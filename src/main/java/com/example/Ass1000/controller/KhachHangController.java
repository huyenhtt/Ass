package com.example.Ass1000.controller;

import com.example.Ass1000.entity.KhachHang;
import com.example.Ass1000.repositories.KhachHangRepo;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet({"/khach-hang/hien-thi","/khach-hang/add","/khach-hang/update","/khach-hang/delete","/khach-hang/detail"})
public class KhachHangController extends HttpServlet {
    private KhachHangRepo repo=new KhachHangRepo();
    private List<KhachHang> list=new ArrayList<>();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String uri=req.getRequestURI();
        if (uri.contains("hien-thi")){
            this.hienthi(req,resp);
        }
        else if(uri.contains("detail")){
            this.detail(req,resp);
        }
        else if(uri.contains("delete")){
            this.delete(req,resp);
        }
        else{
            this.hienthi(req,resp);
        }
    }

    private void delete(HttpServletRequest req, HttpServletResponse resp) {
    }

    private void detail(HttpServletRequest req, HttpServletResponse resp) {
    }

    private void hienthi(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
         list=repo.getAll();
         req.setAttribute("danhSachKH",list);
         req.getRequestDispatcher("/view/home.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String uri=req.getRequestURI();
        if (uri.contains("add")){
            this.addKH(req,resp);
        }
        else if(uri.contains("update")){
            this.updateKH(req,resp);
        }

        else{
            this.hienthi(req,resp);
        }
    }

    private void updateKH(HttpServletRequest req, HttpServletResponse resp) {
    }

    private void addKH(HttpServletRequest req, HttpServletResponse resp) {
    }
}
