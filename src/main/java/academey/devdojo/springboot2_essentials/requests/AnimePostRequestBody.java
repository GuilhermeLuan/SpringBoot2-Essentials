package academey.devdojo.springboot2_essentials.requests;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import lombok.Builder;

@Builder
public record AnimePostRequestBody(
        @NotEmpty(message = "The anime name cannot be empty")
        @NotBlank(message = "The anime name cannot be blank")
        String name) {
}
