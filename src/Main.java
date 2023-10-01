import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        String option;
        final String coinConversor = "Conversor de monedas";
        final String tempConversor = "Conversor de temperatura";


        do {
            option = (String) JOptionPane.showInputDialog(null,"Seleccione el tipo de conversión que desea realizar:", "Menu", JOptionPane.QUESTION_MESSAGE, null, new Object[] {coinConversor,tempConversor}, "Seleccion");
            if (option == null) {
                break;
            }
            switch (option){
                case coinConversor:
                    try {
                        double inputValue = Double.parseDouble(JOptionPane.showInputDialog(null, "Escriba la cantidad que desea convertir: ", "Mensaje", JOptionPane.INFORMATION_MESSAGE));
                        if (inputValue < 0) {
                            JOptionPane.showMessageDialog(null, "Solo se aceptan cantidades positivas.", "ERROR", JOptionPane.ERROR_MESSAGE);
                        }
                        Coins coinConverter = new Coins(inputValue);
                        String coinConversion = (String) JOptionPane.showInputDialog(null,"Seleccione el tipo de moneda al que desea hacer el cambio:", "Opciones de cambio", JOptionPane.QUESTION_MESSAGE, null, coinConverter.coinHashMap.keySet().toArray(), coinConverter.coinHashMap.keySet().toArray()[0]);
                        coinConverter.convert(coinConversion);
                        int confirmation = JOptionPane.showConfirmDialog(null, "Desea realizar una nueva conversion?", "Confirmación", JOptionPane.YES_NO_CANCEL_OPTION);
                        if(confirmation != JOptionPane.YES_OPTION){
                            JOptionPane.showMessageDialog(null, "Gracias por usar el programa!", "Confirmación", JOptionPane.INFORMATION_MESSAGE);
                            return;
                        }
                    } catch (NumberFormatException e){
                        JOptionPane.showMessageDialog(null, "Ingrese un valor correcto.", "ERROR", JOptionPane.ERROR_MESSAGE);
                        return;
                    } catch (NullPointerException e){
                        JOptionPane.showMessageDialog(null, "Gracias por usar el programa.", "ERROR", JOptionPane.INFORMATION_MESSAGE);
                        return;
                    }
                    break;
                case tempConversor:
                    try {
                        Double inputValue = Double.valueOf(JOptionPane.showInputDialog(null, "Escriba la temperatura que desea convertir: ", "Mensaje", JOptionPane.INFORMATION_MESSAGE));
                        Temperature temperatureConverter = new Temperature(inputValue);
                        String tempConverted = (String) JOptionPane.showInputDialog(null,"Seleccione el tipo de moneda al que desea hacer el cambio:", "Opciones de cambio", JOptionPane.QUESTION_MESSAGE, null, temperatureConverter.temperatureHashMap.keySet().toArray(), temperatureConverter.temperatureHashMap.keySet().toArray()[0]);
                        temperatureConverter.convert(tempConverted);
                        int confirmation = JOptionPane.showConfirmDialog(null, "Desea realizar una nueva conversión?", "Confirmación", JOptionPane.YES_NO_CANCEL_OPTION);
                        if (confirmation != JOptionPane.YES_OPTION) {
                            return;
                        }
                    } catch (NumberFormatException e) {
                        JOptionPane.showMessageDialog(null, "Ingrese un valor correcto.", "ERROR", JOptionPane.ERROR_MESSAGE);
                        return;
                    } catch (NullPointerException e){
                        JOptionPane.showMessageDialog(null, "Gracias por usar el programa.", "ERROR", JOptionPane.INFORMATION_MESSAGE);
                        return;
                    }
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Gracias por usar el programa!");
                    break;
            }

        }while (true);

    }
}