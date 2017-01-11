package com.pens.kgf.testfunction;

public class Model {

	private String iterasix, xbawah, xatas, nilaix, nilaifx;
	
	private boolean isGroupHeader = false;
	
	public Model(String xbawah) {
		this(null,xbawah,null,null,null);
		isGroupHeader = true;
	}
	public Model(String iterasix, String xbawah, String xatas, String nilaix, String nilaifx) {
		super();
		this.iterasix = iterasix;
		this.xbawah = xbawah;
		this.xatas = xatas;
		this.nilaix = nilaix;
		this.nilaifx = nilaifx;
	}
	public String getIcon() {
		return iterasix;
	}
	public void setIcon(String iterasix) {
		this.iterasix = iterasix;
	}
	public String getTitle() {
		return xbawah;
	}
	public void setTitle(String xbawah) {
		this.xbawah = xbawah;
	}
	public String getCounter() {
		return xatas;
	}
	public void setCounter(String xatas) {
		this.xatas = xatas;
	}
	public String getNilaix() {
		return nilaix;
	}
	public void setNilaix(String nilaix) {
		this.nilaix = nilaix;
	}
	public String getNilaifx() {
		return nilaifx;
	}
	public void setNilaifx(String nilaifx) {
		this.nilaifx = nilaifx;
	}
	public boolean isGroupHeader() {
		return isGroupHeader;
	}
	public void setGroupHeader(boolean isGroupHeader) {
		this.isGroupHeader = isGroupHeader;
	}
	
	
	
}
