/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ntn.quankykhoahoc.pojo;

/**
 *
 * @author ADMIN
 */
public class NguoiDung {
    private int id;
    private String ho_ten;
    private String email;
    private String mat_khau;
    private int loai_nguoi_dung_id;

    public NguoiDung(int id, String ho_ten, String email, String mat_khau, int loai_nguoi_dung_id) {
        this.id = id;
        this.ho_ten = ho_ten;
        this.email = email;
        this.mat_khau = mat_khau;
        this.loai_nguoi_dung_id = loai_nguoi_dung_id;
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
     * @return the ho_ten
     */
    public String getHo_ten() {
        return ho_ten;
    }

    /**
     * @param ho_ten the ho_ten to set
     */
    public void setHo_ten(String ho_ten) {
        this.ho_ten = ho_ten;
    }

    /**
     * @return the email
     */
    public String getEmail() {
        return email;
    }

    /**
     * @param email the email to set
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * @return the mat_khau
     */
    public String getMat_khau() {
        return mat_khau;
    }

    /**
     * @param mat_khau the mat_khau to set
     */
    public void setMat_khau(String mat_khau) {
        this.mat_khau = mat_khau;
    }

    /**
     * @return the loai_nguoi_dung_id
     */
    public int getLoai_nguoi_dung_id() {
        return loai_nguoi_dung_id;
    }

    /**
     * @param loai_nguoi_dung_id the loai_nguoi_dung_id to set
     */
    public void setLoai_nguoi_dung_id(int loai_nguoi_dung_id) {
        this.loai_nguoi_dung_id = loai_nguoi_dung_id;
    }
}

    
