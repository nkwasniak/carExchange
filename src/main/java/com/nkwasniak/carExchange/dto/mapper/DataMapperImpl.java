package com.nkwasniak.carExchange.dto.mapper;

import com.nkwasniak.carExchange.database.entity.ForRent;
import com.nkwasniak.carExchange.database.entity.User;
import com.nkwasniak.carExchange.dto.ForRentDTO;
import com.nkwasniak.carExchange.dto.UserDTO;
import com.nkwasniak.carExchange.money.Currency;
import com.nkwasniak.carExchange.money.Money;
import com.nkwasniak.carExchange.money.SimpleMoneyConverter;
import org.springframework.stereotype.Component;

@Component
public class DataMapperImpl implements DataMapper {
    @Override
    public ForRentDTO convertToDto(ForRent forRent) {
        return new ForRentDTO(
                forRent.getId(),
                forRent.getModel(),
                forRent.getMake(),
                forRent.getDistance(),
                forRent.getCautionMonths(),
                forRent.getMonthlyRent(),
                Currency.USD.name(),
                forRent.getDescription(),
                new UserDTO(
                        forRent.getUser().getName(),
                        forRent.getUser().getUsername(),
                        forRent.getUser().getEmail(),
                        forRent.getUser().getPhone()
                )
        );
    }

    @Override
    public ForRent convertToEntity(ForRentDTO forRentDTO) throws Exception {
        return ForRent.builder()
                .withModel(forRentDTO.getModel())
                .withCautionMonths(forRentDTO.getCautionMonths())
                .withDescription(forRentDTO.getDescription())
                .withDistance(forRentDTO.getDistance())
                .withMonthlyRent(SimpleMoneyConverter.convertTo(
                        new Money(forRentDTO.getMonthlyRent(),
                                java.util.Currency.getInstance(forRentDTO.getCurrencyMonthlyRent())),
                        java.util.Currency.getInstance(Currency.USD.name())).getAmount().longValue())
                .withMake(forRentDTO.getModel())
                .build();
    }

    @Override
    public UserDTO convertToDto(User user) {
        return new UserDTO(
                user.getName(),
                user.getUsername(),
                user.getEmail(),
                user.getPhone()
        );
    }

    @Override
    public User convertToEntity(UserDTO userDTO) {
        return User.builder()
                .withName(userDTO.getName())
                .withEmail(userDTO.getEmail())
                .withPhone(userDTO.getPhone())
                .withUsername(userDTO.getUsername())
                .build();
    }

}
