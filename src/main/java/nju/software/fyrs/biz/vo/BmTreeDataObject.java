package nju.software.fyrs.biz.vo;

import java.util.ArrayList;
import java.util.List;

public class BmTreeDataObject {
	private int code;
	private int fydm;
	private String name ;
	private String lvlCode;
	
	private List<BmTreeDataObject>  children = new ArrayList<BmTreeDataObject>();
	
	public List<BmTreeDataObject> getChildren() {
		return children;
	}

	public void setChildren(List<BmTreeDataObject> children) {
		this.children = children;
	}

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLvlCode() {
		return lvlCode;
	}

	public void setLvlCode(String lvlCode) {
		this.lvlCode = lvlCode;
	}

	public int getFydm() {
		return fydm;
	}

	public void setFydm(int fydm) {
		this.fydm = fydm;
	}
	
	
}
