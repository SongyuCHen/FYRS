package nju.software.fyrs.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import com.googlecode.ehcache.annotations.Cacheable;

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
import nju.software.fyrs.data.dao.DmDAO;
import nju.software.fyrs.data.dao.GdtjDAO;
import nju.software.fyrs.data.dao.GdtjTjbtjDAO;
import nju.software.fyrs.data.dao.HdbzDAO;
import nju.software.fyrs.data.dao.JgxxDAO;
import nju.software.fyrs.data.dao.JlwhDAO;
import nju.software.fyrs.data.dao.RyjbxxDAO;
import nju.software.fyrs.data.dao.RysxJianglixxDAO;
import nju.software.fyrs.data.dataobject.Dm;
import nju.software.fyrs.data.dataobject.Gdtj;
import nju.software.fyrs.data.dataobject.GdtjTjbtj;
import nju.software.fyrs.data.dataobject.Jgxx;
import nju.software.fyrs.data.dataobject.Jlwh;
import nju.software.fyrs.data.dataobject.Ryjbxx;
import nju.software.fyrs.data.dataobject.RysxHdbz;
import nju.software.fyrs.data.dataobject.RysxJianglixx;
import nju.software.fyrs.service.GdtjService;
import nju.software.fyrs.service.convertor.RyviewConvertor;
import nju.software.fyrs.service.model.RyviewModel;
import nju.software.fyrs.util.ConstantsFyrs;
import nju.software.fyrs.util.DmMcCommon;

public class GdtjServiceImpl implements GdtjService {
	private GdtjDAO gdtjDAO;
	private GdtjTjbtjDAO gdtjTjbtjDAO;
	private RysxJianglixxDAO rysxJianglixxDAO;
	private DmDAO dmDAO;
	private RyjbxxDAO ryjbxxDAO;
	private RyviewConvertor ryviewConvertor;
	private JlwhDAO jlwhDAO;
	private JgxxDAO jgxxDAO;
	private HdbzDAO hdbzDAO;

	public void setGdtjDAO(GdtjDAO gdtjDAO) {
		this.gdtjDAO = gdtjDAO;
	}
	
	public void setGdtjTjbtjDAO(GdtjTjbtjDAO gdtjTjbtjDAO) {
		this.gdtjTjbtjDAO = gdtjTjbtjDAO;
	}
	

	public void setRysxJianglixxDAO(RysxJianglixxDAO rysxJianglixxDAO) {
		this.rysxJianglixxDAO = rysxJianglixxDAO;
	}

	public void setDmDAO(DmDAO dmDAO) {
		this.dmDAO = dmDAO;
	}

	public void setRyjbxxDAO(RyjbxxDAO ryjbxxDAO) {
		this.ryjbxxDAO = ryjbxxDAO;
	}

	public void setRyviewConvertor(RyviewConvertor ryviewConvertor) {
		this.ryviewConvertor = ryviewConvertor;
	}

	public void setJlwhDAO(JlwhDAO jlwhDAO) {
		this.jlwhDAO = jlwhDAO;
	}

	public void setJgxxDAO(JgxxDAO jgxxDAO) {
		this.jgxxDAO = jgxxDAO;
	}

	public void setHdbzDAO(HdbzDAO hdbzDAO) {
		this.hdbzDAO = hdbzDAO;
	}

	@Override
	@Cacheable(cacheName="gdtjCache")
	public List<GdtjVO> getGdtjList() {
		List<Gdtj>gdtjs=gdtjDAO.findAll();
		List<GdtjVO>gdtjvos=new ArrayList<GdtjVO>();
		for(Gdtj gdtj:gdtjs){
			GdtjVO gdtjvo=new GdtjVO();
			gdtjvo.setBbh(gdtj.getNBbh());
			gdtjvo.setTjbbh(gdtj.getCTjbbh());
			gdtjvo.setTjbmc(gdtj.getCTjbmc());
			gdtjvos.add(gdtjvo);
		}
		return gdtjvos;
	}
	@Override
	@Cacheable(cacheName="gdtjCache")
	public List<ArrayList<GdtjTjVO>> getGdtjTjList(int bbh) {
		ArrayList<ArrayList<GdtjTjVO>>gdtjtjvos=new ArrayList<ArrayList<GdtjTjVO>>();
		ArrayList<GdtjTjVO>hangtjvos=new ArrayList<GdtjTjVO>();
		ArrayList<GdtjTjVO>lietjvos=new ArrayList<GdtjTjVO>();
		List<GdtjTjbtj>hangtjs=gdtjTjbtjDAO.findHangTjByBbh(bbh);
		List<GdtjTjbtj>lietjs=gdtjTjbtjDAO.findLieTjByBbh(bbh);
		for(GdtjTjbtj tj:hangtjs){
			GdtjTjVO tjvo=new GdtjTjVO();
			tjvo.setBbh(bbh);
			tjvo.setTjbh(tj.getNTjbh());
			tjvo.setTjm(tj.getCTjm());
			hangtjvos.add(tjvo);
		}
		for(GdtjTjbtj tj:lietjs){
			GdtjTjVO tjvo=new GdtjTjVO();
			tjvo.setBbh(bbh);
			tjvo.setTjbh(tj.getNTjbh());
			tjvo.setTjm(tj.getCTjm());
			lietjvos.add(tjvo);
		}
		gdtjtjvos.add(hangtjvos);
		gdtjtjvos.add(lietjvos);
		return gdtjtjvos;
	}

	@Override
	@Cacheable(cacheName="gdtjCache")
	public String[][] getTjResult(String bbh, String hang,
			String lie, int fydm) {
		List<GdtjTjbtj>hangtjs=gdtjTjbtjDAO.findTjByTjbhs(hang);
		List<GdtjTjbtj>lietjs=gdtjTjbtjDAO.findTjByTjbhs(lie);
		int hangSize=hangtjs.size();
		int lieSize=lietjs.size();
		String[][]result=new String[hangSize+1][lieSize+1];
		result[0][0]="";
		for(int i=0;i<lieSize;i++){
			result[0][i+1]=lietjs.get(i).getCTjm();
		}
		for(int i=0;i<hangSize;i++){
			result[i+1][0]=hangtjs.get(i).getCTjm();
			for(int j=0;j<lieSize;j++){
				String hangtj=hangtjs.get(i).getCWhere();
				hangtj=(hangtj==null)?"":hangtj;
				String lietj=lietjs.get(j).getCWhere();
				lietj=(lietj==null)?"":lietj;
				String hangFroms=hangtjs.get(i).getCTable();
				String lieFroms=lietjs.get(j).getCTable();
				String[]hangTokens=hangFroms.split(",");
				String[]lieTokens=lieFroms.split(",");
				ArrayList<String>froms=new ArrayList<String>();
				for(String hangToken:hangTokens){
					if(!froms.contains(hangToken.trim()))froms.add(hangToken.trim());
				}
				for(String lieToken:lieTokens){
					if(!froms.contains(lieToken.trim()))froms.add(lieToken.trim());
				}
				String fromT="";
				for(String from:froms){
					fromT+=from+",";
				}
				fromT=fromT.substring(0, fromT.length() - 1);
				String jjhs="count(*)";
				if(hangtjs.get(i).getCJjhs()!=null&&!hangtjs.get(i).getCJjhs().trim().equals(""))jjhs=hangtjs.get(i).getCJjhs();
				if(lietjs.get(j).getCJjhs()!=null&&!lietjs.get(j).getCJjhs().trim().equals(""))jjhs=lietjs.get(j).getCJjhs();
				String hql="select "+jjhs+" from "+fromT+" where "+hangtj+" "+lietj;
				hql = hql.replace("#FY#", ""+fydm);
				try{
					
					Long count=gdtjTjbtjDAO.getCountBySQL(hql);
					result[i+1][j+1]=count==null?"-":count.toString();
				}catch(Exception e){
					e.printStackTrace();
				}
			}
		}
		return result;
	}

	@Override
	@Cacheable(cacheName="gdtjCache")
	public GdtjVO getGdtjByBbh(String bbh) {
		Gdtj gdtj=gdtjDAO.findByBbh(bbh);
		GdtjVO gdtjvo=new GdtjVO();
		gdtjvo.setBbh(gdtj.getNBbh());
		gdtjvo.setTjbbh(gdtj.getCTjbbh());
		gdtjvo.setTjbmc(gdtj.getCTjbmc());
		return gdtjvo;
	}

	@SuppressWarnings("deprecation")
	@Override
	@Cacheable(cacheName="gdtjCache")
	public List<GrJlVO> getGrJl(int fydm) {
		List<GrJlVO>vos=new ArrayList<GrJlVO>();
		List<RysxJianglixx>jlxxs=rysxJianglixxDAO.getJianglixxByFy(fydm);
		Map<String,String> mapNames = new HashMap<String,String>();
		for(RysxJianglixx jlxx:jlxxs){
			GrJlVO vo=new GrJlVO();
			vo.setBzjg(jlxx.getCPzdw());
			vo.setBzmc(DmMcCommon.dmMc(jlxx.getNJllb(),ConstantsFyrs.NBXH_GRJLLB,mapNames,dmDAO));
			if(jlxx.getDJlsj()!=null)vo.setBzrq((jlxx.getDJlsj().getYear()+1900)+"."+(jlxx.getDJlsj().getMonth()+1));
			Ryjbxx ryjbxx=ryjbxxDAO.getRyByFyAndRybh(fydm,jlxx.getNRybh());
			RyviewModel ry=ryviewConvertor.getViewByRy(ryjbxx);
			vo.setXm(ry.getXm());
			vo.setXb(ry.getXb());
			vos.add(vo);
		}
		return vos;
	}

	@SuppressWarnings("deprecation")
	@Override
	@Cacheable(cacheName="gdtjCache")
	public List<JtJlVO> getJtJl(int fydm) {
		List<JtJlVO>vos=new ArrayList<JtJlVO>();
		List<Jlwh>jlwhs=jlwhDAO.listJlwhByFyAsc(fydm);
		Map<String,String> mapNames = new HashMap<String,String>();
		for(Jlwh jlwh:jlwhs){
			JtJlVO vo=new JtJlVO();
			vo.setBzjg(jlwh.getCPzdw());
			vo.setBzmc(DmMcCommon.dmMc(jlwh.getNJtjllb(),ConstantsFyrs.NBXH_JTJLLB,mapNames,dmDAO));
			if(jlwh.getDJlsj()!=null)vo.setBzrq((jlwh.getDJlsj().getYear()+1900)+"."+(jlwh.getDJlsj().getMonth()+1));
			
			if(jlwh.getNJlbm()<=0){
				vo.setSbzjt(DmMcCommon.dmMc(fydm,ConstantsFyrs.NBXH_DWMC,mapNames,dmDAO));
			}else if(jlwh.getNJlbm() >= 1000){
				if(mapNames.get(jlwh.getNJlbm().toString()) == null){
					Jgxx jgxx;
					if(jlwh.getNJlbm()<=1010)jgxx = jgxxDAO.bmByFyIdAndNcode(jlwh.getNFy(),jlwh.getNJlbm());
					else jgxx = jgxxDAO.findJgxxByFyUnicode(jlwh.getNFy(),jlwh.getNJlbm());
					if(jgxx != null){
						mapNames.put(jlwh.getNJlbm().toString(), jgxx.getCName());
						vo.setSbzjt(jgxx.getCName()); 
					}
					else{
						vo.setSbzjt(""); 
					}
				}
				else{
					vo.setSbzjt(mapNames.get(jlwh.getNJlbm().toString())); 
				}
			}else{
				vo.setSbzjt(DmMcCommon.dmMc(jlwh.getNJlbm(),ConstantsFyrs.NBXH_NSJG,mapNames,dmDAO));
			}
			vos.add(vo);
		}
		return vos;
	}

