package com.inf.khproject.vo;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * 결제 내역 vo -> 결제 내역을 가져올 때 사용
 */
@Getter
@Setter
@ToString
public class Amount {
    private int total;
    private int tax_free;
    private int vat;
}
