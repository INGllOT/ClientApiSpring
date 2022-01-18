package com.example.Banking3.Client;

import org.apache.catalina.valves.StuckThreadDetectionValve;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Repository
@Transactional(readOnly = true)
public interface ClientRepository extends JpaRepository<Client, Long> {

//    @Query("SELECT s FROM Client s WHERE s.email = ?1")
//    Optional<Client> findClientByEmail(String email);

    Optional<Client>findClientByEmail(String email);
}
