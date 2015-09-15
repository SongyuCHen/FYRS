package nju.software.fyrs.data.dao;

import java.util.List;

import nju.software.fyrs.data.dataobject.RysxLog;

import org.hibernate.LockMode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

/**
 	* A data access object (DAO) providing persistence and search support for RysxLog entities.
 			* Transaction control of the save(), update() and delete() operations 
		can directly support Spring container-managed transactions or they can be augmented	to handle user-managed Spring transactions. 
		Each of these methods provides additional information for how to configure it for the desired type of transaction control. 	
	 * @see nju.software.fyrs.data.dataobject.RysxLog
  * @author MyEclipse Persistence Tools 
 */
public class RysxLogDAO extends HibernateDaoSupport  {
	     private static final Logger log = LoggerFactory.getLogger(RysxLogDAO.class);
		//property constants
	public static final String _CCZYH = "CCzyh";
	public static final String _NDWID = "NDwid";
	public static final String _CIP = "CIp";
	public static final String _DCZSJ = "DCzsj";
	public static final String _CCZNR = "CCznr";



	protected void initDao() {
		//do nothing
	}
    
    public void save(RysxLog transientInstance) {
        log.debug("saving RysxLog instance");
        try {
            getHibernateTemplate().save(transientInstance);
            log.debug("save successful");
        } catch (RuntimeException re) {
            log.error("save failed", re);
            throw re;
        }
    }
    
	public void delete(RysxLog persistentInstance) {
        log.debug("deleting RysxLog instance");
        try {
            getHibernateTemplate().delete(persistentInstance);
            log.debug("delete successful");
        } catch (RuntimeException re) {
            log.error("delete failed", re);
            throw re;
        }
    }
    
    public RysxLog findById( java.math.BigDecimal id) {
        log.debug("getting RysxLog instance with id: " + id);
        try {
            RysxLog instance = (RysxLog) getHibernateTemplate()
                    .get("software.fyrs.data.RysxLog", id);
            return instance;
        } catch (RuntimeException re) {
            log.error("get failed", re);
            throw re;
        }
    }
    
    
    @SuppressWarnings("unchecked")
	public List<RysxLog> findByExample(RysxLog instance) {
        log.debug("finding RysxLog instance by example");
        try {
            List<RysxLog> results = (List<RysxLog>) getHibernateTemplate().findByExample(instance); 
            log.debug("find by example successful, result size: " + results.size());
            return results;
        } catch (RuntimeException re) {
            log.error("find by example failed", re);
            throw re;
        }
    }    
    
    @SuppressWarnings("rawtypes")
	public List findByProperty(String propertyName, Object value) {
      log.debug("finding RysxLog instance with property: " + propertyName
            + ", value: " + value);
      try {
         String queryString = "from RysxLog as model where model." 
         						+ propertyName + "= ?";
		 return getHibernateTemplate().find(queryString, value);
      } catch (RuntimeException re) {
         log.error("find by property name failed", re);
         throw re;
      }
	}

	@SuppressWarnings("unchecked")
	public List<RysxLog> findByCCzyh(Object CCzyh
	) {
		return findByProperty(_CCZYH, CCzyh
		);
	}
	
	@SuppressWarnings("unchecked")
	public List<RysxLog> findByNDwid(Object NDwid
	) {
		return findByProperty(_NDWID, NDwid
		);
	}
	
	@SuppressWarnings("unchecked")
	public List<RysxLog> findByCIp(Object CIp
	) {
		return findByProperty(_CIP, CIp
		);
	}
	
	@SuppressWarnings("unchecked")
	public List<RysxLog> findByDCzsj(Object DCzsj
	) {
		return findByProperty(_DCZSJ, DCzsj
		);
	}
	
	@SuppressWarnings("unchecked")
	public List<RysxLog> findByCCznr(Object CCznr
	) {
		return findByProperty(_CCZNR, CCznr
		);
	}
	

	@SuppressWarnings("rawtypes")
	public List findAll() {
		log.debug("finding all RysxLog instances");
		try {
			String queryString = "from RysxLog";
		 	return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}
	
    public RysxLog merge(RysxLog detachedInstance) {
        log.debug("merging RysxLog instance");
        try {
            RysxLog result = (RysxLog) getHibernateTemplate()
                    .merge(detachedInstance);
            log.debug("merge successful");
            return result;
        } catch (RuntimeException re) {
            log.error("merge failed", re);
            throw re;
        }
    }

    public void attachDirty(RysxLog instance) {
        log.debug("attaching dirty RysxLog instance");
        try {
            getHibernateTemplate().saveOrUpdate(instance);
            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }
    
    public void attachClean(RysxLog instance) {
        log.debug("attaching clean RysxLog instance");
        try {
            getHibernateTemplate().lock(instance, LockMode.NONE);
            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }

	public static RysxLogDAO getFromApplicationContext(ApplicationContext ctx) {
    	return (RysxLogDAO) ctx.getBean("RysxLogDAO");
	}
}