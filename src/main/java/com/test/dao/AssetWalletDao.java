package com.test.dao;

import com.test.domain.dto.AssetWalletSearchDTO;
import com.test.domain.orm.AssetWallet;
import com.test.domain.dto.UpdateWalletAmountDTO;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * 资产钱包
 *
 * @author wangban
 * @data 2019/4/2 9:19
 */
@Component
public interface AssetWalletDao {

    /**
     * 根据用户id和货币id获取用户钱包信息
     *
     * @param assetWalletSearchDTO 查询参数
     * @return 钱包信息
     */
    AssetWallet getAssetWalletByUserIdAndCoinId(AssetWalletSearchDTO assetWalletSearchDTO);

    /**
     * 添加资产钱包
     *
     * @param assetWallet 资产钱包实体类
     * @return 影响行数
     * @author
     */
    int saveAssetWallet(AssetWallet assetWallet);

    /**
     * 修改钱包余额
     *
     * @param dto 参数对象
     * @return 返回受影响行数
     */
    int updateWalletAmount(UpdateWalletAmountDTO dto);

    /**
     * 根据币种ID 用户iD 地址 获取用户钱包
     *
     * @param coinId  币种ID
     * @param userId  用户iD
     * @param address 地址
     * @return 钱包信息
     */
    AssetWallet getAssetWalletByAddressCoinUserId(@Param("coinId") Integer coinId,
                                                  @Param("userId") Integer userId,
                                                  @Param("address") String address);
    /**
     * 批量修改资产
     *
     * @param list 修改列表
     * @return 影响行
     */
    int updateWalletAmountList(List<AssetWallet> list);

    /**
     * 批量修改资产2
     * @param list adw
     * @return daw
     */
    int updateWalletAmountList2(List<AssetWallet> list);

}