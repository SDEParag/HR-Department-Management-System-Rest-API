package com.hrdepartment.service;

import com.hrdepartment.entity.Position;
import com.hrdepartment.payload.PositionDTO;

import java.util.List;

public interface PositionService {
    List<Position> getAllPositions();
    Position getPositionById(Long id);
    Position createPosition(PositionDTO payloapositionDTO);
    Position updatePosition(Long id, PositionDTO positionDTO);
    void deletePosition(Long id);
}
