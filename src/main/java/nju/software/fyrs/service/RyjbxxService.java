package nju.software.fyrs.service;

import java.lang.reflect.InvocationTargetException;
import java.util.List;
import java.util.Map;

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
import nju.software.fyrs.data.dataobject.Dm;
import nju.software.fyrs.data.dataobject.Ryjbxx;
import nju.software.fyrs.data.dataobject.RysxPhoto;
import nju.software.fyrs.data.dataobject.RysxZzmm;

public interface RyjbxxService {

	public List<Ryjbxx> listByFyDmBmDm(int fyDm, int BmDm);

	public List<Ryjbxx> listByFyDm(int fyDm);

	public Ryjbxx getRyjbxxByRybhFyDm(int rybh, int fyDm);

	public int updateUserNameAndRoles(String userName, String roleIds,
			int rybh, int fyDm);

	public void updatePassword(String password, int rybh, int fyDm);

	public Ryjbxx getRyjbxxByUserNamePassowrd(String username, int fyDm);

	public String roleIdsByFydmRybh(int rybh, int fyDm);

	public List<Dm> getDmListByName(String name);

	public int getMaxBhByRybh(String name, String rybh);

	// 人员基本信息
	public RyjbxxVO getJbxxVOByRybhFy(int rybh, int fydm);

	public RyjbxxVO getRyjbxxVOByXmFy(String fydm,String xm);
	
	public void updateRyjbxx(RyjbxxVO vo, int rybh, int fydm);

	public boolean deleteRyjbxx(int rybh, int fydm);

	// 政治面貌
	public RysxZzmm getRsZzmmByFyRybhId(String id, String fydm, String rybh);

	public List<ZzmmVO> getZzmmByRybhFy(int rybh, int fydm);

	public ZzmmVO getRsZzmmById(String id, String fydm, String rybh);

	public ZzmmVO addZzmm(ZzmmVO vo);

	public boolean delRsZzmmById(String id, String fydm, String rybh);

	public ZzmmVO updateRsZzmm(ZzmmVO vo);

	//职级信息
	public List<ZjxxVO> getZjxxByRybhFy(int rybh, int fydm);
	
	public ZjxxVO getRsZjxxById(String id, String fydm, String rybh);
	
	public ZjxxVO addZjxx(ZjxxVO vo);

	public boolean delRsZjxxById(String id, String fydm, String rybh);

	public ZjxxVO updateRsZjxx(ZjxxVO vo);
	
	// 行政职务
	public List<XzzwVO> getXzzwByRybhFy(int rybh, int fydm);

	public XzzwVO getRsXzzwById(String id, String fydm, String rybh);

	public XzzwVO addXzzw(XzzwVO vo);

	public boolean delRsXzzwById(String id, String fydm, String rybh);

	public XzzwVO updateRsXzzw(XzzwVO vo);

	// 法律职务
	public List<FlzwVO> getFlzwByRybhFy(int rybh, int fydm);

	public FlzwVO getRsFlzwById(String id, String fydm, String rybh);

	public boolean delRsFlzwById(String id, String fydm, String rybh);

	public FlzwVO addFlzw(FlzwVO vo);

	public FlzwVO updateRsFlzw(FlzwVO vo);

	// 学历信息
	public List<XlxxVO> getXlxxByRybhFy(int rybh, int fydm);

	public XlxxVO getRsXlxxById(String id, String fydm, String rybh);

	public boolean delRsXlxxById(String id, String fydm, String rybh);

	public XlxxVO addXlxx(XlxxVO vo);

	public XlxxVO updateRsXlxx(XlxxVO vo);
	
	//合同信息
	public List<RysxHtVO> getHtxxByRybhFy(int rybh, int fydm);
	
	public List<RysxHtVO> getHtxxByFy(int fydm);
	
	public RysxHtVO getRsHtxxById(String id, String fydm, String rybh);
	
	public boolean delRsHtxxById(String id, String fydm, String rybh);
	
	public RysxHtVO addHtxx(RysxHtVO vo);
	
	public RysxHtVO updateRsHtxx(RysxHtVO vo);

	// 学位信息
	public List<XwxxVO> getXwxxByRybhFy(int rybh, int fydm);

	public XwxxVO getRsXwxxById(String id, String fydm, String rybh);

	public boolean delRsXwxxById(String id, String fydm, String rybh);

	public XwxxVO addXwxx(XwxxVO vo);

