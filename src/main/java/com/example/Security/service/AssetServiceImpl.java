package com.example.Security.service;

import com.example.Security.modal.Asset;
import com.example.Security.modal.Coin;
import com.example.Security.modal.User;
import com.example.Security.repository.AssetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AssetServiceImpl implements AssetService{

    @Autowired
    private AssetRepository assetRepository;

    @Override
    public Asset createAsset(User user, Coin coin, double quantity) throws Exception {
        Asset asset = new Asset();
        asset.setUser(user);
        asset.setCoin(coin);
        asset.setQuantity(quantity);
        asset.setBuyPrice(coin.getCurrentPrice());
        return assetRepository.save(asset);
    }

    @Override
    public Asset getAssetById(Long assetId) throws Exception {
        return assetRepository.findById(assetId).orElseThrow(() -> new Exception("asset not found"));
    }

    @Override
    public Asset getAssetByUserIdAndId(Long userId, Long assetId) throws Exception {
        return null;
    }

    @Override
    public List<Asset> getUserAssets(Long userId) throws Exception {
        return assetRepository.findByUserId(userId);
    }

    @Override
    public Asset updateAsset(Long assetId, double quantity) throws Exception {
        Asset oldAsset = getAssetById(assetId);
        oldAsset.setQuantity(quantity + oldAsset.getQuantity());
        return assetRepository.save(oldAsset);
    }

    @Override
    public Asset findAssetByUserIdAndCoinId(Long userId, String coinId) throws Exception {
        return assetRepository.findByUserIdAndCoinId(userId, coinId);
    }

    @Override
    public void deleteAsset(Long assetId) throws Exception {
        assetRepository.deleteById(assetId);
    }
}
