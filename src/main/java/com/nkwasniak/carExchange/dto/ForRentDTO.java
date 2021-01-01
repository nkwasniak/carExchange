package com.nkwasniak.carExchange.dto;

public class ForRentDTO {
    private Long adId;
    private String model;
    private String make;
    private Long distance;
    private Long cautionMonths;
    private Long monthlyRent;
    private String currencyMonthlyRent;
    private String description;
    private UserDTO userDTO;

    public ForRentDTO(Long adId, String model, String make, Long distance, Long cautionMonths,
                      Long monthlyRent, String currencyMonthlyRent, String description, UserDTO userDTO) {
        this.adId = adId;
        this.model = model;
        this.make = make;
        this.distance = distance;
        this.cautionMonths = cautionMonths;
        this.monthlyRent = monthlyRent;
        this.currencyMonthlyRent = currencyMonthlyRent;
        this.description = description;
        this.userDTO = userDTO;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public Long getDistance() {
        return distance;
    }

    public void setDistance(Long distance) {
        this.distance = distance;
    }

    public Long getCautionMonths() {
        return cautionMonths;
    }

    public void setCautionMonths(Long cautionMonths) {
        this.cautionMonths = cautionMonths;
    }

    public Long getMonthlyRent() {
        return monthlyRent;
    }

    public void setMonthlyRent(Long monthlyRent) {
        this.monthlyRent = monthlyRent;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public UserDTO getUserDTO() {
        return userDTO;
    }

    public void setUserDTO(UserDTO userDTO) {
        this.userDTO = userDTO;
    }

    public String getCurrencyMonthlyRent() {
        return currencyMonthlyRent;
    }

    public void setCurrencyMonthlyRent(String currencyMonthlyRent) {
        this.currencyMonthlyRent = currencyMonthlyRent;
    }

    public Long getAdId() {
        return adId;
    }

    public void setAdId(Long adId) {
        this.adId = adId;
    }
}
