/* Name - Uditha Lenora
   Student ID - A00235273
   Program - JAV-1001 - 50711 - App Development for Android - 202105 - 001
           - Lab 1 - Variables && Logic
*/

import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
public class Convert {
    public static void main(String[] args){

        Scanner input = new Scanner(System.in);
        double inputValue = 0;
        double calcValue = 0;
        String measurementUnit = "";

        Map<String, String> unitPairNames = new HashMap<>();
        unitPairNames.put("km", "mi");
        unitPairNames.put("mi", "km");
        unitPairNames.put("cm", "in");
        unitPairNames.put("in", "cm");
        unitPairNames.put("kg", "lb");
        unitPairNames.put("lb", "kg");
        unitPairNames.put("g", "oz");
        unitPairNames.put("oz", "g");
        unitPairNames.put("c", "f");
        unitPairNames.put("f", "c");


        //User input
        System.out.println("Enter a value to Convert (Ex :- 10 cm):");
        String userInput = input.nextLine();
        input.close();

        String[] inputTypes = userInput.split(" ");

        inputValue = Double.valueOf(inputTypes[0]);
        measurementUnit = inputTypes[1];

        if (inputValue != 0 && !measurementUnit.equals("") ) {

            measurementUnit = measurementUnit.toLowerCase();
            if(measurementUnit.equals("km") || measurementUnit.equals("mi")) {
                if(measurementUnit.equals("km")) {
                    calcValue = inputValue * 0.62;
                }
                else {
                    calcValue = inputValue * 1.61;
                }
            }
            else if(measurementUnit.equals("cm") || measurementUnit.equals("in")) {
                if(measurementUnit.equals("cm")) {
                    calcValue = inputValue * 0.39;
                }
                else {
                    calcValue = inputValue * 2.54;
                }
            }
            else if(measurementUnit.equals("kg") || measurementUnit.equals("lb")) {
                if(measurementUnit.equals("kg")) {
                    calcValue = inputValue * 2.2;
                }
                else {
                    calcValue = inputValue * 0.45;
                }
            }
            else if(measurementUnit.equals("g") || measurementUnit.equals("oz")) {
                if(measurementUnit.equals("g")) {
                    calcValue = inputValue * 0.4;
                }
                else {
                    calcValue = inputValue * 28.35;
                }
            }
            else if(measurementUnit.equals("c") || measurementUnit.equals("f")) {
                if(measurementUnit.equals("c")) {
                    calcValue = (inputValue * 9 / 5) + 32;
                }
                else {
                    calcValue = ((inputValue - 32) * 5 / 9);
                }
            }
            else {
                System.out.println("Invalid input received for unit of measurement: " + measurementUnit);
            }

            //print convertered values
            if(calcValue != 0) {
                DecimalFormat df = new DecimalFormat("#.##");
                String formatted = df.format(calcValue);

                System.out.print(inputValue + " " + measurementUnit + " " + " " + "is equal to" + " ");
                System.out.print(formatted + " " + unitPairNames.get(measurementUnit));
            }
        }
        else {
            System.out.println("Invalid input received for value: " + inputValue + ", and  unit of measurement: " + measurementUnit);
        }
    }
}
