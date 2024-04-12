package com.ProfileManagement.springboot;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface UserProfileRepository extends JpaRepository<UserProfile, Long> {
    List<UserProfile> findByFullName(String fullName);
    List<UserProfile> findByAddress1(String address1);
    List<UserProfile> findByAddress2(String address2);
    List<UserProfile> findByCity(String city);
    List<UserProfile> findByState(String state);
    List<UserProfile> findByZipcode(String zipcode);
    List<UserProfile> findByProfileCompleted(boolean profileCompleted);
    List<UserProfile> findByID(Long id);
}
