package com.netflix.rest.dto;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;
import lombok.Setter;

/**
 * The Class ChaptersRestModel.
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@Getter
@Setter 
public class ChapterRestModel implements Serializable{
	
	
	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 18080239613616000L;
	
	/** The id. */
	@JsonProperty(value="id")
	private Long id;
	
	/** The number. */
	@JsonProperty(value="number")
	private int number;
	
	/** The name. */
	@JsonProperty(value="name")
	private String name;
	
	/** The duration. */
	@JsonProperty(value="duration")
	private int duration;
}
