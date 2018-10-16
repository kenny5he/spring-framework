/*
 * Copyright 2002-2018 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.springframework.transaction.interceptor;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.lang.Nullable;
import org.springframework.util.ClassUtils;
import org.springframework.util.ObjectUtils;
import org.springframework.util.PatternMatchUtils;

import java.io.Serializable;
import java.lang.reflect.Method;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

/**
 * Simple {@link TransactionAttributeSource} implementation that
 * allows attributes to be matched by registered name.
 *
 * @author Juergen Hoeller
 * @since 21.08.2003
 * @see #isMatch
 * @see MethodMapTransactionAttributeSource
 */
@SuppressWarnings("serial")
public class NameMatchTransactionAttributeSource implements TransactionAttributeSource, Serializable {

	/**
	 * Logger available to subclasses.
	 * <p>Static for optimal serialization.
	 */
	protected static final Log logger = LogFactory.getLog(NameMatchTransactionAttributeSource.class);

	/**
     * Keys are method names; values are TransactionAttributes.
     *
     * 方法名与事务属性的映射
     *
     * KEY：方法名
     * VALUE ：事务属性
     */
	private Map<String, TransactionAttribute> nameMap = new HashMap<>();


	/**
     * 设置到 {@link #nameMap}
     *
     * 附加的方式
     *
	 * Set a name/attribute map, consisting of method names
	 * (e.g. "myMethod") and TransactionAttribute instances
	 * (or Strings to be converted to TransactionAttribute instances).
	 * @see TransactionAttribute
	 * @see TransactionAttributeEditor
	 */
	public void setNameMap(Map<String, TransactionAttribute> nameMap) {
		nameMap.forEach(this::addTransactionalMethod);
	}

	/**
     * 从 Properties 中，读取事务相关配置，添加到 {@link #nameMap} 中
     *
     * TODO 芋艿，后续在详细调试
     *
	 * Parses the given properties into a name/attribute map.
	 * Expects method names as keys and String attributes definitions as values,
	 * parsable into TransactionAttribute instances via TransactionAttributeEditor.
	 * @see #setNameMap
	 * @see TransactionAttributeEditor
	 */
	public void setProperties(Properties transactionAttributes) {
		TransactionAttributeEditor tae = new TransactionAttributeEditor();
		Enumeration<?> propNames = transactionAttributes.propertyNames();
		while (propNames.hasMoreElements()) {
			String methodName = (String) propNames.nextElement();
			String value = transactionAttributes.getProperty(methodName);
			tae.setAsText(value);
			TransactionAttribute attr = (TransactionAttribute) tae.getValue();
			addTransactionalMethod(methodName, attr);
		}
	}

	/**
     * 添加一个方法的事务属性
     *
	 * Add an attribute for a transactional method.
	 * <p>Method names can be exact matches, or of the pattern "xxx*",
	 * "*xxx" or "*xxx*" for matching multiple methods.
	 * @param methodName the name of the method 方法
	 * @param attr attribute associated with the method 事务属性
	 */
	public void addTransactionalMethod(String methodName, TransactionAttribute attr) {
		if (logger.isDebugEnabled()) {
			logger.debug("Adding transactional method [" + methodName + "] with attribute [" + attr + "]");
		}
		this.nameMap.put(methodName, attr);
	}


	@SuppressWarnings("Duplicates")
    @Override
	@Nullable
	public TransactionAttribute getTransactionAttribute(Method method, @Nullable Class<?> targetClass) {
		// 非用户定义的方法，忽略
	    if (!ClassUtils.isUserLevelMethod(method)) {
			return null;
		}

		// Look for direct name match.
        // 直接使用方法名，作为全匹配
		String methodName = method.getName();
		TransactionAttribute attr = this.nameMap.get(methodName);
		// 匹配不上，模糊匹配
		if (attr == null) {
			// Look for most specific name match.
			String bestNameMatch = null; // 最佳匹配
			for (String mappedName : this.nameMap.keySet()) {
				if (isMatch(methodName, mappedName) && // 模式匹配
						(bestNameMatch == null || bestNameMatch.length() <= mappedName.length())) { // 最有匹配的条件：最有匹配不存在，或者更长
					attr = this.nameMap.get(mappedName);
					bestNameMatch = mappedName;
				}
			}
		}

		return attr;
	}

	/**
     * 模式匹配
     *
	 * Return if the given method name matches the mapped name.
	 * <p>The default implementation checks for "xxx*", "*xxx" and "*xxx*" matches,
	 * as well as direct equality. Can be overridden in subclasses.
	 * @param methodName the method name of the class
	 * @param mappedName the name in the descriptor
	 * @return if the names match
	 * @see org.springframework.util.PatternMatchUtils#simpleMatch(String, String)
	 */
	protected boolean isMatch(String methodName, String mappedName) {
		return PatternMatchUtils.simpleMatch(mappedName, methodName);
	}


	@Override
	public boolean equals(@Nullable Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof NameMatchTransactionAttributeSource)) {
			return false;
		}
		NameMatchTransactionAttributeSource otherTas = (NameMatchTransactionAttributeSource) other;
		return ObjectUtils.nullSafeEquals(this.nameMap, otherTas.nameMap);
	}

	@Override
	public int hashCode() {
		return NameMatchTransactionAttributeSource.class.hashCode();
	}

	@Override
	public String toString() {
		return getClass().getName() + ": " + this.nameMap;
	}

}
