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
 * The Class Chapter.
 */
@Entity
@Table(name = "CHAPTERS")
@Getter
@Setter
@NoArgsConstructor

/**
 * Instantiates a new chapter.
 *
 * @param id the id
 * @param number the number
 * @param name the name
 * @param duration the duration
 * @param season the season
 */
@AllArgsConstructor
@Builder

public class Chapter implements Serializable {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

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

	/** The duration. */
	@Column(name = "DURATION")
	private int duration;

	/** The season. */
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "season_Id", referencedColumnName = "ID")
	@JsonIgnore
	private Season season;

}
