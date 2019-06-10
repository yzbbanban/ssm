package com.test.domain.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.math.BigDecimal;

@ApiModel("修改钱包余额参数对象")
public class UpdateWalletAmountDTO {
    @ApiModelProperty("钱包id ")
    private Long id;
    @ApiModelProperty("可用数量 ")
    private BigDecimal amount;
    @ApiModelProperty("冻结数量 ")
    private BigDecimal amountFrozen;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public BigDecimal getAmountFrozen() {
        return amountFrozen;
    }

    public void setAmountFrozen(BigDecimal amountFrozen) {
        this.amountFrozen = amountFrozen;
    }

    @Override
    public String toString() {
        return "UpdateWalletAmountDTO{" +
                "id=" + id +
                ", amount=" + amount +
                ", amountFrozen=" + amountFrozen +
                '}';
    }
}
