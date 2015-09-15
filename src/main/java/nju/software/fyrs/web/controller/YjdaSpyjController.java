package nju.software.fyrs.web.controller;


import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import nju.software.fyrs.biz.vo.DmCommonVO2;
import nju.software.fyrs.data.dataobject.Ajjtxx;
import nju.software.fyrs.data.dataobject.Gryjda;
import nju.software.fyrs.service.YjdaScbbService;
import nju.software.fyrs.service.impl.RoleMenuService;
import nju.software.fyrs.service.model.UserContext;
import nju.software.fyrs.util.NumberUtil;
import nju.software.fyrs.util.RolesUtil;
import nju.software.fyrs.web.json.ResponseBuilder;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/main/yjda")
public class YjdaSpyjController {
	    private RoleMenuService roleMenuService;
	    private YjdaScbbService yjdaScbbService;
	    
	    @RequestMapping(value="/spyj.do",method = RequestMethod.GET)
	    public String showJdcx(Model model,HttpServletResponse response,HttpServletRequest request)
	    {
	       MenuShowUtils.headerMenu(request,model, roleMenuService,"业绩档案");
		   MenuShowUtils.leftMenu(request,model, roleMenuService, "yjda");
	       model.addAttribute("currentSelectLeftMenu","审判业绩");
	       return "spyj/show";
	    }
	    
		public void setRoleMenuService(RoleMenuService roleMenuService) {
			this.roleMenuService = roleMenuService;
		}
		
		public void setYjdaScbbService(YjdaScbbService yjdaScbbService) {
			this.yjdaScbbService = yjdaScbbService;
		}
		
		private List<Date> getFromDateAndToDate(String sjd,String year,String xz,String selectone,String selecttwo,String selectthree,String selectfour){
			Date dateFrom = new Date();
		    Date dateTo = new Date();
		    Calendar calFrom = Calendar.getInstance();
		    Calendar calTo = Calendar.getInstance();
		    int yearNum = Integer.parseInt(year);
		    
		    if(sjd.equals("1")){
		    	if(xz.equals("1")){
		    		calFrom.set(yearNum-1, 11, 21, 0, 0, 0);
		    		calTo.set(yearNum, 11, 20, 0, 0, 0);
		    	}else if(xz.equals("2")){
		    		calFrom.set(yearNum-1, 11, 21, 0, 0, 0);
		    		calTo.set(yearNum, 5, 20, 0, 0, 0);
		    	}else{
		    		calFrom.set(yearNum, 5, 21, 0, 0, 0);
		    		calTo.set(yearNum, 11, 20, 0, 0, 0);
		    	}
		    }else if(sjd.equals("2")){
		    	if(xz.equals("1")){
		    		calFrom.set(yearNum-1, 11, 21, 0, 0, 0);
		    		calTo.set(yearNum, 2, 20, 0, 0, 0);
		    	}else if(xz.equals("2")){
		    		calFrom.set(yearNum, 2, 21, 0, 0, 0);
		    		calTo.set(yearNum, 5, 20, 0, 0, 0);
		    	}else if(xz.equals("3")){
		    		calFrom.set(yearNum, 5, 21, 0, 0, 0);
		    		calTo.set(yearNum, 8, 20, 0, 0, 0);
		    	}else{
		    		calFrom.set(yearNum, 8, 21, 0, 0, 0);
		    		calTo.set(yearNum, 11, 20, 0, 0, 0);
		    	}
		    }else if(sjd.equals("3")){
		    	if(xz.equals("1")){
		    		calFrom.set(yearNum-1, 11, 21, 0, 0, 0);
		    		calTo.set(yearNum, 0, 20, 0, 0, 0);
		    	}else{
		    		calFrom.set(yearNum, Integer.parseInt(xz)-2, 21, 0, 0, 0);
		    		calTo.set(yearNum, Integer.parseInt(xz)-1, 20, 0, 0, 0);
		    	}
		    }else if(sjd.equals("4")){
		    	String[] s1 = selectthree.split("-");
		    	String[] s2 = selectfour.split("-");
		    	calFrom.set(Integer.parseInt(s1[0]), Integer.parseInt(s1[1])-1, Integer.parseInt(s1[2]), 0, 0, 0);
		    	calTo.set(Integer.parseInt(s2[0]), Integer.parseInt(s2[1])-1, Integer.parseInt(s2[2]), 0, 0, 0);
		    }else if(sjd.equals("5")){
		    	calFrom.set(1901, 0, 1, 0, 0, 0);
		    }
		    dateFrom = calFrom.getTime();
		    dateTo = calTo.getTime();
		    
		    System.out.println(dateFrom);
		    System.out.println(dateTo);
		    List<Date> listDate = new ArrayList<Date>(2);
		    listDate.add(dateFrom);
		    listDate.add(dateTo);
		    return listDate;
		}
		
