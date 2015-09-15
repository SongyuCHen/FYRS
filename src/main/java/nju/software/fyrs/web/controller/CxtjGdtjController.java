package nju.software.fyrs.web.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

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
import nju.software.fyrs.service.GdtjService;
import nju.software.fyrs.service.impl.RoleMenuService;
import nju.software.fyrs.service.model.UserContext;
import nju.software.fyrs.web.json.ResponseBuilder;

@Controller
@RequestMapping("/main/cxtj")
public class CxtjGdtjController {
	private RoleMenuService roleMenuService;
	private GdtjService gdtjService;
	@RequestMapping(value="/gdtj.do",method = RequestMethod.GET)
	public String showGdtj(Model model,HttpServletResponse response,HttpServletRequest request)
	{
		MenuShowUtils.headerMenu(request,model, roleMenuService,"��ѯͳ��");
		MenuShowUtils.leftMenu(request,model, roleMenuService, "cxtj");
		model.addAttribute("currentSelectLeftMenu","�̶�ͳ��");
		return "gdtj/show";
	}
	
	@RequestMapping(value="/gdtjlist.aj",method = RequestMethod.POST)
	public void getGdtjList(Model model,HttpServletResponse response,HttpServletRequest request){
		List<GdtjVO>gdtjvos=gdtjService.getGdtjList();
		try {
			ResponseBuilder rb = new ResponseBuilder();
			rb.writeJsonResponse(response, gdtjvos);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	@RequestMapping(value="/gdtjtjlist.aj",method = RequestMethod.POST)
	public void getGdtjTjList(Model model,HttpServletResponse response,HttpServletRequest request){
		String bbh = request.getParameter("bbh");
		List<ArrayList<GdtjTjVO>>gdtjtjvos=gdtjService.getGdtjTjList(Integer.parseInt(bbh));
		try {
			ResponseBuilder rb = new ResponseBuilder();
			rb.writeJsonResponse(response, gdtjtjvos);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	@RequestMapping(value="/bbfm.do",method = RequestMethod.GET)
	public String getBbfm(Model model,HttpServletResponse response,HttpServletRequest request){
		return "gdtj/bbfm";
	}
	
	@RequestMapping(value="/dealTj.do",method = RequestMethod.GET)
	public String dealTj(Model model,HttpServletResponse response,HttpServletRequest request){
		String bbh = request.getParameter("bbh");
		String hang = request.getParameter("hang");
		String lie = request.getParameter("lie");
		String[][]tjResult=null;
		GdtjVO bt=gdtjService.getGdtjByBbh(bbh);
		UserContext user = (UserContext) request.getSession().getAttribute("user");
		if(user!=null){
			int fydm = user.getFydm();
			tjResult=gdtjService.getTjResult(bbh, hang, lie, fydm);
		}
		model.addAttribute("bt", bt);
		model.addAttribute("result", tjResult);
		return "gdtj/tjresult";
	}
	
	//X_01_1
	@RequestMapping(value="/X_01_1.do",method = RequestMethod.GET)
	public String getX_01_1(Model model,HttpServletResponse response,HttpServletRequest request){
		UserContext user = (UserContext) request.getSession().getAttribute("user");
		List<GrJlVO>vos=null;
		if(user!=null){
			int fydm = user.getFydm();
			vos=gdtjService.getGrJl(fydm);
		}
		model.addAttribute("bt", "��Ժ�ɾ���ñ��ý������");
		model.addAttribute("result", vos);
		return "gdtj/X_01_1";
	}
	
	//X_01_2
	@RequestMapping(value="/X_01_2.do",method = RequestMethod.GET)
	public String getX_01_2(Model model,HttpServletResponse response,HttpServletRequest request){
		UserContext user = (UserContext) request.getSession().getAttribute("user");
		List<JtJlVO>vos=null;
		if(user!=null){
			int fydm = user.getFydm();
			vos=gdtjService.getJtJl(fydm);
		}
		model.addAttribute("bt", "�������м�����Ժ���ý������ݣ����壩");
		model.addAttribute("result", vos);
		return "gdtj/X_01_2";
	}
	
	//X_02
	@RequestMapping(value="/X_02.do",method = RequestMethod.GET)
	public String getX_02(Model model,HttpServletResponse response,HttpServletRequest request){
		UserContext user = (UserContext) request.getSession().getAttribute("user");
		FyPzVO fypz=null;
		List<BmPzVO> bmpz=null;
		if(user!=null){
			int fydm = user.getFydm();
			fypz=gdtjService.getFyPz(fydm);
			bmpz=gdtjService.getFyBmPz(fydm);
		}
		model.addAttribute("bt", "������Ժҵ������Ա���û������");
		model.addAttribute("fypz", fypz);
		model.addAttribute("bmpz", bmpz);
		return "gdtj/X_02";
	}
	
	//X_03_1
	@RequestMapping(value="/X_03_1.do",method = RequestMethod.GET)
	public String getX_03_1(Model model,HttpServletResponse response,HttpServletRequest request){
		UserContext user = (UserContext) request.getSession().getAttribute("user");
		List<HmcVO>vos=null;
		if(user!=null){
			int fydm = user.getFydm();
			vos=gdtjService.getHmcRyzb(fydm);
		}
		model.addAttribute("bt", "��Ժ�����ᣨ��Ա�ܱ�");
		model.addAttribute("result", vos);
		return "gdtj/X_03_1";
	}
	
	//X_03_2
	@RequestMapping(value="/X_03_2.do",method = RequestMethod.GET)
	public String getX_03_2(Model model,HttpServletResponse response,HttpServletRequest request){
		UserContext user = (UserContext) request.getSession().getAttribute("user");
		List<HmcVO>ylds=null;
		List<HmcVO>dyys=null;
		List<HmcVO>bgss=null;
		List<HmcVO>zzrscs=null;
		List<HmcVO>zhcs=null;
		List<HmcVO>jpcs=null;
		long zrs=0;
		if(user!=null){
			int fydm = user.getFydm();
			ylds=gdtjService.getHmcByBm(fydm, 1);//Ժ�쵼
			dyys=gdtjService.getHmcByXzzw(fydm, 36);//����Ա
			bgss=gdtjService.getHmcByBm(fydm, 51);//�칫��
			zzrscs=gdtjService.getHmcByBm(fydm, 0);//��֯���´�
			zhcs=gdtjService.getHmcByBmName(fydm, "�ۺϴ�");//�ۺϴ�
			jpcs=gdtjService.getHmcByBm(fydm, 58);//���ദ
			zrs=gdtjService.countByFy(fydm);
		}
		model.addAttribute("title", "��Ժ�����ᣨ��Ժ������Ա������");
		model.addAttribute("bt", "��Ժ�����ᣨ��Ժ������Ա������"+zrs+"�ˣ���");
		model.addAttribute("ylds", ylds);
		model.addAttribute("dyys", dyys);
		model.addAttribute("bgss", bgss);
		model.addAttribute("zzrscs", zzrscs);
		model.addAttribute("zhcs", zhcs);
		model.addAttribute("jpcs", jpcs);
		return "gdtj/X_03_2";
	}
	
	//X_03_3
	@RequestMapping(value="/X_03_3.do",method = RequestMethod.GET)
	public String getX_03_3(Model model,HttpServletResponse response,HttpServletRequest request){
		UserContext user = (UserContext) request.getSession().getAttribute("user");
		List<HmcVO>zcgbs=new ArrayList<HmcVO>();
		List<HmcVO>zzs=new ArrayList<HmcVO>();
		List<HmcVO>fzs=new ArrayList<HmcVO>();
		List<HmcVO>sjs=new ArrayList<HmcVO>();
		int count_zzsj=0;
		int count_zzfsj=0;
		if(user!=null){
			int fydm = user.getFydm();
			List<HmcVO>spzzs=gdtjService.getZcgbHmc(fydm, 4);
			List<HmcVO>xzzzs=gdtjService.getZcgbHmc(fydm, 6);
			List<HmcVO>spfzs=gdtjService.getZcgbHmc(fydm, 5);
			List<HmcVO>xzfzs=gdtjService.getZcgbHmc(fydm, 7);
			List<HmcVO>zzsjs=gdtjService.getZcgbHmc(fydm, 0);
			List<HmcVO>zzfsjs=gdtjService.getZcgbHmc(fydm, 0);
			count_zzsj=zzsjs.size();
			count_zzfsj=zzfsjs.size();
			zcgbs.addAll(spzzs);
			zcgbs.addAll(xzzzs);
			zcgbs.addAll(spfzs);
			zcgbs.addAll(xzfzs);
			zcgbs.addAll(zzsjs);
			zcgbs.addAll(zzfsjs);
			zzs.addAll(spzzs);
			zzs.addAll(xzzzs);
			fzs.addAll(spfzs);
			fzs.addAll(xzfzs);
			sjs.addAll(zzsjs);
			sjs.addAll(zzfsjs);
		}
		model.addAttribute("bt", "��Ժ�����ᣨ�в�ɲ���Ա����������רְ���"+count_zzsj+"�ˡ������"+count_zzfsj+"�ˣ���");
		model.addAttribute("title", "��Ժ�����ᣨ�в�ɲ���Ա������");
		model.addAttribute("zcgbs", zcgbs);
		model.addAttribute("zzs", zzs);
		model.addAttribute("fzs", fzs);
		model.addAttribute("sjs", sjs);
		return "gdtj/X_03_3";
	}
	
	//X_03_4
	@RequestMapping(value="/X_03_4.do",method = RequestMethod.GET)
	public String getX_03_4(Model model,HttpServletResponse response,HttpServletRequest request){
		UserContext user = (UserContext) request.getSession().getAttribute("user");
		List<HmcVO>cjyss=new ArrayList<HmcVO>();
		List<HmcVO>zkjs=new ArrayList<HmcVO>();
		List<HmcVO>fkjs=new ArrayList<HmcVO>();
		List<HmcVO>kys=new ArrayList<HmcVO>();
		List<HmcVO>grs=new ArrayList<HmcVO>();
		List<HmcVO>wdj_gzs=new ArrayList<HmcVO>();
		List<HmcVO>wdj_xlys=new ArrayList<HmcVO>();
		List<HmcVO>wdj_xzls=new ArrayList<HmcVO>();
		List<HmcVO>wdj_jzgbs=new ArrayList<HmcVO>();
		Calendar cal = Calendar.getInstance();
		int year = cal.get(Calendar.YEAR)-1;
		if(user!=null){
			int fydm = user.getFydm();
			cjyss = gdtjService.getHmcByZjCondition(fydm, "and NZj<8");
			zkjs = gdtjService.getHmcByZj(fydm, 8);
			fkjs = gdtjService.getHmcByZj(fydm, 9);
			kys = gdtjService.getHmcByZj(fydm, 10);
			grs = gdtjService.getHmcByZjCondition(fydm, "and NZj in(12,13)");
			wdj_gzs = gdtjService.getHmcByZjCondition(fydm, "and NZj = 98 and NZj = null");
			wdj_xlys = gdtjService.getHmcByZjCondition(fydm, "and NZj = 98 and DGwyrq>='"+year+"-1-1' and DGwyrq<='"+year+"-12-31'");
			wdj_xzls = gdtjService.getHmcByZjCondition(fydm, "and NZj = 98 and DGwyrq>='"+year+"-1-1' and DGwyrq<='"+year+"-12-31'");
			wdj_jzgbs = gdtjService.getHmcByZjCondition(fydm, "and NZj = 98 and NJly=2 and DJyrq>='"+year+"-1-1' and DJyrq<='"+year+"-12-31'");
		}
		model.addAttribute("bt", "��Ժ�����ᣨ��Աְ�������");
		model.addAttribute("year", year);
		model.addAttribute("cjyss", cjyss);
		model.addAttribute("zkjs", zkjs);
		model.addAttribute("fkjs", fkjs);
		model.addAttribute("kys", kys);
		model.addAttribute("grs", grs);
		model.addAttribute("wdj_gzs", wdj_gzs);
		model.addAttribute("wdj_xlys", wdj_xlys);
		model.addAttribute("wdj_xzls", wdj_xzls);
		model.addAttribute("wdj_jzgbs", wdj_jzgbs);
		return "gdtj/X_03_4";
	}
	
	//X_03_5
	@RequestMapping(value="/X_03_5.do",method = RequestMethod.GET)
	public String getX_03_5(Model model,HttpServletResponse response,HttpServletRequest request){
		UserContext user = (UserContext) request.getSession().getAttribute("user");
		List<HmcVO>vos = new ArrayList<HmcVO>();
		if(user!=null){
			//int fydm = user.getFydm();
			
		}
		model.addAttribute("bt", "��Ժ�����ᣨ����¼��Ա�����");
		model.addAttribute("result", vos);
		return "gdtj/X_03_5";
	}
	
	//X_03_6
	@RequestMapping(value="/X_03_6.do",method = RequestMethod.GET)
	public String getX_03_6(Model model,HttpServletResponse response,HttpServletRequest request){
		UserContext user = (UserContext) request.getSession().getAttribute("user");
		List<HmcVO>swhwys = new ArrayList<HmcVO>();
		List<HmcVO>spys = new ArrayList<HmcVO>();
		List<HmcVO>zsys = new ArrayList<HmcVO>();
		List<HmcVO>zxys = new ArrayList<HmcVO>();
		List<HmcVO>sjys = new ArrayList<HmcVO>();
		List<HmcVO>prsjys = new ArrayList<HmcVO>();
		List<HmcVO>fgzls = new ArrayList<HmcVO>();
		List<HmcVO>fjs = new ArrayList<HmcVO>();
		List<HmcVO>jxzlspys = new ArrayList<HmcVO>();
		if(user!=null){
			int fydm = user.getFydm();
			swhwys = gdtjService.getHmcByFlzw(fydm, 3);
			spys = gdtjService.getHmcByFlzw(fydm, 6);
			zsys = gdtjService.getHmcByFlzw(fydm, 7);
			zxys = gdtjService.getHmcByFlzw(fydm, 8);
			sjys = gdtjService.getHmcByFlzw(fydm, 10);
			prsjys = gdtjService.getHmcByFlzw(fydm, 0);
			fgzls = gdtjService.getHmcByFlzw(fydm, 9);
			fjs = gdtjService.getHmcByFlzw(fydm, 11);
			jxzlspys = gdtjService.getHmcByFlzw(fydm, 0);
			
		}
		model.addAttribute("bt", "��Ժ�����ᣨ����ְ�������");
		model.addAttribute("swhwys", swhwys);
		model.addAttribute("spys", spys);
		model.addAttribute("zsys", zsys);
		model.addAttribute("zxys", zxys);
		model.addAttribute("sjys", sjys);
		model.addAttribute("prsjys", prsjys);
		model.addAttribute("fgzls", fgzls);
		model.addAttribute("fjs", fjs);
		model.addAttribute("jxzlspys", jxzlspys);
		return "gdtj/X_03_6";
	}
	
	//X_03_7
	@RequestMapping(value="/X_03_7.do",method = RequestMethod.GET)
	public String getX_03_7(Model model,HttpServletResponse response,HttpServletRequest request){
		UserContext user = (UserContext) request.getSession().getAttribute("user");
		List<HmcVO>cjs = new ArrayList<HmcVO>();
		List<HmcVO>kjs = new ArrayList<HmcVO>();
		List<HmcVO>kys = new ArrayList<HmcVO>();
		if(user!=null){
			int fydm = user.getFydm();
			List<HmcVO>zcjs = gdtjService.getJzgbHmcByZj(fydm, 6);
			List<HmcVO>fcjs = gdtjService.getJzgbHmcByZj(fydm, 7);
			cjs.addAll(zcjs);
			cjs.addAll(fcjs);
			List<HmcVO>zkjs = gdtjService.getJzgbHmcByZj(fydm, 8);
			List<HmcVO>fkjs = gdtjService.getJzgbHmcByZj(fydm, 9);
			kjs.addAll(zkjs);
			kjs.addAll(fkjs);
			kys = gdtjService.getJzgbHmcByZj(fydm, 10);
		}
		model.addAttribute("bt", "��Ժ�����ᣨ��ת�ɲ������");
		model.addAttribute("cjs", cjs);
		model.addAttribute("kjs", kjs);
		model.addAttribute("kys", kys);
		return "gdtj/X_03_7";
	}
	
	//X_03_8
	@RequestMapping(value="/X_03_8.do",method = RequestMethod.GET)
	public String getX_03_8(Model model,HttpServletResponse response,HttpServletRequest request){
		UserContext user = (UserContext) request.getSession().getAttribute("user");
		List<HmcVO>vos = new ArrayList<HmcVO>();
		if(user!=null){
			int fydm = user.getFydm();
			vos = gdtjService.getHmcByXb(fydm, 2);
		}
		model.addAttribute("bt", "��Ժ�����ᣨŮ�ɾ������"+vos.size()+"�ˣ���");
		model.addAttribute("title", "��Ժ�����ᣨŮ�ɾ������");
		model.addAttribute("result", vos);
		return "gdtj/X_03_8";
	}
	
	//X_03_9
	@RequestMapping(value="/X_03_9.do",method = RequestMethod.GET)
	public String getX_03_9(Model model,HttpServletResponse response,HttpServletRequest request){
		UserContext user = (UserContext) request.getSession().getAttribute("user");
		List<HmcVO>vos = new ArrayList<HmcVO>();
		if(user!=null){
			int fydm = user.getFydm();
			vos = gdtjService.getFdyHmc(fydm);
		}
		model.addAttribute("bt", "��Ժ�����ᣨ�ǵ�Ա����Ա�����"+vos.size()+"�ˣ���");
		model.addAttribute("title", "��Ժ�����ᣨ�ǵ�Ա����Ա�����");
		model.addAttribute("result", vos);
		return "gdtj/X_03_9";
	}
	
	//X_04
	@RequestMapping(value="/X_04.do",method = RequestMethod.GET)
	public String getX_04(Model model,HttpServletResponse response,HttpServletRequest request){
		UserContext user = (UserContext) request.getSession().getAttribute("user");
		List<HmcVO>vos = new ArrayList<HmcVO>();
		if(user!=null){
			//int fydm = user.getFydm();
			
		}
		model.addAttribute("bt", "�����ŷ�����");
		model.addAttribute("result", vos);
		return "gdtj/X_04";
	}

	//X_05
	@RequestMapping(value="/X_05.do",method = RequestMethod.GET)
	public String getX_05(Model model,HttpServletResponse response,HttpServletRequest request){
		UserContext user = (UserContext) request.getSession().getAttribute("user");
		List<HmcVO>vos = new ArrayList<HmcVO>();
		if(user!=null){
			//int fydm = user.getFydm();
			
		}
		model.addAttribute("bt", "Ƹ����Ա������");
		model.addAttribute("result", vos);
		return "gdtj/X_05";
	}

	//X_06_1
	@RequestMapping(value="/X_06_1.do",method = RequestMethod.GET)
	public String getX_06_1(Model model,HttpServletResponse response,HttpServletRequest request){
		List<BzPzVO>hdbzs = gdtjService.getHdbzPzByFy(1176,1181,1178,1177,1180,1179,1127,1182,1187,1186,1183,1184,1127);//����
		List<BzPzVO>sybzs = gdtjService.getSybzPzByFy(1176,1181,1178,1177,1180,1179,1127,1182,1187,1186,1183,1184,1127);//����
		//hdbzs = gdtjService.getHdbzPzByFy(51);//���
		//sybzs = gdtjService.getSybzPzByFy(51);//���
		model.addAttribute("bt", "�����з�Ժ��Ա�˶����Ƽ�ʵ������ͳ�Ʊ�(��һ�����)");
		model.addAttribute("hdbzs", hdbzs);
		model.addAttribute("sybzs", sybzs);
		return "gdtj/X_06_1";
	}
	
	//X_06_2
	@RequestMapping(value="/X_06_2.do",method = RequestMethod.GET)
	public String getX_06_2(Model model,HttpServletResponse response,HttpServletRequest request){
		UserContext user = (UserContext) request.getSession().getAttribute("user");
		List<HmcVO>vos = new ArrayList<HmcVO>();
		if(user!=null){
			//int fydm = user.getFydm();
			
		}
		model.addAttribute("bt", "�����з�Ժ��Աͳ�Ʊ�(��һ�����)");
		model.addAttribute("result", vos);
		return "gdtj/X_06_2";
	}
	
	//X_06_3
	@RequestMapping(value="/X_06_3.do",method = RequestMethod.GET)
	public String getX_06_3(Model model,HttpServletResponse response,HttpServletRequest request){
		List<FgBmFbVO>fgbmfbs = gdtjService.getFgbmfbByFy(51);//���
		List<FgFlzwFbVO>fgflzwfbs = gdtjService.getFgflzwfbByFy(51);//���
		//List<FgBmFbVO>fgbmfbs = gdtjService.getFgbmfbByFy(1176,1181,1178,1177,1180,1179,1127,1182,1187,1186,1183,1184,1127);//����
		//List<FgFlzwFbVO>fgflzwfbs = gdtjService.getFgflzwfbByFy(1176,1181,1178,1177,1180,1179,1127,1182,1187,1186,1183,1184,1127);//����
		
		model.addAttribute("bt", "�����з�Ժ���ٷֲ�ͳ�Ʊ�(��һ�����)");
		model.addAttribute("fgbmfbs", fgbmfbs);
		model.addAttribute("fgflzwfbs", fgflzwfbs);
		return "gdtj/X_06_3";
	}
	
	//X_06_4
	@RequestMapping(value="/X_06_4.do",method = RequestMethod.GET)
	public String getX_06_4(Model model,HttpServletResponse response,HttpServletRequest request){
		List<SjyFbVO>zbsjys = gdtjService.getZbsjyfbByFy(51);//���
		List<SjyFbVO>bwsjys = gdtjService.getBwsjyfbByFy(51);//���
		//List<FgBmFbVO>zbsjys = gdtjService.getFgbmfbByFy(1176,1181,1178,1177,1180,1179,1127,1182,1187,1186,1183,1184,1127);//����
		//List<FgFlzwFbVO>bwsjys = gdtjService.getFgflzwfbByFy(1176,1181,1178,1177,1180,1179,1127,1182,1187,1186,1183,1184,1127);//����
		
		model.addAttribute("bt", "�����з�Ժ���Ա�ֲ�ͳ�Ʊ�(��һ�����)");
		model.addAttribute("zbsjys", zbsjys);
		model.addAttribute("bwsjys", bwsjys);
		return "gdtj/X_06_4";
	}
	
	//X_06_5
	@RequestMapping(value="/X_06_5.do",method = RequestMethod.GET)
	public String getX_06_5(Model model,HttpServletResponse response,HttpServletRequest request){
		List<FgzlFbVO>zbfgzls = gdtjService.getZbfgzlfbByFy(51);//���
		List<FgzlFbVO>bwfgzls = gdtjService.getBwfgzlfbByFy(51);//���
		//List<FgBmFbVO>zbfgzls = gdtjService.getFgbmfbByFy(1176,1181,1178,1177,1180,1179,1127,1182,1187,1186,1183,1184,1127);//����
		//List<FgFlzwFbVO>bwfgzls = gdtjService.getFgflzwfbByFy(1176,1181,1178,1177,1180,1179,1127,1182,1187,1186,1183,1184,1127);//����
		
		model.addAttribute("bt", "�����з�Ժ�ڸڷ�������ͳ�Ʊ�(��һ�����)");
		model.addAttribute("zbfgzls", zbfgzls);
		model.addAttribute("bwfgzls", bwfgzls);
		return "gdtj/X_06_5";
	}
	
	//X_06_6
	@RequestMapping(value="/X_06_6.do",method = RequestMethod.GET)
	public String getX_06_6(Model model,HttpServletResponse response,HttpServletRequest request){
		List<ZjFbVO>fgs = gdtjService.getFgzjfbByFy(51);//���
		List<ZjFbVO>fldfgs = gdtjService.getFldfgzjfbByFy(51);//���
		List<TzZjVO>tzs = gdtjService.getTzzjfbByFy(51);//���
		//List<FgBmFbVO>fgs = gdtjService.getFgbmfbByFy(1176,1181,1178,1177,1180,1179,1127,1182,1187,1186,1183,1184,1127);//����
		//List<FgFlzwFbVO>fldfgs = gdtjService.getFgflzwfbByFy(1176,1181,1178,1177,1180,1179,1127,1182,1187,1186,1183,1184,1127);//����
		//List<TzZjVO>tzs = gdtjService.getTzzjfbByFy(1181,1178,1177,1180,1179,1127,1182,1187,1186,1183,1184,1127);//����
		
		model.addAttribute("bt", "�����з���ְ���ֲ�ͳ�Ʊ�(����һ�����������)");
		model.addAttribute("fgs", fgs);
		model.addAttribute("fldfgs", fldfgs);
		model.addAttribute("tzs", tzs);
		return "gdtj/X_06_6";
	}
	
	//X_06_7
	@RequestMapping(value="/X_06_7.do",method = RequestMethod.GET)
	public String getX_06_7(Model model,HttpServletResponse response,HttpServletRequest request){
		List<NlAndXlFbVO>fgnlxls = gdtjService.getFgNlAndXlFbByFy(51);//���
		//List<FgBmFbVO>fgnlxls = gdtjService.getFgbmfbByFy(1176,1181,1178,1177,1180,1179,1127,1182,1187,1186,1183,1184,1127);//����
		
		model.addAttribute("bt", "�����з��ٽṹ�ֲ�ͳ�Ʊ�(��һ�����)");
		model.addAttribute("fgnlxls", fgnlxls);
		return "gdtj/X_06_7";
	}
	
	//X_06_8
	@RequestMapping(value="/X_06_8.do",method = RequestMethod.GET)
	public String getX_06_8(Model model,HttpServletResponse response,HttpServletRequest request){
		List<ZjFbVO>ldbzzjs = gdtjService.getLdbzZjFbByFy(51);//���
		List<NlAndXlFbVO>ldbznlxls = gdtjService.getLdbzNlAndXlFbByFy(51);//���
		//List<FgBmFbVO>fgnlxls = gdtjService.getFgbmfbByFy(1176,1181,1178,1177,1180,1179,1127,1182,1187,1186,1183,1184,1127);//����
		
		model.addAttribute("bt", "�����з�Ժ�쵼������Ա���ͳ�Ʊ�(��һ�����)");
		model.addAttribute("ldbzzjs", ldbzzjs);
		model.addAttribute("ldbznlxls", ldbznlxls);
		return "gdtj/X_06_8";
	}
	
	//X_07
	@RequestMapping(value="/X_07.do",method = RequestMethod.GET)
	public String getX_07(Model model,HttpServletResponse response,HttpServletRequest request){
		//List<ZjFbVO>ldbzzjs = gdtjService.getLdbzZjFbByFy(51);//���
		//List<FgBmFbVO>fgnlxls = gdtjService.getFgbmfbByFy(1176,1181,1178,1177,1180,1179,1127,1182,1187,1186,1183,1184,1127);//����
		
		model.addAttribute("bt", "������Ժ 2014�ɲ����ơ�ְ���䶯̨��");
		return "gdtj/X_07";
	}
	
	public void setRoleMenuService(RoleMenuService roleMenuService) {
		this.roleMenuService = roleMenuService;
	}

	public void setGdtjService(GdtjService gdtjService) {
		this.gdtjService = gdtjService;
	}
}
