package kz.bitlab.restcsrfproject.repositories;

import jakarta.transaction.Transactional;
import kz.bitlab.restcsrfproject.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
@Transactional

public interface UserRepository extends JpaRepository<User,Long> {
    User findAllByEmail(String email);
}
