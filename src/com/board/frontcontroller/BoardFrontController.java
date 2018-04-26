package com.board.frontcontroller;

import com.board.command.BoardCommand;
import com.board.command.BoardContentViewCommand;
import com.board.command.BoardListCommand;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by IntelliJ IDEA.
 * Project: MVC_Study
 * ===========================================
 * User: ByeongGil Jung
 * Date: 2018-04-24
 * Time: 오전 10:10
 */
@WebServlet(name = "BoardFrontController", urlPatterns = {"*.boardDo"})
public class BoardFrontController extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("BFC doPost ~~");
        actionDo(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("BFC doGet ~~");
        actionDo(request, response);
    }

    private void actionDo(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String viewPage = null;
        BoardCommand command = null;

        String uri = request.getRequestURI();
        String conPath = request.getContextPath();
        String com = uri.substring(conPath.length());

        if (com.equals("/write_view.boardDo")) {
            viewPage = "";
        } else if (com.equals("/write.boardDo")) {
            viewPage = "";
        } else if (com.equals("/write.boardDo")) {
            viewPage = "";
        } else if (com.equals("/list.boardDo")) {
            viewPage = "/board/list.jsp";
            command = new BoardListCommand();
            command.execute(request, response);
        } else if (com.equals("/content_view.boardDo")) {
            viewPage = "";
            command = new BoardContentViewCommand();
            command.execute(request, response);
        } else if (com.equals("/modify.boardDo")) {
            viewPage = "";
        } else if (com.equals("/delete.boardDo")) {
            viewPage = "";
        } else if (com.equals("/reply_view.boardDo")) {
            viewPage = "";
        } else if (com.equals("/reply.boardDo")) {

        }

        RequestDispatcher dispatcher = request.getRequestDispatcher(viewPage);
        dispatcher.forward(request, response);
    }
}