	@Override
	@Cacheable(cacheName="gdtjCache")
	public FyPzVO getFyPz(int fydm) {
		FyPzVO vo =new FyPzVO();
		vo.setSyzg(ryjbxxDAO.countByFy(fydm));
		vo.setFg(ryjbxxDAO.countFg(fydm));
		vo.setFg_swhwy(ryjbxxDAO.countFgByFlzw(fydm,3));
		vo.setFg_spy(ryjbxxDAO.countFgByFlzw(fydm,6));
		vo.setFg_zsy(ryjbxxDAO.countFgByFlzw(fydm,7));
		vo.setSjy(ryjbxxDAO.countByFlzw(fydm, 10));
		vo.setZxy(ryjbxxDAO.countByFlzw(fydm, 8));
		vo.setFgzl(ryjbxxDAO.countByFlzw(fydm, 9));
		vo.setSfjc(ryjbxxDAO.countByFlzw(fydm, 11));
		vo.setSfjdjsry(ryjbxxDAO.countByFlzw(fydm, 12));
		vo.setFg_yld(ryjbxxDAO.countFgByCondition(fydm, "NBm=1"));
		vo.setFg_spywbm(ryjbxxDAO.countFgByCondition(fydm, "NBm<50 and NBm>1"));
		vo.setFg_zhspywbm(ryjbxxDAO.countFgByCondition(fydm, "NBm in(50,71)"));
		return vo;
	}

	@Override
	@Cacheable(cacheName="gdtjCache")
	public List<BmPzVO> getFyBmPz(int fydm) {
		List<BmPzVO>vos=new ArrayList<BmPzVO>();
		Map<Integer, Long>bmMap=ryjbxxDAO.getBmFb(fydm);
		Map<String,String> mapNames = new HashMap<String,String>();
		Iterator<Entry<Integer, Long>> it=bmMap.entrySet().iterator();
		while(it.hasNext()){
			BmPzVO vo=new BmPzVO();
			Entry<Integer, Long>entry=(Entry<Integer, Long>) it.next();
			
			if(entry.getKey()>=1000){
				if(mapNames.get(entry.getKey().toString()) == null){
					Jgxx jgxx = jgxxDAO.bmByFyIdAndNcode(fydm,entry.getKey());
					if(jgxx != null){
						mapNames.put(entry.getKey().toString(), jgxx.getCName());
						vo.setBm(jgxx.getCName()); 
					}else{
						vo.setBm(""); 
					}
				}else{
					vo.setBm(mapNames.get(entry.getKey().toString())); 
				}
			}else{
				vo.setBm(DmMcCommon.dmMc(entry.getKey(),ConstantsFyrs.NBXH_NSJG,mapNames,dmDAO));
			}
			
			vo.setRs(entry.getValue());
			Map<Integer, Long>flzwMap=ryjbxxDAO.countBm(fydm, entry.getKey());
			vo.setTz(flzwMap.get(4)==null?0:flzwMap.get(4));
			vo.setFtz(flzwMap.get(5)==null?0:flzwMap.get(5));
			vo.setSpy(flzwMap.get(6)==null?0:flzwMap.get(6));
			vo.setZs(flzwMap.get(7)==null?0:flzwMap.get(7));
			vo.setSjy(flzwMap.get(10)==null?0:flzwMap.get(10));
			vo.setFgzl(flzwMap.get(9)==null?0:flzwMap.get(9));
			vos.add(vo);
		}
		return vos;
	}

	@SuppressWarnings("deprecation")
	@Override
	@Cacheable(cacheName="gdtjCache")
	public List<HmcVO> getHmcRyzb(int fydm) {
		List<HmcVO>vos = new ArrayList<HmcVO>();
		List<Ryjbxx>rys = ryjbxxDAO.getRyListByFy(fydm);
		Map<String,String> mapNames = new HashMap<String,String>();
		for(Ryjbxx ry:rys){
			HmcVO vo=new HmcVO();
			vo.setName(ry.getCXm());
			if(ry.getNBm()>=1000){
				if(mapNames.get(ry.getNBm().toString()) == null){
					Jgxx jgxx = jgxxDAO.bmByFyIdAndNcode(fydm,ry.getNBm());
					if(jgxx != null){
						mapNames.put(ry.getNBm().toString(), jgxx.getCName());
						vo.setBm(jgxx.getCName()); 
					}else{
						vo.setBm(""); 
					}
				}else{
					vo.setBm(mapNames.get(ry.getNBm().toString())); 
				}
			}else{
				vo.setBm(DmMcCommon.dmMc(ry.getNBm(),ConstantsFyrs.NBXH_NSJG,mapNames,dmDAO));
			}
			vo.setXb(DmMcCommon.dmMc(ry.getNXb(),ConstantsFyrs.NBXH_XB,mapNames,dmDAO));
			vo.setSfjzgb(ry.getNJly()==2?"是":"否");
			if(ry.getDCsrq()!=null)vo.setCsrq((ry.getDCsrq().getYear()+1900)+"."+(ry.getDCsrq().getMonth()+1));
			vo.setXzzw(DmMcCommon.dmMc(ry.getNXzzw(),ConstantsFyrs.NBXH_XZZW,mapNames,dmDAO));
			vo.setFlzw(DmMcCommon.dmMc(ry.getNFlzw(),ConstantsFyrs.NBXH_FLZW,mapNames,dmDAO));
			if(ry.getDXzzwRzrq()!=null)vo.setXzzwsj((ry.getDXzzwRzrq().getYear()+1900)+"."+(ry.getDXzzwRzrq().getMonth()+1));
			if(ry.getDFlzwRzrq()!=null)vo.setFlzwsj((ry.getDFlzwRzrq().getYear()+1900)+"."+(ry.getDFlzwRzrq().getMonth()+1));
			vo.setZj(DmMcCommon.dmMc(ry.getNZj(),ConstantsFyrs.NBXH_ZJ,mapNames,dmDAO));
			if(ry.getDZjrq()!=null)vo.setZjsj((ry.getDZjrq().getYear()+1900)+"."+(ry.getDZjrq().getMonth()+1));
			vo.setDj(DmMcCommon.dmMc(ry.getNDj(),ConstantsFyrs.NBXH_DJ,mapNames,dmDAO));
			if(ry.getDGzrq()!=null)vo.setGzsj((ry.getDGzrq().getYear()+1900)+"."+(ry.getDGzrq().getMonth()+1));
			if(ry.getDJyrq()!=null)vo.setJysj((ry.getDJyrq().getYear()+1900)+"."+(ry.getDJyrq().getMonth()+1));
			vo.setJg(ry.getCJg());
			vo.setXl(DmMcCommon.dmMc(ry.getNXl(),ConstantsFyrs.NBXH_WHCD,mapNames,dmDAO));
			vo.setXw(DmMcCommon.dmMc(ry.getNXw(),ConstantsFyrs.NBXH_XW,mapNames,dmDAO));
			vo.setZzmm(DmMcCommon.dmMc(ry.getNZzmm(),ConstantsFyrs.NBXH_ZZMM,mapNames,dmDAO));
			if(ry.getDZzmm()!=null)vo.setJrsj((ry.getDZzmm().getYear()+1900)+"."+(ry.getDZzmm().getMonth()+1));
			vos.add(vo);
		}
		return vos;
	}

	@Override
	@Cacheable(cacheName="gdtjCache")
	public List<HmcVO> getHmcByBm(int fydm, int bm) {
		List<Ryjbxx>rys = ryjbxxDAO.getRyListByFyAndBm(fydm, bm);
		return convertHmc(rys);
	}

	@Override
	@Cacheable(cacheName="gdtjCache")
	public List<HmcVO> getHmcByBmName(int fydm, String bmmc) {
		int bm;
		Dm dm=dmDAO.findDmByNBxhCMc(ConstantsFyrs.NBXH_NSJG, bmmc);
		if(dm==null){
			Jgxx jgxx=jgxxDAO.bmByFydmAndName(fydm, bmmc);{
				if(jgxx!=null){
					bm=jgxx.getNCode();
				}else{
					bm=-1;
				}
			}
		}else bm=dm.getNDm();
		return getHmcByBm(fydm, bm);
	}

	@Override
	@Cacheable(cacheName="gdtjCache")
	public List<HmcVO> getHmcByXzzw(int fydm, int xzzw) {
		List<Ryjbxx>rys = ryjbxxDAO.listByFydmXzzw(fydm, xzzw);
		return convertHmc(rys);
	}
	
	@SuppressWarnings("deprecation")
	private List<HmcVO>convertHmc(List<Ryjbxx>rys){
		List<HmcVO>vos = new ArrayList<HmcVO>();
		Map<String,String> mapNames = new HashMap<String,String>();
		for(Ryjbxx ry:rys){
			HmcVO vo=new HmcVO();
			vo.setName(ry.getCXm());
			if(ry.getDCsrq()!=null)vo.setCsrq((ry.getDCsrq().getYear()+1900)+"."+(ry.getDCsrq().getMonth()+1));
			vo.setXzzw(DmMcCommon.dmMc(ry.getNXzzw(),ConstantsFyrs.NBXH_XZZW,mapNames,dmDAO));
			vo.setFlzw(DmMcCommon.dmMc(ry.getNFlzw(),ConstantsFyrs.NBXH_FLZW,mapNames,dmDAO));
			if(ry.getDXzzwRzrq()!=null)vo.setXzzwsj((ry.getDXzzwRzrq().getYear()+1900)+"."+(ry.getDXzzwRzrq().getMonth()+1));
			if(ry.getDFlzwRzrq()!=null)vo.setFlzwsj((ry.getDFlzwRzrq().getYear()+1900)+"."+(ry.getDFlzwRzrq().getMonth()+1));
			vo.setZj(DmMcCommon.dmMc(ry.getNZj(),ConstantsFyrs.NBXH_ZJ,mapNames,dmDAO));
			if(ry.getDZjrq()!=null)vo.setZjsj((ry.getDZjrq().getYear()+1900)+"."+(ry.getDZjrq().getMonth()+1));
			vo.setDj(DmMcCommon.dmMc(ry.getNDj(),ConstantsFyrs.NBXH_DJ,mapNames,dmDAO));
			if(ry.getDGzrq()!=null)vo.setGzsj((ry.getDGzrq().getYear()+1900)+"."+(ry.getDGzrq().getMonth()+1));
			if(ry.getDJyrq()!=null)vo.setJysj((ry.getDJyrq().getYear()+1900)+"."+(ry.getDJyrq().getMonth()+1));
			vo.setJg(ry.getCJg());
			vo.setXl(DmMcCommon.dmMc(ry.getNXl(),ConstantsFyrs.NBXH_WHCD,mapNames,dmDAO));
			vo.setXw(DmMcCommon.dmMc(ry.getNXw(),ConstantsFyrs.NBXH_XW,mapNames,dmDAO));
			vo.setZzmm(DmMcCommon.dmMc(ry.getNZzmm(),ConstantsFyrs.NBXH_ZZMM,mapNames,dmDAO));
			if(ry.getDZzmm()!=null)vo.setJrsj((ry.getDZzmm().getYear()+1900)+"."+(ry.getDZzmm().getMonth()+1));
			vos.add(vo);
		}
		return vos;
	}
	
