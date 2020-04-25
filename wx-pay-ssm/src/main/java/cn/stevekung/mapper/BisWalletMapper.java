package cn.stevekung.mapper;

import cn.stevekung.pojo.BisWallet;

import java.util.List;

public interface BisWalletMapper {
    public List<BisWallet> getAllBisWallet();
    public BisWallet getBisWalletById(Long id);
    public int AddBisWallet(BisWallet bisWallet);
    public int deleteBisWalletById(Long id);
    public int updateBisWallet(BisWallet bisWallet);
}
