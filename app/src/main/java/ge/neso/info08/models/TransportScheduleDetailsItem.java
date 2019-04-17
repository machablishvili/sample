package ge.neso.info08.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class TransportScheduleDetailsItem {

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class Schedule {

        private Integer id;

        private String name;

        public Integer getId() {
            return id;
        }

        public void setId(Integer id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class Shape {

        private String lat;

        private String lon;

        public String getLat() {
            return lat;
        }

        public void setLat(String lat) {
            this.lat = lat;
        }

        public String getLon() {
            return lon;
        }

        public void setLon(String lon) {
            this.lon = lon;
        }

    }


    private List<Schedule> schedule;

    private List<Shape> shape;

    public List<Schedule> getSchedule() {
        return schedule;
    }

    public void setSchedule(List<Schedule> schedule) {
        this.schedule = schedule;
    }

    public List<Shape> getShape() {
        return shape;
    }

    public void setShape(List<Shape> shape) {
        this.shape = shape;
    }


    public static String fromJson(TransportScheduleDetailsItem item) {

        ObjectMapper mapper = new ObjectMapper();

        try {
            return mapper.writeValueAsString(item);
        } catch (JsonProcessingException e) {
            return null;
        }
    }

    public static TransportScheduleDetailsItem toJson(String jsonStr) {

        ObjectMapper mapper = new ObjectMapper();

        try {
            TransportScheduleDetailsItem item = mapper.readValue(jsonStr, TransportScheduleDetailsItem.class);
            return item;
        } catch (Exception e) {
            return null;
        }

    }
}