	@SuppressWarnings("deprecation")
	private List<HmcVO>convertHmcWithBm(List<Ryjbxx>rys){
		List<HmcVO>vos = new ArrayList<HmcVO>();
		Map<String,String> mapNames = new HashMap<String,String>();
		for(Ryjbxx ry:rys){
			HmcVO vo=new HmcVO();
			vo.setName(ry.getCXm());
			if(ry.getNBm()>=1000){
				if(mapNames.get(ry.getNBm().toString()) == null){
					Jgxx jgxx = jgxxDAO.bmByFyIdAndNcode(ry.getNFy(),ry.getNBm());
					if(jgxx != null){
						mapNames.put(ry.getNBm().toString(), jgxx.getCName());
						vo.setBm(jgxx.getCName()); 
					}else{
						vo.setBm(""); 
					}
				}else{
					vo.setBm(mapNames.get(ry.getNBm().toString())); 
				}
			}else{
				vo.setBm(DmMcCommon.dmMc(ry.getNBm(),ConstantsFyrs.NBXH_NSJG,mapNames,dmDAO));
			}
			if(ry.getDCsrq()!=null)vo.setCsrq((ry.getDCsrq().getYear()+1900)+"."+(ry.getDCsrq().getMonth()+1));
			vo.setXzzw(DmMcCommon.dmMc(ry.getNXzzw(),ConstantsFyrs.NBXH_XZZW,mapNames,dmDAO));
			vo.setFlzw(DmMcCommon.dmMc(ry.getNFlzw(),ConstantsFyrs.NBXH_FLZW,mapNames,dmDAO));
			if(ry.getDXzzwRzrq()!=null)vo.setXzzwsj((ry.getDXzzwRzrq().getYear()+1900)+"."+(ry.getDXzzwRzrq().getMonth()+1));
			if(ry.getDFlzwRzrq()!=null)vo.setFlzwsj((ry.getDFlzwRzrq().getYear()+1900)+"."+(ry.getDFlzwRzrq().getMonth()+1));
			vo.setZj(DmMcCommon.dmMc(ry.getNZj(),ConstantsFyrs.NBXH_ZJ,mapNames,dmDAO));
			if(ry.getDZjrq()!=null)vo.setZjsj((ry.getDZjrq().getYear()+1900)+"."+(ry.getDZjrq().getMonth()+1));
			vo.setDj(DmMcCommon.dmMc(ry.getNDj(),ConstantsFyrs.NBXH_DJ,mapNames,dmDAO));
			if(ry.getDGzrq()!=null)vo.setGzsj((ry.getDGzrq().getYear()+1900)+"."+(ry.getDGzrq().getMonth()+1));
			if(ry.getDJyrq()!=null)vo.setJysj((ry.getDJyrq().getYear()+1900)+"."+(ry.getDJyrq().getMonth()+1));
			vo.setJg(ry.getCJg());
			vo.setXl(DmMcCommon.dmMc(ry.getNXl(),ConstantsFyrs.NBXH_WHCD,mapNames,dmDAO));
			vo.setXw(DmMcCommon.dmMc(ry.getNXw(),ConstantsFyrs.NBXH_XW,mapNames,dmDAO));
			vo.setZzmm(DmMcCommon.dmMc(ry.getNZzmm(),ConstantsFyrs.NBXH_ZZMM,mapNames,dmDAO));
			if(ry.getDZzmm()!=null)vo.setJrsj((ry.getDZzmm().getYear()+1900)+"."+(ry.getDZzmm().getMonth()+1));
			vos.add(vo);
		}
		return vos;
	}

	@Override
	public Long countByFy(int fydm) {
		return ryjbxxDAO.countByFy(fydm);
	}

	@Override
	@Cacheable(cacheName="gdtjCache")
	public List<HmcVO> getZcgbHmc(int fydm, int zwlb) {
		List<Ryjbxx>rys=ryjbxxDAO.getRyListByFyAndZwlb(fydm, zwlb);
		return convertHmc(rys);
	}

	@Override
	@Cacheable(cacheName="gdtjCache")
	public List<HmcVO> getHmcByZjCondition(int fydm, String zjCondition) {
		List<Ryjbxx>rys=ryjbxxDAO.getRyListByFyAndZjCondition(fydm, zjCondition);
		return convertHmcWithBm(rys);
	}

	@Override
	@Cacheable(cacheName="gdtjCache")
	public List<HmcVO> getHmcByZj(int fydm, int zj) {
		List<Ryjbxx>rys=ryjbxxDAO.getRyListByFyAndZj(fydm, zj);
		return convertHmcWithBm(rys);
	}

	@Override
	@Cacheable(cacheName="gdtjCache")
	public List<HmcVO> getHmcByFlzw(int fydm, int flzw) {
		List<Ryjbxx>rys=ryjbxxDAO.getRyListByFyAndFlzw(fydm, flzw);
		return convertHmcWithBm(rys);
	}

	@Override
	@Cacheable(cacheName="gdtjCache")
	public List<HmcVO> getJzgbHmcByZj(int fydm, int zj) {
		List<Ryjbxx>rys=ryjbxxDAO.getJzgbRyListByFyAndZj(fydm, zj);
		return convertHmcWithBm(rys);
	}

	@Override
	@Cacheable(cacheName="gdtjCache")
	public List<HmcVO> getHmcByXb(int fydm, int xb) {
		List<Ryjbxx>rys=ryjbxxDAO.getRyListByFyAndXb(fydm, xb);
		return convertHmcWithBm(rys);
	}

	@Override
	@Cacheable(cacheName="gdtjCache")
	public List<HmcVO> getFdyHmc(int fydm) {
		List<Ryjbxx>rys=ryjbxxDAO.getFdyRyListByFy(fydm);
		return convertHmcWithBm(rys);
	}

	@Override
	@Cacheable(cacheName="gdtjCache")
	public List<BzPzVO> getHdbzPzByFy(int... fydms) {
		List<BzPzVO>vos=new ArrayList<BzPzVO>();
		int zj_zyzfzxbz=0;
		int zj_dfxzbz=0;
		int zj_zysybz=0;
		int zj_dfqesybz=0;
		int zj_dfcesybz=0;
		int zj_zczzsybz=0;
		int zj_xzfsbz=0;
		int zj_zbzs=0;
		
		for(int fydm : fydms){
			BzPzVO vo=new BzPzVO();
			RysxHdbz hdbz;
			
			Dm fy=dmDAO.findDmByNBxhNdm("1", fydm);
			vo.setDw(fy==null?"":fy.getCMc());
			
			int zyzfzxbz=0;
			hdbz = hdbzDAO.getLastHdbzByBzlx(fydm, "NZyZfzxbzBmldZz");
			if(hdbz!=null){
				zyzfzxbz = hdbz.getNZyZfzxbzBmldZz()+hdbz.getNZyZfzxbzBmldFz()+hdbz.getNZyZfzxbzBmldQt()+
						hdbz.getNZyZfzxbzNsjgldZzFc()+hdbz.getNZyZfzxbzNsjgldZzZk()+
						hdbz.getNZyZfzxbzNsjgldFzZk()+hdbz.getNZyZfzxbzNsjgldFzFk()+
						hdbz.getNZyZfzxbzNsjgldQt()+hdbz.getNZyZfzxbzDyy()+hdbz.getNZyZfzxbzFdyy()+
						hdbz.getNZyZfzxbzZrky()+hdbz.getNZyZfzxbzFzrky()+hdbz.getNZyZfzxbzKybsy();
				vo.setZyzfzxbz(zyzfzxbz);
				zj_zyzfzxbz += zyzfzxbz;
			}
			
			int dfxzbz=0;
			hdbz = hdbzDAO.getLastHdbzByBzlx(fydm, "NShengZfzxbzKbs");
			if(hdbz!=null)dfxzbz += hdbz.getNShengZfzxbzKbs();
			hdbz = hdbzDAO.getLastHdbzByBzlx(fydm, "NShiZfzxbzKbs");
			if(hdbz!=null)dfxzbz += hdbz.getNShiZfzxbzKbs();
			vo.setDfxzbz(dfxzbz);
			zj_dfxzbz += dfxzbz;
			
			int zysybz = 0;
			hdbz = hdbzDAO.getLastHdbzByBzlx(fydm, "NZySyKbs");
			if(hdbz!=null){
				zysybz = hdbz.getNZySyKbs();
				vo.setZysybz(zysybz);
				zj_zysybz += zysybz;
			}
			
			
			int dfqesybz=0;
			hdbz = hdbzDAO.getLastHdbzByBzlx(fydm, "NShengQeKbs");
			if(hdbz!=null)dfqesybz += hdbz.getNShengQeKbs();
			hdbz = hdbzDAO.getLastHdbzByBzlx(fydm, "NShiQeKbs");
			if(hdbz!=null)dfqesybz += hdbz.getNShiQeKbs();
			vo.setDfqesybz(dfqesybz);
			zj_dfqesybz += dfqesybz;
			
			int dfcesybz=0;
			hdbz = hdbzDAO.getLastHdbzByBzlx(fydm, "NShengCeKbs");
			if(hdbz!=null)dfcesybz += hdbz.getNShengCeKbs();
			hdbz = hdbzDAO.getLastHdbzByBzlx(fydm, "NShiCeKbs");
			if(hdbz!=null)dfcesybz += hdbz.getNShiCeKbs();
			vo.setDfcesybz(dfcesybz);
			zj_dfcesybz += dfcesybz;
			
			int zczzsybz=0;
			hdbz = hdbzDAO.getLastHdbzByBzlx(fydm, "NShengZczzKbs");
			if(hdbz!=null)zczzsybz += hdbz.getNShengZczzKbs();
			hdbz = hdbzDAO.getLastHdbzByBzlx(fydm, "NShiZczzKbs");
			if(hdbz!=null)zczzsybz += hdbz.getNShiZczzKbs();
			vo.setZczzsybz(zczzsybz);
			zj_zczzsybz += zczzsybz;
			
			int xzfsbz=0;
			hdbz = hdbzDAO.getLastHdbzByBzlx(fydm, "NShengFsKbs");
			if(hdbz!=null)xzfsbz += hdbz.getNShengFsKbs();
			hdbz = hdbzDAO.getLastHdbzByBzlx(fydm, "NShiFsKbs");
			if(hdbz!=null)xzfsbz += hdbz.getNShiFsKbs();
			vo.setXzfsbz(xzfsbz);
			zj_xzfsbz += xzfsbz;
			
			vo.setZbzs(vo.getZyzfzxbz()+vo.getDfxzbz()+vo.getZysybz()+vo.getDfqesybz()+
					vo.getDfcesybz()+vo.getZczzsybz()+vo.getXzfsbz());
			zj_zbzs += vo.getZbzs();
			
			vos.add(vo);
		}
		
		BzPzVO zj=new BzPzVO();
		zj.setDw("合计");
		zj.setZyzfzxbz(zj_zyzfzxbz);
		zj.setDfxzbz(zj_dfxzbz);
		zj.setZysybz(zj_zysybz);
		zj.setDfqesybz(zj_dfqesybz);
		zj.setDfcesybz(zj_dfcesybz);
		zj.setZczzsybz(zj_zczzsybz);
		zj.setXzfsbz(zj_xzfsbz);
		zj.setZbzs(zj_zbzs);
		
		vos.add(zj);
		
		return vos;
	}

