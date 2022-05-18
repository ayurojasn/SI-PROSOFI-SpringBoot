package com.javeriana.prosofi.administrador.dto;

public class OkResponseDto <T>{

	private final T object;

	public OkResponseDto(final T object) {
		this.object = object;
	}
}
