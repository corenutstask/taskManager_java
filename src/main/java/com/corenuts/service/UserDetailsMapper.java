package com.corenuts.service;



import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.stereotype.Component;

import com.corenuts.dto.UserDetailsDTO;
import com.corenuts.entity.UserDetails;

import lombok.Data;
@Data
@Component
public class UserDetailsMapper {
	 private static ModelMapper modelMapper;

	    static {
	        modelMapper = new ModelMapper();
	        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
	    }

	    public static UserDetailsDTO toDTO(UserDetails userDetails) {
	        return modelMapper.map(userDetails, UserDetailsDTO.class);
	    }

	    public static UserDetails toEntity(UserDetailsDTO userDetailsDTO) {
	        return modelMapper.map(userDetailsDTO, UserDetails.class);
	    }
}
