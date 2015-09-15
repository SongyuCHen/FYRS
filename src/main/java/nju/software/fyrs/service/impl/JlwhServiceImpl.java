package nju.software.fyrs.service.impl;

import java.util.List;

import nju.software.fyrs.data.dao.JlwhDAO;
import nju.software.fyrs.data.dataobject.Jlwh;
import nju.software.fyrs.service.JlwhService;

public class JlwhServiceImpl implements JlwhService {
    private JlwhDAO jlwhDAO;
	@Override
	public List<Jlwh> listJlwhByFyBm(int fydm, int bmbh) {
		return jlwhDAO.listJlwhByFyBm(fydm,bmbh);
	}
	@Override
	public Jlwh addJlwh(Jlwh jlwh)
	{
		jlwh.setNId(jlwhDAO.getMaxId(jlwh.getNFy()));
		jlwhDAO.save(jlwh);
		return jlwh;
	}
	@Override
	public void updateJlwh(Jlwh jlwh)
	{
		jlwhDAO.updateJlwh(jlwh);
	}
	@Override
	public Jlwh getJlwh(int fydm,String nid)
	{
		return jlwhDAO.getJlwh(fydm,nid);
	}
	public void deleteJlwh(int fydm,String nid)
	{
		Jlwh jlwh = jlwhDAO.getJlwh(fydm, nid);
        jlwhDAO.delete(jlwh);
	}
	public void setJlwhDAO(JlwhDAO jlwhDAO) {
		this.jlwhDAO = jlwhDAO;
	}

	@Override
	public List<Jlwh> listJlwhByFy(int fydm) {
		return jlwhDAO.listJlwhByFy(fydm);
	}
	
   
}
