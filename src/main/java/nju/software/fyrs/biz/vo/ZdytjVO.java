package nju.software.fyrs.biz.vo;

import java.util.List;

public class ZdytjVO {

	private List<String> tableHead;
	
	private List<ZdytjItem> items;

	public List<String> getTableHead() {
		return tableHead;
	}

	public void setTableHead(List<String> tableHead) {
		this.tableHead = tableHead;
	}

	public List<ZdytjItem> getItems() {
		return items;
	}

	public void setItems(List<ZdytjItem> items) {
		this.items = items;
	}
}
