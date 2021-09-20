package com.example.springemailauthentication.registration.token;

import com.example.springemailauthentication.appuser.AppUser;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
//@AllArgsConstructor
@NoArgsConstructor
@Entity
public class ConfirmationToken {
    @SequenceGenerator(
            name="confirmation_token_sequence",
            sequenceName = "student_sequence",
            allocationSize = 1
    )
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,
            generator = "confirmation_token_sequence")
    private Long id;
    @Column(nullable = false)
    private String token="";
    @Column(nullable = false)
    private LocalDateTime createdAt;
    @Column(nullable = false)
    private LocalDateTime expiresAt;
//    @Column(nullable = false)
    private LocalDateTime confirmedAt;

    @ManyToOne
    @JoinColumn(nullable = false,
    name="app_user_id")
    private AppUser appUser;

    public ConfirmationToken(String token, LocalDateTime createdAt, LocalDateTime expiredAt,AppUser appUser) {
        this.token = token;
        this.createdAt = createdAt;
        this.expiresAt = expiredAt;
        this.appUser=appUser;
//        this.confirmedAt = confirmedAt;
    }
}
