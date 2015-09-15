package nju.software.fyrs.data.dao;

import java.math.BigDecimal;
import java.util.List;

import nju.software.fyrs.data.dataobject.RysxJzzw;

import org.hibernate.LockMode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

/**
 	* A data access object (DAO) providing persistence and search support for RysxJzzw entities.
 			* Transaction control of the save(), update() and delete() operations 
		can directly support Spring container-managed transactions or they can be augmented	to handle user-managed Spring transactions. 
		Each of these methods provides additional information for how to configure it for the desired type of transaction control. 	
	 * @see nju.software.fyrs.data.dataobject.RysxJzzw
  * @author MyEclipse Persistence Tools 
 */
public class RysxJzzwDAO extends HibernateDaoSupport  {
	     private static final Logger log = LoggerFactory.getLogger(RysxJzzwDAO.class);
		//property constants
	public static final String _NRMLB = "NRmlb";
	public static final String _CJRZW = "CJrzw";
	public static final String _CDW = "CDw";
	public static final String _CBM = "CBm";
	public static final String _NRMYY = "NRmyy";
	public static final String _CPZDW = "CPzdw";
	public static final String _CPZWH = "CPzwh";
	public static final String _NDQXX = "NDqxx";
	public static final String _NTBJL = "NTbjl";
	public static final String _CJLID = "CJlid";
	public static final String _NXSSX = "NXssx";



	protected void initDao() {
		//do nothing
	}
    
    public void save(RysxJzzw transientInstance) {
        log.debug("saving RysxJzzw instance");
        try {
            getHibernateTemplate().save(transientInstance);
            log.debug("save successful");
        } catch (RuntimeException re) {
            log.error("save failed", re);
            throw re;
        }
    }
    
	public void delete(RysxJzzw persistentInstance) {
        log.debug("deleting RysxJzzw instance");
        try {
            getHibernateTemplate().delete(persistentInstance);
            log.debug("delete successful");
        } catch (RuntimeException re) {
            log.error("delete failed", re);
            throw re;
        }
    }
    
    public RysxJzzw findById( nju.software.fyrs.data.dataobject.RysxJzzwId id) {
        log.debug("getting RysxJzzw instance with id: " + id);
        try {
            RysxJzzw instance = (RysxJzzw) getHibernateTemplate()
                    .get("software.fyrs.data.RysxJzzw", id);
            return instance;
        } catch (RuntimeException re) {
            log.error("get failed", re);
            throw re;
        }
    }
    
    
    @SuppressWarnings("unchecked")
	public List<RysxJzzw> findByExample(RysxJzzw instance) {
        log.debug("finding RysxJzzw instance by example");
        try {
            List<RysxJzzw> results = (List<RysxJzzw>) getHibernateTemplate().findByExample(instance); 
            log.debug("find by example successful, result size: " + results.size());
            return results;
        } catch (RuntimeException re) {
            log.error("find by example failed", re);
            throw re;
        }
    }    
    
    @SuppressWarnings("rawtypes")
	public List findByProperty(String propertyName, Object value) {
      log.debug("finding RysxJzzw instance with property: " + propertyName
            + ", value: " + value);
      try {
         String queryString = "from RysxJzzw as model where model." 
         						+ propertyName + "= ?";
		 return getHibernateTemplate().find(queryString, value);
      } catch (RuntimeException re) {
         log.error("find by property name failed", re);
         throw re;
      }
	}

	@SuppressWarnings("unchecked")
	public List<RysxJzzw> findByNRmlb(Object NRmlb
	) {
		return findByProperty(_NRMLB, NRmlb
		);
	}
	
	@SuppressWarnings("unchecked")
	public List<RysxJzzw> findByCJrzw(Object CJrzw
	) {
		return findByProperty(_CJRZW, CJrzw
		);
	}
	
	@SuppressWarnings("unchecked")
	public List<RysxJzzw> findByCDw(Object CDw
	) {
		return findByProperty(_CDW, CDw
		);
	}
	
	@SuppressWarnings("unchecked")
	public List<RysxJzzw> findByCBm(Object CBm
	) {
		return findByProperty(_CBM, CBm
		);
	}
	
	@SuppressWarnings("unchecked")
	public List<RysxJzzw> findByNRmyy(Object NRmyy
	) {
		return findByProperty(_NRMYY, NRmyy
		);
	}
	
	@SuppressWarnings("unchecked")
	public List<RysxJzzw> findByCPzdw(Object CPzdw
	) {
		return findByProperty(_CPZDW, CPzdw
		);
	}
	
	@SuppressWarnings("unchecked")
	public List<RysxJzzw> findByCPzwh(Object CPzwh
	) {
		return findByProperty(_CPZWH, CPzwh
		);
	}
	
	@SuppressWarnings("unchecked")
	public List<RysxJzzw> findByNDqxx(Object NDqxx
	) {
		return findByProperty(_NDQXX, NDqxx
		);
	}
	
