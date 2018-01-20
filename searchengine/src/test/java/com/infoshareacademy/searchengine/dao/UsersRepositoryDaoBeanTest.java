package com.infoshareacademy.searchengine.dao;

import com.infoshareacademy.searchengine.domain.User;
import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.Archive;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.asset.EmptyAsset;
import org.jboss.shrinkwrap.api.spec.WebArchive;
import org.junit.Test;
import org.junit.runner.RunWith;

import javax.ejb.EJB;

@RunWith(Arquillian.class)
public class UsersRepositoryDaoBeanTest {

    @EJB
    private UsersRepositoryDao usersRepositoryDao;

    @Deployment
    public static Archive<?> createDeployment() {
        return ShrinkWrap.create(WebArchive.class)
                .addClasses();
    }

    @Test
    public void addUser() throws Exception {
        User user = new User();
        usersRepositoryDao.addUser(user);
    }
}