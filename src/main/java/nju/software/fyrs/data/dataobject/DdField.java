package nju.software.fyrs.data.dataobject;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * DdField entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "T_DD_FIELD")
public class DdField implements java.io.Serializable {

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = 3719476614772076875L;
	private String CId;
	private String CTableid;
	private String CFieldname;
	private String CCnname;
	private short NDatatype;
	private short BKey;
	private short NLength;
	private String CPrecision;
	private short BCannull;
	private short NLogictype;
	private short NMaincode;
	private short BQcondition;
	private short BQresult;
	private short BUserdefined;
	private short NOrder;

	// Constructors

	/** default constructor */
	public DdField()
	{
	}

	/** full constructor */
	public DdField(String CId, String CTableid, String CFieldname, String CCnname, short NDatatype, short BKey, short NLength, String CPrecision, short BCannull, short NLogictype, short NMaincode,
			short BQcondition, short BQresult, short BUserdefined, short NOrder)
	{
		this.CId = CId;
		this.CTableid = CTableid;
		this.CFieldname = CFieldname;
		this.CCnname = CCnname;
		this.NDatatype = NDatatype;
		this.BKey = BKey;
		this.NLength = NLength;
		this.CPrecision = CPrecision;
		this.BCannull = BCannull;
		this.NLogictype = NLogictype;
		this.NMaincode = NMaincode;
		this.BQcondition = BQcondition;
		this.BQresult = BQresult;
		this.BUserdefined = BUserdefined;
		this.NOrder = NOrder;
	}

	// Property accessors
	@Id
	@Column(name = "C_ID", unique = true, nullable = false, length = 50)
	public String getCId()
	{
		return this.CId;
	}

	public void setCId(String CId)
	{
		this.CId = CId;
	}

	@Column(name = "C_TABLEID", nullable = false, length = 50)
	public String getCTableid()
	{
		return this.CTableid;
	}

	public void setCTableid(String CTableid)
	{
		this.CTableid = CTableid;
	}

	@Column(name = "C_FIELDNAME", nullable = false, length = 50)
	public String getCFieldname()
	{
		return this.CFieldname;
	}

	public void setCFieldname(String CFieldname)
	{
		this.CFieldname = CFieldname;
	}

	@Column(name = "C_CNNAME", nullable = false, length = 50)
	public String getCCnname()
	{
		return this.CCnname;
	}

	public void setCCnname(String CCnname)
	{
		this.CCnname = CCnname;
	}

	@Column(name = "N_DATATYPE", nullable = false)
	public short getNDatatype()
	{
		return this.NDatatype;
	}

	public void setNDatatype(short NDatatype)
	{
		this.NDatatype = NDatatype;
	}

	@Column(name = "B_KEY", nullable = false)
	public short getBKey()
	{
		return this.BKey;
	}

	public void setBKey(short BKey)
	{
		this.BKey = BKey;
	}

	@Column(name = "N_LENGTH", nullable = false)
	public short getNLength()
	{
		return this.NLength;
	}

	public void setNLength(short NLength)
	{
		this.NLength = NLength;
	}

	@Column(name = "C_PRECISION", nullable = false, length = 50)
	public String getCPrecision()
	{
		return this.CPrecision;
	}

	public void setCPrecision(String CPrecision)
	{
		this.CPrecision = CPrecision;
	}

	@Column(name = "B_CANNULL", nullable = false)
	public short getBCannull()
	{
		return this.BCannull;
	}

	public void setBCannull(short BCannull)
	{
		this.BCannull = BCannull;
	}

	@Column(name = "N_LOGICTYPE", nullable = false)
	public short getNLogictype()
	{
		return this.NLogictype;
	}

	public void setNLogictype(short NLogictype)
	{
		this.NLogictype = NLogictype;
	}

	@Column(name = "N_MAINCODE", nullable = false)
	public short getNMaincode()
	{
		return this.NMaincode;
	}

	public void setNMaincode(short NMaincode)
	{
		this.NMaincode = NMaincode;
	}

	@Column(name = "B_QCONDITION", nullable = false)
	public short getBQcondition()
	{
		return this.BQcondition;
	}

	public void setBQcondition(short BQcondition)
	{
		this.BQcondition = BQcondition;
	}

	@Column(name = "B_QRESULT", nullable = false)
	public short getBQresult()
	{
		return this.BQresult;
	}

	public void setBQresult(short BQresult)
	{
		this.BQresult = BQresult;
	}

	@Column(name = "B_USERDEFINED", nullable = false)
	public short getBUserdefined()
	{
		return this.BUserdefined;
	}

	public void setBUserdefined(short BUserdefined)
	{
		this.BUserdefined = BUserdefined;
	}

	@Column(name = "N_ORDER", nullable = false)
	public short getNOrder()
	{
		return this.NOrder;
	}

	public void setNOrder(short NOrder)
	{
		this.NOrder = NOrder;
	}

}