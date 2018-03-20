package com.imooc.utils;

import com.imooc.domain.Result;
import com.imooc.enums.ResultEnum;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;

/**
 * @author: wangbao02
 * @date: 2018/3/20 15:23
 * @Description:
 */
public class validateParamUtils {

    public static Result validateParam(BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            String errorMessage = getMessage(bindingResult);
            if (!StringUtils.isEmpty(errorMessage)) {
                return ResultUtil.error(ResultEnum.VALIDATE_PARAM.getCode(), ResultEnum.VALIDATE_PARAM.getMsg() + errorMessage);
            }
        }
        return null;
    }

    public static String getMessage(BindingResult bindingResult) {
        StringBuilder sb = new StringBuilder();
        for (ObjectError objectError : bindingResult.getFieldErrors()) {
            sb.append(objectError.getDefaultMessage()).append(" ");
        }
        return sb.toString();
    }


}
