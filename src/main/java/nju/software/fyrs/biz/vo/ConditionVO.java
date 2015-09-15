package nju.software.fyrs.biz.vo;

import java.util.List;

public class ConditionVO {
	/**
	 * ��ѯ������
	 */
	private String name;
	/**
	 * �Ƿ���ʱ������
	 */
	private boolean isDatetime;
	/**
	 * �Ƿ��д�����Ӧ�Ĵ���
	 */
	private boolean hasMaincode;
	/**
	 * ����������ѡ��
	 */
	private List<OptionVO> options;
	
	/**
	 * ��Ա��Ϣ����������Ӧ���ֶ���
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
