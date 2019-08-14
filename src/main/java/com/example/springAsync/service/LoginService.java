package com.example.springAsync.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class LoginService implements  ILoginService{


    @Override
    public String doLogin(String principal, String credenctial) {
        log.info("Realizando login de usario {} ", principal);
        return "success";
    }

    @Async
    @Override
    public void refreshUserData(String principal) {
        try {
            Thread.sleep(2000);
            log.info("refreshUserData principal : {} ",  principal);
        }catch (Exception exception){
            log.error("Exception refreshUserData {} ", exception.getMessage());
        }
    }

}
