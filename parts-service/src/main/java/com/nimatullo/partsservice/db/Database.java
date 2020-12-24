package com.nimatullo.partsservice.db;

import com.nimatullo.partsservice.models.GraphicsCard;

import java.util.HashMap;
import java.util.Map;

public class Database {
    int numberOfItems = 0;
    private final Map<Integer, GraphicsCard> graphicsCardMap;

    public Database() {
        this.graphicsCardMap = new HashMap<>();
        graphicsCardMap.put(++numberOfItems, new GraphicsCard("EVGA", "GTX 1080 Ti", "Nvidia", 745.99));
        graphicsCardMap.put(++numberOfItems, new GraphicsCard("EVGA", "RTX 2080 Ti", "Nvidia", 1200.99));
    }

    public GraphicsCard get(int n) {
        return graphicsCardMap.get(n);
    }

    public int size() {
        return numberOfItems;
    }
}
