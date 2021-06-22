package com.netflix.rest.repository;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.netflix.rest.model.Actor;

/**
 * The Interface ActorRepository.
 */
@Repository
@Qualifier("ActorRepository")
public interface ActorRepository extends JpaRepository<Actor, Long> {

}
