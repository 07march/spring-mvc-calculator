package by.learn;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Operation {

    @NotNull
    private double num1;
    @NotNull
    private double num2;
    @NotBlank(message = "this field can not be blank! please enter some operation")
    private String operation;
    private double result;
    private User user;
}
