package nju.software.fyrs.biz.manager.impl;

import java.lang.reflect.InvocationTargetException;
import java.util.List;

import nju.software.fyrs.biz.manager.RyjbxxManager;
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
import nju.software.fyrs.biz.vo.RyjbxxVO;
import nju.software.fyrs.biz.vo.RysxFljlVO;
import nju.software.fyrs.biz.vo.RysxHtVO;
import nju.software.fyrs.biz.vo.RysxShebaoVO;
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
import nju.software.fyrs.data.dataobject.Dm;
import nju.software.fyrs.data.dataobject.RysxZzmm;
import nju.software.fyrs.service.RyjbxxService;
import nju.software.fyrs.util.StringUtil;

public class RyjbxxManagerImpl implements RyjbxxManager {
	RyjbxxService ryjbxxService;

	public void setRyjbxxService(RyjbxxService ryjbxxService) {
		this.ryjbxxService = ryjbxxService;
	}

	@Override
	public int getMaxBhByRybh(String name, String rybh) {
		return ryjbxxService.getMaxBhByRybh(name, rybh);
	}

	public RyjbxxVO getJbxxVOByRybhFy(int rybh, int fydm) {
		RyjbxxVO jbxxVO = ryjbxxService.getJbxxVOByRybhFy(rybh, fydm);

		if (jbxxVO == null) {
			return null;
		} else {
			return jbxxVO;
		}
	}

	public RyjbxxVO getRyjbxxVOByXmFy(String fydm,String xm){
		RyjbxxVO jbxxVO = ryjbxxService.getRyjbxxVOByXmFy(fydm,xm);
		return jbxxVO;
	}
	
	@Override
	public void updateRyjbxx(RyjbxxVO vo, int rybh, int fydm) {
		
		ryjbxxService.updateRyjbxx(vo, rybh, fydm);
	}

	public List<ZzmmVO> getZzmmByRybhFy(int rybh, int fydm) {
		return ryjbxxService.getZzmmByRybhFy(rybh, fydm);
	}

	@Override
	public boolean deleteRyjbxx(String rybh, String fydm) {
		if (StringUtil.isBlank(fydm) || StringUtil.isBlank(rybh)
				|| !StringUtil.isNumeric(rybh) || !StringUtil.isNumeric(fydm)) {
			return false;
		}
		return ryjbxxService.deleteRyjbxx(Integer.valueOf(rybh),
				Integer.valueOf(fydm));
	}

	@Override
	public ZzmmVO getRsZzmmById(String id, String fydm, String rybh) {
		
		return ryjbxxService.getRsZzmmById(id, fydm, rybh);
	}

	public RysxZzmm getRsZzmmByFyRybhId(String id, String fydm, String rybh) {
		return ryjbxxService.getRsZzmmByFyRybhId(id, fydm, rybh);
	}

	@Override
	public ZzmmVO addZzmm(ZzmmVO vo) {
		
		return ryjbxxService.addZzmm(vo);
	}

	@Override
	public boolean delRsZzmmById(String id, String fydm, String rybh) {
		
		return ryjbxxService.delRsZzmmById(id, fydm, rybh);
	}

	@Override
	public ZzmmVO updateRsZzmm(ZzmmVO vo) {
		
		return ryjbxxService.updateRsZzmm(vo);
	}

	
	
	public List<ZjxxVO> getZjxxByRybhFy(int rybh, int fydm) {
		return ryjbxxService.getZjxxByRybhFy(rybh, fydm);
	}
	
	@Override
	public ZjxxVO getRsZjxxById(String id, String fydm, String rybh) {
		
		return ryjbxxService.getRsZjxxById(id, fydm, rybh);
	}
	
	@Override
	public ZjxxVO addZjxx(ZjxxVO vo) {
		
		return ryjbxxService.addZjxx(vo);
	}

	@Override
	public boolean delRsZjxxById(String id, String fydm, String rybh) {
		
		return ryjbxxService.delRsZjxxById(id, fydm, rybh);
	}

	@Override
	public ZjxxVO updateRsZjxx(ZjxxVO vo) {
		
		return ryjbxxService.updateRsZjxx(vo);
	}

	
	
