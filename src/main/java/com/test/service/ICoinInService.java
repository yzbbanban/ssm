package com.test.service;

import com.test.domain.dto.CoinInDTO;

/**
 * @author wangban
 * @data 2019/8/13 16:58
 */
public interface ICoinInService {

    /**
     * 增加提币记录
     *
     * @param coinInDTO coinInDTO
     * @return t
     */
    boolean addRecord(CoinInDTO coinInDTO);
}