	@Override
	@Cacheable(cacheName="gdtjCache")
	public List<BzPzVO> getSybzPzByFy(int... fydms) {
		List<BzPzVO>vos=new ArrayList<BzPzVO>();
		Map<String, Long>bzfbs = ryjbxxDAO.getBzFb(fydms);
		
		long zj_zyzfzxbz=0;
		long zj_dfxzbz=0;
		long zj_zysybz=0;
		long zj_dfqesybz=0;
		long zj_dfcesybz=0;
		long zj_zczzsybz=0;
		long zj_xzfsbz=0;
		long zj_zbzs=0;
		for(int fydm : fydms){
			BzPzVO vo=new BzPzVO();
			
			Dm fy=dmDAO.findDmByNBxhNdm("1", fydm);
			vo.setDw(fy==null?"":fy.getCMc());
			
			long zyzfzxbz = bzfbs.get(fydm+"-"+1)==null?0:bzfbs.get(fydm+"-"+1);
			vo.setZyzfzxbz(zyzfzxbz);
			zj_zyzfzxbz += zyzfzxbz;
			
			long dfxzbz = bzfbs.get(fydm+"-"+3)==null?0:bzfbs.get(fydm+"-"+3);
			vo.setDfxzbz(dfxzbz);
			zj_dfxzbz += dfxzbz;
			
			long zysybz = bzfbs.get(fydm+"-"+2)==null?0:bzfbs.get(fydm+"-"+2);
			vo.setZysybz(zysybz);
			zj_zysybz += zysybz;
			
			long dfqesybz = bzfbs.get(fydm+"-"+4)==null?0:bzfbs.get(fydm+"-"+4);
			vo.setDfqesybz(dfqesybz);
			zj_dfqesybz += dfqesybz;
			
			long dfcesybz = bzfbs.get(fydm+"-"+5)==null?0:bzfbs.get(fydm+"-"+5);
			vo.setDfcesybz(dfcesybz);
			zj_dfcesybz += dfcesybz;
			
			long zczzsybz = bzfbs.get(fydm+"-"+8)==null?0:bzfbs.get(fydm+"-"+8);
			vo.setZczzsybz(zczzsybz);
			zj_zczzsybz += zczzsybz;
			
			long xzfsbz = bzfbs.get(fydm+"-"+6)==null?0:bzfbs.get(fydm+"-"+6);
			vo.setXzfsbz(xzfsbz);
			zj_xzfsbz += xzfsbz;
			
			vo.setZbzs(zyzfzxbz+dfxzbz+zysybz+dfqesybz+dfcesybz+zczzsybz+xzfsbz);
			zj_zbzs += vo.getZbzs();
			
			vos.add(vo);
		}
		BzPzVO zj=new BzPzVO();
		zj.setDw("合计");
		zj.setZyzfzxbz(zj_zyzfzxbz);
		zj.setDfxzbz(zj_dfxzbz);
		zj.setZysybz(zj_zysybz);
		zj.setDfqesybz(zj_dfqesybz);
		zj.setDfcesybz(zj_dfcesybz);
		zj.setZczzsybz(zj_zczzsybz);
		zj.setXzfsbz(zj_xzfsbz);
		zj.setZbzs(zj_zbzs);
		
		vos.add(zj);
		
		return vos;
	}

	@Override
	@Cacheable(cacheName="gdtjCache")
	public List<FgBmFbVO> getFgbmfbByFy(int... fydms) {
		List<FgBmFbVO>vos=new ArrayList<FgBmFbVO>();
		Map<String, Long> fbs = ryjbxxDAO.getFgBmFb(fydms);
		
		long zj_zs=0;
		long zj_yld=0;
		long zj_xs=0;
		long zj_ms=0;
		long zj_xz=0;
		long zj_sj=0;
		long zj_la=0;
		long zj_zx=0;
		long zj_zhsp=0;
		long zj_zh=0;
		long zj_qt=0;
		
		for(int fydm : fydms){
			FgBmFbVO vo = new FgBmFbVO();
			
			Dm fy=dmDAO.findDmByNBxhNdm("1", fydm);
			vo.setDw(fy==null?"":fy.getCMc());
			
			long yld = fbs.get(fydm+"-"+1)==null?0:fbs.get(fydm+"-"+1);
			zj_yld += yld;
			
			long xs = (fbs.get(fydm+"-"+2)==null?0:fbs.get(fydm+"-"+2))+
					(fbs.get(fydm+"-"+3)==null?0:fbs.get(fydm+"-"+3))+
					(fbs.get(fydm+"-"+4)==null?0:fbs.get(fydm+"-"+4))+
					(fbs.get(fydm+"-"+5)==null?0:fbs.get(fydm+"-"+5))+
					(fbs.get(fydm+"-"+6)==null?0:fbs.get(fydm+"-"+6))+
					(fbs.get(fydm+"-"+7)==null?0:fbs.get(fydm+"-"+7))+
					(fbs.get(fydm+"-"+8)==null?0:fbs.get(fydm+"-"+8))+
					(fbs.get(fydm+"-"+9)==null?0:fbs.get(fydm+"-"+9));
			zj_xs += xs;
			
			long ms = (fbs.get(fydm+"-"+10)==null?0:fbs.get(fydm+"-"+10))+
					(fbs.get(fydm+"-"+11)==null?0:fbs.get(fydm+"-"+11))+
					(fbs.get(fydm+"-"+12)==null?0:fbs.get(fydm+"-"+12))+
					(fbs.get(fydm+"-"+13)==null?0:fbs.get(fydm+"-"+13))+
					(fbs.get(fydm+"-"+14)==null?0:fbs.get(fydm+"-"+14))+
					(fbs.get(fydm+"-"+15)==null?0:fbs.get(fydm+"-"+15))+
					(fbs.get(fydm+"-"+16)==null?0:fbs.get(fydm+"-"+16))+
					(fbs.get(fydm+"-"+17)==null?0:fbs.get(fydm+"-"+17));
			zj_ms += ms;
			
			long xz = fbs.get(fydm+"-"+23)==null?0:fbs.get(fydm+"-"+23);
			zj_xz += xz;
			
			long sj = (fbs.get(fydm+"-"+34)==null?0:fbs.get(fydm+"-"+34))+
					(fbs.get(fydm+"-"+35)==null?0:fbs.get(fydm+"-"+35))+
					(fbs.get(fydm+"-"+36)==null?0:fbs.get(fydm+"-"+36))+
					(fbs.get(fydm+"-"+37)==null?0:fbs.get(fydm+"-"+37))+
					(fbs.get(fydm+"-"+38)==null?0:fbs.get(fydm+"-"+38))+
					(fbs.get(fydm+"-"+39)==null?0:fbs.get(fydm+"-"+39))+
					(fbs.get(fydm+"-"+40)==null?0:fbs.get(fydm+"-"+40))+
					(fbs.get(fydm+"-"+41)==null?0:fbs.get(fydm+"-"+41));
			zj_sj += sj;
			
			long la = (fbs.get(fydm+"-"+26)==null?0:fbs.get(fydm+"-"+26))+
					(fbs.get(fydm+"-"+27)==null?0:fbs.get(fydm+"-"+27))+
					(fbs.get(fydm+"-"+28)==null?0:fbs.get(fydm+"-"+28))+
					(fbs.get(fydm+"-"+29)==null?0:fbs.get(fydm+"-"+29))+
					(fbs.get(fydm+"-"+30)==null?0:fbs.get(fydm+"-"+30))+
					(fbs.get(fydm+"-"+31)==null?0:fbs.get(fydm+"-"+31))+
					(fbs.get(fydm+"-"+32)==null?0:fbs.get(fydm+"-"+32))+
					(fbs.get(fydm+"-"+33)==null?0:fbs.get(fydm+"-"+33));
			zj_la =+ la;
			
			long zx = fbs.get(fydm+"-"+24)==null?0:fbs.get(fydm+"-"+24);
			zj_zx += zx;
			
			long zhsp = (fbs.get(fydm+"-"+50)==null?0:fbs.get(fydm+"-"+50))+
					(fbs.get(fydm+"-"+71)==null?0:fbs.get(fydm+"-"+71));
			zj_zhsp += zhsp;
			
			long zh = (fbs.get(fydm+"-"+51)==null?0:fbs.get(fydm+"-"+51))+
					(fbs.get(fydm+"-"+52)==null?0:fbs.get(fydm+"-"+52))+
					(fbs.get(fydm+"-"+55)==null?0:fbs.get(fydm+"-"+55))+
					(fbs.get(fydm+"-"+53)==null?0:fbs.get(fydm+"-"+53))+
					(fbs.get(fydm+"-"+54)==null?0:fbs.get(fydm+"-"+54))+
					(fbs.get(fydm+"-"+64)==null?0:fbs.get(fydm+"-"+64))+
					(fbs.get(fydm+"-"+65)==null?0:fbs.get(fydm+"-"+65))+
					(fbs.get(fydm+"-"+70)==null?0:fbs.get(fydm+"-"+70))+
					(fbs.get(fydm+"-"+57)==null?0:fbs.get(fydm+"-"+57))+
					(fbs.get(fydm+"-"+66)==null?0:fbs.get(fydm+"-"+66));
			zj_zh += zh;
			
			long qt = ryjbxxDAO.countFgByCondition(fydm, "((NBm>=18 and NBm<=22) or NBm=25 or (NBm>=42 and NBm<=49)" +
					" or NBm=56 or (NBm>=58 and NBm<=63) or (NBm>=67 and NBm<=69) or NBm>=72)");
			zj_qt += qt;
			
			long zs = yld+xs+ms+xz+sj+la+zx+zhsp+zh+qt;
			zj_zs += zs;
			
			vo.setYld(yld);
			vo.setXs(xs);
			vo.setMs(ms);
			vo.setXz(xz);
			vo.setSj(sj);
			vo.setLa(la);
			vo.setZx(zx);
			vo.setZhsp(zhsp);
			vo.setZh(zh);
			vo.setQt(qt);
			vo.setZs(zs);
			
			vos.add(vo);
		}
		
		FgBmFbVO zj=new FgBmFbVO();
		zj.setDw("合计");
		zj.setYld(zj_yld);
		zj.setXs(zj_xs);
		zj.setMs(zj_ms);
		zj.setXz(zj_xz);
		zj.setSj(zj_sj);
		zj.setLa(zj_la);
		zj.setZx(zj_zx);
		zj.setZhsp(zj_zhsp);
		zj.setZh(zj_zh);
		zj.setQt(zj_qt);
		zj.setZs(zj_zs);
		vos.add(zj);
		
		return vos;
	}

