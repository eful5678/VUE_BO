package com.example.vuetilserver.domain;

import com.example.vuetilserver.domain.global.BaseEntity;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@NoArgsConstructor
@Getter
@Setter
public class Repair extends BaseEntity {

    @Id
    @GeneratedValue
    @Column(name = "repair_id")
    private Long id;

    @Column
    private String containerCode;

    @Column
    private BigDecimal repairCost;

    @Builder
    public Repair(LocalDateTime createDateTime,
                  LocalDateTime updateDateTime,
                  char useYn,
                  char delYn){
        super(createDateTime,updateDateTime, useYn, delYn);
        this.containerCode = containerCode;
        this.repairCost = repairCost;
    }
}
