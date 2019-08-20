package com.sts.vo;

import java.util.ArrayList;
import java.util.List;

public class MavVO {
	private String id=null;
	private String lang=null;
	private List<String> lang1 = new ArrayList<String>();
	
	public List<String> getLang1() {
		return lang1;
	}
	public void setLang1(List<String> lang1) {
		this.lang1 = lang1;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getLang() {
		return lang;
	}
	public void setLang(String lang) {
		this.lang = lang;
	}
	@Override
	public String toString() {
		return "MavVO [id=" + id + ", lang1=" + lang1 + "]";
	}

}
