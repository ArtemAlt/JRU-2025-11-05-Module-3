package com.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.concurrent.CompletionService;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorCompletionService;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) throws CloneNotSupportedException, ExecutionException, InterruptedException {
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
//        int x = 10;
//        String name = "name";
//        for (int i = 0; i < 100000000; i++) {
//
//        }
//        Object obj = new Object();
//        calc(1, 1, obj);
//        SoftReference<Object> ref = new SoftReference<>(obj);
//        WeakReference<Object> ref1 = new WeakReference<>(obj);
//        AtomicInteger counter = new AtomicInteger(0);
//        ConcurrentHashMap map = new ConcurrentHashMap();
//        ConcurrentLinkedQueue<Bank> banks = new ConcurrentLinkedQueue<>();
//        ReentrantLock lock = new ReentrantLock();
//        Semaphore semaphore = new Semaphore(1);
//        ExecutorService executorService = Executors.newFixedThreadPool(10);
//        ExecutorService executorService = Executors.newFixedThreadPool(5);
//        CompletionService service = new ExecutorCompletionService(executorService);
//
//        for (int i = 1; i <= 5; i++) {
//            int id = i;
//            service.submit(() -> {
//                Thread.sleep(10000/id);
//                return "Result " + id;
//            });
//        }
//        for (int i = 0; i < 5; i++) {
//            Future take = service.take();
//            System.out.println(take.get());
//        }
//        executorService.shutdown();
        String url = "jdbc:postgresql://localhost:5432/postgres";
        String user = "user";
        String password = "password";
        String sqlInsert = "INSERT INTO students (first_name, last_name, age, email, phone, city) VALUES\n" +
                "           ('Василий', 'Тепловозов', 28, 'vasya.parovozov@example.com', '+7-999-111-22-33', 'Москва');";

        String sqlSelect = "SELECT * FROM students where first_name = ";
        String sqlName = "'Василий'";

//        String sqlPr = "SELECT id, first_name, last_name, age, created_at FROM students WHERE city = ? AND age > ?";
        String sqlBatch = "INSERT INTO students (first_name, last_name, age, email, city) VALUES (?, ?, ?, ?, ?)";
//        String sqlPr = "SELECT * FROM students limit 10";
        try (Connection conn = DriverManager.getConnection(url, user, password)) {
//            Statement stmt = conn.createStatement();
            PreparedStatement pstmt = conn.prepareStatement(sqlBatch);
//            pstmt.setString(1, "Москва");
//            pstmt.setInt(2, 22);
//            ResultSet rs = pstmt.executeQuery();
//            ResultSet rs = stmt.executeQuery("SELECT * FROM students limit 5");
//            int i = stmt.executeUpdate(sqlInsert);
//            System.out.printf("Inserted %d rows into database\n", i);
//            ResultSet rs = stmt.executeQuery(sqlSelect + sqlName);

//            stmt.execute("CREATE TABLE students ");
            conn.setAutoCommit(false);
            Object[][] students = {
                    {"Алексей", "Иванов", 20, "alex11@example.com", "Москва"},
                    {"Мария", "Петрова", 19, "maria11@example.com", "СПб"},
                    {"Дмитрий", "Сидоров", 21, "dmitry111@example.com", "Казань"}
            };

            for (Object[] student : students) {
                pstmt.setString(1, (String) student[0]);
                pstmt.setString(2, (String) student[1]);
                pstmt.setInt(3, (Integer) student[2]);
                pstmt.setString(4, (String) student[3]);
                pstmt.setString(5, (String) student[4]);
                pstmt.addBatch();
            }

            int[] i = pstmt.executeBatch();
            pstmt.clearBatch();
            conn.commit();
//            ResultSet rs = pstmt.executeQuery();

            System.out.println("Insert rows: " + i.length);
            System.out.println(Arrays.toString(i));

//            while (rs.next()) {
//                int id = rs.getInt("id");
//                String firstName = rs.getString("first_name");
//                String lastName = rs.getString("last_name");
//                int age = rs.getInt("age");
//                LocalDateTime createdAt = rs.getObject("created_at", LocalDateTime.class);
//                System.out.printf("%s | %s | %s | %d | %s%n", id, firstName, lastName, age, createdAt);
//            }

            System.out.printf("Connected to PostgreSQL database\n");
        } catch (SQLException e) {
            e.printStackTrace();
        }


    }

    private static void calc(int i, int i1, Object obj) {
        int result = 0;
        result = i + i1;
        System.out.println(result + obj.toString());
    }
}