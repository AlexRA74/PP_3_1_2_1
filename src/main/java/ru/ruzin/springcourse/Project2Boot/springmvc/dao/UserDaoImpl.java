package ru.javamentor.springmvc.dao;


import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Component;
import ru.javamentor.springmvc.model.User;



import java.util.List;

@Repository
public class UserDaoImpl implements UserDao {

    @PersistenceContext
    private EntityManager entityManager;


    @Override
    public void saveUser(User user) {
        entityManager.persist(user);
    }


    @Override
    public User getById(Long id) {
        return entityManager.find(User.class,id);
    }


    @Override
    public List<User> getAllUsers() {
        return entityManager.createQuery("from User",User.class).getResultList();

    }


    @Override
    public void update (User updateUser) {
        entityManager.merge(updateUser);
    }


    @Override
    public void removeUserById(long id) {
        User user = entityManager.find(User.class,id);
        entityManager.remove(user);

    }
}