package com.board.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by IntelliJ IDEA.
 * Project: MVC_Study
 * ===========================================
 * User: ByeongGil Jung
 * Date: 2018-04-24
 * Time: 오전 10:54
 */
public interface BoardCommand {
    void execute(HttpServletRequest request, HttpServletResponse response);
}
