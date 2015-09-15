package nju.software.fyrs.data.dao;

import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import nju.software.fyrs.data.dataobject.Ryjbxx;
import org.hibernate.LockMode;
import org.hibernate.Query;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

/**
 * A data access object (DAO) providing persistence and search support for Ryjbxx entities.
 * Transaction control of the save(), update() and delete() operations 
 can directly support Spring container-managed transactions or they can be augmented	to handle user-managed Spring transactions. 
 Each of these methods provides additional information for how to configure it for the desired type of transaction control. 	
 * @see nju.software.fyrs.data.dataobject.Ryjbxx
 * @author MyEclipse Persistence Tools 
 */
/**
 * @author Admin
 *
 */
/**
 * @author Admin
 * 
 */
public class RyjbxxDAO extends HibernateDaoSupport {
	private static final Logger log = LoggerFactory.getLogger(RyjbxxDAO.class);
	// property constants
	public static final String _CBS = "CBs";
	public static final String _CMM = "CMm";
	public static final String _CRYBH = "CRybh";
	public static final String _CCODE_JG1 = "CCodeJg1";
	public static final String _CCODE_JG2 = "CCodeJg2";
	public static final String _CCODE_JG3 = "CCodeJg3";
	public static final String _CXM = "CXm";
	public static final String _CCYM = "CCym";
	public static final String _NXB = "NXb";
	public static final String _NBM = "NBm";
	public static final String _NUNICODE = "NUnicode";
	public static final String _NGWXZ = "NGwxz";
	public static final String _CJG = "CJg";
	public static final String _CCSD = "CCsd";
	public static final String _NJKZK = "NJkzk";
	public static final String _NHYZK = "NHyzk";
	public static final String _NMZ = "NMz";
	public static final String _CSFZH = "CSfzh";
	public static final String _NBZ = "NBz";
	public static final String _NZWLB = "NZwlb";
	public static final String _NRYFS = "NRyfs";
	public static final String _NXL = "NXl";
	public static final String _NZY = "NZy";
	public static final String _NXW = "NXw";
	public static final String _NZYZS = "NZyzs";
	public static final String _NZZMM = "NZzmm";
	public static final String _NXZZW = "NXzzw";
	public static final String _NFLZW = "NFlzw";
	public static final String _NJRTZ = "NJrtz";
	public static final String _NDZZW = "NDzzw";
	public static final String _NBCGL = "NBcgl";
	public static final String _NKJGL = "NKjgl";
	public static final String _NJYQFYNX = "NJyqfynx";
	public static final String _NZJ = "NZj";
	public static final String _NDJ = "NDj";
	public static final String _NJTJ = "NJtj";
	public static final String _NJLY = "NJly";
	public static final String _NYZW = "NYzw";
	public static final String _NYZJ = "NYzj";
	public static final String _CYDW = "CYdw";
	public static final String _NCYY = "NCyy";
	public static final String _NQX = "NQx";
	public static final String _NXSSX = "NXssx";
	public static final String _NYX = "NYx";
	public static final String _NPJNL = "NPjnl";
	public static final String _NYJXZ = "NYjxz";
	public static final String _NSFFG = "NSffg";
	public static final String _NGWYJB = "NGwyjb";
	public static final String _NQDFGZGZS = "NQdfgzgzs";
	public static final String _IMSign = "IMSign";

	protected void initDao() {
		// do nothing
	}

