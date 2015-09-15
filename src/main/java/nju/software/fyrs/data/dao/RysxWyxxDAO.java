package nju.software.fyrs.data.dao;

import java.math.BigDecimal;
import java.util.List;

import nju.software.fyrs.data.dataobject.RysxWyxx;

import org.hibernate.LockMode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

/**
 	* A data access object (DAO) providing persistence and search support for RysxWyxx entities.
 			* Transaction control of the save(), update() and delete() operations 
		can directly support Spring container-managed transactions or they can be augmented	to handle user-managed Spring transactions. 
		Each of these methods provides additional information for how to configure it for the desired type of transaction control. 	
	 * @see nju.software.fyrs.data.dataobject.RysxWyxx
  * @author MyEclipse Persistence Tools 
 */
public class RysxWyxxDAO extends HibernateDaoSupport  {
	     private static final Logger log = LoggerFactory.getLogger(RysxWyxxDAO.class);
		//property constants
	public static final String _NWYYZ = "NWyyz";
	public static final String _NSLCD = "NSlcd";
	public static final String _NSPJB = "NSpjb";
	public static final String _NXSSX = "NXssx";



	protected void initDao() {
		//do nothing
	}
    
    public void save(RysxWyxx transientInstance) {
        log.debug("saving RysxWyxx instance");
        try {
            getHibernateTemplate().save(transientInstance);
            log.debug("save successful");
        } catch (RuntimeException re) {
            log.error("save failed", re);
            throw re;
        }
    }
    
	public void delete(RysxWyxx persistentInstance) {
        log.debug("deleting RysxWyxx instance");
        try {
            getHibernateTemplate().delete(persistentInstance);
            log.debug("delete successful");
        } catch (RuntimeException re) {
            log.error("delete failed", re);
            throw re;
        }
    }
    
    public RysxWyxx findById( nju.software.fyrs.data.dataobject.RysxWyxxId id) {
        log.debug("getting RysxWyxx instance with id: " + id);
        try {
            RysxWyxx instance = (RysxWyxx) getHibernateTemplate()
                    .get("software.fyrs.data.RysxWyxx", id);
            return instance;
        } catch (RuntimeException re) {
            log.error("get failed", re);
            throw re;
        }
    }
    
    
    @SuppressWarnings("unchecked")
	public List<RysxWyxx> findByExample(RysxWyxx instance) {
        log.debug("finding RysxWyxx instance by example");
        try {
            List<RysxWyxx> results = (List<RysxWyxx>) getHibernateTemplate().findByExample(instance); 
            log.debug("find by example successful, result size: " + results.size());
            return results;
        } catch (RuntimeException re) {
            log.error("find by example failed", re);
            throw re;
        }
    }    
    
    @SuppressWarnings("rawtypes")
	public List findByProperty(String propertyName, Object value) {
      log.debug("finding RysxWyxx instance with property: " + propertyName
            + ", value: " + value);
      try {
         String queryString = "from RysxWyxx as model where model." 
         						+ propertyName + "= ?";
		 return getHibernateTemplate().find(queryString, value);
      } catch (RuntimeException re) {
         log.error("find by property name failed", re);
         throw re;
      }
	}

	@SuppressWarnings("unchecked")
	public List<RysxWyxx> findByNWyyz(Object NWyyz
	) {
		return findByProperty(_NWYYZ, NWyyz
		);
	}
	
	@SuppressWarnings("unchecked")
	public List<RysxWyxx> findByNSlcd(Object NSlcd
	) {
		return findByProperty(_NSLCD, NSlcd
		);
	}
	
	@SuppressWarnings("unchecked")
	public List<RysxWyxx> findByNSpjb(Object NSpjb
	) {
		return findByProperty(_NSPJB, NSpjb
		);
	}
	
	@SuppressWarnings("unchecked")
	public List<RysxWyxx> findByNXssx(Object NXssx
	) {
		return findByProperty(_NXSSX, NXssx
		);
	}
	

