package nju.software.fyrs.service;

import java.util.List;

import nju.software.fyrs.biz.vo.JlxxVO;

public interface FzbJlxxService {
	// ºÚ¿˙–≈œ¢
	public List<JlxxVO> getJlxxByRybhFy(int rybh, int fydm);

	public JlxxVO getRsJlxxById(String id, String fydm, String rybh);

	public boolean delRsJlxxById(String id, String fydm, String rybh);

	public JlxxVO addJlxx(JlxxVO vo);

	public JlxxVO updateRsJlxx(JlxxVO vo);
}
