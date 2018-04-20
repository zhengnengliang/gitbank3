package com.bdqn.pojo;

public class ItripTradeEnds {
    private Long id;

    private String orderno;

    private Boolean flag;

    public ItripTradeEnds() {
		// TODO Auto-generated constructor stub
	}
    
    public ItripTradeEnds(Long id, String orderno, Boolean flag) {
    	this.id=id;
    	this.orderno=orderno;
    	this.flag=flag;
    }

	public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getOrderno() {
        return orderno;
    }

    public void setOrderno(String orderno) {
        this.orderno = orderno == null ? null : orderno.trim();
    }

    public Boolean getFlag() {
        return flag;
    }

    public void setFlag(Boolean flag) {
        this.flag = flag;
    }
}