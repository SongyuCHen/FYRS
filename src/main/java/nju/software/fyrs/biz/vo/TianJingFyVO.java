package nju.software.fyrs.biz.vo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import nju.software.fyrs.service.JgxxService;

public class TianJingFyVO {
	public static JgxxService jgxxService;
	private String data;
	@SuppressWarnings("rawtypes")
	private Map attr = new HashMap();
	private List<TianJingFyVO> children = null;

	@SuppressWarnings("unchecked")
	public TianJingFyVO(FyTreeDataObject fdo) {
		this.data = fdo.getFymc();
		this.attr.put("id", fdo.getFydm());
		List<FyTreeDataObject> fdos = fdo.getChildren();
		if (fdos != null && fdos.size() > 0) {
			this.children = new ArrayList<TianJingFyVO>();
			for (FyTreeDataObject f : fdos) {
				this.children.add(new TianJingFyVO(f));
			}
		}
	}

	@SuppressWarnings("unchecked")
	public TianJingFyVO(FyTreeDataObject fdo, boolean addBm) {
		this.data = fdo.getFymc();
		this.attr.put("id", fdo.getFydm());
		List<FyTreeDataObject> fdos = fdo.getChildren();
		if (fdos != null && fdos.size() > 0) {
			this.children = new ArrayList<TianJingFyVO>();
			// 把自己也当作一个子节点,这时它不能再递归
			fdo.setChildren(null);
			this.children.add(new TianJingFyVO(fdo, true));
			for (FyTreeDataObject f : fdos) {
				this.children.add(new TianJingFyVO(f, true));
			}
		} else {
			this.children = new ArrayList<TianJingFyVO>();
			BmTreeDataObject root = jgxxService.bmByFyIdTree(fdo.getFydm());
			for (BmTreeDataObject bm : root.getChildren()) {
				bm.setFydm(fdo.getFydm());
				this.children.add(new TianJingFyVO(bm));
			}

		}

	}

	@SuppressWarnings("unchecked")
	public TianJingFyVO(BmTreeDataObject bm) {
		this.data = bm.getName();
		this.attr.put("id", bm.getCode());
		this.attr.put("level", bm.getLvlCode());
		this.attr.put("fydm", bm.getFydm());
		List<BmTreeDataObject> fdos = bm.getChildren();
		if (fdos != null && fdos.size() > 0) {
			this.children = new ArrayList<TianJingFyVO>();
			for (BmTreeDataObject f : fdos) {
				f.setFydm(bm.getFydm());
				this.children.add(new TianJingFyVO(f));
			}
		}
	}

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

	@SuppressWarnings("rawtypes")
	public Map getAttr() {
		return attr;
	}

	@SuppressWarnings("rawtypes")
	public void setAttr(Map attr) {
		this.attr = attr;
	}

	public List<TianJingFyVO> getChildren() {
		return children;
	}

	public void setChildren(List<TianJingFyVO> children) {
		this.children = children;
	}
}
