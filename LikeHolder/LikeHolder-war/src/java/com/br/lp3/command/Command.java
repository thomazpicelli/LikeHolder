package com.br.lp3.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Thomaz
 */
public interface Command {
    public void execute(HttpServletRequest request, HttpServletResponse response, String operacao);
}
