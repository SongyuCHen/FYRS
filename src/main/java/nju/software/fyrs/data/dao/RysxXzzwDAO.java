package nju.software.fyrs.data.dao;

import java.math.BigDecimal;
import java.util.List;

import nju.software.fyrs.data.dataobject.RysxXzzw;

import org.hibernate.LockMode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

/**
 	* A data access object (DAO) providing persistence and search support for RysxXzzw entities.
 			* Transaction control of the save(), update() and delete() operations 
		can directly support Spring container-managed transactions or they can be augmented	to handle user-managed Spring transactions. 
		Each of these methods provides additional information for how to configure it for the desired type of transaction control. 	
	 * @see nju.software.fyrs.data.dataobject.RysxXzzw
  * @author MyEclipse Persistence Tools 
 */
public class RysxXzzwDAO extends HibernateDaoSupport  {
	     private static final Logger log = LoggerFactory.getLogger(RysxXzzwDAO.class);
		//property constants
	public static final String _NRMLB = "NRmlb";
	public static final String _NXZZW = "NXzzw";
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
    
    public void save(RysxXzzw transientInstance) {
        log.debug("saving RysxXzzw instance");
        try {
            getHibernateTemplate().save(transientInstance);
            log.debug("save successful");
        } catch (RuntimeException re) {
            log.error("save failed", re);
            throw re;
        }
    }
    
	public void delete(RysxXzzw persistentInstance) {
        log.debug("deleting RysxXzzw instance");
        try {
            getHibernateTemplate().delete(persistentInstance);
            log.debug("delete successful");
        } catch (RuntimeException re) {
            log.error("delete failed", re);
            throw re;
        }
    }
    
    public RysxXzzw findById( nju.software.fyrs.data.dataobject.RysxXzzwId id) {
        log.debug("getting RysxXzzw instance with id: " + id);
        try {
            RysxXzzw instance = (RysxXzzw) getHibernateTemplate()
                    .get("software.fyrs.data.RysxXzzw", id);
            return instance;
        } catch (RuntimeException re) {
            log.error("get failed", re);
            throw re;
        }
    }
    
    
    @SuppressWarnings("unchecked")
	public List<RysxXzzw> findByExample(RysxXzzw instance) {
        log.debug("finding RysxXzzw instance by example");
        try {
            List<RysxXzzw> results = (List<RysxXzzw>) getHibernateTemplate().findByExample(instance); 
            log.debug("find by example successful, result size: " + results.size());
            return results;
        } catch (RuntimeException re) {
            log.error("find by example failed", re);
            throw re;
        }
    }    
    
    @SuppressWarnings("rawtypes")
	public List findByProperty(String propertyName, Object value) {
      log.debug("finding RysxXzzw instance with property: " + propertyName
            + ", value: " + value);
      try {
         String queryString = "from RysxXzzw as model where model." 
         						+ propertyName + "= ?";
		 return getHibernateTemplate().find(queryString, value);
      } catch (RuntimeException re) {
         log.error("find by property name failed", re);
         throw re;
      }
	}

	@SuppressWarnings("unchecked")
	public List<RysxXzzw> findByNRmlb(Object NRmlb
	) {
		return findByProperty(_NRMLB, NRmlb
		);
	}
	
	@SuppressWarnings("unchecked")
	public List<RysxXzzw> findByNXzzw(Object NXzzw
	) {
		return findByProperty(_NXZZW, NXzzw
		);
	}
	
	@SuppressWarnings("unchecked")
	public List<RysxXzzw> findByCDw(Object CDw
	) {
		return findByProperty(_CDW, CDw
		);
	}
	
	@SuppressWarnings("unchecked")
	public List<RysxXzzw> findByCBm(Object CBm
	) {
		return findByProperty(_CBM, CBm
		);
	}
	
	@SuppressWarnings("unchecked")
	public List<RysxXzzw> findByNRmyy(Object NRmyy
	) {
		return findByProperty(_NRMYY, NRmyy
		);
	}
	
	@SuppressWarnings("unchecked")
	public List<RysxXzzw> findByCPzdw(Object CPzdw
	) {
		return findByProperty(_CPZDW, CPzdw
		);
	}
	
	@SuppressWarnings("unchecked")
	public List<RysxXzzw> findByCPzwh(Object CPzwh
	) {
		return findByProperty(_CPZWH, CPzwh
		);
	}
	
	@SuppressWarnings("unchecked")
	public List<RysxXzzw> findByNDqxx(Object NDqxx
	) {
		return findByProperty(_NDQXX, NDqxx
		);
	}
	
	@SuppressWarnings("unchecked")
	public List<RysxXzzw> findByCJlid(Object CJlid
	) {
		return findByProperty(_CJLID, CJlid
		);
	}
	
