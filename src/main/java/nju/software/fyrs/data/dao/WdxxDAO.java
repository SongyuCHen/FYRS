package nju.software.fyrs.data.dao;

import java.util.List;

import nju.software.fyrs.data.dataobject.Wdxx;

import org.hibernate.LockMode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

/**
 	* A data access object (DAO) providing persistence and search support for Wdxx entities.
 			* Transaction control of the save(), update() and delete() operations 
		can directly support Spring container-managed transactions or they can be augmented	to handle user-managed Spring transactions. 
		Each of these methods provides additional information for how to configure it for the desired type of transaction control. 	
	 * @see nju.software.fyrs.data.dataobject.Wdxx
  * @author MyEclipse Persistence Tools 
 */
public class WdxxDAO extends HibernateDaoSupport  {
	     private static final Logger log = LoggerFactory.getLogger(WdxxDAO.class);
		//property constants
	public static final String _CFWH = "CFwh";
	public static final String _CFWBT = "CFwbt";
	public static final String _CWDMS = "CWdms";
	public static final String _CWDNR = "CWdnr";



	protected void initDao() {
		//do nothing
	}
    
    public void save(Wdxx transientInstance) {
        log.debug("saving Wdxx instance");
        try {
            getHibernateTemplate().save(transientInstance);
            log.debug("save successful");
        } catch (RuntimeException re) {
            log.error("save failed", re);
            throw re;
        }
    }
    
	public void delete(Wdxx persistentInstance) {
        log.debug("deleting Wdxx instance");
        try {
            getHibernateTemplate().delete(persistentInstance);
            log.debug("delete successful");
        } catch (RuntimeException re) {
            log.error("delete failed", re);
            throw re;
        }
    }
    
    public Wdxx findById( java.lang.Long id) {
        log.debug("getting Wdxx instance with id: " + id);
        try {
            Wdxx instance = (Wdxx) getHibernateTemplate()
                    .get("software.fyrs.data.Wdxx", id);
            return instance;
        } catch (RuntimeException re) {
            log.error("get failed", re);
            throw re;
        }
    }
    
    
    @SuppressWarnings("unchecked")
	public List<Wdxx> findByExample(Wdxx instance) {
        log.debug("finding Wdxx instance by example");
        try {
            List<Wdxx> results = (List<Wdxx>) getHibernateTemplate().findByExample(instance); 
            log.debug("find by example successful, result size: " + results.size());
            return results;
        } catch (RuntimeException re) {
            log.error("find by example failed", re);
            throw re;
        }
    }    
    
    @SuppressWarnings("rawtypes")
	public List findByProperty(String propertyName, Object value) {
      log.debug("finding Wdxx instance with property: " + propertyName
            + ", value: " + value);
      try {
         String queryString = "from Wdxx as model where model." 
         						+ propertyName + "= ?";
		 return getHibernateTemplate().find(queryString, value);
      } catch (RuntimeException re) {
         log.error("find by property name failed", re);
         throw re;
      }
	}

	@SuppressWarnings("unchecked")
	public List<Wdxx> findByCFwh(Object CFwh
	) {
		return findByProperty(_CFWH, CFwh
		);
	}
	
	@SuppressWarnings("unchecked")
	public List<Wdxx> findByCFwbt(Object CFwbt
	) {
		return findByProperty(_CFWBT, CFwbt
		);
	}
	
	@SuppressWarnings("unchecked")
	public List<Wdxx> findByCWdms(Object CWdms
	) {
		return findByProperty(_CWDMS, CWdms
		);
	}
	
	@SuppressWarnings("unchecked")
	public List<Wdxx> findByCWdnr(Object CWdnr
	) {
		return findByProperty(_CWDNR, CWdnr
		);
	}
	

	@SuppressWarnings("rawtypes")
	public List findAll() {
		log.debug("finding all Wdxx instances");
		try {
			String queryString = "from Wdxx";
		 	return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}
	
    public Wdxx merge(Wdxx detachedInstance) {
        log.debug("merging Wdxx instance");
        try {
            Wdxx result = (Wdxx) getHibernateTemplate()
                    .merge(detachedInstance);
            log.debug("merge successful");
            return result;
        } catch (RuntimeException re) {
            log.error("merge failed", re);
            throw re;
        }
    }

    public void attachDirty(Wdxx instance) {
        log.debug("attaching dirty Wdxx instance");
        try {
            getHibernateTemplate().saveOrUpdate(instance);
            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }
    
    public void attachClean(Wdxx instance) {
        log.debug("attaching clean Wdxx instance");
        try {
            getHibernateTemplate().lock(instance, LockMode.NONE);
            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }

	public static WdxxDAO getFromApplicationContext(ApplicationContext ctx) {
    	return (WdxxDAO) ctx.getBean("WdxxDAO");
	}
}