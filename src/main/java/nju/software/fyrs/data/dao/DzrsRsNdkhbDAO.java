package nju.software.fyrs.data.dao;

import java.util.List;

import nju.software.fyrs.data.dataobject.DzrsRsNdkhb;
import nju.software.fyrs.data.dataobject.DzrsRsNdkhbId;

import org.hibernate.LockMode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

/**
 * A data access object (DAO) providing persistence and search support for
 * DzrsRsNdkhb entities. Transaction control of the save(), update() and
 * delete() operations can directly support Spring container-managed
 * transactions or they can be augmented to handle user-managed Spring
 * transactions. Each of these methods provides additional information for how
 * to configure it for the desired type of transaction control.
 * 
 * @see software.tjspxt.data.dataobject.DzrsRsNdkhb
 * @author MyEclipse Persistence Tools
 */

public class DzrsRsNdkhbDAO extends HibernateDaoSupport {
	private static final Logger log = LoggerFactory
			.getLogger(DzrsRsNdkhbDAO.class);

	protected void initDao() {
		// do nothing
	}

	public void save(DzrsRsNdkhb transientInstance) {
		log.debug("saving DzrsRsNdkhb instance");
		try {
			getHibernateTemplate().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void update(DzrsRsNdkhb transientInstance) {
		log.debug("updating DzrsRsNdkhb instance");
		try {
			getHibernateTemplate().clear();
			getHibernateTemplate().update(transientInstance);
			log.debug("update successful");
		} catch (RuntimeException re) {
			log.error("update failed", re);
			throw re;
		}
	}
	
	public void delete(DzrsRsNdkhb persistentInstance) {
		log.debug("deleting DzrsRsNdkhb instance");
		try {
			getHibernateTemplate().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public DzrsRsNdkhb findById(DzrsRsNdkhbId id) {
		log.debug("getting DzrsRsNdkhb instance with id: " + id);
		try {
			DzrsRsNdkhb instance = (DzrsRsNdkhb) getHibernateTemplate().get(
					"software.tjspxt.data.dataobject.DzrsRsNdkhb", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	@SuppressWarnings("unchecked")
	public List<DzrsRsNdkhb> findByExample(DzrsRsNdkhb instance) {
		log.debug("finding DzrsRsNdkhb instance by example");
		try {
			List<DzrsRsNdkhb> results = (List<DzrsRsNdkhb>) getHibernateTemplate()
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
		log.debug("finding DzrsRsNdkhb instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from DzrsRsNdkhb as model where model."
					+ propertyName + "= ?";
			return getHibernateTemplate().find(queryString, value);
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	@SuppressWarnings("rawtypes")
	public List findAll() {
		log.debug("finding all DzrsRsNdkhb instances");
		try {
			String queryString = "from DzrsRsNdkhb";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public DzrsRsNdkhb merge(DzrsRsNdkhb detachedInstance) {
		log.debug("merging DzrsRsNdkhb instance");
		try {
			DzrsRsNdkhb result = (DzrsRsNdkhb) getHibernateTemplate().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(DzrsRsNdkhb instance) {
		log.debug("attaching dirty DzrsRsNdkhb instance");
		try {
			getHibernateTemplate().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(DzrsRsNdkhb instance) {
		log.debug("attaching clean DzrsRsNdkhb instance");
		try {
			getHibernateTemplate().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public static DzrsRsNdkhbDAO getFromApplicationContext(
			ApplicationContext ctx) {
		return (DzrsRsNdkhbDAO) ctx.getBean("DzrsRsNdkhbDAO");
	}
	
	@SuppressWarnings("unchecked")
	public List<DzrsRsNdkhb> getNdByRybh(String rybh){
		String hql = "from DzrsRsNdkhb where jbxxjCode=? order by nd";
		List<DzrsRsNdkhb> listDzrsRsNdkhb = getHibernateTemplate().find(hql,rybh);
		return listDzrsRsNdkhb;
	}
	
	@SuppressWarnings("unchecked")
	public List<DzrsRsNdkhb> getNdkhbByRybhAndKhnd(String rybh,String khnd){
		String hql = "from DzrsRsNdkhb where jbxxjCode=? and nd = ?";
		List<DzrsRsNdkhb> listDzrsRsNdkhb = getHibernateTemplate().find(hql,rybh,Integer.parseInt(khnd));
		return listDzrsRsNdkhb;
	}
	
}