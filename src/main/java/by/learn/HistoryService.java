package by.learn;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class HistoryService {
    private List<Operation> operations = new ArrayList<>();

    public void add(double num1, double num2, String operation, double result, User user) {
        operations.add(new Operation(num1, num2, operation, result, user));
    }

    public List<Operation> getOperationsByOperationType(String operation) {
        List<Operation> myOper = new ArrayList<>();
        for (Operation operations : operations) {
            if (operations == null) break;
            if (operations.getOperation().equals(operation)) {
                myOper.add(operations);
            }
        }
        return myOper;
    }

    public List<Operation> getOperationsByResult(double result) {
        List<Operation> myOper = new ArrayList<>();
        for (Operation operation : operations) {
            if (operation == null) break;
            if (operation.getResult() == result) {
                myOper.add(operation);
            }
        }
        return myOper;
    }

    public List<Operation> getOperationsByUser(User user) {
        List<Operation> users = new ArrayList<>();
        for (Operation operation : operations) {
            if (operation == null) break;
            if (operation.getUser().equals(user)) {
                users.add(operation);
            }
        }
        return users;
    }

}

