package cn.stevekung.service;

import cn.stevekung.pojo.Wallet;

public interface WalletService {
    Wallet getWalletByUserId(Long userId);
}
