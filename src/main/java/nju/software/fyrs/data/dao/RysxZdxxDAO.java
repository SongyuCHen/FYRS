package nju.software.fyrs.data.dao;

import java.math.BigDecimal;
import java.util.List;

import nju.software.fyrs.data.dataobject.RysxZdxx;

import org.hibernate.LockMode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

/**
 	* A data access object (DAO) providing persistence and search support for RysxZdxx entities.
 			* Transaction control of the save(), update() and delete() operations 
		can directly support Spring container-managed transactions or they can be augmented	to handle user-managed Spring transactions. 
		Each of these methods provides additional information for how to configure it for the desired type of transaction control. 	
	 * @see nju.software.fyrs.data.dataobject.RysxZdxx
  * @author MyEclipse Persistence Tools 
 */
public class RysxZdxxDAO extends HibernateDaoSupport  {
	     private static final Logger log = LoggerFactory.getLogger(RysxZdxxDAO.class);
		//property constants
	public static final String _NZDXL = "NZdxl";
	public static final String _CZDYX = "CZdyx";
	public static final String _NSXZY = "NSxzy";
	public static final String _CZDZY = "CZdzy";
	public static final String _NJYXS = "NJyxs";
	public static final String _NXXXS = "NXxxs";
	public static final String _NXZ = "NXz";
	public static final String _NDQXX = "NDqxx";
	public static final String _NXSSX = "NXssx";



	protected void initDao() {
		//do nothing
	}
    
    public void save(RysxZdxx transientInstance) {
        log.debug("saving RysxZdxx instance");
        try {
            getHibernateTemplate().save(transientInstance);
            log.debug("save successful");
        } catch (RuntimeException re) {
            log.error("save failed", re);
            throw re;
        }
    }
    
	public void delete(RysxZdxx persistentInstance) {
        log.debug("deleting RysxZdxx instance");
        try {
            getHibernateTemplate().delete(persistentInstance);
            log.debug("delete successful");
        } catch (RuntimeException re) {
            log.error("delete failed", re);
            throw re;
        }
    }
    
    public RysxZdxx findById( nju.software.fyrs.data.dataobject.RysxZdxxId id) {
        log.debug("getting RysxZdxx instance with id: " + id);
        try {
            RysxZdxx instance = (RysxZdxx) getHibernateTemplate()
                    .get("software.fyrs.data.RysxZdxx", id);
            return instance;
        } catch (RuntimeException re) {
            log.error("get failed", re);
            throw re;
        }
    }
    
    
    @SuppressWarnings("unchecked")
	public List<RysxZdxx> findByExample(RysxZdxx instance) {
        log.debug("finding RysxZdxx instance by example");
        try {
            List<RysxZdxx> results = (List<RysxZdxx>) getHibernateTemplate().findByExample(instance); 
            log.debug("find by example successful, result size: " + results.size());
            return results;
        } catch (RuntimeException re) {
            log.error("find by example failed", re);
            throw re;
        }
    }    
    
    @SuppressWarnings("rawtypes")
	public List findByProperty(String propertyName, Object value) {
      log.debug("finding RysxZdxx instance with property: " + propertyName
            + ", value: " + value);
      try {
         String queryString = "from RysxZdxx as model where model." 
         						+ propertyName + "= ?";
		 return getHibernateTemplate().find(queryString, value);
      } catch (RuntimeException re) {
         log.error("find by property name failed", re);
         throw re;
      }
	}

	@SuppressWarnings("unchecked")
	public List<RysxZdxx> findByNZdxl(Object NZdxl
	) {
		return findByProperty(_NZDXL, NZdxl
		);
	}
	
	@SuppressWarnings("unchecked")
	public List<RysxZdxx> findByCZdyx(Object CZdyx
	) {
		return findByProperty(_CZDYX, CZdyx
		);
	}
	
	@SuppressWarnings("unchecked")
	public List<RysxZdxx> findByNSxzy(Object NSxzy
	) {
		return findByProperty(_NSXZY, NSxzy
		);
	}
	
	@SuppressWarnings("unchecked")
	public List<RysxZdxx> findByCZdzy(Object CZdzy
	) {
		return findByProperty(_CZDZY, CZdzy
		);
	}
	
	@SuppressWarnings("unchecked")
	public List<RysxZdxx> findByNJyxs(Object NJyxs
	) {
		return findByProperty(_NJYXS, NJyxs
		);
	}
	
	@SuppressWarnings("unchecked")
	public List<RysxZdxx> findByNXxxs(Object NXxxs
	) {
		return findByProperty(_NXXXS, NXxxs
		);
	}
	
	@SuppressWarnings("unchecked")
	public List<RysxZdxx> findByNXz(Object NXz
	) {
		return findByProperty(_NXZ, NXz
		);
	}
	
