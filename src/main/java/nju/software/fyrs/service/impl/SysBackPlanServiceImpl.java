package nju.software.fyrs.service.impl;

import java.util.List;

import nju.software.fyrs.data.dao.SysBackPlanDAO;
import nju.software.fyrs.data.dataobject.SysBackPlan;
import nju.software.fyrs.service.SysBackPlanService;

import org.quartz.Scheduler;
import org.springframework.scheduling.quartz.CronTriggerBean;

public class SysBackPlanServiceImpl implements SysBackPlanService {
	private SysBackPlanDAO sysBackPlanDAO;
	private Scheduler scheduler;
	@Override
	public List<SysBackPlan> listSysBackPlans()
	{
		return sysBackPlanDAO.listSysBackPlans();
	}
	@Override
	public void addSysBackPlan(SysBackPlan sysBackPlan)
	{
		sysBackPlanDAO.save(sysBackPlan);
	}
	@Override
	public void updateSysBackPlan(SysBackPlan sysBackPlan)
	{		
		CronTriggerBean trigger = null;
		try
		{
			trigger = (CronTriggerBean) scheduler.getTrigger("doTime",Scheduler.DEFAULT_GROUP);
			if(sysBackPlan.getNFrequency() == 1)
			{
				trigger.setCronExpression("0 0/1 * * * ?");
				// 表示每天的早上  1 点 到 2 点
				// trigger.setCronExpression("0 0 1,2 * * ?");
			}
			if(sysBackPlan.getNFrequency() == 2)
			{
				trigger.setCronExpression("0 0 1,2 ? * MON");
				// 表示每周一的早上  1 点 到 2 点
				// trigger.setCronExpression("0 0 1,2 * * MON ?");
			}
			if(sysBackPlan.getNFrequency() == 3)
			{
				trigger.setCronExpression("0 0/3 * * * ?");
				// 表示每月最后一天 1 点 到 2 点
				// trigger.setCronExpression("0 0 1,2 L * ?");
			}
			scheduler.rescheduleJob("doTime",Scheduler.DEFAULT_GROUP,trigger);
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
		sysBackPlanDAO.updateSysBackPlan(sysBackPlan);
	}
	public void setSysBackPlanDAO(SysBackPlanDAO sysBackPlanDAO)
	{
		this.sysBackPlanDAO = sysBackPlanDAO;
	}
	public void setScheduler(Scheduler scheduler)
	{
		this.scheduler = scheduler;
	}
	
} 
