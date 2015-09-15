package nju.software.fyrs.data.dao;

import java.math.BigDecimal;
import java.util.List;

import nju.software.fyrs.data.dataobject.RysxBzxx;

import org.hibernate.LockMode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

/**
 	* A data access object (DAO) providing persistence and search support for RysxBzxx entities.
 			* Transaction control of the save(), update() and delete() operations 
		can directly support Spring container-managed transactions or they can be augmented	to handle user-managed Spring transactions. 
		Each of these methods provides additional information for how to configure it for the desired type of transaction control. 	
	 * @see nju.software.fyrs.data.dataobject.RysxBzxx
  * @author MyEclipse Persistence Tools 
 */
public class RysxBzxxDAO extends HibernateDaoSupport  {
	     private static final Logger log = LoggerFactory.getLogger(RysxBzxxDAO.class);
		//property constants
	public static final String _CBZ = "CBz";
	public static final String _NXSSX = "NXssx";



	protected void initDao() {
		//do nothing
	}
    
    public void save(RysxBzxx transientInstance) {
        log.debug("saving RysxBzxx instance");
        try {
            getHibernateTemplate().save(transientInstance);
            log.debug("save successful");
        } catch (RuntimeException re) {
            log.error("save failed", re);
            throw re;
        }
    }
    
	public void delete(RysxBzxx persistentInstance) {
        log.debug("deleting RysxBzxx instance");
        try {
            getHibernateTemplate().delete(persistentInstance);
            log.debug("delete successful");
        } catch (RuntimeException re) {
            log.error("delete failed", re);
            throw re;
        }
    }
    
    public RysxBzxx findById( nju.software.fyrs.data.dataobject.RysxBzxxId id) {
        log.debug("getting RysxBzxx instance with id: " + id);
        try {
            RysxBzxx instance = (RysxBzxx) getHibernateTemplate()
                    .get("software.fyrs.data.RysxBzxx", id);
            return instance;
        } catch (RuntimeException re) {
            log.error("get failed", re);
            throw re;
        }
    }
    
    
    @SuppressWarnings("unchecked")
	public List<RysxBzxx> findByExample(RysxBzxx instance) {
        log.debug("finding RysxBzxx instance by example");
        try {
            List<RysxBzxx> results = (List<RysxBzxx>) getHibernateTemplate().findByExample(instance); 
            log.debug("find by example successful, result size: " + results.size());
            return results;
        } catch (RuntimeException re) {
            log.error("find by example failed", re);
            throw re;
        }
    }    
    
    @SuppressWarnings("rawtypes")
	public List findByProperty(String propertyName, Object value) {
      log.debug("finding RysxBzxx instance with property: " + propertyName
            + ", value: " + value);
      try {
         String queryString = "from RysxBzxx as model where model." 
         						+ propertyName + "= ?";
		 return getHibernateTemplate().find(queryString, value);
      } catch (RuntimeException re) {
         log.error("find by property name failed", re);
         throw re;
      }
	}

	@SuppressWarnings("unchecked")
	public List<RysxBzxx> findByCBz(Object CBz
	) {
		return findByProperty(_CBZ, CBz
		);
	}
	
	@SuppressWarnings("unchecked")
	public List<RysxBzxx> findByNXssx(Object NXssx
	) {
		return findByProperty(_NXSSX, NXssx
		);
	}
	

	@SuppressWarnings("rawtypes")
	public List findAll() {
		log.debug("finding all RysxBzxx instances");
		try {
			String queryString = "from RysxBzxx";
		 	return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}
	
    public RysxBzxx merge(RysxBzxx detachedInstance) {
        log.debug("merging RysxBzxx instance");
        try {
            RysxBzxx result = (RysxBzxx) getHibernateTemplate()
                    .merge(detachedInstance);
            log.debug("merge successful");
            return result;
        } catch (RuntimeException re) {
            log.error("merge failed", re);
            throw re;
        }
    }

    public void attachDirty(RysxBzxx instance) {
        log.debug("attaching dirty RysxBzxx instance");
        try {
            getHibernateTemplate().saveOrUpdate(instance);
            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }
    
    public void attachClean(RysxBzxx instance) {
        log.debug("attaching clean RysxBzxx instance");
        try {
            getHibernateTemplate().lock(instance, LockMode.NONE);
            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }

	public static RysxBzxxDAO getFromApplicationContext(ApplicationContext ctx) {
    	return (RysxBzxxDAO) ctx.getBean("RysxBzxxDAO");
	}
	
	@SuppressWarnings("unchecked")
	public List<RysxBzxx> getBzxxByRybh(String rybh){
		int nrybh = Integer.parseInt(rybh);
		String hql = "from RysxBzxx where NRybh=?";
		List<RysxBzxx> listRysxBzxx = getHibernateTemplate().find(hql,nrybh);
		return listRysxBzxx;
	}
	
	public RysxBzxx getRsBzxxById(String id,String fydm,String rybh){
		String hql = "from RysxBzxx where NId=? and NFy=? and NRybh=?";
		BigDecimal bigDecimal = new BigDecimal(id);
		return (RysxBzxx)getSession().createQuery(hql).setParameter(0,bigDecimal).setParameter(1,Integer.valueOf(fydm)).setParameter(2, Integer.valueOf(rybh)).uniqueResult();
	}
	
	@SuppressWarnings("unchecked")
	public boolean delRsBzxxById(String rybh,String bh){
		int nrybh = Integer.parseInt(rybh);
		BigDecimal bd = new BigDecimal(bh);
		String hql = "from RysxBzxx where NRybh=? and NId=?";
		List<RysxBzxx> listRysxBzxx = getHibernateTemplate().find(hql,nrybh,bd);
		if(listRysxBzxx==null||listRysxBzxx.size()==0){
			return false;
		}else{
			RysxBzxx rysxBzxx = listRysxBzxx.get(0);
			getHibernateTemplate().delete(rysxBzxx);
			return true;
		}
	}
	
	public boolean updateRsBzxx(RysxBzxx rysxBzxx){
		if(rysxBzxx==null){
			return false;
		}else{
			getHibernateTemplate().update(rysxBzxx);
			return true;
		}
	}
	
	
	public boolean interceptAddBzxx(RysxBzxx rysxBzxx){
		try
		{
			getSession().save(rysxBzxx);
			getSession().flush();
			return true;
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
			return false;
		}
		
	}
	
	public boolean interceptUpdateBzxx(RysxBzxx rysxBzxx){
		try
		{
			getSession().update(rysxBzxx);
			getSession().flush();
			return true;
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
			return false;
		}
		
	}
	
	public boolean interceptDeleteRsBzxxById(RysxBzxx rysxBzxx){
		try
		{
			getSession().delete(rysxBzxx);
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
	public List<RysxBzxx> getBzxxByRybhFy(int rybh,int fydm){
		return getSession().createQuery("from RysxBzxx rk where rk.NFy=? and rk.NRybh=?").setParameter(0,Integer.valueOf(fydm)).setParameter(1,Integer.valueOf(rybh)).list();
	}
	
	public RysxBzxx findByFyRybhId(int fy,int rybh,BigDecimal id)
	{
	   return (RysxBzxx)getSession().createQuery("from RysxBzxx rk where rk.NFy = ? and rk.NRybh = ? and rk.NId = ? ").setParameter(0,fy).setParameter(1, rybh).setParameter(2,id).uniqueResult();	
	}
	public BigDecimal getMaxNid(int fydm)
	{
		String hql = "select max(N_ID) from T_RYSX_BZXX";
		return DaoUtils.getMaxIdRyjbxx(getSession(), fydm, hql);
		
	}

}