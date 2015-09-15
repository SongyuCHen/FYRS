package nju.software.fyrs.data.dao;

import java.math.BigDecimal;
import java.util.List;

import nju.software.fyrs.data.dataobject.RysxKhxx;

import org.hibernate.LockMode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

/**
 	* A data access object (DAO) providing persistence and search support for RysxKhxx entities.
 			* Transaction control of the save(), update() and delete() operations 
		can directly support Spring container-managed transactions or they can be augmented	to handle user-managed Spring transactions. 
		Each of these methods provides additional information for how to configure it for the desired type of transaction control. 	
	 * @see nju.software.fyrs.data.dataobject.RysxKhxx
  * @author MyEclipse Persistence Tools 
 */
public class RysxKhxxDAO extends HibernateDaoSupport  {
	     private static final Logger log = LoggerFactory.getLogger(RysxKhxxDAO.class);
		//property constants
	public static final String _NND = "NNd";
	public static final String _NKHJG = "NKhjg";
	public static final String _NXSSX = "NXssx";



	protected void initDao() {
		//do nothing
	}
    
    public void save(RysxKhxx transientInstance) {
        log.debug("saving RysxKhxx instance");
        try {
            getHibernateTemplate().save(transientInstance);
            log.debug("save successful");
        } catch (RuntimeException re) {
            log.error("save failed", re);
            throw re;
        }
    }
    
	public void delete(RysxKhxx persistentInstance) {
        log.debug("deleting RysxKhxx instance");
        try {
            getHibernateTemplate().delete(persistentInstance);
            log.debug("delete successful");
        } catch (RuntimeException re) {
            log.error("delete failed", re);
            throw re;
        }
    }
    
    public RysxKhxx findById( nju.software.fyrs.data.dataobject.RysxKhxxId id) {
        log.debug("getting RysxKhxx instance with id: " + id);
        try {
            RysxKhxx instance = (RysxKhxx) getHibernateTemplate()
                    .get("software.fyrs.data.RysxKhxx", id);
            return instance;
        } catch (RuntimeException re) {
            log.error("get failed", re);
            throw re;
        }
    }
    
    
    @SuppressWarnings("unchecked")
	public List<RysxKhxx> findByExample(RysxKhxx instance) {
        log.debug("finding RysxKhxx instance by example");
        try {
            List<RysxKhxx> results = (List<RysxKhxx>) getHibernateTemplate().findByExample(instance); 
            log.debug("find by example successful, result size: " + results.size());
            return results;
        } catch (RuntimeException re) {
            log.error("find by example failed", re);
            throw re;
        }
    }    
    
    @SuppressWarnings("rawtypes")
	public List findByProperty(String propertyName, Object value) {
      log.debug("finding RysxKhxx instance with property: " + propertyName
            + ", value: " + value);
      try {
         String queryString = "from RysxKhxx as model where model." 
         						+ propertyName + "= ?";
		 return getHibernateTemplate().find(queryString, value);
      } catch (RuntimeException re) {
         log.error("find by property name failed", re);
         throw re;
      }
	}

	@SuppressWarnings("unchecked")
	public List<RysxKhxx> findByNNd(Object NNd
	) {
		return findByProperty(_NND, NNd
		);
	}
	
	@SuppressWarnings("unchecked")
	public List<RysxKhxx> findByNKhjg(Object NKhjg
	) {
		return findByProperty(_NKHJG, NKhjg
		);
	}
	
	@SuppressWarnings("unchecked")
	public List<RysxKhxx> findByNXssx(Object NXssx
	) {
		return findByProperty(_NXSSX, NXssx
		);
	}
	

