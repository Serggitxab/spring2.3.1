package ru.zarya.spring.config.dao;




import org.springframework.stereotype.Repository;
import ru.zarya.spring.config.models.User;


import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class UserDaoImpl implements UserDao {
    @PersistenceContext
    private EntityManager entityManager;

    public EntityManager getEntityManager() {
        return entityManager;
    }

    @Override
    public List<User> showUser() {

        return getEntityManager().createQuery("select u from User u",User.class).getResultList();
    }

    @Override
    public void saveUser(User user) {
        getEntityManager().persist(user);
    }


    @Override
    public void updateUser(int id, User user) {
        getEntityManager().merge(user);
    }

    @Override
    public void removeUser(int id) {
        getEntityManager().remove(getUser(id));

    }

    @Override
    public User getUser(int id) {
        return getEntityManager().find(User.class, id);

    }
}