	@Override
	public List<XzzwVO> getXzzwByRybhFy(int rybh, int fydm) {
		
		return ryjbxxService.getXzzwByRybhFy(rybh, fydm);
	}

	@Override
	public XzzwVO getRsXzzwById(String id, String fydm, String rybh) {
		
		return ryjbxxService.getRsXzzwById(id, fydm, rybh);
	}

	@Override
	public XzzwVO addXzzw(XzzwVO vo) {
		
		return ryjbxxService.addXzzw(vo);
	}

	@Override
	public boolean delRsXzzwById(String id, String fydm, String rybh) {
		
		return ryjbxxService.delRsXzzwById(id, fydm, rybh);
	}

	@Override
	public XzzwVO updateRsXzzw(XzzwVO vo) {
		
		return ryjbxxService.updateRsXzzw(vo);
	}

	@Override
	public List<FlzwVO> getFlzwByRybhFy(int rybh, int fydm) {
		
		return ryjbxxService.getFlzwByRybhFy(rybh, fydm);
	}

	@Override
	public FlzwVO getRsFlzwById(String id, String fydm, String rybh) {
		
		return ryjbxxService.getRsFlzwById(id, fydm, rybh);
	}

	@Override
	public boolean delRsFlzwById(String id, String fydm, String rybh) {
		
		return ryjbxxService.delRsFlzwById(id, fydm, rybh);
	}

	@Override
	public FlzwVO addFlzw(FlzwVO vo) {
		
		return ryjbxxService.addFlzw(vo);
	}

	@Override
	public FlzwVO updateRsFlzw(FlzwVO vo) {
		
		return ryjbxxService.updateRsFlzw(vo);
	}

	@Override
	public List<Dm> getDmListByName(String name) {
		
		return ryjbxxService.getDmListByName(name);
	}

	// 学历信息
	public List<XlxxVO> getXlxxByRybhFy(int rybh, int fydm) {
		return ryjbxxService.getXlxxByRybhFy(rybh, fydm);
	};

	@Override
	public XlxxVO getRsXlxxById(String id, String fydm, String rybh) {
		
		return ryjbxxService.getRsXlxxById(id, fydm, rybh);
	}

	@Override
	public boolean delRsXlxxById(String id, String fydm, String rybh) {
		
		return ryjbxxService.delRsXlxxById(id, fydm, rybh);
	}

	@Override
	public XlxxVO addXlxx(XlxxVO vo) {
		
		return ryjbxxService.addXlxx(vo);
	}

	@Override
	public XlxxVO updateRsXlxx(XlxxVO vo) {
		
		return ryjbxxService.updateRsXlxx(vo);
	}

	@Override
	public List<XwxxVO> getXwxxByRybhFy(int rybh, int fydm) {
		
		return ryjbxxService.getXwxxByRybhFy(rybh, fydm);
	}

	@Override
	public XwxxVO getRsXwxxById(String id, String fydm, String rybh) {
		
		return ryjbxxService.getRsXwxxById(id, fydm, rybh);
	}

	@Override
	public boolean delRsXwxxById(String id, String fydm, String rybh) {
		
		return ryjbxxService.delRsXwxxById(id, fydm, rybh);
	}

	@Override
	public XwxxVO addXwxx(XwxxVO vo) {
		
		return ryjbxxService.addXwxx(vo);
	}

	@Override
	public XwxxVO updateRsXwxx(XwxxVO vo) {
		
		return ryjbxxService.updateRsXwxx(vo);
	}

	// 简历信息
	public List<JlxxVO> getJlxxByRybhFy(int rybh, int fydm) {
		return ryjbxxService.getJlxxByRybhFy(rybh, fydm);
	}

	@Override
	public JlxxVO getRsJlxxById(String id, String fydm, String rybh) {
		
		return ryjbxxService.getRsJlxxById(id, fydm, rybh);
	}

	@Override
	public boolean delRsJlxxById(String id, String fydm, String rybh) {
		
		return ryjbxxService.delRsJlxxById(id, fydm, rybh);
	}

	@Override
	public JlxxVO addJlxx(JlxxVO vo) {
		return ryjbxxService.addJlxx(vo);
	}

	@Override
	public JlxxVO updateRsJlxx(JlxxVO vo) {
		return ryjbxxService.updateRsJlxx(vo);
	}

