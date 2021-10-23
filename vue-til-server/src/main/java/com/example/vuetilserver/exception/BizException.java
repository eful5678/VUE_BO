package com.example.vuetilserver.exception;

import com.example.vuetilserver.dto.global.GlobalResponse.error;
import com.example.vuetilserver.exception.base.JinException;
import com.example.vuetilserver.exception.type.CustomCode;

public class BizException extends JinException {
    public BizException(CustomCode customCode){
        super(customCode);
    }

    public BizException(CustomCode customCode, String message){
        super(customCode);
    }

    @Override
    public error toExceptionMessage() {
        // TODO Auto-generated method stub
        return super.toExceptionMessageDefault();
    }
}
