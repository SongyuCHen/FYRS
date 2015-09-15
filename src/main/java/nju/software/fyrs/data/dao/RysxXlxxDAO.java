package nju.software.fyrs.data.dao;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import nju.software.fyrs.biz.vo.PrimaryKeyFyRybhVO;
import nju.software.fyrs.data.dataobject.RysxXlxx;

import org.hibernate.LockMode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

/**
 * A data access object (DAO) providing persistence and search support for
 * RysxXlxx entities. Transaction control of the save(), update() and delete()
 * operations can directly support Spring container-managed transactions or they
 * can be augmented to handle user-managed Spring transactions. Each of these
 * methods provides additional information for how to configure it for the
 * desired type of transaction control.
 * 
 * @see nju.software.fyrs.data.dataobject.RysxXlxx
 * @author MyEclipse Persistence Tools
 */
public class RysxXlxxDAO extends HibernateDaoSupport {
	private static final Logger log = LoggerFactory
			.getLogger(RysxXlxxDAO.class);
	// property constants
	public static final String _NXL = "NXl";
	public static final String _NSXZY = "NSxzy";
	public static final String _CSXZY = "CSxzy";
	public static final String _CXXMC = "CXxmc";
	public static final String _NJYXS = "NJyxs";
	public static final String _NXXLB = "NXxlb";
	public static final String _NXXXS = "NXxxs";
	public static final String _NXZ = "NXz";
	public static final String _CSYDW = "CSydw";
	public static final String _NXXSZGJ = "NXxszgj";
	public static final String _NJYXL = "NJyxl";
	public static final String _NDQXX = "NDqxx";
	public static final String _NTBJL = "NTbjl";
	public static final String _CJLID = "CJlid";
	public static final String _NXSSX = "NXssx";

	protected void initDao() {
		// do nothing
	}

