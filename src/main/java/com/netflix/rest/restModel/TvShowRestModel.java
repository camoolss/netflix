package com.netflix.rest.restModel;

import java.io.Serializable;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * The Class TvShowRestModel.
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@Getter
@Setter

/**
 * Instantiates a new tv show rest model.
 *
 * @param id the id
 * @param name the name
 * @param shortDescription the short description
 * @param longDescription the long description
 * @param year the year
 * @param recommendedAge the recommended age
 * @param advertising the advertising
 */
@AllArgsConstructor
@NoArgsConstructor
public class TvShowRestModel implements Serializable {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 18080239613616000L;

	/** The id. */
	@JsonProperty(value = "ID")
	private Long id;

	/** The name. */
	@JsonProperty(value = "NAME")
	private String name;

	/** The short description. */
	@JsonProperty(value = "SHORT_DESC")
	private String shortDescription;

	/** The long description. */
	@JsonProperty(value = "LONG_DESC")
	private String longDescription;

	/** The year. */
	@JsonProperty(value = "YEAR")
	@JsonFormat(pattern = "yyyy")
	private Date year;

	/** The recommended age. */
	@JsonProperty(value = "RECOMMENDED_AGE")
	private int recommendedAge;

	/** The advertising. */
	@JsonProperty(value = "ADVERTISING")
	private String advertising;

}
