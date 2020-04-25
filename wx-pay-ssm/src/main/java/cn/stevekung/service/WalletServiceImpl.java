package cn.stevekung.service;

import cn.stevekung.mapper.WalletMapper;
import cn.stevekung.pojo.Wallet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class WalletServiceImpl implements WalletMapper {
    @Autowired
    WalletMapper walletMapper;
    @Override
    public Wallet getWalletByUserId(Long userId) {
        return walletMapper.getWalletByUserId(userId);
    }
}
