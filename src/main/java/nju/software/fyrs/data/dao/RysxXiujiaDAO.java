package nju.software.fyrs.data.dao;

import java.math.BigDecimal;
import java.util.List;

import nju.software.fyrs.data.dataobject.RysxXiujia;

import org.hibernate.LockMode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

/**
 	* A data access object (DAO) providing persistence and search support for RysxXiujia entities.
 			* Transaction control of the save(), update() and delete() operations 
		can directly support Spring container-managed transactions or they can be augmented	to handle user-managed Spring transactions. 
		Each of these methods provides additional information for how to configure it for the desired type of transaction control. 	
	 * @see nju.software.fyrs.data.dataobject.RysxXiujia
  * @author MyEclipse Persistence Tools 
 */
public class RysxXiujiaDAO extends HibernateDaoSupport  {
	     private static final Logger log = LoggerFactory.getLogger(RysxXiujiaDAO.class);
	


	protected void initDao() {
		//do nothing
	}
    
    public void save(RysxXiujia transientInstance) {
        log.debug("saving RysxXiujia instance");
        try {
            getHibernateTemplate().save(transientInstance);
            log.debug("save successful");
        } catch (RuntimeException re) {
            log.error("save failed", re);
            throw re;
        }
    }
    
	public void delete(RysxXiujia persistentInstance) {
        log.debug("deleting RysxXiujia instance");
        try {
            getHibernateTemplate().delete(persistentInstance);
            log.debug("delete successful");
        } catch (RuntimeException re) {
            log.error("delete failed", re);
            throw re;
        }
    }
    
   
    
    
    @SuppressWarnings("unchecked")
	public List<RysxXiujia> findByExample(RysxXiujia instance) {
        log.debug("finding RysxXiujia instance by example");
        try {
            List<RysxXiujia> results = (List<RysxXiujia>) getHibernateTemplate().findByExample(instance); 
            log.debug("find by example successful, result size: " + results.size());
            return results;
        } catch (RuntimeException re) {
            log.error("find by example failed", re);
            throw re;
        }
    }    
    
    @SuppressWarnings("rawtypes")
	public List findByProperty(String propertyName, Object value) {
      log.debug("finding RysxXiujia instance with property: " + propertyName
            + ", value: " + value);
      try {
         String queryString = "from RysxXiujia as model where model." 
         						+ propertyName + "= ?";
		 return getHibernateTemplate().find(queryString, value);
      } catch (RuntimeException re) {
         log.error("find by property name failed", re);
         throw re;
      }
	}


	

	@SuppressWarnings("rawtypes")
	public List findAll() {
		log.debug("finding all RysxXiujia instances");
		try {
			String queryString = "from RysxXiujia";
		 	return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}
	
    public RysxXiujia merge(RysxXiujia detachedInstance) {
        log.debug("merging RysxXiujia instance");
        try {
            RysxXiujia result = (RysxXiujia) getHibernateTemplate()
                    .merge(detachedInstance);
            log.debug("merge successful");
            return result;
        } catch (RuntimeException re) {
            log.error("merge failed", re);
            throw re;
        }
    }

    public void attachDirty(RysxXiujia instance) {
        log.debug("attaching dirty RysxXiujia instance");
        try {
            getHibernateTemplate().saveOrUpdate(instance);
            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }
    
    public void attachClean(RysxXiujia instance) {
        log.debug("attaching clean RysxXiujia instance");
        try {
            getHibernateTemplate().lock(instance, LockMode.NONE);
            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }

	public static RysxXiujiaDAO getFromApplicationContext(ApplicationContext ctx) {
    	return (RysxXiujiaDAO) ctx.getBean("RysxXiujiaDAO");
	}
	
	@SuppressWarnings("unchecked")
	public List<RysxXiujia> getXiujiaByRybh(String rybh){
		int nrybh = Integer.parseInt(rybh);
		String hql = "from RysxXiujia where NRybh=?";
		List<RysxXiujia> listXiujia = getHibernateTemplate().find(hql,nrybh);
		return listXiujia;
		
	}
	
	public RysxXiujia getRsXiujiaById(String id,String fydm,String rybh){
		String hql = "from RysxXiujia where NId=? and NFy=? and NRybh=?";
		BigDecimal bigDecimal = new BigDecimal(id);
		return (RysxXiujia)getSession().createQuery(hql).setParameter(0,bigDecimal).setParameter(1,Integer.valueOf(fydm)).setParameter(2, Integer.valueOf(rybh)).uniqueResult();
	}
	
	@SuppressWarnings("unchecked")
	public boolean delRsXiujiaById(String rybh,String bh){
		int nrybh = Integer.parseInt(rybh);
		BigDecimal bd = new BigDecimal(bh);
		String hql = "from RysxXiujia where NRybh=? and NId=?";
		List<RysxXiujia> listXiujia = getHibernateTemplate().find(hql,nrybh,bd);
		if(listXiujia==null||listXiujia.size()==0){
			return false;
		}else{
			RysxXiujia rysxxiujia = listXiujia.get(0);
			getHibernateTemplate().delete(rysxxiujia);
			return true;
		}
	}
	
	public boolean updateRsXiujia(RysxXiujia rysxxiujia){
		if(rysxxiujia==null){
			return false;
		}else{
			getHibernateTemplate().update(rysxxiujia);
			return true;
		}
	}
	
	public boolean interceptAddXiujia(RysxXiujia rysxXiujia){
		try
		{
			getSession().save(rysxXiujia);
			getSession().flush();
			return true;
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
			return false;
		}
		
	}
	
	public boolean interceptUpdateXiujia(RysxXiujia rysxXiujia){
		try
		{
			getSession().update(rysxXiujia);
			getSession().flush();
			return true;
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
			return false;
		}
		
	}
	
	public boolean interceptDeleteXiujiaById(RysxXiujia rysxXiujia){
		try
		{
			getSession().delete(rysxXiujia);
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
	public List<RysxXiujia> getXiujiaByRybhFy(int rybh,int fydm){
		return getSession().createQuery("from RysxXiujia rj where rj.NFy=? and rj.NRybh=?").setParameter(0,Integer.valueOf(fydm)).setParameter(1,Integer.valueOf(rybh)).list();
	}
	
	public RysxXiujia findByFyRybhId(int fy,int rybh,BigDecimal id)
	{
	   return (RysxXiujia)getSession().createQuery("from RysxXiujia rj where rj.NFy = ? and rj.NRybh = ? and rj.NId = ? ").setParameter(0,fy).setParameter(1, rybh).setParameter(2,id).uniqueResult();	
	}
	public BigDecimal getMaxNid(int fydm)
	{
		String hql = "select max(N_ID) from T_RYSX_XIUJIA";
		return DaoUtils.getMaxIdRyjbxx(getSession(), fydm, hql);
		
	}
}