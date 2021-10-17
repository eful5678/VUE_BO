package com.example.vuetilserver.repository;

import com.example.vuetilserver.domain.Employee;
import com.example.vuetilserver.domain.QRepair;
import com.example.vuetilserver.domain.Repair;
import com.example.vuetilserver.dto.RepairDto;
import com.querydsl.core.types.Projections;
import com.querydsl.jpa.impl.JPAQueryFactory;
import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
public class RepairRepositorySupportImpl extends QuerydslRepositorySupport implements RepairRepositorySupport{

    private final JPAQueryFactory jpaQueryFactory;

    public RepairRepositorySupportImpl(EntityManager em){
        super(Repair.class);
        super.setEntityManager(em);
        jpaQueryFactory = new JPAQueryFactory(em);
    }
    @Override
    public List<RepairDto.repairList> list(RepairDto.repairListParam repairListParam) {
        // Repair Entity
        QRepair Repair = QRepair.repair;
        return jpaQueryFactory.select(Projections.constructor(RepairDto.repairList.class,
                                Repair.containerCode,
                Repair.shippingCompany,
                                Repair.repairCost,
                Repair.paymentAmount,
                Repair.regDate,
                Repair.repairDate
                ))
                .from(Repair)
                .fetch();

    }
}
