package com.day01.day01.controller;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.multipart.MaxUploadSizeExceededException;
import org.springframework.web.servlet.ModelAndView;

import java.io.IOException;

@ControllerAdvice

public class CustomExceptionHandler {
    @ExceptionHandler(MaxUploadSizeExceededException.class)

    //文件上传异常处理

    //1.直接输出文本
    /*public void uploadException(MaxUploadSizeExceededException e, HttpServletResponse resp) throws IOException {
        resp.setContentType("text/html;charset=utf-8");
        PrintWriter out = resp.getWriter();
        out.write("文件大小超过限制");
        out.flush();
        out.close();
    }*/

    //2.输出templates模板
    public ModelAndView uploadException(MaxUploadSizeExceededException e) throws IOException{
        ModelAndView mv = new ModelAndView();
        mv.addObject("msg", "文件大小超过限制");
        mv.setViewName("error");
        return mv;
    }
}
