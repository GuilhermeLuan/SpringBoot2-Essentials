package academey.devdojo.springboot2_essentials.util;

import academey.devdojo.springboot2_essentials.domain.Anime;

public class AnimeCreator {
    public static Anime createAnimeToBeSaved(){
        return Anime.builder()
                .name("Hajime Noi")
                .build();
    }

    public static Anime createValidAnime(){
        return Anime.builder()
                .name("Hajime Noi")
                .id(1L)
                .build();
    }

    public static Anime createValidUpdateAnime(){
        return Anime.builder()
                .name("Hajime Noi")
                .id(1L)
                .build();
    }

}
