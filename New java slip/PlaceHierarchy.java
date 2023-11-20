// Write a program for multilevel inheritance such that country is inherited from continent. State is inherited from country. Display the place, state, country and continent.

class Continent {
    private String continentName;

    public Continent(String continentName) {
        this.continentName = continentName;
    }

    public String getContinentName() {
        return continentName;
    }
}

class Country extends Continent {
    private String countryName;

    public Country(String continentName, String countryName) {
        super(continentName);
        this.countryName = countryName;
    }

    public String getCountryName() {
        return countryName;
    }
}

class State extends Country {
    private String stateName;

    public State(String continentName, String countryName, String stateName) {
        super(continentName, countryName);
        this.stateName = stateName;
    }

    public String getStateName() {
        return stateName;
    }

    public void displayDetails() {
        System.out.println("Place: " + stateName);
        System.out.println("State: " + stateName);
        System.out.println("Country: " + getCountryName());
        System.out.println("Continent: " + getContinentName());
    }
}

public class PlaceHierarchy {
    public static void main(String[] args) {
        State state = new State("Asia", "India", "Karnataka");
        state.displayDetails();
    }
}
