package nju.software.fyrs.util;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Properties;

import org.apache.velocity.Template;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.VelocityEngine;

public class FileOnTemplateV
{
	private VelocityEngine velocityEngine = null;
	private Properties properties = null;
	private VelocityContext context = null;
	@SuppressWarnings("static-access")
	public FileOnTemplateV()
	{
	    velocityEngine = new VelocityEngine();
	    properties = new java.util.Properties();
		properties.setProperty(velocityEngine.FILE_RESOURCE_LOADER_PATH,this.getClass().getResource("/").getPath());
		try
		{
			velocityEngine.init(properties);
		} catch (Exception e)
		{
			
			e.printStackTrace();
		}
	    context = new VelocityContext();

		
	}
	public void generatorFileBaseOnTemplate(String templateFileName,String[] name,Object[] value,File output)
	{
		FileWriter fileWriter = null;
 		try
		{
			Template template = velocityEngine.getTemplate(templateFileName,"UTF-8");	
			for(int i = 0; i < name.length;i++)
			{
				context.put(name[i],value[i]);
			}
			fileWriter = new FileWriter(output);
			fileWriter.flush();
			template.merge(context, fileWriter);
		} catch (Exception e)
		{
			
			e.printStackTrace();
		} 
		finally
		{
			if(fileWriter != null)
			{
				try
				{
					fileWriter.close();
				} catch (IOException e)
				{
					
					e.printStackTrace();
				}
			}
		}
	}
	
}
