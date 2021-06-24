package com.netflix.rest.restModel;

import java.io.Serializable;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.netflix.rest.model.Category;

import lombok.Getter;
import lombok.Setter;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Getter
@Setter
public class TvShowRestModel implements Serializable {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 18080239613616000L;

	/** The id. */
	@JsonProperty(value = "ID")
	private Long id;

	/** The name. */
	@JsonProperty(value = "NAME")
	private String name;

	@JsonProperty(value = "SHORT_DESC")
	private String shortDescription;

	@JsonProperty(value = "LONG_DESC")
	private String longDescription;

	@JsonProperty(value = "YEAR")
	@JsonFormat(pattern = "yyyy")
	private Date year;

	@JsonProperty(value = "RECOMMENDED_AGE")
	private int recommendedAge;

	@JsonProperty(value = "ADVERTISING")
	private String advertising;

}
