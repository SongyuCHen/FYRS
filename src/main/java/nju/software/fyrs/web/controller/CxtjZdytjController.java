package nju.software.fyrs.web.controller;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import nju.software.fyrs.biz.vo.ConditionVO;
import nju.software.fyrs.biz.vo.DdFieldCondtionVO;
import nju.software.fyrs.biz.vo.OptionVO;
import nju.software.fyrs.biz.vo.ZdytjItem;
import nju.software.fyrs.biz.vo.ZdytjVO;
import nju.software.fyrs.data.dataobject.Dm;
import nju.software.fyrs.service.DdFieldService;
import nju.software.fyrs.service.DmService;
import nju.software.fyrs.service.RyjbxxService;
import nju.software.fyrs.service.impl.RoleMenuService;
import nju.software.fyrs.web.json.ResponseBuilder;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/main/cxtj")
public class CxtjZdytjController {
	private static Logger logger = Logger.getLogger(CxtjZdytjController.class);
	
	public static String RYJBXX_TABLEID = "T_RYJBXX";
	
	public static String MIN_DATE = "1900-01-01";
	
    private RoleMenuService roleMenuService;
    private DdFieldService ddFieldService;
    private DmService dmService;
    private RyjbxxService ryjbxxService;
    
    public void setRoleMenuService(RoleMenuService roleMenuService) {
		this.roleMenuService = roleMenuService;
	}
	public void setDdFieldService(DdFieldService ddFieldService) {
		this.ddFieldService = ddFieldService;
	}
	public void setDmService(DmService dmService) {
		this.dmService = dmService;
	}
	public void setRyjbxxService(RyjbxxService ryjbxxService) {
		this.ryjbxxService = ryjbxxService;
	}
	
    @RequestMapping(value="/zdytj.do",method = RequestMethod.GET)
    public String showJdcx(Model model,HttpServletResponse response,HttpServletRequest request)
    {
       MenuShowUtils.headerMenu(request,model, roleMenuService,"��ѯͳ��");
	   MenuShowUtils.leftMenu(request,model, roleMenuService, "cxtj");
       model.addAttribute("currentSelectLeftMenu","�Զ���ͳ��");
       
       return "zdytj/show";
    }
    
    @RequestMapping(value="/getInitConditions.do",method = RequestMethod.POST)
    public void getInitConditions(Model model,HttpServletResponse response,HttpServletRequest request){
		List<DdFieldCondtionVO> vos = ddFieldService.listByTableNameCondition(RYJBXX_TABLEID);
		List<ConditionVO> conditionVOList = new ArrayList<ConditionVO>();
		for(DdFieldCondtionVO vo : vos){
			ConditionVO conditionVO = new ConditionVO();
			conditionVO.setName(vo.getCCnname());
			conditionVO.setNameInDb(vo.getCFieldname());
			//�ж��Ƿ���ʱ������
			conditionVO.setDatetime(vo.getNDatatype().equals("3") ? true : false);
			//�ж��Ƿ��д���
			conditionVO.setHasMaincode(vo.getNMaincode().equals("0") ? false : true);
			
			List<OptionVO> optionList = new ArrayList<OptionVO>();
			List<Dm> dmList = dmService.listDmByNBxh(vo.getNMaincode());
			for(Dm dm : dmList){
				OptionVO optionVO = new OptionVO();
				optionVO.setName(dm.getCMc());
				optionVO.setOptionId(dm.getNDm());
				optionList.add(optionVO);
			}
			conditionVO.setOptions(optionList);
			conditionVOList.add(conditionVO);
		}
		try {
			ResponseBuilder rb = new ResponseBuilder();
			rb.writeJsonResponse(response, conditionVOList);
		} catch (IOException e) {
			e.printStackTrace();
		}
    }
    
