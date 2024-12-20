package fr.epsi;

import fr.epsi.exception.UserNotFoundException;
import fr.epsi.service.UserService;

public class Main {

    public static void main(String[] args) {
        var userService = new UserService();

        try {
            var user = userService.findUserById(1L);
            System.out.println("Utilisateur : " + user);

            var otherUser = userService.findUserById(20L);
            System.out.println("Utilisateur : " + otherUser);
        } catch (UserNotFoundException e) {
            System.err.println(e.getMessage());
            e.printStackTrace();
        }

        System.out.println("Programme terminé");
    }
}
