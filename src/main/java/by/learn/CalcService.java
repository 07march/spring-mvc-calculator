package by.learn;

import org.springframework.stereotype.Component;

@Component
public class CalcService {

    public Double calc(Double a, Double b, String type) {
        switch (type) {
            case "sum":
                return sum(a, b);
            case "sub":
                return sub(a, b);
            case "mul":
                return mul(a, b);
            case "div":
                return div(a, b);
            default:
                return null;
        }
    }

    private Double sum(Double a, Double b) {
        return a + b;
    }

    private Double sub(Double a, Double b) {
        return a - b;
    }

    private Double mul(Double a, Double b) {
        return a * b;
    }

    private Double div(Double a, Double b) {
        return a / b;
    }
}
