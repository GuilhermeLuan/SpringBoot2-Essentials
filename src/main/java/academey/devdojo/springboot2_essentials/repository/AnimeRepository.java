package academey.devdojo.springboot2_essentials.repository;

import academey.devdojo.springboot2_essentials.domain.Anime;

import java.util.List;

public interface AnimeRepository{
    List<Anime> listAll();
}
