package academey.devdojo.springboot2_essentials.util;

import academey.devdojo.springboot2_essentials.requests.AnimePutRequestBody;

public class AnimePutRequestBodyCreator {
    public static AnimePutRequestBody createPutRequestBody(){
        return new AnimePutRequestBody(
                AnimeCreator.createValidUpdateAnime().getId(),
                AnimeCreator.createValidUpdateAnime().getName());
    }
}
