package nju.software.fyrs.data.dao;



import java.math.BigDecimal;
import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

public class MaxBHDAO extends HibernateDaoSupport {

	public int getMaxBhByRybh(String sjb, String rybh) {
		int nrybh = Integer.parseInt(rybh);
		String hql="select max(NId) from "+sjb+" where NRybh="+nrybh;
		@SuppressWarnings("unchecked")
		List<Object> result=getHibernateTemplate().find(hql);
		if(result.get(0)==null){
			return 0;
		}else{
			if(sjb=="RykRc"){
				return (Integer)result.get(0);
			}else{
				return  ((BigDecimal)result.get(0)).intValue();
			}
		}
		
//		Session s = this.getSession();
//		Query query = s.createSQLQuery(hql);
//		int maxBh=0;
//		if(query.uniqueResult() != null){
//			maxBh=(Integer)query.uniqueResult();
//		}
		
	}

}
