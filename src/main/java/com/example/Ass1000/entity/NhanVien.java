package com.example.Ass1000.entity;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.JoinColumn;

import java.io.Serializable;
import java.sql.Date;
import java.util.UUID;

@Entity
@Table(name = "NhanVien")
public class NhanVien implements Serializable {

    @Id
    @Column(name = "Id")
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    @Column(name = "Ten")
    private String ten;
    @Column(name = "Ma")
    private String ma;
    @Column(name = "TenDem")
    private String tenDem;
    @Column(name = "Ho")
    private String ho;
    @Column(name = "NgaySinh")
    private Date ngaySinh;
    @Column(name = "DiaChi")
    private String diaChi;
    @Column(name = "Sdt")
    private String sdt;
    @Column(name = "MatKhau")
    private String matKhau;
    @Column(name = "IdCH")
    private UUID idCH;

    @ManyToOne()
    @JoinColumn(name = "IdCV")
    private ChucVu cv;

    @Column(name = "IdGuiBC")
    private UUID idGuiBC;

    public NhanVien() {
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public String getMa() {
        return ma;
    }

    public void setMa(String ma) {
        this.ma = ma;
    }

    public String getTenDem() {
        return tenDem;
    }

    public void setTenDem(String tenDem) {
        this.tenDem = tenDem;
    }

    public String getHo() {
        return ho;
    }

    public void setHo(String ho) {
        this.ho = ho;
    }

    public Date getNgaySinh() {
        return ngaySinh;
    }

    public void setNgaySinh(Date ngaySinh) {
        this.ngaySinh = ngaySinh;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }

    public String getSdt() {
        return sdt;
    }

    public void setSdt(String sdt) {
        this.sdt = sdt;
    }

    public String getMatKhau() {
        return matKhau;
    }

    public void setMatKhau(String matKhau) {
        this.matKhau = matKhau;
    }

    public UUID getIdCH() {
        return idCH;
    }

    public void setIdCH(UUID idCH) {
        this.idCH = idCH;
    }

    public ChucVu getCv() {
        return cv;
    }

    public void setCv(ChucVu cv) {
        this.cv = cv;
    }

    public UUID getIdGuiBC() {
        return idGuiBC;
    }

    public void setIdGuiBC(UUID idGuiBC) {
        this.idGuiBC = idGuiBC;
    }

    public NhanVien(UUID id, String ten, String ma, String tenDem, String ho, Date ngaySinh, String diaChi, String sdt, String matKhau, UUID idCH, ChucVu cv, UUID idGuiBC) {
        this.id = id;
        this.ten = ten;
        this.ma = ma;
        this.tenDem = tenDem;
        this.ho = ho;
        this.ngaySinh = ngaySinh;
        this.diaChi = diaChi;
        this.sdt = sdt;
        this.matKhau = matKhau;
        this.idCH = idCH;
        this.cv = cv;
        this.idGuiBC = idGuiBC;
    }

    @Override
    public String toString() {
        return "NhanVien{" +
                "id=" + id +
                ", ten='" + ten + '\'' +
                ", ma='" + ma + '\'' +
                ", tenDem='" + tenDem + '\'' +
                ", ho='" + ho + '\'' +
                ", ngaySinh=" + ngaySinh +
                ", diaChi='" + diaChi + '\'' +
                ", sdt='" + sdt + '\'' +
                ", matKhau='" + matKhau + '\'' +
                ", idCH=" + idCH +
                ", cv=" + cv +
                ", idGuiBC=" + idGuiBC +
                '}';
    }
}
