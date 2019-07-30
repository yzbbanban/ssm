package com.test.domain.orm;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.math.BigDecimal;

@ApiModel(value = "资产钱包")
public class AssetWallet {
    @ApiModelProperty(value = "ID")
    private Long id;
    @ApiModelProperty(value = "用户ID")
    private Integer userId;
    @ApiModelProperty(value = "货币ID")
    private Integer coinId;
    @ApiModelProperty(value = "账户余额")
    private BigDecimal amount;
    @ApiModelProperty(value = "账户冻结金额")
    private BigDecimal amountFrozen;
    @ApiModelProperty(value = "充币地址")
    private String coinInAddress;
    @ApiModelProperty(value = "创建时间")
    private Long createTime;
    @ApiModelProperty(value = "修改时间")
    private Long updateTime;
    @ApiModelProperty(value = "verison")
    private Long version;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getCoinId() {
        return coinId;
    }

    public void setCoinId(Integer coinId) {
        this.coinId = coinId;
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

    public String getCoinInAddress() {
        return coinInAddress;
    }

    public void setCoinInAddress(String coinInAddress) {
        this.coinInAddress = coinInAddress;
    }

    public Long getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Long createTime) {
        this.createTime = createTime;
    }

    public Long getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Long updateTime) {
        this.updateTime = updateTime;
    }

    public Long getVersion() {
        return version;
    }

    public void setVersion(Long version) {
        this.version = version;
    }

    @Override
    public String toString() {
        return "AssetWallet{" +
                "id=" + id +
                ", userId=" + userId +
                ", coinId=" + coinId +
                ", amount=" + amount +
                ", amountFrozen=" + amountFrozen +
                ", coinInAddress='" + coinInAddress + '\'' +
                ", createTime=" + createTime +
                ", updateTime=" + updateTime +
                ", version=" + version +
                '}';
    }
}
