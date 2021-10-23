package com.example.vuetilserver.dto.global;

import java.time.LocalDateTime;

import com.example.vuetilserver.exception.type.CustomCode;
import com.example.vuetilserver.util.GlobalUtil;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

public class GlobalResponse {

    @Getter
    @Setter
    @NoArgsConstructor
    public static class base {
        protected boolean isSuccess = true;

        protected Long startTime;

        protected Long endTime = GlobalUtil.timeToEpochConvert(LocalDateTime.now()).get();
    }
    
    @Getter
    @Setter
    public static final class error extends GlobalResponse.base{
        private String response;
        private CustomCode customCode;

        @Builder
        private error(final String response, final CustomCode customCode){
            super.isSuccess = false;
            this.response = response;
            this.customCode = customCode;
        }
    }
}
