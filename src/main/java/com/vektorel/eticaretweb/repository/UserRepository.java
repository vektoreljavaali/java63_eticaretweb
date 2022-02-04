package com.vektorel.eticaretweb.repository;

import com.vektorel.eticaretweb.repository.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {
    // Optional -> çerisinde bilgi olup olmadığın kontrol eden bir mekanizmaya
    // sahiptir. bu nedenle kontrol işlemlerinde kullanılır
    Optional<User> findOptionalByUsernameAndPassword(String username, String password);
}