	// 家庭信息
	@Override
	public List<JtxxVO> getJtxxByRybhFy(int rybh, int fydm) {
		return ryjbxxService.getJtxxByRybhFy(rybh, fydm);
	};

	@Override
	public JtxxVO getRsJtxxById(String id, String fydm, String rybh) {
		
		return ryjbxxService.getRsJtxxById(id, fydm, rybh);
	}

	@Override
	public boolean delRsJtxxById(String id, String fydm, String rybh) {
		
		return ryjbxxService.delRsJtxxById(id, fydm, rybh);
	}

	@Override
	public JtxxVO addJtxx(JtxxVO vo) {
		
		return ryjbxxService.addJtxx(vo);
	}

	@Override
	public JtxxVO updateRsJtxx(JtxxVO vo) {
		
		return ryjbxxService.updateRsJtxx(vo);
	}

	// 考核信息
	@Override
	public List<KhxxVO> getKhxxByRybhFy(int rybh, int fydm) {
		return ryjbxxService.getKhxxByRybhFy(rybh, fydm);
	};

	@Override
	public KhxxVO getRsKhxxById(String id, String fydm, String rybh) {
		
		return ryjbxxService.getRsKhxxById(id, fydm, rybh);
	}

	@Override
	public boolean delRsKhxxById(String id, String fydm, String rybh) {
		
		return ryjbxxService.delRsKhxxById(id, fydm, rybh);
	}

	@Override
	public KhxxVO addKhxx(KhxxVO vo) {
		
		return ryjbxxService.addKhxx(vo);
	}

	@Override
	public KhxxVO updateRsKhxx(KhxxVO vo) {
		
		return ryjbxxService.updateRsKhxx(vo);
	}

	// 奖励信息
	@Override
	public List<JlixxVO> getJlixxByRybhFy(int rybh, int fydm) {
		
		return ryjbxxService.getJlixxByRybhFy(rybh, fydm);
	}

	@Override
	public JlixxVO getRsJlixxById(String id, String fydm, String rybh) {
		
		return ryjbxxService.getRsJlixxById(id, fydm, rybh);
	}

	@Override
	public boolean delRsJlixxById(String id, String fydm, String rybh) {
		
		return ryjbxxService.delRsJlixxById(id, fydm, rybh);
	}

	@Override
	public JlixxVO addJlixx(JlixxVO vo) {
		
		return ryjbxxService.addJlixx(vo);
	}

	@Override
	public JlixxVO updateRsJlixx(JlixxVO vo) {
		
		return ryjbxxService.updateRsJlixx(vo);
	}

	// 司法考试
	@Override
	public List<SfksVO> getSfksByRybhFy(int rybh, int fydm) {
		return ryjbxxService.getSfksByRybhFy(rybh, fydm);
	};

	@Override
	public SfksVO getRsSfksById(String id, String fydm, String rybh) {
		
		return ryjbxxService.getRsSfksById(id, fydm, rybh);
	}

	@Override
	public boolean delRsSfksById(String id, String fydm, String rybh) {
		
		return ryjbxxService.delRsSfksById(id, fydm, rybh);
	}

	@Override
	public SfksVO addSfks(SfksVO vo) {
		
		return ryjbxxService.addSfks(vo);
	}

	@Override
	public SfksVO updateRsSfks(SfksVO vo) {
		
		return ryjbxxService.updateRsSfks(vo);
	}

	// 交流信息
	@Override
	public List<JliuxxVO> getJliuxxByRybhFy(int rybh, int fydm) {
		return ryjbxxService.getJliuxxByRybhFy(rybh, fydm);
	};

	@Override
	public JliuxxVO getRsJliuxxById(String id, String fydm, String rybh) {
		
		return ryjbxxService.getRsJliuxxById(id, fydm, rybh);
	}

	@Override
	public boolean delRsJliuxxById(String id, String fydm, String rybh) {
		
		return ryjbxxService.delRsJliuxxById(id, fydm, rybh);
	}

	@Override
	public JliuxxVO addJliuxx(JliuxxVO vo) {
		
		return ryjbxxService.addJliuxx(vo);
	}

	@Override
	public JliuxxVO updateRsJliuxx(JliuxxVO vo) {
		
		return ryjbxxService.updateRsJliuxx(vo);
	}

