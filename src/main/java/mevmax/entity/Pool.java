package mevmax.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;

@Entity
@Data
public class Pool {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String pool_address;
    private String protocol_name;
    private String blockchain_name;
    private BigDecimal tvl;
    private BigDecimal fee;
    private Boolean pool_flag;
}

