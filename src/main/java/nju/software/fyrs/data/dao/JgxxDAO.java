package nju.software.fyrs.data.dao;

import java.util.List;

import nju.software.fyrs.data.dataobject.Jgxx;

import org.hibernate.LockMode;
import org.hibernate.Query;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

/**
 	* A data access object (DAO) providing persistence and search support for Jgxx entities.
 			* Transaction control of the save(), update() and delete() operations 
		can directly support Spring container-managed transactions or they can be augmented	to handle user-managed Spring transactions. 
		Each of these methods provides additional information for how to configure it for the desired type of transaction control. 	
	 * @see nju.software.fyrs.data.dataobject.Jgxx
  * @author MyEclipse Persistence Tools 
 */
public class JgxxDAO extends HibernateDaoSupport  {
	     private static final Logger log = LoggerFactory.getLogger(JgxxDAO.class);
		//property constants
	public static final String _NUNICODE = "NUnicode";
	public static final String _NLEVEL = "NLevel";
	public static final String _CNAME = "CName";
	public static final String _CSTNAME = "CStname";
	public static final String _CLVLCODE = "CLvlcode";
	public static final String _NZGLDZW = "NZgldzw";
	public static final String _NRYSL = "NRysl";
	public static final String _NYX = "NYx";
	public static final String _NSFXS = "NSfxs";
	public static final String _NXSSX = "NXssx";
	public static final String _NRYXZ = "NRyxz";
	public static final String _NBMXZ = "NBmxz";



	protected void initDao() {
		//do nothing
	}
    
    public void save(Jgxx transientInstance) {
        log.debug("saving Jgxx instance");
        try {
            getHibernateTemplate().save(transientInstance);
            log.debug("save successful");
        } catch (RuntimeException re) {
            log.error("save failed", re);
            throw re;
        }
    }
    
	public void delete(Jgxx persistentInstance) {
        log.debug("deleting Jgxx instance");
        try {
            getHibernateTemplate().delete(persistentInstance);
            log.debug("delete successful");
        } catch (RuntimeException re) {
            log.error("delete failed", re);
            throw re;
        }
    }
    
    public Jgxx findById( nju.software.fyrs.data.dataobject.JgxxId id) {
        log.debug("getting Jgxx instance with id: " + id);
        try {
            Jgxx instance = (Jgxx) getHibernateTemplate()
                    .get("software.fyrs.data.Jgxx", id);
            return instance;
        } catch (RuntimeException re) {
            log.error("get failed", re);
            throw re;
        }
    }
    
    
    @SuppressWarnings("unchecked")
	public List<Jgxx> findByExample(Jgxx instance) {
        log.debug("finding Jgxx instance by example");
        try {
            List<Jgxx> results = (List<Jgxx>) getHibernateTemplate().findByExample(instance); 
            log.debug("find by example successful, result size: " + results.size());
            return results;
        } catch (RuntimeException re) {
            log.error("find by example failed", re);
            throw re;
        }
    }    
    
    @SuppressWarnings("rawtypes")
	public List findByProperty(String propertyName, Object value) {
      log.debug("finding Jgxx instance with property: " + propertyName
            + ", value: " + value);
      try {
         String queryString = "from Jgxx as model where model." 
         						+ propertyName + "= ?";
		 return getHibernateTemplate().find(queryString, value);
      } catch (RuntimeException re) {
         log.error("find by property name failed", re);
         throw re;
      }
	}

	@SuppressWarnings("unchecked")
	public List<Jgxx> findByNUnicode(Object NUnicode
	) {
		return findByProperty(_NUNICODE, NUnicode
		);
	}
	
	@SuppressWarnings("unchecked")
	public List<Jgxx> findByNLevel(Object NLevel
	) {
		return findByProperty(_NLEVEL, NLevel
		);
	}
	
	@SuppressWarnings("unchecked")
	public List<Jgxx> findByCName(Object CName
	) {
		return findByProperty(_CNAME, CName
		);
	}
	
	@SuppressWarnings("unchecked")
	public List<Jgxx> findByCStname(Object CStname
	) {
		return findByProperty(_CSTNAME, CStname
		);
	}
	
