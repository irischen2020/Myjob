package com.pojo;

import java.util.List;
/*
 * Page对象
 */
public class Page {
	private String keyword;
	private List<UIElement> EIElement;
	public String getKeyword() {
		return keyword;
	}
	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}
	public List<UIElement> getEIElement() {
		return EIElement;
	}
	public void setEIElement(List<UIElement> eIElement) {
		EIElement = eIElement;
	}
	
}
