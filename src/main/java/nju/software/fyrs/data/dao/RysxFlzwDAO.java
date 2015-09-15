package nju.software.fyrs.data.dao;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import nju.software.fyrs.biz.vo.PrimaryKeyFyRybhVO;
import nju.software.fyrs.data.dataobject.RysxFlzw;

import org.hibernate.LockMode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

/**
 	* A data access object (DAO) providing persistence and search support for RysxFlzw entities.
 			* Transaction control of the save(), update() and delete() operations 
		can directly support Spring container-managed transactions or they can be augmented	to handle user-managed Spring transactions. 
		Each of these methods provides additional information for how to configure it for the desired type of transaction control. 	
	 * @see nju.software.fyrs.data.dataobject.RysxFlzw
  * @author MyEclipse Persistence Tools 
 */
public class RysxFlzwDAO extends HibernateDaoSupport  {
	     private static final Logger log = LoggerFactory.getLogger(RysxFlzwDAO.class);
		//property constants
	public static final String _NRMLB = "NRmlb";
	public static final String _NFLZW = "NFlzw";
	public static final String _CDW = "CDw";
	public static final String _CBM = "CBm";
	public static final String _NRMYY = "NRmyy";
	public static final String _CPZDW = "CPzdw";
	public static final String _CPZWH = "CPzwh";
	public static final String _NCRFG = "NCrfg";
	public static final String _NCRFGNX = "NCrfgnx";
	public static final String _NFLGZQK = "NFlgzqk";
	public static final String _NFLZYZS = "NFlzyzs";
	public static final String _NFLZYZSQK = "NFlzyzsqk";
	public static final String _NDQXX = "NDqxx";
	public static final String _CJLID = "CJlid";
	public static final String _NXSSX = "NXssx";



	protected void initDao() {
		//do nothing
	}
    
    public void save(RysxFlzw transientInstance) {
        log.debug("saving RysxFlzw instance");
        try {
            getHibernateTemplate().save(transientInstance);
            log.debug("save successful");
        } catch (RuntimeException re) {
            log.error("save failed", re);
            throw re;
        }
    }
    
	public void delete(RysxFlzw persistentInstance) {
        log.debug("deleting RysxFlzw instance");
        try {
            getHibernateTemplate().delete(persistentInstance);
            log.debug("delete successful");
        } catch (RuntimeException re) {
            log.error("delete failed", re);
            throw re;
        }
    }
    
    public RysxFlzw findById( nju.software.fyrs.data.dataobject.RysxFlzwId id) {
        log.debug("getting RysxFlzw instance with id: " + id);
        try {
            RysxFlzw instance = (RysxFlzw) getHibernateTemplate()
                    .get("software.fyrs.data.RysxFlzw", id);
            return instance;
        } catch (RuntimeException re) {
            log.error("get failed", re);
            throw re;
        }
    }
    
    
    @SuppressWarnings("unchecked")
	public List<RysxFlzw> findByExample(RysxFlzw instance) {
        log.debug("finding RysxFlzw instance by example");
        try {
            List<RysxFlzw> results = (List<RysxFlzw>) getHibernateTemplate().findByExample(instance); 
            log.debug("find by example successful, result size: " + results.size());
            return results;
        } catch (RuntimeException re) {
            log.error("find by example failed", re);
            throw re;
        }
    }    
    
    @SuppressWarnings("rawtypes")
	public List findByProperty(String propertyName, Object value) {
      log.debug("finding RysxFlzw instance with property: " + propertyName
            + ", value: " + value);
      try {
         String queryString = "from RysxFlzw as model where model." 
         						+ propertyName + "= ?";
		 return getHibernateTemplate().find(queryString, value);
      } catch (RuntimeException re) {
         log.error("find by property name failed", re);
         throw re;
      }
	}

	@SuppressWarnings("unchecked")
	public List<RysxFlzw> findByNRmlb(Object NRmlb
	) {
		return findByProperty(_NRMLB, NRmlb
		);
	}
	
