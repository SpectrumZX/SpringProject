package com.platform.db.dao;

import com.platform.db.TransactionalManager;
import com.platform.db.entity.UserEntity;
import org.hibernate.HibernateException;

import javax.persistence.PersistenceException;
import javax.persistence.TypedQuery;
import javax.sql.rowset.spi.TransactionalWriter;
import java.io.Serializable;
import java.util.List;

public class UserDAO {

    public static UserEntity findByName(String name) {
        return TransactionalManager.queryExecutor(session -> {
                @SuppressWarnings("JpaQlInspection") TypedQuery<UserEntity> query = session.createQuery("FROM com.platform.db.entity.UserEntity U WHERE U.userName=:u_name");
                query.setParameter("u_name", name);
                query.setMaxResults(1);
                return query.getSingleResult();
        });
    }

    public static UserEntity findById(Integer id) {
        return TransactionalManager.queryExecutor(session -> session.get(UserEntity.class, id));
    }


    public static boolean removeUser(UserEntity user) {
        return TransactionalManager.transactionExecutor(session -> {
            try {
                session.remove(user);
                return true;
            }
            catch (PersistenceException ex){
                return false;
            }

        });
    }

    public static boolean update(UserEntity user) {
         TransactionalManager.voidTransactionExecutor(session -> session.update(user));
         return true;
    }

    public static Serializable addUser(UserEntity user) {
          return TransactionalManager.transactionExecutor(session -> {
              return session.save(user);
          });
    }

    public static List<UserEntity> findAll() {
        return TransactionalManager.queryExecutor(session -> {
            @SuppressWarnings("JpaQlInspection") TypedQuery<UserEntity> query = session.createQuery("FROM com.platform.db.entity.UserEntity U");
            query.setMaxResults(1000);
            return query.getResultList();
        });
    }

}
