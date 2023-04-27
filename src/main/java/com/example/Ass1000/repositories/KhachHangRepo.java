package com.example.Ass1000.repositories;

import com.example.Ass1000.entity.KhachHang;
import com.example.Ass1000.util.HibernateUtil;
import jakarta.persistence.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.ArrayList;
import java.util.List;

public class KhachHangRepo {
    // CRUD <=> CREATE , READ , UPDATE, DELETE <=> INSERT INTO , SELECT , UPDATE, DEELTE
    // GET ALL <=> READ
    public List<KhachHang> getAll() {
        List<KhachHang> lists = new ArrayList<>();
        // CODE
        try (Session session = HibernateUtil.getFACTORY().openSession()) {
            Query query = session.createQuery("FROM KhachHang", KhachHang.class);
            lists = query.getResultList();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return lists;
    }

    // GET ONE <=> SELECT <=> CO Tham So
    public KhachHang getOne(Long id) {
        KhachHang kh = null;
        try (Session session = HibernateUtil.getFACTORY().openSession()) {
            Query query = session.createQuery("FROM KHachHang WHERE id =:id1", KhachHang.class);
            query.setParameter("id1", id);
            kh = (KhachHang) query.getSingleResult();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return kh;
    }

    // ADD - INSERT INTO
    public Boolean add(KhachHang nv) {
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
    public Boolean update(KhachHang kh) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getFACTORY().openSession()) {
            // Mo transaction
            transaction = session.beginTransaction();
            // Update 1 doi tuong : merge
            session.merge(kh);
            // Commit
            transaction.commit();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    // Delete : delte
    public Boolean delete(KhachHang nv) {
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
        new KhachHangRepo().getAll().forEach(s -> System.out.println(s.toString()));
//        System.out.println(new NhanVienRepository().getOne(1L));
    }
}