	// 培训信息
	@Override
	public List<PxxxVO> getPxxxByRybhFy(int rybh, int fydm) {
		return ryjbxxService.getPxxxByRybhFy(rybh, fydm);
	};

	@Override
	public PxxxVO getRsPxxxById(String id, String fydm, String rybh) {
		
		return ryjbxxService.getRsPxxxById(id, fydm, rybh);
	}

	@Override
	public boolean delRsPxxxById(String id, String fydm, String rybh) {
		
		return ryjbxxService.delRsPxxxById(id, fydm, rybh);
	}

	@Override
	public PxxxVO addPxxx(PxxxVO vo) {
		
		return ryjbxxService.addPxxx(vo);
	}

	@Override
	public PxxxVO updateRsPxxx(PxxxVO vo) {
		
		return ryjbxxService.updateRsPxxx(vo);
	}

	// 人才信息
	@Override
	public List<RcxxVO> getRcxxByRybhFy(int rybh, int fydm) {
		
		return ryjbxxService.getRcxxByRybhFy(rybh, fydm);
	}

	@Override
	public RcxxVO getRsRcxxById(String id, String fydm, String rybh) {
		
		return ryjbxxService.getRsRcxxById(id, fydm, rybh);
	}

	@Override
	public boolean delRsRcxxById(String id, String fydm, String rybh) {
		
		return ryjbxxService.delRsRcxxById(id, fydm, rybh);
	}

	@Override
	public RcxxVO addRcxx(RcxxVO vo) {
		
		return ryjbxxService.addRcxx(vo);
	}

	@Override
	public RcxxVO updateRsRcxx(RcxxVO vo) {
		
		return ryjbxxService.updateRsRcxx(vo);
	}

	// 等级信息
	@Override
	public List<DjxxVO> getDjxxByRybhFy(int rybh, int fydm) {
		
		return ryjbxxService.getDjxxByRybhFy(rybh, fydm);
	}

	@Override
	public DjxxVO getRsDjxxById(String id, String fydm, String rybh) {
		
		return ryjbxxService.getRsDjxxById(id, fydm, rybh);
	}

	@Override
	public boolean delRsDjxxById(String id, String fydm, String rybh) {
		
		return ryjbxxService.delRsDjxxById(id, fydm, rybh);
	}

	@Override
	public DjxxVO addDjxx(DjxxVO vo) {
		
		return ryjbxxService.addDjxx(vo);
	}

	@Override
	public DjxxVO updateRsDjxx(DjxxVO vo) {
		
		return ryjbxxService.updateRsDjxx(vo);
	}

	// 公务员级别
	@Override
	public List<GwyjbVO> getGwyjbByRybhFy(int rybh, int fydm) {
		
		return ryjbxxService.getGwyjbByRybhFy(rybh, fydm);
	}

	@Override
	public GwyjbVO getRsGwyjbById(String id, String fydm, String rybh) {
		
		return ryjbxxService.getRsGwyjbById(id, fydm, rybh);
	}

	@Override
	public boolean delRsGwyjbById(String id, String fydm, String rybh) {
		
		return ryjbxxService.delRsGwyjbById(id, fydm, rybh);
	}

	@Override
	public GwyjbVO addGwyjb(GwyjbVO vo) {
		
		return ryjbxxService.addGwyjb(vo);
	}

	@Override
	public GwyjbVO updateRsGwyjb(GwyjbVO vo) {
		
		return ryjbxxService.updateRsGwyjb(vo);
	}

	// 专业技术职务
	@Override
	public List<ZyjszwVO> getZyjszwByRybhFy(int rybh, int fydm) {
		
		return ryjbxxService.getZyjszwByRybhFy(rybh, fydm);
	}

	@Override
	public ZyjszwVO getRsZyjszwById(String id, String fydm, String rybh) {
		
		return ryjbxxService.getRsZyjszwById(id, fydm, rybh);
	}

	@Override
	public boolean delRsZyjszwById(String id, String fydm, String rybh) {
		
		return ryjbxxService.delRsZyjszwById(id, fydm, rybh);
	}

	@Override
	public ZyjszwVO addZyjszw(ZyjszwVO vo) {
		
		return ryjbxxService.addZyjszw(vo);
	}

