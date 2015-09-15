package nju.software.fyrs.data.dao;

import java.util.List;

import nju.software.fyrs.data.dataobject.Mc;

import org.hibernate.LockMode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

/**
 	* A data access object (DAO) providing persistence and search support for Mc entities.
 			* Transaction control of the save(), update() and delete() operations 
		can directly support Spring container-managed transactions or they can be augmented	to handle user-managed Spring transactions. 
		Each of these methods provides additional information for how to configure it for the desired type of transaction control. 	
	 * @see nju.software.fyrs.data.dataobject.Mc
  * @author MyEclipse Persistence Tools 
 */
public class McDAO extends HibernateDaoSupport  {
	     private static final Logger log = LoggerFactory.getLogger(McDAO.class);
		//property constants
	public static final String _CMC = "CMc";
	public static final String _NLX = "NLx";
	public static final String _NZXZ = "NZxz";
	public static final String _NZDZ = "NZdz";
	public static final String _NDQZ = "NDqz";



	protected void initDao() {
		//do nothing
	}
    
    public void save(Mc transientInstance) {
        log.debug("saving Mc instance");
        try {
            getHibernateTemplate().save(transientInstance);
            log.debug("save successful");
        } catch (RuntimeException re) {
            log.error("save failed", re);
            throw re;
        }
    }
    
	public void delete(Mc persistentInstance) {
        log.debug("deleting Mc instance");
        try {
            getHibernateTemplate().delete(persistentInstance);
            log.debug("delete successful");
        } catch (RuntimeException re) {
            log.error("delete failed", re);
            throw re;
        }
    }
    
    public Mc findById( java.lang.Short id) {
        log.debug("getting Mc instance with id: " + id);
        try {
            Mc instance = (Mc) getHibernateTemplate()
                    .get("software.fyrs.data.Mc", id);
            return instance;
        } catch (RuntimeException re) {
            log.error("get failed", re);
            throw re;
        }
    }
    
    
    @SuppressWarnings("unchecked")
	public List<Mc> findByExample(Mc instance) {
        log.debug("finding Mc instance by example");
        try {
            List<Mc> results = (List<Mc>) getHibernateTemplate().findByExample(instance); 
            log.debug("find by example successful, result size: " + results.size());
            return results;
        } catch (RuntimeException re) {
            log.error("find by example failed", re);
            throw re;
        }
    }    
    
    @SuppressWarnings("rawtypes")
	public List findByProperty(String propertyName, Object value) {
      log.debug("finding Mc instance with property: " + propertyName
            + ", value: " + value);
      try {
         String queryString = "from Mc as model where model." 
         						+ propertyName + "= ?";
		 return getHibernateTemplate().find(queryString, value);
      } catch (RuntimeException re) {
         log.error("find by property name failed", re);
         throw re;
      }
	}

	@SuppressWarnings("unchecked")
	public List<Mc> findByCMc(Object CMc
	) {
		return findByProperty(_CMC, CMc
		);
	}
	
	@SuppressWarnings("unchecked")
	public List<Mc> findByNLx(Object NLx
	) {
		return findByProperty(_NLX, NLx
		);
	}
	
	@SuppressWarnings("unchecked")
	public List<Mc> findByNZxz(Object NZxz
	) {
		return findByProperty(_NZXZ, NZxz
		);
	}
	
	@SuppressWarnings("unchecked")
	public List<Mc> findByNZdz(Object NZdz
	) {
		return findByProperty(_NZDZ, NZdz
		);
	}
	
	@SuppressWarnings("unchecked")
	public List<Mc> findByNDqz(Object NDqz
	) {
		return findByProperty(_NDQZ, NDqz
		);
	}
	

	@SuppressWarnings("rawtypes")
	public List findAll() {
		log.debug("finding all Mc instances");
		try {
			String queryString = "from Mc";
		 	return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}
	
    public Mc merge(Mc detachedInstance) {
        log.debug("merging Mc instance");
        try {
            Mc result = (Mc) getHibernateTemplate()
                    .merge(detachedInstance);
            log.debug("merge successful");
            return result;
        } catch (RuntimeException re) {
            log.error("merge failed", re);
            throw re;
        }
    }

    public void attachDirty(Mc instance) {
        log.debug("attaching dirty Mc instance");
        try {
            getHibernateTemplate().saveOrUpdate(instance);
            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }
    
    public void attachClean(Mc instance) {
        log.debug("attaching clean Mc instance");
        try {
            getHibernateTemplate().lock(instance, LockMode.NONE);
            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }

	public static McDAO getFromApplicationContext(ApplicationContext ctx) {
    	return (McDAO) ctx.getBean("McDAO");
	}
}