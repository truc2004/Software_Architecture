package org.example.data_partition_horizontal.Repository;

import org.example.data_partition_horizontal.Entity.UserFemale;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserFemaleRepository extends JpaRepository<UserFemale, Integer> {
}