package nju.software.fyrs.data.dataobject;

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * FieldId entity. @author MyEclipse Persistence Tools
 */
@Embeddable
public class FieldId implements java.io.Serializable {

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = -2648352565196123935L;
	private String CName;
	private String CTable;

	// Constructors

	/** default constructor */
	public FieldId()
	{
	}

	/** full constructor */
	public FieldId(String CName, String CTable)
	{
		this.CName = CName;
		this.CTable = CTable;
	}

	// Property accessors

	@Column(name = "C_NAME", nullable = false, length = 100)
	public String getCName()
	{
		return this.CName;
	}

	public void setCName(String CName)
	{
		this.CName = CName;
	}

	@Column(name = "C_TABLE", nullable = false, length = 50)
	public String getCTable()
	{
		return this.CTable;
	}

	public void setCTable(String CTable)
	{
		this.CTable = CTable;
	}

	public boolean equals(Object other)
	{
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof FieldId))
			return false;
		FieldId castOther = (FieldId) other;

		return ((this.getCName() == castOther.getCName()) || (this.getCName() != null && castOther.getCName() != null && this.getCName().equals(castOther.getCName())))
				&& ((this.getCTable() == castOther.getCTable()) || (this.getCTable() != null && castOther.getCTable() != null && this.getCTable().equals(castOther.getCTable())));
	}

	public int hashCode()
	{
		int result = 17;

		result = 37 * result + (getCName() == null ? 0 : this.getCName().hashCode());
		result = 37 * result + (getCTable() == null ? 0 : this.getCTable().hashCode());
		return result;
	}

}