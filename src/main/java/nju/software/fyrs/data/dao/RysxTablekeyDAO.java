package nju.software.fyrs.data.dao;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import nju.software.fyrs.data.dataobject.RysxTablekey;

import org.hibernate.LockMode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

/**
 * A data access object (DAO) providing persistence and search support for
 * RysxTablekey entities. Transaction control of the save(), update() and
 * delete() operations can directly support Spring container-managed
 * transactions or they can be augmented to handle user-managed Spring
 * transactions. Each of these methods provides additional information for how
 * to configure it for the desired type of transaction control.
 * 
 * @see nju.software.fyrs.data.dataobject.RysxTablekey
 * @author MyEclipse Persistence Tools
 */

public class RysxTablekeyDAO extends HibernateDaoSupport {
	private static final Logger log = LoggerFactory.getLogger(RysxTablekeyDAO.class);
	private Map<String, Object> maps = new HashMap<String, Object>();
	private Map<String, Object> init = new HashMap<String, Object>();

	// property constants

	protected void initDao()
	{
		// do nothing
	}

	public void save(RysxTablekey transientInstance)
	{
		log.debug("saving RysxTablekey instance");
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

	public void delete(RysxTablekey persistentInstance)
	{
		log.debug("deleting RysxTablekey instance");
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

	public RysxTablekey findById(java.lang.Integer id)
	{
		log.debug("getting RysxTablekey instance with id: " + id);
		try
		{
			RysxTablekey instance = (RysxTablekey) getHibernateTemplate().get("nju.software.fyrs.data.dataobject.RysxTablekey", id);
			return instance;
		} catch (RuntimeException re)
		{
			log.error("get failed", re);
			throw re;
		}
	}

	@SuppressWarnings("unchecked")
	public List<RysxTablekey> findByExample(RysxTablekey instance)
	{
		log.debug("finding RysxTablekey instance by example");
		try
		{
			List<RysxTablekey> results = (List<RysxTablekey>) getHibernateTemplate().findByExample(instance);
			log.debug("find by example successful, result size: " + results.size());
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
		log.debug("finding RysxTablekey instance with property: " + propertyName + ", value: " + value);
		try
		{
			String queryString = "from RysxTablekey as model where model." + propertyName + "= ?";
			return getHibernateTemplate().find(queryString, value);
		} catch (RuntimeException re)
		{
			log.error("find by property name failed", re);
			throw re;
		}
	}

	@SuppressWarnings("rawtypes")
	public List findAll()
	{
		log.debug("finding all RysxTablekey instances");
		try
		{
			String queryString = "from RysxTablekey";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re)
		{
			log.error("find all failed", re);
			throw re;
		}
	}

	public RysxTablekey merge(RysxTablekey detachedInstance)
	{
		log.debug("merging RysxTablekey instance");
		try
		{
			RysxTablekey result = (RysxTablekey) getHibernateTemplate().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re)
		{
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(RysxTablekey instance)
	{
		log.debug("attaching dirty RysxTablekey instance");
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

	public void attachClean(RysxTablekey instance)
	{
		log.debug("attaching clean RysxTablekey instance");
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

	public static RysxTablekeyDAO getFromApplicationContext(ApplicationContext ctx)
	{
		return (RysxTablekeyDAO) ctx.getBean("RysxTablekeyDAO");
	}

	// myCode
	public BigDecimal getMaxId(int fydm, String keyName)
	{
		if (hasInit(fydm))
		{
			String key = fydm + keyName;
			BigDecimal bigDecimal = new BigDecimal(1);
			if (maps.get(key) == null)
			{
				try
				{
					maps.put(key, Object.class.newInstance());
				} catch (Exception ex)
				{
					ex.printStackTrace();
				}

			}
			synchronized (maps.get(key))
			{
				bigDecimal = (BigDecimal) getSession().createSQLQuery("select " + keyName + " from T_RYSX_TABLE_KEY where N_ID = ?").setParameter(0, fydm).uniqueResult();
				bigDecimal = bigDecimal.add(BigDecimal.valueOf(1));
				getSession().createSQLQuery("update T_RYSX_TABLE_KEY set " + keyName + " = ?").setParameter(0, bigDecimal).executeUpdate();
			}
			return bigDecimal;
		}
		return null;
	}

	private boolean hasInit(int fydm)
	{
		Integer n_id = (Integer) getSession().createSQLQuery("SELECT N_ID FROM T_RYSX_TABLE_KEY WHERE N_ID = ?").setParameter(0, fydm).uniqueResult();
		if (n_id != null)
		{
			return true;
		}
		try
		{
			if (init.get(fydm + "") == null)
			{
				init.put(fydm + "", Object.class.newInstance());
			}
			synchronized (init.get(fydm + ""))
			{

				RysxTablekey ry = new RysxTablekey();
				BigDecimal initData = BigDecimal.valueOf(fydm, -10).add(BigDecimal.valueOf(0));
				ry.setNId(fydm);

				Field[] fields = ry.getClass().getDeclaredFields();
				for (Field f : fields)
				{
					f.setAccessible(true);
					if (f.getName().endsWith("id"))
					{
						Method method = ry.getClass().getMethod("set" + f.getName(), new Class[]
						{ BigDecimal.class });
						method.invoke(ry, initData);
					}
				}
				getSession().save(ry);
				getSession().flush();

			}

		} catch (Exception ex)
		{
			ex.printStackTrace();
			return false;
		}
		return true;
	}

	// myCode
}