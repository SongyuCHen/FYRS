package nju.software.fyrs.data.dao;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import nju.software.fyrs.data.dataobject.YyglPxjh;

import org.hibernate.LockMode;
import org.hibernate.connection.ConnectionProvider;
import org.hibernate.impl.SessionFactoryImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

public class YyglPxjhDAO extends HibernateDaoSupport {
	private static final Logger log = LoggerFactory
			.getLogger(YyglPxjhDAO.class);

	protected void initDao() {
		// do nothing
	}

	public void save(YyglPxjh transientInstance) {
		log.debug("saving YyglPxjh instance");
		try {
			getHibernateTemplate().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(YyglPxjh persistentInstance) {
		log.debug("deleting YyglPxjh instance");
		try {
			getHibernateTemplate().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}
	
	public void update(YyglPxjh persistentInstance){
		log.debug("update YyglPxjh instance");
		try {
			getHibernateTemplate().update(persistentInstance);
			log.debug("update successful");
		} catch (RuntimeException re) {
			log.error("update failed",re);
			throw re;
		}
	}

	public YyglPxjh findById(java.lang.Integer id) {
		log.debug("getting YyglPxjh instance with id: " + id);
		try {
			YyglPxjh instance = (YyglPxjh) getHibernateTemplate().get(
					"nju.software.fyrs.data.dataobject.YyglPxjh", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	@SuppressWarnings("unchecked")
	public List<YyglPxjh> findByExample(YyglPxjh instance) {
		log.debug("finding YyglPxjh instance by example");
		try {
			List<YyglPxjh> results = (List<YyglPxjh>) getHibernateTemplate()
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
		log.debug("finding YyglPxjh instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from YyglPxjh as model where model."
					+ propertyName + "= ?";
			return getHibernateTemplate().find(queryString, value);
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	@SuppressWarnings("rawtypes")
	public List findAll() {
		log.debug("finding all YyglPxjh instances");
		try {
			String queryString = "from YyglPxjh";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public YyglPxjh merge(YyglPxjh detachedInstance) {
		log.debug("merging YyglPxjh instance");
		try {
			YyglPxjh result = (YyglPxjh) getHibernateTemplate().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(YyglPxjh instance) {
		log.debug("attaching dirty YyglPxjh instance");
		try {
			getHibernateTemplate().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(YyglPxjh instance) {
		log.debug("attaching clean YyglPxjh instance");
		try {
			getHibernateTemplate().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public static YyglPxjhDAO getFromApplicationContext(ApplicationContext ctx) {
		return (YyglPxjhDAO) ctx.getBean("YyglPxjhDAO");
	}
	
	
	

	
	public String execsql(String bmdm,String lbbh){
		SessionFactoryImpl impl = (SessionFactoryImpl) getSessionFactory();
		ConnectionProvider provider = impl.getConnectionProvider();
		String sql = "select DMMS from PUB_DMB where LBBH = '"+lbbh+"' and DMBH ='"+bmdm+"'";
		String s = "";
		try {
			Connection conn = provider.getConnection();
			Statement sta = conn.createStatement();
			ResultSet rs = sta.executeQuery(sql);
			while (rs.next()) {
				s = rs.getString(1);

			}
			rs.close();
			sta.close();
			conn.close();
			provider.close();
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		return s;
	}
	
	@SuppressWarnings("unchecked")
	public int getMaxCode(){
		String hql = "select max(checkCode) from YyglPxjh";
		List<Integer> s = getHibernateTemplate().find(hql);
		return s.get(0);
	}
	
	
	

	
	@SuppressWarnings("unchecked")
	public List<YyglPxjh> getYyglPxjhByFy(String fy){
		int nfy = Integer.parseInt(fy);
		String hql = "from YyglPxjh where NFy=?";
		List<YyglPxjh> listYyglPxjh = getHibernateTemplate().find(hql,nfy);		
		return listYyglPxjh;
	}
	

	@SuppressWarnings("unchecked")
	public YyglPxjh getYyglPxjhById(String id, String fydm){

		int nfy = Integer.parseInt(fydm);
		BigDecimal bd = new BigDecimal(id);
		String hql = "from YyglPxjh where NId=? and NFy=? ";
		List<YyglPxjh> listYyglPxjh = getHibernateTemplate().find(hql,bd,nfy);		
		return listYyglPxjh.size()>0?listYyglPxjh.get(0):null;
	}
	
	
	@SuppressWarnings("unchecked")
	public boolean delYyglPxjhById(String bh){

		BigDecimal bd = new BigDecimal(bh);
		String hql = "from YyglPxjh where NId=?";
		List<YyglPxjh> listYyglPxjh = getHibernateTemplate().find(hql,bd);	
		if(listYyglPxjh==null || listYyglPxjh.size()==0){
			return false;
		}else{
			YyglPxjh rysxHt = listYyglPxjh.get(0);
			getHibernateTemplate().delete(rysxHt);
			return true;
		}
	}
}
