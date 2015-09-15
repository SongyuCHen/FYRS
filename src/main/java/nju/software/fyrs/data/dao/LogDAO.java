package nju.software.fyrs.data.dao;

import java.math.BigDecimal;
import java.util.Calendar;
import java.util.List;

import nju.software.fyrs.data.dataobject.Log;
import nju.software.fyrs.util.DateUtil;
import nju.software.fyrs.util.StringUtil;

import org.hibernate.LockMode;
import org.hibernate.Query;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

/**
 	* A data access object (DAO) providing persistence and search support for Log entities.
 			* Transaction control of the save(), update() and delete() operations 
		can directly support Spring container-managed transactions or they can be augmented	to handle user-managed Spring transactions. 
		Each of these methods provides additional information for how to configure it for the desired type of transaction control. 	
	 * @see nju.software.fyrs.data.dataobject.Log
  * @author MyEclipse Persistence Tools 
 */
public class LogDAO extends HibernateDaoSupport  {
	     private static final Logger log = LoggerFactory.getLogger(LogDAO.class);
		//property constants
	public static final String _CCZYH = "CCzyh";
	public static final String _NDWID = "NDwid";
	public static final String _CIP = "CIp";
	public static final String _DCZSJ = "DCzsj";
	public static final String _CCZNR = "CCznr";



	protected void initDao() {
		//do nothing
	}
    
    public void save(Log transientInstance) {
        
    	log.debug("saving Log instance");
        try {
        	
            getHibernateTemplate().save(transientInstance);
            log.debug("save successful");
        } catch (RuntimeException re) {
            log.error("save failed", re);
            throw re;
        }
    }
    
	public void delete(Log persistentInstance) {
        log.debug("deleting Log instance");
        try {
            getHibernateTemplate().delete(persistentInstance);
            log.debug("delete successful");
        } catch (RuntimeException re) {
            log.error("delete failed", re);
            throw re;
        }
    }
    
    public Log findById( java.math.BigDecimal id) {
        log.debug("getting Log instance with id: " + id);
        try {
            Log instance = (Log) getHibernateTemplate()
                    .get("software.fyrs.data.Log", id);
            return instance;
        } catch (RuntimeException re) {
            log.error("get failed", re);
            throw re;
        }
    }
    
    
    @SuppressWarnings("unchecked")
	public List<Log> findByExample(Log instance) {
        log.debug("finding Log instance by example");
        try {
            List<Log> results = (List<Log>) getHibernateTemplate().findByExample(instance); 
            log.debug("find by example successful, result size: " + results.size());
            return results;
        } catch (RuntimeException re) {
            log.error("find by example failed", re);
            throw re;
        }
    }    
    
    @SuppressWarnings("rawtypes")
	public List findByProperty(String propertyName, Object value) {
      log.debug("finding Log instance with property: " + propertyName
            + ", value: " + value);
      try {
         String queryString = "from Log as model where model." 
         						+ propertyName + "= ?";
		 return getHibernateTemplate().find(queryString, value);
      } catch (RuntimeException re) {
         log.error("find by property name failed", re);
         throw re;
      }
	}

	@SuppressWarnings("unchecked")
	public List<Log> findByCCzyh(Object CCzyh
	) {
		return findByProperty(_CCZYH, CCzyh
		);
	}
	
	@SuppressWarnings("unchecked")
	public List<Log> findByNDwid(Object NDwid
	) {
		return findByProperty(_NDWID, NDwid
		);
	}
	
	@SuppressWarnings("unchecked")
	public List<Log> findByCIp(Object CIp
	) {
		return findByProperty(_CIP, CIp
		);
	}
	
	@SuppressWarnings("unchecked")
	public List<Log> findByDCzsj(Object DCzsj
	) {
		return findByProperty(_DCZSJ, DCzsj
		);
	}
	
	@SuppressWarnings("unchecked")
	public List<Log> findByCCznr(Object CCznr
	) {
		return findByProperty(_CCZNR, CCznr
		);
	}
	

