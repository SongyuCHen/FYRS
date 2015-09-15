package nju.software.fyrs.data.dao;

import java.math.BigDecimal;
import java.util.List;

import nju.software.fyrs.data.dataobject.RysxJtxx;

import org.hibernate.LockMode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

/**
 	* A data access object (DAO) providing persistence and search support for RysxJtxx entities.
 			* Transaction control of the save(), update() and delete() operations 
		can directly support Spring container-managed transactions or they can be augmented	to handle user-managed Spring transactions. 
		Each of these methods provides additional information for how to configure it for the desired type of transaction control. 	
	 * @see nju.software.fyrs.data.dataobject.RysxJtxx
  * @author MyEclipse Persistence Tools 
 */
public class RysxJtxxDAO extends HibernateDaoSupport  {
	     private static final Logger log = LoggerFactory.getLogger(RysxJtxxDAO.class);
		//property constants
	public static final String _CXM = "CXm";
	public static final String _NYBRGX = "NYbrgx";
	public static final String _NZZMM = "NZzmm";
	public static final String _CJTDH = "CJtdh";
	public static final String _CYZBM = "CYzbm";
	public static final String _NZFMJ = "NZfmj";
	public static final String _CJTZZ = "CJtzz";
	public static final String _CDWJZW = "CDwjzw";
	public static final String _NXSSX = "NXssx";



	protected void initDao() {
		//do nothing
	}
    
    public void save(RysxJtxx transientInstance) {
        log.debug("saving RysxJtxx instance");
        try {
            getHibernateTemplate().save(transientInstance);
            log.debug("save successful");
        } catch (RuntimeException re) {
            log.error("save failed", re);
            throw re;
        }
    }
    
	public void delete(RysxJtxx persistentInstance) {
        log.debug("deleting RysxJtxx instance");
        try {
            getHibernateTemplate().delete(persistentInstance);
            log.debug("delete successful");
        } catch (RuntimeException re) {
            log.error("delete failed", re);
            throw re;
        }
    }
    
    public RysxJtxx findById( nju.software.fyrs.data.dataobject.RysxJtxxId id) {
        log.debug("getting RysxJtxx instance with id: " + id);
        try {
            RysxJtxx instance = (RysxJtxx) getHibernateTemplate()
                    .get("software.fyrs.data.RysxJtxx", id);
            return instance;
        } catch (RuntimeException re) {
            log.error("get failed", re);
            throw re;
        }
    }
    
    
    @SuppressWarnings("unchecked")
	public List<RysxJtxx> findByExample(RysxJtxx instance) {
        log.debug("finding RysxJtxx instance by example");
        try {
            List<RysxJtxx> results = (List<RysxJtxx>) getHibernateTemplate().findByExample(instance); 
            log.debug("find by example successful, result size: " + results.size());
            return results;
        } catch (RuntimeException re) {
            log.error("find by example failed", re);
            throw re;
        }
    }    
    
    @SuppressWarnings("rawtypes")
	public List findByProperty(String propertyName, Object value) {
      log.debug("finding RysxJtxx instance with property: " + propertyName
            + ", value: " + value);
      try {
         String queryString = "from RysxJtxx as model where model." 
         						+ propertyName + "= ?";
		 return getHibernateTemplate().find(queryString, value);
      } catch (RuntimeException re) {
         log.error("find by property name failed", re);
         throw re;
      }
	}

	@SuppressWarnings("unchecked")
	public List<RysxJtxx> findByCXm(Object CXm
	) {
		return findByProperty(_CXM, CXm
		);
	}
	
	@SuppressWarnings("unchecked")
	public List<RysxJtxx> findByNYbrgx(Object NYbrgx
	) {
		return findByProperty(_NYBRGX, NYbrgx
		);
	}
	
	@SuppressWarnings("unchecked")
	public List<RysxJtxx> findByNZzmm(Object NZzmm
	) {
		return findByProperty(_NZZMM, NZzmm
		);
	}
	
	@SuppressWarnings("unchecked")
	public List<RysxJtxx> findByCJtdh(Object CJtdh
	) {
		return findByProperty(_CJTDH, CJtdh
		);
	}
	
	@SuppressWarnings("unchecked")
	public List<RysxJtxx> findByCYzbm(Object CYzbm
	) {
		return findByProperty(_CYZBM, CYzbm
		);
	}
	
	@SuppressWarnings("unchecked")
	public List<RysxJtxx> findByNZfmj(Object NZfmj
	) {
		return findByProperty(_NZFMJ, NZfmj
		);
	}
	
	@SuppressWarnings("unchecked")
	public List<RysxJtxx> findByCJtzz(Object CJtzz
	) {
		return findByProperty(_CJTZZ, CJtzz
		);
	}
	
