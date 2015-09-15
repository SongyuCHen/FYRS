package nju.software.fyrs.data.dao;

import java.util.List;
import nju.software.fyrs.data.dataobject.Dm;
import nju.software.fyrs.data.dataobject.Mc;

import org.hibernate.LockMode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

/**
 	* A data access object (DAO) providing persistence and search support for Dm entities.
 			* Transaction control of the save(), update() and delete() operations 
		can directly support Spring container-managed transactions or they can be augmented	to handle user-managed Spring transactions. 
		Each of these methods provides additional information for how to configure it for the desired type of transaction control. 	
	 * @see nju.software.fyrs.data.dataobject.Dm
  * @author MyEclipse Persistence Tools 
 */
public class DmDAO extends HibernateDaoSupport  {
	     private static final Logger log = LoggerFactory.getLogger(DmDAO.class);
		//property constants
	public static final String _CMC = "CMc";
	public static final String _NXSSX = "NXssx";
	public static final String _NYX = "NYx";
	public static final String _NSFZDY = "NSfzdy";
	public static final String _NSFYC = "NSfyc";
	public static final String _NDYDM = "NDydm";



	protected void initDao() {
		//do nothing
	}
    
    public void save(Dm transientInstance) {
        log.debug("saving Dm instance");
        try {
            getHibernateTemplate().save(transientInstance);
            log.debug("save successful");
        } catch (RuntimeException re) {
            log.error("save failed", re);
            throw re;
        }
    }
    
	public void delete(Dm persistentInstance) {
        log.debug("deleting Dm instance");
        try {
            getHibernateTemplate().delete(persistentInstance);
            log.debug("delete successful");
        } catch (RuntimeException re) {
            log.error("delete failed", re);
            throw re;
        }
    }
    
    public Dm findById( nju.software.fyrs.data.dataobject.DmId id) {
        log.debug("getting Dm instance with id: " + id);
        try {
            Dm instance = (Dm) getHibernateTemplate()
                    .get("software.fyrs.data.Dm", id);
            return instance;
        } catch (RuntimeException re) {
            log.error("get failed", re);
            throw re;
        }
    }
    
    
    @SuppressWarnings("unchecked")
	public List<Dm> findByExample(Dm instance) {
        log.debug("finding Dm instance by example");
        try {
            List<Dm> results = (List<Dm>) getHibernateTemplate().findByExample(instance); 
            log.debug("find by example successful, result size: " + results.size());
            return results;
        } catch (RuntimeException re) {
            log.error("find by example failed", re);
            throw re;
        }
    }    
    
    @SuppressWarnings("rawtypes")
	public List findByProperty(String propertyName, Object value) {
      log.debug("finding Dm instance with property: " + propertyName
            + ", value: " + value);
      try {
         String queryString = "from Dm as model where model." 
         						+ propertyName + "= ?";
		 return getHibernateTemplate().find(queryString, value);
      } catch (RuntimeException re) {
         log.error("find by property name failed", re);
         throw re;
      }
	}

	@SuppressWarnings("unchecked")
	public List<Dm> findByCMc(Object CMc
	) {
		return findByProperty(_CMC, CMc
		);
	}
	
	@SuppressWarnings("unchecked")
	public List<Dm> findByNXssx(Object NXssx
	) {
		return findByProperty(_NXSSX, NXssx
		);
	}
	
	@SuppressWarnings("unchecked")
	public List<Dm> findByNYx(Object NYx
	) {
		return findByProperty(_NYX, NYx
		);
	}
	
	@SuppressWarnings("unchecked")
	public List<Dm> findByNSfzdy(Object NSfzdy
	) {
		return findByProperty(_NSFZDY, NSfzdy
		);
	}
	
	@SuppressWarnings("unchecked")
	public List<Dm> findByNSfyc(Object NSfyc
	) {
		return findByProperty(_NSFYC, NSfyc
		);
	}
	
	@SuppressWarnings("unchecked")
	public List<Dm> findByNDydm(Object NDydm
	) {
		return findByProperty(_NDYDM, NDydm
		);
	}
	

