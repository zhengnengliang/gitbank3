package entity;

import java.util.Date;

public class Comments {
	  private int cID;
	  private int cNID;
	  private String cContent ;
	  private  Date cDate;
	  private String cIp;
	  private String  cAuthor;
	  public int getcID() {
		return cID;
	}
	public void setcID(int cID) {
		this.cID = cID;
	}
	public int getcNID() {
		return cNID;
	}
	public void setcNID(int cNID) {
		this.cNID = cNID;
	}
	public String getcContent() {
		return cContent;
	}
	public void setcContent(String cContent) {
		this.cContent = cContent;
	}
	public Date getcDate() {
		return cDate;
	}
	public void setcDate(Date cDate) {
		this.cDate = cDate;
	}
	public String getcIp() {
		return cIp;
	}
	public void setcIp(String cIp) {
		this.cIp = cIp;
	}
	public String getcAuthor() {
		return cAuthor;
	}
	public void setcAuthor(String cAuthor) {
		this.cAuthor = cAuthor;
	}
	
 
  
}
