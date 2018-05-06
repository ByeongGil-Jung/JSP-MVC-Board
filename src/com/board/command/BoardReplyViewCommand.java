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
 * Time: 오후 12:47
 */
public class BoardReplyViewCommand implements BoardCommand {
    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) {
        if (request.getMethod().equals("GET")) {
            String bId = request.getParameter("bId");

            BoardDao dao = BoardDao.getInstance();
            BoardDto dto = dao.replyView(bId);

            request.setAttribute("replyView", dto);
        }
    }
}
