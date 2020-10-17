package com.demo.filter;

import com.demo.constant.ResponseCode;
import com.demo.dto.ResponseBean;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
public class GlobleExceptionService {

    /**
     * 全局异常捕捉处理
     * @param e
     * @return
     */
    @ResponseBody
    @ExceptionHandler(value = Exception.class)
    public ResponseBean errorHandler(Exception e) {
        return ResponseBean.createByErrorCodeMessage(ResponseCode.FAIL.getCode(),e.getMessage());
    }

}
