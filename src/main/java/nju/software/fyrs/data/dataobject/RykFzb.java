package nju.software.fyrs.data.dataobject;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


/**
 * RykFzb entity. @author MyEclipse Persistence Tools
 * 非在编人员库DO
 */
@Entity
@Table(name="T_RYK_FZB")

public class RykFzb  implements java.io.Serializable {


    // Fields    

     /**
	 * 
	 */
	private static final long serialVersionUID = 1557463479524974435L;
	private Integer NId;
     private Integer NFy;
     private Integer NRybh;
     private Integer NBm;
     private Integer NFzblx;
     private Integer NXssx;
     private Integer NSfls;


    // Constructors

    /** default constructor */
    public RykFzb() {
    }

	/** minimal constructor */
    public RykFzb(Integer NId, Integer NFy, Integer NRybh) {
        this.NId = NId;
        this.NFy = NFy;
        this.NRybh = NRybh;
    }
    
    /** full constructor */
    public RykFzb(Integer NId, Integer NFy, Integer NRybh, Integer NBm, Integer NFzblx, Integer NXssx, Integer NSfls) {
        this.NId = NId;
        this.NFy = NFy;
        this.NRybh = NRybh;
        this.NBm = NBm;
        this.NFzblx = NFzblx;
        this.NXssx = NXssx;
        this.NSfls = NSfls;
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
    
    @Column(name="N_FZBLX")

    public Integer getNFzblx() {
        return this.NFzblx;
    }
    
    public void setNFzblx(Integer NFzblx) {
        this.NFzblx = NFzblx;
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







}