package com.example;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) throws Exception {

        // FIRST - TDD
        // TRIPLE A -
        // Single
        // https://admin:password@javarush.com:443/search/users?q=java&page=2#results
        //ssh://admin:admin@myvm.ru:443
        String token = "******";

        GibHubClient client = new GibHubClient(token);

        // 1. Получить информацию о пользователе
        System.out.println("=== Информация о пользователе ===");
        String user = client.getUser();
        System.out.println(user);
    }
}