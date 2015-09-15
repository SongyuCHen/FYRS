package nju.software.fyrs.data.dao;

import java.math.BigDecimal;
import java.util.List;

import nju.software.fyrs.data.dataobject.RysxGwy;

import org.hibernate.LockMode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

/**
 	* A data access object (DAO) providing persistence and search support for RysxGwy entities.
 			* Transaction control of the save(), update() and delete() operations 
		can directly support Spring container-managed transactions or they can be augmented	to handle user-managed Spring transactions. 
		Each of these methods provides additional information for how to configure it for the desired type of transaction control. 	
	 * @see nju.software.fyrs.data.dataobject.RysxGwy
  * @author MyEclipse Persistence Tools 
 */
public class RysxGwyDAO extends HibernateDaoSupport  {
	     private static final Logger log = LoggerFactory.getLogger(RysxGwyDAO.class);
		//property constants
	public static final String _NGWYJB = "NGwyjb";
	public static final String _CDW = "CDw";
	public static final String _NGZDC = "NGzdc";
	public static final String _NDQXX = "NDqxx";
	public static final String _NXSSX = "NXssx";



	protected void initDao() {
		//do nothing
	}
    
    public void save(RysxGwy transientInstance) {
        log.debug("saving RysxGwy instance");
        try {
            getHibernateTemplate().save(transientInstance);
            log.debug("save successful");
        } catch (RuntimeException re) {
            log.error("save failed", re);
            throw re;
        }
    }
    
	public void delete(RysxGwy persistentInstance) {
        log.debug("deleting RysxGwy instance");
        try {
            getHibernateTemplate().delete(persistentInstance);
            log.debug("delete successful");
        } catch (RuntimeException re) {
            log.error("delete failed", re);
            throw re;
        }
    }
    
    public RysxGwy findById( nju.software.fyrs.data.dataobject.RysxGwyId id) {
        log.debug("getting RysxGwy instance with id: " + id);
        try {
            RysxGwy instance = (RysxGwy) getHibernateTemplate()
                    .get("software.fyrs.data.RysxGwy", id);
            return instance;
        } catch (RuntimeException re) {
            log.error("get failed", re);
            throw re;
        }
    }
    
    
    @SuppressWarnings("unchecked")
	public List<RysxGwy> findByExample(RysxGwy instance) {
        log.debug("finding RysxGwy instance by example");
        try {
            List<RysxGwy> results = (List<RysxGwy>) getHibernateTemplate().findByExample(instance); 
            log.debug("find by example successful, result size: " + results.size());
            return results;
        } catch (RuntimeException re) {
            log.error("find by example failed", re);
            throw re;
        }
    }    
    
    @SuppressWarnings("rawtypes")
	public List findByProperty(String propertyName, Object value) {
      log.debug("finding RysxGwy instance with property: " + propertyName
            + ", value: " + value);
      try {
         String queryString = "from RysxGwy as model where model." 
         						+ propertyName + "= ?";
		 return getHibernateTemplate().find(queryString, value);
      } catch (RuntimeException re) {
         log.error("find by property name failed", re);
         throw re;
      }
	}

	@SuppressWarnings("unchecked")
	public List<RysxGwy> findByNGwyjb(Object NGwyjb
	) {
		return findByProperty(_NGWYJB, NGwyjb
		);
	}
	
	@SuppressWarnings("unchecked")
	public List<RysxGwy> findByCDw(Object CDw
	) {
		return findByProperty(_CDW, CDw
		);
	}
	
	@SuppressWarnings("unchecked")
	public List<RysxGwy> findByNGzdc(Object NGzdc
	) {
		return findByProperty(_NGZDC, NGzdc
		);
	}
	
	@SuppressWarnings("unchecked")
	public List<RysxGwy> findByNDqxx(Object NDqxx
	) {
		return findByProperty(_NDQXX, NDqxx
		);
	}
	
	@SuppressWarnings("unchecked")
	public List<RysxGwy> findByNXssx(Object NXssx
	) {
		return findByProperty(_NXSSX, NXssx
		);
	}
	

