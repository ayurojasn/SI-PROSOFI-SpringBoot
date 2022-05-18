package com.javeriana.prosofi.administrador.dto.mapper;

import com.javeriana.prosofi.administrador.dto.OkResponseDto;

public class OkResponseDtoMapper<T> {

	public OkResponseDto<T> mapperToOKResponseDto(T object){
		return new OkResponseDto(object);
	}
}