	@Override
	@Cacheable(cacheName="gdtjCache")
	public List<FgFlzwFbVO> getFgflzwfbByFy(int... fydms) {
		List<FgFlzwFbVO>vos=new ArrayList<FgFlzwFbVO>();
		Map<String, Long> fgbmfbs = ryjbxxDAO.getFgBmFb(fydms);
		Map<String, Long> fgflzwfbs = ryjbxxDAO.getFgFlzwFb(fydms);
		
		long zj_yld=0;
		long zj_tz=0;
		long zj_ftz=0;
		long zj_spy=0;
		long zj_zsy=0;
		long zj_zs=0;
		for(int fydm : fydms){
			FgFlzwFbVO vo = new FgFlzwFbVO();
			
			Dm fy=dmDAO.findDmByNBxhNdm("1", fydm);
			vo.setDw(fy==null?"":fy.getCMc());
			
			long yld = fgbmfbs.get(fydm+"-"+1)==null?0:fgbmfbs.get(fydm+"-"+1);
			zj_yld += yld;
			
			long tz = fgflzwfbs.get(fydm+"-"+4)==null?0:fgflzwfbs.get(fydm+"-"+4);
			zj_tz += tz;
			
			long ftz = fgflzwfbs.get(fydm+"-"+5)==null?0:fgflzwfbs.get(fydm+"-"+5);
			zj_ftz += ftz;
			
			long spy = fgflzwfbs.get(fydm+"-"+6)==null?0:fgflzwfbs.get(fydm+"-"+6);
			zj_spy += spy;
			
			long zsy = fgflzwfbs.get(fydm+"-"+7)==null?0:fgflzwfbs.get(fydm+"-"+7);
			zj_zsy += zsy;
			
			long zs = ryjbxxDAO.countFg(fydm);
			zj_zs += zs;
			
			vo.setYld(yld);
			vo.setTz(tz);
			vo.setFtz(ftz);
			vo.setSpy(spy);
			vo.setZsy(zsy);
			vo.setZs(zs);
			
			vos.add(vo);
		}
		
		FgFlzwFbVO zj = new FgFlzwFbVO();
		zj.setDw("合计");
		zj.setYld(zj_yld);
		zj.setTz(zj_tz);
		zj.setFtz(zj_ftz);
		zj.setSpy(zj_spy);
		zj.setZsy(zj_zsy);
		zj.setZs(zj_zs);
		vos.add(zj);
		
		return vos;
	}

	@Override
	@Cacheable(cacheName="gdtjCache")
	public List<SjyFbVO> getZbsjyfbByFy(int... fydms) {
		List<SjyFbVO>vos=new ArrayList<SjyFbVO>();
		Map<String, Long> fbs = ryjbxxDAO.getZbsjyFb(fydms);
		
		long zj_zs=0;
		long zj_xs=0;
		long zj_ms=0;
		long zj_xz=0;
		long zj_sj=0;
		long zj_la=0;
		long zj_zx=0;
		long zj_zhsp=0;
		long zj_zh=0;
		
		for(int fydm : fydms){
			SjyFbVO vo = new SjyFbVO();
			
			Dm fy=dmDAO.findDmByNBxhNdm("1", fydm);
			vo.setDw(fy==null?"":fy.getCMc());
			
			long xs = (fbs.get(fydm+"-"+2)==null?0:fbs.get(fydm+"-"+2))+
					(fbs.get(fydm+"-"+3)==null?0:fbs.get(fydm+"-"+3))+
					(fbs.get(fydm+"-"+4)==null?0:fbs.get(fydm+"-"+4))+
					(fbs.get(fydm+"-"+5)==null?0:fbs.get(fydm+"-"+5))+
					(fbs.get(fydm+"-"+6)==null?0:fbs.get(fydm+"-"+6))+
					(fbs.get(fydm+"-"+7)==null?0:fbs.get(fydm+"-"+7))+
					(fbs.get(fydm+"-"+8)==null?0:fbs.get(fydm+"-"+8))+
					(fbs.get(fydm+"-"+9)==null?0:fbs.get(fydm+"-"+9));
			zj_xs += xs;
			
			long ms = (fbs.get(fydm+"-"+10)==null?0:fbs.get(fydm+"-"+10))+
					(fbs.get(fydm+"-"+11)==null?0:fbs.get(fydm+"-"+11))+
					(fbs.get(fydm+"-"+12)==null?0:fbs.get(fydm+"-"+12))+
					(fbs.get(fydm+"-"+13)==null?0:fbs.get(fydm+"-"+13))+
					(fbs.get(fydm+"-"+14)==null?0:fbs.get(fydm+"-"+14))+
					(fbs.get(fydm+"-"+15)==null?0:fbs.get(fydm+"-"+15))+
					(fbs.get(fydm+"-"+16)==null?0:fbs.get(fydm+"-"+16))+
					(fbs.get(fydm+"-"+17)==null?0:fbs.get(fydm+"-"+17));
			zj_ms += ms;
			
			long xz = fbs.get(fydm+"-"+23)==null?0:fbs.get(fydm+"-"+23);
			zj_xz += xz;
			
			long sj = (fbs.get(fydm+"-"+34)==null?0:fbs.get(fydm+"-"+34))+
					(fbs.get(fydm+"-"+35)==null?0:fbs.get(fydm+"-"+35))+
					(fbs.get(fydm+"-"+36)==null?0:fbs.get(fydm+"-"+36))+
					(fbs.get(fydm+"-"+37)==null?0:fbs.get(fydm+"-"+37))+
					(fbs.get(fydm+"-"+38)==null?0:fbs.get(fydm+"-"+38))+
					(fbs.get(fydm+"-"+39)==null?0:fbs.get(fydm+"-"+39))+
					(fbs.get(fydm+"-"+40)==null?0:fbs.get(fydm+"-"+40))+
					(fbs.get(fydm+"-"+41)==null?0:fbs.get(fydm+"-"+41));
			zj_sj += sj;
			
			long la = (fbs.get(fydm+"-"+26)==null?0:fbs.get(fydm+"-"+26))+
					(fbs.get(fydm+"-"+27)==null?0:fbs.get(fydm+"-"+27))+
					(fbs.get(fydm+"-"+28)==null?0:fbs.get(fydm+"-"+28))+
					(fbs.get(fydm+"-"+29)==null?0:fbs.get(fydm+"-"+29))+
					(fbs.get(fydm+"-"+30)==null?0:fbs.get(fydm+"-"+30))+
					(fbs.get(fydm+"-"+31)==null?0:fbs.get(fydm+"-"+31))+
					(fbs.get(fydm+"-"+32)==null?0:fbs.get(fydm+"-"+32))+
					(fbs.get(fydm+"-"+33)==null?0:fbs.get(fydm+"-"+33));
			zj_la =+ la;
			
			long zx = fbs.get(fydm+"-"+24)==null?0:fbs.get(fydm+"-"+24);
			zj_zx += zx;
			
			long zhsp = (fbs.get(fydm+"-"+50)==null?0:fbs.get(fydm+"-"+50))+
					(fbs.get(fydm+"-"+71)==null?0:fbs.get(fydm+"-"+71));
			zj_zhsp += zhsp;
			
			long zh = (fbs.get(fydm+"-"+51)==null?0:fbs.get(fydm+"-"+51))+
					(fbs.get(fydm+"-"+52)==null?0:fbs.get(fydm+"-"+52))+
					(fbs.get(fydm+"-"+55)==null?0:fbs.get(fydm+"-"+55))+
					(fbs.get(fydm+"-"+53)==null?0:fbs.get(fydm+"-"+53))+
					(fbs.get(fydm+"-"+54)==null?0:fbs.get(fydm+"-"+54))+
					(fbs.get(fydm+"-"+64)==null?0:fbs.get(fydm+"-"+64))+
					(fbs.get(fydm+"-"+65)==null?0:fbs.get(fydm+"-"+65))+
					(fbs.get(fydm+"-"+70)==null?0:fbs.get(fydm+"-"+70))+
					(fbs.get(fydm+"-"+57)==null?0:fbs.get(fydm+"-"+57))+
					(fbs.get(fydm+"-"+66)==null?0:fbs.get(fydm+"-"+66));
			zj_zh += zh;
			
			long zs = xs+ms+xz+sj+la+zx+zhsp+zh;
			zj_zs += zs;
			
			vo.setXs(xs);
			vo.setMs(ms);
			vo.setXz(xz);
			vo.setSj(sj);
			vo.setLa(la);
			vo.setZx(zx);
			vo.setZhsp(zhsp);
			vo.setZh(zh);
			vo.setZs(zs);
			
			vos.add(vo);
		}
		
		SjyFbVO zj=new SjyFbVO();
		zj.setDw("合计");
		zj.setXs(zj_xs);
		zj.setMs(zj_ms);
		zj.setXz(zj_xz);
		zj.setSj(zj_sj);
		zj.setLa(zj_la);
		zj.setZx(zj_zx);
		zj.setZhsp(zj_zhsp);
		zj.setZh(zj_zh);
		zj.setZs(zj_zs);
		vos.add(zj);
		
		return vos;
	}

