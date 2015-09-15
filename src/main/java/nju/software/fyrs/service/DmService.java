package nju.software.fyrs.service;

import java.util.List;

import nju.software.fyrs.data.dataobject.Dm;

public interface DmService {
	public String findFymc(Integer fydm);
	public Dm dmByDmBxh(int dm,int bxh);
	public String getDmByMc(int id,String mc);
	public void updateDm(Dm dm);
	public void deleteDm(String dm,String nbxh);
	// ��������Ѿ����ڲ��ܱ���
	public boolean addDmWithDmBxh(Dm dm);
	public List<Dm> listDmByNBxh(String nBxh);
	public List<Dm> getDmListByName(String name);
	public int maxDmByNBxh(String nBxh);
    public Dm findDmByNBxhNdm(String nBxh,Integer nDm);
}
