package com.board.db;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.util.ArrayList;

/**
 * Created by IntelliJ IDEA.
 * Project: MVC_Study
 * ===========================================
 * User: ByeongGil Jung
 * Date: 2018-04-26
 * Time: 오전 12:35
 */
public class BoardDao {
    private static BoardDao instance = null;

    private BoardDao() {}

    public static BoardDao getInstance() {
        if (instance == null)
            instance = new BoardDao();
        return instance;
    }

    private Connection getConnection() {
        Context context = null;
        DataSource dataSource = null;
        Connection connection = null;
        try {
            context = new InitialContext();
            dataSource = (DataSource) context.lookup("java:comp/env/jdbc/Oracle11g");
            connection = dataSource.getConnection();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return connection;
    }

    public ArrayList<BoardDto> list() {
        ArrayList<BoardDto> dtos = new ArrayList<>();
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        try {
            String sql = "SELECT bId, bName, bTitle, bContent, bDate, bHit, bGroup, bStep, bIndent\n" +
                    "FROM mvc_board\n" +
                    "ORDER BY bGroup DESC, bStep ASC";
            conn = getConnection();
            pstmt = conn.prepareStatement(sql);
            rs = pstmt.executeQuery();

            while (rs.next()) {
                int bId = rs.getInt("bId");
                String bName = rs.getString("bName");
                String bTitle = rs.getString("bTitle");
                String bContent = rs.getString("bContent");
                Timestamp bDate = rs.getTimestamp("bDate");
                int bHit = rs.getInt("bHit");
                int bGroup = rs.getInt("bGroup");
                int bStep = rs.getInt("bStep");
                int bIndent = rs.getInt("bIndent");

                BoardDto dto = new BoardDto(bId, bName, bTitle, bContent, bDate, bHit, bGroup, bStep, bIndent);
                dtos.add(dto);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (rs != null) rs.close();
                if (pstmt != null) pstmt.close();
                if (conn != null) conn.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return dtos;
    }

    public BoardDto contentView(String bId) {
        BoardDto dto = null;
        return dto;
    }
}
