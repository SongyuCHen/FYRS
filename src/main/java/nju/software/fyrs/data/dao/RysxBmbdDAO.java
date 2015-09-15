package nju.software.fyrs.data.dao;

import java.math.BigDecimal;
import java.util.List;

import nju.software.fyrs.data.dataobject.RysxBmbd;

import org.hibernate.LockMode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

/**
 	* A data access object (DAO) providing persistence and search support for RysxBmbd entities.
 			* Transaction control of the save(), update() and delete() operations 
		can directly support Spring container-managed transactions or they can be augmented	to handle user-managed Spring transactions. 
		Each of these methods provides additional information for how to configure it for the desired type of transaction control. 	
	 * @see nju.software.fyrs.data.dataobject.RysxBmbd
  * @author MyEclipse Persistence Tools 
 */
public class RysxBmbdDAO extends HibernateDaoSupport  {
	     private static final Logger log = LoggerFactory.getLogger(RysxBmbdDAO.class);
	


	protected void initDao() {
		//do nothing
	}
    
    public void save(RysxBmbd transientInstance) {
        log.debug("saving RysxBmbd instance");
        try {
            getHibernateTemplate().save(transientInstance);
            log.debug("save successful");
        } catch (RuntimeException re) {
            log.error("save failed", re);
            throw re;
        }
    }
    
	public void delete(RysxBmbd persistentInstance) {
        log.debug("deleting RysxBmbd instance");
        try {
            getHibernateTemplate().delete(persistentInstance);
            log.debug("delete successful");
        } catch (RuntimeException re) {
            log.error("delete failed", re);
            throw re;
        }
    }
    
   
    
    
    @SuppressWarnings("unchecked")
	public List<RysxBmbd> findByExample(RysxBmbd instance) {
        log.debug("finding RysxBmbd instance by example");
        try {
            List<RysxBmbd> results = (List<RysxBmbd>) getHibernateTemplate().findByExample(instance); 
            log.debug("find by example successful, result size: " + results.size());
            return results;
        } catch (RuntimeException re) {
            log.error("find by example failed", re);
            throw re;
        }
    }    
    
    @SuppressWarnings("rawtypes")
	public List findByProperty(String propertyName, Object value) {
      log.debug("finding RysxBmbd instance with property: " + propertyName
            + ", value: " + value);
      try {
         String queryString = "from RysxBmbd as model where model." 
         						+ propertyName + "= ?";
		 return getHibernateTemplate().find(queryString, value);
      } catch (RuntimeException re) {
         log.error("find by property name failed", re);
         throw re;
      }
	}


	

	@SuppressWarnings("rawtypes")
	public List findAll() {
		log.debug("finding all RysxBmbd instances");
		try {
			String queryString = "from RysxBmbd";
		 	return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}
	
    public RysxBmbd merge(RysxBmbd detachedInstance) {
        log.debug("merging RysxBmbd instance");
        try {
            RysxBmbd result = (RysxBmbd) getHibernateTemplate()
                    .merge(detachedInstance);
            log.debug("merge successful");
            return result;
        } catch (RuntimeException re) {
            log.error("merge failed", re);
            throw re;
        }
    }

    public void attachDirty(RysxBmbd instance) {
        log.debug("attaching dirty RysxBmbd instance");
        try {
            getHibernateTemplate().saveOrUpdate(instance);
            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }
    
    public void attachClean(RysxBmbd instance) {
        log.debug("attaching clean RysxBmbd instance");
        try {
            getHibernateTemplate().lock(instance, LockMode.NONE);
            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }

	public static RysxBmbdDAO getFromApplicationContext(ApplicationContext ctx) {
    	return (RysxBmbdDAO) ctx.getBean("RysxBmbdDAO");
	}
	
	@SuppressWarnings("unchecked")
	public List<RysxBmbd> getBmbdByRybh(String rybh){
		int nrybh = Integer.parseInt(rybh);
		String hql = "from RysxBmbd where NRybh=?";
		List<RysxBmbd> listBmbd = getHibernateTemplate().find(hql,nrybh);
		return listBmbd;
		
	}
	
	public RysxBmbd getRsBmbdById(String id,String fydm,String rybh){
		String hql = "from RysxBmbd where NId=? and NFy=? and NRybh=?";
		BigDecimal bigDecimal = new BigDecimal(id);
		return (RysxBmbd)getSession().createQuery(hql).setParameter(0,bigDecimal).setParameter(1,Integer.valueOf(fydm)).setParameter(2, Integer.valueOf(rybh)).uniqueResult();
	}
	
	@SuppressWarnings("unchecked")
	public boolean delRsBmbdById(String rybh,String bh){
		int nrybh = Integer.parseInt(rybh);
		BigDecimal bd = new BigDecimal(bh);
		String hql = "from RysxBmbd where NRybh=? and NId=?";
		List<RysxBmbd> listBmbd = getHibernateTemplate().find(hql,nrybh,bd);
		if(listBmbd==null||listBmbd.size()==0){
			return false;
		}else{
			RysxBmbd rysxbmbd = listBmbd.get(0);
			getHibernateTemplate().delete(rysxbmbd);
			return true;
		}
	}
	
	public boolean updateRsBmbd(RysxBmbd rysxbmbd){
		if(rysxbmbd==null){
			return false;
		}else{
			getHibernateTemplate().update(rysxbmbd);
			return true;
		}
	}
	
	public boolean interceptAddBmbd(RysxBmbd rysxBmbd){
		try
		{
			getSession().save(rysxBmbd);
			getSession().flush();
			return true;
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
			return false;
		}
		
	}
	
	public boolean interceptUpdateBmbd(RysxBmbd rysxBmbd){
		try
		{
			getSession().update(rysxBmbd);
			getSession().flush();
			return true;
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
			return false;
		}
		
	}
	
	public boolean interceptDeleteBmbdById(RysxBmbd rysxBmbd){
		try
		{
			getSession().delete(rysxBmbd);
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
	public List<RysxBmbd> getBmbdByRybhFy(int rybh,int fydm){
		return getSession().createQuery("from RysxBmbd rj where rj.NFy=? and rj.NRybh=?").setParameter(0,Integer.valueOf(fydm)).setParameter(1,Integer.valueOf(rybh)).list();
	}
	
	public RysxBmbd findByFyRybhId(int fy,int rybh,BigDecimal id)
	{
	   return (RysxBmbd)getSession().createQuery("from RysxBmbd rj where rj.NFy = ? and rj.NRybh = ? and rj.NId = ? ").setParameter(0,fy).setParameter(1, rybh).setParameter(2,id).uniqueResult();	
	}
	public BigDecimal getMaxNid(int fydm)
	{
		String hql = "select max(N_ID) from T_RYSX_BMBD";
		return DaoUtils.getMaxIdRyjbxx(getSession(), fydm, hql);
		
	}
}