package bdn.code.gisspoc.rest.dto;

import lombok.Builder;
import lombok.Data;

@Builder(toBuilder = true)
@Data
public class ProcessDto {

    Long id;
    String name;
}
