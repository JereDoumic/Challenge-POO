import java.io.InputStream;
import java.nio.charset.Charset;
import java.util.Random;
import java.util.Scanner;

public class Password {
    private String password;
    private int length = 8;

    //regionConstructores
    public Password(String password) {
        this.password = password;
    }

    public Password() {
    }

    public Password(int length) {
        if(length <= 8){
            this.password = generarPassword(length);
            this.length = length;
        }
        else
            System.out.println("La contraseña debe tener 8 o menos caracteres");
    }

    //endregion

    //regionMetodos

    //Metodo para conseguir un string aleatorio
    private String generarPassword(int length){
        String AlphaNumerico = "ABCDEFGHIJKLMNOPQRSTUVWXYZ"
                + "0123456789"
                + "abcdefghijklmnopqrstuvxyz";
        StringBuilder new_pass = new StringBuilder(length);
        for (int i = 0; i < length; i++) {
            int index
                    = (int)(AlphaNumerico.length()
                    * Math.random());
            new_pass.append(AlphaNumerico
                    .charAt(index));
        }
       return new_pass.toString();
    }

    public boolean esFuerte(){
        int cant_min = 0;
        int cant_may = 0;
        int cant_num = 0;
        for (char ch: password.toCharArray()) {
            if (Character.isLowerCase(ch)){
                cant_min += 1;
            }
            else if(Character.isUpperCase(ch)){
                cant_may += 1;
            }
            else { cant_num += 1; }
        }
        if (cant_may > 2 && cant_min > 1 && cant_num > 3) {
            return true;
        }
        else {
            return false;
        }
    }

    public void solicitarContraseñaPorTeclado(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Ingrese una contraseña: ");
        this.password = scanner.nextLine();
        System.out.println("Su contraseña es: " + this.password);
        if(esFuerte())
            System.out.println("Contraseña fuerte!");
        else
            System.out.println("Contraseña debil!");

    }
    //endregion

    //regionGettersAndSetters

    public String getPassword() {
        return password;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        if(length <= 8)
            this.length = length;
        else
            System.out.println("La contraseña debe tener 8 o menos caracteres");
    }

    //endregion

    @Override
    public String toString() {
        return "Password{" +
                "contraseña='" + password + '\'' +
                ", longitud=" + length +
                '}';
    }
}