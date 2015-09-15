package nju.software.fyrs.biz.vo;

import java.util.ArrayList;
import java.util.List;

public class FyTreeDataObject {
	private int fydm;
	private String fymc;
	private List<FyTreeDataObject>  children = new ArrayList<FyTreeDataObject>();
	
	public int getFydm() {
		return fydm;
	}

	public void setFydm(int fydm) {
		this.fydm = fydm;
	}
	
	public List<FyTreeDataObject> getChildren() {
		return children;
	}

	public void setChildren(List<FyTreeDataObject> children) {
		this.children = children;
	}

	public String getFymc() {
		return fymc;
	}

	public void setFymc(String fymc) {
		this.fymc = fymc;
	}
	
}
