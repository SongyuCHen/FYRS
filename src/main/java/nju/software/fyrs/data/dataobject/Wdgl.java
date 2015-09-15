package nju.software.fyrs.data.dataobject;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "T_WDGL")
public class Wdgl implements java.io.Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 6577200448621982325L;
	/**
	 * �ĵ����
	 */
	private Integer wdbh;
	/**
	 * ���ĺ�
	 */
	private String fwh;
	/**
	 * ����
	 */
	private String bt;
	/**
	 * �ĵ�����
	 */
	private String wdms;
	/**
	 * �ĵ�����
	 */
	private String wdnr;
	/**
	 * �ĵ�·��
	 */
	private String wdlj;
	/**
	 * �ĵ�ԭ�ļ���
	 */
	private String wdywjm;
	/**
	 * �û�id
	 */
	private Integer userid;
	/**
	 * ����ʱ��
	 */
	private Date fwsj;
	/**
	 * ����޸�ʱ��
	 */
	private Date zjxgsj;

	@Id
	@GeneratedValue(generator = "ud")
	@GenericGenerator(name = "ud", strategy = "increment")
	@Column(name = "WDBH", unique = true, nullable = false)
	public Integer getWdbh()
	{
		return this.wdbh;
	}

	public void setWdbh(Integer wdbh)
	{
		this.wdbh = wdbh;
	}

	@Column(name = "FWH", nullable = false)
	public String getFwh()
	{
		return fwh;
	}

	public void setFwh(String fwh)
	{
		this.fwh = fwh;
	}

	@Column(name = "BT", nullable = false)
	public String getBt()
	{
		return bt;
	}

	public void setBt(String bt)
	{
		this.bt = bt;
	}

	@Column(name = "WDMS", nullable = true)
	public String getWdms()
	{
		return wdms;
	}

	public void setWdms(String wdms)
	{
		this.wdms = wdms;
	}

	@Column(name = "WDNR", nullable = false)
	public String getWdnr()
	{
		return wdnr;
	}

	public void setWdnr(String wdnr)
	{
		this.wdnr = wdnr;
	}

	@Column(name = "WDLJ", nullable = true)
	public String getWdlj()
	{
		return wdlj;
	}

	public void setWdlj(String wdlj)
	{
		this.wdlj = wdlj;
	}

	@Column(name = "USERID", nullable = false)
	public Integer getUserid()
	{
		return userid;
	}

	public void setUserid(Integer userid)
	{
		this.userid = userid;
	}
	@Column(name = "FWSJ", nullable = false)
	public Date getFwsj()
	{
		return fwsj;
	}

	public void setFwsj(Date fwsj)
	{
		this.fwsj = fwsj;
	}

	@Column(name = "ZJXGSJ", nullable = false)
	public Date getZjxgsj()
	{
		return zjxgsj;
	}

	public void setZjxgsj(Date zjxgsj)
	{
		this.zjxgsj = zjxgsj;
	}

	@Column(name = "WDYWJM", nullable = true)
	public String getWdywjm()
	{
		return wdywjm;
	}

	public void setWdywjm(String wdywjm)
	{
		this.wdywjm = wdywjm;
	}
}
