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
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.sun.istack.NotNull;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * The Class Category.
 */
@Entity
@Table(name = "CATEGORY")
@Getter
@Setter
@NoArgsConstructor

/**
 * Instantiates a new category.
 *
 * @param id the id
 * @param name the name
 * @param tvShowList the tv show list
 */
@AllArgsConstructor
@Builder
public class Category implements Serializable {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The id. */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID")
	@NotNull
	@JsonIgnore
	private Long id;
	
	/** The name. */
	@Column(name = "NAME")
	@NotNull
	private String name;
	
	/** The tv show list. */
	//@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "category")
	//private List<TvShow> tvShowList;
	
	/** The tv shows. */
    @ManyToMany(cascade = CascadeType.ALL, mappedBy="category")
	private List<TvShow> tvShow;

}