	@Override
	@Cacheable(cacheName="gdtjCache")
	public List<SjyFbVO> getBwsjyfbByFy(int... fydms) {
		List<SjyFbVO>vos=new ArrayList<SjyFbVO>();
		Map<String, Long> fbs = ryjbxxDAO.getBwsjyFb(fydms);
		
		long zj_zs=0;
		long zj_xs=0;
		long zj_ms=0;
		long zj_xz=0;
		long zj_sj=0;
		long zj_la=0;
		long zj_zx=0;
		
		for(int fydm : fydms){
			SjyFbVO vo = new SjyFbVO();
			
			Dm fy=dmDAO.findDmByNBxhNdm("1", fydm);
			vo.setDw(fy==null?"":fy.getCMc());
			
			long xs = (fbs.get(fydm+"-"+2)==null?0:fbs.get(fydm+"-"+2))+
					(fbs.get(fydm+"-"+3)==null?0:fbs.get(fydm+"-"+3))+
					(fbs.get(fydm+"-"+4)==null?0:fbs.get(fydm+"-"+4))+
					(fbs.get(fydm+"-"+5)==null?0:fbs.get(fydm+"-"+5))+
					(fbs.get(fydm+"-"+6)==null?0:fbs.get(fydm+"-"+6))+
					(fbs.get(fydm+"-"+7)==null?0:fbs.get(fydm+"-"+7))+
					(fbs.get(fydm+"-"+8)==null?0:fbs.get(fydm+"-"+8))+
					(fbs.get(fydm+"-"+9)==null?0:fbs.get(fydm+"-"+9));
			zj_xs += xs;
			
			long ms = (fbs.get(fydm+"-"+10)==null?0:fbs.get(fydm+"-"+10))+
					(fbs.get(fydm+"-"+11)==null?0:fbs.get(fydm+"-"+11))+
					(fbs.get(fydm+"-"+12)==null?0:fbs.get(fydm+"-"+12))+
					(fbs.get(fydm+"-"+13)==null?0:fbs.get(fydm+"-"+13))+
					(fbs.get(fydm+"-"+14)==null?0:fbs.get(fydm+"-"+14))+
					(fbs.get(fydm+"-"+15)==null?0:fbs.get(fydm+"-"+15))+
					(fbs.get(fydm+"-"+16)==null?0:fbs.get(fydm+"-"+16))+
					(fbs.get(fydm+"-"+17)==null?0:fbs.get(fydm+"-"+17));
			zj_ms += ms;
			
			long xz = fbs.get(fydm+"-"+23)==null?0:fbs.get(fydm+"-"+23);
			zj_xz += xz;
			
			long sj = (fbs.get(fydm+"-"+34)==null?0:fbs.get(fydm+"-"+34))+
					(fbs.get(fydm+"-"+35)==null?0:fbs.get(fydm+"-"+35))+
					(fbs.get(fydm+"-"+36)==null?0:fbs.get(fydm+"-"+36))+
					(fbs.get(fydm+"-"+37)==null?0:fbs.get(fydm+"-"+37))+
					(fbs.get(fydm+"-"+38)==null?0:fbs.get(fydm+"-"+38))+
					(fbs.get(fydm+"-"+39)==null?0:fbs.get(fydm+"-"+39))+
					(fbs.get(fydm+"-"+40)==null?0:fbs.get(fydm+"-"+40))+
					(fbs.get(fydm+"-"+41)==null?0:fbs.get(fydm+"-"+41));
			zj_sj += sj;
			
			long la = (fbs.get(fydm+"-"+26)==null?0:fbs.get(fydm+"-"+26))+
					(fbs.get(fydm+"-"+27)==null?0:fbs.get(fydm+"-"+27))+
					(fbs.get(fydm+"-"+28)==null?0:fbs.get(fydm+"-"+28))+
					(fbs.get(fydm+"-"+29)==null?0:fbs.get(fydm+"-"+29))+
					(fbs.get(fydm+"-"+30)==null?0:fbs.get(fydm+"-"+30))+
					(fbs.get(fydm+"-"+31)==null?0:fbs.get(fydm+"-"+31))+
					(fbs.get(fydm+"-"+32)==null?0:fbs.get(fydm+"-"+32))+
					(fbs.get(fydm+"-"+33)==null?0:fbs.get(fydm+"-"+33));
			zj_la =+ la;
			
			long zx = fbs.get(fydm+"-"+24)==null?0:fbs.get(fydm+"-"+24);
			zj_zx += zx;
			
			long zs = xs+ms+xz+sj+la+zx;
			zj_zs += zs;
			
			vo.setXs(xs);
			vo.setMs(ms);
			vo.setXz(xz);
			vo.setSj(sj);
			vo.setLa(la);
			vo.setZx(zx);
			vo.setZs(zs);
			
			vos.add(vo);
		}
		
		SjyFbVO zj=new SjyFbVO();
		zj.setDw("合计");
		zj.setXs(zj_xs);
		zj.setMs(zj_ms);
		zj.setXz(zj_xz);
		zj.setSj(zj_sj);
		zj.setLa(zj_la);
		zj.setZx(zj_zx);
		zj.setZs(zj_zs);
		vos.add(zj);
		
		return vos;
	}

	@Override
	@Cacheable(cacheName="gdtjCache")
	public List<FgzlFbVO> getZbfgzlfbByFy(int... fydms) {
		List<FgzlFbVO>vos=new ArrayList<FgzlFbVO>();
		Map<String, Long> fbs = ryjbxxDAO.getZbfgzlFb(fydms);
		
		long zj_zs=0;
		long zj_xs=0;
		long zj_ms=0;
		long zj_xz=0;
		long zj_sj=0;
		long zj_la=0;
		long zj_zx=0;
		
		for(int fydm : fydms){
			FgzlFbVO vo = new FgzlFbVO();
			
			Dm fy=dmDAO.findDmByNBxhNdm("1", fydm);
			vo.setDw(fy==null?"":fy.getCMc());
			
			long xs = (fbs.get(fydm+"-"+2)==null?0:fbs.get(fydm+"-"+2))+
					(fbs.get(fydm+"-"+3)==null?0:fbs.get(fydm+"-"+3))+
					(fbs.get(fydm+"-"+4)==null?0:fbs.get(fydm+"-"+4))+
					(fbs.get(fydm+"-"+5)==null?0:fbs.get(fydm+"-"+5))+
					(fbs.get(fydm+"-"+6)==null?0:fbs.get(fydm+"-"+6))+
					(fbs.get(fydm+"-"+7)==null?0:fbs.get(fydm+"-"+7))+
					(fbs.get(fydm+"-"+8)==null?0:fbs.get(fydm+"-"+8))+
					(fbs.get(fydm+"-"+9)==null?0:fbs.get(fydm+"-"+9));
			zj_xs += xs;
			
			long ms = (fbs.get(fydm+"-"+10)==null?0:fbs.get(fydm+"-"+10))+
					(fbs.get(fydm+"-"+11)==null?0:fbs.get(fydm+"-"+11))+
					(fbs.get(fydm+"-"+12)==null?0:fbs.get(fydm+"-"+12))+
					(fbs.get(fydm+"-"+13)==null?0:fbs.get(fydm+"-"+13))+
					(fbs.get(fydm+"-"+14)==null?0:fbs.get(fydm+"-"+14))+
					(fbs.get(fydm+"-"+15)==null?0:fbs.get(fydm+"-"+15))+
					(fbs.get(fydm+"-"+16)==null?0:fbs.get(fydm+"-"+16))+
					(fbs.get(fydm+"-"+17)==null?0:fbs.get(fydm+"-"+17));
			zj_ms += ms;
			
			long xz = fbs.get(fydm+"-"+23)==null?0:fbs.get(fydm+"-"+23);
			zj_xz += xz;
			
			long sj = (fbs.get(fydm+"-"+34)==null?0:fbs.get(fydm+"-"+34))+
					(fbs.get(fydm+"-"+35)==null?0:fbs.get(fydm+"-"+35))+
					(fbs.get(fydm+"-"+36)==null?0:fbs.get(fydm+"-"+36))+
					(fbs.get(fydm+"-"+37)==null?0:fbs.get(fydm+"-"+37))+
					(fbs.get(fydm+"-"+38)==null?0:fbs.get(fydm+"-"+38))+
					(fbs.get(fydm+"-"+39)==null?0:fbs.get(fydm+"-"+39))+
					(fbs.get(fydm+"-"+40)==null?0:fbs.get(fydm+"-"+40))+
					(fbs.get(fydm+"-"+41)==null?0:fbs.get(fydm+"-"+41));
			zj_sj += sj;
			
			long la = (fbs.get(fydm+"-"+26)==null?0:fbs.get(fydm+"-"+26))+
					(fbs.get(fydm+"-"+27)==null?0:fbs.get(fydm+"-"+27))+
					(fbs.get(fydm+"-"+28)==null?0:fbs.get(fydm+"-"+28))+
					(fbs.get(fydm+"-"+29)==null?0:fbs.get(fydm+"-"+29))+
					(fbs.get(fydm+"-"+30)==null?0:fbs.get(fydm+"-"+30))+
					(fbs.get(fydm+"-"+31)==null?0:fbs.get(fydm+"-"+31))+
					(fbs.get(fydm+"-"+32)==null?0:fbs.get(fydm+"-"+32))+
					(fbs.get(fydm+"-"+33)==null?0:fbs.get(fydm+"-"+33));
			zj_la =+ la;
			
			long zx = fbs.get(fydm+"-"+24)==null?0:fbs.get(fydm+"-"+24);
			zj_zx += zx;
			
			long zs = xs+ms+xz+sj+la+zx;
			zj_zs += zs;
			
			vo.setXs(xs);
			vo.setMs(ms);
			vo.setXz(xz);
			vo.setSj(sj);
			vo.setLa(la);
			vo.setZx(zx);
			vo.setZs(zs);
			
			vos.add(vo);
		}
		
		FgzlFbVO zj=new FgzlFbVO();
		zj.setDw("合计");
		zj.setXs(zj_xs);
		zj.setMs(zj_ms);
		zj.setXz(zj_xz);
		zj.setSj(zj_sj);
		zj.setLa(zj_la);
		zj.setZx(zj_zx);
		zj.setZs(zj_zs);
		vos.add(zj);
		
		return vos;
	}

	@Override
	@Cacheable(cacheName="gdtjCache")
	public List<FgzlFbVO> getBwfgzlfbByFy(int... fydms) {
		List<FgzlFbVO>vos=new ArrayList<FgzlFbVO>();
		Map<String, Long> fbs = ryjbxxDAO.getBwfgzlFb(fydms);
		
		long zj_zs=0;
		long zj_xs=0;
		long zj_ms=0;
		long zj_xz=0;
		long zj_sj=0;
		long zj_la=0;
		long zj_zx=0;
		
		for(int fydm : fydms){
			FgzlFbVO vo = new FgzlFbVO();
			
			Dm fy=dmDAO.findDmByNBxhNdm("1", fydm);
			vo.setDw(fy==null?"":fy.getCMc());
			
			long xs = (fbs.get(fydm+"-"+2)==null?0:fbs.get(fydm+"-"+2))+
					(fbs.get(fydm+"-"+3)==null?0:fbs.get(fydm+"-"+3))+
					(fbs.get(fydm+"-"+4)==null?0:fbs.get(fydm+"-"+4))+
					(fbs.get(fydm+"-"+5)==null?0:fbs.get(fydm+"-"+5))+
					(fbs.get(fydm+"-"+6)==null?0:fbs.get(fydm+"-"+6))+
					(fbs.get(fydm+"-"+7)==null?0:fbs.get(fydm+"-"+7))+
					(fbs.get(fydm+"-"+8)==null?0:fbs.get(fydm+"-"+8))+
					(fbs.get(fydm+"-"+9)==null?0:fbs.get(fydm+"-"+9));
			zj_xs += xs;
			
			long ms = (fbs.get(fydm+"-"+10)==null?0:fbs.get(fydm+"-"+10))+
					(fbs.get(fydm+"-"+11)==null?0:fbs.get(fydm+"-"+11))+
					(fbs.get(fydm+"-"+12)==null?0:fbs.get(fydm+"-"+12))+
					(fbs.get(fydm+"-"+13)==null?0:fbs.get(fydm+"-"+13))+
					(fbs.get(fydm+"-"+14)==null?0:fbs.get(fydm+"-"+14))+
					(fbs.get(fydm+"-"+15)==null?0:fbs.get(fydm+"-"+15))+
					(fbs.get(fydm+"-"+16)==null?0:fbs.get(fydm+"-"+16))+
					(fbs.get(fydm+"-"+17)==null?0:fbs.get(fydm+"-"+17));
			zj_ms += ms;
			
			long xz = fbs.get(fydm+"-"+23)==null?0:fbs.get(fydm+"-"+23);
			zj_xz += xz;
			
			long sj = (fbs.get(fydm+"-"+34)==null?0:fbs.get(fydm+"-"+34))+
					(fbs.get(fydm+"-"+35)==null?0:fbs.get(fydm+"-"+35))+
					(fbs.get(fydm+"-"+36)==null?0:fbs.get(fydm+"-"+36))+
					(fbs.get(fydm+"-"+37)==null?0:fbs.get(fydm+"-"+37))+
					(fbs.get(fydm+"-"+38)==null?0:fbs.get(fydm+"-"+38))+
					(fbs.get(fydm+"-"+39)==null?0:fbs.get(fydm+"-"+39))+
					(fbs.get(fydm+"-"+40)==null?0:fbs.get(fydm+"-"+40))+
					(fbs.get(fydm+"-"+41)==null?0:fbs.get(fydm+"-"+41));
			zj_sj += sj;
			
			long la = (fbs.get(fydm+"-"+26)==null?0:fbs.get(fydm+"-"+26))+
					(fbs.get(fydm+"-"+27)==null?0:fbs.get(fydm+"-"+27))+
					(fbs.get(fydm+"-"+28)==null?0:fbs.get(fydm+"-"+28))+
					(fbs.get(fydm+"-"+29)==null?0:fbs.get(fydm+"-"+29))+
					(fbs.get(fydm+"-"+30)==null?0:fbs.get(fydm+"-"+30))+
					(fbs.get(fydm+"-"+31)==null?0:fbs.get(fydm+"-"+31))+
					(fbs.get(fydm+"-"+32)==null?0:fbs.get(fydm+"-"+32))+
					(fbs.get(fydm+"-"+33)==null?0:fbs.get(fydm+"-"+33));
			zj_la =+ la;
			
			long zx = fbs.get(fydm+"-"+24)==null?0:fbs.get(fydm+"-"+24);
			zj_zx += zx;
			
			long zs = xs+ms+xz+sj+la+zx;
			zj_zs += zs;
			
			vo.setXs(xs);
			vo.setMs(ms);
			vo.setXz(xz);
			vo.setSj(sj);
			vo.setLa(la);
			vo.setZx(zx);
			vo.setZs(zs);
			
			vos.add(vo);
		}
		
		FgzlFbVO zj=new FgzlFbVO();
		zj.setDw("合计");
		zj.setXs(zj_xs);
		zj.setMs(zj_ms);
		zj.setXz(zj_xz);
		zj.setSj(zj_sj);
		zj.setLa(zj_la);
		zj.setZx(zj_zx);
		zj.setZs(zj_zs);
		vos.add(zj);
		
		return vos;
	}

