package com.infoshareacademy.searchengine.dao;

import com.infoshareacademy.searchengine.domain.User;
import com.infoshareacademy.searchengine.repository.UsersRepository;
import com.infoshareacademy.searchengine.servlets.Car;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

@Stateless
public class UsersRepositoryDaoBean implements UsersRepositoryDao {

    @PersistenceContext(unitName = "pUnit")
    private EntityManager entityManager;

    @Override
    public void addUser(User user) {
        List cars = entityManager.createQuery("from Car where model=:model")
                .setParameter("model", "A222S")
                .getResultList();

        entityManager.createQuery("update Car c set model=:model where model=:modelToUpdate")
                .setParameter("model", "Mazda")
                .setParameter("modelToUpdate", "A222S")
                .executeUpdate();


        System.out.println(cars);
        entityManager.persist(new Car("A222S"));
        UsersRepository.getRepository().add(user);
    }

    @Override
    public User getUserById(int id) {
        List<User> userList = UsersRepository.getRepository();
        for (User user : userList) {
            if (user.getId() == id) {
                return user;
            }
        }
        return null;
    }

    @Override
    public User getUserByLogin(String login) {
        List<User> userList = UsersRepository.getRepository();
        for (User user : userList) {
            if (user.getLogin().equals(login)) {
                return user;
            }
        }
        return null;
    }

    @Override
    public List<User> getUsersList() {
        return UsersRepository.getRepository();
    }

}
