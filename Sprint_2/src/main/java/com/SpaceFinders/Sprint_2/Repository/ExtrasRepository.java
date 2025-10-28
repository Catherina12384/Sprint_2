package com.SpaceFinders.Sprint_2.Repository;

import com.SpaceFinders.Sprint_2.Entity.Extras;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ExtrasRepository extends JpaRepository<Extras, Integer> {

    boolean existsByExtrasNameIgnoreCase(String extrasName);

    Extras findByExtrasNameIgnoreCase(String extrasName);

    List<Extras> findAllByExtrasIsActive(boolean extrasIsActive);
}