	@SuppressWarnings("unchecked")
	public List<Jgxx> findByCLvlcode(Object CLvlcode
	) {
		return findByProperty(_CLVLCODE, CLvlcode
		);
	}
	
	@SuppressWarnings("unchecked")
	public List<Jgxx> findByNZgldzw(Object NZgldzw
	) {
		return findByProperty(_NZGLDZW, NZgldzw
		);
	}
	
	@SuppressWarnings("unchecked")
	public List<Jgxx> findByNRysl(Object NRysl
	) {
		return findByProperty(_NRYSL, NRysl
		);
	}
	
	@SuppressWarnings("unchecked")
	public List<Jgxx> findByNYx(Object NYx
	) {
		return findByProperty(_NYX, NYx
		);
	}
	
	@SuppressWarnings("unchecked")
	public List<Jgxx> findByNSfxs(Object NSfxs
	) {
		return findByProperty(_NSFXS, NSfxs
		);
	}
	
	@SuppressWarnings("unchecked")
	public List<Jgxx> findByNXssx(Object NXssx
	) {
		return findByProperty(_NXSSX, NXssx
		);
	}
	
	@SuppressWarnings("unchecked")
	public List<Jgxx> findByNRyxz(Object NRyxz
	) {
		return findByProperty(_NRYXZ, NRyxz
		);
	}
	
	@SuppressWarnings("unchecked")
	public List<Jgxx> findByNBmxz(Object NBmxz
	) {
		return findByProperty(_NBMXZ, NBmxz
		);
	}
	

