package com.netflix.rest.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * The Class Actor.
 */
@Entity
@Table(name = "ACTORS")
@Getter
@Setter
@NoArgsConstructor

/**
 * Instantiates a new actor.
 *
 * @param id the id
 * @param name the name
 * @param year the year
 */
@AllArgsConstructor
@Builder
public class Actor implements Serializable {

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

	/** The year. */
	@Column(name = "YEAR")
	private int year;
	
	/** The tv show. */
	@JoinTable(name = "ACTORS_TVSHOWS",
		    joinColumns = @JoinColumn(name = "TVSHOW_ID", nullable = false),
		    inverseJoinColumns = @JoinColumn(name="ACTOR_ID", nullable = false)
		)
	@ManyToMany(cascade = CascadeType.ALL)
	private List<TvShow> tvShow;

}