	@Override
	public ZyjszwVO updateRsZyjszw(ZyjszwVO vo) {
		
		return ryjbxxService.updateRsZyjszw(vo);
	}

	// 兼任职务
	@Override
	public List<JrzwVO> getJrzwByRybhFy(int rybh, int fydm) {
		
		return ryjbxxService.getJrzwByRybhFy(rybh, fydm);
	}

	@Override
	public JrzwVO getRsJrzwById(String id, String fydm, String rybh) {
		
		return ryjbxxService.getRsJrzwById(id, fydm, rybh);
	}

	@Override
	public boolean delRsJrzwById(String id, String fydm, String rybh) {
		
		return ryjbxxService.delRsJrzwById(id, fydm, rybh);
	}

	@Override
	public JrzwVO addJrzw(JrzwVO vo) {
		
		return ryjbxxService.addJrzw(vo);
	}

	@Override
	public JrzwVO updateRsJrzw(JrzwVO vo) {
		
		return ryjbxxService.updateRsJrzw(vo);
	}

	@Override
	public List<LdbzVO> getLdbzByRybhFy(int rybh, int fydm) {
		
		return ryjbxxService.getLdbzByRybhFy(rybh, fydm);
	}

	@Override
	public LdbzVO getRsLdbzById(String id, String fydm, String rybh) {
		
		return ryjbxxService.getRsLdbzById(id, fydm, rybh);
	}

	@Override
	public boolean delRsLdbzById(String id, String fydm, String rybh) {
		
		return ryjbxxService.delRsLdbzById(id, fydm, rybh);
	}

	@Override
	public LdbzVO addLdbz(LdbzVO vo) {
		
		return ryjbxxService.addLdbz(vo);
	}

	@Override
	public LdbzVO updateRsLdbz(LdbzVO vo) {
		
		return ryjbxxService.updateRsLdbz(vo);
	}

	// 后备干部
	@Override
	public List<HbgbVO> getHbgbByRybhFy(int rybh, int fydm) {
		
		return ryjbxxService.getHbgbByRybhFy(rybh, fydm);
	}

	@Override
	public HbgbVO getRsHbgbById(String id, String fydm, String rybh) {
		
		return ryjbxxService.getRsHbgbById(id, fydm, rybh);
	}

	@Override
	public boolean delRsHbgbById(String id, String fydm, String rybh) {
		
		return ryjbxxService.delRsHbgbById(id, fydm, rybh);
	}

	@Override
	public HbgbVO addHbgb(HbgbVO vo) {
		
		return ryjbxxService.addHbgb(vo);
	}

	@Override
	public HbgbVO updateRsHbgb(HbgbVO vo) {
		
		return ryjbxxService.updateRsHbgb(vo);
	}

	// 工资信息
	@Override
	public List<GzxxVO> getGzxxByRybhFy(int rybh, int fydm) {
		
		return ryjbxxService.getGzxxByRybhFy(rybh, fydm);
	}

	@Override
	public GzxxVO getRsGzxxById(String id, String fydm, String rybh) {
		
		return ryjbxxService.getRsGzxxById(id, fydm, rybh);
	}

	@Override
	public boolean delRsGzxxById(String id, String fydm, String rybh) {
		
		return ryjbxxService.delRsGzxxById(id, fydm, rybh);
	}

	@Override
	public GzxxVO addGzxx(GzxxVO vo) {
		
		return ryjbxxService.addGzxx(vo);
	}

	@Override
	public GzxxVO updateRsGzxx(GzxxVO vo) {
		
		return ryjbxxService.updateRsGzxx(vo);
	}

	// 惩处信息
	@Override
	public List<CcxxVO> getCcxxByRybhFy(int rybh, int fydm) {
		
		return ryjbxxService.getCcxxByRybhFy(rybh, fydm);
	}

	@Override
	public CcxxVO getRsCcxxById(String id, String fydm, String rybh) {
		
		return ryjbxxService.getRsCcxxById(id, fydm, rybh);
	}

	@Override
	public boolean delRsCcxxById(String id, String fydm, String rybh) {
		
		return ryjbxxService.delRsCcxxById(id, fydm, rybh);
	}

