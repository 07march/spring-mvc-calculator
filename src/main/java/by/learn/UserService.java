package by.learn;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class UserService {
    private List<User> users = new ArrayList<>();

    public void add(User user){
        users.add(user);
    }

    public void delete(User user){
        users.remove(user);
    }

    public boolean updateLogin(String login, int id){
        for (User user : users) {
            if (user.getId() == id) {
                user.setLogin(login);
                return true;
            }
        }
        return false;
    }

    public boolean updatePassword(String password, int id){
        for (User user : users) {
            if (user.getId() == id) {
                if (user.getPassword().equals(password)) {
                    return false;
                }
                user.setPassword(password);
                return true;
            }
        }
        return false;
    }

    public boolean updateName(String name, int id){
        for (User user : users) {
            if (user.getId() == id) {
                user.setName(name);
                return true;
            }
        }
        return false;
    }

    public List<User> findAll(){
        return new ArrayList<>(users);
    }

    public User findById(int id){
        for (User user : users) {
            if (user.getId() == id){
                return user;
            }
        }
        return null;
    }

    public User findByLogin(String login){
        for (User user : users) {
            if (user.getLogin().equals(login)){
                return user;
            }
        }
        throw new UserNorFoundException("User not found");
    }
}
