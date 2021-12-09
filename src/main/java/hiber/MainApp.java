package hiber;

import hiber.config.AppConfig;
import hiber.model.Car;
import hiber.model.User;
import hiber.service.UserService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.sql.SQLException;
import java.util.List;

public class MainApp {
   public static void main(String[] args) throws SQLException {
      AnnotationConfigApplicationContext context = 
            new AnnotationConfigApplicationContext(AppConfig.class);

      UserService userService = context.getBean(UserService.class);

      userService.add(new User("Ivan", "Ivanov", "ivanov@mail.ru", new Car ("Vaz", 2101)));
      userService.add(new User("Semen", "Semenov", "semenov@mail.ru", new Car ("Gaz", 53)));
      userService.add(new User("Gosha", "Vasiluk", "gosha@mail.ru", new Car ("Mark-II", 90)));
      userService.add(new User("Dima", "Boroda", "user4@mail.ru", new Car ("Skyline", 34)));

      List<User> users = userService.listUsers();
      for (User user : users) {
         System.out.println("Id = "+user.getId());
         System.out.println("First Name = "+user.getFirstName());
         System.out.println("Last Name = "+user.getLastName());
         System.out.println("Email = "+user.getEmail());
         System.out.println("Car = " + user.getUserCar());
         System.out.println();
      }
      User userCar = userService.getUserCar("Vaz", 2101);
      System.out.println(userCar);


      context.close();
   }
}
