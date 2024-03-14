package bdn.code.gisspoc.service;

import bdn.code.gisspoc.domain.Servidor;
import bdn.code.gisspoc.repository.HqlServidorRepository;
import bdn.code.gisspoc.rest.dto.ServidorDto;
import bdn.code.gisspoc.service.mapper.ServidorMapper;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
@Service
@RequiredArgsConstructor
public class ServidorService {

    private final HqlServidorRepository servidorRepository;
    private final ServidorMapper processMapper;

    public List<ServidorDto> getAll() {
        return processMapper.toDtoList(servidorRepository.findAll());
    }

    public ServidorDto getById(Long id) {
        return servidorRepository.findById(id)
                .map(processMapper::toDto)
                .orElseThrow(() -> new EntityNotFoundException("Not found process with id"));
    }

    public ServidorDto create(ServidorDto processDto) {
        Servidor process = processMapper.toEntity(processDto);
        return processMapper.toDto(servidorRepository.save(process));
    }

    public ServidorDto update(ServidorDto processDto) {
        return servidorRepository.findById(processDto.getId())
                .map(processMapper::toDto)
                .map(a -> update(processDto, a))
                .orElseThrow(() -> new EntityNotFoundException("Not found process with id"));
    }

    private ServidorDto update(ServidorDto processDto, ServidorDto a) {
        ServidorDto updatedDto = processMapper.updateDtoFromDto(processDto, a);
        Servidor process = processMapper.toEntity(updatedDto);
        return processMapper.toDto(servidorRepository.save(process));
    }

    public void deleteById(Long id) {
        servidorRepository.deleteById(id);
    }
}
