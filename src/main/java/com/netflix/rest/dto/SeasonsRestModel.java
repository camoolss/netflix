package com.netflix.rest.dto;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;
import lombok.Setter;

/**
 * The Class SeasonsRestModel.
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@Getter
@Setter 
public class SeasonsRestModel implements Serializable{
	
	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 18080239613616000L;
	
	/** The id. */
	@JsonProperty(value="ID")
	private Long id;
	
	/** The number. */
	@JsonProperty(value="NUMBER")
	private int number;
	
	/** The name. */
	@JsonProperty(value="NAME")
	private String name;
	
	
	
}
