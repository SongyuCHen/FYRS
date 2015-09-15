package nju.software.fyrs.data.dataobject;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * DdTable entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "T_DD_TABLE")
public class DdTable implements java.io.Serializable {
	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = 293255183263361819L;
	private String CId;
	private String CTablename;
	private String CCnname;
	private short BRoottable;
	private short BUserdefined;
	private short NOrder;

	// Constructors

	/** default constructor */
	public DdTable()
	{
	}

	/** full constructor */
	public DdTable(String CId, String CTablename, String CCnname, short BRoottable, short BUserdefined, short NOrder)
	{
		this.CId = CId;
		this.CTablename = CTablename;
		this.CCnname = CCnname;
		this.BRoottable = BRoottable;
		this.BUserdefined = BUserdefined;
		this.NOrder = NOrder;
	}

	// Property accessors
	@Id
	@Column(name = "c_id", unique = true, nullable = false, length = 50)
	public String getCId()
	{
		return this.CId;
	}

	public void setCId(String CId)
	{
		this.CId = CId;
	}

	@Column(name = "c_tablename", nullable = false, length = 50)
	public String getCTablename()
	{
		return this.CTablename;
	}

	public void setCTablename(String CTablename)
	{
		this.CTablename = CTablename;
	}

	@Column(name = "c_cnname", nullable = false, length = 50)
	public String getCCnname()
	{
		return this.CCnname;
	}

	public void setCCnname(String CCnname)
	{
		this.CCnname = CCnname;
	}

	@Column(name = "b_roottable", nullable = false)
	public short getBRoottable()
	{
		return this.BRoottable;
	}

	public void setBRoottable(short BRoottable)
	{
		this.BRoottable = BRoottable;
	}

	@Column(name = "b_userdefined", nullable = false)
	public short getBUserdefined()
	{
		return this.BUserdefined;
	}

	public void setBUserdefined(short BUserdefined)
	{
		this.BUserdefined = BUserdefined;
	}

	@Column(name = "n_order", nullable = false)
	public short getNOrder()
	{
		return this.NOrder;
	}

	public void setNOrder(short NOrder)
	{
		this.NOrder = NOrder;
	}

}