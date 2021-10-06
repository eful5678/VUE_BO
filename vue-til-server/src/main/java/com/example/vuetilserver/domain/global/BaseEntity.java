package com.example.vuetilserver.domain.global;

import com.example.vuetilserver.domain.Post;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import java.time.LocalDateTime;

@Getter
@MappedSuperclass
@NoArgsConstructor
public abstract class BaseEntity {

    @Column
    @CreationTimestamp
    protected LocalDateTime createDateTime;

    @Column(nullable = false)
    @ColumnDefault("'Y'")
    protected char useYn = 'Y';

    @Column(nullable = false)
    @ColumnDefault("'N'")
    protected char delYn = 'N';

    protected BaseEntity(LocalDateTime createDateTime, char useYn, char delYn){
        this.useYn = 'Y';
    }

}
