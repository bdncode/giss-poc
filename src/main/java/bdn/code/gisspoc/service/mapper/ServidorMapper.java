package bdn.code.gisspoc.service.mapper;

import bdn.code.gisspoc.domain.Servidor;
import bdn.code.gisspoc.rest.dto.ServidorDto;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper(componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.ERROR)
public interface ServidorMapper {

    ServidorDto toDto(Servidor process);

    List<ServidorDto> toDtoList(List<Servidor> client);

    Servidor toEntity(ServidorDto processDto);

    ServidorDto updateDtoFromDto(ServidorDto processDto, @MappingTarget ServidorDto target);
}
