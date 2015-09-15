package nju.software.fyrs.service.impl;

import java.io.File;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import nju.software.fyrs.biz.vo.SysBackupVO;
import nju.software.fyrs.data.dao.SysBackPlanDAO;
import nju.software.fyrs.data.dao.SysBackupDAO;
import nju.software.fyrs.data.dataobject.SysBackPlan;
import nju.software.fyrs.data.dataobject.SysBackup;
import nju.software.fyrs.service.SysBackupService;
import nju.software.fyrs.util.BackupDatabase;
import nju.software.fyrs.util.DateUtil;

public class SysBackupServiceImpl implements SysBackupService {
    private SysBackupDAO sysBackupDAO;
    private SysBackPlanDAO sysBackPlanDAO;
	@Override
	public List<SysBackupVO> listSysBackup()
	{
		List<SysBackupVO> vos = new ArrayList<SysBackupVO>();
		List<SysBackup> list = sysBackupDAO.listSysBackup();
		for(SysBackup item : list)
		{
		SysBackupVO vo = new SysBackupVO();
		vo.setNId(item.getNId()+"");
		vo.setDBacktime(DateUtil.format(item.getDBacktime(),DateUtil.webFormat2));
		vo.setCPath(item.getCPath());
		vo.setCFilename(item.getCFilename());
		if(item.getNBacktype() == 1)
		{
			vo.setNBacktype("系统自动备份");
		}
		if(item.getNBacktype() == 2)
		{
			vo.setNBacktype("手动备份");
		}		
		vos.add(vo);
		}
		return vos;
		
	}
	public void deleteSysBackup(String nid)
	{
		SysBackup sysBackup = sysBackupDAO.findById(nid);
		File file = new File(sysBackup.getCPath());
		if(file.exists())
		{
			file.delete();
		}
		sysBackupDAO.delete(sysBackup);
	}
	public boolean isGeneratorOnline(String basePath,String databaseName,String nid) throws IOException
	{
		boolean result = false;
		BackupDatabase backupDatabase = new BackupDatabase();
		Date date = new Date();
		SysBackup sysBackup = sysBackupDAO.findById(nid);
		if(sysBackup != null)
		{
			result = backupDatabase.uploadDatabaseOnline(basePath, databaseName,sysBackup.getCPath(),date.getTime());
		}	
		return result;
	}
	@Override
	public boolean isGeneratorOnlineAuto(String basePath,String databaseName,String dataBasePath,long currentTime) throws IOException
	{
		BackupDatabase backupDatabase = new BackupDatabase();
		return backupDatabase.uploadDatabaseOnline(basePath, databaseName,dataBasePath,currentTime);
	}
	public SysBackup getSysBackup(String nid)
	{
		return sysBackupDAO.findById(new BigDecimal(nid));
	}
	@Override
	public void addSysBackup(SysBackup sysBackup)
	{
		sysBackup.setNId(sysBackupDAO.getMaxId());
		List<SysBackup> exists = sysBackupDAO.listSysBackup();
		SysBackPlan sysBackPlan = sysBackPlanDAO.listSysBackPlans().get(0);
		if(exists.size() >= sysBackPlan.getNBlfs())
		{
			for(int i = sysBackPlan.getNBlfs() - 1; i < exists.size(); i++)
			{
				sysBackupDAO.delete(exists.get(i));
			}
		}
		sysBackupDAO.save(sysBackup);
		
	}
	public void setSysBackupDAO(SysBackupDAO sysBackupDAO)
	{
		this.sysBackupDAO = sysBackupDAO;
	}
	public void setSysBackPlanDAO(SysBackPlanDAO sysBackPlanDAO)
	{
		this.sysBackPlanDAO = sysBackPlanDAO;
	}
	
  
}
