package com.furkanyavuz.springfu;

import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

public class SampleHandler {

	private SampleService sampleService;

	public SampleHandler(SampleService sampleService) {
		this.sampleService = sampleService;
	}

	public Mono<ServerResponse> hello(ServerRequest request) {
		return ServerResponse.ok().syncBody(this.sampleService.generateMessage());
	}
}
