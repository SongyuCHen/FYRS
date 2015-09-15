package nju.software.fyrs.biz.vo;

import java.util.List;

public class ConditionVO {
	/**
	 * 查询条件名
	 */
	private String name;
	/**
	 * 是否是时间类型
	 */
	private boolean isDatetime;
	/**
	 * 是否有代码表对应的代码
	 */
	private boolean hasMaincode;
	/**
	 * 条件包含的选项
	 */
	private List<OptionVO> options;
	
	/**
	 * 人员信息表中条件对应的字段名
	 */
	private String nameInDb;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getNameInDb() {
		return nameInDb;
	}

	public void setNameInDb(String nameInDb) {
		this.nameInDb = nameInDb;
	}

	public List<OptionVO> getOptions() {
		return options;
	}

	public void setOptions(List<OptionVO> options) {
		this.options = options;
	}

	public boolean isDatetime() {
		return isDatetime;
	}

	public void setDatetime(boolean isDatetime) {
		this.isDatetime = isDatetime;
	}

	public boolean isHasMaincode() {
		return hasMaincode;
	}

	public void setHasMaincode(boolean hasMaincode) {
		this.hasMaincode = hasMaincode;
	}
}
