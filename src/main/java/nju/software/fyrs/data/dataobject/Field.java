package nju.software.fyrs.data.dataobject;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

/**
 * Field entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "T_FIELD")
@IdClass(FieldId.class)
public class Field implements java.io.Serializable {

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = 7573758742733023975L;
	private String CName;
	private String CTable;
	private Short NOrder;
	private String CCnname;
	private String CValuedesc;
	private String CConstranintsdesc;
	private String CType;
	private Short NIstrans;
	private Short NValidate;
	private Integer NSfxs;
	private Integer NSfbt;

	// Constructors

	/** default constructor */
	public Field()
	{
	}

	/** full constructor */
	public Field(String cName, String cTable, Short nOrder, String cCnname, String cValuedesc, String cConstranintsdesc, String cType, Short nIstrans, Short nValidate, Integer nSfxs, Integer nSfbt)
	{
		super();
		CName = cName;
		CTable = cTable;
		NOrder = nOrder;
		CCnname = cCnname;
		CValuedesc = cValuedesc;
		CConstranintsdesc = cConstranintsdesc;
		CType = cType;
		NIstrans = nIstrans;
		NValidate = nValidate;
		NSfxs = nSfxs;
		NSfbt = nSfbt;
	}

	// Property accessors
	@Id
	@Column(name = "C_NAME", nullable = false, length = 100)
	public String getCName()
	{
		return this.CName;
	}

	public void setCName(String CName)
	{
		this.CName = CName;
	}

	@Id
	@Column(name = "C_TABLE", nullable = false, length = 50)
	public String getCTable()
	{
		return this.CTable;
	}

	public void setCTable(String CTable)
	{
		this.CTable = CTable;
	}

	@Column(name = "N_ORDER", nullable = false)
	public Short getNOrder()
	{
		return this.NOrder;
	}

	public void setNOrder(Short NOrder)
	{
		this.NOrder = NOrder;
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

	@Column(name = "C_VALUEDESC", length = 200)
	public String getCValuedesc()
	{
		return this.CValuedesc;
	}

	public void setCValuedesc(String CValuedesc)
	{
		this.CValuedesc = CValuedesc;
	}

	@Column(name = "C_CONSTRANINTSDESC", length = 200)
	public String getCConstranintsdesc()
	{
		return this.CConstranintsdesc;
	}

	public void setCConstranintsdesc(String CConstranintsdesc)
	{
		this.CConstranintsdesc = CConstranintsdesc;
	}

	@Column(name = "C_TYPE", length = 20)
	public String getCType()
	{
		return this.CType;
	}

	public void setCType(String CType)
	{
		this.CType = CType;
	}

	@Column(name = "N_ISTRANS")
	public Short getNIstrans()
	{
		return this.NIstrans;
	}

	public void setNIstrans(Short NIstrans)
	{
		this.NIstrans = NIstrans;
	}

	@Column(name = "N_VALIDATE")
	public Short getNValidate()
	{
		return this.NValidate;
	}

	public void setNValidate(Short NValidate)
	{
		this.NValidate = NValidate;
	}

	@Column(name = "N_SFXS")
	public Integer getNSfxs()
	{
		return this.NSfxs;
	}

	public void setNSfxs(Integer NSfxs)
	{
		this.NSfxs = NSfxs;
	}

	@Column(name = "N_SFBT")
	public Integer getNSfbt()
	{
		return this.NSfbt;
	}

	public void setNSfbt(Integer NSfbt)
	{
		this.NSfbt = NSfbt;
	}

}
