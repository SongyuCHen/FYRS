package nju.software.fyrs.data.dao;

import java.util.List;

import nju.software.fyrs.data.dataobject.Pub_DmbDO;

public interface Pub_DmbDao {
	/**
	 * 根据类别编号和代码编号获取代码表
	 * @param lbbh 类别编号
	 * @param dmbh 代码编号
	 * @return Pub_DmbDO
	 */
	public Pub_DmbDO getDmByLbbhAndDmbh(String lbbh, String dmbh);
	
	/**
	 * 获取所有在江苏的法院列表
	 * @return List<Pub_DmbDO>
	 */
	public List<Pub_DmbDO> getJsFydmb();
	
	/**
	 * 获取所有部门的列表
	 * @return List<Pub_DmbDO>
	 */
	public List<Pub_DmbDO> getAllBm();
	/**
	 * 根据代码编号获取代码DO
	 * @param fydm 代码编号
	 * @return Pub_DmbDO
	 */
	public Pub_DmbDO getFydmbByFybh(long fydm);
	
	public Pub_DmbDO getDmbByBmbh(String bmbh);
	/**
	 * 根据类型编号来获得
	 * @param lbbh
	 * @return
	 */
	public List<Pub_DmbDO> getDmbByLbbh(String lbbh);
}
