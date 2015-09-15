package nju.software.fyrs.data.dataobject;
// default package

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


/**
 * RysxXzzwBzbh entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name="T_RYSX_XZZW_BZBH")

public class RysxXzzwBzbh  implements java.io.Serializable {


    // Fields    

     private Integer NId;
     private Integer NBhid;
     private Integer NXzzw;
     private Integer NZbs;
     private Integer NJbs;
     private Integer NKbs;


    // Constructors

    /** default constructor */
    public RysxXzzwBzbh() {
    }

	/** minimal constructor */
    public RysxXzzwBzbh(Integer NId) {
        this.NId = NId;
    }
    
    /** full constructor */
    public RysxXzzwBzbh(Integer NId, Integer NBhid, Integer NXzzw, Integer NZbs, Integer NJbs, Integer NKbs) {
        this.NId = NId;
        this.NBhid = NBhid;
        this.NXzzw = NXzzw;
        this.NZbs = NZbs;
        this.NJbs = NJbs;
        this.NKbs = NKbs;
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
    
    @Column(name="N_BHID")

    public Integer getNBhid() {
        return this.NBhid;
    }
    
    public void setNBhid(Integer NBhid) {
        this.NBhid = NBhid;
    }
    
    @Column(name="N_XZZW")

    public Integer getNXzzw() {
        return this.NXzzw;
    }
    
    public void setNXzzw(Integer NXzzw) {
        this.NXzzw = NXzzw;
    }
    
    @Column(name="N_ZBS")

    public Integer getNZbs() {
        return this.NZbs;
    }
    
    public void setNZbs(Integer NZbs) {
        this.NZbs = NZbs;
    }
    
    @Column(name="N_JBS")

    public Integer getNJbs() {
        return this.NJbs;
    }
    
    public void setNJbs(Integer NJbs) {
        this.NJbs = NJbs;
    }
    
    @Column(name="N_KBS")

    public Integer getNKbs() {
        return this.NKbs;
    }
    
    public void setNKbs(Integer NKbs) {
        this.NKbs = NKbs;
    }
   








}