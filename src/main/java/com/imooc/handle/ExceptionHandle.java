package com.imooc.handle;

import com.imooc.domain.Result;
import com.imooc.enums.ResultEnum;
import com.imooc.exception.GirlException;
import com.imooc.utils.ResultUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;

/**
 * Created by wangbao02
 * 2017-01-21 13:59
 */
@ControllerAdvice
public class ExceptionHandle {

    private final static Logger logger = LoggerFactory.getLogger(ExceptionHandle.class);


    @ExceptionHandler(value = GirlException.class)
    @ResponseBody
    public Result handlerGirException(HttpServletResponse response, GirlException e) {
        logger.error("GirlException = {}",e);
        response.setStatus(406);
        return ResultUtil.error(e.getCode(), e.getMessage());
    }


    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public Result handle(Exception e) {
        logger.error("【系统异常】{}", e);
        return ResultUtil.error(ResultEnum.UNKONW_ERROR.getCode(),ResultEnum.UNKONW_ERROR.getMsg());
    }
}
