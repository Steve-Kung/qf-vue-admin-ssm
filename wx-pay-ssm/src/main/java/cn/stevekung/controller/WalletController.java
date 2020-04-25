package cn.stevekung.controller;

import cn.stevekung.pojo.Wallet;
import cn.stevekung.service.WalletServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WalletController {

    @Autowired
    WalletServiceImpl walletService;

    @RequestMapping("/amount")
    public Wallet amount(Long userId){
        return walletService.getWalletByUserId(userId);
    }
}
