package nju.software.fyrs.service;

import java.util.List;

import nju.software.fyrs.biz.vo.BzbhVO;

public interface BzglService {
	/**
	 * 根据法院代码，编制级别，编制性质得到编制变化情况
	 * @param fydm
	 * @param jb
	 * @param bzxz
	 * @return
	 */
	public List<BzbhVO> getBzbhList(int fydm, int jb, int bzxz);
}
