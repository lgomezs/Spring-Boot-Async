package com.example.springAsync.service;

public interface ILoginService {

    String doLogin(String principal, String credenctial);

    void refreshUserData(String principal);

}