	public XwxxVO updateRsXwxx(XwxxVO vo);

	// 简历信息
	public List<JlxxVO> getJlxxByRybhFy(int rybh, int fydm);

	public JlxxVO getRsJlxxById(String id, String fydm, String rybh);

	public boolean delRsJlxxById(String id, String fydm, String rybh);

	public JlxxVO addJlxx(JlxxVO vo);

	public JlxxVO updateRsJlxx(JlxxVO vo);

	// 家庭信息
	public List<JtxxVO> getJtxxByRybhFy(int rybh, int fydm);

	public JtxxVO getRsJtxxById(String id, String fydm, String rybh);

	public boolean delRsJtxxById(String id, String fydm, String rybh);

	public JtxxVO addJtxx(JtxxVO vo);

	public JtxxVO updateRsJtxx(JtxxVO vo);

	// 考核信息
	public List<KhxxVO> getKhxxByRybhFy(int rybh, int fydm);

	public KhxxVO getRsKhxxById(String id, String fydm, String rybh);

	public boolean delRsKhxxById(String id, String fydm, String rybh);

	public KhxxVO addKhxx(KhxxVO vo);

	public KhxxVO updateRsKhxx(KhxxVO vo);

	// 奖励信息
	public List<JlixxVO> getJlixxByRybhFy(int rybh, int fydm);

	public JlixxVO getRsJlixxById(String id, String fydm, String rybh);

	public boolean delRsJlixxById(String id, String fydm, String rybh);

	public JlixxVO addJlixx(JlixxVO vo);

	public JlixxVO updateRsJlixx(JlixxVO vo);

	// 司法考试
	public List<SfksVO> getSfksByRybhFy(int rybh, int fydm);

	public SfksVO getRsSfksById(String id, String fydm, String rybh);

	public boolean delRsSfksById(String id, String fydm, String rybh);

	public SfksVO addSfks(SfksVO vo);

	public SfksVO updateRsSfks(SfksVO vo);

	// 交流信息
	public List<JliuxxVO> getJliuxxByRybhFy(int rybh, int fydm);

	public JliuxxVO getRsJliuxxById(String id, String fydm, String rybh);

	public boolean delRsJliuxxById(String id, String fydm, String rybh);

	public JliuxxVO addJliuxx(JliuxxVO vo);

	public JliuxxVO updateRsJliuxx(JliuxxVO vo);

	// 培训信息
	public List<PxxxVO> getPxxxByRybhFy(int rybh, int fydm);
	public List<PxxxVO> getPxxxByFy(int fydm);
	public PxxxVO getRsPxxxById(String id, String fydm, String rybh);

	public boolean delRsPxxxById(String id, String fydm, String rybh);

	public PxxxVO addPxxx(PxxxVO vo);

	public PxxxVO updateRsPxxx(PxxxVO vo);

	// 人才信息
	public List<RcxxVO> getRcxxByRybhFy(int rybh, int fydm);

	public RcxxVO getRsRcxxById(String id, String fydm, String rybh);

	public boolean delRsRcxxById(String id, String fydm, String rybh);

	public RcxxVO addRcxx(RcxxVO vo);

	public RcxxVO updateRsRcxx(RcxxVO vo);

	// 等级信息
	public List<DjxxVO> getDjxxByRybhFy(int rybh, int fydm);

	public DjxxVO getRsDjxxById(String id, String fydm, String rybh);

	public boolean delRsDjxxById(String id, String fydm, String rybh);

	public DjxxVO addDjxx(DjxxVO vo);

	public DjxxVO updateRsDjxx(DjxxVO vo);

	// 公务员级别
	public List<GwyjbVO> getGwyjbByRybhFy(int rybh, int fydm);

	public GwyjbVO getRsGwyjbById(String id, String fydm, String rybh);

	public boolean delRsGwyjbById(String id, String fydm, String rybh);

	public GwyjbVO addGwyjb(GwyjbVO vo);

	public GwyjbVO updateRsGwyjb(GwyjbVO vo);

	// 专业技术职务
	public List<ZyjszwVO> getZyjszwByRybhFy(int rybh, int fydm);

	public ZyjszwVO getRsZyjszwById(String id, String fydm, String rybh);

	public boolean delRsZyjszwById(String id, String fydm, String rybh);

	public ZyjszwVO addZyjszw(ZyjszwVO vo);

	public ZyjszwVO updateRsZyjszw(ZyjszwVO vo);

