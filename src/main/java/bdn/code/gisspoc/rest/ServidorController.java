package bdn.code.gisspoc.rest;

import bdn.code.gisspoc.error.IdMismatchException;
import bdn.code.gisspoc.rest.dto.ServidorDto;
import bdn.code.gisspoc.service.ServidorService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Objects;

@RestController
@RequestMapping("/proceses")
@RequiredArgsConstructor
public class ServidorController {

    private final ServidorService processService;

    @GetMapping
    public ResponseEntity<List<ServidorDto>> getAll() {
        return ResponseEntity.ok(processService.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ServidorDto> getById(@PathVariable Long id) {
        return ResponseEntity.ok(processService.getById(id));
    }

    @PostMapping
    public ResponseEntity<ServidorDto> create(@RequestBody ServidorDto processDto) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(processService.create(processDto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ServidorDto> update(@PathVariable Long id, @RequestBody ServidorDto processDto) {
        if (!Objects.equals(id, processDto.getId())) {
            throw new IdMismatchException("No match");
        }
        return ResponseEntity.ok(processService.update(processDto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        processService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