	@SuppressWarnings("rawtypes")
	public List findAll() {
		log.debug("finding all RysxWyxx instances");
		try {
			String queryString = "from RysxWyxx";
		 	return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}
	
    public RysxWyxx merge(RysxWyxx detachedInstance) {
        log.debug("merging RysxWyxx instance");
        try {
            RysxWyxx result = (RysxWyxx) getHibernateTemplate()
                    .merge(detachedInstance);
            log.debug("merge successful");
            return result;
        } catch (RuntimeException re) {
            log.error("merge failed", re);
            throw re;
        }
    }

    public void attachDirty(RysxWyxx instance) {
        log.debug("attaching dirty RysxWyxx instance");
        try {
            getHibernateTemplate().saveOrUpdate(instance);
            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }
    
    public void attachClean(RysxWyxx instance) {
        log.debug("attaching clean RysxWyxx instance");
        try {
            getHibernateTemplate().lock(instance, LockMode.NONE);
            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }

	public static RysxWyxxDAO getFromApplicationContext(ApplicationContext ctx) {
    	return (RysxWyxxDAO) ctx.getBean("RysxWyxxDAO");
	}
	
	@SuppressWarnings("unchecked")
	public List<RysxWyxx> getWyxxByRybh(String rybh){
		int nrybh = Integer.parseInt(rybh);
		String hql = "from RysxWyxx where NRybh=?";
		List<RysxWyxx> listRysxWyxx = getHibernateTemplate().find(hql,nrybh);
		return listRysxWyxx;
	}
	
	public RysxWyxx getRsWyxxById(String id,String fydm,String rybh){
		String hql = "from RysxWyxx where NId=? and NFy=? and NRybh=?";
		BigDecimal bigDecimal = new BigDecimal(id);
		return (RysxWyxx)getSession().createQuery(hql).setParameter(0,bigDecimal).setParameter(1,Integer.valueOf(fydm)).setParameter(2, Integer.valueOf(rybh)).uniqueResult();
	}
	
	@SuppressWarnings("unchecked")
	public boolean delRsWyxxById(String rybh,String bh){
		int nrybh = Integer.parseInt(rybh);
		BigDecimal bd = new BigDecimal(bh);
		String hql = "from RysxWyxx where NRybh=? and NId=?";
		List<RysxWyxx> listRysxWyxx = getHibernateTemplate().find(hql,nrybh,bd);
		if(listRysxWyxx==null||listRysxWyxx.size()==0){
			return false;
		}else{
			RysxWyxx rysxWyxx = listRysxWyxx.get(0);
			getHibernateTemplate().delete(rysxWyxx);
			return true;
		}
	}
	
	public boolean updateRsWyxx(RysxWyxx rysxWyxx){
		if(rysxWyxx==null){
			return false;
		}else{
			getHibernateTemplate().update(rysxWyxx);
			return true;
		}
	}
	
	public boolean interceptAddWyxx(RysxWyxx rysxWyxx){
		try
		{
			getSession().save(rysxWyxx);
			getSession().flush();
			return true;
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
			return false;
		}
		
	}
	
	public boolean interceptUpdateWyxx(RysxWyxx rysxWyxx){
		try
		{
			getSession().update(rysxWyxx);
			getSession().flush();
			return true;
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
			return false;
		}
		
	}
	
	public boolean interceptDeleteRsWyxxById(RysxWyxx rysxWyxx){
		try
		{
			getSession().delete(rysxWyxx);
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
	public List<RysxWyxx> getWyxxByRybhFy(int rybh,int fydm){
		return getSession().createQuery("from RysxWyxx rk where rk.NFy=? and rk.NRybh=?").setParameter(0,Integer.valueOf(fydm)).setParameter(1,Integer.valueOf(rybh)).list();
	}
	
	public RysxWyxx findByFyRybhId(int fy,int rybh,BigDecimal id)
	{
	   return (RysxWyxx)getSession().createQuery("from RysxWyxx rk where rk.NFy = ? and rk.NRybh = ? and rk.NId = ? ").setParameter(0,fy).setParameter(1, rybh).setParameter(2,id).uniqueResult();	
	}
	public BigDecimal getMaxNid(int fydm)
	{
		String hql = "select max(N_ID) from T_RYSX_WYXX";
		return DaoUtils.getMaxIdRyjbxx(getSession(), fydm, hql);
		
	}
}