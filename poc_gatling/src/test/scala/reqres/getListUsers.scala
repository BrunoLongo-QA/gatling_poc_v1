package reqres

import utils.Constants
import io.gatling.core.Predef._
import io.gatling.http.Predef._
import scala.collection.JavaConverters.mapAsScalaMapConverter

class getListUsers extends Simulation {

	val httpProtocol = http
		.baseUrl(Constants.REQRES_BASE_URL)
		.inferHtmlResources()
		.contentTypeHeader("application/json")
		.userAgentHeader("Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/135.0.0.0 Safari/537.36")

	val headers: Map[String, String] = Constants.REQRES_HEADERS.asScala.toMap

	val scn = scenario("getListUsers")
		.exec(http("request_0")
			.get("/api/users?page=2")
			.headers(headers))
		.pause(1)
		.exec(http("request_1")
			.get("/api/users/2")
			.headers(headers))
		.pause(1)
		.exec(http("request_2")
			.get("/api/users/23")
			.headers(headers)
			.check(status.is(404)))
		.pause(1)
		.exec(http("request_3")
			.get("/api/unknown")
			.headers(headers))

	setUp(scn.inject(atOnceUsers(1))).protocols(httpProtocol)
}