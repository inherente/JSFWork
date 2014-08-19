package com.obelit.reloaded.util;

import javax.faces.bean.ManagedBean;

@ManagedBean(name = "localResource")
public class ConstantResource {
	final static String TITLE ="Message from the Bottle";
	final static String XML_HEADER ="<?xml version=\"1.0\" encoding=\"UTF-8\"?>";
	private String principalTitle;
	private String xmlHeader;
	public ConstantResource() {
		setPrincipalTitle(TITLE);
		setXmlHeader(XML_HEADER);
	}
	public String getPrincipalTitle() {
		return principalTitle;
	}
	public void setPrincipalTitle(String title) {
		this.principalTitle = title;
	}
	public String getXmlHeader() {
		return xmlHeader;
	}
	public void setXmlHeader(String xmlHeader) {
		this.xmlHeader = xmlHeader;
	}

}
