package academey.devdojo.springboot2_essentials.repository;

import academey.devdojo.springboot2_essentials.domain.Anime;
import academey.devdojo.springboot2_essentials.domain.DevDojoUser;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DevDojoUserRepository extends JpaRepository<DevDojoUser, Long> {

    DevDojoUser findByUsername(String name);
}
