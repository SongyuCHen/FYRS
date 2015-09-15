package nju.software.fyrs.biz.vo;

import java.util.ArrayList;
import java.util.List;

public class SdcxQueryVO {

	private String excuteSql;
	private String tableName;
	private String parentId;
	private String topId;
	private String id;
	private String andOr;
	private List<SdcxQueryVO> childrenOr = new ArrayList<SdcxQueryVO>();
	private List<SdcxQueryVO> childrenAnd = new ArrayList<SdcxQueryVO>();

	public String getExcuteSql()
	{
		return excuteSql;
	}

	public void setExcuteSql(String excuteSql)
	{
		this.excuteSql = excuteSql;
	}

	public String getTableName()
	{
		return tableName;
	}

	public void setTableName(String tableName)
	{
		this.tableName = tableName;
	}

	public String getParentId()
	{
		return parentId;
	}

	public void setParentId(String parentId)
	{
		this.parentId = parentId;
	}

	public String getTopId()
	{
		return topId;
	}

	public void setTopId(String topId)
	{
		this.topId = topId;
	}

	public String getId()
	{
		return id;
	}

	public void setId(String id)
	{
		this.id = id;
	}

	public String getAndOr()
	{
		return andOr;
	}

	public void setAndOr(String andOr)
	{
		this.andOr = andOr;
	}

	public List<SdcxQueryVO> getChildrenOr()
	{
		return childrenOr;
	}

	public void setChildrenOr(List<SdcxQueryVO> childrenOr)
	{
		this.childrenOr = childrenOr;
	}

	public List<SdcxQueryVO> getChildrenAnd()
	{
		return childrenAnd;
	}

	public void setChildrenAnd(List<SdcxQueryVO> childrenAnd)
	{
		this.childrenAnd = childrenAnd;
	}
	

}
