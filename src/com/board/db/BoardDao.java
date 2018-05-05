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

    public void write(String bName, String bTitle, String bContent) {
        Connection conn = null;
        PreparedStatement pstmt = null;

        try {
            String sql =
                    "INSERT INTO mvc_board\n" +
                    "(bId, bName, bTitle, bContent, bHit, bGroup, bStep, bIndent)\n" +
                    "VALUES (mvc_board_seq.nextval, ?, ?, ?, 0, mvc_board_seq.currval, 0, 0)";
            conn = getConnection();
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, bName);
            pstmt.setString(2, bTitle);
            pstmt.setString(3, bContent);
            int rn = pstmt.executeUpdate();
            if (rn == 1)
                System.out.println("Insert Success");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (pstmt != null) pstmt.close();
                if (conn != null) conn.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public ArrayList<BoardDto> list() {
        ArrayList<BoardDto> dtos = new ArrayList<>();
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        try {
            String sql =
                    "SELECT bId, bName, bTitle, bContent, bDate, bHit, bGroup, bStep, bIndent\n" +
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
        // Increase the hit of board
        upHit(bId);

        BoardDto dto = null;
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        try {
            int bId_int = Integer.parseInt(bId);
            String sql =
                    "SELECT *\n" +
                    "FROM mvc_board\n" +
                    "WHERE bID = ?";
            conn = getConnection();
            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, bId_int);
            rs = pstmt.executeQuery();

            while (rs.next()) {
                String bName = rs.getString("bName");
                String bTitle = rs.getString("bTitle");
                String bContent = rs.getString("bContent");
                Timestamp bDate = rs.getTimestamp("bDate");
                int bHit = rs.getInt("bHit");
                int bGroup = rs.getInt("bGroup");
                int bStep = rs.getInt("bStep");
                int bIndent = rs.getInt("bIndent");

                dto = new BoardDto(bId_int, bName, bTitle, bContent, bDate, bHit, bGroup, bStep, bIndent);
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
        return dto;
    }

    public void modify(String bId, String bName, String bTitle, String bContent) {
        Connection conn = null;
        PreparedStatement pstmt = null;

        try {
            String sql =
                    "UPDATE mvc_board\n" +
                    "SET bName = ?, bTitle = ?, bContent = ?\n" +
                    "WHERE bId = ?";

            conn = getConnection();
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, bName);
            pstmt.setString(2, bTitle);
            pstmt.setString(3, bContent);
            pstmt.setInt(4, Integer.parseInt(bId));
            int rn = pstmt.executeUpdate();
            if (rn == 1)
                System.out.println("Modify Success");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (pstmt != null) pstmt.close();
                if (conn != null) conn.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void delete(String bId) {
        Connection conn = null;
        PreparedStatement pstmt = null;

        try {
            String sql =
                    "DELETE\n" +
                    "FROM mvc_board\n" +
                    "WHERE bId = ?";

            conn = getConnection();
            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, Integer.parseInt(bId));
            int rn = pstmt.executeUpdate();
            if (rn == 1)
                System.out.println("Delete Success");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (pstmt != null) pstmt.close();
                if (conn != null) conn.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    private void upHit(String bId) {
        Connection conn = null;
        PreparedStatement pstmt = null;

        try {
            String sql =
                    "UPDATE mvc_board\n" +
                    "SET bHit = bHit + 1\n" +
                    "WHERE bId = ?";

            conn = getConnection();
            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, Integer.parseInt(bId));
            int rn = pstmt.executeUpdate();
            if (rn == 1)
                System.out.println("Increasing the Hit");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (pstmt != null) pstmt.close();
                if (conn != null) conn.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
