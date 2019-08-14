package com.test.domain.dto;

public class CoinInDTO {
    private String targetAddress;
    private String amount;
    private String coinName;
    private String txid;
    private String useTag;
    private Long createTime;

    public Long getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Long createTime) {
        this.createTime = createTime;
    }

    public String getTxid() {
        return txid;
    }

    public void setTxid(String txid) {
        this.txid = txid;
    }

    public String getUseTag() {
        return useTag;
    }

    public void setUseTag(String useTag) {
        this.useTag = useTag;
    }

    public String getTargetAddress() {
        return targetAddress;
    }

    public void setTargetAddress(String targetAddress) {
        this.targetAddress = targetAddress;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public String getCoinName() {
        return coinName;
    }

    public void setCoinName(String coinName) {
        this.coinName = coinName;
    }

    @Override
    public String toString() {
        return "CoinInDTO{" +
                "targetAddress='" + targetAddress + '\'' +
                ", amount='" + amount + '\'' +
                ", coinName='" + coinName + '\'' +
                ", txid='" + txid + '\'' +
                ", useTag='" + useTag + '\'' +
                ", createTime=" + createTime +
                '}';
    }
}
