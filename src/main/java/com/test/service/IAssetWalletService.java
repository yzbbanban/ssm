package com.test.service;


import com.test.domain.dto.AssetWalletSearchDTO;
import com.test.domain.dto.UpdateWalletAmountDTO;
import com.test.domain.orm.AssetWallet;

public interface IAssetWalletService {


    boolean updateWalletAsset(AssetWalletSearchDTO assetWalletSearchDTO, UpdateWalletAmountDTO updateDto);

}
