package nju.software.fyrs.data.dao;

import java.math.BigDecimal;
import java.util.List;

import nju.software.fyrs.data.dataobject.RysxZjxx;
import nju.software.fyrs.data.dataobject.RysxZzmm;

import org.hibernate.LockMode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

/**
 	* A data access object (DAO) providing persistence and search support for RysxZjxx entities.
 			* Transaction control of the save(), update() and delete() operations 
		can directly support Spring container-managed transactions or they can be augmented	to handle user-managed Spring transactions. 
		Each of these methods provides additional information for how to configure it for the desired type of transaction control. 	
	 * @see nju.software.fyrs.data.dataobject.RysxZjxx
  * @author MyEclipse Persistence Tools 
 */
public class RysxZjxxDAO extends HibernateDaoSupport  {
	     private static final Logger log = LoggerFactory.getLogger(RysxZjxxDAO.class);
		//property constants
	public static final String _NRMLB = "NRmlb";
	public static final String _NZJ = "NZj";
	public static final String _NZJXZ = "NZjxz";
	public static final String _CDW = "CDw";
	public static final String _CBM = "CBm";
	public static final String _NRMYY = "NRmyy";
	public static final String _CPZDW = "CPzdw";
	public static final String _CPZWH = "CPzwh";
	public static final String _NDQXX = "NDqxx";
	public static final String _CJLID = "CJlid";
	public static final String _NXSSX = "NXssx";



	protected void initDao() {
		//do nothing
	}
    
    public void save(RysxZjxx transientInstance) {
        log.debug("saving RysxZjxx instance");
        try {
            getHibernateTemplate().save(transientInstance);
            log.debug("save successful");
        } catch (RuntimeException re) {
            log.error("save failed", re);
            throw re;
        }
    }
    
	public void delete(RysxZjxx persistentInstance) {
        log.debug("deleting RysxZjxx instance");
        try {
            getHibernateTemplate().delete(persistentInstance);
            log.debug("delete successful");
        } catch (RuntimeException re) {
            log.error("delete failed", re);
            throw re;
        }
    }
    
    public RysxZjxx findById( nju.software.fyrs.data.dataobject.RysxZjxxId id) {
        log.debug("getting RysxZjxx instance with id: " + id);
        try {
            RysxZjxx instance = (RysxZjxx) getHibernateTemplate()
                    .get("software.fyrs.data.RysxZjxx", id);
            return instance;
        } catch (RuntimeException re) {
            log.error("get failed", re);
            throw re;
        }
    }
    
    
    @SuppressWarnings("unchecked")
	public List<RysxZjxx> findByExample(RysxZjxx instance) {
        log.debug("finding RysxZjxx instance by example");
        try {
            List<RysxZjxx> results = (List<RysxZjxx>) getHibernateTemplate().findByExample(instance); 
            log.debug("find by example successful, result size: " + results.size());
            return results;
        } catch (RuntimeException re) {
            log.error("find by example failed", re);
            throw re;
        }
    }    
    
    @SuppressWarnings("rawtypes")
	public List findByProperty(String propertyName, Object value) {
      log.debug("finding RysxZjxx instance with property: " + propertyName
            + ", value: " + value);
      try {
         String queryString = "from RysxZjxx as model where model." 
         						+ propertyName + "= ?";
		 return getHibernateTemplate().find(queryString, value);
      } catch (RuntimeException re) {
         log.error("find by property name failed", re);
         throw re;
      }
	}

	@SuppressWarnings("unchecked")
	public List<RysxZjxx> findByNRmlb(Object NRmlb
	) {
		return findByProperty(_NRMLB, NRmlb
		);
	}
	
	@SuppressWarnings("unchecked")
	public List<RysxZjxx> findByNZj(Object NZj
	) {
		return findByProperty(_NZJ, NZj
		);
	}
	
	@SuppressWarnings("unchecked")
	public List<RysxZjxx> findByNZjxz(Object NZjxz
	) {
		return findByProperty(_NZJXZ, NZjxz
		);
	}
	
	@SuppressWarnings("unchecked")
	public List<RysxZjxx> findByCDw(Object CDw
	) {
		return findByProperty(_CDW, CDw
		);
	}
	
