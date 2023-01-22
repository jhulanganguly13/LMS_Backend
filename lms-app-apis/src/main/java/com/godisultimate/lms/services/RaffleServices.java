package com.godisultimate.lms.services;

import java.util.HashMap;
import java.util.List;

import com.godisultimate.lms.playloads.RaffleDto;
import com.godisultimate.lms.utils.ApplicationExceptions;

public interface RaffleServices {
	public HashMap<String, Object> addRaffle(RaffleDto raffleDto) throws ApplicationExceptions, Exception;
	public List<RaffleDto> getAllRaffle() throws ApplicationExceptions, Exception;
	public RaffleDto getRaffleById(Long raffleId) throws ApplicationExceptions, Exception;
	public RaffleDto getRaffleByCode(String raffleCode) throws ApplicationExceptions, Exception;
}
