package com.test.dao;


import com.test.domain.dto.CoinInDTO;

/**
 * @author wangban
 * @date 10:21 2019/3/7
 */
public interface CoinInDao {
    /**
     * 放入充币数据
     *
     * @param coinInDTO coinInDTO
     * @return xxx
     */
    int saveFinanceCoinInRecord(CoinInDTO coinInDTO);
}
