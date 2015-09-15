package nju.software.fyrs.data.dao;

import java.math.BigDecimal;
import java.util.List;

import nju.software.fyrs.data.dataobject.SdcxCondition;

import org.hibernate.LockMode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

/**
 * A data access object (DAO) providing persistence and search support for
 * SdcxCondition entities. Transaction control of the save(), update() and
 * delete() operations can directly support Spring container-managed
 * transactions or they can be augmented to handle user-managed Spring
 * transactions. Each of these methods provides additional information for how
 * to configure it for the desired type of transaction control.
 * 
 * @see nju.software.fyrs.data.dataobject.SdcxCondition
 * @author MyEclipse Persistence Tools
 */

public class SdcxConditionDAO extends HibernateDaoSupport
{
	private static final Logger log = LoggerFactory
			.getLogger(SdcxConditionDAO.class);
	// property constants
	public static final String _NFY = "NFy";
	public static final String _NRYBH = "NRybh";
	public static final String _TCONDITON = "TConditon";
	public static final String _NRYK = "NRyk";
	public static final String _CTJMC = "CTjmc";

	protected void initDao()
	{
		// do nothing
	}

	public void save(SdcxCondition transientInstance)
	{
		log.debug("saving SdcxCondition instance");
		try
		{
			getHibernateTemplate().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re)
		{
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(SdcxCondition persistentInstance)
	{
		log.debug("deleting SdcxCondition instance");
		try
		{
			getHibernateTemplate().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re)
		{
			log.error("delete failed", re);
			throw re;
		}
	}

	public SdcxCondition findById(java.math.BigDecimal id)
	{
		log.debug("getting SdcxCondition instance with id: " + id);
		try
		{
			SdcxCondition instance = (SdcxCondition) getHibernateTemplate()
					.get("nju.software.fyrs.data.dataobject.SdcxCondition", id);
			return instance;
		} catch (RuntimeException re)
		{
			log.error("get failed", re);
			throw re;
		}
	}

	@SuppressWarnings("unchecked")
	public List<SdcxCondition> findByExample(SdcxCondition instance)
	{
		log.debug("finding SdcxCondition instance by example");
		try
		{
			List<SdcxCondition> results = (List<SdcxCondition>) getHibernateTemplate()
					.findByExample(instance);
			log.debug("find by example successful, result size: "
					+ results.size());
			return results;
		} catch (RuntimeException re)
		{
			log.error("find by example failed", re);
			throw re;
		}
	}

	@SuppressWarnings("rawtypes")
	public List findByProperty(String propertyName, Object value)
	{
		log.debug("finding SdcxCondition instance with property: "
				+ propertyName + ", value: " + value);
		try
		{
			String queryString = "from SdcxCondition as model where model."
					+ propertyName + "= ?";
			return getHibernateTemplate().find(queryString, value);
		} catch (RuntimeException re)
		{
			log.error("find by property name failed", re);
			throw re;
		}
	}

	@SuppressWarnings("unchecked")
	public List<SdcxCondition> findByNFy(Object NFy)
	{
		return findByProperty(_NFY, NFy);
	}

	@SuppressWarnings("unchecked")
	public List<SdcxCondition> findByNRybh(Object NRybh)
	{
		return findByProperty(_NRYBH, NRybh);
	}

	@SuppressWarnings("unchecked")
	public List<SdcxCondition> findByTConditon(Object TConditon)
	{
		return findByProperty(_TCONDITON, TConditon);
	}

	@SuppressWarnings("unchecked")
	public List<SdcxCondition> findByNRyk(Object NRyk)
	{
		return findByProperty(_NRYK, NRyk);
	}

	@SuppressWarnings("unchecked")
	public List<SdcxCondition> findByCTjmc(Object CTjmc)
	{
		return findByProperty(_CTJMC, CTjmc);
	}

	@SuppressWarnings("rawtypes")
	public List findAll()
	{
		log.debug("finding all SdcxCondition instances");
		try
		{
			String queryString = "from SdcxCondition";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re)
		{
			log.error("find all failed", re);
			throw re;
		}
	}

	public SdcxCondition merge(SdcxCondition detachedInstance)
	{
		log.debug("merging SdcxCondition instance");
		try
		{
			SdcxCondition result = (SdcxCondition) getHibernateTemplate()
					.merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re)
		{
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(SdcxCondition instance)
	{
		log.debug("attaching dirty SdcxCondition instance");
		try
		{
			getHibernateTemplate().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re)
		{
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(SdcxCondition instance)
	{
		log.debug("attaching clean SdcxCondition instance");
		try
		{
			getHibernateTemplate().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re)
		{
			log.error("attach failed", re);
			throw re;
		}
	}
	public BigDecimal getMaxIdBigDecimal()
	{
		return DaoUtils.getMaxIdBigDecimal(getSession(),"select max(N_ID) from T_SDCX_CONDITION");
	}
	public static SdcxConditionDAO getFromApplicationContext(
			ApplicationContext ctx)
	{
		return (SdcxConditionDAO) ctx.getBean("SdcxConditionDAO");
	}

	@SuppressWarnings("unchecked")
	public List<SdcxCondition> listAll(int fydm, int rybh)
	{
		return getSession().createQuery(" from SdcxCondition where NFy = ? AND NRybh = ? ").setParameter(0, fydm).setParameter(1, rybh).list();
	}

	public void deleteAll(String fydm, String rybh)
	{
	   getSession().createSQLQuery(" DELETE FROM T_SDCX_CONDITION  WHERE N_FY = ? AND N_RYBH = ? ").setParameter(0, Integer.valueOf(fydm)).setParameter(1,Integer.valueOf(rybh)).executeUpdate();
	}

	public SdcxCondition findByIdFydmRybh(String id, String fydm, String rybh)
	{
		return (SdcxCondition) getSession().createQuery(" from SdcxCondition where N_ID = ? AND NFy = ? AND NRybh = ?").setParameter(0,BigDecimal.valueOf(Integer.valueOf(id))).setParameter(1,Integer.valueOf(fydm)).setParameter(2,Integer.valueOf(rybh)).uniqueResult();
		
	}
}