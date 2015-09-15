package nju.software.fyrs.service.impl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import nju.software.fyrs.biz.vo.SdcxConditionVO;
import nju.software.fyrs.data.dao.SdcxConditionDAO;
import nju.software.fyrs.data.dataobject.SdcxCondition;
import nju.software.fyrs.service.SdcxConditionService;
import nju.software.fyrs.util.DateUtil;

public class SdcxConditionServiceImpl implements SdcxConditionService {
    private SdcxConditionDAO  sdcxConditionDAO;
	@Override
	public List<SdcxConditionVO> listAll(int fydm,int rybh)
	{
		List<SdcxConditionVO> vos = new ArrayList<SdcxConditionVO>();
		List<SdcxCondition> list = sdcxConditionDAO.listAll(fydm,rybh);
		for(SdcxCondition item : list)
		{
		SdcxConditionVO vo = new SdcxConditionVO();
		beanToVo(vo, item);
		vos.add(vo);
		}
		return vos;

	}

	@Override
	public void delete(String id, String fydm, String rybh)
	{
		SdcxCondition sc = sdcxConditionDAO.findById(BigDecimal.valueOf(Integer.valueOf(id)));
		sdcxConditionDAO.delete(sc);
	}
	@Override
	public void deleteAll( String fydm, String rybh)
	{
		sdcxConditionDAO.deleteAll(fydm, rybh);
	}

	@Override
	public void add(SdcxConditionVO vo)
	{
		SdcxCondition bean = new SdcxCondition();
		bean.setNId(sdcxConditionDAO.getMaxIdBigDecimal());
		bean.setNFy(Integer.valueOf(vo.getNFy()));
		bean.setNRybh(Integer.valueOf(vo.getNRybh()));
		bean.setTConditon(vo.getTConditon());
		bean.setNRyk(Integer.valueOf(vo.getNRyk()));
		bean.setDBcsj(DateUtil.parse(vo.getDBcsj(),DateUtil.webFormat));
		bean.setCTjmc(vo.getCTjmc());
		sdcxConditionDAO.save(bean);
	}
	@Override
	public SdcxConditionVO  findByIdFydmRybh(String id,String fydm,String rybh)
	{
		SdcxCondition bean = sdcxConditionDAO.findByIdFydmRybh(id,fydm,rybh);
		SdcxConditionVO vo = new SdcxConditionVO();
		beanToVo(vo, bean);
		return vo ;
	}
	private void beanToVo(SdcxConditionVO vo,SdcxCondition item)
	{
		vo.setNId(item.getNId().toString());
		vo.setNRybh(item.getNRybh()+"");
		vo.setDBcsj(DateUtil.format(item.getDBcsj(),DateUtil.webFormat));
		vo.setNFy(item.getNFy()+"");
		vo.setCTjmc(item.getCTjmc());
		vo.setNRyk(item.getNRyk()+"");
		vo.setTConditon(item.getTConditon());
	}
	public void setSdcxConditionDAO(SdcxConditionDAO sdcxConditionDAO)
	{
		this.sdcxConditionDAO = sdcxConditionDAO;
	}
	
   
}
