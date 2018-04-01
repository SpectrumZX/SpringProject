package com.platform.db.dao;

import com.platform.db.TransactionalManager;
import com.platform.db.entity.PostEntity;
import com.platform.db.entity.UserEntity;
import javax.persistence.TypedQuery;
import java.io.Serializable;
import java.util.List;

public class PostDAO {

    public static PostEntity findById(Integer id) {
        return TransactionalManager.queryExecutor(session -> session.get(PostEntity.class, id));
    }

    public static boolean remove(PostEntity post) {
        return TransactionalManager.transactionExecutor(session -> {
            session.remove(post);
            return false;
        });
    }

    public static boolean update(PostEntity post) {
        TransactionalManager.voidTransactionExecutor(session -> session.update(post));
        return true;
    }

    public static Serializable add(PostEntity post) {
        return TransactionalManager.transactionExecutor(session -> {
            return session.save(post);
        });
    }

    public static List<PostEntity> findAll() {
        return TransactionalManager.queryExecutor(session -> {
            @SuppressWarnings("JpaQlInspection") TypedQuery<PostEntity> query = session.createQuery("FROM com.platform.db.entity.PostEntity P");
            query.setMaxResults(1000);
            return query.getResultList();
        });
    }

    public static Boolean deleteById(Integer id) {
        return TransactionalManager.queryExecutor(session -> {
            @SuppressWarnings("JpaQlInspection") TypedQuery<PostEntity> query = session.createQuery("FROM com.platform.db.entity.PostEntity P WHERE P.userName=:u_name");
            if(query.getSingleResult()!=null) return true;
            return false;
        });
    }
}
