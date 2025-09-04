package com.example.Security.service;

import com.example.Security.modal.Coin;

import java.util.List;

public interface CoinService {
    List<Coin> getCoinList(int page) throws Exception;
    String marketChart(String coinId, int days) throws Exception;
    String getCoinDetails(String coinId) throws Exception;
    Coin findById(String coinId) throws Exception;
    String SearchCoin(String keyword) throws Exception;
    String getTop50CoinsByMarketCapRank() throws Exception;
    String getTrendingCoins() throws Exception;
}
