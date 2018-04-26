package com.board.command;

import com.board.db.BoardDao;
import com.board.db.BoardDto;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;

/**
 * Created by IntelliJ IDEA.
 * Project: MVC_Study
 * ===========================================
 * User: ByeongGil Jung
 * Date: 2018-04-26
 * Time: 오전 9:35
 */
public class BoardListCommand implements BoardCommand {
    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) {
        BoardDao dao = BoardDao.getInstance();
        ArrayList<BoardDto> dtos = dao.list();
        request.setAttribute("list", dtos);
    }
}
