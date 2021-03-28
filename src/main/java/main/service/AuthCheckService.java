package main.service;

import main.api.response.AuthCheckResponse;
import org.springframework.stereotype.Service;

@Service
public class AuthCheckService
{
    public AuthCheckResponse checkAuth()
    {
        AuthCheckResponse authCheckResponse = new AuthCheckResponse();
        return authCheckResponse;
    }
}
