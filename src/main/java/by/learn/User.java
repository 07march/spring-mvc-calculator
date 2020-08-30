package by.learn;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
    private static int incId = 1;
    private int id;

    @NotBlank(message = "- name is empty!")
    @Size(min = 3, max = 10, message = "- please enter 3-10 characters!")
    private String name;

    @NotBlank(message = "- login is empty!")
    @Size(min = 5, max = 15, message = "- please enter 4-9 characters!")
    private String login;

    @NotBlank(message = "- password is empty!")
    @Size(min = 5, max = 15, message = "- please enter 5-15 characters!")
    private String password;

    @Min(value = 10, message = "registration only from 10 years old!")
    private int age;

    public User(String name, String login, String password, int age) {
        this.name = name;
        this.login = login;
        this.password = password;
        this.age = age;
    }
}
