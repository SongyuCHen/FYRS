package nju.software.fyrs.service;

import java.util.ArrayList;
import java.util.List;

import nju.software.fyrs.biz.vo.BmPzVO;
import nju.software.fyrs.biz.vo.BzPzVO;
import nju.software.fyrs.biz.vo.FgBmFbVO;
import nju.software.fyrs.biz.vo.FgFlzwFbVO;
import nju.software.fyrs.biz.vo.ZjFbVO;
import nju.software.fyrs.biz.vo.FgzlFbVO;
import nju.software.fyrs.biz.vo.FyPzVO;
import nju.software.fyrs.biz.vo.GdtjTjVO;
import nju.software.fyrs.biz.vo.GdtjVO;
import nju.software.fyrs.biz.vo.GrJlVO;
import nju.software.fyrs.biz.vo.HmcVO;
import nju.software.fyrs.biz.vo.JtJlVO;
import nju.software.fyrs.biz.vo.NlAndXlFbVO;
import nju.software.fyrs.biz.vo.SjyFbVO;
import nju.software.fyrs.biz.vo.TzZjVO;

/**
 * 获取固定统计相关的统计数据
 * @author wwj
 *
 */
public interface GdtjService {
	/**
	 * 获取固定统计列表
	 * @return
	 */
	public List<GdtjVO>getGdtjList();
	/**
	 * 获取某张表的统计条件
	 * @param bbh
	 * @return
	 */
	public List<ArrayList<GdtjTjVO>> getGdtjTjList(int bbh);
	/**
	 * 获取固定统计结果
	 * @param bbh
	 * @param hang
	 * @param lie
	 * @param fydm
	 * @return
	 */
	public String[][] getTjResult(String bbh, String hang, String lie, int fydm);
	/**
	 * 根据表编号获取表名
	 * @param bbh
	 * @return
	 */
	public GdtjVO getGdtjByBbh(String bbh);
	/**
	 * 中院干警获得表彰奖励情况（个人奖励）
	 * @param fydm
	 * @return
	 */
	public List<GrJlVO> getGrJl(int fydm);
	/**
	 * 徐州市中级人民法院表彰奖励数据（集体）
	 * @param fydm
	 * @return
	 */
	public List<JtJlVO> getJtJl(int fydm);
	/**
	 * 获得法院人员配置
	 * @param fydm
	 * @return
	 */
	public FyPzVO getFyPz(int fydm);
	/**
	 * 获得法院部门人员配置
	 * @param fydm
	 * @return
	 */
	public List<BmPzVO> getFyBmPz(int fydm);
	/**
	 * 获得法院花名册
	 * @param fydm
	 * @return
	 */
	public List<HmcVO> getHmcRyzb(int fydm);
	/**
	 * 获得法院某部门花名册
	 * @param fydm
	 * @param bm
	 * @return
	 */
	public List<HmcVO> getHmcByBm(int fydm, int bm);
	/**
	 * 根据法院部门名获取花名册
	 * @param fydm
	 * @param bm
	 * @return
	 */
	public List<HmcVO> getHmcByBmName(int fydm, String bm);
	/**
	 * 获得法院某行政职务花名册
	 * @param fydm
	 * @param xzzw
	 * @return
	 */
	public List<HmcVO> getHmcByXzzw(int fydm, int xzzw);
	/**
	 * 获得法院人数
	 * @param fydm
	 * @return
	 */
	public Long countByFy(int fydm);
	/**
	 * 获得法院职务类别花名册
	 * @param fydm
	 * @param zwlb
	 * @return
	 */
	public List<HmcVO> getZcgbHmc(int fydm, int zwlb);
	/**
	 * 根据职级的条件返回花名册,这个代码编的非常丑
	 * @param fydm
	 * @param zjCondition
	 * @return
	 */
	public List<HmcVO> getHmcByZjCondition(int fydm, String zjCondition);
	/**
	 * 根据职级返回花名册
	 * @param fydm
	 * @param zj
	 * @return
	 */
	public List<HmcVO> getHmcByZj(int fydm, int zj);
	/**
	 * 根据法律职务返回花名册
	 * @param fydm
	 * @param flzw
	 * @return
	 */
	public List<HmcVO> getHmcByFlzw(int fydm, int flzw);
	/**
	 * 根据职级返回军转干部花名册
	 * @param fydm
	 * @param zj
	 * @return
	 */
	public List<HmcVO> getJzgbHmcByZj(int fydm, int zj);
	/**
	 * 根据性别返回花名册
	 * @param fydm
	 * @param xb
	 * @return
	 */
	public List<HmcVO> getHmcByXb(int fydm, int xb);
	/**
	 * 获得非党员花名册
	 * @param fydm
	 * @return
	 */
	public List<HmcVO> getFdyHmc(int fydm);
	/**
	 * 根据法院获得核定编制信息
	 * @param fydm
	 * @return
	 */
	public List<BzPzVO> getHdbzPzByFy(int...fydms);
	/**
	 * 根据法院获得实有编制信息
	 * @param fydms
	 * @return
	 */
	public List<BzPzVO> getSybzPzByFy(int...fydms);
	/**
	 * 根据法院获得法官部门分布
	 * @param fydms
	 * @return
	 */
	public List<FgBmFbVO> getFgbmfbByFy(int...fydms);
	/**
	 * 根据法院获得法官法律职务分布
	 * @param fydms
	 * @return
	 */
	public List<FgFlzwFbVO> getFgflzwfbByFy(int...fydms);
	/**
	 * 根据法院获得在编书记员部门分布
	 * @param fydms
	 * @return
	 */
	public List<SjyFbVO> getZbsjyfbByFy(int...fydms);
	/**
	 * 根据法院获得编外书记员部门分布
	 * @param fydms
	 * @return
	 */
	public List<SjyFbVO> getBwsjyfbByFy(int...fydms);
	/**
	 * 根据法院获得在编法官助理部门分布
	 * @param fydms
	 * @return
	 */
	public List<FgzlFbVO> getZbfgzlfbByFy(int...fydms);
	/**
	 * 根据法院获得编外法官助理部门分布
	 * @param fydms
	 * @return
	 */
	public List<FgzlFbVO> getBwfgzlfbByFy(int...fydms);
	/**
	 * 根据法院获得法官职级分布
	 * @param fydms
	 * @return
	 */
	public List<ZjFbVO> getFgzjfbByFy(int...fydms);
	/**
	 * 根据法院获得非领导法官职级分布
	 * @param fydms
	 * @return
	 */
	public List<ZjFbVO> getFldfgzjfbByFy(int...fydms);
	/**
	 * 根据法院获得庭长职级分布
	 * @param fydms
	 * @return
	 */
	public List<TzZjVO> getTzzjfbByFy(int...fydms);
	/**
	 * 根据法院获得法官年龄和学历分布
	 * @param fydms
	 * @return
	 */
	public List<NlAndXlFbVO> getFgNlAndXlFbByFy(int...fydms);
	/**
	 * 根据法院获得领导班子职级分布
	 * @param fydms
	 * @return
	 */
	public List<ZjFbVO> getLdbzZjFbByFy(int...fydms);
	/**
	 * 根据法院获得领导班子年龄和学历分布
	 * @param fydms
	 * @return
	 */
	public List<NlAndXlFbVO> getLdbzNlAndXlFbByFy(int...fydms);
}
