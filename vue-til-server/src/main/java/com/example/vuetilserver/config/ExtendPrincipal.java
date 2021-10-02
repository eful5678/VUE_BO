package com.example.vuetilserver.config;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class ExtendPrincipal {

    // ID
    private String id = "anomymous";
    // Key
    private Long key = -1L;

    private String type = "ETC";

    // appId
    private String appId;

    // Cid
    private String cid;

    // writer
    private String writer;

    // 회원타입
    private String memberType;

    // birthDay
    // private LocalDateTime birthDay;

    // smartmBmCode
    private String smartmBmCode;

    // smartmMemberCode
    private String smartmMemberCode;

    // BM 여부
    private char isBeautyMaster;

    // 회원 키
    private String memberCode;


    /**
     * admin인지 체크 현재는 type이 ADMIN이면 관리자다.
     * @return
     */
    public boolean isAdmin() {
        return "ADMIN".equals(this.type);
    }

}
