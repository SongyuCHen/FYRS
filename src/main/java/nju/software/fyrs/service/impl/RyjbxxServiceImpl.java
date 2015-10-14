package nju.software.fyrs.service.impl;

import java.lang.reflect.InvocationTargetException;
import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.log4j.Logger;
import org.springframework.transaction.annotation.Transactional;

import nju.software.fyrs.biz.vo.BmbdVO;
import nju.software.fyrs.biz.vo.BzxxVO;
import nju.software.fyrs.biz.vo.CcxxVO;
import nju.software.fyrs.biz.vo.CgxxVO;
import nju.software.fyrs.biz.vo.DjxxVO;
import nju.software.fyrs.biz.vo.FlzwVO;
import nju.software.fyrs.biz.vo.GwyjbVO;
import nju.software.fyrs.biz.vo.GzxxVO;
import nju.software.fyrs.biz.vo.HbgbVO;
import nju.software.fyrs.biz.vo.JliuxxVO;
import nju.software.fyrs.biz.vo.JlixxVO;
import nju.software.fyrs.biz.vo.JlxxVO;
import nju.software.fyrs.biz.vo.JrzwVO;
import nju.software.fyrs.biz.vo.JtxxVO;
import nju.software.fyrs.biz.vo.KhxxVO;
import nju.software.fyrs.biz.vo.LdbzVO;
import nju.software.fyrs.biz.vo.PxxxVO;
import nju.software.fyrs.biz.vo.RcxxVO;
import nju.software.fyrs.biz.vo.RyjbxxHmcVO;
import nju.software.fyrs.biz.vo.RyjbxxRylhTimeShowVo;
import nju.software.fyrs.biz.vo.RyjbxxRylhTimeVo;
import nju.software.fyrs.biz.vo.RyjbxxRylhTimeVoComparator;
import nju.software.fyrs.biz.vo.RyjbxxRylhVO;
import nju.software.fyrs.biz.vo.RyjbxxVO;
import nju.software.fyrs.biz.vo.RysxFljlVO;
import nju.software.fyrs.biz.vo.RysxHtVO;
import nju.software.fyrs.biz.vo.RysxShebaoVO;
import nju.software.fyrs.biz.vo.SdcxShowColumnsVO;
import nju.software.fyrs.biz.vo.SfksVO;
import nju.software.fyrs.biz.vo.SwxxVO;
import nju.software.fyrs.biz.vo.SyyyxVO;
import nju.software.fyrs.biz.vo.TxlVO;
import nju.software.fyrs.biz.vo.WyxxVO;
import nju.software.fyrs.biz.vo.XiujiaVO;
import nju.software.fyrs.biz.vo.XlxxVO;
import nju.software.fyrs.biz.vo.XwxxVO;
import nju.software.fyrs.biz.vo.XzzwVO;
import nju.software.fyrs.biz.vo.ZdxxVO;
import nju.software.fyrs.biz.vo.ZjbgVO;
import nju.software.fyrs.biz.vo.ZjxxVO;
import nju.software.fyrs.biz.vo.ZyjszwVO;
import nju.software.fyrs.biz.vo.ZzmmVO;
import nju.software.fyrs.data.dao.DmDAO;
import nju.software.fyrs.data.dao.JgxxDAO;
import nju.software.fyrs.data.dao.MaxBHDAO;
import nju.software.fyrs.data.dao.RyjbxxDAO;
import nju.software.fyrs.data.dao.RykRcDAO;
import nju.software.fyrs.data.dao.RysxBmbdDAO;
import nju.software.fyrs.data.dao.RysxBzxxDAO;
import nju.software.fyrs.data.dao.RysxCcxxDAO;
import nju.software.fyrs.data.dao.RysxCgxxDAO;
import nju.software.fyrs.data.dao.RysxDjxxDAO;
import nju.software.fyrs.data.dao.RysxFljlDAO;
import nju.software.fyrs.data.dao.RysxFlzwDAO;
import nju.software.fyrs.data.dao.RysxGwyDAO;
import nju.software.fyrs.data.dao.RysxGzxxDAO;
import nju.software.fyrs.data.dao.RysxHbgbDAO;
import nju.software.fyrs.data.dao.RysxHtDAO;
import nju.software.fyrs.data.dao.RysxJianglixxDAO;
import nju.software.fyrs.data.dao.RysxJiaoliuxxDAO;
import nju.software.fyrs.data.dao.RysxJlxxDAO;
import nju.software.fyrs.data.dao.RysxJtxxDAO;
import nju.software.fyrs.data.dao.RysxJzzwDAO;
import nju.software.fyrs.data.dao.RysxKhxxDAO;
import nju.software.fyrs.data.dao.RysxLdbzDAO;
import nju.software.fyrs.data.dao.RysxPhotoDAO;
import nju.software.fyrs.data.dao.RysxPxxxDAO;
import nju.software.fyrs.data.dao.RysxSfksDAO;
import nju.software.fyrs.data.dao.RysxShebDAO;
import nju.software.fyrs.data.dao.RysxSwxxDAO;
import nju.software.fyrs.data.dao.RysxSyyyxDAO;
import nju.software.fyrs.data.dao.RysxTablekeyDAO;
import nju.software.fyrs.data.dao.RysxTxlDAO;
import nju.software.fyrs.data.dao.RysxWyxxDAO;
import nju.software.fyrs.data.dao.RysxXiujiaDAO;
import nju.software.fyrs.data.dao.RysxXlxxDAO;
import nju.software.fyrs.data.dao.RysxXwxxDAO;
import nju.software.fyrs.data.dao.RysxXzzwDAO;
import nju.software.fyrs.data.dao.RysxZdxxDAO;
import nju.software.fyrs.data.dao.RysxZjbdDAO;
import nju.software.fyrs.data.dao.RysxZjxxDAO;
import nju.software.fyrs.data.dao.RysxZyjszwDAO;
import nju.software.fyrs.data.dao.RysxZzmmDAO;
import nju.software.fyrs.data.dataobject.Dm;
import nju.software.fyrs.data.dataobject.Jgxx;
import nju.software.fyrs.data.dataobject.Ryjbxx;
import nju.software.fyrs.data.dataobject.RykRc;
import nju.software.fyrs.data.dataobject.RysxBmbd;
import nju.software.fyrs.data.dataobject.RysxBzxx;
import nju.software.fyrs.data.dataobject.RysxCcxx;
import nju.software.fyrs.data.dataobject.RysxCgxx;
import nju.software.fyrs.data.dataobject.RysxDjxx;
import nju.software.fyrs.data.dataobject.RysxFljl;
import nju.software.fyrs.data.dataobject.RysxFlzw;
import nju.software.fyrs.data.dataobject.RysxGwy;
import nju.software.fyrs.data.dataobject.RysxGzxx;
import nju.software.fyrs.data.dataobject.RysxHbgb;
import nju.software.fyrs.data.dataobject.RysxHt;
import nju.software.fyrs.data.dataobject.RysxJianglixx;
import nju.software.fyrs.data.dataobject.RysxJiaoliuxx;
import nju.software.fyrs.data.dataobject.RysxJlxx;
import nju.software.fyrs.data.dataobject.RysxJtxx;
import nju.software.fyrs.data.dataobject.RysxJzzw;
import nju.software.fyrs.data.dataobject.RysxKhxx;
import nju.software.fyrs.data.dataobject.RysxLdbz;
import nju.software.fyrs.data.dataobject.RysxPhoto;
import nju.software.fyrs.data.dataobject.RysxPxxx;
import nju.software.fyrs.data.dataobject.RysxSfks;
import nju.software.fyrs.data.dataobject.RysxShebao;
import nju.software.fyrs.data.dataobject.RysxSwxx;
import nju.software.fyrs.data.dataobject.RysxSyyyx;
import nju.software.fyrs.data.dataobject.RysxTxl;
import nju.software.fyrs.data.dataobject.RysxWyxx;
import nju.software.fyrs.data.dataobject.RysxXiujia;
import nju.software.fyrs.data.dataobject.RysxXlxx;
import nju.software.fyrs.data.dataobject.RysxXwxx;
import nju.software.fyrs.data.dataobject.RysxXzzw;
import nju.software.fyrs.data.dataobject.RysxZdxx;
import nju.software.fyrs.data.dataobject.RysxZjbg;
import nju.software.fyrs.data.dataobject.RysxZjxx;
import nju.software.fyrs.data.dataobject.RysxZyjszw;
import nju.software.fyrs.data.dataobject.RysxZzmm;
import nju.software.fyrs.service.RyjbxxService;
import nju.software.fyrs.service.convertor.CloneConvertor;
import nju.software.fyrs.util.ConstantsFyrs;
import nju.software.fyrs.util.DateUtil;
import nju.software.fyrs.util.DmMcCommon;
import nju.software.fyrs.util.NFyRybhCodeUtils;
import nju.software.fyrs.util.ObjectByteThreadLocal;
import nju.software.fyrs.util.ObjectSerializedUtils;
import nju.software.fyrs.util.SdcxUtil;
import nju.software.fyrs.util.StringUtil;

public class RyjbxxServiceImpl implements RyjbxxService
{
	RyjbxxDAO ryjbxxDAO;
	RysxZzmmDAO rysxZzmmDAO;
	RysxXzzwDAO rysxXzzwDAO;
	RysxFlzwDAO rysxFlzwDAO;
	RysxXlxxDAO rysxXlxxDAO;
	RysxXwxxDAO rysxXwxxDAO;
	RysxJlxxDAO rysxJlxxDAO;
	RysxJtxxDAO rysxJtxxDAO;
	RysxKhxxDAO rysxKhxxDAO;
	RysxJianglixxDAO rysxJianglixxDAO;
	RysxSfksDAO rysxSfksDAO;
	RysxJiaoliuxxDAO rysxJiaoliuxxDAO;
	RysxPxxxDAO rysxPxxxDAO;
	RykRcDAO rykRcDAO;
	RysxDjxxDAO rysxDjxxDAO;
	RysxGwyDAO rysxGwyDAO;
	RysxZyjszwDAO rysxZyjszwDAO;
	RysxJzzwDAO rysxJzzwDAO;
	RysxLdbzDAO rysxLdbzDAO;
	RysxHbgbDAO rysxHbgbDAO;
	RysxGzxxDAO rysxGzxxDAO;
	RysxCcxxDAO rysxCcxxDAO;
	RysxSwxxDAO rysxSwxxDAO;
	RysxZdxxDAO rysxZdxxDAO;
	RysxCgxxDAO rysxCgxxDAO;
	RysxWyxxDAO rysxWyxxDAO;
	RysxTxlDAO rysxTxlDAO;
	RysxSyyyxDAO rysxSyyyxDAO;
	RysxBzxxDAO rysxBzxxDAO;
	RysxZjxxDAO rysxZjxxDAO;
	RysxPhotoDAO rysxPhotoDAO;
	RysxHtDAO rysxHtDAO;
	private JgxxDAO jgxxDAO;
	private RysxXiujiaDAO xiujiaDAO;
	private RysxShebDAO shebDAO;
	private RysxZjbdDAO zjbdDAO;
	private RysxBmbdDAO bmbdDAO;
	private RysxFljlDAO fljlDAO;
	public void setZjbdDAO(RysxZjbdDAO zjbdDAO) {
		this.zjbdDAO = zjbdDAO;
	}

	public void setBmbdDAO(RysxBmbdDAO bmbdDAO) {
		this.bmbdDAO = bmbdDAO;
	}

	public void setFljlDAO(RysxFljlDAO fljlDAO) {
		this.fljlDAO = fljlDAO;
	}

	private Map<String, String> mapNames = new HashMap<String, String>();
	private RysxTablekeyDAO rysxTablekeyDAO;
	private static Logger logger = Logger.getLogger(RyjbxxServiceImpl.class);
	DmDAO dmDAO;
	MaxBHDAO maxBHDAO;
	
	

	public void setShebDAO(RysxShebDAO shebDAO) {
		this.shebDAO = shebDAO;
	}

	public void setXiujiaDAO(RysxXiujiaDAO xiujiaDAO) {
		this.xiujiaDAO = xiujiaDAO;
	}

	public void setRysxHtDAO(RysxHtDAO rysxHtDAO) {
		this.rysxHtDAO = rysxHtDAO;
	}

	public void setRyjbxxDAO(RyjbxxDAO ryjbxxDAO)
	{
		this.ryjbxxDAO = ryjbxxDAO;
	}

	public void setRysxZzmmDAO(RysxZzmmDAO rysxZzmmDAO)
	{
		this.rysxZzmmDAO = rysxZzmmDAO;
	}

	public void setRysxXzzwDAO(RysxXzzwDAO rysxXzzwDAO)
	{
		this.rysxXzzwDAO = rysxXzzwDAO;
	}

	public void setDmDAO(DmDAO dmDAO)
	{
		this.dmDAO = dmDAO;
	}

	public void setMaxBHDAO(MaxBHDAO maxBHDAO)
	{
		this.maxBHDAO = maxBHDAO;
	}

	public void setRysxFlzwDAO(RysxFlzwDAO rysxFlzwDAO)
	{
		this.rysxFlzwDAO = rysxFlzwDAO;
	}

	public void setRysxXlxxDAO(RysxXlxxDAO rysxXlxxDAO)
	{
		this.rysxXlxxDAO = rysxXlxxDAO;
	}

	public void setRysxXwxxDAO(RysxXwxxDAO rysxXwxxDAO)
	{
		this.rysxXwxxDAO = rysxXwxxDAO;
	}

	public void setRysxPhotoDAO(RysxPhotoDAO rysxPhotoDAO)
	{
		this.rysxPhotoDAO = rysxPhotoDAO;
	}

	public void setRysxJlxxDAO(RysxJlxxDAO rysxJlxxDAO)
	{
		this.rysxJlxxDAO = rysxJlxxDAO;
	}

	public void setRysxJtxxDAO(RysxJtxxDAO rysxJtxxDAO)
	{
		this.rysxJtxxDAO = rysxJtxxDAO;
	}

	public void setRysxKhxxDAO(RysxKhxxDAO rysxKhxxDAO)
	{
		this.rysxKhxxDAO = rysxKhxxDAO;
	}

	public void setRysxJianglixxDAO(RysxJianglixxDAO rysxJianglixxDAO)
	{
		this.rysxJianglixxDAO = rysxJianglixxDAO;
	}

	public void setRysxSfksDAO(RysxSfksDAO rysxSfksDAO)
	{
		this.rysxSfksDAO = rysxSfksDAO;
	}

	public void setRysxJiaoliuxxDAO(RysxJiaoliuxxDAO rysxJiaoliuxxDAO)
	{
		this.rysxJiaoliuxxDAO = rysxJiaoliuxxDAO;
	}

	public void setRysxPxxxDAO(RysxPxxxDAO rysxPxxxDAO)
	{
		this.rysxPxxxDAO = rysxPxxxDAO;
	}

	public void setRykRcDAO(RykRcDAO rykRcDAO)
	{
		this.rykRcDAO = rykRcDAO;
	}

	public void setRysxDjxxDAO(RysxDjxxDAO rysxDjxxDAO)
	{
		this.rysxDjxxDAO = rysxDjxxDAO;
	}

	public void setRysxGwyDAO(RysxGwyDAO rysxGwyDAO)
	{
		this.rysxGwyDAO = rysxGwyDAO;
	}

	public void setRysxZyjszwDAO(RysxZyjszwDAO rysxZyjszwDAO)
	{
		this.rysxZyjszwDAO = rysxZyjszwDAO;
	}

	public void setRysxJzzwDAO(RysxJzzwDAO rysxJzzwDAO)
	{
		this.rysxJzzwDAO = rysxJzzwDAO;
	}

	public void setRysxLdbzDAO(RysxLdbzDAO rysxLdbzDAO)
	{
		this.rysxLdbzDAO = rysxLdbzDAO;
	}

	public void setRysxHbgbDAO(RysxHbgbDAO rysxHbgbDAO)
	{
		this.rysxHbgbDAO = rysxHbgbDAO;
	}

	public void setRysxGzxxDAO(RysxGzxxDAO rysxGzxxDAO)
	{
		this.rysxGzxxDAO = rysxGzxxDAO;
	}

	public void setRysxCcxxDAO(RysxCcxxDAO rysxCcxxDAO)
	{
		this.rysxCcxxDAO = rysxCcxxDAO;
	}

	public void setRysxSwxxDAO(RysxSwxxDAO rysxSwxxDAO)
	{
		this.rysxSwxxDAO = rysxSwxxDAO;
	}

	public void setRysxZdxxDAO(RysxZdxxDAO rysxZdxxDAO)
	{
		this.rysxZdxxDAO = rysxZdxxDAO;
	}

	public void setRysxCgxxDAO(RysxCgxxDAO rysxCgxxDAO)
	{
		this.rysxCgxxDAO = rysxCgxxDAO;
	}

	public void setRysxWyxxDAO(RysxWyxxDAO rysxWyxxDAO)
	{
		this.rysxWyxxDAO = rysxWyxxDAO;
	}

	public void setRysxTxlDAO(RysxTxlDAO rysxTxlDAO)
	{
		this.rysxTxlDAO = rysxTxlDAO;
	}

	public void setRysxSyyyxDAO(RysxSyyyxDAO rysxSyyyxDAO)
	{
		this.rysxSyyyxDAO = rysxSyyyxDAO;
	}

	public void setRysxBzxxDAO(RysxBzxxDAO rysxBzxxDAO)
	{
		this.rysxBzxxDAO = rysxBzxxDAO;
	}

	public void setRysxTablekeyDAO(RysxTablekeyDAO rysxTablekeyDAO)
	{
		this.rysxTablekeyDAO = rysxTablekeyDAO;
	}

	public void setRysxZjxxDAO(RysxZjxxDAO rysxZjxxDAO)
	{
		this.rysxZjxxDAO = rysxZjxxDAO;
	}
    
	
	public void setJgxxDAO(JgxxDAO jgxxDAO)
	{
		this.jgxxDAO = jgxxDAO;
	}

	@Override
	public int getMaxBhByRybh(String name, String rybh)
	{
		return maxBHDAO.getMaxBhByRybh(name, rybh);
	}

	@Override
	public List<Ryjbxx> listByFyDmBmDm(int fyDm, int BmDm)
	{
		return ryjbxxDAO.listByFyDmBmDm(fyDm, BmDm);
	}

	@Override
	public List<Ryjbxx> listByFyDm(int fyDm)
	{
		return ryjbxxDAO.listByFyDm(fyDm);
	}

	@Override
	public Ryjbxx getRyjbxxByRybhFyDm(int rybh, int fyDm)
	{
		return ryjbxxDAO.getRyjbxxByRybhFyDm(rybh, fyDm);
	}

	@SuppressWarnings("deprecation")
	public RyjbxxVO getJbxxVOByRybhFy(int rybh, int fydm)
	{

		List<Ryjbxx> list = ryjbxxDAO.getJbxxVOByRybhFy(rybh, fydm);
		if (list.size() == 0)
		{
			return null;
		}
		Ryjbxx ryjbxx = list.get(0);
		RyjbxxVO ryjbxxVO = new RyjbxxVO();
		ryjbxxVO.setNRybh(rybh);
		if (ryjbxx.getCRybh() != " ")
		{
			ryjbxxVO.setCRybh(ryjbxx.getCRybh());
		}
		if (ryjbxx.getCCym() != " ")
		{
			ryjbxxVO.setCCym(ryjbxx.getCCym());
		}
		if (ryjbxx.getCSfzh() != " ")
		{
			ryjbxxVO.setCSfzh(ryjbxx.getCSfzh());
		}
		if (ryjbxx.getNBm() != null)
		{
			Jgxx jgxx = jgxxDAO.bmByFyIdAndNcode(ryjbxx.getNFy(),ryjbxx.getNBm());
			if(null !=jgxx.getNBmxz()){
		    		String bmxz = dmDAO.findDmByNBxhNdm(ConstantsFyrs.BMXZ+"", jgxx.getNBmxz()).getCMc();
		    		ryjbxxVO.setBmxz(bmxz);
		     }
			ryjbxxVO.setNBm(jgxx.getCName());
			
		}
		if (ryjbxx.getCXm() != " ")
		{
			ryjbxxVO.setCXm(ryjbxx.getCXm());
		}
		if (ryjbxx.getCCym() != " ")
		{
			ryjbxxVO.setCCym(ryjbxx.getCCym());
		}
		if (ryjbxx.getNXb() != null)
		{
			ryjbxxVO.setNXb(dmDAO.getDmByMc(ryjbxx.getNXb(), "性别"));
		}
		if (ryjbxx.getNMz() != null)
		{
			ryjbxxVO.setNMz(dmDAO.getDmByMc(ryjbxx.getNMz(), "民族"));
		}
		if (ryjbxx.getNHyzk() != null)
		{
			ryjbxxVO.setNHyzk(dmDAO.getDmByMc(ryjbxx.getNHyzk(), "婚姻状况"));
		}
		if (ryjbxx.getNJkzk() != null)
		{
			ryjbxxVO.setNJkzk(dmDAO.getDmByMc(ryjbxx.getNJkzk(), "健康状况"));
		}
		if (ryjbxx.getDCsrq() != null)
		{
			ryjbxxVO.setDCsrq(DateUtil.format(ryjbxx.getDCsrq(),
					DateUtil.webFormat).toString());
			ryjbxxVO.setNNl(DateUtil.today().getYear()
					- ryjbxx.getDCsrq().getYear());
		}
		if (ryjbxx.getCJg() != " ")
		{
			ryjbxxVO.setCJg(ryjbxx.getCJg());
		}
		if (ryjbxx.getCCsd() != " ")
		{
			ryjbxxVO.setCCsd(ryjbxx.getCCsd());
		}
		if (ryjbxx.getNZwlb() != null)
		{
			ryjbxxVO.setNZwlb(dmDAO.getDmByMc(ryjbxx.getNZwlb(), "职务类别"));
		}
		if (ryjbxx.getDZwlbsj() != null)
		{
			ryjbxxVO.setDZwlbsj(DateUtil.format(ryjbxx.getDZwlbsj(),
					DateUtil.webFormat).toString());
		}
		if (ryjbxx.getDFgzgrq() != null)
		{
			ryjbxxVO.setDFgzgrq(DateUtil.format(ryjbxx.getDFgzgrq(),
					DateUtil.webFormat).toString());
		}
		if (ryjbxx.getNZzmm() != null)
		{
			ryjbxxVO.setNZzmm(dmDAO.getDmByMc(ryjbxx.getNZzmm(), "政治面貌"));
		}
		if (ryjbxx.getDZzmm() != null)
		{
			ryjbxxVO.setDZzmm(DateUtil.format(ryjbxx.getDZzmm(),
					DateUtil.webFormat).toString());
		}
		if (ryjbxx.getDDzzwrq() != null)
		{
			ryjbxxVO.setDDzzwrq(DateUtil.format(ryjbxx.getDDzzwrq(),
					DateUtil.webFormat).toString());
		}
		if (ryjbxx.getNFlzw() != null)
		{
			ryjbxxVO.setNFlzw(dmDAO.getDmByMc(ryjbxx.getNFlzw(), "法律职务"));
		}
		if (ryjbxx.getDFlzwRzrq() != null)
		{
			ryjbxxVO.setDFlzwRzrq(DateUtil.format(ryjbxx.getDFlzwRzrq(),
					DateUtil.webFormat).toString());
		}
		if (ryjbxx.getNJrtz() != null)
		{
			ryjbxxVO.setNJrtz(dmDAO.getDmByMc(ryjbxx.getNJrtz(), "是否"));
		}
		if (ryjbxx.getNDzzw() != null)
		{
			ryjbxxVO.setNDzzw(dmDAO.getDmByMc(ryjbxx.getNDzzw(), "党组职务"));
		}
		if (ryjbxx.getNXzzw() != null)
		{
			ryjbxxVO.setNXzzw(dmDAO.getDmByMc(ryjbxx.getNXzzw(), "行政职务"));
		}
		if (ryjbxx.getDXzzwRzrq() != null)
		{
			ryjbxxVO.setDXzzwRzrq(DateUtil.format(ryjbxx.getDXzzwRzrq(),
					DateUtil.webFormat).toString());
		}
		if (ryjbxx.getNBz() != null)
		{
			ryjbxxVO.setNBz(dmDAO.getDmByMc(ryjbxx.getNBz(), "编制"));
		}
		if (ryjbxx.getNZj() != null)
		{
			ryjbxxVO.setNZj(dmDAO.getDmByMc(ryjbxx.getNZj(), "职级"));
		}
		if (ryjbxx.getDZjrq() != null)
		{
			ryjbxxVO.setDZjrq(DateUtil.format(ryjbxx.getDZjrq(),
					DateUtil.webFormat).toString());
		}
		if (ryjbxx.getNDj() != null)
		{
			ryjbxxVO.setNDj(dmDAO.getDmByMc(ryjbxx.getNDj(), "等级"));
		}
		if (ryjbxx.getDDjrq() != null)
		{
			ryjbxxVO.setDDjrq(DateUtil.format(ryjbxx.getDDjrq(),
					DateUtil.webFormat).toString());
		}
		if (ryjbxx.getNGwyjb() != null)
		{
			ryjbxxVO.setNGwyjb(dmDAO.getDmByMc(ryjbxx.getNGwyjb(), "公务员级别"));
		}
		if (ryjbxx.getDGwyrq() != null)
		{
			ryjbxxVO.setDGwyrq(DateUtil.format(ryjbxx.getDGwyrq(),
					DateUtil.webFormat).toString());
		}
		if (ryjbxx.getNXl() != null)
		{
			ryjbxxVO.setNXl(dmDAO.getDmByMc(ryjbxx.getNXl(), "文化程度"));
		}
		if (ryjbxx.getNXw() != null)
		{
			ryjbxxVO.setNXw(dmDAO.getDmByMc(ryjbxx.getNXw(), "学位"));
		}
		if (ryjbxx.getDHdxwrq() != null)
		{
			ryjbxxVO.setDHdxwrq(DateUtil.format(ryjbxx.getDHdxwrq(),
					DateUtil.webFormat).toString());
		}
		if (ryjbxx.getNZy() != null)
		{
			ryjbxxVO.setNZy(dmDAO.getDmByMc(ryjbxx.getNZy(), "专业"));
		}
		if (ryjbxx.getNZyzs() != null)
		{
			ryjbxxVO.setNZyzs(dmDAO.getDmByMc(ryjbxx.getNZyzs(), "专业证书"));
		}
		if (ryjbxx.getDHdzsrq() != null)
		{
			ryjbxxVO.setDHdzsrq(DateUtil.format(ryjbxx.getDHdzsrq(),
					DateUtil.webFormat).toString());
		}
		if (ryjbxx.getDQdfgzgzs() != null)
		{
			ryjbxxVO.setDQdfgzgzs(DateUtil.format(ryjbxx.getDQdfgzgzs(),
					DateUtil.webFormat).toString());
		}
		if (ryjbxx.getNQdfgzgzs() != null)
		{
			ryjbxxVO.setNQdfgzgzs(dmDAO.getDmByMc(ryjbxx.getNQdfgzgzs(),
					"法官资格证书"));
		}
		if (ryjbxx.getDGzrq() != null)
		{
			ryjbxxVO.setDGzrq(DateUtil.format(ryjbxx.getDGzrq(),
					DateUtil.webFormat).toString());
			// 连续工龄
			int lxgl = DateUtil.today().getYear() - ryjbxx.getDGzrq().getYear();
			ryjbxxVO.setLxgl(lxgl);
		}
		if (ryjbxx.getDZfgzrq() != null)
		{
			ryjbxxVO.setDZfgzrq(DateUtil.format(ryjbxx.getDZfgzrq(),
					DateUtil.webFormat).toString());
			// 法院工作合计年限
			int fygzhjnx = DateUtil.today().getYear()
					- ryjbxx.getDZfgzrq().getYear();
			ryjbxxVO.setFygzhjnx(fygzhjnx);
		}
		if (ryjbxx.getDJyrq() != null)
		{
			ryjbxxVO.setDJyrq(DateUtil.format(ryjbxx.getDJyrq(),
					DateUtil.webFormat).toString());
		}
		if (ryjbxx.getNBcgl() != null)
		{
			ryjbxxVO.setNBcgl(ryjbxx.getNBcgl().toString());
		}
		if (ryjbxx.getNKjgl() != null)
		{
			ryjbxxVO.setNKjgl(ryjbxx.getNKjgl().toString());
		}
		if (ryjbxx.getNJyqfynx() != null)
		{
			ryjbxxVO.setNJyqfynx(ryjbxx.getNJyqfynx().toString());
		}
		if (ryjbxx.getNYjxz() != null)
		{
			ryjbxxVO.setNYjxz(ryjbxx.getNYjxz().toString());
		}
		if (ryjbxx.getNJtj() != null)
		{
			ryjbxxVO.setNJtj(dmDAO.getDmByMc(ryjbxx.getNJtj(), "进入途径"));
		}
		if (ryjbxx.getNJly() != null)
		{
			ryjbxxVO.setNJly(dmDAO.getDmByMc(ryjbxx.getNJly(), "进入来源"));
		}
		if (ryjbxx.getDShrq() != null)
		{
			ryjbxxVO.setDShrq(DateUtil.format(ryjbxx.getDShrq(),
					DateUtil.webFormat).toString());
		}
		if (ryjbxx.getNYzw() != null)
		{
			ryjbxxVO.setNYzw(dmDAO.getDmByMc(ryjbxx.getNYzw(), "职务"));
		}
		if (ryjbxx.getNYzj() != null)
		{
			ryjbxxVO.setNYzj(dmDAO.getDmByMc(ryjbxx.getNYzj(), "职级"));
		}
		if (ryjbxx.getCYdw() != " ")
		{
			ryjbxxVO.setCYdw(ryjbxx.getCYdw());
		}
		if (ryjbxx.getNCyy() != null)
		{
			ryjbxxVO.setNCyy(dmDAO.getDmByMc(ryjbxx.getNCyy(), "调离原因")); //
		}
		if (ryjbxx.getDCrq() != null)
		{
			ryjbxxVO.setDCrq(DateUtil.format(ryjbxx.getDCrq(),
					DateUtil.webFormat).toString());
		}
		if (ryjbxx.getNQx() != null)
		{
			ryjbxxVO.setNQx(dmDAO.getDmByMc(ryjbxx.getNQx(), "调离去向"));
		}
		ryjbxxVO.setCSfzh(ryjbxx.getCSfzh());
		return ryjbxxVO;
	}
	
	@SuppressWarnings("deprecation")
	@Override
	public RyjbxxVO getRyjbxxVOByXmFy(String fydm,String xm){
		
		List<Ryjbxx> list = ryjbxxDAO.getRyjbxxVOByXmFy(fydm,xm);
		if (list.size() == 0)
		{
			return null;
		}
		Ryjbxx ryjbxx = list.get(0);
		RyjbxxVO ryjbxxVO = new RyjbxxVO();
		ryjbxxVO.setNRybh(ryjbxx.getNRybh());
		if (ryjbxx.getCRybh() != " ")
		{
			ryjbxxVO.setCRybh(ryjbxx.getCRybh());
		}
		if (ryjbxx.getCCym() != " ")
		{
			ryjbxxVO.setCCym(ryjbxx.getCCym());
		}
		if (ryjbxx.getCSfzh() != " ")
		{
			ryjbxxVO.setCSfzh(ryjbxx.getCSfzh());
		}
		if (ryjbxx.getNBm() != null)
		{
			ryjbxxVO.setNBm(dmDAO.getDmByMc(ryjbxx.getNBm(), "内设机构"));
		}
		if (ryjbxx.getCXm() != " ")
		{
			ryjbxxVO.setCXm(ryjbxx.getCXm());
		}
		if (ryjbxx.getCCym() != " ")
		{
			ryjbxxVO.setCCym(ryjbxx.getCCym());
		}
		if (ryjbxx.getNXb() != null)
		{
			ryjbxxVO.setNXb(dmDAO.getDmByMc(ryjbxx.getNXb(), "性别"));
		}
		if (ryjbxx.getNMz() != null)
		{
			ryjbxxVO.setNMz(dmDAO.getDmByMc(ryjbxx.getNMz(), "民族"));
		}
		if (ryjbxx.getNHyzk() != null)
		{
			ryjbxxVO.setNHyzk(dmDAO.getDmByMc(ryjbxx.getNHyzk(), "婚姻状况"));
		}
		if (ryjbxx.getNJkzk() != null)
		{
			ryjbxxVO.setNJkzk(dmDAO.getDmByMc(ryjbxx.getNJkzk(), "健康状况"));
		}
		if (ryjbxx.getDCsrq() != null)
		{
			ryjbxxVO.setDCsrq(DateUtil.format(ryjbxx.getDCsrq(),
					DateUtil.webFormat).toString());
			ryjbxxVO.setNNl(DateUtil.today().getYear()
					- ryjbxx.getDCsrq().getYear());
		}
		if (ryjbxx.getCJg() != " ")
		{
			ryjbxxVO.setCJg(ryjbxx.getCJg());
		}
		if (ryjbxx.getCCsd() != " ")
		{
			ryjbxxVO.setCCsd(ryjbxx.getCCsd());
		}
		if (ryjbxx.getNZwlb() != null)
		{
			ryjbxxVO.setNZwlb(dmDAO.getDmByMc(ryjbxx.getNZwlb(), "职务类别"));
		}
		if (ryjbxx.getDZwlbsj() != null)
		{
			ryjbxxVO.setDZwlbsj(DateUtil.format(ryjbxx.getDZwlbsj(),
					DateUtil.webFormat).toString());
		}
		if (ryjbxx.getDFgzgrq() != null)
		{
			ryjbxxVO.setDFgzgrq(DateUtil.format(ryjbxx.getDFgzgrq(),
					DateUtil.webFormat).toString());
		}
		if (ryjbxx.getNZzmm() != null)
		{
			ryjbxxVO.setNZzmm(dmDAO.getDmByMc(ryjbxx.getNZzmm(), "政治面貌"));
		}
		if (ryjbxx.getDZzmm() != null)
		{
			ryjbxxVO.setDZzmm(DateUtil.format(ryjbxx.getDZzmm(),
					DateUtil.webFormat).toString());
		}
		if (ryjbxx.getDDzzwrq() != null)
		{
			ryjbxxVO.setDDzzwrq(DateUtil.format(ryjbxx.getDDzzwrq(),
					DateUtil.webFormat).toString());
		}
		if (ryjbxx.getNFlzw() != null)
		{
			ryjbxxVO.setNFlzw(dmDAO.getDmByMc(ryjbxx.getNFlzw(), "法律职务"));
		}
		if (ryjbxx.getDFlzwRzrq() != null)
		{
			ryjbxxVO.setDFlzwRzrq(DateUtil.format(ryjbxx.getDFlzwRzrq(),
					DateUtil.webFormat).toString());
		}
		if (ryjbxx.getNJrtz() != null)
		{
			ryjbxxVO.setNJrtz(dmDAO.getDmByMc(ryjbxx.getNJrtz(), "是否"));
		}
		if (ryjbxx.getNDzzw() != null)
		{
			ryjbxxVO.setNDzzw(dmDAO.getDmByMc(ryjbxx.getNDzzw(), "党组职务"));
		}
		if (ryjbxx.getNXzzw() != null)
		{
			ryjbxxVO.setNXzzw(dmDAO.getDmByMc(ryjbxx.getNXzzw(), "行政职务"));
		}
		if (ryjbxx.getDXzzwRzrq() != null)
		{
			ryjbxxVO.setDXzzwRzrq(DateUtil.format(ryjbxx.getDXzzwRzrq(),
					DateUtil.webFormat).toString());
		}
		if (ryjbxx.getNBz() != null)
		{
			ryjbxxVO.setNBz(dmDAO.getDmByMc(ryjbxx.getNBz(), "编制"));
		}
		if (ryjbxx.getNZj() != null)
		{
			ryjbxxVO.setNZj(dmDAO.getDmByMc(ryjbxx.getNZj(), "职级"));
		}
		if (ryjbxx.getDZjrq() != null)
		{
			ryjbxxVO.setDZjrq(DateUtil.format(ryjbxx.getDZjrq(),
					DateUtil.webFormat).toString());
		}
		if (ryjbxx.getNDj() != null)
		{
			ryjbxxVO.setNDj(dmDAO.getDmByMc(ryjbxx.getNDj(), "等级"));
		}
		if (ryjbxx.getDDjrq() != null)
		{
			ryjbxxVO.setDDjrq(DateUtil.format(ryjbxx.getDDjrq(),
					DateUtil.webFormat).toString());
		}
		if (ryjbxx.getNGwyjb() != null)
		{
			ryjbxxVO.setNGwyjb(dmDAO.getDmByMc(ryjbxx.getNGwyjb(), "公务员级别"));
		}
		if (ryjbxx.getDGwyrq() != null)
		{
			ryjbxxVO.setDGwyrq(DateUtil.format(ryjbxx.getDGwyrq(),
					DateUtil.webFormat).toString());
		}
		if (ryjbxx.getNXl() != null)
		{
			ryjbxxVO.setNXl(dmDAO.getDmByMc(ryjbxx.getNXl(), "文化程度"));
		}
		if (ryjbxx.getNXw() != null)
		{
			ryjbxxVO.setNXw(dmDAO.getDmByMc(ryjbxx.getNXw(), "学位"));
		}
		if (ryjbxx.getDHdxwrq() != null)
		{
			ryjbxxVO.setDHdxwrq(DateUtil.format(ryjbxx.getDHdxwrq(),
					DateUtil.webFormat).toString());
		}
		if (ryjbxx.getNZy() != null)
		{
			ryjbxxVO.setNZy(dmDAO.getDmByMc(ryjbxx.getNZy(), "专业"));
		}
		if (ryjbxx.getNZyzs() != null)
		{
			ryjbxxVO.setNZyzs(dmDAO.getDmByMc(ryjbxx.getNZyzs(), "专业证书"));
		}
		if (ryjbxx.getDHdzsrq() != null)
		{
			ryjbxxVO.setDHdzsrq(DateUtil.format(ryjbxx.getDHdzsrq(),
					DateUtil.webFormat).toString());
		}
		if (ryjbxx.getDQdfgzgzs() != null)
		{
			ryjbxxVO.setDQdfgzgzs(DateUtil.format(ryjbxx.getDQdfgzgzs(),
					DateUtil.webFormat).toString());
		}
		if (ryjbxx.getNQdfgzgzs() != null)
		{
			ryjbxxVO.setNQdfgzgzs(dmDAO.getDmByMc(ryjbxx.getNQdfgzgzs(),
					"法官资格证书"));
		}
		if (ryjbxx.getDGzrq() != null)
		{
			ryjbxxVO.setDGzrq(DateUtil.format(ryjbxx.getDGzrq(),
					DateUtil.webFormat).toString());
			// 连续工龄
			int lxgl = DateUtil.today().getYear() - ryjbxx.getDGzrq().getYear();
			ryjbxxVO.setLxgl(lxgl);
		}
		if (ryjbxx.getDZfgzrq() != null)
		{
			ryjbxxVO.setDZfgzrq(DateUtil.format(ryjbxx.getDZfgzrq(),
					DateUtil.webFormat).toString());
			// 法院工作合计年限
			int fygzhjnx = DateUtil.today().getYear()
					- ryjbxx.getDZfgzrq().getYear();
			ryjbxxVO.setFygzhjnx(fygzhjnx);
		}
		if (ryjbxx.getDJyrq() != null)
		{
			ryjbxxVO.setDJyrq(DateUtil.format(ryjbxx.getDJyrq(),
					DateUtil.webFormat).toString());
		}
		if (ryjbxx.getNBcgl() != null)
		{
			ryjbxxVO.setNBcgl(ryjbxx.getNBcgl().toString());
		}
		if (ryjbxx.getNKjgl() != null)
		{
			ryjbxxVO.setNKjgl(ryjbxx.getNKjgl().toString());
		}
		if (ryjbxx.getNJyqfynx() != null)
		{
			ryjbxxVO.setNJyqfynx(ryjbxx.getNJyqfynx().toString());
		}
		if (ryjbxx.getNYjxz() != null)
		{
			ryjbxxVO.setNYjxz(ryjbxx.getNYjxz().toString());
		}
		if (ryjbxx.getNJtj() != null)
		{
			ryjbxxVO.setNJtj(dmDAO.getDmByMc(ryjbxx.getNJtj(), "进入途径"));
		}
		if (ryjbxx.getNJly() != null)
		{
			ryjbxxVO.setNJly(dmDAO.getDmByMc(ryjbxx.getNJly(), "进入来源"));
		}
		if (ryjbxx.getDShrq() != null)
		{
			ryjbxxVO.setDShrq(DateUtil.format(ryjbxx.getDShrq(),
					DateUtil.webFormat).toString());
		}
		if (ryjbxx.getNYzw() != null)
		{
			ryjbxxVO.setNYzw(dmDAO.getDmByMc(ryjbxx.getNYzw(), "职务"));
		}
		if (ryjbxx.getNYzj() != null)
		{
			ryjbxxVO.setNYzj(dmDAO.getDmByMc(ryjbxx.getNYzj(), "职级"));
		}
		if (ryjbxx.getCYdw() != " ")
		{
			ryjbxxVO.setCYdw(ryjbxx.getCYdw());
		}
		if (ryjbxx.getNCyy() != null)
		{
			ryjbxxVO.setNCyy(dmDAO.getDmByMc(ryjbxx.getNCyy(), "调离原因")); //
		}
		if (ryjbxx.getDCrq() != null)
		{
			ryjbxxVO.setDCrq(DateUtil.format(ryjbxx.getDCrq(),
					DateUtil.webFormat).toString());
		}
		if (ryjbxx.getNQx() != null)
		{
			ryjbxxVO.setNQx(dmDAO.getDmByMc(ryjbxx.getNQx(), "调离去向"));
		}
		ryjbxxVO.setCSfzh(ryjbxx.getCSfzh());
		return ryjbxxVO;
	}
	
	@Override
	public void updateRyjbxx(RyjbxxVO vo, int rybh, int fydm)
	{
		List<Ryjbxx> list = ryjbxxDAO.getJbxxVOByRybhFy(rybh, fydm);
		Ryjbxx ryjbxx;
		Jgxx oldJgxx = null;
		Boolean updateFlag = true;
		if (list == null || list.isEmpty())
		{
			updateFlag = false;
			ryjbxx = new Ryjbxx();
			ryjbxx.setNRybh(rybh);
			ryjbxx.setNFy(fydm);
			ryjbxx.setNXssx(ryjbxxDAO.getMaxXssxByFydm(fydm));
		} else
		{
			ryjbxx = list.get(0);
			oldJgxx = jgxxDAO.bmByFyIdAndNcode(ryjbxx.getNFy(),ryjbxx.getNBm());
			if(null == oldJgxx)
			{
				oldJgxx = jgxxDAO.bmByFyIdAndNcode(ryjbxx.getNFy(), ryjbxx.getNUnicode());
			}
			/**
			 * 只有更新的对象才需要保存
			 */
			try
			{
				ObjectByteThreadLocal.setObjectByte(ObjectSerializedUtils
						.writeObjectToMemory(ryjbxx));
			} catch (Exception ex)
			{
				ex.printStackTrace();
			}
		}
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		ryjbxx.setNBm(Integer.parseInt(vo.getNBm()));
		ryjbxx.setCXm(vo.getCXm());
		ryjbxx.setCCym(vo.getCCym());
		ryjbxx.setNXb(Integer.parseInt(vo.getNXb()));
		ryjbxx.setNMz(Integer.parseInt(vo.getNMz()));
		ryjbxx.setNHyzk(Integer.parseInt(vo.getNHyzk()));
		ryjbxx.setNJkzk(Integer.parseInt(vo.getNJkzk()));
		ryjbxx.setCJg(vo.getCJg());
		ryjbxx.setCCsd(vo.getCCsd());
		ryjbxx.setCSfzh(vo.getCSfzh());
		if (StringUtil.isNotBlank(vo.getNZwlb()))
		{
			ryjbxx.setNZwlb(Integer.parseInt(vo.getNZwlb()));
		} else
		{
			ryjbxx.setNZwlb(null);
		}
		if (StringUtil.isNotBlank(vo.getNDzzw()))
		{
			ryjbxx.setNDzzw(Integer.parseInt(vo.getNDzzw()));
		}
		if (StringUtil.isNotBlank(vo.getNBz()))
		{
			ryjbxx.setNBz(Integer.parseInt(vo.getNBz()));
		}
		if (StringUtil.isNotBlank(vo.getNZyzs()))
		{
			ryjbxx.setNZyzs(Integer.parseInt(vo.getNZyzs()));
		}
		if (StringUtil.isNotBlank(vo.getNQdfgzgzs()))
		{
			ryjbxx.setNQdfgzgzs(Integer.parseInt(vo.getNQdfgzgzs()));
		}
		if (StringUtil.isNotBlank(vo.getNBcgl()))
		{
			ryjbxx.setNBcgl(Short.parseShort(vo.getNBcgl()));
		}
		if (StringUtil.isNotBlank(vo.getNKjgl()))
		{
			ryjbxx.setNKjgl(Short.parseShort(vo.getNKjgl()));
		}
		if (StringUtil.isNotBlank(vo.getNJyqfynx()))
		{
			ryjbxx.setNJyqfynx(Short.parseShort(vo.getNJyqfynx()));
		}
		if (StringUtil.isNotBlank(vo.getNYjxz()))
		{
			ryjbxx.setNYjxz(Short.parseShort(vo.getNYjxz()));
		}
		if (StringUtil.isNotBlank(vo.getNJtj()))
		{
			ryjbxx.setNJtj(Integer.parseInt(vo.getNJtj()));
		}
		if (StringUtil.isNotBlank(vo.getNJly()))
		{
			ryjbxx.setNJly(Integer.parseInt(vo.getNJly()));
		}
		if (StringUtil.isNotBlank(vo.getNYzw()))
		{
			ryjbxx.setNYzw(Integer.parseInt(vo.getNYzw()));
		}
		if (StringUtil.isNotBlank(vo.getNYzj()))
		{
			ryjbxx.setNYzj(Integer.parseInt(vo.getNYzj()));
		}
		ryjbxx.setCYdw(vo.getCYdw());

		if (StringUtil.isBlank(vo.getNCyy()))
		{
			ryjbxx.setNBiaozhi(1);
		} else
		{
			ryjbxx.setNBiaozhi(0);
		}

		if (StringUtil.isNotBlank(vo.getNCyy()))
		{
			ryjbxx.setNCyy(Integer.parseInt(vo.getNCyy()));
		} else
		{
			ryjbxx.setNCyy(null);
		}
		if (StringUtil.isNotBlank(vo.getNQx()))
		{
			ryjbxx.setNQx(Integer.parseInt(vo.getNQx()));
		} else
		{
			ryjbxx.setNQx(null);
		}
		try
		{
			ryjbxx.setDCsrq(sdf.parse(vo.getDCsrq()));
			if (StringUtil.isNotBlank(vo.getDZwlbsj()))
			{
				ryjbxx.setDZwlbsj(sdf.parse(vo.getDZwlbsj()));
			}
			if (StringUtil.isNotBlank(vo.getDFgzgrq()))
			{
				ryjbxx.setDFgzgrq(sdf.parse(vo.getDFgzgrq()));
			}
			if (StringUtil.isNotBlank(vo.getDDzzwrq()))
			{
				ryjbxx.setDDzzwrq(sdf.parse(vo.getDDzzwrq()));
			}
			if (StringUtil.isNotBlank(vo.getDHdzsrq()))
			{
				ryjbxx.setDHdzsrq(sdf.parse(vo.getDHdzsrq()));
			}
			if (StringUtil.isNotBlank(vo.getDQdfgzgzs()))
			{
				ryjbxx.setDQdfgzgzs(sdf.parse(vo.getDQdfgzgzs()));
			}
			if (StringUtil.isNotBlank(vo.getDGzrq()))
			{
				ryjbxx.setDGzrq(sdf.parse(vo.getDGzrq()));
			}
			if (StringUtil.isNotBlank(vo.getDZfgzrq()))
			{
				ryjbxx.setDZfgzrq(sdf.parse(vo.getDZfgzrq()));
			}
			if (StringUtil.isNotBlank(vo.getDJyrq()))
			{
				ryjbxx.setDJyrq(sdf.parse(vo.getDJyrq()));
			}
			if (StringUtil.isNotBlank(vo.getDShrq()))
			{
				ryjbxx.setDShrq(sdf.parse(vo.getDShrq()));
			}
			if (StringUtil.isNotBlank(vo.getDCrq()))
			{
				ryjbxx.setDCrq(sdf.parse(vo.getDCrq()));
			} else
			{
				ryjbxx.setDCrq(null);
			}
		} catch (ParseException e)
		{
			e.printStackTrace();
		}
		if (updateFlag)
		{
			/**
			 * 考虑兼容性,bm 可能是 unicode 或是  ncode，相同表示还在同一个部门,不同时，旧部门减少，新部门加一
			 */
			if(!(oldJgxx.getNCode() == ryjbxx.getNBm() || oldJgxx.getNUnicode() == ryjbxx.getNBm()))
			{
				oldJgxx.setNRysl(oldJgxx.getNRysl() - 1);
				Jgxx newJgxx = jgxxDAO.bmByFyIdAndNcode(ryjbxx.getNFy(),ryjbxx.getNBm());
				if(null == newJgxx)
				{
					newJgxx = jgxxDAO.bmByFyIdAndNcode(ryjbxx.getNFy(), ryjbxx.getNUnicode());
				}
				if(null == newJgxx.getNRysl())
				{
					newJgxx.setNRysl(1);
				}
				else
				{
					newJgxx.setNRysl(newJgxx.getNRysl()+1);
				}
				jgxxDAO.updateJgxx(oldJgxx);
				jgxxDAO.updateJgxx(newJgxx);
				
			}
			ryjbxxDAO.interceptUpdateRyjbxx(ryjbxx);
		} else
		{
			//  添加必须拦截
			// 添加一个人必须在机构加一
			Jgxx  jgxx = jgxxDAO.bmByFyIdAndNcode(ryjbxx.getNFy(),ryjbxx.getNBm());
			if(jgxx.getNRysl() == null)
			{
			   jgxx.setNRysl(1);
			}
			else
			{
				jgxx.setNRysl(jgxx.getNRysl()+1);
			}	
			jgxxDAO.save(jgxx);
			ryjbxxDAO.interceptAddRyjbxx(ryjbxx);
		}
	}

	@Transactional
	@Override
	public boolean deleteRyjbxx(int rybh, int fydm) {
		Ryjbxx ry = ryjbxxDAO.getRyjbxxByRybhFyDm(rybh, fydm);
		if (ry != null) {
			ryjbxxDAO.interceptDeleteRyjbxx(ry);

			List<RysxBzxx> bzxxList = rysxBzxxDAO.getBzxxByRybhFy(rybh, fydm);
			for (RysxBzxx bzxx : bzxxList) {

				rysxBzxxDAO.interceptDeleteRsBzxxById(bzxx);
			}
			List<RysxCcxx> ccxxList = rysxCcxxDAO.getCcxxByRybhFy(rybh, fydm);
			for (RysxCcxx ccxx : ccxxList) {

				rysxCcxxDAO.interceptDeleteRsCcxxById(ccxx);
			}
			List<RysxCgxx> cgxxList = rysxCgxxDAO.getCgxxByRybhFy(rybh, fydm);
			for (RysxCgxx cgxx : cgxxList) {

				rysxCgxxDAO.interceptDeleteRsCgxxById(cgxx);
			}
			List<RysxDjxx> djxxList = rysxDjxxDAO.getDjxxByRybhFy(rybh, fydm);
			for (RysxDjxx djxx : djxxList) {

				rysxDjxxDAO.interceptDeleteRsDjxxById(djxx);
			}
			List<RysxFlzw> flzwList = rysxFlzwDAO.getFlzwByRybhFy(rybh, fydm);
			for (RysxFlzw flzw : flzwList) {

				rysxFlzwDAO.interceptAddFlzw(flzw);
			}
			List<RysxGwy> gwyList = rysxGwyDAO.getGwyjbByRybhFy(rybh, fydm);
			for (RysxGwy gwy : gwyList) {

				rysxGwyDAO.interceptDeleteRsGwyById(gwy);
			}
			List<RysxGzxx> gzxxList = rysxGzxxDAO.getGzxxByRybhFy(rybh, fydm);
			for (RysxGzxx gzxx : gzxxList) {

				rysxGzxxDAO.interceptDeleteRsGzxxById(gzxx);
			}
			List<RysxHbgb> hbgbList = rysxHbgbDAO.getHbgbByRybhFy(rybh, fydm);
			for (RysxHbgb hbgb : hbgbList) {

				rysxHbgbDAO.interceptDeleteRsHbgbById(hbgb);
			}
			List<RysxJianglixx> jianglixxList = rysxJianglixxDAO
					.getJlixxByRybhFy(rybh, fydm);
			for (RysxJianglixx jianglixx : jianglixxList) {

				rysxJianglixxDAO.interceptDeleteRsJianglixxById(jianglixx);
			}
			List<RysxJiaoliuxx> jiaoliuxxList = rysxJiaoliuxxDAO
					.getJiaoliuxxByRybhFy(rybh, fydm);
			for (RysxJiaoliuxx jiaoliuxx : jiaoliuxxList) {

				rysxJiaoliuxxDAO.interceptDeleteRsJiaoliuxxById(jiaoliuxx);
			}
			List<RysxJlxx> jlxxList = rysxJlxxDAO.getJlxxByRybhFy(rybh, fydm);
			for (RysxJlxx jlxx : jlxxList) {

				rysxJlxxDAO.interceptDeleteRsJlxxById(jlxx);
			}
			List<RysxJtxx> jtxxList = rysxJtxxDAO.getJtxxByRybhFy(rybh, fydm);
			for (RysxJtxx jtxx : jtxxList) {

				rysxJtxxDAO.interceptDeleteRsJtxxById(jtxx);
			}
			List<RysxJzzw> jzzwList = rysxJzzwDAO.getJrzwByRybhFy(rybh, fydm);
			for (RysxJzzw jzzw : jzzwList) {

				rysxJzzwDAO.interceptDeleteRsJrzwById(jzzw);
			}
			List<RysxKhxx> khxxList = rysxKhxxDAO.getKhxxByRybhFy(rybh, fydm);
			for (RysxKhxx khxx : khxxList) {

				rysxKhxxDAO.interceptDeleteRsKhxxById(khxx);
			}
			List<RysxLdbz> ldbzList = rysxLdbzDAO.getLdbzByRybhFy(rybh, fydm);
			for (RysxLdbz ldbz : ldbzList) {

				rysxLdbzDAO.interceptDeleteRsLdbzById(ldbz);
			}
			RysxPhoto photo = rysxPhotoDAO.getRysxPhoto(String.valueOf(fydm),
					String.valueOf(rybh));

			if (photo != null)
				rysxPhotoDAO.delete(photo);

			List<RysxPxxx> pxxxList = rysxPxxxDAO.getPxxxByRybhFy(rybh, fydm);
			for (RysxPxxx pxxx : pxxxList) {

				rysxPxxxDAO.interceptDeleteRsPxxxById(pxxx);
			}
			List<RysxSfks> sfksList = rysxSfksDAO.getSfksByRybhFy(rybh, fydm);
			for (RysxSfks sfks : sfksList) {

				rysxSfksDAO.interceptDeleteRsSfksById(sfks);
			}
			List<RysxSwxx> swxxList = rysxSwxxDAO.getSwxxByRybhFy(rybh, fydm);
			for (RysxSwxx swxx : swxxList) {

				rysxSwxxDAO.interceptDeleteRsSwxxById(swxx);
			}
			List<RysxSyyyx> syyyxList = rysxSyyyxDAO.getSyyyxByRybh(String
					.valueOf(rybh));
			for (RysxSyyyx syyyx : syyyxList) {

				if (syyyx != null)
					rysxSyyyxDAO.delete(syyyx);
			}
			List<RysxTxl> txlList = rysxTxlDAO.getTxlByRybhFy(rybh, fydm);
			for (RysxTxl txl : txlList) {

				rysxTxlDAO.interceptDeleteRsTxlById(txl);
			}
			List<RysxWyxx> wyxxList = rysxWyxxDAO.getWyxxByRybhFy(rybh, fydm);
			for (RysxWyxx wyxx : wyxxList) {

				rysxWyxxDAO.interceptDeleteRsWyxxById(wyxx);
			}
			List<RysxXlxx> xlxxList = rysxXlxxDAO.getXlxxByRybhFy(rybh, fydm);
			for (RysxXlxx xlxx : xlxxList) {

				rysxXlxxDAO.interceptDeleteRsXlxxById(xlxx);
			}
			List<RysxXwxx> xwxxList = rysxXwxxDAO.getXwxxByRybhFy(rybh, fydm);
			for (RysxXwxx xwxx : xwxxList) {

				rysxXwxxDAO.interceptDeleteRsXwxxById(xwxx);
			}
			List<RysxXzzw> xzzwList = rysxXzzwDAO.getXzzwByRybhFy(rybh, fydm);
			for (RysxXzzw xzzw : xzzwList) {

				rysxXzzwDAO.interceptDeleteRsXzzwById(xzzw);
			}
			List<RysxZdxx> zdxxList = rysxZdxxDAO.getZdxxByRybhFy(rybh, fydm);
			for (RysxZdxx zdxx : zdxxList) {

				rysxZdxxDAO.interceptDeleteRsZdxxById(zdxx);
			}
			List<RysxZjxx> zjxxList = rysxZjxxDAO.getZjxxByRybhFy(rybh, fydm);
			for (RysxZjxx zjxx : zjxxList) {

				rysxZjxxDAO.delete(zjxx);
			}
			List<RysxZyjszw> zyjszwList = rysxZyjszwDAO.getZyjszwByRybhFy(rybh,
					fydm);
			for (RysxZyjszw zyjszw : zyjszwList) {

				rysxZyjszwDAO.interceptDeleteRsZyjszwById(zyjszw);
			}
			List<RysxZzmm> zzmmList = rysxZzmmDAO.getZzmmByRybhFy(rybh, fydm);
			for (RysxZzmm zzmm : zzmmList) {

				rysxZzmmDAO.interceptDeleteRsZzmmById(zzmm);
			}
		}
		return true;
	}



	public List<ZzmmVO> getZzmmByRybhFy(int rybh, int fydm)
	{
		List<RysxZzmm> listRysxZzmm = rysxZzmmDAO.getZzmmByRybhFy(fydm, rybh);
		List<ZzmmVO> listZzmm = new ArrayList<ZzmmVO>();
		Map<String, String> mapNames = new HashMap<String, String>();
		for (int i = 0; i < listRysxZzmm.size(); i++)
		{
			ZzmmVO zzmmVO = new ZzmmVO();
			zzmmToVo(listRysxZzmm.get(i), zzmmVO, mapNames);
			listZzmm.add(zzmmVO);
		}
		return listZzmm;
	}

	private void zzmmToVo(RysxZzmm rysxZzmm, ZzmmVO zzmmVO,
			Map<String, String> mapNames)
	{
		zzmmVO.setNFy(rysxZzmm.getNFy() + "");
		zzmmVO.setNRybh(rysxZzmm.getNRybh() + "");
		zzmmVO.setNId(rysxZzmm.getNId().toString());
		zzmmVO.setNZzmm(DmMcCommon.dmMc(rysxZzmm.getNZzmm(),
				ConstantsFyrs.NBXH_ZZMM, mapNames, dmDAO));
		if (rysxZzmm.getDJrrq() != null)
		{
			zzmmVO.setDJrrq(DateUtil.format(rysxZzmm.getDJrrq(),
					DateUtil.webFormat).toString());
		}
		if (rysxZzmm.getDZzrq() != null)
		{
			zzmmVO.setDZzrq(DateUtil.format(rysxZzmm.getDZzrq(),
					DateUtil.webFormat).toString());
		}
		zzmmVO.setNDqxx(DmMcCommon.dmMc((int) rysxZzmm.getNDqxx(),
				ConstantsFyrs.NBXH_SF, mapNames, dmDAO));
	}

	@Override
	public ZzmmVO getRsZzmmById(String id, String fydm, String rybh)
	{
		RysxZzmm rysxZzmm = rysxZzmmDAO.getRsZzmmById(id, fydm, rybh);
		ZzmmVO zzmmVO = new ZzmmVO();
		Map<String, String> mapNames = new HashMap<String, String>();
		zzmmToVo(rysxZzmm, zzmmVO, mapNames);
		return zzmmVO;
	}

	public RysxZzmm getRsZzmmByFyRybhId(String id, String fydm, String rybh)
	{
		return rysxZzmmDAO.getRsZzmmById(id, fydm, rybh);
	}

	/**
	 * 功能，只需要确保它最多有一个-----是
	 */
	@Override
	public ZzmmVO addZzmm(ZzmmVO vo)
	{
		RysxZzmm rysxZzmm = new RysxZzmm();
		int fydm = Integer.valueOf(vo.getNFy());
		rysxZzmm.setNId(rysxTablekeyDAO.getMaxId(fydm, "N_ZZMMID"));
		rysxZzmm.setNFy(fydm);
		rysxZzmm.setNRybh(Integer.parseInt(vo.getNRybh()));
		rysxZzmm.setNZzmm(Integer.valueOf(vo.getNZzmm()));
		if (StringUtil.isNotBlank(vo.getDJrrq()))
		{
			rysxZzmm.setDJrrq(DateUtil.parse(vo.getDJrrq(), DateUtil.webFormat));
		}
		if (StringUtil.isNotBlank(vo.getDZzrq()))
		{
			rysxZzmm.setDZzrq(DateUtil.parse(vo.getDZzrq(), DateUtil.webFormat));
		}

		// 如果添加的是--当前信息
		if (vo.getNDqxx().equals("1"))
		{
			List<RysxZzmm> listRysxZzmms = rysxZzmmDAO.getZzmmByRybhFy(
					Integer.valueOf(fydm), Integer.valueOf(vo.getNRybh()));
			for (int i = 0; i < listRysxZzmms.size(); i++)
			{

				if (listRysxZzmms.get(i).getNDqxx() == 1)
				{
					try
					{
						ObjectByteThreadLocal
								.setObjectByte(ObjectSerializedUtils
										.writeObjectToMemory(listRysxZzmms
												.get(i)));
					} catch (Exception ex)
					{
						ex.printStackTrace();
					}
					listRysxZzmms.get(i).setNDqxx((short) 2);
					rysxZzmmDAO.interceptUpdateZzmm(listRysxZzmms.get(i));
				}
			}
			Ryjbxx ryjbxx = ryjbxxDAO.getRyjbxxByRybhFyDm(
					Integer.valueOf(vo.getNRybh()), Integer.valueOf(fydm));
			try
			{
				ObjectByteThreadLocal.setObjectByte(ObjectSerializedUtils
						.writeObjectToMemory(ryjbxx));
			} catch (Exception ex)
			{
				ex.printStackTrace();
			}
			ryjbxx.setNZzmm(Integer.valueOf(vo.getNZzmm()));
			ryjbxxDAO.interceptUpdateRyjbxx(ryjbxx);
		}

		rysxZzmm.setNDqxx(Short.valueOf(vo.getNDqxx()));
		rysxZzmmDAO.interceptAddZzmm(rysxZzmm);
		ZzmmVO zzmmVO = new ZzmmVO();
		Map<String, String> mapNames = new HashMap<String, String>();
		zzmmToVo(rysxZzmm, zzmmVO, mapNames);
		return zzmmVO;
	}

	@Override
	public boolean delRsZzmmById(String id, String fydm, String rybh)
	{
		RysxZzmm rysxZzmm = rysxZzmmDAO.findByFyRybhId(Integer.valueOf(fydm),
				Integer.valueOf(rybh), new BigDecimal(id));
		boolean isUpdateRyjbxx = false;
		// 如果删除的是当前信息
		if (rysxZzmm.getNDqxx() == 1)
		{
			Ryjbxx ryjbxx = ryjbxxDAO.getRyjbxxByRybhFyDm(
					Integer.valueOf(rybh), Integer.valueOf(fydm));
			try
			{
				ObjectByteThreadLocal.setObjectByte(ObjectSerializedUtils
						.writeObjectToMemory(ryjbxx));
			} catch (Exception ex)
			{
				ex.printStackTrace();
			}
			ryjbxx.setNZzmm(null);
			isUpdateRyjbxx = ryjbxxDAO.interceptUpdateRyjbxx(ryjbxx);
			return ((rysxZzmmDAO.interceptDeleteRsZzmmById(rysxZzmm)) && isUpdateRyjbxx);
		} else
		{
			return rysxZzmmDAO.interceptDeleteRsZzmmById(rysxZzmm);
		}
		// 如果是 -- 是，就会把当前信息修改
	}

	@Override
	public ZzmmVO updateRsZzmm(ZzmmVO vo)
	{
		BigDecimal bd = new BigDecimal(vo.getNId());
		int fydm = Integer.valueOf(vo.getNFy());
		int rybh = Integer.valueOf(vo.getNRybh());
		// 这里的代码有顺序要求（因为首先要把旧的对象保存，才更新，最多涉及三个对象）
		RysxZzmm rysxZzmm = rysxZzmmDAO.findByFyRybhId(fydm, rybh, bd);

		// 如果更新成 --- 是
		if (vo.getNDqxx().equals("1"))
		{
			List<RysxZzmm> listRysxZzmms = rysxZzmmDAO.getZzmmByRybhFy(fydm,
					Integer.parseInt(vo.getNRybh()));
			for (int i = 0; i < listRysxZzmms.size(); i++)
			{
				if (listRysxZzmms.get(i).getNDqxx() == 1)
				{
					try
					{
						ObjectByteThreadLocal
								.setObjectByte(ObjectSerializedUtils
										.writeObjectToMemory(listRysxZzmms
												.get(i)));
					} catch (Exception ex)
					{
						ex.printStackTrace();
					}
					listRysxZzmms.get(i).setNDqxx((short) 2);
					rysxZzmmDAO.interceptUpdateZzmm(listRysxZzmms.get(i));
				}
			}
			Ryjbxx ryjbxx = ryjbxxDAO.getRyjbxxByRybhFyDm(
					Integer.valueOf(rybh), Integer.valueOf(fydm));

			try
			{
				ObjectByteThreadLocal.setObjectByte(ObjectSerializedUtils
						.writeObjectToMemory(ryjbxx));
			} catch (Exception ex)
			{
				ex.printStackTrace();
			}
			ryjbxx.setNZzmm(Integer.valueOf(vo.getNZzmm()));
			ryjbxxDAO.interceptUpdateRyjbxx(ryjbxx);
		}

		// 它自己要更新，所以先保存
		try
		{
			ObjectByteThreadLocal.setObjectByte(ObjectSerializedUtils
					.writeObjectToMemory(rysxZzmm));
		} catch (Exception ex)
		{
			ex.printStackTrace();
		}
		
		rysxZzmm.setNZzmm(Integer.valueOf(vo.getNZzmm()));
		if (StringUtil.isNotBlank(vo.getDJrrq()))
		{
			rysxZzmm.setDJrrq(DateUtil.parse(vo.getDJrrq(), DateUtil.webFormat));
		} else
		{
			rysxZzmm.setDJrrq(null);
		}
		if (StringUtil.isNotBlank(vo.getDZzrq()))
		{
			rysxZzmm.setDZzrq(DateUtil.parse(vo.getDZzrq(), DateUtil.webFormat));
		} else
		{
			rysxZzmm.setDZzrq(null);
		}
		rysxZzmm.setNDqxx(Short.valueOf(vo.getNDqxx()));
		rysxZzmmDAO.interceptUpdateZzmm(rysxZzmm);
		ZzmmVO zzmmVO = new ZzmmVO();
		Map<String, String> mapNames = new HashMap<String, String>();
		zzmmToVo(rysxZzmm, zzmmVO, mapNames);
		return zzmmVO;
	}

	//职级信息
	public List<ZjxxVO> getZjxxByRybhFy(int rybh, int fydm)
	{
		List<RysxZjxx> listRysxZjxx = rysxZjxxDAO.getZjxxByRybhFy(fydm, rybh);
		List<ZjxxVO> listZjxx = new ArrayList<ZjxxVO>();
		for (int i = 0; i < listRysxZjxx.size(); i++)
		{
			ZjxxVO zjxxVO = new ZjxxVO();
			zjxxVO.setNId(listRysxZjxx.get(i).getNId().toString());
			zjxxVO.setNFy(listRysxZjxx.get(i).getNFy().toString());
			zjxxVO.setNRybh(listRysxZjxx.get(i).getNRybh().toString());
			if (listRysxZjxx.get(i).getNRmlb() != null)
			{
				zjxxVO.setNRmlb(dmDAO.getDmByMc(listRysxZjxx.get(i).getNRmlb(),
						"任免类别"));
			}
			if(listRysxZjxx.get(i).getNZj()!=null){
				zjxxVO.setNZj(dmDAO.getDmByMc(listRysxZjxx.get(i).getNZj(),
						"职级"));
			}
			if(listRysxZjxx.get(i).getNZjxz()!=null){
				zjxxVO.setNZjxz(dmDAO.getDmByMc(listRysxZjxx.get(i).getNZjxz(),
						"职级性质"));
			}
			if (listRysxZjxx.get(i).getDRmrq() != null)
			{
				zjxxVO.setDRmrq(DateUtil.format(listRysxZjxx.get(i).getDRmrq(),
						DateUtil.webFormat).toString());
			}
			
			zjxxVO.setCDw(listRysxZjxx.get(i).getCDw());
			zjxxVO.setCBm(listRysxZjxx.get(i).getCBm());
			if (listRysxZjxx.get(i).getNRmyy() != null)
			{
				zjxxVO.setNRmyy(dmDAO.getDmByMc(listRysxZjxx.get(i).getNRmyy(),
						"任免原因"));
			}
			if (listRysxZjxx.get(i).getDPzrq() != null)
			{
				zjxxVO.setDPzrq(DateUtil.format(listRysxZjxx.get(i).getDPzrq(),
						DateUtil.webFormat).toString());
			}
			zjxxVO.setCPzdw(listRysxZjxx.get(i).getCPzdw());
			zjxxVO.setCPzwh(listRysxZjxx.get(i).getCPzwh());
			if (listRysxZjxx.get(i).getNDqxx() != null)
			{
				zjxxVO.setNDqxx(dmDAO.getDmByMc(listRysxZjxx.get(i).getNDqxx(),
						"是否"));
			}
			listZjxx.add(zjxxVO);
		}
		return listZjxx;
	}
	
	
	@Override
	public ZjxxVO getRsZjxxById(String id, String fydm, String rybh)
	{

		RysxZjxx rysxZjxx = rysxZjxxDAO.getRsZjxxById(id, fydm, rybh);
		ZjxxVO zjxxVO = new ZjxxVO();
		
		zjxxVO.setNId(rysxZjxx.getNId().toString());
		zjxxVO.setNFy(rysxZjxx.getNFy().toString());
		zjxxVO.setNRybh(rysxZjxx.getNRybh().toString());
		if (rysxZjxx.getNRmlb() != null)
		{
			zjxxVO.setNRmlb(dmDAO.getDmByMc(rysxZjxx.getNRmlb(),
					"任免类别"));
		}
		if(rysxZjxx.getNZj()!=null){
			zjxxVO.setNZj(dmDAO.getDmByMc(rysxZjxx.getNZj(),
					"职级"));
		}
		if(rysxZjxx.getNZjxz()!=null){
			zjxxVO.setNZjxz(dmDAO.getDmByMc(rysxZjxx.getNZjxz(),
					"职级性质"));
		}
		if (rysxZjxx.getDRmrq() != null)
		{
			zjxxVO.setDRmrq(DateUtil.format(rysxZjxx.getDRmrq(),
					DateUtil.webFormat).toString());
		}
		
		zjxxVO.setCDw(rysxZjxx.getCDw());
		zjxxVO.setCBm(rysxZjxx.getCBm());
		if (rysxZjxx.getNRmyy() != null)
		{
			zjxxVO.setNRmyy(dmDAO.getDmByMc(rysxZjxx.getNRmyy(),
					"任免原因"));
		}
		if (rysxZjxx.getDPzrq() != null)
		{
			zjxxVO.setDPzrq(DateUtil.format(rysxZjxx.getDPzrq(),
					DateUtil.webFormat).toString());
		}
		zjxxVO.setCPzdw(rysxZjxx.getCPzdw());
		zjxxVO.setCPzwh(rysxZjxx.getCPzwh());
		if (rysxZjxx.getNDqxx() != null)
		{
			zjxxVO.setNDqxx(dmDAO.getDmByMc(rysxZjxx.getNDqxx(),
					"是否"));
		}
		return zjxxVO;
	}

	
	
	@Override
	public List<XzzwVO> getXzzwByRybhFy(int rybh, int fydm)
	{

		List<RysxXzzw> listRysxXzzw = rysxXzzwDAO.getXzzwByRybhFy(fydm, rybh);
		List<XzzwVO> listXzzw = new ArrayList<XzzwVO>();
		for (int i = 0; i < listRysxXzzw.size(); i++)
		{
			XzzwVO xzzwVO = new XzzwVO();
			xzzwVO.setNId(listRysxXzzw.get(i).getNId().toString());
			xzzwVO.setNFy(listRysxXzzw.get(i).getNFy().toString());
			xzzwVO.setNRybh(listRysxXzzw.get(i).getNRybh().toString());
			if (listRysxXzzw.get(i).getNRmlb() != null)
			{
				xzzwVO.setNRmlb(dmDAO.getDmByMc(listRysxXzzw.get(i).getNRmlb(),
						"任免类别"));
			}
			if (!("").equals(listRysxXzzw.get(i).getCDw()))
			{
				xzzwVO.setCDw(listRysxXzzw.get(i).getCDw());
			}
			if (listRysxXzzw.get(i).getNXzzw() != null)
			{
				xzzwVO.setNXzzw(dmDAO.getDmByMc(listRysxXzzw.get(i).getNXzzw(),
						"行政职务"));
			}
			if (listRysxXzzw.get(i).getDRmrq() != null)
			{
				xzzwVO.setDRmrq(DateUtil.format(listRysxXzzw.get(i).getDRmrq(),
						DateUtil.webFormat).toString());
			}
			if (listRysxXzzw.get(i).getDPzrq() != null)
			{
				xzzwVO.setDPzrq(DateUtil.format(listRysxXzzw.get(i).getDPzrq(),
						DateUtil.webFormat).toString());
			}
			if (listRysxXzzw.get(i).getNDqxx() != null)
			{
				xzzwVO.setNDqxx(dmDAO.getDmByMc(listRysxXzzw.get(i).getNDqxx(),
						"是否"));
			}
			if (!("").equals(listRysxXzzw.get(i).getCPzwh()))
			{
				xzzwVO.setCPzwh(listRysxXzzw.get(i).getCPzwh());
			}
			listXzzw.add(xzzwVO);
		}
		return listXzzw;
	}

	@Override
	public XzzwVO getRsXzzwById(String id, String fydm, String rybh)
	{

		RysxXzzw rysxXzzw = rysxXzzwDAO.getRsXzzwById(id, fydm, rybh);
		XzzwVO xzzwVO = new XzzwVO();
		xzzwVO.setNId(rysxXzzw.getNId().toString());
		xzzwVO.setNFy(rysxXzzw.getNFy().toString());
		xzzwVO.setNRybh(rysxXzzw.getNRybh().toString());
		if (rysxXzzw.getNRmlb() != null)
		{
			xzzwVO.setNRmlb(dmDAO.getDmByMc(rysxXzzw.getNRmlb(), "任免类别"));
		}
		if (rysxXzzw.getNXzzw() != null)
		{
			xzzwVO.setNXzzw(dmDAO.getDmByMc(rysxXzzw.getNXzzw(), "行政职务"));
		}
		if (rysxXzzw.getDRmrq() != null)
		{
			xzzwVO.setDRmrq(DateUtil.format(rysxXzzw.getDRmrq(),
					DateUtil.webFormat).toString());
		}
		xzzwVO.setCDw(rysxXzzw.getCDw());
		xzzwVO.setCBm(rysxXzzw.getCBm());
		if (rysxXzzw.getNRmyy() != null)
		{
			xzzwVO.setNRmyy(dmDAO.getDmByMc(rysxXzzw.getNRmyy(), "任免原因"));
		}
		if (rysxXzzw.getDPzrq() != null)
		{
			xzzwVO.setDPzrq(DateUtil.format(rysxXzzw.getDPzrq(),
					DateUtil.webFormat).toString());
		}
		xzzwVO.setCPzdw(rysxXzzw.getCPzdw());
		xzzwVO.setCPzwh(rysxXzzw.getCPzwh());

		if (rysxXzzw.getNDqxx() != null)
		{
			xzzwVO.setNDqxx(dmDAO.getDmByMc(rysxXzzw.getNDqxx(), "是否"));
		}
		return xzzwVO;
	}

	@Override
	public XzzwVO addXzzw(XzzwVO vo)
	{
		RysxXzzw rysxXzzw = new RysxXzzw();
		int fydm = Integer.valueOf(vo.getNFy());
		rysxXzzw.setNId(rysxTablekeyDAO.getMaxId(fydm, "N_XZZWID"));
		rysxXzzw.setNFy(fydm);
		rysxXzzw.setNRybh(Integer.parseInt(vo.getNRybh()));
		rysxXzzw.setNRmlb(dmDAO.getDmByVO(vo.getNRmlb(), "任免类别"));
		rysxXzzw.setNXzzw(dmDAO.getDmByVO(vo.getNXzzw(), "行政职务"));
		if (StringUtil.isNotBlank(vo.getDRmrq()))
		{
			rysxXzzw.setDRmrq(DateUtil.parse(vo.getDRmrq(), DateUtil.webFormat));
		}
		if (StringUtil.isNotBlank(vo.getCDw()))
		{
			rysxXzzw.setCDw(vo.getCDw());
		}
		if (StringUtil.isNotBlank(vo.getCBm()))
		{
			rysxXzzw.setCBm(vo.getCBm());
		}
		if (StringUtil.isNotBlank(vo.getNRmyy()))
		{
			rysxXzzw.setNRmyy(dmDAO.getDmByVO(vo.getNRmyy(), "任免原因"));
		}
		if (StringUtil.isNotBlank(vo.getDPzrq()))
		{
			rysxXzzw.setDPzrq(DateUtil.parse(vo.getDPzrq(), DateUtil.webFormat));
		}
		rysxXzzw.setCDw(vo.getCDw());
		if (StringUtil.isNotBlank(vo.getCPzdw()))
		{
			rysxXzzw.setCPzdw(vo.getCPzdw());
		}
		if (StringUtil.isNotBlank(vo.getCPzwh()))
		{
			rysxXzzw.setCPzwh(vo.getCPzwh());
		}
		if (StringUtil.isNotBlank(vo.getNDqxx()))
		{
			rysxXzzw.setNDqxx((short) dmDAO.getDmByVO(vo.getNDqxx(), "是否"));
		}

		// 如果添加的是--当前信息
		if ((short) rysxXzzw.getNDqxx() == 1)
		{
			List<RysxXzzw> listRysxXzzws = rysxXzzwDAO.getXzzwByRybhFy(
					Integer.valueOf(fydm), Integer.valueOf(vo.getNRybh()));
			for (int i = 0; i < listRysxXzzws.size(); i++)
			{
				if ((short) listRysxXzzws.get(i).getNDqxx() == 1)
				{
					try
					{
						ObjectByteThreadLocal
								.setObjectByte(ObjectSerializedUtils
										.writeObjectToMemory(listRysxXzzws
												.get(i)));
					} catch (Exception ex)
					{
						ex.printStackTrace();
					}
					listRysxXzzws.get(i).setNDqxx((short) 2);
					rysxXzzwDAO.interceptUpdateXzzw(listRysxXzzws.get(i));
				}
			}
			Ryjbxx ryjbxx = ryjbxxDAO.getRyjbxxByRybhFyDm(
					Integer.valueOf(vo.getNRybh()), Integer.valueOf(fydm));
			try
			{
				ObjectByteThreadLocal.setObjectByte(ObjectSerializedUtils
						.writeObjectToMemory(ryjbxx));
			} catch (Exception ex)
			{
				ex.printStackTrace();
			}
			ryjbxx.setNXzzw(rysxXzzw.getNXzzw());
			ryjbxxDAO.interceptUpdateRyjbxx(ryjbxx);
		}

		rysxXzzwDAO.interceptAddXzzw(rysxXzzw);
		XzzwVO xzzwVO = new XzzwVO();
		xzzwVO.setNId(rysxXzzw.getNId().toString());
		xzzwVO.setNFy(rysxXzzw.getNFy().toString());
		xzzwVO.setNRybh(rysxXzzw.getNRybh().toString());

		if (rysxXzzw.getNRmlb() != null)
		{
			xzzwVO.setNRmlb(dmDAO.getDmByMc(rysxXzzw.getNRmlb(), "任免类别"));
		}
		if (rysxXzzw.getNXzzw() != null)
		{
			xzzwVO.setNXzzw(dmDAO.getDmByMc(rysxXzzw.getNXzzw(), "行政职务"));
		}
		if (rysxXzzw.getDRmrq() != null)
		{
			xzzwVO.setDRmrq(DateUtil.format(rysxXzzw.getDRmrq(),
					DateUtil.webFormat).toString());
		}
		xzzwVO.setCDw(rysxXzzw.getCDw());

		xzzwVO.setCBm(rysxXzzw.getCBm());

		if (rysxXzzw.getNRmyy() != null)
		{
			xzzwVO.setNRmyy(dmDAO.getDmByMc(rysxXzzw.getNRmyy(), "任免原因"));
		}
		if (rysxXzzw.getDPzrq() != null)
		{
			xzzwVO.setDPzrq(DateUtil.format(rysxXzzw.getDPzrq(),
					DateUtil.webFormat).toString());
		}

		xzzwVO.setCPzdw(rysxXzzw.getCPzdw());
		xzzwVO.setCPzwh(rysxXzzw.getCPzdw());
		if (rysxXzzw.getNDqxx() != null)
		{
			xzzwVO.setNDqxx(dmDAO.getDmByMc(rysxXzzw.getNDqxx(), "是否"));
		}
		return xzzwVO;
	}

	@Override
	public boolean delRsXzzwById(String id, String fydm, String rybh)
	{
		RysxXzzw rysxXzzw = rysxXzzwDAO.findByFyRybhId(Integer.valueOf(fydm),
				Integer.valueOf(rybh), new BigDecimal(id));
		boolean isUpdateRyjbxx = false;
		// 如果删除的是当前信息
		if (rysxXzzw.getNDqxx() == 1)
		{
			Ryjbxx ryjbxx = ryjbxxDAO.getRyjbxxByRybhFyDm(
					Integer.valueOf(rybh), Integer.valueOf(fydm));
			try
			{
				ObjectByteThreadLocal.setObjectByte(ObjectSerializedUtils
						.writeObjectToMemory(ryjbxx));
			} catch (Exception ex)
			{
				ex.printStackTrace();
			}
			ryjbxx.setNXzzw(null);
			isUpdateRyjbxx = ryjbxxDAO.interceptUpdateRyjbxx(ryjbxx);
			return ((rysxXzzwDAO.interceptDeleteRsXzzwById(rysxXzzw)) && isUpdateRyjbxx);
		} else
		{
			return rysxXzzwDAO.interceptDeleteRsXzzwById(rysxXzzw);
		}
	}

	
	@Override
	public XzzwVO updateRsXzzw(XzzwVO vo)
	{

		BigDecimal bd = new BigDecimal(vo.getNId());
		int fydm = Integer.valueOf(vo.getNFy());
		int rybh = Integer.valueOf(vo.getNRybh());
		// 这里的代码有顺序要求（因为首先要把旧的对象保存，才更新，最多涉及三个对象）
		RysxXzzw rysxXzzw = rysxXzzwDAO.findByFyRybhId(fydm, rybh, bd);
		// 如果更新成 --- 是
		if (vo.getNDqxx().equals("1"))
		{
			List<RysxXzzw> listRysxXzzws = rysxXzzwDAO.getXzzwByRybhFy(fydm,
					Integer.parseInt(vo.getNRybh()));
			for (int i = 0; i < listRysxXzzws.size(); i++)
			{
				if (listRysxXzzws.get(i).getNDqxx() == 1)
				{
					try
					{
						ObjectByteThreadLocal
								.setObjectByte(ObjectSerializedUtils
										.writeObjectToMemory(listRysxXzzws
												.get(i)));
					} catch (Exception ex)
					{
						ex.printStackTrace();
					}
					listRysxXzzws.get(i).setNDqxx((short) 2);
					rysxXzzwDAO.interceptUpdateXzzw(listRysxXzzws.get(i));
				}
			}
			Ryjbxx ryjbxx = ryjbxxDAO.getRyjbxxByRybhFyDm(
					Integer.valueOf(rybh), Integer.valueOf(fydm));

			try
			{
				ObjectByteThreadLocal.setObjectByte(ObjectSerializedUtils
						.writeObjectToMemory(ryjbxx));
			} catch (Exception ex)
			{
				ex.printStackTrace();
			}
			ryjbxx.setNXzzw(Integer.valueOf(vo.getNXzzw()));
			ryjbxxDAO.interceptUpdateRyjbxx(ryjbxx);
		}

		// 它自己要更新，所以先保存
		try
		{
			ObjectByteThreadLocal.setObjectByte(ObjectSerializedUtils
					.writeObjectToMemory(rysxXzzw));
		} catch (Exception ex)
		{
			ex.printStackTrace();
		}

		rysxXzzw.setNRmlb(dmDAO.getDmByVO(vo.getNRmlb(), "任免类别"));
		rysxXzzw.setNXzzw(dmDAO.getDmByVO(vo.getNXzzw(), "行政职务"));
		if (StringUtil.isNotBlank(vo.getDRmrq()))
		{
			rysxXzzw.setDRmrq(DateUtil.parse(vo.getDRmrq(), DateUtil.webFormat));
		} else
		{
			rysxXzzw.setDRmrq(null);
		}
		rysxXzzw.setCDw(vo.getCDw());
		rysxXzzw.setCBm(vo.getCBm());
		if (StringUtil.isNotBlank(vo.getNRmyy()))
		{
			rysxXzzw.setNRmyy(dmDAO.getDmByVO(vo.getNRmyy(), "任免原因"));
		}
		if (StringUtil.isNotBlank(vo.getDPzrq()))
		{
			rysxXzzw.setDPzrq(DateUtil.parse(vo.getDPzrq(), DateUtil.webFormat));
		} else
		{
			rysxXzzw.setDPzrq(null);
		}
		rysxXzzw.setCPzdw(vo.getCPzdw());
		if (StringUtil.isNotBlank(vo.getNDqxx()))
		{
			rysxXzzw.setNDqxx((short) dmDAO.getDmByVO(vo.getNDqxx(), "是否"));
		}
		if (vo.getNDqxx().equals("是"))
		{
			List<RysxXzzw> listRysxXzzw = rysxXzzwDAO.getXzzwByRybhFy(fydm,
					Integer.parseInt(vo.getNRybh()));
			for (int i = 0; i < listRysxXzzw.size(); i++)
			{
				if (listRysxXzzw.get(i).getNDqxx() == 1
						&& listRysxXzzw.get(i) != rysxXzzw)
				{
					listRysxXzzw.get(i).setNDqxx((short) 2);
					rysxXzzwDAO.updateRsXzzw(listRysxXzzw.get(i));
				}
			}
		}
		rysxXzzwDAO.interceptUpdateXzzw(rysxXzzw);
		XzzwVO xzzwVO = new XzzwVO();
		xzzwVO.setNId(rysxXzzw.getNId().toString());
		xzzwVO.setNFy(rysxXzzw.getNFy().toString());
		xzzwVO.setNRybh(rysxXzzw.getNRybh().toString());
		xzzwVO.setNRmlb(dmDAO.getDmByMc(rysxXzzw.getNRmlb(), "任免类别"));
		xzzwVO.setNXzzw(dmDAO.getDmByMc(rysxXzzw.getNXzzw(), "行政职务"));

		if (rysxXzzw.getDRmrq() != null)
		{
			xzzwVO.setDRmrq(DateUtil.format(rysxXzzw.getDRmrq(),
					DateUtil.webFormat).toString());
		}
		if (!rysxXzzw.getCDw().equals(""))
		{
			xzzwVO.setCDw(rysxXzzw.getCDw());
		}
		if (!rysxXzzw.getCBm().equals(""))
		{
			xzzwVO.setCBm(rysxXzzw.getCBm());
		}
		if (rysxXzzw.getNRmyy() != null)
		{
			xzzwVO.setNRmyy(dmDAO.getDmByMc(rysxXzzw.getNRmyy(), "任免原因"));
		}
		if (rysxXzzw.getDPzrq() != null)
		{
			xzzwVO.setDPzrq(DateUtil.format(rysxXzzw.getDPzrq(),
					DateUtil.webFormat).toString());
		}
		if (!rysxXzzw.getCPzdw().equals(""))
		{
			xzzwVO.setCPzdw(rysxXzzw.getCPzdw());
		}
		if (rysxXzzw.getCPzdw().equals(""))
		{
			xzzwVO.setCPzwh(rysxXzzw.getCPzdw());
		}
		if (rysxXzzw.getNDqxx() != null)
		{
			xzzwVO.setNDqxx(dmDAO.getDmByMc(rysxXzzw.getNDqxx(), "是否"));
		}
		return xzzwVO;
	}

	@Override
	public List<FlzwVO> getFlzwByRybhFy(int rybh, int fydm)
	{
		List<RysxFlzw> flzwList = rysxFlzwDAO.getFlzwByRybhFy(fydm, rybh);
		List<FlzwVO> flzwVOList = new ArrayList<FlzwVO>();
		for (int i = 0; i < flzwList.size(); i++)
		{
			FlzwVO flzwVO = new FlzwVO();
			flzwVO.setNId(flzwList.get(i).getNId().toString());
			flzwVO.setNFy(flzwList.get(i).getNFy().toString());
			flzwVO.setNRybh(flzwList.get(i).getNRybh().toString());
			if (flzwList.get(i).getNRmlb() != null)
			{
				flzwVO.setNRmlb(dmDAO.getDmByMc(flzwList.get(i).getNRmlb(),
						"任免类别"));
			}
			if (flzwList.get(i).getNFlzw() != null)
			{
				flzwVO.setNFlzw(dmDAO.getDmByMc(flzwList.get(i).getNFlzw(),
						"法律职务"));
			}
			if (flzwList.get(i).getDRmrq() != null)
			{
				flzwVO.setDRmrq(DateUtil.format(flzwList.get(i).getDRmrq(),
						DateUtil.webFormat).toString());
			}
			flzwVO.setCDw(flzwList.get(i).getCDw());
			flzwVO.setCBm(flzwList.get(i).getCBm());
			if (flzwList.get(i).getNRmyy() != null)
			{
				flzwVO.setNRmyy(dmDAO.getDmByMc(flzwList.get(i).getNRmyy(),
						"任免原因"));
			}
			if (flzwList.get(i).getDPzrq() != null)
			{
				flzwVO.setDPzrq(DateUtil.format(flzwList.get(i).getDPzrq(),
						DateUtil.webFormat).toString());
			}
			flzwVO.setCPzdw(flzwList.get(i).getCPzdw());
			flzwVO.setCPzwh(flzwList.get(i).getCPzwh());
			if (flzwList.get(i).getNDqxx() != null)
			{
				flzwVO.setNDqxx(dmDAO.getDmByMc(flzwList.get(i).getNDqxx(),
						"是否"));
			}
			flzwVOList.add(flzwVO);
		}
		return flzwVOList;
	}

	@Override
	public FlzwVO getRsFlzwById(String id, String fydm, String rybh)
	{
		RysxFlzw rysxFlzw = rysxFlzwDAO.getRsFlzwById(id, fydm, rybh);
		FlzwVO flzwVO = new FlzwVO();
		flzwVO.setNId(rysxFlzw.getNId().toString());
		flzwVO.setNRybh(rysxFlzw.getNRybh().toString());
		flzwVO.setNFy(rysxFlzw.getNFy().toString());
		flzwVO.setNRmlb(dmDAO.getDmByMc(rysxFlzw.getNRmlb(), "任免类别"));
		flzwVO.setNFlzw(dmDAO.getDmByMc(rysxFlzw.getNFlzw(), "法律职务"));
		if (rysxFlzw.getDRmrq() != null)
		{
			flzwVO.setDRmrq(DateUtil.format(rysxFlzw.getDRmrq(),
					DateUtil.webFormat).toString());
		}
		flzwVO.setCDw(rysxFlzw.getCDw());
		flzwVO.setCBm(rysxFlzw.getCBm());
		if (rysxFlzw.getNRmyy() != null)
		{
			flzwVO.setNRmyy(dmDAO.getDmByMc(rysxFlzw.getNRmyy(), "任免原因"));
		}
		if (rysxFlzw.getDPzrq() != null)
		{
			flzwVO.setDPzrq(DateUtil.format(rysxFlzw.getDPzrq(),
					DateUtil.webFormat).toString());
		}
		flzwVO.setCPzdw(rysxFlzw.getCPzdw());
		flzwVO.setCPzwh(rysxFlzw.getCPzwh());
		if (rysxFlzw.getNDqxx() != null)
		{
			flzwVO.setNDqxx(dmDAO.getDmByMc(rysxFlzw.getNDqxx(), "是否"));
		}
		return flzwVO;
	}

	@Override
	public boolean delRsFlzwById(String id, String fydm, String rybh)
	{
		RysxFlzw rysxFlzw = rysxFlzwDAO.findByFyRybhId(Integer.valueOf(fydm),
				Integer.valueOf(rybh), new BigDecimal(id));
		boolean isUpdateRyjbxx = false;
		// 如果删除的是当前信息
		if (rysxFlzw.getNDqxx() == 1)
		{
			Ryjbxx ryjbxx = ryjbxxDAO.getRyjbxxByRybhFyDm(
					Integer.valueOf(rybh), Integer.valueOf(fydm));
			try
			{
				ObjectByteThreadLocal.setObjectByte(ObjectSerializedUtils
						.writeObjectToMemory(ryjbxx));
			} catch (Exception ex)
			{
				ex.printStackTrace();
			}
			ryjbxx.setNFlzw(null);
			isUpdateRyjbxx = ryjbxxDAO.interceptUpdateRyjbxx(ryjbxx);
			return ((rysxFlzwDAO.interceptDeleteRsFlzwById(rysxFlzw)) && isUpdateRyjbxx);
		} else
		{
			return rysxFlzwDAO.interceptDeleteRsFlzwById(rysxFlzw);
		}
	}

	
	@Override
	public FlzwVO addFlzw(FlzwVO vo)
	{
		RysxFlzw rysxFlzw = new RysxFlzw();
		int fydm = Integer.valueOf(vo.getNFy());
		rysxFlzw.setNId(rysxTablekeyDAO.getMaxId(fydm, "N_FLZWID"));
		rysxFlzw.setCBm(vo.getCBm());
		rysxFlzw.setCDw(vo.getCDw());
		rysxFlzw.setCPzdw(vo.getCPzdw());
		rysxFlzw.setCPzwh(vo.getCPzdw());
		rysxFlzw.setCPzwh(vo.getCPzwh());
		if (StringUtil.isNotBlank(vo.getDPzrq()))
		{
			rysxFlzw.setDPzrq(DateUtil.parse(vo.getDPzrq(), DateUtil.webFormat));
		}
		if (StringUtil.isNotBlank(vo.getDRmrq()))
		{
			rysxFlzw.setDRmrq(DateUtil.parse(vo.getDPzrq(), DateUtil.webFormat));
		}
		rysxFlzw.setNDqxx((short) dmDAO.getDmByVO(vo.getNDqxx(), "是否"));
		rysxFlzw.setNFlzw(dmDAO.getDmByVO(vo.getNFlzw(), "法律职务"));
		rysxFlzw.setNFy(fydm);
		rysxFlzw.setNRmlb(dmDAO.getDmByVO(vo.getNRmlb(), "任免类别"));
		rysxFlzw.setNRmyy(dmDAO.getDmByVO(vo.getNRmyy(), "任免原因"));
		rysxFlzw.setNRybh(Integer.parseInt(vo.getNRybh()));

		// 如果添加的是--当前信息
		if (vo.getNDqxx().equals("是"))
		{
			List<RysxFlzw> listRysxFlzws = rysxFlzwDAO.getFlzwByRybhFy(
					Integer.valueOf(fydm), Integer.valueOf(vo.getNRybh()));
			for (int i = 0; i < listRysxFlzws.size(); i++)
			{

				if ((short) listRysxFlzws.get(i).getNDqxx() == 1)
				{
					try
					{
						ObjectByteThreadLocal
								.setObjectByte(ObjectSerializedUtils
										.writeObjectToMemory(listRysxFlzws
												.get(i)));
					} catch (Exception ex)
					{
						ex.printStackTrace();
					}
					listRysxFlzws.get(i).setNDqxx((short) 2);
					rysxFlzwDAO.interceptUpdateFlzw(listRysxFlzws.get(i));
				}
			}
			Ryjbxx ryjbxx = ryjbxxDAO.getRyjbxxByRybhFyDm(
					Integer.valueOf(vo.getNRybh()), Integer.valueOf(fydm));
			try
			{
				ObjectByteThreadLocal.setObjectByte(ObjectSerializedUtils
						.writeObjectToMemory(ryjbxx));
			} catch (Exception ex)
			{
				ex.printStackTrace();
			}
			ryjbxx.setNFlzw(rysxFlzw.getNFlzw());
			ryjbxxDAO.interceptUpdateRyjbxx(ryjbxx);
		}
		rysxFlzwDAO.interceptAddFlzw(rysxFlzw);
		FlzwVO flzwVO = new FlzwVO();
		flzwVO.setNId(rysxFlzw.getNId().toString());
		flzwVO.setNRybh(rysxFlzw.getNRybh().toString());
		flzwVO.setNFy(rysxFlzw.getNFy().toString());
		flzwVO.setNRmlb(dmDAO.getDmByMc(rysxFlzw.getNRmlb(), "任免类别"));
		flzwVO.setNFlzw(dmDAO.getDmByMc(rysxFlzw.getNFlzw(), "法律职务"));
		if (rysxFlzw.getDRmrq() != null)
		{
			flzwVO.setDRmrq(DateUtil.format(rysxFlzw.getDRmrq(),
					DateUtil.webFormat).toString());
		}
		flzwVO.setCDw(rysxFlzw.getCDw());
		flzwVO.setCBm(rysxFlzw.getCBm());
		flzwVO.setNRmyy(dmDAO.getDmByMc(rysxFlzw.getNRmyy(), "任免原因"));
		if (rysxFlzw.getDPzrq() != null)
		{
			flzwVO.setDPzrq(DateUtil.format(rysxFlzw.getDPzrq(),
					DateUtil.webFormat).toString());
		}
		flzwVO.setCPzdw(rysxFlzw.getCPzdw());
		flzwVO.setCPzwh(rysxFlzw.getCPzwh());
		flzwVO.setNDqxx(dmDAO.getDmByMc(rysxFlzw.getNDqxx(), "是否"));
		return flzwVO;
	}

	
	@Override
	public FlzwVO updateRsFlzw(FlzwVO vo)
	{
		BigDecimal bd = new BigDecimal(vo.getNId());
		int fydm = Integer.valueOf(vo.getNFy());
		int rybh = Integer.valueOf(vo.getNRybh());
		// 这里的代码有顺序要求（因为首先要把旧的对象保存，才更新，最多涉及三个对象）
		RysxFlzw rysxFlzw = rysxFlzwDAO.findByFyRybhId(fydm, rybh, bd);
		// 如果更新成 --- 是
		if (vo.getNDqxx().equals("是"))
		{
			List<RysxFlzw> listRysxFlzws = rysxFlzwDAO.getFlzwByRybhFy(fydm,
					Integer.parseInt(vo.getNRybh()));
			for (int i = 0; i < listRysxFlzws.size(); i++)
			{
				if (listRysxFlzws.get(i).getNDqxx() == 1)
				{
					try
					{
						ObjectByteThreadLocal
								.setObjectByte(ObjectSerializedUtils
										.writeObjectToMemory(listRysxFlzws
												.get(i)));
					} catch (Exception ex)
					{
						ex.printStackTrace();
					}
					listRysxFlzws.get(i).setNDqxx((short) 2);
					rysxFlzwDAO.interceptUpdateFlzw(listRysxFlzws.get(i));
				}
			}
			Ryjbxx ryjbxx = ryjbxxDAO.getRyjbxxByRybhFyDm(
					Integer.valueOf(rybh), Integer.valueOf(fydm));
			try
			{
				ObjectByteThreadLocal.setObjectByte(ObjectSerializedUtils
						.writeObjectToMemory(ryjbxx));
			} catch (Exception ex)
			{
				ex.printStackTrace();
			}
			ryjbxx.setNFlzw(dmDAO.getDmByVO(vo.getNFlzw(), "法律职务"));
			ryjbxxDAO.interceptUpdateRyjbxx(ryjbxx);
		}

		// 它自己要更新，所以先保存
		try
		{
			ObjectByteThreadLocal.setObjectByte(ObjectSerializedUtils
					.writeObjectToMemory(rysxFlzw));
		} catch (Exception ex)
		{
			ex.printStackTrace();
		}
		rysxFlzw.setCBm(vo.getCBm());
		rysxFlzw.setCDw(vo.getCDw());
		rysxFlzw.setCPzdw(vo.getCPzdw());
		rysxFlzw.setCPzwh(vo.getCPzdw());
		rysxFlzw.setCPzwh(vo.getCPzwh());
		if (StringUtil.isNotBlank(vo.getDPzrq()))
		{
			rysxFlzw.setDPzrq(DateUtil.parse(vo.getDPzrq(), DateUtil.webFormat));
		}
		if (StringUtil.isNotBlank(vo.getDRmrq()))
		{
			rysxFlzw.setDRmrq(DateUtil.parse(vo.getDPzrq(), DateUtil.webFormat));
		}
		rysxFlzw.setNDqxx((short) dmDAO.getDmByVO(vo.getNDqxx(), "是否"));
		rysxFlzw.setNRmlb(dmDAO.getDmByVO(vo.getNRmlb(), "任免类别"));
		rysxFlzw.setNRmyy(dmDAO.getDmByVO(vo.getNRmyy(), "任免原因"));
		rysxFlzw.setNFlzw(dmDAO.getDmByVO(vo.getNFlzw(), "法律职务"));
		if (vo.getNDqxx().equals("是"))
		{
			List<RysxFlzw> listRysxFlzw = rysxFlzwDAO.getFlzwByRybhFy(fydm,
					Integer.parseInt(vo.getNRybh()));
			for (int i = 0; i < listRysxFlzw.size(); i++)
			{
				if (listRysxFlzw.get(i).getNDqxx() == 1
						&& listRysxFlzw.get(i) != rysxFlzw)
				{
					listRysxFlzw.get(i).setNDqxx((short) 2);
					rysxFlzwDAO.updateRsFlzw(listRysxFlzw.get(i));
				}
			}
		}
		rysxFlzwDAO.interceptUpdateFlzw(rysxFlzw);
		FlzwVO flzwVO = new FlzwVO();
		flzwVO.setNId(rysxFlzw.getNId().toString());
		flzwVO.setNRybh(rysxFlzw.getNRybh().toString());
		flzwVO.setNFy(rysxFlzw.getNFy().toString());
		flzwVO.setNRmlb(dmDAO.getDmByMc(rysxFlzw.getNRmlb(), "任免类别"));
		flzwVO.setNFlzw(dmDAO.getDmByMc(rysxFlzw.getNFlzw(), "法律职务"));
		if (rysxFlzw.getDRmrq() != null)
		{
			flzwVO.setDRmrq(DateUtil.format(rysxFlzw.getDRmrq(),
					DateUtil.webFormat).toString());
		}
		flzwVO.setCDw(rysxFlzw.getCDw());
		flzwVO.setCBm(rysxFlzw.getCBm());
		flzwVO.setNRmyy(dmDAO.getDmByMc(rysxFlzw.getNRmyy(), "任免原因"));
		if (rysxFlzw.getDPzrq() != null)
		{
			flzwVO.setDPzrq(DateUtil.format(rysxFlzw.getDPzrq(),
					DateUtil.webFormat).toString());
		}
		flzwVO.setCPzdw(rysxFlzw.getCPzdw());
		flzwVO.setCPzwh(rysxFlzw.getCPzwh());
		flzwVO.setNDqxx(dmDAO.getDmByMc(rysxFlzw.getNDqxx(), "是否"));
		return flzwVO;
	}

	@Override
	public List<Dm> getDmListByName(String name)
	{
		return dmDAO.getDmListByName(name);
	}

	@Override
	public List<XlxxVO> getXlxxByRybhFy(int rybh, int fydm)
	{
		List<RysxXlxx> listRysxXlxx = rysxXlxxDAO.getXlxxByRybhFy(rybh, fydm);
		List<XlxxVO> listXlxx = new ArrayList<XlxxVO>();
		for (int i = 0; i < listRysxXlxx.size(); i++)
		{
			XlxxVO xlxxVO = new XlxxVO();
			xlxxVO.setNId(listRysxXlxx.get(i).getNId().toString());
			xlxxVO.setNFy(listRysxXlxx.get(i).getNFy().toString());
			xlxxVO.setNRybh(listRysxXlxx.get(i).getNRybh().toString());
			xlxxVO.setCSxzy(listRysxXlxx.get(i).getCSxzy());
			if (listRysxXlxx.get(i).getNSxzy() != null)
			{
				xlxxVO.setNSxzy(dmDAO.getDmByMc(listRysxXlxx.get(i).getNSxzy(),
						"专业"));
			}
			xlxxVO.setCXxmc(listRysxXlxx.get(i).getCXxmc());
			xlxxVO.setNJyxs(dmDAO.getDmByMc(listRysxXlxx.get(i).getNJyxs(),
					"教育形式"));
			if(listRysxXlxx.get(i).getNXxlb()!=null){
				xlxxVO.setNXxlb(dmDAO.getDmByMc(listRysxXlxx.get(i).getNXxlb(),
						"培训机构"));
			}
			if(listRysxXlxx.get(i).getNXxxs()!=null){
				xlxxVO.setNXxxs(dmDAO.getDmByMc(listRysxXlxx.get(i).getNXxxs(),
						"学习形式"));
			}
			if (listRysxXlxx.get(i).getDRxrq() != null)
			{
				xlxxVO.setDRxrq(DateUtil.format(listRysxXlxx.get(i).getDRxrq(),
						DateUtil.webFormat));
			}
			if (listRysxXlxx.get(i).getDByrq() != null)
			{
				xlxxVO.setDByrq(DateUtil.format(listRysxXlxx.get(i).getDByrq(),
						DateUtil.webFormat));
			}
			if (listRysxXlxx.get(i).getNXz() != null)
			{
				xlxxVO.setNXz(listRysxXlxx.get(i).getNXz().toString());
			}
			xlxxVO.setCSydw(listRysxXlxx.get(i).getCSydw());
			if (listRysxXlxx.get(i).getNXxszgj() != null)
			{
				xlxxVO.setNXxszgj(dmDAO.getDmByMc(listRysxXlxx.get(i)
						.getNXxszgj(), "国家"));
			}
			if (listRysxXlxx.get(i).getNJyxl() != null)
			{
				xlxxVO.setNJyxl(dmDAO.getDmByMc(listRysxXlxx.get(i).getNJyxl(),
						"文化程度"));
			}
			xlxxVO.setNXl(dmDAO.getDmByMc(listRysxXlxx.get(i).getNXl(), "文化程度"));
			xlxxVO.setNDqxx(dmDAO.getDmByMc(listRysxXlxx.get(i).getNDqxx(),
					"是否"));
			if (listRysxXlxx.get(i).getNTbjl() != null)
			{
				xlxxVO.setNTbjl(dmDAO.getDmByMc(listRysxXlxx.get(i).getNTbjl(),
						"是否"));
			}
			listXlxx.add(xlxxVO);
		}
		return listXlxx;
	}

	@Override
	public XlxxVO getRsXlxxById(String id, String fydm, String rybh)
	{
		RysxXlxx rysxXlxx = rysxXlxxDAO.getRsXlxxById(id, fydm, rybh);
		XlxxVO xlxxVO = new XlxxVO();
		xlxxVO.setNId(rysxXlxx.getNId().toString());
		xlxxVO.setNFy(rysxXlxx.getNFy().toString());
		xlxxVO.setNRybh(rysxXlxx.getNRybh().toString());
		xlxxVO.setCSxzy(rysxXlxx.getCSxzy());
		xlxxVO.setNSxzy(dmDAO.getDmByMc(rysxXlxx.getNSxzy(), "专业"));
		xlxxVO.setCXxmc(rysxXlxx.getCXxmc());
		xlxxVO.setNJyxs(dmDAO.getDmByMc(rysxXlxx.getNJyxs(), "教育形式"));
		xlxxVO.setNXxlb(dmDAO.getDmByMc(rysxXlxx.getNXxlb(), "培训机构"));
		xlxxVO.setNXxxs(dmDAO.getDmByMc(rysxXlxx.getNXxxs(), "学习形式"));
		if (rysxXlxx.getDRxrq() != null)
		{
			xlxxVO.setDRxrq(DateUtil.format(rysxXlxx.getDRxrq(),
					DateUtil.webFormat));
		}
		if (rysxXlxx.getDByrq() != null)
		{
			xlxxVO.setDByrq(DateUtil.format(rysxXlxx.getDByrq(),
					DateUtil.webFormat));
		}
		if (rysxXlxx.getNXz() != null)
		{
			xlxxVO.setNXz(rysxXlxx.getNXz().toString());
		}
		xlxxVO.setCSydw(rysxXlxx.getCSydw());
		
		
		
		xlxxVO.setNXxszgj(DmMcCommon.dmMc(rysxXlxx.getNXxszgj(), ConstantsFyrs.NBXH_GJ, mapNames, dmDAO));
		xlxxVO.setNJyxl(DmMcCommon.dmMc((int)rysxXlxx.getNJyxl(), ConstantsFyrs.NBXH_WHCD, mapNames, dmDAO));
		xlxxVO.setNXl(DmMcCommon.dmMc((int)rysxXlxx.getNDqxx(), ConstantsFyrs.NBXH_SF, mapNames, dmDAO));
		xlxxVO.setNDqxx(DmMcCommon.dmMc((int)rysxXlxx.getNTbjl(), ConstantsFyrs.NBXH_SF, mapNames, dmDAO));
		
		return xlxxVO;
	}

	@Override
	public boolean delRsXlxxById(String id, String fydm, String rybh)
	{
		RysxXlxx rysxXlxx = rysxXlxxDAO.findByFyRybhId(Integer.valueOf(fydm),
				Integer.valueOf(rybh), new BigDecimal(id));
		return rysxXlxxDAO.interceptDeleteRsXlxxById(rysxXlxx);
	}

	
	@Override
	public XlxxVO addXlxx(XlxxVO vo)
	{
		RysxXlxx rysxXlxx = new RysxXlxx();
		int fydm = Integer.valueOf(vo.getNFy());
		rysxXlxx.setNId(rysxTablekeyDAO.getMaxId(fydm, "N_XLXXID"));
		rysxXlxx.setNFy(fydm);
		rysxXlxx.setNRybh(Integer.parseInt(vo.getNRybh()));
		rysxXlxx.setNXl(Integer.parseInt(vo.getNXl()));
		rysxXlxx.setNSxzy(Integer.parseInt(vo.getNSxzy()));
		rysxXlxx.setCSxzy(vo.getCSxzy());
		rysxXlxx.setCXxmc(vo.getCXxmc());
		rysxXlxx.setNXxlb(Integer.parseInt(vo.getNXxlb()));
		rysxXlxx.setNJyxs(Integer.parseInt(vo.getNJyxs()));
		if (!vo.getNXz().equals(""))
		{
			rysxXlxx.setNXz(Short.parseShort(vo.getNXz()));
		}
		rysxXlxx.setCSydw(vo.getCSydw());
		rysxXlxx.setNXxszgj(Integer.parseInt(vo.getNXxszgj()));
		rysxXlxx.setNJyxl(Short.parseShort(vo.getNJyxl()));
		rysxXlxx.setNDqxx(Short.parseShort(vo.getNDqxx()));
		rysxXlxx.setNTbjl(Short.parseShort(vo.getNTbjl()));
		if (StringUtil.isNotBlank(vo.getDRxrq()))
		{
			rysxXlxx.setDRxrq(DateUtil.parse(vo.getDRxrq(), DateUtil.webFormat));
		}
		if (StringUtil.isNotBlank(vo.getDByrq()))
		{
			rysxXlxx.setDByrq(DateUtil.parse(vo.getDByrq(), DateUtil.webFormat));
		}
		rysxXlxx.setNXxxs(Integer.parseInt(vo.getNXxxs()));
		if (vo.getNDqxx().equals("1"))
		{
			List<RysxXlxx> listRysxXlxx = rysxXlxxDAO.getXlxxByRybhFy(
					Integer.parseInt(vo.getNRybh()), fydm);
			for (int i = 0; i < listRysxXlxx.size(); i++)
			{
				if ((short) listRysxXlxx.get(i).getNDqxx() == 1)
				{
					try
					{
						ObjectByteThreadLocal
								.setObjectByte(ObjectSerializedUtils
										.writeObjectToMemory(listRysxXlxx
												.get(i)));
					} catch (Exception ex)
					{
						ex.printStackTrace();
					}
					listRysxXlxx.get(i).setNDqxx((short) 2);
					rysxXlxxDAO.interceptUpdateXlxx(listRysxXlxx.get(i));
				}
			}
			Ryjbxx ryjbxx = ryjbxxDAO.getRyjbxxByRybhFyDm(
					Integer.valueOf(vo.getNRybh()), Integer.valueOf(fydm));
			try
			{
				ObjectByteThreadLocal.setObjectByte(ObjectSerializedUtils
						.writeObjectToMemory(ryjbxx));
			} catch (Exception ex)
			{
				ex.printStackTrace();
			}
			ryjbxx.setNXl(rysxXlxx.getNXl());
			ryjbxxDAO.interceptUpdateRyjbxx(ryjbxx);
		}
		rysxXlxxDAO.interceptAddXlxx(rysxXlxx);
		if (vo.getNTbjl().equals("1"))
		{
			JlxxVO jlxxVO = new JlxxVO();
			jlxxVO.setNFy(vo.getNFy());
			jlxxVO.setNRybh(vo.getNRybh());
			jlxxVO.setCZmr("");
			jlxxVO.setCSzdw("");
			jlxxVO.setCSzbm("");
			jlxxVO.setDQsrq(vo.getDRxrq());
			jlxxVO.setDJzrq(vo.getDByrq());
			jlxxVO.setCZj("");
			jlxxVO.setCZw(dmDAO.getDmByMc(rysxXlxx.getNXl(), "文化程度"));
			addJlxx(jlxxVO);
		}

		XlxxVO xlxxVO = new XlxxVO();
		xlxxVO.setNId(rysxXlxx.getNId().toString());
		xlxxVO.setNFy(rysxXlxx.getNFy().toString());
		xlxxVO.setNRybh(rysxXlxx.getNRybh().toString());
		xlxxVO.setCSxzy(rysxXlxx.getCSxzy());
		xlxxVO.setNSxzy(dmDAO.getDmByMc(rysxXlxx.getNSxzy(), "专业"));
		xlxxVO.setCXxmc(rysxXlxx.getCXxmc());
		xlxxVO.setNJyxs(dmDAO.getDmByMc(rysxXlxx.getNJyxs(), "教育形式"));
		xlxxVO.setNXxlb(dmDAO.getDmByMc(rysxXlxx.getNXxlb(), "培训机构"));
		xlxxVO.setNXxxs(dmDAO.getDmByMc(rysxXlxx.getNXxxs(), "学习形式"));
		if (rysxXlxx.getDRxrq() != null)
		{
			xlxxVO.setDRxrq(DateUtil.format(rysxXlxx.getDRxrq(),
					DateUtil.webFormat));
		}
		if (rysxXlxx.getDByrq() != null)
		{
			xlxxVO.setDByrq(DateUtil.format(rysxXlxx.getDByrq(),
					DateUtil.webFormat));
		}
		if (rysxXlxx.getNXz() != null)
		{
			xlxxVO.setNXz(rysxXlxx.getNXz().toString());
		}
		xlxxVO.setCSydw(rysxXlxx.getCSydw());
		xlxxVO.setNXxszgj(dmDAO.getDmByMc(rysxXlxx.getNXxszgj(), "国家"));
		xlxxVO.setNJyxl(dmDAO.getDmByMc(rysxXlxx.getNJyxl(), "文化程度"));
		xlxxVO.setNXl(dmDAO.getDmByMc(rysxXlxx.getNXl(), "文化程度"));
		xlxxVO.setNDqxx(dmDAO.getDmByMc(rysxXlxx.getNDqxx(), "是否"));
		xlxxVO.setNTbjl(dmDAO.getDmByMc(rysxXlxx.getNTbjl(), "是否"));
		return xlxxVO;
	}

	
	@Override
	public XlxxVO updateRsXlxx(XlxxVO vo)
	{
		BigDecimal bd = new BigDecimal(vo.getNId());
		int fydm = Integer.valueOf(vo.getNFy());
		int rybh = Integer.valueOf(vo.getNRybh());
		RysxXlxx rysxXlxx = rysxXlxxDAO.findByFyRybhId(fydm, rybh, bd);
		try
		{
			ObjectByteThreadLocal.setObjectByte(ObjectSerializedUtils
					.writeObjectToMemory(rysxXlxx));
		} catch (Exception ex)
		{
			ex.printStackTrace();
		}
		rysxXlxx.setNXl(Integer.parseInt(vo.getNXl()));
		rysxXlxx.setNSxzy(Integer.parseInt(vo.getNSxzy()));
		rysxXlxx.setCSxzy(vo.getCSxzy());
		rysxXlxx.setCXxmc(vo.getCXxmc());
		rysxXlxx.setNXxlb(Integer.parseInt(vo.getNXxlb()));
		rysxXlxx.setNJyxs(Integer.parseInt(vo.getNJyxs()));
		if (StringUtil.isNotBlank(vo.getNXz()))
		{
			rysxXlxx.setNXz(Short.parseShort(vo.getNXz()));
		}
		rysxXlxx.setCSydw(vo.getCSydw());
		rysxXlxx.setNXxszgj(Integer.parseInt(vo.getNXxszgj()));
		rysxXlxx.setNJyxl(Short.parseShort(vo.getNJyxl()));
		rysxXlxx.setNDqxx(Short.parseShort(vo.getNDqxx()));
		rysxXlxx.setNTbjl(Short.parseShort(vo.getNTbjl()));
		if (StringUtil.isNotBlank(vo.getDRxrq()))
		{
			rysxXlxx.setDRxrq(DateUtil.parse(vo.getDRxrq(), DateUtil.webFormat));
		}
		if (StringUtil.isNotBlank(vo.getDByrq()))
		{
			rysxXlxx.setDByrq(DateUtil.parse(vo.getDByrq(), DateUtil.webFormat));
		}
		rysxXlxx.setNXxxs(Integer.parseInt(vo.getNXxxs()));
		if (vo.getNDqxx().equals("1"))
		{
			List<RysxXlxx> listRysxXlxx = rysxXlxxDAO.getXlxxByRybhFy(
					Integer.parseInt(vo.getNRybh()), fydm);
			for (int i = 0; i < listRysxXlxx.size(); i++)
			{
				if ((short) listRysxXlxx.get(i).getNDqxx() == 1
						&& listRysxXlxx.get(i) != rysxXlxx)
				{
					try
					{
						ObjectByteThreadLocal
								.setObjectByte(ObjectSerializedUtils
										.writeObjectToMemory(listRysxXlxx
												.get(i)));
					} catch (Exception ex)
					{
						ex.printStackTrace();
					}
					listRysxXlxx.get(i).setNDqxx((short) 2);
					rysxXlxxDAO.interceptUpdateXlxx(listRysxXlxx.get(i));
				}
			}
			Ryjbxx ryjbxx = ryjbxxDAO.getRyjbxxByRybhFyDm(
					Integer.valueOf(vo.getNRybh()), Integer.valueOf(fydm));
			try
			{
				ObjectByteThreadLocal.setObjectByte(ObjectSerializedUtils
						.writeObjectToMemory(ryjbxx));
			} catch (Exception ex)
			{
				ex.printStackTrace();
			}
			ryjbxx.setNXl(rysxXlxx.getNXl());
			ryjbxxDAO.interceptUpdateRyjbxx(ryjbxx);
		}

		rysxXlxxDAO.interceptUpdateXlxx(rysxXlxx);
		XlxxVO xlxxVO = new XlxxVO();
		xlxxVO.setNId(rysxXlxx.getNId().toString());
		xlxxVO.setNFy(rysxXlxx.getNFy().toString());
		xlxxVO.setNRybh(rysxXlxx.getNRybh().toString());
		xlxxVO.setCSxzy(rysxXlxx.getCSxzy());
		xlxxVO.setNSxzy(dmDAO.getDmByMc(rysxXlxx.getNSxzy(), "专业"));
		xlxxVO.setCXxmc(rysxXlxx.getCXxmc());
		xlxxVO.setNJyxs(dmDAO.getDmByMc(rysxXlxx.getNJyxs(), "教育形式"));
		xlxxVO.setNXxlb(dmDAO.getDmByMc(rysxXlxx.getNXxlb(), "培训机构"));
		xlxxVO.setNXxxs(dmDAO.getDmByMc(rysxXlxx.getNXxxs(), "学习形式"));
		if (rysxXlxx.getDRxrq() != null)
		{
			xlxxVO.setDRxrq(DateUtil.format(rysxXlxx.getDRxrq(),
					DateUtil.webFormat));
		}
		if (rysxXlxx.getDByrq() != null)
		{
			xlxxVO.setDByrq(DateUtil.format(rysxXlxx.getDByrq(),
					DateUtil.webFormat));
		}
		if (rysxXlxx.getNXz() != null)
		{
			xlxxVO.setNXz(rysxXlxx.getNXz().toString());
		}
		xlxxVO.setCSydw(rysxXlxx.getCSydw());
		xlxxVO.setNXxszgj(dmDAO.getDmByMc(rysxXlxx.getNXxszgj(), "国家"));
		xlxxVO.setNJyxl(dmDAO.getDmByMc(rysxXlxx.getNJyxl(), "文化程度"));
		xlxxVO.setNXl(dmDAO.getDmByMc(rysxXlxx.getNXl(), "文化程度"));
		xlxxVO.setNDqxx(dmDAO.getDmByMc(rysxXlxx.getNDqxx(), "是否"));
		xlxxVO.setNTbjl(dmDAO.getDmByMc(rysxXlxx.getNTbjl(), "是否"));
		return xlxxVO;
	}

	@Override
	public int updateUserNameAndRoles(String userName, String roleIds,
			int rybh, int fyDm)
	{
		return ryjbxxDAO.updateUserNameAndRoles(userName, roleIds, rybh, fyDm);
	}

	@Override
	public void updatePassword(String password, int rybh, int fyDm)
	{
		ryjbxxDAO.updatePassword(password, rybh, fyDm);
	}

	@Override
	public Ryjbxx getRyjbxxByUserNamePassowrd(String username, int fyDm)
	{
		return ryjbxxDAO.getRyjbxxByUserNamePassowrd(username, fyDm);
	}

	@Override
	public String roleIdsByFydmRybh(int rybh, int fyDm)
	{
		return ryjbxxDAO.roleIdsByFydmRybh(rybh, fyDm);
	}

	// 学位信息
	@Override
	public List<XwxxVO> getXwxxByRybhFy(int rybh, int fydm)
	{
		List<RysxXwxx> listRysxXwxx = rysxXwxxDAO.getXwxxByRybhFy(rybh, fydm);
		List<XwxxVO> listXwxx = new ArrayList<XwxxVO>();
		for (int i = 0; i < listRysxXwxx.size(); i++)
		{
			XwxxVO xwxxVO = new XwxxVO();
			xwxxVO.setNId(listRysxXwxx.get(i).getNId().toString());
			xwxxVO.setNFy(listRysxXwxx.get(i).getNFy().toString());
			xwxxVO.setNRybh(listRysxXwxx.get(i).getNRybh().toString());
			xwxxVO.setNXw(dmDAO.getDmByMc(listRysxXwxx.get(i).getNXw(), "学位"));
			xwxxVO.setCSxzy(listRysxXwxx.get(i).getCSxzy());
			xwxxVO.setNSxzy(dmDAO.getDmByMc(listRysxXwxx.get(i).getNSxzy(),
					"专业"));
			xwxxVO.setCXxmc(listRysxXwxx.get(i).getCXxmc());
			xwxxVO.setNJyxs(dmDAO.getDmByMc(listRysxXwxx.get(i).getNJyxs(),
					"教育形式"));
			xwxxVO.setNXxlb(dmDAO.getDmByMc(listRysxXwxx.get(i).getNXxlb(),
					"培训机构"));
			xwxxVO.setNXxxs(dmDAO.getDmByMc(listRysxXwxx.get(i).getNXxxs(),
					"学习形式"));
			if (listRysxXwxx.get(i).getDRxrq() != null)
			{
				xwxxVO.setDRxrq(DateUtil.format(listRysxXwxx.get(i).getDRxrq(),
						DateUtil.webFormat));
			}
			if (listRysxXwxx.get(i).getDByrq() != null)
			{
				xwxxVO.setDByrq(DateUtil.format(listRysxXwxx.get(i).getDByrq(),
						DateUtil.webFormat));
			}
			if (listRysxXwxx.get(i).getNXz() != null)
			{
				xwxxVO.setNXz(listRysxXwxx.get(i).getNXz().toString());
			}
			if(listRysxXwxx.get(i).getNSygj()!=null){
				xwxxVO.setNSygj(dmDAO.getDmByMc(listRysxXwxx.get(i).getNSygj(),
						"国家"));
			}
			xwxxVO.setNDqxx(dmDAO.getDmByMc(listRysxXwxx.get(i).getNDqxx(),
					"是否"));
			listXwxx.add(xwxxVO);
		}
		return listXwxx;
	}

	
	@Override
	public XwxxVO getRsXwxxById(String id, String fydm, String rybh)
	{
		RysxXwxx rysxXwxx = rysxXwxxDAO.getRsXwxxById(id, fydm, rybh);
		XwxxVO xwxxVO = new XwxxVO();
		xwxxVO.setNId(rysxXwxx.getNId().toString());
		xwxxVO.setNFy(rysxXwxx.getNFy().toString());
		xwxxVO.setNRybh(rysxXwxx.getNRybh().toString());
		xwxxVO.setNXw(dmDAO.getDmByMc(rysxXwxx.getNXw(), "学位"));
		xwxxVO.setCSxzy(rysxXwxx.getCSxzy());
		xwxxVO.setNSxzy(dmDAO.getDmByMc(rysxXwxx.getNSxzy(), "专业"));
		xwxxVO.setCXxmc(rysxXwxx.getCXxmc());
		xwxxVO.setNJyxs(dmDAO.getDmByMc(rysxXwxx.getNJyxs(), "教育形式"));
		xwxxVO.setNXxlb(dmDAO.getDmByMc(rysxXwxx.getNXxlb(), "培训机构"));
		xwxxVO.setNXxxs(dmDAO.getDmByMc(rysxXwxx.getNXxxs(), "学习形式"));
		if (rysxXwxx.getDRxrq() != null)
		{
			xwxxVO.setDRxrq(DateUtil.format(rysxXwxx.getDRxrq(),
					DateUtil.webFormat));
		}
		if (rysxXwxx.getDByrq() != null)
		{
			xwxxVO.setDByrq(DateUtil.format(rysxXwxx.getDByrq(),
					DateUtil.webFormat));
		}
		if (rysxXwxx.getNXz() != null)
		{
			xwxxVO.setNXz(rysxXwxx.getNXz().toString());
		}
		xwxxVO.setDSyrq(DateUtil.format(rysxXwxx.getDSyrq(), DateUtil.webFormat));
		if(rysxXwxx.getNSygj()!=null){
			xwxxVO.setNSygj(dmDAO.getDmByMc(rysxXwxx.getNSygj(), "国家"));
		}
		xwxxVO.setNDqxx(dmDAO.getDmByMc(rysxXwxx.getNDqxx(), "是否"));
		xwxxVO.setNTbjl(dmDAO.getDmByMc(rysxXwxx.getNTbjl(), "是否"));
		return xwxxVO;
	}

	@Override
	public boolean delRsXwxxById(String id, String fydm, String rybh)
	{
		RysxXwxx rysxXwxx = rysxXwxxDAO.findByFyRybhId(Integer.valueOf(fydm),
				Integer.valueOf(rybh), new BigDecimal(id));
		return rysxXwxxDAO.interceptDeleteRsXwxxById(rysxXwxx);
	}

	
	@Override
	public XwxxVO addXwxx(XwxxVO vo)
	{
		RysxXwxx rysxXwxx = new RysxXwxx();
		int fydm = Integer.valueOf(vo.getNFy());
		rysxXwxx.setNId(rysxTablekeyDAO.getMaxId(fydm, "N_XWXXID"));
		rysxXwxx.setNFy(fydm);
		rysxXwxx.setNRybh(Integer.parseInt(vo.getNRybh()));
		rysxXwxx.setNXw(Integer.parseInt(vo.getNXw()));
		rysxXwxx.setNSxzy(Integer.parseInt(vo.getNSxzy()));
		rysxXwxx.setCSxzy(vo.getCSxzy());
		rysxXwxx.setCXxmc(vo.getCXxmc());
		rysxXwxx.setNXxlb(Integer.parseInt(vo.getNXxlb()));
		rysxXwxx.setNJyxs(Integer.parseInt(vo.getNJyxs()));
		if (StringUtil.isNotBlank(vo.getNXz()))
		{
			rysxXwxx.setNXz(Short.parseShort(vo.getNXz()));
		}
		rysxXwxx.setNSygj(Integer.parseInt(vo.getNSygj()));
		rysxXwxx.setNDqxx(Short.parseShort(vo.getNDqxx()));
		rysxXwxx.setNTbjl(Short.parseShort(vo.getNTbjl()));
		if (StringUtil.isNotBlank(vo.getDRxrq()))
		{
			rysxXwxx.setDRxrq(DateUtil.parse(vo.getDRxrq(), DateUtil.webFormat));
		}
		if (StringUtil.isNotBlank(vo.getDByrq()))
		{
			rysxXwxx.setDByrq(DateUtil.parse(vo.getDByrq(), DateUtil.webFormat));
		}
		if (StringUtil.isNotBlank(vo.getDSyrq()))
		{
			rysxXwxx.setDSyrq(DateUtil.parse(vo.getDSyrq(), DateUtil.webFormat));
		}
		rysxXwxx.setNXxxs(Integer.parseInt(vo.getNXxxs()));

		if (vo.getNDqxx().equals("1"))
		{
			List<RysxXwxx> listRysxXwxx = rysxXwxxDAO.getXwxxByRybhFy(
					Integer.parseInt(vo.getNRybh()), fydm);
			for (int i = 0; i < listRysxXwxx.size(); i++)
			{
				if (listRysxXwxx.get(i).getNDqxx() == 1)
				{
					listRysxXwxx.get(i).setNDqxx((short) 2);
					rysxXwxxDAO.updateRsXwxx(listRysxXwxx.get(i));
				}
			}
		}

		if (vo.getNTbjl().equals("1"))
		{
			JlxxVO jlxxVO = new JlxxVO();
			jlxxVO.setNFy(vo.getNFy());
			jlxxVO.setNRybh(vo.getNRybh());
			jlxxVO.setCZmr("");
			jlxxVO.setCSzdw("");
			jlxxVO.setCSzbm("");
			jlxxVO.setDQsrq(vo.getDRxrq());
			jlxxVO.setDJzrq(vo.getDByrq());
			jlxxVO.setCZj("");
			jlxxVO.setCZw(dmDAO.getDmByMc(rysxXwxx.getNXw(), "学位"));
			addJlxx(jlxxVO);
		}
		rysxXwxxDAO.interceptAddXwxx(rysxXwxx);
		XwxxVO xwxxVO = new XwxxVO();
		xwxxVO.setNId(rysxXwxx.getNId().toString());
		xwxxVO.setNFy(rysxXwxx.getNFy().toString());
		xwxxVO.setNRybh(rysxXwxx.getNRybh().toString());
		xwxxVO.setNXw(dmDAO.getDmByMc(rysxXwxx.getNXw(), "学位"));
		xwxxVO.setCSxzy(rysxXwxx.getCSxzy());
		xwxxVO.setNSxzy(dmDAO.getDmByMc(rysxXwxx.getNSxzy(), "专业"));
		xwxxVO.setCXxmc(rysxXwxx.getCXxmc());
		xwxxVO.setNJyxs(dmDAO.getDmByMc(rysxXwxx.getNJyxs(), "教育形式"));
		xwxxVO.setNXxlb(dmDAO.getDmByMc(rysxXwxx.getNXxlb(), "培训机构"));
		xwxxVO.setNXxxs(dmDAO.getDmByMc(rysxXwxx.getNXxxs(), "学习形式"));
		if (rysxXwxx.getDRxrq() != null)
		{
			xwxxVO.setDRxrq(DateUtil.format(rysxXwxx.getDRxrq(),
					DateUtil.webFormat));
		}
		if (rysxXwxx.getDByrq() != null)
		{
			xwxxVO.setDByrq(DateUtil.format(rysxXwxx.getDByrq(),
					DateUtil.webFormat));
		}
		if (rysxXwxx.getNXz() != null)
		{
			xwxxVO.setNXz(rysxXwxx.getNXz().toString());
		}
		xwxxVO.setDSyrq(DateUtil.format(rysxXwxx.getDSyrq(), DateUtil.webFormat));
		xwxxVO.setNSygj(dmDAO.getDmByMc(rysxXwxx.getNSygj(), "国家"));
		xwxxVO.setNDqxx(dmDAO.getDmByMc(rysxXwxx.getNDqxx(), "是否"));
		xwxxVO.setNTbjl(dmDAO.getDmByMc(rysxXwxx.getNTbjl(), "是否"));
		return xwxxVO;
	}

	
	@Override
	public XwxxVO updateRsXwxx(XwxxVO vo)
	{
		BigDecimal bd = new BigDecimal(vo.getNId());
		int fydm = Integer.valueOf(vo.getNFy());
		int rybh = Integer.valueOf(vo.getNRybh());
		RysxXwxx rysxXwxx = rysxXwxxDAO.findByFyRybhId(fydm, rybh, bd);
		try
		{
			ObjectByteThreadLocal.setObjectByte(ObjectSerializedUtils
					.writeObjectToMemory(rysxXwxx));
		} catch (Exception ex)
		{
			ex.printStackTrace();
		}
		rysxXwxx.setNXw(Integer.parseInt(vo.getNXw()));
		rysxXwxx.setNSxzy(Integer.parseInt(vo.getNSxzy()));
		rysxXwxx.setCSxzy(vo.getCSxzy());
		rysxXwxx.setCXxmc(vo.getCXxmc());
		rysxXwxx.setNXxlb(Integer.parseInt(vo.getNXxlb()));
		rysxXwxx.setNJyxs(Integer.parseInt(vo.getNJyxs()));
		if (!vo.getNXz().equals(""))
		{
			rysxXwxx.setNXz(Short.parseShort(vo.getNXz()));
		} else
		{
			rysxXwxx.setNXz(null);
		}
		rysxXwxx.setNSygj(Integer.parseInt(vo.getNSygj()));
		rysxXwxx.setNDqxx(Short.parseShort(vo.getNDqxx()));
		rysxXwxx.setNTbjl(Short.parseShort(vo.getNTbjl()));
		if (StringUtil.isNotBlank(vo.getDRxrq()))
		{
			rysxXwxx.setDRxrq(DateUtil.parse(vo.getDRxrq(), DateUtil.webFormat));
		}
		if (StringUtil.isNotBlank(vo.getDByrq()))
		{
			rysxXwxx.setDByrq(DateUtil.parse(vo.getDByrq(), DateUtil.webFormat));
		}
		if (StringUtil.isNotBlank(vo.getDSyrq()))
		{
			rysxXwxx.setDSyrq(DateUtil.parse(vo.getDSyrq(), DateUtil.webFormat));
		}
		rysxXwxx.setNXxxs(Integer.parseInt(vo.getNXxxs()));
		if (vo.getNDqxx().equals("1"))
		{
			List<RysxXwxx> listRysxXwxx = rysxXwxxDAO.getXwxxByRybhFy(
					Integer.parseInt(vo.getNRybh()), fydm);
			for (int i = 0; i < listRysxXwxx.size(); i++)
			{
				if (listRysxXwxx.get(i).getNDqxx() == 1
						&& listRysxXwxx.get(i) != rysxXwxx)
				{
					listRysxXwxx.get(i).setNDqxx((short) 2);
					rysxXwxxDAO.updateRsXwxx(listRysxXwxx.get(i));
				}
			}
		}
		rysxXwxxDAO.interceptUpdateXwxx(rysxXwxx);
		XwxxVO xwxxVO = new XwxxVO();
		xwxxVO.setNId(rysxXwxx.getNId().toString());
		xwxxVO.setNFy(rysxXwxx.getNFy().toString());
		xwxxVO.setNRybh(rysxXwxx.getNRybh().toString());
		xwxxVO.setNXw(dmDAO.getDmByMc(rysxXwxx.getNXw(), "学位"));
		xwxxVO.setCSxzy(rysxXwxx.getCSxzy());
		xwxxVO.setNSxzy(dmDAO.getDmByMc(rysxXwxx.getNSxzy(), "专业"));
		xwxxVO.setCXxmc(rysxXwxx.getCXxmc());
		xwxxVO.setNJyxs(dmDAO.getDmByMc(rysxXwxx.getNJyxs(), "教育形式"));
		xwxxVO.setNXxlb(dmDAO.getDmByMc(rysxXwxx.getNXxlb(), "培训机构"));
		xwxxVO.setNXxxs(dmDAO.getDmByMc(rysxXwxx.getNXxxs(), "学习形式"));
		if (rysxXwxx.getDRxrq() != null)
		{
			xwxxVO.setDRxrq(DateUtil.format(rysxXwxx.getDRxrq(),
					DateUtil.webFormat));
		}
		if (rysxXwxx.getDByrq() != null)
		{
			xwxxVO.setDByrq(DateUtil.format(rysxXwxx.getDByrq(),
					DateUtil.webFormat));
		}
		if (rysxXwxx.getNXz() != null)
		{
			xwxxVO.setNXz(rysxXwxx.getNXz().toString());
		}
		xwxxVO.setDSyrq(DateUtil.format(rysxXwxx.getDSyrq(), DateUtil.webFormat));
		xwxxVO.setNSygj(dmDAO.getDmByMc(rysxXwxx.getNSygj(), "国家"));
		xwxxVO.setNDqxx(dmDAO.getDmByMc(rysxXwxx.getNDqxx(), "是否"));
		xwxxVO.setNTbjl(dmDAO.getDmByMc(rysxXwxx.getNTbjl(), "是否"));
		return xwxxVO;
	}

	// 简历信息
	@Override
	public List<JlxxVO> getJlxxByRybhFy(int rybh, int fydm)
	{
		List<RysxJlxx> jlxxList = rysxJlxxDAO.getJlxxByRybhFy(rybh, fydm);
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
		RysxJlxx rysxJlxx = rysxJlxxDAO.getRsJlxxById(id, fydm, rybh);
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
		RysxJlxx rysxJlxx = rysxJlxxDAO.findByFyRybhId(Integer.valueOf(fydm),
				Integer.valueOf(rybh), new BigDecimal(id));
		return rysxJlxxDAO.interceptDeleteRsJlxxById(rysxJlxx);
	}

	
	@Override
	public JlxxVO addJlxx(JlxxVO vo)
	{
		RysxJlxx rysxJlxx = new RysxJlxx();
		int fydm = Integer.valueOf(vo.getNFy());
		rysxJlxx.setNId(rysxTablekeyDAO.getMaxId(fydm, "N_JLXXID"));
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
		rysxJlxxDAO.interceptAddJlxx(rysxJlxx);
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
		RysxJlxx rysxJlxx = rysxJlxxDAO.findByFyRybhId(fydm, rybh, bd);
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
		rysxJlxxDAO.interceptUpdateJlxx(rysxJlxx);
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

	// 家庭信息
	@Override
	public List<JtxxVO> getJtxxByRybhFy(int rybh, int fydm)
	{
		List<RysxJtxx> listRysxJtxx = rysxJtxxDAO.getJtxxByRybhFy(rybh, fydm);
		List<JtxxVO> listJtxx = new ArrayList<JtxxVO>();
		for (int i = 0; i < listRysxJtxx.size(); i++)
		{
			JtxxVO jtxxVO = new JtxxVO();
			jtxxVO.setNId(listRysxJtxx.get(i).getNId().toString());
			jtxxVO.setNFy(listRysxJtxx.get(i).getNFy().toString());
			jtxxVO.setNRybh(listRysxJtxx.get(i).getNRybh().toString());
			jtxxVO.setNYbrgx(dmDAO.getDmByMc(listRysxJtxx.get(i).getNYbrgx(),
					"家庭关系"));
			jtxxVO.setCXm(listRysxJtxx.get(i).getCXm());
			if (listRysxJtxx.get(i).getDCsrq() != null)
			{
				jtxxVO.setDCsrq(DateUtil.format(listRysxJtxx.get(i).getDCsrq(),
						DateUtil.webFormat).toString());
			}
			if (listRysxJtxx.get(i).getNZzmm() != null)
			{
				jtxxVO.setNZzmm(dmDAO.getDmByMc(listRysxJtxx.get(i).getNZzmm(),
						"政治面貌"));
			}
			listJtxx.add(jtxxVO);
		}
		return listJtxx;
	};

	@Override
	public JtxxVO getRsJtxxById(String id, String fydm, String rybh)
	{
		RysxJtxx rysxJtxx = rysxJtxxDAO.getRsJtxxById(id, fydm, rybh);
		JtxxVO jtxxVO = new JtxxVO();
		jtxxVO.setNId(rysxJtxx.getNId().toString());
		jtxxVO.setNFy(rysxJtxx.getNFy().toString());
		jtxxVO.setNRybh(rysxJtxx.getNRybh().toString());
		jtxxVO.setNYbrgx(dmDAO.getDmByMc(rysxJtxx.getNYbrgx(), "家庭关系"));
		jtxxVO.setCXm(rysxJtxx.getCXm());
		if (rysxJtxx.getDCsrq() != null)
		{
			jtxxVO.setDCsrq(DateUtil.format(rysxJtxx.getDCsrq(),
					DateUtil.webFormat).toString());
		}
		jtxxVO.setNZzmm(dmDAO.getDmByMc(rysxJtxx.getNZzmm(), "政治面貌"));
		jtxxVO.setCJtdh(rysxJtxx.getCJtdh());
		jtxxVO.setCYzbm(rysxJtxx.getCYzbm());
		if (rysxJtxx.getNZfmj() != null)
		{
			jtxxVO.setNZfmj(rysxJtxx.getNZfmj().toString());
		}
		jtxxVO.setCJtzz(rysxJtxx.getCJtzz());
		jtxxVO.setCDwjzw(rysxJtxx.getCDwjzw());
		return jtxxVO;
	}

	@Override
	public boolean delRsJtxxById(String id, String fydm, String rybh)
	{
		RysxJtxx rysxJtxx = rysxJtxxDAO.findByFyRybhId(Integer.valueOf(fydm),
				Integer.valueOf(rybh), new BigDecimal(id));
		return rysxJtxxDAO.interceptDeleteRsJtxxById(rysxJtxx);
	}

	
	@Override
	public JtxxVO addJtxx(JtxxVO vo)
	{
		RysxJtxx rysxJtxx = new RysxJtxx();
		int fydm = Integer.valueOf(vo.getNFy());
		rysxJtxx.setNId(rysxTablekeyDAO.getMaxId(fydm, "N_JTXXID"));
		rysxJtxx.setNFy(fydm);
		rysxJtxx.setNRybh(Integer.parseInt(vo.getNRybh()));
		rysxJtxx.setNYbrgx(Integer.parseInt(vo.getNYbrgx()));
		rysxJtxx.setCXm(vo.getCXm());
		if (StringUtil.isNotBlank(vo.getDCsrq()))
		{
			rysxJtxx.setDCsrq(DateUtil.parse(vo.getDCsrq(), DateUtil.webFormat));
		}
		rysxJtxx.setNZzmm(Integer.parseInt(vo.getNZzmm()));
		rysxJtxx.setCJtdh(vo.getCJtdh());
		rysxJtxx.setCYzbm(vo.getCYzbm());
		if (!vo.getNZfmj().equals(""))
		{
			rysxJtxx.setNZfmj(Integer.parseInt(vo.getNZfmj()));
		}
		rysxJtxx.setCJtzz(vo.getCJtzz());
		rysxJtxx.setCDwjzw(vo.getCDwjzw());
		rysxJtxxDAO.interceptAddJtxx(rysxJtxx);
		JtxxVO jtxxVO = new JtxxVO();
		jtxxVO.setNId(rysxJtxx.getNId().toString());
		jtxxVO.setNFy(rysxJtxx.getNFy().toString());
		jtxxVO.setNRybh(rysxJtxx.getNRybh().toString());
		jtxxVO.setNYbrgx(dmDAO.getDmByMc(rysxJtxx.getNYbrgx(), "家庭关系"));
		jtxxVO.setCXm(rysxJtxx.getCXm());
		if (rysxJtxx.getDCsrq() != null)
		{
			jtxxVO.setDCsrq(DateUtil.format(rysxJtxx.getDCsrq(),
					DateUtil.webFormat).toString());
		}
		jtxxVO.setNZzmm(dmDAO.getDmByMc(rysxJtxx.getNZzmm(), "政治面貌"));
		jtxxVO.setCJtdh(rysxJtxx.getCJtdh());
		jtxxVO.setCYzbm(rysxJtxx.getCYzbm());
		if (rysxJtxx.getNZfmj() != null)
		{
			jtxxVO.setNZfmj(rysxJtxx.getNZfmj().toString());
		}
		jtxxVO.setCJtzz(rysxJtxx.getCJtzz());
		jtxxVO.setCDwjzw(rysxJtxx.getCDwjzw());
		return jtxxVO;
	}

	
	@Override
	public JtxxVO updateRsJtxx(JtxxVO vo)
	{
		BigDecimal bd = new BigDecimal(vo.getNId());
		int fydm = Integer.valueOf(vo.getNFy());
		int rybh = Integer.valueOf(vo.getNRybh());
		RysxJtxx rysxJtxx = rysxJtxxDAO.findByFyRybhId(fydm, rybh, bd);
		try
		{
			ObjectByteThreadLocal.setObjectByte(ObjectSerializedUtils
					.writeObjectToMemory(rysxJtxx));
		} catch (Exception ex)
		{
			ex.printStackTrace();
		}
		rysxJtxx.setNYbrgx(Integer.parseInt(vo.getNYbrgx()));
		rysxJtxx.setCXm(vo.getCXm());
		if (StringUtil.isNotBlank(vo.getDCsrq()))
		{
			rysxJtxx.setDCsrq(DateUtil.parse(vo.getDCsrq(), DateUtil.webFormat));
		}
		rysxJtxx.setNZzmm(Integer.parseInt(vo.getNZzmm()));
		rysxJtxx.setCJtdh(vo.getCJtdh());
		rysxJtxx.setCYzbm(vo.getCYzbm());
		if (!vo.getNZfmj().equals(""))
		{
			rysxJtxx.setNZfmj(Integer.parseInt(vo.getNZfmj()));
		} else
		{
			rysxJtxx.setNZfmj(null);
		}
		rysxJtxx.setCJtzz(vo.getCJtzz());
		rysxJtxx.setCDwjzw(vo.getCDwjzw());
		rysxJtxxDAO.interceptUpdateJtxx(rysxJtxx);
		JtxxVO jtxxVO = new JtxxVO();
		jtxxVO.setNId(rysxJtxx.getNId().toString());
		jtxxVO.setNFy(rysxJtxx.getNFy().toString());
		jtxxVO.setNRybh(rysxJtxx.getNRybh().toString());
		jtxxVO.setNYbrgx(dmDAO.getDmByMc(rysxJtxx.getNYbrgx(), "家庭关系"));
		jtxxVO.setCXm(rysxJtxx.getCXm());
		if (rysxJtxx.getDCsrq() != null)
		{
			jtxxVO.setDCsrq(DateUtil.format(rysxJtxx.getDCsrq(),
					DateUtil.webFormat).toString());
		}
		jtxxVO.setNZzmm(dmDAO.getDmByMc(rysxJtxx.getNZzmm(), "政治面貌"));
		jtxxVO.setCJtdh(rysxJtxx.getCJtdh());
		jtxxVO.setCYzbm(rysxJtxx.getCYzbm());
		if (rysxJtxx.getNZfmj() != null)
		{
			jtxxVO.setNZfmj(rysxJtxx.getNZfmj().toString());
		}
		jtxxVO.setCJtzz(rysxJtxx.getCJtzz());
		jtxxVO.setCDwjzw(rysxJtxx.getCDwjzw());
		return jtxxVO;
	}

	// 考核信息
	@Override
	public List<KhxxVO> getKhxxByRybhFy(int rybh, int fydm)
	{
		List<RysxKhxx> listRysxKhxx = rysxKhxxDAO.getKhxxByRybhFy(rybh, fydm);
		List<KhxxVO> listKhxxVO = new ArrayList<KhxxVO>();
		for (int i = 0; i < listRysxKhxx.size(); i++)
		{
			KhxxVO khxxVO = new KhxxVO();
			khxxVO.setNId(listRysxKhxx.get(i).getNId().toString());
			khxxVO.setNFy(listRysxKhxx.get(i).getNFy().toString());
			khxxVO.setNRybh(listRysxKhxx.get(i).getNRybh().toString());
			if (listRysxKhxx.get(i).getNNd() != null)
			{
				khxxVO.setNNd(listRysxKhxx.get(i).getNNd().toString());
			}
			if (listRysxKhxx.get(i).getNKhjg() != null)
			{
				khxxVO.setNKhjg(dmDAO.getDmByMc(listRysxKhxx.get(i).getNKhjg(),
						"考核"));
			}
			listKhxxVO.add(khxxVO);
		}
		return listKhxxVO;
	}

	@Override
	public KhxxVO getRsKhxxById(String id, String fydm, String rybh)
	{
		RysxKhxx rysxKhxx = rysxKhxxDAO.getRsKhxxById(id, fydm, rybh);
		KhxxVO khxxVO = new KhxxVO();
		khxxVO.setNId(rysxKhxx.getNId().toString());
		khxxVO.setNFy(rysxKhxx.getNFy().toString());
		khxxVO.setNRybh(rysxKhxx.getNRybh().toString());
		if (rysxKhxx.getNNd() != null)
		{
			khxxVO.setNNd(rysxKhxx.getNNd().toString());
		}
		if (rysxKhxx.getNKhjg() != null)
		{
			khxxVO.setNKhjg(dmDAO.getDmByMc(rysxKhxx.getNKhjg(), "考核"));
		}
		return khxxVO;
	}

	@Override
	public boolean delRsKhxxById(String id, String fydm, String rybh)
	{
		RysxKhxx rysxKhxx = rysxKhxxDAO.findByFyRybhId(Integer.valueOf(fydm),
				Integer.valueOf(rybh), new BigDecimal(id));
		return rysxKhxxDAO.interceptDeleteRsKhxxById(rysxKhxx);
	}

	@Override
	public KhxxVO addKhxx(KhxxVO vo)
	{
		RysxKhxx rysxKhxx = new RysxKhxx();
		int fydm = Integer.valueOf(vo.getNFy());
		rysxKhxx.setNId(rysxTablekeyDAO.getMaxId(fydm, "N_KHXXID"));
		rysxKhxx.setNFy(fydm);
		rysxKhxx.setNRybh(Integer.parseInt(vo.getNRybh()));
		if (!vo.getNNd().equals(""))
		{
			rysxKhxx.setNNd(Integer.parseInt(vo.getNNd()));
		}
		if (!vo.getNKhjg().equals(""))
		{
			rysxKhxx.setNKhjg(Integer.parseInt(vo.getNKhjg()));
		}
		rysxKhxxDAO.interceptAddKhxx(rysxKhxx);
		KhxxVO khxxVO = new KhxxVO();
		khxxVO.setNId(rysxKhxx.getNId().toString());
		khxxVO.setNFy(rysxKhxx.getNFy().toString());
		khxxVO.setNRybh(rysxKhxx.getNRybh().toString());
		if (rysxKhxx.getNNd() != null)
		{
			khxxVO.setNNd(rysxKhxx.getNNd().toString());
		}
		if (rysxKhxx.getNKhjg() != null)
		{
			khxxVO.setNKhjg(dmDAO.getDmByMc(rysxKhxx.getNKhjg(), "考核"));
		}
		return khxxVO;
	}

	@Override
	public KhxxVO updateRsKhxx(KhxxVO vo)
	{
		BigDecimal bd = new BigDecimal(vo.getNId());
		int fydm = Integer.valueOf(vo.getNFy());
		int rybh = Integer.valueOf(vo.getNRybh());
		RysxKhxx rysxKhxx = rysxKhxxDAO.findByFyRybhId(fydm, rybh, bd);
		try
		{
			ObjectByteThreadLocal.setObjectByte(ObjectSerializedUtils
					.writeObjectToMemory(rysxKhxx));
		} catch (Exception ex)
		{
			ex.printStackTrace();
		}
		rysxKhxx.setNRybh(Integer.parseInt(vo.getNRybh()));
		if (!vo.getNNd().equals(""))
		{
			rysxKhxx.setNNd(Integer.parseInt(vo.getNNd()));
		} else
		{
			rysxKhxx.setNNd(null);
		}
		if (!vo.getNKhjg().equals(""))
		{
			rysxKhxx.setNKhjg(Integer.parseInt(vo.getNKhjg()));
		} else
		{
			rysxKhxx.setNKhjg(null);
		}
		rysxKhxxDAO.interceptUpdateKhxx(rysxKhxx);
		KhxxVO khxxVO = new KhxxVO();
		khxxVO.setNId(rysxKhxx.getNId().toString());
		khxxVO.setNFy(rysxKhxx.getNFy().toString());
		khxxVO.setNRybh(rysxKhxx.getNRybh().toString());
		if (rysxKhxx.getNNd() != null)
		{
			khxxVO.setNNd(rysxKhxx.getNNd().toString());
		}
		if (rysxKhxx.getNKhjg() != null)
		{
			khxxVO.setNKhjg(dmDAO.getDmByMc(rysxKhxx.getNKhjg(), "考核"));
		}
		return khxxVO;
	}

	// 奖励信息
	public List<JlixxVO> getJlixxByRybhFy(int rybh, int fydm)
	{
		List<RysxJianglixx> listJianglixx = rysxJianglixxDAO.getJlixxByRybhFy(
				rybh, fydm);
		List<JlixxVO> listJlixxVO = new ArrayList<JlixxVO>();
		for (int i = 0; i < listJianglixx.size(); i++)
		{
			JlixxVO jlixxVO = new JlixxVO();
			jlixxVO.setNId(listJianglixx.get(i).getNId().toString());
			jlixxVO.setNFy(listJianglixx.get(i).getNFy().toString());
			jlixxVO.setNRybh(listJianglixx.get(i).getNRybh().toString());
			jlixxVO.setNJllb(DmMcCommon.dmMc(listJianglixx.get(i).getNJllb(), ConstantsFyrs.NBXH_GRJLLB, mapNames, dmDAO));
			jlixxVO.setNGrqk(DmMcCommon.dmMc(listJianglixx.get(i).getNGrqk(), ConstantsFyrs.NBXH_GRQK, mapNames, dmDAO));
			jlixxVO.setNJlyy(DmMcCommon.dmMc(listJianglixx.get(i).getNJlyy(), ConstantsFyrs.NBXH_JLYY, mapNames, dmDAO));
			jlixxVO.setNJljb(DmMcCommon.dmMc(listJianglixx.get(i).getNJljb(), ConstantsFyrs.NBXH_JLJB, mapNames, dmDAO));
			
//			
//			jlixxVO.setNJllb(dmDAO.getDmByMc(listJianglixx.get(i).getNJllb(),
//					"个人奖励类别"));
//			jlixxVO.setNJlyy(dmDAO.getDmByMc(listJianglixx.get(i).getNJlyy(),
//					"奖励原因"));
//			jlixxVO.setNGrqk(dmDAO.getDmByMc(listJianglixx.get(i).getNGrqk(),
//					"个人情况"));
//			jlixxVO.setNJljb(dmDAO.getDmByMc(listJianglixx.get(i).getNJljb(),
//					"奖励级别"));
			listJlixxVO.add(jlixxVO);
		}
		return listJlixxVO;
	};

	@Override
	public JlixxVO getRsJlixxById(String id, String fydm, String rybh)
	{
		RysxJianglixx rysxJianglixx = rysxJianglixxDAO.getRsJlixxById(id, fydm,
				rybh);
		JlixxVO jlixxVO = new JlixxVO();
		jlixxVO.setNId(rysxJianglixx.getNId().toString());
		jlixxVO.setNFy(rysxJianglixx.getNFy().toString());
		jlixxVO.setNRybh(rysxJianglixx.getNRybh().toString());
		
		
//		jlixxVO.setNJllb(dmDAO.getDmByMc(rysxJianglixx.getNJllb(), "个人奖励类别"));
//		jlixxVO.setNJlyy(dmDAO.getDmByMc(rysxJianglixx.getNJlyy(), "奖励原因"));
//		jlixxVO.setNGrqk(dmDAO.getDmByMc(rysxJianglixx.getNGrqk(), "个人情况"));
//		jlixxVO.setNJljb(dmDAO.getDmByMc(rysxJianglixx.getNJljb(), "奖励级别"));
		
		jlixxVO.setNJllb(DmMcCommon.dmMc(rysxJianglixx.getNJllb(), ConstantsFyrs.NBXH_GRJLLB, mapNames, dmDAO));
		jlixxVO.setNGrqk(DmMcCommon.dmMc(rysxJianglixx.getNGrqk(), ConstantsFyrs.NBXH_GRQK, mapNames, dmDAO));
		jlixxVO.setNJlyy(DmMcCommon.dmMc(rysxJianglixx.getNJlyy(), ConstantsFyrs.NBXH_JLYY, mapNames, dmDAO));
		jlixxVO.setNJljb(DmMcCommon.dmMc(rysxJianglixx.getNJljb(), ConstantsFyrs.NBXH_JLJB, mapNames, dmDAO));
		
		jlixxVO.setCJllbsm(rysxJianglixx.getCJllbsm());
		jlixxVO.setCJlyyxx(rysxJianglixx.getCJlyyxx());
		jlixxVO.setCPzdw(rysxJianglixx.getCPzdw());
		jlixxVO.setCPzwh(rysxJianglixx.getCPzwh());
		if (rysxJianglixx.getDJlsj() != null)
		{
			jlixxVO.setDJlsj(DateUtil.format(rysxJianglixx.getDJlsj(),
					DateUtil.webFormat).toString());
		}
		return jlixxVO;
	}

	@Override
	public boolean delRsJlixxById(String id, String fydm, String rybh)
	{
		RysxJianglixx rysxJianglixx = rysxJianglixxDAO.findByFyRybhId(
				Integer.valueOf(fydm), Integer.valueOf(rybh),
				new BigDecimal(id));
		return rysxJianglixxDAO.interceptDeleteRsJianglixxById(rysxJianglixx);
	}

	
	@Override
	public JlixxVO addJlixx(JlixxVO vo)
	{
		int fydm = Integer.valueOf(vo.getNFy());
		RysxJianglixx rysxJianglixx = new RysxJianglixx();
		rysxJianglixx.setCJllbsm(vo.getCJllbsm());
		rysxJianglixx.setCJlyyxx(vo.getCJlyyxx());
		rysxJianglixx.setCPzdw(vo.getCPzdw());
		rysxJianglixx.setCPzwh(vo.getCPzwh());
		if (StringUtil.isNotBlank(vo.getDJlsj()))
		{
			rysxJianglixx.setDJlsj(DateUtil.parse(vo.getDJlsj(), DateUtil.webFormat));
		}
		rysxJianglixx.setNFy(fydm);
		rysxJianglixx.setNGrqk(Integer.parseInt(vo.getNGrqk()));
		rysxJianglixx.setNId(rysxTablekeyDAO.getMaxId(fydm, "N_JIANGLIXXID"));
		rysxJianglixx.setNJljb(Integer.parseInt(vo.getNJljb()));
		rysxJianglixx.setNJllb(Integer.parseInt(vo.getNJllb()));
		rysxJianglixx.setNJlyy(Integer.parseInt(vo.getNJlyy()));
		rysxJianglixx.setNRybh(Integer.parseInt(vo.getNRybh()));
		rysxJianglixxDAO.interceptAddJianglixx(rysxJianglixx);
		JlixxVO jlixxVO = new JlixxVO();
		jlixxVO.setNId(rysxJianglixx.getNId().toString());
		jlixxVO.setNFy(rysxJianglixx.getNFy().toString());
		jlixxVO.setNRybh(rysxJianglixx.getNRybh().toString());
//		jlixxVO.setNJllb(dmDAO.getDmByMc(rysxJianglixx.getNJllb(), "个人奖励类别"));
//		jlixxVO.setNJlyy(dmDAO.getDmByMc(rysxJianglixx.getNJlyy(), "奖励原因"));
//		jlixxVO.setNGrqk(dmDAO.getDmByMc(rysxJianglixx.getNGrqk(), "个人情况"));
//		jlixxVO.setNJljb(dmDAO.getDmByMc(rysxJianglixx.getNJljb(), "奖励级别"));
		
		jlixxVO.setNJllb(DmMcCommon.dmMc(rysxJianglixx.getNJllb(), ConstantsFyrs.NBXH_GRJLLB, mapNames, dmDAO));
		jlixxVO.setNGrqk(DmMcCommon.dmMc(rysxJianglixx.getNGrqk(), ConstantsFyrs.NBXH_GRQK, mapNames, dmDAO));
		jlixxVO.setNJlyy(DmMcCommon.dmMc(rysxJianglixx.getNJlyy(), ConstantsFyrs.NBXH_JLYY, mapNames, dmDAO));
		jlixxVO.setNJljb(DmMcCommon.dmMc(rysxJianglixx.getNJljb(), ConstantsFyrs.NBXH_JLJB, mapNames, dmDAO));
		
		jlixxVO.setCJllbsm(rysxJianglixx.getCJllbsm());
		jlixxVO.setCJlyyxx(rysxJianglixx.getCJlyyxx());
		jlixxVO.setCPzdw(rysxJianglixx.getCPzdw());
		jlixxVO.setCPzwh(rysxJianglixx.getCPzwh());
		if (rysxJianglixx.getDJlsj() != null)
		{
			jlixxVO.setDJlsj(DateUtil.format(rysxJianglixx.getDJlsj(),
					DateUtil.webFormat).toString());
		}
		return jlixxVO;
	}

	
	@Override
	public JlixxVO updateRsJlixx(JlixxVO vo)
	{
		BigDecimal bd = new BigDecimal(vo.getNId());
		int fydm = Integer.valueOf(vo.getNFy());
		int rybh = Integer.valueOf(vo.getNRybh());
		RysxJianglixx rysxJianglixx = rysxJianglixxDAO.findByFyRybhId(fydm,
				rybh, bd);
		try
		{
			ObjectByteThreadLocal.setObjectByte(ObjectSerializedUtils
					.writeObjectToMemory(rysxJianglixx));
		} catch (Exception ex)
		{
			ex.printStackTrace();
		}
		rysxJianglixx.setCJllbsm(vo.getCJllbsm());
		rysxJianglixx.setCJlyyxx(vo.getCJlyyxx());
		rysxJianglixx.setCPzdw(vo.getCPzdw());
		rysxJianglixx.setCPzwh(vo.getCPzwh());
		if (StringUtil.isNotBlank(vo.getDJlsj()))
		{
			rysxJianglixx.setDJlsj(DateUtil.parse(vo.getDJlsj(), DateUtil.webFormat));
		}
		rysxJianglixx.setNGrqk(Integer.parseInt(vo.getNGrqk()));
		rysxJianglixx.setNJljb(Integer.parseInt(vo.getNJljb()));
		rysxJianglixx.setNJllb(Integer.parseInt(vo.getNJllb()));
		rysxJianglixx.setNJlyy(Integer.parseInt(vo.getNJlyy()));
		rysxJianglixxDAO.interceptUpdateJianglixx(rysxJianglixx);
		JlixxVO jlixxVO = new JlixxVO();
		jlixxVO.setNId(rysxJianglixx.getNId().toString());
		jlixxVO.setNFy(rysxJianglixx.getNFy().toString());
		jlixxVO.setNRybh(rysxJianglixx.getNRybh().toString());
//		jlixxVO.setNJllb(dmDAO.getDmByMc(rysxJianglixx.getNJllb(), "个人奖励类别"));
//		jlixxVO.setNJlyy(dmDAO.getDmByMc(rysxJianglixx.getNJlyy(), "奖励原因"));
//		jlixxVO.setNGrqk(dmDAO.getDmByMc(rysxJianglixx.getNGrqk(), "个人情况"));
//		jlixxVO.setNJljb(dmDAO.getDmByMc(rysxJianglixx.getNJljb(), "奖励级别"));
		
		jlixxVO.setNJllb(DmMcCommon.dmMc(rysxJianglixx.getNJllb(), ConstantsFyrs.NBXH_GRJLLB, mapNames, dmDAO));
		jlixxVO.setNGrqk(DmMcCommon.dmMc(rysxJianglixx.getNGrqk(), ConstantsFyrs.NBXH_GRQK, mapNames, dmDAO));
		jlixxVO.setNJlyy(DmMcCommon.dmMc(rysxJianglixx.getNJlyy(), ConstantsFyrs.NBXH_JLYY, mapNames, dmDAO));
		jlixxVO.setNJljb(DmMcCommon.dmMc(rysxJianglixx.getNJljb(), ConstantsFyrs.NBXH_JLJB, mapNames, dmDAO));
		
		jlixxVO.setCJllbsm(rysxJianglixx.getCJllbsm());
		jlixxVO.setCJlyyxx(rysxJianglixx.getCJlyyxx());
		jlixxVO.setCPzdw(rysxJianglixx.getCPzdw());
		jlixxVO.setCPzwh(rysxJianglixx.getCPzwh());
		if (rysxJianglixx.getDJlsj() != null)
		{
			jlixxVO.setDJlsj(DateUtil.format(rysxJianglixx.getDJlsj(),
					DateUtil.webFormat).toString());
		}
		return jlixxVO;
	}

	// 司法考试
	@Override
	public List<SfksVO> getSfksByRybhFy(int rybh, int fydm)
	{
		List<RysxSfks> listRysxSfks = rysxSfksDAO.getSfksByRybhFy(rybh, fydm);
		List<SfksVO> listSfksVO = new ArrayList<SfksVO>();
		for (int i = 0; i < listRysxSfks.size(); i++)
		{
			SfksVO sfksVO = new SfksVO();
			sfksVO.setNId(listRysxSfks.get(i).getNId().toString());
			sfksVO.setNFy(listRysxSfks.get(i).getNFy().toString());
			sfksVO.setNRybh(listRysxSfks.get(i).getNRybh().toString());
			sfksVO.setCZsbh(listRysxSfks.get(i).getCZsbh());
			if (listRysxSfks.get(i).getDBzrq() != null)
			{
				sfksVO.setDBzrq(DateUtil.format(listRysxSfks.get(i).getDBzrq(),
						DateUtil.webFormat).toString());
			}
			sfksVO.setNZslx(dmDAO.getDmByMc(listRysxSfks.get(i).getNZslx(),
					"法律职业资格证书类型").toString());
			listSfksVO.add(sfksVO);
		}
		return listSfksVO;
	};

	@Override
	public SfksVO getRsSfksById(String id, String fydm, String rybh)
	{
		RysxSfks rysxSfks = rysxSfksDAO.getRsSfksById(id, fydm, rybh);
		SfksVO sfksVO = new SfksVO();
		sfksVO.setNId(rysxSfks.getNId().toString());
		sfksVO.setNFy(rysxSfks.getNFy().toString());
		sfksVO.setNRybh(rysxSfks.getNRybh().toString());
		sfksVO.setCZsbh(rysxSfks.getCZsbh());
		if (rysxSfks.getDBzrq() != null)
		{
			sfksVO.setDBzrq(DateUtil.format(rysxSfks.getDBzrq(),
					DateUtil.webFormat).toString());
		}
		sfksVO.setNZslx(dmDAO.getDmByMc(rysxSfks.getNZslx(), "法律职业资格证书类型")
				.toString());
		return sfksVO;
	}

	@Override
	public boolean delRsSfksById(String id, String fydm, String rybh)
	{
		RysxSfks rysxSfks = rysxSfksDAO.findByFyRybhId(Integer.valueOf(fydm),
				Integer.valueOf(rybh), new BigDecimal(id));
		return rysxSfksDAO.interceptDeleteRsSfksById(rysxSfks);
	}

	
	@Override
	public SfksVO addSfks(SfksVO vo)
	{
		int fydm = Integer.valueOf(vo.getNFy());
		RysxSfks rysxSfks = new RysxSfks();
		rysxSfks.setCZsbh(vo.getCZsbh());
		if (StringUtil.isNotBlank(vo.getDBzrq()))
		{
			rysxSfks.setDBzrq(DateUtil.parse(vo.getDBzrq(), DateUtil.webFormat));
		}
		rysxSfks.setNFy(fydm);
		rysxSfks.setNId(rysxTablekeyDAO.getMaxId(fydm, "N_SFKSID"));
		rysxSfks.setNRybh(Integer.parseInt(vo.getNRybh()));
		rysxSfks.setNZslx(Integer.parseInt(vo.getNZslx()));
		rysxSfksDAO.interceptAddSfks(rysxSfks);
		SfksVO sfksVO = new SfksVO();
		sfksVO.setNId(rysxSfks.getNId().toString());
		sfksVO.setNFy(rysxSfks.getNFy().toString());
		sfksVO.setNRybh(rysxSfks.getNRybh().toString());
		sfksVO.setCZsbh(rysxSfks.getCZsbh());
		if (rysxSfks.getDBzrq() != null)
		{
			sfksVO.setDBzrq(DateUtil.format(rysxSfks.getDBzrq(),
					DateUtil.webFormat).toString());
		}
		sfksVO.setNZslx(dmDAO.getDmByMc(rysxSfks.getNZslx(), "法律职业资格证书类型")
				.toString());
		return sfksVO;
	}

	
	@Override
	public SfksVO updateRsSfks(SfksVO vo)
	{
		BigDecimal bd = new BigDecimal(vo.getNId());
		int fydm = Integer.valueOf(vo.getNFy());
		int rybh = Integer.valueOf(vo.getNRybh());
		RysxSfks rysxSfks = rysxSfksDAO.findByFyRybhId(fydm, rybh, bd);
		try
		{
			ObjectByteThreadLocal.setObjectByte(ObjectSerializedUtils
					.writeObjectToMemory(rysxSfks));
		} catch (Exception ex)
		{
			ex.printStackTrace();
		}
		rysxSfks.setCZsbh(vo.getCZsbh());
		if (StringUtil.isNotBlank(vo.getDBzrq()))
		{
			rysxSfks.setDBzrq(DateUtil.parse(vo.getDBzrq(), DateUtil.webFormat));
		}
		rysxSfks.setNZslx(Integer.parseInt(vo.getNZslx()));
		rysxSfksDAO.interceptUpdateSfks(rysxSfks);
		SfksVO sfksVO = new SfksVO();
		sfksVO.setNId(rysxSfks.getNId().toString());
		sfksVO.setNFy(rysxSfks.getNFy().toString());
		sfksVO.setNRybh(rysxSfks.getNRybh().toString());
		sfksVO.setCZsbh(rysxSfks.getCZsbh());
		if (rysxSfks.getDBzrq() != null)
		{
			sfksVO.setDBzrq(DateUtil.format(rysxSfks.getDBzrq(),
					DateUtil.webFormat).toString());
		}
		sfksVO.setNZslx(dmDAO.getDmByMc(rysxSfks.getNZslx(), "法律职业资格证书类型")
				.toString());
		return sfksVO;
	}

	// 交流信息
	@Override
	public List<JliuxxVO> getJliuxxByRybhFy(int rybh, int fydm)
	{
		List<RysxJiaoliuxx> listrysxJiaoliuxx = rysxJiaoliuxxDAO
				.getJiaoliuxxByRybhFy(rybh, fydm);
		List<JliuxxVO> listJliuxxVO = new ArrayList<JliuxxVO>();
		for (int i = 0; i < listrysxJiaoliuxx.size(); i++)
		{
			JliuxxVO jliuxxVO = new JliuxxVO();
			jliuxxVO.setNId(listrysxJiaoliuxx.get(i).getNId().toString());
			jliuxxVO.setNFy(listrysxJiaoliuxx.get(i).getNFy().toString());
			jliuxxVO.setNRybh(listrysxJiaoliuxx.get(i).getNRybh().toString());
			jliuxxVO.setNJllb(dmDAO.getDmByMc(listrysxJiaoliuxx.get(i)
					.getNJllb(), "交流类别"));
			jliuxxVO.setNJlfs(dmDAO.getDmByMc(listrysxJiaoliuxx.get(i)
					.getNJlfs(), "交流方式"));
			jliuxxVO.setNJlzwxz(dmDAO.getDmByMc(listrysxJiaoliuxx.get(i)
					.getNJlzwxz(), "交流职务"));
			if (listrysxJiaoliuxx.get(i).getDKsrq() != null)
			{
				jliuxxVO.setDKsrq(DateUtil
						.format(listrysxJiaoliuxx.get(i).getDKsrq(),
								DateUtil.webFormat).toString());
			}
			if (listrysxJiaoliuxx.get(i).getDJsrq() != null)
			{
				jliuxxVO.setDJsrq(DateUtil
						.format(listrysxJiaoliuxx.get(i).getDJsrq(),
								DateUtil.webFormat).toString());
			}
			listJliuxxVO.add(jliuxxVO);
		}
		return listJliuxxVO;
	}

	@Override
	public JliuxxVO getRsJliuxxById(String id, String fydm, String rybh)
	{
		RysxJiaoliuxx rysxJiaoliuxx = rysxJiaoliuxxDAO.getRsJliuxxById(id,
				fydm, rybh);
		JliuxxVO jliuxxVO = new JliuxxVO();
		jliuxxVO.setNId(rysxJiaoliuxx.getNId().toString());
		jliuxxVO.setNFy(rysxJiaoliuxx.getNFy().toString());
		jliuxxVO.setNRybh(rysxJiaoliuxx.getNRybh().toString());
		jliuxxVO.setNJllb(dmDAO.getDmByMc(rysxJiaoliuxx.getNJllb(), "交流类别"));
		jliuxxVO.setNJlfs(dmDAO.getDmByMc(rysxJiaoliuxx.getNJlfs(), "交流方式"));
		jliuxxVO.setNJlzwxz(dmDAO.getDmByMc(rysxJiaoliuxx.getNJlzwxz(), "交流职务"));
		if (rysxJiaoliuxx.getDKsrq() != null)
		{
			jliuxxVO.setDKsrq(DateUtil.format(rysxJiaoliuxx.getDKsrq(),
					DateUtil.webFormat).toString());
		}
		if (rysxJiaoliuxx.getDJsrq() != null)
		{
			jliuxxVO.setDJsrq(DateUtil.format(rysxJiaoliuxx.getDJsrq(),
					DateUtil.webFormat).toString());
		}
		jliuxxVO.setCJlzwmc(rysxJiaoliuxx.getCJlzwmc());
		jliuxxVO.setCJlgzbm(rysxJiaoliuxx.getCJlgzbm());
		jliuxxVO.setCJlgzdw(rysxJiaoliuxx.getCJlgzdw());
		jliuxxVO.setNTbjl(dmDAO.getDmByMc(rysxJiaoliuxx.getNTbjl(), "是否"));
		return jliuxxVO;
	}

	@Override
	public boolean delRsJliuxxById(String id, String fydm, String rybh)
	{
		RysxJiaoliuxx rysxJliuxx = rysxJiaoliuxxDAO.findByFyRybhId(
				Integer.valueOf(fydm), Integer.valueOf(rybh),
				new BigDecimal(id));
		return rysxJiaoliuxxDAO.interceptDeleteRsJiaoliuxxById(rysxJliuxx);
	}

	
	@Override
	public JliuxxVO addJliuxx(JliuxxVO vo)
	{
		int fydm = Integer.valueOf(vo.getNFy());
		RysxJiaoliuxx rysxJiaoliuxx = new RysxJiaoliuxx();
		rysxJiaoliuxx.setCJlgzbm(vo.getCJlgzbm());
		rysxJiaoliuxx.setCJlgzdw(vo.getCJlgzdw());
		rysxJiaoliuxx.setCJlzwmc(vo.getCJlzwmc());
		if (StringUtil.isNotBlank(vo.getDJsrq()))
		{
			rysxJiaoliuxx.setDJsrq(DateUtil.parse(vo.getDJsrq(), DateUtil.webFormat));
		}
		if (StringUtil.isNotBlank(vo.getDKsrq()))
		{
			rysxJiaoliuxx.setDKsrq(DateUtil.parse(vo.getDKsrq(), DateUtil.webFormat));
		}
		rysxJiaoliuxx.setNFy(fydm);
		rysxJiaoliuxx.setNId(rysxTablekeyDAO.getMaxId(fydm, "N_JIAOLIUXXID"));
		rysxJiaoliuxx.setNJlfs(Integer.parseInt(vo.getNJlfs()));
		rysxJiaoliuxx.setNJllb(Integer.parseInt(vo.getNJllb()));
		rysxJiaoliuxx.setNJlzwxz(Integer.parseInt(vo.getNJlzwxz()));
		rysxJiaoliuxx.setNRybh(Integer.parseInt(vo.getNRybh()));
		rysxJiaoliuxx.setNTbjl(Short.parseShort(vo.getNTbjl()));
		if (vo.getNTbjl().equals("1"))
		{
			JlxxVO jlxxVO = new JlxxVO();
			jlxxVO.setNFy(vo.getNFy());
			jlxxVO.setNRybh(vo.getNRybh());
			jlxxVO.setCZmr("");
			jlxxVO.setCSzdw("");
			jlxxVO.setCSzbm("");
			jlxxVO.setDQsrq(vo.getDKsrq());
			jlxxVO.setDJzrq(vo.getDJsrq());
			jlxxVO.setCZj("");
			jlxxVO.setCZw(dmDAO.getDmByMc(rysxJiaoliuxx.getNJlzwxz(), "交流职务"));
			addJlxx(jlxxVO);
		}
		rysxJiaoliuxxDAO.interceptAddRsJiaoliuxx(rysxJiaoliuxx);
		JliuxxVO jliuxxVO = new JliuxxVO();
		jliuxxVO.setNId(rysxJiaoliuxx.getNId().toString());
		jliuxxVO.setNFy(rysxJiaoliuxx.getNFy().toString());
		jliuxxVO.setNRybh(rysxJiaoliuxx.getNRybh().toString());
		jliuxxVO.setNJllb(dmDAO.getDmByMc(rysxJiaoliuxx.getNJllb(), "交流类别"));
		jliuxxVO.setNJlfs(dmDAO.getDmByMc(rysxJiaoliuxx.getNJlfs(), "交流方式"));
		jliuxxVO.setNJlzwxz(dmDAO.getDmByMc(rysxJiaoliuxx.getNJlzwxz(), "交流职务"));
		if (rysxJiaoliuxx.getDKsrq() != null)
		{
			jliuxxVO.setDKsrq(DateUtil.format(rysxJiaoliuxx.getDKsrq(),
					DateUtil.webFormat).toString());
		}
		if (rysxJiaoliuxx.getDJsrq() != null)
		{
			jliuxxVO.setDJsrq(DateUtil.format(rysxJiaoliuxx.getDJsrq(),
					DateUtil.webFormat).toString());
		}
		jliuxxVO.setCJlzwmc(rysxJiaoliuxx.getCJlzwmc());
		jliuxxVO.setCJlgzbm(rysxJiaoliuxx.getCJlgzbm());
		jliuxxVO.setCJlgzdw(rysxJiaoliuxx.getCJlgzdw());
		jliuxxVO.setNTbjl(dmDAO.getDmByMc(rysxJiaoliuxx.getNTbjl(), "是否"));
		return jliuxxVO;
	}

	@Override
	public JliuxxVO updateRsJliuxx(JliuxxVO vo)
	{
		BigDecimal bd = new BigDecimal(vo.getNId());
		int fydm = Integer.valueOf(vo.getNFy());
		int rybh = Integer.valueOf(vo.getNRybh());
		RysxJiaoliuxx rysxJiaoliuxx = rysxJiaoliuxxDAO.findByFyRybhId(fydm,
				rybh, bd);
		try
		{
			ObjectByteThreadLocal.setObjectByte(ObjectSerializedUtils
					.writeObjectToMemory(rysxJiaoliuxx));
		} catch (Exception ex)
		{
			ex.printStackTrace();
		}
		rysxJiaoliuxx.setCJlgzbm(vo.getCJlgzbm());
		rysxJiaoliuxx.setCJlgzdw(vo.getCJlgzdw());
		rysxJiaoliuxx.setCJlzwmc(vo.getCJlzwmc());
		if (StringUtil.isNotBlank(vo.getDJsrq()))
		{
			rysxJiaoliuxx.setDJsrq(DateUtil.parse(vo.getDJsrq(), DateUtil.webFormat));
		}
		if (StringUtil.isNotBlank(vo.getDKsrq()))
		{
			rysxJiaoliuxx.setDKsrq(DateUtil.parse(vo.getDKsrq(), DateUtil.webFormat));
		}
		rysxJiaoliuxx.setNJlfs(Integer.parseInt(vo.getNJlfs()));
		rysxJiaoliuxx.setNJllb(Integer.parseInt(vo.getNJllb()));
		rysxJiaoliuxx.setNJlzwxz(Integer.parseInt(vo.getNJlzwxz()));
		rysxJiaoliuxx.setNTbjl(Short.parseShort(vo.getNTbjl()));
		rysxJiaoliuxxDAO.interceptUpdateRsJiaoliuxx(rysxJiaoliuxx);
		JliuxxVO jliuxxVO = new JliuxxVO();
		jliuxxVO.setNId(rysxJiaoliuxx.getNId().toString());
		jliuxxVO.setNFy(rysxJiaoliuxx.getNFy().toString());
		jliuxxVO.setNRybh(rysxJiaoliuxx.getNRybh().toString());
		jliuxxVO.setNJllb(dmDAO.getDmByMc(rysxJiaoliuxx.getNJllb(), "交流类别"));
		jliuxxVO.setNJlfs(dmDAO.getDmByMc(rysxJiaoliuxx.getNJlfs(), "交流方式"));
		jliuxxVO.setNJlzwxz(dmDAO.getDmByMc(rysxJiaoliuxx.getNJlzwxz(), "交流职务"));
		if (rysxJiaoliuxx.getDKsrq() != null)
		{
			jliuxxVO.setDKsrq(DateUtil.format(rysxJiaoliuxx.getDKsrq(),
					DateUtil.webFormat).toString());
		}
		if (rysxJiaoliuxx.getDJsrq() != null)
		{
			jliuxxVO.setDJsrq(DateUtil.format(rysxJiaoliuxx.getDJsrq(),
					DateUtil.webFormat).toString());
		}
		jliuxxVO.setCJlzwmc(rysxJiaoliuxx.getCJlzwmc());
		jliuxxVO.setCJlgzbm(rysxJiaoliuxx.getCJlgzbm());
		jliuxxVO.setCJlgzdw(rysxJiaoliuxx.getCJlgzdw());
		jliuxxVO.setNTbjl(dmDAO.getDmByMc(rysxJiaoliuxx.getNTbjl(), "是否"));
		return jliuxxVO;
	}

	// 培训信息
	@Override
	public List<PxxxVO> getPxxxByRybhFy(int rybh, int fydm)
	{
		List<RysxPxxx> listRysxPxxx = rysxPxxxDAO.getPxxxByRybhFy(rybh, fydm);
		List<PxxxVO> listPxxxVO = new ArrayList<PxxxVO>();
		for (int i = 0; i < listRysxPxxx.size(); i++)
		{
			PxxxVO pxxxVO = new PxxxVO();
			pxxxVO.setNId(listRysxPxxx.get(i).getNId().toString());
			pxxxVO.setNFy(listRysxPxxx.get(i).getNFy().toString());
			pxxxVO.setNRybh(listRysxPxxx.get(i).getNRybh().toString());
			pxxxVO.setNPxxs(dmDAO.getDmByMc(listRysxPxxx.get(i).getNPxxs(),
					"学习形式"));
			pxxxVO.setCPxbmc(listRysxPxxx.get(i).getCPxbmc());
			if (listRysxPxxx.get(i).getDKsrq() != null)
			{
				pxxxVO.setDKsrq(DateUtil.format(listRysxPxxx.get(i).getDKsrq(),
						DateUtil.webFormat).toString());
			}
			if (listRysxPxxx.get(i).getDJsrq() != null)
			{
				pxxxVO.setDJsrq(DateUtil.format(listRysxPxxx.get(i).getDJsrq(),
						DateUtil.webFormat).toString());
			}
			if (listRysxPxxx.get(i).getNZy() != null)
			{
				pxxxVO.setNZy(dmDAO.getDmByMc(listRysxPxxx.get(i).getNZy(),
						"专业"));
			}
			listPxxxVO.add(pxxxVO);
		}
		return listPxxxVO;
	}

	@Override
	public PxxxVO getRsPxxxById(String id, String fydm, String rybh)
	{
		RysxPxxx rysxPxxx = rysxPxxxDAO.getRsPxxxById(id, fydm, rybh);
		PxxxVO pxxxVO = new PxxxVO();
		pxxxVO.setNId(rysxPxxx.getNId().toString());
		pxxxVO.setNFy(rysxPxxx.getNFy().toString());
		pxxxVO.setNRybh(rysxPxxx.getNRybh().toString());
		pxxxVO.setNPxfs(dmDAO.getDmByMc(rysxPxxx.getNPxfs(), "培训方式"));
		pxxxVO.setCPxbmc(rysxPxxx.getCPxbmc());
		if (rysxPxxx.getDKsrq() != null)
		{
			pxxxVO.setDKsrq(DateUtil.format(rysxPxxx.getDKsrq(),
					DateUtil.webFormat).toString());
		}
		if (rysxPxxx.getDJsrq() != null)
		{
			pxxxVO.setDJsrq(DateUtil.format(rysxPxxx.getDJsrq(),
					DateUtil.webFormat).toString());
		}
		pxxxVO.setNZy(dmDAO.getDmByMc(rysxPxxx.getNZy(), "专业"));
		pxxxVO.setCPxbmc(rysxPxxx.getCPxbmc());
		pxxxVO.setCPxcj(rysxPxxx.getCPxcj());
		pxxxVO.setCPxjg(rysxPxxx.getCPxjg());
		pxxxVO.setCQtjglb(rysxPxxx.getCPxjg());
		pxxxVO.setCQtpxxs(rysxPxxx.getCQtpxxs());
		pxxxVO.setNJglb(dmDAO.getDmByMc(rysxPxxx.getNJglb(), "培训机构"));
		pxxxVO.setNPxxs(dmDAO.getDmByMc(rysxPxxx.getNPxxs(), "学习形式"));
		pxxxVO.setNPxzl(dmDAO.getDmByMc(rysxPxxx.getNPxzl(), "培训种类"));
		pxxxVO.setNSfqdzs(dmDAO.getDmByMc(rysxPxxx.getNSfqdzs(), "是否"));
		if (rysxPxxx.getNTbjl() != null)
		{
			pxxxVO.setNTbjl(dmDAO.getDmByMc(rysxPxxx.getNTbjl(), "是否"));
		}
		if (rysxPxxx.getNXz() != null)
		{
			pxxxVO.setNXz(rysxPxxx.getNXz().toString());
		}
		return pxxxVO;
	}

	@Override
	public boolean delRsPxxxById(String id, String fydm, String rybh)
	{
		RysxPxxx rysxPxxx = rysxPxxxDAO.findByFyRybhId(Integer.valueOf(fydm),
				Integer.valueOf(rybh), new BigDecimal(id));
		return rysxPxxxDAO.interceptDeleteRsPxxxById(rysxPxxx);
	}

	
	@Override
	public PxxxVO addPxxx(PxxxVO vo)
	{
		int fydm = Integer.valueOf(vo.getNFy());
		RysxPxxx rysxPxxx = new RysxPxxx();
		rysxPxxx.setCPxbmc(vo.getCPxbmc());
		rysxPxxx.setCPxcj(vo.getCPxcj());
		rysxPxxx.setCPxjg(vo.getCPxjg());
		rysxPxxx.setCQtjglb(vo.getCQtjglb());
		rysxPxxx.setCQtpxxs(vo.getCQtpxxs());
		if (StringUtil.isNotBlank(vo.getDJsrq()))
		{
			rysxPxxx.setDJsrq(DateUtil.parse(vo.getDJsrq(), DateUtil.webFormat));
		}
		if (StringUtil.isNotBlank(vo.getDKsrq()))
		{
			rysxPxxx.setDKsrq(DateUtil.parse(vo.getDKsrq(), DateUtil.webFormat));
		}
		rysxPxxx.setNFy(fydm);
		rysxPxxx.setNId(rysxTablekeyDAO.getMaxId(fydm, "N_PXXXID"));
		rysxPxxx.setNJglb(Integer.parseInt(vo.getNJglb()));
		rysxPxxx.setNPxfs(Integer.parseInt(vo.getNPxfs()));
		rysxPxxx.setNPxxs(Integer.parseInt(vo.getNPxxs()));
		rysxPxxx.setNPxzl(Integer.parseInt(vo.getNPxzl()));
		rysxPxxx.setNRybh(Integer.parseInt(vo.getNRybh()));
		rysxPxxx.setNSfqdzs(Short.parseShort(vo.getNSfqdzs()));
		if (!vo.getNTbjl().equals(""))
		{
			rysxPxxx.setNTbjl(Short.parseShort(vo.getNTbjl()));
		}
		if (!vo.getNXz().equals(""))
		{
			rysxPxxx.setNXz(Short.parseShort(vo.getNXz()));
		}
		rysxPxxx.setNZy(Integer.parseInt(vo.getNZy()));
		if (vo.getNTbjl().equals("1"))
		{
			JlxxVO jlxxVO = new JlxxVO();
			jlxxVO.setNFy(vo.getNFy());
			jlxxVO.setNRybh(vo.getNRybh());
			jlxxVO.setCZmr("");
			jlxxVO.setCSzdw("");
			jlxxVO.setCSzbm("");
			jlxxVO.setDQsrq(vo.getDKsrq());
			jlxxVO.setDJzrq(vo.getDJsrq());
			jlxxVO.setCZj("");
			jlxxVO.setCZw(dmDAO.getDmByMc(rysxPxxx.getNZy(), "专业"));
			addJlxx(jlxxVO);
		}
		rysxPxxxDAO.interceptAddPxxx(rysxPxxx);
		PxxxVO pxxxVO = new PxxxVO();
		pxxxVO.setNId(rysxPxxx.getNId().toString());
		pxxxVO.setNFy(rysxPxxx.getNFy().toString());
		pxxxVO.setNRybh(rysxPxxx.getNRybh().toString());
		pxxxVO.setNPxxs(dmDAO.getDmByMc(rysxPxxx.getNPxxs(), "学习形式"));
		pxxxVO.setCPxbmc(rysxPxxx.getCPxbmc());
		if (rysxPxxx.getDKsrq() != null)
		{
			pxxxVO.setDKsrq(DateUtil.format(rysxPxxx.getDKsrq(),
					DateUtil.webFormat).toString());
		}
		if (rysxPxxx.getDJsrq() != null)
		{
			pxxxVO.setDJsrq(DateUtil.format(rysxPxxx.getDJsrq(),
					DateUtil.webFormat).toString());
		}
		if (rysxPxxx.getNZy() != null)
		{
			pxxxVO.setNZy(dmDAO.getDmByMc(rysxPxxx.getNZy(), "专业"));
		}
		pxxxVO.setCPxbmc(rysxPxxx.getCPxbmc());
		pxxxVO.setCPxcj(rysxPxxx.getCPxcj());
		pxxxVO.setCPxjg(rysxPxxx.getCPxjg());
		pxxxVO.setCQtjglb(rysxPxxx.getCPxjg());
		pxxxVO.setCQtpxxs(rysxPxxx.getCQtpxxs());
		pxxxVO.setNJglb(dmDAO.getDmByMc(rysxPxxx.getNJglb(), "培训机构"));
		pxxxVO.setNPxfs(dmDAO.getDmByMc(rysxPxxx.getNPxfs(), "培训方式"));
		pxxxVO.setNPxzl(dmDAO.getDmByMc(rysxPxxx.getNPxzl(), "培训种类"));
		pxxxVO.setNSfqdzs(dmDAO.getDmByMc(rysxPxxx.getNSfqdzs(), "是否"));
		if (rysxPxxx.getNTbjl() != null)
		{
			pxxxVO.setNTbjl(dmDAO.getDmByMc(rysxPxxx.getNTbjl(), "是否"));
		}
		if (rysxPxxx.getNXz() != null)
		{
			pxxxVO.setNXz(rysxPxxx.getNXz().toString());
		}
		return pxxxVO;
	}

	
	@Override
	public PxxxVO updateRsPxxx(PxxxVO vo)
	{
		BigDecimal bd = new BigDecimal(vo.getNId());
		int fydm = Integer.valueOf(vo.getNFy());
		int rybh = Integer.valueOf(vo.getNRybh());
		RysxPxxx rysxPxxx = rysxPxxxDAO.findByFyRybhId(fydm, rybh, bd);
		try
		{
			ObjectByteThreadLocal.setObjectByte(ObjectSerializedUtils
					.writeObjectToMemory(rysxPxxx));
		} catch (Exception ex)
		{
			ex.printStackTrace();
		}
		rysxPxxx.setCPxbmc(vo.getCPxbmc());
		rysxPxxx.setCPxcj(vo.getCPxcj());
		rysxPxxx.setCPxjg(vo.getCPxjg());
		rysxPxxx.setCQtjglb(vo.getCQtjglb());
		rysxPxxx.setCQtpxxs(vo.getCQtpxxs());
		if (StringUtil.isNotBlank(vo.getDJsrq()))
		{
			rysxPxxx.setDJsrq(DateUtil.parse(vo.getDJsrq(), DateUtil.webFormat));
		}
		if (StringUtil.isNotBlank(vo.getDKsrq()))
		{
			rysxPxxx.setDKsrq(DateUtil.parse(vo.getDKsrq(), DateUtil.webFormat));
		}
		rysxPxxx.setNJglb(Integer.parseInt(vo.getNJglb()));
		rysxPxxx.setNPxfs(Integer.parseInt(vo.getNPxfs()));
		rysxPxxx.setNPxxs(Integer.parseInt(vo.getNPxxs()));
		rysxPxxx.setNPxzl(Integer.parseInt(vo.getNPxzl()));
		rysxPxxx.setNSfqdzs(Short.parseShort(vo.getNSfqdzs()));
		if (!vo.getNTbjl().equals(""))
		{
			rysxPxxx.setNTbjl(Short.parseShort(vo.getNTbjl()));
		} else
		{
			rysxPxxx.setNTbjl(null);
		}
		if (!vo.getNXz().equals(""))
		{
			rysxPxxx.setNXz(Short.parseShort(vo.getNXz()));
		} else
		{
			rysxPxxx.setNXz(null);
		}
		rysxPxxx.setNZy(Integer.parseInt(vo.getNZy()));
		rysxPxxxDAO.interceptUpdatePxxx(rysxPxxx);
		PxxxVO pxxxVO = new PxxxVO();
		pxxxVO.setNId(rysxPxxx.getNId().toString());
		pxxxVO.setNFy(rysxPxxx.getNFy().toString());
		pxxxVO.setNRybh(rysxPxxx.getNRybh().toString());
		pxxxVO.setNPxxs(dmDAO.getDmByMc(rysxPxxx.getNPxxs(), "学习形式"));
		pxxxVO.setCPxbmc(rysxPxxx.getCPxbmc());
		if (rysxPxxx.getDKsrq() != null)
		{
			pxxxVO.setDKsrq(DateUtil.format(rysxPxxx.getDKsrq(),
					DateUtil.webFormat).toString());
		}
		if (rysxPxxx.getDJsrq() != null)
		{
			pxxxVO.setDJsrq(DateUtil.format(rysxPxxx.getDJsrq(),
					DateUtil.webFormat).toString());
		}
		pxxxVO.setNZy(dmDAO.getDmByMc(rysxPxxx.getNZy(), "专业"));
		pxxxVO.setCPxbmc(rysxPxxx.getCPxbmc());
		pxxxVO.setCPxcj(rysxPxxx.getCPxcj());
		pxxxVO.setCPxjg(rysxPxxx.getCPxjg());
		pxxxVO.setCQtjglb(rysxPxxx.getCPxjg());
		pxxxVO.setCQtpxxs(rysxPxxx.getCQtpxxs());
		pxxxVO.setNJglb(dmDAO.getDmByMc(rysxPxxx.getNJglb(), "培训机构"));
		pxxxVO.setNPxfs(dmDAO.getDmByMc(rysxPxxx.getNPxfs(), "培训方式"));
		pxxxVO.setNPxzl(dmDAO.getDmByMc(rysxPxxx.getNPxzl(), "培训种类"));
		pxxxVO.setNSfqdzs(dmDAO.getDmByMc(rysxPxxx.getNSfqdzs(), "是否"));
		if (rysxPxxx.getNTbjl() != null)
		{
			pxxxVO.setNTbjl(dmDAO.getDmByMc(rysxPxxx.getNTbjl(), "是否"));
		}
		if (rysxPxxx.getNXz() != null)
		{
			pxxxVO.setNXz(rysxPxxx.getNXz().toString());
		}
		return pxxxVO;
	}

	// 人才信息
	@Override
	public List<RcxxVO> getRcxxByRybhFy(int rybh, int fydm)
	{
		List<RykRc> listRykRc = rykRcDAO.getRcxxByRybhFy(rybh, fydm);
		List<RcxxVO> listRcxxVO = new ArrayList<RcxxVO>();
		for (int i = 0; i < listRykRc.size(); i++)
		{
			RcxxVO rcxxVO = new RcxxVO();
			rcxxVO.setNBm(dmDAO.getDmByMc(listRykRc.get(i).getNBm(), "内设机构"));
			rcxxVO.setNFy(listRykRc.get(i).getNFy().toString());
			rcxxVO.setNId(listRykRc.get(i).getNId().toString());
			rcxxVO.setNRclx(dmDAO
					.getDmByMc(listRykRc.get(i).getNRclx(), "人才信息"));
			rcxxVO.setNRybh(listRykRc.get(i).getNRybh().toString());
			rcxxVO.setCPzwh(listRykRc.get(i).getCPzwh());
			rcxxVO.setCPzdw(listRykRc.get(i).getCPzdw());
			rcxxVO.setCPzbm(listRykRc.get(i).getCPzbm());
			if(listRykRc.get(i).getDPzsj() != null){
				rcxxVO.setDPzsj(DateUtil.format(listRykRc.get(i).getDPzsj(), DateUtil.webFormat));
			}else{
				rcxxVO.setDPzsj("");
			}
			listRcxxVO.add(rcxxVO);
		}
		return listRcxxVO;
	}

	@Override
	public RcxxVO getRsRcxxById(String id, String fydm, String rybh)
	{
		RykRc rykRcxx = rykRcDAO.getRsRcxxById(id, fydm, rybh);
		RcxxVO rcxxVO = new RcxxVO();
		rcxxVO.setNBm(dmDAO.getDmByMc(rykRcxx.getNBm(), "内设机构"));
		rcxxVO.setNFy(rykRcxx.getNFy().toString());
		rcxxVO.setNId(rykRcxx.getNId().toString());
		rcxxVO.setNRclx(dmDAO.getDmByMc(rykRcxx.getNRclx(), "人才信息"));
		rcxxVO.setNRybh(rykRcxx.getNRybh().toString());
		rcxxVO.setCPzwh(rykRcxx.getCPzwh());
		rcxxVO.setCPzdw(rykRcxx.getCPzdw());
		rcxxVO.setCPzbm(rykRcxx.getCPzbm());
		if(rykRcxx.getDPzsj() != null){
			rcxxVO.setDPzsj(DateUtil.format(rykRcxx.getDPzsj(), DateUtil.webFormat));
		}else{
			rcxxVO.setDPzsj("");
		}
		return rcxxVO;
	}

	@Override
	public boolean delRsRcxxById(String id, String fydm, String rybh)
	{
		RykRc rykRc = rykRcDAO.findByFyRybhId(Integer.valueOf(fydm),
				Integer.valueOf(rybh), Integer.valueOf(id));
		return rykRcDAO.interceptDeleteRsRcxxById(rykRc);
	}

	@Override
	public RcxxVO addRcxx(RcxxVO vo)
	{
		RykRc rykRc = new RykRc();
		int fydm = Integer.valueOf(vo.getNFy());
		rykRc.setNBm(Integer.parseInt(vo.getNBm()));
		rykRc.setNFy(fydm);
		rykRc.setNId(rysxTablekeyDAO.getMaxId(fydm, "N_RCXXID").intValue());
		rykRc.setNRclx(Integer.parseInt(vo.getNRclx()));
		rykRc.setNRybh(Integer.parseInt(vo.getNRybh()));
		rykRc.setNSfls(0);
		rykRc.setCPzbm(vo.getCPzbm());
		rykRc.setCPzdw(vo.getCPzdw());
		rykRc.setCPzwh(vo.getCPzwh());
		if(StringUtil.isNotBlank(vo.getDPzsj())){
			rykRc.setDPzsj(DateUtil.parse(vo.getDPzsj(), DateUtil.webFormat));
		}else{
			rykRc.setDPzsj(DateUtil.today());
		}
		
		rykRcDAO.interceptAddRcxx(rykRc);
		RcxxVO rcxxVO = new RcxxVO();
		rcxxVO.setNBm(dmDAO.getDmByMc(rykRc.getNBm(), "内设机构"));
		rcxxVO.setNFy(rykRc.getNFy().toString());
		rcxxVO.setNId(rykRc.getNId().toString());
		rcxxVO.setNRclx(dmDAO.getDmByMc(rykRc.getNRclx(), "人才信息"));
		rcxxVO.setNRybh(rykRc.getNRybh().toString());
		rcxxVO.setCPzwh(rykRc.getCPzwh());
		rcxxVO.setCPzdw(rykRc.getCPzdw());
		rcxxVO.setCPzbm(rykRc.getCPzbm());
		if(rykRc.getDPzsj() != null){
			rcxxVO.setDPzsj(DateUtil.format(rykRc.getDPzsj(), DateUtil.webFormat));
		}else{
			rcxxVO.setDPzsj("");
		}
		return rcxxVO;
	}

	@Override
	public RcxxVO updateRsRcxx(RcxxVO vo)
	{
		int bd = Integer.valueOf(vo.getNId());
		int fydm = Integer.valueOf(vo.getNFy());
		int rybh = Integer.valueOf(vo.getNRybh());
		RykRc rykRc = rykRcDAO.findByFyRybhId(fydm, rybh, bd);
		try
		{
			ObjectByteThreadLocal.setObjectByte(ObjectSerializedUtils
					.writeObjectToMemory(rykRc));
		} catch (Exception ex)
		{
			ex.printStackTrace();
		}
		rykRc.setNBm(Integer.parseInt(vo.getNBm()));
		rykRc.setNRclx(Integer.parseInt(vo.getNRclx()));
		rykRc.setCPzbm(vo.getCPzbm());
		rykRc.setCPzdw(vo.getCPzdw());
		rykRc.setCPzwh(vo.getCPzwh());
		if(StringUtil.isNotBlank(vo.getDPzsj())){
			rykRc.setDPzsj(DateUtil.parse(vo.getDPzsj(), DateUtil.webFormat));
		}else{
			rykRc.setDPzsj(DateUtil.today());
		}
		rykRcDAO.interceptUpdateRcxx(rykRc);
		RcxxVO rcxxVO = new RcxxVO();
		rcxxVO.setNBm(dmDAO.getDmByMc(rykRc.getNBm(), "内设机构"));
		rcxxVO.setNFy(rykRc.getNFy().toString());
		rcxxVO.setNId(rykRc.getNId().toString());
		rcxxVO.setNRclx(dmDAO.getDmByMc(rykRc.getNRclx(), "人才信息"));
		rcxxVO.setNRybh(rykRc.getNRybh().toString());
		rcxxVO.setCPzwh(rykRc.getCPzwh());
		rcxxVO.setCPzdw(rykRc.getCPzdw());
		rcxxVO.setCPzbm(rykRc.getCPzbm());
		if(rykRc.getDPzsj() != null){
			rcxxVO.setDPzsj(DateUtil.format(rykRc.getDPzsj(), DateUtil.webFormat));
		}else{
			rcxxVO.setDPzsj("");
		}
		return rcxxVO;
	}

	// 等级信息
	@Override
	public List<DjxxVO> getDjxxByRybhFy(int rybh, int fydm)
	{
		List<RysxDjxx> listRysxDjxx = rysxDjxxDAO.getDjxxByRybhFy(rybh, fydm);
		List<DjxxVO> listDjxxVO = new ArrayList<DjxxVO>();
		for (int i = 0; i < listRysxDjxx.size(); i++)
		{
			DjxxVO djxxVO = new DjxxVO();
			djxxVO.setNId(listRysxDjxx.get(i).getNId().toString());
			djxxVO.setNFy(listRysxDjxx.get(i).getNFy().toString());
			djxxVO.setNRybh(listRysxDjxx.get(i).getNRybh().toString());

			djxxVO.setCBdyj(listRysxDjxx.get(i).getCBdyj());
			djxxVO.setCPzdw(listRysxDjxx.get(i).getCPzdw());
			djxxVO.setCZsbh(listRysxDjxx.get(i).getCZsbh());
			if (listRysxDjxx.get(i).getDQsrq() != null)
			{
				djxxVO.setDQsrq(DateUtil.format(listRysxDjxx.get(i).getDQsrq(),
						DateUtil.webFormat).toString());
			}
			if(listRysxDjxx.get(i).getNBdlb()!=null){
				djxxVO.setNBdlb(dmDAO.getDmByMc(listRysxDjxx.get(i).getNBdlb(),
						"等级变动类别"));
			}
			if(listRysxDjxx.get(i).getNBdyy()!=null){
				djxxVO.setNBdyy(dmDAO.getDmByMc(listRysxDjxx.get(i).getNBdyy(),
						"等级变动原因"));
			}
			djxxVO.setNDjlb(dmDAO.getDmByMc(listRysxDjxx.get(i).getNDjlb(),
					"等级类别"));
			djxxVO.setNDjmc(dmDAO.getDmByMc(listRysxDjxx.get(i).getNDjmc(),
					"等级"));
			djxxVO.setNDqxx(dmDAO.getDmByMc(listRysxDjxx.get(i).getNDqxx(),
					"是否"));
			listDjxxVO.add(djxxVO);
		}
		return listDjxxVO;
	};

	@Override
	public DjxxVO getRsDjxxById(String id, String fydm, String rybh)
	{
		RysxDjxx rysxDjxx = rysxDjxxDAO.getRsDjxxById(id, fydm, rybh);
		DjxxVO djxxVO = new DjxxVO();
		djxxVO.setNId(rysxDjxx.getNId().toString());
		djxxVO.setNFy(rysxDjxx.getNFy().toString());
		djxxVO.setNRybh(rysxDjxx.getNRybh().toString());
		djxxVO.setCBdyj(rysxDjxx.getCBdyj());
		djxxVO.setCPzdw(rysxDjxx.getCPzdw());
		djxxVO.setCZsbh(rysxDjxx.getCZsbh());
		djxxVO.setCPzwh(rysxDjxx.getCPzwh());
		if (rysxDjxx.getDQsrq() != null)
		{
			djxxVO.setDQsrq(DateUtil.format(rysxDjxx.getDQsrq(),
					DateUtil.webFormat).toString());
		}
		if(rysxDjxx.getNBdlb()!=null){
			djxxVO.setNBdlb(dmDAO.getDmByMc(rysxDjxx.getNBdlb(), "等级变动类别"));
		}
		if(rysxDjxx.getNBdyy()!=null){
			djxxVO.setNBdyy(dmDAO.getDmByMc(rysxDjxx.getNBdyy(), "等级变动原因"));
		}
		djxxVO.setNDjlb(dmDAO.getDmByMc(rysxDjxx.getNDjlb(), "等级类别"));
		djxxVO.setNDjmc(dmDAO.getDmByMc(rysxDjxx.getNDjmc(), "等级"));
		djxxVO.setNDqxx(dmDAO.getDmByMc(rysxDjxx.getNDqxx(), "是否"));
		return djxxVO;
	}

	@Override
	public boolean delRsDjxxById(String id, String fydm, String rybh)
	{
		RysxDjxx rysxDjxx = rysxDjxxDAO.findByFyRybhId(Integer.valueOf(fydm),
				Integer.valueOf(rybh), new BigDecimal(id));
		return rysxDjxxDAO.interceptDeleteRsDjxxById(rysxDjxx);
	}

	
	@Override
	public DjxxVO addDjxx(DjxxVO vo)
	{
		int fydm = Integer.valueOf(vo.getNFy());
		RysxDjxx rysxDjxx = new RysxDjxx();
		rysxDjxx.setCBdyj(vo.getCBdyj());
		rysxDjxx.setCPzdw(vo.getCPzdw());
		rysxDjxx.setCPzwh(vo.getCPzwh());
		rysxDjxx.setCZsbh(vo.getCZsbh());
		if (StringUtil.isNotBlank(vo.getDQsrq()))
		{
			rysxDjxx.setDQsrq(DateUtil.parse(vo.getDQsrq(), DateUtil.webFormat));
		}
		rysxDjxx.setNBdlb(Integer.parseInt(vo.getNBdlb()));
		rysxDjxx.setNBdyy(Integer.parseInt(vo.getNBdyy()));
		rysxDjxx.setNDjlb(Integer.parseInt(vo.getNDjlb()));
		rysxDjxx.setNDjmc(Integer.parseInt(vo.getNDjmc()));
		rysxDjxx.setNDqxx(Short.parseShort(vo.getNDqxx()));
		rysxDjxx.setNFy(fydm);
		rysxDjxx.setNId(rysxTablekeyDAO.getMaxId(fydm, "N_DJXXID"));
		rysxDjxx.setNRybh(Integer.parseInt(vo.getNRybh()));
		if (vo.getNDqxx().equals("1"))
		{
			List<RysxDjxx> listRysxDjxx = rysxDjxxDAO.getDjxxByRybhFy(
					Integer.parseInt(vo.getNRybh()), fydm);
			for (int i = 0; i < listRysxDjxx.size(); i++)
			{
				if (listRysxDjxx.get(i).getNDqxx() == 1)
				{
					listRysxDjxx.get(i).setNDqxx((short) 2);
					rysxDjxxDAO.updateRsDjxx(listRysxDjxx.get(i));
				}
			}
		}
		rysxDjxxDAO.interceptAddDjxx(rysxDjxx);
		DjxxVO djxxVO = new DjxxVO();
		djxxVO.setNId(rysxDjxx.getNId().toString());
		djxxVO.setNFy(rysxDjxx.getNFy().toString());
		djxxVO.setNRybh(rysxDjxx.getNRybh().toString());
		djxxVO.setCBdyj(rysxDjxx.getCBdyj());
		djxxVO.setCPzdw(rysxDjxx.getCPzdw());
		djxxVO.setCZsbh(rysxDjxx.getCZsbh());
		djxxVO.setCPzwh(rysxDjxx.getCPzwh());
		if (rysxDjxx.getDQsrq() != null)
		{
			djxxVO.setDQsrq(DateUtil.format(rysxDjxx.getDQsrq(),
					DateUtil.webFormat).toString());
		}
		djxxVO.setNBdlb(dmDAO.getDmByMc(rysxDjxx.getNBdlb(), "等级变动类别"));
		djxxVO.setNBdyy(dmDAO.getDmByMc(rysxDjxx.getNBdyy(), "等级变动原因"));
		djxxVO.setNDjlb(dmDAO.getDmByMc(rysxDjxx.getNDjlb(), "等级类别"));
		djxxVO.setNDjmc(dmDAO.getDmByMc(rysxDjxx.getNDjmc(), "等级"));
		djxxVO.setNDqxx(dmDAO.getDmByMc(rysxDjxx.getNDqxx(), "是否"));
		return djxxVO;
	}

	
	@Override
	public DjxxVO updateRsDjxx(DjxxVO vo)
	{
		BigDecimal bd = new BigDecimal(vo.getNId());
		int fydm = Integer.valueOf(vo.getNFy());
		int rybh = Integer.valueOf(vo.getNRybh());
		RysxDjxx rysxDjxx = rysxDjxxDAO.findByFyRybhId(fydm, rybh, bd);
		try
		{
			ObjectByteThreadLocal.setObjectByte(ObjectSerializedUtils
					.writeObjectToMemory(rysxDjxx));
		} catch (Exception ex)
		{
			ex.printStackTrace();
		}
		rysxDjxx.setCBdyj(vo.getCBdyj());
		rysxDjxx.setCPzdw(vo.getCPzdw());
		rysxDjxx.setCPzwh(vo.getCPzwh());
		rysxDjxx.setCZsbh(vo.getCZsbh());
		if (StringUtil.isNotBlank(vo.getDQsrq()))
		{
			rysxDjxx.setDQsrq(DateUtil.parse(vo.getDQsrq(), DateUtil.webFormat));
		}
		rysxDjxx.setNBdlb(Integer.parseInt(vo.getNBdlb()));
		rysxDjxx.setNBdyy(Integer.parseInt(vo.getNBdyy()));
		rysxDjxx.setNDjlb(Integer.parseInt(vo.getNDjlb()));
		rysxDjxx.setNDjmc(Integer.parseInt(vo.getNDjmc()));
		rysxDjxx.setNDqxx(Short.parseShort(vo.getNDqxx()));
		if (vo.getNDqxx().equals("1"))
		{
			List<RysxDjxx> listRysxDjxx = rysxDjxxDAO.getDjxxByRybhFy(
					Integer.parseInt(vo.getNRybh()), fydm);
			for (int i = 0; i < listRysxDjxx.size(); i++)
			{
				if (listRysxDjxx.get(i).getNDqxx() == 1
						&& listRysxDjxx.get(i) != rysxDjxx)
				{
					listRysxDjxx.get(i).setNDqxx((short) 2);
					rysxDjxxDAO.updateRsDjxx(listRysxDjxx.get(i));
				}
			}
		}
		rysxDjxxDAO.interceptUpdateDjxx(rysxDjxx);
		DjxxVO djxxVO = new DjxxVO();
		djxxVO.setNId(rysxDjxx.getNId().toString());
		djxxVO.setNFy(rysxDjxx.getNFy().toString());
		djxxVO.setNRybh(rysxDjxx.getNRybh().toString());
		djxxVO.setCBdyj(rysxDjxx.getCBdyj());
		djxxVO.setCPzdw(rysxDjxx.getCPzdw());
		djxxVO.setCZsbh(rysxDjxx.getCZsbh());
		djxxVO.setCPzwh(rysxDjxx.getCPzwh());
		if (rysxDjxx.getDQsrq() != null)
		{
			djxxVO.setDQsrq(DateUtil.format(rysxDjxx.getDQsrq(),
					DateUtil.webFormat).toString());
		}
		djxxVO.setNBdlb(dmDAO.getDmByMc(rysxDjxx.getNBdlb(), "等级变动类别"));
		djxxVO.setNBdyy(dmDAO.getDmByMc(rysxDjxx.getNBdyy(), "等级变动原因"));
		djxxVO.setNDjlb(dmDAO.getDmByMc(rysxDjxx.getNDjlb(), "等级类别"));
		djxxVO.setNDjmc(dmDAO.getDmByMc(rysxDjxx.getNDjmc(), "等级"));
		djxxVO.setNDqxx(dmDAO.getDmByMc(rysxDjxx.getNDqxx(), "是否"));
		return djxxVO;
	}

	// 公务员级别
	@Override
	public List<GwyjbVO> getGwyjbByRybhFy(int rybh, int fydm)
	{
		List<RysxGwy> listRysxGwy = rysxGwyDAO.getGwyjbByRybhFy(rybh, fydm);
		List<GwyjbVO> listGwyjbVO = new ArrayList<GwyjbVO>();
		for (int i = 0; i < listRysxGwy.size(); i++)
		{
			GwyjbVO gwyjbVO = new GwyjbVO();
			gwyjbVO.setCDw(listRysxGwy.get(i).getCDw());
			if (listRysxGwy.get(i).getDQsrq() != null)
			{
				gwyjbVO.setDQsrq(DateUtil.format(listRysxGwy.get(i).getDQsrq(),
						DateUtil.webFormat).toString());
			}
			gwyjbVO.setNDqxx(dmDAO.getDmByMc(listRysxGwy.get(i).getNDqxx(),
					"是否"));
			gwyjbVO.setNFy(listRysxGwy.get(i).getNFy().toString());
			gwyjbVO.setNGwyjb(dmDAO.getDmByMc(listRysxGwy.get(i).getNGwyjb(),
					"公务员级别"));
			gwyjbVO.setNId(listRysxGwy.get(i).getNId().toString());
			gwyjbVO.setNGzdc(dmDAO.getDmByMc(listRysxGwy.get(i).getNGzdc(),
					"工资档次"));
			gwyjbVO.setNRybh(listRysxGwy.get(i).getNRybh().toString());
			listGwyjbVO.add(gwyjbVO);
		}
		return listGwyjbVO;
	}

	@Override
	public GwyjbVO getRsGwyjbById(String id, String fydm, String rybh)
	{
		RysxGwy rysxGwy = rysxGwyDAO.getRsGwyjbById(id, fydm, rybh);
		GwyjbVO gwyjbVO = new GwyjbVO();
		gwyjbVO.setCDw(rysxGwy.getCDw());
		if (rysxGwy.getDQsrq() != null)
		{
			gwyjbVO.setDQsrq(DateUtil.format(rysxGwy.getDQsrq(),
					DateUtil.webFormat).toString());
		}
		gwyjbVO.setNDqxx(dmDAO.getDmByMc(rysxGwy.getNDqxx(), "是否"));
		gwyjbVO.setNFy(rysxGwy.getNFy().toString());
		gwyjbVO.setNGwyjb(dmDAO.getDmByMc(rysxGwy.getNGwyjb(), "公务员级别"));
		gwyjbVO.setNId(rysxGwy.getNId().toString());
		gwyjbVO.setNGzdc(dmDAO.getDmByMc(rysxGwy.getNGzdc(), "工资档次"));
		gwyjbVO.setNRybh(rysxGwy.getNRybh().toString());
		return gwyjbVO;
	}

	@Override
	public boolean delRsGwyjbById(String id, String fydm, String rybh)
	{
		RysxGwy rysxGwy = rysxGwyDAO.findByFyRybhId(Integer.valueOf(fydm),
				Integer.valueOf(rybh), new BigDecimal(id));
		return rysxGwyDAO.interceptDeleteRsGwyById(rysxGwy);
	}

	
	@Override
	public GwyjbVO addGwyjb(GwyjbVO vo)
	{
		int fydm = Integer.valueOf(vo.getNFy());
		RysxGwy rysxGwy = new RysxGwy();
		rysxGwy.setCDw(vo.getCDw());
		if (StringUtil.isNotBlank(vo.getDQsrq()))
		{
			rysxGwy.setDQsrq(DateUtil.parse(vo.getDQsrq(), DateUtil.webFormat));
		}
		rysxGwy.setNDqxx(Short.parseShort(vo.getNDqxx()));
		rysxGwy.setNFy(fydm);
		rysxGwy.setNGwyjb(Integer.parseInt(vo.getNGwyjb()));
		rysxGwy.setNGzdc(Integer.parseInt(vo.getNGzdc()));
		rysxGwy.setNId(rysxTablekeyDAO.getMaxId(fydm, "N_GWYID"));
		rysxGwy.setNRybh(Integer.parseInt(vo.getNRybh()));
		if (vo.getNDqxx().equals("1"))
		{
			List<RysxGwy> listRysxGwy = rysxGwyDAO.getGwyjbByRybhFy(
					Integer.parseInt(vo.getNRybh()), fydm);
			for (int i = 0; i < listRysxGwy.size(); i++)
			{
				if (listRysxGwy.get(i).getNDqxx() == 1)
				{
					listRysxGwy.get(i).setNDqxx((short) 2);
					rysxGwyDAO.updateRsGwyjb(listRysxGwy.get(i));
				}
			}
		}
		rysxGwyDAO.interceptAddGwy(rysxGwy);
		GwyjbVO gwyjbVO = new GwyjbVO();
		gwyjbVO.setCDw(rysxGwy.getCDw());
		if (rysxGwy.getDQsrq() != null)
		{
			gwyjbVO.setDQsrq(DateUtil.format(rysxGwy.getDQsrq(),
					DateUtil.webFormat).toString());
		}
		gwyjbVO.setNDqxx(dmDAO.getDmByMc(rysxGwy.getNDqxx(), "是否"));
		gwyjbVO.setNFy(rysxGwy.getNFy().toString());
		gwyjbVO.setNGwyjb(dmDAO.getDmByMc(rysxGwy.getNGwyjb(), "公务员级别"));
		gwyjbVO.setNId(rysxGwy.getNId().toString());
		gwyjbVO.setNGzdc(dmDAO.getDmByMc(rysxGwy.getNGzdc(), "工资档次"));
		gwyjbVO.setNRybh(rysxGwy.getNRybh().toString());
		return gwyjbVO;
	}

	@Override
	public GwyjbVO updateRsGwyjb(GwyjbVO vo)
	{
		BigDecimal bd = new BigDecimal(vo.getNId());
		int fydm = Integer.valueOf(vo.getNFy());
		int rybh = Integer.valueOf(vo.getNRybh());
		RysxGwy rysxGwy = rysxGwyDAO.findByFyRybhId(fydm, rybh, bd);
		try
		{
			ObjectByteThreadLocal.setObjectByte(ObjectSerializedUtils
					.writeObjectToMemory(rysxGwy));
		} catch (Exception ex)
		{
			ex.printStackTrace();
		}
		rysxGwy.setCDw(vo.getCDw());
		if (StringUtil.isNotBlank(vo.getDQsrq()))
		{
			rysxGwy.setDQsrq(DateUtil.parse(vo.getDQsrq(), DateUtil.webFormat));
		}
		rysxGwy.setNDqxx(Short.parseShort(vo.getNDqxx()));
		rysxGwy.setNGwyjb(Integer.parseInt(vo.getNGwyjb()));
		rysxGwy.setNGzdc(Integer.parseInt(vo.getNGzdc()));
		if (vo.getNDqxx().equals("1"))
		{
			List<RysxGwy> listRysxGwy = rysxGwyDAO.getGwyjbByRybhFy(
					Integer.parseInt(vo.getNRybh()), fydm);
			for (int i = 0; i < listRysxGwy.size(); i++)
			{
				if (listRysxGwy.get(i).getNDqxx() == 1
						&& listRysxGwy.get(i) != rysxGwy)
				{
					listRysxGwy.get(i).setNDqxx((short) 2);
					rysxGwyDAO.updateRsGwyjb(listRysxGwy.get(i));
				}
			}
		}
		rysxGwyDAO.interceptUpdateGwy(rysxGwy);
		GwyjbVO gwyjbVO = new GwyjbVO();
		gwyjbVO.setCDw(rysxGwy.getCDw());
		if (rysxGwy.getDQsrq() != null)
		{
			gwyjbVO.setDQsrq(DateUtil.format(rysxGwy.getDQsrq(),
					DateUtil.webFormat).toString());
		}
		gwyjbVO.setNDqxx(dmDAO.getDmByMc(rysxGwy.getNDqxx(), "是否"));
		gwyjbVO.setNFy(rysxGwy.getNFy().toString());
		gwyjbVO.setNGwyjb(dmDAO.getDmByMc(rysxGwy.getNGwyjb(), "公务员级别"));
		gwyjbVO.setNId(rysxGwy.getNId().toString());
		gwyjbVO.setNGzdc(dmDAO.getDmByMc(rysxGwy.getNGzdc(), "工资档次"));
		gwyjbVO.setNRybh(rysxGwy.getNRybh().toString());
		return gwyjbVO;
	}

	// 专业技术职务
	@Override
	public List<ZyjszwVO> getZyjszwByRybhFy(int rybh, int fydm)
	{
		List<RysxZyjszw> listRysxZyjszw = rysxZyjszwDAO.getZyjszwByRybhFy(rybh,
				fydm);
		List<ZyjszwVO> listZyjszwVO = new ArrayList<ZyjszwVO>();
		for (int i = 0; i < listRysxZyjszw.size(); i++)
		{
			ZyjszwVO zyjszwVO = new ZyjszwVO();
			if (listRysxZyjszw.get(i).getDPrrq() != null)
			{
				zyjszwVO.setDPrrq(DateUtil.format(
						listRysxZyjszw.get(i).getDPrrq(), DateUtil.webFormat)
						.toString());
			}
			if (listRysxZyjszw.get(i).getDQdrq() != null)
			{
				zyjszwVO.setDQdrq(DateUtil.format(
						listRysxZyjszw.get(i).getDQdrq(), DateUtil.webFormat)
						.toString());
			}
			zyjszwVO.setNFy(listRysxZyjszw.get(i).getNFy().toString());
			zyjszwVO.setNId(listRysxZyjszw.get(i).getNId().toString());
			if(listRysxZyjszw.get(i).getNPrmc()!=null){
				zyjszwVO.setNPrmc(dmDAO.getDmByMc(listRysxZyjszw.get(i).getNPrmc(),
						"聘任名称"));
			}
			zyjszwVO.setNQdmc(dmDAO.getDmByMc(listRysxZyjszw.get(i).getNQdmc(),
					"聘任名称"));
			zyjszwVO.setNQdtj(dmDAO.getDmByMc(listRysxZyjszw.get(i).getNQdtj(),
					"专业技术途径"));
			zyjszwVO.setNRybh(listRysxZyjszw.get(i).getNRybh().toString());
			if(listRysxZyjszw.get(i).getNZcdj()!=null){
				zyjszwVO.setNZcdj(dmDAO.getDmByMc(listRysxZyjszw.get(i).getNZcdj(),
						"职称等级"));
			}
			listZyjszwVO.add(zyjszwVO);
		}
		return listZyjszwVO;
	};

	@Override
	public ZyjszwVO getRsZyjszwById(String id, String fydm, String rybh)
	{
		RysxZyjszw rysxZyjszw = rysxZyjszwDAO.getRsZyjszwById(id, fydm, rybh);
		ZyjszwVO zyjszwVO = new ZyjszwVO();
		if (rysxZyjszw.getDPrrq() != null)
		{
			zyjszwVO.setDPrrq(DateUtil.format(rysxZyjszw.getDPrrq(),
					DateUtil.webFormat).toString());
		}
		if (rysxZyjszw.getDQdrq() != null)
		{
			zyjszwVO.setDQdrq(DateUtil.format(rysxZyjszw.getDQdrq(),
					DateUtil.webFormat).toString());
		}
		zyjszwVO.setNFy(rysxZyjszw.getNFy().toString());
		zyjszwVO.setNId(rysxZyjszw.getNId().toString());
		zyjszwVO.setNPrmc(dmDAO.getDmByMc(rysxZyjszw.getNPrmc(), "聘任名称"));
		zyjszwVO.setNQdmc(dmDAO.getDmByMc(rysxZyjszw.getNQdmc(), "聘任名称"));
		zyjszwVO.setNQdtj(dmDAO.getDmByMc(rysxZyjszw.getNQdtj(), "专业技术途径"));
		zyjszwVO.setNRybh(rysxZyjszw.getNRybh().toString());
		if(rysxZyjszw.getNZcdj()!=null){
			zyjszwVO.setNZcdj(dmDAO.getDmByMc(rysxZyjszw.getNZcdj(), "职称等级"));
		}
		return zyjszwVO;
	}

	@Override
	public boolean delRsZyjszwById(String id, String fydm, String rybh)
	{
		RysxZyjszw rysxZyjszw = rysxZyjszwDAO.findByFyRybhId(
				Integer.valueOf(fydm), Integer.valueOf(rybh),
				new BigDecimal(id));
		return rysxZyjszwDAO.interceptDeleteRsZyjszwById(rysxZyjszw);
	}

	
	@Override
	public ZyjszwVO addZyjszw(ZyjszwVO vo)
	{
		int fydm = Integer.valueOf(vo.getNFy());
		RysxZyjszw rysxZyjszw = new RysxZyjszw();
		if (StringUtil.isNotBlank(vo.getDPrrq()))
		{
			rysxZyjszw.setDPrrq(DateUtil.parse(vo.getDPrrq(), DateUtil.webFormat));
		}
		if (StringUtil.isNotBlank(vo.getDQdrq()))
		{
			rysxZyjszw.setDQdrq(DateUtil.parse(vo.getDQdrq(), DateUtil.webFormat));
		}
		rysxZyjszw.setNFy(fydm);
		rysxZyjszw.setNId(rysxTablekeyDAO.getMaxId(fydm, "N_ZYJSZWID"));
		rysxZyjszw.setNPrmc(Integer.parseInt(vo.getNPrmc()));
		rysxZyjszw.setNQdmc(Integer.parseInt(vo.getNQdmc()));
		rysxZyjszw.setNQdtj(Integer.parseInt(vo.getNQdtj()));
		rysxZyjszw.setNRybh(Integer.parseInt(vo.getNRybh()));
		rysxZyjszw.setNZcdj(Integer.parseInt(vo.getNZcdj()));
		rysxZyjszwDAO.interceptAddZyjszw(rysxZyjszw);
		ZyjszwVO zyjszwVO = new ZyjszwVO();
		if (rysxZyjszw.getDPrrq() != null)
		{
			zyjszwVO.setDPrrq(DateUtil.format(rysxZyjszw.getDPrrq(),
					DateUtil.webFormat).toString());
		}
		if (rysxZyjszw.getDQdrq() != null)
		{
			zyjszwVO.setDQdrq(DateUtil.format(rysxZyjszw.getDQdrq(),
					DateUtil.webFormat).toString());
		}
		zyjszwVO.setNFy(rysxZyjszw.getNFy().toString());
		zyjszwVO.setNId(rysxZyjszw.getNId().toString());
		zyjszwVO.setNPrmc(dmDAO.getDmByMc(rysxZyjszw.getNPrmc(), "聘任名称"));
		zyjszwVO.setNQdmc(dmDAO.getDmByMc(rysxZyjszw.getNQdmc(), "聘任名称"));
		zyjszwVO.setNQdtj(dmDAO.getDmByMc(rysxZyjszw.getNQdtj(), "专业技术途径"));
		zyjszwVO.setNRybh(rysxZyjszw.getNRybh().toString());
		zyjszwVO.setNZcdj(dmDAO.getDmByMc(rysxZyjszw.getNZcdj(), "职称等级"));
		return zyjszwVO;
	}

	
	@Override
	public ZyjszwVO updateRsZyjszw(ZyjszwVO vo)
	{
		BigDecimal bd = new BigDecimal(vo.getNId());
		int fydm = Integer.valueOf(vo.getNFy());
		int rybh = Integer.valueOf(vo.getNRybh());
		RysxZyjszw rysxZyjszw = rysxZyjszwDAO.findByFyRybhId(fydm, rybh, bd);
		try
		{
			ObjectByteThreadLocal.setObjectByte(ObjectSerializedUtils
					.writeObjectToMemory(rysxZyjszw));
		} catch (Exception ex)
		{
			ex.printStackTrace();
		}
		if (StringUtil.isNotBlank(vo.getDPrrq()))
		{
			rysxZyjszw.setDPrrq(DateUtil.parse(vo.getDPrrq(), DateUtil.webFormat));
		}
		if (StringUtil.isNotBlank(vo.getDQdrq()))
		{
			rysxZyjszw.setDQdrq(DateUtil.parse(vo.getDQdrq(), DateUtil.webFormat));
		}
		rysxZyjszw.setNPrmc(Integer.parseInt(vo.getNPrmc()));
		rysxZyjszw.setNQdmc(Integer.parseInt(vo.getNQdmc()));
		rysxZyjszw.setNQdtj(Integer.parseInt(vo.getNQdtj()));
		rysxZyjszw.setNZcdj(Integer.parseInt(vo.getNZcdj()));
		rysxZyjszwDAO.interceptUpdateZyjszw(rysxZyjszw);
		ZyjszwVO zyjszwVO = new ZyjszwVO();
		if (rysxZyjszw.getDPrrq() != null)
		{
			zyjszwVO.setDPrrq(DateUtil.format(rysxZyjszw.getDPrrq(),
					DateUtil.webFormat).toString());
		}
		if (rysxZyjszw.getDQdrq() != null)
		{
			zyjszwVO.setDQdrq(DateUtil.format(rysxZyjszw.getDQdrq(),
					DateUtil.webFormat).toString());
		}
		zyjszwVO.setNFy(rysxZyjszw.getNFy().toString());
		zyjszwVO.setNId(rysxZyjszw.getNId().toString());
		zyjszwVO.setNPrmc(dmDAO.getDmByMc(rysxZyjszw.getNPrmc(), "聘任名称"));
		zyjszwVO.setNQdmc(dmDAO.getDmByMc(rysxZyjszw.getNQdmc(), "聘任名称"));
		zyjszwVO.setNQdtj(dmDAO.getDmByMc(rysxZyjszw.getNQdtj(), "专业技术途径"));
		zyjszwVO.setNRybh(rysxZyjszw.getNRybh().toString());
		zyjszwVO.setNZcdj(dmDAO.getDmByMc(rysxZyjszw.getNZcdj(), "职称等级"));
		return zyjszwVO;
	}

	// 兼任职务
	@Override
	public List<JrzwVO> getJrzwByRybhFy(int rybh, int fydm)
	{
		List<RysxJzzw> listRysxJrzw = rysxJzzwDAO.getJrzwByRybhFy(rybh, fydm);
		List<JrzwVO> listJrzwVO = new ArrayList<JrzwVO>();
		for (int i = 0; i < listRysxJrzw.size(); i++)
		{
			JrzwVO jrzwVO = new JrzwVO();
			jrzwVO.setCBm(listRysxJrzw.get(i).getCBm());
			jrzwVO.setCDw(listRysxJrzw.get(i).getCDw());
			jrzwVO.setCJrzw(listRysxJrzw.get(i).getCJrzw());
			jrzwVO.setCPzdw(listRysxJrzw.get(i).getCPzdw());
			jrzwVO.setCPzwh(listRysxJrzw.get(i).getCPzwh());
			if (listRysxJrzw.get(i).getDPzrq() != null)
			{
				jrzwVO.setDPzrq(DateUtil.format(listRysxJrzw.get(i).getDPzrq(),
						DateUtil.webFormat).toString());
			}
			if (listRysxJrzw.get(i).getDRmrq() != null)
			{
				jrzwVO.setDRmrq(DateUtil.format(listRysxJrzw.get(i).getDRmrq(),
						DateUtil.webFormat).toString());
			}
			jrzwVO.setNDqxx(dmDAO.getDmByMc(listRysxJrzw.get(i).getNDqxx(),
					"是否"));
			jrzwVO.setNFy(listRysxJrzw.get(i).getNFy().toString());
			jrzwVO.setNId(listRysxJrzw.get(i).getNId().toString());
			jrzwVO.setNRmlb(dmDAO.getDmByMc(listRysxJrzw.get(i).getNRmlb(),
					"任免类别"));
			jrzwVO.setNRmyy(dmDAO.getDmByMc(listRysxJrzw.get(i).getNRmyy(),
					"任免原因"));
			jrzwVO.setNRybh(listRysxJrzw.get(i).getNRybh().toString());
			jrzwVO.setNTbjl(dmDAO.getDmByMc(listRysxJrzw.get(i).getNTbjl(),
					"是否"));
			listJrzwVO.add(jrzwVO);
		}
		return listJrzwVO;
	};

	@Override
	public JrzwVO getRsJrzwById(String id, String fydm, String rybh)
	{
		RysxJzzw rysxJrzw = rysxJzzwDAO.getRsJrzwById(id, fydm, rybh);
		JrzwVO jrzwVO = new JrzwVO();
		jrzwVO.setCBm(rysxJrzw.getCBm());
		jrzwVO.setCDw(rysxJrzw.getCDw());
		jrzwVO.setCJrzw(rysxJrzw.getCJrzw());
		jrzwVO.setCPzdw(rysxJrzw.getCPzdw());
		jrzwVO.setCPzwh(rysxJrzw.getCPzwh());
		if (rysxJrzw.getDPzrq() != null)
		{
			jrzwVO.setDPzrq(DateUtil.format(rysxJrzw.getDPzrq(),
					DateUtil.webFormat).toString());
		}
		if (rysxJrzw.getDRmrq() != null)
		{
			jrzwVO.setDRmrq(DateUtil.format(rysxJrzw.getDRmrq(),
					DateUtil.webFormat).toString());
		}
		jrzwVO.setNDqxx(dmDAO.getDmByMc(rysxJrzw.getNDqxx(), "是否"));
		jrzwVO.setNFy(rysxJrzw.getNFy().toString());
		jrzwVO.setNId(rysxJrzw.getNId().toString());
		jrzwVO.setNRmlb(dmDAO.getDmByMc(rysxJrzw.getNRmlb(), "任免类别"));
		jrzwVO.setNRmyy(dmDAO.getDmByMc(rysxJrzw.getNRmyy(), "任免原因"));
		jrzwVO.setNRybh(rysxJrzw.getNRybh().toString());
		jrzwVO.setNTbjl(dmDAO.getDmByMc(rysxJrzw.getNTbjl(), "是否"));
		return jrzwVO;
	}

	@Override
	public boolean delRsJrzwById(String id, String fydm, String rybh)
	{
		RysxJzzw rysxJzzw = rysxJzzwDAO.findByFyRybhId(Integer.valueOf(fydm),
				Integer.valueOf(rybh), new BigDecimal(id));
		return rysxJzzwDAO.interceptDeleteRsJrzwById(rysxJzzw);
	}

	@Override
	public JrzwVO addJrzw(JrzwVO vo)
	{
		RysxJzzw rysxJzzw = new RysxJzzw();
		int fydm = Integer.valueOf(vo.getNFy());
		rysxJzzw.setCBm(vo.getCBm());
		rysxJzzw.setCDw(vo.getCDw());
		rysxJzzw.setCJrzw(vo.getCJrzw());
		rysxJzzw.setCPzdw(vo.getCPzdw());
		rysxJzzw.setCPzwh(vo.getCPzwh());
		if (StringUtil.isNotBlank(vo.getDPzrq()))
		{
			rysxJzzw.setDPzrq(DateUtil.parse(vo.getDPzrq(), DateUtil.webFormat));
		}
		if (StringUtil.isNotBlank(vo.getDRmrq()))
		{
			rysxJzzw.setDRmrq(DateUtil.parse(vo.getDRmrq(), DateUtil.webFormat));
		}
		rysxJzzw.setNDqxx(Short.parseShort(vo.getNDqxx()));
		rysxJzzw.setNFy(fydm);
		rysxJzzw.setNId(rysxTablekeyDAO.getMaxId(fydm, "N_JZZWID"));
		rysxJzzw.setNRmlb(Integer.parseInt(vo.getNRmlb()));
		rysxJzzw.setNRmyy(Integer.parseInt(vo.getNRmyy()));
		rysxJzzw.setNRybh(Integer.parseInt(vo.getNRybh()));
		rysxJzzw.setNTbjl(Short.parseShort(vo.getNTbjl()));
		if (vo.getNDqxx().equals("1"))
		{
			List<RysxJzzw> listRysxJzzw = rysxJzzwDAO.getJrzwByRybhFy(
					Integer.parseInt(vo.getNRybh()), fydm);
			for (int i = 0; i < listRysxJzzw.size(); i++)
			{
				if (listRysxJzzw.get(i).getNDqxx() == 1)
				{
					listRysxJzzw.get(i).setNDqxx((short) 2);
					rysxJzzwDAO.updateRsJrzw(listRysxJzzw.get(i));
				}
			}
		}
		if (vo.getNTbjl().equals("1"))
		{
			JlxxVO jlxxVO = new JlxxVO();
			jlxxVO.setNFy(vo.getNFy());
			jlxxVO.setNRybh(vo.getNRybh());
			jlxxVO.setCZmr("");
			jlxxVO.setCSzdw("");
			jlxxVO.setCSzbm("");
			jlxxVO.setDQsrq(vo.getDRmrq());
			jlxxVO.setDJzrq(vo.getDPzrq());
			jlxxVO.setCZj("");
			jlxxVO.setCZw(vo.getCJrzw());
			addJlxx(jlxxVO);
		}
		rysxJzzwDAO.interceptAddJrzw(rysxJzzw);
		JrzwVO jrzwVO = new JrzwVO();
		jrzwVO.setCBm(rysxJzzw.getCBm());
		jrzwVO.setCDw(rysxJzzw.getCDw());
		jrzwVO.setCJrzw(rysxJzzw.getCJrzw());
		jrzwVO.setCPzdw(rysxJzzw.getCPzdw());
		jrzwVO.setCPzwh(rysxJzzw.getCPzwh());
		if (rysxJzzw.getDPzrq() != null)
		{
			jrzwVO.setDPzrq(DateUtil.format(rysxJzzw.getDPzrq(),
					DateUtil.webFormat).toString());
		}
		if (rysxJzzw.getDRmrq() != null)
		{
			jrzwVO.setDRmrq(DateUtil.format(rysxJzzw.getDRmrq(),
					DateUtil.webFormat).toString());
		}
		jrzwVO.setNDqxx(dmDAO.getDmByMc(rysxJzzw.getNDqxx(), "是否"));
		jrzwVO.setNFy(rysxJzzw.getNFy().toString());
		jrzwVO.setNId(rysxJzzw.getNId().toString());
		jrzwVO.setNRmlb(dmDAO.getDmByMc(rysxJzzw.getNRmlb(), "任免类别"));
		jrzwVO.setNRmyy(dmDAO.getDmByMc(rysxJzzw.getNRmyy(), "任免原因"));
		jrzwVO.setNRybh(rysxJzzw.getNRybh().toString());
		jrzwVO.setNTbjl(dmDAO.getDmByMc(rysxJzzw.getNTbjl(), "是否"));
		return jrzwVO;
	}

	
	@Override
	public JrzwVO updateRsJrzw(JrzwVO vo)
	{
		BigDecimal bd = new BigDecimal(vo.getNId());
		int fydm = Integer.valueOf(vo.getNFy());
		int rybh = Integer.valueOf(vo.getNRybh());
		RysxJzzw rysxJzzw = rysxJzzwDAO.findByFyRybhId(fydm, rybh, bd);
		try
		{
			ObjectByteThreadLocal.setObjectByte(ObjectSerializedUtils
					.writeObjectToMemory(rysxJzzw));
		} catch (Exception ex)
		{
			ex.printStackTrace();
		}
		rysxJzzw.setCBm(vo.getCBm());
		rysxJzzw.setCDw(vo.getCDw());
		rysxJzzw.setCJrzw(vo.getCJrzw());
		rysxJzzw.setCPzdw(vo.getCPzdw());
		rysxJzzw.setCPzwh(vo.getCPzwh());
		if (StringUtil.isNotBlank(vo.getDPzrq()))
		{
			rysxJzzw.setDPzrq(DateUtil.parse(vo.getDPzrq(), DateUtil.webFormat));
		}
		if (StringUtil.isNotBlank(vo.getDRmrq()))
		{
			rysxJzzw.setDRmrq(DateUtil.parse(vo.getDRmrq(), DateUtil.webFormat));
		}
		rysxJzzw.setNDqxx(Short.parseShort(vo.getNDqxx()));
		rysxJzzw.setNRmlb(Integer.parseInt(vo.getNRmlb()));
		rysxJzzw.setNRmyy(Integer.parseInt(vo.getNRmyy()));
		rysxJzzw.setNTbjl(Short.parseShort(vo.getNTbjl()));

		if (vo.getNDqxx().equals("1"))
		{
			List<RysxJzzw> listRysxJzzw = rysxJzzwDAO.getJrzwByRybhFy(
					Integer.parseInt(vo.getNRybh()), fydm);
			for (int i = 0; i < listRysxJzzw.size(); i++)
			{
				if (listRysxJzzw.get(i).getNDqxx() == 1
						&& listRysxJzzw.get(i) != rysxJzzw)
				{
					listRysxJzzw.get(i).setNDqxx((short) 2);
					rysxJzzwDAO.updateRsJrzw(listRysxJzzw.get(i));
				}
			}
		}

		rysxJzzwDAO.interceptUpdateJrzw(rysxJzzw);
		JrzwVO jrzwVO = new JrzwVO();
		jrzwVO.setCBm(rysxJzzw.getCBm());
		jrzwVO.setCDw(rysxJzzw.getCDw());
		jrzwVO.setCJrzw(rysxJzzw.getCJrzw());
		jrzwVO.setCPzdw(rysxJzzw.getCPzdw());
		jrzwVO.setCPzwh(rysxJzzw.getCPzwh());
		if (rysxJzzw.getDPzrq() != null)
		{
			jrzwVO.setDPzrq(DateUtil.format(rysxJzzw.getDPzrq(),
					DateUtil.webFormat).toString());
		}
		if (rysxJzzw.getDRmrq() != null)
		{
			jrzwVO.setDRmrq(DateUtil.format(rysxJzzw.getDRmrq(),
					DateUtil.webFormat).toString());
		}
		jrzwVO.setNDqxx(dmDAO.getDmByMc(rysxJzzw.getNDqxx(), "是否"));
		jrzwVO.setNFy(rysxJzzw.getNFy().toString());
		jrzwVO.setNId(rysxJzzw.getNId().toString());
		jrzwVO.setNRmlb(dmDAO.getDmByMc(rysxJzzw.getNRmlb(), "任免类别"));
		jrzwVO.setNRmyy(dmDAO.getDmByMc(rysxJzzw.getNRmyy(), "任免原因"));
		jrzwVO.setNRybh(rysxJzzw.getNRybh().toString());
		jrzwVO.setNTbjl(dmDAO.getDmByMc(rysxJzzw.getNTbjl(), "是否"));
		return jrzwVO;
	}

	@Override
	public List<LdbzVO> getLdbzByRybhFy(int rybh, int fydm)
	{
		List<RysxLdbz> listRysxLdbz = rysxLdbzDAO.getLdbzByRybhFy(rybh, fydm);
		List<LdbzVO> listLdbzVO = new ArrayList<LdbzVO>();
		for (int i = 0; i < listRysxLdbz.size(); i++)
		{
			LdbzVO ldbzVO = new LdbzVO();
			ldbzVO.setCQgzbm(listRysxLdbz.get(i).getCQgzbm());
			ldbzVO.setCQgzdw(listRysxLdbz.get(i).getCQgzdw());
			ldbzVO.setNCjkc(dmDAO.getDmByMc(listRysxLdbz.get(i).getNCjkc(),
					"是否"));
			ldbzVO.setNFy(listRysxLdbz.get(i).getNFy().toString());
			ldbzVO.setNId(listRysxLdbz.get(i).getNId().toString());
			ldbzVO.setNRybh(listRysxLdbz.get(i).getNRybh().toString());
			ldbzVO.setNZqdzyj(dmDAO.getDmByMc(listRysxLdbz.get(i).getNZqdzyj(),
					"是否"));
			ldbzVO.setNZw(dmDAO.getDmByMc(listRysxLdbz.get(i).getNZw(), "职务"));
			listLdbzVO.add(ldbzVO);
		}
		return listLdbzVO;
	}

	@Override
	public LdbzVO getRsLdbzById(String id, String fydm, String rybh)
	{
		RysxLdbz rysxLdbz = rysxLdbzDAO.getRsLdbzById(id, fydm, rybh);
		LdbzVO ldbzVO = new LdbzVO();
		ldbzVO.setCQgzbm(rysxLdbz.getCQgzbm());
		ldbzVO.setCQgzdw(rysxLdbz.getCQgzdw());
		ldbzVO.setNCjkc(dmDAO.getDmByMc(rysxLdbz.getNCjkc(), "是否"));
		ldbzVO.setNFy(rysxLdbz.getNFy().toString());
		ldbzVO.setNId(rysxLdbz.getNId().toString());
		ldbzVO.setNRybh(rysxLdbz.getNRybh().toString());
		ldbzVO.setNZqdzyj(dmDAO.getDmByMc(rysxLdbz.getNZqdzyj(), "是否"));
		ldbzVO.setNZw(dmDAO.getDmByMc(rysxLdbz.getNZw(), "职务"));
		return ldbzVO;
	}

	@Override
	public boolean delRsLdbzById(String id, String fydm, String rybh)
	{
		RysxLdbz rysxLdbz = rysxLdbzDAO.findByFyRybhId(Integer.valueOf(fydm),
				Integer.valueOf(rybh), new BigDecimal(id));
		return rysxLdbzDAO.interceptDeleteRsLdbzById(rysxLdbz);
	}

	@Override
	public LdbzVO addLdbz(LdbzVO vo)
	{
		RysxLdbz rysxLdbz = new RysxLdbz();
		int fydm = Integer.valueOf(vo.getNFy());
		rysxLdbz.setCQgzbm(vo.getCQgzbm());
		rysxLdbz.setCQgzdw(vo.getCQgzdw());
		rysxLdbz.setNCjkc(Short.parseShort(vo.getNCjkc()));
		rysxLdbz.setNFy(fydm);
		rysxLdbz.setNId(rysxTablekeyDAO.getMaxId(fydm, "N_LDBZID"));
		rysxLdbz.setNRybh(Integer.parseInt(vo.getNRybh()));
		rysxLdbz.setNZqdzyj(Short.parseShort(vo.getNZqdzyj()));
		rysxLdbz.setNZw(Integer.parseInt(vo.getNZw()));
		rysxLdbzDAO.interceptAddLdbz(rysxLdbz);
		LdbzVO ldbzVO = new LdbzVO();
		ldbzVO.setCQgzbm(rysxLdbz.getCQgzbm());
		ldbzVO.setCQgzdw(rysxLdbz.getCQgzdw());
		ldbzVO.setNCjkc(dmDAO.getDmByMc(rysxLdbz.getNCjkc(), "是否"));
		ldbzVO.setNFy(rysxLdbz.getNFy().toString());
		ldbzVO.setNId(rysxLdbz.getNId().toString());
		ldbzVO.setNRybh(rysxLdbz.getNRybh().toString());
		ldbzVO.setNZqdzyj(dmDAO.getDmByMc(rysxLdbz.getNZqdzyj(), "是否"));
		ldbzVO.setNZw(dmDAO.getDmByMc(rysxLdbz.getNZw(), "职务"));
		return ldbzVO;
	}

	@Override
	public LdbzVO updateRsLdbz(LdbzVO vo)
	{
		BigDecimal bd = new BigDecimal(vo.getNId());
		int fydm = Integer.valueOf(vo.getNFy());
		int rybh = Integer.valueOf(vo.getNRybh());
		RysxLdbz rysxLdbz = rysxLdbzDAO.findByFyRybhId(fydm, rybh, bd);
		try
		{
			ObjectByteThreadLocal.setObjectByte(ObjectSerializedUtils
					.writeObjectToMemory(rysxLdbz));
		} catch (Exception ex)
		{
			ex.printStackTrace();
		}
		rysxLdbz.setCQgzbm(vo.getCQgzbm());
		rysxLdbz.setCQgzdw(vo.getCQgzdw());
		rysxLdbz.setNCjkc(Short.parseShort(vo.getNCjkc()));
		rysxLdbz.setNZqdzyj(Short.parseShort(vo.getNZqdzyj()));
		rysxLdbz.setNZw(Integer.parseInt(vo.getNZw()));
		rysxLdbzDAO.interceptUpdateLdbz(rysxLdbz);
		LdbzVO ldbzVO = new LdbzVO();
		ldbzVO.setCQgzbm(rysxLdbz.getCQgzbm());
		ldbzVO.setCQgzdw(rysxLdbz.getCQgzdw());
		ldbzVO.setNCjkc(dmDAO.getDmByMc(rysxLdbz.getNCjkc(), "是否"));
		ldbzVO.setNFy(rysxLdbz.getNFy().toString());
		ldbzVO.setNId(rysxLdbz.getNId().toString());
		ldbzVO.setNRybh(rysxLdbz.getNRybh().toString());
		ldbzVO.setNZqdzyj(dmDAO.getDmByMc(rysxLdbz.getNZqdzyj(), "是否"));
		ldbzVO.setNZw(dmDAO.getDmByMc(rysxLdbz.getNZw(), "职务"));
		return ldbzVO;
	}

	// 后备干部
	@Override
	public List<HbgbVO> getHbgbByRybhFy(int rybh, int fydm)
	{
		List<RysxHbgb> listRysxHbgb = rysxHbgbDAO.getHbgbByRybhFy(rybh, fydm);
		List<HbgbVO> listHbgbVO = new ArrayList<HbgbVO>();
		for (int i = 0; i < listRysxHbgb.size(); i++)
		{
			HbgbVO hbgbVO = new HbgbVO();
			hbgbVO.setCDldw(listRysxHbgb.get(i).getCDldw());
			hbgbVO.setCJl(listRysxHbgb.get(i).getCJl());
			if (listRysxHbgb.get(i).getDJssj() != null)
			{
				hbgbVO.setDJssj(DateUtil.format(listRysxHbgb.get(i).getDJssj(),
						DateUtil.webFormat).toString());
			}
			if (listRysxHbgb.get(i).getDKssj() != null)
			{
				hbgbVO.setDKssj(DateUtil.format(listRysxHbgb.get(i).getDKssj(),
						DateUtil.webFormat).toString());
			}
			hbgbVO.setNDlzw(dmDAO.getDmByMc(listRysxHbgb.get(i).getNDlzw(),
					"职务"));
			hbgbVO.setNFy(listRysxHbgb.get(i).getNFy().toString());
			hbgbVO.setNHbzw(dmDAO.getDmByMc(listRysxHbgb.get(i).getNHbzw(),
					"职务"));
			hbgbVO.setNId(listRysxHbgb.get(i).getNId().toString());
			hbgbVO.setNRybh(listRysxHbgb.get(i).getNRybh().toString());
			listHbgbVO.add(hbgbVO);
		}
		return listHbgbVO;
	}

	@Override
	public HbgbVO getRsHbgbById(String id, String fydm, String rybh)
	{
		RysxHbgb rysxHbgb = rysxHbgbDAO.getRsHbgbById(id, fydm, rybh);
		HbgbVO hbgbVO = new HbgbVO();
		hbgbVO.setCDldw(rysxHbgb.getCDldw());
		hbgbVO.setCJl(rysxHbgb.getCJl());
		if (rysxHbgb.getDJssj() != null)
		{
			hbgbVO.setDJssj(DateUtil.format(rysxHbgb.getDJssj(),
					DateUtil.webFormat).toString());
		}
		if (rysxHbgb.getDKssj() != null)
		{
			hbgbVO.setDKssj(DateUtil.format(rysxHbgb.getDKssj(),
					DateUtil.webFormat).toString());
		}
		hbgbVO.setNDlzw(dmDAO.getDmByMc(rysxHbgb.getNDlzw(), "职务"));
		hbgbVO.setNFy(rysxHbgb.getNFy().toString());
		hbgbVO.setNHbzw(dmDAO.getDmByMc(rysxHbgb.getNHbzw(), "职务"));
		hbgbVO.setNId(rysxHbgb.getNId().toString());
		hbgbVO.setNRybh(rysxHbgb.getNRybh().toString());
		return hbgbVO;
	}

	@Override
	public boolean delRsHbgbById(String id, String fydm, String rybh)
	{
		RysxHbgb rysxHbgb = rysxHbgbDAO.findByFyRybhId(Integer.valueOf(fydm),
				Integer.valueOf(rybh), new BigDecimal(id));
		return rysxHbgbDAO.interceptDeleteRsHbgbById(rysxHbgb);
	}

	
	@Override
	public HbgbVO addHbgb(HbgbVO vo)
	{
		int fydm = Integer.valueOf(vo.getNFy());
		RysxHbgb rysxHbgb = new RysxHbgb();
		rysxHbgb.setCDldw(vo.getCDldw());
		rysxHbgb.setCJl(vo.getCJl());
		if (StringUtil.isNotBlank(vo.getDJssj()))
		{
			rysxHbgb.setDJssj(DateUtil.parse(vo.getDJssj(), DateUtil.webFormat));
		}
		if (StringUtil.isNotBlank(vo.getDKssj()))
		{
			rysxHbgb.setDKssj(DateUtil.parse(vo.getDKssj(), DateUtil.webFormat));
		}
		rysxHbgb.setNDlzw(Integer.parseInt(vo.getNDlzw()));
		rysxHbgb.setNFy(fydm);
		rysxHbgb.setNHbzw(Integer.parseInt(vo.getNHbzw()));
		rysxHbgb.setNId(rysxTablekeyDAO.getMaxId(fydm, "N_HBGBID"));
		rysxHbgb.setNRybh(Integer.parseInt(vo.getNRybh()));
		rysxHbgbDAO.interceptAddHbgb(rysxHbgb);
		HbgbVO hbgbVO = new HbgbVO();
		hbgbVO.setCDldw(rysxHbgb.getCDldw());
		hbgbVO.setCJl(rysxHbgb.getCJl());
		if (rysxHbgb.getDJssj() != null)
		{
			hbgbVO.setDJssj(DateUtil.format(rysxHbgb.getDJssj(),
					DateUtil.webFormat).toString());
		}
		if (rysxHbgb.getDKssj() != null)
		{
			hbgbVO.setDKssj(DateUtil.format(rysxHbgb.getDKssj(),
					DateUtil.webFormat).toString());
		}
		hbgbVO.setNDlzw(dmDAO.getDmByMc(rysxHbgb.getNDlzw(), "职务"));
		hbgbVO.setNFy(rysxHbgb.getNFy().toString());
		hbgbVO.setNHbzw(dmDAO.getDmByMc(rysxHbgb.getNHbzw(), "职务"));
		hbgbVO.setNId(rysxHbgb.getNId().toString());
		hbgbVO.setNRybh(rysxHbgb.getNRybh().toString());
		return hbgbVO;
	}

	
	@Override
	public HbgbVO updateRsHbgb(HbgbVO vo)
	{
		BigDecimal bd = new BigDecimal(vo.getNId());
		int fydm = Integer.valueOf(vo.getNFy());
		int rybh = Integer.valueOf(vo.getNRybh());
		RysxHbgb rysxHbgb = rysxHbgbDAO.findByFyRybhId(fydm, rybh, bd);
		try
		{
			ObjectByteThreadLocal.setObjectByte(ObjectSerializedUtils
					.writeObjectToMemory(rysxHbgb));
		} catch (Exception ex)
		{
			ex.printStackTrace();
		}
		rysxHbgb.setCDldw(vo.getCDldw());
		rysxHbgb.setCJl(vo.getCJl());
		if (StringUtil.isNotBlank(vo.getDJssj()))
		{
			rysxHbgb.setDJssj(DateUtil.parse(vo.getDJssj(), DateUtil.webFormat));
		}
		if (StringUtil.isNotBlank(vo.getDKssj()))
		{
			rysxHbgb.setDKssj(DateUtil.parse(vo.getDKssj(), DateUtil.webFormat));
		}
		rysxHbgb.setNDlzw(Integer.parseInt(vo.getNDlzw()));
		rysxHbgb.setNHbzw(Integer.parseInt(vo.getNHbzw()));
		rysxHbgbDAO.interceptUpdateHbgb(rysxHbgb);
		HbgbVO hbgbVO = new HbgbVO();
		hbgbVO.setCDldw(rysxHbgb.getCDldw());
		hbgbVO.setCJl(rysxHbgb.getCJl());
		if (rysxHbgb.getDJssj() != null)
		{
			hbgbVO.setDJssj(DateUtil.format(rysxHbgb.getDJssj(),
					DateUtil.webFormat).toString());
		}
		if (rysxHbgb.getDKssj() != null)
		{
			hbgbVO.setDKssj(DateUtil.format(rysxHbgb.getDKssj(),
					DateUtil.webFormat).toString());
		}
		hbgbVO.setNDlzw(dmDAO.getDmByMc(rysxHbgb.getNDlzw(), "职务"));
		hbgbVO.setNFy(rysxHbgb.getNFy().toString());
		hbgbVO.setNHbzw(dmDAO.getDmByMc(rysxHbgb.getNHbzw(), "职务"));
		hbgbVO.setNId(rysxHbgb.getNId().toString());
		hbgbVO.setNRybh(rysxHbgb.getNRybh().toString());
		return hbgbVO;
	}

	// 工资信息
	@Override
	public List<GzxxVO> getGzxxByRybhFy(int rybh, int fydm)
	{
		List<RysxGzxx> listRysxGzxx = rysxGzxxDAO.getGzxxByRybhFy(rybh, fydm);
		List<GzxxVO> listGzxxVO = new ArrayList<GzxxVO>();
		for (int i = 0; i < listRysxGzxx.size(); i++)
		{
			GzxxVO gzxxVO = new GzxxVO();
			gzxxVO.setCXjb(listRysxGzxx.get(i).getCXjb());
			gzxxVO.setCZwgzdc(listRysxGzxx.get(i).getCZwgzdc());
			if (listRysxGzxx.get(i).getDXjbsj() != null)
			{
				gzxxVO.setDXjbsj(DateUtil.format(
						listRysxGzxx.get(i).getDXjbsj(), DateUtil.webFormat)
						.toString());
			}
			if (listRysxGzxx.get(i).getDZwgzdcsj() != null)
			{
				gzxxVO.setDZwgzdcsj(DateUtil.format(
						listRysxGzxx.get(i).getDZwgzdcsj(), DateUtil.webFormat)
						.toString());
			}
			if (listRysxGzxx.get(i).getMJbgze() != null)
			{
				gzxxVO.setMJbgze(listRysxGzxx.get(i).getMJbgze().toString());
			}
			if (listRysxGzxx.get(i).getMJhljt() != null)
			{
				gzxxVO.setMJhljt(listRysxGzxx.get(i).getMJhljt().toString());
			}
			if (listRysxGzxx.get(i).getMJt() != null)
			{
				gzxxVO.setMJt(listRysxGzxx.get(i).getMJt().toString());
			}
			if (listRysxGzxx.get(i).getMZwgwbt() != null)
			{
				gzxxVO.setMZwgwbt(listRysxGzxx.get(i).getMZwgwbt().toString());
			}
			if (listRysxGzxx.get(i).getMZwgze() != null)
			{
				gzxxVO.setMZwgze(listRysxGzxx.get(i).getMZwgze().toString());
			}
			gzxxVO.setNFy(listRysxGzxx.get(i).getNFy().toString());
			gzxxVO.setNId(listRysxGzxx.get(i).getNId().toString());
			gzxxVO.setNRybh(listRysxGzxx.get(i).getNRybh().toString());
			listGzxxVO.add(gzxxVO);
		}
		return listGzxxVO;
	}

	@Override
	public GzxxVO getRsGzxxById(String id, String fydm, String rybh)
	{
		RysxGzxx rysxGzxx = rysxGzxxDAO.getRsGzxxById(id, fydm, rybh);
		GzxxVO gzxxVO = new GzxxVO();
		gzxxVO.setCXjb(rysxGzxx.getCXjb());
		gzxxVO.setCZwgzdc(rysxGzxx.getCZwgzdc());
		if (rysxGzxx.getDXjbsj() != null)
		{
			gzxxVO.setDXjbsj(DateUtil.format(rysxGzxx.getDXjbsj(),
					DateUtil.webFormat).toString());
		}
		if (rysxGzxx.getDZwgzdcsj() != null)
		{
			gzxxVO.setDZwgzdcsj(DateUtil.format(rysxGzxx.getDZwgzdcsj(),
					DateUtil.webFormat).toString());
		}
		if (rysxGzxx.getMJbgze() != null)
		{
			gzxxVO.setMJbgze(rysxGzxx.getMJbgze().toString());
		}
		if (rysxGzxx.getMJhljt() != null)
		{
			gzxxVO.setMJhljt(rysxGzxx.getMJhljt().toString());
		}
		if (rysxGzxx.getMJt() != null)
		{
			gzxxVO.setMJt(rysxGzxx.getMJt().toString());
		}
		if (rysxGzxx.getMZwgwbt() != null)
		{
			gzxxVO.setMZwgwbt(rysxGzxx.getMZwgwbt().toString());
		}
		if (rysxGzxx.getMZwgze() != null)
		{
			gzxxVO.setMZwgze(rysxGzxx.getMZwgze().toString());
		}

		gzxxVO.setNFy(rysxGzxx.getNFy().toString());
		gzxxVO.setNId(rysxGzxx.getNId().toString());
		gzxxVO.setNRybh(rysxGzxx.getNRybh().toString());
		return gzxxVO;
	}

	@Override
	public boolean delRsGzxxById(String id, String fydm, String rybh)
	{
		RysxGzxx rysxGzxx = rysxGzxxDAO.findByFyRybhId(Integer.valueOf(fydm),
				Integer.valueOf(rybh), new BigDecimal(id));
		return rysxGzxxDAO.interceptDeleteRsGzxxById(rysxGzxx);
	}

	
	@Override
	public GzxxVO addGzxx(GzxxVO vo)
	{
		RysxGzxx rysxGzxx = new RysxGzxx();
		int fydm = Integer.valueOf(vo.getNFy());
		rysxGzxx.setCXjb(vo.getCXjb());
		rysxGzxx.setCZwgzdc(vo.getCZwgzdc());
		if (StringUtil.isNotBlank(vo.getDXjbsj()))
		{
			rysxGzxx.setDXjbsj(DateUtil.parse(vo.getDXjbsj(), DateUtil.webFormat));
		}
		if (StringUtil.isNotBlank(vo.getDZwgzdcsj()))
		{
			rysxGzxx.setDZwgzdcsj(DateUtil.parse(vo.getDZwgzdcsj(), DateUtil.webFormat));
		}
		if (StringUtil.isNotBlank(vo.getMJbgze()))
		{
			rysxGzxx.setMJbgze(Double.parseDouble(vo.getMJbgze()));
		}
		if (StringUtil.isNotBlank(vo.getMJhljt()))
		{
			rysxGzxx.setMJhljt(Double.parseDouble(vo.getMJhljt()));
		}
		if (StringUtil.isNotBlank(vo.getMJt()))
		{
			rysxGzxx.setMJt(Double.parseDouble(vo.getMJt()));
		}
		if (StringUtil.isNotBlank(vo.getMZwgwbt()))
		{
			rysxGzxx.setMZwgwbt(Double.parseDouble(vo.getMZwgwbt()));
		}
		if (StringUtil.isNotBlank(vo.getMZwgze()))
		{
			rysxGzxx.setMZwgze(Double.parseDouble(vo.getMZwgze()));
		}
		rysxGzxx.setNFy(fydm);
		rysxGzxx.setNId(rysxTablekeyDAO.getMaxId(fydm, "N_GZXXID"));
		rysxGzxx.setNRybh(Integer.parseInt(vo.getNRybh()));
		rysxGzxxDAO.interceptAddGzxx(rysxGzxx);
		GzxxVO gzxxVO = new GzxxVO();
		gzxxVO.setCXjb(rysxGzxx.getCXjb());
		gzxxVO.setCZwgzdc(rysxGzxx.getCZwgzdc());
		if (rysxGzxx.getDXjbsj() != null)
		{
			gzxxVO.setDXjbsj(DateUtil.format(rysxGzxx.getDXjbsj(),
					DateUtil.webFormat).toString());
		}
		if (rysxGzxx.getDZwgzdcsj() != null)
		{
			gzxxVO.setDZwgzdcsj(DateUtil.format(rysxGzxx.getDZwgzdcsj(),
					DateUtil.webFormat).toString());
		}
		if (rysxGzxx.getMJbgze() != null)
		{
			gzxxVO.setMJbgze(rysxGzxx.getMJbgze().toString());
		}
		if (rysxGzxx.getMJhljt() != null)
		{
			gzxxVO.setMJhljt(rysxGzxx.getMJhljt().toString());
		}
		if (rysxGzxx.getMJt() != null)
		{
			gzxxVO.setMJt(rysxGzxx.getMJt().toString());
		}
		if (rysxGzxx.getMZwgwbt() != null)
		{
			gzxxVO.setMZwgwbt(rysxGzxx.getMZwgwbt().toString());
		}
		if (rysxGzxx.getMZwgze() != null)
		{
			gzxxVO.setMZwgze(rysxGzxx.getMZwgze().toString());
		}
		gzxxVO.setNFy(rysxGzxx.getNFy().toString());
		gzxxVO.setNId(rysxGzxx.getNId().toString());
		gzxxVO.setNRybh(rysxGzxx.getNRybh().toString());
		return gzxxVO;
	}

	@Override
	public GzxxVO updateRsGzxx(GzxxVO vo)
	{
		BigDecimal bd = new BigDecimal(vo.getNId());
		int fydm = Integer.valueOf(vo.getNFy());
		int rybh = Integer.valueOf(vo.getNRybh());
		RysxGzxx rysxGzxx = rysxGzxxDAO.findByFyRybhId(fydm, rybh, bd);
		try
		{
			ObjectByteThreadLocal.setObjectByte(ObjectSerializedUtils
					.writeObjectToMemory(rysxGzxx));
		} catch (Exception ex)
		{
			ex.printStackTrace();
		}
		rysxGzxx.setCXjb(vo.getCXjb());
		rysxGzxx.setCZwgzdc(vo.getCZwgzdc());
		if (StringUtil.isNotBlank(vo.getDXjbsj()))
		{
			rysxGzxx.setDXjbsj(DateUtil.parse(vo.getDXjbsj(), DateUtil.webFormat));
		}
		if (StringUtil.isNotBlank(vo.getDZwgzdcsj()))
		{
			rysxGzxx.setDZwgzdcsj(DateUtil.parse(vo.getDZwgzdcsj(), DateUtil.webFormat));
		}
		if (StringUtil.isNotBlank(vo.getMJbgze()))
		{
			rysxGzxx.setMJbgze(Double.parseDouble(vo.getMJbgze()));
		} else
		{
			rysxGzxx.setMJbgze(null);
		}
		if (StringUtil.isNotBlank(vo.getMJhljt()))
		{
			rysxGzxx.setMJhljt(Double.parseDouble(vo.getMJhljt()));
		} else
		{
			rysxGzxx.setMJhljt(null);
		}
		if (StringUtil.isNotBlank(vo.getMJt()))
		{
			rysxGzxx.setMJt(Double.parseDouble(vo.getMJt()));
		} else
		{
			rysxGzxx.setMJt(null);
		}
		if (StringUtil.isNotBlank(vo.getMZwgwbt()))
		{
			rysxGzxx.setMZwgwbt(Double.parseDouble(vo.getMZwgwbt()));
		} else
		{
			rysxGzxx.setMZwgwbt(null);
		}
		if (StringUtil.isNotBlank(vo.getMZwgze()))
		{
			rysxGzxx.setMZwgze(Double.parseDouble(vo.getMZwgze()));
		} else
		{
			rysxGzxx.setMZwgze(null);
		}
		rysxGzxxDAO.interceptUpdateGzxx(rysxGzxx);
		GzxxVO gzxxVO = new GzxxVO();
		gzxxVO.setCXjb(rysxGzxx.getCXjb());
		gzxxVO.setCZwgzdc(rysxGzxx.getCZwgzdc());
		if (rysxGzxx.getDXjbsj() != null)
		{
			gzxxVO.setDXjbsj(DateUtil.format(rysxGzxx.getDXjbsj(),
					DateUtil.webFormat).toString());
		}
		if (rysxGzxx.getDZwgzdcsj() != null)
		{
			gzxxVO.setDZwgzdcsj(DateUtil.format(rysxGzxx.getDZwgzdcsj(),
					DateUtil.webFormat).toString());
		}
		if (rysxGzxx.getMJbgze() != null)
		{
			gzxxVO.setMJbgze(rysxGzxx.getMJbgze().toString());
		}
		if (rysxGzxx.getMJhljt() != null)
		{
			gzxxVO.setMJhljt(rysxGzxx.getMJhljt().toString());
		}
		if (rysxGzxx.getMJt() != null)
		{
			gzxxVO.setMJt(rysxGzxx.getMJt().toString());
		}
		if (rysxGzxx.getMZwgwbt() != null)
		{
			gzxxVO.setMZwgwbt(rysxGzxx.getMZwgwbt().toString());
		}
		if (rysxGzxx.getMZwgze() != null)
		{
			gzxxVO.setMZwgze(rysxGzxx.getMZwgze().toString());
		}
		gzxxVO.setNFy(rysxGzxx.getNFy().toString());
		gzxxVO.setNId(rysxGzxx.getNId().toString());
		gzxxVO.setNRybh(rysxGzxx.getNRybh().toString());
		return gzxxVO;
	}

	// 惩处信息
	@Override
	public List<CcxxVO> getCcxxByRybhFy(int rybh, int fydm)
	{
		List<RysxCcxx> listRysxCcxx = rysxCcxxDAO.getCcxxByRybhFy(rybh, fydm);
		List<CcxxVO> listCcxxVO = new ArrayList<CcxxVO>();
		for (int i = 0; i < listRysxCcxx.size(); i++)
		{
			CcxxVO ccxxVO = new CcxxVO();
			ccxxVO.setCPzdw(listRysxCcxx.get(i).getCPzdw());
			if (listRysxCcxx.get(i).getDCcrq() != null)
			{
				ccxxVO.setDCcrq(DateUtil.format(listRysxCcxx.get(i).getDCcrq(),
						DateUtil.webFormat).toString());
			}
			if (listRysxCcxx.get(i).getDJcrq() != null)
			{
				ccxxVO.setDJcrq(DateUtil.format(listRysxCcxx.get(i).getDJcrq(),
						DateUtil.webFormat).toString());
			}
			ccxxVO.setNCclb(dmDAO.getDmByMc(listRysxCcxx.get(i).getNCclb(),
					"惩罚程度"));
			ccxxVO.setNCcyy(dmDAO.getDmByMc(listRysxCcxx.get(i).getNCcyy(),
					"惩罚原因"));
			ccxxVO.setNFy(listRysxCcxx.get(i).getNFy().toString());
			ccxxVO.setNId(listRysxCcxx.get(i).getNId().toString());
			ccxxVO.setNRybh(listRysxCcxx.get(i).getNRybh().toString());
			listCcxxVO.add(ccxxVO);
		}
		return listCcxxVO;
	}

	@Override
	public CcxxVO getRsCcxxById(String id, String fydm, String rybh)
	{
		RysxCcxx rysxCcxx = rysxCcxxDAO.getRsCcxxById(id, fydm, rybh);
		CcxxVO ccxxVO = new CcxxVO();
		ccxxVO.setCPzdw(rysxCcxx.getCPzdw());
		if (rysxCcxx.getDCcrq() != null)
		{
			ccxxVO.setDCcrq(DateUtil.format(rysxCcxx.getDCcrq(),
					DateUtil.webFormat).toString());
		}
		if (rysxCcxx.getDJcrq() != null)
		{
			ccxxVO.setDJcrq(DateUtil.format(rysxCcxx.getDJcrq(),
					DateUtil.webFormat).toString());
		}
		ccxxVO.setNCclb(dmDAO.getDmByMc(rysxCcxx.getNCclb(), "惩罚程度"));
		ccxxVO.setNCcyy(dmDAO.getDmByMc(rysxCcxx.getNCcyy(), "惩罚原因"));
		ccxxVO.setNFy(rysxCcxx.getNFy().toString());
		ccxxVO.setNId(rysxCcxx.getNId().toString());
		ccxxVO.setNRybh(rysxCcxx.getNRybh().toString());
		return ccxxVO;
	}

	@Override
	public boolean delRsCcxxById(String id, String fydm, String rybh)
	{
		RysxCcxx rysxCcxx = rysxCcxxDAO.findByFyRybhId(Integer.valueOf(fydm),
				Integer.valueOf(rybh), new BigDecimal(id));
		return rysxCcxxDAO.interceptDeleteRsCcxxById(rysxCcxx);
	}

	
	@Override
	public CcxxVO addCcxx(CcxxVO vo)
	{
		int fydm = Integer.valueOf(vo.getNFy());
		RysxCcxx rysxCcxx = new RysxCcxx();
		rysxCcxx.setCPzdw(vo.getCPzdw());
		if (StringUtil.isNotBlank(vo.getDCcrq()))
		{
			rysxCcxx.setDCcrq(DateUtil.parse(vo.getDCcrq(), DateUtil.webFormat));
		}
		if (StringUtil.isNotBlank(vo.getDJcrq()))
		{
			rysxCcxx.setDJcrq(DateUtil.parse(vo.getDJcrq(), DateUtil.webFormat));
		}
		rysxCcxx.setNCclb(Integer.parseInt(vo.getNCclb()));
		rysxCcxx.setNCcyy(Integer.parseInt(vo.getNCcyy()));
		rysxCcxx.setNFy(fydm);
		rysxCcxx.setNId(rysxTablekeyDAO.getMaxId(fydm, "N_CCXXID"));
		rysxCcxx.setNRybh(Integer.parseInt(vo.getNRybh()));
		rysxCcxxDAO.interceptAddCcxx(rysxCcxx);
		CcxxVO ccxxVO = new CcxxVO();
		ccxxVO.setCPzdw(rysxCcxx.getCPzdw());
		if (rysxCcxx.getDCcrq() != null)
		{
			ccxxVO.setDCcrq(DateUtil.format(rysxCcxx.getDCcrq(),
					DateUtil.webFormat).toString());
		}
		if (rysxCcxx.getDJcrq() != null)
		{
			ccxxVO.setDJcrq(DateUtil.format(rysxCcxx.getDJcrq(),
					DateUtil.webFormat).toString());
		}
		ccxxVO.setNCclb(dmDAO.getDmByMc(rysxCcxx.getNCclb(), "惩罚程度"));
		ccxxVO.setNCcyy(dmDAO.getDmByMc(rysxCcxx.getNCcyy(), "惩罚原因"));
		ccxxVO.setNFy(rysxCcxx.getNFy().toString());
		ccxxVO.setNId(rysxCcxx.getNId().toString());
		ccxxVO.setNRybh(rysxCcxx.getNRybh().toString());
		return ccxxVO;
	}

	@Override
	public CcxxVO updateRsCcxx(CcxxVO vo)
	{
		BigDecimal bd = new BigDecimal(vo.getNId());
		int fydm = Integer.valueOf(vo.getNFy());
		int rybh = Integer.valueOf(vo.getNRybh());
		RysxCcxx rysxCcxx = rysxCcxxDAO.findByFyRybhId(fydm, rybh, bd);
		try
		{
			ObjectByteThreadLocal.setObjectByte(ObjectSerializedUtils
					.writeObjectToMemory(rysxCcxx));
		} catch (Exception ex)
		{
			ex.printStackTrace();
		}
		rysxCcxx.setCPzdw(vo.getCPzdw());
		if (StringUtil.isNotBlank(vo.getDCcrq()))
		{
			rysxCcxx.setDCcrq(DateUtil.parse(vo.getDCcrq(), DateUtil.webFormat));
		}
		if (StringUtil.isNotBlank(vo.getDJcrq()))
		{
			rysxCcxx.setDJcrq(DateUtil.parse(vo.getDJcrq(), DateUtil.webFormat));
		}
		rysxCcxx.setNCclb(Integer.parseInt(vo.getNCclb()));
		rysxCcxx.setNCcyy(Integer.parseInt(vo.getNCcyy()));
		rysxCcxxDAO.interceptUpdateCcxx(rysxCcxx);
		CcxxVO ccxxVO = new CcxxVO();
		ccxxVO.setCPzdw(rysxCcxx.getCPzdw());
		if (rysxCcxx.getDCcrq() != null)
		{
			ccxxVO.setDCcrq(DateUtil.format(rysxCcxx.getDCcrq(),
					DateUtil.webFormat).toString());
		}
		if (rysxCcxx.getDJcrq() != null)
		{
			ccxxVO.setDJcrq(DateUtil.format(rysxCcxx.getDJcrq(),
					DateUtil.webFormat).toString());
		}
		ccxxVO.setNCclb(dmDAO.getDmByMc(rysxCcxx.getNCclb(), "惩罚程度"));
		ccxxVO.setNCcyy(dmDAO.getDmByMc(rysxCcxx.getNCcyy(), "惩罚原因"));
		ccxxVO.setNFy(rysxCcxx.getNFy().toString());
		ccxxVO.setNId(rysxCcxx.getNId().toString());
		ccxxVO.setNRybh(rysxCcxx.getNRybh().toString());
		return ccxxVO;
	}

	// 伤亡信息
	@Override
	public List<SwxxVO> getSwxxByRybhFy(int rybh, int fydm)
	{
		List<RysxSwxx> listRysxSwxx = rysxSwxxDAO.getSwxxByRybhFy(rybh, fydm);
		List<SwxxVO> listSwxxVO = new ArrayList<SwxxVO>();
		for (int i = 0; i < listRysxSwxx.size(); i++)
		{
			SwxxVO swxxVO = new SwxxVO();
			if (listRysxSwxx.get(i).getDSwrq() != null)
			{
				swxxVO.setDSwrq(DateUtil.format(listRysxSwxx.get(i).getDSwrq(),
						DateUtil.webFormat).toString());
			}
			swxxVO.setNFy(listRysxSwxx.get(i).getNFy().toString());
			swxxVO.setNId(listRysxSwxx.get(i).getNId().toString());
			swxxVO.setNRybh(listRysxSwxx.get(i).getNRybh().toString());
			swxxVO.setNSwcd(dmDAO.getDmByMc(listRysxSwxx.get(i).getNSwcd(),
					"伤亡程度"));
			swxxVO.setNSwyy(dmDAO.getDmByMc(listRysxSwxx.get(i).getNSwyy(),
					"伤亡原因"));
			listSwxxVO.add(swxxVO);
		}
		return listSwxxVO;
	};

	@Override
	public SwxxVO getRsSwxxById(String id, String fydm, String rybh)
	{
		RysxSwxx rysxSwxx = rysxSwxxDAO.getRsSwxxById(id, fydm, rybh);
		SwxxVO swxxVO = new SwxxVO();
		if (rysxSwxx.getDSwrq() != null)
		{
			swxxVO.setDSwrq(DateUtil.format(rysxSwxx.getDSwrq(),
					DateUtil.webFormat).toString());
		}
		swxxVO.setNFy(rysxSwxx.getNFy().toString());
		swxxVO.setNId(rysxSwxx.getNId().toString());
		swxxVO.setNRybh(rysxSwxx.getNRybh().toString());
		swxxVO.setNSwcd(dmDAO.getDmByMc(rysxSwxx.getNSwcd(), "伤亡程度"));
		swxxVO.setNSwyy(dmDAO.getDmByMc(rysxSwxx.getNSwyy(), "伤亡原因"));
		return swxxVO;
	}

	@Override
	public boolean delRsSwxxById(String id, String fydm, String rybh)
	{
		RysxSwxx rysxSwxx = rysxSwxxDAO.findByFyRybhId(Integer.valueOf(fydm),
				Integer.valueOf(rybh), new BigDecimal(id));
		return rysxSwxxDAO.interceptDeleteRsSwxxById(rysxSwxx);
	}

	@Override
	public SwxxVO addSwxx(SwxxVO vo)
	{
		int fydm = Integer.valueOf(vo.getNFy());
		RysxSwxx rysxSwxx = new RysxSwxx();
		if (StringUtil.isNotBlank(vo.getDSwrq()))
		{
			rysxSwxx.setDSwrq(DateUtil.parse(vo.getDSwrq(), DateUtil.webFormat));
		}
		rysxSwxx.setNFy(fydm);
		rysxSwxx.setNId(rysxTablekeyDAO.getMaxId(fydm, "N_SWXXID"));
		rysxSwxx.setNRybh(Integer.parseInt(vo.getNRybh()));
		rysxSwxx.setNSwcd(Integer.parseInt(vo.getNSwcd()));
		rysxSwxx.setNSwyy(Integer.parseInt(vo.getNSwyy()));
		rysxSwxxDAO.interceptAddSwxx(rysxSwxx);
		SwxxVO swxxVO = new SwxxVO();
		if (rysxSwxx.getDSwrq() != null)
		{
			swxxVO.setDSwrq(DateUtil.format(rysxSwxx.getDSwrq(),
					DateUtil.webFormat).toString());
		}
		swxxVO.setNFy(rysxSwxx.getNFy().toString());
		swxxVO.setNId(rysxSwxx.getNId().toString());
		swxxVO.setNRybh(rysxSwxx.getNRybh().toString());
		swxxVO.setNSwcd(dmDAO.getDmByMc(rysxSwxx.getNSwcd(), "伤亡程度"));
		swxxVO.setNSwyy(dmDAO.getDmByMc(rysxSwxx.getNSwyy(), "伤亡原因"));
		return swxxVO;
	}

	@Override
	public SwxxVO updateRsSwxx(SwxxVO vo)
	{
		BigDecimal bd = new BigDecimal(vo.getNId());
		int fydm = Integer.valueOf(vo.getNFy());
		int rybh = Integer.valueOf(vo.getNRybh());
		RysxSwxx rysxSwxx = rysxSwxxDAO.findByFyRybhId(fydm, rybh, bd);
		try
		{
			ObjectByteThreadLocal.setObjectByte(ObjectSerializedUtils
					.writeObjectToMemory(rysxSwxx));
		} catch (Exception ex)
		{
			ex.printStackTrace();
		}
		if (StringUtil.isNotBlank(vo.getDSwrq()))
		{
			rysxSwxx.setDSwrq(DateUtil.parse(vo.getDSwrq(), DateUtil.webFormat));
		}
		rysxSwxx.setNSwcd(Integer.parseInt(vo.getNSwcd()));
		rysxSwxx.setNSwyy(Integer.parseInt(vo.getNSwyy()));
		rysxSwxxDAO.interceptUpdateSwxx(rysxSwxx);
		SwxxVO swxxVO = new SwxxVO();
		if (rysxSwxx.getDSwrq() != null)
		{
			swxxVO.setDSwrq(DateUtil.format(rysxSwxx.getDSwrq(),
					DateUtil.webFormat).toString());
		}
		swxxVO.setNFy(rysxSwxx.getNFy().toString());
		swxxVO.setNId(rysxSwxx.getNId().toString());
		swxxVO.setNRybh(rysxSwxx.getNRybh().toString());
		swxxVO.setNSwcd(dmDAO.getDmByMc(rysxSwxx.getNSwcd(), "伤亡程度"));
		swxxVO.setNSwyy(dmDAO.getDmByMc(rysxSwxx.getNSwyy(), "伤亡原因"));
		return swxxVO;
	}

	// 在读信息
	@Override
	public List<ZdxxVO> getZdxxByRybhFy(int rybh, int fydm)
	{
		List<RysxZdxx> listRysxZdxx = rysxZdxxDAO.getZdxxByRybhFy(rybh, fydm);
		List<ZdxxVO> listZdxxVO = new ArrayList<ZdxxVO>();
		for (int i = 0; i < listRysxZdxx.size(); i++)
		{
			ZdxxVO zdxxVO = new ZdxxVO();
			zdxxVO.setCZdyx(listRysxZdxx.get(i).getCZdyx());
			zdxxVO.setCZdzy(listRysxZdxx.get(i).getCZdzy());
			zdxxVO.setNDqxx(dmDAO.getDmByMc(listRysxZdxx.get(i).getNDqxx(),
					"是否"));
			zdxxVO.setNFy(listRysxZdxx.get(i).getNFy().toString());
			zdxxVO.setNId(listRysxZdxx.get(i).getNId().toString());
			if (listRysxZdxx.get(i).getDRxrq() != null)
			{
				zdxxVO.setDRxrq(DateUtil.format(listRysxZdxx.get(i).getDRxrq(),
						DateUtil.webFormat).toString());
			}
			zdxxVO.setNJyxs(dmDAO.getDmByMc(listRysxZdxx.get(i).getNJyxs(),
					"教育形式"));
			zdxxVO.setNRybh(listRysxZdxx.get(i).getNRybh().toString());
			zdxxVO.setNSxzy(dmDAO.getDmByMc(listRysxZdxx.get(i).getNSxzy(),
					"专业"));
			zdxxVO.setNXxxs(dmDAO.getDmByMc(listRysxZdxx.get(i).getNXxxs(),
					"学习形式"));
			if (listRysxZdxx.get(i).getNXz() != null)
			{
				zdxxVO.setNXz(listRysxZdxx.get(i).getNXz().toString());
			}
			zdxxVO.setNZdxl(dmDAO.getDmByMc(listRysxZdxx.get(i).getNZdxl(),
					"文化程度"));
			listZdxxVO.add(zdxxVO);
		}
		return listZdxxVO;

	}

	@Override
	public ZdxxVO getRsZdxxById(String id, String fydm, String rybh)
	{
		RysxZdxx rysxZdxx = rysxZdxxDAO.getRsZdxxById(id, fydm, rybh);
		ZdxxVO zdxxVO = new ZdxxVO();
		zdxxVO.setCZdyx(rysxZdxx.getCZdyx());
		zdxxVO.setCZdzy(rysxZdxx.getCZdzy());
		zdxxVO.setNDqxx(dmDAO.getDmByMc(rysxZdxx.getNDqxx(), "是否"));
		zdxxVO.setNFy(rysxZdxx.getNFy().toString());
		zdxxVO.setNId(rysxZdxx.getNId().toString());
		if (rysxZdxx.getDRxrq() != null)
		{
			zdxxVO.setDRxrq(DateUtil.format(rysxZdxx.getDRxrq(),
					DateUtil.webFormat).toString());
		}
		zdxxVO.setNJyxs(dmDAO.getDmByMc(rysxZdxx.getNJyxs(), "教育形式"));
		zdxxVO.setNRybh(rysxZdxx.getNRybh().toString());
		zdxxVO.setNSxzy(dmDAO.getDmByMc(rysxZdxx.getNSxzy(), "专业"));
		zdxxVO.setNXxxs(dmDAO.getDmByMc(rysxZdxx.getNXxxs(), "学习形式"));
		if (rysxZdxx.getNXz() != null)
		{
			zdxxVO.setNXz(rysxZdxx.getNXz().toString());
		}
		zdxxVO.setNZdxl(dmDAO.getDmByMc(rysxZdxx.getNZdxl(), "文化程度"));
		return zdxxVO;
	}

	@Override
	public boolean delRsZdxxById(String id, String fydm, String rybh)
	{
		RysxZdxx rysxZdxx = rysxZdxxDAO.findByFyRybhId(Integer.valueOf(fydm),
				Integer.valueOf(rybh), new BigDecimal(id));
		return rysxZdxxDAO.interceptDeleteRsZdxxById(rysxZdxx);
	}

	@Override
	public ZdxxVO addZdxx(ZdxxVO vo)
	{
		int fydm = Integer.valueOf(vo.getNFy());
		RysxZdxx rysxZdxx = new RysxZdxx();
		rysxZdxx.setCZdyx(vo.getCZdyx());
		rysxZdxx.setCZdzy(vo.getCZdzy());
		if (StringUtil.isNotBlank(vo.getDRxrq()))
		{
			rysxZdxx.setDRxrq(DateUtil.parse(vo.getDRxrq(), DateUtil.webFormat));
		}
		rysxZdxx.setNDqxx(Short.parseShort(vo.getNDqxx()));
		rysxZdxx.setNFy(fydm);
		rysxZdxx.setNId(rysxTablekeyDAO.getMaxId(fydm, "N_ZDXXID"));
		rysxZdxx.setNJyxs(Integer.parseInt(vo.getNJyxs()));
		rysxZdxx.setNRybh(Integer.parseInt(vo.getNRybh()));
		rysxZdxx.setNSxzy(Integer.parseInt(vo.getNSxzy()));
		rysxZdxx.setNXxxs(Integer.parseInt(vo.getNXxxs()));
		if (StringUtil.isNotBlank(vo.getNXz()))
		{
			rysxZdxx.setNXz(Short.parseShort(vo.getNXz()));
		}
		rysxZdxx.setNZdxl(Integer.parseInt(vo.getNZdxl()));
		if (vo.getNDqxx().equals("1"))
		{
			List<RysxZdxx> listRysxZdxx = rysxZdxxDAO.getZdxxByRybhFy(
					Integer.parseInt(vo.getNRybh()), fydm);
			for (int i = 0; i < listRysxZdxx.size(); i++)
			{
				if (listRysxZdxx.get(i).getNDqxx() == 1)
				{
					listRysxZdxx.get(i).setNDqxx((short) 2);
					rysxZdxxDAO.updateRsZdxx(listRysxZdxx.get(i));
				}
			}
		}
		rysxZdxxDAO.interceptAddZdxx(rysxZdxx);
		ZdxxVO zdxxVO = new ZdxxVO();
		zdxxVO.setCZdyx(rysxZdxx.getCZdyx());
		zdxxVO.setCZdzy(rysxZdxx.getCZdzy());
		zdxxVO.setNDqxx(dmDAO.getDmByMc(rysxZdxx.getNDqxx(), "是否"));
		zdxxVO.setNFy(rysxZdxx.getNFy().toString());
		zdxxVO.setNId(rysxZdxx.getNId().toString());
		if (rysxZdxx.getDRxrq() != null)
		{
			zdxxVO.setDRxrq(DateUtil.format(rysxZdxx.getDRxrq(),
					DateUtil.webFormat).toString());
		}
		zdxxVO.setNJyxs(dmDAO.getDmByMc(rysxZdxx.getNJyxs(), "教育形式"));
		zdxxVO.setNRybh(rysxZdxx.getNRybh().toString());
		zdxxVO.setNSxzy(dmDAO.getDmByMc(rysxZdxx.getNSxzy(), "专业"));
		zdxxVO.setNXxxs(dmDAO.getDmByMc(rysxZdxx.getNXxxs(), "学习形式"));
		if (rysxZdxx.getNXz() != null)
		{
			zdxxVO.setNXz(rysxZdxx.getNXz().toString());
		}
		zdxxVO.setNZdxl(dmDAO.getDmByMc(rysxZdxx.getNZdxl(), "文化程度"));
		return zdxxVO;
	}

	@Override
	public ZdxxVO updateRsZdxx(ZdxxVO vo)
	{
		BigDecimal bd = new BigDecimal(vo.getNId());
		int fydm = Integer.valueOf(vo.getNFy());
		int rybh = Integer.valueOf(vo.getNRybh());
		RysxZdxx rysxZdxx = rysxZdxxDAO.findByFyRybhId(fydm, rybh, bd);
		try
		{
			ObjectByteThreadLocal.setObjectByte(ObjectSerializedUtils
					.writeObjectToMemory(rysxZdxx));
		} catch (Exception ex)
		{
			ex.printStackTrace();
		}
		rysxZdxx.setCZdyx(vo.getCZdyx());
		rysxZdxx.setCZdzy(vo.getCZdzy());
		if (StringUtil.isNotBlank(vo.getDRxrq()))
		{
			rysxZdxx.setDRxrq(DateUtil.parse(vo.getDRxrq(), DateUtil.webFormat));
		} else
		{
			rysxZdxx.setDRxrq(null);
		}
		rysxZdxx.setNDqxx(Short.parseShort(vo.getNDqxx()));
		rysxZdxx.setNJyxs(Integer.parseInt(vo.getNJyxs()));
		rysxZdxx.setNSxzy(Integer.parseInt(vo.getNSxzy()));
		rysxZdxx.setNXxxs(Integer.parseInt(vo.getNXxxs()));
		if (StringUtil.isNotBlank(vo.getNXz()))
		{
			rysxZdxx.setNXz(Short.parseShort(vo.getNXz()));
		} else
		{
			rysxZdxx.setNXz(null);
		}
		rysxZdxx.setNZdxl(Integer.parseInt(vo.getNZdxl()));
		if (vo.getNDqxx().equals("1"))
		{
			List<RysxZdxx> listRysxZdxx = rysxZdxxDAO.getZdxxByRybhFy(
					Integer.parseInt(vo.getNRybh()), fydm);
			for (int i = 0; i < listRysxZdxx.size(); i++)
			{
				if (listRysxZdxx.get(i).getNDqxx() == 1
						&& listRysxZdxx.get(i) != rysxZdxx)
				{
					listRysxZdxx.get(i).setNDqxx((short) 2);
					rysxZdxxDAO.updateRsZdxx(listRysxZdxx.get(i));
				}
			}
		}
		rysxZdxxDAO.interceptUpdateZdxx(rysxZdxx);
		ZdxxVO zdxxVO = new ZdxxVO();
		zdxxVO.setCZdyx(rysxZdxx.getCZdyx());
		zdxxVO.setCZdzy(rysxZdxx.getCZdzy());
		zdxxVO.setNDqxx(dmDAO.getDmByMc(rysxZdxx.getNDqxx(), "是否"));
		zdxxVO.setNFy(rysxZdxx.getNFy().toString());
		zdxxVO.setNId(rysxZdxx.getNId().toString());
		if (rysxZdxx.getDRxrq() != null)
		{
			zdxxVO.setDRxrq(DateUtil.format(rysxZdxx.getDRxrq(),
					DateUtil.webFormat).toString());
		}
		zdxxVO.setNJyxs(dmDAO.getDmByMc(rysxZdxx.getNJyxs(), "教育形式"));
		zdxxVO.setNRybh(rysxZdxx.getNRybh().toString());
		zdxxVO.setNSxzy(dmDAO.getDmByMc(rysxZdxx.getNSxzy(), "专业"));
		zdxxVO.setNXxxs(dmDAO.getDmByMc(rysxZdxx.getNXxxs(), "学习形式"));
		if (rysxZdxx.getNXz() != null)
		{
			zdxxVO.setNXz(rysxZdxx.getNXz().toString());
		}
		zdxxVO.setNZdxl(dmDAO.getDmByMc(rysxZdxx.getNZdxl(), "文化程度"));
		return zdxxVO;
	}

	// 出国信息
	@Override
	public List<CgxxVO> getCgxxByRybhFy(int rybh, int fydm)
	{
		List<RysxCgxx> listRysxCgxx = rysxCgxxDAO.getCgxxByRybhFy(rybh, fydm);
		List<CgxxVO> listCgxxVO = new ArrayList<CgxxVO>();
		for (int i = 0; i < listRysxCgxx.size(); i++)
		{
			CgxxVO cgxxVO = new CgxxVO();
			cgxxVO.setCJfly(listRysxCgxx.get(i).getCJfly());
			if (listRysxCgxx.get(i).getCJfly() != null)
			{
				cgxxVO.setDJssj(DateUtil.format(listRysxCgxx.get(i).getDJssj(),
						DateUtil.webFormat).toString());
			}
			if (listRysxCgxx.get(i).getDKssj() != null)
			{
				cgxxVO.setDKssj(DateUtil.format(listRysxCgxx.get(i).getDKssj(),
						DateUtil.webFormat).toString());
			}
			cgxxVO.setNCgsf(dmDAO.getDmByMc(listRysxCgxx.get(i).getNCgsf(),
					"出国身份"));
			cgxxVO.setNCgxz(dmDAO.getDmByMc(listRysxCgxx.get(i).getNCgxz(),
					"出国性质"));
			cgxxVO.setNFy(listRysxCgxx.get(i).getNFy().toString());
			cgxxVO.setNGb(dmDAO.getDmByMc(listRysxCgxx.get(i).getNGb(), "国家"));
			cgxxVO.setNId(listRysxCgxx.get(i).getNId().toString());
			cgxxVO.setNRybh(listRysxCgxx.get(i).getNRybh().toString());
			listCgxxVO.add(cgxxVO);
		}
		return listCgxxVO;
	}

	@Override
	public CgxxVO getRsCgxxById(String id, String fydm, String rybh)
	{
		RysxCgxx rysxCgxx = rysxCgxxDAO.getRsCgxxById(id, fydm, rybh);
		CgxxVO cgxxVO = new CgxxVO();
		cgxxVO.setCJfly(rysxCgxx.getCJfly());
		if (rysxCgxx.getDJssj() != null)
		{
			cgxxVO.setDJssj(DateUtil.format(rysxCgxx.getDJssj(),
					DateUtil.webFormat).toString());
		}
		if (rysxCgxx.getDKssj() != null)
		{
			cgxxVO.setDKssj(DateUtil.format(rysxCgxx.getDKssj(),
					DateUtil.webFormat).toString());
		}
		cgxxVO.setNCgsf(dmDAO.getDmByMc(rysxCgxx.getNCgsf(), "出国身份"));
		cgxxVO.setNCgxz(dmDAO.getDmByMc(rysxCgxx.getNCgxz(), "出国性质"));
		cgxxVO.setNFy(rysxCgxx.getNFy().toString());
		cgxxVO.setNGb(dmDAO.getDmByMc(rysxCgxx.getNGb(), "国家"));
		cgxxVO.setNId(rysxCgxx.getNId().toString());
		cgxxVO.setNRybh(rysxCgxx.getNRybh().toString());
		return cgxxVO;
	}

	@Override
	public boolean delRsCgxxById(String id, String fydm, String rybh)
	{
		RysxCgxx rysxCgxx = rysxCgxxDAO.findByFyRybhId(Integer.valueOf(fydm),
				Integer.valueOf(rybh), new BigDecimal(id));
		return rysxCgxxDAO.interceptDeleteRsCgxxById(rysxCgxx);
	}

	// myCode
	@Override
	public int[] findBzCount(int fydm)
	{
		return ryjbxxDAO.findBzCount(fydm);
	}

	@Override
	public List<Ryjbxx> listByFlzwBmZwlbZyZjDjXlRyk(String flzw, String bm,
			String zwlb, String zy, String zj, String dj, String xl, String ryk)
	{

		return ryjbxxDAO.listByFlzwBmZwlbZyZjDjXlRyk(flzw, bm, zwlb, zy, zj,
				dj, xl, ryk);
	}

	public List<Ryjbxx> listByFydmRybhIn(String inString)
	{
		return ryjbxxDAO.listByFydmRybhIn(inString);
	}

	@Override
	public List<String> listNameByKuFydmBm(String ku, String fydm, String bm)
	{
		ArrayList<String> names = new ArrayList<String>();
		for (Ryjbxx rj : ryjbxxDAO.listNameByKuFydmBm(ku, fydm, bm))
		{
			names.add(rj.getCXm());
		}
		return names;
	}

	@Override
	public RyjbxxRylhVO getRyjbxxByKuFydmBmName(String ku, String fydm,
			String bm, String name)
	{
		Ryjbxx rj = ryjbxxDAO.getRyjbxxByKuFydmBmName(ku, fydm, bm, name);
		RyjbxxRylhVO vo = new RyjbxxRylhVO();
		vo.setNFy(rj.getNFy() + "");
		vo.setNRybh(rj.getNRybh() + "");
		vo.setCXm(rj.getCXm());
		if(rj.getNXb() != null)
			vo.setXb(dmDAO.dmByDmBxh(rj.getNXb(), ConstantsFyrs.NBXH_XB).getCMc());
		if(rj.getNXl() != null)
			vo.setNXl(dmDAO.dmByDmBxh(rj.getNXl(), ConstantsFyrs.NBXH_WHCD)
				.getCMc());
		if(rj.getNXzzw() != null)
			vo.setXzzwMc(dmDAO.dmByDmBxh(rj.getNXzzw(), ConstantsFyrs.NBXH_XZZW)
				.getCMc());
		if(rj.getNZj() != null)
			vo.setNZj(dmDAO.dmByDmBxh(rj.getNZj(), ConstantsFyrs.NBXH_ZJ).getCMc());
		if(rj.getDCsrq()!=null){
			vo.setNl(String.valueOf(DateUtil.getAge(rj.getDCsrq())));
		}
		vo.setShowKey(NFyRybhCodeUtils.encode(rj.getNFy(), rj.getNRybh()));
		return vo;
	}

	@Override
	public List<RyjbxxHmcVO> listByKuFydmBm(String ku, String fydm, String bm)
	{
		Map<String, String> mapNames = new HashMap<String, String>();
		List<RyjbxxHmcVO> vos = new ArrayList<RyjbxxHmcVO>();
		List<Ryjbxx> list = ryjbxxDAO.listNameByKuFydmBm(ku, fydm, bm);
		for (Ryjbxx item : list)
		{
			RyjbxxHmcVO vo = new RyjbxxHmcVO();
			vo.setCXm(item.getCXm());
			vo.setXB(DmMcCommon.dmMc(item.getNXb(), ConstantsFyrs.NBXH_XB,
					mapNames, dmDAO));
			vo.setNL(String.valueOf(DateUtil.getAge(item.getDCrq())));
			vo.setNXzzwMc(DmMcCommon.dmMc(item.getNXzzw(),
					ConstantsFyrs.NBXH_XZZW, mapNames, dmDAO));
			vo.setNFlzw(DmMcCommon.dmMc(item.getNFlzw(),
					ConstantsFyrs.NBXH_FLZW, mapNames, dmDAO));

			/**
			 * 表示有法官等级的
			 */
			if (item.getNDj() != null
					&& !item.getNDj().toString().trim().equals("")
					&& item.getNDj() >= 0 && item.getNDj() <= 24)
			{
				vo.setNDj(DmMcCommon.dmMc(item.getNDj(), ConstantsFyrs.NBXH_DJ,
						mapNames, dmDAO));
			} else
			{
				vo.setNDj("法官等级未定");
			}
			vo.setNZj(DmMcCommon.dmMc(item.getNZj(), ConstantsFyrs.NBXH_ZJ,
					mapNames, dmDAO));
			vo.setNXl(DmMcCommon.dmMc(item.getNXl(), ConstantsFyrs.NBXH_WHCD,
					mapNames, dmDAO));
			vos.add(vo);
		}
		return vos;
	}

	@Override
	public List<List<String>> listDynamicShowByKuFydmBm(
			Map<String, List<SdcxShowColumnsVO>> showTableAndColumns,
			String ku, String fydm, String bm)
	{
		List<Ryjbxx> list = ryjbxxDAO.listNameByKuFydmBm(ku, fydm, bm);
		List<List<String>> resultVos = new ArrayList<List<String>>();
		Set<String> iter = showTableAndColumns.keySet();
		for (Ryjbxx rj : list)
		{
			for (String str : iter)
			{
				List<String> oneColumn = listPropertyValueInObj(rj,
						showTableAndColumns.get(str));
				resultVos.add(oneColumn);
			}
		}
		return resultVos;
	}

	private List<String> listPropertyValueInObj(Object obj,
			List<SdcxShowColumnsVO> properties)
	{
		List<String> propertieValue = new ArrayList<String>();
		for (SdcxShowColumnsVO vo : properties)
		{
			Object value = SdcxUtil.getFieldValue(obj,
					SdcxUtil.fyrsColumnNameToFiledName(vo.getColumnName()));
			if (null == value)
			{
				propertieValue.add("");
				continue;
			}
			if (vo.getColumnName().toCharArray()[0] == 'D')
			{
				propertieValue.add(DateUtil.format((Date) value,
						DateUtil.webFormat));
			} else if (!vo.getnMainCode().equals("0")
					&& vo.getColumnName().toCharArray()[0] == 'N')
			{
				propertieValue.add(DmMcCommon.dmMc(
						Integer.valueOf(value.toString()),
						Integer.valueOf(vo.getnMainCode()), mapNames, dmDAO));
			} else if ((vo.getnMainCode().equals("0") && vo.getColumnName()
					.trim().equals("N_FY")))
			{
				propertieValue.add(DmMcCommon.dmMc(
						Integer.valueOf(value.toString()),
						ConstantsFyrs.NBXH_DWMC, mapNames, dmDAO));
			} else
			{
				propertieValue.add(value.toString());
			}

		}
		return propertieValue;
	}

	// myCode
	@Override
	public CgxxVO addCgxx(CgxxVO vo)
	{
		int fydm = Integer.valueOf(vo.getNFy());
		RysxCgxx rysxCgxx = new RysxCgxx();
		rysxCgxx.setCJfly(vo.getCJfly());
		if (StringUtil.isNotBlank(vo.getDJssj()))
		{
			rysxCgxx.setDJssj(DateUtil.parse(vo.getDJssj(), DateUtil.webFormat));
		}
		if (StringUtil.isNotBlank(vo.getDKssj()))
		{
			rysxCgxx.setDKssj(DateUtil.parse(vo.getDKssj(), DateUtil.webFormat));
		}
		rysxCgxx.setNCgsf(Integer.parseInt(vo.getNCgsf()));
		rysxCgxx.setNCgxz(Integer.parseInt(vo.getNCgxz()));
		rysxCgxx.setNFy(fydm);
		rysxCgxx.setNGb(Integer.parseInt(vo.getNGb()));
		rysxCgxx.setNId(rysxTablekeyDAO.getMaxId(fydm, "N_CGXXID"));
		rysxCgxx.setNRybh(Integer.parseInt(vo.getNRybh()));
		rysxCgxxDAO.interceptAddCgxx(rysxCgxx);
		CgxxVO cgxxVO = new CgxxVO();
		cgxxVO.setCJfly(rysxCgxx.getCJfly());
		if (rysxCgxx.getDJssj() != null)
		{
			cgxxVO.setDJssj(DateUtil.format(rysxCgxx.getDJssj(),
					DateUtil.webFormat).toString());
		}
		if (rysxCgxx.getDKssj() != null)
		{
			cgxxVO.setDKssj(DateUtil.format(rysxCgxx.getDKssj(),
					DateUtil.webFormat).toString());
		}
		cgxxVO.setNCgsf(dmDAO.getDmByMc(rysxCgxx.getNCgsf(), "出国身份"));
		cgxxVO.setNCgxz(dmDAO.getDmByMc(rysxCgxx.getNCgxz(), "出国性质"));
		cgxxVO.setNFy(rysxCgxx.getNFy().toString());
		cgxxVO.setNGb(dmDAO.getDmByMc(rysxCgxx.getNGb(), "国家"));
		cgxxVO.setNId(rysxCgxx.getNId().toString());
		cgxxVO.setNRybh(rysxCgxx.getNRybh().toString());
		return cgxxVO;
	}

	@Override
	public CgxxVO updateRsCgxx(CgxxVO vo)
	{
		BigDecimal bd = new BigDecimal(vo.getNId());
		int fydm = Integer.valueOf(vo.getNFy());
		int rybh = Integer.valueOf(vo.getNRybh());
		RysxCgxx rysxCgxx = rysxCgxxDAO.findByFyRybhId(fydm, rybh, bd);
		try
		{
			ObjectByteThreadLocal.setObjectByte(ObjectSerializedUtils
					.writeObjectToMemory(rysxCgxx));
		} catch (Exception ex)
		{
			ex.printStackTrace();
		}
		rysxCgxx.setCJfly(vo.getCJfly());
		if (StringUtil.isNotBlank(vo.getDJssj()))
		{
			rysxCgxx.setDJssj(DateUtil.parse(vo.getDJssj(), DateUtil.webFormat));
		} else
		{
			rysxCgxx.setDJssj(null);
		}
		if (StringUtil.isNotBlank(vo.getDKssj()))
		{
			rysxCgxx.setDKssj(DateUtil.parse(vo.getDKssj(), DateUtil.webFormat));
		} else
		{
			rysxCgxx.setDKssj(null);
		}
		rysxCgxx.setNCgsf(Integer.parseInt(vo.getNCgsf()));
		rysxCgxx.setNCgxz(Integer.parseInt(vo.getNCgxz()));
		rysxCgxx.setNGb(Integer.parseInt(vo.getNGb()));
		rysxCgxxDAO.interceptUpdateCgxx(rysxCgxx);
		CgxxVO cgxxVO = new CgxxVO();
		cgxxVO.setCJfly(rysxCgxx.getCJfly());
		if (rysxCgxx.getDJssj() != null)
		{
			cgxxVO.setDJssj(DateUtil.format(rysxCgxx.getDJssj(),
					DateUtil.webFormat).toString());
		}
		if (rysxCgxx.getDKssj() != null)
		{
			cgxxVO.setDKssj(DateUtil.format(rysxCgxx.getDKssj(),
					DateUtil.webFormat).toString());
		}
		cgxxVO.setNCgsf(dmDAO.getDmByMc(rysxCgxx.getNCgsf(), "出国身份"));
		cgxxVO.setNCgxz(dmDAO.getDmByMc(rysxCgxx.getNCgxz(), "出国性质"));
		cgxxVO.setNFy(rysxCgxx.getNFy().toString());
		cgxxVO.setNGb(dmDAO.getDmByMc(rysxCgxx.getNGb(), "国家"));
		cgxxVO.setNId(rysxCgxx.getNId().toString());
		cgxxVO.setNRybh(rysxCgxx.getNRybh().toString());
		return cgxxVO;
	}

	// 外语信息
	@Override
	public List<WyxxVO> getWyxxByRybhFy(int rybh, int fydm)
	{
		List<RysxWyxx> listRysxWyxx = rysxWyxxDAO.getWyxxByRybhFy(rybh, fydm);
		List<WyxxVO> listWyxxVO = new ArrayList<WyxxVO>();
		for (int i = 0; i < listRysxWyxx.size(); i++)
		{
			WyxxVO wyxxVO = new WyxxVO();
			wyxxVO.setNFy(listRysxWyxx.get(i).getNFy().toString());
			wyxxVO.setNId(listRysxWyxx.get(i).getNId().toString());
			wyxxVO.setNRybh(listRysxWyxx.get(i).getNRybh().toString());
			if (listRysxWyxx.get(i).getNSlcd() != null
					&& dmDAO.getDmByMc(listRysxWyxx.get(i).getNSlcd(), "语种熟练程度") != null)
			{
				wyxxVO.setNSlcd(dmDAO.getDmByMc(listRysxWyxx.get(i).getNSlcd(),
						"语种熟练程度"));
			}
			if (listRysxWyxx.get(i).getNSpjb() != null
					&& dmDAO.getDmByMc(listRysxWyxx.get(i).getNSpjb(), "外语水平") != null)
			{
				wyxxVO.setNSpjb(dmDAO.getDmByMc(listRysxWyxx.get(i).getNSpjb(),
						"外语水平"));
			}
			if (listRysxWyxx.get(i).getNWyyz() != null
					&& dmDAO.getDmByMc(listRysxWyxx.get(i).getNWyyz(), "语种") != null)
			{
				wyxxVO.setNWyyz(dmDAO.getDmByMc(listRysxWyxx.get(i).getNWyyz(),
						"语种"));
			}
			listWyxxVO.add(wyxxVO);
		}
		return listWyxxVO;
	}

	@Override
	public WyxxVO getRsWyxxById(String id, String fydm, String rybh)
	{
		RysxWyxx rysxWyxx = rysxWyxxDAO.getRsWyxxById(id, fydm, rybh);
		WyxxVO wyxxVO = new WyxxVO();
		wyxxVO.setNFy(rysxWyxx.getNFy().toString());
		wyxxVO.setNId(rysxWyxx.getNId().toString());
		wyxxVO.setNRybh(rysxWyxx.getNRybh().toString());
		if (rysxWyxx.getNSlcd() != null
				&& dmDAO.getDmByMc(rysxWyxx.getNSlcd(), "语种熟练程度") != null)
		{
			wyxxVO.setNSlcd(dmDAO.getDmByMc(rysxWyxx.getNSlcd(), "语种熟练程度"));
		}
		if (rysxWyxx.getNSpjb() != null
				&& dmDAO.getDmByMc(rysxWyxx.getNSpjb(), "外语水平") != null)
		{
			wyxxVO.setNSpjb(dmDAO.getDmByMc(rysxWyxx.getNSpjb(), "外语水平"));
		}
		if (rysxWyxx.getNWyyz() != null
				&& dmDAO.getDmByMc(rysxWyxx.getNWyyz(), "语种") != null)
		{
			wyxxVO.setNWyyz(dmDAO.getDmByMc(rysxWyxx.getNWyyz(), "语种"));
		}
		return wyxxVO;
	}

	@Override
	public boolean delRsWyxxById(String id, String fydm, String rybh)
	{
		RysxWyxx rysxWyxx = rysxWyxxDAO.findByFyRybhId(Integer.valueOf(fydm),
				Integer.valueOf(rybh), new BigDecimal(id));
		return rysxWyxxDAO.interceptDeleteRsWyxxById(rysxWyxx);
	}

	@Override
	public WyxxVO addWyxx(WyxxVO vo)
	{
		RysxWyxx rysxWyxx = new RysxWyxx();
		int fydm = Integer.valueOf(vo.getNFy());
		rysxWyxx.setNFy(fydm);
		rysxWyxx.setNId(rysxTablekeyDAO.getMaxId(fydm, "N_WYXXID"));
		rysxWyxx.setNRybh(Integer.parseInt(vo.getNRybh()));
		rysxWyxx.setNSlcd(Integer.parseInt(vo.getNSlcd()));
		rysxWyxx.setNSpjb(Integer.parseInt(vo.getNSpjb()));
		rysxWyxx.setNWyyz(Integer.parseInt(vo.getNWyyz()));
		rysxWyxxDAO.interceptAddWyxx(rysxWyxx);
		WyxxVO wyxxVO = new WyxxVO();
		wyxxVO.setNFy(rysxWyxx.getNFy().toString());
		wyxxVO.setNId(rysxWyxx.getNId().toString());
		wyxxVO.setNRybh(rysxWyxx.getNRybh().toString());
		wyxxVO.setNSlcd(dmDAO.getDmByMc(rysxWyxx.getNSlcd(), "语种熟练程度"));
		wyxxVO.setNSpjb(dmDAO.getDmByMc(rysxWyxx.getNSpjb(), "外语水平"));
		wyxxVO.setNWyyz(dmDAO.getDmByMc(rysxWyxx.getNWyyz(), "语种"));
		return wyxxVO;
	}

	@Override
	public WyxxVO updateRsWyxx(WyxxVO vo)
	{
		BigDecimal bd = new BigDecimal(vo.getNId());
		int fydm = Integer.valueOf(vo.getNFy());
		int rybh = Integer.valueOf(vo.getNRybh());
		RysxWyxx rysxWyxx = rysxWyxxDAO.findByFyRybhId(fydm, rybh, bd);
		try
		{
			ObjectByteThreadLocal.setObjectByte(ObjectSerializedUtils
					.writeObjectToMemory(rysxWyxx));
		} catch (Exception ex)
		{
			ex.printStackTrace();
		}
		rysxWyxx.setNSlcd(Integer.parseInt(vo.getNSlcd()));
		rysxWyxx.setNSpjb(Integer.parseInt(vo.getNSpjb()));
		rysxWyxx.setNWyyz(Integer.parseInt(vo.getNWyyz()));
		rysxWyxxDAO.interceptUpdateWyxx(rysxWyxx);
		WyxxVO wyxxVO = new WyxxVO();
		wyxxVO.setNFy(rysxWyxx.getNFy().toString());
		wyxxVO.setNId(rysxWyxx.getNId().toString());
		wyxxVO.setNRybh(rysxWyxx.getNRybh().toString());
		wyxxVO.setNSlcd(dmDAO.getDmByMc(rysxWyxx.getNSlcd(), "语种熟练程度"));
		wyxxVO.setNSpjb(dmDAO.getDmByMc(rysxWyxx.getNSpjb(), "外语水平"));
		wyxxVO.setNWyyz(dmDAO.getDmByMc(rysxWyxx.getNWyyz(), "语种"));
		return wyxxVO;
	}

	// 通讯录
	@Override
	public List<TxlVO> getTxlByRybhFy(int rybh, int fydm)
	{
		List<RysxTxl> listRysxTxl = rysxTxlDAO.getTxlByRybhFy(rybh, fydm);
		List<TxlVO> listTxlVO = new ArrayList<TxlVO>();
		for (int i = 0; i < listRysxTxl.size(); i++)
		{
			TxlVO txlVO = new TxlVO();
			txlVO.setCBgdh(listRysxTxl.get(i).getCBgdh());
			txlVO.setCJtdh(listRysxTxl.get(i).getCJtdh());
			txlVO.setCQh(listRysxTxl.get(i).getCQh());
			txlVO.setCTxdz(listRysxTxl.get(i).getCTxdz());
			txlVO.setCYddh(listRysxTxl.get(i).getCYddh());
			txlVO.setCYzbm(listRysxTxl.get(i).getCYzbm());
			txlVO.setNFy(listRysxTxl.get(i).getNFy().toString());
			txlVO.setNId(listRysxTxl.get(i).getNId().toString());
			txlVO.setNRybh(listRysxTxl.get(i).getNRybh().toString());
			listTxlVO.add(txlVO);
		}
		return listTxlVO;
	}

	@Override
	public TxlVO getRsTxlById(String id, String fydm, String rybh)
	{
		RysxTxl rysxTxl = rysxTxlDAO.getRsTxlById(id, fydm, rybh);
		TxlVO txlVO = new TxlVO();
		txlVO.setCBgdh(rysxTxl.getCBgdh());
		txlVO.setCJtdh(rysxTxl.getCJtdh());
		txlVO.setCQh(rysxTxl.getCQh());
		txlVO.setCTxdz(rysxTxl.getCTxdz());
		txlVO.setCYddh(rysxTxl.getCYddh());
		txlVO.setCYzbm(rysxTxl.getCYzbm());
		txlVO.setNFy(rysxTxl.getNFy().toString());
		txlVO.setNId(rysxTxl.getNId().toString());
		txlVO.setNRybh(rysxTxl.getNRybh().toString());
		return txlVO;
	}

	@Override
	public boolean delRsTxlById(String id, String fydm, String rybh)
	{
		RysxTxl rysxTxl = rysxTxlDAO.findByFyRybhId(Integer.valueOf(fydm),
				Integer.valueOf(rybh), new BigDecimal(id));
		return rysxTxlDAO.interceptDeleteRsTxlById(rysxTxl);
	}

	@Override
	public TxlVO addTxl(TxlVO vo)
	{
		int fydm = Integer.valueOf(vo.getNFy());
		RysxTxl rysxTxl = new RysxTxl();
		rysxTxl.setCBgdh(vo.getCBgdh());
		rysxTxl.setCJtdh(vo.getCJtdh());
		rysxTxl.setCQh(vo.getCQh());
		rysxTxl.setCTxdz(vo.getCTxdz());
		rysxTxl.setCYddh(vo.getCYddh());
		rysxTxl.setCYzbm(vo.getCYzbm());
		rysxTxl.setNFy(fydm);
		rysxTxl.setNId(rysxTablekeyDAO.getMaxId(fydm, "N_TXLID"));
		rysxTxl.setNRybh(Integer.parseInt(vo.getNRybh()));
		rysxTxlDAO.interceptAddTxl(rysxTxl);
		TxlVO txlVO = new TxlVO();
		txlVO.setCBgdh(rysxTxl.getCBgdh());
		txlVO.setCJtdh(rysxTxl.getCJtdh());
		txlVO.setCQh(rysxTxl.getCQh());
		txlVO.setCTxdz(rysxTxl.getCTxdz());
		txlVO.setCYddh(rysxTxl.getCYddh());
		txlVO.setCYzbm(rysxTxl.getCYzbm());
		txlVO.setNFy(rysxTxl.getNFy().toString());
		txlVO.setNId(rysxTxl.getNId().toString());
		txlVO.setNRybh(rysxTxl.getNRybh().toString());
		return txlVO;
	}

	@Override
	public TxlVO updateRsTxl(TxlVO vo)
	{
		BigDecimal bd = new BigDecimal(vo.getNId());
		int fydm = Integer.valueOf(vo.getNFy());
		int rybh = Integer.valueOf(vo.getNRybh());
		RysxTxl rysxTxl = rysxTxlDAO.findByFyRybhId(fydm, rybh, bd);
		try
		{
			ObjectByteThreadLocal.setObjectByte(ObjectSerializedUtils
					.writeObjectToMemory(rysxTxl));
		} catch (Exception ex)
		{
			ex.printStackTrace();
		}
		rysxTxl.setCBgdh(vo.getCBgdh());
		rysxTxl.setCJtdh(vo.getCJtdh());
		rysxTxl.setCQh(vo.getCQh());
		rysxTxl.setCTxdz(vo.getCTxdz());
		rysxTxl.setCYddh(vo.getCYddh());
		rysxTxl.setCYzbm(vo.getCYzbm());
		rysxTxlDAO.interceptUpdateTxl(rysxTxl);
		TxlVO txlVO = new TxlVO();
		txlVO.setCBgdh(rysxTxl.getCBgdh());
		txlVO.setCJtdh(rysxTxl.getCJtdh());
		txlVO.setCQh(rysxTxl.getCQh());
		txlVO.setCTxdz(rysxTxl.getCTxdz());
		txlVO.setCYddh(rysxTxl.getCYddh());
		txlVO.setCYzbm(rysxTxl.getCYzbm());
		txlVO.setNFy(rysxTxl.getNFy().toString());
		txlVO.setNId(rysxTxl.getNId().toString());
		txlVO.setNRybh(rysxTxl.getNRybh().toString());
		return txlVO;
	}

	@Override
	public List<SyyyxVO> getSyyyxByRybh(String rybh)
	{
		List<RysxSyyyx> listRysxSyyyx = rysxSyyyxDAO.getSyyyxByRybh(rybh);
		List<SyyyxVO> listSyyyxVO = new ArrayList<SyyyxVO>();
		for (int i = 0; i < listRysxSyyyx.size(); i++)
		{
			SyyyxVO syyyxVO = new SyyyxVO();
			syyyxVO.setCFilename(listRysxSyyyx.get(i).getCFilename());
			syyyxVO.setCMs(listRysxSyyyx.get(i).getCMs());
			syyyxVO.setCPath(listRysxSyyyx.get(i).getCPath());
			syyyxVO.setNFy(listRysxSyyyx.get(i).getNFy().toString());
			syyyxVO.setNId(listRysxSyyyx.get(i).getNId().toString());
			syyyxVO.setNRybh(listRysxSyyyx.get(i).getNRybh().toString());
			listSyyyxVO.add(syyyxVO);
		}
		return listSyyyxVO;
	}

	@Override
	public SyyyxVO getRsSyyyxById(String rybh, String bh)
	{
		RysxSyyyx rysxSyyyx = rysxSyyyxDAO.getRsSyyyxById(rybh, bh);
		SyyyxVO syyyxVO = new SyyyxVO();
		syyyxVO.setCFilename(rysxSyyyx.getCFilename());
		syyyxVO.setCMs(rysxSyyyx.getCMs());
		syyyxVO.setCPath(rysxSyyyx.getCPath());
		syyyxVO.setNFy(rysxSyyyx.getNFy().toString());
		syyyxVO.setNId(rysxSyyyx.getNId().toString());
		syyyxVO.setNRybh(rysxSyyyx.getNRybh().toString());
		return syyyxVO;
	}

	@Override
	public boolean delRsSyyyxById(String rybh, String bh)
	{
		return rysxSyyyxDAO.delRsSyyyxById(rybh, bh);
	}

	@Override
	public int addSyyyx(SyyyxVO vo)
	{
		RysxSyyyx rysxSyyyx = new RysxSyyyx();
		BigDecimal bd = new BigDecimal(vo.getNId());
		rysxSyyyx.setCFilename(vo.getCFilename());
		rysxSyyyx.setCMs(vo.getCMs());
		rysxSyyyx.setCPath(vo.getCPath());
		rysxSyyyx.setNFy(1);
		rysxSyyyx.setNId(bd);
		rysxSyyyx.setNRybh(Integer.parseInt(vo.getNRybh()));
		rysxSyyyxDAO.save(rysxSyyyx);
		return 0;
	}

	@Override
	public boolean updateRsSyyyx(SyyyxVO vo)
	{
		RysxSyyyx rysxSyyyx = new RysxSyyyx();
		BigDecimal bd = new BigDecimal(vo.getNId());
		rysxSyyyx.setCFilename(vo.getCFilename());
		rysxSyyyx.setCMs(vo.getCMs());
		rysxSyyyx.setCPath(vo.getCPath());
		rysxSyyyx.setNFy(1);
		rysxSyyyx.setNId(bd);
		rysxSyyyx.setNRybh(Integer.parseInt(vo.getNRybh()));
		return rysxSyyyxDAO.updateRsSyyyx(rysxSyyyx);
	}

	// 备注信息
	@Override
	public List<BzxxVO> getBzxxByRybhFy(int rybh, int fydm)
	{
		List<RysxBzxx> listRysxBzxx = rysxBzxxDAO.getBzxxByRybhFy(rybh, fydm);
		List<BzxxVO> listBzxxVO = new ArrayList<BzxxVO>();
		for (int i = 0; i < listRysxBzxx.size(); i++)
		{
			BzxxVO bzxxVO = new BzxxVO();
			bzxxVO.setCBz(listRysxBzxx.get(i).getCBz());
			bzxxVO.setNFy(listRysxBzxx.get(i).getNFy().toString());
			bzxxVO.setNId(listRysxBzxx.get(i).getNId().toString());
			bzxxVO.setNRybh(listRysxBzxx.get(i).getNRybh().toString());
			listBzxxVO.add(bzxxVO);
		}
		return listBzxxVO;
	}

	@Override
	public List<BzxxVO> getBzxxByRybh(String rybh)
	{
		List<RysxBzxx> listRysxBzxx = rysxBzxxDAO.getBzxxByRybh(rybh);
		List<BzxxVO> listBzxxVO = new ArrayList<BzxxVO>();
		for (int i = 0; i < listRysxBzxx.size(); i++)
		{
			BzxxVO bzxxVO = new BzxxVO();
			bzxxVO.setCBz(listRysxBzxx.get(i).getCBz());
			bzxxVO.setNFy(listRysxBzxx.get(i).getNFy().toString());
			bzxxVO.setNId(listRysxBzxx.get(i).getNId().toString());
			bzxxVO.setNRybh(listRysxBzxx.get(i).getNRybh().toString());
			listBzxxVO.add(bzxxVO);
		}
		return listBzxxVO;
	}

	@Override
	public BzxxVO getRsBzxxById(String id, String fydm, String rybh)
	{
		RysxBzxx rysxBzxx = rysxBzxxDAO.getRsBzxxById(id, fydm, rybh);
		BzxxVO bzxxVO = new BzxxVO();
		bzxxVO.setCBz(rysxBzxx.getCBz());
		bzxxVO.setNFy(rysxBzxx.getNFy().toString());
		bzxxVO.setNId(rysxBzxx.getNId().toString());
		bzxxVO.setNRybh(rysxBzxx.getNRybh().toString());
		return bzxxVO;
	}

	@Override
	public boolean delRsBzxxById(String id, String fydm, String rybh)
	{
		RysxBzxx rysxBzxx = rysxBzxxDAO.findByFyRybhId(Integer.valueOf(fydm),
				Integer.valueOf(rybh), new BigDecimal(id));
		return rysxBzxxDAO.interceptDeleteRsBzxxById(rysxBzxx);
	}

	@Override
	public BzxxVO addBzxx(BzxxVO vo)
	{
		RysxBzxx rysxBzxx = new RysxBzxx();
		int fydm = Integer.valueOf(vo.getNFy());
		rysxBzxx.setCBz(vo.getCBz());
		rysxBzxx.setNFy(fydm);
		rysxBzxx.setNId(rysxTablekeyDAO.getMaxId(fydm, "N_BZXXID"));
		rysxBzxx.setNRybh(Integer.parseInt(vo.getNRybh()));
		rysxBzxxDAO.interceptAddBzxx(rysxBzxx);
		BzxxVO bzxxVO = new BzxxVO();
		bzxxVO.setCBz(rysxBzxx.getCBz());
		bzxxVO.setNFy(rysxBzxx.getNFy().toString());
		bzxxVO.setNId(rysxBzxx.getNId().toString());
		bzxxVO.setNRybh(rysxBzxx.getNRybh().toString());
		return bzxxVO;
	}

	@Override
	public BzxxVO updateRsBzxx(BzxxVO vo)
	{
		BigDecimal bd = new BigDecimal(vo.getNId());
		int fydm = Integer.valueOf(vo.getNFy());
		int rybh = Integer.valueOf(vo.getNRybh());
		RysxBzxx rysxBzxx = rysxBzxxDAO.findByFyRybhId(fydm, rybh, bd);
		try
		{
			ObjectByteThreadLocal.setObjectByte(ObjectSerializedUtils
					.writeObjectToMemory(rysxBzxx));
		} catch (Exception ex)
		{
			ex.printStackTrace();
		}
		rysxBzxx.setCBz(vo.getCBz());
		rysxBzxxDAO.interceptUpdateBzxx(rysxBzxx);
		BzxxVO bzxxVO = new BzxxVO();
		bzxxVO.setCBz(rysxBzxx.getCBz());
		bzxxVO.setNFy(rysxBzxx.getNFy().toString());
		bzxxVO.setNId(rysxBzxx.getNId().toString());
		bzxxVO.setNRybh(rysxBzxx.getNRybh().toString());
		return bzxxVO;
	}

	// myCode
	@Override
	public List<RyjbxxRylhTimeShowVo> listAllEventByByKuFydmBmName(String ku,
			String fydm, String bm, String name)
	{
		Map<String, String> mapNames = new HashMap<String, String>();
		List<RyjbxxRylhTimeVo> vos = new ArrayList<RyjbxxRylhTimeVo>();
		Ryjbxx rj = ryjbxxDAO.getRyjbxxByKuFydmBmName(ku, fydm, bm, name);
		String dwmc = dmDAO.dmByDmBxh(rj.getNFy(), ConstantsFyrs.NBXH_DWMC)
				.getCMc();
		// 政治面貌事件
		List<RysxZzmm> zzmms = rysxZzmmDAO.getZzmmByRybhFy(rj.getNFy(),
				rj.getNRybh());
		for (RysxZzmm zzmm : zzmms)
		{
			if (zzmm.getDJrrq() == null || zzmm.getDZzrq() == null)
			{
				continue;
			}
			String mc = DmMcCommon.dmMc(zzmm.getNZzmm(),
					ConstantsFyrs.NBXH_ZZMM, mapNames, dmDAO);
			instanceRyjbxxRylhTimeVo(zzmm.getDJrrq(),
					"您于" + dateFormat(zzmm.getDJrrq()) + "加入" + mc, vos);
			instanceRyjbxxRylhTimeVo(zzmm.getDZzrq(),
					"您于" + dateFormat(zzmm.getDZzrq()) + mc + "转正", vos);

		}
		// 行政职务事件
		List<RysxXzzw> xzzws = rysxXzzwDAO.getXzzwByRybhFy(rj.getNFy(),
				rj.getNRybh());
		for (RysxXzzw xzzw : xzzws)
		{
			if (xzzw.getDRmrq() == null)
			{
				continue;
			}
			String mc = DmMcCommon.dmMc(xzzw.getNXzzw(),
					ConstantsFyrs.NBXH_XZZW, mapNames, dmDAO);
			instanceRyjbxxRylhTimeVo(xzzw.getDRmrq(),
					"您于" + dateFormat(xzzw.getDRmrq()) + "在" + dwmc + "担任" + mc
							+ "职务", vos);
		}
		// 法律职务
		List<RysxFlzw> flzws = rysxFlzwDAO.getFlzwByRybhFy(rj.getNFy(),
				rj.getNRybh());
		for (RysxFlzw flzw : flzws)
		{
			if (flzw.getDRmrq() == null)
			{
				continue;
			}
			String mc = DmMcCommon.dmMc(flzw.getNFlzw(),
					ConstantsFyrs.NBXH_FLZW, mapNames, dmDAO);
			instanceRyjbxxRylhTimeVo(flzw.getDRmrq(),
					"您于" + dateFormat(flzw.getDRmrq()) + "在" + dwmc + "担任" + mc
							+ "职务", vos);
		}

		List<RysxZjxx> zjxxs = rysxZjxxDAO.getZjxxByRybhFy(rj.getNFy(),
				rj.getNRybh());
		for (RysxZjxx zjxx : zjxxs)
		{
			if (zjxx.getDRmrq() == null)
			{
				continue;
			}
			String mc = DmMcCommon.dmMc(zjxx.getNZj(), ConstantsFyrs.NBXH_ZJ,
					mapNames, dmDAO);
			instanceRyjbxxRylhTimeVo(zjxx.getDRmrq(),
					"您于" + dateFormat(zjxx.getDRmrq()) + "晋升" + mc + "职级", vos);
		}

		List<RysxDjxx> djxxs = rysxDjxxDAO.getDjxxByRybhFy(rj.getNFy(),
				rj.getNRybh());
		for (RysxDjxx djxx : djxxs)
		{
			if (djxx.getDQsrq() == null)
			{
				continue;
			}
			String mc = DmMcCommon.dmMc(djxx.getNDjmc(), ConstantsFyrs.NBXH_DJ,
					mapNames, dmDAO);
			instanceRyjbxxRylhTimeVo(djxx.getDQsrq(),
					"您于" + dateFormat(djxx.getDQsrq()) + "担任" + mc + "大法官"
							+ "," + "证书编号为：" + djxx.getCZsbh(), vos);
		}

		List<RysxGwy> gwys = rysxGwyDAO.getGwyjbByRybhFy(rj.getNFy(),
				rj.getNRybh());
		for (RysxGwy gwy : gwys)
		{
			if (gwy.getDQsrq() == null)
			{
				continue;
			}
			String mc = DmMcCommon.dmMc(gwy.getNGwyjb(),
					ConstantsFyrs.NBXH_GWYJB, mapNames, dmDAO);
			String gzdc = DmMcCommon.dmMc(gwy.getNGzdc(),
					ConstantsFyrs.NBXH_GZDC, mapNames, dmDAO);
			instanceRyjbxxRylhTimeVo(gwy.getDQsrq(),
					"您于" + dateFormat(gwy.getDQsrq()) + "在" + dwmc + "担任" + mc
							+ "公务员" + "," + "工资档次" + gzdc, vos);
		}

		List<RysxXlxx> xlxxs = rysxXlxxDAO.getXlxxByRybhFy(rj.getNFy(),
				rj.getNRybh());
		for (RysxXlxx xlxx : xlxxs)
		{
			if (xlxx.getDByrq() == null)
			{
				continue;
			}
			String xl = DmMcCommon.dmMc(xlxx.getNXl(), ConstantsFyrs.NBXH_WHCD,
					mapNames, dmDAO);
			String sxzy = DmMcCommon.dmMc(xlxx.getNSxzy(),
					ConstantsFyrs.NBXH_ZY, mapNames, dmDAO);
			instanceRyjbxxRylhTimeVo(
					xlxx.getDByrq(),
					"您于" + dateFormat(xlxx.getDByrq()) + "毕业于"
							+ xlxx.getCSydw() + "," + "学历为" + xl + ","
							+ "所学专业为" + sxzy, vos);
		}

		List<RysxXwxx> xwxxs = rysxXwxxDAO.getXwxxByRybhFy(rj.getNFy(),
				rj.getNRybh());
		for (RysxXwxx xwxx : xwxxs)
		{
			if (xwxx.getDByrq() == null)
			{
				continue;
			}
			String xw = DmMcCommon.dmMc(xwxx.getNXw(), ConstantsFyrs.NBXH_XW,
					mapNames, dmDAO);
			instanceRyjbxxRylhTimeVo(xwxx.getDByrq(),
					"您于" + dateFormat(xwxx.getDByrq()) + "在" + xwxx.getCXxmc()
							+ "获得" + xw, vos);
		}

		List<RysxZdxx> zdxxs = rysxZdxxDAO.getZdxxByRybhFy(rj.getNFy(),
				rj.getNRybh());
		for (RysxZdxx zdxx : zdxxs)
		{
			if (zdxx.getDRxrq() == null)
			{
				continue;
			}
			String zdxl = DmMcCommon.dmMc(zdxx.getNZdxl(),
					ConstantsFyrs.NBXH_WHCD, mapNames, dmDAO);
			String xxzy = DmMcCommon.dmMc(zdxx.getNSxzy(),
					ConstantsFyrs.NBXH_ZY, mapNames, dmDAO);
			instanceRyjbxxRylhTimeVo(zdxx.getDRxrq(),
					"您于" + dateFormat(zdxx.getDRxrq()) + "进入" + zdxx.getCZdyx()
							+ ",学历为" + zdxl + ",所学专业为" + xxzy, vos);
		}

		List<RysxPxxx> pxxxs = rysxPxxxDAO.getPxxxByRybhFy(rj.getNFy(),
				rj.getNRybh());
		for (RysxPxxx pxxx : pxxxs)
		{
			if (null != pxxx.getDKsrq())
			{
				String pxxs = DmMcCommon.dmMc(pxxx.getNPxxs(),
						ConstantsFyrs.NBXH_PXFS, mapNames, dmDAO);
				String zy = DmMcCommon.dmMc(pxxx.getNZy(),
						ConstantsFyrs.NBXH_ZY, mapNames, dmDAO);
				if (null == pxxx.getDJsrq())
				{
					instanceRyjbxxRylhTimeVo(
							pxxx.getDKsrq(),
							"您于" + dateFormat(pxxx.getDKsrq()) + "进入"
									+ pxxx.getCPxbmc() + "，培训形式为" + pxxs
									+ ",培训专业为" + zy, vos);
				} else
				{
					instanceRyjbxxRylhTimeVo(
							pxxx.getDKsrq(),
							"您于"
									+ dateFormat(pxxx.getDKsrq())
									+ "进入"
									+ pxxx.getCPxbmc()
									+ "，培训形式为"
									+ pxxs
									+ ",培训专业为"
									+ zy
									+ ",培训结束时间为"
									+ DateUtil.format(pxxx.getDJsrq(),
											DateUtil.chineseDtFormat), vos);
				}

			}
		}

		List<RysxKhxx> khxxs = rysxKhxxDAO.getKhxxByRybhFy(rj.getNFy(),
				rj.getNRybh());
		for (RysxKhxx khxx : khxxs)
		{
			String khjg = DmMcCommon.dmMc(khxx.getNKhjg(),
					ConstantsFyrs.NBXH_KH, mapNames, dmDAO);
			instanceRyjbxxRylhTimeVo(DateUtil.parse(khxx.getNNd() + "-12-31",
					DateUtil.newFormat), "您" + khxx.getNNd() + "的考核结果为" + khjg,
					vos);
		}

		List<RysxJianglixx> jianglixxs = rysxJianglixxDAO.getJlixxByRybhFy(
				rj.getNFy(), rj.getNRybh());
		for (RysxJianglixx jianglixx : jianglixxs)
		{
			if (jianglixx.getDJlsj() == null)
			{
				continue;
			}
			String jlyy = DmMcCommon.dmMc(jianglixx.getNJlyy(),
					ConstantsFyrs.NBXH_JLYY, mapNames, dmDAO);
			String jljb = DmMcCommon.dmMc(jianglixx.getNJljb(),
					ConstantsFyrs.NBXH_JLJB, mapNames, dmDAO);
			String jllb = DmMcCommon.dmMc(jianglixx.getNJllb(),
					ConstantsFyrs.NBXH_GRJLLB, mapNames, dmDAO);
			instanceRyjbxxRylhTimeVo(jianglixx.getDJlsj(), "您于"
					+ dateFormat(jianglixx.getDJlsj()) + "因" + jlyy + "获得"
					+ jljb + "的" + jllb, vos);
		}

		List<RysxCgxx> cgxxs = rysxCgxxDAO.getCgxxByRybhFy(rj.getNFy(),
				rj.getNRybh());
		for (RysxCgxx cgxx : cgxxs)
		{
			if (cgxx.getDKssj() == null)
			{
				continue;
			}
			String cgxz = DmMcCommon.dmMc(cgxx.getNCgxz(),
					ConstantsFyrs.NBXH_CGXZ, mapNames, dmDAO);
			String gj = DmMcCommon.dmMc(cgxx.getNGb(), ConstantsFyrs.NBXH_GJ,
					mapNames, dmDAO);
			instanceRyjbxxRylhTimeVo(
					cgxx.getDKssj(),
					"您于"
							+ dateFormat(cgxx.getDKssj())
							+ "因"
							+ cgxz
							+ "访问"
							+ gj
							+ ",归国时间为"
							+ DateUtil.format(cgxx.getDJssj(),
									DateUtil.chineseDtFormat), vos);
		}
		Collections.sort(vos, new RyjbxxRylhTimeVoComparator());
		List<RyjbxxRylhTimeShowVo> lists = new ArrayList<RyjbxxRylhTimeShowVo>();
		Map<String, RyjbxxRylhTimeShowVo> maps = new HashMap<String, RyjbxxRylhTimeShowVo>();
		for (RyjbxxRylhTimeVo vo : vos)
		{
			String key = DateUtil.format(vo.getEventTime(), "yyyy年");
			// 表示如果事件是今年发生的，那么它的 key 为 现在
			if (key.equals(DateUtil.format(new Date(), "yyyy年")))
			{
				key = "现在";
			}
			if (null == maps.get(key))
			{
				RyjbxxRylhTimeShowVo timeShowVo = new RyjbxxRylhTimeShowVo();
				timeShowVo.setName(key);
				maps.put(key, timeShowVo);
				lists.add(timeShowVo);
			}
			maps.get(key).getEventMonth().add(vo.getEvent());
		}
		return lists;
	}

	private void instanceRyjbxxRylhTimeVo(Date date, String event,
			List<RyjbxxRylhTimeVo> vos)
	{
		RyjbxxRylhTimeVo vo = new RyjbxxRylhTimeVo();
		vo.setEventTime(date);
		vo.setEvent(event);
		vos.add(vo);
	}

	private String dateFormat(Date date)
	{
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("MM月dd日");
		String str = simpleDateFormat.format(date);
		return str;
	}

	// myCode
	@Override
	public Integer getRyCountByTopAndLeftConditions(String topCondition,
			String leftCondition, Object[] topParams, Object[] leftParams)
	{
		return ryjbxxDAO.getRyCountByTopAndLeftConditions(topCondition,
				leftCondition, topParams, leftParams);
	}

	@Override
	public RysxPhoto getRysxPhoto(String fydm, String rybh)
	{
		return rysxPhotoDAO.getRysxPhoto(fydm, rybh);
	}

	@Override
	public boolean delRysxPhoto(String fydm, String rybh)
	{
		return rysxPhotoDAO.delRysxPhoto(fydm, rybh);
	}

	@Transactional
	@Override
	public boolean deleteRyjbxxAndAllSubTable(int fydm, int rybh)
	{
		boolean allDelete = true;
		boolean temp = true;
		// 政治面貌
		List<RysxZzmm> rysxZzmms = rysxZzmmDAO.getZzmmByRybhFy(fydm, rybh);
		for (RysxZzmm zzmm : rysxZzmms)
		{
			allDelete = rysxZzmmDAO.interceptDeleteRsZzmmById(zzmm);
			if (!allDelete)
			{
				temp = false;
			}
		}
		// 行政职务
		List<RysxXzzw> rysxXzzws = rysxXzzwDAO.getXzzwByRybhFy(fydm, rybh);
		for (RysxXzzw xzzw : rysxXzzws)
		{
			allDelete = rysxXzzwDAO.interceptDeleteRsXzzwById(xzzw);
			if (!allDelete)
			{
				temp = false;
			}
		}
		// 法律职务
		List<RysxFlzw> rysxFlzws = rysxFlzwDAO.getFlzwByRybhFy(fydm, rybh);
		for (RysxFlzw flzw : rysxFlzws)
		{
			allDelete = rysxFlzwDAO.interceptDeleteRsFlzwById(flzw);
			if (!allDelete)
			{
				temp = false;
			}
		}
		// 职级信息
		List<RysxZjxx> rysxZjxxs = rysxZjxxDAO.getZjxxByRybhFy(fydm, rybh);
		for (RysxZjxx zjxx : rysxZjxxs)
		{
			allDelete = rysxZjxxDAO.interceptDeleteRsZjxxById(zjxx);
			if (!allDelete)
			{
				temp = false;
			}
		}
		// 兼任职务
		List<RysxJzzw> rysxJzzws = rysxJzzwDAO.getJrzwByRybhFy(fydm, rybh);
		for (RysxJzzw jzzw : rysxJzzws)
		{
			allDelete = rysxJzzwDAO.interceptDeleteRsJrzwById(jzzw);
			if (!allDelete)
			{
				temp = false;
			}
		}
		// 等级信息
		List<RysxDjxx> rysxDjxxs = rysxDjxxDAO.getDjxxByRybhFy(fydm, rybh);
		for (RysxDjxx djxx : rysxDjxxs)
		{
			allDelete = rysxDjxxDAO.interceptDeleteRsDjxxById(djxx);
			if (!allDelete)
			{
				temp = false;
			}
		}
		// 学历信息
		List<RysxXlxx> rysxXlxxs = rysxXlxxDAO.getXlxxByRybhFy(fydm, rybh);
		for (RysxXlxx xlxx : rysxXlxxs)
		{
			allDelete = rysxXlxxDAO.interceptDeleteRsXlxxById(xlxx);
			if (!allDelete)
			{
				temp = false;
			}
		}
		// 学位信息
		List<RysxXwxx> rysxXwxxs = rysxXwxxDAO.getXwxxByRybhFy(fydm, rybh);
		for (RysxXwxx xwxx : rysxXwxxs)
		{
			allDelete = rysxXwxxDAO.interceptDeleteRsXwxxById(xwxx);
			if (!allDelete)
			{
				temp = false;
			}
		}
		// 在读信息
		List<RysxZdxx> rysxZdxxs = rysxZdxxDAO.getZdxxByRybhFy(fydm, rybh);
		for (RysxZdxx zdxx : rysxZdxxs)
		{
			allDelete = rysxZdxxDAO.interceptDeleteRsZdxxById(zdxx);
			if (!allDelete)
			{
				temp = false;
			}
		}
		// 培训信息
		List<RysxPxxx> rysxPxxxs = rysxPxxxDAO.getPxxxByRybhFy(fydm, rybh);
		for (RysxPxxx pxxx : rysxPxxxs)
		{
			allDelete = rysxPxxxDAO.interceptDeleteRsPxxxById(pxxx);
			if (!allDelete)
			{
				temp = false;
			}
		}
		// 简历信息
		List<RysxJlxx> rysxJlxxs = rysxJlxxDAO.getJlxxByRybhFy(fydm, rybh);
		for (RysxJlxx jlxx : rysxJlxxs)
		{
			allDelete = rysxJlxxDAO.interceptDeleteRsJlxxById(jlxx);
			if (!allDelete)
			{
				temp = false;
			}
		}
		// 家庭信息
		List<RysxJtxx> rysxJtxxs = rysxJtxxDAO.getJtxxByRybhFy(fydm, rybh);
		for (RysxJtxx jtxx : rysxJtxxs)
		{
			allDelete = rysxJtxxDAO.interceptDeleteRsJtxxById(jtxx);
			if (!allDelete)
			{
				temp = false;
			}
		}
		// 考核信息
		List<RysxKhxx> rysxKhxxs = rysxKhxxDAO.getKhxxByRybhFy(fydm, rybh);
		for (RysxKhxx khxx : rysxKhxxs)
		{
			allDelete = rysxKhxxDAO.interceptDeleteRsKhxxById(khxx);
			if (!allDelete)
			{
				temp = false;
			}
		}
		// 奖励信息
		List<RysxJianglixx> rysxJianglixxs = rysxJianglixxDAO.getJlixxByRybhFy(
				fydm, rybh);
		for (RysxJianglixx jianglixx : rysxJianglixxs)
		{
			allDelete = rysxJianglixxDAO
					.interceptDeleteRsJianglixxById(jianglixx);
			if (!allDelete)
			{
				temp = false;
			}
		}
		// 惩处信息
		List<RysxCcxx> rysxCcxxs = rysxCcxxDAO.getCcxxByRybhFy(fydm, rybh);
		for (RysxCcxx ccxx : rysxCcxxs)
		{
			allDelete = rysxCcxxDAO.interceptDeleteRsCcxxById(ccxx);
			if (!allDelete)
			{
				temp = false;
			}
		}
		// 出国信息
		List<RysxCgxx> rysxCgxxs = rysxCgxxDAO.getCgxxByRybhFy(fydm, rybh);
		for (RysxCgxx cgxx : rysxCgxxs)
		{
			allDelete = rysxCgxxDAO.interceptDeleteRsCgxxById(cgxx);
			if (!allDelete)
			{
				temp = false;
			}
		}
		// 外语信息
		List<RysxWyxx> rysxWyxxs = rysxWyxxDAO.getWyxxByRybhFy(fydm, rybh);
		for (RysxWyxx wyxx : rysxWyxxs)
		{
			allDelete = rysxWyxxDAO.interceptDeleteRsWyxxById(wyxx);
			if (!allDelete)
			{
				temp = false;
			}
		}
		// 交流信息
		List<RysxJiaoliuxx> rysxJiaoliuxxs = rysxJiaoliuxxDAO
				.getJiaoliuxxByRybhFy(fydm, rybh);
		for (RysxJiaoliuxx jiaoliuxx : rysxJiaoliuxxs)
		{
			allDelete = rysxJiaoliuxxDAO
					.interceptDeleteRsJiaoliuxxById(jiaoliuxx);
			if (!allDelete)
			{
				temp = false;
			}
		}
		// 司法考试
		List<RysxSfks> rysxSfkss = rysxSfksDAO.getSfksByRybhFy(fydm, rybh);
		for (RysxSfks sfks : rysxSfkss)
		{
			allDelete = rysxSfksDAO.interceptDeleteRsSfksById(sfks);
			if (!allDelete)
			{
				temp = false;
			}
		}
		// 专业技术职务
		List<RysxZyjszw> rysxZyjszws = rysxZyjszwDAO.getZyjszwByRybhFy(fydm,
				rybh);
		for (RysxZyjszw zyjszw : rysxZyjszws)
		{
			allDelete = rysxZyjszwDAO.interceptDeleteRsZyjszwById(zyjszw);
			if (!allDelete)
			{
				temp = false;
			}
		}
		// 伤亡信息
		List<RysxSwxx> rysxSwxxs = rysxSwxxDAO.getSwxxByRybhFy(fydm, rybh);
		for (RysxSwxx swxx : rysxSwxxs)
		{
			allDelete = rysxSwxxDAO.interceptDeleteRsSwxxById(swxx);
			if (!allDelete)
			{
				temp = false;
			}
		}
		// 备注信息
		List<RysxBzxx> rysxBzxxs = rysxBzxxDAO.getBzxxByRybhFy(fydm, rybh);
		for (RysxBzxx bzxx : rysxBzxxs)
		{
			allDelete = rysxBzxxDAO.interceptDeleteRsBzxxById(bzxx);
			if (!allDelete)
			{
				temp = false;
			}
		}
		// 声音与影像
		// List<RysxSyyyx> rysxSyyyxs = rysxSyyyxDAO.getSyyyxByRybh(rybh+"");
		// for(RysxSyyyx syyyx : rysxSyyyxs)
		// {
		// allDelete = rysxSyyyxDAO.interceptDeleteRsSyyyxById(syyyx);
		// if(!allDelete)
		// {
		// temp = false;
		// }
		// }
		// 工资信息
		List<RysxGzxx> rysxGzxxs = rysxGzxxDAO.getGzxxByRybhFy(fydm, rybh);
		for (RysxGzxx gzxx : rysxGzxxs)
		{
			allDelete = rysxGzxxDAO.interceptDeleteRsGzxxById(gzxx);
			if (!allDelete)
			{
				temp = false;
			}
		}
		// 后备干部
		List<RysxHbgb> rysxHbgbs = rysxHbgbDAO.getHbgbByRybhFy(fydm, rybh);
		for (RysxHbgb hbgb : rysxHbgbs)
		{
			allDelete = rysxHbgbDAO.interceptDeleteRsHbgbById(hbgb);
			if (!allDelete)
			{
				temp = false;
			}
		}
		// 通讯录
		List<RysxTxl> rysxTxls = rysxTxlDAO.getTxlByRybhFy(fydm, rybh);
		for (RysxTxl txl : rysxTxls)
		{
			allDelete = rysxTxlDAO.interceptDeleteRsTxlById(txl);
			if (!allDelete)
			{
				temp = false;
			}
		}
		// 领导班子
		List<RysxLdbz> rysxLdbzs = rysxLdbzDAO.getLdbzByRybhFy(fydm, rybh);
		for (RysxLdbz ldbz : rysxLdbzs)
		{
			allDelete = rysxLdbzDAO.interceptDeleteRsLdbzById(ldbz);
			if (!allDelete)
			{
				temp = false;
			}
		}
		// 公务员
		List<RysxGwy> rysxGwys = rysxGwyDAO.getGwyjbByRybhFy(fydm, rybh);
		for (RysxGwy gwy : rysxGwys)
		{
			allDelete = rysxGwyDAO.interceptDeleteRsGwyById(gwy);
			if (!allDelete)
			{
				temp = false;
			}
		}
		boolean jbxxDelete = false;	
		Jgxx jgxx = null;
		Ryjbxx ryjbxx = ryjbxxDAO.getRyjbxxByRybhFyDm(rybh, fydm);
		jgxx = jgxxDAO.bmByFyIdAndNcode(ryjbxx.getNFy(),ryjbxx.getNBm());
		if(jgxx == null)
		{
			jgxx = jgxxDAO.findJgxxByFyUnicode(ryjbxx.getNFy(),ryjbxx.getNUnicode());
		}
		if(jgxx == null)
		{
			logger.debug("系统BUG数据存储不完整，每个人应该对应一个机构！");
		}
		else
		{
			int oldRs = jgxx.getNRysl();
			if(oldRs < 1)
			{
				logger.debug("系统BUG数据存储不完整，机构至少包含一个人！");
			}
			else
			{
				jgxx.setNRysl(jgxx.getNRysl() - 1);
				jgxxDAO.updateJgxx(jgxx);
			}
			
		}
		jbxxDelete = ryjbxxDAO.interceptDeleteRyjbxx(ryjbxx);
		return (temp && jbxxDelete);
	}

	@Override
	public int getMaxRybhByFydm(int fydm)
	{
		int rybh = ryjbxxDAO.getMaxRybhByFydm(fydm);
		return rybh;
	}

	@Transactional
	@Override
	public boolean addRyFromLsk(String fysrc, String rybh, String fydst,
			String bmdst) {
		int iFysrc = Integer.valueOf(fysrc);
		int iRybh = Integer.valueOf(rybh);
		int iFydst = Integer.valueOf(fydst);
		int iBmdst = Integer.valueOf(bmdst);
		Ryjbxx ry = this.getRyjbxxByRybhFyDm(iRybh, iFysrc);
		int rybhNew = ryjbxxDAO.getMaxRybhByFydm(iFydst);
		Ryjbxx ryNew = new Ryjbxx(iFydst, rybhNew, ry.getCBs(), ry.getCMm(),
				ry.getCRybh(), ry.getCCodeJg1(), ry.getCCodeJg2(),
				ry.getCCodeJg3(), ry.getCXm(), ry.getCCym(), ry.getNXb(),
				iBmdst, ry.getNUnicode(), ry.getNGwxz(), ry.getCJg(),
				ry.getCCsd(), ry.getDCsrq(), ry.getNJkzk(), ry.getNHyzk(),
				ry.getNMz(), ry.getCSfzh(), ry.getNBz(), ry.getNZwlb(),
				ry.getDZwlbsj(), ry.getNRyfs(), ry.getNXl(), ry.getNZy(),
				ry.getNXw(), ry.getDHdxwrq(), ry.getDGzrq(), ry.getDJyrq(),
				ry.getNZyzs(), ry.getDHdzsrq(), ry.getNZzmm(), ry.getDZzmm(),
				ry.getDZfgzrq(), ry.getNXzzw(), ry.getDXzzwRzrq(),
				ry.getNFlzw(), ry.getDFlzwRzrq(), ry.getNJrtz(), ry.getNDzzw(),
				ry.getDDzzwrq(), ry.getDFgzgrq(), ry.getNBcgl(), ry.getNKjgl(),
				ry.getNJyqfynx(), ry.getNZj(), ry.getDZjrq(), ry.getNDj(),
				ry.getDDjrq(), ry.getNJtj(), ry.getNJly(), ry.getNYzw(),
				ry.getNYzj(), ry.getCYdw(), ry.getDShrq(), null, null,
				ry.getNQx(), ryjbxxDAO.getMaxXssxByFydm(iFydst), ry.getNYx(),
				ry.getNPjnl(), ry.getNYjxz(), ry.getNSffg(), ry.getDQdfgzgzs(),
				ry.getNGwyjb(), ry.getDGwyrq(), ry.getNQdfgzgzs(), 1);
		ryjbxxDAO.interceptSaveRyjbxx(ryNew);
		//将原人员加入历史库
		ry.setNBiaozhi(0);
		ry.setNCyy(1);
		ry.setNQx(1);
		ry.setDCrq(DateUtil.today());
		ryjbxxDAO.interceptUpdateRyjbxx(ry);
		try {
			List<RysxBzxx> bzxxList = rysxBzxxDAO
					.getBzxxByRybhFy(iRybh, iFysrc);
			for (RysxBzxx bzxxS : bzxxList) {
				RysxBzxx bzxx = CloneConvertor.cloneXx(bzxxS);
				bzxx.setNFy(iFydst);
				bzxx.setNRybh(rybhNew);
				rysxBzxxDAO.interceptAddBzxx(bzxx);
			}
			List<RysxCcxx> ccxxList = rysxCcxxDAO
					.getCcxxByRybhFy(iRybh, iFysrc);
			for (RysxCcxx ccxxS : ccxxList) {
				RysxCcxx ccxx = CloneConvertor.cloneXx(ccxxS);
				ccxx.setNFy(iFydst);
				ccxx.setNRybh(rybhNew);
				rysxCcxxDAO.interceptAddCcxx(ccxx);
			}
			List<RysxCgxx> cgxxList = rysxCgxxDAO
					.getCgxxByRybhFy(iRybh, iFysrc);
			for (RysxCgxx cgxxS : cgxxList) {
				RysxCgxx cgxx = CloneConvertor.cloneXx(cgxxS);
				cgxx.setNFy(iFydst);
				cgxx.setNRybh(rybhNew);
				rysxCgxxDAO.interceptAddCgxx(cgxx);
			}
			List<RysxDjxx> djxxList = rysxDjxxDAO
					.getDjxxByRybhFy(iRybh, iFysrc);
			for (RysxDjxx djxxS : djxxList) {
				RysxDjxx djxx = CloneConvertor.cloneXx(djxxS);
				djxx.setNFy(iFydst);
				djxx.setNRybh(rybhNew);
				rysxDjxxDAO.interceptAddDjxx(djxx);
			}
			List<RysxFlzw> flzwList = rysxFlzwDAO
					.getFlzwByRybhFy(iRybh, iFysrc);
			for (RysxFlzw flzwS : flzwList) {
				RysxFlzw flzw = CloneConvertor.cloneXx(flzwS);
				flzw.setNFy(iFydst);
				flzw.setNRybh(rybhNew);
				rysxFlzwDAO.interceptAddFlzw(flzw);
			}
			List<RysxGwy> gwyList = rysxGwyDAO.getGwyjbByRybhFy(iRybh, iFysrc);
			for (RysxGwy gwyS : gwyList) {
				RysxGwy gwy = CloneConvertor.cloneXx(gwyS);
				gwy.setNFy(iFydst);
				gwy.setNRybh(rybhNew);
				rysxGwyDAO.interceptAddGwy(gwy);
			}
			List<RysxGzxx> gzxxList = rysxGzxxDAO
					.getGzxxByRybhFy(iRybh, iFysrc);
			for (RysxGzxx gzxxS : gzxxList) {
				RysxGzxx gzxx = CloneConvertor.cloneXx(gzxxS);
				gzxx.setNFy(iFydst);
				gzxx.setNRybh(rybhNew);
				rysxGzxxDAO.interceptAddGzxx(gzxx);
			}
			List<RysxHbgb> hbgbList = rysxHbgbDAO
					.getHbgbByRybhFy(iRybh, iFysrc);
			for (RysxHbgb hbgbS : hbgbList) {
				RysxHbgb hbgb = CloneConvertor.cloneXx(hbgbS);
				hbgb.setNFy(iFydst);
				hbgb.setNRybh(rybhNew);
				rysxHbgbDAO.interceptAddHbgb(hbgb);
			}
			List<RysxJianglixx> jianglixxList = rysxJianglixxDAO
					.getJlixxByRybhFy(iRybh, iFysrc);
			for (RysxJianglixx jianglixxS : jianglixxList) {
				RysxJianglixx jianglixx = CloneConvertor
						.cloneXx(jianglixxS);
				jianglixx.setNFy(iFydst);
				jianglixx.setNRybh(rybhNew);
				rysxJianglixxDAO.interceptAddJianglixx(jianglixx);
			}
			List<RysxJiaoliuxx> jiaoliuxxList = rysxJiaoliuxxDAO
					.getJiaoliuxxByRybhFy(iRybh, iFysrc);
			for (RysxJiaoliuxx jiaoliuxxS : jiaoliuxxList) {
				RysxJiaoliuxx jiaoliuxx = CloneConvertor.cloneXx(jiaoliuxxS);
				jiaoliuxx.setNFy(iFydst);
				jiaoliuxx.setNRybh(rybhNew);
				rysxJiaoliuxxDAO.interceptAddRsJiaoliuxx(jiaoliuxx);
			}
			List<RysxJlxx> jlxxList = rysxJlxxDAO
					.getJlxxByRybhFy(iRybh, iFysrc);
			for (RysxJlxx jlxxS : jlxxList) {
				RysxJlxx jlxx = CloneConvertor.cloneXx(jlxxS);
				jlxx.setNFy(iFydst);
				jlxx.setNRybh(rybhNew);
				rysxJlxxDAO.interceptAddJlxx(jlxx);
			}
			List<RysxJtxx> jtxxList = rysxJtxxDAO
					.getJtxxByRybhFy(iRybh, iFysrc);
			for (RysxJtxx jtxxS : jtxxList) {
				RysxJtxx jtxx = CloneConvertor.cloneXx(jtxxS);
				jtxx.setNFy(iFydst);
				jtxx.setNRybh(rybhNew);
				rysxJtxxDAO.interceptAddJtxx(jtxx);
			}
			List<RysxJzzw> jzzwList = rysxJzzwDAO
					.getJrzwByRybhFy(iRybh, iFysrc);
			for (RysxJzzw jzzwS : jzzwList) {
				RysxJzzw jzzw = CloneConvertor.cloneXx(jzzwS);
				jzzw.setNFy(iFydst);
				jzzw.setNRybh(rybhNew);
				rysxJzzwDAO.interceptAddJrzw(jzzw);
			}
			List<RysxKhxx> khxxList = rysxKhxxDAO
					.getKhxxByRybhFy(iRybh, iFysrc);
			for (RysxKhxx khxxS : khxxList) {
				RysxKhxx khxx = CloneConvertor.cloneXx(khxxS);
				khxx.setNFy(iFydst);
				khxx.setNRybh(rybhNew);
				rysxKhxxDAO.interceptAddKhxx(khxx);
			}
			List<RysxLdbz> ldbzList = rysxLdbzDAO
					.getLdbzByRybhFy(iRybh, iFysrc);
			for (RysxLdbz ldbzS : ldbzList) {
				RysxLdbz ldbz = CloneConvertor.cloneXx(ldbzS);
				ldbz.setNFy(iFydst);
				ldbz.setNRybh(rybhNew);
				rysxLdbzDAO.interceptAddLdbz(ldbz);
			}
			RysxPhoto photo = rysxPhotoDAO.getRysxPhoto(fysrc, rybh);
			if(photo != null){
				RysxPhoto photoN = CloneConvertor.cloneXx(photo);
				photoN.setNFy(iFydst);
				photoN.setNRybh(rybhNew);
				rysxPhotoDAO.save(photoN);
			}

			List<RysxPxxx> pxxxList = rysxPxxxDAO
					.getPxxxByRybhFy(iRybh, iFysrc);
			for (RysxPxxx pxxxS : pxxxList) {
				RysxPxxx pxxx = CloneConvertor.cloneXx(pxxxS);
				pxxx.setNFy(iFydst);
				pxxx.setNRybh(rybhNew);
				rysxPxxxDAO.interceptAddPxxx(pxxx);
			}
			List<RysxSfks> sfksList = rysxSfksDAO
					.getSfksByRybhFy(iRybh, iFysrc);
			for (RysxSfks sfksS : sfksList) {
				RysxSfks sfks = CloneConvertor.cloneXx(sfksS);
				sfks.setNFy(iFydst);
				sfks.setNRybh(rybhNew);
				rysxSfksDAO.interceptAddSfks(sfks);
			}
			List<RysxSwxx> swxxList = rysxSwxxDAO
					.getSwxxByRybhFy(iRybh, iFysrc);
			for (RysxSwxx swxxS : swxxList) {
				RysxSwxx swxx = CloneConvertor.cloneXx(swxxS);
				swxx.setNFy(iFydst);
				swxx.setNRybh(rybhNew);
				rysxSwxxDAO.interceptAddSwxx(swxx);
			}
			List<RysxTxl> txlList = rysxTxlDAO.getTxlByRybhFy(iRybh, iFysrc);
			for (RysxTxl txlS : txlList) {
				RysxTxl txl = CloneConvertor.cloneXx(txlS);
				txl.setNFy(iFydst);
				txl.setNRybh(rybhNew);
				rysxTxlDAO.interceptAddTxl(txl);
			}
			List<RysxWyxx> wyxxList = rysxWyxxDAO
					.getWyxxByRybhFy(iRybh, iFysrc);
			for (RysxWyxx wyxxS : wyxxList) {
				RysxWyxx wyxx = CloneConvertor.cloneXx(wyxxS);
				wyxx.setNFy(iFydst);
				wyxx.setNRybh(rybhNew);
				rysxWyxxDAO.interceptAddWyxx(wyxx);
			}
			List<RysxXlxx> xlxxList = rysxXlxxDAO
					.getXlxxByRybhFy(iRybh, iFysrc);
			for (RysxXlxx xlxxS : xlxxList) {
				RysxXlxx xlxx = CloneConvertor.cloneXx(xlxxS);
				xlxx.setNFy(iFydst);
				xlxx.setNRybh(rybhNew);
				rysxXlxxDAO.interceptAddXlxx(xlxx);
			}
			List<RysxXwxx> xwxxList = rysxXwxxDAO
					.getXwxxByRybhFy(iRybh, iFysrc);
			for (RysxXwxx xwxxS : xwxxList) {
				RysxXwxx xwxx = CloneConvertor.cloneXx(xwxxS);
				xwxx.setNFy(iFydst);
				xwxx.setNRybh(rybhNew);
				rysxXwxxDAO.interceptAddXwxx(xwxx);
			}
			List<RysxXzzw> xzzwList = rysxXzzwDAO
					.getXzzwByRybhFy(iRybh, iFysrc);
			for (RysxXzzw xzzwS : xzzwList) {
				RysxXzzw xzzw = CloneConvertor.cloneXx(xzzwS);
				xzzw.setNFy(iFydst);
				xzzw.setNRybh(rybhNew);
				rysxXzzwDAO.interceptAddXzzw(xzzw);
			}
			List<RysxZdxx> zdxxList = rysxZdxxDAO
					.getZdxxByRybhFy(iRybh, iFysrc);
			for (RysxZdxx zdxxS : zdxxList) {
				RysxZdxx zdxx = CloneConvertor.cloneXx(zdxxS);
				zdxx.setNFy(iFydst);
				zdxx.setNRybh(rybhNew);
				rysxZdxxDAO.interceptAddZdxx(zdxx);
			}
			List<RysxZjxx> zjxxList = rysxZjxxDAO
					.getZjxxByRybhFy(iRybh, iFysrc);
			for (RysxZjxx zjxxS : zjxxList) {
				RysxZjxx zjxx = CloneConvertor.cloneXx(zjxxS);
				zjxx.setNFy(iFydst);
				zjxx.setNRybh(rybhNew);
				rysxZjxxDAO.save(zjxx);
			}
			List<RysxZyjszw> zyjszwList = rysxZyjszwDAO.getZyjszwByRybhFy(
					iRybh, iFysrc);
			for (RysxZyjszw zyjszwS : zyjszwList) {
				RysxZyjszw zyjszw = CloneConvertor.cloneXx(zyjszwS);
				zyjszw.setNFy(iFydst);
				zyjszw.setNRybh(rybhNew);
				rysxZyjszwDAO
						.interceptAddZyjszw(zyjszw);
			}
			List<RysxZzmm> zzmmList = rysxZzmmDAO
					.getZzmmByRybhFy(iRybh, iFysrc);
			for (RysxZzmm zzmmS : zzmmList) {
				RysxZzmm zzmm = CloneConvertor.cloneXx(zzmmS);
				zzmm.setNFy(iFydst);
				zzmm.setNRybh(rybhNew);
				rysxZzmmDAO.interceptAddZzmm(zzmm);
			}
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		}
		return true;
	}

	@Override
	public List<RysxHtVO> getHtxxByRybhFy(int fydm, int rybh) {
		// TODO Auto-generated method stub
		List<RysxHt> rysxXiujias = rysxHtDAO.getRysxHtByRybh(rybh,fydm);
		List<RysxHtVO> vos = new ArrayList<RysxHtVO>();
		for(RysxHt rysxXiujia:rysxXiujias){
			RysxHtVO rysxXiujiaVO = new RysxHtVO();
			rysxXiujiaVO.setNId(rysxXiujia.getNId().toString());
			rysxXiujiaVO.setNFy(rysxXiujia.getNFy().toString());
			rysxXiujiaVO.setNRybh(rysxXiujia.getNRybh().toString());
			rysxXiujiaVO.setCHtbh(rysxXiujia.getCHtbh());
			rysxXiujiaVO.setCHtqx(rysxXiujia.getCHtqx());
			if(rysxXiujia.getNPrzw() != null  && dmDAO.getDmByMc(rysxXiujia.getNPrzw(), "行政职务") != null){
				rysxXiujiaVO.setNPrzw(dmDAO.getDmByMc(rysxXiujia.getNPrzw(), "行政职务"));
			}	
			rysxXiujiaVO.setCBz(rysxXiujia.getCBz());
			if(rysxXiujia.getNHtlb() != null && dmDAO.getDmByMc(rysxXiujia.getNHtlb(), "合同类别") != null){
				rysxXiujiaVO.setNHtlb(dmDAO.getDmByMc(rysxXiujia.getNHtlb(), "合同类别"));
			}
			rysxXiujiaVO.setDQdrq(DateUtil.format(rysxXiujia.getDQdrq(), DateUtil.webFormat));
			vos.add(rysxXiujiaVO);
		}
		return vos;
	}

	@Override
	public RysxHtVO getRsHtxxById(String id, String fydm, String rybh) {
		// TODO Auto-generated method stub
		RysxHt rysxXiujia = rysxHtDAO.getRysxHtById(id, fydm, rybh);
		RysxHtVO htxxVO = new RysxHtVO();
		htxxVO.setCBz(rysxXiujia.getCBz());
		htxxVO.setNFy(rysxXiujia.getNFy().toString());
		htxxVO.setNId(rysxXiujia.getNId().toString());
		htxxVO.setNRybh(rysxXiujia.getNRybh().toString());
		htxxVO.setCHtbh(rysxXiujia.getCHtbh());
		htxxVO.setCHtqx(rysxXiujia.getCHtqx());
		if(rysxXiujia.getNPrzw() != null  && dmDAO.getDmByMc(rysxXiujia.getNPrzw(), "行政职务") != null){
			htxxVO.setNPrzw(dmDAO.getDmByMc(rysxXiujia.getNPrzw(), "行政职务"));
		}	
		htxxVO.setDQdrq(rysxXiujia.getDQdrq()==null?"":DateUtil.format(rysxXiujia.getDQdrq(), DateUtil.webFormat));
		if(rysxXiujia.getNHtlb() != null && dmDAO.getDmByMc(rysxXiujia.getNHtlb(), "合同类别") != null){
			htxxVO.setNHtlb(dmDAO.getDmByMc(rysxXiujia.getNHtlb(), "合同类别"));
		}
		
		return htxxVO;
	}

	@Override
	public boolean delRsHtxxById(String id, String fydm, String rybh) {
		// TODO Auto-generated method stub
		RysxHt rysxXiujia = rysxHtDAO.getRysxHtById(id, fydm, rybh);
		return rysxHtDAO.interceptDeleteRsXlxxById(rysxXiujia);
	}

	@Override
	public RysxHtVO addHtxx(RysxHtVO vo) {
		// TODO Auto-generated method stub
		RysxHt rysxXiujia = new RysxHt();
		int fydm = Integer.valueOf(vo.getNFy());
		rysxXiujia.setNFy(fydm);
		BigDecimal bd = rysxTablekeyDAO.getMaxId(fydm, "N_HTID");
		rysxXiujia.setNId(bd);
		rysxXiujia.setNRybh(Integer.parseInt(vo.getNRybh()));
		rysxXiujia.setCHtbh(vo.getCHtbh());
		rysxXiujia.setCHtqx(vo.getCHtqx());
		rysxXiujia.setNHtlb(Integer.parseInt(vo.getNHtlb()));
		rysxXiujia.setNPrzw(Integer.parseInt(vo.getNPrzw()));
		if (StringUtil.isNotBlank(vo.getDQdrq()))
		{
			rysxXiujia.setDQdrq(DateUtil.parse(vo.getDQdrq(), DateUtil.webFormat));
		}
		rysxXiujia.setCBz(vo.getCBz());
		rysxHtDAO.interceptAddHt(rysxXiujia);
		vo.setNId(bd.toString());
		vo.setNHtlb(dmDAO.getDmByMc(rysxXiujia.getNHtlb(), "addHtxx"));
		vo.setNPrzw(dmDAO.getDmByMc(rysxXiujia.getNPrzw(), "行政职务"));
		return vo;
	}

	@Override
	public RysxHtVO updateRsHtxx(RysxHtVO vo) {
		// TODO Auto-generated method stub
		RysxHt rysxXiujia =  rysxHtDAO.getRysxHtById(vo.getNId(), vo.getNFy(), vo.getNRybh());
		try
		{
			ObjectByteThreadLocal.setObjectByte(ObjectSerializedUtils
					.writeObjectToMemory(rysxXiujia));
		} catch (Exception ex)
		{
			ex.printStackTrace();
		}
		rysxXiujia.setCHtbh(vo.getCHtbh());
		rysxXiujia.setCHtqx(vo.getCHtqx());
		rysxXiujia.setNPrzw(Integer.parseInt(vo.getNPrzw()));
		if (StringUtil.isNotBlank(vo.getDQdrq()))
		{
			rysxXiujia.setDQdrq(DateUtil.parse(vo.getDQdrq(), DateUtil.webFormat));
		}
		rysxXiujia.setCBz(vo.getCBz());
		rysxHtDAO.interceptUpdateXlxx(rysxXiujia);
		return vo;
	}

	@Override
	public long countByXzzw(int fydm, String xzzw) {
		return ryjbxxDAO.countByXzzw(fydm, xzzw);
	}

	@Override
	public ZjxxVO addZjxx(ZjxxVO vo) {
		// TODO Auto-generated method stub
		RysxZjxx rysxZjxx = new RysxZjxx();
		int fydm = Integer.valueOf(vo.getNFy());
		rysxZjxx.setNFy(fydm);
		BigDecimal bd = rysxTablekeyDAO.getMaxId(fydm, "N_ZJXXID");
		rysxZjxx.setNId(bd);
		rysxZjxx.setNRybh(Integer.parseInt(vo.getNRybh()));
		rysxZjxx.setCBm(vo.getCBm());
		rysxZjxx.setCDw(vo.getCDw());
		rysxZjxx.setCJlid(vo.getCJlid());
		rysxZjxx.setCPzdw(vo.getCPzdw());
		rysxZjxx.setCPzwh(vo.getCPzwh());
		if(StringUtil.isBlank(vo.getDPzrq())){
			rysxZjxx.setDPzrq(DateUtil.parse(vo.getDPzrq(), DateUtil.webFormat));
		}
		if(StringUtil.isBlank(vo.getDRmrq())){
			rysxZjxx.setDRmrq(DateUtil.parse(vo.getDRmrq(), DateUtil.webFormat));
		}
		rysxZjxx.setNDqxx(Short.parseShort(vo.getNDqxx()));
		rysxZjxx.setNRmlb(Integer.parseInt(vo.getNRmlb()));
		rysxZjxx.setNRmyy(Integer.parseInt(vo.getNRmyy()));
		rysxZjxx.setNZj(Integer.parseInt(vo.getNZj()));
		rysxZjxx.setNZjxz(Integer.parseInt(vo.getNZjxz()));
		rysxZjxxDAO.interceptAddZjxx(rysxZjxx);
		vo.setNId(bd.toString());
		vo.setNRmlb(dmDAO.getDmByMc(rysxZjxx.getNRmlb(),"任免类别"));
		vo.setNRmyy(dmDAO.getDmByMc(rysxZjxx.getNRmyy(), "任免原因"));
		vo.setNZj(dmDAO.getDmByMc(rysxZjxx.getNZj(), "职级"));
		vo.setNZjxz(dmDAO.getDmByMc(rysxZjxx.getNZjxz(), "职级性质"));
		return vo;
	}

	@Override
	public boolean delRsZjxxById(String id, String fydm, String rybh) {
		// TODO Auto-generated method stub
		RysxZjxx rysxZjxx = rysxZjxxDAO.getRsZjxxById(id, fydm, rybh);
		return rysxZjxxDAO.interceptDeleteRsZjxxById(rysxZjxx);
	}

	@Override
	public ZjxxVO updateRsZjxx(ZjxxVO vo) {
		// TODO Auto-generated method stub
		RysxZjxx rysxZjxx = rysxZjxxDAO.getRsZjxxById(vo.getNId(), vo.getNFy(), vo.getNRmlb());
		try
		{
			ObjectByteThreadLocal.setObjectByte(ObjectSerializedUtils
					.writeObjectToMemory(rysxZjxx));
		} catch (Exception ex)
		{
			ex.printStackTrace();
		}
		rysxZjxx.setCBm(vo.getCBm());
		rysxZjxx.setCDw(vo.getCDw());
		rysxZjxx.setCJlid(vo.getCJlid());
		rysxZjxx.setCPzdw(vo.getCPzdw());
		rysxZjxx.setCPzwh(vo.getCPzwh());
		if(StringUtil.isBlank(vo.getDPzrq())){
			rysxZjxx.setDPzrq(DateUtil.parse(vo.getDPzrq(), DateUtil.webFormat));
		}
		if(StringUtil.isBlank(vo.getDRmrq())){
			rysxZjxx.setDRmrq(DateUtil.parse(vo.getDRmrq(), DateUtil.webFormat));
		}
		rysxZjxx.setNDqxx(Short.parseShort(vo.getNDqxx()));
		rysxZjxx.setNRmlb(Integer.parseInt(vo.getNRmlb()));
		rysxZjxx.setNRmyy(Integer.parseInt(vo.getNRmyy()));
		rysxZjxx.setNZj(Integer.parseInt(vo.getNZj()));
		rysxZjxx.setNZjxz(Integer.parseInt(vo.getNZjxz()));
		rysxZjxxDAO.interceptUpdateZjxx(rysxZjxx);		
		return vo;
	}

	@Override
	public List<XiujiaVO> getXiujiaByRybhFy(int fydm, int rybh) {
		// TODO Auto-generated method stub
		List<RysxXiujia> rysxXiujias = xiujiaDAO.getXiujiaByRybhFy(rybh, fydm);
		List<XiujiaVO> vos = new ArrayList<XiujiaVO>();
		for(RysxXiujia rysxXiujia:rysxXiujias){
			XiujiaVO rysxXiujiaVO = new XiujiaVO();
			rysxXiujiaVO.setNId(rysxXiujia.getNId().toString());
			rysxXiujiaVO.setNFy(rysxXiujia.getNFy().toString());
			rysxXiujiaVO.setNRybh(rysxXiujia.getNRybh().toString());
			rysxXiujiaVO.setDJssj(DateUtil.format(rysxXiujia.getDJssj(), DateUtil.webFormat));
			rysxXiujiaVO.setDKssj(DateUtil.format(rysxXiujia.getDKssj(), DateUtil.webFormat));
			rysxXiujiaVO.setCXjsy(rysxXiujia.getCXjsy());
			rysxXiujiaVO.setNType(dmDAO.getDmByMc(rysxXiujia.getNType(), "休假类型"));
			rysxXiujiaVO.setNXjts(String.valueOf(DateUtil.getDiffDays(rysxXiujia.getDJssj(),rysxXiujia.getDKssj())));
			vos.add(rysxXiujiaVO);
		}
		return vos;
	}

	@Override
	public XiujiaVO getXiujiaById(String id, String fydm, String rybh) {
		// TODO Auto-generated method stub
		RysxXiujia rysxXiujia = xiujiaDAO.getRsXiujiaById(id, fydm, rybh);
		XiujiaVO vo = new XiujiaVO();
		
		vo.setNId(rysxXiujia.getNId().toString());
		vo.setNFy(rysxXiujia.getNFy().toString());
		vo.setNRybh(rysxXiujia.getNRybh().toString());
		vo.setDJssj(DateUtil.format(rysxXiujia.getDJssj(), DateUtil.webFormat));
		vo.setDKssj(DateUtil.format(rysxXiujia.getDKssj(), DateUtil.webFormat));
		vo.setCXjsy(rysxXiujia.getCXjsy());
		vo.setNType(dmDAO.getDmByMc(rysxXiujia.getNType(), "休假类型"));
		vo.setNXjts(String.valueOf(DateUtil.getDiffDays(rysxXiujia.getDKssj(),rysxXiujia.getDJssj())));	
		return vo;
	}
	
	@Override
	public XiujiaVO updateXiujia(XiujiaVO vo) {
		// TODO Auto-generated method stub
		RysxXiujia rysxXiujia = xiujiaDAO.getRsXiujiaById(vo.getNId(), vo.getNFy(), vo.getNRybh());
		try
		{
			ObjectByteThreadLocal.setObjectByte(ObjectSerializedUtils
					.writeObjectToMemory(rysxXiujia));
		} catch (Exception ex)
		{
			ex.printStackTrace();
		}
		if(StringUtil.isNotBlank(vo.getDJssj())){
			rysxXiujia.setDJssj(DateUtil.parse(vo.getDJssj(), DateUtil.webFormat));
		}
		if(StringUtil.isNotBlank(vo.getDKssj())){
			rysxXiujia.setDKssj(DateUtil.parse(vo.getDKssj(), DateUtil.webFormat));
		}
		rysxXiujia.setCXjsy(vo.getCXjsy());
		rysxXiujia.setNType(Integer.parseInt(vo.getNType()));
		xiujiaDAO.interceptUpdateXiujia(rysxXiujia);
		return vo;
	}

	@Override
	public XiujiaVO addXiujia(XiujiaVO vo) {
		// TODO Auto-generated method stub
		RysxXiujia rysxXiujia = new RysxXiujia();
		int fydm = Integer.valueOf(vo.getNFy());
		rysxXiujia.setNFy(fydm);
		BigDecimal bd = rysxTablekeyDAO.getMaxId(fydm, "N_XIUJIAID");
		rysxXiujia.setNId(bd);
		rysxXiujia.setNRybh(Integer.parseInt(vo.getNRybh()));
		if(StringUtil.isNotBlank(vo.getDKssj())){
			rysxXiujia.setDKssj(DateUtil.parse(vo.getDKssj(), DateUtil.webFormat));
		}
		if(StringUtil.isNotBlank(vo.getDJssj())){
			rysxXiujia.setDJssj(DateUtil.parse(vo.getDJssj(), DateUtil.webFormat));
		}
		rysxXiujia.setCXjsy(vo.getCXjsy());
		if(StringUtil.isNotBlank(vo.getNType()))
			rysxXiujia.setNType(Integer.parseInt(vo.getNType()));
		xiujiaDAO.interceptAddXiujia(rysxXiujia);
		vo.setNId(bd.toString());
		vo.setNType(dmDAO.getDmByMc(rysxXiujia.getNType(), "休假类型"));
		return vo;
	}

	@Override
	public boolean delXiujiaById(String id, String fydm, String rybh) {
		// TODO Auto-generated method stub
		RysxXiujia rysxXiujia = xiujiaDAO.getRsXiujiaById(id, fydm, rybh);
		return xiujiaDAO.interceptDeleteXiujiaById(rysxXiujia);
	}

	@Override
	public List<RysxShebaoVO> getShebaoByRybhFy(int fydm, int rybh) {
		// TODO Auto-generated method stub
		List<RysxShebao> rysxShebaos = shebDAO.getShebaoByRybhFy( rybh,fydm);
		List<RysxShebaoVO> vos = new ArrayList<RysxShebaoVO>();
		for(RysxShebao shebao:rysxShebaos){
			RysxShebaoVO shebaoVO = new RysxShebaoVO();
			shebaoVO.setNId(shebao.getNId().toString());
			shebaoVO.setNFy(shebao.getNFy().toString());
			shebaoVO.setNRybh(shebao.getNRybh().toString());
			shebaoVO.setDKssj(DateUtil.format(shebao.getDKssj(), DateUtil.webFormat));
			shebaoVO.setDJssj(DateUtil.format(shebao.getDJssj(), DateUtil.webFormat));
			shebaoVO.setNType(dmDAO.getDmByMc(shebao.getNType(), "保险类型"));
			shebaoVO.setMGryj(shebao.getMGryj().toString());
			shebaoVO.setMDwyj(shebao.getMDwyj().toString());
			Float mfyhj = (float) (shebao.getMGryj() + shebao.getMDwyj());
			shebaoVO.setMFyhj(mfyhj.toString());
			vos.add(shebaoVO);
		}
		return vos;
	}

	@Override
	public RysxShebaoVO updateShebao(RysxShebaoVO vo) {
		// TODO Auto-generated method stub
		RysxShebao rysxShebao = shebDAO.getRsShebaoById(vo.getNId(), vo.getNFy(), vo.getNRybh());
		try
		{
			ObjectByteThreadLocal.setObjectByte(ObjectSerializedUtils
					.writeObjectToMemory(rysxShebao));
		} catch (Exception ex)
		{
			ex.printStackTrace();
		}
		if(StringUtil.isNotBlank(vo.getDKssj())){
			rysxShebao.setDKssj(DateUtil.parse(vo.getDKssj(), DateUtil.webFormat));
		}
		if(StringUtil.isNotBlank(vo.getDJssj())){
			rysxShebao.setDJssj(DateUtil.parse(vo.getDJssj(), DateUtil.webFormat));
		}
		rysxShebao.setNType(Integer.parseInt(vo.getNType()));
		rysxShebao.setMGryj(Double.valueOf(vo.getMGryj()));
		rysxShebao.setMDwyj(Double.valueOf(vo.getMDwyj()));
		return vo;
	}

	@Override
	public RysxShebaoVO addShebao(RysxShebaoVO vo) {
		// TODO Auto-generated method stub
		RysxShebao rysxShebao = new RysxShebao();
		int fydm = Integer.valueOf(vo.getNFy());
		rysxShebao.setNFy(fydm);
		BigDecimal bd = rysxTablekeyDAO.getMaxId(fydm, "N_SBJLID");
		rysxShebao.setNId(bd);
		rysxShebao.setNRybh(Integer.parseInt(vo.getNRybh()));
		if(StringUtil.isNotBlank(vo.getDKssj())){
			rysxShebao.setDKssj(DateUtil.parse(vo.getDKssj(), DateUtil.webFormat));
		}
		if(StringUtil.isNotBlank(vo.getDJssj())){
			rysxShebao.setDJssj(DateUtil.parse(vo.getDJssj(), DateUtil.webFormat));
		}
		rysxShebao.setNType(Integer.parseInt(vo.getNType()));
		rysxShebao.setMGryj(Double.valueOf(vo.getMGryj()));
		rysxShebao.setMDwyj(Double.valueOf(vo.getMDwyj()));
		shebDAO.interceptAddShebao(rysxShebao);
		vo.setNId(bd.toString());
		vo.setNType(dmDAO.getDmByMc(rysxShebao.getNType(), "保险类型"));
		return vo;
	}

	@Override
	public boolean delShebaoById(String id, String fydm, String rybh) {
		// TODO Auto-generated method stub
		RysxShebao rysxShebao = shebDAO.getRsShebaoById(id, fydm, rybh);
		return shebDAO.interceptDeleteShebaoById(rysxShebao);
	}

	@Override
	public RysxShebaoVO getShebaoById(String id, String fydm, String rybh) {
		// TODO Auto-generated method stub
		RysxShebao rysxShebao = shebDAO.getRsShebaoById(id, fydm, rybh);
		RysxShebaoVO shebaoVO = new RysxShebaoVO();
		shebaoVO.setNId(rysxShebao.getNId().toString());
		shebaoVO.setNFy(rysxShebao.getNFy().toString());
		shebaoVO.setNRybh(rysxShebao.getNRybh().toString());
		shebaoVO.setDKssj(DateUtil.format(rysxShebao.getDKssj(), DateUtil.webFormat));
		shebaoVO.setDJssj(DateUtil.format(rysxShebao.getDJssj(), DateUtil.webFormat));
		shebaoVO.setNType(dmDAO.getDmByMc(rysxShebao.getNType(), "保险类型"));
		shebaoVO.setMGryj(rysxShebao.getMGryj().toString());
		shebaoVO.setMDwyj(rysxShebao.getMDwyj().toString());
		Float mfyhj = (float) (rysxShebao.getMGryj() + rysxShebao.getMDwyj());
		shebaoVO.setMFyhj(mfyhj.toString());
		return shebaoVO;
	}

	@Override
	public ZjbgVO addZjbd(ZjbgVO vo) {
		// TODO Auto-generated method stub
		RysxZjbg rysxZjbg = new RysxZjbg();
		int fydm = Integer.valueOf(vo.getNFy());
		rysxZjbg.setNFy(fydm);
		BigDecimal bd = rysxTablekeyDAO.getMaxId(fydm, "N_ZJBGID");
		rysxZjbg.setNId(bd);
		rysxZjbg.setNRybh(Integer.parseInt(vo.getNRybh()));
		if(StringUtil.isNotBlank(vo.getDBgsj())){
			rysxZjbg.setDBdsj(DateUtil.parse(vo.getDBgsj(), DateUtil.webFormat));
		}
		rysxZjbg.setNBdhzj(Integer.parseInt(vo.getCZjafter()));
		rysxZjbg.setNBdqzj(Integer.parseInt(vo.getCZjafter()));
		rysxZjbg.setCPzwh(vo.getCPzwh());
		rysxZjbg.setCBz(vo.getCBz());
		zjbdDAO.interceptAddZjbg(rysxZjbg);
		vo.setNId(bd.toString());
		vo.setCZjbefore(dmDAO.getDmByMc(rysxZjbg.getNBdqzj(), "职级"));
		vo.setCZjafter(dmDAO.getDmByMc(rysxZjbg.getNBdhzj(), "职级"));
		return vo;
	}

	@Override
	public ZjbgVO updateZjbd(ZjbgVO vo) {
		// TODO Auto-generated method stub
		RysxZjbg rysxZjbg = zjbdDAO.getRsZjbgById(vo.getNId(), vo.getNFy(), vo.getNRybh());
		try
		{
			ObjectByteThreadLocal.setObjectByte(ObjectSerializedUtils
					.writeObjectToMemory(rysxZjbg));
		} catch (Exception ex)
		{
			ex.printStackTrace();
		}
		if(StringUtil.isNotBlank(vo.getDBgsj())){
			rysxZjbg.setDBdsj(DateUtil.parse(vo.getDBgsj(), DateUtil.webFormat));
		}
		rysxZjbg.setNBdhzj(Integer.parseInt(vo.getCZjafter()));
		rysxZjbg.setNBdqzj(Integer.parseInt(vo.getCZjafter()));
		rysxZjbg.setCPzwh(vo.getCPzwh());
		rysxZjbg.setCBz(vo.getCBz());
		zjbdDAO.interceptUpdateZjbg(rysxZjbg);
		return vo;
	}

	@Override
	public boolean delZjbdById(String id, String fydm, String rybh) {
		// TODO Auto-generated method stub
		RysxZjbg rysxZjbg = zjbdDAO.getRsZjbgById(id, fydm, rybh);
		return zjbdDAO.interceptDeleteZjbgById(rysxZjbg);
	}

	@Override
	public ZjbgVO getZjbdById(String id, String fydm, String rybh) {
		// TODO Auto-generated method stub
		RysxZjbg rysxZjbg = zjbdDAO.getRsZjbgById(id, fydm, rybh);
		ZjbgVO vo = new ZjbgVO();
		vo.setNId(rysxZjbg.getNId().toString());
		vo.setNFy(rysxZjbg.getNFy().toString());
		vo.setNRybh(rysxZjbg.getNRybh().toString());
		vo.setDBgsj(DateUtil.format(rysxZjbg.getDBdsj(), DateUtil.webFormat));
		vo.setCZjbefore(dmDAO.getDmByMc(rysxZjbg.getNBdqzj(), "职级"));
		vo.setCZjafter(dmDAO.getDmByMc(rysxZjbg.getNBdhzj(), "职级"));
		vo.setCPzwh(rysxZjbg.getCPzwh());
		vo.setCBz(rysxZjbg.getCBz());
		return vo;
	}

	@Override
	public List<ZjbgVO> getZjbdByRybhFy(int rybh, int fydm) {
		// TODO Auto-generated method stub
		List<RysxZjbg> rysxZjbgs = zjbdDAO.getZjbgByRybhFy(rybh, fydm);
		List<ZjbgVO> vos = new ArrayList<ZjbgVO>();
		for(RysxZjbg zjbg:rysxZjbgs){
			ZjbgVO zjbgVO = new ZjbgVO();
			zjbgVO.setNId(zjbg.getNId().toString());
			zjbgVO.setNFy(zjbg.getNFy().toString());
			zjbgVO.setNRybh(zjbg.getNRybh().toString());
			zjbgVO.setDBgsj(DateUtil.format(zjbg.getDBdsj(), DateUtil.webFormat));
			zjbgVO.setCZjbefore(dmDAO.getDmByMc(zjbg.getNBdqzj(), "职级"));
			zjbgVO.setCZjafter(dmDAO.getDmByMc(zjbg.getNBdhzj(), "职级"));
			zjbgVO.setCPzwh(zjbg.getCPzwh());
			zjbgVO.setCBz(zjbg.getCBz());
			vos.add(zjbgVO);
		}
		return vos;
	}

	@Override
	public BmbdVO addBmbd(BmbdVO vo) {
		// TODO Auto-generated method stub
		RysxBmbd rysxBmbd = new RysxBmbd();
		int fydm = Integer.valueOf(vo.getNFy());
		rysxBmbd.setNFy(fydm);
		BigDecimal bd = rysxTablekeyDAO.getMaxId(fydm, "N_BMBDID");
		rysxBmbd.setNId(bd);
		rysxBmbd.setNRybh(Integer.parseInt(vo.getNRybh()));
		if(StringUtil.isNotBlank(vo.getDBgsj())){
			rysxBmbd.setDBgsj(DateUtil.parse(vo.getDBgsj(), DateUtil.webFormat));
		}
		rysxBmbd.setNBdqbm(Integer.parseInt(vo.getCBmbefore()));
		rysxBmbd.setNBdhbm(Integer.parseInt(vo.getCBmafter()));
		rysxBmbd.setCPzwh(vo.getCPzwh());
		rysxBmbd.setCBz(vo.getCBz());
		bmbdDAO.interceptAddBmbd(rysxBmbd);
		vo.setNId(bd.toString());
		vo.setCBmbefore(dmDAO.getDmByMc(rysxBmbd.getNBdqbm(), "内设机构"));
		vo.setCBmafter(dmDAO.getDmByMc(rysxBmbd.getNBdhbm(), "内设机构"));		
		return vo;
	}

	@Override
	public BmbdVO updateBmbd(BmbdVO vo) {
		// TODO Auto-generated method stub
		RysxBmbd rysxBmbd = bmbdDAO.getRsBmbdById(vo.getNId(), vo.getNFy(), vo.getNFy());
		try
		{
			ObjectByteThreadLocal.setObjectByte(ObjectSerializedUtils
					.writeObjectToMemory(rysxBmbd));
		} catch (Exception ex)
		{
			ex.printStackTrace();
		}
		if(StringUtil.isNotBlank(vo.getDBgsj())){
			rysxBmbd.setDBgsj(DateUtil.parse(vo.getDBgsj(), DateUtil.webFormat));
		}
		rysxBmbd.setNBdqbm(Integer.parseInt(vo.getCBmbefore()));
		rysxBmbd.setNBdhbm(Integer.parseInt(vo.getCBmafter()));
		rysxBmbd.setCPzwh(vo.getCPzwh());
		rysxBmbd.setCBz(vo.getCBz());
		bmbdDAO.interceptUpdateBmbd(rysxBmbd);
		return vo;
	}

	@Override
	public boolean delBmbdById(String id, String fydm, String rybh) {
		// TODO Auto-generated method stub
		RysxBmbd rysxBmbd = bmbdDAO.getRsBmbdById(id, fydm, rybh);
		return bmbdDAO.interceptDeleteBmbdById(rysxBmbd);
	}

	@Override
	public BmbdVO getBmbdById(String id, String fydm, String rybh) {
		// TODO Auto-generated method stub
		RysxBmbd rysxBmbd = bmbdDAO.getRsBmbdById(id, fydm, rybh);
		BmbdVO vo = new BmbdVO();
		vo.setNId(rysxBmbd.getNId().toString());
		vo.setNFy(rysxBmbd.getNFy().toString());
		vo.setNRybh(rysxBmbd.getNRybh().toString());
		vo.setDBgsj(DateUtil.format(rysxBmbd.getDBgsj(), DateUtil.webFormat));
		vo.setCBmbefore(dmDAO.getDmByMc(rysxBmbd.getNBdqbm(), "内设机构"));
		vo.setCBmafter(dmDAO.getDmByMc(rysxBmbd.getNBdhbm(), "内设机构"));
		vo.setCPzwh(rysxBmbd.getCPzwh());
		vo.setCBz(rysxBmbd.getCBz());
		return vo;
	}

	@Override
	public List<BmbdVO> getBmbdByRybhFy(int rybh, int fydm) {
		// TODO Auto-generated method stub
		List<RysxBmbd> rysxBmbds = bmbdDAO.getBmbdByRybhFy(rybh, fydm);
		List<BmbdVO> vos = new ArrayList<BmbdVO>();
		for(RysxBmbd rysxBmbd:rysxBmbds){
			BmbdVO vo = new BmbdVO();
			vo.setNId(rysxBmbd.getNId().toString());
			vo.setNFy(rysxBmbd.getNFy().toString());
			vo.setNRybh(rysxBmbd.getNRybh().toString());
			vo.setDBgsj(DateUtil.format(rysxBmbd.getDBgsj(), DateUtil.webFormat));
			vo.setCBmbefore(dmDAO.getDmByMc(rysxBmbd.getNBdqbm(), "内设机构"));
			vo.setCBmafter(dmDAO.getDmByMc(rysxBmbd.getNBdhbm(), "内设机构"));
			vo.setCPzwh(rysxBmbd.getCPzwh());
			vo.setCBz(rysxBmbd.getCBz());
			vos.add(vo);
		}
		return vos;
	}

	@Override
	public RysxFljlVO addRysxFljl(RysxFljlVO vo) {
		// TODO Auto-generated method stub
		RysxFljl rysxFljl = new RysxFljl();
		int fydm = Integer.valueOf(vo.getNFy());
		rysxFljl.setNFy(fydm);
		BigDecimal bd = rysxTablekeyDAO.getMaxId(fydm, "N_FLJLID");
		rysxFljl.setNId(bd);
		rysxFljl.setNRybh(Integer.parseInt(vo.getNRybh()));
		if(StringUtil.isNotBlank(vo.getDFfsj())){
			rysxFljl.setDFfsj(DateUtil.parse(vo.getDFfsj(), DateUtil.webFormat));
		}
		rysxFljl.setMFlbt(Double.valueOf(vo.getMFlbt()));
		rysxFljl.setMJbxc(Double.valueOf(vo.getMJbxc()));
		rysxFljl.setNKq(Integer.parseInt(vo.getNKq()));
		rysxFljl.setCbz(vo.getCBz());
		fljlDAO.interceptAddFljl(rysxFljl);
		vo.setNId(bd.toString());
		return vo;
	}

	@Override
	public RysxFljlVO updateRysxFljl(RysxFljlVO vo) {
		// TODO Auto-generated method stub
		RysxFljl rysxFljl = fljlDAO.getRsFljlById(vo.getNId(), vo.getNFy(), vo.getNRybh());
		try
		{
			ObjectByteThreadLocal.setObjectByte(ObjectSerializedUtils
					.writeObjectToMemory(rysxFljl));
		} catch (Exception ex)
		{
			ex.printStackTrace();
		}
		if(StringUtil.isNotBlank(vo.getDFfsj())){
			rysxFljl.setDFfsj(DateUtil.parse(vo.getDFfsj(), DateUtil.webFormat));
		}
		rysxFljl.setMFlbt(Double.valueOf(vo.getMFlbt()));
		rysxFljl.setMJbxc(Double.valueOf(vo.getMJbxc()));
		rysxFljl.setNKq(Integer.parseInt(vo.getNKq()));
		rysxFljl.setCbz(vo.getCBz());
		fljlDAO.interceptUpdateFljl(rysxFljl);
		return vo;
	}

	@Override
	public boolean delRysxFljlById(String id, String fydm, String rybh) {
		// TODO Auto-generated method stub
		RysxFljl rysxFljl = fljlDAO.getRsFljlById(id, fydm, rybh);
		return fljlDAO.interceptDeleteFljlById(rysxFljl);
	}

	@Override
	public RysxFljlVO getRysxFljlById(String id, String fydm, String rybh) {
		// TODO Auto-generated method stub
		RysxFljl rysxFljl = fljlDAO.getRsFljlById(id, fydm, rybh);
		RysxFljlVO vo = new RysxFljlVO();
		vo.setNId(rysxFljl.getNId().toString());
		vo.setNFy(rysxFljl.getNFy().toString());
		vo.setNRybh(rysxFljl.getNRybh().toString());
		vo.setDFfsj(DateUtil.format(rysxFljl.getDFfsj(), DateUtil.webFormat));
		if(rysxFljl.getMFlbt() != null) vo.setMFlbt(rysxFljl.getMFlbt().toString());
		if(rysxFljl.getMJbxc() != null) vo.setMJbxc(rysxFljl.getMJbxc().toString());
		vo.setCBz(rysxFljl.getCbz());
		if(rysxFljl.getNKq() != null) vo.setNKq(rysxFljl.getNKq().toString());
		return vo;
	}

	@Override
	public List<RysxFljlVO> getRysxFljlByRybhFy(int rybh, int fydm) {
		// TODO Auto-generated method stub
		List<RysxFljl> rysxFljls = fljlDAO.getFljlByRybhFy(rybh, fydm);
		List<RysxFljlVO> vos = new ArrayList<RysxFljlVO>();
		for(RysxFljl rysxFljl:rysxFljls){
			RysxFljlVO vo = new RysxFljlVO();
			vo.setNId(rysxFljl.getNId().toString());
			vo.setNFy(rysxFljl.getNFy().toString());
			vo.setNRybh(rysxFljl.getNRybh().toString());
			vo.setDFfsj(DateUtil.format(rysxFljl.getDFfsj(), DateUtil.webFormat));
			if(rysxFljl.getMFlbt() != null) vo.setMFlbt(rysxFljl.getMFlbt().toString());
			if(rysxFljl.getMJbxc() != null) vo.setMJbxc(rysxFljl.getMJbxc().toString());
			if(rysxFljl.getNKq() != null) vo.setNKq(rysxFljl.getNKq().toString());
			vo.setCBz(rysxFljl.getCbz());
			vos.add(vo);
		}
		return vos;
	}

	@Override
	public List<RysxFljlVO> getRysxFljlByFy(int fydm) {
		// TODO Auto-generated method stub
		List<RysxFljl> rysxFljls = fljlDAO.getFljlByFy(fydm);
		List<RysxFljlVO> vos = new ArrayList<RysxFljlVO>();
		for(RysxFljl rysxFljl:rysxFljls){
			RysxFljlVO vo = new RysxFljlVO();
			vo.setNId(rysxFljl.getNId().toString());
			vo.setNFy(rysxFljl.getNFy().toString());
			vo.setNRybh(rysxFljl.getNRybh().toString());
			vo.setDFfsj(DateUtil.format(rysxFljl.getDFfsj(), DateUtil.webFormat));
			if(rysxFljl.getMFlbt() != null) vo.setMFlbt(rysxFljl.getMFlbt().toString());
			if(rysxFljl.getMJbxc() != null) vo.setMJbxc(rysxFljl.getMJbxc().toString());
			if(rysxFljl.getNKq() != null) vo.setNKq(rysxFljl.getNKq().toString());
			vo.setCBz(rysxFljl.getCbz());
			vos.add(vo);
		}
		return vos;
	}

	@Override
	public List<RysxHtVO> getHtxxByFy(int fydm) {
		// TODO Auto-generated method stub
		List<RysxHt> rysxHts = rysxHtDAO.getRysxHtByFy(fydm);
		List<RysxHtVO> vos = new ArrayList<RysxHtVO>();
		for(RysxHt ht:rysxHts){
			RysxHtVO vo = new RysxHtVO();
			vo.setNId(ht.getNId().toString());
			vo.setNFy(ht.getNFy().toString());
			vo.setNRybh(ht.getNRybh().toString());
			vo.setNHtlb(dmDAO.getDmByMc(ht.getNHtlb(),"合同类别"));
			vo.setDQdrq(DateUtil.format(ht.getDQdrq(), DateUtil.webFormat));
			vo.setCHtbh(ht.getCHtbh());
			vo.setCHtqx(ht.getCHtqx());
			vo.setNPrzw(dmDAO.getDmByMc(ht.getNPrzw(),"行政职务"));
			vo.setCBz(ht.getCBz());
			vos.add(vo);
		}
		return vos;
	}

	@Override
	public List<PxxxVO> getPxxxByFy(int fydm) {
		// TODO Auto-generated method stub
		List<RysxPxxx> pxxxs = rysxPxxxDAO.getPxxxByFy(fydm);
		List<PxxxVO> vos = new ArrayList<PxxxVO>();
		for(RysxPxxx pxxx:pxxxs){
			PxxxVO vo = new PxxxVO();
			vo.setNId(pxxx.getNId().toString());
			vo.setNFy(pxxx.getNFy().toString());
			vo.setNRybh(pxxx.getNRybh().toString());
			vo.setNPxfs(dmDAO.getDmByMc(pxxx.getNPxfs(), "培训方式"));
			vo.setCPxbmc(pxxx.getCPxbmc());
			if (pxxx.getDKsrq() != null)
			{
				vo.setDKsrq(DateUtil.format(pxxx.getDKsrq(),
						DateUtil.webFormat).toString());
			}
			if (pxxx.getDJsrq() != null)
			{
				vo.setDJsrq(DateUtil.format(pxxx.getDJsrq(),
						DateUtil.webFormat).toString());
			}
			vo.setNZy(dmDAO.getDmByMc(pxxx.getNZy(), "专业"));
			vo.setCPxbmc(pxxx.getCPxbmc());
			vo.setCPxcj(pxxx.getCPxcj());
			vo.setCPxjg(pxxx.getCPxjg());
			vo.setCQtjglb(pxxx.getCPxjg());
			vo.setCQtpxxs(pxxx.getCQtpxxs());
			vo.setNJglb(dmDAO.getDmByMc(pxxx.getNJglb(), "培训机构"));
			vo.setNPxxs(dmDAO.getDmByMc(pxxx.getNPxxs(), "学习形式"));
			vo.setNPxzl(dmDAO.getDmByMc(pxxx.getNPxzl(), "培训种类"));
			vo.setNSfqdzs(dmDAO.getDmByMc(pxxx.getNSfqdzs(), "是否"));
			if (pxxx.getNTbjl() != null)
			{
				vo.setNTbjl(dmDAO.getDmByMc(pxxx.getNTbjl(), "是否"));
			}
			if (pxxx.getNXz() != null)
			{
				vo.setNXz(pxxx.getNXz().toString());
			}
			vos.add(vo);
		}
		return vos;
	}

	@Override
	public List<RysxShebaoVO> getShebaoByFy(int fydm) {
		// TODO Auto-generated method stub
		List<RysxShebao> shebaos = shebDAO.getShebaoByFy(fydm);
		List<RysxShebaoVO> vos = new ArrayList<RysxShebaoVO>();
		for(RysxShebao sheb:shebaos){
			RysxShebaoVO vo = new RysxShebaoVO();
			vo.setNId(sheb.getNId().toString());
			vo.setNFy(sheb.getNFy().toString());
			vo.setNRybh(sheb.getNRybh().toString());
			vo.setNType(dmDAO.getDmByMc(sheb.getNType(), "保险类型"));
			vo.setDJssj(DateUtil.format(sheb.getDJssj(), DateUtil.webFormat));
			vo.setDKssj(DateUtil.format(sheb.getDKssj(), DateUtil.webFormat));
			if(sheb.getMDwyj() != null) vo.setMDwyj(sheb.getMDwyj().toString());
			if(sheb.getMGryj() != null) vo.setMGryj(sheb.getMGryj().toString());
			Double fyhj = sheb.getMDwyj() + sheb.getMGryj();
			if(fyhj != null) vo.setMFyhj(fyhj.toString());
			vos.add(vo);
		}
		return vos;
	}

}
