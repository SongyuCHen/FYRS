package nju.software.fyrs.biz.vo;

import java.util.Comparator;

import nju.software.fyrs.util.DateUtil;

public class RyjbxxRylhTimeVoComparator implements Comparator<RyjbxxRylhTimeVo> {
    /**
     * ·µ»Ø½µÐò
     */
	@Override
	public int compare(RyjbxxRylhTimeVo o1, RyjbxxRylhTimeVo o2)
	{
        String str_1 = DateUtil.format(o1.getEventTime(),DateUtil.webFormat);
        String str_2 = DateUtil.format(o2.getEventTime(),DateUtil.webFormat);
		return str_2.compareTo(str_1);
	}
  
}
