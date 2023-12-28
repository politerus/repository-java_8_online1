package ua.com.alevel.dao;

import org.hibernate.Session;
import org.hibernate.Transaction;
import ua.com.alevel.entity.Student;
import ua.com.alevel.util.HibernateConfig;

import java.util.Collections;
import java.util.List;

public class StudentDaoImpl implements StudentDao {

    @Override
    public void create(Student student) {
        Transaction transaction = null;
        try (Session session = HibernateConfig.getInstance().getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.save(student);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }

    @Override
    public void update(Student student) {
        Transaction transaction = null;
        try (Session session = HibernateConfig.getInstance().getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.update(student);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }

    @Override
    public void delete(int studentId) {
        Transaction transaction = null;
        try (Session session = HibernateConfig.getInstance().getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            Student student = session.get(Student.class, studentId);
            if (student != null) {
                session.delete(student);
            }
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }

    @Override
    public Student findById(int studentId) {
        try (Session session = HibernateConfig.getInstance().getSessionFactory().openSession()) {
            return session.get(Student.class, studentId);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<Student> findAll() {
        try (Session session = HibernateConfig.getInstance().getSessionFactory().openSession()) {
            return session.createQuery("from Student").list();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    public List<Student> findStudentsByGroupId(int groupId) {
        try (Session session = HibernateConfig.getInstance().getSessionFactory().openSession()) {
            return session.createQuery("FROM Student WHERE group.id = :groupId", Student.class)
                    .setParameter("groupId", groupId) // groupId - это ID группы
                    .list();
        } catch (Exception e) {
            e.printStackTrace();
            return Collections.emptyList();
        }
    }
}

