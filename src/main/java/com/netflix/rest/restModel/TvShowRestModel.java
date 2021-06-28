package com.netflix.rest.restModel;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.netflix.rest.model.Category;
import com.netflix.rest.model.Season;

import io.swagger.annotations.ApiModelProperty;
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
 * @param id               the id
 * @param name             the name
 * @param shortDescription the short description
 * @param longDescription  the long description
 * @param year             the year
 * @param recommendedAge   the recommended age
 * @param advertising      the advertising
 */
@AllArgsConstructor
@NoArgsConstructor
public class TvShowRestModel implements Serializable {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 18080239613616000L;

	/** The id. */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID")
	@JsonIgnore
	@ApiModelProperty(position = 0)
	private Long id;

	/** The name. */
	@Column(name = "NAME")
	private String name;

	/** The short description. */
	@Column(name = "SHORT_DESC")
	private String shortDescription;

	/** The long description. */
	@Column(name = "LONG_DESC")
	private String longDescription;

	/** The year. */
	@Column(name = "YEAR")
	private int year;

	/** The recommended age. */
	@Column(name = "RECOMMENDED_AGE")
	private int recommendedAge;

	/** The category id. */
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "categoryId", referencedColumnName = "ID")
	@JsonIgnore
	private Category categoryId;

	/** The seasons. */
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "tvShow")
	private List<Season> season;

	/** The advertising. */
	@Column(name = "ADVERTISING")
	private String advertising;

	@JoinTable(name = "CATEGORY_TVSHOW", joinColumns = @JoinColumn(name = "TVSHOW_ID", nullable = false), inverseJoinColumns = @JoinColumn(name = "CATEGORY_ID", nullable = false))
	@ManyToMany(cascade = CascadeType.ALL)
	private List<Category> category;
}
