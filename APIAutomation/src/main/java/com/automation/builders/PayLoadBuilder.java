package com.automation.builders;

public class PayLoadBuilder {

    private String external_id;
    private String name;
    private double latitude;
    private double longitude;
    private double altitude;

    private PayLoadBuilder(Builder builder) {
	this.external_id = builder.externalId;
	this.name = builder.name;
	this.latitude = builder.latitude;
	this.longitude = builder.longitude;
	this.altitude = builder.altitude;

    }

    public static class Builder {

	private String externalId;
	private String name;
	private double latitude;
	private double longitude;
	private double altitude;

	public Builder() {

	}

	public Builder externalId(String externalId) {
	    this.externalId = externalId;
	    return this;
	}

	public Builder name(String name) {
	    this.name = name;
	    return this;
	}

	public Builder latitude(double latitude) {
	    this.latitude = latitude;
	    return this;
	}

	public Builder longitude(double longitude) {
	    this.longitude = longitude;
	    return this;
	}

	public Builder altitude(double altitude) {
	    this.altitude = altitude;
	    return this;
	}

	public PayLoadBuilder build() {
	    return new PayLoadBuilder(this);
	}

    }

}
