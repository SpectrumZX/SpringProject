package com.platform.db;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceException;
import java.util.function.Consumer;
import java.util.function.Function;

public class TransactionalManager {

    private static final Logger log = LoggerFactory.getLogger(TransactionalManager.class);

    public static <T> T transactionExecutor(Function<Session, T> wrappedFunction) {
        Session session = null;
        try {
            session = HibernateUtil.getSession();
            final Transaction tx = session.beginTransaction();

            T result = wrappedFunction.apply(session);

            session.flush();
            tx.commit();
            return result;
        } catch (PersistenceException pe) {
            log.error("Transaction Error:", pe);
            if (session != null) {
                Transaction tx = session.getTransaction();
                tx.rollback();
            }
        } finally {
            if (session != null) {
                session.close();
            }
        }
        return null;
    }

    public static void voidTransactionExecutor(Consumer<Session> toRun) {
        Session session = null;
        try {
            session = HibernateUtil.getSession();
            final Transaction tx = session.beginTransaction();

            toRun.accept(session);

            session.flush();
            tx.commit();
        } catch (PersistenceException pe) {
            log.error("Transaction Error:", pe);
            if (session != null) {
                Transaction tx = session.getTransaction();
                tx.rollback();
            }
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

        public static <T> T queryExecutor(Function<Session, T> wrappedFunction) {
            Session session = null;
            try {
                session = HibernateUtil.getSession();

                T result = wrappedFunction.apply(session);

                return result;
            } catch (NoResultException e) {
                log.info(e.getMessage());
                return null;
            } catch (PersistenceException pe) {
                log.error("DB Error:", pe);
            }
            finally {
                if (session != null) {
                    session.close();
                }
            }
            return null;
        }
    }

