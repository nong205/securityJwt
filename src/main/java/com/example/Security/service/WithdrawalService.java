package com.example.Security.service;

import com.example.Security.modal.User;
import com.example.Security.modal.Withdrawal;
import lombok.With;

import java.util.List;

public interface WithdrawalService {
    Withdrawal requestyWithdrawal(Long amount, User user);
    Withdrawal procedWithwithdrawal(Long withdrawalId, Boolean accept) throws Exception;
    List<Withdrawal> getUserWithdrawalHistory(User user);
    List<Withdrawal> getAllWithdrawalRequest() throws Exception;
}
