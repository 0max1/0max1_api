package mevmax.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;

@Entity
@Data
public class Token {
    @Id
    private String token_address;
    private String token_symbol;
    private Integer decimal;
    private Integer num_holders;
    private Boolean is_new;
}
