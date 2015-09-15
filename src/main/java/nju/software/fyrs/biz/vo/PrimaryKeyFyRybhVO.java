package nju.software.fyrs.biz.vo;

public class PrimaryKeyFyRybhVO {
	private Integer NFy;
    private Integer NRybh;
	public Integer getNFy() {
		return NFy;
	}
	public void setNFy(Integer nFy) {
		NFy = nFy;
	}
	public Integer getNRybh() {
		return NRybh;
	}
	public void setNRybh(Integer nRybh) {
		NRybh = nRybh;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((NFy == null) ? 0 : NFy.hashCode());
		result = prime * result + ((NRybh == null) ? 0 : NRybh.hashCode());
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
		PrimaryKeyFyRybhVO other = (PrimaryKeyFyRybhVO) obj;
		if (NFy == null) {
			if (other.NFy != null)
				return false;
		} else if (!NFy.equals(other.NFy))
			return false;
		if (NRybh == null) {
			if (other.NRybh != null)
				return false;
		} else if (!NRybh.equals(other.NRybh))
			return false;
		return true;
	}
    
}
