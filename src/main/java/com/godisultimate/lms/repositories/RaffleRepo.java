package com.godisultimate.lms.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.godisultimate.lms.model.Raffle;

public interface RaffleRepo extends JpaRepository<Raffle, Long> {

	public static final String select_r_from_Raffle_r_where = "select r from Raffle r where ";

	@Query(select_r_from_Raffle_r_where
			+ "r.raffleCode =:raffleCode ")
	Optional<Raffle> findByRaffleCode(String raffleCode);

}
