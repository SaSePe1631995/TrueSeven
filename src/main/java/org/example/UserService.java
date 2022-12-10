package org.example;

public class UserService {

    private static final UserDAO _userDAO = new UserDAO();

    public static void add(User user){
        _userDAO.add(user);
    }

    public static void edit(int id, User user){
        _userDAO.edit(id, user);
    }

    public static void get (){
        _userDAO.get();
    }

    public static void get (String username){
        _userDAO.get(username);
    }

    public static void get (int fromAge, int toAge){
        _userDAO.get(fromAge, toAge);
    }

    public static void delete (int id){
        _userDAO.delete(id);
    }

    public static void delete (String username){
        _userDAO.delete(username);
    }

}
