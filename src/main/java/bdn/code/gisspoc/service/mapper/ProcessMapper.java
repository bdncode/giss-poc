package bdn.code.gisspoc.service.mapper;

import bdn.code.gisspoc.domain.Process;
import bdn.code.gisspoc.rest.dto.ProcessDto;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper(componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.ERROR)
public interface ProcessMapper {

    ProcessDto toDto(Process process);

    List<ProcessDto> toDtoList(List<Process> client);

    Process toEntity(ProcessDto processDto);

    ProcessDto updateDtoFromDto(ProcessDto processDto, @MappingTarget ProcessDto target);
}
