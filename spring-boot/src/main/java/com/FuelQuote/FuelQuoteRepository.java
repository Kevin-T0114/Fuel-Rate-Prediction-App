package com.FuelQuote;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.sql.Date;
import java.util.List;

@Repository
public interface FuelQuoteRepository extends JpaRepository<FuelQuote, Long>{
    
    @Query(value = "SELECT user_id FROM user_profile WHERE username = :username", nativeQuery = true)
    Long findbyUsername(@Param("username") String username);

    @Query(value = "SELECT * FROM quote WHERE user_id = :user_id ORDER BY delivery_date DESC", nativeQuery = true)
    List<FuelQuote> findByUserID(@Param("user_id") Long user_id);

    @Query(value = "SELECT state FROM user_profile WHERE username = :username", nativeQuery = true)
    String findStateByUsername(@Param("username") String username);

    @Modifying
    @Query(value = "INSERT INTO quote (delivery_date, gallons_requested, price_per_gallon, total, address, user_id) VALUES (:delivery_date, :gallons_requested, :price_per_gallon, :total, :address, :user_id)", nativeQuery = true)
    void quoteInsertion(@Param("delivery_date") Date delivery_date, @Param("gallons_requested") float gallons_requested, @Param("price_per_gallon") double price_per_gallon, @Param("total") double total, @Param("address") String address, @Param("user_id") Long user_id);

    @Query(value = "SELECT COUNT(*) FROM quote WHERE user_id = :user_id", nativeQuery = true)
    int getNumQuoteRows(@Param("user_id") Long user_id);

    @Query(value = "SELECT address1 FROM user_profile WHERE username = :username", nativeQuery = true)
    String findAddressByUsername(@Param("username") String username);
}
