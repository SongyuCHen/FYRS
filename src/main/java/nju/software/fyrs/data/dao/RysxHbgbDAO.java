package nju.software.fyrs.data.dao;

import java.math.BigDecimal;
import java.util.List;

import nju.software.fyrs.data.dataobject.RysxHbgb;

import org.hibernate.LockMode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

/**
 	* A data access object (DAO) providing persistence and search support for RysxHbgb entities.
 			* Transaction control of the save(), update() and delete() operations 
		can directly support Spring container-managed transactions or they can be augmented	to handle user-managed Spring transactions. 
		Each of these methods provides additional information for how to configure it for the desired type of transaction control. 	
	 * @see nju.software.fyrs.data.dataobject.RysxHbgb
  * @author MyEclipse Persistence Tools 
 */
public class RysxHbgbDAO extends HibernateDaoSupport  {
	     private static final Logger log = LoggerFactory.getLogger(RysxHbgbDAO.class);
		//property constants
	public static final String _NHBZW = "NHbzw";
	public static final String _NDLZW = "NDlzw";
	public static final String _CDLDW = "CDldw";
	public static final String _CJL = "CJl";
	public static final String _NXSSX = "NXssx";



	protected void initDao() {
		//do nothing
	}
    
    public void save(RysxHbgb transientInstance) {
        log.debug("saving RysxHbgb instance");
        try {
            getHibernateTemplate().save(transientInstance);
            log.debug("save successful");
        } catch (RuntimeException re) {
            log.error("save failed", re);
            throw re;
        }
    }
    
	public void delete(RysxHbgb persistentInstance) {
        log.debug("deleting RysxHbgb instance");
        try {
            getHibernateTemplate().delete(persistentInstance);
            log.debug("delete successful");
        } catch (RuntimeException re) {
            log.error("delete failed", re);
            throw re;
        }
    }
    
    public RysxHbgb findById( nju.software.fyrs.data.dataobject.RysxHbgbId id) {
        log.debug("getting RysxHbgb instance with id: " + id);
        try {
            RysxHbgb instance = (RysxHbgb) getHibernateTemplate()
                    .get("software.fyrs.data.RysxHbgb", id);
            return instance;
        } catch (RuntimeException re) {
            log.error("get failed", re);
            throw re;
        }
    }
    
    
    @SuppressWarnings("unchecked")
	public List<RysxHbgb> findByExample(RysxHbgb instance) {
        log.debug("finding RysxHbgb instance by example");
        try {
            List<RysxHbgb> results = (List<RysxHbgb>) getHibernateTemplate().findByExample(instance); 
            log.debug("find by example successful, result size: " + results.size());
            return results;
        } catch (RuntimeException re) {
            log.error("find by example failed", re);
            throw re;
        }
    }    
    
    @SuppressWarnings("rawtypes")
	public List findByProperty(String propertyName, Object value) {
      log.debug("finding RysxHbgb instance with property: " + propertyName
            + ", value: " + value);
      try {
         String queryString = "from RysxHbgb as model where model." 
         						+ propertyName + "= ?";
		 return getHibernateTemplate().find(queryString, value);
      } catch (RuntimeException re) {
         log.error("find by property name failed", re);
         throw re;
      }
	}

	@SuppressWarnings("unchecked")
	public List<RysxHbgb> findByNHbzw(Object NHbzw
	) {
		return findByProperty(_NHBZW, NHbzw
		);
	}
	
	@SuppressWarnings("unchecked")
	public List<RysxHbgb> findByNDlzw(Object NDlzw
	) {
		return findByProperty(_NDLZW, NDlzw
		);
	}
	
	@SuppressWarnings("unchecked")
	public List<RysxHbgb> findByCDldw(Object CDldw
	) {
		return findByProperty(_CDLDW, CDldw
		);
	}
	
	@SuppressWarnings("unchecked")
	public List<RysxHbgb> findByCJl(Object CJl
	) {
		return findByProperty(_CJL, CJl
		);
	}
	
	@SuppressWarnings("unchecked")
	public List<RysxHbgb> findByNXssx(Object NXssx
	) {
		return findByProperty(_NXSSX, NXssx
		);
	}
	

