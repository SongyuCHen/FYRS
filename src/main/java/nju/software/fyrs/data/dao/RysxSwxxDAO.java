package nju.software.fyrs.data.dao;

import java.math.BigDecimal;
import java.util.List;

import nju.software.fyrs.data.dataobject.RysxSwxx;

import org.hibernate.LockMode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

/**
 	* A data access object (DAO) providing persistence and search support for RysxSwxx entities.
 			* Transaction control of the save(), update() and delete() operations 
		can directly support Spring container-managed transactions or they can be augmented	to handle user-managed Spring transactions. 
		Each of these methods provides additional information for how to configure it for the desired type of transaction control. 	
	 * @see nju.software.fyrs.data.dataobject.RysxSwxx
  * @author MyEclipse Persistence Tools 
 */
public class RysxSwxxDAO extends HibernateDaoSupport  {
	     private static final Logger log = LoggerFactory.getLogger(RysxSwxxDAO.class);
		//property constants
	public static final String _NSWCD = "NSwcd";
	public static final String _NSWYY = "NSwyy";
	public static final String _NXSSX = "NXssx";



	protected void initDao() {
		//do nothing
	}
    
    public void save(RysxSwxx transientInstance) {
        log.debug("saving RysxSwxx instance");
        try {
            getHibernateTemplate().save(transientInstance);
            log.debug("save successful");
        } catch (RuntimeException re) {
            log.error("save failed", re);
            throw re;
        }
    }
    
	public void delete(RysxSwxx persistentInstance) {
        log.debug("deleting RysxSwxx instance");
        try {
            getHibernateTemplate().delete(persistentInstance);
            log.debug("delete successful");
        } catch (RuntimeException re) {
            log.error("delete failed", re);
            throw re;
        }
    }
    
    public RysxSwxx findById( nju.software.fyrs.data.dataobject.RysxSwxxId id) {
        log.debug("getting RysxSwxx instance with id: " + id);
        try {
            RysxSwxx instance = (RysxSwxx) getHibernateTemplate()
                    .get("software.fyrs.data.RysxSwxx", id);
            return instance;
        } catch (RuntimeException re) {
            log.error("get failed", re);
            throw re;
        }
    }
    
    
    @SuppressWarnings("unchecked")
	public List<RysxSwxx> findByExample(RysxSwxx instance) {
        log.debug("finding RysxSwxx instance by example");
        try {
            List<RysxSwxx> results = (List<RysxSwxx>) getHibernateTemplate().findByExample(instance); 
            log.debug("find by example successful, result size: " + results.size());
            return results;
        } catch (RuntimeException re) {
            log.error("find by example failed", re);
            throw re;
        }
    }    
    
    @SuppressWarnings("rawtypes")
	public List findByProperty(String propertyName, Object value) {
      log.debug("finding RysxSwxx instance with property: " + propertyName
            + ", value: " + value);
      try {
         String queryString = "from RysxSwxx as model where model." 
         						+ propertyName + "= ?";
		 return getHibernateTemplate().find(queryString, value);
      } catch (RuntimeException re) {
         log.error("find by property name failed", re);
         throw re;
      }
	}

	@SuppressWarnings("unchecked")
	public List<RysxSwxx> findByNSwcd(Object NSwcd
	) {
		return findByProperty(_NSWCD, NSwcd
		);
	}
	
	@SuppressWarnings("unchecked")
	public List<RysxSwxx> findByNSwyy(Object NSwyy
	) {
		return findByProperty(_NSWYY, NSwyy
		);
	}
	
	@SuppressWarnings("unchecked")
	public List<RysxSwxx> findByNXssx(Object NXssx
	) {
		return findByProperty(_NXSSX, NXssx
		);
	}
	

