package nju.software.fyrs.data.dao;

import java.util.List;

import nju.software.fyrs.data.dataobject.Pub_DmbDO;

public interface Pub_DmbDao {
	/**
	 * ��������źʹ����Ż�ȡ�����
	 * @param lbbh �����
	 * @param dmbh ������
	 * @return Pub_DmbDO
	 */
	public Pub_DmbDO getDmByLbbhAndDmbh(String lbbh, String dmbh);
	
	/**
	 * ��ȡ�����ڽ��յķ�Ժ�б�
	 * @return List<Pub_DmbDO>
	 */
	public List<Pub_DmbDO> getJsFydmb();
	
	/**
	 * ��ȡ���в��ŵ��б�
	 * @return List<Pub_DmbDO>
	 */
	public List<Pub_DmbDO> getAllBm();
	/**
	 * ���ݴ����Ż�ȡ����DO
	 * @param fydm ������
	 * @return Pub_DmbDO
	 */
	public Pub_DmbDO getFydmbByFybh(long fydm);
	
	public Pub_DmbDO getDmbByBmbh(String bmbh);
	/**
	 * �������ͱ�������
	 * @param lbbh
	 * @return
	 */
	public List<Pub_DmbDO> getDmbByLbbh(String lbbh);
}
