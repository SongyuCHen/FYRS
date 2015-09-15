package nju.software.fyrs.service;

import java.util.List;

import nju.software.fyrs.biz.vo.BmTreeDataObject;
import nju.software.fyrs.biz.vo.JgbgVO;
import nju.software.fyrs.data.dataobject.Jgbg;
import nju.software.fyrs.data.dataobject.Jgxx;

public interface JgxxService {
	public List<Jgxx> bmByFyId(int fyDm);
	public List<Jgxx> bmByFyIdXssx(int fyDm);
	public Jgxx bmByFyIdAndNcode(int fyDm,int ncode);
	public Jgxx bmByFyIdAndNunicode(int fyDm,int unicode);
	public boolean deleteByFyIdAndNcode(int fyDm,int ncode);
	
	public List<Jgbg> getJgbgById(String fyDm);
	public Jgbg getJgbgByIdAndId(int fyDm,int id);
	
	public boolean delJgbgById(int fyDm,int id);
	public void updateJgbg(Jgbg jgbg);
	public JgbgVO addJgbg(Jgbg jgbg);
	/**
	 * ��鷨Ժ�£��Ƿ���������׼�Ĳ���
	 * @param fydm
	 * @param bzbmdm
	 * @return
	 */
	public boolean isExistBzbm(int fydm,int bzbmdm);
	/**
	 * ���������������Ƿ��Ѿ�����
	 * @param fydm
	 * @param bzbmdm
	 * @param bmmc
	 * @return
	 */
	public boolean isExistBm(int fydm,String parentCLvlcode,String bmmc,int level,int bmxz);
	public BmTreeDataObject bmByFyIdTree(int fydm);
	public Jgxx addJgxxBzbm(Jgxx jgxx);
	public Jgxx addJgxxOnlyBm(Jgxx jgxx);
	public void updateJgxx(Jgxx jgxx);
	public int countJg(int fydm);
}
