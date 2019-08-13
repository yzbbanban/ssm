package com.test.controller;

import com.test.domain.dto.CoinInDTO;
import com.test.service.ICoinInService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/coin/in")
public class CoinInController {

    @Autowired
    private ICoinInService iCoinInService;

    @PostMapping(value = "add")
    public boolean addAsset(CoinInDTO coinInDTO) {
        return iCoinInService.addRecord(coinInDTO);
    }

}
