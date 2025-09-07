package com.example.Security.service;

import com.example.Security.modal.Asset;
import com.example.Security.modal.Coin;
import com.example.Security.modal.User;

import java.util.List;

public interface AssetService {
    Asset createAsset(User user, Coin coin, double quantity) throws Exception;
    Asset getAssetById(Long assetId) throws Exception;
    Asset getAssetByUserIdAndId(Long userId, Long assetId) throws Exception;
    List<Asset> getUserAssets(Long userId) throws Exception;
    Asset updateAsset(Long assetId, double quantity) throws Exception;
    Asset findAssetByUserIdAndCoinId(Long userId, String coinId) throws Exception;
    void deleteAsset(Long assetId) throws Exception;
}
