/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ntn.quankykhoahoc.pojo;

import java.sql.Date;
import javafx.scene.chart.PieChart;

/**
 *
 * @author ADMIN
 */
public class KhoaHocDaDangKy {
    private int id;
    private int hocVienID;
    private int khoaHocID;
    private Date ngayDangKy;
    private boolean daThanhToan;

    public KhoaHocDaDangKy(int id, int hocVienID, int khoaHocID, Date ngayDangKy, boolean daThanhToan) {
        this.id = id;
        this.hocVienID = hocVienID;
        this.khoaHocID = khoaHocID;
        this.ngayDangKy = ngayDangKy;
        this.daThanhToan = daThanhToan;
    }

    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * @return the hocVienID
     */
    public int getHocVienID() {
        return hocVienID;
    }

    /**
     * @param hocVienID the hocVienID to set
     */
    public void setHocVienID(int hocVienID) {
        this.hocVienID = hocVienID;
    }

    /**
     * @return the khoaHocID
     */
    public int getKhoaHocID() {
        return khoaHocID;
    }

    /**
     * @param khoaHocID the khoaHocID to set
     */
    public void setKhoaHocID(int khoaHocID) {
        this.khoaHocID = khoaHocID;
    }

    /**
     * @return the ngayDangKy
     */
    public Date getNgayDangKy() {
        return ngayDangKy;
    }

    /**
     * @param ngayDangKy the ngayDangKy to set
     */
    public void setNgayDangKy(Date ngayDangKy) {
        this.ngayDangKy = ngayDangKy;
    }

    /**
     * @return the daThanhToan
     */
    public boolean isDaThanhToan() {
        return daThanhToan;
    }

    /**
     * @param daThanhToan the daThanhToan to set
     */
    public void setDaThanhToan(boolean daThanhToan) {
        this.daThanhToan = daThanhToan;
    }
    
    
    
    
}
