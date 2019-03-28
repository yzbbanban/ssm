package com.test.common.result;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.List;

/**
 * Created by brander on 2019/1/14
 */
@ApiModel("列表")
public class ResultList<T> {

    @ApiModelProperty("数量")
    private Integer count;
    @ApiModelProperty("列表数据")
    private List<T> dataList;

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public List<T> getDataList() {
        return dataList;
    }

    public void setDataList(List<T> dataList) {
        this.dataList = dataList;
    }

    @Override
    public String toString() {
        return "ResultList{" +
                "count=" + count +
                ", dataList=" + dataList +
                '}';
    }
}
