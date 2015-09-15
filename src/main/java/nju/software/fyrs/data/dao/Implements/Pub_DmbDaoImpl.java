package nju.software.fyrs.data.dao.Implements;

import java.util.ArrayList;
import java.util.List;

import nju.software.fyrs.data.dao.Pub_DmbDao;
import nju.software.fyrs.data.dataobject.Pub_DmbDO;

import org.apache.log4j.Logger;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

/**
 * 代码表DAO的实现
 * 
 * @author byron
 * 
 */
public class Pub_DmbDaoImpl extends HibernateDaoSupport implements Pub_DmbDao {
	private static final Logger log = Logger.getLogger(Pub_DmbDaoImpl.class);

	public Pub_DmbDO getDmByLbbhAndDmbh(String lbbh, String dmbh) {
		
		String hql = "from Pub_DmbDO where lbbh=? and dmbh=?";
		@SuppressWarnings("unchecked")
		List<Pub_DmbDO> dmb = getHibernateTemplate().find(hql, lbbh, dmbh);
		if (log.isInfoEnabled()) {
			log.info("getDmByDmbbh by sql: " + hql + " lbbh=" + lbbh + " dmbh"
					+ dmbh);
		}
		return dmb.isEmpty() ? null : dmb.get(0);
	}

	public List<Pub_DmbDO> getJsFydmb() {
		
		String hql = "from Pub_DmbDO where lbbh=? and dmbh like ?";
		@SuppressWarnings("unchecked")
		// 120000 200天津高院
		List<Pub_DmbDO> dmb = getHibernateTemplate().find(hql, "FBZ0001-97",
				"12%");
		if (dmb == null) {
			dmb = new ArrayList<Pub_DmbDO>();
		}
		for (int i = 0; i < dmb.size(); i++) {
			if (dmb.get(i).getDmbh().length() < 10) {
				dmb.remove(i);
				break;
			}
		}
		if (log.isInfoEnabled()) {
			log.info("getDmInJs by sql: " + hql);
		}
		return dmb;
	}

	public List<Pub_DmbDO> getAllBm() {
		
		String hql = "from Pub_DmbDO where lbbh=? and bz=?";
		@SuppressWarnings("unchecked")
		List<Pub_DmbDO> dmb = getHibernateTemplate().find(hql, "USR206-99",
				"审判");
		if (dmb == null) {
			dmb = new ArrayList<Pub_DmbDO>();
		}
		if (log.isInfoEnabled()) {
			log.info("getDmInJs by sql: " + hql);
		}
		return dmb;
	}

	public Pub_DmbDO getFydmbByFybh(long fydm) {
		
		String hql = "from Pub_DmbDO where dmbh=?";
		@SuppressWarnings("unchecked")
		List<Pub_DmbDO> dmb = getHibernateTemplate().find(hql, fydm);
		if (log.isInfoEnabled()) {
			log.info("getDmByDmbbh by sql: " + hql + " dmbh" + fydm);
		}
		return dmb.isEmpty() ? null : dmb.get(0);
	}

	public Pub_DmbDO getDmbByBmbh(String bmbh) {
		String hql = "from Pub_DmbDO where lbbh=? and dmbh like ?";
		@SuppressWarnings("unchecked")
		List<Pub_DmbDO> dmb = getHibernateTemplate().find(hql, "USR206-99",
				bmbh);
		if (dmb == null) {
			dmb = new ArrayList<Pub_DmbDO>();
		}
		return dmb.isEmpty() ? null : dmb.get(0);
	}

	public List<Pub_DmbDO> getDmbByLbbh(String lbbh) {
		String hql = "from Pub_DmbDO where lbbh=?";
		@SuppressWarnings("unchecked")
		List<Pub_DmbDO> dmb = getHibernateTemplate().find(hql, lbbh);
		return dmb;
	}

}