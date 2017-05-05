package com.baomidou.config;

import org.apache.maven.plugins.annotations.Parameter;

/**
 * 
 * @ClassName: TemplateConfig
 * @Description: 模板路径配置项
 * @author tzg
 * @date 2016年11月10日 下午4:45:12
 *
 */
public class TemplateConfig {
	
	@Parameter(defaultValue = ConstVal.TEMPLATE_ENTITY)
	private String entity;
	
	@Parameter(defaultValue = ConstVal.TEMPLATE_SERVICE)
	private String service;
	
	@Parameter(defaultValue = ConstVal.TEMPLATE_SERVICEIMPL)
	private String serviceImpl;
	
	@Parameter(defaultValue = ConstVal.TEMPLATE_MAPPER)
	private String mapper;
	
	@Parameter(defaultValue = ConstVal.TEMPLATE_XML)
	private String xml;
	
	@Parameter(defaultValue = ConstVal.TEMPLATE_CONTROLLER)
	private String controller;
	

	public String getEntity() {
		if(entity == null) return ConstVal.TEMPLATE_ENTITY;
		return entity;
	}

	public String getService() {
		if(service == null) return ConstVal.TEMPLATE_SERVICE;
		return service;
	}

	public String getServiceImpl() {
		if(serviceImpl == null) return ConstVal.TEMPLATE_SERVICEIMPL;
		return serviceImpl;
	}

	public String getMapper() {
		if(mapper == null) return ConstVal.TEMPLATE_MAPPER;
		return mapper;
	}

	public String getXml() {
		if(xml == null) return ConstVal.TEMPLATE_XML;
		return xml;
	}

	public String getController() {
		if(controller == null) return ConstVal.TEMPLATE_CONTROLLER;
		return controller;
	}

	
}
