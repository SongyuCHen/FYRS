package nju.software.fyrs.data.dao;

import java.math.BigDecimal;
import java.util.List;

import nju.software.fyrs.data.dataobject.RysxPxxx;

import org.hibernate.LockMode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

/**
 	* A data access object (DAO) providing persistence and search support for RysxPxxx entities.
 			* Transaction control of the save(), update() and delete() operations 
		can directly support Spring container-managed transactions or they can be augmented	to handle user-managed Spring transactions. 
		Each of these methods provides additional information for how to configure it for the desired type of transaction control. 	
	 * @see nju.software.fyrs.data.dataobject.RysxPxxx
  * @author MyEclipse Persistence Tools 
 */
public class RysxPxxxDAO extends HibernateDaoSupport  {
	     private static final Logger log = LoggerFactory.getLogger(RysxPxxxDAO.class);
		//property constants
	public static final String _NPXXS = "NPxxs";
	public static final String _CQTPXXS = "CQtpxxs";
	public static final String _CPXBMC = "CPxbmc";
	public static final String _NJGLB = "NJglb";
	public static final String _CQTJGLB = "CQtjglb";
	public static final String _CPXJG = "CPxjg";
	public static final String _NZY = "NZy";
	public static final String _NXZ = "NXz";
	public static final String _CPXCJ = "CPxcj";
	public static final String _NPXFS = "NPxfs";
	public static final String _NPXZL = "NPxzl";
	public static final String _NTBJL = "NTbjl";
	public static final String _CJLID = "CJlid";
	public static final String _NSFQDZS = "NSfqdzs";
	public static final String _NXSSX = "NXssx";



	protected void initDao() {
		//do nothing
	}
    
    public void save(RysxPxxx transientInstance) {
        log.debug("saving RysxPxxx instance");
        try {
            getHibernateTemplate().save(transientInstance);
            log.debug("save successful");
        } catch (RuntimeException re) {
            log.error("save failed", re);
            throw re;
        }
    }
    
	public void delete(RysxPxxx persistentInstance) {
        log.debug("deleting RysxPxxx instance");
        try {
            getHibernateTemplate().delete(persistentInstance);
            log.debug("delete successful");
        } catch (RuntimeException re) {
            log.error("delete failed", re);
            throw re;
        }
    }
    
    public RysxPxxx findById( nju.software.fyrs.data.dataobject.RysxPxxxId id) {
        log.debug("getting RysxPxxx instance with id: " + id);
        try {
            RysxPxxx instance = (RysxPxxx) getHibernateTemplate()
                    .get("software.fyrs.data.RysxPxxx", id);
            return instance;
        } catch (RuntimeException re) {
            log.error("get failed", re);
            throw re;
        }
    }
    
    
    @SuppressWarnings("unchecked")
	public List<RysxPxxx> findByExample(RysxPxxx instance) {
        log.debug("finding RysxPxxx instance by example");
        try {
            List<RysxPxxx> results = (List<RysxPxxx>) getHibernateTemplate().findByExample(instance); 
            log.debug("find by example successful, result size: " + results.size());
            return results;
        } catch (RuntimeException re) {
            log.error("find by example failed", re);
            throw re;
        }
    }    
    
    @SuppressWarnings("rawtypes")
	public List findByProperty(String propertyName, Object value) {
      log.debug("finding RysxPxxx instance with property: " + propertyName
            + ", value: " + value);
      try {
         String queryString = "from RysxPxxx as model where model." 
         						+ propertyName + "= ?";
		 return getHibernateTemplate().find(queryString, value);
      } catch (RuntimeException re) {
         log.error("find by property name failed", re);
         throw re;
      }
	}

	@SuppressWarnings("unchecked")
	public List<RysxPxxx> findByNPxxs(Object NPxxs
	) {
		return findByProperty(_NPXXS, NPxxs
		);
	}
	
	@SuppressWarnings("unchecked")
	public List<RysxPxxx> findByCQtpxxs(Object CQtpxxs
	) {
		return findByProperty(_CQTPXXS, CQtpxxs
		);
	}
	
	@SuppressWarnings("unchecked")
	public List<RysxPxxx> findByCPxbmc(Object CPxbmc
	) {
		return findByProperty(_CPXBMC, CPxbmc
		);
	}
	
	@SuppressWarnings("unchecked")
	public List<RysxPxxx> findByNJglb(Object NJglb
	) {
		return findByProperty(_NJGLB, NJglb
		);
	}
	
	@SuppressWarnings("unchecked")
	public List<RysxPxxx> findByCQtjglb(Object CQtjglb
	) {
		return findByProperty(_CQTJGLB, CQtjglb
		);
	}
	
	@SuppressWarnings("unchecked")
	public List<RysxPxxx> findByCPxjg(Object CPxjg
	) {
		return findByProperty(_CPXJG, CPxjg
		);
	}
	
	@SuppressWarnings("unchecked")
	public List<RysxPxxx> findByNZy(Object NZy
	) {
		return findByProperty(_NZY, NZy
		);
	}
	
	@SuppressWarnings("unchecked")
	public List<RysxPxxx> findByNXz(Object NXz
	) {
		return findByProperty(_NXZ, NXz
		);
	}
	
	@SuppressWarnings("unchecked")
	public List<RysxPxxx> findByCPxcj(Object CPxcj
	) {
		return findByProperty(_CPXCJ, CPxcj
		);
	}
	
	@SuppressWarnings("unchecked")
	public List<RysxPxxx> findByNPxfs(Object NPxfs
	) {
		return findByProperty(_NPXFS, NPxfs
		);
	}
	
