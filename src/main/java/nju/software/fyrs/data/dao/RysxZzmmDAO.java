package nju.software.fyrs.data.dao;

import java.math.BigDecimal;
import java.util.List;

import nju.software.fyrs.data.dataobject.RysxZzmm;

import org.hibernate.LockMode;
import org.hibernate.Session;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

/**
 * A data access object (DAO) providing persistence and search support for
 * RysxZzmm entities. Transaction control of the save(), update() and delete()
 * operations can directly support Spring container-managed transactions or they
 * can be augmented to handle user-managed Spring transactions. Each of these
 * methods provides additional information for how to configure it for the
 * desired type of transaction control.
 * 
 * @see nju.software.fyrs.data.dataobject.RysxZzmm
 * @author MyEclipse Persistence Tools
 */
public class RysxZzmmDAO extends HibernateDaoSupport {
	private static final Logger log = LoggerFactory
			.getLogger(RysxZzmmDAO.class);
	// property constants
	public static final String _NZZMM = "NZzmm";
	public static final String _NDQXX = "NDqxx";
	public static final String _NXSSX = "NXssx";

	protected void initDao() {
		// do nothing
	}

	public void save(RysxZzmm transientInstance) {
		log.debug("saving RysxZzmm instance");
		try {
			getHibernateTemplate().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(RysxZzmm persistentInstance) {
		log.debug("deleting RysxZzmm instance");
		try {
			getHibernateTemplate().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public RysxZzmm findById(nju.software.fyrs.data.dataobject.RysxZzmmId id) {
		log.debug("getting RysxZzmm instance with id: " + id);
		try {
			RysxZzmm instance = (RysxZzmm) getHibernateTemplate().get(
					"software.fyrs.data.RysxZzmm", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	@SuppressWarnings("unchecked")
	public List<RysxZzmm> findByExample(RysxZzmm instance) {
		log.debug("finding RysxZzmm instance by example");
		try {
			List<RysxZzmm> results = (List<RysxZzmm>) getHibernateTemplate()
					.findByExample(instance);
			log.debug("find by example successful, result size: "
					+ results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}

	@SuppressWarnings("rawtypes")
	public List findByProperty(String propertyName, Object value) {
		log.debug("finding RysxZzmm instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from RysxZzmm as model where model."
					+ propertyName + "= ?";
			return getHibernateTemplate().find(queryString, value);
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	@SuppressWarnings("unchecked")
	public List<RysxZzmm> findByNZzmm(Object NZzmm) {
		return findByProperty(_NZZMM, NZzmm);
	}

	@SuppressWarnings("unchecked")
	public List<RysxZzmm> findByNDqxx(Object NDqxx) {
		return findByProperty(_NDQXX, NDqxx);
	}

	@SuppressWarnings("unchecked")
	public List<RysxZzmm> findByNXssx(Object NXssx) {
		return findByProperty(_NXSSX, NXssx);
	}

	@SuppressWarnings("rawtypes")
	public List findAll() {
		log.debug("finding all RysxZzmm instances");
		try {
			String queryString = "from RysxZzmm";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public RysxZzmm merge(RysxZzmm detachedInstance) {
		log.debug("merging RysxZzmm instance");
		try {
			RysxZzmm result = (RysxZzmm) getHibernateTemplate().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(RysxZzmm instance) {
		log.debug("attaching dirty RysxZzmm instance");
		try {
			getHibernateTemplate().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(RysxZzmm instance) {
		log.debug("attaching clean RysxZzmm instance");
		try {
			getHibernateTemplate().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public static RysxZzmmDAO getFromApplicationContext(ApplicationContext ctx) {
		return (RysxZzmmDAO) ctx.getBean("RysxZzmmDAO");
	}

	public List<RysxZzmm> getZzmmListByRybh(String rybh) {
		String hql = "from RysxZzmm where NRybh=" + Integer.parseInt(rybh) + "";
		@SuppressWarnings("unchecked")
		List<RysxZzmm> listZzmm = getHibernateTemplate().find(hql);

		return listZzmm;
	}

	public RysxZzmm getRsZzmmById(String id, String fydm, String rybh) {
		String hql = "from RysxZzmm where NId=? and NFy = ? and NRybh=? ";
		BigDecimal bigDecimal = new BigDecimal(id);
		return (RysxZzmm) getSession().createQuery(hql)
				.setParameter(0, bigDecimal)
				.setParameter(1, Integer.valueOf(fydm))
				.setParameter(2, Integer.valueOf(rybh)).uniqueResult();

	}

	public boolean updateRsZzmm(RysxZzmm rysxZzmm) {
		if (rysxZzmm == null) {
			return false;
		} else {
			getHibernateTemplate().update(rysxZzmm);
			return true;
		}
	}

	// myCode
	public boolean interceptAddZzmm(RysxZzmm rysxZzmm) {
		try {
			getSession().save(rysxZzmm);
			getSession().flush();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			log.debug("添加政治面貌错");
			return false;
		}

	}

	public boolean interceptUpdateZzmm(RysxZzmm rysxZzmm) {
		try {
			getSession().update(rysxZzmm);
			getSession().flush();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			log.debug("更新政治面貌错");
			return false;
		}

	}

	public boolean interceptDeleteRsZzmmById(RysxZzmm rysxZzmm) {
		try {
			getSession().delete(rysxZzmm);
			getSession().flush();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			log.debug("删除政治面貌错");
			return false;
		}
	}

	@SuppressWarnings("unchecked")
	public List<RysxZzmm> getZzmmByRybhFy(int fydm, int rybh) {
		Session s = getSession();
		String str = "from RysxZzmm rz where rz.NFy = ? and rz.NRybh = ? order by DZzrq desc ";
		List<RysxZzmm> listRysxZzmm = s.createQuery(str)
				.setParameter(0, Integer.valueOf(fydm))
				.setParameter(1, Integer.valueOf(rybh)).list();
		return listRysxZzmm;
		// return
		// getSession().createQuery("from RysxZzmm rz where rz.NFy = ? and rz.NRybh = ?").setParameter(0,Integer.valueOf(fydm)).setParameter(1,Integer.valueOf(rybh)).list();
	}

	public RysxZzmm findByFyRybhId(int fy, int rybh, BigDecimal id) {
		return (RysxZzmm) getSession()
				.createQuery(
						"from RysxZzmm rz where rz.NFy = ? and rz.NRybh = ? and rz.NId = ? ")
				.setParameter(0, fy).setParameter(1, rybh).setParameter(2, id)
				.uniqueResult();
	}

	public BigDecimal getMaxNid(int fydm) {
		String hql = "select max(N_ID) from T_RYSX_ZZMM";
		return DaoUtils.getMaxIdRyjbxx(getSession(), fydm, hql);

	}
	// myCode

	// myCode
}