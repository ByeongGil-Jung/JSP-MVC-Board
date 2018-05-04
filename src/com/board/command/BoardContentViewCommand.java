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
 * Date: 2018-04-24
 * Time: 오전 10:58
 */
public class BoardContentViewCommand implements BoardCommand {
    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) {
        if (request.getMethod().equals("GET")) {
            String bId = request.getParameter("bId");

            BoardDao dao = BoardDao.getInstance();
            BoardDto dto = dao.contentView(bId);

            request.setAttribute("contentView", dto);
        }
    }
}
