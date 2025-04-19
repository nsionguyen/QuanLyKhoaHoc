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
public class KhoaHoc {
    private int id;
    private String tenKhoaHoc;
    private String moTa;
    private Date ngayKhaiGiang;
    private int soLuongToiDa;
    private int giangVienID;
    private int gia;
    private String hinhAnh;

    public KhoaHoc(int id, String tenKhoaHoc, String moTa, Date ngayKhaiGiang, int soLuongToiDa, int giangVienID, int gia, String hinhAnh) {
        this.id = id;
        this.tenKhoaHoc = tenKhoaHoc;
        this.moTa = moTa;
        this.ngayKhaiGiang = ngayKhaiGiang;
        this.soLuongToiDa = soLuongToiDa;
        this.giangVienID = giangVienID;
        this.gia = gia;
        this.hinhAnh = hinhAnh;
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
     * @return the tenKhoaHoc
     */
    public String getTenKhoaHoc() {
        return tenKhoaHoc;
    }

    /**
     * @param tenKhoaHoc the tenKhoaHoc to set
     */
    public void setTenKhoaHoc(String tenKhoaHoc) {
        this.tenKhoaHoc = tenKhoaHoc;
    }

    /**
     * @return the moTa
     */
    public String getMoTa() {
        return moTa;
    }

    /**
     * @param moTa the moTa to set
     */
    public void setMoTa(String moTa) {
        this.moTa = moTa;
    }

    /**
     * @return the ngayKhaiGiang
     */
    public Date getNgayKhaiGiang() {
        return ngayKhaiGiang;
    }

    /**
     * @param ngayKhaiGiang the ngayKhaiGiang to set
     */
    public void setNgayKhaiGiang(Date ngayKhaiGiang) {
        this.ngayKhaiGiang = ngayKhaiGiang;
    }

    /**
     * @return the soLuongToiDa
     */
    public int getSoLuongToiDa() {
        return soLuongToiDa;
    }

    /**
     * @param soLuongToiDa the soLuongToiDa to set
     */
    public void setSoLuongToiDa(int soLuongToiDa) {
        this.soLuongToiDa = soLuongToiDa;
    }

    /**
     * @return the giangVienID
     */
    public int getGiangVienID() {
        return giangVienID;
    }

    /**
     * @param giangVienID the giangVienID to set
     */
    public void setGiangVienID(int giangVienID) {
        this.giangVienID = giangVienID;
    }

    /**
     * @return the gia
     */
    public int getGia() {
        return gia;
    }

    /**
     * @param gia the gia to set
     */
    public void setGia(int gia) {
        this.gia = gia;
    }

    /**
     * @return the hinhAnh
     */
    public String getHinhAnh() {
        return hinhAnh;
    }

    /**
     * @param hinhAnh the hinhAnh to set
     */
    public void setHinhAnh(String hinhAnh) {
        this.hinhAnh = hinhAnh;
    }
    
}
