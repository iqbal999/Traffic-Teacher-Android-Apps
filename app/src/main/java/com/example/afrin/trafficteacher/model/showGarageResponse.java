package com.example.afrin.trafficteacher.model;

public class showGarageResponse {
    private String garage_name;
    private String contact;
    private String address;

    public showGarageResponse(String garage_name, String contact, String address) {
        this.garage_name = garage_name;
        this.contact = contact;
        this.address = address;
    }

    public String getGarage_name() {
        return garage_name;
    }

    public String getContact() {
        return contact;
    }

    public String getAddress() {
        return address;
    }
}
