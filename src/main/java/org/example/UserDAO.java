package org.example;

import org.jetbrains.annotations.NotNull;

import javax.persistence.*;
import javax.transaction.Transactional;
import java.util.List;

@Transactional
public class UserDAO {

    private static final EntityManagerFactory ENTITY_MANAGER_FACTORY = Persistence.createEntityManagerFactory("users");
    @PersistenceContext
    private EntityManager entityManager;

    public void add (User user){
        EntityManager entityManager = ENTITY_MANAGER_FACTORY.createEntityManager();
        EntityTransaction entityTransaction = entityManager.getTransaction();
        entityTransaction.begin();

        entityManager.persist(user);
        entityTransaction.commit();
    }

    public void edit(int id, @NotNull User user){
        EntityManager entityManager = ENTITY_MANAGER_FACTORY.createEntityManager();
        EntityTransaction entityTransaction = entityManager.getTransaction();
        entityTransaction.begin();

        User newUser = entityManager.find(User.class, id);
        newUser.setUsername(user.getUsername());
        newUser.setAge(user.getAge());

        entityManager.persist(newUser);
        entityTransaction.commit();
    }

    public void get (){
        EntityManager entityManager = ENTITY_MANAGER_FACTORY.createEntityManager();
        String query = "SELECT entry FROM User entry";

        TypedQuery<User> typedQuery = entityManager.createQuery(query, User.class);
        List<User> users = typedQuery.getResultList();

        for (User user : users) System.out.println(user.getId() + " " + user.getUsername() + " " + user.getAge());

    }

    public void get (String username) {
        EntityManager entityManager = ENTITY_MANAGER_FACTORY.createEntityManager();
        String query = "SELECT entry FROM User entry WHERE entry.username=:par1";

        TypedQuery<User> typedQuery = entityManager.createQuery(query, User.class);
        typedQuery.setParameter("par1", username);
        User user = typedQuery.getSingleResult();

        System.out.println(user.getId() + " " + user.getUsername() + " " + user.getAge());
    }

    public void get (int fromAge, int toAge) {
        EntityManager entityManager = ENTITY_MANAGER_FACTORY.createEntityManager();
        String query = "SELECT entry FROM User entry WHERE entry.age>=:par1 AND entry.age<:par2";

        TypedQuery<User> typedQuery = entityManager.createQuery(query, User.class);
        typedQuery.setParameter("par1", fromAge);
        typedQuery.setParameter("par2", toAge);
        List<User> users = typedQuery.getResultList();

        for (User user : users) System.out.println(user.getId() + " " + user.getUsername() + " " + user.getAge());
    }

    public void delete(int id){
        EntityManager entityManager = ENTITY_MANAGER_FACTORY.createEntityManager();
        EntityTransaction entityTransaction = entityManager.getTransaction();
        entityTransaction.begin();

        User user = entityManager.find(User.class, id);

        entityManager.remove(user);
        entityTransaction.commit();
    }

    public void delete(String username){
        EntityManager entityManager = ENTITY_MANAGER_FACTORY.createEntityManager();
        EntityTransaction entityTransaction = entityManager.getTransaction();
        entityTransaction.begin();
        String query = "SELECT entry FROM User entry WHERE entry.username=:par1";

        TypedQuery<User> typedQuery = entityManager.createQuery(query, User.class);
        typedQuery.setParameter("par1", username);
        User user = typedQuery.getSingleResult();

        entityManager.remove(user);
        entityTransaction.commit();
    }

}
