package nju.software.fyrs.database;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import nju.software.fyrs.data.dataobject.SysBackup;
import nju.software.fyrs.service.SysBackupService;
import nju.software.fyrs.util.BackupDatabase;
import nju.software.fyrs.util.ConstantsFyrs;

import org.apache.log4j.Logger;

public class DatabaseUpTask
{
	private SysBackupService sysBackupService;
	private static Logger logger = Logger.getLogger(DatabaseUpTask.class);

	public void databaseDoBackupTask()
	{
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat();
		System.out.println("-task->" + simpleDateFormat.format(new Date()));
		System.out.println("���ݿ��ڻָ���");
		String resourcePath = this.getClass().getResource("").getPath();
		String baseURL = resourcePath.substring(1,
				resourcePath.lastIndexOf("/WEB-INF"));

		Date currentDate = new Date();
		long timeStamp = currentDate.getTime();
		String dataBaseUpPath = SetTheDatabasePath.getPath()+"\\fyrs2014-" + timeStamp
				+ ".db";
		BackupDatabase backupDatabase = new BackupDatabase();
		boolean isBackupSuccess = false;
		try
		{
			isBackupSuccess = backupDatabase.dataBaseUp(baseURL,
					dataBaseUpPath, timeStamp, "FYRS");
		} catch (IOException e)
		{
			isBackupSuccess = false;
			e.printStackTrace();
		}
		if (isBackupSuccess)
		{
			SysBackup sysBackup = new SysBackup();
			sysBackup.setCFilename("fyrs2014-" + timeStamp + ".db");
			sysBackup.setCPath(dataBaseUpPath);
			sysBackup.setDBacktime(currentDate);
			sysBackup.setNBacktype(ConstantsFyrs.DATABASE_BACKUP_AUTO);
			sysBackupService.addSysBackup(sysBackup);
			
			// �����ɵı��ݿ��ɿ��Իع������ݿ�
			
			// sysBackupService.isGeneratorOnline(baseURL,"FYRS_BACKUP",nid);
			try
			{
				boolean isOnline = sysBackupService.isGeneratorOnlineAuto(baseURL, "FYRS_BACKUP", dataBaseUpPath, timeStamp);
			    if(isOnline)
			    {
			    	logger.debug("ϵͳ�Զ���������ʧ��!");
			    }
			} catch (IOException e)
			{	        
				e.printStackTrace();
				logger.debug("ϵͳ�Զ����������쳣!");
			}
		} else
		{
			logger.debug("ϵͳ�Զ�����ʧ��!");
		}

	}

	public void setSysBackupService(SysBackupService sysBackupService)
	{
		this.sysBackupService = sysBackupService;
	}

}
