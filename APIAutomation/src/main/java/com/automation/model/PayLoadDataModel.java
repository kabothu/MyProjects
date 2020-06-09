package com.automation.model;

public class PayLoadDataModel {
    private double altitude;

    private double latitude;

    private String name;

    private String external_id;

    private double longitude;
    
    private String id;

    public double getAltitude() {
	return altitude;
    }

    public void setAltitude(double altitude) {
	this.altitude = altitude;
    }

    public double getLatitude() {
	return latitude;
    }

    public void setLatitude(double latitude) {
	this.latitude = latitude;
    }

    public String getName() {
	return name;
    }

    public void setName(String name) {
	this.name = name;
    }

    public String getExternal_id() {
	return external_id;
    }

    public void setExternal_id(String external_id) {
	this.external_id = external_id;
    }

    public double getLongitude() {
	return longitude;
    }

    public void setLongitude(double longitude) {
	this.longitude = longitude;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

}
