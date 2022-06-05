package com.bs32.GrFX.service;

import com.bs32.GrFX.model.Item;

import java.util.Collection;

public interface ItemService {
    Item register(Item item);
    Collection<Item> list(int limit);
}
