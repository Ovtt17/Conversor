import javax.swing.*;
import java.util.HashMap;

public class Temperature {
    HashMap<String, Double> temperatureHashMap = new HashMap<>();
    final static double celsiusToFahrenheit = 1.8;
    final static double celsiusToKelvin = 273.15;
    final static double fahrenheitToCelsius = 0.5555555555555556;
    final static double fahrenheitToKelvin = 255.37222222222222;
    final static double kelvinToCelsius = -273.15;
    final static double kelvinToFahrenheit = -457.87;

    private Double value;

    public Double getValue() {
        return value;
    }

    public void setValue(Double value) {
        this.value = value;
    }

    public Temperature (Double inputValue) {
        setValue(inputValue);
        temperatureHashMap.put("De Celsius a Fahrenheit", getValue() * celsiusToFahrenheit);
        temperatureHashMap.put("De Celsius a Kelvin", getValue() + celsiusToKelvin);
        temperatureHashMap.put("De Fahrenheit a Celsius", (getValue() - 32) * fahrenheitToCelsius);
        temperatureHashMap.put("De Fahrenheit a Kelvin", (getValue() + 459.67) * fahrenheitToKelvin);
        temperatureHashMap.put("De Kelvin a Celsius", getValue() + kelvinToCelsius);
        temperatureHashMap.put("De Kelvin a Fahrenheit", getValue() * kelvinToFahrenheit);
    }
    public void convert(String temperatureToConvert) {
        if (temperatureHashMap.containsKey(temperatureToConvert)) {
            double conversion = temperatureHashMap.get(temperatureToConvert);

            String temperatureDestiny = temperatureToConvert.split("a ")[1];
            String temperatureOrigin = temperatureToConvert.split("De ")[1];

            JOptionPane.showMessageDialog(null, getValue() + " " + temperatureOrigin + " son: " + conversion + " " + temperatureDestiny);
        } else {
            JOptionPane.showMessageDialog(null, "No se pudo realizar la conversión.");
        }
    }
}
