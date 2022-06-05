package com.bs32.GrFX.service.implementation;

import com.bs32.GrFX.Repo.ItemRepo;
import com.bs32.GrFX.model.Item;
import com.bs32.GrFX.service.ItemService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.transaction.Transactional;
import java.util.Collection;
import java.util.Random;

@RequiredArgsConstructor
@Service
@Transactional
@Slf4j
public class ItemServiceImpl implements ItemService {
    private final ItemRepo itemRepo;
    @Override
    public Item register(Item item) {
        log.info("Registering new item: {}", item.getName());
        item.setImageUrl(setItemImageUrl());
        return itemRepo.save(item);
    }

    @Override
    public Collection<Item> list(int limit) {
        log.info("Fetching all items");
        return itemRepo.findAll(PageRequest.of(0, limit)).toList();
    }

    private String setItemImageUrl(){
        String[] imageNames = {"Grinder1.png", "Grinder1.png", "Grinder1.png", "Grinder1.png"};
        return ServletUriComponentsBuilder.fromCurrentContextPath().path("/server/image" + imageNames[new Random().nextInt(4)]).toUriString();
    }
}