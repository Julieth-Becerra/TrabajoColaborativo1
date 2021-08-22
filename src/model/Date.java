/**
 * Paquete model
 */
package model;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Clase con la funcionalidad de manejo de cadenas
 */
public class Date {

    /**
     * Cadena de caracteres
     */
    private String string;
    char[] caracteres;

    /**
     * Se define la cadena de caracteres inmutable
     */

    public Date() {
       this.string = "Sogamoso ciudad del sol y del acero";
       this.caracteres=string.toCharArray();
        caracteres[0] = Character.toUpperCase(caracteres[0]);
    }

    /**
     * Metodo que retorna el contenido de la cadena
     * @return contenido de la cadena
     */
    public String getDate() {
        return string;
    }
    
     /**
     * Metodo que elimina caracter escrito de la cadena de texto ya instanciada
     *
     * @param CharacterRemoved - carcaterer
     * @return Delete - cadena de caracteres
     */
    public String DeleteCharacter(String CharacterRemoved) {
        String Delete = "";
        for (int i = 0; i < string.length(); i++) {
            String aux = Character.toString(string.charAt(i));
            if (!CharacterRemoved.contains(aux)) {
                Delete += aux.toLowerCase();
            }
        }
        return Delete;
    }

    /**
     * Metodo que convierte la cadena de caracteres inmutable en nombre propio.
     * @return contenido de la cadena convertido en nombre propio
     */

    public String convertirNombrePropio(){
        for (int i = 0; i < string.length()- 2; i++){

            if (caracteres[i] == ' ' || caracteres[i] == '.' || caracteres[i] == ',' ) {
                caracteres[i + 1] = Character.toUpperCase(caracteres[i + 1]);
            }
        }return new String(caracteres);
    }
    /**
     * Metodo el cual muestra los caracteres que se repiten entre las dos cadenas
     *
     * @param sentenc cadena de caracteres
     * @return retorna cadena de caracteres iguales sin repetir del parametro
     *         ingresado
     */

    public String intersection(String sentenc) {

        String duplicate = "";
        for (int i = 0; i < sentenc.length(); i++) {
            String si = Character.toString(sentenc.charAt(i));
            if (string.contains(si)) {
                if (!duplicate.contains(si)) {
                    duplicate += si;
                }
            }
        }
        return duplicate;
    }

    /**
     * Metodo el cual muestra la diferencia de caracteres de la cadena original con
     * la entrada o parametro
     *
     * @param sentenc cadena de caracteres
     * @return cadena original con caracteres de diferencia.
     */
    public String diferencia(String sentenc) {
        String duplicate = "";
        for (int i = 0; i < string.length(); i++) {
            String si = Character.toString(string.charAt(i));
            if (!sentenc.contains(si)) {
                duplicate += si;
            }
        }
        return duplicate;
    }

    /**
     * Metodo de encriptacion de caracteres (cifrado César)
     * @param text texto a encriptar
     * @param key valor de desplazamiento en abecedario
     * @return texto encriptado
     */
    public static String encrypt (String text, int key ) {
        StringBuilder cifrar = new StringBuilder();
        key = key % 26;
        for (int i = 0; i < text.length(); i++) {
            if (text.charAt(i) >= 'a' && text.charAt(i) <= 'z') {
                if ((text.charAt(i) + key) > 'z') {
                    cifrar.append((char) (text.charAt(i) + key - 26));
                } else {
                    cifrar.append((char) (text.charAt(i) + key));
                }
            } else if (text.charAt(i) >= 'A' && text.charAt(i) <= 'Z') {
                if ((text.charAt(i) + key) > 'Z') {
                    cifrar.append((char) (text.charAt(i) + key - 26));
                } else {
                    cifrar.append((char) (text.charAt(i) + key));
                }
            }
        }
        return cifrar.toString();
    }

