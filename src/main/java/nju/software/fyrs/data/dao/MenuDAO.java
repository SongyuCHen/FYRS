package nju.software.fyrs.data.dao;

import java.util.List;

import nju.software.fyrs.data.dataobject.Menu;

import org.hibernate.LockMode;
import org.hibernate.Session;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

/**
 * A data access object (DAO) providing persistence and search support for Menu
 * entities. Transaction control of the save(), update() and delete() operations
 * can directly support Spring container-managed transactions or they can be
 * augmented to handle user-managed Spring transactions. Each of these methods
 * provides additional information for how to configure it for the desired type
 * of transaction control.
 * 
 * @see nju.software.fyrs.data.dataobject.Menu
 * @author MyEclipse Persistence Tools
 */

public class MenuDAO extends HibernateDaoSupport {
	private static final Logger log = LoggerFactory.getLogger(MenuDAO.class);
	// property constants
	public static final String HREF = "href";
	public static final String MENU_NAME = "menuName";
	public static final String MENU_TYPE = "menuType";
	public static final String ORDER_NUMBER = "orderNumber";
	public static final String UNIQUE_NAME = "uniqueName";

	protected void initDao() {
		// do nothing
	}

	public void save(Menu transientInstance) {
		log.debug("saving Menu instance");
		try {
			getHibernateTemplate().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}
	
	public void saveRightNow(Menu transientInstance) {
		Session s = this.getSession();
		save(transientInstance);
		s.flush();
	}

	public void delete(Menu persistentInstance) {
		log.debug("deleting Menu instance");
		try {
			getHibernateTemplate().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Menu findById(java.lang.Integer id) {
		log.debug("getting Menu instance with id: " + id);
		try {
			Menu instance = (Menu) getHibernateTemplate().get(
					"nju.software.fyrs.data.dataobject.Menu", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	@SuppressWarnings("unchecked")
	public List<Menu> findByExample(Menu instance) {
		log.debug("finding Menu instance by example");
		try {
			List<Menu> results = (List<Menu>) getHibernateTemplate()
					.findByExample(instance);
			log.debug("find by example successful, result size: "
					+ results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}

	@SuppressWarnings("rawtypes")
	public List findByProperty(String propertyName, Object value) {
		log.debug("finding Menu instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from Menu as model where model."
					+ propertyName + "= ?";
			return getHibernateTemplate().find(queryString, value);
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	@SuppressWarnings("unchecked")
	public List<Menu> findByHref(Object href) {
		return findByProperty(HREF, href);
	}

	@SuppressWarnings("unchecked")
	public List<Menu> findByMenuName(Object menuName) {
		return findByProperty(MENU_NAME, menuName);
	}

	@SuppressWarnings("unchecked")
	public List<Menu> findByMenuType(Object menuType) {
		return findByProperty(MENU_TYPE, menuType);
	}

	@SuppressWarnings("unchecked")
	public List<Menu> findByOrderNumber(Object orderNumber) {
		return findByProperty(ORDER_NUMBER, orderNumber);
	}

	@SuppressWarnings("unchecked")
	public List<Menu> findByUniqueName(Object uniqueName) {
		return findByProperty(UNIQUE_NAME, uniqueName);
	}

	@SuppressWarnings("rawtypes")
	public List findAll() {
		log.debug("finding all Menu instances");
		try {
			String queryString = "from Menu";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public Menu merge(Menu detachedInstance) {
		log.debug("merging Menu instance");
		try {
			Menu result = (Menu) getHibernateTemplate().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(Menu instance) {
		log.debug("attaching dirty Menu instance");
		try {
			getHibernateTemplate().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Menu instance) {
		log.debug("attaching clean Menu instance");
		try {
			getHibernateTemplate().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public static MenuDAO getFromApplicationContext(ApplicationContext ctx) {
		return (MenuDAO) ctx.getBean("MenuDAO");
	}
	public int getMaxId()
	{
		String hql="select max(id) from t_menu";
		return DaoUtils.getMaxId(this.getSession(), hql);
	}
	@SuppressWarnings("unchecked")
	public List<Integer> getMenuTopIds()
	{
		String hql = "select m.id from Menu m where m.menu is null";
		return getSession().createQuery(hql).list();
	}
    @SuppressWarnings("unchecked")
	public List<Menu> listAllByMenuType(String menuTypeIns)
    {
    	return getSession().createQuery(" from Menu where menuType IN "+menuTypeIns+" order by orderNumber ").list();
    }
}