	@Override
	public CcxxVO addCcxx(CcxxVO vo) {
		
		return ryjbxxService.addCcxx(vo);
	}

	@Override
	public CcxxVO updateRsCcxx(CcxxVO vo) {
		
		return ryjbxxService.updateRsCcxx(vo);
	}

	// 伤亡信息
	@Override
	public List<SwxxVO> getSwxxByRybhFy(int rybh, int fydm) {
		
		return ryjbxxService.getSwxxByRybhFy(rybh, fydm);
	}

	@Override
	public SwxxVO getRsSwxxById(String id, String fydm, String rybh) {
		
		return ryjbxxService.getRsSwxxById(id, fydm, rybh);
	}

	@Override
	public boolean delRsSwxxById(String id, String fydm, String rybh) {
		
		return ryjbxxService.delRsSwxxById(id, fydm, rybh);
	}

	@Override
	public SwxxVO addSwxx(SwxxVO vo) {
		
		return ryjbxxService.addSwxx(vo);
	}

	@Override
	public SwxxVO updateRsSwxx(SwxxVO vo) {
		
		return ryjbxxService.updateRsSwxx(vo);
	}

	// 伤亡信息
	@Override
	public List<ZdxxVO> getZdxxByRybhFy(int rybh, int fydm) {
		
		return ryjbxxService.getZdxxByRybhFy(rybh, fydm);
	}

	@Override
	public ZdxxVO getRsZdxxById(String id, String fydm, String rybh) {
		
		return ryjbxxService.getRsZdxxById(id, fydm, rybh);
	}

	@Override
	public boolean delRsZdxxById(String id, String fydm, String rybh) {
		
		return ryjbxxService.delRsZdxxById(id, fydm, rybh);
	}

	@Override
	public ZdxxVO addZdxx(ZdxxVO vo) {
		
		return ryjbxxService.addZdxx(vo);
	}

	@Override
	public ZdxxVO updateRsZdxx(ZdxxVO vo) {
		
		return ryjbxxService.updateRsZdxx(vo);
	}

	// 出国信息
	@Override
	public List<CgxxVO> getCgxxByRybhFy(int rybh, int fydm) {
		return ryjbxxService.getCgxxByRybhFy(rybh, fydm);
	};

	@Override
	public CgxxVO getRsCgxxById(String id, String fydm, String rybh) {
		
		return ryjbxxService.getRsCgxxById(id, fydm, rybh);
	}

	@Override
	public boolean delRsCgxxById(String id, String fydm, String rybh) {
		
		return ryjbxxService.delRsCgxxById(id, fydm, rybh);
	}

	@Override
	public CgxxVO addCgxx(CgxxVO vo) {
		
		return ryjbxxService.addCgxx(vo);
	}

	@Override
	public CgxxVO updateRsCgxx(CgxxVO vo) {
		
		return ryjbxxService.updateRsCgxx(vo);
	}

	// 外语信息
	@Override
	public List<WyxxVO> getWyxxByRybhFy(int rybh, int fydm) {
		
		return ryjbxxService.getWyxxByRybhFy(rybh, fydm);
	}

	@Override
	public WyxxVO getRsWyxxById(String id, String fydm, String rybh) {
		
		return ryjbxxService.getRsWyxxById(id, fydm, rybh);
	}

	@Override
	public boolean delRsWyxxById(String id, String fydm, String rybh) {
		
		return ryjbxxService.delRsWyxxById(id, fydm, rybh);
	}

	@Override
	public WyxxVO addWyxx(WyxxVO vo) {
		
		return ryjbxxService.addWyxx(vo);
	}

	@Override
	public WyxxVO updateRsWyxx(WyxxVO vo) {
		
		return ryjbxxService.updateRsWyxx(vo);
	}

	// 通讯录
	@Override
	public List<TxlVO> getTxlByRybhFy(int rybh, int fydm) {
		
		return ryjbxxService.getTxlByRybhFy(rybh, fydm);
	}

	@Override
	public TxlVO getRsTxlById(String id, String fydm, String rybh) {
		
		return ryjbxxService.getRsTxlById(id, fydm, rybh);
	}

	@Override
	public boolean delRsTxlById(String id, String fydm, String rybh) {
		
		return ryjbxxService.delRsTxlById(id, fydm, rybh);
	}

