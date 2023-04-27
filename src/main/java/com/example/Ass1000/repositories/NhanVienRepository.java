package com.example.Ass1000.repositories;

import com.example.Ass1000.entity.NhanVien;
import com.example.Ass1000.util.HibernateUtil;
import jakarta.persistence.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.ArrayList;
import java.util.List;

public class NhanVienRepository {
    // CRUD <=> CREATE , READ , UPDATE, DELETE <=> INSERT INTO , SELECT , UPDATE, DEELTE
    // GET ALL <=> READ
    public List<NhanVien> getAll() {
        List<NhanVien> lists = new ArrayList<>();
        // CODE
        try (Session session = HibernateUtil.getFACTORY().openSession()) {
            Query query = session.createQuery("FROM NhanVien", NhanVien.class);
            lists = query.getResultList();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return lists;
    }

    // GET ONE <=> SELECT <=> CO Tham So
    public NhanVien getOne(Long id) {
        NhanVien nv = null;
        try (Session session = HibernateUtil.getFACTORY().openSession()) {
            Query query = session.createQuery("FROM NhanVien WHERE id =:id1", NhanVien.class);
            query.setParameter("id1", id);
            nv = (NhanVien) query.getSingleResult();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return nv;
    }

    // ADD - INSERT INTO
    public Boolean add(NhanVien nv) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getFACTORY().openSession()) {
            // Mo transaction
            transaction = session.beginTransaction();
            // Add 1 doi tuong : presist
            session.persist(nv);
            // Commit
            transaction.commit();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    // Update
    public Boolean update(NhanVien nv) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getFACTORY().openSession()) {
            // Mo transaction
            transaction = session.beginTransaction();
            // Update 1 doi tuong : merge
            session.merge(nv);
            // Commit
            transaction.commit();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    // Delete : delte
    public Boolean delete(NhanVien nv) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getFACTORY().openSession()) {
            // Mo transaction
            transaction = session.beginTransaction();
            // Delete 1 doi tuong : delete
            session.delete(nv);
            // Commit
            transaction.commit();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public static void main(String[] args) {
        new NhanVienRepository().getAll().forEach(s -> System.out.println(s.toString()));
//        System.out.println(new NhanVienRepository().getOne(1L));
    }
}