		@RequestMapping(value="/scbbgr.aj",method = RequestMethod.POST)
	    public void scbbShow(Model model,HttpServletResponse response,HttpServletRequest request) throws IOException{
			UserContext userContext = (UserContext)request.getSession().getAttribute("user");
			String yhmc = userContext.getYhmc();
			//根据从前台传送来的数据确定时间
		    String sjd = request.getParameter("sjd");
		    String year = request.getParameter("year");
		    String xz = request.getParameter("xz");
		    String selectone = request.getParameter("selectone");
		    String selecttwo = request.getParameter("selecttwo");
		    String selectthree = request.getParameter("selectthree");
		    String selectfour = request.getParameter("selectfour");
		    
		    List<Date> listDate = getFromDateAndToDate(sjd, year, xz, selectone, selecttwo, selectthree, selectfour);
		    Date dateFrom = listDate.get(0);
		    Date dateTo = listDate.get(1);
		    
		    //切换数据源到业绩档案
		    String saveBefore = RolesUtil.getUserContext(request).getCurrentDataSource();
		    RolesUtil.getUserContext(request).setCurrentDataSource("yjda");
		    Gryjda gryjda = yjdaScbbService.getGryjda(dateFrom,dateTo,yhmc);		    
		    // xf-server		    
		    List<Ajjtxx> ajjtxxList = new ArrayList<Ajjtxx>();
		    List<String> ahs = new ArrayList<String>();
		    ajjtxxList = yjdaScbbService.getAjjtxx(yhmc,2+"");
		    for(Ajjtxx aj : ajjtxxList)
		    {
		       ahs.add(aj.getAH());
		    }
		    RolesUtil.getUserContext(request).setCurrentDataSource("xfServer");
		    int[] sumXfshu = yjdaScbbService.getXfShu(ahs);
		    gryjda.setXftss(sumXfshu[0]+"");
		    if(gryjda.getJazs() != null && !gryjda.getJazs().trim().equals("") || !gryjda.getJazs().trim().equals("0"))
		    {
		    	float re = (float)sumXfshu[1]/Float.valueOf(gryjda.getJazs());
		    	gryjda.setXftsl(NumberUtil.formatFloat(re, "0.00"));
		    }
		    else
		    {
		    	gryjda.setXftsl("--");
		    }
		    // xf-server
		    ResponseBuilder builder=new ResponseBuilder();	
		    //切换到原来的数据源
		    RolesUtil.getUserContext(request).setCurrentDataSource(saveBefore);
		    builder.writeJsonResponse(response,gryjda);		
		   
		}
		
		@RequestMapping(value="/ajjtxx.aj",method = RequestMethod.POST)
	    public String ajjtxxShow(Model model,HttpServletResponse response,HttpServletRequest request){
			UserContext userContext = (UserContext)request.getSession().getAttribute("user");
			String yhmc = userContext.getYhmc();
			String codeNum = request.getParameter("codeNum");
			String saveBefore = RolesUtil.getUserContext(request).getCurrentDataSource();
			RolesUtil.getUserContext(request).setCurrentDataSource("yjda");
			List<Ajjtxx> ajjtxxList = new ArrayList<Ajjtxx>();
			ajjtxxList = yjdaScbbService.getAjjtxx(yhmc,codeNum);
			model.addAttribute("ajjtxxList", ajjtxxList);
			RolesUtil.getUserContext(request).setCurrentDataSource(saveBefore);
			return "/spyj/pop/view_ajjtxx";
		}
		
