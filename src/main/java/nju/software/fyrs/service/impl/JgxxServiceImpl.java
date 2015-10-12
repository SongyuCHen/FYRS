package nju.software.fyrs.service.impl;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import nju.software.fyrs.biz.vo.BmTreeDataObject;
import nju.software.fyrs.biz.vo.JgbgVO;
import nju.software.fyrs.data.dao.JgbgDAO;
import nju.software.fyrs.data.dao.JgxxDAO;
import nju.software.fyrs.data.dao.RysxTablekeyDAO;
import nju.software.fyrs.data.dataobject.Jgbg;
import nju.software.fyrs.data.dataobject.Jgxx;
import nju.software.fyrs.service.JgxxService;
import nju.software.fyrs.util.DateUtil;
import nju.software.fyrs.util.DmCommonList;

public class JgxxServiceImpl implements JgxxService{
	private JgxxDAO jgxxDAO;
	private JgbgDAO jgbgDAO;
	private RysxTablekeyDAO rysxTablekeyDAO;
	public List<Jgxx> bmByFyId(int fyDm) {
		return jgxxDAO.bmByFyId(fyDm);
	}
	public List<Jgxx> bmByFyIdXssx(int fyDm)
	{
		return jgxxDAO.bmByFyIdXssx(fyDm);
	}
	@Override
	public Jgxx bmByFyIdAndNcode(int fyDm, int ncode) {
		return jgxxDAO.bmByFyIdAndNcode(fyDm,ncode);
	}
	@Override
	public Jgxx bmByFyIdAndNunicode(int fydm, int unicode) {
		return jgxxDAO.findJgxxByFyUnicode(fydm, unicode);
	}
	@Override
	public boolean deleteByFyIdAndNcode(int fyDm, int ncode) {
		Jgxx jgxx = jgxxDAO.bmByFyIdAndNcode(fyDm, ncode);
		/**
		 * 如果这个机构的人数不为 0 是不能删除的
		 */
		if(null != jgxx.getNRysl() && jgxx.getNRysl() != 0)
		{
			return false;
		}
		// 可以直接删除
		if(jgxx.getNLevel() == 3)
		{
			jgxxDAO.delete(jgxx);
			return true;
		}
		if(jgxx.getNLevel() == 2)
		{
			if(!jgxxDAO.hasChildren(fyDm, jgxx.getCLvlcode().substring(0,8)+"%"))
			{
				jgxxDAO.delete(jgxx);
				return true;
			}
		}
		if(jgxx.getNLevel() == 1)
		{
			if(!jgxxDAO.hasChildren(fyDm, jgxx.getCLvlcode().substring(0,4)+"%"))
			{
				jgxxDAO.delete(jgxx);
				return true;
			}
		}
		return false;
	}
	@Override
	public int countJg(int fydm) {
		return jgxxDAO.countJg(fydm);
	}
	public JgxxDAO getJgxxDAO() {
		return jgxxDAO;
	}

