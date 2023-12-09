package bg.softuni.pathfinder.model.dto;

import bg.softuni.pathfinder.model.Category;
import bg.softuni.pathfinder.model.CategoryEnum;
import bg.softuni.pathfinder.model.Level;

import java.util.Set;

public class AddRouteBindingModel {

    private String name;
    private String description;
//    private String gpxCoordinates;

    private Level level;

    private String videoUrl;
    private Set<CategoryEnum> categories;


    public String getName() {
        return name;
    }

    public AddRouteBindingModel setName(String name) {
        this.name = name;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public AddRouteBindingModel setDescription(String description) {
        this.description = description;
        return this;
    }



    public Level getLevel() {
        return level;
    }

    public AddRouteBindingModel setLevel(Level level) {
        this.level = level;
        return this;
    }

    public String getVideoUrl() {
        return videoUrl;
    }

    public AddRouteBindingModel setVideoUrl(String videoUrl) {
        this.videoUrl = videoUrl;
        return this;
    }

    public Set<CategoryEnum> getCategories() {
        return categories;
    }

    public AddRouteBindingModel setCategories(Set<CategoryEnum> categories) {
        this.categories = categories;
        return this;
    }


//    public String getGpxCoordinates() {
//        return gpxCoordinates;
//    }
//
//    public AddRouteBindingModel setGpxCoordinates(String gpxCoordinates) {
//        this.gpxCoordinates = gpxCoordinates;
////        return this;
//    }
}
