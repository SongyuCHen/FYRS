package nju.software.fyrs.data.dao;

import java.util.List;

import nju.software.fyrs.data.dataobject.Gdtj;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

public class GdtjDAO extends HibernateDaoSupport {
	@SuppressWarnings("unchecked")
	public List<Gdtj>findAll(){
		String queryString = "from Gdtj order by NBbh asc";
		return getHibernateTemplate().find(queryString);
	}
	public Gdtj findByBbh(String bbh){
		try {
			Gdtj instance = (Gdtj) getHibernateTemplate().get(
					"nju.software.fyrs.data.dataobject.Gdtj", Short.parseShort(bbh));
			return instance;
		} catch (RuntimeException re) {
			throw re;
		}
	}
}
