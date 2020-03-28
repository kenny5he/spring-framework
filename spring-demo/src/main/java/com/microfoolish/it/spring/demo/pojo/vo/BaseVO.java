package com.microfoolish.it.spring.demo.pojo.vo;

import java.io.Serializable;
import java.util.Date;

public class BaseVO implements Serializable {

	private static final long serialVersionUID = -2935135628389490231L;

	private Date creationDate;

	private Long createBy;

	private Date updateDate;

	private Long updateBy;

	private String dataVersion;

}