	@Override
	@Cacheable(cacheName="gdtjCache")
	public List<ZjFbVO> getFgzjfbByFy(int... fydms) {
		List<ZjFbVO>vos=new ArrayList<ZjFbVO>();
		Map<String, Long> fbs = ryjbxxDAO.getFgZjFb(fydms);
		
		long zj_zs=0;
		long zj_zt=0;
		long zj_ft=0;
		long zj_zc=0;
		long zj_fc=0;
		long zj_zk=0;
		long zj_fk=0;
		long zj_ky=0;
		long zj_kyyx=0;
		
		for(int fydm : fydms){
			ZjFbVO vo = new ZjFbVO();
			
			Dm fy=dmDAO.findDmByNBxhNdm("1", fydm);
			vo.setDw(fy==null?"":fy.getCMc());
			
			long zt = fbs.get(fydm+"-"+4)==null?0:fbs.get(fydm+"-"+4);
			zj_zt += zt;
			
			long ft = fbs.get(fydm+"-"+5)==null?0:fbs.get(fydm+"-"+5);
			zj_ft += ft;
			
			long zc = fbs.get(fydm+"-"+6)==null?0:fbs.get(fydm+"-"+6);
			zj_zc += zc;
			
			long fc = fbs.get(fydm+"-"+7)==null?0:fbs.get(fydm+"-"+7);
			zj_fc += fc;
			
			long zk = fbs.get(fydm+"-"+8)==null?0:fbs.get(fydm+"-"+8);
			zj_zk += zk;
			
			long fk = fbs.get(fydm+"-"+9)==null?0:fbs.get(fydm+"-"+9);
			zj_fk += fk;
			
			long ky = fbs.get(fydm+"-"+10)==null?0:fbs.get(fydm+"-"+10);
			zj_ky += ky;
			
			long kyyx = (fbs.get(fydm+"-"+11)==null?0:fbs.get(fydm+"-"+11))+
					(fbs.get(fydm+"-"+12)==null?0:fbs.get(fydm+"-"+12))+
					(fbs.get(fydm+"-"+13)==null?0:fbs.get(fydm+"-"+13))+
					(fbs.get(fydm+"-"+98)==null?0:fbs.get(fydm+"-"+98))+
					(fbs.get(fydm+"-"+99)==null?0:fbs.get(fydm+"-"+99));
			zj_kyyx += kyyx;
			
			long zs = zt+ft+zc+fc+zk+fk+ky+kyyx;
			zj_zs += zs;
			
			vo.setZt(zt);
			vo.setFt(ft);
			vo.setZc(zc);
			vo.setFc(fc);
			vo.setZk(zk);
			vo.setFk(fk);
			vo.setKy(ky);
			vo.setKyyx(kyyx);
			vo.setZs(zs);
			
			vos.add(vo);
		}
		
		ZjFbVO zj = new ZjFbVO();
		zj.setDw("合计");
		zj.setZt(zj_zt);
		zj.setFt(zj_ft);
		zj.setZc(zj_zc);
		zj.setFc(zj_fc);
		zj.setZk(zj_zk);
		zj.setFk(zj_fk);
		zj.setKy(zj_ky);
		zj.setKyyx(zj_kyyx);
		zj.setZs(zj_zs);
		vos.add(zj);
		
		return vos;
	}

	@Override
	@Cacheable(cacheName="gdtjCache")
	public List<ZjFbVO> getFldfgzjfbByFy(int... fydms) {
		List<ZjFbVO>vos=new ArrayList<ZjFbVO>();
		Map<String, Long> fbs = ryjbxxDAO.getFldFgZjFb(fydms);
		
		long zj_zs=0;
		long zj_zc=0;
		long zj_fc=0;
		long zj_zk=0;
		long zj_fk=0;
		long zj_ky=0;
		long zj_kyyx=0;
		
		for(int fydm : fydms){
			ZjFbVO vo = new ZjFbVO();
			
			Dm fy=dmDAO.findDmByNBxhNdm("1", fydm);
			vo.setDw(fy==null?"":fy.getCMc());
			
			long zc = fbs.get(fydm+"-"+6)==null?0:fbs.get(fydm+"-"+6);
			zj_zc += zc;
			
			long fc = fbs.get(fydm+"-"+7)==null?0:fbs.get(fydm+"-"+7);
			zj_fc += fc;
			
			long zk = fbs.get(fydm+"-"+8)==null?0:fbs.get(fydm+"-"+8);
			zj_zk += zk;
			
			long fk = fbs.get(fydm+"-"+9)==null?0:fbs.get(fydm+"-"+9);
			zj_fk += fk;
			
			long ky = fbs.get(fydm+"-"+10)==null?0:fbs.get(fydm+"-"+10);
			zj_ky += ky;
			
			long kyyx = (fbs.get(fydm+"-"+11)==null?0:fbs.get(fydm+"-"+11))+
					(fbs.get(fydm+"-"+12)==null?0:fbs.get(fydm+"-"+12))+
					(fbs.get(fydm+"-"+13)==null?0:fbs.get(fydm+"-"+13))+
					(fbs.get(fydm+"-"+98)==null?0:fbs.get(fydm+"-"+98))+
					(fbs.get(fydm+"-"+99)==null?0:fbs.get(fydm+"-"+99));
			zj_kyyx += kyyx;
			
			long zs = zc+fc+zk+fk+ky+kyyx;
			zj_zs += zs;
			
			vo.setZc(zc);
			vo.setFc(fc);
			vo.setZk(zk);
			vo.setFk(fk);
			vo.setKy(ky);
			vo.setKyyx(kyyx);
			vo.setZs(zs);
			
			vos.add(vo);
		}
		
		ZjFbVO zj = new ZjFbVO();
		zj.setDw("合计");
		zj.setZc(zj_zc);
		zj.setFc(zj_fc);
		zj.setZk(zj_zk);
		zj.setFk(zj_fk);
		zj.setKy(zj_ky);
		zj.setKyyx(zj_kyyx);
		zj.setZs(zj_zs);
		vos.add(zj);
		
		return vos;
	}

	@Override
	@Cacheable(cacheName="gdtjCache")
	public List<TzZjVO> getTzzjfbByFy(int... fydms) {
		List<TzZjVO>vos=new ArrayList<TzZjVO>();
		Map<String, Long> fbs = ryjbxxDAO.getTzZjFb(fydms);
		
		long zj_ftzs=0;
		long zj_tzzs=0;
		long zj_fc=0;
		long zj_zk=0;
		long zj_fk=0;
		long zj_ky=0;
		
		for(int fydm : fydms){
			TzZjVO vo = new TzZjVO();
			
			Dm fy=dmDAO.findDmByNBxhNdm("1", fydm);
			vo.setDw(fy==null?"":fy.getCMc());
			
			long ftzs = jgxxDAO.countFtByFy(fydm);
			zj_ftzs += ftzs;
			
			long fc = fbs.get(fydm+"-"+7)==null?0:fbs.get(fydm+"-"+7);
			zj_fc += fc;
			
			long zk = fbs.get(fydm+"-"+8)==null?0:fbs.get(fydm+"-"+8);
			zj_zk += zk;
			
			long fk = fbs.get(fydm+"-"+9)==null?0:fbs.get(fydm+"-"+9);
			zj_fk += fk;
			
			long ky = fbs.get(fydm+"-"+10)==null?0:fbs.get(fydm+"-"+10);
			zj_ky += ky;
			
			long tzzs = ryjbxxDAO.countTzByFy(fydm);
			zj_tzzs += tzzs;
			
			vo.setFc(fc);
			vo.setZk(zk);
			vo.setFk(fk);
			vo.setKy(ky);
			vo.setTzzs(tzzs);
			vo.setFtzs(ftzs);
			
			vos.add(vo);
		}

		TzZjVO zj = new TzZjVO();
		zj.setDw("合计");
		zj.setFc(zj_fc);
		zj.setZk(zj_zk);
		zj.setFk(zj_fk);
		zj.setKy(zj_ky);
		zj.setTzzs(zj_tzzs);
		zj.setFtzs(zj_ftzs);
		vos.add(zj);
		
		return vos;
	}