	public void save(RysxXlxx transientInstance) {
		log.debug("saving RysxXlxx instance");
		try {
			getHibernateTemplate().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(RysxXlxx persistentInstance) {
		log.debug("deleting RysxXlxx instance");
		try {
			getHibernateTemplate().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public RysxXlxx findById(nju.software.fyrs.data.dataobject.RysxXlxxId id) {
		log.debug("getting RysxXlxx instance with id: " + id);
		try {
			RysxXlxx instance = (RysxXlxx) getHibernateTemplate().get(
					"software.fyrs.data.RysxXlxx", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	@SuppressWarnings("unchecked")
	public List<RysxXlxx> findByExample(RysxXlxx instance) {
		log.debug("finding RysxXlxx instance by example");
		try {
			List<RysxXlxx> results = (List<RysxXlxx>) getHibernateTemplate()
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
		log.debug("finding RysxXlxx instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from RysxXlxx as model where model."
					+ propertyName + "= ?";
			return getHibernateTemplate().find(queryString, value);
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	@SuppressWarnings("unchecked")
	public List<RysxXlxx> findByNXl(Object NXl) {
		return findByProperty(_NXL, NXl);
	}

	@SuppressWarnings("unchecked")
	public List<RysxXlxx> findByNSxzy(Object NSxzy) {
		return findByProperty(_NSXZY, NSxzy);
	}

	@SuppressWarnings("unchecked")
	public List<RysxXlxx> findByCSxzy(Object CSxzy) {
		return findByProperty(_CSXZY, CSxzy);
	}

	@SuppressWarnings("unchecked")
	public List<RysxXlxx> findByCXxmc(Object CXxmc) {
		return findByProperty(_CXXMC, CXxmc);
	}

	@SuppressWarnings("unchecked")
	public List<RysxXlxx> findByNJyxs(Object NJyxs) {
		return findByProperty(_NJYXS, NJyxs);
	}

	@SuppressWarnings("unchecked")
	public List<RysxXlxx> findByNXxlb(Object NXxlb) {
		return findByProperty(_NXXLB, NXxlb);
	}

	@SuppressWarnings("unchecked")
	public List<RysxXlxx> findByNXxxs(Object NXxxs) {
		return findByProperty(_NXXXS, NXxxs);
	}

	@SuppressWarnings("unchecked")
	public List<RysxXlxx> findByNXz(Object NXz) {
		return findByProperty(_NXZ, NXz);
	}

	@SuppressWarnings("unchecked")
	public List<RysxXlxx> findByCSydw(Object CSydw) {
		return findByProperty(_CSYDW, CSydw);
	}

	@SuppressWarnings("unchecked")
	public List<RysxXlxx> findByNXxszgj(Object NXxszgj) {
		return findByProperty(_NXXSZGJ, NXxszgj);
	}

	@SuppressWarnings("unchecked")
	public List<RysxXlxx> findByNJyxl(Object NJyxl) {
		return findByProperty(_NJYXL, NJyxl);
	}

	@SuppressWarnings("unchecked")
	public List<RysxXlxx> findByNDqxx(Object NDqxx) {
		return findByProperty(_NDQXX, NDqxx);
	}

	@SuppressWarnings("unchecked")
	public List<RysxXlxx> findByNTbjl(Object NTbjl) {
		return findByProperty(_NTBJL, NTbjl);
	}

	@SuppressWarnings("unchecked")
	public List<RysxXlxx> findByCJlid(Object CJlid) {
		return findByProperty(_CJLID, CJlid);
	}

	@SuppressWarnings("unchecked")
	public List<RysxXlxx> findByNXssx(Object NXssx) {
		return findByProperty(_NXSSX, NXssx);
	}

	@SuppressWarnings("rawtypes")
	public List findAll() {
		log.debug("finding all RysxXlxx instances");
		try {
			String queryString = "from RysxXlxx";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public RysxXlxx merge(RysxXlxx detachedInstance) {
		log.debug("merging RysxXlxx instance");
		try {
			RysxXlxx result = (RysxXlxx) getHibernateTemplate().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(RysxXlxx instance) {
		log.debug("attaching dirty RysxXlxx instance");
		try {
			getHibernateTemplate().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(RysxXlxx instance) {
		log.debug("attaching clean RysxXlxx instance");
		try {
			getHibernateTemplate().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public static RysxXlxxDAO getFromApplicationContext(ApplicationContext ctx) {
		return (RysxXlxxDAO) ctx.getBean("RysxXlxxDAO");
	}

	@SuppressWarnings("unchecked")
	public List<RysxXlxx> getXlxxByRybh(String rybh) {
		int nrybh = Integer.parseInt(rybh);
		String hql = "from RysxXlxx where NRybh = " + nrybh;
		List<RysxXlxx> listXlxx = getHibernateTemplate().find(hql);
		return listXlxx;

	}

	public RysxXlxx getRsXlxxById(String id, String fydm,String rybh) {
		String hql = "from RysxXlxx where NId=? and NFy=? and NRybh=?";
		BigDecimal bigDecimal = new BigDecimal(id);
		return (RysxXlxx)getSession().createQuery(hql).setParameter(0,bigDecimal).setParameter(1,Integer.valueOf(fydm)).setParameter(2, Integer.valueOf(rybh)).uniqueResult();
	}

	@SuppressWarnings("unchecked")
	public boolean delRsXlxxById(String rybh, String bh) {
		String hql = "from RysxXlxx where NRybh=? and NId=?";
		int nrybh = Integer.parseInt(rybh);
		BigDecimal bd = new BigDecimal(bh);
		List<RysxXlxx> rsXlxxList = getHibernateTemplate().find(hql, nrybh, bd);
		if (rsXlxxList == null || rsXlxxList.size() == 0) {
			return false;
		} else {
			RysxXlxx rsXlxx = rsXlxxList.get(0);
			getHibernateTemplate().delete(rsXlxx);
			return true;
		}
	}

	public boolean updateRsXlxx(RysxXlxx rysxXlxx) {
		if (rysxXlxx == null) {
			return false;
		} else {
			getHibernateTemplate().update(rysxXlxx);
			return true;
		}
	}

	// myCode

	public List<PrimaryKeyFyRybhVO> listByXljb(int xljb) {
		// 1 607 研究生 1 1
		// 2 607 本科以上 2 1
		// 3 607 本科 3 1
		// 4 607 大专以上 4 1
		// 5 607 大专 5 1
		// 6 607 中专以下 6 1
		int begin = 0;
		int end = 0;
		switch (xljb) {
		case 1:
            begin = 1;
            end = 9;
			break;
		case 2:
			 begin = 1;
	         end = 20;
			break;
		case 3:
			 begin = 11;
	         end = 20;
			break;
		case 4:
			 begin = 1;
	         end = 29;
			break;
		case 5:
			 begin = 21;
	         end = 29;
			break;
		case 6:
			 begin = 29;
	         end = 81;
			break;

		}
		String sql = "select n_fy,n_rybh from t_rysx_xlxx where N_XL >= ? AND N_XL <= ? and N_dqxx = ?";
		List<PrimaryKeyFyRybhVO> results = new ArrayList<PrimaryKeyFyRybhVO>();
		@SuppressWarnings("unchecked")
		List<Object[]> list = (List<Object[]>) getSession().createSQLQuery(sql).setParameter(0, begin).setParameter(1, end).setParameter(2,1);
		for(Object[] obj : list)
		{
			PrimaryKeyFyRybhVO vo = new PrimaryKeyFyRybhVO();
			vo.setNFy((Integer)obj[0]);
			vo.setNRybh((Integer)obj[1]);
			results.add(vo);
		}
		return results;
	}
	@SuppressWarnings("unchecked")
	public List<RysxXlxx> getXlxxByRybhFy(int rybh,int fydm)
	{
	return getSession().createQuery("from RysxXlxx rz where rz.NFy = ? and rz.NRybh = ? order by DByrq").setParameter(0,Integer.valueOf(fydm)).setParameter(1,Integer.valueOf(rybh)).list();
	}
	// myCode
	
	public boolean interceptAddXlxx(RysxXlxx rysxXlxx){
		try
		{
			getSession().save(rysxXlxx);
			getSession().flush();
			return true;
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
			return false;
		}
		
	}
	
	public boolean interceptUpdateXlxx(RysxXlxx rysxXlxx){
		try
		{
			getSession().update(rysxXlxx);
			getSession().flush();
			return true;
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
			return false;
		}
		
	}
	
	public boolean interceptDeleteRsXlxxById(RysxXlxx rysxXlxx){
		try
		{
			getSession().delete(rysxXlxx);
			getSession().flush();
			return true;
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
			return false;
		}
		
	}
	public RysxXlxx findByFyRybhId(int fy,int rybh,BigDecimal id)
	{
	   return (RysxXlxx)getSession().createQuery("from RysxXlxx rx where rx.NFy = ? and rx.NRybh = ? and rx.NId = ? ").setParameter(0,fy).setParameter(1, rybh).setParameter(2,id).uniqueResult();	
	}
	public BigDecimal getMaxNid(int fydm)
	{
		String hql = "select max(N_ID) from T_RYSX_XLXX";
		return DaoUtils.getMaxIdRyjbxx(getSession(), fydm, hql);
		
	}
}