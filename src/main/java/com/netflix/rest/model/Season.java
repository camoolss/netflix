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
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * The Class Season.
 */
@Entity
@Table(name = "SEASONS")
@Getter
@Setter
@NoArgsConstructor

/**
 * Instantiates a new seasons.
 *
 * @param id the id
 * @param number the number
 * @param name the name
 * @param tvShow the tv show
 * @param chapters the chapters
 */
@AllArgsConstructor
@Builder
public class Season implements Serializable {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 18080239613616000L;
	
	/** The id. */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID")
	@JsonIgnore
	private Long id;

	/** The number. */
	@Column(name = "NUMBER")
	private int number;

	/** The name. */
	@Column(name = "NAME")
	private String name;

	/** The tv show. */
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "TV_SHOW_ID", referencedColumnName = "ID")
	@JsonIgnore
	private TvShow tvShow;

	/** The chapters. */
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "seasons")
	private List<Chapter> chapters;

}