	@SuppressWarnings("unchecked")
	public List<RysxZdxx> findByNDqxx(Object NDqxx
	) {
		return findByProperty(_NDQXX, NDqxx
		);
	}
	
	@SuppressWarnings("unchecked")
	public List<RysxZdxx> findByNXssx(Object NXssx
	) {
		return findByProperty(_NXSSX, NXssx
		);
	}
	

	@SuppressWarnings("rawtypes")
	public List findAll() {
		log.debug("finding all RysxZdxx instances");
		try {
			String queryString = "from RysxZdxx";
		 	return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}
	
    public RysxZdxx merge(RysxZdxx detachedInstance) {
        log.debug("merging RysxZdxx instance");
        try {
            RysxZdxx result = (RysxZdxx) getHibernateTemplate()
                    .merge(detachedInstance);
            log.debug("merge successful");
            return result;
        } catch (RuntimeException re) {
            log.error("merge failed", re);
            throw re;
        }
    }

    public void attachDirty(RysxZdxx instance) {
        log.debug("attaching dirty RysxZdxx instance");
        try {
            getHibernateTemplate().saveOrUpdate(instance);
            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }
    
    public void attachClean(RysxZdxx instance) {
        log.debug("attaching clean RysxZdxx instance");
        try {
            getHibernateTemplate().lock(instance, LockMode.NONE);
            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }

	public static RysxZdxxDAO getFromApplicationContext(ApplicationContext ctx) {
    	return (RysxZdxxDAO) ctx.getBean("RysxZdxxDAO");
	}
	
	@SuppressWarnings("unchecked")
	public List<RysxZdxx> getZdxxByRybh(String rybh){
		int nrybh = Integer.parseInt(rybh);
		String hql = "from RysxZdxx where NRybh=?";
		List<RysxZdxx> listRysxZdxx = getHibernateTemplate().find(hql,nrybh);
		return listRysxZdxx;
	}
	
	public RysxZdxx getRsZdxxById(String id,String fydm,String rybh){
		String hql = "from RysxZdxx where NId=? and NFy=? and NRybh=?";
		BigDecimal bigDecimal = new BigDecimal(id);
		return (RysxZdxx)getSession().createQuery(hql).setParameter(0,bigDecimal).setParameter(1,Integer.valueOf(fydm)).setParameter(2, Integer.valueOf(rybh)).uniqueResult();
	}
	
	@SuppressWarnings("unchecked")
	public boolean delRsZdxxById(String rybh,String bh){
		int nrybh = Integer.parseInt(rybh);
		BigDecimal bd = new BigDecimal(bh);
		String hql = "from RysxZdxx where NRybh=? and NId=?";
		List<RysxZdxx> listRysxZdxx = getHibernateTemplate().find(hql,nrybh,bd);
		if(listRysxZdxx==null||listRysxZdxx.size()==0){
			return false;
		}else{
			RysxZdxx rysxZdxx = listRysxZdxx.get(0);
			getHibernateTemplate().delete(rysxZdxx);
			return true;
		}
	}
	
	public boolean updateRsZdxx(RysxZdxx rysxZdxx){
		if(rysxZdxx==null){
			return false;
		}else{
			getHibernateTemplate().update(rysxZdxx);
			return true;
		}
	}
	// myCode
	@SuppressWarnings("unchecked")
	public List<RysxZdxx> getZdxxByRybhFy(int rybh,int fydm)
	{
	return getSession().createQuery("from RysxZdxx rz where rz.NFy = ? and rz.NRybh = ?").setParameter(0,Integer.valueOf(fydm)).setParameter(1,Integer.valueOf(rybh)).list();
	}
	// myCode
	
	public boolean interceptAddZdxx(RysxZdxx rysxZdxx){
		try
		{
			getSession().save(rysxZdxx);
			getSession().flush();
			return true;
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
			return false;
		}
		
	}
	
	public boolean interceptUpdateZdxx(RysxZdxx rysxZdxx){
		try
		{
			getSession().update(rysxZdxx);
			getSession().flush();
			return true;
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
			return false;
		}
		
	}
	
	public boolean interceptDeleteRsZdxxById(RysxZdxx rysxZdxx){
		try
		{
			getSession().delete(rysxZdxx);
			getSession().flush();
			return true;
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
			return false;
		}
		
	}
	
	public RysxZdxx findByFyRybhId(int fy,int rybh,BigDecimal id)
	{
	   return (RysxZdxx)getSession().createQuery("from RysxZdxx rk where rk.NFy = ? and rk.NRybh = ? and rk.NId = ? ").setParameter(0,fy).setParameter(1, rybh).setParameter(2,id).uniqueResult();	
	}
	public BigDecimal getMaxNid(int fydm)
	{
		String hql = "select max(N_ID) from T_RYSX_ZDXX";
		return DaoUtils.getMaxIdRyjbxx(getSession(), fydm, hql);
		
	}


	
}