package com.example;

import com.example.mediator.ChatRoom;
import com.example.mediator.ChatUser;
import com.example.obsertver.Bank;
import com.example.obsertver.CurrencyExigence;
import com.example.obsertver.Trader;
import com.example.state.CoffeMachine;
import com.example.stategy.CashPaymentStrategy;
import com.example.stategy.CreditCardStrategy;
import com.example.stategy.CryptoPaymentStrategy;
import com.example.stategy.ShoppingCart;

import java.lang.ref.PhantomReference;
import java.lang.ref.SoftReference;
import java.lang.ref.WeakReference;
import java.util.Arrays;
import java.util.List;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) throws CloneNotSupportedException {
//        ServiceLocator.register(DiscountService.class, new DiscountService());
//        ServiceLocator.register(EmailService.class, new EmailService());
//        ServiceLocator.register(DiscountService.class, new DiscountService());


        // FIRST - TDD
        // TRIPLE A -
        // Single

//        GameCharacter one = new GameCharacter("Base", 10);
//        one.addSkill("Fireball");
//        one.showInfo();
//        System.out.println("==============");
//        GameCharacter two = one.clone();
//        two.setName("Dolphin");
//        two.addSkill("Strong");
//        two.addSkill("Swim");
//        two.showInfo();
//        System.out.println("==============");
//        GameCharacter three = one.clone();
//        three.setName("Dog");
//        three.addSkill("Bark");
//        three.showInfo();
//        System.out.println("==============");
//        Pizza margarita = new Margarita();
//        Pizza fourCheeze = new FourCheeze();
//        System.out.println(margarita.getDescription() + margarita.getPrice());
//        System.out.println(fourCheeze.getDescription() + fourCheeze.getPrice());
//        System.out.println("===================");
//        Pizza newMargarita = new PizzaMushroomDecorator(margarita);
//        System.out.println(newMargarita.getDescription() + newMargarita.getPrice());
//
//        System.out.println("====================");
//        Pizza newFourCheeze = new PizzaMushroomDecorator(new PizzaMushroomDecorator(fourCheeze));
//        System.out.println(newFourCheeze.getDescription() + newFourCheeze.getPrice());
//GoF

//        SupportHandler1Level support1 = new SupportHandler1Level();
//        SupportHandler2Level support2 = new SupportHandler2Level();
//        SupportHandlerLevel3 support3 = new SupportHandlerLevel3();
//        support1.setNext(support2);
//        support2.setNext(support3);
//
//        SupportRequest[] requests = {
//                new SupportRequest("Как сменить пароль?", 1),
//                new SupportRequest("Не открывается сайт", 1),
//                new SupportRequest("Программа зависла при запуске", 2),
//                new SupportRequest("Ошибка 500 на сервере", 3),
//                new SupportRequest("Сгорел сервер в дата-центре", 4)
//        };
//
//        for (SupportRequest request : requests) {
//            System.out.println("\n📞 Новый запрос: " + request.getIssue());
//            support1.handle(request);
//        }

//        Light light = new Light("Living Room");
//        MusicCenter musicCenter = new MusicCenter();
//        LighCommand lighCommand = new LighCommand(light);
//        MusicCenterCommand musicCenterCommand = new MusicCenterCommand(musicCenter);
//        RemoteControl remoteControl = new RemoteControl();
//        remoteControl.setCommand(lighCommand, 0);
//        remoteControl.setCommand(musicCenterCommand, 3);
//        System.out.println("================");
//        remoteControl.pressButton(0);
//        remoteControl.pressButton(1);
//        remoteControl.pressButton(2);
//        remoteControl.pressButton(3);

//        CurrencyExigence currencyExigence = new CurrencyExigence();
//        Bank alfa = new Bank("Alfa");
//        Bank sber = new Bank("Sber");
//        Trader trader = new Trader();
//
//        currencyExigence.subscribe(alfa);
//        currencyExigence.subscribe(sber);
//        currencyExigence.subscribe(trader);
//
//        currencyExigence.setNewRange("EUR", 80);
//        currencyExigence.setNewRange("USD", 71);

//        CoffeMachine coffeMachine = new CoffeMachine();
//
//        coffeMachine.insertCoin();
//        coffeMachine.insertCoin();
//        coffeMachine.insertCoin();
//        coffeMachine.selectCoffe();
//        coffeMachine.dispense();
//        ShoppingCart shoppingCart = new ShoppingCart();
//        System.out.println("===Shopping=======");
//        shoppingCart.payCart(3000);
//        System.out.println("===Shopping Cash=======");
//        shoppingCart.setPaymentStrategy(new CashPaymentStrategy());
//        shoppingCart.payCart(3000);
//        System.out.println("===Shopping Card======");
//        ShoppingCart shoppingCart2 = new ShoppingCart();
//        shoppingCart2.setPaymentStrategy(new CreditCardStrategy("4651654461"));
//        shoppingCart2.payCart(3500);
//        System.out.println("===Shopping Crypto======");
//        ShoppingCart shoppingCart3 = new ShoppingCart();
//        shoppingCart3.setPaymentStrategy(new CryptoPaymentStrategy("klfnbfgxkn"));
//        shoppingCart3.payCart(3800);

        /*
        int STATUS_FINAL = 1
        if (code == STATUS_FINAL){
        } else {
        }
         */

//        ChatRoom chatRoom = new ChatRoom();
//        ChatUser sergey = new ChatUser("Sergey", chatRoom);
//        ChatUser andrey = new ChatUser("Andrey", chatRoom);
//        ChatUser ivan = new ChatUser("Ivan", chatRoom);
//        ChatUser john = new ChatUser("John", chatRoom);
//        System.out.println("=======Chat room===========");
//        sergey.sendMessage("Hello everybody");
//        andrey.sendMessage("Hi!!!!!");
//        ivan.sendMessage("Hello");
//        john.sendMessage("John is comming!!!!");
        /*
        counter = 0;
         - 0
         - 0+1
         - 1
         */
        int x = 10;
        String name = "name";
        for (int i = 0; i < 100000000; i++) {

        }
        Object obj = new Object();
        calc(1, 1, obj);
        SoftReference<Object> ref = new SoftReference<>(obj);
        WeakReference<Object> ref1 = new WeakReference<>(obj);
    }

    private static void calc(int i, int i1, Object obj) {
        int result = 0;
        result = i + i1;
        System.out.println(result + obj.toString());
    }

}