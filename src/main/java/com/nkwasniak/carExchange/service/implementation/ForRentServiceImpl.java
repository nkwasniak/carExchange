package com.nkwasniak.carExchange.service.implementation;

import com.nkwasniak.carExchange.database.entity.User;
import com.nkwasniak.carExchange.database.repository.UserRepository;
import com.nkwasniak.carExchange.service.exception.ResourceNotFoundException;
import com.nkwasniak.carExchange.service.ForRentService;
import com.nkwasniak.carExchange.database.entity.ForRent;
import com.nkwasniak.carExchange.database.repository.ForRentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.nkwasniak.carExchange.service.implementation.UserDetailsServiceImpl.activeUserId;

@Service
public class ForRentServiceImpl implements ForRentService {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ForRentRepository forRentRepository;

    @Override
    public void saveForRent(ForRent forRent) {
        userRepository.findById(activeUserId).map(user -> {
            ForRent newForRent = createNewForRent(forRent);
            user.addForRentAdvert(newForRent);
            return userRepository.save(user);
        }).orElseThrow(() -> new ResourceNotFoundException("UserId " + activeUserId + " not found"));
    }

    @Override
    public void deleteByAdsId(Long adsId) {
        User updateUser = userRepository.findById(activeUserId).get();
        ForRent forRent = forRentRepository.findById(adsId).get();
        updateUser.removeForRentAdvert(forRent);

        userRepository.save(updateUser);
    }

    @Override
    public ForRent findByAdsId(Long adsId) {
        return forRentRepository.findById(adsId).get();
    }

    @Override
    public List<ForRent> findAll() {
        return forRentRepository.findAll();
    }

    @Override
    public List<ForRent> findAllByUserId(Long userId) {
        return userRepository.findById(userId).get().getForRentList();
    }

    @Override
    public void updateForRentAd(ForRent forRent, Long adsId) {
        ForRent editForRent = forRentRepository.findById(adsId).get();

        editForRent.setDescription(forRent.getDescription());
        editForRent.setDistance(forRent.getDistance());
        editForRent.setMonthlyRent(forRent.getMonthlyRent());
        editForRent.setMake(forRent.getMake());
        editForRent.setCautionMonths(forRent.getCautionMonths());
        editForRent.setModel(forRent.getModel());

        forRentRepository.save(editForRent);
    }

    private ForRent createNewForRent(ForRent forRent) {
        return ForRent.builder()
                .withModel(forRent.getModel())
                .withMake(forRent.getMake())
                .withDistance(forRent.getDistance())
                .withCautionMonths(forRent.getCautionMonths())
                .withMonthlyRent(forRent.getMonthlyRent())
                .withDescription(forRent.getDescription())
                .build();
    }
}
