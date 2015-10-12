package nju.software.fyrs.biz.vo;

public class JgxxVO {
	private Integer NCode;
	private Short NLevel;
	private String CName;

	public Integer getNCode() {
		return NCode;
	}

	public void setNCode(Integer nCode) {
		NCode = nCode;
	}

	public String getCName() {
		return CName;
	}

	public void setCName(String cName) {
		CName = cName;
	}

	public Short getNLevel() {
		return NLevel;
	}

	public void setNLevel(Short nLevel) {
		NLevel = nLevel;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((CName == null) ? 0 : CName.hashCode());
		result = prime * result + ((NCode == null) ? 0 : NCode.hashCode());
		result = prime * result + ((NLevel == null) ? 0 : NLevel.hashCode());
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
		JgxxVO other = (JgxxVO) obj;
		if (CName == null) {
			if (other.CName != null)
				return false;
		} else if (!CName.equals(other.CName))
			return false;
		if (NCode == null) {
			if (other.NCode != null)
				return false;
		} else if (!NCode.equals(other.NCode))
			return false;
		if (NLevel == null) {
			if (other.NLevel != null)
				return false;
		} else if (!NLevel.equals(other.NLevel))
			return false;
		return true;
	}

	
	

}
