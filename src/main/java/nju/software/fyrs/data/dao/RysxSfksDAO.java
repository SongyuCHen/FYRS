package nju.software.fyrs.data.dao;

import java.math.BigDecimal;
import java.util.List;

import nju.software.fyrs.data.dataobject.RysxSfks;

import org.hibernate.LockMode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

/**
 	* A data access object (DAO) providing persistence and search support for RysxSfks entities.
 			* Transaction control of the save(), update() and delete() operations 
		can directly support Spring container-managed transactions or they can be augmented	to handle user-managed Spring transactions. 
		Each of these methods provides additional information for how to configure it for the desired type of transaction control. 	
	 * @see nju.software.fyrs.data.dataobject.RysxSfks
  * @author MyEclipse Persistence Tools 
 */
public class RysxSfksDAO extends HibernateDaoSupport  {
	     private static final Logger log = LoggerFactory.getLogger(RysxSfksDAO.class);
		//property constants
	public static final String _NZSLX = "NZslx";
	public static final String _CZSBH = "CZsbh";
	public static final String _NXSSX = "NXssx";



	protected void initDao() {
		//do nothing
	}
    
    public void save(RysxSfks transientInstance) {
        log.debug("saving RysxSfks instance");
        try {
            getHibernateTemplate().save(transientInstance);
            log.debug("save successful");
        } catch (RuntimeException re) {
            log.error("save failed", re);
            throw re;
        }
    }
    
	public void delete(RysxSfks persistentInstance) {
        log.debug("deleting RysxSfks instance");
        try {
            getHibernateTemplate().delete(persistentInstance);
            log.debug("delete successful");
        } catch (RuntimeException re) {
            log.error("delete failed", re);
            throw re;
        }
    }
    
    public RysxSfks findById( nju.software.fyrs.data.dataobject.RysxSfksId id) {
        log.debug("getting RysxSfks instance with id: " + id);
        try {
            RysxSfks instance = (RysxSfks) getHibernateTemplate()
                    .get("software.fyrs.data.RysxSfks", id);
            return instance;
        } catch (RuntimeException re) {
            log.error("get failed", re);
            throw re;
        }
    }
    
    
    @SuppressWarnings("unchecked")
	public List<RysxSfks> findByExample(RysxSfks instance) {
        log.debug("finding RysxSfks instance by example");
        try {
            List<RysxSfks> results = (List<RysxSfks>) getHibernateTemplate().findByExample(instance); 
            log.debug("find by example successful, result size: " + results.size());
            return results;
        } catch (RuntimeException re) {
            log.error("find by example failed", re);
            throw re;
        }
    }    
    
    @SuppressWarnings("rawtypes")
	public List findByProperty(String propertyName, Object value) {
      log.debug("finding RysxSfks instance with property: " + propertyName
            + ", value: " + value);
      try {
         String queryString = "from RysxSfks as model where model." 
         						+ propertyName + "= ?";
		 return getHibernateTemplate().find(queryString, value);
      } catch (RuntimeException re) {
         log.error("find by property name failed", re);
         throw re;
      }
	}

	@SuppressWarnings("unchecked")
	public List<RysxSfks> findByNZslx(Object NZslx
	) {
		return findByProperty(_NZSLX, NZslx
		);
	}
	
	@SuppressWarnings("unchecked")
	public List<RysxSfks> findByCZsbh(Object CZsbh
	) {
		return findByProperty(_CZSBH, CZsbh
		);
	}
	
	@SuppressWarnings("unchecked")
	public List<RysxSfks> findByNXssx(Object NXssx
	) {
		return findByProperty(_NXSSX, NXssx
		);
	}
	

