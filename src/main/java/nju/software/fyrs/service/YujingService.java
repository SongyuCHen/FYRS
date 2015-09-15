package nju.software.fyrs.service;

import java.util.List;

import nju.software.fyrs.biz.vo.YujingVO;

public interface YujingService {
	public List<YujingVO> getYujingByFy(String fydm);
	
	public YujingVO getYujingById(String id, String fydm, String rybh);

	public YujingVO addYujing(YujingVO vo);
	
	public YujingVO updateYujing(YujingVO vo);
	
	public boolean delYujingById(String id, String fydm, String rybh);
}
