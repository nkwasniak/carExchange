package com.nkwasniak.carExchange.database.entity;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "for_rent")
public class ForRent implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", length = 50, nullable = false)
    private Long id;

    @Column(name = "model", length = 50, nullable = false)
    private String model;

    @Column(name = "make", length = 50, nullable = false)
    private String make;

    @Column(name = "distance", length = 50, nullable = false)
    private Long distance;

    @Column(name = "caution_months", length = 50, nullable = false)
    private Long cautionMonths;

    @Column(name = "monthly_rent", length = 50, nullable = false)
    private Long monthlyRent;

    @Column(name = "description", nullable = false)
    private String description;

    @ManyToOne(fetch = FetchType.LAZY)
    private User user;

    public Long getId() {
        return id;
    }

    public String getModel() {
        return model;
    }

    public String getMake() {
        return make;
    }

    public Long getDistance() {
        return distance;
    }

    public Long getCautionMonths() {
        return cautionMonths;
    }

    public Long getMonthlyRent() {
        return monthlyRent;
    }

    public String getDescription() {
        return description;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public void setDistance(Long distance) {
        this.distance = distance;
    }

    public void setCautionMonths(Long cautionMonths) {
        this.cautionMonths = cautionMonths;
    }

    public void setMonthlyRent(Long monthlyRent) {
        this.monthlyRent = monthlyRent;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public static ForRentBuilder builder() {
        return new ForRentBuilder();
    }

    public static final class ForRentBuilder {
        private Long id;
        private String model;
        private String make;
        private Long distance;
        private Long cautionMonths;
        private Long monthlyRent;
        private String description;
        private User user;

        public ForRentBuilder withId(Long id) {
            this.id = id;
            return this;
        }

        public ForRentBuilder withModel(String model) {
            this.model = model;
            return this;
        }

        public ForRentBuilder withMake(String make) {
            this.make = make;
            return this;
        }

        public ForRentBuilder withDistance(Long distance) {
            this.distance = distance;
            return this;
        }

        public ForRentBuilder withCautionMonths(Long cautionMonths) {
            this.cautionMonths = cautionMonths;
            return this;
        }

        public ForRentBuilder withMonthlyRent(Long monthlyRent) {
            this.monthlyRent = monthlyRent;
            return this;
        }

        public ForRentBuilder withDescription(String description) {
            this.description = description;
            return this;
        }

        public ForRentBuilder withUser(User user) {
            this.user = user;
            return this;
        }

        public ForRent build() {
            ForRent forRent = new ForRent();
            forRent.user = this.user;
            forRent.distance = this.distance;
            forRent.description = this.description;
            forRent.monthlyRent = this.monthlyRent;
            forRent.make = this.make;
            forRent.model = this.model;
            forRent.cautionMonths = this.cautionMonths;
            forRent.id = this.id;
            return forRent;
        }
    }
}
