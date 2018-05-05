package com.board.command;

import com.board.db.BoardDao;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by IntelliJ IDEA.
 * Project: MVC_Study
 * ===========================================
 * User: ByeongGil Jung
 * Date: 2018-05-06
 * Time: 오전 12:11
 */
public class BoardDeleteCommand implements BoardCommand {
    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) {
        if (request.getMethod().equals("GET")) {
            String bId = request.getParameter("bId");
            BoardDao dao = BoardDao.getInstance();
            dao.delete(bId);
        }
    }
}
