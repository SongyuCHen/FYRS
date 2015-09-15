package nju.software.fyrs.data.dao;

import java.util.List;
import java.math.BigDecimal;
import nju.software.fyrs.data.dataobject.YyglZhaolu;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.hibernate.LockMode;
import org.hibernate.connection.ConnectionProvider;
import org.hibernate.impl.SessionFactoryImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
public class YyglZhaoluDAO extends HibernateDaoSupport {
	private static final Logger log = LoggerFactory
			.getLogger(YyglZhaoluDAO.class);

	protected void initDao() {
		// do nothing
	}

	public void save(YyglZhaolu transientInstance) {
		log.debug("saving YyglZhaolu instance");
		try {
			getHibernateTemplate().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(YyglZhaolu persistentInstance) {
		log.debug("deleting YyglZhaolu instance");
		try {
			getHibernateTemplate().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}
	
	public void update(YyglZhaolu persistentInstance){
		log.debug("update YyglZhaolu instance");
		try {
			getHibernateTemplate().update(persistentInstance);
			log.debug("update successful");
		} catch (RuntimeException re) {
			log.error("update failed",re);
			throw re;
		}
	}

	public YyglZhaolu findById(java.lang.Integer id) {
		log.debug("getting YyglZhaolu instance with id: " + id);
		try {
			YyglZhaolu instance = (YyglZhaolu) getHibernateTemplate().get(
					"nju.software.fyrs.data.dataobject.YyglZhaolu", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	@SuppressWarnings("unchecked")
	public List<YyglZhaolu> findByExample(YyglZhaolu instance) {
		log.debug("finding YyglZhaolu instance by example");
		try {
			List<YyglZhaolu> results = (List<YyglZhaolu>) getHibernateTemplate()
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
		log.debug("finding YyglZhaolu instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from YyglZhaolu as model where model."
					+ propertyName + "= ?";
			return getHibernateTemplate().find(queryString, value);
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	@SuppressWarnings("rawtypes")
	public List findAll() {
		log.debug("finding all YyglZhaolu instances");
		try {
			String queryString = "from YyglZhaolu";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public YyglZhaolu merge(YyglZhaolu detachedInstance) {
		log.debug("merging YyglZhaolu instance");
		try {
			YyglZhaolu result = (YyglZhaolu) getHibernateTemplate().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(YyglZhaolu instance) {
		log.debug("attaching dirty YyglZhaolu instance");
		try {
			getHibernateTemplate().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(YyglZhaolu instance) {
		log.debug("attaching clean YyglZhaolu instance");
		try {
			getHibernateTemplate().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public static YyglZhaoluDAO getFromApplicationContext(ApplicationContext ctx) {
		return (YyglZhaoluDAO) ctx.getBean("YyglZhaoluDAO");
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
		String hql = "select max(checkCode) from YyglZhaolu";
		List<Integer> s = getHibernateTemplate().find(hql);
		return s.get(0);
	}
	
	
	

	
	@SuppressWarnings("unchecked")
	public List<YyglZhaolu> getYyglZhaoluByFy(String fy){
		int nfy = Integer.parseInt(fy);
		String hql = "from YyglZhaolu where NFy=?";
		List<YyglZhaolu> listYyglZhaolu = getHibernateTemplate().find(hql,nfy);		
		return listYyglZhaolu;
	}
	

	@SuppressWarnings("unchecked")
	public YyglZhaolu getYyglZhaoluById(String id, String fydm){

		int nfy = Integer.parseInt(fydm);
		BigDecimal bd = new BigDecimal(id);
		String hql = "from YyglZhaolu where NId=? and NFy=? ";
		List<YyglZhaolu> listYyglZhaolu = getHibernateTemplate().find(hql,bd,nfy);		
		return listYyglZhaolu.size()>0?listYyglZhaolu.get(0):null;
	}
	
	
	@SuppressWarnings("unchecked")
	public boolean delYyglZhaoluById(String bh){

		BigDecimal bd = new BigDecimal(bh);
		String hql = "from YyglZhaolu where NId=?";
		List<YyglZhaolu> listYyglZhaolu = getHibernateTemplate().find(hql,bd);	
		if(listYyglZhaolu==null || listYyglZhaolu.size()==0){
			return false;
		}else{
			YyglZhaolu rysxHt = listYyglZhaolu.get(0);
			getHibernateTemplate().delete(rysxHt);
			return true;
		}
	}

}