	public void save(Ryjbxx transientInstance) {
		log.debug("saving Ryjbxx instance");
		try {
			getHibernateTemplate().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(Ryjbxx persistentInstance) {
		log.debug("deleting Ryjbxx instance");
		try {
			getHibernateTemplate().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Ryjbxx findById(nju.software.fyrs.data.dataobject.RyjbxxId id) {
		log.debug("getting Ryjbxx instance with id: " + id);
		try {
			Ryjbxx instance = (Ryjbxx) getHibernateTemplate().get(
					"software.fyrs.data.Ryjbxx", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	@SuppressWarnings("unchecked")
	public List<Ryjbxx> findByExample(Ryjbxx instance) {
		log.debug("finding Ryjbxx instance by example");
		try {
			List<Ryjbxx> results = (List<Ryjbxx>) getHibernateTemplate()
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
		log.debug("finding Ryjbxx instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from Ryjbxx as model where model."
					+ propertyName + "= ?";
			return getHibernateTemplate().find(queryString, value);
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	@SuppressWarnings("unchecked")
	public List<Ryjbxx> findByCBs(Object CBs) {
		return findByProperty(_CBS, CBs);
	}

	@SuppressWarnings("unchecked")
	public List<Ryjbxx> findByCMm(Object CMm) {
		return findByProperty(_CMM, CMm);
	}

	@SuppressWarnings("unchecked")
	public List<Ryjbxx> findByCRybh(Object CRybh) {
		return findByProperty(_CRYBH, CRybh);
	}

	@SuppressWarnings("unchecked")
	public List<Ryjbxx> findByCCodeJg1(Object CCodeJg1) {
		return findByProperty(_CCODE_JG1, CCodeJg1);
	}

	@SuppressWarnings("unchecked")
	public List<Ryjbxx> findByCCodeJg2(Object CCodeJg2) {
		return findByProperty(_CCODE_JG2, CCodeJg2);
	}

	@SuppressWarnings("unchecked")
	public List<Ryjbxx> findByCCodeJg3(Object CCodeJg3) {
		return findByProperty(_CCODE_JG3, CCodeJg3);
	}

	@SuppressWarnings("unchecked")
	public List<Ryjbxx> findByCXm(Object CXm) {
		return findByProperty(_CXM, CXm);
	}

	@SuppressWarnings("unchecked")
	public List<Ryjbxx> findByCCym(Object CCym) {
		return findByProperty(_CCYM, CCym);
	}

	@SuppressWarnings("unchecked")
	public List<Ryjbxx> findByNXb(Object NXb) {
		return findByProperty(_NXB, NXb);
	}

	@SuppressWarnings("unchecked")
	public List<Ryjbxx> findByNBm(Object NBm) {
		return findByProperty(_NBM, NBm);
	}

	@SuppressWarnings("unchecked")
	public List<Ryjbxx> findByNUnicode(Object NUnicode) {
		return findByProperty(_NUNICODE, NUnicode);
	}

	@SuppressWarnings("unchecked")
	public List<Ryjbxx> findByNGwxz(Object NGwxz) {
		return findByProperty(_NGWXZ, NGwxz);
	}

	@SuppressWarnings("unchecked")
	public List<Ryjbxx> findByCJg(Object CJg) {
		return findByProperty(_CJG, CJg);
	}

	@SuppressWarnings("unchecked")
	public List<Ryjbxx> findByCCsd(Object CCsd) {
		return findByProperty(_CCSD, CCsd);
	}

	@SuppressWarnings("unchecked")
	public List<Ryjbxx> findByNJkzk(Object NJkzk) {
		return findByProperty(_NJKZK, NJkzk);
	}

	@SuppressWarnings("unchecked")
	public List<Ryjbxx> findByNHyzk(Object NHyzk) {
		return findByProperty(_NHYZK, NHyzk);
	}

	@SuppressWarnings("unchecked")
	public List<Ryjbxx> findByNMz(Object NMz) {
		return findByProperty(_NMZ, NMz);
	}

	@SuppressWarnings("unchecked")
	public List<Ryjbxx> findByCSfzh(Object CSfzh) {
		return findByProperty(_CSFZH, CSfzh);
	}

	@SuppressWarnings("unchecked")
	public List<Ryjbxx> findByNBz(Object NBz) {
		return findByProperty(_NBZ, NBz);
	}

	@SuppressWarnings("unchecked")
	public List<Ryjbxx> findByNZwlb(Object NZwlb) {
		return findByProperty(_NZWLB, NZwlb);
	}

	@SuppressWarnings("unchecked")
	public List<Ryjbxx> findByNRyfs(Object NRyfs) {
		return findByProperty(_NRYFS, NRyfs);
	}

	@SuppressWarnings("unchecked")
	public List<Ryjbxx> findByNXl(Object NXl) {
		return findByProperty(_NXL, NXl);
	}

	@SuppressWarnings("unchecked")
	public List<Ryjbxx> findByNZy(Object NZy) {
		return findByProperty(_NZY, NZy);
	}

	@SuppressWarnings("unchecked")
	public List<Ryjbxx> findByNXw(Object NXw) {
		return findByProperty(_NXW, NXw);
	}

	@SuppressWarnings("unchecked")
	public List<Ryjbxx> findByNZyzs(Object NZyzs) {
		return findByProperty(_NZYZS, NZyzs);
	}

	@SuppressWarnings("unchecked")
	public List<Ryjbxx> findByNZzmm(Object NZzmm) {
		return findByProperty(_NZZMM, NZzmm);
	}

	@SuppressWarnings("unchecked")
	public List<Ryjbxx> findByNXzzw(Object NXzzw) {
		return findByProperty(_NXZZW, NXzzw);
	}

	@SuppressWarnings("unchecked")
	public List<Ryjbxx> findByNFlzw(Object NFlzw) {
		return findByProperty(_NFLZW, NFlzw);
	}

	@SuppressWarnings("unchecked")
	public List<Ryjbxx> findByNJrtz(Object NJrtz) {
		return findByProperty(_NJRTZ, NJrtz);
	}

	@SuppressWarnings("unchecked")
	public List<Ryjbxx> findByNDzzw(Object NDzzw) {
		return findByProperty(_NDZZW, NDzzw);
	}

	@SuppressWarnings("unchecked")
	public List<Ryjbxx> findByNBcgl(Object NBcgl) {
		return findByProperty(_NBCGL, NBcgl);
	}

	@SuppressWarnings("unchecked")
	public List<Ryjbxx> findByNKjgl(Object NKjgl) {
		return findByProperty(_NKJGL, NKjgl);
	}

	@SuppressWarnings("unchecked")
	public List<Ryjbxx> findByNJyqfynx(Object NJyqfynx) {
		return findByProperty(_NJYQFYNX, NJyqfynx);
	}

	@SuppressWarnings("unchecked")
	public List<Ryjbxx> findByNZj(Object NZj) {
		return findByProperty(_NZJ, NZj);
	}

	@SuppressWarnings("unchecked")
	public List<Ryjbxx> findByNDj(Object NDj) {
		return findByProperty(_NDJ, NDj);
	}

	@SuppressWarnings("unchecked")
	public List<Ryjbxx> findByNJtj(Object NJtj) {
		return findByProperty(_NJTJ, NJtj);
	}

	@SuppressWarnings("unchecked")
	public List<Ryjbxx> findByNJly(Object NJly) {
		return findByProperty(_NJLY, NJly);
	}

	@SuppressWarnings("unchecked")
	public List<Ryjbxx> findByNYzw(Object NYzw) {
		return findByProperty(_NYZW, NYzw);
	}

	@SuppressWarnings("unchecked")
	public List<Ryjbxx> findByNYzj(Object NYzj) {
		return findByProperty(_NYZJ, NYzj);
	}

	@SuppressWarnings("unchecked")
	public List<Ryjbxx> findByCYdw(Object CYdw) {
		return findByProperty(_CYDW, CYdw);
	}

	@SuppressWarnings("unchecked")
	public List<Ryjbxx> findByNCyy(Object NCyy) {
		return findByProperty(_NCYY, NCyy);
	}

	@SuppressWarnings("unchecked")
	public List<Ryjbxx> findByNQx(Object NQx) {
		return findByProperty(_NQX, NQx);
	}

	@SuppressWarnings("unchecked")
	public List<Ryjbxx> findByNXssx(Object NXssx) {
		return findByProperty(_NXSSX, NXssx);
	}

	@SuppressWarnings("unchecked")
	public List<Ryjbxx> findByNYx(Object NYx) {
		return findByProperty(_NYX, NYx);
	}

	@SuppressWarnings("unchecked")
	public List<Ryjbxx> findByNPjnl(Object NPjnl) {
		return findByProperty(_NPJNL, NPjnl);
	}

	@SuppressWarnings("unchecked")
	public List<Ryjbxx> findByNYjxz(Object NYjxz) {
		return findByProperty(_NYJXZ, NYjxz);
	}

	@SuppressWarnings("unchecked")
	public List<Ryjbxx> findByNSffg(Object NSffg) {
		return findByProperty(_NSFFG, NSffg);
	}

	@SuppressWarnings("unchecked")
	public List<Ryjbxx> findByNGwyjb(Object NGwyjb) {
		return findByProperty(_NGWYJB, NGwyjb);
	}

	@SuppressWarnings("unchecked")
	public List<Ryjbxx> findByNQdfgzgzs(Object NQdfgzgzs) {
		return findByProperty(_NQDFGZGZS, NQdfgzgzs);
	}

	@SuppressWarnings("rawtypes")
	public List findAll() {
		log.debug("finding all Ryjbxx instances");
		try {
			String queryString = "from Ryjbxx";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public Ryjbxx merge(Ryjbxx detachedInstance) {
		log.debug("merging Ryjbxx instance");
		try {
			Ryjbxx result = (Ryjbxx) getHibernateTemplate().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void saveOrUpdate(Ryjbxx detachedInstance) {
		log.debug("merging Ryjbxx instance");
		try {
			getHibernateTemplate().saveOrUpdate(detachedInstance);
			log.debug("merge successful");
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(Ryjbxx instance) {
		log.debug("attaching dirty Ryjbxx instance");
		try {
			getHibernateTemplate().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Ryjbxx instance) {
		log.debug("attaching clean Ryjbxx instance");
		try {
			getHibernateTemplate().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public static RyjbxxDAO getFromApplicationContext(ApplicationContext ctx) {
		return (RyjbxxDAO) ctx.getBean("RyjbxxDAO");
	}

	// myCode
	@SuppressWarnings("unchecked")
	public List<Ryjbxx> listByFyDmBmDm(int fyDm, int bmDm) {
		String hql = "from Ryjbxx rj where rj.NFy = ? and rj.NBm = ?";
		return getSession().createQuery(hql).setParameter(0, fyDm)
				.setParameter(1, bmDm).list();
	}
	
	@SuppressWarnings("unchecked")
	public List<Ryjbxx> listByFydmXzzw(int fydm, int xzzw) {
		String hql = "from Ryjbxx rj where rj.NFy = ? and rj.NXzzw = ?";
		return getSession().createQuery(hql).setParameter(0, fydm)
				.setParameter(1, xzzw).list();
	}

	@SuppressWarnings("unchecked")
	public List<Ryjbxx> listByFyDm(int fyDm) {
		String hql = "from Ryjbxx rj where rj.NFy = ?";
		return getSession().createQuery(hql).setParameter(0, fyDm).list();
	}

	public Ryjbxx getRyjbxxByRybhFyDm(int rybh, int fyDm) {
		String hql = "from Ryjbxx rj where rj.NFy = ? and rj.NRybh = ?";
		return (Ryjbxx) getSession().createQuery(hql).setParameter(0, fyDm)
				.setParameter(1, rybh).uniqueResult();
	}

	@SuppressWarnings("unchecked")
	public List<Ryjbxx> getJbxxVOByRybhFy(int rybh, int fydm) {
		String hql = "from Ryjbxx where NRybh=? and NFy=?";
		return getSession().createQuery(hql)
				.setParameter(0, Integer.valueOf(rybh))
				.setParameter(1, Integer.valueOf(fydm)).list();
	}

	@SuppressWarnings("unchecked")
	public List<Ryjbxx> getRyjbxxVOByXmFy(String fydm, String xm) {
		String hql = "from Ryjbxx where NFy=? and CXm=?";
		List<Ryjbxx> jbxxList = getSession().createQuery(hql)
				.setParameter(0, Integer.valueOf(fydm)).setParameter(1, xm)
				.list();
		return jbxxList;
	}

	public int updateUserNameAndRoles(String userName, String roleIds,
			int rybh, int fydm) {

		Ryjbxx ryjbxx = this.getRyjbxxByRybhFyDm(rybh, fydm);
		if (!ryjbxx.getCBs().equals(userName)) {
			// 表示这个法院的用户已经存在
			if (isExistUsername(userName, fydm)) {
				return -1;
			}

		}
		ryjbxx.setCBs(userName);
		ryjbxx.setCQx(roleIds);
		this.save(ryjbxx);
		return 1;
	}

	/**
	 * 判断同一个法院用户名是否已经存在
	 * 
	 * @param username
	 * @param fydm
	 * @return
	 */
	@SuppressWarnings("unchecked")
	private boolean isExistUsername(String username, int fydm) {
		String hql = "from Ryjbxx rj where rj.NFy = ? and rj.CBs = ?";
		List<Ryjbxx> lists = (List<Ryjbxx>) getSession().createQuery(hql)
				.setParameter(0, fydm).setParameter(1, username).list();
		if (lists.size() == 0) {
			return false;
		}
		return true;
	}

	public void updatePassword(String password, int rybh, int fyDm) {
		Ryjbxx ryjbxx = this.getRyjbxxByRybhFyDm(rybh, fyDm);
		ryjbxx.setCMm(password);
		this.save(ryjbxx);
	}

	public Ryjbxx getRyjbxxByUserNamePassowrd(String username, int fyDm) {
		String hql = "from Ryjbxx rj where rj.NFy = ? and rj.CBs = ?";
		return (Ryjbxx) getSession().createQuery(hql).setParameter(0, fyDm)
				.setParameter(1, username).uniqueResult();
	}

	public String roleIdsByFydmRybh(int rybh, int fyDm) {
		Ryjbxx ryjbxx = this.getRyjbxxByRybhFyDm(rybh, fyDm);
		return ryjbxx.getCQx();
	}

	// myCode
	public int[] findBzCount(int fydm) {
		/**
		 * 代码表知道 N_BZ 最多可能是 1 ，2，3，4，5，6，7，8，9 分别代表不同的编制，所以
		 */
		int[] arrays = new int[] { 0, 0, 0, 0, 0, 0, 0, 0, 0 };
		String sql = "select N_BZ,COUNT(*) FROM T_RYJBXX WHERE N_FY = ?  GROUP BY N_BZ";
		Query query = getSession().createSQLQuery(sql);
		@SuppressWarnings("unchecked")
		List<Object[]> list = (List<Object[]>) query.setParameter(0, fydm)
				.list();
		for (Object[] objects : list) {
			if (null == objects[0]) {
				arrays[8] += (Integer) objects[1];
			} else {
				arrays[(Integer) objects[0] - 1] = (Integer) objects[1];
			}

		}
		return arrays;
	}

	@SuppressWarnings("unchecked")
	public List<Ryjbxx> listByFlzwBmZwlbZyZjDjXlRyk(String flzw, String bm,
			String zwlb, String zy, String zj, String dj, String xl, String ryk) {
		String firstSql = "from Ryjbxx rj where ";
		String hql = "";
		if (!flzw.equals("-1")) {
			hql += " and  rj.NFlzw = " + flzw;
		}
		if (!bm.equals("-1")) {
			// 1-49 审判
			// 50 - 87 行政
			// 88 - 123 法庭

			if (bm.equals("1")) {
				hql += " and ( rj.NBm >= 1 and  rj.NBm <= 49)";
			}
			if (bm.equals("2")) {
				hql += " and ( rj.NBm >= 50 and  rj.NBm <= 87)";
			}
			if (bm.equals("3")) {
				hql += " and ( rj.NBm >= 88 and  rj.NBm <= 123)";
			}
		}
		if (!zwlb.equals("-1")) {
			hql += " and rj.NZwlb = " + zwlb;
		}
		if (!zy.equals("-1")) {
			// 法律专业代码，非法律专业代码
			String[] stringCode = {
					"(9,23,24,25,26,27,28,29,30,31,32,33,34,35,36,37,38,39,40)",
					"(1,2,3,4,5,6,7,8,60,99,100,101,102,103,104,105,106)" };
			hql += " and rj.NZy in  " + stringCode[Integer.valueOf(zy) - 1];
		}
		// 职级对应关系 代码表中 正军-正部 副军-副部 正师-正厅 副师-副厅 正处-正团 副处-副团 正科-正营 副科-副营
		// 科员-正连，副连，正排 其他军职 --其他
		if (!zj.equals("-1")) {
			String[] stringCode = { "(1)", "(2,14)", "(3,15)", "(4,16)",
					"(5,17)", "(6,18)", "(7,19)", "(8,20)", "(9,21)",
					"(10,22,23,24)", "(11)", "(12)", "(13)", "(14)", "(15)" };
			hql += " and rj.NZj in " + stringCode[Integer.valueOf(zj) - 1];
		}
		if (!dj.equals("-1")) {
			String[] dengJi = { "(0,1,2)", "(10,11,12,13)", "(20,21,22,23,24)",
					"(30,31,32,33,34)", "(40,41,42)", "(50,51,52)", "(60,61)" };
			hql += " and rj.NDj in " + dengJi[Integer.valueOf(dj) - 1];
		}
		if (!xl.equals("-1")) {
			String[] xlString = { "(1,2,3,4,5,6,7,8,9)", "(11,12,13,19,20)",
					"(21,22,29)" };
			if (xl.trim().equals("1")) {
				hql += " and rj.NXl in " + xlString[0];
			}
			if (xl.trim().equals("2")) {
				hql += " and rj.NXl < 11 ";
			}
			if (xl.trim().equals("3")) {
				hql += " and rj.NXl in " + xlString[1];
			}
			if (xl.trim().equals("4")) {
				hql += " and rj.NXl < 21 ";
			}
			if (xl.trim().equals("5")) {
				hql += " and rj.NXl in " + xlString[2];
			}
			if (xl.trim().equals("6")) {
				hql += " and rj.NXl > 29 ";
			}
		}
		if (!ryk.equals("-1")) {
			hql += " and rj.NBiaozhi = " + Integer.valueOf(ryk);
		}
		hql = hql.substring(" and ".length());

		return getSession().createQuery(firstSql + hql).list();
	}

	@SuppressWarnings("unused")
	public List<Ryjbxx> listByFydmRybhIn(String inString) {
		List<Ryjbxx> lists = new ArrayList<Ryjbxx>();
		// 表示 一个空格，二个空格，三个空格，四个空格
		String[] strNone = { " ", "  ", "   ", "    " };
		try {
			/**
			 * ('51 3342338','51 3342338')
			 */
			String str = "select C_XM,N_XB,N_FY,N_BM,N_XZZW,N_FLZW,D_CSRQ,N_ZJ,N_XL from T_RYJBXX WHERE CONVERT(CHAR(5),N_FY)+CONVERT(CHAR(32),N_RYBH)  IN "
					+ inString + "";
			@SuppressWarnings("unchecked")
			List<Object[]> listObjs = (List<Object[]>) getSession()
					.createSQLQuery(str).list();
			if (listObjs != null) {
				for (Object[] obj : listObjs) {
					Ryjbxx rj = new Ryjbxx();
					rj.setCXm((String) obj[0]);
					rj.setNXb((Integer) obj[1]);
					rj.setNFy((Integer) obj[2]);
					rj.setNBm((Integer) obj[3]);
					rj.setNXzzw((Integer) obj[4]);
					rj.setNFlzw((Integer) obj[5]);
					rj.setDCsrq((Date) obj[6]);
					rj.setNZj((Integer) obj[7]);
					rj.setNXl((Integer) obj[8]);
					lists.add(rj);
				}
			}
			return lists;
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return lists;
	}

	/**
	 * 
	 * @param ku
	 * @param fydm
	 * @param bm
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public List<Ryjbxx> listNameByKuFydmBm(String ku, String fydm, String bm) {
		int iBm = Integer.valueOf(bm);
		if (iBm < 0) {
			return getSession()
					.createQuery("from Ryjbxx where NBiaozhi = ? and NFy = ?")
					.setParameter(0, Integer.valueOf(ku))
					.setParameter(1, Integer.valueOf(fydm)).list();
		}
		return getSession()
				.createQuery(
						"from Ryjbxx where NBiaozhi = ? and NFy = ? and NBm = ?")
				.setParameter(0, Integer.valueOf(ku))
				.setParameter(1, Integer.valueOf(fydm)).setParameter(2, iBm)
				.list();
	}

	public Ryjbxx getRyjbxxByKuFydmBmName(String ku, String fydm, String bm,
			String name) {
		int iBm = Integer.valueOf(bm);
		if (iBm < 0) {
			return (Ryjbxx) getSession()
					.createQuery(
							"from Ryjbxx where NBiaozhi = ? and NFy = ? and CXm = ? ")
					.setParameter(0, Integer.valueOf(ku))
					.setParameter(1, Integer.valueOf(fydm))
					.setParameter(2, name).uniqueResult();
		}
		return (Ryjbxx) getSession()
				.createQuery(
						"from Ryjbxx where NBiaozhi = ? and NFy = ? and CXm = ? and NBm = ?")
				.setParameter(0, Integer.valueOf(ku))
				.setParameter(1, Integer.valueOf(fydm)).setParameter(2, name)
				.setParameter(3, iBm).uniqueResult();
	}

	// myCode

	/**
	 * 求法律职务的分布
	 * 
	 * @param fydm
	 * @return
	 */
	@SuppressWarnings("rawtypes")
	public Map<Integer, Long> getFlzwFb(int fydm) {
		Map<Integer, Long> flzwFbs = new HashMap<Integer, Long>();
		String hql = "select NFlzw, count(*) from Ryjbxx where NFy = ? group by NFlzw";
		Query query = getSession().createQuery(hql);
		List list = query.setParameter(0, fydm).list();
		Iterator iterator = list.iterator();
		while (iterator.hasNext()) {
			Object[] obj = (Object[]) iterator.next();
			flzwFbs.put((Integer) obj[0], (Long) obj[1]);
		}
		return flzwFbs;
	}

	/**
	 * 求法官等级的分布
	 * 
	 * @param fydm
	 * @return
	 */
	@SuppressWarnings("rawtypes")
	public Map<Integer, Long> getFgdjFb(int fydm) {
		Map<Integer, Long> fgdjFbs = new HashMap<Integer, Long>();
		String hql = "select NDj, count(*) from Ryjbxx where NFy = ? group by NDj";
		Query query = getSession().createQuery(hql);
		List list = query.setParameter(0, fydm).list();
		Iterator iterator = list.iterator();
		while (iterator.hasNext()) {
			Object[] obj = (Object[]) iterator.next();
			fgdjFbs.put((Integer) obj[0], (Long) obj[1]);
		}
		return fgdjFbs;
	}

	/**
	 * 求行政职务的分布
	 * 
	 * @param fydm
	 * @return
	 */
	@SuppressWarnings("rawtypes")
	public Map<Integer, Long> getXzzwFb(int fydm) {
		Map<Integer, Long> xzzwFbs = new HashMap<Integer, Long>();
		String hql = "select NXzzw, count(*) from Ryjbxx where NFy = ? group by NXzzw";
		Query query = getSession().createQuery(hql);
		List list = query.setParameter(0, fydm).list();
		Iterator iterator = list.iterator();
		while (iterator.hasNext()) {
			Object[] obj = (Object[]) iterator.next();
			xzzwFbs.put((Integer) obj[0], (Long) obj[1]);
		}
		return xzzwFbs;
	}

	/**
	 * 求部门人员的分布
	 * 
	 * @param fydm
	 * @return
	 */
	@SuppressWarnings("rawtypes")
	public Map<Integer, Long> getBmFb(int fydm) {
		Map<Integer, Long> bmFbs = new TreeMap<Integer, Long>();
		String hql = "select NBm, count(*) from Ryjbxx where NFy = ? group by NBm order by NBm asc";
		Query query = getSession().createQuery(hql);
		List list = query.setParameter(0, fydm).list();
		Iterator iterator = list.iterator();
		while (iterator.hasNext()) {
			Object[] obj = (Object[]) iterator.next();
			bmFbs.put((Integer) obj[0], (Long) obj[1]);
		}
		return bmFbs;
	}
	
	@SuppressWarnings("rawtypes")
	public Map<String, Long> getBzFb(int...fydms){
		Map<String, Long> bzfbs = new HashMap<String, Long>();
		if(fydms.length==0)return bzfbs;
		String infys = "";
		for(int fydm : fydms)
			infys = fydm + ",";
		infys = infys.substring(0, infys.length()-1);
		String hql = "select NFy, NBz, count(*) from Ryjbxx where NFy in("+infys+") group by NFy, NBz";
		Query query = getSession().createQuery(hql);
		List list = query.list();
		Iterator iterator = list.iterator();
		while (iterator.hasNext()) {
			Object[] obj = (Object[]) iterator.next();
			bzfbs.put(obj[0]+"-"+obj[1], (Long)obj[2]);
		}
		return bzfbs;
	}
	
	@SuppressWarnings("rawtypes")
	public Map<String, Long> getFgBmFb(int...fydms){
		Map<String, Long> fgbmfbs = new HashMap<String, Long>();
		if(fydms.length==0)return fgbmfbs;
		String infys = "";
		for(int fydm : fydms)
			infys = fydm + ",";
		infys = infys.substring(0, infys.length()-1);
		String hql = "select NFy, NBm, count(*) from Ryjbxx where NFy in("+infys+") and NDj<=24 group by NFy, NBm";
		Query query = getSession().createQuery(hql);
		List list = query.list();
		Iterator iterator = list.iterator();
		while (iterator.hasNext()) {
			Object[] obj = (Object[]) iterator.next();
			fgbmfbs.put(obj[0]+"-"+obj[1], (Long)obj[2]);
		}
		return fgbmfbs;
	}
	
	@SuppressWarnings("rawtypes")
	public Map<String, Long> getFgFlzwFb(int...fydms){
		Map<String, Long> fgflzwfbs = new HashMap<String, Long>();
		if(fydms.length==0)return fgflzwfbs;
		String infys = "";
		for(int fydm : fydms)
			infys = fydm + ",";
		infys = infys.substring(0, infys.length()-1);
		String hql = "select NFy, NFlzw, count(*) from Ryjbxx where NFy in("+infys+") and NDj<=24 group by NFy, NFlzw";
		Query query = getSession().createQuery(hql);
		List list = query.list();
		Iterator iterator = list.iterator();
		while (iterator.hasNext()) {
			Object[] obj = (Object[]) iterator.next();
			fgflzwfbs.put(obj[0]+"-"+obj[1], (Long)obj[2]);
		}
		return fgflzwfbs;
	}
	
	@SuppressWarnings("rawtypes")
	public Map<String, Long> getFgZjFb(int...fydms){
		Map<String, Long> fgzjfbs = new HashMap<String, Long>();
		if(fydms.length==0)return fgzjfbs;
		String infys = "";
		for(int fydm : fydms)
			infys = fydm + ",";
		infys = infys.substring(0, infys.length()-1);
		String hql = "select NFy, NZj, count(*) from Ryjbxx where NFy in("+infys+") and NDj<=24 group by NFy, NZj";
		Query query = getSession().createQuery(hql);
		List list = query.list();
		Iterator iterator = list.iterator();
		while (iterator.hasNext()) {
			Object[] obj = (Object[]) iterator.next();
			fgzjfbs.put(obj[0]+"-"+obj[1], (Long)obj[2]);
		}
		return fgzjfbs;
	}
	
	@SuppressWarnings("rawtypes")
	public Map<String, Long> getFgXlFb(int...fydms){
		Map<String, Long> fgxlfbs = new HashMap<String, Long>();
		if(fydms.length==0)return fgxlfbs;
		String infys = "";
		for(int fydm : fydms)
			infys = fydm + ",";
		infys = infys.substring(0, infys.length()-1);
		String hql = "select NFy, NXl, count(*) from Ryjbxx where NFy in("+infys+") and NDj<=24 group by NFy, NXl";
		Query query = getSession().createQuery(hql);
		List list = query.list();
		Iterator iterator = list.iterator();
		while (iterator.hasNext()) {
			Object[] obj = (Object[]) iterator.next();
			fgxlfbs.put(obj[0]+"-"+obj[1], (Long)obj[2]);
		}
		return fgxlfbs;
	}
	
	@SuppressWarnings("rawtypes")
	public Map<String, Long> getFldFgZjFb(int...fydms){//非领导法官：审判员助审员
		Map<String, Long> fldfgzjfbs = new HashMap<String, Long>();
		if(fydms.length==0)return fldfgzjfbs;
		String infys = "";
		for(int fydm : fydms)
			infys = fydm + ",";
		infys = infys.substring(0, infys.length()-1);
		String hql = "select NFy, NZj, count(*) from Ryjbxx where NFy in("+infys+") and NDj<=24 and NFlzw in(6,7) and NXzzw in(7,58) group by NFy, NZj";
		Query query = getSession().createQuery(hql);
		List list = query.list();
		Iterator iterator = list.iterator();
		while (iterator.hasNext()) {
			Object[] obj = (Object[]) iterator.next();
			fldfgzjfbs.put(obj[0]+"-"+obj[1], (Long)obj[2]);
		}
		return fldfgzjfbs;
	}
	
	@SuppressWarnings("rawtypes")
	public Map<String, Long> getLdbzZjFb(int...fydms){
		Map<String, Long> ldbzzjfbs = new HashMap<String, Long>();
		if(fydms.length==0)return ldbzzjfbs;
		String infys = "";
		for(int fydm : fydms)
			infys = fydm + ",";
		infys = infys.substring(0, infys.length()-1);
		String hql = "select NFy, NZj, count(*) from Ryjbxx where NFy in("+infys+") and NXzzw in(1,2,54,52,40) group by NFy, NZj";
		Query query = getSession().createQuery(hql);
		List list = query.list();
		Iterator iterator = list.iterator();
		while (iterator.hasNext()) {
			Object[] obj = (Object[]) iterator.next();
			ldbzzjfbs.put(obj[0]+"-"+obj[1], (Long)obj[2]);
		}
		return ldbzzjfbs;
	}
	
	@SuppressWarnings("rawtypes")
	public Map<String, Long> getLdbzXlFb(int...fydms){
		Map<String, Long> ldbzxlfbs = new HashMap<String, Long>();
		if(fydms.length==0)return ldbzxlfbs;
		String infys = "";
		for(int fydm : fydms)
			infys = fydm + ",";
		infys = infys.substring(0, infys.length()-1);
		String hql = "select NFy, NXl, count(*) from Ryjbxx where NFy in("+infys+") and NXzzw in(1,2,54,52,40) group by NFy, NXl";
		Query query = getSession().createQuery(hql);
		List list = query.list();
		Iterator iterator = list.iterator();
		while (iterator.hasNext()) {
			Object[] obj = (Object[]) iterator.next();
			ldbzxlfbs.put(obj[0]+"-"+obj[1], (Long)obj[2]);
		}
		return ldbzxlfbs;
	}
	
	
	
	@SuppressWarnings("rawtypes")
	public Map<String, Long> getTzZjFb(int...fydms){
		Map<String, Long> tzzjfbs = new HashMap<String, Long>();
		if(fydms.length==0)return tzzjfbs;
		String infys = "";
		for(int fydm : fydms)
			infys = fydm + ",";
		infys = infys.substring(0, infys.length()-1);
		String hql = "select NFy, NZj, count(*) from Ryjbxx where NFy in("+infys+") and NXzzw=3 group by NFy, NZj";
		Query query = getSession().createQuery(hql);
		List list = query.list();
		Iterator iterator = list.iterator();
		while (iterator.hasNext()) {
			Object[] obj = (Object[]) iterator.next();
			tzzjfbs.put(obj[0]+"-"+obj[1], (Long)obj[2]);
		}
		return tzzjfbs;
	}
	
	@SuppressWarnings("rawtypes")
	public Map<String, Long> getZbsjyFb(int...fydms){
		Map<String, Long> zbsjyfbs = new HashMap<String, Long>();
		if(fydms.length==0)return zbsjyfbs;
		String infys = "";
		for(int fydm : fydms)
			infys = fydm + ",";
		infys = infys.substring(0, infys.length()-1);
		String hql = "select NFy, NBm, count(*) from Ryjbxx where NFy in("+infys+") and NFlzw=10 and NBz is not null group by NFy, NBm";
		Query query = getSession().createQuery(hql);
		List list = query.list();
		Iterator iterator = list.iterator();
		while (iterator.hasNext()) {
			Object[] obj = (Object[]) iterator.next();
			zbsjyfbs.put(obj[0]+"-"+obj[1], (Long)obj[2]);
		}
		return zbsjyfbs;
	}
	
	@SuppressWarnings("rawtypes")
	public Map<String, Long> getBwsjyFb(int...fydms){
		Map<String, Long> bwsjyfbs = new HashMap<String, Long>();
		if(fydms.length==0)return bwsjyfbs;
		String infys = "";
		for(int fydm : fydms)
			infys = fydm + ",";
		infys = infys.substring(0, infys.length()-1);
		String hql = "select NFy, NBm, count(*) from Ryjbxx where NFy in("+infys+") and NFlzw=10 and NBz is null group by NFy, NBm";
		Query query = getSession().createQuery(hql);
		List list = query.list();
		Iterator iterator = list.iterator();
		while (iterator.hasNext()) {
			Object[] obj = (Object[]) iterator.next();
			bwsjyfbs.put(obj[0]+"-"+obj[1], (Long)obj[2]);
		}
		return bwsjyfbs;
	}
	
	@SuppressWarnings("rawtypes")
	public Map<String, Long> getZbfgzlFb(int...fydms){
		Map<String, Long> zbfgzlfbs = new HashMap<String, Long>();
		if(fydms.length==0)return zbfgzlfbs;
		String infys = "";
		for(int fydm : fydms)
			infys = fydm + ",";
		infys = infys.substring(0, infys.length()-1);
		String hql = "select NFy, NBm, count(*) from Ryjbxx where NFy in("+infys+") and NFlzw=9 and NBz is null group by NFy, NBm";
		Query query = getSession().createQuery(hql);
		List list = query.list();
		Iterator iterator = list.iterator();
		while (iterator.hasNext()) {
			Object[] obj = (Object[]) iterator.next();
			zbfgzlfbs.put(obj[0]+"-"+obj[1], (Long)obj[2]);
		}
		return zbfgzlfbs;
	}
	
	@SuppressWarnings("rawtypes")
	public Map<String, Long> getBwfgzlFb(int...fydms){
		Map<String, Long> bwfgzlfbs = new HashMap<String, Long>();
		if(fydms.length==0)return bwfgzlfbs;
		String infys = "";
		for(int fydm : fydms)
			infys = fydm + ",";
		infys = infys.substring(0, infys.length()-1);
		String hql = "select NFy, NBm, count(*) from Ryjbxx where NFy in("+infys+") and NFlzw=9 and NBz is null group by NFy, NBm";
		Query query = getSession().createQuery(hql);
		List list = query.list();
		Iterator iterator = list.iterator();
		while (iterator.hasNext()) {
			Object[] obj = (Object[]) iterator.next();
			bwfgzlfbs.put(obj[0]+"-"+obj[1], (Long)obj[2]);
		}
		return bwfgzlfbs;
	}

	/**
	 * 根据人员编号，获取签名信息
	 * 
	 * @param rybh
	 * */

	public Integer getRyCountByTopAndLeftConditions(String topCondition,
			String leftCondition, Object[] topParams, Object[] leftParams) {
		String str = "select COUNT(*) from T_RYJBXX";

		if (topCondition.isEmpty()) {
			topCondition = "1=1";
		}
		if (leftCondition.isEmpty()) {
			leftCondition = "1=1";
		}
		str += " WHERE " + topCondition + " AND " + leftCondition;
		Query query = getSession().createSQLQuery(str);
		int i = 0;
		if (topParams != null) {
			for (i = 0; i < topParams.length; i++) {
				query.setParameter(i, topParams[i]);
			}
		}
		if (leftParams != null) {
			for (int j = 0; j < leftParams.length; j++) {
				query.setParameter(j + i, leftParams[j]);
			}
		}
		return (Integer) query.uniqueResult();
	}

	public List<Ryjbxx> getRyListByFyAndBm(int fybh, int bmbh) {
		if (bmbh < 0) {
			return getRyListByFy(fybh);
		}
		String hql = "from Ryjbxx where NFy= ? and NBm= ? and NBiaozhi= 1 order by NXssx asc";
		@SuppressWarnings("unchecked")
		List<Ryjbxx> ryList = getHibernateTemplate().find(hql, fybh, bmbh);
		if (ryList == null)
			return new ArrayList<Ryjbxx>();
		return ryList;
	}

	public List<Ryjbxx> getLsryListByFyAndBm(int fybh, int bmbh) {
		if (bmbh < 0) {
			return getLsryListByFy(fybh);
		}
		String hql = "from Ryjbxx where NFy= ? and NBm= ? and NBiaozhi <> 1 order by NXssx asc";
		@SuppressWarnings("unchecked")
		List<Ryjbxx> ryList = getHibernateTemplate().find(hql, fybh, bmbh);
		if (ryList == null)
			return new ArrayList<Ryjbxx>();
		return ryList;
	}

	public List<Ryjbxx> getRyListByFy(int fybh) {
		String hql = "from Ryjbxx rj where rj.NFy= ? and rj.NBiaozhi= 1  order by rj.NBm,rj.NXssx asc";
		@SuppressWarnings("unchecked")
		List<Ryjbxx> ryList = getHibernateTemplate().find(hql, fybh);
		if (ryList == null)
			return new ArrayList<Ryjbxx>();
		return ryList;
	}

	public Ryjbxx getRyByFyAndRybh(int fydm,int rybh){
		String hql = "from Ryjbxx rj where rj.NFy= ? and rj.NRybh=? and rj.NBiaozhi= 1  order by rj.NBm,rj.NXssx asc";
		@SuppressWarnings("unchecked")
		List<Ryjbxx> ryList = getHibernateTemplate().find(hql, fydm,rybh);
		if (ryList == null||ryList.size()==0)
			return new Ryjbxx();
		return ryList.get(0);
	}
	public boolean interceptUpdateRyjbxx(Ryjbxx ryjbxx) {
		try {
			getSession().update(ryjbxx);
			getSession().flush();
			return true;
		} catch (Exception ex) {
			ex.printStackTrace();
			return false;
		}

	}

	public boolean interceptDeleteRyjbxx(Ryjbxx ryjbxx) {
		try {
			getSession().delete(ryjbxx);
			getSession().flush();
			return true;
		} catch (Exception ex) {
			ex.printStackTrace();
			return false;
		}
	}

	public boolean interceptAddRyjbxx(Ryjbxx ryjbxx) {
		try {
			getSession().save(ryjbxx);
			getSession().flush();
			return true;
		} catch (Exception ex) {
			ex.printStackTrace();
			return false;
		}
	}

	public List<Ryjbxx> getLsryListByFy(int fybh) {
		String hql = "from Ryjbxx where NFy= ? and NBiaozhi <> 1  order by NXssx asc";
		@SuppressWarnings("unchecked")
		List<Ryjbxx> ryList = getHibernateTemplate().find(hql, fybh);
		if (ryList == null)
			return new ArrayList<Ryjbxx>();
		return ryList;
	}

	public int getMaxRybhByFydm(int fydm) {
		String hql = "select max(N_RYBH) from T_RYJBXX where N_FY = " + fydm;
		Query query = getSession().createSQLQuery(hql);
		Object object = query.uniqueResult();
		int maxBh = fydm * 10000;
		if (null != object) {
			maxBh = (Integer) object;
			maxBh = maxBh + 1;
		}
		return maxBh;
	}

	public short getMaxXssxByFydm(int fydm) {
		String hql = "select max(N_XSSX) from T_RYJBXX where N_FY = " + fydm;
		Query query = getSession().createSQLQuery(hql);
		Object object = query.uniqueResult();
		short maxBh = 1;
		if (null != object) {
			maxBh = (Short) object;
			maxBh++;
		}
		return maxBh;
	}
	
	public long countByXzzw(int fydm, String xzzw){
		String hql = "select count(*) from Ryjbxx where NFy="+fydm+" and NXzzw in("+xzzw+")";
		return (Long) getHibernateTemplate().find(hql).get(0);
	}
	//计算法院总人数
	public long countByFy(int fydm){
		String hql = "select count(*) from Ryjbxx where NFy="+fydm;
		return (Long) getHibernateTemplate().find(hql).get(0);
	}
	//计算法院法官人数
	public long countFg(int fydm){
		String hql = "select count(*) from Ryjbxx where NFy="+fydm+" and NDj<=24";
		return (Long) getHibernateTemplate().find(hql).get(0);
	}
	//计算法院法官中的法律职务人数
	public long countFgByFlzw(int fydm, int flzw){
		String hql = "select count(*) from Ryjbxx where NFy="+fydm+" and NDj<=24 and NFlzw="+flzw;
		return (Long) getHibernateTemplate().find(hql).get(0);
	}
	//计算法院法律职务人数
	public long countByFlzw(int fydm, int flzw){
		String hql = "select count(*) from Ryjbxx where NFy="+fydm+" and NFlzw="+flzw;
		return (Long) getHibernateTemplate().find(hql).get(0);
	}
	//计算法院法官中的满足某条件的人数
	public long countFgByCondition(int fydm, String condition){
		String hql = "select count(*) from Ryjbxx where NFy="+fydm+" and NDj<=24 and "+condition;
		return (Long) getHibernateTemplate().find(hql).get(0);
	}
	//计算领导班子中的满足某条件的人数
	public long countLdbzByCondition(int fydm, String condition){
		String hql = "select count(*) from Ryjbxx where NFy="+fydm+" and NXzzw in(1,2,54,52,40) and "+condition;
		return (Long) getHibernateTemplate().find(hql).get(0);
	}
	//计算庭长数
	public long countTzByFy(int fydm){
		String hql = "select count(*) from Ryjbxx where NFy=? and NXzzw=3";
		return (Long) getHibernateTemplate().find(hql, fydm).get(0);
	}
	//计算法院部门符合条件的人数
	@SuppressWarnings("rawtypes")
	public Map<Integer, Long> countBm(int fydm, int bm){
		Map<Integer, Long> map = new HashMap<Integer, Long>();
		String hql = "select NFlzw, count(*) from Ryjbxx where NFy = ? and NBm = ? and NFlzw in(4,5,6,7,9,10) group by NFlzw";
		Query query = getSession().createQuery(hql);
		List list = query.setParameter(0, fydm).setParameter(1, bm).list();
		Iterator iterator = list.iterator();
		while (iterator.hasNext()) {
			Object[] obj = (Object[]) iterator.next();
			map.put((Integer) obj[0], (Long) obj[1]);
		}
		return map;
	}
	//获得对应职务列别的人员信息
	@SuppressWarnings("unchecked")
	public List<Ryjbxx> getRyListByFyAndZwlb(int fydm, int zwlb) {
		String hql = "from Ryjbxx rj where rj.NFy = ? and rj.NZwlb = ?";
		List<Ryjbxx> ryList = getHibernateTemplate().find(hql, fydm, zwlb);
		if (ryList == null)
			return new ArrayList<Ryjbxx>();
		return ryList;
	}
	//获得对应职级的人员信息
	@SuppressWarnings("unchecked")
	public List<Ryjbxx> getRyListByFyAndZj(int fydm, int zj) {
		String hql = "from Ryjbxx rj where rj.NFy = ? and rj.NZj = ?";
		List<Ryjbxx> ryList = getHibernateTemplate().find(hql, fydm, zj);
		if (ryList == null)
			return new ArrayList<Ryjbxx>();
		return ryList;
	}
	//获得对应职级的人员信息
	@SuppressWarnings("unchecked")
	public List<Ryjbxx> getRyListByFyAndZjCondition(int fydm, String zjCondition) {
		String hql = "from Ryjbxx where NFy = ? "+zjCondition;
		List<Ryjbxx> ryList = getHibernateTemplate().find(hql, fydm);
		if (ryList == null)
			return new ArrayList<Ryjbxx>();
		return ryList;
	}
	//获得对应法律职务的人员信息
	@SuppressWarnings("unchecked")
	public List<Ryjbxx> getRyListByFyAndFlzw(int fydm, int flzw) {
		String hql = "from Ryjbxx rj where rj.NFy = ? and rj.NFlzw = ?";
		List<Ryjbxx> ryList = getHibernateTemplate().find(hql, fydm, flzw);
		if (ryList == null)
			return new ArrayList<Ryjbxx>();
		return ryList;
	}
	//获得对应职级的军转干部人员信息
	@SuppressWarnings("unchecked")
	public List<Ryjbxx> getJzgbRyListByFyAndZj(int fydm, int zj) {
		String hql = "from Ryjbxx rj where rj.NFy = ? and rj.NZj = ? and rj.NJly=2";
		List<Ryjbxx> ryList = getHibernateTemplate().find(hql, fydm, zj);
		if (ryList == null)
			return new ArrayList<Ryjbxx>();
		return ryList;
	}
	//获得对应性别的人员信息
	@SuppressWarnings("unchecked")
	public List<Ryjbxx> getRyListByFyAndXb(int fydm, int xb) {
		String hql = "from Ryjbxx rj where rj.NFy = ? and rj.NXb = ?";
		List<Ryjbxx> ryList = getHibernateTemplate().find(hql, fydm, xb);
		if (ryList == null)
			return new ArrayList<Ryjbxx>();
		return ryList;
	}
	//获得对应非党员的人员信息
	@SuppressWarnings("unchecked")
	public List<Ryjbxx> getFdyRyListByFy(int fydm) {
		String hql = "from Ryjbxx rj where rj.NFy = ? and rj.NZzmm<>1 and rj.NZzmm<>2";
		List<Ryjbxx> ryList = getHibernateTemplate().find(hql, fydm);
		if (ryList == null)
			return new ArrayList<Ryjbxx>();
		return ryList;
	}
	public void interceptSaveRyjbxx(Ryjbxx ryjbxx) {
		getSession().save(ryjbxx);
	}
}