package ua.skidchenko.BusinessLayer.ScheduleClasses;

import com.google.gson.Gson;
import ua.skidchenko.Model.LessonsForSchedule.LessonsDTO.LessonsDTO;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.charset.StandardCharsets;

@Component
public class ScheduleJSONFromNetRetrieverImpl implements ScheduleJSONFromNetRetriever {

    private final Gson gson;
    private URL url;
    private String groupName;

    public ScheduleJSONFromNetRetrieverImpl(Environment environment) {
        this.gson = new Gson();
        this.groupName = environment.getProperty("schedule.url.group");
        try {
            this.url = new URL(
                    "https://api.rozklad.org.ua/v2/groups/" + groupName + "/lessons");
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }

    }

    public LessonsDTO getLessonsFromJsonFromNet() {
        LessonsDTO lessonsDTO = gson.fromJson(getJsonStringForParsing(), LessonsDTO.class);
        lessonsDTO.setGroupName(groupName);
        return lessonsDTO;
    }

    private String getJsonStringForParsing() {
        StringBuilder builder = new StringBuilder();
        try (InputStreamReader inputStreamReader = new InputStreamReader(url.openStream(), StandardCharsets.UTF_8)) {
            int co;
            while ((co = inputStreamReader.read()) != -1) {
                builder.append((char) co);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return builder.toString();
    }

    public URL getUrl() {
        return url;
    }
}
