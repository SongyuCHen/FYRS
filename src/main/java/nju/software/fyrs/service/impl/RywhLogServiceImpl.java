package nju.software.fyrs.service.impl;

import java.lang.reflect.Method;
import java.util.Date;
import java.util.List;

import nju.software.fyrs.data.dao.DdTableDAO;
import nju.software.fyrs.data.dao.RyjbxxDAO;
import nju.software.fyrs.data.dao.RywhLogDAO;
import nju.software.fyrs.data.dataobject.Ryjbxx;
import nju.software.fyrs.data.dataobject.RywhLog;
import nju.software.fyrs.service.RywhLogService;
import nju.software.fyrs.util.InterceptThreadLocal;
import nju.software.fyrs.util.LoginUserInfoThreadLocal;
import nju.software.fyrs.util.ObjectByteThreadLocal;
import nju.software.fyrs.util.ObjectSerializedUtils;

import org.aspectj.lang.JoinPoint;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class RywhLogServiceImpl implements RywhLogService {
	private RywhLogDAO rywhLogDAO;
	private RyjbxxDAO ryjbxxDAO;
	private DdTableDAO ddTableDAO;
	private boolean isIntercept = true;
	private static final Logger log = LoggerFactory.getLogger(RywhLogServiceImpl.class);
	/**
	 * ���ص���Ӷ��󣬴�����
	 * 
	 * @param joinPoint
	 */
	public void dealAddMethod(JoinPoint joinPoint,Object returnValue)
	{
		
		if((Boolean)returnValue)
		{
			if (InterceptThreadLocal.getIsIntercept() != null)
			{
				isIntercept = InterceptThreadLocal.getIsIntercept();
			}
			
			if (isIntercept)
			{
				System.out.println(joinPoint.getArgs()[0].getClass().getName() + "��������-->add");
				Object obj = joinPoint.getArgs()[0];
				commonAddUpdateDlete(obj, "����", 1);
			}
			InterceptThreadLocal.removeIsIntercept();
		}
		else
		{
			log.debug("��Ӳ����쳣�����������ش���!");
		}
	}

	/**
	 * ���ص����¶��󣬴�����
	 * 
	 * @param joinPoint
	 */
	public void dealUpdateMethod(JoinPoint joinPoint,Object returnValue)
	{
	
		if((Boolean)returnValue)
		{
			if (InterceptThreadLocal.getIsIntercept() != null)
			{
				isIntercept = InterceptThreadLocal.getIsIntercept();
			}
		
			if (isIntercept)
			{
				System.out.println(joinPoint.getArgs()[0].getClass().getName() + "��������-->update");
				Object obj = joinPoint.getArgs()[0];
				commonAddUpdateDlete(obj, "�޸�", 3);				
			}
			InterceptThreadLocal.removeIsIntercept();
		}
		else
		{
			log.debug("���²����쳣�����������ش���!");
		}
		
	}

	/**
	 * ���ص�ɾ�����󣬴�����
	 * 
	 * @param joinPoint
	 */
	public void dealDeleteMethod(JoinPoint joinPoint,Object returnValue)
	{
		if((Boolean)returnValue)
		{
			if (InterceptThreadLocal.getIsIntercept() != null)
			{
				isIntercept = InterceptThreadLocal.getIsIntercept();
			}
			if (isIntercept)
			{
				System.out.println(joinPoint.getArgs()[0].getClass().getName() + "��������-->delete");
				Object obj = joinPoint.getArgs()[0];
				commonAddUpdateDlete(obj, "ɾ��", 2);
			}

			InterceptThreadLocal.removeIsIntercept();
		}
		else
		{
			log.debug("ɾ�������쳣�����������ش���!");
		}
		

	}

	private void commonAddUpdateDlete(Object obj, String oper, int operType)
	{
		RywhLog rywhLog = null;
		String changeUsername = "";
		try
		{
			rywhLog = rywhLogDAO.getMaxNidWithRywhLog(getFydmFromObj(obj));
			/**
			 * ���ɾ�����ǻ�����Ϣ��,��� XM ֱ�Ӵ� �����ã����������
			 */
			if(obj.getClass().getName().equals("nju.software.fyrs.data.dataobject.Ryjbxx"))
			{
				Ryjbxx ryjbxx = (Ryjbxx)obj;
				if(ryjbxx.getCXm() == null)
				{
					changeUsername = "";
				}
				else
				{
					changeUsername = ryjbxx.getCXm();
				}
				
			}
			else
			{
				changeUsername = getCxm(rywhLog.getNDwid(),getRybhFromObj(obj));
			}
			
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
			return;
		}
		// ����ѷ�Ժ�� fydm ���
		
		String tableName = getTableName(classNameToTableName(obj.getClass().getSimpleName()));
		rywhLog.setCCznr(oper + changeUsername + "��" + tableName);		
		rywhLog.setCIp(LoginUserInfoThreadLocal.getUserIp());
		rywhLog.setDCzsj(new Date());
		if (operType == 3)
		{
			rywhLog.setImUsql(ObjectByteThreadLocal.getObjectByte());
		} else
		{
			try
			{
				rywhLog.setImUsql(ObjectSerializedUtils.writeObjectToMemory(obj));
			} catch (Exception ex)
			{
				ex.printStackTrace();
			}                                                                                                                                               

		}
		rywhLog.setNUsqltype(operType);
		// �����õ���Ժ fydm
		// rywhLog.setNId(rywhLogDAO.getMaxNid(rywhLog.getNDwid()));
		rywhLogDAO.mSaveOrUpdate(rywhLog);
		
	}

	public void setRywhLogDAO(RywhLogDAO rywhLogDAO)
	{
		this.rywhLogDAO = rywhLogDAO;
	}

	public void setRyjbxxDAO(RyjbxxDAO ryjbxxDAO)
	{
		this.ryjbxxDAO = ryjbxxDAO;
	}

	public void setDdTableDAO(DdTableDAO ddTableDAO)
	{
		this.ddTableDAO = ddTableDAO;
	}

	@Override
	public List<RywhLog> listByTimeOperUser(String operUser, String operBeginTime, String operEndTime, String operType)
	{

		return rywhLogDAO.listByTimeOperUser(operUser, operBeginTime, operEndTime, operType);
	}

	@Override
	public void recoverSystem(String endTime)
	{
		try
		{
			List<RywhLog> lists = rywhLogDAO.listAll(endTime);
			for (final RywhLog rl : lists)
			{
				if (rl.getNUsqltype() == 1)
				{
					rywhLogDAO.recoverSystemDelete(ObjectSerializedUtils.readObjectFromMemory(rl.getImUsql()));
				}
				if (rl.getNUsqltype() == 2)
				{
					rywhLogDAO.recoverSystemAdd(ObjectSerializedUtils.readObjectFromMemory(rl.getImUsql()));
				}
				if (rl.getNUsqltype() == 3)
				{
					rywhLogDAO.recoverSystemUpdate(ObjectSerializedUtils.readObjectFromMemory(rl.getImUsql()));
				}
				rywhLogDAO.delete(rl);
			}
		} catch (Exception ex)
		{
			log.debug("�ָ�����");
			ex.printStackTrace();
		}

	}

	/**
	 * ��һ�������磺 RysxBzxx ת���� T_Rysx_Bzxx
	 * 
	 * @param className
	 * @return
	 */
	private String classNameToTableName(String className)
	{
		char[] chars = className.toCharArray();
		boolean hasCapital = false;
		int j = 0;
		int k = 0;
		StringBuffer sb = new StringBuffer();
		sb.append("T_");
		for (int i = 0; i < chars.length; i++)
		{
			char c = chars[i];
			if (c >= 65 && c <= 90)
			{
				hasCapital = true;
				if (j != 0)
				{
					sb.append(String.valueOf(chars, k, j) + "_");
				}
				k = i;
				j = 0;
			}
			// Сдת���ɴ�д
			else
			{
				chars[i] -= 32;
			}
			j++;
			if (i == chars.length - 1)
			{
				sb.append(String.valueOf(chars, k, j));
			}
		}
		if (hasCapital)
		{
			return sb.toString();
		}
		return className;
	}

	private String getCxm(int fydm, int rybh)
	{	
			Ryjbxx ryjbxx = ryjbxxDAO.getRyjbxxByRybhFyDm(rybh, fydm);
			if(ryjbxx.getCXm() == null)
			{
				return "";
			}
			return ryjbxx.getCXm();	
	}
	private Integer getFydmFromObj(Object obj) throws Exception
	{
		Method fyMethod = obj.getClass().getMethod("getNFy");
		return (Integer) fyMethod.invoke(obj);
	}
	private Integer getRybhFromObj(Object obj) throws Exception
	{
		Method ryBhMethod = obj.getClass().getMethod("getNRybh");
		return (Integer) ryBhMethod.invoke(obj);
	}

	@Override
	public Date[] findMaxAndMinDate()
	{
		return rywhLogDAO.findMaxAndMinDate();
	}

	private String getTableName(String tableName)
	{
		if(tableName.equals("T_RYSX_JIALLIUXX")){
			tableName="T_RYSX_JIAOLIUXX";
		}else if(tableName.equals("T_RYSX_SHEBAO")){
			tableName="T_RYSX_SBJL";
		}else if(tableName.equals("T_RYSX_ZJBG")){
			tableName="T_RYSX_ZJBD";
		}
		
		return ddTableDAO.findByCTablename(tableName).getCCnname();
	}
	// ��ѯ

}