	@SuppressWarnings("unchecked")
	public List<RysxZjxx> findByCBm(Object CBm
	) {
		return findByProperty(_CBM, CBm
		);
	}
	
	@SuppressWarnings("unchecked")
	public List<RysxZjxx> findByNRmyy(Object NRmyy
	) {
		return findByProperty(_NRMYY, NRmyy
		);
	}
	
	@SuppressWarnings("unchecked")
	public List<RysxZjxx> findByCPzdw(Object CPzdw
	) {
		return findByProperty(_CPZDW, CPzdw
		);
	}
	
	@SuppressWarnings("unchecked")
	public List<RysxZjxx> findByCPzwh(Object CPzwh
	) {
		return findByProperty(_CPZWH, CPzwh
		);
	}
	
	@SuppressWarnings("unchecked")
	public List<RysxZjxx> findByNDqxx(Object NDqxx
	) {
		return findByProperty(_NDQXX, NDqxx
		);
	}
	
	@SuppressWarnings("unchecked")
	public List<RysxZjxx> findByCJlid(Object CJlid
	) {
		return findByProperty(_CJLID, CJlid
		);
	}
	
	@SuppressWarnings("unchecked")
	public List<RysxZjxx> findByNXssx(Object NXssx
	) {
		return findByProperty(_NXSSX, NXssx
		);
	}
	

	@SuppressWarnings("rawtypes")
	public List findAll() {
		log.debug("finding all RysxZjxx instances");
		try {
			String queryString = "from RysxZjxx";
		 	return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}
	
    public RysxZjxx merge(RysxZjxx detachedInstance) {
        log.debug("merging RysxZjxx instance");
        try {
            RysxZjxx result = (RysxZjxx) getHibernateTemplate()
                    .merge(detachedInstance);
            log.debug("merge successful");
            return result;
        } catch (RuntimeException re) {
            log.error("merge failed", re);
            throw re;
        }
    }

    public void attachDirty(RysxZjxx instance) {
        log.debug("attaching dirty RysxZjxx instance");
        try {
            getHibernateTemplate().saveOrUpdate(instance);
            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }
    
    public void attachClean(RysxZjxx instance) {
        log.debug("attaching clean RysxZjxx instance");
        try {
            getHibernateTemplate().lock(instance, LockMode.NONE);
            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }

	public static RysxZjxxDAO getFromApplicationContext(ApplicationContext ctx) {
    	return (RysxZjxxDAO) ctx.getBean("RysxZjxxDAO");
	}
	
	// myCode
	@SuppressWarnings("unchecked")
	public List<RysxZjxx> getZjxxByRybhFy(int fydm,int rybh)
	{
	return getSession().createQuery("from RysxZjxx rz where rz.NFy = ? and rz.NRybh = ?").setParameter(0,Integer.valueOf(fydm)).setParameter(1,Integer.valueOf(rybh)).list();
	}
	
	public RysxZjxx getRsZjxxById(String id, String fydm, String rybh) {
		String hql = "from RysxZjxx where NId=? and NFy = ? and NRybh=? ";
		BigDecimal bigDecimal = new BigDecimal(id);
		return (RysxZjxx) getSession().createQuery(hql)
				.setParameter(0, bigDecimal)
				.setParameter(1, Integer.valueOf(fydm))
				.setParameter(2, Integer.valueOf(rybh)).uniqueResult();
	}
	
	//À¹½Ø
	public boolean interceptAddZjxx(RysxZjxx rysxZjxx){
		try
		{
			getSession().save(rysxZjxx);
			getSession().flush();
			return true;
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
			return false;
		}
		
	}
	
	public boolean interceptUpdateZjxx(RysxZjxx rysxZjxx){
		try
		{
			getSession().update(rysxZjxx);
			getSession().flush();
			return true;
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
			return false;
		}
	}
	
	public boolean interceptDeleteRsZjxxById(RysxZjxx rysxZjxx){
		try
		{
			getSession().delete(rysxZjxx);
			getSession().flush();
			return true;
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
			return false;
		}
	}
	// myCode
}