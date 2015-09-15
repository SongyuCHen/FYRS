package nju.software.fyrs.data.dataobject;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


/**
 * RykRc entity. @author MyEclipse Persistence Tools
 * »À≤≈ø‚DO
 */
@Entity
@Table(name="T_RYK_RC")

public class RykRc  implements java.io.Serializable {


    // Fields    

     /**
	 * 
	 */
	private static final long serialVersionUID = -1341060155582265433L;
	private Integer NId;
     private Integer NFy;
     private Integer NRybh;
     private Integer NBm;
     private Integer NRclx;
     private Integer NXssx;
     private Integer NSfls;
     private String CPzwh;
     private Date DPzsj;
     private String CPzbm;
     private String CPzdw;


    // Constructors

    /** default constructor */
    public RykRc() {
    }

	/** minimal constructor */
    public RykRc(Integer NId, Integer NFy, Integer NRybh) {
        this.NId = NId;
        this.NFy = NFy;
        this.NRybh = NRybh;
    }
    
    

   
    public RykRc(Integer nId, Integer nFy, Integer nRybh, Integer nBm,
			Integer nRclx, Integer nXssx, Integer nSfls, String cPzwh,
			Date dPzsj, String cPzbm, String cPzdw) {
		super();
		NId = nId;
		NFy = nFy;
		NRybh = nRybh;
		NBm = nBm;
		NRclx = nRclx;
		NXssx = nXssx;
		NSfls = nSfls;
		CPzwh = cPzwh;
		DPzsj = dPzsj;
		CPzbm = cPzbm;
		CPzdw = cPzdw;
	}

	// Property accessors
    @Id 
    
    @Column(name="N_ID", unique=true, nullable=false)

    public Integer getNId() {
        return this.NId;
    }
    
    public void setNId(Integer NId) {
        this.NId = NId;
    }
    
    @Column(name="N_FY", nullable=false)

    public Integer getNFy() {
        return this.NFy;
    }
    
    public void setNFy(Integer NFy) {
        this.NFy = NFy;
    }
    
    @Column(name="N_RYBH", nullable=false)

    public Integer getNRybh() {
        return this.NRybh;
    }
    
    public void setNRybh(Integer NRybh) {
        this.NRybh = NRybh;
    }
    
    @Column(name="N_BM")

    public Integer getNBm() {
        return this.NBm;
    }
    
    public void setNBm(Integer NBm) {
        this.NBm = NBm;
    }
    
    @Column(name="N_RCLX")

    public Integer getNRclx() {
        return this.NRclx;
    }
    
    public void setNRclx(Integer NRclx) {
        this.NRclx = NRclx;
    }
    
    @Column(name="N_XSSX")

    public Integer getNXssx() {
        return this.NXssx;
    }
    
    public void setNXssx(Integer NXssx) {
        this.NXssx = NXssx;
    }
   
    @Column(name="N_SFLS")

    public Integer getNSfls() {
        return this.NSfls;
    }
    
    public void setNSfls(Integer NSfls) {
        this.NSfls = NSfls;
    }

    @Column(name="C_PZWH")
	public String getCPzwh() {
		return CPzwh;
	}

	public void setCPzwh(String cPzwh) {
		CPzwh = cPzwh;
	}

	@Column(name="D_PZSJ")
	public Date getDPzsj() {
		return DPzsj;
	}

	public void setDPzsj(Date dPzsj) {
		DPzsj = dPzsj;
	}

	@Column(name="C_PZBM")
	public String getCPzbm() {
		return CPzbm;
	}

	public void setCPzbm(String cPzbm) {
		CPzbm = cPzbm;
	}

	@Column(name="C_PZDW")
	public String getCPzdw() {
		return CPzdw;
	}

	public void setCPzdw(String cPzdw) {
		CPzdw = cPzdw;
	}







}