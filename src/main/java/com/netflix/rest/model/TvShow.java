/*
 * 
 */
package com.netflix.rest.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.netflix.rest.model.TvShow;
import com.sun.istack.NotNull;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * The Class TvShow.
 */
@Entity
@Table(name = "TV_SHOWS")
@Getter
@Setter
@NoArgsConstructor

/**
 * Instantiates a new tv show.
 *
 * @param id               the id
 * @param name             the name
 * @param shortDescription the short description
 * @param longDescription  the long description
 * @param year             the year
 * @param recommendedAge   the recommended age
 * @param advertising      the advertising
 * @param category         the category
 */
@AllArgsConstructor
@Builder
public class TvShow implements Serializable {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The id. */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID", length = 20)
	@NotNull
	@JsonIgnore
	private Long id;

	/** The name. */
	@Column(name = "NAME", unique = true, length = 256)
	@NotNull
	private String name;

	/** The short description. */
	@Column(name = "SHORT_DESC", unique = true, length = 256)
	@NotNull
	private String shortDescription;

	/** The long description. */
	@Column(name = "LONG_DESC", unique = true, length = 2048)
	@NotNull
	private String longDescription;

	/** The year. */
	@Column(name = "YEAR", unique = true, length = 4)
	@NotNull
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
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "tvShows")
	private List<Seasons> seasons;

	/** The advertising. */
	@Column(name = "ADVERTISING")
	private String advertising;

	@JoinTable(name = "CATEGORY_TVSHOWS", joinColumns = @JoinColumn(name = "TVSHOW_ID", nullable = false), inverseJoinColumns = @JoinColumn(name = "CATEGORY_ID", nullable = false))
	@ManyToMany(cascade = CascadeType.ALL)
	private List<Category> categories;

}
