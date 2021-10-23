package com.example.vuetilserver.exception.type;

import javax.annotation.Nullable;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
public enum CustomCode {
    NOMODEL(1_01), // validation 시 체크할 model이 없는 경우
    ETC(9_09); 

    @Getter
    private int code;

    @Nullable
    public static CustomCode identityByCode(int code){
        for(CustomCode customCode : values()){
            if(customCode.code == code) return customCode;
        }
        return CustomCode.ETC;
    }

    public String getCommonReason(){
        return CustomCode.codeSeries.identityByCode(this.code/1_000).reason;
    }

    @AllArgsConstructor
    private enum codeSeries {
        OK(0, "succeed"),
        PARAMETEREXCEPT(1, "parameter problem"),
        ETCEXCEPT(9, "?");

        private int series;
        private String reason;

        @Nullable
        private static CustomCode.codeSeries identityByCode(int series){
            for(CustomCode.codeSeries codeSeries : values()){
                if(codeSeries.series == series) return codeSeries;
            }
            return CustomCode.codeSeries.ETCEXCEPT;
        }
    }
}