	@SuppressWarnings("unchecked")
	public List<RysxXzzw> findByNXssx(Object NXssx
	) {
		return findByProperty(_NXSSX, NXssx
		);
	}
	

	@SuppressWarnings("rawtypes")
	public List findAll() {
		log.debug("finding all RysxXzzw instances");
		try {
			String queryString = "from RysxXzzw";
		 	return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}
	
    public RysxXzzw merge(RysxXzzw detachedInstance) {
        log.debug("merging RysxXzzw instance");
        try {
            RysxXzzw result = (RysxXzzw) getHibernateTemplate()
                    .merge(detachedInstance);
            log.debug("merge successful");
            return result;
        } catch (RuntimeException re) {
            log.error("merge failed", re);
            throw re;
        }
    }

    public void attachDirty(RysxXzzw instance) {
        log.debug("attaching dirty RysxXzzw instance");
        try {
            getHibernateTemplate().saveOrUpdate(instance);
            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }
    
    public void attachClean(RysxXzzw instance) {
        log.debug("attaching clean RysxXzzw instance");
        try {
            getHibernateTemplate().lock(instance, LockMode.NONE);
            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }

	public static RysxXzzwDAO getFromApplicationContext(ApplicationContext ctx) {
    	return (RysxXzzwDAO) ctx.getBean("RysxXzzwDAO");
	}
	
	@SuppressWarnings("unchecked")
	public List<RysxXzzw> getXzzwListByRybh(String rybh){
		String hql = "from RysxXzzw where NRybh="+Integer.parseInt(rybh)+"";
		return getHibernateTemplate().find(hql);
	}
	
	public RysxXzzw getRsXzzwById(String id,String fydm,String rybh){
		String hql="from RysxXzzw where NId=? and NFy=? and NRybh=?";
		BigDecimal bigDecimal = new BigDecimal(id);
		return (RysxXzzw)getSession().createQuery(hql).setParameter(0,bigDecimal).setParameter(1,Integer.valueOf(fydm)).setParameter(2, Integer.valueOf(rybh)).uniqueResult();
	} 
	
	public boolean delRsXzzwById(String rybh,String bh){
		String hql="from RysxXzzw where NRybh=? and NId=?";
		int nrybh = Integer.parseInt(rybh);
		BigDecimal bd1 = new BigDecimal(bh);
		@SuppressWarnings("unchecked")
		List<RysxXzzw> RsXzzwList = getHibernateTemplate().find(hql,nrybh,bd1);
		if(RsXzzwList==null||RsXzzwList.size()==0){
			return false;
		}
		else {
			RysxXzzw rsXzzw=RsXzzwList.get(0);
			getHibernateTemplate().delete(rsXzzw);
		}
		return true;
	}
	public boolean updateRsXzzw(RysxXzzw rysxXzzw){
		if(rysxXzzw==null){
		    return false;
		}
		else{
			getHibernateTemplate().update(rysxXzzw);
			return true;
		}
	}
	// myCode
	@SuppressWarnings("unchecked")
	public List<RysxXzzw> getXzzwByRybhFy(int fydm,int rybh)
	{
	return getSession().createQuery("from RysxXzzw rz where rz.NFy = ? and rz.NRybh = ?").setParameter(0,Integer.valueOf(fydm)).setParameter(1,Integer.valueOf(rybh)).list();
	}
	// myCode
	
	
	//À¹½Ø
	public boolean interceptAddXzzw(RysxXzzw rysxXzzw){
		try
		{
			getSession().save(rysxXzzw);
			getSession().flush();
		    return true;
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
			return false;
		}
		
	}
	
	public boolean interceptUpdateXzzw(RysxXzzw rysxXzzw){
		
		try
		{
			getSession().update(rysxXzzw);
			getSession().flush();
		    return true;
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
			return false;
		}
	}
	
	public boolean interceptDeleteRsXzzwById(RysxXzzw rysxXzzw){
		try
		{
			getSession().delete(rysxXzzw);
			getSession().flush();
		    return true;
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
			return false;
		}
	}
	
	
	public RysxXzzw findByFyRybhId(int fy,int rybh,BigDecimal id)
	{
	   return (RysxXzzw)getSession().createQuery("from RysxXzzw rz where rz.NFy = ? and rz.NRybh = ? and rz.NId = ? ").setParameter(0,fy).setParameter(1, rybh).setParameter(2,id).uniqueResult();	
	}
	public BigDecimal getMaxNid(int fydm)
	{
		String hql = "select max(N_ID) from T_RYSX_XZZW";
		return DaoUtils.getMaxIdRyjbxx(getSession(), fydm, hql);
		
	}
}