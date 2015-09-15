package nju.software.fyrs.data.dao;

import java.util.List;
import nju.software.fyrs.data.dataobject.FzbPhoto;
import org.hibernate.LockMode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

/**
 * A data access object (DAO) providing persistence and search support for
 * FzbPhoto entities. Transaction control of the save(), update() and delete()
 * operations can directly support Spring container-managed transactions or they
 * can be augmented to handle user-managed Spring transactions. Each of these
 * methods provides additional information for how to configure it for the
 * desired type of transaction control.
 * 
 * @see nju.software.fyrs.data.dataobject.FzbPhoto
 * @author MyEclipse Persistence Tools
 */
public class FzbPhotoDAO extends HibernateDaoSupport {
	private static final Logger log = LoggerFactory
			.getLogger(FzbPhotoDAO.class);
	// property constants
	public static final String _IPHOTO = "IPhoto";

	protected void initDao() {
		// do nothing
	}

	public void save(FzbPhoto transientInstance) {
		log.debug("saving FzbPhoto instance");
		try {
			getHibernateTemplate().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(FzbPhoto persistentInstance) {
		log.debug("deleting FzbPhoto instance");
		try {
			getHibernateTemplate().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public FzbPhoto findById(nju.software.fyrs.data.dataobject.FzbPhotoId id) {
		log.debug("getting FzbPhoto instance with id: " + id);
		try {
			FzbPhoto instance = (FzbPhoto) getHibernateTemplate().get(
					"software.fyrs.data.FzbPhoto", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	@SuppressWarnings("unchecked")
	public List<FzbPhoto> findByExample(FzbPhoto instance) {
		log.debug("finding FzbPhoto instance by example");
		try {
			List<FzbPhoto> results = (List<FzbPhoto>) getHibernateTemplate()
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
		log.debug("finding FzbPhoto instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from FzbPhoto as model where model."
					+ propertyName + "= ?";
			return getHibernateTemplate().find(queryString, value);
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	@SuppressWarnings("unchecked")
	public List<FzbPhoto> findByIPhoto(Object IPhoto) {
		return findByProperty(_IPHOTO, IPhoto);
	}

	@SuppressWarnings("rawtypes")
	public List findAll() {
		log.debug("finding all FzbPhoto instances");
		try {
			String queryString = "from FzbPhoto";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public FzbPhoto merge(FzbPhoto detachedInstance) {
		log.debug("merging FzbPhoto instance");
		try {
			FzbPhoto result = (FzbPhoto) getHibernateTemplate().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(FzbPhoto instance) {
		log.debug("attaching dirty FzbPhoto instance");
		try {
			getHibernateTemplate().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(FzbPhoto instance) {
		log.debug("attaching clean FzbPhoto instance");
		try {
			getHibernateTemplate().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public FzbPhoto getFzbPhoto(String fydm, String rybh) {
		return (FzbPhoto) getSession()
				.createQuery(" from FzbPhoto where NFy = ? and NRybh = ?")
				.setParameter(0, Integer.valueOf(fydm))
				.setParameter(1, Integer.valueOf(rybh)).uniqueResult();
	}

	public static FzbPhotoDAO getFromApplicationContext(ApplicationContext ctx) {
		return (FzbPhotoDAO) ctx.getBean("FzbPhotoDAO");
	}

	public boolean delFzbPhoto(String fydm, String rybh) {
		FzbPhoto FzbPhoto = (FzbPhoto) getSession()
				.createQuery(" from FzbPhoto where NFy = ? and NRybh = ?")
				.setParameter(0, Integer.valueOf(fydm))
				.setParameter(1, Integer.valueOf(rybh)).uniqueResult();
		if (FzbPhoto == null) {
			return false;
		} else {
			getSession().delete(FzbPhoto);
			return true;
		}
	}

	public void update(FzbPhoto transientInstance) {
		log.debug("updating FzbPhoto instance");
		try {
			getHibernateTemplate().save(transientInstance);
			log.debug("update successful");
		} catch (RuntimeException re) {
			log.error("update failed", re);
			throw re;
		}
	}
}