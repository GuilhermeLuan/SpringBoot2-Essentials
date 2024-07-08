package academey.devdojo.springboot2_essentials.service;

import academey.devdojo.springboot2_essentials.domain.Anime;
import academey.devdojo.springboot2_essentials.exception.BadRequestException;
import academey.devdojo.springboot2_essentials.mapper.AnimeMapper;
import academey.devdojo.springboot2_essentials.repository.AnimeRepository;
import academey.devdojo.springboot2_essentials.requests.AnimePostRequestBody;
import academey.devdojo.springboot2_essentials.requests.AnimePutRequestBody;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AnimeService {

    private final AnimeRepository animeRepository;

    public Page<Anime> listAll(Pageable pageable) {
        return animeRepository.findAll(pageable);
    }

    public List<Anime> findByName(String name) {
        return animeRepository.findByName(name);
    }

    public Anime findByIdOrThrowBadRequestException(long id) {
        return animeRepository.findById(id).
                orElseThrow(() -> new BadRequestException("Anime not Found"));
    }
    @Transactional
    public Anime save(AnimePostRequestBody animePostRequestBody){
        return animeRepository.save(AnimeMapper.INSTANCE.toAnime(animePostRequestBody));
    }

    public void delete(long id) {
        animeRepository.delete(findByIdOrThrowBadRequestException(id));
    }

    public void replace(AnimePutRequestBody animePutRequestBody) {
        Anime savedAnime = findByIdOrThrowBadRequestException(animePutRequestBody.id());
        Anime anime = AnimeMapper.INSTANCE.toAnime(animePutRequestBody);
        anime.setId(savedAnime.getId());
        animeRepository.save(anime);
    }
}