	@SuppressWarnings("rawtypes")
	public List findAll() {
		log.debug("finding all RysxGwy instances");
		try {
			String queryString = "from RysxGwy";
		 	return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}
	
    public RysxGwy merge(RysxGwy detachedInstance) {
        log.debug("merging RysxGwy instance");
        try {
            RysxGwy result = (RysxGwy) getHibernateTemplate()
                    .merge(detachedInstance);
            log.debug("merge successful");
            return result;
        } catch (RuntimeException re) {
            log.error("merge failed", re);
            throw re;
        }
    }

    public void attachDirty(RysxGwy instance) {
        log.debug("attaching dirty RysxGwy instance");
        try {
            getHibernateTemplate().saveOrUpdate(instance);
            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }
    
    public void attachClean(RysxGwy instance) {
        log.debug("attaching clean RysxGwy instance");
        try {
            getHibernateTemplate().lock(instance, LockMode.NONE);
            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }

	public static RysxGwyDAO getFromApplicationContext(ApplicationContext ctx) {
    	return (RysxGwyDAO) ctx.getBean("RysxGwyDAO");
	}
	
	@SuppressWarnings("unchecked")
	public List<RysxGwy> getGwyjbByRybh(String rybh){
		int nrybh = Integer.parseInt(rybh);
		String hql = "from RysxGwy where NRybh=?";
		List<RysxGwy> listRysxGwy = getHibernateTemplate().find(hql,nrybh);
		return listRysxGwy;
	}
	
	public RysxGwy getRsGwyjbById(String id,String fydm,String rybh){
		String hql = "from RysxGwy where NId=? and NFy=? and NRybh=?";
		BigDecimal bigDecimal = new BigDecimal(id);
		return (RysxGwy)getSession().createQuery(hql).setParameter(0,bigDecimal).setParameter(1,Integer.valueOf(fydm)).setParameter(2, Integer.valueOf(rybh)).uniqueResult();
	}
	
	@SuppressWarnings("unchecked")
	public boolean delRsGwyjbById(String rybh,String bh){
		int nrybh = Integer.parseInt(rybh);
		BigDecimal bd = new BigDecimal(bh);
		String hql = "from RysxGwy where NRybh=? and NId=?";
		List<RysxGwy> listRysxGwy = getHibernateTemplate().find(hql,nrybh,bd);
		if(listRysxGwy==null||listRysxGwy.size()==0){
			return false;
		}else{
			RysxGwy rysxGwy = listRysxGwy.get(0);
			getHibernateTemplate().delete(rysxGwy);
			return true;
		}
	}
	
	public boolean updateRsGwyjb(RysxGwy rysxGwy){
		if(rysxGwy==null){
			return false;
		}else{
			getHibernateTemplate().update(rysxGwy);
			return true;
		}
	}

	
	public boolean interceptAddGwy(RysxGwy rysxGwy){
		try
		{
			getSession().save(rysxGwy);
			getSession().flush();
			return true;
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
			return false;
		}
		
	}
	
	public boolean interceptUpdateGwy(RysxGwy rysxGwy){
		try
		{
			getSession().update(rysxGwy);
			getSession().flush();
			return true;
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
			return false;
		}
		
	}
	
	public boolean interceptDeleteRsGwyById(RysxGwy rysxGwy){
		try
		{
			getSession().delete(rysxGwy);
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

	public List<RysxGwy> getGwyjbByRybhFy(int fydm,int rybh){
		return getSession().createQuery("from RysxGwy rj where rj.NFy=? and rj.NRybh=?").setParameter(0,Integer.valueOf(fydm)).setParameter(1,Integer.valueOf(rybh)).list();
	}
	
	public RysxGwy findByFyRybhId(int fy,int rybh,BigDecimal id)
	{
	   return (RysxGwy)getSession().createQuery("from RysxGwy rj where rj.NFy = ? and rj.NRybh = ? and rj.NId = ? ").setParameter(0,fy).setParameter(1, rybh).setParameter(2,id).uniqueResult();	
	}
	public BigDecimal getMaxNid(int fydm)
	{
		String hql = "select max(N_ID) from T_RYSX_GWY";
		return DaoUtils.getMaxIdRyjbxx(getSession(), fydm, hql);
		
	}

}