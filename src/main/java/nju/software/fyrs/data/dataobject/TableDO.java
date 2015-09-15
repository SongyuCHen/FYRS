package nju.software.fyrs.data.dataobject;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Table entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "T_TABLE")
public class TableDO implements java.io.Serializable {

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = -3347719845597666960L;
	private String CName;
	private String CCnname;

	// Constructors

	/** default constructor */
	public TableDO()
	{
	}

	/** full constructor */
	public TableDO(String CName, String CCnname)
	{
		this.CName = CName;
		this.CCnname = CCnname;
	}

	// Property accessors
	@Id
	@Column(name = "C_NAME", unique = true, nullable = false, length = 50)
	public String getCName()
	{
		return this.CName;
	}

	public void setCName(String CName)
	{
		this.CName = CName;
	}

	@Column(name = "C_CNNAME", nullable = false, length = 100)
	public String getCCnname()
	{
		return this.CCnname;
	}

	public void setCCnname(String CCnname)
	{
		this.CCnname = CCnname;
	}

}