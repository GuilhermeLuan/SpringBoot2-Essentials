package academey.devdojo.springboot2_essentials.service;

import academey.devdojo.springboot2_essentials.domain.Anime;
import academey.devdojo.springboot2_essentials.repository.AnimeRepository;
import academey.devdojo.springboot2_essentials.requests.AnimePostRequestBodyRecord;
import academey.devdojo.springboot2_essentials.requests.AnimePutRequestBodyRecord;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AnimeService {

    private final AnimeRepository animeRepository;

    public List<Anime> listAll() {
        return animeRepository.findAll();
    }

    public Anime findByIdOrThrowBadRequestException(long id) {
        return animeRepository.findById(id).
                orElseThrow(() -> new ResponseStatusException(HttpStatus.BAD_REQUEST, "Anime not Found"));
    }

    public Anime save(AnimePostRequestBodyRecord animePostRequestBodyRecord) {
        Anime anime = Anime
                .builder()
                .name(animePostRequestBodyRecord.name())
                .build();
        return animeRepository.save(anime);
    }

    public void delete(long id) {
        animeRepository.delete(findByIdOrThrowBadRequestException(id));
    }

    public void replace(AnimePutRequestBodyRecord animePutRequestBodyRecord) {
        Anime savedAnime = findByIdOrThrowBadRequestException(animePutRequestBodyRecord.id());
        Anime anime = Anime.builder()
                .id(savedAnime.getId())
                .name(animePutRequestBodyRecord.name())
                .build();

        animeRepository.save(anime);
    }
}
