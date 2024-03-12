package bdn.code.gisspoc.service;

import bdn.code.gisspoc.domain.Process;
import bdn.code.gisspoc.repository.JpaProcessRepository;
import bdn.code.gisspoc.rest.dto.ProcessDto;
import bdn.code.gisspoc.service.mapper.ProcessMapper;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
@Service
@RequiredArgsConstructor
public class ProcessService {

    private final JpaProcessRepository jpaProcessRepository;
    private final ProcessMapper processMapper;

    public List<ProcessDto> getAll() {
        return processMapper.toDtoList(jpaProcessRepository.findAll());
    }

    public ProcessDto getById(Long id) {
        return jpaProcessRepository.findById(id)
                .map(processMapper::toDto)
                .orElseThrow(() -> new EntityNotFoundException("Not found process with id"));
    }

    public ProcessDto create(ProcessDto processDto) {
        Process process = processMapper.toEntity(processDto);
        return processMapper.toDto(jpaProcessRepository.save(process));
    }

    public ProcessDto update(ProcessDto processDto) {
        return jpaProcessRepository.findById(processDto.getId())
                .map(processMapper::toDto)
                .map(a -> update(processDto, a))
                .orElseThrow(() -> new EntityNotFoundException("Not found process with id"));
    }

    private ProcessDto update(ProcessDto processDto, ProcessDto a) {
        ProcessDto updatedDto = processMapper.updateDtoFromDto(processDto, a);
        Process process = processMapper.toEntity(updatedDto);
        return processMapper.toDto(jpaProcessRepository.save(process));
    }

    public void deleteById(Long id) {
        jpaProcessRepository.deleteById(id);
    }
}