	@SuppressWarnings("rawtypes")
	public List findAll() {
		log.debug("finding all Jgxx instances");
		try {
			String queryString = "from Jgxx";
		 	return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}
	
    public Jgxx merge(Jgxx detachedInstance) {
        log.debug("merging Jgxx instance");
        try {
            Jgxx result = (Jgxx) getHibernateTemplate()
                    .merge(detachedInstance);
            log.debug("merge successful");
            return result;
        } catch (RuntimeException re) {
            log.error("merge failed", re);
            throw re;
        }
    }

    public void attachDirty(Jgxx instance) {
        log.debug("attaching dirty Jgxx instance");
        try {
            getHibernateTemplate().saveOrUpdate(instance);
            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }
    
    public void attachClean(Jgxx instance) {
        log.debug("attaching clean Jgxx instance");
        try {
            getHibernateTemplate().lock(instance, LockMode.NONE);
            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }
    
	public static JgxxDAO getFromApplicationContext(ApplicationContext ctx) {
    	return (JgxxDAO) ctx.getBean("JgxxDAO");
	}
	// myCode
	@SuppressWarnings("unchecked")
	public List<Jgxx> bmByFyId(int fyDm)
	{
		String hql = "from Jgxx jx where jx.NFy = ? order by jx.NCode";
		List<Jgxx> lists = getSession().createQuery(hql).setParameter(0,fyDm).list();
		return lists;
	}
	public Jgxx bmByFyIdAndNcode(int fyDm, int ncode) {
		String hql = "from Jgxx jx where jx.NFy = ? and jx.NCode = ?";
		return (Jgxx) getSession().createQuery(hql).setParameter(0, fyDm).setParameter(1,ncode).uniqueResult();
	}
	public Jgxx bmByFydmAndName(int fydm, String name){
		String hql = "from Jgxx jx where jx.NFy = ? and jx.CName like ?";
		return (Jgxx) getSession().createQuery(hql).setParameter(0, fydm).setParameter(1, "%"+name+"%").uniqueResult();
	}
	public int countJg(int fydm)
	{
		// 计算部门总数
		String sql = "select COUNT(*) FROM T_JGXX WHERE N_FY = ? and C_NAME IS NOT NULL";
        Query query = getSession().createSQLQuery(sql);
        query.setParameter(0,fydm);
		return (Integer)query.uniqueResult();
	}
	public Jgxx findJgxxByFyUnicode(int fydm, int unicode) {
		String hql = "from Jgxx jx where jx.NFy = ? and jx.NUnicode = ?";
		return (Jgxx) getSession().createQuery(hql).setParameter(0, fydm).setParameter(1, unicode).uniqueResult();
	}
	public Boolean hasChildren(int fydm,String parent) {
		String hql = "from Jgxx jx where jx.NFy = ? and jx.CLvlcode like ?";
		return getSession().createQuery(hql).setParameter(0, fydm).setParameter(1,parent).list().size() > 1;
	}
    public void updateJgxx(Jgxx jgxx) {
		getSession().update(jgxx);
	}
  
	public boolean isExistBzbm(int fydm, int bzbmdm)
	{
		Jgxx jgxx = (Jgxx) getSession().createQuery(" from Jgxx jx where jx.NFy = ? and jx.NCode = ? ").setParameter(0, fydm).setParameter(1, bzbmdm).uniqueResult();
		if(null != jgxx)
		{
			return true;
		}
		return false;
	}
	
	public boolean isExistBm(int fydm,String parentCLvlcode,String bmmc,int level,int bmxz)
	{
		// 表示它是法院下面的部门
		if(level == 1)
		{
			Jgxx jgxx = (Jgxx) getSession().createQuery(" from Jgxx jx where jx.NFy = ? and jx.CName = ? and jx.NBmxz = ?").setParameter(0, fydm).setParameter(1, bmmc).setParameter(2,bmxz).uniqueResult();
		    if(null != jgxx)
		    {
		    	return true;
		    }
		}
		else
		{
			String like = "";
			if(level == 2)
			{
				like = parentCLvlcode.substring(0,4)+"%";
			}
			if(level == 3)
			{
				like = parentCLvlcode.substring(0,8)+"%";
			}
		   
			Jgxx jgxx = (Jgxx) getSession().createQuery(" from Jgxx jx where jx.NFy = ? and jx.CName = ? and jx.CLvlcode like ? and jx.CLvlcode != ? and jx.NLevel = ? ").setParameter(0, fydm).setParameter(1, bmmc).setParameter(2,like).setParameter(3,parentCLvlcode).setParameter(4, (short)level).uniqueResult();
		    if(jgxx != null)
		    {
		    	return true;
		    }
		}
		return false;
	}
	/**
	 * 直接是可以使用的 xssx
	 * @param fydm
	 * @param level
	 * @return
	 */
	public short maxXssx(int fydm,short level)
	{
		Object object = getSession().createQuery(" select max(NXssx) from Jgxx jx where jx.NFy = ? and jx.NLevel = ? ").setParameter(0, fydm).setParameter(1,level).uniqueResult();
	    short maxXssx = 1;
		if(null != object)
	    {
	    	maxXssx = (Short)object;
	    	maxXssx += (short)1;
	    }
		return maxXssx;
	}
	public int maxCode(int fydm,short level)
	{
		Object object = getSession().createQuery(" select max(NCode) from Jgxx jx where jx.NFy = ? and jx.NLevel = ? ").setParameter(0, fydm).setParameter(1,level).uniqueResult();
	    int maxCode = -1;
	    if(level == 2)
	    {
	    	maxCode = 1000;
	    }
	    if(level == 3)
	    {
	    	maxCode = 2000;
	    }
		if(null != object)
	    {
			maxCode = (Integer)object;
			maxCode += 1;
	    }
		return maxCode;
	}
	@SuppressWarnings("unchecked")
	public List<Jgxx> bmByFyIdXssx(int fyDm)
	{
		String hql = "from Jgxx jx where jx.NFy = ? order by jx.NXssx";
		List<Jgxx> lists = getSession().createQuery(hql).setParameter(0,fyDm).list();
		return lists;
	}
	/**
	 * 保存这个对象返回这个对象
	 * @param jgxx
	 * @return
	 */
	public Jgxx saveRObject(Jgxx jgxx)
	{
		getSession().save(jgxx);
		return jgxx;
	}
	
	//获得法院法庭数
	public long countFtByFy(int fydm){
		String hql = "select count(*) from Jgxx where NFy = ? and (CName like '%庭%' or CStname like '%庭%')";
		return (Long) getHibernateTemplate().find(hql, fydm).get(0);
	}
	// myCode

	
}