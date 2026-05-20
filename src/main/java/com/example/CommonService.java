package com.example;

import com.example.models.UserService;

public class CommonService {
    //    private UserService userService = new UserService();
    //    private EmailService emailService = new EmailService();
    //    private DiscountService discountService = new DiscountService();
    private UserService userService;
    private EmailService emailService;
    private DiscountService discountService;


    public CommonService() {

    }

    public CommonService(UserService userService,
                         EmailService emailService,
                         DiscountService discountService) {
        this.userService = userService;
        this.emailService = emailService;
        this.discountService = discountService;
    }
}
