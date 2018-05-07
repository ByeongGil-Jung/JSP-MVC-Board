package com.board.command;

import com.board.db.BoardDao;
import com.board.db.BoardDto;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by IntelliJ IDEA.
 * Project: MVC_Study
 * ===========================================
 * User: ByeongGil Jung
 * Date: 2018-05-06
 * Time: 오후 6:05
 */
public class BoardReplyCommand implements BoardCommand {
    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) {
        String bId = request.getParameter("bId");
        String bName = request.getParameter("bName");
        String bTitle = request.getParameter("bTitle");
        String bContent = request.getParameter("bContent");
        String bGroup = request.getParameter("bGroup");
        String bStep = request.getParameter("bStep");
        String bIndent = request.getParameter("bIndent");

        BoardDao dao = BoardDao.getInstance();
        dao.reply(bId, bName, bTitle, bContent, bGroup, bStep, bIndent);
    }
}
