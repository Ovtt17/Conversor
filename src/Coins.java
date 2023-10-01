import javax.swing.*;
import java.util.HashMap;

public class Coins {
    HashMap<String, Double> coinHashMap = new HashMap<>();
    final double dollar = 36.5;
    final double euro = 38.73;
    final double libra = 44.62;
    final double yen = 0.24;
    final double won = 2.70;
    private Double value;

    public Double getValue() {
        return value;
    }

    public void setValue(Double value) {
        this.value = value;
    }

    public Coins(Double inputValue) {
        setValue(inputValue);
        coinHashMap.put("De Cordobas a Dollar",(double) Math.round(getValue() / dollar));
        coinHashMap.put("De Cordobas a Euro",(double) Math.round(getValue() / euro));
        coinHashMap.put("De Cordobas a Libra Esterlina", (double) Math.round(getValue() / libra));
        coinHashMap.put("De Cordobas a Yen Japonés", (double) Math.round(getValue() / yen));
        coinHashMap.put("De Cordobas a Won sur-coreano", (double) Math.round(getValue() / won));


        coinHashMap.put("De Dollar a Cordobas", (double) Math.round(getValue() * dollar));
        coinHashMap.put("De Euro a Cordobas", (double) Math.round(getValue() * euro));
        coinHashMap.put("De Libra Esterlina a Cordobas", (double) Math.round(getValue() * libra));
        coinHashMap.put("De Yen Japonés a Cordobas", (double) Math.round(getValue() * yen));
        coinHashMap.put("De Won sur-coreano a Cordobas", (double) Math.round(getValue() * won));
    }
    public void convert (String coinToConvert) {
        if (coinHashMap.containsKey(coinToConvert)) {
            double conversion = coinHashMap.get(coinToConvert);

            String coinDestiny = coinToConvert.split("a ")[1];
            String coinOrigin = coinToConvert.split("De ")[1];

            JOptionPane.showMessageDialog(null, "$" + getValue() + " " + coinOrigin + " son: $" + conversion + " " +coinDestiny);
        } else {
            JOptionPane.showMessageDialog(null, "No se pudo realizar la conversión.");
        }
    }

}
