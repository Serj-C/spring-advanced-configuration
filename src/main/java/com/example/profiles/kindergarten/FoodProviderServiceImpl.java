package com.example.profiles.kindergarten;

import com.example.profiles.Food;
import com.example.profiles.FoodProviderService;

import java.util.ArrayList;
import java.util.List;

public class FoodProviderServiceImpl implements FoodProviderService {
    @Override
    public List<Food> provideLunchSet() {
        List<Food> lunchSet = new ArrayList<>();
        lunchSet.add(new Food("Milk"));
        lunchSet.add(new Food("Biscuits"));

        return lunchSet;
    }
}
