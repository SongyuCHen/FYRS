package nju.software.fyrs.service;

import java.util.List;

import nju.software.fyrs.biz.vo.BzbhVO;

public interface BzglService {
	/**
	 * ���ݷ�Ժ���룬���Ƽ��𣬱������ʵõ����Ʊ仯���
	 * @param fydm
	 * @param jb
	 * @param bzxz
	 * @return
	 */
	public List<BzbhVO> getBzbhList(int fydm, int jb, int bzxz);
}