	@SuppressWarnings("rawtypes")
	public List findAll() {
		log.debug("finding all Dm instances");
		try {
			String queryString = "from Dm";
		 	return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}
	
    public Dm merge(Dm detachedInstance) {
        log.debug("merging Dm instance");
        try {
            Dm result = (Dm) getHibernateTemplate()
                    .merge(detachedInstance);
            log.debug("merge successful");
            return result;
        } catch (RuntimeException re) {
            log.error("merge failed", re);
            throw re;
        }
    }

    public void attachDirty(Dm instance) {
        log.debug("attaching dirty Dm instance");
        try {
            getHibernateTemplate().saveOrUpdate(instance);
            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }
    
    public void attachClean(Dm instance) {
        log.debug("attaching clean Dm instance");
        try {
            getHibernateTemplate().lock(instance, LockMode.NONE);
            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }

	public static DmDAO getFromApplicationContext(ApplicationContext ctx) {
    	return (DmDAO) ctx.getBean("DmDAO");
	}
	// myCode
	@SuppressWarnings("unchecked")
	public List<Dm> listDmByFyfjm(String fyFjm)
	{
		// 法院代码中，类型编号是 1，所以直接编写
		String hql = "from Dm dm where dm.NBxh = 1 AND dm.CBz like ? order by dm.CBz";
		return this.getSession().createQuery(hql).setParameter(0,fyFjm).list();	
	}
	@SuppressWarnings("unchecked")
	public List<Dm> listDmByNBxh(String nBxh)
	{
		// 法院代码中，类型编号是 1，所以直接编写
		String hql = "from Dm dm where dm.NBxh = ? order by dm.NXssx";
		return this.getSession().createQuery(hql).setParameter(0,Short.valueOf(nBxh)).list();	
	}
	public Dm findDmByNBxhNdm(String nBxh,Integer nDm)
	{
		// 法院代码中，类型编号是 1，所以直接编写
		String hql = "from Dm dm where dm.NBxh = ? and dm.NDm = ?";
		return (Dm) this.getSession().createQuery(hql).setParameter(0,Short.valueOf(nBxh)).setParameter(1,nDm).uniqueResult();	
	}
	public Dm findDmByNBxhCMc(int bxh, String mc){
		String hql = "from Dm dm where dm.NBxh = "+bxh+" and dm.CMc like ?";
		return (Dm) this.getSession().createQuery(hql).setParameter(0,"%"+mc+"%").uniqueResult();	
	}
	/**
	 * 根据法院代码来获得一个 Dm
	 * @param fydm
	 * @return
	 */
    public Dm dmByFydm(int fydm)
    {
    	String hql = "from Dm dm where dm.NBxh = 1 AND dm.NDm = ?";
    	return (Dm) this.getSession().createQuery(hql).setParameter(0,fydm).uniqueResult();
    	
    }
    public Dm dmByDmBxh(int dm,int bxh)
    {
    	String hql = "from Dm dm where dm.NBxh = ? AND dm.NDm = ?";
    	System.out.println("dm->"+dm+"-ndm->"+bxh);
    	Dm dm_2 = (Dm)this.getSession().createQuery(hql).setParameter(0,(short)bxh).setParameter(1, dm).uniqueResult();
    	return dm_2;
    }
   
	
	public int getDmByVO(String name,String mc){
		String hql = "from Mc where CMc='"+mc+"'";
		@SuppressWarnings("unchecked")
		List<Mc> list = getHibernateTemplate().find(hql);
		int nbh = (int)(list.get(0).getNBxh());
		String hql1 = "from Dm where NBxh="+nbh+" and CMc='"+name+"'";
		@SuppressWarnings("unchecked")
		List<Dm> listDm = getHibernateTemplate().find(hql1);
		if(listDm.size()==0){
			return 1;
		}else{
			Dm dm = listDm.get(0);
			return dm.getNDm();
		}
	}

	/*
	 * 通过Mc找到代码编号，通过代码编号找到代码的名称
	 * */
	public String getDmByMc(int id,String mc){
		String hql = "from Mc where CMc='"+mc+"'";
		@SuppressWarnings("unchecked")
		List<Mc> list = getHibernateTemplate().find(hql);
		int nbh = (int)(list.get(0).getNBxh());
		String sql = "from Dm where NBxh="+nbh+"and NDm="+id+"";
		@SuppressWarnings("unchecked")
		List<Dm> listDm = getHibernateTemplate().find(sql);
		if(listDm.size()==0){
			return "";
		}else{
			Dm dm = listDm.get(0);
			return dm.getCMc();
		}
	}
	
	@SuppressWarnings("unchecked")
	public List<Dm> getDmListByName(String name){
		String hql = "from Mc where CMc='"+name+"'";
		List<Mc> list = getHibernateTemplate().find(hql);
		int nbh = (int)(list.get(0).getNBxh());
		String hql2 = "from Dm where NBxh="+nbh+"order by NDm";
		List<Dm> listDm = getHibernateTemplate().find(hql2);
		return listDm;
	}
	public int maxDmByNBxh(String nBxh)
	{
		return (Integer) getSession().createSQLQuery(" select max(N_DM) from T_DM WHERE N_BXH = ? ").setParameter(0,Integer.valueOf(nBxh)).uniqueResult();
	}
	// 添加自定义代码
	public boolean addDmWithDmBxh(Dm dm)
	{
		Dm d = this.dmByDmBxh(dm.getNDm(),dm.getNBxh());
		if(null != d)
		{
			return false;
		}
		Dm cmc = (Dm) getSession().createQuery(" from Dm WHERE NBxh = ? AND CMc = ? ").setParameter(0,dm.getNBxh()).setParameter(1,dm.getCMc()).uniqueResult();
		if(cmc != null)
		{
			return false;
		}
		int maxXs = (Integer) getSession().createSQLQuery(" select max(N_XSSX) from T_DM WHERE N_BXH = ? ").setParameter(0,dm.getNBxh()).uniqueResult();
		dm.setNXssx(maxXs+1);
		dm.setNYx((short)1);
		// 1 表示自定义
		dm.setNSfzdy(1);
		this.save(dm);
		return true;
	}
	public void updateDm(Dm dm)
	{
		getSession().update(dm);
	}
	
}