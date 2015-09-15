package nju.software.fyrs.data.dao;

import java.util.List;

import nju.software.fyrs.data.dataobject.GdtjTjbtj;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

public class GdtjTjbtjDAO extends HibernateDaoSupport {
	@SuppressWarnings("unchecked")
	public List<GdtjTjbtj>findHangTjByBbh(int bbh){
		String queryString = "from GdtjTjbtj where NBbh="+bbh+" and NWz=0 order by NXh asc";
		return getHibernateTemplate().find(queryString);
	}
	
	@SuppressWarnings("unchecked")
	public List<GdtjTjbtj>findLieTjByBbh(int bbh){
		String queryString = "from GdtjTjbtj where NBbh="+bbh+" and NWz=1 order by NXh asc";
		return getHibernateTemplate().find(queryString);
	}
	
	@SuppressWarnings("unchecked")
	public List<GdtjTjbtj>findTjByTjbhs(String tjbhs){
		String queryString = "from GdtjTjbtj where NTjbh in("+tjbhs+") order by NXh asc";
		return getHibernateTemplate().find(queryString);
	}
	
	public Long getCountBySQL(String hql){
		return (Long) getHibernateTemplate().find(hql).get(0);
	}
}
