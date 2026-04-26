package com.beyondlabs.backend_assignment;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HealthController {

    @GetMapping("/hello")
    public String hello()
    {
       return "Yo- Beyond Labs";
    }
}