    /**
     * Metodo de desencriptacion de caracteres (cifrado César)
     * @param text texto a desencriptar
     * @param key valor de dezplazamiento en abecedario
     * @return texto desencriptado
     */
    public static String decrypt (String text , int key) {
        StringBuilder cifrar = new StringBuilder();
        key = key % 26;
        for (int i = 0; i < text.length(); i++) {
            if (text.charAt(i) >= 'a' && text.charAt(i) <= 'z') {
                if ((text.charAt(i) - key) < 'a') {
                    cifrar.append((char) (text.charAt(i) - key + 26));
                } else {
                    cifrar.append((char) (text.charAt(i) - key));
                }
            } else if (text.charAt(i) >= 'A' && text.charAt(i) <= 'Z') {
                if ((text.charAt(i) - key) < 'A') {
                    cifrar.append((char) (text.charAt(i) - key + 26));
                } else {
                    cifrar.append((char) (text.charAt(i) - key));
                }
            }
        }
        return cifrar.toString();
    }



    /**
     * Metodo que permite hacer verificacion de validez de un correo
     * @param mail mail a verificar validez
     * @return valor logico que indica si el correo tiene validez
     */
    public boolean mailValidation (String mail){

        Pattern pattern = Pattern.compile("^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$");

        Matcher matcher = pattern.matcher(mail);

        boolean aux;

        if(matcher.find() == true){
            aux = true;
        } else {
            aux = false;
        }

        return aux;
    }

    /**
     * Metodo con el que se revisa la ocurrencia de una sub cadena dentro de una cadena y se devuelve en numero de veces que esta
     * @param subString subString sub cadena a buscar dentro de la cadena
     * @return cont el numero de veces que se encuentra la sub cadena
     */
    public int countOccurrences(String subString) {
        int cont = 0;
        if (string.length() == subString.length()) {
            if (string.equalsIgnoreCase(subString)) {
                cont++;
            }
        } else if (string.length() < subString.length()) {
            cont = 0;
        } else {
            for (int i = 0; i <= string.length() - subString.length(); i++) {

                if (i == 0) {
                    if (string.substring(i + subString.length(), (i + subString.length() + 1)).equalsIgnoreCase(" ")) {
                        if (string.substring(i, i + subString.length()).equalsIgnoreCase(subString)) {
                            cont++;
                        }
                    }
                } else if (i < string.length() - subString.length()) {
                    if (string.substring(i - 1, i).equalsIgnoreCase(" ")
                            && string.substring(i + subString.length(), (i + subString.length() + 1)).equalsIgnoreCase(" ")) {
                        if (string.substring(i, i + subString.length()).equalsIgnoreCase(subString)) {
                            cont++;
                        }
                    }
                } else {
                    if (string.substring(i - 1, i).equalsIgnoreCase(" ")) {
                        if (string.substring(i, i + subString.length()).equalsIgnoreCase(subString)) {
                            cont++;
                        }
                    }
                }
            }
        }
        return cont;
    }

    /**
     * Memoto que revisa si una palabra existe
     * @param character caracteres
     * @param string cadena de texto
     * @return boolean
     */

    public static boolean frequency(String character, String string) {
        int counter = 0;
        for (int i = 0; i < string.length(); i++) {
            if (string.substring(i, i + 1).equalsIgnoreCase(character)) {
                counter++;
            }
        }
        if (counter == 0)
            return false;
        else
            return true;
    }

    /**
     * Metodo que compara una subcadena con una cadena y elimina la subcadena por izquierda o derecha
     * @param subStrings subString subcadena a eliminar
     * @param address address direccion por la que se va a eliminar la subcadena de la frase
     * @return finalText
     */

    public String deleteSubstring (String subStrings, String address) {

        if (address.equals("left")) {
            String finalText = string;
            for (int i = 0; i < string.length(); i++) {
                if (frequency(string.substring(i, i + 1), subStrings)) {
                    finalText = string.substring(i + 1, string.length());
                } else {
                    return finalText;
                }

            }
            return finalText;
        } else {
            String finalText = string;
            for (int i = string.length(); i >= 0; i--) {
                if (frequency(string.substring(i - 1, i), subStrings)) {
                    finalText = string.substring(0, i - 1);
                } else {
                    return finalText;
                }

            }
            return finalText;
        }
    }
}
