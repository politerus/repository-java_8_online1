package ua.com.alevel.dao;

import org.hibernate.Session;
import org.hibernate.Transaction;
import ua.com.alevel.entity.Group;
import ua.com.alevel.util.HibernateUtil;

import java.util.List;

public class GroupDaoImpl implements GroupDao {

    @Override
    public void create(Group group) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.save(group);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }

    @Override
    public void update(Group group) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.update(group);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }

    @Override
    public void delete(int groupId) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            Group group = session.get(Group.class, groupId);
            if (group != null) {
                session.delete(group);
            }
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<Group> findAll() {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.createQuery("from Group").list();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    @Override
    public Group findById(int groupId) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.get(Group.class, groupId);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

}
