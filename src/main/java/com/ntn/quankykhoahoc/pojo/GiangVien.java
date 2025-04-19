/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ntn.quankykhoahoc.pojo;

import java.sql.Date;

/**
 *
 * @author ADMIN
 */
public class GiangVien {
    private int id;
    private Date ngay_sinh;
    private String so_dien_thoai;
    private String dia_chi;
    private String trinh_do;
    private int nam_kinh_nghiem;
    private String linh_vuc_chuyen_mon;

    public GiangVien(int id, Date ngay_sinh, String so_dien_thoai, String dia_chi, String trinh_do, int nam_kinh_nghiem, String linh_vuc_chuyen_mon) {
        this.id = id;
        this.ngay_sinh = ngay_sinh;
        this.so_dien_thoai = so_dien_thoai;
        this.dia_chi = dia_chi;
        this.trinh_do = trinh_do;
        this.nam_kinh_nghiem = nam_kinh_nghiem;
        this.linh_vuc_chuyen_mon = linh_vuc_chuyen_mon;
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
     * @return the ngay_sinh
     */
    public Date getNgay_sinh() {
        return ngay_sinh;
    }

    /**
     * @param ngay_sinh the ngay_sinh to set
     */
    public void setNgay_sinh(Date ngay_sinh) {
        this.ngay_sinh = ngay_sinh;
    }

    /**
     * @return the so_dien_thoai
     */
    public String getSo_dien_thoai() {
        return so_dien_thoai;
    }

    /**
     * @param so_dien_thoai the so_dien_thoai to set
     */
    public void setSo_dien_thoai(String so_dien_thoai) {
        this.so_dien_thoai = so_dien_thoai;
    }

    /**
     * @return the dia_chi
     */
    public String getDia_chi() {
        return dia_chi;
    }

    /**
     * @param dia_chi the dia_chi to set
     */
    public void setDia_chi(String dia_chi) {
        this.dia_chi = dia_chi;
    }

    /**
     * @return the trinh_do
     */
    public String getTrinh_do() {
        return trinh_do;
    }

    /**
     * @param trinh_do the trinh_do to set
     */
    public void setTrinh_do(String trinh_do) {
        this.trinh_do = trinh_do;
    }

    /**
     * @return the nam_kinh_nghiem
     */
    public int getNam_kinh_nghiem() {
        return nam_kinh_nghiem;
    }

    /**
     * @param nam_kinh_nghiem the nam_kinh_nghiem to set
     */
    public void setNam_kinh_nghiem(int nam_kinh_nghiem) {
        this.nam_kinh_nghiem = nam_kinh_nghiem;
    }

    /**
     * @return the linh_vuc_chuyen_mon
     */
    public String getLinh_vuc_chuyen_mon() {
        return linh_vuc_chuyen_mon;
    }

    /**
     * @param linh_vuc_chuyen_mon the linh_vuc_chuyen_mon to set
     */
    public void setLinh_vuc_chuyen_mon(String linh_vuc_chuyen_mon) {
        this.linh_vuc_chuyen_mon = linh_vuc_chuyen_mon;
    }
    
    
    
}
