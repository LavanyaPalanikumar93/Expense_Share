package com.example.expenseShare.service;


import org.springframework.stereotype.Component;

import java.util.Map;

@Component
public class CategoryPredictor {

    private static final Map<String, String> categoryMap = Map.ofEntries(
            Map.entry("coffee", "Food"),
            Map.entry("lunch", "Food"),
            Map.entry("dinner", "Food"),
            Map.entry("restaurant", "Food"),
            Map.entry("uber", "Travel"),
            Map.entry("flight", "Travel"),
            Map.entry("taxi", "Travel"),
            Map.entry("groceries", "Groceries"),
            Map.entry("supermarket", "Groceries"),
            Map.entry("rent", "Rent"),
            Map.entry("movie", "Entertainment"),
            Map.entry("netflix", "Entertainment")
    );


    public String predictCategory(String description) {
        description = description.toLowerCase();

        for (Map.Entry<String, String> entry : categoryMap.entrySet()) {
            if (description.contains(entry.getKey())) {
                return entry.getValue();
            }
        }

        return "Others";
    }
}
