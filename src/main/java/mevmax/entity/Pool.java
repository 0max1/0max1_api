package mevmax.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;

@Entity
@Data
public class Pool {
    @Id
    private String pool_address;
    private String factory_address;
    private String blockchain_name;
    private BigDecimal tvl;
    private BigDecimal fee;
    private Boolean pool_flag;
}

