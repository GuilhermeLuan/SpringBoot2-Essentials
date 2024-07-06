package academey.devdojo.springboot2_essentials.controller;

import academey.devdojo.springboot2_essentials.domain.Anime;
import academey.devdojo.springboot2_essentials.requests.AnimePostRequestBodyRecord;
import academey.devdojo.springboot2_essentials.requests.AnimePutRequestBodyRecord;
import academey.devdojo.springboot2_essentials.service.AnimeService;
import academey.devdojo.springboot2_essentials.util.DateUtil;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("animes")
@Log4j2
@RequiredArgsConstructor
public class AnimeController {
    private final DateUtil dateUtil;
    private final AnimeService animeService;

    @GetMapping
    public ResponseEntity<List<Anime>> list() {
        log.info(dateUtil.formatLocalDateTimeToDataBaseStyle(LocalDateTime.now()));
        return new ResponseEntity<>(animeService.listAll(), HttpStatus.OK);
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<Anime> findById(@PathVariable long id) {
        return new ResponseEntity<>(animeService.findByIdOrThrowBadRequestException(id), HttpStatus.OK);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<Anime> save(@RequestBody AnimePostRequestBodyRecord animePostRequestBodyRecord){
        return new ResponseEntity<>(animeService.save(animePostRequestBodyRecord), HttpStatus.CREATED);
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable long id) {
        animeService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PutMapping
    public ResponseEntity<Void> replace(@RequestBody AnimePutRequestBodyRecord animePutRequestBodyRecord) {
        animeService.replace(animePutRequestBodyRecord);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
