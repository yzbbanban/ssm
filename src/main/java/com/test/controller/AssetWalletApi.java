package com.test.controller;

import com.test.common.result.ResultJson;
import com.test.domain.dto.AssetWalletSearchDTO;
import com.test.domain.dto.UpdateWalletAmountDTO;
import com.test.service.IAssetWalletService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;

/**
 * 资产基础服务
 *
 * @author wangban
 * @data 2019/4/26 9:55
 */
@RestController
@RequestMapping("/v1/asset")
@Api(tags = {"资产基础服务"})
public class AssetWalletApi {

    @Autowired
    private IAssetWalletService assetWalletService;

    @ApiOperation(value = "王斑: ", notes = "")
    @GetMapping(value = "testS")
    public ResultJson<String> testUpdateAmount() {

        AssetWalletSearchDTO searchDTO = new AssetWalletSearchDTO();
        searchDTO.setUserId(1);
        searchDTO.setCoinId(7);
        //获取用户钱包信息
        UpdateWalletAmountDTO amountDTO = new UpdateWalletAmountDTO();
        amountDTO.setAmount(new BigDecimal("-10"));
        amountDTO.setAmountFrozen(new BigDecimal("10"));

        boolean result = assetWalletService.updateWalletAsset(searchDTO, amountDTO);

        return ResultJson.createBySuccess("啦啦啦啦: " + result);
    }


}
