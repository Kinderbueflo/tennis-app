package fr.fgirard.tennisapp.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.fgirard.tennisapp.domain.Player;
import fr.fgirard.tennisapp.repository.PlayerRepository;
import fr.fgirard.tennisapp.service.PlayerService;

@Service("playerService")
public class PlayerServiceImpl implements PlayerService {

	@Autowired
	private PlayerRepository playerRepository;
	
	@Override
	public List<Player> getAllPlayers() {
		return this.playerRepository.findAll();
	}

}