	@SuppressWarnings("rawtypes")
	public List findAll() {
		log.debug("finding all RysxSwxx instances");
		try {
			String queryString = "from RysxSwxx";
		 	return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}
	
    public RysxSwxx merge(RysxSwxx detachedInstance) {
        log.debug("merging RysxSwxx instance");
        try {
            RysxSwxx result = (RysxSwxx) getHibernateTemplate()
                    .merge(detachedInstance);
            log.debug("merge successful");
            return result;
        } catch (RuntimeException re) {
            log.error("merge failed", re);
            throw re;
        }
    }

    public void attachDirty(RysxSwxx instance) {
        log.debug("attaching dirty RysxSwxx instance");
        try {
            getHibernateTemplate().saveOrUpdate(instance);
            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }
    
    public void attachClean(RysxSwxx instance) {
        log.debug("attaching clean RysxSwxx instance");
        try {
            getHibernateTemplate().lock(instance, LockMode.NONE);
            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }

	public static RysxSwxxDAO getFromApplicationContext(ApplicationContext ctx) {
    	return (RysxSwxxDAO) ctx.getBean("RysxSwxxDAO");
	}
	
	@SuppressWarnings("unchecked")
	public List<RysxSwxx> getSwxxByRybh(String rybh){
		int nrybh = Integer.parseInt(rybh);
		String hql = "from RysxSwxx where NRybh=?";
		List<RysxSwxx> listRysxSwxx = getHibernateTemplate().find(hql,nrybh);
		return listRysxSwxx;
	}
	
	public RysxSwxx getRsSwxxById(String id,String fydm,String rybh){
		String hql = "from RysxSwxx where NId=? and NFy=? and NRybh=?";
		BigDecimal bigDecimal = new BigDecimal(id);
		return (RysxSwxx)getSession().createQuery(hql).setParameter(0,bigDecimal).setParameter(1,Integer.valueOf(fydm)).setParameter(2, Integer.valueOf(rybh)).uniqueResult();
	}
	
	@SuppressWarnings("unchecked")
	public boolean delRsSwxxById(String rybh,String bh){
		int nrybh = Integer.parseInt(rybh);
		BigDecimal bd = new BigDecimal(bh);
		String hql = "from RysxSwxx where NRybh=? and NId=?";
		List<RysxSwxx> listRysxSwxx = getHibernateTemplate().find(hql,nrybh,bd);
		if(listRysxSwxx==null||listRysxSwxx.size()==0){
			return false;
		}else{
			RysxSwxx rysxSwxx = listRysxSwxx.get(0);
			getHibernateTemplate().delete(rysxSwxx);
			return true;
		}
	}
	
	public boolean updateRsSwxx(RysxSwxx rysxSwxx){
		if(rysxSwxx==null){
			return false;
		}else{
			getHibernateTemplate().update(rysxSwxx);
			return true;
		}
	}
	
	public boolean interceptAddSwxx(RysxSwxx rysxSwxx){
		try
		{
			getSession().save(rysxSwxx);
			getSession().flush();
			return true;
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
			return false;
		}
		
	}
	
	public boolean interceptUpdateSwxx(RysxSwxx rysxSwxx){
		try
		{
			getSession().update(rysxSwxx);
			getSession().flush();
			return true;
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
			return false;
		}
	
	}
	
	public boolean interceptDeleteRsSwxxById(RysxSwxx rysxSwxx){
		try
		{
			getSession().delete(rysxSwxx);
			getSession().flush();
			return true;
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
			return false;
		}
		
	}
	
	@SuppressWarnings("unchecked")
	public List<RysxSwxx> getSwxxByRybhFy(int rybh,int fydm){
		return getSession().createQuery("from RysxSwxx rk where rk.NFy=? and rk.NRybh=?").setParameter(0,Integer.valueOf(fydm)).setParameter(1,Integer.valueOf(rybh)).list();
	}
	
	public RysxSwxx findByFyRybhId(int fy,int rybh,BigDecimal id)
	{
	   return (RysxSwxx)getSession().createQuery("from RysxSwxx rk where rk.NFy = ? and rk.NRybh = ? and rk.NId = ? ").setParameter(0,fy).setParameter(1, rybh).setParameter(2,id).uniqueResult();	
	}
	public BigDecimal getMaxNid(int fydm)
	{
		String hql = "select max(N_ID) from T_RYSX_SWXX";
		return DaoUtils.getMaxIdRyjbxx(getSession(), fydm, hql);
		
	}


	
}