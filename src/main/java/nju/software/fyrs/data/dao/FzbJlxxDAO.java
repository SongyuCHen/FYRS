package nju.software.fyrs.data.dao;

import java.math.BigDecimal;
import java.util.List;
import nju.software.fyrs.data.dataobject.FzbJlxx;
import org.hibernate.LockMode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

/**
 * A data access object (DAO) providing persistence and search support for
 * FzbJlxx entities. Transaction control of the save(), update() and delete()
 * operations can directly support Spring container-managed transactions or they
 * can be augmented to handle user-managed Spring transactions. Each of these
 * methods provides additional information for how to configure it for the
 * desired type of transaction control.
 * 
 * @see nju.software.fyrs.data.dataobject.FzbJlxx
 * @author MyEclipse Persistence Tools
 */
public class FzbJlxxDAO extends HibernateDaoSupport {
	private static final Logger log = LoggerFactory.getLogger(FzbJlxxDAO.class);
	// property constants
	public static final String _CSZDW = "CSzdw";
	public static final String _CSZBM = "CSzbm";
	public static final String _CZW = "CZw";
	public static final String _CZJ = "CZj";
	public static final String _CZMR = "CZmr";
	public static final String _CGLXX = "CGlxx";
	public static final String _NXSSX = "NXssx";

	protected void initDao() {
		// do nothing
	}

