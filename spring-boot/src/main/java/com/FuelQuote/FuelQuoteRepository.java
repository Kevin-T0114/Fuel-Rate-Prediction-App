package com.FuelQuote;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FuelQuoteRepository extends JpaRepository<FuelQuote, Long>{
    
    @Query(value = "SELECT user_id FROM user_profile WHERE username = :username", nativeQuery = true)
    Long findbyUsername(@Param("username") String username);

    @Query(value = "SELECT * FROM quote WHERE user_id = :user_id ORDER BY delivery_date DESC", nativeQuery = true)
    List<FuelQuote> findByUserID(@Param("user_id") Long user_id);
}
