package com.example.vuetilserver.exception.base;

import com.example.vuetilserver.dto.global.GlobalResponse;
import com.example.vuetilserver.exception.type.CustomCode;

import lombok.Getter;

public abstract class JinException extends RuntimeException {
    
    @Getter
    private final CustomCode customCode;

    public JinException(CustomCode customCode){
        super(customCode.getCommonReason());
        this.customCode = customCode;
    }
    public JinException(CustomCode customCode, String message){
        super(message);
        this.customCode = customCode;
    }

    public abstract GlobalResponse.error toExceptionMessage();
    
    protected GlobalResponse.error toExceptionMessageDefault(){
        return GlobalResponse.error
                        .builder()
                        .customCode(this.customCode)
                        .response(this.getMessage())
                        .build();
    }
}
