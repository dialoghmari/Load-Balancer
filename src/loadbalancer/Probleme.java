/**
 *
 * @author Dia LOGHMARI & Wael LATIRI
 * github.com/dialoghmari
 */
package loadbalancer;

import static java.lang.Math.random;
import java.util.Random;

/**
 *
 * @author Asus
 */
public class Probleme {

    public static String generateEq() {
        Random random = new Random();
        String expression = "";
        int a = (int) random.nextInt(10);
        int b = (int) random.nextInt(10);

        final int type = random.nextInt(2);
        switch (type) {
            case 0:
                expression = a + "+" + b;
                break;
            case 1:
                expression = a + "-" + b;
                break;
            case 2:
                expression = a + "*" + b;
                break;
        }
        return expression;
    }

    public static int calculateEq(String expression) {
        int resultat = 0;
        int a = Character.getNumericValue(expression.charAt(0));
        int b = Character.getNumericValue(expression.charAt(2));
        char c = expression.charAt(1);
        switch (c) {
            case '+':
                resultat = a + b;
                break;
            case '-':
                resultat = a - b;
                break;
            case '/':
                resultat = a / b;
                break;
            case '*':
                resultat = a * b;
                break;
        }

        return resultat;
    }

    public static void main(String[] args) {
        Probleme p = new Probleme();
        String ex = p.generateEq();
        System.out.println("Expression : " + ex + " = " + p.calculateEq(ex));

    }

}
