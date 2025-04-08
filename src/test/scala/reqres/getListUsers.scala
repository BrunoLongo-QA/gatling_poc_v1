package reqres

import utils.ConstantsReqRes
import io.gatling.core.Predef._
import io.gatling.http.Predef._

class getListUsers extends Simulation {

	val userName: String = ConstantsReqRes.USERS_VALIDATION("userName");
	val userEndPoint: String = ConstantsReqRes.REQRES_ENDPOINTS("users");
	val headers = ConstantsReqRes.REQRES_HEADERS;

	val scn = scenario("USERS_VALIDATION")
		.exec(http("Get List Users for page 2")
			.get(userEndPoint + "?page=2")
			.headers(headers)
			.check(status.is(200)))
		.pause(1)
		.exec(http("Get User Singlegit")
			.get(userEndPoint+ "/2")
			.headers(headers)
			.check(status.is(200),substring(userName).exists))
		.pause(1)
		.exec(http("Get User 23 - Not Found")
			.get(userEndPoint + "/23")
			.headers(headers)
			.check(status.is(404)))
	setUp(scn.inject(atOnceUsers(1))).protocols(ConstantsReqRes.HTTP_PROTOCOLS)
}