package com.infoshareacademy.searchengine.repository;

import com.infoshareacademy.searchengine.domain.User;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Stateless
public class StatisticsRepository {

    public Map<User, Integer> getRepository() {
        Map<User, Integer> statisticsRepository = new HashMap<>();
        List<User> repository = new ArrayList<>();
        for (User user : repository) {
            statisticsRepository.put(user, 0);
        }
        return statisticsRepository;
    }
}
