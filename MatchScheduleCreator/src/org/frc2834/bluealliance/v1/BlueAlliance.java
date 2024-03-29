package org.frc2834.bluealliance.v1;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import org.frc2834.bluealliance.v1.event.Event;
import org.frc2834.bluealliance.v1.event.SimpleEvent;
import org.frc2834.bluealliance.v1.matches.Match;
import org.frc2834.bluealliance.v1.teams.Team;
import org.frc2834.bluealliance.v1.util.Constants;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.lang.reflect.Type;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.util.Arrays;
import java.util.List;

/**
 * This is the starting class to access all BlueAlliance "objects", like teams and events
 */
public class BlueAlliance {


    /**
     * Queries basic information about a team or multiple teams
     *
     * @param teamsKeys Team keys to query data on, ex. frc2834
     * @return List<Team> A list of Team objects that contains information about a team or multiple teams
     * @throws IOException Throws IOException on connection/reader errors
     */
    public List<Team> getTeamsInfo(String[] teamsKeys) throws IOException {
        @SuppressWarnings("unchecked")
        List<Team> list = (List<Team>) (List<?>) deserializeJSONArray(new TypeToken<List<Team>>() {
        }.getType(),
                createReader(createURL(Constants.BLUE_ALLIANCE_TEAMS_INFO + Arrays.toString(teamsKeys).replace("[", "").replace("]", "").replace(" ", ""))));
        return list;
    }

    /**
     * Queries basic information about a single team
     *
     * @param teamKey The team key you want to query data on, ex. "frc2834"
     * @return Returns a Team object that contains information about the team
     * @throws IOException Throws IOException on connection/reader errors
     */
    public Team getTeamDetails(String teamKey) throws IOException {
        return (Team) deserializeJSON(new Team(), createReader(createURL(Constants.BLUE_ALLIANCE_TEAM_DETAILS + teamKey)));
    }

    /**
     * Queries a list of all the events for a given year, with basic information for each event
     *
     * @param year The year to query a list of events from, ex. "2014"
     * @return Returns a List of SimpleEvent objects, each containing basic information about the events
     * @throws IOException Throws IOException on connection/reader errors
     */
    public List<SimpleEvent> getEventList(String year) throws IOException {
        @SuppressWarnings("unchecked")
        List<SimpleEvent> list = (List<SimpleEvent>) (List<?>) deserializeJSONArray(new TypeToken<List<SimpleEvent>>() {
        }.getType(),
                createReader(createURL(Constants.BLUE_ALLIANCE_EVENT_LIST + year)));
        return list;
    }

    /**
     * Get extremely detailed event information for an event
     *
     * @param eventKey The BlueAlliance event key
     * @return Returns an Event object
     * @throws IOException Throws IOException on connection/reader errors
     */
    public Event getEventDetails(String eventKey) throws IOException {
        return (Event) deserializeJSON(new Event(), createReader(createURL(Constants.BLUE_ALLIANCE_EVENT_DETAILS + eventKey)));
    }
    
    /**
     * Get extremely detailed event information for an event
     *
     * @param eventKey The BlueAlliance event key
     * @return Returns an Event object
     * @throws IOException Throws IOException on connection/reader errors
     */
    public List<Match> getMatchList(String eventKey) throws IOException {
        //return deserializeJSON(new Event(), createReader(createURL(Constants.BLUE_ALLIANCE_EVENT_DETAILS + eventKey + "/matches"))).;
    
        return (List<Match>) (List<?>) deserializeJSONArray(new TypeToken<List<Match>>() {
        }.getType(),
                createReader(createURL(Constants.BLUE_ALLIANCE_EVENT_DETAILS + eventKey + "/matches")));
    }

    /**
     * Get extensive match details for a specific BlueAlliance match key, ex. "2013micmp_qm117",
     * Contains info such as score and alliances
     *
     * @param matchKey The match key of the single match you want to query
     * @return Returns a Match object with the information
     * @throws IOException Throws IOException on connection/reader errors
     */
    public Match getMatchDetails(String matchKey) throws IOException {
        return getMatchDetails(new String[]{matchKey}).get(0);
    }

    /**
     * Get extensive match details for multiple BlueAlliance match keys, ex. "2013micmp_qm117",
     * Contains info such as score and alliances
     *
     * @param matchKeys The match keys of the matches you want to query
     * @return Returns a List of Match objects with the information
     * @throws IOException Throws IOException on connection/reader errors
     */
    public List<Match> getMatchDetails(String[] matchKeys) throws IOException {
        @SuppressWarnings("unchecked")
        List<Match> list = (List<Match>) (List<?>) deserializeJSONArray(new TypeToken<List<Match>>() {
        }.getType(),
                createReader(createURL(Constants.BLUE_ALLIANCE_MATCH_DETAILS + Arrays.toString(matchKeys).replace("[", "").replace("]", "").replace(" ", ""))));
        return list;
    }

    /**
     * Generically deserializes JSON data into a class
     *
     * @param blueAllianceObject A specific, instantiated BlueAllianceObject, for example like TeamDetails
     * @param reader             A reader that is open to JSON data, use createReader to create a reader
     * @return Returns a generic BlueAllianceObject that can be casted to the specific object you originally wanted
     */
    private BlueAllianceObject deserializeJSON(BlueAllianceObject blueAllianceObject, Reader reader) {
        Gson gson = new Gson();

        return gson.fromJson(reader, blueAllianceObject.getClass());
    }

    /**
     * Deserializes a JSON array of JSON objects from BlueAlliance and returns a List with each element being a Java respresentation of the JSON Object
     *
     * @param type   The type of List to create, (TypeToken)
     * @param reader A reader that is open to JSON data, use createReader to create a reader
     * @return Returns a generic List of BlueAllianceObjects which must be casted to the specific type you want
     */
    private List<BlueAllianceObject> deserializeJSONArray(Type type, Reader reader) {
        Gson gson = new Gson();

        Type listType = type;

        return gson.fromJson(reader, listType);
    }


    /**
     * Creates a reader pointing to JSON data
     *
     * @param url A full BlueAlliance pointing to JSON data, create one with createURL(String append)
     * @return Returns a InputStreamReader typed as a generic Reader
     * @throws IOException throws IOException on connection/reader errors
     */
    private Reader createReader(String url) throws IOException {
        HttpURLConnection urlConnection = (HttpURLConnection) (new URL(url).openConnection());
        urlConnection.addRequestProperty("User-Agent", "Mozilla/4.76");
        urlConnection.addRequestProperty("X-TBA-App-Id", "frc2834:java-blue-alliance-api:v1.0.2");
        return new InputStreamReader(urlConnection.getInputStream());
    }

    /**
     * Creates a full URL to a BlueAlliance page containing JSON data
     *
     * @param append Additional text to append to Constants.BLUE_ALLIANCE_BASE_URL_V1, which is the base URL with a forward slash on the end
     * @return Returns a complete BlueAlliance URL that points to a JSON information
     */
    private String createURL(String append) {
        return Constants.BLUE_ALLIANCE_BASE_URL_V1 + append + "?X-TBA-App-Id=2607:scoutingsystem:1";
    }

}
