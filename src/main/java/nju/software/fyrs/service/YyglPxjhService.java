package nju.software.fyrs.service;

import java.util.List;

import nju.software.fyrs.biz.vo.YyglPxjhVO;

public interface YyglPxjhService {
	public List<YyglPxjhVO> getPxjhByFy(String fydm);
	
	public YyglPxjhVO getPxjhById(String id, String fydm);

	public YyglPxjhVO addPxjh(YyglPxjhVO vo);
	
	public YyglPxjhVO updatePxjh(YyglPxjhVO vo);
	
	public boolean delPxjhById(String id, String fydm);
}
