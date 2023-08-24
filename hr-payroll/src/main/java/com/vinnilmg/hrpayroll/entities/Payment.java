package com.vinnilmg.hrpayroll.entities;


import lombok.*;

import java.io.Serializable;

@ToString
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Payment implements Serializable {
    private static final long serialVersionUID = 1L;

    private String name;
    private Double dailyIncome;
    private Integer days;

    public double getTotal() {
        return dailyIncome * days;
    }
}
