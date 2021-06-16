package com.netflix.rest.dto;

import java.io.Serializable;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.netflix.rest.model.Category;

import lombok.Getter;
import lombok.Setter;

/**
 * The Class CategoriesRestModel.
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@Getter
@Setter
public class TvShowsRestModel implements Serializable {

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

	/** The category id. */
	@JsonProperty(value = "categoryId")
	private Category categoryId;

	/** The advertising. */
	@JsonProperty(value = "ADVERTISING")
	private String advertising;

}
