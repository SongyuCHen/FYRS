package nju.software.fyrs.service.model;

import java.io.Serializable;


/**
 * 
 * 代码的领域模型
 */
public class DmbModel implements Serializable{
	
	private static final long serialVersionUID = 6340894809001349965L;

	/**
	 * 类别编号
	 */
	private String lbbh;
	/**
	 * 代码编号
	 */
	private String dmbh;
	/**
	 * 代码描述
	 */
	private String dmms;
	/**
	 * 相关代码
	 */
	private String xgdm;
	/**
	 * 备注
	 */
	private String bz;
	/**
	 * 修改标识
	 */
	private String modflag;
	/**
	 * 转换标识？
	 */
	private String transflag;
	
	public DmbModel(String lbbh, String dmbh, String dmms, String xgdm,
			String bz, String modflag, String transflag) {
		super();
		this.lbbh = lbbh;
		this.dmbh = dmbh;
		this.dmms = dmms;
		this.xgdm = xgdm;
		this.bz = bz;
		this.modflag = modflag;
		this.transflag = transflag;
	}
	
	public DmbModel(){}
	
	public String getLbbh() {
		return lbbh;
	}
	public void setLbbh(String lbbh) {
		this.lbbh = lbbh;
	}
	public String getDmbh() {
		return dmbh;
	}
	public void setDmbh(String dmbh) {
		this.dmbh = dmbh;
	}
	public String getDmms() {
		return dmms;
	}
	public void setDmms(String dmms) {
		this.dmms = dmms;
	}
	public String getXgdm() {
		return xgdm;
	}
	public void setXgdm(String xgdm) {
		this.xgdm = xgdm;
	}
	public String getBz() {
		return bz;
	}
	public void setBz(String bz) {
		this.bz = bz;
	}
	public String getModflag() {
		return modflag;
	}
	public void setModflag(String modflag) {
		this.modflag = modflag;
	}
	public String getTransflag() {
		return transflag;
	}
	public void setTransflag(String transflag) {
		this.transflag = transflag;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((bz == null) ? 0 : bz.hashCode());
		result = prime * result + ((dmbh == null) ? 0 : dmbh.hashCode());
		result = prime * result + ((dmms == null) ? 0 : dmms.hashCode());
		result = prime * result + ((lbbh == null) ? 0 : lbbh.hashCode());
		result = prime * result + ((modflag == null) ? 0 : modflag.hashCode());
		result = prime * result
				+ ((transflag == null) ? 0 : transflag.hashCode());
		result = prime * result + ((xgdm == null) ? 0 : xgdm.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		DmbModel other = (DmbModel) obj;
		if (bz == null) {
			if (other.bz != null)
				return false;
		} else if (!bz.equals(other.bz))
			return false;
		if (dmbh == null) {
			if (other.dmbh != null)
				return false;
		} else if (!dmbh.equals(other.dmbh))
			return false;
		if (dmms == null) {
			if (other.dmms != null)
				return false;
		} else if (!dmms.equals(other.dmms))
			return false;
		if (lbbh == null) {
			if (other.lbbh != null)
				return false;
		} else if (!lbbh.equals(other.lbbh))
			return false;
		if (modflag == null) {
			if (other.modflag != null)
				return false;
		} else if (!modflag.equals(other.modflag))
			return false;
		if (transflag == null) {
			if (other.transflag != null)
				return false;
		} else if (!transflag.equals(other.transflag))
			return false;
		if (xgdm == null) {
			if (other.xgdm != null)
				return false;
		} else if (!xgdm.equals(other.xgdm))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "DmModel [lbbh=" + lbbh + ", dmbh=" + dmbh + ", dmms=" + dmms
				+ ", xgdm=" + xgdm + ", bz=" + bz + ", modflag=" + modflag
				+ ", transflag=" + transflag + "]";
	}

}

