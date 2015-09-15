package nju.software.fyrs.data.dao;

import java.util.List;


import nju.software.fyrs.data.dataobject.RykLs;

import org.hibernate.LockMode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

/**
 	* A data access object (DAO) providing persistence and search support for RykLs entities.
 			* Transaction control of the save(), update() and delete() operations 
		can directly support Spring container-managed transactions or they can be augmented	to handle user-managed Spring transactions. 
		Each of these methods provides additional information for how to configure it for the desired type of transaction control. 	
	 * @see nju.software.fyrs.data.dataobject.RykLs
  * @author MyEclipse Persistence Tools 
 */

public class RykLsDAO extends HibernateDaoSupport  {
	     private static final Logger log = LoggerFactory.getLogger(RykLsDAO.class);
		//property constants
	public static final String _NFY = "NFy";
	public static final String _NRYBH = "NRybh";
	public static final String _NBM = "NBm";
	public static final String _NLSLX = "NLslx";
	public static final String _NXSSX = "NXssx";



	protected void initDao() {
		//do nothing
	}
    
    public void save(RykLs transientInstance) {
        log.debug("saving RykLs instance");
        try {
            getHibernateTemplate().save(transientInstance);
            log.debug("save successful");
        } catch (RuntimeException re) {
            log.error("save failed", re);
            throw re;
        }
    }
    
	public void delete(RykLs persistentInstance) {
        log.debug("deleting RykLs instance");
        try {
            getHibernateTemplate().delete(persistentInstance);
            log.debug("delete successful");
        } catch (RuntimeException re) {
            log.error("delete failed", re);
            throw re;
        }
    }
    
    public RykLs findById( java.lang.Integer id) {
        log.debug("getting RykLs instance with id: " + id);
        try {
            RykLs instance = (RykLs) getHibernateTemplate()
                    .get("nju.software.fyrs.data.RykLs", id);
            return instance;
        } catch (RuntimeException re) {
            log.error("get failed", re);
            throw re;
        }
    }
    
    
    @SuppressWarnings("unchecked")
	public List<RykLs> findByExample(RykLs instance) {
        log.debug("finding RykLs instance by example");
        try {
            List<RykLs> results = (List<RykLs>) getHibernateTemplate().findByExample(instance); 
            log.debug("find by example successful, result size: " + results.size());
            return results;
        } catch (RuntimeException re) {
            log.error("find by example failed", re);
            throw re;
        }
    }    
    
    @SuppressWarnings("rawtypes")
	public List findByProperty(String propertyName, Object value) {
      log.debug("finding RykLs instance with property: " + propertyName
            + ", value: " + value);
      try {
         String queryString = "from RykLs as model where model." 
         						+ propertyName + "= ?";
		 return getHibernateTemplate().find(queryString, value);
      } catch (RuntimeException re) {
         log.error("find by property name failed", re);
         throw re;
      }
	}

	@SuppressWarnings("unchecked")
	public List<RykLs> findByNFy(Object NFy
	) {
		return findByProperty(_NFY, NFy
		);
	}
	
	@SuppressWarnings("unchecked")
	public List<RykLs> findByNRybh(Object NRybh
	) {
		return findByProperty(_NRYBH, NRybh
		);
	}
	
	@SuppressWarnings("unchecked")
	public List<RykLs> findByNBm(Object NBm
	) {
		return findByProperty(_NBM, NBm
		);
	}
	
	@SuppressWarnings("unchecked")
	public List<RykLs> findByNLslx(Object NLslx
	) {
		return findByProperty(_NLSLX, NLslx
		);
	}
	
	@SuppressWarnings("unchecked")
	public List<RykLs> findByNXssx(Object NXssx
	) {
		return findByProperty(_NXSSX, NXssx
		);
	}
	

	@SuppressWarnings("rawtypes")
	public List findAll() {
		log.debug("finding all RykLs instances");
		try {
			String queryString = "from RykLs";
		 	return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}
	
    public RykLs merge(RykLs detachedInstance) {
        log.debug("merging RykLs instance");
        try {
            RykLs result = (RykLs) getHibernateTemplate()
                    .merge(detachedInstance);
            log.debug("merge successful");
            return result;
        } catch (RuntimeException re) {
            log.error("merge failed", re);
            throw re;
        }
    }

    public void attachDirty(RykLs instance) {
        log.debug("attaching dirty RykLs instance");
        try {
            getHibernateTemplate().saveOrUpdate(instance);
            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }
    
    public void attachClean(RykLs instance) {
        log.debug("attaching clean RykLs instance");
        try {
            getHibernateTemplate().lock(instance, LockMode.NONE);
            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }

	public static RykLsDAO getFromApplicationContext(ApplicationContext ctx) {
    	return (RykLsDAO) ctx.getBean("RykLsDAO");
	}
}