package nju.software.fyrs.data.dao;

import java.util.ArrayList;
import java.util.List;


import nju.software.fyrs.data.dataobject.RykZz;

import org.hibernate.LockMode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

/**
 	* A data access object (DAO) providing persistence and search support for RykZz entities.
 			* Transaction control of the save(), update() and delete() operations 
		can directly support Spring container-managed transactions or they can be augmented	to handle user-managed Spring transactions. 
		Each of these methods provides additional information for how to configure it for the desired type of transaction control. 	
	 * @see nju.software.fyrs.data.dataobject.RykZz
  * @author MyEclipse Persistence Tools 
 */

public class RykZzDAO extends HibernateDaoSupport  {
	     private static final Logger log = LoggerFactory.getLogger(RykZzDAO.class);
		//property constants
	public static final String _NFY = "NFy";
	public static final String _NRYBH = "NRybh";
	public static final String _NBM = "NBm";
	public static final String _NXSSX = "NXssx";



	protected void initDao() {
		//do nothing
	}
    
    public void save(RykZz transientInstance) {
        log.debug("saving RykZz instance");
        try {
            getHibernateTemplate().save(transientInstance);
            log.debug("save successful");
        } catch (RuntimeException re) {
            log.error("save failed", re);
            throw re;
        }
    }
    
	public void delete(RykZz persistentInstance) {
        log.debug("deleting RykZz instance");
        try {
            getHibernateTemplate().delete(persistentInstance);
            log.debug("delete successful");
        } catch (RuntimeException re) {
            log.error("delete failed", re);
            throw re;
        }
    }
    
    public RykZz findById( java.lang.Integer id) {
        log.debug("getting RykZz instance with id: " + id);
        try {
            RykZz instance = (RykZz) getHibernateTemplate()
                    .get("nju.software.fyrs.data.RykZz", id);
            return instance;
        } catch (RuntimeException re) {
            log.error("get failed", re);
            throw re;
        }
    }
    
    
    @SuppressWarnings("unchecked")
	public List<RykZz> findByExample(RykZz instance) {
        log.debug("finding RykZz instance by example");
        try {
            List<RykZz> results = (List<RykZz>) getHibernateTemplate().findByExample(instance); 
            log.debug("find by example successful, result size: " + results.size());
            return results;
        } catch (RuntimeException re) {
            log.error("find by example failed", re);
            throw re;
        }
    }    
    
    @SuppressWarnings("rawtypes")
	public List findByProperty(String propertyName, Object value) {
      log.debug("finding RykZz instance with property: " + propertyName
            + ", value: " + value);
      try {
         String queryString = "from RykZz as model where model." 
         						+ propertyName + "= ?";
		 return getHibernateTemplate().find(queryString, value);
      } catch (RuntimeException re) {
         log.error("find by property name failed", re);
         throw re;
      }
	}

	@SuppressWarnings("unchecked")
	public List<RykZz> findByNFy(Object NFy
	) {
		return findByProperty(_NFY, NFy
		);
	}
	
	@SuppressWarnings("unchecked")
	public List<RykZz> findByNRybh(Object NRybh
	) {
		return findByProperty(_NRYBH, NRybh
		);
	}
	
	@SuppressWarnings("unchecked")
	public List<RykZz> findByNBm(Object NBm
	) {
		return findByProperty(_NBM, NBm
		);
	}
	
	@SuppressWarnings("unchecked")
	public List<RykZz> findByNXssx(Object NXssx
	) {
		return findByProperty(_NXSSX, NXssx
		);
	}
	

	@SuppressWarnings("rawtypes")
	public List findAll() {
		log.debug("finding all RykZz instances");
		try {
			String queryString = "from RykZz";
		 	return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}
	
    public RykZz merge(RykZz detachedInstance) {
        log.debug("merging RykZz instance");
        try {
            RykZz result = (RykZz) getHibernateTemplate()
                    .merge(detachedInstance);
            log.debug("merge successful");
            return result;
        } catch (RuntimeException re) {
            log.error("merge failed", re);
            throw re;
        }
    }

    public void attachDirty(RykZz instance) {
        log.debug("attaching dirty RykZz instance");
        try {
            getHibernateTemplate().saveOrUpdate(instance);
            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }
    
    public void attachClean(RykZz instance) {
        log.debug("attaching clean RykZz instance");
        try {
            getHibernateTemplate().lock(instance, LockMode.NONE);
            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }

	public static RykZzDAO getFromApplicationContext(ApplicationContext ctx) {
    	return (RykZzDAO) ctx.getBean("RykZzDAO");
	}
	
	@SuppressWarnings("unchecked")
	public List<RykZz> getRyList(int fydm, int bmdm){
		List<RykZz> ryList = new ArrayList<RykZz>();
		String hql = "from RykZz where NFy = ? and NBm = ?";
		ryList = getHibernateTemplate().find(hql, fydm, bmdm);
		return ryList;
	}
}