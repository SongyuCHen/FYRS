package nju.software.fyrs.data.dao;

import java.math.BigDecimal;
import java.util.List;

import nju.software.fyrs.data.dataobject.RysxJianglixx;

import org.hibernate.LockMode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

/**
 	* A data access object (DAO) providing persistence and search support for RysxJianglixx entities.
 			* Transaction control of the save(), update() and delete() operations 
		can directly support Spring container-managed transactions or they can be augmented	to handle user-managed Spring transactions. 
		Each of these methods provides additional information for how to configure it for the desired type of transaction control. 	
	 * @see nju.software.fyrs.data.dataobject.RysxJianglixx
  * @author MyEclipse Persistence Tools 
 */
public class RysxJianglixxDAO extends HibernateDaoSupport  {
	     private static final Logger log = LoggerFactory.getLogger(RysxJianglixxDAO.class);
		//property constants
	public static final String _NJLLB = "NJllb";
	public static final String _NJLYY = "NJlyy";
	public static final String _NGRQK = "NGrqk";
	public static final String _NJLJB = "NJljb";
	public static final String _CPZDW = "CPzdw";
	public static final String _CPZWH = "CPzwh";
	public static final String _CJLYYXX = "CJlyyxx";
	public static final String _CJLLBSM = "CJllbsm";
	public static final String _NXSSX = "NXssx";



	protected void initDao() {
		//do nothing
	}
    
    public void save(RysxJianglixx transientInstance) {
        log.debug("saving RysxJianglixx instance");
        try {
            getHibernateTemplate().save(transientInstance);
            log.debug("save successful");
        } catch (RuntimeException re) {
            log.error("save failed", re);
            throw re;
        }
    }
    
	public void delete(RysxJianglixx persistentInstance) {
        log.debug("deleting RysxJianglixx instance");
        try {
            getHibernateTemplate().delete(persistentInstance);
            log.debug("delete successful");
        } catch (RuntimeException re) {
            log.error("delete failed", re);
            throw re;
        }
    }
    
    public RysxJianglixx findById( nju.software.fyrs.data.dataobject.RysxJianglixxId id) {
        log.debug("getting RysxJianglixx instance with id: " + id);
        try {
            RysxJianglixx instance = (RysxJianglixx) getHibernateTemplate()
                    .get("software.fyrs.data.RysxJianglixx", id);
            return instance;
        } catch (RuntimeException re) {
            log.error("get failed", re);
            throw re;
        }
    }
    
    
    @SuppressWarnings("unchecked")
	public List<RysxJianglixx> findByExample(RysxJianglixx instance) {
        log.debug("finding RysxJianglixx instance by example");
        try {
            List<RysxJianglixx> results = (List<RysxJianglixx>) getHibernateTemplate().findByExample(instance); 
            log.debug("find by example successful, result size: " + results.size());
            return results;
        } catch (RuntimeException re) {
            log.error("find by example failed", re);
            throw re;
        }
    }    
    
    @SuppressWarnings("rawtypes")
	public List findByProperty(String propertyName, Object value) {
      log.debug("finding RysxJianglixx instance with property: " + propertyName
            + ", value: " + value);
      try {
         String queryString = "from RysxJianglixx as model where model." 
         						+ propertyName + "= ?";
		 return getHibernateTemplate().find(queryString, value);
      } catch (RuntimeException re) {
         log.error("find by property name failed", re);
         throw re;
      }
	}

	@SuppressWarnings("unchecked")
	public List<RysxJianglixx> findByNJllb(Object NJllb
	) {
		return findByProperty(_NJLLB, NJllb
		);
	}
	
	@SuppressWarnings("unchecked")
	public List<RysxJianglixx> findByNJlyy(Object NJlyy
	) {
		return findByProperty(_NJLYY, NJlyy
		);
	}
	
	@SuppressWarnings("unchecked")
	public List<RysxJianglixx> findByNGrqk(Object NGrqk
	) {
		return findByProperty(_NGRQK, NGrqk
		);
	}
	
	@SuppressWarnings("unchecked")
	public List<RysxJianglixx> findByNJljb(Object NJljb
	) {
		return findByProperty(_NJLJB, NJljb
		);
	}
	
	@SuppressWarnings("unchecked")
	public List<RysxJianglixx> findByCPzdw(Object CPzdw
	) {
		return findByProperty(_CPZDW, CPzdw
		);
	}
	
	@SuppressWarnings("unchecked")
	public List<RysxJianglixx> findByCPzwh(Object CPzwh
	) {
		return findByProperty(_CPZWH, CPzwh
		);
	}
	
	@SuppressWarnings("unchecked")
	public List<RysxJianglixx> findByCJlyyxx(Object CJlyyxx
	) {
		return findByProperty(_CJLYYXX, CJlyyxx
		);
	}
	
	@SuppressWarnings("unchecked")
	public List<RysxJianglixx> findByCJllbsm(Object CJllbsm
	) {
		return findByProperty(_CJLLBSM, CJllbsm
		);
	}
	
