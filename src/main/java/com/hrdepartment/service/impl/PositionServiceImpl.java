package com.hrdepartment.service.impl;

import com.hrdepartment.entity.Position;
import com.hrdepartment.payload.PositionDTO;
import com.hrdepartment.repository.DepartmentRepository;
import com.hrdepartment.repository.PositionRepository;
import com.hrdepartment.service.PositionService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class PositionServiceImpl implements PositionService {
    @Autowired
    private PositionRepository positionRepository;
    @Autowired
    private DepartmentRepository departmentRepository;
    @Autowired
    private ModelMapper modelMapper;

    @Override
    public List<Position> getAllPositions() {
        List<Position> positions = positionRepository.findAll();
        return positions.stream()
                .map(position -> modelMapper.map(position, Position.class))
                .collect(Collectors.toList());
    }

    @Override
    public Position getPositionById(Long id) {
        Position position = positionRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Position not found"));
        return modelMapper.map(position, Position.class);
    }

    @Override
    public Position createPosition(PositionDTO positionDTO) {
        Position position = modelMapper.map(positionDTO, Position.class);
        Position savedPosition = positionRepository.save(position);
        return modelMapper.map(savedPosition, Position.class);
    }

    @Override
    public Position updatePosition(Long id, PositionDTO positionDTO) {
        Position position = positionRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Position not found"));
        modelMapper.map(positionDTO, position);
        Position updatedPosition = positionRepository.save(position);
        return modelMapper.map(updatedPosition, Position.class);
    }

    @Override
    public void deletePosition(Long id) {
        positionRepository.deleteById(id);
    }
}