	// 兼任职务
	public List<JrzwVO> getJrzwByRybhFy(int rybh, int fydm);

	public JrzwVO getRsJrzwById(String id, String fydm, String rybh);

	public boolean delRsJrzwById(String id, String fydm, String rybh);

	public JrzwVO addJrzw(JrzwVO vo);

	public JrzwVO updateRsJrzw(JrzwVO vo);

	// 领导班子
	public List<LdbzVO> getLdbzByRybhFy(int rybh, int fydm);

	public LdbzVO getRsLdbzById(String id, String fydm, String rybh);

	public boolean delRsLdbzById(String id, String fydm, String rybh);

	public LdbzVO addLdbz(LdbzVO vo);

	public LdbzVO updateRsLdbz(LdbzVO vo);

	// 后备干部
	public List<HbgbVO> getHbgbByRybhFy(int rybh, int fydm);

	public HbgbVO getRsHbgbById(String id, String fydm, String rybh);

	public boolean delRsHbgbById(String id, String fydm, String rybh);

	public HbgbVO addHbgb(HbgbVO vo);

	public HbgbVO updateRsHbgb(HbgbVO vo);

	// 工资信息
	public List<GzxxVO> getGzxxByRybhFy(int rybh, int fydm);

	public GzxxVO getRsGzxxById(String id, String fydm, String rybh);

	public boolean delRsGzxxById(String id, String fydm, String rybh);

	public GzxxVO addGzxx(GzxxVO vo);

	public GzxxVO updateRsGzxx(GzxxVO vo);

	// 惩处信息
	public List<CcxxVO> getCcxxByRybhFy(int rybh, int fydm);

	public CcxxVO getRsCcxxById(String id, String fydm, String rybh);

	public boolean delRsCcxxById(String id, String fydm, String rybh);

	public CcxxVO addCcxx(CcxxVO vo);

	public CcxxVO updateRsCcxx(CcxxVO vo);

	// 伤亡信息
	public List<SwxxVO> getSwxxByRybhFy(int rybh, int fydm);

	public SwxxVO getRsSwxxById(String id, String fydm, String rybh);

	public boolean delRsSwxxById(String id, String fydm, String rybh);

	public SwxxVO addSwxx(SwxxVO vo);

	public SwxxVO updateRsSwxx(SwxxVO vo);

	// 在读信息
	public List<ZdxxVO> getZdxxByRybhFy(int rybh, int fydm);

	public ZdxxVO getRsZdxxById(String id, String fydm, String rybh);

	public boolean delRsZdxxById(String id, String fydm, String rybh);

	public ZdxxVO addZdxx(ZdxxVO vo);

	public ZdxxVO updateRsZdxx(ZdxxVO vo);

	// 出国信息
	public List<CgxxVO> getCgxxByRybhFy(int rybh, int fydm);

	public CgxxVO getRsCgxxById(String id, String fydm, String rybh);

	public boolean delRsCgxxById(String id, String fydm, String rybh);

	public CgxxVO addCgxx(CgxxVO vo);

	public CgxxVO updateRsCgxx(CgxxVO vo);

	// 外语信息
	public List<WyxxVO> getWyxxByRybhFy(int rybh, int fydm);

	public WyxxVO getRsWyxxById(String id, String fydm, String rybh);

	public boolean delRsWyxxById(String id, String fydm, String rybh);

	public WyxxVO addWyxx(WyxxVO vo);

	public WyxxVO updateRsWyxx(WyxxVO vo);

	// 通讯录
	public List<TxlVO> getTxlByRybhFy(int rybh, int fydm);

	public TxlVO getRsTxlById(String id, String fydm, String rybh);

	public boolean delRsTxlById(String id, String fydm, String rybh);

	public TxlVO addTxl(TxlVO vo);

	public TxlVO updateRsTxl(TxlVO vo);

	public List<SyyyxVO> getSyyyxByRybh(String rybh);

	public SyyyxVO getRsSyyyxById(String rybh, String bh);

	public boolean delRsSyyyxById(String rybh, String bh);

	public int addSyyyx(SyyyxVO vo);

	public boolean updateRsSyyyx(SyyyxVO vo);

	// 备注信息
	public List<BzxxVO> getBzxxByRybhFy(int rybh, int fydm);

	public List<BzxxVO> getBzxxByRybh(String rybh);

	public BzxxVO getRsBzxxById(String id, String fydm, String rybh);

