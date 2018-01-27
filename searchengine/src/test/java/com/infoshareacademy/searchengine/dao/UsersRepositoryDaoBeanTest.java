package com.infoshareacademy.searchengine.dao;

import com.infoshareacademy.searchengine.domain.Gender;
import com.infoshareacademy.searchengine.domain.Phone;
import com.infoshareacademy.searchengine.domain.User;
import com.infoshareacademy.searchengine.interceptors.AddUserInterceptor;
import com.infoshareacademy.searchengine.interceptors.AddUserSetGenderInterceptor;
import com.infoshareacademy.searchengine.repository.UsersRepository;
import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.arquillian.junit.InSequence;
import org.jboss.shrinkwrap.api.Archive;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.asset.EmptyAsset;
import org.jboss.shrinkwrap.api.spec.JavaArchive;
import org.jboss.shrinkwrap.api.spec.WebArchive;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

import javax.ejb.EJB;
import javax.jws.soap.SOAPBinding;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;

@RunWith(Arquillian.class)
public class UsersRepositoryDaoBeanTest {

    @EJB
    private UsersRepositoryDao usersRepositoryDao;
    @PersistenceContext(name = "Punit")
    private EntityManager em;

    @Deployment
    public static Archive<?> createDeployment()  {
        return ShrinkWrap.create(WebArchive.class)
                .addAsResource("test-persistence.xml", "META-INF/persistence.xml")
                .addClasses(
                        UsersRepositoryDaoBean.class,
                        UsersRepositoryDao.class,
                        UsersRepositoryDaoRemote.class,
                        UsersRepository.class,
                        User.class,
                        Gender.class,
                        Phone.class,
                        AddUserInterceptor.class,
                        AddUserSetGenderInterceptor.class
                );
    }

/*     @Test
     @InSequence(1)
     public void GetUserListTest()throws Exception{
     User user = new User();
     Assert.assertTrue(usersRepositoryDao.getUsersList().size()==1);

     }*/


    @Test
    @InSequence(2)
    public void addUser() throws Exception {
        User user = new User();
        user.setName("Name");
        usersRepositoryDao.addUser(user);

        Assert.assertTrue(usersRepositoryDao.getUserById(1).getGender().equals(Gender.MAN));
        Assert.assertTrue(usersRepositoryDao.getUsersList().size()==1);
//        List<User>users = em.createQuery("select u from User u", User.class).getResultList();
//        List<User>userList = usersRepositoryDao.getUsersList();
        //assertThat()
    }


}