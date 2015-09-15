package nju.software.fyrs.service.impl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import nju.software.fyrs.biz.vo.JlxxVO;
import nju.software.fyrs.data.dao.FzbJlxxDAO;
import nju.software.fyrs.data.dao.RysxTablekeyDAO;
import nju.software.fyrs.data.dataobject.FzbJlxx;
import nju.software.fyrs.service.FzbJlxxService;
import nju.software.fyrs.util.DateUtil;
import nju.software.fyrs.util.ObjectByteThreadLocal;
import nju.software.fyrs.util.ObjectSerializedUtils;
import nju.software.fyrs.util.StringUtil;

public class FzbJlxxServiceImpl implements FzbJlxxService{
	// ºÚ¿˙–≈œ¢
	RysxTablekeyDAO rysxTablekeyDAO;
	FzbJlxxDAO fzbJlxxDAO;
	@Override
	public List<JlxxVO> getJlxxByRybhFy(int rybh, int fydm)
	{
		List<FzbJlxx> jlxxList = fzbJlxxDAO.getJlxxByRybhFy(rybh, fydm);
		List<JlxxVO> jlxxVOList = new ArrayList<JlxxVO>();
		for (int i = 0; i < jlxxList.size(); i++)
		{
			JlxxVO jlxxVO = new JlxxVO();
			jlxxVO.setNId(jlxxList.get(i).getNId().toString());
			jlxxVO.setNFy(jlxxList.get(i).getNFy().toString());
			jlxxVO.setNRybh(jlxxList.get(i).getNRybh().toString());
			jlxxVO.setCSzdw(jlxxList.get(i).getCSzdw());
			jlxxVO.setCSzbm(jlxxList.get(i).getCSzbm());
			if (jlxxList.get(i).getDQsrq() != null)
			{
				jlxxVO.setDQsrq(DateUtil.format(jlxxList.get(i).getDQsrq(),
						DateUtil.webFormat).toString());
			}
			if (jlxxList.get(i).getDJzrq() != null)
			{
				jlxxVO.setDJzrq(DateUtil.format(jlxxList.get(i).getDJzrq(),
						DateUtil.webFormat).toString());
			}
			jlxxVO.setCZw(jlxxList.get(i).getCZw());
			jlxxVO.setCZj(jlxxList.get(i).getCZj());
			jlxxVO.setCZmr(jlxxList.get(i).getCZmr());
			jlxxVO.setCGlxx(jlxxList.get(i).getCGlxx());
			jlxxVOList.add(jlxxVO);
		}
		return jlxxVOList;
	}

	@Override
	public JlxxVO getRsJlxxById(String id, String fydm, String rybh)
	{
		FzbJlxx rysxJlxx = fzbJlxxDAO.getRsJlxxById(id, fydm, rybh);
		JlxxVO jlxxVO = new JlxxVO();
		jlxxVO.setNId(rysxJlxx.getNId().toString());
		jlxxVO.setNFy(rysxJlxx.getNFy().toString());
		jlxxVO.setNRybh(rysxJlxx.getNRybh().toString());
		jlxxVO.setCSzdw(rysxJlxx.getCSzdw());
		jlxxVO.setCSzbm(rysxJlxx.getCSzbm());
		if (rysxJlxx.getDQsrq() != null)
		{
			jlxxVO.setDQsrq(DateUtil.format(rysxJlxx.getDQsrq(),
					DateUtil.webFormat).toString());
		}
		if (rysxJlxx.getDJzrq() != null)
		{
			jlxxVO.setDJzrq(DateUtil.format(rysxJlxx.getDJzrq(),
					DateUtil.webFormat).toString());
		}
		jlxxVO.setCZw(rysxJlxx.getCZw());
		jlxxVO.setCZj(rysxJlxx.getCZj());
		jlxxVO.setCZmr(rysxJlxx.getCZmr());
		jlxxVO.setCGlxx(rysxJlxx.getCGlxx());
		return jlxxVO;
	}