	@Override
	public TxlVO addTxl(TxlVO vo) {
		
		return ryjbxxService.addTxl(vo);
	}

	@Override
	public TxlVO updateRsTxl(TxlVO vo) {
		
		return ryjbxxService.updateRsTxl(vo);
	}

	@Override
	public List<SyyyxVO> getSyyyxByRybh(String rybh) {
		
		return ryjbxxService.getSyyyxByRybh(rybh);
	}

	@Override
	public SyyyxVO getRsSyyyxById(String rybh, String bh) {
		
		return ryjbxxService.getRsSyyyxById(rybh, bh);
	}

	@Override
	public boolean delRsSyyyxById(String rybh, String bh) {
		
		return ryjbxxService.delRsSyyyxById(rybh, bh);
	}

	@Override
	public int addSyyyx(SyyyxVO vo) {
		
		return ryjbxxService.addSyyyx(vo);
	}

	@Override
	public boolean updateRsSyyyx(SyyyxVO vo) {
		
		return ryjbxxService.updateRsSyyyx(vo);
	}

	// 备注信息
	@Override
	public List<BzxxVO> getBzxxByRybhFy(int rybh, int fydm) {
		
		return ryjbxxService.getBzxxByRybhFy(rybh, fydm);
	}

	@Override
	public List<BzxxVO> getBzxxByRybh(String rybh) {
		
		return ryjbxxService.getBzxxByRybh(rybh);
	}

	@Override
	public BzxxVO getRsBzxxById(String id, String fydm, String rybh) {
		
		return ryjbxxService.getRsBzxxById(id, fydm, rybh);
	}

	@Override
	public boolean delRsBzxxById(String id, String fydm, String rybh) {
		
		return ryjbxxService.delRsBzxxById(id, fydm, rybh);
	}

	@Override
	public BzxxVO addBzxx(BzxxVO vo) {
		
		return ryjbxxService.addBzxx(vo);
	}

	@Override
	public BzxxVO updateRsBzxx(BzxxVO vo) {
		
		return ryjbxxService.updateRsBzxx(vo);
	}

	@Override
	public boolean addRyFromLsk(String fysrc, String rybh, String fydst,
			String bmdst) {
		try {
			return ryjbxxService.addRyFromLsk(fysrc, rybh, fydst, bmdst);
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		}
		return false;
	}
	
	//合同信息
	@Override
	public List<RysxHtVO> getHtxxByRybhFy(int rybh, int fydm) {
		// TODO Auto-generated method stub
		return ryjbxxService.getHtxxByRybhFy(fydm, rybh);
	}

	@Override
	public RysxHtVO getRsHtxxById(String id, String fydm, String rybh) {
		// TODO Auto-generated method stub
		return ryjbxxService.getRsHtxxById(id, fydm, rybh);
	}

	@Override
	public boolean delRsHtxxById(String id, String fydm, String rybh) {
		// TODO Auto-generated method stub
		return ryjbxxService.delRsHtxxById(id, fydm, rybh);
	}

	@Override
	public RysxHtVO addHtxx(RysxHtVO vo) {
		// TODO Auto-generated method stub
		return ryjbxxService.addHtxx(vo);
	}

	@Override
	public RysxHtVO updateRsHtxx(RysxHtVO vo) {
		// TODO Auto-generated method stub
		return ryjbxxService.updateRsHtxx(vo);
	}
	
	//休假信息
	@Override
	public List<XiujiaVO> getXiujiaByRybhFy(int rybh, int fydm) {
		// TODO Auto-generated method stub
		return ryjbxxService.getXiujiaByRybhFy(fydm, rybh);
	}

	@Override
	public XiujiaVO getXiujiaById(String id, String fydm, String rybh) {
		// TODO Auto-generated method stub
		return ryjbxxService.getXiujiaById(id, fydm, rybh);
	}

	@Override
	public boolean delXiujiaById(String id, String fydm, String rybh) {
		// TODO Auto-generated method stub
		return ryjbxxService.delXiujiaById(id, fydm, rybh);
	}

	@Override
	public XiujiaVO addXiujia(XiujiaVO vo) {
		// TODO Auto-generated method stub
		return ryjbxxService.addXiujia(vo);
	}

