package com.example.afrin.trafficteacher.model;

public class showRouteResponse {
    private String route_name;
    private String route_desc;

    public showRouteResponse(String route_name, String route_desc) {
        this.route_name = route_name;
        this.route_desc = route_desc;
    }

    public String getRoute_name() {
        return route_name;
    }

    public String getRoute_desc() {
        return route_desc;
    }
}
