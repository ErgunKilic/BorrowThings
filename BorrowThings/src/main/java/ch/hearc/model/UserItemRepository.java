package ch.hearc.model;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UserItemRepository extends JpaRepository<User, Integer> {

}