	@Override
	public XiujiaVO updateXiujia(XiujiaVO vo) {
		// TODO Auto-generated method stub
		return ryjbxxService.updateXiujia(vo);
	}
	//社保记录
	@Override
	public List<RysxShebaoVO> getShebaoByRybhFy(int rybh, int fydm) {
		// TODO Auto-generated method stub
		return ryjbxxService.getShebaoByRybhFy(fydm, rybh);
	}

	@Override
	public RysxShebaoVO getShebaoById(String id, String fydm, String rybh) {
		// TODO Auto-generated method stub
		return ryjbxxService.getShebaoById(id, fydm, rybh);
	}

	@Override
	public boolean delShebaoById(String id, String fydm, String rybh) {
		// TODO Auto-generated method stub
		return ryjbxxService.delShebaoById(id, fydm, rybh);
	}

	@Override
	public RysxShebaoVO addShebao(RysxShebaoVO vo) {
		// TODO Auto-generated method stub
		return ryjbxxService.addShebao(vo);
	}

	@Override
	public RysxShebaoVO updateShebao(RysxShebaoVO vo) {
		// TODO Auto-generated method stub
		return ryjbxxService.updateShebao(vo);
	}

	@Override
	public ZjbgVO addZjbd(ZjbgVO vo) {
		// TODO Auto-generated method stub
		return ryjbxxService.addZjbd(vo);
	}

	@Override
	public ZjbgVO updateZjbd(ZjbgVO vo) {
		// TODO Auto-generated method stub
		return ryjbxxService.updateZjbd(vo);
	}

	@Override
	public boolean delZjbdById(String id, String fydm, String rybh) {
		// TODO Auto-generated method stub
		return ryjbxxService.delZjbdById(id, fydm, rybh);
	}

	@Override
	public ZjbgVO getZjbdById(String id, String fydm, String rybh) {
		// TODO Auto-generated method stub
		return ryjbxxService.getZjbdById(id, fydm, rybh);
	}

	@Override
	public List<ZjbgVO> getZjbdByRybhFy(int rybh, int fydm) {
		// TODO Auto-generated method stub
		return ryjbxxService.getZjbdByRybhFy(rybh, fydm);
	}

	@Override
	public BmbdVO addBmbd(BmbdVO vo) {
		// TODO Auto-generated method stub
		return ryjbxxService.addBmbd(vo);
	}

	@Override
	public BmbdVO updateBmbd(BmbdVO vo) {
		// TODO Auto-generated method stub
		return ryjbxxService.updateBmbd(vo);
	}

	@Override
	public boolean delBmbdById(String id, String fydm, String rybh) {
		// TODO Auto-generated method stub
		return ryjbxxService.delBmbdById(id, fydm, rybh);
	}

	@Override
	public BmbdVO getBmbdById(String id, String fydm, String rybh) {
		// TODO Auto-generated method stub
		return ryjbxxService.getBmbdById(id, fydm, rybh);
	}

	@Override
	public List<BmbdVO> getBmbdByRybhFy(int rybh, int fydm) {
		// TODO Auto-generated method stub
		return ryjbxxService.getBmbdByRybhFy(rybh, fydm);
	}

	@Override
	public RysxFljlVO addRysxFljl(RysxFljlVO vo) {
		// TODO Auto-generated method stub
		return ryjbxxService.addRysxFljl(vo);
	}

	@Override
	public RysxFljlVO updateRysxFljl(RysxFljlVO vo) {
		// TODO Auto-generated method stub
		return ryjbxxService.updateRysxFljl(vo);
	}

	@Override
	public boolean delRysxFljlById(String id, String fydm, String rybh) {
		// TODO Auto-generated method stub
		return ryjbxxService.delRysxFljlById(id, fydm, rybh);
	}

	@Override
	public RysxFljlVO getRysxFljlById(String id, String fydm, String rybh) {
		// TODO Auto-generated method stub
		return ryjbxxService.getRysxFljlById(id, fydm, rybh);
	}

	@Override
	public List<RysxFljlVO> getRysxFljlByRybhFy(int rybh, int fydm) {
		// TODO Auto-generated method stub
		return ryjbxxService.getRysxFljlByRybhFy(rybh, fydm);
	}
}
