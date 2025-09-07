package com.example.Security.service;

import com.example.Security.domain.WalletTransactionType;
import com.example.Security.modal.Order;
import com.example.Security.modal.User;
import com.example.Security.modal.Wallet;
import com.example.Security.modal.WalletTransaction;

public interface WalletService {
    Wallet getUserWallet(User user) throws Exception;
    Wallet addBalance(Wallet wallet, Long money) throws Exception;
    Wallet findWalletById(Long id) throws Exception;
    Wallet walletToWalletTransfer(User sender, Wallet receiverWallet, Long amount) throws Exception;
    Wallet payOrderPayment(Order order, User user) throws Exception;
    WalletTransaction createTransaction(
                             Wallet wallet,
                             WalletTransactionType type,
                             String transferId,
                             String purpose,
                             Long amount)throws Exception;
}
