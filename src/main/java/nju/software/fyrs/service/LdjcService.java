package nju.software.fyrs.service;

import java.util.List;
import nju.software.fyrs.biz.vo.LdjcVO;

/**
 * ��ȡ�쵼������Ҫ��ͳ������
 * @author wwj
 *
 */
public interface LdjcService {
	/**
	 * ��ȡ����ְ��ֲ�����
	 * @param fydm
	 * @return
	 */
	public List<LdjcVO> getFlzwFb(int fydm);
	
	/**
	 * ��ȡ���ٵȼ��ֲ�����
	 * @param fydm
	 * @return
	 */
	public List<LdjcVO> getFgdjFb(int fydm);
	
	/**
	 * ��ȡ����ְ��ֲ�����
	 * @param fydm
	 * @return
	 */
	public List<LdjcVO> getXzzwFb(int fydm);
	
	/**
	 * ��ȡ������Ա�ֲ�����
	 * @param fydm
	 * @return
	 */
	public List<LdjcVO> getBmFb(int fydm);
}
