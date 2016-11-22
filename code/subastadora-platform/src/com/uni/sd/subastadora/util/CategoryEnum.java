package com.uni.sd.subastadora.util;

public enum CategoryEnum {
	LIBROS("Libros"),
	MUSICAS("Musicas"),
	PELICULAS("Peliculas");

	final String _value;
	private CategoryEnum(String value){
		_value = value;
	}
	
	public String toString(){
		return _value;
	}
	public String getKey(){
		return name();
	}
	
	
}
