package com.bs32.GrFX.Repo;

import com.bs32.GrFX.model.Item;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemRepo extends JpaRepository<Item, Long> {
    Item findByItemId(Long id);

}
