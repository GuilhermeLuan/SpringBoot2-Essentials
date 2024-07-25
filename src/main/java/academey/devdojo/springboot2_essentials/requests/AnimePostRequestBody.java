package academey.devdojo.springboot2_essentials.requests;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import lombok.Builder;

@Builder
public record AnimePostRequestBody(
        @NotEmpty(message = "The anime name cannot be empty")
        @NotBlank(message = "The anime name cannot be blank")
        @Schema(description = "This is the Anime's name",
        example = "Naruto")
        String name) {
}
