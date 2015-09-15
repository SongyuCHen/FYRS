package nju.software.fyrs.service;

import nju.software.fyrs.biz.vo.FyVO;

/**
 * 
 * 获得法院列表信息。
 * 
 */
public interface FyService {
	/**
	 * 获得江苏法院列表信息
	 * 
	 * return FyVO
	 */
	public FyVO getJsfyList();
}
