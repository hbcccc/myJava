package org.example.withdao.controller;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@ControllerAdvice(assignableTypes = UserController.class)// 可以控制被增强的controller对象
public class RuntimeExceptionHandler {
    @ExceptionHandler(RuntimeException.class)
    public String handleRuntimeException(HttpServletRequest request, HttpServletResponse response, RuntimeException e){
        e.printStackTrace();
        request.setAttribute("message", e.getMessage());
        return  "error";
    }
    @ExceptionHandler(IllegalArgumentException.class)
    public String handleIllegalArgumentException(HttpServletRequest request, IllegalArgumentException e) {
        request.setAttribute("message", "[不合法的参数]" + e.getMessage());
        return "error";
    }
}
