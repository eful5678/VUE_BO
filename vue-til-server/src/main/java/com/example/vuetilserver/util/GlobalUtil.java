package com.example.vuetilserver.util;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import reactor.core.publisher.Mono;

import org.apache.commons.lang3.StringUtils;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import javax.validation.Validation;
import javax.validation.Validator;

import com.example.vuetilserver.exception.BizException;
import com.example.vuetilserver.exception.base.ArgsException;
import com.example.vuetilserver.exception.base.JinException;
import com.example.vuetilserver.exception.type.CustomCode;

@NoArgsConstructor(access = AccessLevel.NONE)
public class GlobalUtil {

    private static final Validator validator = Validation.buildDefaultValidatorFactory().getValidator();

    // parameter Validatin Check
    public static <T> void checkValidation(final T t) throws JinException{
        Optional<?> validated = Mono.justOrEmpty(t)
                                    .switchIfEmpty(Mono.error(() -> new BizException(CustomCode.NOMODEL, "model is empty")))
                                    .map(x -> GlobalUtil.validator.validate(x))
                                    .filter(result -> !result.isEmpty())
                                    .map(x -> x.stream().map(y -> y.getMessage()).findFirst().orElseGet(() -> "입력하지 않은 부분 존재"))
                                    .blockOptional();
        if(!validated.isPresent()){

        }else{
            throw new ArgsException(CustomCode.ETC, validated.get().toString());
        }
    }

    // Long Type으로 받은 날짜값을 LocalDateTime 타입으로 변경하는 메서드
    public static Optional<LocalDateTime> epochToTimeConvert(Long epochTime){
        if(GlobalUtil.nullCheck(epochTime)){
            return Optional.empty();
        }else{
            return Optional.of(Instant.ofEpochMilli(epochTime).atZone(ZoneId.of("Asia/Seoul")).toLocalDateTime());
        }
    }

    public static Optional<Long> timeToEpochConvert(LocalDateTime localDateTime){
        if(GlobalUtil.nullCheck(localDateTime)){
            return Optional.empty();
        }else{
            return Optional.of(localDateTime.atZone(ZoneId.of("Asia/Seoul")).toInstant().toEpochMilli());
        }
    }

    // null check
    @SuppressWarnings("rawtypes")
    public static <T> boolean nullCheck(T obj){
        if(Optional.ofNullable(obj).isPresent()){
            if(obj instanceof List){
                List col = (List)obj;

                return col.isEmpty();
            }else if(obj instanceof String){
                String str = obj.toString();

                return StringUtils.isEmpty(str);
            }else if(obj instanceof Map){
                Map map = (Map) obj;

                return map.size() == 0;
            }else if(obj instanceof Optional){
                Optional otp = (Optional) obj;

                return !otp.isPresent();
            }else{
                return false;
            }
        } else{
            return true;
        }
    }
}
