package com.nkwasniak.carExchange.service;

import com.nkwasniak.carExchange.database.entity.ForRent;

import java.util.List;

public interface ForRentService {
    void saveForRent(ForRent forRent);
    void deleteByAdsId(Long adsId);
    ForRent findByAdsId(Long adsId);
    List<ForRent> findAll();
    List<ForRent> findAllByUserId(Long userId);
    void updateForRentAd(ForRent forRent, Long adsId);
}
