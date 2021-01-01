package com.nkwasniak.carExchange.dto.mapper;

import com.nkwasniak.carExchange.database.entity.ForRent;
import com.nkwasniak.carExchange.database.entity.User;
import com.nkwasniak.carExchange.dto.ForRentDTO;
import com.nkwasniak.carExchange.dto.UserDTO;
import org.springframework.stereotype.Component;

@Component
public interface DataMapper {
    ForRentDTO convertToDto(ForRent forRent);

    ForRent convertToEntity(ForRentDTO forRentDTO) throws Exception;

    UserDTO convertToDto(User user);

    User convertToEntity(UserDTO userDTO);
}
