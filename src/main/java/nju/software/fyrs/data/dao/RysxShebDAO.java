package nju.software.fyrs.data.dao;

import java.math.BigDecimal;
import java.util.List;

import nju.software.fyrs.data.dataobject.RysxShebao;

import org.hibernate.LockMode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

/**
 	* A data access object (DAO) providing persistence and search support for RysxShebao entities.
 			* Transaction control of the save(), update() and delete() operations 
		can directly support Spring container-managed transactions or they can be augmented	to handle user-managed Spring transactions. 
		Each of these methods provides additional information for how to configure it for the desired type of transaction control. 	
	 * @see nju.software.fyrs.data.dataobject.RysxShebao
  * @author MyEclipse Persistence Tools 
 */
public class RysxShebDAO extends HibernateDaoSupport  {
	     private static final Logger log = LoggerFactory.getLogger(RysxShebDAO.class);
	


	protected void initDao() {
		//do nothing
	}
    
    public void save(RysxShebao transientInstance) {
        log.debug("saving RysxShebao instance");
        try {
            getHibernateTemplate().save(transientInstance);
            log.debug("save successful");
        } catch (RuntimeException re) {
            log.error("save failed", re);
            throw re;
        }
    }
    
	public void delete(RysxShebao persistentInstance) {
        log.debug("deleting RysxShebao instance");
        try {
            getHibernateTemplate().delete(persistentInstance);
            log.debug("delete successful");
        } catch (RuntimeException re) {
            log.error("delete failed", re);
            throw re;
        }
    }
    
   
    
    
    @SuppressWarnings("unchecked")
	public List<RysxShebao> findByExample(RysxShebao instance) {
        log.debug("finding RysxShebao instance by example");
        try {
            List<RysxShebao> results = (List<RysxShebao>) getHibernateTemplate().findByExample(instance); 
            log.debug("find by example successful, result size: " + results.size());
            return results;
        } catch (RuntimeException re) {
            log.error("find by example failed", re);
            throw re;
        }
    }    
    
    @SuppressWarnings("rawtypes")
	public List findByProperty(String propertyName, Object value) {
      log.debug("finding RysxShebao instance with property: " + propertyName
            + ", value: " + value);
      try {
         String queryString = "from RysxShebao as model where model." 
         						+ propertyName + "= ?";
		 return getHibernateTemplate().find(queryString, value);
      } catch (RuntimeException re) {
         log.error("find by property name failed", re);
         throw re;
      }
	}


	

	@SuppressWarnings("rawtypes")
	public List findAll() {
		log.debug("finding all RysxShebao instances");
		try {
			String queryString = "from RysxShebao";
		 	return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}
	
    public RysxShebao merge(RysxShebao detachedInstance) {
        log.debug("merging RysxShebao instance");
        try {
            RysxShebao result = (RysxShebao) getHibernateTemplate()
                    .merge(detachedInstance);
            log.debug("merge successful");
            return result;
        } catch (RuntimeException re) {
            log.error("merge failed", re);
            throw re;
        }
    }

    public void attachDirty(RysxShebao instance) {
        log.debug("attaching dirty RysxShebao instance");
        try {
            getHibernateTemplate().saveOrUpdate(instance);
            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }
    
    public void attachClean(RysxShebao instance) {
        log.debug("attaching clean RysxShebao instance");
        try {
            getHibernateTemplate().lock(instance, LockMode.NONE);
            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }

	public static RysxShebDAO getFromApplicationContext(ApplicationContext ctx) {
    	return (RysxShebDAO) ctx.getBean("RysxShebDAO");
	}
	
	@SuppressWarnings("unchecked")
	public List<RysxShebao> getShebaoByRybh(String rybh){
		int nrybh = Integer.parseInt(rybh);
		String hql = "from RysxShebao where NRybh=?";
		List<RysxShebao> listXiujia = getHibernateTemplate().find(hql,nrybh);
		return listXiujia;
		
	}
	
	public RysxShebao getRsShebaoById(String id,String fydm,String rybh){
		String hql = "from RysxShebao where NId=? and NFy=? and NRybh=?";
		BigDecimal bigDecimal = new BigDecimal(id);
		return (RysxShebao)getSession().createQuery(hql).setParameter(0,bigDecimal).setParameter(1,Integer.valueOf(fydm)).setParameter(2, Integer.valueOf(rybh)).uniqueResult();
	}
	
	@SuppressWarnings("unchecked")
	public boolean delRsShebaoById(String rybh,String bh){
		int nrybh = Integer.parseInt(rybh);
		BigDecimal bd = new BigDecimal(bh);
		String hql = "from RysxShebao where NRybh=? and NId=?";
		List<RysxShebao> listXiujia = getHibernateTemplate().find(hql,nrybh,bd);
		if(listXiujia==null||listXiujia.size()==0){
			return false;
		}else{
			RysxShebao rysxSheb = listXiujia.get(0);
			getHibernateTemplate().delete(rysxSheb);
			return true;
		}
	}
	
	public boolean updateRsShebao(RysxShebao rysxSheb){
		if(rysxSheb==null){
			return false;
		}else{
			getHibernateTemplate().update(rysxSheb);
			return true;
		}
	}
	
	public boolean interceptAddShebao(RysxShebao rysxSheb){
		try
		{
			getSession().save(rysxSheb);
			getSession().flush();
			return true;
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
			return false;
		}
		
	}
	
	public boolean interceptUpdateShebao(RysxShebao rysxSheb){
		try
		{
			getSession().update(rysxSheb);
			getSession().flush();
			return true;
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
			return false;
		}
		
	}
	
	public boolean interceptDeleteShebaoById(RysxShebao rysxSheb){
		try
		{
			getSession().delete(rysxSheb);
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
	public List<RysxShebao> getShebaoByRybhFy(int rybh,int fydm){
		return getSession().createQuery("from RysxShebao rj where rj.NFy=? and rj.NRybh=?").setParameter(0,Integer.valueOf(fydm)).setParameter(1,Integer.valueOf(rybh)).list();
	}
	
	@SuppressWarnings("unchecked")
	public List<RysxShebao> getShebaoByFy(int fydm){
		return getSession().createQuery("from RysxShebao rj where rj.NFy=? ").setParameter(0,Integer.valueOf(fydm)).list();
	}
	
	public RysxShebao findByFyRybhId(int fy,int rybh,BigDecimal id)
	{
	   return (RysxShebao)getSession().createQuery("from RysxShebao rj where rj.NFy = ? and rj.NRybh = ? and rj.NId = ? ").setParameter(0,fy).setParameter(1, rybh).setParameter(2,id).uniqueResult();	
	}
	public BigDecimal getMaxNid(int fydm)
	{
		String hql = "select max(N_ID) from T_RYSX_SBJL";
		return DaoUtils.getMaxIdRyjbxx(getSession(), fydm, hql);
		
	}
}