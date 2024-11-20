package com.sra.domain.valueobject;

public class Address {
    private String street;
    private String city;
    private String postalCode;
    private String country;
    private double latitude;
    private double longitude;

    private Address(Builder builder) {
        street = builder.street;
        city = builder.city;
        postalCode = builder.postalCode;
        country = builder.country;
        latitude = builder.latitude;
        longitude = builder.longitude;
    }

    public static final class Builder {
        private String street;
        private String city;
        private String postalCode;
        private String country;
        private double latitude;
        private double longitude;

        public Builder() {
        }

        public Builder street(String val) {
            street = val;
            return this;
        }

        public Builder city(String val) {
            city = val;
            return this;
        }

        public Builder postalCode(String val) {
            postalCode = val;
            return this;
        }

        public Builder country(String val) {
            country = val;
            return this;
        }

        public Builder latitude(double val) {
            latitude = val;
            return this;
        }

        public Builder longitude(double val) {
            longitude = val;
            return this;
        }

        public Address build() {
            return new Address(this);
        }
    }
}