	public void save(FzbJlxx transientInstance) {
		log.debug("saving FzbJlxx instance");
		try {
			getHibernateTemplate().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(FzbJlxx persistentInstance) {
		log.debug("deleting FzbJlxx instance");
		try {
			getHibernateTemplate().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public FzbJlxx findById(nju.software.fyrs.data.dataobject.FzbJlxxId id) {
		log.debug("getting FzbJlxx instance with id: " + id);
		try {
			FzbJlxx instance = (FzbJlxx) getHibernateTemplate().get(
					"software.fyrs.data.FzbJlxx", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	@SuppressWarnings("unchecked")
	public List<FzbJlxx> findByExample(FzbJlxx instance) {
		log.debug("finding FzbJlxx instance by example");
		try {
			List<FzbJlxx> results = (List<FzbJlxx>) getHibernateTemplate()
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
		log.debug("finding FzbJlxx instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from FzbJlxx as model where model."
					+ propertyName + "= ?";
			return getHibernateTemplate().find(queryString, value);
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	@SuppressWarnings("unchecked")
	public List<FzbJlxx> findByCSzdw(Object CSzdw) {
		return findByProperty(_CSZDW, CSzdw);
	}

	@SuppressWarnings("unchecked")
	public List<FzbJlxx> findByCSzbm(Object CSzbm) {
		return findByProperty(_CSZBM, CSzbm);
	}

	@SuppressWarnings("unchecked")
	public List<FzbJlxx> findByCZw(Object CZw) {
		return findByProperty(_CZW, CZw);
	}

	@SuppressWarnings("unchecked")
	public List<FzbJlxx> findByCZj(Object CZj) {
		return findByProperty(_CZJ, CZj);
	}

	@SuppressWarnings("unchecked")
	public List<FzbJlxx> findByCZmr(Object CZmr) {
		return findByProperty(_CZMR, CZmr);
	}

	@SuppressWarnings("unchecked")
	public List<FzbJlxx> findByCGlxx(Object CGlxx) {
		return findByProperty(_CGLXX, CGlxx);
	}

	@SuppressWarnings("unchecked")
	public List<FzbJlxx> findByNXssx(Object NXssx) {
		return findByProperty(_NXSSX, NXssx);
	}

	@SuppressWarnings("rawtypes")
	public List findAll() {
		log.debug("finding all FzbJlxx instances");
		try {
			String queryString = "from FzbJlxx";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public FzbJlxx merge(FzbJlxx detachedInstance) {
		log.debug("merging FzbJlxx instance");
		try {
			FzbJlxx result = (FzbJlxx) getHibernateTemplate().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(FzbJlxx instance) {
		log.debug("attaching dirty FzbJlxx instance");
		try {
			getHibernateTemplate().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(FzbJlxx instance) {
		log.debug("attaching clean FzbJlxx instance");
		try {
			getHibernateTemplate().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public static FzbJlxxDAO getFromApplicationContext(ApplicationContext ctx) {
		return (FzbJlxxDAO) ctx.getBean("FzbJlxxDAO");
	}

	@SuppressWarnings("unchecked")
	public List<FzbJlxx> getJlxxByRybh(String rybh) {
		int nrybh = Integer.parseInt(rybh);
		String hql = "from FzbJlxx where NRybh=" + nrybh;
		List<FzbJlxx> listFzbJlxx = getHibernateTemplate().find(hql);
		return listFzbJlxx;
	}

	public FzbJlxx getRsJlxxById(String id, String fydm, String rybh) {
		String hql = "from FzbJlxx where NId=? and NFy=? and NRybh=?";
		BigDecimal bigDecimal = new BigDecimal(id);
		return (FzbJlxx) getSession().createQuery(hql)
				.setParameter(0, bigDecimal)
				.setParameter(1, Integer.valueOf(fydm))
				.setParameter(2, Integer.valueOf(rybh)).uniqueResult();
	}

	@SuppressWarnings("unchecked")
	public boolean delRsJlxxById(String rybh, String bh) {
		String hql = "from FzbJlxx where NRybh=? and NId=?";
		int nrybh = Integer.parseInt(rybh);
		BigDecimal bd = new BigDecimal(bh);
		List<FzbJlxx> RsJlxxList = getHibernateTemplate().find(hql, nrybh, bd);
		if (RsJlxxList == null || RsJlxxList.size() == 0) {
			return false;
		} else {
			FzbJlxx rsJlxx = RsJlxxList.get(0);
			getHibernateTemplate().delete(rsJlxx);
			return true;
		}
	}

	public boolean updateRsJlxx(FzbJlxx FzbJlxx) {
		if (FzbJlxx == null) {
			return false;
		} else {
			getHibernateTemplate().update(FzbJlxx);
			return true;
		}
	}

	public boolean AddJlxx(FzbJlxx FzbJlxx) {
		try {
			getSession().save(FzbJlxx);
			getSession().flush();
			return true;
		} catch (Exception ex) {
			ex.printStackTrace();
			return false;
		}

	}

	public boolean UpdateJlxx(FzbJlxx FzbJlxx) {
		try {
			getSession().update(FzbJlxx);
			getSession().flush();
			return true;
		} catch (Exception ex) {
			ex.printStackTrace();
			return false;
		}

	}

	public boolean DeleteRsJlxxById(FzbJlxx FzbJlxx) {
		try {
			getSession().delete(FzbJlxx);
			getSession().flush();
			return true;
		} catch (Exception ex) {
			ex.printStackTrace();
			return false;
		}

	}

	@SuppressWarnings("unchecked")
	public List<FzbJlxx> getJlxxByRybhFy(int rybh, int fydm) {
		return getSession()
				.createQuery("from FzbJlxx rj where rj.NFy=? and rj.NRybh=?")
				.setParameter(0, Integer.valueOf(fydm))
				.setParameter(1, Integer.valueOf(rybh)).list();
	}

	public FzbJlxx findByFyRybhId(int fy, int rybh, BigDecimal id) {
		return (FzbJlxx) getSession()
				.createQuery(
						"from FzbJlxx rj where rj.NFy = ? and rj.NRybh = ? and rj.NId = ? ")
				.setParameter(0, fy).setParameter(1, rybh).setParameter(2, id)
				.uniqueResult();
	}

	public BigDecimal getMaxNid(int fydm) {
		String hql = "select max(N_ID) from T_FZB_JLXX";
		return DaoUtils.getMaxIdRyjbxx(getSession(), fydm, hql);

	}
}