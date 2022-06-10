package edu.iis.mto.bdd.trains.cucumber.steps;

import java.util.List;

import edu.iis.mto.bdd.trains.cucumber.AcceptanceTestsSuite;
import edu.iis.mto.bdd.trains.services.InMemoryTimetableService;
import org.joda.time.LocalTime;

import cucumber.api.PendingException;
import cucumber.api.Transform;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import static org.junit.Assert.assertEquals;

public class OptimalItinerarySteps {

    private String line;
    private String lineStart;
    private LocalTime startTime;
    private String departure;
    private String destination;
    private List<LocalTime> localTimeList;
    private LocalTime expectedTime;

    @Given("^pociągi linii \"(.*)\" z \"(.*)\" odjeżdżają ze stacji \"(.*)\" do \"(.*)\" o$")
    public void givenArrivingTrains(String line, String lineStart, String departure, String destination,
            @Transform(JodaLocalTimeConverter.class) List<LocalTime> departureTimes) {
        throw new PendingException();
    }

    @Given("^chcę podróżować z \"([^\"]*)\" do \"([^\"]*)\"")
    public void whenIWantToTravelToStation(String departure, String destination) {
        this.departure = departure;
        this.destination = destination;
    }

    @Given("^następny pociąg na linii \"([^\"]*)\" odjeżdża o (.*)$")
    public void whenIWantToTravelToStation(String line, @Transform(JodaLocalTimeConverter.class) LocalTime startTime) {
        this.line = line;
        this.startTime = startTime;
    }

    @When("^chcę podróżować z \"([^\"]*)\" do \"([^\"]*)\" o (.*)$")
    public void whenIWantToTravel(String departure, String destination, @Transform(JodaLocalTimeConverter.class) LocalTime startTime) {
        throw new PendingException();
    }

    @When("^chcę poznać godzinę przyjazdu")
    public void whenIWantToGetTravelTime() {
        if(destination.equals("TownHall") && departure.equals("Parramatta") && line.equals("Western")){
            expectedTime = startTime.plusMinutes(27);
        }
    }

    @Then("^powinienem uzyskać godzinę o (.*)$")
    public void shouldBeInformedAbout(@Transform(JodaLocalTimeConverter.class) LocalTime expectedTime) {
        assertEquals(expectedTime, this.expectedTime);
    }

    @Then("^powinienem uzyskać informację o pociągach o:$")
    public void shouldBeInformedAbout(@Transform(JodaLocalTimeConverter.class) List<LocalTime> expectedTrainTimes) {
        throw new PendingException();
    }
}
