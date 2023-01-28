package com.godisultimate.lms.services;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.godisultimate.lms.model.Raffle;
import com.godisultimate.lms.playloads.RaffleDto;
import com.godisultimate.lms.repositories.RaffleRepo;
import com.godisultimate.lms.utils.ApplicationExceptionMsge;
import com.godisultimate.lms.utils.ApplicationExceptions;

@Service
public class RaffleServicesImpl implements RaffleServices {

	@Autowired
	private ModelMapper modelMapper;
	@Autowired
	private RaffleRepo raffleRepo;
	@Autowired
	private Raffle raffle;
	@Override
	public HashMap<String, Object> addRaffle(RaffleDto raffleDto) throws ApplicationExceptions, Exception {
		HashMap<String, Object> hashMap = new HashMap<String, Object>();

		raffle= DtoToEntity(raffleDto);
		if (raffle.getRaffleId() > 0 ||raffle.getRaffleCode().isEmpty()|| raffle.getRaffleName().trim().equals("")
				|| raffle.getSeries()==0) {
			throw new ApplicationExceptions(ApplicationExceptionMsge.raffle_invalid_parameter);
		}
		raffle = raffleRepo.save(raffle);
		hashMap.put("Raffle Id::", raffle.getRaffleId());
		return hashMap;
	}

	private Raffle DtoToEntity(RaffleDto raffleDto) {
		// TODO Auto-generated method stub
		return this.modelMapper.map(raffleDto, Raffle.class);
	}

	@Override
	public List<RaffleDto> getAllRaffle() throws ApplicationExceptions, Exception {
		List<Raffle> raffles = raffleRepo.findAll();
		List<RaffleDto> raffleDtos = new ArrayList<RaffleDto>();
		for(Raffle raffle:raffles) {
			raffleDtos.add(this.modelMapper.map(raffle, RaffleDto.class));
		}
		return raffleDtos;
	}

	@Override
	public RaffleDto getRaffleById(Long raffleId) throws ApplicationExceptions, Exception {
		// TODO Auto-generated method stub
		return this.modelMapper.map(raffleRepo.findById(raffleId), RaffleDto.class);
	}

	@Override
	public RaffleDto getRaffleByCode(String raffleCode) throws ApplicationExceptions, Exception {
		Optional<Raffle> raffle = raffleRepo.findByRaffleCode(raffleCode);
		if (raffle.isPresent()) {
			return this.modelMapper.map(raffle.get(), RaffleDto.class);
		}
		throw new RuntimeException("Raffle is not found for this raffle code:: "+raffleCode);
	}

}
