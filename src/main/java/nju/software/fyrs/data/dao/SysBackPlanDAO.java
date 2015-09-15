package nju.software.fyrs.data.dao;

import java.util.List;

import nju.software.fyrs.data.dataobject.SysBackPlan;

import org.hibernate.LockMode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

/**
 * A data access object (DAO) providing persistence and search support for
 * SysBackPlan entities. Transaction control of the save(), update() and
 * delete() operations can directly support Spring container-managed
 * transactions or they can be augmented to handle user-managed Spring
 * transactions. Each of these methods provides additional information for how
 * to configure it for the desired type of transaction control.
 * 
 * @see nju.software.fyrs.data.dataobject.SysBackPlan
 * @author MyEclipse Persistence Tools
 */

public class SysBackPlanDAO extends HibernateDaoSupport
{
	private static final Logger log = LoggerFactory
			.getLogger(SysBackPlanDAO.class);
	// property constants
	public static final String _NFREQUENCY = "NFrequency";
	public static final String _NBLFS = "NBlfs";

	protected void initDao()
	{
		// do nothing
	}

	public void save(SysBackPlan transientInstance)
	{
		log.debug("saving SysBackPlan instance");
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

	public void delete(SysBackPlan persistentInstance)
	{
		log.debug("deleting SysBackPlan instance");
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

	public SysBackPlan findById(Long id)
	{
		log.debug("getting SysBackPlan instance with id: " + id);
		try
		{
			SysBackPlan instance = (SysBackPlan) getHibernateTemplate().get(
					"nju.software.fyrs.data.dataobject.SysBackPlan", id);
			return instance;
		} catch (RuntimeException re)
		{
			log.error("get failed", re);
			throw re;
		}
	}

	@SuppressWarnings("unchecked")
	public List<SysBackPlan> findByExample(SysBackPlan instance)
	{
		log.debug("finding SysBackPlan instance by example");
		try
		{
			List<SysBackPlan> results = (List<SysBackPlan>) getHibernateTemplate()
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
		log.debug("finding SysBackPlan instance with property: " + propertyName
				+ ", value: " + value);
		try
		{
			String queryString = "from SysBackPlan as model where model."
					+ propertyName + "= ?";
			return getHibernateTemplate().find(queryString, value);
		} catch (RuntimeException re)
		{
			log.error("find by property name failed", re);
			throw re;
		}
	}

	@SuppressWarnings("unchecked")
	public List<SysBackPlan> findByNFrequency(Object NFrequency)
	{
		return findByProperty(_NFREQUENCY, NFrequency);
	}

	@SuppressWarnings("unchecked")
	public List<SysBackPlan> findByNBlfs(Object NBlfs)
	{
		return findByProperty(_NBLFS, NBlfs);
	}

	@SuppressWarnings("rawtypes")
	public List findAll()
	{
		log.debug("finding all SysBackPlan instances");
		try
		{
			String queryString = "from SysBackPlan";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re)
		{
			log.error("find all failed", re);
			throw re;
		}
	}

	public SysBackPlan merge(SysBackPlan detachedInstance)
	{
		log.debug("merging SysBackPlan instance");
		try
		{
			SysBackPlan result = (SysBackPlan) getHibernateTemplate().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re)
		{
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(SysBackPlan instance)
	{
		log.debug("attaching dirty SysBackPlan instance");
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

	public void attachClean(SysBackPlan instance)
	{
		log.debug("attaching clean SysBackPlan instance");
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

	public static SysBackPlanDAO getFromApplicationContext(
			ApplicationContext ctx)
	{
		return (SysBackPlanDAO) ctx.getBean("SysBackPlanDAO");
	}
   // myCode
	@SuppressWarnings("unchecked")
	public List<SysBackPlan> listSysBackPlans()
	{		
		return getSession().createQuery("from SysBackPlan").list();
	}
	public void updateSysBackPlan(SysBackPlan sysBackPlan)
	{
		SysBackPlan sysBackPlan2 = this.findById(sysBackPlan.getNId());
	    sysBackPlan2.setNBlfs(sysBackPlan.getNBlfs());
	    sysBackPlan2.setNFrequency(sysBackPlan.getNFrequency());
	    getSession().update(sysBackPlan2);
	}
	// myCode

	

	
}