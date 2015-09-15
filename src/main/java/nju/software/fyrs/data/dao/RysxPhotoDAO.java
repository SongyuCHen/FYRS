package nju.software.fyrs.data.dao;
import java.util.List;
import nju.software.fyrs.data.dataobject.RysxPhoto;
import org.hibernate.LockMode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

/**
 	* A data access object (DAO) providing persistence and search support for RysxPhoto entities.
 			* Transaction control of the save(), update() and delete() operations 
		can directly support Spring container-managed transactions or they can be augmented	to handle user-managed Spring transactions. 
		Each of these methods provides additional information for how to configure it for the desired type of transaction control. 	
	 * @see nju.software.fyrs.data.dataobject.RysxPhoto
  * @author MyEclipse Persistence Tools 
 */
public class RysxPhotoDAO extends HibernateDaoSupport  {
	     private static final Logger log = LoggerFactory.getLogger(RysxPhotoDAO.class);
		//property constants
	public static final String _IPHOTO = "IPhoto";



	protected void initDao() {
		//do nothing
	}
    
    public void save(RysxPhoto transientInstance) {
        log.debug("saving RysxPhoto instance");
        try {
            getHibernateTemplate().save(transientInstance);
            log.debug("save successful");
            getSession().flush();
        } catch (RuntimeException re) {
            log.error("save failed", re);
            throw re;
        }
    }
    
	public void delete(RysxPhoto persistentInstance) {
        log.debug("deleting RysxPhoto instance");
        try {
            getHibernateTemplate().delete(persistentInstance);
            log.debug("delete successful");
        } catch (RuntimeException re) {
            log.error("delete failed", re);
            throw re;
        }
    }
    
    public RysxPhoto findById( nju.software.fyrs.data.dataobject.RysxPhotoId id) {
        log.debug("getting RysxPhoto instance with id: " + id);
        try {
            RysxPhoto instance = (RysxPhoto) getHibernateTemplate()
                    .get("software.fyrs.data.RysxPhoto", id);
            return instance;
        } catch (RuntimeException re) {
            log.error("get failed", re);
            throw re;
        }
    }
    
    
    @SuppressWarnings("unchecked")
	public List<RysxPhoto> findByExample(RysxPhoto instance) {
        log.debug("finding RysxPhoto instance by example");
        try {
            List<RysxPhoto> results = (List<RysxPhoto>) getHibernateTemplate().findByExample(instance); 
            log.debug("find by example successful, result size: " + results.size());
            return results;
        } catch (RuntimeException re) {
            log.error("find by example failed", re);
            throw re;
        }
    }    
    
    @SuppressWarnings("rawtypes")
	public List findByProperty(String propertyName, Object value) {
      log.debug("finding RysxPhoto instance with property: " + propertyName
            + ", value: " + value);
      try {
         String queryString = "from RysxPhoto as model where model." 
         						+ propertyName + "= ?";
		 return getHibernateTemplate().find(queryString, value);
      } catch (RuntimeException re) {
         log.error("find by property name failed", re);
         throw re;
      }
	}

	@SuppressWarnings("unchecked")
	public List<RysxPhoto> findByIPhoto(Object IPhoto
	) {
		return findByProperty(_IPHOTO, IPhoto
		);
	}
	

	@SuppressWarnings("rawtypes")
	public List findAll() {
		log.debug("finding all RysxPhoto instances");
		try {
			String queryString = "from RysxPhoto";
		 	return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}
	
    public RysxPhoto merge(RysxPhoto detachedInstance) {
        log.debug("merging RysxPhoto instance");
        try {
            RysxPhoto result = (RysxPhoto) getHibernateTemplate()
                    .merge(detachedInstance);
            log.debug("merge successful");
            return result;
        } catch (RuntimeException re) {
            log.error("merge failed", re);
            throw re;
        }
    }

    public void attachDirty(RysxPhoto instance) {
        log.debug("attaching dirty RysxPhoto instance");
        try {
            getHibernateTemplate().saveOrUpdate(instance);
            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }
    
    public void attachClean(RysxPhoto instance) {
        log.debug("attaching clean RysxPhoto instance");
        try {
            getHibernateTemplate().lock(instance, LockMode.NONE);
            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }
    public RysxPhoto getRysxPhoto(String fydm,String rybh)
    {
    	return (RysxPhoto) getSession().createQuery(" from RysxPhoto where NFy = ? and NRybh = ?").setParameter(0,Integer.valueOf(fydm)).setParameter(1,Integer.valueOf(rybh)).uniqueResult();
    }
  
	public static RysxPhotoDAO getFromApplicationContext(ApplicationContext ctx) {
    	return (RysxPhotoDAO) ctx.getBean("RysxPhotoDAO");
	}
	
	public boolean delRysxPhoto(String fydm,String rybh){
		RysxPhoto rysxPhoto = (RysxPhoto) getSession().createQuery(" from RysxPhoto where NFy = ? and NRybh = ?").setParameter(0,Integer.valueOf(fydm)).setParameter(1,Integer.valueOf(rybh)).uniqueResult();
		if(rysxPhoto==null){
			return false;
		}else{
			getSession().delete(rysxPhoto);
			return true;
		}
	}

	public void update(RysxPhoto transientInstance) {
		 log.debug("updating RysxPhoto instance");
	        try {
	            getHibernateTemplate().update(transientInstance);
	            log.debug("update successful");
	            getSession().flush();
	        } catch (RuntimeException re) {
	            log.error("update failed", re);
	            throw re;
	        }
	}
}