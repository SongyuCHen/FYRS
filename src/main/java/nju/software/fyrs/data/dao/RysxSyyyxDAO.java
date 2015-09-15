package nju.software.fyrs.data.dao;

import java.math.BigDecimal;
import java.util.List;

import nju.software.fyrs.data.dataobject.RysxSyyyx;

import org.hibernate.LockMode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

/**
 	* A data access object (DAO) providing persistence and search support for RysxSyyyx entities.
 			* Transaction control of the save(), update() and delete() operations 
		can directly support Spring container-managed transactions or they can be augmented	to handle user-managed Spring transactions. 
		Each of these methods provides additional information for how to configure it for the desired type of transaction control. 	
	 * @see nju.software.fyrs.data.dataobject.RysxSyyyx
  * @author MyEclipse Persistence Tools 
 */
public class RysxSyyyxDAO extends HibernateDaoSupport  {
	     private static final Logger log = LoggerFactory.getLogger(RysxSyyyxDAO.class);
		//property constants
	public static final String _CFILENAME = "CFilename";
	public static final String _CPATH = "CPath";
	public static final String _CMS = "CMs";
	public static final String _NXSSX = "NXssx";



	protected void initDao() {
		//do nothing
	}
    
    public void save(RysxSyyyx transientInstance) {
        log.debug("saving RysxSyyyx instance");
        try {
            getHibernateTemplate().save(transientInstance);
            log.debug("save successful");
        } catch (RuntimeException re) {
            log.error("save failed", re);
            throw re;
        }
    }
    
	public void delete(RysxSyyyx persistentInstance) {
        log.debug("deleting RysxSyyyx instance");
        try {
            getHibernateTemplate().delete(persistentInstance);
            log.debug("delete successful");
        } catch (RuntimeException re) {
            log.error("delete failed", re);
            throw re;
        }
    }
    
    public RysxSyyyx findById( nju.software.fyrs.data.dataobject.RysxSyyyxId id) {
        log.debug("getting RysxSyyyx instance with id: " + id);
        try {
            RysxSyyyx instance = (RysxSyyyx) getHibernateTemplate()
                    .get("software.fyrs.data.RysxSyyyx", id);
            return instance;
        } catch (RuntimeException re) {
            log.error("get failed", re);
            throw re;
        }
    }
    
    
    @SuppressWarnings("unchecked")
	public List<RysxSyyyx> findByExample(RysxSyyyx instance) {
        log.debug("finding RysxSyyyx instance by example");
        try {
            List<RysxSyyyx> results = (List<RysxSyyyx>) getHibernateTemplate().findByExample(instance); 
            log.debug("find by example successful, result size: " + results.size());
            return results;
        } catch (RuntimeException re) {
            log.error("find by example failed", re);
            throw re;
        }
    }    
    
    @SuppressWarnings("rawtypes")
	public List findByProperty(String propertyName, Object value) {
      log.debug("finding RysxSyyyx instance with property: " + propertyName
            + ", value: " + value);
      try {
         String queryString = "from RysxSyyyx as model where model." 
         						+ propertyName + "= ?";
		 return getHibernateTemplate().find(queryString, value);
      } catch (RuntimeException re) {
         log.error("find by property name failed", re);
         throw re;
      }
	}

	@SuppressWarnings("unchecked")
	public List<RysxSyyyx> findByCFilename(Object CFilename
	) {
		return findByProperty(_CFILENAME, CFilename
		);
	}
	
	@SuppressWarnings("unchecked")
	public List<RysxSyyyx> findByCPath(Object CPath
	) {
		return findByProperty(_CPATH, CPath
		);
	}
	
	@SuppressWarnings("unchecked")
	public List<RysxSyyyx> findByCMs(Object CMs
	) {
		return findByProperty(_CMS, CMs
		);
	}
	
	@SuppressWarnings("unchecked")
	public List<RysxSyyyx> findByNXssx(Object NXssx
	) {
		return findByProperty(_NXSSX, NXssx
		);
	}
	

	@SuppressWarnings("rawtypes")
	public List findAll() {
		log.debug("finding all RysxSyyyx instances");
		try {
			String queryString = "from RysxSyyyx";
		 	return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}
	
    public RysxSyyyx merge(RysxSyyyx detachedInstance) {
        log.debug("merging RysxSyyyx instance");
        try {
            RysxSyyyx result = (RysxSyyyx) getHibernateTemplate()
                    .merge(detachedInstance);
            log.debug("merge successful");
            return result;
        } catch (RuntimeException re) {
            log.error("merge failed", re);
            throw re;
        }
    }

    public void attachDirty(RysxSyyyx instance) {
        log.debug("attaching dirty RysxSyyyx instance");
        try {
            getHibernateTemplate().saveOrUpdate(instance);
            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }
    
    public void attachClean(RysxSyyyx instance) {
        log.debug("attaching clean RysxSyyyx instance");
        try {
            getHibernateTemplate().lock(instance, LockMode.NONE);
            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }

	public static RysxSyyyxDAO getFromApplicationContext(ApplicationContext ctx) {
    	return (RysxSyyyxDAO) ctx.getBean("RysxSyyyxDAO");
	}
	
	@SuppressWarnings("unchecked")
	public List<RysxSyyyx> getSyyyxByRybh(String rybh){
		int nrybh = Integer.parseInt(rybh);
		String hql = "from RysxSyyyx where NRybh=?";
		List<RysxSyyyx> listRysxSyyyx = getHibernateTemplate().find(hql,nrybh);
		return listRysxSyyyx;
	}
	
	@SuppressWarnings("unchecked")
	public RysxSyyyx getRsSyyyxById(String rybh,String bh){
		int nrybh = Integer.parseInt(rybh);
		BigDecimal bd = new BigDecimal(bh);
		String hql = "from RysxSyyyx where NRybh=? and NId=?";
		List<RysxSyyyx> listRysxSyyyx = getHibernateTemplate().find(hql,nrybh,bd);
		if(listRysxSyyyx==null||listRysxSyyyx.size()==0){
			return null;
		}else{
			RysxSyyyx rysxSyyyx = listRysxSyyyx.get(0);
			return rysxSyyyx;
		}
	}
	
	@SuppressWarnings("unchecked")
	public boolean delRsSyyyxById(String rybh,String bh){
		int nrybh = Integer.parseInt(rybh);
		BigDecimal bd = new BigDecimal(bh);
		String hql = "from RysxSyyyx where NRybh=? and NId=?";
		List<RysxSyyyx> listRysxSyyyx = getHibernateTemplate().find(hql,nrybh,bd);
		if(listRysxSyyyx==null||listRysxSyyyx.size()==0){
			return false;
		}else{
			RysxSyyyx rysxSyyyx = listRysxSyyyx.get(0);
			getHibernateTemplate().delete(rysxSyyyx);
			return true;
		}
	}
	
	public boolean updateRsSyyyx(RysxSyyyx rysxSyyyx){
		if(rysxSyyyx==null){
			return false;
		}else{
			getHibernateTemplate().update(rysxSyyyx);
			return true;
		}
	}
}