	@Override
	public boolean delRsJlxxById(String id, String fydm, String rybh)
	{
		FzbJlxx rysxJlxx = fzbJlxxDAO.findByFyRybhId(Integer.valueOf(fydm),
				Integer.valueOf(rybh), new BigDecimal(id));
		return fzbJlxxDAO.DeleteRsJlxxById(rysxJlxx);
	}

	
	@Override
	public JlxxVO addJlxx(JlxxVO vo)
	{
		FzbJlxx rysxJlxx = new FzbJlxx();
		int fydm = Integer.valueOf(vo.getNFy());
		rysxJlxx.setNId(rysxTablekeyDAO.getMaxId(fydm, "N_FZBJLXXID"));
		rysxJlxx.setNFy(fydm);
		rysxJlxx.setNRybh(Integer.parseInt(vo.getNRybh()));
		rysxJlxx.setCSzdw(vo.getCSzdw());
		rysxJlxx.setCSzbm(vo.getCSzbm());
		if (StringUtil.isNotBlank(vo.getDQsrq()))
		{
			rysxJlxx.setDQsrq(DateUtil.parse(vo.getDQsrq(), DateUtil.webFormat));
		}
		if (StringUtil.isNotBlank(vo.getDJzrq()))
		{
			rysxJlxx.setDJzrq(DateUtil.parse(vo.getDJzrq(), DateUtil.webFormat));
		}
		rysxJlxx.setCZw(vo.getCZw());
		rysxJlxx.setCZj(vo.getCZj());
		rysxJlxx.setCZmr(vo.getCZmr());
		rysxJlxx.setCGlxx(vo.getCGlxx());
		fzbJlxxDAO.AddJlxx(rysxJlxx);
		JlxxVO jlxxVO = new JlxxVO();
		jlxxVO.setNId(rysxJlxx.getNId().toString());
		jlxxVO.setNFy(rysxJlxx.getNFy().toString());
		jlxxVO.setNRybh(rysxJlxx.getNRybh().toString());
		jlxxVO.setCSzdw(rysxJlxx.getCSzdw());
		jlxxVO.setCSzbm(rysxJlxx.getCSzbm());
		if (rysxJlxx.getDQsrq() != null)
		{
			jlxxVO.setDQsrq(DateUtil.format(rysxJlxx.getDQsrq(),
					DateUtil.webFormat).toString());
		}
		if (rysxJlxx.getDJzrq() != null)
		{
			jlxxVO.setDJzrq(DateUtil.format(rysxJlxx.getDJzrq(),
					DateUtil.webFormat).toString());
		}
		jlxxVO.setCZw(rysxJlxx.getCZw());
		jlxxVO.setCZj(rysxJlxx.getCZj());
		jlxxVO.setCZmr(rysxJlxx.getCZmr());
		jlxxVO.setCGlxx(rysxJlxx.getCGlxx());
		return jlxxVO;
	}

	
	@Override
	public JlxxVO updateRsJlxx(JlxxVO vo)
	{
		BigDecimal bd = new BigDecimal(vo.getNId());
		int fydm = Integer.valueOf(vo.getNFy());
		int rybh = Integer.valueOf(vo.getNRybh());
		FzbJlxx rysxJlxx = fzbJlxxDAO.findByFyRybhId(fydm, rybh, bd);
		try
		{
			ObjectByteThreadLocal.setObjectByte(ObjectSerializedUtils
					.writeObjectToMemory(rysxJlxx));
		} catch (Exception ex)
		{
			ex.printStackTrace();
		}
		rysxJlxx.setCSzdw(vo.getCSzdw());
		rysxJlxx.setCSzbm(vo.getCSzbm());
		if (StringUtil.isNotBlank(vo.getDQsrq()))
		{
			rysxJlxx.setDQsrq(DateUtil.parse(vo.getDQsrq(), DateUtil.webFormat));
		}
		if (StringUtil.isNotBlank(vo.getDJzrq()))
		{
			rysxJlxx.setDJzrq(DateUtil.parse(vo.getDJzrq(), DateUtil.webFormat));
		}
		rysxJlxx.setCZw(vo.getCZw());
		rysxJlxx.setCZj(vo.getCZj());
		rysxJlxx.setCZmr(vo.getCZmr());
		rysxJlxx.setCGlxx(vo.getCGlxx());
		fzbJlxxDAO.UpdateJlxx(rysxJlxx);
		JlxxVO jlxxVO = new JlxxVO();
		jlxxVO.setNId(rysxJlxx.getNId().toString());
		jlxxVO.setNFy(rysxJlxx.getNFy().toString());
		jlxxVO.setNRybh(rysxJlxx.getNRybh().toString());
		jlxxVO.setCSzdw(rysxJlxx.getCSzdw());
		jlxxVO.setCSzbm(rysxJlxx.getCSzbm());
		if (rysxJlxx.getDQsrq() != null)
		{
			jlxxVO.setDQsrq(DateUtil.format(rysxJlxx.getDQsrq(),
					DateUtil.webFormat).toString());
		}
		if (rysxJlxx.getDJzrq() != null)
		{
			jlxxVO.setDJzrq(DateUtil.format(rysxJlxx.getDJzrq(),
					DateUtil.webFormat).toString());
		}
		jlxxVO.setCZw(rysxJlxx.getCZw());
		jlxxVO.setCZj(rysxJlxx.getCZj());
		jlxxVO.setCZmr(rysxJlxx.getCZmr());
		jlxxVO.setCGlxx(rysxJlxx.getCGlxx());
		return jlxxVO;
	}

	public void setFzbJlxxDAO(FzbJlxxDAO fzbJlxxDAO) {
		this.fzbJlxxDAO = fzbJlxxDAO;
	}

	public void setRysxTablekeyDAO(RysxTablekeyDAO rysxTablekeyDAO) {
		this.rysxTablekeyDAO = rysxTablekeyDAO;
	}
}