	@SuppressWarnings("unchecked")
	public List<RysxJtxx> findByCDwjzw(Object CDwjzw
	) {
		return findByProperty(_CDWJZW, CDwjzw
		);
	}
	
	@SuppressWarnings("unchecked")
	public List<RysxJtxx> findByNXssx(Object NXssx
	) {
		return findByProperty(_NXSSX, NXssx
		);
	}
	

	@SuppressWarnings("rawtypes")
	public List findAll() {
		log.debug("finding all RysxJtxx instances");
		try {
			String queryString = "from RysxJtxx";
		 	return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}
	
    public RysxJtxx merge(RysxJtxx detachedInstance) {
        log.debug("merging RysxJtxx instance");
        try {
            RysxJtxx result = (RysxJtxx) getHibernateTemplate()
                    .merge(detachedInstance);
            log.debug("merge successful");
            return result;
        } catch (RuntimeException re) {
            log.error("merge failed", re);
            throw re;
        }
    }

    public void attachDirty(RysxJtxx instance) {
        log.debug("attaching dirty RysxJtxx instance");
        try {
            getHibernateTemplate().saveOrUpdate(instance);
            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }
    
    public void attachClean(RysxJtxx instance) {
        log.debug("attaching clean RysxJtxx instance");
        try {
            getHibernateTemplate().lock(instance, LockMode.NONE);
            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }

	public static RysxJtxxDAO getFromApplicationContext(ApplicationContext ctx) {
    	return (RysxJtxxDAO) ctx.getBean("RysxJtxxDAO");
	}
	
	@SuppressWarnings("unchecked")
	public List<RysxJtxx> getJtxxByRybh(String rybh){
		int nrybh = Integer.parseInt(rybh);
		String hql = "from RysxJtxx where NRybh="+nrybh;
		List<RysxJtxx> listRysxJtxx = getHibernateTemplate().find(hql);
		return listRysxJtxx;
	}
	
	
	public RysxJtxx getRsJtxxById(String id,String fydm,String rybh){
		String hql = "from RysxJtxx where NId=? and NFy=? and NRybh=?";
		BigDecimal bigDecimal = new BigDecimal(id);
		return (RysxJtxx)getSession().createQuery(hql).setParameter(0,bigDecimal).setParameter(1,Integer.valueOf(fydm)).setParameter(2, Integer.valueOf(rybh)).uniqueResult();
	}
	
	@SuppressWarnings("unchecked")
	public boolean delRsJtxxById(String rybh,String bh){
		String hql = "from RysxJtxx where NRybh=? and NId=?";
		int nrybh = Integer.parseInt(rybh);
		BigDecimal bd = new BigDecimal(bh);
		List<RysxJtxx> RsJtxxList = getHibernateTemplate().find(hql,nrybh,bd);
		if(RsJtxxList==null||RsJtxxList.size()==0){
			return false;
		}else{
			RysxJtxx rsJtxx = RsJtxxList.get(0);
			getHibernateTemplate().delete(rsJtxx);
			return true;
		}
	}
	
	public boolean updateRsJtxx(RysxJtxx rysxJtxx){
		if(rysxJtxx==null){
			return false;
		}else{
			getHibernateTemplate().update(rysxJtxx);
			return true;
		}
	}
	
	public boolean interceptAddJtxx(RysxJtxx rysxJtxx){
		try
		{
			getSession().save(rysxJtxx);
			getSession().flush();
			return true;
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
			return false;
		}
		
	}
	
	public boolean interceptUpdateJtxx(RysxJtxx rysxJtxx){
		try
		{
			getSession().update(rysxJtxx);
			getSession().flush();
			return true;
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
			return false;
		}
		
	}
	
	public boolean interceptDeleteRsJtxxById(RysxJtxx rysxJtxx){
		try
		{
			getSession().delete(rysxJtxx);
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
	public List<RysxJtxx> getJtxxByRybhFy(int rybh,int fydm){
		return getSession().createQuery("from RysxJtxx rj where rj.NFy=? and rj.NRybh=?").setParameter(0,Integer.valueOf(fydm)).setParameter(1,Integer.valueOf(rybh)).list();
	}
	
	public RysxJtxx findByFyRybhId(int fy,int rybh,BigDecimal id)
	{
	   return (RysxJtxx)getSession().createQuery("from RysxJtxx rj where rj.NFy = ? and rj.NRybh = ? and rj.NId = ? ").setParameter(0,fy).setParameter(1, rybh).setParameter(2,id).uniqueResult();	
	}
	public BigDecimal getMaxNid(int fydm)
	{
		String hql = "select max(N_ID) from T_RYSX_JTXX";
		return DaoUtils.getMaxIdRyjbxx(getSession(), fydm, hql);
		
	}
}