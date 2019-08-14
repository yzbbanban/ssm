package com.test.service.impl;

import com.test.dao.CoinInDao;
import com.test.domain.dto.CoinInDTO;
import com.test.service.ICoinInService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

/**
 * @author wangban
 * @data 2019/8/13 16:58
 */
@Service
public class CoinInServcieImpl implements ICoinInService {

    @Autowired
    private CoinInDao coinInDao;

    /**
     * 增加提币记录
     *
     * @param coinInDTO
     * @return
     */
    @Override
    public boolean addRecord(CoinInDTO coinInDTO) {
        coinInDTO.setTxid(UUID.randomUUID().toString());
        coinInDTO.setCreateTime(System.currentTimeMillis() / 1000);
        return coinInDao.saveFinanceCoinInRecord(coinInDTO) > 0;
    }
}
