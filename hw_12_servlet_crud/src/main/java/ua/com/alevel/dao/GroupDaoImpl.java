package ua.com.alevel.dao;

import org.hibernate.Session;
import org.hibernate.Transaction;
import ua.com.alevel.entity.Group;
import ua.com.alevel.util.HibernateConfig;
import java.util.List;

public class GroupDaoImpl implements GroupDao {

    @Override
    public void create(Group group) {
        try (Session session = HibernateConfig.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            session.save(group);
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(Group group) {
        try (Session session = HibernateConfig.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            session.update(group);
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(int groupId) {
        try (Session session = HibernateConfig.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            Group group = session.get(Group.class, groupId);
            if (group != null) {
                session.delete(group);
            }
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public Group findById(int groupId) {
        try (Session session = HibernateConfig.getSessionFactory().openSession()) {
            return session.get(Group.class, groupId);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<Group> findAll() {
        try (Session session = HibernateConfig.getSessionFactory().openSession()) {
            return session.createQuery("from Group", Group.class).list();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
