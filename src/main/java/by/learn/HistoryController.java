package by.learn;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.List;

@Validated
@Controller
@RequestMapping(path = "/history")
public class HistoryController {

    @Autowired
    private HistoryService historyService;

    @GetMapping
    public String getView() {
        return "historyOperations";
    }

    @GetMapping(path = "/operation")
    public String getViewOperation() {
        throw new RuntimeException();
//        return "operationView";
    }

    @GetMapping(path = "/result")
    public String getViewResult() {
        return "resultView";
    }

    @PostMapping(path = "/operation")
    public String getOperationResult(String value, Model model) {
        List<Operation> operationsByOperationType = historyService.getOperationsByOperationType(value);
        if (operationsByOperationType.size() == 0) {
            model.addAttribute("message", "oops, is empty!");
            return "operationView";
        } else {
            model.addAttribute("operations", operationsByOperationType);
            return "operationView";
        }
    }

    @PostMapping(path = "/result")
    public String getResult(double value, Model model) {
        List<Operation> operationsByResult = historyService.getOperationsByResult(value);
        if (operationsByResult.size() == 0) {
            model.addAttribute("message", "oops, no operations with this result!");
            return "resultView";
        } else {
            model.addAttribute("result", operationsByResult);
            return "resultView";
        }
    }

    @GetMapping(path = "/user")
    public String getViewUser(HttpSession httpSession, Model model) {
        List<Operation> currentUser = historyService.getOperationsByUser((User) httpSession.getAttribute("currentUser"));
        if (currentUser.size() == 0) {
            model.addAttribute("message", "oops, is empty!");
            return "userView";
        } else {
            model.addAttribute("operations", currentUser);
            return "userView";
        }
    }
}
