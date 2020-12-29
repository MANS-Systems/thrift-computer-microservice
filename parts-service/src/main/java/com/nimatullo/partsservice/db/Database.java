package com.nimatullo.partsservice.db;

import com.nimatullo.partsservice.models.GraphicsCard;

import java.util.*;
import java.util.stream.Collectors;

public class Database {
    int numberOfItems = 0;
    private final Map<Integer, GraphicsCard> graphicsCardMap;

    public Database() {
        this.graphicsCardMap = Map.of(
                ++numberOfItems, new GraphicsCard("EVGA", "GTX 1080 Ti", "Nvidia", 745.99),
                ++numberOfItems, new GraphicsCard("EVGA", "RTX 2080 Ti", "Nvidia", 1200.99),
                ++numberOfItems, new GraphicsCard("PowerColor", "AMD Radeon RX 5500 XT", "AMD", 79.99),
                ++numberOfItems, new GraphicsCard("MSI", "GTX 1660 Super", "Nvidia", 549.99)
        );
    }

    public GraphicsCard get(int n) {
        return graphicsCardMap.get(n);
    }

    public int size() {
        return numberOfItems;
    }

    public List<GraphicsCard> getAll() {
        return new ArrayList<>(graphicsCardMap.values());
    }
}
