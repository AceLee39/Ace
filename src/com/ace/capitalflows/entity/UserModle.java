package com.ace.capitalflows.entity;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.ace.capitalflows.db.DaoFactory;
import com.ace.capitalflows.utils.DBUtils;

public class UserModle {

    public static User getUserByUsername(final String username) throws Exception {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        User user = null;
        try {
            conn = DaoFactory.getInstance().getConn();
            final String sql = "select * from t_user where username=?";
            ps = conn.prepareStatement(sql);
            ps.setString(1, username);
            rs = ps.executeQuery();
            if(rs.next()) {
                user = new User();
                user.setId(rs.getInt("id"));
                user.setUsername(rs.getString("username"));
                user.setPassword(rs.getString("password"));
            }
        } catch (final SQLException e) {
            e.printStackTrace();
        }finally{
            try {
                DBUtils.closeRs(rs);
                DBUtils.closePs(ps);
                DBUtils.closeConn(conn);
            } catch (final Exception e) {
                e.printStackTrace();
            }
        }
        return user;
    }

    public static void saveUser(final User u) {
        Connection conn = null;
        PreparedStatement ps = null;
        try {
            conn = DaoFactory.getInstance().getConn();
            final String sql = "insert into t_user values(null,?,?)";
            ps = conn.prepareStatement(sql);
            ps.setString(1, u.getUsername());
            ps.setString(2, u.getPassword());
            ps.executeUpdate();
        } catch (final SQLException e) {
            try {
                conn.rollback();
            } catch (final SQLException e1) {
                e1.printStackTrace();
            }
            e.printStackTrace();
        }finally{
            try {
                DBUtils.closePs(ps);
                DBUtils.closeConn(conn);
            } catch (final Exception e) {
                e.printStackTrace();
            }
        }
    }
}