	@Override
	@Cacheable(cacheName="gdtjCache")
	public List<NlAndXlFbVO> getFgNlAndXlFbByFy(int... fydms) {
		List<NlAndXlFbVO>vos=new ArrayList<NlAndXlFbVO>();
		Map<String, Long> fbs = ryjbxxDAO.getFgXlFb(fydms);
		
		long zj_bs=0;
		long zj_ss=0;
		long zj_bk=0;
		long zj_dz=0;
		long zj_gzyx=0;
		long zj_nl_35=0;
		long zj_nl_36_45=0;
		long zj_nl_46_55=0;
		long zj_nl_56=0;
		long zj_zs=0;
		
		for(int fydm : fydms){
			NlAndXlFbVO vo = new NlAndXlFbVO();
			
			Dm fy=dmDAO.findDmByNBxhNdm("1", fydm);
			vo.setDw(fy==null?"":fy.getCMc());
			
			long bs = (fbs.get(fydm+"-"+1)==null?0:fbs.get(fydm+"-"+1))+
					(fbs.get(fydm+"-"+4)==null?0:fbs.get(fydm+"-"+4));
			zj_bs += bs;
			
			long ss = (fbs.get(fydm+"-"+2)==null?0:fbs.get(fydm+"-"+2))+
					(fbs.get(fydm+"-"+3)==null?0:fbs.get(fydm+"-"+3))+
					(fbs.get(fydm+"-"+5)==null?0:fbs.get(fydm+"-"+5))+
					(fbs.get(fydm+"-"+6)==null?0:fbs.get(fydm+"-"+6))+
					(fbs.get(fydm+"-"+9)==null?0:fbs.get(fydm+"-"+9));
			zj_ss += ss;
			
			long bk = (fbs.get(fydm+"-"+11)==null?0:fbs.get(fydm+"-"+11))+
					(fbs.get(fydm+"-"+12)==null?0:fbs.get(fydm+"-"+12))+
					(fbs.get(fydm+"-"+13)==null?0:fbs.get(fydm+"-"+13))+
					(fbs.get(fydm+"-"+19)==null?0:fbs.get(fydm+"-"+19))+
					(fbs.get(fydm+"-"+20)==null?0:fbs.get(fydm+"-"+20));
			zj_bk += bk;
			
			long dz = (fbs.get(fydm+"-"+21)==null?0:fbs.get(fydm+"-"+21))+
					(fbs.get(fydm+"-"+22)==null?0:fbs.get(fydm+"-"+22))+
					(fbs.get(fydm+"-"+29)==null?0:fbs.get(fydm+"-"+29));
			zj_dz += dz;
			
			long gzyx = ryjbxxDAO.countFgByCondition(fydm, "(NXl>=31 or NXl is null)");
			zj_gzyx += gzyx;
			
			long nl_35 = ryjbxxDAO.countFgByCondition(fydm, "datediff(year,DCsrq,getdate())<=35");
			zj_nl_35 += nl_35;
			
			long nl_36_45 = ryjbxxDAO.countFgByCondition(fydm, "datediff(year,DCsrq,getdate())>35 and datediff(year,DCsrq,getdate())<=45");
			zj_nl_36_45 += nl_36_45;
			
			long nl_46_55 = ryjbxxDAO.countFgByCondition(fydm, "datediff(year,DCsrq,getdate())>45 and datediff(year,DCsrq,getdate())<=55");
			zj_nl_46_55 += nl_46_55;
			
			long nl_56 = ryjbxxDAO.countFgByCondition(fydm, "datediff(year,DCsrq,getdate())>55");
			zj_nl_56 += nl_56;
			
			long zs = nl_35+nl_36_45+nl_46_55+nl_56;
			zj_zs += zs;
			
			vo.setNl_35(nl_35);
			vo.setNl_36_45(nl_36_45);
			vo.setNl_46_55(nl_46_55);
			vo.setNl_56(nl_56);
			vo.setXl_bs(bs);
			vo.setXl_ss(ss);
			vo.setXl_bk(bk);
			vo.setXl_dz(dz);
			vo.setXl_gzyx(gzyx);
			vo.setZs(zs);
			
			vos.add(vo);
		}
		
		NlAndXlFbVO zj = new NlAndXlFbVO();
		zj.setDw("合计");
		zj.setNl_35(zj_nl_35);
		zj.setNl_36_45(zj_nl_36_45);
		zj.setNl_46_55(zj_nl_46_55);
		zj.setNl_56(zj_nl_56);
		zj.setXl_bs(zj_bs);
		zj.setXl_ss(zj_ss);
		zj.setXl_bk(zj_bk);
		zj.setXl_dz(zj_dz);
		zj.setXl_gzyx(zj_gzyx);
		zj.setZs(zj_zs);
		vos.add(zj);
		
		return vos;
	}

	@Override
	@Cacheable(cacheName="gdtjCache")
	public List<ZjFbVO> getLdbzZjFbByFy(int... fydms) {
		List<ZjFbVO>vos=new ArrayList<ZjFbVO>();
		Map<String, Long> fbs = ryjbxxDAO.getLdbzZjFb(fydms);
		
		long zj_zs=0;
		long zj_zt=0;
		long zj_ft=0;
		long zj_zc=0;
		long zj_fc=0;
		long zj_zk=0;
		long zj_fk=0;
		
		for(int fydm : fydms){
			ZjFbVO vo = new ZjFbVO();
			
			Dm fy=dmDAO.findDmByNBxhNdm("1", fydm);
			vo.setDw(fy==null?"":fy.getCMc());
			
			long zt = fbs.get(fydm+"-"+4)==null?0:fbs.get(fydm+"-"+4);
			zj_zt += zt;
			
			long ft = fbs.get(fydm+"-"+5)==null?0:fbs.get(fydm+"-"+5);
			zj_ft += ft;
			
			long zc = fbs.get(fydm+"-"+6)==null?0:fbs.get(fydm+"-"+6);
			zj_zc += zc;
			
			long fc = fbs.get(fydm+"-"+7)==null?0:fbs.get(fydm+"-"+7);
			zj_fc += fc;
			
			long zk = fbs.get(fydm+"-"+8)==null?0:fbs.get(fydm+"-"+8);
			zj_zk += zk;
			
			long fk = fbs.get(fydm+"-"+9)==null?0:fbs.get(fydm+"-"+9);
			zj_fk += fk;
			
			long zs = zt+ft+zc+fc+zk+fk;
			zj_zs += zs;
			
			vo.setZt(zt);
			vo.setFt(ft);
			vo.setZc(zc);
			vo.setFc(fc);
			vo.setZk(zk);
			vo.setFk(fk);
			vo.setZs(zs);
			
			vos.add(vo);
		}
		
		ZjFbVO zj = new ZjFbVO();
		zj.setDw("合计");
		zj.setZt(zj_zt);
		zj.setFt(zj_ft);
		zj.setZc(zj_zc);
		zj.setFc(zj_fc);
		zj.setZk(zj_zk);
		zj.setFk(zj_fk);
		zj.setZs(zj_zs);
		vos.add(zj);
		
		return vos;
	}

	@Override
	@Cacheable(cacheName="gdtjCache")
	public List<NlAndXlFbVO> getLdbzNlAndXlFbByFy(int... fydms) {
		List<NlAndXlFbVO>vos=new ArrayList<NlAndXlFbVO>();
		Map<String, Long> fbs = ryjbxxDAO.getLdbzXlFb(fydms);
		
		long zj_bs=0;
		long zj_ss=0;
		long zj_bk=0;
		long zj_dz=0;
		long zj_gzyx=0;
		long zj_nl_35=0;
		long zj_nl_36_45=0;
		long zj_nl_46_55=0;
		long zj_nl_56=0;
		long zj_zs=0;
		
		for(int fydm : fydms){
			NlAndXlFbVO vo = new NlAndXlFbVO();
			
			Dm fy=dmDAO.findDmByNBxhNdm("1", fydm);
			vo.setDw(fy==null?"":fy.getCMc());
			
			long bs = (fbs.get(fydm+"-"+1)==null?0:fbs.get(fydm+"-"+1))+
					(fbs.get(fydm+"-"+4)==null?0:fbs.get(fydm+"-"+4));
			zj_bs += bs;
			
			long ss = (fbs.get(fydm+"-"+2)==null?0:fbs.get(fydm+"-"+2))+
					(fbs.get(fydm+"-"+3)==null?0:fbs.get(fydm+"-"+3))+
					(fbs.get(fydm+"-"+5)==null?0:fbs.get(fydm+"-"+5))+
					(fbs.get(fydm+"-"+6)==null?0:fbs.get(fydm+"-"+6))+
					(fbs.get(fydm+"-"+9)==null?0:fbs.get(fydm+"-"+9));
			zj_ss += ss;
			
			long bk = (fbs.get(fydm+"-"+11)==null?0:fbs.get(fydm+"-"+11))+
					(fbs.get(fydm+"-"+12)==null?0:fbs.get(fydm+"-"+12))+
					(fbs.get(fydm+"-"+13)==null?0:fbs.get(fydm+"-"+13))+
					(fbs.get(fydm+"-"+19)==null?0:fbs.get(fydm+"-"+19))+
					(fbs.get(fydm+"-"+20)==null?0:fbs.get(fydm+"-"+20));
			zj_bk += bk;
			
			long dz = (fbs.get(fydm+"-"+21)==null?0:fbs.get(fydm+"-"+21))+
					(fbs.get(fydm+"-"+22)==null?0:fbs.get(fydm+"-"+22))+
					(fbs.get(fydm+"-"+29)==null?0:fbs.get(fydm+"-"+29));
			zj_dz += dz;
			
			long gzyx = ryjbxxDAO.countLdbzByCondition(fydm, "(NXl>=31 or NXl is null)");
			zj_gzyx += gzyx;
			
			long nl_35 = ryjbxxDAO.countLdbzByCondition(fydm, "datediff(year,DCsrq,getdate())<=35");
			zj_nl_35 += nl_35;
			
			long nl_36_45 = ryjbxxDAO.countLdbzByCondition(fydm, "datediff(year,DCsrq,getdate())>35 and datediff(year,DCsrq,getdate())<=45");
			zj_nl_36_45 += nl_36_45;
			
			long nl_46_55 = ryjbxxDAO.countLdbzByCondition(fydm, "datediff(year,DCsrq,getdate())>45 and datediff(year,DCsrq,getdate())<=55");
			zj_nl_46_55 += nl_46_55;
			
			long nl_56 = ryjbxxDAO.countLdbzByCondition(fydm, "datediff(year,DCsrq,getdate())>55");
			zj_nl_56 += nl_56;
			
			long zs = nl_35+nl_36_45+nl_46_55+nl_56;
			zj_zs += zs;
			
			vo.setNl_35(nl_35);
			vo.setNl_36_45(nl_36_45);
			vo.setNl_46_55(nl_46_55);
			vo.setNl_56(nl_56);
			vo.setXl_bs(bs);
			vo.setXl_ss(ss);
			vo.setXl_bk(bk);
			vo.setXl_dz(dz);
			vo.setXl_gzyx(gzyx);
			vo.setZs(zs);
			
			vos.add(vo);
		}
		
		NlAndXlFbVO zj = new NlAndXlFbVO();
		zj.setDw("合计");
		zj.setNl_35(zj_nl_35);
		zj.setNl_36_45(zj_nl_36_45);
		zj.setNl_46_55(zj_nl_46_55);
		zj.setNl_56(zj_nl_56);
		zj.setXl_bs(zj_bs);
		zj.setXl_ss(zj_ss);
		zj.setXl_bk(zj_bk);
		zj.setXl_dz(zj_dz);
		zj.setXl_gzyx(zj_gzyx);
		zj.setZs(zj_zs);
		vos.add(zj);
		
		return vos;
	}
}
