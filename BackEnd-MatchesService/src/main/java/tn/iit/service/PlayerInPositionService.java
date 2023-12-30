package tn.iit.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import tn.iit.dao.PlayerInPositionRepository;
import tn.iit.entity.PlayerInPosition;
import tn.iit.utils.checks.PlayerInPositionControl;

@Service
public class PlayerInPositionService {
    private PlayerInPositionRepository playerInPositionRepository;

    @Autowired
    public PlayerInPositionService(PlayerInPositionRepository playerInPositionRepository) {
        this.playerInPositionRepository = playerInPositionRepository;
    }

    public PlayerInPosition createPlayerInPosition(PlayerInPosition playerInPosition) {
        if (!PlayerInPositionControl.checkPlayerInPosition(playerInPosition).checkPosition().finish()) {
            throw new IllegalArgumentException("Invalid playerInPosition");
        }

        return playerInPositionRepository.save(playerInPosition);
    }

    public PlayerInPosition getPlayerInPositionById(Long playerInPositionId) {
        return playerInPositionRepository.findById(playerInPositionId).orElse(null);
    }

    public PlayerInPosition updatePlayerInPosition(PlayerInPosition playerInPosition) {
        return playerInPositionRepository.save(playerInPosition);
    }

    public void deletePlayerInPosition(Long playerInPositionId) {
        playerInPositionRepository.deleteById(playerInPositionId);
    }

    public Page<PlayerInPosition> getAllPlayerInPositions(Pageable pageable) {
        return playerInPositionRepository.findAll(pageable);
    }
}
