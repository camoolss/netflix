package com.netflix.rest.restModel;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * The Class ActorRestModel.
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@Getter
@Setter

/**
 * Instantiates a new actor rest model.
 *
 * @param name the name
 * @param age the age
 * @param actorId the actor id
 */
@AllArgsConstructor
@NoArgsConstructor
public class ActorRestModel implements Serializable {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 18080239613616000L;

	/** The actor id. */
	@JsonProperty(value = "actorId")
	private Long actorId;
	
	/** The name. */
	@JsonProperty(value = "name")
	private String name;

	/** The age. */
	@JsonProperty(value = "year")
	private int year;

}