	@SuppressWarnings("rawtypes")
	public List findAll() {
		log.debug("finding all Log instances");
		try {
			String queryString = "from Log";
		 	return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}
	
    public Log merge(Log detachedInstance) {
        log.debug("merging Log instance");
        try {
            Log result = (Log) getHibernateTemplate()
                    .merge(detachedInstance);
            log.debug("merge successful");
            return result;
        } catch (RuntimeException re) {
            log.error("merge failed", re);
            throw re;
        }
    }

    public void attachDirty(Log instance) {
        log.debug("attaching dirty Log instance");
        try {
            getHibernateTemplate().saveOrUpdate(instance);
            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }
    
    public void attachClean(Log instance) {
        log.debug("attaching clean Log instance");
        try {
            getHibernateTemplate().lock(instance, LockMode.NONE);
            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }

	public static LogDAO getFromApplicationContext(ApplicationContext ctx) {
    	return (LogDAO) ctx.getBean("LogDAO");
	}
	// 
	   // myCode
			@SuppressWarnings("unchecked")
			public List<Log> listByTimeOperUser(String operUser,
					String operBeginTime, String operEndTime, String operType)
					{
				      List<Log> logs = null;
				      Object[] strArray = {null,null,null,null,null,null};
				      String before = "from Log log where ";
				      String hql = "";
				      boolean isWhere = false;
				      if(!StringUtil.isEmpty(operUser))
				      {
				    	  hql += "and log.CCzyh = ? ";
				    	  strArray[0] = operUser;
				    	  isWhere = true;
				      }
				      // 两个时间值都有
				      if(!StringUtil.isEmpty(operBeginTime) && !StringUtil.isEmpty(operEndTime))
				      {
				    	  hql += "and log.DCzsj >= ? and log.DCzsj <= ?";			
				    	  strArray[1] = DateUtil.parse(operBeginTime,"yyyy-MM-dd");
				    	  strArray[2] = DateUtil.add(DateUtil.parse(operEndTime, "yyyy-MM-dd"),Calendar.DATE,1);
				    	  isWhere = true;
				      }
				      // 说明只有后面时间是空的
				      if(!StringUtil.isEmpty(operBeginTime) && StringUtil.isEmpty(operEndTime))
				      {
				    	  hql += "and log.DCzsj >= ? ";
				    	  strArray[3] = DateUtil.parse(operBeginTime,"yyyy-MM-dd");
				    	  isWhere = true;
				      }
				      // 说明是前面时间是空的
				      if( !StringUtil.isEmpty(operEndTime) && StringUtil.isEmpty(operBeginTime))
				      {
				    	  hql += "and log.DCzsj <= ? ";
				    	  strArray[4] = DateUtil.add(DateUtil.parse(operEndTime, "yyyy-MM-dd"),Calendar.DATE,1);
				    	  isWhere = true;
				      }
				      if(!StringUtil.isEmpty(operType))
				      {
				    	  // "修改"   --- 1 ,"清空"  --- 2,"登录系统" --- 3
				    	  String[] types = {"修改","清空","登录系统"};
				    	  hql += "and log.CCznr like ? ";
				    	  strArray[5] = types[Integer.valueOf(operType) - 1]+"%";
				    	  isWhere = true;
				      }
				      if(!isWhere)
				      {
				    	  logs = getSession().createQuery(" from Log order by DCzsj desc ").list();
				      }
				      else
				      {
				    	 hql = hql.substring(3, hql.length());
				    	 Query query = getSession().createQuery(before + hql + " order by DCzsj desc ");
				    	 int i = 0;
				    	 for(Object obj : strArray)
				    	 {
				    		 if(null != obj)
				    		 {
				    			 query.setParameter(i,obj);
				    			 i++;
				    		 }
				    	 }
				    	 logs = query.list();
				      }
				      
				      return logs;
				  }
	public BigDecimal getMaxId()
	{
		
		String hql = "select max(N_ID) from T_LOG";
		Query query = this.getSession().createSQLQuery(hql);
		Object object = query.uniqueResult();
		BigDecimal maxBh = BigDecimal.valueOf(1);
		if(null != object)
		{
			maxBh = (BigDecimal)object;
		}
		return maxBh;
	}
	
}