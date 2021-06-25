package com.netflix.rest.restModel;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * The Class SeasonRestModel.
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@Getter
@Setter

/**
 * Instantiates a new season rest model.
 *
 * @param id the id
 * @param number the number
 * @param name the name
 */
@AllArgsConstructor
@NoArgsConstructor
public class SeasonRestModel implements Serializable {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 18080239613616000L;

	/** The id. */
	@JsonProperty(value = "ID")
	private Long id;

	/** The number. */
	@JsonProperty(value = "NUMBER")
	private int number;

	/** The name. */
	@JsonProperty(value = "NAME")
	private String name;

}
