package com.furkanyavuz.springfu;

import static org.springframework.boot.jafu.Jafu.application;

import org.springframework.boot.SpringApplication;
import org.springframework.core.io.ClassPathResource;

public class DemoApplication
{

	public static SpringApplication app = application(app -> {
		app.beans(beans -> {
			beans.bean(SampleService.class);
			beans.bean(SampleHandler.class);
		});
		app.server(server -> server.router(router -> {
			SampleHandler sampleHandler = app.ref(SampleHandler.class);
			router.GET("/", sampleHandler::hello);
			router.resources("/**", new ClassPathResource("static/"));
		}));
	});

	public static void main (String[] args) {
		app.run(args);
	}

}