	public boolean delRsBzxxById(String id, String fydm, String rybh);

	public BzxxVO addBzxx(BzxxVO vo);

	public BzxxVO updateRsBzxx(BzxxVO vo);

	// myCode
	/**
	 * 1 9 中央行政编制 2 9 中央事业编制 3 9 地方行政 4 9 地方全额事业 5 9 地方差额事业 6 9 行政附属 7 9 企业 8 9
	 * 地方自筹自支事业 6 1
	 * 
	 * @param fydm
	 * @return
	 */
	public int[] findBzCount(int fydm);

	public List<Ryjbxx> listByFlzwBmZwlbZyZjDjXlRyk(String flzw, String bm,
			String zwlb, String zy, String zj, String dj, String xl, String ryk);

	public List<Ryjbxx> listByFydmRybhIn(String inString);

	public List<String> listNameByKuFydmBm(String ku, String fydm, String bm);

	public List<RyjbxxHmcVO> listByKuFydmBm(String ku, String fydm, String bm);

	public List<List<String>> listDynamicShowByKuFydmBm(
			Map<String, List<SdcxShowColumnsVO>> showTableAndColumns,
			String ku, String fydm, String bm);

	public RyjbxxRylhVO getRyjbxxByKuFydmBmName(String ku, String fydm,
			String bm, String name);

	public List<RyjbxxRylhTimeShowVo> listAllEventByByKuFydmBmName(String ku,
			String fydm, String bm, String name);

	// 删除人员基本信息及所有的字表
	public boolean deleteRyjbxxAndAllSubTable(int fydm, int rybh);

	// myCode

	/**
	 * 自定义统计 根据上标题和左标题查询人数
	 * 
	 * @param topCondition
	 * @param leftCondition
	 * @return
	 */
	public Integer getRyCountByTopAndLeftConditions(String topCondition,
			String leftCondition, Object[] topParams, Object[] leftParams);

	public RysxPhoto getRysxPhoto(String fydm, String rybh);

	public boolean delRysxPhoto(String fydm, String rybh);

	public int getMaxRybhByFydm(int fydm);

	public boolean addRyFromLsk(String fysrc, String rybh, String fydst,
			String bmdst) throws IllegalAccessException,
			InvocationTargetException;
	
	public long countByXzzw(int fydm, String xzzw);
	// 休假信息
	public List<XiujiaVO> getXiujiaByRybhFy(int fydm, int rybh);

	public XiujiaVO updateXiujia(XiujiaVO vo);

	public XiujiaVO addXiujia(XiujiaVO vo);

	public boolean delXiujiaById(String id, String fydm, String rybh);

	XiujiaVO getXiujiaById(String id, String fydm, String rybh);
	// 社保记录
	public List<RysxShebaoVO> getShebaoByRybhFy(int fydm, int rybh);
	
	public List<RysxShebaoVO> getShebaoByFy(int fydm);

	public RysxShebaoVO updateShebao(RysxShebaoVO vo);

	public RysxShebaoVO addShebao(RysxShebaoVO vo);

	public boolean delShebaoById(String id, String fydm, String rybh);

	RysxShebaoVO getShebaoById(String id, String fydm, String rybh);
	// 职级变动信息
	public ZjbgVO addZjbd(ZjbgVO vo);

	public ZjbgVO updateZjbd(ZjbgVO vo);

	public boolean delZjbdById(String id, String fydm, String rybh);

	public ZjbgVO getZjbdById(String id, String fydm, String rybh);

	public List<ZjbgVO> getZjbdByRybhFy(int rybh, int fydm);
	// 部门变动信息
	public BmbdVO addBmbd(BmbdVO vo);

	public BmbdVO updateBmbd(BmbdVO vo);

	public boolean delBmbdById(String id, String fydm, String rybh);

	public BmbdVO getBmbdById(String id, String fydm, String rybh);

	public List<BmbdVO> getBmbdByRybhFy(int rybh, int fydm);
	// 薪酬福利信息
	public RysxFljlVO addRysxFljl(RysxFljlVO vo);

	public RysxFljlVO updateRysxFljl(RysxFljlVO vo);

	public boolean delRysxFljlById(String id, String fydm, String rybh);

	public RysxFljlVO getRysxFljlById(String id, String fydm, String rybh);

	public List<RysxFljlVO> getRysxFljlByRybhFy(int rybh, int fydm);
	
	public List<RysxFljlVO> getRysxFljlByFy(int fydm);
}
