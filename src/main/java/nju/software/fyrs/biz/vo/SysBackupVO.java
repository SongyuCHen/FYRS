package nju.software.fyrs.biz.vo;


public class SysBackupVO {
	private String NId;
	private String NBacktype;
	private String DBacktime;
	private String CFilename;
	private String CPath;
	public String getNId()
	{
		return NId;
	}
	public void setNId(String nId)
	{
		NId = nId;
	}
	public String getNBacktype()
	{
		return NBacktype;
	}
	public void setNBacktype(String nBacktype)
	{
		NBacktype = nBacktype;
	}
	public String getDBacktime()
	{
		return DBacktime;
	}
	public void setDBacktime(String dBacktime)
	{
		DBacktime = dBacktime;
	}
	public String getCFilename()
	{
		return CFilename;
	}
	public void setCFilename(String cFilename)
	{
		CFilename = cFilename;
	}
	public String getCPath()
	{
		return CPath;
	}
	public void setCPath(String cPath)
	{
		CPath = cPath;
	}
}