	@SuppressWarnings("unchecked")
	public List<RysxFlzw> findByNFlzw(Object NFlzw
	) {
		return findByProperty(_NFLZW, NFlzw
		);
	}
	
	@SuppressWarnings("unchecked")
	public List<RysxFlzw> findByCDw(Object CDw
	) {
		return findByProperty(_CDW, CDw
		);
	}
	
	@SuppressWarnings("unchecked")
	public List<RysxFlzw> findByCBm(Object CBm
	) {
		return findByProperty(_CBM, CBm
		);
	}
	
	@SuppressWarnings("unchecked")
	public List<RysxFlzw> findByNRmyy(Object NRmyy
	) {
		return findByProperty(_NRMYY, NRmyy
		);
	}
	
	@SuppressWarnings("unchecked")
	public List<RysxFlzw> findByCPzdw(Object CPzdw
	) {
		return findByProperty(_CPZDW, CPzdw
		);
	}
	
	@SuppressWarnings("unchecked")
	public List<RysxFlzw> findByCPzwh(Object CPzwh
	) {
		return findByProperty(_CPZWH, CPzwh
		);
	}
	
	@SuppressWarnings("unchecked")
	public List<RysxFlzw> findByNCrfg(Object NCrfg
	) {
		return findByProperty(_NCRFG, NCrfg
		);
	}
	
	@SuppressWarnings("unchecked")
	public List<RysxFlzw> findByNCrfgnx(Object NCrfgnx
	) {
		return findByProperty(_NCRFGNX, NCrfgnx
		);
	}
	
	@SuppressWarnings("unchecked")
	public List<RysxFlzw> findByNFlgzqk(Object NFlgzqk
	) {
		return findByProperty(_NFLGZQK, NFlgzqk
		);
	}
	
	@SuppressWarnings("unchecked")
	public List<RysxFlzw> findByNFlzyzs(Object NFlzyzs
	) {
		return findByProperty(_NFLZYZS, NFlzyzs
		);
	}
	
	@SuppressWarnings("unchecked")
	public List<RysxFlzw> findByNFlzyzsqk(Object NFlzyzsqk
	) {
		return findByProperty(_NFLZYZSQK, NFlzyzsqk
		);
	}
	
	@SuppressWarnings("unchecked")
	public List<RysxFlzw> findByNDqxx(Object NDqxx
	) {
		return findByProperty(_NDQXX, NDqxx
		);
	}
	
	@SuppressWarnings("unchecked")
	public List<RysxFlzw> findByCJlid(Object CJlid
	) {
		return findByProperty(_CJLID, CJlid
		);
	}
	
	@SuppressWarnings("unchecked")
	public List<RysxFlzw> findByNXssx(Object NXssx
	) {
		return findByProperty(_NXSSX, NXssx
		);
	}
	

