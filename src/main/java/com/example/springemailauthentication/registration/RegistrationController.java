package com.example.springemailauthentication.registration;

import com.example.springemailauthentication.appuser.service.AppUserService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/registration")
@AllArgsConstructor
public class RegistrationController {
    private final RegistrationService registrationService;

    @PostMapping
    public String register(@RequestBody RegistrationRequest request){
        return registrationService.register(request);
    }
    @GetMapping(path="/confirm")
    public String confirm(@RequestParam("token") String token){
        return registrationService.ConfirmToken(token);
    }
}
