package com.netflix.rest.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * The Class Category.
 */
@Entity
@Table(name = "CATEGORIES")
@Getter
@Setter
@NoArgsConstructor

/**
 * Instantiates a new category.
 *
 * @param id the id
 * @param name the name
 * @param tvShow the tv show
 */
@AllArgsConstructor
@Builder
public class Category implements Serializable {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 18080239613616000L;

	/** The id. */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID")
	@JsonIgnore
	private Long id;

	/** The name. */
	@Column(name = "NAME")
	private String name;

	/** The tv show. */
	@ManyToMany(cascade = CascadeType.ALL, mappedBy = "category")
	private List<TvShow> tvShow;

}
