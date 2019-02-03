package com.github.illiaderhun.aopdemo;

import com.github.illiaderhun.DemoConfig;
import com.github.illiaderhun.aopdemo.dao.AccountDAO;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MainDemoApp {
    public static void main(String[] args) {

        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DemoConfig.class);

        AccountDAO accountDAO = context.getBean("accountDAO", AccountDAO.class);

        accountDAO.addAccount();
        accountDAO.addAccount();

        context.close();
    }
}