		@RequestMapping(value="/scbbqy.aj",method = RequestMethod.POST)
	    public void generatorSQLTest(Model model,HttpServletResponse response,HttpServletRequest request) throws IOException{
		    // 切换数据源
			String saveBefore = RolesUtil.getUserContext(request).getCurrentDataSource();
			RolesUtil.getUserContext(request).setCurrentDataSource("yjda");
			UserContext userContext = (UserContext)request.getSession().getAttribute("user");
			String yhmc = userContext.getYhmc();
		    String sjd = request.getParameter("sjd");
		    String year = request.getParameter("year");
		    String xz = request.getParameter("xz");
		    String selectone = request.getParameter("selectone");
		    String selecttwo = request.getParameter("selecttwo");
		    String selectthree = request.getParameter("selectthree");
		    String selectfour = request.getParameter("selectfour");
		    
		    List<Date> listDate = getFromDateAndToDate(sjd, year, xz, selectone, selecttwo, selectthree, selectfour);
		    Date dateFrom = listDate.get(0);
		    Date dateTo = listDate.get(1);
		    
			List<List<String>> listData = yjdaScbbService.getQuanYuanyjda(dateFrom,dateTo,yhmc);
				
		    // 切换数据源
			RolesUtil.getUserContext(request).setCurrentDataSource(saveBefore);
			ResponseBuilder rb  = new ResponseBuilder();
			rb.writeJsonResponse(response,listData);
			
		}
		@RequestMapping(value="/scbbxz.aj",method = RequestMethod.POST)
	    public void scbbxz(Model model,HttpServletResponse response,HttpServletRequest request) throws IOException{
		    // 切换数据源
			String saveBefore = RolesUtil.getUserContext(request).getCurrentDataSource();
			RolesUtil.getUserContext(request).setCurrentDataSource("yjda");
			//UserContext userContext = (UserContext)request.getSession().getAttribute("user");
			//String yhmc = userContext.getYhmc();
		    String sjd = request.getParameter("sjd");
		    String year = request.getParameter("year");
		    String xz = request.getParameter("xz");
		    String selectone = request.getParameter("selectone");
		    String selecttwo = request.getParameter("selecttwo");
		    String selectthree = request.getParameter("selectthree");
		    String selectfour = request.getParameter("selectfour");
		    
		    List<Date> listDate = getFromDateAndToDate(sjd, year, xz, selectone, selecttwo, selectthree, selectfour);
		    Date dateFrom = listDate.get(0);
		    Date dateTo = listDate.get(1);
		    
			List<List<String>> listData = yjdaScbbService.getXzspYjda(selecttwo,dateFrom,dateTo);
				
		// 切换数据源
			RolesUtil.getUserContext(request).setCurrentDataSource(saveBefore);
			ResponseBuilder rb  = new ResponseBuilder();
			rb.writeJsonResponse(response,listData);
			
		}
		@RequestMapping(value="/scbbms.aj",method = RequestMethod.POST)
	    public void scbbms(Model model,HttpServletResponse response,HttpServletRequest request) throws IOException{
		    // 切换数据源
			String saveBefore = RolesUtil.getUserContext(request).getCurrentDataSource();
			RolesUtil.getUserContext(request).setCurrentDataSource("yjda");
			//UserContext userContext = (UserContext)request.getSession().getAttribute("user");
			//String yhmc = userContext.getYhmc();
		    String sjd = request.getParameter("sjd");
		    String year = request.getParameter("year");
		    String xz = request.getParameter("xz");
		    String selectone = request.getParameter("selectone");
		    String selecttwo = request.getParameter("selecttwo");
		    String selectthree = request.getParameter("selectthree");
		    String selectfour = request.getParameter("selectfour");
		    
		    List<Date> listDate = getFromDateAndToDate(sjd, year, xz, selectone, selecttwo, selectthree, selectfour);
		    Date dateFrom = listDate.get(0);
		    Date dateTo = listDate.get(1);
		    
			List<List<String>> listData = yjdaScbbService.getMsspYjda(selecttwo,dateFrom,dateTo);
				
		// 切换数据源
			RolesUtil.getUserContext(request).setCurrentDataSource(saveBefore);
			ResponseBuilder rb  = new ResponseBuilder();
			rb.writeJsonResponse(response,listData);
			
		}
		@RequestMapping(value="/scbbxs.aj",method = RequestMethod.POST)
	    public void scbbxs(Model model,HttpServletResponse response,HttpServletRequest request) throws IOException{
		    // 切换数据源
			String saveBefore = RolesUtil.getUserContext(request).getCurrentDataSource();
			RolesUtil.getUserContext(request).setCurrentDataSource("yjda");
			//UserContext userContext = (UserContext)request.getSession().getAttribute("user");
			//String yhmc = userContext.getYhmc();
		    String sjd = request.getParameter("sjd");
		    String year = request.getParameter("year");
		    String xz = request.getParameter("xz");
		    String selectone = request.getParameter("selectone");
		    String selecttwo = request.getParameter("selecttwo");
		    String selectthree = request.getParameter("selectthree");
		    String selectfour = request.getParameter("selectfour");
		    
		    List<Date> listDate = getFromDateAndToDate(sjd, year, xz, selectone, selecttwo, selectthree, selectfour);
		    Date dateFrom = listDate.get(0);
		    Date dateTo = listDate.get(1);
		    
			List<List<String>> listData = yjdaScbbService.getXsspYjda(selecttwo,dateFrom,dateTo);
				
		// 切换数据源
			RolesUtil.getUserContext(request).setCurrentDataSource(saveBefore);
			ResponseBuilder rb  = new ResponseBuilder();
			rb.writeJsonResponse(response,listData);
			
		}
		@RequestMapping(value="/scbbzx.aj",method = RequestMethod.POST)
	    public void scbbzx(Model model,HttpServletResponse response,HttpServletRequest request) throws IOException{
		    // 切换数据源
			String saveBefore = RolesUtil.getUserContext(request).getCurrentDataSource();
			RolesUtil.getUserContext(request).setCurrentDataSource("yjda");
			//UserContext userContext = (UserContext)request.getSession().getAttribute("user");
			//String yhmc = userContext.getYhmc();
		    String sjd = request.getParameter("sjd");
		    String year = request.getParameter("year");
		    String xz = request.getParameter("xz");
		    String selectone = request.getParameter("selectone");
		    String selecttwo = request.getParameter("selecttwo");
		    String selectthree = request.getParameter("selectthree");
		    String selectfour = request.getParameter("selectfour");
		    
		    List<Date> listDate = getFromDateAndToDate(sjd, year, xz, selectone, selecttwo, selectthree, selectfour);
		    Date dateFrom = listDate.get(0);
		    Date dateTo = listDate.get(1);
		    
			List<List<String>> listData = yjdaScbbService.getZxspYjda(selecttwo,dateFrom,dateTo);
				
		// 切换数据源
			RolesUtil.getUserContext(request).setCurrentDataSource(saveBefore);
			ResponseBuilder rb  = new ResponseBuilder();
			rb.writeJsonResponse(response,listData);
			
		}
		@RequestMapping(value="/scbbla.aj",method = RequestMethod.POST)
	    public void scbbla(Model model,HttpServletResponse response,HttpServletRequest request) throws IOException{
		    // 切换数据源
			String saveBefore = RolesUtil.getUserContext(request).getCurrentDataSource();
			RolesUtil.getUserContext(request).setCurrentDataSource("yjda");
			//UserContext userContext = (UserContext)request.getSession().getAttribute("user");
			//String yhmc = userContext.getYhmc();
		    String sjd = request.getParameter("sjd");
		    String year = request.getParameter("year");
		    String xz = request.getParameter("xz");
		    String selectone = request.getParameter("selectone");
		    String selecttwo = request.getParameter("selecttwo");
		    String selectthree = request.getParameter("selectthree");
		    String selectfour = request.getParameter("selectfour");
		    
		    List<Date> listDate = getFromDateAndToDate(sjd, year, xz, selectone, selecttwo, selectthree, selectfour);
		    Date dateFrom = listDate.get(0);
		    Date dateTo = listDate.get(1);
		    
			List<List<String>> listData = yjdaScbbService.getLaspYjda(selecttwo,dateFrom,dateTo);
				
		// 切换数据源
			RolesUtil.getUserContext(request).setCurrentDataSource(saveBefore);
			ResponseBuilder rb  = new ResponseBuilder();
			rb.writeJsonResponse(response,listData);
			
		}
		@RequestMapping(value="/scbbsj.aj",method = RequestMethod.POST)
	    public void scbbsj(Model model,HttpServletResponse response,HttpServletRequest request) throws IOException{
		    // 切换数据源
			String saveBefore = RolesUtil.getUserContext(request).getCurrentDataSource();
			RolesUtil.getUserContext(request).setCurrentDataSource("yjda");
			//UserContext userContext = (UserContext)request.getSession().getAttribute("user");
			//String yhmc = userContext.getYhmc();
		    String sjd = request.getParameter("sjd");
		    String year = request.getParameter("year");
		    String xz = request.getParameter("xz");
		    String selectone = request.getParameter("selectone");
		    String selecttwo = request.getParameter("selecttwo");
		    String selectthree = request.getParameter("selectthree");
		    String selectfour = request.getParameter("selectfour");
		    
		    List<Date> listDate = getFromDateAndToDate(sjd, year, xz, selectone, selecttwo, selectthree, selectfour);
		    Date dateFrom = listDate.get(0);
		    Date dateTo = listDate.get(1);
		    
			List<List<String>> listData = yjdaScbbService.getSjspYjda(selecttwo,dateFrom,dateTo);
				
		// 切换数据源
			RolesUtil.getUserContext(request).setCurrentDataSource(saveBefore);
			ResponseBuilder rb  = new ResponseBuilder();
			rb.writeJsonResponse(response,listData);
			
		}
		 @RequestMapping(value="/selectType.aj",method = RequestMethod.POST)
		    public void selectType(Model model,HttpServletResponse response,HttpServletRequest request) throws IOException
		    {
			   
			   String selectType = request.getParameter("selectType");
			   String saveBefore = RolesUtil.getUserContext(request).getCurrentDataSource();
			   RolesUtil.getUserContext(request).setCurrentDataSource("yjda");
			   List<DmCommonVO2> vos = yjdaScbbService.getDmb(selectType);	  
				// 切换数据源
			   RolesUtil.getUserContext(request).setCurrentDataSource(saveBefore);
		       ResponseBuilder rb = new ResponseBuilder();
		       rb.writeJsonResponse(response, vos);			  
		    }
		 @RequestMapping(value="/scbbzwzj.aj",method = RequestMethod.POST)
		    public void generatorScbbZwZj(Model model,HttpServletResponse response,HttpServletRequest request) throws IOException{
			    // 切换数据源
			    String saveBefore = RolesUtil.getUserContext(request).getCurrentDataSource();
				RolesUtil.getUserContext(request).setCurrentDataSource("yjda");
			    String sjd = request.getParameter("sjd");
			    String year = request.getParameter("year");
			    String xz = request.getParameter("xz");
			    String selectone = request.getParameter("selectone");
			    String selecttwo = request.getParameter("selecttwo");
			    String selectthree = request.getParameter("selectthree");
			    String selectfour = request.getParameter("selectfour");
			    
			    List<Date> listDate = getFromDateAndToDate(sjd, year, xz, selectone, selecttwo, selectthree, selectfour);
			    Date dateFrom = listDate.get(0);
			    Date dateTo = listDate.get(1);
			    
				List<List<String>> listData = yjdaScbbService.getScbbZwZj(dateFrom,dateTo,selectone,selecttwo);
					
				// 切换数据源
				RolesUtil.getUserContext(request).setCurrentDataSource(saveBefore);
				ResponseBuilder rb  = new ResponseBuilder();
				rb.writeJsonResponse(response,listData);			
			}
}
