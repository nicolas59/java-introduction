package fr.epsi;

import fr.epsi.exception.UserNotFoundException;
import fr.epsi.service.UserService;

public class Main2 {

    public static void main(String[] args) {
        var userService = new UserService();

        try {
            var user = userService.findUserById(1L);
            System.out.println("Utilisateur : " + user);

            var otherUser = userService.findUserById(20L);
            System.out.println("Utilisateur : " + otherUser);
        } catch (UserNotFoundException e) {
            System.err.println(e.getMessage());
        } catch(NullPointerException e){
            System.err.println("Exception qui n'aurait pas du être levée. Message : " + e.getMessage());
        }
    }
}
