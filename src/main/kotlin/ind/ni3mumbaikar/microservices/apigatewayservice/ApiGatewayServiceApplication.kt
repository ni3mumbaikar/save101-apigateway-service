package ind.ni3mumbaikar.microservices.apigatewayservice

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.cloud.gateway.route.RouteLocator
import org.springframework.cloud.gateway.route.builder.PredicateSpec
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder
import org.springframework.context.annotation.Bean


@SpringBootApplication
class ApiGatewayServiceApplication

fun main(args: Array<String>) {
    runApplication<ApiGatewayServiceApplication>(*args)
}

@Bean
fun customRouteLocator(builder: RouteLocatorBuilder): RouteLocator? {
    return builder.routes()
        .route(
            "path_route"
        ) { r: PredicateSpec ->
            r.path("/get")
                .uri("http://httpbin.org")
        }
        .build()
}
