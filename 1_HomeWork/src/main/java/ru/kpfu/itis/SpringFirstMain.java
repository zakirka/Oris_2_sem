package ru.kpfu.itis;

import ru.kpfu.itis.entity.User;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import ru.kpfu.itis.service.UserService;


@SpringBootApplication
public class SpringFirstMain {
    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(SpringFirstMain.class, args);

        UserService userService = context.getBean(UserService.class);

        System.out.println("Cоздание пользователей: ");

        User u1 = userService.create("Азамат");
        User u2 = userService.create("Максим");
        User u3 = userService.create("Виктория");

        System.out.println(u1);
        System.out.println(u2);
        System.out.println(u3);

        System.out.println("\n2. Все пользователи: ");
        for (User u : userService.getAll()) {
            System.out.println(u);
        }

        System.out.println("\n3. Пользователь с id = 2: ");
        System.out.println(userService.get(1L));

        System.out.println("\n4. Удаление пользователя с id = 3: ");
        userService.delete(3L);

        System.out.println("\n5. Остались после удаления:");
        for (User u : userService.getAll()) {
            System.out.println(u);
        }
    }
}