	@SuppressWarnings("unchecked")
	public List<RysxJzzw> findByNTbjl(Object NTbjl
	) {
		return findByProperty(_NTBJL, NTbjl
		);
	}
	
	@SuppressWarnings("unchecked")
	public List<RysxJzzw> findByCJlid(Object CJlid
	) {
		return findByProperty(_CJLID, CJlid
		);
	}
	
	@SuppressWarnings("unchecked")
	public List<RysxJzzw> findByNXssx(Object NXssx
	) {
		return findByProperty(_NXSSX, NXssx
		);
	}
	

	@SuppressWarnings("rawtypes")
	public List findAll() {
		log.debug("finding all RysxJzzw instances");
		try {
			String queryString = "from RysxJzzw";
		 	return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}
	
    public RysxJzzw merge(RysxJzzw detachedInstance) {
        log.debug("merging RysxJzzw instance");
        try {
            RysxJzzw result = (RysxJzzw) getHibernateTemplate()
                    .merge(detachedInstance);
            log.debug("merge successful");
            return result;
        } catch (RuntimeException re) {
            log.error("merge failed", re);
            throw re;
        }
    }

    public void attachDirty(RysxJzzw instance) {
        log.debug("attaching dirty RysxJzzw instance");
        try {
            getHibernateTemplate().saveOrUpdate(instance);
            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }
    
    public void attachClean(RysxJzzw instance) {
        log.debug("attaching clean RysxJzzw instance");
        try {
            getHibernateTemplate().lock(instance, LockMode.NONE);
            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }

	public static RysxJzzwDAO getFromApplicationContext(ApplicationContext ctx) {
    	return (RysxJzzwDAO) ctx.getBean("RysxJzzwDAO");
	}
	
	@SuppressWarnings("unchecked")
	public List<RysxJzzw> getJrzwByRybh(String rybh){
		int nrybh = Integer.parseInt(rybh);
		String hql = "from RysxJzzw where NRybh=?";
		List<RysxJzzw> listRysxJrzw = getHibernateTemplate().find(hql,nrybh);
		return listRysxJrzw;
	}
	
	public RysxJzzw getRsJrzwById(String id,String fydm,String rybh){
		String hql = "from RysxJzzw where NId=? and NFy=? and NRybh=?";
		BigDecimal bigDecimal = new BigDecimal(id);
		return (RysxJzzw)getSession().createQuery(hql).setParameter(0,bigDecimal).setParameter(1,Integer.valueOf(fydm)).setParameter(2, Integer.valueOf(rybh)).uniqueResult();
	}
	
	@SuppressWarnings("unchecked")
	public boolean delRsJrzwById(String rybh,String bh){
		int nrybh = Integer.parseInt(rybh);
		BigDecimal bd = new BigDecimal(bh);
		String hql = "from RysxJzzw where NRybh=? and NId=?";
		List<RysxJzzw> listRysxJzzw = getHibernateTemplate().find(hql,nrybh,bd);
		if(listRysxJzzw==null||listRysxJzzw.size()==0){
			return false;
		}else{
			RysxJzzw rysxjrzw = listRysxJzzw.get(0);
			getHibernateTemplate().delete(rysxjrzw);
			return true;
		}
	}
	
	public boolean updateRsJrzw(RysxJzzw rysxJzzw){
		if(rysxJzzw==null){
			return false;
		}else{
			getHibernateTemplate().update(rysxJzzw);
			return true;
		}
	}
	
	public boolean interceptAddJrzw(RysxJzzw rysxJzzw){
		try
		{
			getSession().save(rysxJzzw);
			getSession().flush();
			return false;
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
			return false;
		}
		
	}
	
	public boolean interceptUpdateJrzw(RysxJzzw rysxJzzw){
		try
		{
			getSession().update(rysxJzzw);
			getSession().flush();
			return true;
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
			return false;
		}
		
	}
	
	public boolean interceptDeleteRsJrzwById(RysxJzzw rysxJzzw){
		try
		{
			getSession().delete(rysxJzzw);
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
	public List<RysxJzzw> getJrzwByRybhFy(int rybh,int fydm){
		return getSession().createQuery("from RysxJzzw rk where rk.NFy=? and rk.NRybh=?").setParameter(0,Integer.valueOf(fydm)).setParameter(1,Integer.valueOf(rybh)).list();
	}
	
	public RysxJzzw findByFyRybhId(int fy,int rybh,BigDecimal id)
	{
	   return (RysxJzzw)getSession().createQuery("from RysxJzzw rk where rk.NFy = ? and rk.NRybh = ? and rk.NId = ? ").setParameter(0,fy).setParameter(1, rybh).setParameter(2,id).uniqueResult();	
	}
	public BigDecimal getMaxNid(int fydm)
	{
		String hql = "select max(N_ID) from T_RYSX_JZZW";
		return DaoUtils.getMaxIdRyjbxx(getSession(), fydm, hql);
		
	}


}