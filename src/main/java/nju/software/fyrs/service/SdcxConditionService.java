package nju.software.fyrs.service;

import java.util.List;

import nju.software.fyrs.biz.vo.SdcxConditionVO;

public interface SdcxConditionService {
	public List<SdcxConditionVO> listAll(int fydm,int rybh);
	public SdcxConditionVO  findByIdFydmRybh(String id,String fydm,String rybh);
	public void delete(String id,String fydm,String rybh);
	public void deleteAll( String fydm, String rybh);
	public void add(SdcxConditionVO vo);
}
