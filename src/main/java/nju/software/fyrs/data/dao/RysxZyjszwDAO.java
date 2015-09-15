package nju.software.fyrs.data.dao;

import java.math.BigDecimal;
import java.util.List;

import nju.software.fyrs.data.dataobject.RysxZyjszw;

import org.hibernate.LockMode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

/**
 * A data access object (DAO) providing persistence and search support for
 * RysxZyjszw entities. Transaction control of the save(), update() and delete()
 * operations can directly support Spring container-managed transactions or they
 * can be augmented to handle user-managed Spring transactions. Each of these
 * methods provides additional information for how to configure it for the
 * desired type of transaction control.
 * 
 * @see nju.software.fyrs.data.dataobject.RysxZyjszw
 * @author MyEclipse Persistence Tools
 */
public class RysxZyjszwDAO extends HibernateDaoSupport {
	private static final Logger log = LoggerFactory
			.getLogger(RysxZyjszwDAO.class);
	// property constants
	public static final String _NQDMC = "NQdmc";
	public static final String _NQDTJ = "NQdtj";
	public static final String _NPRMC = "NPrmc";
	public static final String _NZCDJ = "NZcdj";
	public static final String _NXSSX = "NXssx";

	protected void initDao() {
		// do nothing
	}

	public void save(RysxZyjszw transientInstance) {
		log.debug("saving RysxZyjszw instance");
		try {
			getHibernateTemplate().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(RysxZyjszw persistentInstance) {
		log.debug("deleting RysxZyjszw instance");
		try {
			getHibernateTemplate().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public RysxZyjszw findById(nju.software.fyrs.data.dataobject.RysxZyjszwId id) {
		log.debug("getting RysxZyjszw instance with id: " + id);
		try {
			RysxZyjszw instance = (RysxZyjszw) getHibernateTemplate().get(
					"software.fyrs.data.RysxZyjszw", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	@SuppressWarnings("unchecked")
	public List<RysxZyjszw> findByExample(RysxZyjszw instance) {
		log.debug("finding RysxZyjszw instance by example");
		try {
			List<RysxZyjszw> results = (List<RysxZyjszw>) getHibernateTemplate()
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
		log.debug("finding RysxZyjszw instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from RysxZyjszw as model where model."
					+ propertyName + "= ?";
			return getHibernateTemplate().find(queryString, value);
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	@SuppressWarnings("unchecked")
	public List<RysxZyjszw> findByNQdmc(Object NQdmc) {
		return findByProperty(_NQDMC, NQdmc);
	}

	@SuppressWarnings("unchecked")
	public List<RysxZyjszw> findByNQdtj(Object NQdtj) {
		return findByProperty(_NQDTJ, NQdtj);
	}

	@SuppressWarnings("unchecked")
	public List<RysxZyjszw> findByNPrmc(Object NPrmc) {
		return findByProperty(_NPRMC, NPrmc);
	}

	@SuppressWarnings("unchecked")
	public List<RysxZyjszw> findByNZcdj(Object NZcdj) {
		return findByProperty(_NZCDJ, NZcdj);
	}

	@SuppressWarnings("unchecked")
	public List<RysxZyjszw> findByNXssx(Object NXssx) {
		return findByProperty(_NXSSX, NXssx);
	}

	@SuppressWarnings("rawtypes")
	public List findAll() {
		log.debug("finding all RysxZyjszw instances");
		try {
			String queryString = "from RysxZyjszw";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public RysxZyjszw merge(RysxZyjszw detachedInstance) {
		log.debug("merging RysxZyjszw instance");
		try {
			RysxZyjszw result = (RysxZyjszw) getHibernateTemplate().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(RysxZyjszw instance) {
		log.debug("attaching dirty RysxZyjszw instance");
		try {
			getHibernateTemplate().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(RysxZyjszw instance) {
		log.debug("attaching clean RysxZyjszw instance");
		try {
			getHibernateTemplate().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public static RysxZyjszwDAO getFromApplicationContext(ApplicationContext ctx) {
		return (RysxZyjszwDAO) ctx.getBean("RysxZyjszwDAO");
	}

	@SuppressWarnings("unchecked")
	public List<RysxZyjszw> getZyjszwByRybh(String rybh) {
		int nrybh = Integer.parseInt(rybh);
		String hql = "from RysxZyjszw where NRybh=?";
		List<RysxZyjszw> listRysxZyjszw = getHibernateTemplate().find(hql,
				nrybh);
		return listRysxZyjszw;

	}

	public RysxZyjszw getRsZyjszwById(String id, String fydm, String rybh) {
		String hql = "from RysxZyjszw where NId=? and NFy=? and NRybh=?";
		BigDecimal bigDecimal = new BigDecimal(id);
		return (RysxZyjszw) getSession().createQuery(hql)
				.setParameter(0, bigDecimal)
				.setParameter(1, Integer.valueOf(fydm))
				.setParameter(2, Integer.valueOf(rybh)).uniqueResult();
	}

	@SuppressWarnings("unchecked")
	public boolean delRsZyjszwById(String rybh, String bh) {
		int nrybh = Integer.parseInt(rybh);
		BigDecimal bd = new BigDecimal(bh);
		String hql = "from RysxZyjszw where NRybh=? and NId=?";
		List<RysxZyjszw> listRysxZyjszw = getHibernateTemplate().find(hql,
				nrybh, bd);
		if (listRysxZyjszw == null || listRysxZyjszw.size() == 0) {
			return false;
		} else {
			RysxZyjszw rysxZyjszw = listRysxZyjszw.get(0);
			getHibernateTemplate().delete(rysxZyjszw);
			return true;
		}
	}

	public boolean updateRsZyjszw(RysxZyjszw rysxZyjszw) {
		if (rysxZyjszw == null) {
			return false;
		} else {
			getHibernateTemplate().update(rysxZyjszw);
			return true;
		}
	}

	public boolean interceptAddZyjszw(RysxZyjszw rysxZyjszw) {
		try {
			getSession().save(rysxZyjszw);
			getSession().flush();
			return true;
		} catch (Exception ex) {
			ex.printStackTrace();
			return false;
		}

	}

	public boolean interceptUpdateZyjszw(RysxZyjszw rysxZyjszw) {
		try {
			getSession().update(rysxZyjszw);
			getSession().flush();
			return true;
		} catch (Exception ex) {
			ex.printStackTrace();
			return false;
		}

	}

	public boolean interceptDeleteRsZyjszwById(RysxZyjszw rysxZyjszw) {
		try {
			getSession().delete(rysxZyjszw);
			getSession().flush();
			return true;
		} catch (Exception ex) {
			ex.printStackTrace();
			return false;
		}

	}

	@SuppressWarnings("unchecked")
	public List<RysxZyjszw> getZyjszwByRybhFy(int rybh, int fydm) {
		return getSession()
				.createQuery(
						"from RysxZyjszw rj where rj.NFy=? and rj.NRybh=? order by DQdrq")
				.setParameter(0, Integer.valueOf(fydm))
				.setParameter(1, Integer.valueOf(rybh)).list();
	}

	public RysxZyjszw findByFyRybhId(int fy, int rybh, BigDecimal id) {
		return (RysxZyjszw) getSession()
				.createQuery(
						"from RysxZyjszw rj where rj.NFy = ? and rj.NRybh = ? and rj.NId = ? ")
				.setParameter(0, fy).setParameter(1, rybh).setParameter(2, id)
				.uniqueResult();
	}

	public BigDecimal getMaxNid(int fydm) {
		String hql = "select max(N_ID) from T_RYSX_ZYJSZW";
		return DaoUtils.getMaxIdRyjbxx(getSession(), fydm, hql);

	}
}