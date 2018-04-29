package com.board.command;

import com.board.db.BoardDao;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by IntelliJ IDEA.
 * Project: MVC_Study
 * ===========================================
 * User: ByeongGil Jung
 * Date: 2018-04-29
 * Time: 오전 12:38
 */
public class BoardWriteCommand implements BoardCommand {
    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) {
        String bName = request.getParameter("bName");
        String bTitle = request.getParameter("bTitle");
        String bContent = request.getParameter("bContent");

        BoardDao dao = BoardDao.getInstance();
        dao.write(bName, bTitle, bContent);
    }
}