	@SuppressWarnings("unchecked")
	public List<RysxPxxx> findByNPxzl(Object NPxzl
	) {
		return findByProperty(_NPXZL, NPxzl
		);
	}
	
	@SuppressWarnings("unchecked")
	public List<RysxPxxx> findByNTbjl(Object NTbjl
	) {
		return findByProperty(_NTBJL, NTbjl
		);
	}
	
	@SuppressWarnings("unchecked")
	public List<RysxPxxx> findByCJlid(Object CJlid
	) {
		return findByProperty(_CJLID, CJlid
		);
	}
	
	@SuppressWarnings("unchecked")
	public List<RysxPxxx> findByNSfqdzs(Object NSfqdzs
	) {
		return findByProperty(_NSFQDZS, NSfqdzs
		);
	}
	
	@SuppressWarnings("unchecked")
	public List<RysxPxxx> findByNXssx(Object NXssx
	) {
		return findByProperty(_NXSSX, NXssx
		);
	}
	

	@SuppressWarnings("rawtypes")
	public List findAll() {
		log.debug("finding all RysxPxxx instances");
		try {
			String queryString = "from RysxPxxx";
		 	return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}
	
    public RysxPxxx merge(RysxPxxx detachedInstance) {
        log.debug("merging RysxPxxx instance");
        try {
            RysxPxxx result = (RysxPxxx) getHibernateTemplate()
                    .merge(detachedInstance);
            log.debug("merge successful");
            return result;
        } catch (RuntimeException re) {
            log.error("merge failed", re);
            throw re;
        }
    }

    public void attachDirty(RysxPxxx instance) {
        log.debug("attaching dirty RysxPxxx instance");
        try {
            getHibernateTemplate().saveOrUpdate(instance);
            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }
    
    public void attachClean(RysxPxxx instance) {
        log.debug("attaching clean RysxPxxx instance");
        try {
            getHibernateTemplate().lock(instance, LockMode.NONE);
            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }

	public static RysxPxxxDAO getFromApplicationContext(ApplicationContext ctx) {
    	return (RysxPxxxDAO) ctx.getBean("RysxPxxxDAO");
	}
	
	@SuppressWarnings("unchecked")
	public List<RysxPxxx> getPxxxByRybh(String rybh){
		int nrybh = Integer.parseInt(rybh);
		String hql = "from RysxPxxx where NRybh=?";
		List<RysxPxxx> listRysxPxxx = getHibernateTemplate().find(hql,nrybh);
		return listRysxPxxx;
	}
	
	public RysxPxxx getRsPxxxById(String id,String fydm,String rybh){
		String hql = "from RysxPxxx where NId=? and NFy=? and NRybh=?";
		BigDecimal bigDecimal = new BigDecimal(id);
		return (RysxPxxx)getSession().createQuery(hql).setParameter(0,bigDecimal).setParameter(1,Integer.valueOf(fydm)).setParameter(2, Integer.valueOf(rybh)).uniqueResult();
	}
	
	@SuppressWarnings("unchecked")
	public boolean delRsPxxxById(String rybh,String bh){
		int nrybh = Integer.parseInt(rybh);
		BigDecimal bd = new BigDecimal(bh);
		String hql = "from RysxPxxx where NRybh=? and NId=?";
		List<RysxPxxx> listRysxPxxx = getHibernateTemplate().find(hql,nrybh,bd);
		if(listRysxPxxx==null||listRysxPxxx.size()==0){
			return false;
		}else{
			RysxPxxx rysxPxxx = listRysxPxxx.get(0);
			getHibernateTemplate().delete(rysxPxxx);
			return true;
		}
	}
	
	public boolean updateRsPxxx(RysxPxxx rysxPxxx){
		if(rysxPxxx==null){
			return false;
		}else{
			getHibernateTemplate().update(rysxPxxx);
			return true;
		}
	}

	
	public boolean interceptAddPxxx(RysxPxxx rysxPxxx){
		try
		{
			getSession().save(rysxPxxx);
			getSession().flush();
			return true;
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
			return false;
		}
		
	}
	
	public boolean interceptUpdatePxxx(RysxPxxx rysxPxxx){
		try
		{
			getSession().update(rysxPxxx);
			getSession().flush();
			return true;
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
			return false;
		}
		
	}
	
	public boolean interceptDeleteRsPxxxById(RysxPxxx rysxPxxx){
		try
		{
			getSession().delete(rysxPxxx);
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
	public List<RysxPxxx> getPxxxByRybhFy(int rybh,int fydm){
		return getSession().createQuery("from RysxPxxx rp where rp.NFy=? and rp.NRybh=? order by DKsrq").setParameter(0,Integer.valueOf(fydm)).setParameter(1,Integer.valueOf(rybh)).list();
	}
	@SuppressWarnings("unchecked")
	public List<RysxPxxx> getPxxxByFy(int fydm){
		return getSession().createQuery("from RysxPxxx rp where rp.NFy=? order by DKsrq").setParameter(0,Integer.valueOf(fydm)).list();
	}
	
	public RysxPxxx findByFyRybhId(int fy,int rybh,BigDecimal id)
	{
	   return (RysxPxxx)getSession().createQuery("from RysxPxxx rp where rp.NFy = ? and rp.NRybh = ? and rp.NId = ? ").setParameter(0,fy).setParameter(1, rybh).setParameter(2,id).uniqueResult();	
	}
	public BigDecimal getMaxNid(int fydm)
	{
		String hql = "select max(N_ID) from T_RYSX_PXXX";
		return DaoUtils.getMaxIdRyjbxx(getSession(), fydm, hql);
		
	}

}