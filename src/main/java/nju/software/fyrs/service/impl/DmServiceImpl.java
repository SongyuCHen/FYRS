package nju.software.fyrs.service.impl;

import java.util.List;

import com.googlecode.ehcache.annotations.Cacheable;

import nju.software.fyrs.data.dao.DmDAO;
import nju.software.fyrs.data.dataobject.Dm;
import nju.software.fyrs.service.DmService;

public class DmServiceImpl implements DmService{
    private DmDAO dmDAO;
	@Override
	@Cacheable(cacheName="dmbCache")
	public String findFymc(Integer fydm) {
		Dm dm = dmDAO.dmByFydm(fydm);
		return dm.getCMc();
	}
	
	public void setDmDAO(DmDAO dmDAO) {
		this.dmDAO = dmDAO;
	}

	@Override
	@Cacheable(cacheName="dmbCache")
	public List<Dm> listDmByNBxh(String nBxh) {
		return dmDAO.listDmByNBxh(nBxh);
	}

	@Override
	@Cacheable(cacheName="dmbCache")
	public Dm dmByDmBxh(int dm, int bxh) {
		return dmDAO.dmByDmBxh(dm, bxh);
	}

	@Override
	@Cacheable(cacheName="dmbCache")
	public Dm findDmByNBxhNdm(String nBxh, Integer nDm) {
		Dm dm = dmDAO.findDmByNBxhNdm(nBxh, nDm);
		if(dm == null){
			dm = new Dm();
			dm.setCMc(" ");
			dm.setNBxh((short)-1);
			dm.setNDm(-1);
		}
		return dm;
	}
	@Override
	@Cacheable(cacheName="dmbCache")
	public int maxDmByNBxh(String nBxh)
	{
		return dmDAO.maxDmByNBxh(nBxh);
	}
	@Override
	@Cacheable(cacheName="dmbCache")
	public boolean addDmWithDmBxh(Dm dm)
	{
		return dmDAO.addDmWithDmBxh(dm);
	}
	@Override
	@Cacheable(cacheName="dmbCache")
	public void updateDm(Dm dm)
	{
		dmDAO.updateDm(dm);
	}
	@Override
	public void deleteDm(String dm,String nbxh)
	{
		Dm dmGet = dmDAO.dmByDmBxh(Integer.valueOf(dm),Integer.valueOf(nbxh));
		if(null != dmGet)
		{
			dmDAO.delete(dmGet);
		}
		
	}

	@Override
	@Cacheable(cacheName="dmbCache")
	public String getDmByMc(int id, String mc) {
		// TODO Auto-generated method stub
		return dmDAO.getDmByMc(id, mc);
	}

	@Override
	public List<Dm> getDmListByName(String name) {
		// TODO Auto-generated method stub
		return dmDAO.getDmListByName(name);
	}


	
}