	@SuppressWarnings("rawtypes")
	public List findAll() {
		log.debug("finding all RysxFlzw instances");
		try {
			String queryString = "from RysxFlzw";
		 	return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}
	
    public RysxFlzw merge(RysxFlzw detachedInstance) {
        log.debug("merging RysxFlzw instance");
        try {
            RysxFlzw result = (RysxFlzw) getHibernateTemplate()
                    .merge(detachedInstance);
            log.debug("merge successful");
            return result;
        } catch (RuntimeException re) {
            log.error("merge failed", re);
            throw re;
        }
    }

    public void attachDirty(RysxFlzw instance) {
        log.debug("attaching dirty RysxFlzw instance");
        try {
            getHibernateTemplate().saveOrUpdate(instance);
            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }
    
    public void attachClean(RysxFlzw instance) {
        log.debug("attaching clean RysxFlzw instance");
        try {
            getHibernateTemplate().lock(instance, LockMode.NONE);
            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }

	public static RysxFlzwDAO getFromApplicationContext(ApplicationContext ctx) {
    	return (RysxFlzwDAO) ctx.getBean("RysxFlzwDAO");
	}
	
	@SuppressWarnings("unchecked")
	public List<RysxFlzw> getFlzwByRybh(String rybh){
		String hql = "from RysxFlzw where NRybh="+Integer.parseInt(rybh);
		List<RysxFlzw> flzwList = getHibernateTemplate().find(hql);
		return flzwList;
	}
	
	public RysxFlzw getRsFlzwById(String id,String fydm,String rybh){
		String hql = "from RysxFlzw where NId=? and NFy=? and NRybh=?";
		BigDecimal bigDecimal = new BigDecimal(id);
		return (RysxFlzw)getSession().createQuery(hql).setParameter(0,bigDecimal).setParameter(1,Integer.valueOf(fydm)).setParameter(2, Integer.valueOf(rybh)).uniqueResult();
	}
	
	@SuppressWarnings("unchecked")
	public boolean delRsFlzwById(String rybh,String bh){
		String hql = "from RysxFlzw where NRybh=? and NId=?";
		int nrybh = Integer.parseInt(rybh);
		BigDecimal bd1 = new BigDecimal(bh);
		List<RysxFlzw> rsFlzwList = getHibernateTemplate().find(hql,nrybh,bd1);
		if(rsFlzwList==null||rsFlzwList.size()==0){
			return false;
		}else{
			RysxFlzw rsFlzw = rsFlzwList.get(0);
			getHibernateTemplate().delete(rsFlzw);
			return true;
		}
	}
	
	public boolean updateRsFlzw(RysxFlzw rysxFlzw){
		if(rysxFlzw==null){
			return false;
		}else{
			getHibernateTemplate().update(rysxFlzw);
			return true;
		}
	}
    // myCode
	public List<PrimaryKeyFyRybhVO> listByFlzw(int flzw) {
		String sql = "select n_fy,n_rybh from t_rysx_flzw where n_flzw = ?";
		List<PrimaryKeyFyRybhVO> results = new ArrayList<PrimaryKeyFyRybhVO>();
		@SuppressWarnings("unchecked")
		List<Object[]> list = (List<Object[]>) getSession().createSQLQuery(sql).setParameter(0, flzw);
		for(Object[] obj : list)
		{
			PrimaryKeyFyRybhVO vo = new PrimaryKeyFyRybhVO();
			vo.setNFy((Integer)obj[0]);
			vo.setNRybh((Integer)obj[1]);
			results.add(vo);
		}
		return results;
	}

	//À¹½Ø
		public boolean interceptAddFlzw(RysxFlzw rysxFlzw){
			try
			{
				getSession().save(rysxFlzw);
				getSession().flush();
				return true;
			}
			catch(Exception ex)
			{
				ex.printStackTrace();
				return false;
			}
			
		}
		
		public boolean interceptUpdateFlzw(RysxFlzw rysxFlzw){
			try
			{
				getSession().update(rysxFlzw);
				getSession().flush();
				return true;
			}
			catch(Exception ex)
			{
				ex.printStackTrace();
				return false;
			}
		}
		
		public boolean interceptDeleteRsFlzwById(RysxFlzw rysxFlzw){
			try
			{
				getSession().delete(rysxFlzw);
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
		public List<RysxFlzw> getFlzwByRybhFy(int fydm,int rybh){
			return getSession().createQuery("from RysxFlzw rf where rf.NFy=? and rf.NRybh=?").setParameter(0,Integer.valueOf(fydm)).setParameter(1,Integer.valueOf(rybh)).list();
		}
		
		public RysxFlzw findByFyRybhId(int fy,int rybh,BigDecimal id)
		{
		   return (RysxFlzw)getSession().createQuery("from RysxFlzw rf where rf.NFy = ? and rf.NRybh = ? and rf.NId = ? ")
				   .setParameter(0,fy)
				   .setParameter(1, rybh)
				   .setParameter(2,id).uniqueResult();	
		}
		public BigDecimal getMaxNid(int fydm)
		{
			String hql = "select max(N_ID) from T_RYSX_FLZW";
			return DaoUtils.getMaxIdRyjbxx(getSession(), fydm, hql);
			
		}

}