package Maps.Zadanie2;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // zmienna do prezchowywania komendy
        String komenda;
        do{
            System.out.println("Podaj komende: ");
            komenda = scanner.nextLine();
            String[] slowa = komenda.split(" ");

            if(slowa[0].equalsIgnoreCase("wjazd")){
                if(slowa.length > 3){
                }

            }else if(slowa[0].equalsIgnoreCase("wyjazd")){

            }

        }while(!komenda.equalsIgnoreCase("zamknij"));

    }
}
