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
}
