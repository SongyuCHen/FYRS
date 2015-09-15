package nju.software.fyrs.biz.vo;

import java.util.ArrayList;
import java.util.List;

public class RyjbxxRylhTimeShowVo {
	private String name;
	private List<String> eventMonth = new ArrayList<String>();
	public String getName()
	{
		return name;
	}
	public void setName(String name)
	{
		this.name = name;
	}
	public List<String> getEventMonth()
	{
		return eventMonth;
	}
	public void setEventMonth(List<String> eventMonth)
	{
		this.eventMonth = eventMonth;
	}
  
	
}
