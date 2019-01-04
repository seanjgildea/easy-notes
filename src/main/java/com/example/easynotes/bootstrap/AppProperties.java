package com.example.easynotes.bootstrap;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
@ConfigurationProperties("app") // prefix app, find app.* values
public class AppProperties {

    private String error;
    private List<Menu> menus = new ArrayList<>();

    public static class Menu {

        private String name;
        private String path;
        private String title;

        @Override
        public String toString() {
            return "Menu{" +
                    "name='" + name + '\'' +
                    ", path='" + path + '\'' +
                    ", title='" + title + '\'' +
                    '}';
        }
    }
}