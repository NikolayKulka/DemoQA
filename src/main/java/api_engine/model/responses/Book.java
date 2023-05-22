package api_engine.model.responses;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;


@JsonIgnoreProperties(ignoreUnknown = true)
public class Book {
    @JsonProperty("isbn")
    public String isbn;
    @JsonProperty("title")
    public String title;
    @JsonProperty("subTitle")
    public String subTitle;
    @JsonProperty("author")
    public String author;
    @JsonProperty("publish_date")
    public String publish_date;
    @JsonProperty("publisher")
    public String publisher;
    @JsonProperty("pages")
    public int pages;
    @JsonProperty("description")
    public String description;
    @JsonProperty("website")
    public String website;
}
