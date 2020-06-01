import java.lang.Math;
import java.lang.RuntimeException;

public class ONP {
    private Stos stack = new Stos();
    Lambda lambda = (a, b) -> a+b;
    /**
     * Metoda sprawdza czy równanie kończy się znakiem '='
     *
     * @param rownanie równanie do sprawdzenia
     * @return true jeśli równanie jest poprawne, false jeśli niepoprawne
     */
    boolean czyPoprawneRownanie(String rownanie) throws RuntimeException {
        if (rownanie.endsWith("="))
            return true;
        else
            throw new RuntimeException("Brak znaku = na koncu");
    }


    private static double silnia(double i) {
        if (i < 1)
            return 1;
        else
            return i * silnia(i - 1);
    }

    /**
     * Metoda oblicza wartość wyrażenia zapisanego w postaci ONP
     *
     * @param rownanie równanie zapisane w postaci ONP
     * @return wartość obliczonego wyrażenia
     */
    public String obliczOnp(String rownanie) {
        if (czyPoprawneRownanie(rownanie)) {
            String wynik = "";
            Double a = 0.0;
            Double b = 0.0;
            for (int i = 0; i < rownanie.length(); i++) {
                if (rownanie.charAt(i) >= '0' && rownanie.charAt(i) <= '9') {
                    wynik += rownanie.charAt(i);
                    if (!(rownanie.charAt(i + 1) >= '0' && rownanie.charAt(i + 1) <= '9')) {
                        stack.push(wynik);
                        wynik = "";
                    }

                } else if (rownanie.charAt(i) == '=') {
                    return stack.pop();
                } else if (rownanie.charAt(i) == '!') {
                    a = Double.parseDouble(stack.pop());
                    stack.push((silnia(a)) + "");
                } //else if (rownanie.charAt(i) == 's') {
                //    a = Double.parseDouble(stack.pop());
                //    stack.push((Math.sqrt(a)) + "");
                //}
                else if (rownanie.charAt(i) != ' ') {
                    b = Double.parseDouble(stack.pop());
                    a = Double.parseDouble(stack.pop());
                    switch (rownanie.charAt(i)) {
                        case ('+'): {
                            stack.push(lambda.oblicz(a, b) + "");
                            break;
                        }
                        case ('-'): {
                            stack.push((a - b) + "");
                            break;
                        }
                        case ('x'):
                            ;
                        case ('*'): {
                            stack.push((a * b) + "");
                            break;
                        }
                        case ('/'): {
                            stack.push((a / b) + "");
                            break;
                        }
                        case ('^'): {
                            stack.push(Math.pow(a, b) + "");
                            break;
                        }
                        case ('s'): {
                            stack.push(Math.pow(b, 1/a) + "");
                            break;
                        }
                        case ('%'): {
                            if(b != 0)
                                stack.push((a % b) + "");
                            break;
                        }
                    }
                }
            }
            return "0.0";
        } else
            return "Brak '='";
    }

    /**
     * Metoda zamienia równanie na postać ONP
     *
     * @param rownanie równanie do zamiany na postać ONP
     * @return równanie w postaci ONP
     */
    public String przeksztalcNaOnp(String rownanie) {
        if (czyPoprawneRownanie(rownanie)) {
            String wynik = "";
            for (int i = 0; i < rownanie.length(); i++) {
                if (rownanie.charAt(i) >= '0' && rownanie.charAt(i) <= '9'){
                    wynik += rownanie.charAt(i);
                    if (!(rownanie.charAt(i + 1) >= '0' && rownanie.charAt(i + 1) <= '9'))
                        wynik += " ";
                } else
                    switch (rownanie.charAt(i)) {
                        case ('+'):
                            ;
                        case ('-'): {
                            while (stack.getSize() > 0 && !stack.showValue(stack.getSize() - 1).equals("(")) {
                                wynik = wynik + stack.pop() + " ";
                            }
                            String str = "" + rownanie.charAt(i);
                            stack.push(str);
                            break;
                        }
                        case ('x'):
                            ;
                        case ('*'):
                            ;
                        case ('/'): {
                            while (stack.getSize() > 0 && !stack.showValue(stack.getSize() - 1).equals("(")
                                    && !stack.showValue(stack.getSize() - 1).equals("+")
                                    && !stack.showValue(stack.getSize() - 1).equals("-")) {
                                wynik = wynik + stack.pop() + " ";
                            }
                            String str = "" + rownanie.charAt(i);
                            stack.push(str);
                            break;
                        }
                        case ('^'):
                        case ('!'): {
                            while (stack.getSize() > 0 && stack.showValue(stack.getSize() - 1).equals("^")) {
                                wynik = wynik + stack.pop() + " ";
                            }
                            String str = "" + rownanie.charAt(i);
                            stack.push(str);
                            break;
                        }
                        case ('('): {
                            String str = "" + rownanie.charAt(i);
                            stack.push(str);
                            break;
                        }
                        case (')'): {
                            while (stack.getSize() > 0 && !stack.showValue(stack.getSize() - 1).equals("(")) {
                                wynik = wynik + stack.pop() + " ";
                            }
                            // zdjęcie ze stosu znaku (
                            stack.pop();
                            break;
                        }
                        case ('='): {
                            while (stack.getSize() > 0) {
                                wynik = wynik + stack.pop() + " ";
                            }
                            wynik += "=";
                        }
                        case ('s'): {
                            while (stack.getSize() > 0 && stack.showValue(stack.getSize() - 1).equals("^")) {
                                wynik = wynik + stack.pop() + " ";
                            }
                            String str = "" + rownanie.charAt(i);
                            stack.push(str);
                            break;
                        }
                        case ('%'): {
                            while (stack.getSize() > 0 && !stack.showValue(stack.getSize() - 1).equals("(")) {
                                wynik = wynik + stack.pop() + " ";
                            }
                            String str = "" + rownanie.charAt(i);
                            stack.push(str);
                            break;
                        }
                    }
            }
            return wynik;
        } else
            return "null";
    }
}