	@SuppressWarnings("rawtypes")
	public List findAll() {
		log.debug("finding all RysxHbgb instances");
		try {
			String queryString = "from RysxHbgb";
		 	return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}
	
    public RysxHbgb merge(RysxHbgb detachedInstance) {
        log.debug("merging RysxHbgb instance");
        try {
            RysxHbgb result = (RysxHbgb) getHibernateTemplate()
                    .merge(detachedInstance);
            log.debug("merge successful");
            return result;
        } catch (RuntimeException re) {
            log.error("merge failed", re);
            throw re;
        }
    }

    public void attachDirty(RysxHbgb instance) {
        log.debug("attaching dirty RysxHbgb instance");
        try {
            getHibernateTemplate().saveOrUpdate(instance);
            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }
    
    public void attachClean(RysxHbgb instance) {
        log.debug("attaching clean RysxHbgb instance");
        try {
            getHibernateTemplate().lock(instance, LockMode.NONE);
            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }

	public static RysxHbgbDAO getFromApplicationContext(ApplicationContext ctx) {
    	return (RysxHbgbDAO) ctx.getBean("RysxHbgbDAO");
	}
	
	@SuppressWarnings("unchecked")
	public List<RysxHbgb> getHbgbByRybh(String rybh){
		int nrybh = Integer.parseInt(rybh);
		String hql = "from RysxHbgb where NRybh=?";
		List<RysxHbgb> listRysxHbgb = getHibernateTemplate().find(hql,nrybh);
		return listRysxHbgb;
	}
	
	public RysxHbgb getRsHbgbById(String id,String fydm,String rybh){
		String hql = "from RysxHbgb where NId=? and NFy=? and NRybh=?";
		BigDecimal bigDecimal = new BigDecimal(id);
		return (RysxHbgb)getSession().createQuery(hql).setParameter(0,bigDecimal).setParameter(1,Integer.valueOf(fydm)).setParameter(2, Integer.valueOf(rybh)).uniqueResult();
	}
	
	@SuppressWarnings("unchecked")
	public boolean delRsHbgbById(String rybh,String bh){
		int nrybh = Integer.parseInt(rybh);
		BigDecimal bd = new BigDecimal(bh);
		String hql = "from RysxHbgb where NRybh=? and NId=?";
		List<RysxHbgb> listRysxHbgb = getHibernateTemplate().find(hql,nrybh,bd);
		if(listRysxHbgb==null||listRysxHbgb.size()==0){
			return false;
		}else{
			RysxHbgb rysxHbgb = listRysxHbgb.get(0);
			getHibernateTemplate().delete(rysxHbgb);
			return true;
		}
	}
	
	public boolean updateRsHbgb(RysxHbgb rysxHbgb){
		if(rysxHbgb==null){
			return false;
		}else{
			getHibernateTemplate().update(rysxHbgb);
			return true;
		}
	}
	
	public boolean interceptAddHbgb(RysxHbgb rysxHbgb){
		try
		{
			getSession().save(rysxHbgb);
			getSession().flush();
			return true;
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
			return false;
		}
		
	}
	
	public boolean interceptUpdateHbgb(RysxHbgb rysxHbgb){
		try
		{
			getSession().update(rysxHbgb);
			getSession().flush();
			return true;
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
			return false;
		}
		
	}
	
	public boolean interceptDeleteRsHbgbById(RysxHbgb rysxHbgb){
		try
		{
			getSession().delete(rysxHbgb);
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
	public List<RysxHbgb> getHbgbByRybhFy(int rybh,int fydm){
		return getSession().createQuery("from RysxHbgb rj where rj.NFy=? and rj.NRybh=?").setParameter(0,Integer.valueOf(fydm)).setParameter(1,Integer.valueOf(rybh)).list();
	}
	
	public RysxHbgb findByFyRybhId(int fy,int rybh,BigDecimal id)
	{
	   return (RysxHbgb)getSession().createQuery("from RysxHbgb rj where rj.NFy = ? and rj.NRybh = ? and rj.NId = ? ").setParameter(0,fy).setParameter(1, rybh).setParameter(2,id).uniqueResult();	
	}
	public BigDecimal getMaxNid(int fydm)
	{
		String hql = "select max(N_ID) from T_RYSX_HBGB";
		return DaoUtils.getMaxIdRyjbxx(getSession(), fydm, hql);
		
	}
}