	@SuppressWarnings("unchecked")
	public List<RysxJianglixx> findByNXssx(Object NXssx
	) {
		return findByProperty(_NXSSX, NXssx
		);
	}
	

	@SuppressWarnings("rawtypes")
	public List findAll() {
		log.debug("finding all RysxJianglixx instances");
		try {
			String queryString = "from RysxJianglixx";
		 	return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}
	
    public RysxJianglixx merge(RysxJianglixx detachedInstance) {
        log.debug("merging RysxJianglixx instance");
        try {
            RysxJianglixx result = (RysxJianglixx) getHibernateTemplate()
                    .merge(detachedInstance);
            log.debug("merge successful");
            return result;
        } catch (RuntimeException re) {
            log.error("merge failed", re);
            throw re;
        }
    }

    public void attachDirty(RysxJianglixx instance) {
        log.debug("attaching dirty RysxJianglixx instance");
        try {
            getHibernateTemplate().saveOrUpdate(instance);
            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }
    
    public void attachClean(RysxJianglixx instance) {
        log.debug("attaching clean RysxJianglixx instance");
        try {
            getHibernateTemplate().lock(instance, LockMode.NONE);
            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }

	public static RysxJianglixxDAO getFromApplicationContext(ApplicationContext ctx) {
    	return (RysxJianglixxDAO) ctx.getBean("RysxJianglixxDAO");
	}
	
	@SuppressWarnings("unchecked")
	public List<RysxJianglixx> getJlixxByRybh(String rybh){
		String hql = "from RysxJianglixx where NRybh=?";
		int nrybh = Integer.parseInt(rybh);
		List<RysxJianglixx> listJianglixx = getHibernateTemplate().find(hql,nrybh);
		return listJianglixx;
	}
	
	public RysxJianglixx getRsJlixxById(String id,String fydm,String rybh){
		String hql = "from RysxJianglixx where NId=? and NFy=? and NRybh=?";
		BigDecimal bigDecimal = new BigDecimal(id);
		return (RysxJianglixx)getSession().createQuery(hql).setParameter(0,bigDecimal).setParameter(1,Integer.valueOf(fydm)).setParameter(2, Integer.valueOf(rybh)).uniqueResult();
	}
	
	@SuppressWarnings("unchecked")
	public boolean delRsJlixxById(String rybh,String bh){
		String hql = "from RysxJianglixx where NRybh=? and NId=?";
		int nrybh = Integer.parseInt(rybh);
		BigDecimal bd = new BigDecimal(bh);
		List<RysxJianglixx> listRysxJianglixx = getHibernateTemplate().find(hql,nrybh,bd);
		if(listRysxJianglixx==null||listRysxJianglixx.size()==0){
			return false;
		}else{
			RysxJianglixx rsJianglixx = listRysxJianglixx.get(0);
			getHibernateTemplate().delete(rsJianglixx);
			return true;
		}
	}
	
	public boolean updateRsJlixx(RysxJianglixx rysxJianglixx){
		if(rysxJianglixx==null){
			return false;
		}else{
			getHibernateTemplate().update(rysxJianglixx);
			return true;
		}
	}

	

	public boolean interceptAddJianglixx(RysxJianglixx rysxJlixx){
		try
		{
			getSession().save(rysxJlixx);
			getSession().flush();
			return true;
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
			return false;
		}
		
	}
	
	public boolean interceptUpdateJianglixx(RysxJianglixx rysxJlixx){
		try
		{
			getSession().update(rysxJlixx);
			getSession().flush();
			return true;
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
			return false;
		}
		
	}
	
	public boolean interceptDeleteRsJianglixxById(RysxJianglixx rysxJlixx){
		try
		{
			getSession().delete(rysxJlixx);
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
	public List<RysxJianglixx> getJlixxByRybhFy(int rybh,int fydm){
		return getSession().createQuery("from RysxJianglixx rj where rj.NFy=? and rj.NRybh=? order by DJlsj").setParameter(0,Integer.valueOf(fydm)).setParameter(1,Integer.valueOf(rybh)).list();
	}
	
	@SuppressWarnings("unchecked")
	public List<RysxJianglixx> getJianglixxByFy(int fydm){
		return getHibernateTemplate().find("from RysxJianglixx where NFy="+fydm+" order by DJlsj asc");
	}
	
	public RysxJianglixx findByFyRybhId(int fy,int rybh,BigDecimal id)
	{
	   return (RysxJianglixx)getSession().createQuery("from RysxJianglixx rj where rj.NFy = ? and rj.NRybh = ? and rj.NId = ? ").setParameter(0,fy).setParameter(1, rybh).setParameter(2,id).uniqueResult();	
	}
	public BigDecimal getMaxNid(int fydm)
	{
		String hql = "select max(N_ID) from T_RYSX_JIANGLIXX";
		return DaoUtils.getMaxIdRyjbxx(getSession(), fydm, hql);
		
	}

}