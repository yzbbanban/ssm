package com.test.service.impl;

import com.test.dao.AssetWalletDao;
import com.test.domain.dto.AssetWalletSearchDTO;
import com.test.domain.dto.UpdateWalletAmountDTO;
import com.test.domain.orm.AssetWallet;
import com.test.service.IAssetWalletService;
import com.test.service.exception.ServiceException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;

@Service
public class AssetWalletServiceImpl implements IAssetWalletService {

    private Logger log = LoggerFactory.getLogger(AssetWalletServiceImpl.class);

    @Autowired
    private AssetWalletDao assetWalletDao;

    @Override
    @Transactional(rollbackFor = Exception.class)
    public boolean updateWalletAsset(AssetWalletSearchDTO assetWalletSearchDTO, UpdateWalletAmountDTO updateDto) {

        if (assetWalletSearchDTO.getUserId() == null
                || assetWalletSearchDTO.getCoinId() == null
                || assetWalletSearchDTO.getUserId() <= 0) {
            log.error("获取用户资产参数异常==>用户ID：" + assetWalletSearchDTO.getUserId() + "币种：" + assetWalletSearchDTO.getCoinId());
            throw new ServiceException("失败");
        }
        AssetWallet wallet = assetWalletDao.getAssetWalletByUserIdAndCoinId(assetWalletSearchDTO);
        if (wallet == null) {
            AssetWallet newWallet = new AssetWallet();
            newWallet.setUserId(assetWalletSearchDTO.getUserId());
            newWallet.setCoinId(assetWalletSearchDTO.getCoinId());
            newWallet.setAmountFrozen(BigDecimal.ZERO);
            newWallet.setAmount(BigDecimal.ZERO);
            newWallet.setCoinInAddress(null);
            newWallet.setUpdateTime(System.currentTimeMillis());
            newWallet.setCreateTime(System.currentTimeMillis());
            int result = assetWalletDao.saveAssetWallet(newWallet);
            //防止数据同步出现问题，从内存中添加数据
            if (result != 1) {
                throw new ServiceException("创建用户账号钱包失败");
            }
            wallet = newWallet;
        }
        updateDto.setId(wallet.getId());
        //修改用户账号余额 （增加）
        int wcount = assetWalletDao.updateWalletAmount(updateDto);
        if (wcount != 1) {
            log.error("======> 修改钱包{},", wcount);
            throw new ServiceException("修改用户账号钱包失败");
        }
        //模拟账单
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return true;
    }
}
