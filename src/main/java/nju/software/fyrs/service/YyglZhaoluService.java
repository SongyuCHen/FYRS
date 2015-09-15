package nju.software.fyrs.service;

import java.util.List;

import nju.software.fyrs.biz.vo.YyglZhaoluVO;

public interface YyglZhaoluService {
	public List<YyglZhaoluVO> getZhaoluByFy(String fydm);
	
	public YyglZhaoluVO getZhaoluById(String id, String fydm);

	public YyglZhaoluVO addZhaolu(YyglZhaoluVO vo);
	
	public YyglZhaoluVO updateZhaolu(YyglZhaoluVO vo);
	
	public boolean delZhaoluById(String id, String fydm);
}