	@SuppressWarnings("unchecked")
	@RequestMapping(value="/kstj.aj",method = RequestMethod.POST)
    public void zdytj(Model model,HttpServletResponse response,HttpServletRequest request) throws ParseException
    {	
		Map<String, String[]> map = request.getParameterMap();
    	Set<Entry<String, String[]>> set = map.entrySet();
    	Iterator<Entry<String, String[]>> it = set.iterator();
    	
    	String topColumnName = "";
    	String[] topValues = null;
    	
    	String leftColumnName = "";
    	String[] leftValues = null;
    	
    	String topCnname = "";
    	String leftCnname = "";
    	while (it.hasNext()) {
    		Entry<String, String[]> entry = it.next();
    		String key = entry.getKey();
    		if(key.startsWith("top-")){//�ϱ���
    			topColumnName = key.replace("top-", "");
    			topValues = entry.getValue();
    			topCnname = ddFieldService.getCnnameByTableIdAndFieldName(RYJBXX_TABLEID, topColumnName);
    		}
    		if(key.startsWith("left-")){//�ϱ���
    			leftColumnName = key.replace("left-", "");
    			leftValues = entry.getValue();
    			leftCnname = ddFieldService.getCnnameByTableIdAndFieldName(RYJBXX_TABLEID, leftColumnName);
    		}
    	}
    	
    	ZdytjVO zdytjVO = getRyCountByTopAndLeft(topColumnName, topValues, topCnname, leftColumnName, leftValues, leftCnname);
    	
    	try {
			ResponseBuilder rb = new ResponseBuilder();
			rb.writeJsonResponse(response, zdytjVO);
		} catch (IOException e) {
			e.printStackTrace();
		}
    }
	private ZdytjVO getRyCountByTopAndLeft(String topColumnName,
			String[] topValues, String topCnname, String leftColumnName, String[] leftValues, String leftCnname) throws ParseException {
		logger.info("topColumnName: "+topColumnName);
		
		boolean isTopDate = topColumnName.startsWith("D");
		boolean isLeftDate = leftColumnName.startsWith("D");
		boolean isTopNumber = topColumnName.startsWith("N");
		boolean isLeftNumber = leftColumnName.startsWith("N");
		boolean isTopString = topColumnName.startsWith("C");
		boolean isLeftString = leftColumnName.startsWith("C");
		
		int topColumnCount = topValues == null ? 0 :
				(isTopDate ? topValues.length / 2 : topValues.length);
		int leftColumnCount = leftValues == null ? 0 :
				(isLeftDate ? leftValues.length / 2 : leftValues.length);
		
		//��Ž��������
		Integer[][] resultMatrix = new Integer[topColumnCount+1][leftColumnCount+1];
		
		String topCondition = "";
		String leftCondition = "";
		Object[] topParams = null;
		Object[] leftParams = null;
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		if(topColumnCount > 0 && leftColumnCount > 0){
			for(int i=0; i<topColumnCount; i++){
				for(int j=0; j<leftColumnCount; j++){
					if(topValues != null){
						if(isTopDate){ //��������
							Date startDate = sdf.parse(MIN_DATE);
							Date endDate = new Date();
							if(!topValues[i*2].isEmpty()){//��ʼʱ��
								startDate = sdf.parse(topValues[i*2]);
							}
							if(!topValues[i*2+1].isEmpty()){//����ʱ��
								endDate = sdf.parse(topValues[i*2+1]);
							}
							topParams = new Object[]{startDate,endDate};
							topCondition = topColumnName + " BETWEEN ? AND ?";
						}else if(isTopNumber){ //��������
							topParams = new Object[]{Integer.parseInt(topValues[i])};
							topCondition = topColumnName+"= ?";
						}else if(isTopString){ //�ַ�������
							topParams = new Object[]{topValues[i]};
							topCondition = topColumnName+"= ?";
						}
					}
					if(leftValues != null){
						if(isLeftDate){
							Date startDate = sdf.parse(MIN_DATE);
							Date endDate = new Date();
							if(!leftValues[j*2].isEmpty()){//��ʼʱ��
								startDate = sdf.parse(leftValues[j*2]);
							}
							if(!leftValues[j*2+1].isEmpty()){//����ʱ��
								endDate = sdf.parse(leftValues[j*2+1]);
							}
							leftParams = new Object[]{startDate,endDate};
							leftCondition = leftColumnName + " BETWEEN ? AND ?";
						}else if(isLeftNumber){ //��������
							leftParams = new Object[]{Integer.parseInt(leftValues[j])};
							leftCondition = leftColumnName+"= ?";
						}else if(isLeftString){ //�ַ�������
							leftParams = new Object[]{leftValues[j]};
							leftCondition = leftColumnName+"= ?";
						}
					}
					resultMatrix[i][j] = ryjbxxService.getRyCountByTopAndLeftConditions(topCondition, leftCondition, topParams, leftParams);
				}
			}
		}
		if(topColumnCount == 0 && leftColumnCount > 0){
			for(int j=0; j<leftColumnCount; j++){
				if(isLeftDate){
					Date startDate = sdf.parse(MIN_DATE);
					Date endDate = new Date();
					if(!leftValues[j*2].isEmpty()){//��ʼʱ��
						startDate = sdf.parse(leftValues[j*2]);
					}
					if(!leftValues[j*2+1].isEmpty()){//����ʱ��
						endDate = sdf.parse(leftValues[j*2+1]);
					}
					leftParams = new Object[]{startDate,endDate};
					leftCondition = leftColumnName + " BETWEEN ? AND ?";
				}else if(isLeftNumber){ //��������
					leftParams = new Object[]{Integer.parseInt(leftValues[j])};
					leftCondition = leftColumnName+"= ?";
				}else if(isLeftString){ //�ַ�������
					leftParams = new Object[]{leftValues[j]};
					leftCondition = leftColumnName+"= ?";
				}
				resultMatrix[0][j] = ryjbxxService.getRyCountByTopAndLeftConditions(topCondition, leftCondition, topParams, leftParams);
			}
		}
		if(leftColumnCount == 0 && topColumnCount > 0){
			for(int j=0; j<topColumnCount; j++){
				if(isTopDate){ //��������
					Date startDate = sdf.parse(MIN_DATE);
					Date endDate = new Date();
					if(!topValues[j*2].isEmpty()){//��ʼʱ��
						startDate = sdf.parse(topValues[j*2]);
					}
					if(!topValues[j*2+1].isEmpty()){//����ʱ��
						endDate = sdf.parse(topValues[j*2+1]);
					}
					topParams = new Object[]{startDate,endDate};
					topCondition = topColumnName + " BETWEEN ? AND ?";
				}else if(isTopNumber){ //��������
					topParams = new Object[]{Integer.parseInt(topValues[j])};
					topCondition = topColumnName+"= ?";
				}else if(isTopString){ //�ַ�������
					topParams = new Object[]{topValues[j]};
					topCondition = topColumnName+"= ?";
				}
				resultMatrix[j][0] = ryjbxxService.getRyCountByTopAndLeftConditions(topCondition, leftCondition, topParams, leftParams);
			}
		}
		//����ϼ�
		if(leftColumnCount > 0){
			for(int i=0; i==0 || i< topColumnCount; i++){
				int subTotal = 0;
				
				for(int j=0; j<leftColumnCount; j++){
					subTotal += resultMatrix[i][j];
				}
				resultMatrix[i][leftColumnCount] = subTotal;
				
			}
		}
		if(topColumnCount > 0){
			for(int i=0; i<leftColumnCount+1; i++){
				int subTotal = 0;
				
				for(int j=0; j<topColumnCount; j++){
					subTotal += resultMatrix[j][i];
				}
				resultMatrix[topColumnCount][i] = subTotal;
				
			}
		}
		ZdytjVO zdytjVO = new ZdytjVO();
		//����top
		if(topColumnCount > 0){
			List<String> tableHead = new ArrayList<String>();
			tableHead.add(topCnname +"/" + leftCnname);//���Ͻ�
			Short topMaincode = ddFieldService.getMaincodeByTableIdAndFieldName(RYJBXX_TABLEID,topColumnName);
			for(int i =0 ;i<topColumnCount; i++){
				if(isTopDate){
					tableHead.add(topValues[i*2]+"~"+topValues[i*2+1]);
				}else if(isTopNumber){
					Dm dm = dmService.findDmByNBxhNdm(topMaincode.toString(), Integer.parseInt(topValues[i]));
					tableHead.add(dm.getCMc());
				}else{
					tableHead.add(topCnname+":"+topValues[i]);
				}
			}
			if(topColumnCount > 1) //ֻ��һ�У�����Ҫ�ϼ�
				tableHead.add("�ϼ�");//�ϼ�
			zdytjVO.setTableHead(tableHead);
		}
		//����������
		Short leftMaincode = ddFieldService.getMaincodeByTableIdAndFieldName(RYJBXX_TABLEID,leftColumnName);
		List<ZdytjItem> items = new ArrayList<ZdytjItem>();
		
		if(leftColumnCount > 0){
			for(int i=0; i<leftColumnCount; i++){
				ZdytjItem item = new ZdytjItem();
				List<String> data = new ArrayList<String>();
				if(isLeftNumber){
					Dm dm = dmService.findDmByNBxhNdm(leftMaincode.toString(), Integer.parseInt(leftValues[i]));
					data.add(dm.getCMc());
				}else if(isLeftString){
					data.add(leftCnname+":"+leftValues[i]);
				}else if(isLeftDate){
					data.add(leftValues[i*2]+"~"+leftValues[i*2+1]);
				}
				int colCount = topColumnCount > 1 ? topColumnCount+1 : 1;//ֻ��һ�У�����Ҫ�ϼ�
				for(int j=0; j<colCount; j++){
					data.add(resultMatrix[j][i]!=null ? resultMatrix[j][i].toString() : "0");
				}
				
				item.setData(data);
				items.add(item);
			}
		}
		if(leftColumnCount > 1 || leftColumnCount == 0){
			ZdytjItem item = new ZdytjItem();
			List<String> data = new ArrayList<String>();
			data.add("�ϼ�");
			int colCount = topColumnCount > 1 ? topColumnCount+1 : 1;//ֻ��һ�У�����Ҫ�ϼ�
			for(int j=0; j<colCount; j++){
				data.add(resultMatrix[j][leftColumnCount]!=null ? resultMatrix[j][leftColumnCount].toString() : "0");
			}
			item.setData(data);
			items.add(item);
		}
		zdytjVO.setItems(items);
		return zdytjVO;
	}
}
