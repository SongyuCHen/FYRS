package nju.software.fyrs.data.dao;

import java.math.BigDecimal;
import java.util.List;

import nju.software.fyrs.data.dataobject.RysxFljl;

import org.hibernate.LockMode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

/**
 	* A data access object (DAO) providing persistence and search support for RysxFljl entities.
 			* Transaction control of the save(), update() and delete() operations 
		can directly support Spring container-managed transactions or they can be augmented	to handle user-managed Spring transactions. 
		Each of these methods provides additional information for how to configure it for the desired type of transaction control. 	
	 * @see nju.software.fyrs.data.dataobject.RysxFljl
  * @author MyEclipse Persistence Tools 
 */
public class RysxFljlDAO extends HibernateDaoSupport  {
	     private static final Logger log = LoggerFactory.getLogger(RysxFljlDAO.class);
	


	protected void initDao() {
		//do nothing
	}
    
    public void save(RysxFljl transientInstance) {
        log.debug("saving RysxFljl instance");
        try {
            getHibernateTemplate().save(transientInstance);
            log.debug("save successful");
        } catch (RuntimeException re) {
            log.error("save failed", re);
            throw re;
        }
    }
    
	public void delete(RysxFljl persistentInstance) {
        log.debug("deleting RysxFljl instance");
        try {
            getHibernateTemplate().delete(persistentInstance);
            log.debug("delete successful");
        } catch (RuntimeException re) {
            log.error("delete failed", re);
            throw re;
        }
    }
    
   
    
    
    @SuppressWarnings("unchecked")
	public List<RysxFljl> findByExample(RysxFljl instance) {
        log.debug("finding RysxFljl instance by example");
        try {
            List<RysxFljl> results = (List<RysxFljl>) getHibernateTemplate().findByExample(instance); 
            log.debug("find by example successful, result size: " + results.size());
            return results;
        } catch (RuntimeException re) {
            log.error("find by example failed", re);
            throw re;
        }
    }    
    
    @SuppressWarnings("rawtypes")
	public List findByProperty(String propertyName, Object value) {
      log.debug("finding RysxFljl instance with property: " + propertyName
            + ", value: " + value);
      try {
         String queryString = "from RysxFljl as model where model." 
         						+ propertyName + "= ?";
		 return getHibernateTemplate().find(queryString, value);
      } catch (RuntimeException re) {
         log.error("find by property name failed", re);
         throw re;
      }
	}


	

	@SuppressWarnings("rawtypes")
	public List findAll() {
		log.debug("finding all RysxFljl instances");
		try {
			String queryString = "from RysxFljl";
		 	return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}
	
    public RysxFljl merge(RysxFljl detachedInstance) {
        log.debug("merging RysxFljl instance");
        try {
            RysxFljl result = (RysxFljl) getHibernateTemplate()
                    .merge(detachedInstance);
            log.debug("merge successful");
            return result;
        } catch (RuntimeException re) {
            log.error("merge failed", re);
            throw re;
        }
    }

    public void attachDirty(RysxFljl instance) {
        log.debug("attaching dirty RysxFljl instance");
        try {
            getHibernateTemplate().saveOrUpdate(instance);
            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }
    
    public void attachClean(RysxFljl instance) {
        log.debug("attaching clean RysxFljl instance");
        try {
            getHibernateTemplate().lock(instance, LockMode.NONE);
            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }

	public static RysxFljlDAO getFromApplicationContext(ApplicationContext ctx) {
    	return (RysxFljlDAO) ctx.getBean("RysxFljlDAO");
	}
	
	@SuppressWarnings("unchecked")
	public List<RysxFljl> getFljlByRybh(String rybh){
		int nrybh = Integer.parseInt(rybh);
		String hql = "from RysxFljl where NRybh=?";
		List<RysxFljl> listXiujia = getHibernateTemplate().find(hql,nrybh);
		return listXiujia;
		
	}
	
	public RysxFljl getRsFljlById(String id,String fydm,String rybh){
		String hql = "from RysxFljl where NId=? and NFy=? and NRybh=?";
		BigDecimal bigDecimal = new BigDecimal(id);
		return (RysxFljl)getSession().createQuery(hql).setParameter(0,bigDecimal).setParameter(1,Integer.valueOf(fydm)).setParameter(2, Integer.valueOf(rybh)).uniqueResult();
	}
	
	@SuppressWarnings("unchecked")
	public boolean delRsFljlById(String rybh,String bh){
		int nrybh = Integer.parseInt(rybh);
		BigDecimal bd = new BigDecimal(bh);
		String hql = "from RysxFljl where NRybh=? and NId=?";
		List<RysxFljl> listXiujia = getHibernateTemplate().find(hql,nrybh,bd);
		if(listXiujia==null||listXiujia.size()==0){
			return false;
		}else{
			RysxFljl rysxFljl = listXiujia.get(0);
			getHibernateTemplate().delete(rysxFljl);
			return true;
		}
	}
	
	public boolean updateRsFljl(RysxFljl rysxFljl){
		if(rysxFljl==null){
			return false;
		}else{
			getHibernateTemplate().update(rysxFljl);
			return true;
		}
	}
	
	public boolean interceptAddFljl(RysxFljl rysxFljl){
		try
		{
			getSession().save(rysxFljl);
			getSession().flush();
			return true;
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
			return false;
		}
		
	}
	
	public boolean interceptUpdateFljl(RysxFljl rysxFljl){
		try
		{
			getSession().update(rysxFljl);
			getSession().flush();
			return true;
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
			return false;
		}
		
	}
	
	public boolean interceptDeleteFljlById(RysxFljl rysxFljl){
		try
		{
			getSession().delete(rysxFljl);
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
	public List<RysxFljl> getFljlByRybhFy(int rybh,int fydm){
		return getSession().createQuery("from RysxFljl rj where rj.NFy=? and rj.NRybh=?").setParameter(0,Integer.valueOf(fydm)).setParameter(1,Integer.valueOf(rybh)).list();
	}
	
	public List<RysxFljl> getFljlByFy(int fydm){
		return getSession().createQuery("from RysxFljl rj where rj.NFy=? ").setParameter(0,Integer.valueOf(fydm)).list();
	}
	
	public RysxFljl findByFyRybhId(int fy,int rybh,BigDecimal id)
	{
	   return (RysxFljl)getSession().createQuery("from RysxFljl rj where rj.NFy = ? and rj.NRybh = ? and rj.NId = ? ").setParameter(0,fy).setParameter(1, rybh).setParameter(2,id).uniqueResult();	
	}
	public BigDecimal getMaxNid(int fydm)
	{
		String hql = "select max(N_ID) from T_RYSX_FLJL";
		return DaoUtils.getMaxIdRyjbxx(getSession(), fydm, hql);
		
	}
}