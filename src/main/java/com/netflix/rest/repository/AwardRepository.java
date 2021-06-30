package com.netflix.rest.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.netflix.rest.model.Award;

/**
 * The Interface AwardRepository.
 */
@Repository
@Qualifier("AwardRepository")
public interface AwardRepository extends JpaRepository<Award, Long> {

	/**
	 * Find by tv show id.
	 *
	 * @param tvShowId the tv show id
	 * @return the list
	 */
	@Query(value = "SELECT * FROM AWARDS WHERE tv_show_id =?1", nativeQuery = true)
	List<Award> findByTvShowId(long tvShowId);

}
