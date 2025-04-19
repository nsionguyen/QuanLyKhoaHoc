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
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ADMIN
 */
public class KhoaHocDaDangKyServices {
    public List<KhoaHoc> getKhoaHocDaDangKyTheoHocVienID(int id) throws SQLException{
        
        
        
        List<KhoaHoc> kh = new ArrayList<>();
        Connection conn1 = JdbcUtils.getConn();
        String sql = " SELECT khoahoc.* FROM khoahoc LEFT JOIN dangkykhoahoc ON khoahoc.id = dangkykhoahoc.khoaHocID "
                + "WHERE dangkykhoahoc.hocVienID = ?";
        PreparedStatement stm = conn1.prepareStatement(sql);
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
