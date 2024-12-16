package fr.epsi;

import fr.epsi.domain.User;
import fr.epsi.exception.UserNotFoundException;
import fr.epsi.service.UserService;

public class Main4 {

    public static void main(String... args) throws Exception{
        UserService userService = new UserService();
        try {
            User user = userService.findUserById(1L);
            System.out.println(user);
        }catch(UserNotFoundException e) {
            System.out.println("Exception remontée");
            System.out.println(e.getMessage());
            throw e;
        } finally {
            System.out.println("Traitement finally en cours");
        }
    }
}
