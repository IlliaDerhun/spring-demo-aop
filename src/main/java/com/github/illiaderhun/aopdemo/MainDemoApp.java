package com.github.illiaderhun.aopdemo;

import com.github.illiaderhun.DemoConfig;
import com.github.illiaderhun.aopdemo.dao.AccountDAO;
import com.github.illiaderhun.aopdemo.dao.MembershipDAO;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MainDemoApp {
    public static void main(String[] args) {

        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DemoConfig.class);

        AccountDAO accountDAO = context.getBean("accountDAO", AccountDAO.class);
        MembershipDAO membershipDAO = context.getBean("membershipDAO", MembershipDAO.class);

        accountDAO.addAccount();

        System.out.println("add account into membership");

        membershipDAO.addAccount();
        membershipDAO.addSillyMember();

        context.close();
    }
}
