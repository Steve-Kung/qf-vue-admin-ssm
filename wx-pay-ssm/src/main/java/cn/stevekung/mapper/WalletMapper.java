package cn.stevekung.mapper;

import cn.stevekung.pojo.Wallet;

public interface WalletMapper {
    Wallet getWalletByUserId(Long userId);
}