	@SuppressWarnings("rawtypes")
	public List findAll() {
		log.debug("finding all RysxKhxx instances");
		try {
			String queryString = "from RysxKhxx";
		 	return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}
	
    public RysxKhxx merge(RysxKhxx detachedInstance) {
        log.debug("merging RysxKhxx instance");
        try {
            RysxKhxx result = (RysxKhxx) getHibernateTemplate()
                    .merge(detachedInstance);
            log.debug("merge successful");
            return result;
        } catch (RuntimeException re) {
            log.error("merge failed", re);
            throw re;
        }
    }

    public void attachDirty(RysxKhxx instance) {
        log.debug("attaching dirty RysxKhxx instance");
        try {
            getHibernateTemplate().saveOrUpdate(instance);
            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }
    
    public void attachClean(RysxKhxx instance) {
        log.debug("attaching clean RysxKhxx instance");
        try {
            getHibernateTemplate().lock(instance, LockMode.NONE);
            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }

	public static RysxKhxxDAO getFromApplicationContext(ApplicationContext ctx) {
    	return (RysxKhxxDAO) ctx.getBean("RysxKhxxDAO");
	}
	
	@SuppressWarnings("unchecked")
	public List<RysxKhxx> getKhxxByRybh(String rybh){
		int nrybh = Integer.parseInt(rybh);
		String hql = "from RysxKhxx where NRybh="+nrybh;
		List<RysxKhxx> listRysxKhxx = getHibernateTemplate().find(hql);
		if(listRysxKhxx==null||listRysxKhxx.size()==0){
			return null;
		}else{
			return listRysxKhxx;
		}
	}
	
	public RysxKhxx getRsKhxxById(String id,String fydm,String rybh){
		String hql = "from RysxKhxx where NId=? and NFy=? and NRybh=?";
		BigDecimal bigDecimal = new BigDecimal(id);
		return (RysxKhxx)getSession().createQuery(hql).setParameter(0,bigDecimal).setParameter(1,Integer.valueOf(fydm)).setParameter(2, Integer.valueOf(rybh)).uniqueResult();
	}
	
	@SuppressWarnings("unchecked")
	public boolean delRsKhxxById(String rybh,String bh){
		String hql = "from RysxKhxx where NRybh=? and NId=?";
		int nrybh = Integer.parseInt(rybh);
		BigDecimal bd = new BigDecimal(bh);
		List<RysxKhxx> RsKhxxList = getHibernateTemplate().find(hql,nrybh,bd);
		if(RsKhxxList==null||RsKhxxList.size()==0){
			return false;
		}else{
			RysxKhxx rysxKhxx = RsKhxxList.get(0);
			getHibernateTemplate().delete(rysxKhxx);
			return true;
		}
	}
	
	public boolean updateRsKhxx(RysxKhxx rysxKhxx){
		if(rysxKhxx==null){
			return false;
		}else{
			getHibernateTemplate().update(rysxKhxx);
			return true;
		}
	}

	public boolean interceptAddKhxx(RysxKhxx rysxKhxx){
		try
		{
			getSession().save(rysxKhxx);
			getSession().flush();
			return true;
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
			return false;
		}
		
	}
	
	public boolean interceptUpdateKhxx(RysxKhxx rysxKhxx){
		try
		{
			getSession().update(rysxKhxx);
			getSession().flush();
			return true;
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
			return false;
		}
		
	}
	
	public boolean interceptDeleteRsKhxxById(RysxKhxx rysxKhxx){
		try
		{
			getSession().delete(rysxKhxx);
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
	public List<RysxKhxx> getKhxxByRybhFy(int rybh,int fydm){
		return getSession().createQuery("from RysxKhxx rk where rk.NFy=? and rk.NRybh=? order by NNd").setParameter(0,Integer.valueOf(fydm)).setParameter(1,Integer.valueOf(rybh)).list();
	}
	
	public RysxKhxx findByFyRybhId(int fy,int rybh,BigDecimal id)
	{
	   return (RysxKhxx)getSession().createQuery("from RysxKhxx rk where rk.NFy = ? and rk.NRybh = ? and rk.NId = ? ").setParameter(0,fy).setParameter(1, rybh).setParameter(2,id).uniqueResult();	
	}
	public BigDecimal getMaxNid(int fydm)
	{
		String hql = "select max(N_ID) from T_RYSX_KHXX";
		return DaoUtils.getMaxIdRyjbxx(getSession(), fydm, hql);
		
	}


	

}