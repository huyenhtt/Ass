package com.example.Ass1000.entity;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "ChucVu")
public class ChucVu implements Serializable {
    @Id
    @Column(name = "Id")
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(name = "Ma")
    private String ma;

    @Column(name = "Ten")
    private String ten;

    @OneToMany(
            mappedBy = "cv",
            fetch = FetchType.LAZY
    )
    private List<NhanVien> listNv;

    public ChucVu() {

    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getMa() {
        return ma;
    }

    public void setMa(String ma) {
        this.ma = ma;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public List<NhanVien> getListNv() {
        return listNv;
    }

    public void setListNv(List<NhanVien> listNv) {
        this.listNv = listNv;
    }

    @Override
    public String toString() {
        return "ChucVu{" +
                "id=" + id +
                ", ma='" + ma + '\'' +
                ", ten='" + ten + '\'' +
                ", listNv=" + listNv +
                '}';
    }

    public ChucVu(UUID id, String ma, String ten, List<NhanVien> listNv) {
        this.id = id;
        this.ma = ma;
        this.ten = ten;
        this.listNv = listNv;
    }
}
