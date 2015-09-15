package nju.software.fyrs.biz.vo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SdcxShowResultVO {
	private List<String> jbxxInfo = new ArrayList<String>();
	private Map<String,List<List<String>>> otherTableInfo = new HashMap<String,List<List<String>>>();
	public List<String> getJbxxInfo()
	{
		return jbxxInfo;
	}
	public void setJbxxInfo(List<String> jbxxInfo)
	{
		this.jbxxInfo = jbxxInfo;
	}
	public Map<String, List<List<String>>> getOtherTableInfo()
	{
		return otherTableInfo;
	}
	public void setOtherTableInfo(Map<String, List<List<String>>> otherTableInfo)
	{
		this.otherTableInfo = otherTableInfo;
	}
	
}
