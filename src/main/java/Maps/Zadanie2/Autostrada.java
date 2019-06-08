package Maps.Zadanie2;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

public class Autostrada {

    // mapa w ktorej przechowujemuy pojazdy
    // do oszybkiego wyszukiwania kluczem jest nr rejestracyjny
    private Map<String, InformacjeOPojezdzie> mapaPojazdow = new HashMap<>();


    void wjazdPojazduNaAutostrade(String numerRejestracyjny, TypPojazdu typPojazdu){
        InformacjeOPojezdzie informacjeOPojezdzie = new InformacjeOPojezdzie(numerRejestracyjny, typPojazdu, LocalDateTime.now());
        mapaPojazdow.put(numerRejestracyjny, informacjeOPojezdzie);
        System.out.println("Pojazd: " + informacjeOPojezdzie + ", wjechal na autostrade. ");
    }

    public InformacjeOPojezdzie znajdzPojazd(String numerRejestracyjny){
        if(mapaPojazdow.containsKey(numerRejestracyjny)){
            return mapaPojazdow.get(numerRejestracyjny);
        }
        throw new NIeMoznaZnalezdzPojazduExeption();
    }

    public Double wyjazdPojazdu(String numerRejestracyjny){
        if(!mapaPojazdow.containsKey(numerRejestracyjny)){
            throw new NIeMoznaZnalezdzPojazduExeption();
        }
        InformacjeOPojezdzie informacjeOPojezdzie = mapaPojazdow.get(numerRejestracyjny);
        // obliczamy roznice miedzy data wiazdu a wyjazdu
        Duration dlugoscPrzejazdu = Duration.between(informacjeOPojezdzie.getDataWjazdu(), LocalDateTime.now());

        double doZaplaty = 0.0;
        switch (informacjeOPojezdzie.getTypPojazdu()){
            case OSOBOWY:
                doZaplaty = dlugoscPrzejazdu.getSeconds() * 0.3;
                break;
            case MOTOCYKl:
                doZaplaty = dlugoscPrzejazdu.getSeconds() * 0.2;
            case CIEZAROWY:
                doZaplaty = dlugoscPrzejazdu.getSeconds() * 0.5;
        }
        mapaPojazdow.remove(numerRejestracyjny);
        System.out.println("Pojazd: " + numerRejestracyjny + " opuszcza autostrade, do zaplaty: " + doZaplaty);
        return  doZaplaty;
    }
}

