package nju.software.fyrs.service;

import java.util.List;
import nju.software.fyrs.biz.vo.LdjcVO;

/**
 * 获取领导决策需要的统计数据
 * @author wwj
 *
 */
public interface LdjcService {
	/**
	 * 获取法律职务分布数据
	 * @param fydm
	 * @return
	 */
	public List<LdjcVO> getFlzwFb(int fydm);
	
	/**
	 * 获取法官等级分布数据
	 * @param fydm
	 * @return
	 */
	public List<LdjcVO> getFgdjFb(int fydm);
	
	/**
	 * 获取行政职务分布数据
	 * @param fydm
	 * @return
	 */
	public List<LdjcVO> getXzzwFb(int fydm);
	
	/**
	 * 获取部门人员分布数据
	 * @param fydm
	 * @return
	 */
	public List<LdjcVO> getBmFb(int fydm);
}
