package com.example.easynotes;

import com.example.easynotes.consts.Constants;
import com.example.easynotes.controller.GameController;
import com.example.easynotes.converters.StringToPlatformConverter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.format.FormatterRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

@SpringBootApplication
@EnableConfigurationProperties
public class EasyNotesApplication extends WebMvcConfigurationSupport {

	public void addViewControllers(ViewControllerRegistry registry) {
		registry.addViewController("/game/add").setViewName(Constants.ADD_EDIT_GAMES_URL);
		registry.addViewController("/game/edit").setViewName(Constants.ADD_EDIT_GAMES_URL);
		registry.addViewController("/").setViewName(Constants.VIEW_GAMES_URL);
		registry.addViewController("/user/register").setViewName("register.html");
		registry.addViewController("/login").setViewName("login.html");
	}

	@Override
	public void addFormatters(FormatterRegistry registry) {
		registry.addConverter(new StringToPlatformConverter());
	}
	
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("/**").addResourceLocations("/resources/uploads");
	}

	public static void main(String[] args) {
		SpringApplication.run(EasyNotesApplication.class, args);
	}
}
