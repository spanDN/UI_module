package com.example.delle5540.ui_module.model;

/**
 * Created by dell e5540 on 3/11/2018.
 */

public class Topic {
    private String name;
    private String description;

    // topics is array of topic
    public static final Topic[] topics = {
            new Topic("Activities", "GUI abstraction to display info"),
            new Topic("Activity lifecycle", "Methods where actually things performed"),
            new Topic("Fragments", "More modular GUI element"),
            new Topic("MVVP", "Interaction beetwen components/model/view"),
            new Topic("List view and Adapters",  "Display list of elements")
    };

    private Topic (String name, String description) {
        this.name = name;
        this.description = description;
    }

    @Override
    public String toString() {
        return "Topic{" +
                "name='" + name + '\'' +
                ", description='" + description + '\'' +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