	@SuppressWarnings("rawtypes")
	public List findAll() {
		log.debug("finding all RysxSfks instances");
		try {
			String queryString = "from RysxSfks";
		 	return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}
	
    public RysxSfks merge(RysxSfks detachedInstance) {
        log.debug("merging RysxSfks instance");
        try {
            RysxSfks result = (RysxSfks) getHibernateTemplate()
                    .merge(detachedInstance);
            log.debug("merge successful");
            return result;
        } catch (RuntimeException re) {
            log.error("merge failed", re);
            throw re;
        }
    }

    public void attachDirty(RysxSfks instance) {
        log.debug("attaching dirty RysxSfks instance");
        try {
            getHibernateTemplate().saveOrUpdate(instance);
            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }
    
    public void attachClean(RysxSfks instance) {
        log.debug("attaching clean RysxSfks instance");
        try {
            getHibernateTemplate().lock(instance, LockMode.NONE);
            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }

	public static RysxSfksDAO getFromApplicationContext(ApplicationContext ctx) {
    	return (RysxSfksDAO) ctx.getBean("RysxSfksDAO");
	}
	
	@SuppressWarnings("unchecked")
	public List<RysxSfks> getSfksByRybh(String rybh){
		int nrybh = Integer.parseInt(rybh);
		String hql = "from RysxSfks where NRybh=?";
		List<RysxSfks> listRysxSfks = getHibernateTemplate().find(hql,nrybh);
		return listRysxSfks;
	}
	
	public RysxSfks getRsSfksById(String id,String fydm,String rybh){
		String hql = "from RysxSfks where NId=? and NFy=? and NRybh=?";
		BigDecimal bigDecimal = new BigDecimal(id);
		return (RysxSfks)getSession().createQuery(hql).setParameter(0,bigDecimal).setParameter(1,Integer.valueOf(fydm)).setParameter(2, Integer.valueOf(rybh)).uniqueResult();
	}
	
	@SuppressWarnings("unchecked")
	public boolean delRsSfksById(String rybh,String bh){
		int nrybh = Integer.parseInt(rybh);
		BigDecimal bd = new BigDecimal(bh);
		String hql = "from RysxSfks where NRybh=? and NId=?";
		List<RysxSfks> listRysxSfks = getHibernateTemplate().find(hql,nrybh,bd);
		if(listRysxSfks==null||listRysxSfks.size()==0){
			return false;
		}else{
			RysxSfks rysxSfks = listRysxSfks.get(0);
			getHibernateTemplate().delete(rysxSfks);
			return true;
		}
	}
	
	public boolean updateRsSfks(RysxSfks rysxSfks){
		if(rysxSfks==null){
			return false;
		}else{
			getHibernateTemplate().update(rysxSfks);
			return true;
		}
	}
	
	public boolean interceptAddSfks(RysxSfks rysxSfks){
		try
		{
			getSession().save(rysxSfks);
			getSession().flush();
			return true;
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
			return false;
		}
		
	}
	
	public boolean interceptUpdateSfks(RysxSfks rysxSfks){
		try
		{
			getSession().update(rysxSfks);
			getSession().flush();
			return true;
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
			return false;
		}
		
	}
	
	public boolean interceptDeleteRsSfksById(RysxSfks rysxSfks){
		try
		{
			getSession().delete(rysxSfks);
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
	public List<RysxSfks> getSfksByRybhFy(int rybh,int fydm){
		return getSession().createQuery("from RysxSfks rs where rs.NFy=? and rs.NRybh=?").setParameter(0,Integer.valueOf(fydm)).setParameter(1,Integer.valueOf(rybh)).list();
	}
	
	public RysxSfks findByFyRybhId(int fy,int rybh,BigDecimal id)
	{
	   return (RysxSfks)getSession().createQuery("from RysxSfks rs where rs.NFy = ? and rs.NRybh = ? and rs.NId = ? ").setParameter(0,fy).setParameter(1, rybh).setParameter(2,id).uniqueResult();	
	}
	public BigDecimal getMaxNid(int fydm)
	{
		String hql = "select max(N_ID) from T_RYSX_SFKS";
		return DaoUtils.getMaxIdRyjbxx(getSession(), fydm, hql);
		
	}
}