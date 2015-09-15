package nju.software.fyrs.data.dao;

import java.math.BigDecimal;
import java.util.List;

import nju.software.fyrs.data.dataobject.RysxZjbg;

import org.hibernate.LockMode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

/**
 	* A data access object (DAO) providing persistence and search support for RysxZjbg entities.
 			* Transaction control of the save(), update() and delete() operations 
		can directly support Spring container-managed transactions or they can be augmented	to handle user-managed Spring transactions. 
		Each of these methods provides additional information for how to configure it for the desired type of transaction control. 	
	 * @see nju.software.fyrs.data.dataobject.RysxZjbg
  * @author MyEclipse Persistence Tools 
 */
public class RysxZjbdDAO extends HibernateDaoSupport  {
	     private static final Logger log = LoggerFactory.getLogger(RysxZjbdDAO.class);
	


	protected void initDao() {
		//do nothing
	}
    
    public void save(RysxZjbg transientInstance) {
        log.debug("saving RysxZjbg instance");
        try {
            getHibernateTemplate().save(transientInstance);
            log.debug("save successful");
        } catch (RuntimeException re) {
            log.error("save failed", re);
            throw re;
        }
    }
    
	public void delete(RysxZjbg persistentInstance) {
        log.debug("deleting RysxZjbg instance");
        try {
            getHibernateTemplate().delete(persistentInstance);
            log.debug("delete successful");
        } catch (RuntimeException re) {
            log.error("delete failed", re);
            throw re;
        }
    }
    
   
    
    
    @SuppressWarnings("unchecked")
	public List<RysxZjbg> findByExample(RysxZjbg instance) {
        log.debug("finding RysxZjbg instance by example");
        try {
            List<RysxZjbg> results = (List<RysxZjbg>) getHibernateTemplate().findByExample(instance); 
            log.debug("find by example successful, result size: " + results.size());
            return results;
        } catch (RuntimeException re) {
            log.error("find by example failed", re);
            throw re;
        }
    }    
    
    @SuppressWarnings("rawtypes")
	public List findByProperty(String propertyName, Object value) {
      log.debug("finding RysxZjbg instance with property: " + propertyName
            + ", value: " + value);
      try {
         String queryString = "from RysxZjbg as model where model." 
         						+ propertyName + "= ?";
		 return getHibernateTemplate().find(queryString, value);
      } catch (RuntimeException re) {
         log.error("find by property name failed", re);
         throw re;
      }
	}


	

	@SuppressWarnings("rawtypes")
	public List findAll() {
		log.debug("finding all RysxZjbg instances");
		try {
			String queryString = "from RysxZjbg";
		 	return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}
	
    public RysxZjbg merge(RysxZjbg detachedInstance) {
        log.debug("merging RysxZjbg instance");
        try {
            RysxZjbg result = (RysxZjbg) getHibernateTemplate()
                    .merge(detachedInstance);
            log.debug("merge successful");
            return result;
        } catch (RuntimeException re) {
            log.error("merge failed", re);
            throw re;
        }
    }

    public void attachDirty(RysxZjbg instance) {
        log.debug("attaching dirty RysxZjbg instance");
        try {
            getHibernateTemplate().saveOrUpdate(instance);
            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }
    
    public void attachClean(RysxZjbg instance) {
        log.debug("attaching clean RysxZjbg instance");
        try {
            getHibernateTemplate().lock(instance, LockMode.NONE);
            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }

	public static RysxZjbdDAO getFromApplicationContext(ApplicationContext ctx) {
    	return (RysxZjbdDAO) ctx.getBean("RysxZjbdDAO");
	}
	
	@SuppressWarnings("unchecked")
	public List<RysxZjbg> getZjbgByRybh(String rybh){
		int nrybh = Integer.parseInt(rybh);
		String hql = "from RysxZjbg where NRybh=?";
		List<RysxZjbg> listZjbg = getHibernateTemplate().find(hql,nrybh);
		return listZjbg;
		
	}
	
	public RysxZjbg getRsZjbgById(String id,String fydm,String rybh){
		String hql = "from RysxZjbg where NId=? and NFy=? and NRybh=?";
		BigDecimal bigDecimal = new BigDecimal(id);
		return (RysxZjbg)getSession().createQuery(hql).setParameter(0,bigDecimal).setParameter(1,Integer.valueOf(fydm)).setParameter(2, Integer.valueOf(rybh)).uniqueResult();
	}
	
	@SuppressWarnings("unchecked")
	public boolean delRsZjbgById(String rybh,String bh){
		int nrybh = Integer.parseInt(rybh);
		BigDecimal bd = new BigDecimal(bh);
		String hql = "from RysxZjbg where NRybh=? and NId=?";
		List<RysxZjbg> listZjbg = getHibernateTemplate().find(hql,nrybh,bd);
		if(listZjbg==null||listZjbg.size()==0){
			return false;
		}else{
			RysxZjbg rysxzjbd = listZjbg.get(0);
			getHibernateTemplate().delete(rysxzjbd);
			return true;
		}
	}
	
	public boolean updateRsZjbg(RysxZjbg rysxzjbd){
		if(rysxzjbd==null){
			return false;
		}else{
			getHibernateTemplate().update(rysxzjbd);
			return true;
		}
	}
	
	public boolean interceptAddZjbg(RysxZjbg rysxZjbg){
		try
		{
			getSession().save(rysxZjbg);
			getSession().flush();
			return true;
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
			return false;
		}
		
	}
	
	public boolean interceptUpdateZjbg(RysxZjbg rysxZjbg){
		try
		{
			getSession().update(rysxZjbg);
			getSession().flush();
			return true;
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
			return false;
		}
		
	}
	
	public boolean interceptDeleteZjbgById(RysxZjbg rysxZjbg){
		try
		{
			getSession().delete(rysxZjbg);
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
	public List<RysxZjbg> getZjbgByRybhFy(int rybh,int fydm){
		return getSession().createQuery("from RysxZjbg rj where rj.NFy=? and rj.NRybh=?").setParameter(0,Integer.valueOf(fydm)).setParameter(1,Integer.valueOf(rybh)).list();
	}
	
	public RysxZjbg findByFyRybhId(int fy,int rybh,BigDecimal id)
	{
	   return (RysxZjbg)getSession().createQuery("from RysxZjbg rj where rj.NFy = ? and rj.NRybh = ? and rj.NId = ? ").setParameter(0,fy).setParameter(1, rybh).setParameter(2,id).uniqueResult();	
	}
	public BigDecimal getMaxNid(int fydm)
	{
		String hql = "select max(N_ID) from T_RYSX_ZJBD";
		return DaoUtils.getMaxIdRyjbxx(getSession(), fydm, hql);
		
	}
}