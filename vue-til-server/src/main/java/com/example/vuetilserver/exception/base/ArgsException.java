package com.example.vuetilserver.exception.base;

import com.example.vuetilserver.dto.global.GlobalResponse.error;
import com.example.vuetilserver.exception.type.CustomCode;

public class ArgsException extends JinException {
    
    public ArgsException(CustomCode customCode, String message){
        super(customCode, message);
    }

    @Override
    public error toExceptionMessage() {
        // TODO Auto-generated method stub
        return super.toExceptionMessageDefault();
    }
}
