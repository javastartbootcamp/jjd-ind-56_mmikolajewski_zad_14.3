import java.math.BigDecimal;

public class Country {
    private String name;
    private String abbreviation;
    private BigDecimal population;

    public Country(String name, String abbreviation, BigDecimal population) {
        this.name = name;
        this.abbreviation = abbreviation;
        this.population = population;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAbbreviation() {
        return abbreviation;
    }

    public void setAbbreviation(String abbreviation) {
        this.abbreviation = abbreviation;
    }

    public BigDecimal getPopulation() {
        return population;
    }

    public void setPopulation(BigDecimal population) {
        this.population = population;
    }

    @Override
    public String toString() {
        return  abbreviation + " " +  name + " " + population;
    }
}
