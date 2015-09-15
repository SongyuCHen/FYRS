package nju.software.fyrs.service.model;

public class RyviewJsonModel {
	RyviewModel[] ryviewArray;

	/**
	 * 
	 */
	public RyviewJsonModel() {
		super();
	}

	/**
	 * @param ryviewArray
	 */
	public RyviewJsonModel(RyviewModel[] ryviewArray) {
		super();
		this.ryviewArray = ryviewArray;
	}

	public RyviewModel[] getRyviewArray() {
		return ryviewArray;
	}

	public void setRyviewArray(RyviewModel[] ryviewArray) {
		this.ryviewArray = ryviewArray;
	}
	
}
