package nju.software.fyrs.service;

import java.util.ArrayList;
import java.util.List;

import nju.software.fyrs.biz.vo.BmPzVO;
import nju.software.fyrs.biz.vo.BzPzVO;
import nju.software.fyrs.biz.vo.FgBmFbVO;
import nju.software.fyrs.biz.vo.FgFlzwFbVO;
import nju.software.fyrs.biz.vo.ZjFbVO;
import nju.software.fyrs.biz.vo.FgzlFbVO;
import nju.software.fyrs.biz.vo.FyPzVO;
import nju.software.fyrs.biz.vo.GdtjTjVO;
import nju.software.fyrs.biz.vo.GdtjVO;
import nju.software.fyrs.biz.vo.GrJlVO;
import nju.software.fyrs.biz.vo.HmcVO;
import nju.software.fyrs.biz.vo.JtJlVO;
import nju.software.fyrs.biz.vo.NlAndXlFbVO;
import nju.software.fyrs.biz.vo.SjyFbVO;
import nju.software.fyrs.biz.vo.TzZjVO;

/**
 * ��ȡ�̶�ͳ����ص�ͳ������
 * @author wwj
 *
 */
public interface GdtjService {
	/**
	 * ��ȡ�̶�ͳ���б�
	 * @return
	 */
	public List<GdtjVO>getGdtjList();
	/**
	 * ��ȡĳ�ű��ͳ������
	 * @param bbh
	 * @return
	 */
	public List<ArrayList<GdtjTjVO>> getGdtjTjList(int bbh);
	/**
	 * ��ȡ�̶�ͳ�ƽ��
	 * @param bbh
	 * @param hang
	 * @param lie
	 * @param fydm
	 * @return
	 */
	public String[][] getTjResult(String bbh, String hang, String lie, int fydm);
	/**
	 * ���ݱ��Ż�ȡ����
	 * @param bbh
	 * @return
	 */
	public GdtjVO getGdtjByBbh(String bbh);
	/**
	 * ��Ժ�ɾ���ñ��ý�����������˽�����
	 * @param fydm
	 * @return
	 */
	public List<GrJlVO> getGrJl(int fydm);
	/**
	 * �������м�����Ժ���ý������ݣ����壩
	 * @param fydm
	 * @return
	 */
	public List<JtJlVO> getJtJl(int fydm);
	/**
	 * ��÷�Ժ��Ա����
	 * @param fydm
	 * @return
	 */
	public FyPzVO getFyPz(int fydm);
	/**
	 * ��÷�Ժ������Ա����
	 * @param fydm
	 * @return
	 */
	public List<BmPzVO> getFyBmPz(int fydm);
	/**
	 * ��÷�Ժ������
	 * @param fydm
	 * @return
	 */
	public List<HmcVO> getHmcRyzb(int fydm);
	/**
	 * ��÷�Ժĳ���Ż�����
	 * @param fydm
	 * @param bm
	 * @return
	 */
	public List<HmcVO> getHmcByBm(int fydm, int bm);
	/**
	 * ���ݷ�Ժ��������ȡ������
	 * @param fydm
	 * @param bm
	 * @return
	 */
	public List<HmcVO> getHmcByBmName(int fydm, String bm);
	/**
	 * ��÷�Ժĳ����ְ������
	 * @param fydm
	 * @param xzzw
	 * @return
	 */
	public List<HmcVO> getHmcByXzzw(int fydm, int xzzw);
	/**
	 * ��÷�Ժ����
	 * @param fydm
	 * @return
	 */
	public Long countByFy(int fydm);
	/**
	 * ��÷�Ժְ���������
	 * @param fydm
	 * @param zwlb
	 * @return
	 */
	public List<HmcVO> getZcgbHmc(int fydm, int zwlb);
	/**
	 * ����ְ�����������ػ�����,��������ķǳ���
	 * @param fydm
	 * @param zjCondition
	 * @return
	 */
	public List<HmcVO> getHmcByZjCondition(int fydm, String zjCondition);
	/**
	 * ����ְ�����ػ�����
	 * @param fydm
	 * @param zj
	 * @return
	 */
	public List<HmcVO> getHmcByZj(int fydm, int zj);
	/**
	 * ���ݷ���ְ�񷵻ػ�����
	 * @param fydm
	 * @param flzw
	 * @return
	 */
	public List<HmcVO> getHmcByFlzw(int fydm, int flzw);
	/**
	 * ����ְ�����ؾ�ת�ɲ�������
	 * @param fydm
	 * @param zj
	 * @return
	 */
	public List<HmcVO> getJzgbHmcByZj(int fydm, int zj);
	/**
	 * �����Ա𷵻ػ�����
	 * @param fydm
	 * @param xb
	 * @return
	 */
	public List<HmcVO> getHmcByXb(int fydm, int xb);
	/**
	 * ��÷ǵ�Ա������
	 * @param fydm
	 * @return
	 */
	public List<HmcVO> getFdyHmc(int fydm);
	/**
	 * ���ݷ�Ժ��ú˶�������Ϣ
	 * @param fydm
	 * @return
	 */
	public List<BzPzVO> getHdbzPzByFy(int...fydms);
	/**
	 * ���ݷ�Ժ���ʵ�б�����Ϣ
	 * @param fydms
	 * @return
	 */
	public List<BzPzVO> getSybzPzByFy(int...fydms);
	/**
	 * ���ݷ�Ժ��÷��ٲ��ŷֲ�
	 * @param fydms
	 * @return
	 */
	public List<FgBmFbVO> getFgbmfbByFy(int...fydms);
	/**
	 * ���ݷ�Ժ��÷��ٷ���ְ��ֲ�
	 * @param fydms
	 * @return
	 */
	public List<FgFlzwFbVO> getFgflzwfbByFy(int...fydms);
	/**
	 * ���ݷ�Ժ����ڱ����Ա���ŷֲ�
	 * @param fydms
	 * @return
	 */
	public List<SjyFbVO> getZbsjyfbByFy(int...fydms);
	/**
	 * ���ݷ�Ժ��ñ������Ա���ŷֲ�
	 * @param fydms
	 * @return
	 */
	public List<SjyFbVO> getBwsjyfbByFy(int...fydms);
	/**
	 * ���ݷ�Ժ����ڱ෨�������ŷֲ�
	 * @param fydms
	 * @return
	 */
	public List<FgzlFbVO> getZbfgzlfbByFy(int...fydms);
	/**
	 * ���ݷ�Ժ��ñ��ⷨ�������ŷֲ�
	 * @param fydms
	 * @return
	 */
	public List<FgzlFbVO> getBwfgzlfbByFy(int...fydms);
	/**
	 * ���ݷ�Ժ��÷���ְ���ֲ�
	 * @param fydms
	 * @return
	 */
	public List<ZjFbVO> getFgzjfbByFy(int...fydms);
	/**
	 * ���ݷ�Ժ��÷��쵼����ְ���ֲ�
	 * @param fydms
	 * @return
	 */
	public List<ZjFbVO> getFldfgzjfbByFy(int...fydms);
	/**
	 * ���ݷ�Ժ���ͥ��ְ���ֲ�
	 * @param fydms
	 * @return
	 */
	public List<TzZjVO> getTzzjfbByFy(int...fydms);
	/**
	 * ���ݷ�Ժ��÷��������ѧ���ֲ�
	 * @param fydms
	 * @return
	 */
	public List<NlAndXlFbVO> getFgNlAndXlFbByFy(int...fydms);
	/**
	 * ���ݷ�Ժ����쵼����ְ���ֲ�
	 * @param fydms
	 * @return
	 */
	public List<ZjFbVO> getLdbzZjFbByFy(int...fydms);
	/**
	 * ���ݷ�Ժ����쵼���������ѧ���ֲ�
	 * @param fydms
	 * @return
	 */
	public List<NlAndXlFbVO> getLdbzNlAndXlFbByFy(int...fydms);
}
