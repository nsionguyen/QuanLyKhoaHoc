/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ntn.quankykhoahoc.Services;


import com.ntn.quankykhoahoc.pojo.JdbcUtils;
import com.ntn.quankykhoahoc.pojo.NguoiDung;
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
public class NguoiDungServices {
    public List<NguoiDung> getNguoiDungTheoEmail (String s) throws SQLException{
        List<NguoiDung> results = new ArrayList<>();
        Connection conn = JdbcUtils.getConn();
        String sql = "SELECT * FROM nguoidung WHERE email = ?";
        PreparedStatement stm = conn.prepareCall(sql);
        stm.setString(1,s );
        ResultSet rs = stm.executeQuery();
        while(rs.next()){
            NguoiDung c = new NguoiDung(rs.getInt("id"), rs.getString("ho_ten"), rs.getString("email"), rs.getString("mat_khau"), 
                    rs.getInt("loai_nguoi_dung_id"));
            results.add(c);
        }
        return results;
        
    }
}