	public void setJgxxDAO(JgxxDAO jgxxDAO) {
		this.jgxxDAO = jgxxDAO;
	}
	
	
	public JgbgDAO getJgbgDAO() {
		return jgbgDAO;
	}
	public void setJgbgDAO(JgbgDAO jgbgDAO) {
		this.jgbgDAO = jgbgDAO;
	}
	@Override
	public BmTreeDataObject bmByFyIdTree(int fydm) {
		List<Jgxx> jgxxs = this.bmByFyId(fydm);
		BmTreeDataObject root = new BmTreeDataObject();
		Map<String,BmTreeDataObject> jgxxsMap = new HashMap<String,BmTreeDataObject>();
		for(int i = 0; i < jgxxs.size(); i++)
		{
			Jgxx jgxx = jgxxs.get(i);
			BmTreeDataObject bm = new BmTreeDataObject();
			bm.setCode(jgxx.getNCode());
			bm.setLvlCode(jgxx.getCLvlcode());
			bm.setName(jgxx.getCName());
			if(jgxx.getNLevel() == 1)
			{
				jgxxsMap.put(jgxx.getCLvlcode().substring(0,4),bm);
				root.getChildren().add(bm);
			}
			if(jgxx.getNLevel()  == 2)
			{
				jgxxsMap.get(jgxx.getCLvlcode().substring(0,4)).getChildren().add(bm);
				jgxxsMap.put(bm.getLvlCode().substring(0,8),bm);
			}
			if(jgxx.getNLevel() == 3)
			{
				jgxxsMap.get(bm.getLvlCode().substring(0,8)).getChildren().add(bm);
			}
		}
		return root;
	}
	
	
	@Override
	public Jgxx addJgxxBzbm(Jgxx jgxx)
	{
		jgxx.setNXssx(jgxxDAO.maxXssx(jgxx.getNFy(),jgxx.getNLevel()));
	    return jgxxDAO.saveRObject(jgxx);
	}
	@Override
	public Jgxx addJgxxOnlyBm(Jgxx jgxx)
	{
		int code = jgxxDAO.maxCode(jgxx.getNFy(), jgxx.getNLevel());
		jgxx.setNCode(code);
		if(jgxx.getNLevel() == 2)
		{
		  	jgxx.setCLvlcode(jgxx.getCLvlcode().substring(0,4)+DmCommonList.addNum[String.valueOf(code).trim().length()]+code+"0000");
		}
		if(jgxx.getNLevel() == 3)
		{
			jgxx.setCLvlcode(jgxx.getCLvlcode().substring(0,8)+DmCommonList.addNum[String.valueOf(code).trim().length()]+code);
		}
		jgxx.setNRysl(0);
		jgxx.setNYx(1);
		jgxx.setNXssx(jgxxDAO.maxXssx(jgxx.getNFy(),jgxx.getNLevel()));
		return jgxxDAO.saveRObject(jgxx);
	}
	@Override
	public void updateJgxx(Jgxx jgxx) {
		jgxxDAO.updateJgxx(jgxx);
	}
	@Override
	public boolean isExistBzbm(int fydm, int bzbmdm)
	{
		return jgxxDAO.isExistBzbm(fydm, bzbmdm);
	}
	@Override
	public boolean isExistBm(int fydm,String parentCLvlcode,String bmmc,int level,int bmxz)
	{
	  return jgxxDAO.isExistBm(fydm, parentCLvlcode, bmmc, level,bmxz);
	}
	@Override
	public List<Jgbg> getJgbgById(String fyDm) {
		// TODO Auto-generated method stub
		return jgbgDAO.getJgbgByRybh(fyDm);
	}
	@Override
	public Jgbg getJgbgByIdAndId(int fyDm, int id) {
		// TODO Auto-generated method stub
		String sfydm = Integer.toString(fyDm);
		String sid = Integer.toString(id);
		return jgbgDAO.getJgbgByRybhHtbh(sfydm, sid);
	}
	@Override
	public boolean delJgbgById(int fyDm, int id) {
		// TODO Auto-generated method stub
		String sfydm = Integer.toString(fyDm);
		String sid = Integer.toString(id);
		return jgbgDAO.delJgbgById(sfydm, sid);
	}
	@Override
	public void updateJgbg(Jgbg jgbg) {
		// TODO Auto-generated method stub
		jgbgDAO.update(jgbg);
	}
	@Override
	public JgbgVO addJgbg(Jgbg jgbg) {
		// TODO Auto-generated method stub
		int fydm = Integer.valueOf(jgbg.getNFy());
		BigDecimal bd = rysxTablekeyDAO.getMaxId(fydm, "N_JGBGID");
		jgbg.setNId(bd);
		jgbgDAO.save(jgbg);
		Jgbg newJgbg = getJgbgByIdAndId(jgbg.getNFy(), jgbg.getNId().intValue());
		JgbgVO jgbgVO = new JgbgVO();
		jgbgVO.setNId(newJgbg.getNId()+"");
		jgbgVO.setNFy(newJgbg.getNFy().toString());
		jgbgVO.setCBbpfbh(newJgbg.getCBbpfbh());
		jgbgVO.setDBbpfsj(DateUtil.format(newJgbg.getDBbpfsj(), DateUtil.webFormat));
		jgbgVO.setDBgsj(DateUtil.format(newJgbg.getDBgsj(), DateUtil.webFormat));
		jgbgVO.setCBgnr(newJgbg.getCBgnr());
		jgbgVO.setCbgr(newJgbg.getCBgr());
		return jgbgVO;
	}
	public void setRysxTablekeyDAO(RysxTablekeyDAO rysxTablekeyDAO) {
		this.rysxTablekeyDAO = rysxTablekeyDAO;
	}
	@Override
	public Jgxx bmByFyidAndLvlCode(int fydm, String lvlcode) {
		// TODO Auto-generated method stub
		return jgxxDAO.bhByFyIdAndLvlCode(fydm,lvlcode);
	}
	
	
	
}
