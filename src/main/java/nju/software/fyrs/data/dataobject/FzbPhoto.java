package nju.software.fyrs.data.dataobject;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

/**
 * RysxPhoto entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "T_FZB_PHOTO")
@IdClass(FzbPhotoId.class)
public class FzbPhoto implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6320639809609349133L;
	// Fields
	private Integer NFy;
	private Integer NRybh;
	private byte[] IPhoto;

	// Constructors

	/** default constructor */
	public FzbPhoto()
	{
	}

	/**
	 * @param nId
	 * @param nFy
	 * @param nRybh
	 * @param iPhoto
	 */
	public FzbPhoto(Integer nFy, Integer nRybh, byte[] iPhoto)
	{
		super();
		NFy = nFy;
		NRybh = nRybh;
		IPhoto = iPhoto;
	}
	@Id
	@Column(name = "N_FY", nullable = false)
	public Integer getNFy()
	{
		return this.NFy;
	}

	public void setNFy(Integer NFy)
	{
		this.NFy = NFy;
	}

	@Id
	@Column(name = "N_RYBH", nullable = false)
	public Integer getNRybh()
	{
		return this.NRybh;
	}

	public void setNRybh(Integer NRybh)
	{
		this.NRybh = NRybh;
	}

	@Column(name = "I_PHOTO")
	public byte[] getIPhoto()
	{
		return this.IPhoto;
	}

	public void setIPhoto(byte[] IPhoto)
	{
		this.IPhoto = IPhoto;
	}

}