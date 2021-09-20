package com.example.springemailauthentication.registration;

import com.example.springemailauthentication.appuser.AppUser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@AutoConfigureMockMvc
//@RequiredArgsConstructor
class RegistrationControllerTest {
    @Autowired
    private MockMvc mockMvc;
    @Mock
    private RegistrationService registrationService;

//    public RegistrationControllerTest(RegistrationService registrationService){
//        this.registrationService=registrationService;
//    }
    ObjectMapper objectMapper=new ObjectMapper();
    RegistrationRequest registrationRequest=new RegistrationRequest("Bhupendra","Singh",
            "ash@gmail.com","password");
    @Test
    @BeforeEach
    void register() throws Exception {

        String registration=objectMapper.writeValueAsString(registrationRequest);

        mockMvc.perform(post("/api/v1/registration").content(registration)
                .header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON)).andExpect(status().isOk());


    }

    @Test
    void confirm() throws Exception{
        String token =registrationService.register(registrationRequest);
        System.out.println(token);
        token="";
        mockMvc.perform(get("/api/v1/registration/confirm?token="+token)).andExpect(status().isOk());
    }
}