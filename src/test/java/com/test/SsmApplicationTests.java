package com.test;

import com.test.dao.AssetWalletDao;
import com.test.domain.orm.Area;
import com.test.domain.orm.AssetWallet;
import com.test.service.IAreaService;
import org.bitcoinj.core.ECKey;
import org.bitcoinj.core.NetworkParameters;
import org.bitcoinj.kits.WalletAppKit;
import org.bitcoinj.params.RegTestParams;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import java.io.File;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SsmApplicationTests {

    private static NetworkParameters params;
    private static WalletAppKit kit;

    @Autowired
    private IAreaService areaService;

    @Autowired
    private AssetWalletDao assetWalletDao;

    @Before
    public void init() throws Exception {
        try {
//            params = TestNet3Params.get();
            params = RegTestParams.get();
//            client = new BitcoinJSONRPCClient("http://192.168.1.117:18444");
//            kit = new WalletAppKit(params, new File("data"), "myapp");
        } catch (Exception e) {
            System.out.println("error init static members.");
        }

    }

    @Test
    public void contextLoads() {


        System.out.println("WalletAppKit demo");
// Start up a basic app using a class that automates some boilerplate. Ensure we always have at least one key.
        kit = new WalletAppKit(params, new File("."), "myapp") {
            @Override
            protected void onSetupCompleted() {
                // This is called in a background thread after startAndWait is called, as setting up various objects
                // can do disk and network IO that may cause UI jank/stuttering in wallet apps if it were to be done
                // on the main thread.
                if (wallet().getKeyChainGroupSize() < 1)
                    wallet().importKey(new ECKey());
            }
        };

        if (params == RegTestParams.get()) {
            // Regression test mode is designed for testing and development only, so there's no public network for it.
            // If you pick this mode, you're expected to be running a local "bitcoind -regtest" instance.
            kit.connectToLocalHost();
        }

        // Download the block chain and wait until it's done.
//        kit.startAsync();
//        kit.awaitRunning();
    }

    @Test
    @Transactional(rollbackFor = Exception.class)
    public void testLock() throws InterruptedException {

        //批量更新

        List<AssetWallet> wallet = new ArrayList<>();
        AssetWallet wa = new AssetWallet();
        wa.setVersion(0L);
        wa.setAmount(new BigDecimal("10"));
        wa.setAmountFrozen(new BigDecimal("-10"));
        wa.setId(2L);
        wallet.add(wa);
//
        AssetWallet wa2 = new AssetWallet();
        wa2.setVersion(0L);
        wa2.setAmount(new BigDecimal("8"));
        wa2.setAmountFrozen(new BigDecimal("-8"));
        wa2.setId(1L);
        wallet.add(wa2);

        int row = assetWalletDao.updateWalletAmountList2(wallet);
        if (row < wallet.size()) {
            throw new RuntimeException("");
        }

        System.out.println("======>" + row);

    }

}
