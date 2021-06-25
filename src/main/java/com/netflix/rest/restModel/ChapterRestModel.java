package com.netflix.rest.restModel;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * The Class ChapterRestModel.
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@Getter
@Setter

/**
 * Instantiates a new chapter rest model.
 *
 * @param id the id
 * @param number the number
 * @param name the name
 * @param duration the duration
 */
@AllArgsConstructor
@NoArgsConstructor
public class ChapterRestModel implements Serializable {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 18080239613616000L;

	/** The id. */
	@JsonProperty(value = "id")
	private Long id;

	/** The number. */
	@JsonProperty(value = "number")
	private int number;

	/** The name. */
	@JsonProperty(value = "name")
	private String name;

	/** The duration. */
	@JsonProperty(value = "duration")
	private int duration;
}