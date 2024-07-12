package academey.devdojo.springboot2_essentials.util;

import academey.devdojo.springboot2_essentials.requests.AnimePostRequestBody;

public class AnimePostRequestBodyCreator {
    public static AnimePostRequestBody createPostRequestBody(){
        return new AnimePostRequestBody(AnimeCreator.createAnimeToBeSaved().getName());
    }
}
