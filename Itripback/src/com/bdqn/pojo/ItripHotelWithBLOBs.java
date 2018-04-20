package com.bdqn.pojo;

public class ItripHotelWithBLOBs extends ItripHotel {
    private String details;

    private String facilities;

    private String hotelpolicy;

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details == null ? null : details.trim();
    }

    public String getFacilities() {
        return facilities;
    }

    public void setFacilities(String facilities) {
        this.facilities = facilities == null ? null : facilities.trim();
    }

    public String getHotelpolicy() {
        return hotelpolicy;
    }

    public void setHotelpolicy(String hotelpolicy) {
        this.hotelpolicy = hotelpolicy == null ? null : hotelpolicy.trim();
    }
}