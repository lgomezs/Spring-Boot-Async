package com.example.springAsync.rest;

import com.example.springAsync.service.ILoginService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Slf4j
@Controller
@RequestMapping("/login")
public class UsuarioRest {

    @Autowired
    private ILoginService iLoginService;

    @RequestMapping(method = RequestMethod.POST)
    public @ResponseBody String getUsers(@RequestParam("username") String username,
             @RequestParam("password") final String password){
       String resul= iLoginService.doLogin(username,password);
       iLoginService.refreshUserData(username);
       return resul;
    }
}
