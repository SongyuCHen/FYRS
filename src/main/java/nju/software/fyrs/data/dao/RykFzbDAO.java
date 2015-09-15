package nju.software.fyrs.data.dao;

import java.util.List;

import nju.software.fyrs.data.dataobject.RykFzb;

import org.hibernate.LockMode;
import org.hibernate.Query;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

/**
 * A data access object (DAO) providing persistence and search support for
 * RykFzb entities. Transaction control of the save(), update() and delete()
 * operations can directly support Spring container-managed transactions or they
 * can be augmented to handle user-managed Spring transactions. Each of these
 * methods provides additional information for how to configure it for the
 * desired type of transaction control.
 * 
 * @see nju.software.fyrs.data.dataobject.RykFzb
 * @author MyEclipse Persistence Tools
 */

public class RykFzbDAO extends HibernateDaoSupport {
	private static final Logger log = LoggerFactory.getLogger(RykFzbDAO.class);
	// property constants
	public static final String _NFY = "NFy";
	public static final String _NRYBH = "NRybh";
	public static final String _NBM = "NBm";
	public static final String _NFZBLX = "NFzblx";
	public static final String _NXSSX = "NXssx";

	protected void initDao() {
		// do nothing
	}

	public void save(RykFzb transientInstance) {
		log.debug("saving RykFzb instance");
		try {
			getHibernateTemplate().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(RykFzb persistentInstance) {
		log.debug("deleting RykFzb instance");
		try {
			getHibernateTemplate().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public RykFzb findById(java.lang.Integer id) {
		log.debug("getting RykFzb instance with id: " + id);
		try {
			RykFzb instance = (RykFzb) getHibernateTemplate().get(
					"nju.software.fyrs.data.RykFzb", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	@SuppressWarnings("unchecked")
	public List<RykFzb> findByExample(RykFzb instance) {
		log.debug("finding RykFzb instance by example");
		try {
			List<RykFzb> results = (List<RykFzb>) getHibernateTemplate()
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
		log.debug("finding RykFzb instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from RykFzb as model where model."
					+ propertyName + "= ?";
			return getHibernateTemplate().find(queryString, value);
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	@SuppressWarnings("unchecked")
	public List<RykFzb> findByNFy(Object NFy) {
		return findByProperty(_NFY, NFy);
	}

	@SuppressWarnings("unchecked")
	public List<RykFzb> findByNRybh(Object NRybh) {
		return findByProperty(_NRYBH, NRybh);
	}

	@SuppressWarnings("unchecked")
	public List<RykFzb> findByNBm(Object NBm) {
		return findByProperty(_NBM, NBm);
	}

	@SuppressWarnings("unchecked")
	public List<RykFzb> findByNFzblx(Object NFzblx) {
		return findByProperty(_NFZBLX, NFzblx);
	}

	@SuppressWarnings("unchecked")
	public List<RykFzb> findByNXssx(Object NXssx) {
		return findByProperty(_NXSSX, NXssx);
	}

	@SuppressWarnings("rawtypes")
	public List findAll() {
		log.debug("finding all RykFzb instances");
		try {
			String queryString = "from RykFzb";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public RykFzb merge(RykFzb detachedInstance) {
		log.debug("merging RykFzb instance");
		try {
			RykFzb result = (RykFzb) getHibernateTemplate().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(RykFzb instance) {
		log.debug("attaching dirty RykFzb instance");
		try {
			getHibernateTemplate().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(RykFzb instance) {
		log.debug("attaching clean RykFzb instance");
		try {
			getHibernateTemplate().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public static RykFzbDAO getFromApplicationContext(ApplicationContext ctx) {
		return (RykFzbDAO) ctx.getBean("RykFzbDAO");
	}

	@SuppressWarnings("unchecked")
	public List<RykFzb> getFzbListByFyAndBm(int fydm, int bmdm, int fzbrylx,
			int sfls) {
		if (bmdm == -2) {
			return getSession()
					.createQuery(
							"from RykFzb rj where rj.NFy=? and rj.NFzblx=? and rj.NSfls = ?")
					.setParameter(0, Integer.valueOf(fydm))
					.setParameter(1, Integer.valueOf(fzbrylx))
					.setParameter(2, Integer.valueOf(sfls)).list();
		}
		return getSession()
				.createQuery(
						"from RykFzb rj where rj.NFy=? and rj.NBm=? and rj.NFzblx=? and rj.NSfls = ?")
				.setParameter(0, Integer.valueOf(fydm))
				.setParameter(1, Integer.valueOf(bmdm))
				.setParameter(2, Integer.valueOf(fzbrylx))
				.setParameter(3, Integer.valueOf(sfls)).list();
	}

	public void update(RykFzb transientInstance) {
		log.debug("updating RykFzb instance");
		try {
			getHibernateTemplate().update(transientInstance);
			log.debug("update successful");
		} catch (RuntimeException re) {
			log.error("update failed", re);
			throw re;
		}
	}

	public Integer getMaxNid(int fydm) {
		String hql = "select max(N_ID) from T_RYK_FZB";
		Query query = getSession().createSQLQuery(hql);
		Object object = query.uniqueResult();
		int maxBh = 1;
		if (null != object) {
			maxBh = (Integer) object + 1;
		}
		return maxBh;
	}

	public int getMaxNXssx(int fydm) {
		String hql = "select max(N_XSSX) from T_RYK_FZB where N_FY = " + fydm;
		Query query = getSession().createSQLQuery(hql);
		Object object = query.uniqueResult();
		int maxBh = 1;
		if (null != object) {
			maxBh = (Integer) object + 1;
		}
		return maxBh;
	}

	public RykFzb getFzbByRybhFyFzbrylx(Integer rybh, Integer fydm,
			Integer fzbrylx) {

		return (RykFzb) getSession()
				.createQuery(
						"from RykFzb rj where rj.NFy = ? and rj.NRybh = ? and rj.NFzblx = ? ")
				.setParameter(0, fydm).setParameter(1, rybh)
				.setParameter(2, fzbrylx).uniqueResult();
	}

}