package nju.software.fyrs.data.dao;

import java.util.List;

import nju.software.fyrs.data.dataobject.Menu;
import nju.software.fyrs.data.dataobject.Role;
import nju.software.fyrs.data.dataobject.RoleMenu;

import org.hibernate.LockMode;
import org.hibernate.Query;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

/**
 * A data access object (DAO) providing persistence and search support for
 * RoleMenu entities. Transaction control of the save(), update() and delete()
 * operations can directly support Spring container-managed transactions or they
 * can be augmented to handle user-managed Spring transactions. Each of these
 * methods provides additional information for how to configure it for the
 * desired type of transaction control.
 * 
 * @see nju.software.fyrs.data.dataobject.RoleMenu
 * @author MyEclipse Persistence Tools
 */

public class RoleMenuDAO extends HibernateDaoSupport {
	private static final Logger log = LoggerFactory
			.getLogger(RoleMenuDAO.class);

	// property constants

	protected void initDao() {
		// do nothing
	}

	public void save(RoleMenu transientInstance) {
		log.debug("saving RoleMenu instance");
		try {
			getHibernateTemplate().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(RoleMenu persistentInstance) {
		log.debug("deleting RoleMenu instance");
		try {
			getHibernateTemplate().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public RoleMenu findById(java.lang.Integer id) {
		log.debug("getting RoleMenu instance with id: " + id);
		try {
			RoleMenu instance = (RoleMenu) getHibernateTemplate().get(
					"nju.software.fyrs.data.dataobject.RoleMenu", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	@SuppressWarnings("unchecked")
	public List<RoleMenu> findByExample(RoleMenu instance) {
		log.debug("finding RoleMenu instance by example");
		try {
			List<RoleMenu> results = (List<RoleMenu>) getHibernateTemplate()
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
		log.debug("finding RoleMenu instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from RoleMenu as model where model."
					+ propertyName + "= ?";
			return getHibernateTemplate().find(queryString, value);
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	@SuppressWarnings("rawtypes")
	public List findAll() {
		log.debug("finding all RoleMenu instances");
		try {
			String queryString = "from RoleMenu";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public RoleMenu merge(RoleMenu detachedInstance) {
		log.debug("merging RoleMenu instance");
		try {
			RoleMenu result = (RoleMenu) getHibernateTemplate().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(RoleMenu instance) {
		log.debug("attaching dirty RoleMenu instance");
		try {
			getHibernateTemplate().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(RoleMenu instance) {
		log.debug("attaching clean RoleMenu instance");
		try {
			getHibernateTemplate().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public static RoleMenuDAO getFromApplicationContext(ApplicationContext ctx) {
		return (RoleMenuDAO) ctx.getBean("RoleMenuDAO");
	}
	/**
	 * 首先将原来的授权删除，再保存新的授权
	 * @param roleId 角色 ID
	 * @param menuIds 菜单 IDS
	 */
	@SuppressWarnings("unchecked")
	public void saveRoleMenu(int roleId,String[] menuIds)
	{
	  List<RoleMenu> roleMenus = this.getSession().createQuery("from RoleMenu rm where rm.role.id = ?").setParameter(0, roleId).list();
	  
	  for(RoleMenu roleMenu : roleMenus)
	  {
		  this.delete(roleMenu);
	  }
	  getSession().flush();
	  Role role = new Role();
	  role.setId(roleId);
	  int i = this.getMaxId() + 1;
	  for(String str : menuIds)
	  {
		  Menu menu = new Menu();
		  menu.setId(Integer.valueOf(str));
		  RoleMenu roleMenu = new RoleMenu();
		  roleMenu.setId(i);
		  roleMenu.setMenu(menu);
		  roleMenu.setRole(role);
		  this.save(roleMenu);
		  i++;
	  }
	  
	}
	/**
	 * 根据角色获得所有的菜单
	 * @param roleId
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public List<Menu> listMenuByRoleId(int roleId)
	{
		 String hql = "select rm.menu from RoleMenu rm where rm.role.id = ?";
	     return this.getSession().createQuery(hql).setParameter(0,roleId).list();
	}
	/**
	 * 根据角色和菜单的类型获得菜单
	 * @param roleId 角色的ID
	 * @param menuType 菜单的类型
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public List<Menu> listMenuByRoleIdMenuType(int[] roleIds,int menuType)
	{
		if(roleIds.length == 1)
		{
			String hql = "select rm.menu from RoleMenu rm where rm.role.id = ? and rm.menu.menuType = ? order by rm.menu.orderNumber";
			return this.getSession().createQuery(hql).setParameter(0,roleIds[0]).setParameter(1,menuType).list();
		}
		String hql_2 = "select distinct rm.menu from RoleMenu rm where (";
		for(int i = 0; i < roleIds.length; i++)
		{
			hql_2 += "rm.role.id = ? or ";
		}
		hql_2 = hql_2.substring(0,hql_2.length() - 3) + ") and rm.menu.menuType = ? order by rm.menu.orderNumber";
		Query query = this.getSession().createQuery(hql_2);
		int i = 0;
		for(; i < roleIds.length; i++)
		{
			query.setParameter(i,roleIds[i]);
		}
		query.setParameter(i,menuType);
		return query.list();
	}
	@SuppressWarnings("unchecked")
	public List<Menu> listMenuByRoleIdParentMenuName(int[] roleIds,String parentMenuName)
	{
		if(roleIds.length == 1)
		{
			String hql = "select rm.menu from RoleMenu rm where rm.role.id = ? and rm.menu.menu.uniqueName = ?";
		    return this.getSession().createQuery(hql).setParameter(0,roleIds[0]).setParameter(1,parentMenuName).list();
		}
		String hql_2 = "select distinct rm.menu from RoleMenu rm where (";
		for(int i = 0; i < roleIds.length; i++)
		{
			hql_2 += "rm.role.id = ? or ";
		}
		hql_2 = hql_2.substring(0,hql_2.length() - 3) + ")  and rm.menu.menu.uniqueName = ? order by rm.menu.orderNumber";
		Query query = this.getSession().createQuery(hql_2);
		int i = 0;
		for(; i < roleIds.length; i++)
		{
			query.setParameter(i,roleIds[i]);
		}
		query.setParameter(i,parentMenuName);
		return query.list();
		
	}
	/**
	 * 获得最大的ID
	 * @return
	 */
	public int getMaxId()
	{
		String hql="select max(id) from t_role_menu";
		return DaoUtils.getMaxId(this.getSessionFactory().getCurrentSession(), hql);
	}
	public void deleteAllData()
	{
	   String sql = "delete from t_role_user where id != 0";
	   this.getSession().createSQLQuery(sql);
	}
}