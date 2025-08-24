package com.example.Security.modal;

import com.example.Security.domain.VerificationType;
import jakarta.persistence.Embeddable;
import jakarta.persistence.Embedded;
import lombok.Data;

@Data
@Embeddable
public class TwoFactorAuth {
    private boolean isEnabled = false;
    private VerificationType sendTo;
}
