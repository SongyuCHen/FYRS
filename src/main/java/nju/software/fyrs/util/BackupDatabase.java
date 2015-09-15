package nju.software.fyrs.util;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.apache.commons.io.FileUtils;

public class BackupDatabase
{
	public static String DATABASE_DIR = "databaseup";
	@SuppressWarnings("unchecked")
	public boolean  dataBaseUp(String basePath,String dataBaseSavePath,long currentTime,String databaseName) throws IOException
	{
		
		File inputFile = createFileOnServer(basePath,new String[]{DATABASE_DIR},"InputFile-"+currentTime+".txt");
		File outFile = createFileOnServer(basePath,new String[]{DATABASE_DIR},"OutFile-"+currentTime+".txt");	
		FileOnTemplateV fileOnTemplateV = new FileOnTemplateV();
		fileOnTemplateV.generatorFileBaseOnTemplate("dataBaseDump.vm",new String[]{"databaseName","databaseSavePath"},new Object[]{databaseName.trim(),dataBaseSavePath.trim()}, inputFile);
		
		// 拼出可以执行的命令
		//备份
//		isql -Usa -P -Sfyrs-server
//		go
//		use master  文件命令从这里开始
//		go
//		dump database FYRS TO 'D:\fyrsSpringWorkspace\2014-10-22\tools\apache-tomcat-7.0.53\backup\fyrs20141027.dmp'
//		go
		Process process = Runtime.getRuntime().exec("cmd /c isql -Usa -P  -Sfyrs-server -D"+databaseName.trim()+"  -i"+inputFile.toString()+"  -o"+outFile.toString());
		try
		{
			process.waitFor();
		} catch (InterruptedException e)
		{
			e.printStackTrace();
			return false;
		}
		List<String> lines = FileUtils.readLines(outFile);
		for(String line : lines)
		{
			if(line.contains("DUMP is complete"))
			{
				return true;
			}
		}
		//deleteFile(inputFile);
		//deleteFile(outFile);
		return false;
	}
	public static File createFileOnServer(String basepath,String[] directory,String fileName) throws IOException
	{
		StringBuilder sb = new StringBuilder();
		File file = null;
		if(null == directory)
		{
			sb.append(basepath).append(File.separator).append(fileName);
			file = new File(sb.toString());
			if(!file.exists())
			{
				file.createNewFile();
			}
			return file;
		}
		else
		{
			sb.append(basepath);
			for(int i = 0; i < directory.length; i++)
			{
				sb.append(File.separator).append(directory[i]);
			}
			file = new File(sb.toString());
			if(!file.exists())
			{
				file.mkdirs();
			}
			File newFile = new File(file,fileName);
			if(!newFile.exists())
			{
				newFile.createNewFile();
			}
			return newFile;
		}
		
	}
	
	@SuppressWarnings("unchecked")
	public boolean uploadDatabaseOnline(String basePath,String databaseName,String dataFilePath,long currentTime) throws IOException
	{
		File inputFile = createFileOnServer(basePath,new String[]{DATABASE_DIR},"onlineInputFile-"+currentTime+".txt");
		File outFile = createFileOnServer(basePath,new String[]{DATABASE_DIR},"onlineOutFile-"+currentTime+".txt");		
		FileOnTemplateV fileOnTemplateV = new FileOnTemplateV();
		fileOnTemplateV.generatorFileBaseOnTemplate("dataBaseRecover.vm",new String[]{"dataBaseName","dataBaseFilePath"},new Object[]{databaseName.trim(),dataFilePath.trim()}, inputFile);
		// 拼出可以执行的命令
		//恢复
//		isql -Usa -P -Sfyrs-server
//		go
//		use master  文件命令从这里开始
//		go
//      sp_dboption FYRS_BACKUP,"single user",true (true 开，false 关)	
//      go		
//		load database FYRS_BACKUP from 'C:\dataBaseUp-fyrs\fyrs2014-1414457470384.db'
//		go
//		online database FYRS_BACKUP
//      sp_dboption FYRS_BACKUP,"single user",false (true 开，false 关)	
//      go
//		System.out.println("-str-->"+DATABASE_EXECUTE_CMD_ONLINE_FIRST+databaseName.trim()+" from '"+dataFilePath.trim()+DATABASE_EXECUTE_CMD_ONLINE_LAST);
//		FileUtils.writeStringToFile(inputFile,DATABASE_EXECUTE_CMD_ONLINE_FIRST+databaseName.trim()+" from '"+dataFilePath.trim()+DATABASE_EXECUTE_CMD_ONLINE_LAST + databaseName.trim() + "\ngo");
		// 实际执行的命令
	    Process process = Runtime.getRuntime().exec("cmd /c isql -Usa -P  -Sfyrs-server -D"+databaseName.trim()+" -e  -i"+inputFile.toString()+"  -o"+outFile.toString());
		try
		{
			 process.waitFor();
		} catch (Exception e)
		{
			e.printStackTrace();
			return false;
		}
		
		System.out.println("command-->"+FileUtils.readFileToString(inputFile));
		List<String> lastLine = FileUtils.readLines(outFile,"UTF-8");
		
		for(String line : lastLine)
		{
			if(line.trim().equals("Database '"+databaseName+"' is now online."))
			{
				return true;
			}
		}
		if(null != inputFile && inputFile.exists())
		{
			inputFile.delete();
		}
		deleteFile(inputFile);
		deleteFile(outFile);
		return false;
	}
	private static void deleteFile(File file)
	{
		if(null != file && file.exists())
		{
			file.delete();
		}
	}
    
}
