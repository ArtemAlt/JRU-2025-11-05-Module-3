package com.example;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import org.json.JSONObject;

import javax.sql.rowset.CachedRowSet;
import javax.sql.rowset.FilteredRowSet;
import javax.sql.rowset.JdbcRowSet;
import javax.sql.rowset.RowSetFactory;
import javax.sql.rowset.RowSetProvider;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Savepoint;
import java.sql.Statement;

public class Main {
    public static void main(String[] args) throws SQLException {
        String url = "jdbc:postgresql://localhost:5432/postgres";
        String user = "user";
        String password = "password";

//        try (Connection conn = DriverManager.getConnection(url, user, password)) {
//            // Отключаем AutoCommit
//            conn.setAutoCommit(false);
//            System.out.println("AutoCommit: " + conn.getAutoCommit());  // false
//
//            try {
//                // Операция 1: обновляем студентов
//                String sql1 = "UPDATE students SET age = age + 1 WHERE city = 'Москва'";
//                try (Statement stmt = conn.createStatement()) {
//                    int rows = stmt.executeUpdate(sql1);
//                    System.out.println("Обновлено студентов в Москве: " + rows);
//                }
//
//                // Операция 2: добавляем запись на курс
//                String sql2 = "INSERT INTO enrollments (student_id, course_id, teacher_id, grade) VALUES (?, ?, ?, ?)";
//                try (PreparedStatement pstmt = conn.prepareStatement(sql2)) {
//                    pstmt.setInt(1, 1);
//                    pstmt.setInt(2, 1);
//                    pstmt.setInt(3, 1);
//                    pstmt.setInt(4, 5);
//                    pstmt.executeUpdate();
//                    System.out.println("Добавлена запись на курс");
//                }
//
//                // Если всё хорошо — подтверждаем
//                conn.commit();
//                System.out.println("✅ Транзакция успешно выполнена!");
//
//            } catch (SQLException e) {
//                // Если ошибка — откатываем всё
//                conn.rollback();
//                System.err.println("❌ Транзакция откачена: " + e.getMessage());
//            } finally {
//           conn.setAutoCommit(true);}
//        }

//        try (Connection conn = DriverManager.getConnection(url, user, password)) {
//            conn.setAutoCommit(false);
//
//            Savepoint sp2 = null;
//            try {
//                // Шаг 1: обновляем студентов из Москвы
//                String sql1 = "UPDATE students SET age = age + 1 WHERE city = 'Москва'";
//                try (Statement stmt = conn.createStatement()) {
//                    int rows = stmt.executeUpdate(sql1);
//                    System.out.println("1. Обновлено студентов в Москве: " + rows);
//                }
//
//                // Точка сохранения №1
//                Savepoint sp1 = conn.setSavepoint("after_moscow_update");
//                System.out.println("📌 Точка сохранения: after_moscow_update");
//
//                // Шаг 2: обновляем студентов из Казани
//                String sql2 = "UPDATE students SET age = age + 1 WHERE city = 'Казань'";
//                try (Statement stmt = conn.createStatement()) {
//                    int rows = stmt.executeUpdate(sql2);
//                    System.out.println("2. Обновлено студентов в Казани: " + rows);
//                }
//
//                // Точка сохранения №2
//                sp2 = conn.setSavepoint("after_kazan_update");
//                System.out.println("📌 Точка сохранения: after_kazan_update");
//
//                // Шаг 3: добавляем нового студента (может вызвать ошибку)
//                String sql3 = "INSERT INTO students (first_name, last_name, age, email, city) VALUES (?, ?, ?, ?, ?)";
//                try (PreparedStatement pstmt = conn.prepareStatement(sql3)) {
//                    pstmt.setString(1, "Тестовый");
//                    pstmt.setString(2, "Студент");
//                    pstmt.setInt(3, 20);
//                    pstmt.setString(4, "test@example.com");
//                    pstmt.setString(5, "Москва");
//                    pstmt.executeUpdate();
//                    System.out.println("3. Добавлен новый студент");
//                }
//
//                // Всё хорошо — коммит
//                conn.commit();
//                System.out.println("✅ Транзакция успешно выполнена!");
//
//            } catch (SQLException e) {
//                System.err.println("❌ Ошибка: " + e.getMessage());
//
//                // Откатываемся к точке after_kazan_update
//                // (отменяем только добавление студента, но сохраняем обновления возрастов)
//                conn.rollback(sp2);
//                conn.commit();
//                System.out.println("↩️ Откат до savepoint 'after_kazan_update'");
//                System.out.println("✅ Изменения возрастов сохранены");
//
//            } finally {
//                conn.setAutoCommit(true);
//            }
//
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }

//        try {
//            Connection conn = DriverManager.getConnection(url, user, password);
//            File photo = new File("photo.jpg");
//            PreparedStatement ps = conn.prepareStatement("insert into photo (filename) values (?)");
//            try (FileInputStream fis = new FileInputStream(photo)){
//                ps.setBinaryStream(1, fis);
//            } catch (FileNotFoundException e) {
//                throw new RuntimeException(e);
//            } catch (IOException e) {
//                throw new RuntimeException(e);
//            }
//        } catch (SQLException e) {
//            throw new RuntimeException(e);
//        }
//
//        String sql = "SELECT student_id, photo, photo_name FROM student_photos WHERE student_id = ?";
//        try (Connection conn = DriverManager.getConnection(url, user, password);
//             PreparedStatement pstmt = conn.prepareStatement(sql)) {
//
//            pstmt.setInt(1, 1);
//
//            try (ResultSet rs = pstmt.executeQuery()) {
//                if (rs.next()) {
//                    String photoName = rs.getString("photo_name");
//                    byte[] photoData = rs.getBytes("photo");
//
//                    System.out.println("📸 Фото: " + photoName);
//                    System.out.println("   Размер: " + photoData.length + " байт");
//
//                    // Сохраняем в файл
//                    try (FileOutputStream fos = new FileOutputStream("downloaded_" + photoName)) {
//                        fos.write(photoData);
//                        System.out.println("✅ Фото сохранено в файл");
//                    }
//                }
//            }
//
//        } catch (Exception e) {
//            e.printStackTrace();
//        }

//        JSONObject preferences = new JSONObject();
//        preferences.put("theme", "dark");
//        preferences.put("notifications", true);
//        preferences.put("language", "ru");
//
//        JSONObject address = new JSONObject();
//        address.put("city", "Москва");
//        address.put("street", "Тверская");
//        address.put("zip", "101000");
//        preferences.put("address", address);
//
//        String sql = "INSERT INTO student_preferences (student_id, preferences) VALUES (?, ?::jsonb)";
//
//        try (Connection conn = DriverManager.getConnection(url, user, password);
//             PreparedStatement pstmt = conn.prepareStatement(sql)) {
//
//            pstmt.setInt(1, 1);
//            pstmt.setString(2, preferences.toString());
//            pstmt.executeUpdate();
//            System.out.println("✅ JSON сохранён в БД");
//
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        String sql = "SELECT student_id, preferences FROM student_preferences WHERE student_id = ?";
//
//        try (Connection conn = DriverManager.getConnection(url, user, password);
//             PreparedStatement pstmt = conn.prepareStatement(sql)) {
//
//            pstmt.setInt(1, 1);
//
//            try (ResultSet rs = pstmt.executeQuery()) {
//                if (rs.next()) {
//                    String jsonStr = rs.getString("preferences");
//                    JSONObject preferences = new JSONObject(jsonStr);
//
//                    System.out.println("📋 Предпочтения студента:");
//                    System.out.println("   Тема: " + preferences.getString("theme"));
//                    System.out.println("   Уведомления: " + preferences.getBoolean("notifications"));
//                    System.out.println("   Язык: " + preferences.getString("language"));
//
//                    JSONObject address = preferences.getJSONObject("address");
//                    System.out.println("   Адрес:");
//                    System.out.println("      Город: " + address.getString("city"));
//                    System.out.println("      Улица: " + address.getString("street"));
//                }
//            }
///*
//SELECT student_id, preferences->>'theme' AS theme, preferences->>'language' AS lang
//FROM student_preferences WHERE preferences->>'theme' = 'dark';
// */
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        String xml = """
//            <?xml version="1.0" encoding="UTF-8"?>
//            <student>
//                <id>1</id>
//                <firstName>Иван</firstName>
//                <lastName>Петров</lastName>
//                <age>20</age>
//                <city>Москва</city>
//            </student>
//            """;
//
//        String sql = "INSERT INTO student_documents (student_id, document, doc_name) VALUES (?, XMLPARSE(DOCUMENT ?), ?)";
//
//        try (Connection conn = DriverManager.getConnection(url, user, password);
//             PreparedStatement pstmt = conn.prepareStatement(sql)) {
//
//            pstmt.setInt(1, 1);
//            pstmt.setString(2, xml);
//            pstmt.setString(3, "student_info.xml");
//            pstmt.executeUpdate();
//            System.out.println("✅ XML сохранён в БД");
//
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        HikariConfig config = new HikariConfig();
//        config.setJdbcUrl(url);
//        config.setUsername(user);
//        config.setPassword(password);
//
//        config.setMaximumPoolSize(10);        // Максимум соединений в пуле
//        config.setMinimumIdle(5);             // Минимум свободных соединений
//        config.setIdleTimeout(300000);        // 5 минут бездействия → закрыть
//        config.setMaxLifetime(1800000);       // 30 минут → закрыть и создать новое
//        config.setConnectionTimeout(30000);   // 30 секунд ожидания подключения
//
//        try (HikariDataSource ds = new HikariDataSource(config)) {
//            for (int i = 0; i < 1500; i++) {
//                try (Connection conn = ds.getConnection();
//                     PreparedStatement pstmt = conn.prepareStatement("SELECT COUNT(*) FROM students");
//                     ResultSet rs = pstmt.executeQuery()) {
//
//                    if (rs.next()) {
//                        System.out.println("  Запрос " + (i + 1) + ": студентов = " + rs.getInt(1));
//                    }
//                }
//            }
//        }

//        try (Connection connection = DriverManager.getConnection(url, user, password)) {
//            Statement statement = connection.createStatement(
//                    ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE
//            );
//           /*
//            ResultSet.TYPE_FORWARD_ONLY;
//            ResultSet.TYPE_SCROLL_INSENSITIVE;
//            ResultSet.TYPE_SCROLL_SENSITIVE;
//
//*/
//
//            ResultSet resultSet = statement.executeQuery("CREATE TABLE IF NOT EXISTS postgres (");
//
//        RowSetFactory rowSetFactory = RowSetProvider.newFactory();
//        JdbcRowSet jdbcRowSet = rowSetFactory.createJdbcRowSet();
//        CachedRowSet cachedRowSet = rowSetFactory.createCachedRowSet();
//        FilteredRowSet filteredRowSet = rowSetFactory.createFilteredRowSet();
//
//
//        jdbcRowSet.setUrl(url);
//        jdbcRowSet.setUsername(user);
//        jdbcRowSet.setPassword(password);
//        jdbcRowSet.setCommand("SELECT 1");
//        jdbcRowSet.execute();
//
//        while (jdbcRowSet.next()) {
//            System.out.println(jdbcRowSet.getString(1));
//        }



    }
}