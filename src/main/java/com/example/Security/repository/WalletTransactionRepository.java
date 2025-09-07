package com.example.Security.repository;

import com.example.Security.modal.Wallet;
import com.example.Security.modal.WalletTransaction;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface WalletTransactionRepository extends JpaRepository<WalletTransaction, Long> {
      List<WalletTransaction> findByWallet(Wallet wallet);
      List<WalletTransaction> findByWalletId(Long walletId);
}
