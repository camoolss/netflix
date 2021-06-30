package com.netflix.rest.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * The Class Award.
 */
@Entity
@Table(name = "AWARDS")
@Getter
@Setter
@NoArgsConstructor

/**
 * Instantiates a new award.
 *
 * @param id the id
 * @param name the name
 * @param year the year
 * @param tvShowId the tv show id
 */
@AllArgsConstructor
@Builder
public class Award implements Serializable {

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

	/** The tv show id. */
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "tvShowId", referencedColumnName = "ID")
	@JsonIgnore
	private TvShow tvShowId;

}
