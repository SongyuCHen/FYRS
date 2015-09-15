package nju.software.fyrs.data.dao;

import nju.software.fyrs.data.dataobject.RyjbxxFzb;
import nju.software.fyrs.data.dataobject.RykFzb;
import org.hibernate.Query;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.springframework.transaction.annotation.Transactional;

public class RyjbxxFzbDAO extends HibernateDaoSupport{
	RykFzbDAO rykFzbDAO;
    private static final Logger log = LoggerFactory.getLogger(RyjbxxFzbDAO.class);
	protected void initDao() {
		//do nothing
	}
	public void save(RyjbxxFzb transientInstance) {
        log.debug("saving RyjbxxFzb instance");
        try {
            getHibernateTemplate().save(transientInstance);
            log.debug("save successful");
        } catch (RuntimeException re) {
            log.error("save failed", re);
            throw re;
        }
    }
    
    public void update(RyjbxxFzb transientInstance) {
        log.debug("updating RyjbxxFzb instance");
        try {
            getHibernateTemplate().update(transientInstance);
            log.debug("update successful");
        } catch (RuntimeException re) {
            log.error("update failed", re);
            throw re;
        }
    }
    
	public void delete(RyjbxxFzb persistentInstance) {
        log.debug("deleting RyjbxxFzb instance");
        try {
            getHibernateTemplate().delete(persistentInstance);
            log.debug("delete successful");
        } catch (RuntimeException re) {
            log.error("delete failed", re);
            throw re;
        }
    }
	
	public RyjbxxFzb getRyjbxxFzbByRybhFyDm(Integer nRybh, Integer nFy) {
		 String hql = "from RyjbxxFzb rj where rj.NFy = ? and rj.NRybh = ?";
		  return (RyjbxxFzb) getSession().createQuery(hql).setParameter(0,nFy).setParameter(1,nRybh).uniqueResult();
	}

	public int getMaxRybhByFydm(int fydm) {
		String hql = "select max(N_RYBH) from T_RYJBXX_FZB where N_FY = " + fydm;
		Query query = getSession().createSQLQuery(hql);
		Object object = query.uniqueResult();
		int maxBh = fydm*10000 + 10001;
		if(null != object)
		{
			maxBh = (Integer)object;
			maxBh = maxBh + 1;
		}
        return maxBh;
	}

	@Transactional
	public void saveRyFzb(int rybh, int fydm, RyjbxxFzb ry) {
		RykFzb fzb = rykFzbDAO.getFzbByRybhFyFzbrylx(rybh, fydm, 2);
		if(fzb == null){ //ÐÂÔö
			fzb = new RykFzb(rykFzbDAO.getMaxNid(fydm), fydm, rybh, ry.getNBm(), 2, rykFzbDAO.getMaxNXssx(fydm), 0);
			if(ry.getDCrq() != null && ry.getNCyy() != null){
				fzb.setNSfls(1);
			}
			rykFzbDAO.save(fzb);
			ry.setNRybh(rybh);
			ry.setNFy(fydm);
			save(ry);
		}else{//ÐÞ¸Ä
			if(ry.getDCrq() != null && ry.getNCyy() != null){
				fzb.setNSfls(1);
			}
			rykFzbDAO.update(fzb);			
			ry.setNRybh(rybh);
			ry.setNFy(fydm);
			update(ry);
		}
		
	}
	public void setRykFzbDAO(RykFzbDAO rykFzbDAO) {
		this.rykFzbDAO = rykFzbDAO;
	}

}
