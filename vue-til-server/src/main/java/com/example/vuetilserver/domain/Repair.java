package com.example.vuetilserver.domain;

import com.example.vuetilserver.domain.global.BaseEntity;
import com.example.vuetilserver.dto.RepairDto;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.function.Supplier;

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

    @Column
    private String shippingCompany;

    @Column
    private BigDecimal paymentAmount;

    @Column
    private LocalDateTime regDate;

    @Column
    private LocalDateTime repairDate;

    @JoinColumn(name = "employee_id")
    @ManyToOne(fetch = FetchType.LAZY)
    private Employee employee;

    @Builder
    public Repair(LocalDateTime createDateTime,
                  LocalDateTime updateDateTime,
                  char useYn,
                  char delYn,
                  String containerCode,
                  String shippingCompany,
                  BigDecimal repairCost,
                  BigDecimal paymentAmount,
                  LocalDateTime regDate,
                  LocalDateTime repairDate){
        super(createDateTime,updateDateTime, useYn, delYn);
        this.containerCode = containerCode;
        this.repairCost = repairCost;
        this.shippingCompany = shippingCompany;
        this.repairCost = repairCost;
        this.paymentAmount = paymentAmount;
        this.regDate = regDate;
        this.repairDate = repairDate;
    }


    public static Repair doMaker(RepairDto.insertParam insertParam){
        Repair repair = Repair.builder()
                .containerCode(insertParam.getContainerCode())
                .shippingCompany(insertParam.getShippingCompany())
                .repairCost(insertParam.getRepairCost())
                .paymentAmount(BigDecimal.TEN)
                .regDate(LocalDateTime.now())
                .repairDate(LocalDateTime.now())
                .build();
        return repair;
    }
}
