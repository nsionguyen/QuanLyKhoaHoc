/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ntn.quankykhoahoc.Services;




import com.ntn.quankykhoahoc.pojo.JdbcUtils;
import com.ntn.quankykhoahoc.pojo.KhoaHoc;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author ADMIN
 */
public class KhoaHocServices {
     public List<KhoaHoc> getKhoaHocs () throws SQLException{
        List<KhoaHoc> results = new ArrayList<>();
         Connection conn = JdbcUtils.getConn();
        String sql = "SELECT * FROM khoahoc";
         PreparedStatement stm = conn.prepareCall(sql);
         ResultSet rs = stm.executeQuery();
        while(rs.next()){
            KhoaHoc c = new KhoaHoc(rs.getInt("id"), rs.getString("tenKhoaHoc"), rs.getString("moTa"), rs.getDate("ngayKhaiGiang"), 
                    rs.getInt("soLuongToiDa"), rs.getInt("giangVienID"), rs.getInt("gia"), rs.getString("hinhAnh"));
            results.add(c);
        }
        return results;
     }
     public List<KhoaHoc> getKhoaHocID(int i) throws SQLException {
    List<KhoaHoc> kh = new ArrayList<>();
    Connection conn = JdbcUtils.getConn();
    String sql = "SELECT * FROM khoahoc WHERE id = ?";
    PreparedStatement stm = conn.prepareStatement(sql);
    stm.setInt(1, i);
    ResultSet rs = stm.executeQuery();

    while (rs.next()) {
        KhoaHoc c = new KhoaHoc(
            rs.getInt("id"), 
            rs.getString("tenKhoaHoc"), 
            rs.getString("moTa"), 
            rs.getDate("ngayKhaiGiang"),
            rs.getInt("soLuongToiDa"), 
            rs.getInt("giangVienID"), 
            rs.getInt("gia"), 
            rs.getString("hinhAnh")
        );
        kh.add(c);
    }
    
    // Đóng kết nối để tránh rò rỉ bộ nhớ
    rs.close();
    stm.close();
    conn.close();
    
    return kh;
}
     
     public List<KhoaHoc> getKhoaHocGiangVienID(int id) throws SQLException{
     List<KhoaHoc> kh = new ArrayList<>();
     Connection conn = JdbcUtils.getConn();
     String s = " SELECT khoahoc.* FROM khoahoc LEFT JOIN giangvien ON khoahoc.id = giangvien.id "
                + "WHERE khoahoc.giangVienID = ?";
     PreparedStatement stm = conn.prepareStatement(s);
     stm.setInt(1, id);
     ResultSet rs = stm.executeQuery();
     while (rs.next()) {
        KhoaHoc c = new KhoaHoc(
            rs.getInt("id"), 
            rs.getString("tenKhoaHoc"), 
            rs.getString("moTa"), 
            rs.getDate("ngayKhaiGiang"),
            rs.getInt("soLuongToiDa"), 
            rs.getInt("giangVienID"), 
            rs.getInt("gia"), 
            rs.getString("hinhAnh")
        );
        kh.add(c);
    }
     return kh;
     
}
    }

