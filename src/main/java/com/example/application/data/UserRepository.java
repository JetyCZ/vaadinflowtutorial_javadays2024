package com.example.application.data;


import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface UserRepository extends JpaRepository<User, Long> {

  /*
  @Query("select u from User u " +
      "where lower(u.firstName) like lower(concat('%', :searchTerm, '%')) " +
      "or lower(u.email) like lower(concat('%', :searchTerm, '%'))")
  List<User> search(@Param("searchTerm") String searchTerm);
  */
}
