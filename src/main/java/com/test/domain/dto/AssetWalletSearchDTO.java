package com.test.domain.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel("用户资产钱包查询参数")
public class AssetWalletSearchDTO {
    @ApiModelProperty(value = "用户ID", hidden = true)
    private Integer userId;
    @ApiModelProperty("货币ID")
    private Integer coinId;

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

    @Override
    public String toString() {
        return "AssetWalletSearchDTO{" +
                "userId=" + userId +
                ", coinId=" + coinId +
                '}';
    }
}
