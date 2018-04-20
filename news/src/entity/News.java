package entity;


import java.util.Date;

public class News {
	private int nID;
	private int nTID;
	private String nTitle;
	private String nAuthor;
	private Date nCreatedate ;
	private String nPicpath ;
	private String nContent ;
	private Date nModifydate ;
	private String nSummary  ;
	public int getnID() {
		return nID;
	}
	public void setnID(int nID) {
		this.nID = nID;
	}
	public int getnTID() {
		return nTID;
	}
	public void setnTID(int nTID) {
		this.nTID = nTID;
	}
	public String getnTitle() {
		return nTitle;
	}
	public void setnTitle(String nTitle) {
		this.nTitle = nTitle;
	}
	public String getnAuthor() {
		return nAuthor;
	}
	public void setnAuthor(String nAuthor) {
		this.nAuthor = nAuthor;
	}
	public Date getnCreatedate() {
		return nCreatedate;
	}
	public void setnCreatedate(Date nCreatedate) {
		this.nCreatedate = nCreatedate;
	}
	public String getnPicpath() {
		return nPicpath;
	}
	public void setnPicpath(String nPicpath) {
		this.nPicpath = nPicpath;
	}
	public String getnContent() {
		return nContent;
	}
	public void setnContent(String nContent) {
		this.nContent = nContent;
	}
	public Date getnModifydate() {
		return nModifydate;
	}
	public void setnModifydate(Date nModifydate) {
		this.nModifydate = nModifydate;
	}
	public String getnSummary() {
		return nSummary;
	}
	public void setnSummary(String nSummary) {
		this.nSummary = nSummary;
	}

	
	
}
