package com.infoshareacademy.searchengine.repository;

import com.infoshareacademy.searchengine.domain.User;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Stateless
public class StatisticsRepository {
    private static Map<User, Integer> statisticsRepository = new HashMap<>();

    @EJB
    UsersRepository usersRepository;

    public Map<User, Integer> getRepository() {
        fillRepositoryWithDefaults();
        return statisticsRepository;
    }

    private void fillRepositoryWithDefaults() {
        List<User> repository = usersRepository.getUsersList();
        for (User user : repository) {
            statisticsRepository.putIfAbsent(user, 0);
        }
    }
}
