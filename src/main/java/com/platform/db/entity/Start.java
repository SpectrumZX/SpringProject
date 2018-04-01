package com.platform.db.entity;

import com.platform.db.TransactionalManager;
import com.platform.db.dao.PostDAO;
import com.platform.db.dao.UserDAO;
import org.hibernate.mapping.Collection;

import java.lang.reflect.Field;
import java.util.Set;

public class Start {
    public static void main(String[] args) throws NoSuchFieldException, IllegalAccessException {

       TransactionalManager.queryExecutor(session -> {
            System.out.println(session.get(PostEntity.class, 1).getUser());
            System.out.println("-------------------------------");
            System.out.println(session.get(UserEntity.class, 1).getPost());
return null;
        });


    }
}
