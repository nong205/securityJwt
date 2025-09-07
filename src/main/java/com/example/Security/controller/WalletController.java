package com.example.Security.controller;

import com.example.Security.modal.Order;
import com.example.Security.modal.User;
import com.example.Security.modal.Wallet;
import com.example.Security.modal.WalletTransaction;
import com.example.Security.repository.WalletRepository;
import com.example.Security.service.OrderService;
import com.example.Security.service.UserService;
import com.example.Security.service.WalletService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class WalletController {
    @Autowired
    private WalletService walletService;
    @Autowired
    private UserService userService;
    @Autowired
    private OrderService orderService;

    @GetMapping("/api/wallet")
    public ResponseEntity<Wallet> getUserWallet(@RequestHeader("Authorization") String jwt) throws Exception {
        User user = userService.findUserProfileByJwt(jwt);
        Wallet wallet = walletService.getUserWallet(user);
        return new ResponseEntity<>(wallet, HttpStatus.ACCEPTED);
    }

    @PutMapping("/api/wallet/{walletId}/transfer")
    public ResponseEntity<Wallet> walletToWalletTransfer(
            @RequestHeader("Authorization") String jwt,
            @PathVariable Long walletId,
            @RequestBody WalletTransaction res
            ) throws Exception {
        User senderUser = userService.findUserProfileByJwt(jwt);
        Wallet recieverWallet = walletService.findWalletById(walletId);
        Wallet wallet = walletService.walletToWalletTransfer(
                senderUser,
                recieverWallet,
                res.getAmount());

        return new ResponseEntity<>(wallet, HttpStatus.ACCEPTED);
    }

    @PutMapping("/api/wallet/order/{orderId}/pay")
    public ResponseEntity<Wallet> payOrderPayment(
            @RequestHeader("Authorization") String jwt,
            @PathVariable Long orderId ) throws Exception {
        User user = userService.findUserProfileByJwt(jwt);
        Order order = orderService.getOrderById(orderId);
        Wallet wallet = walletService.payOrderPayment(order, user);
        return new ResponseEntity<>(wallet, HttpStatus.ACCEPTED);
    }

//    @GetMapping("/api/wallet/deposit")
//    public ResponseEntity<Wallet> addBalanceToWallet(
//            @RequestHeader("Authorization") String jwt,
//            @RequestParam(name = "order_id") Long orderId,
//            @RequestParam(name = "payment_id") String paymentId
//    ) throws Exception{
//        User user = userService.findUserProfileByJwt(jwt);
//        Wallet wallet = walletService.findWalletById(user.getId());
//        Payment
//    }

}
