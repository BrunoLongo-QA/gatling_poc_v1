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
			.check(
				status.is(200),
				bodyString.saveAs("resourceListResponse"),
				jsonPath("$.data[0].id").saveAs("singleUserID"),
				jsonPath("$.data[0].first_name").saveAs("singleUserName")
			)
		)
		.exec(
			session => {
				println("User ID: " + session("singleUserID").as[String])
				println("User Name: " + session("singleUserName").as[String])
				session
			}
		)
		.pause(1)
		.exec(http("Get User Single")
			.get(userEndPoint + "/${singleUserID}")
			.headers(headers)
			.check(status.is(200),
				jsonPath("$.data.first_name").saveAs("getSingleUserName"),
			)
		)
		.exec(
			session => {
				val expectedName = session("singleUserName").as[String]
				val returnedName = session("getSingleUserName").as[String]

				if (expectedName == returnedName) {
					println(s"✅ Name matches: $expectedName")
				} else {
					throw new Error(s"❌ Name mismatch: expected=$expectedName, returned=$returnedName")
				}
				session
					.set("expectedName", expectedName)
					.set("returnedName", returnedName)
			}
		)
		.pause(1)
		.exec(http("Get User 23 - Not Found")
			.get(userEndPoint + "/23")
			.headers(headers)
			.check(
				status.is(404)
			)
		)
		.pause(1)
		.exec(http("Get User Single Using Constants")
			.get(userEndPoint + "/2")
			.headers(headers)
			.check(status.is(200),
				substring(userName).exists,
			)
		)
		.pause(1)
		.exec(
			session => {
				println("✅ Using variables saved in the session Expected: " + session("expectedName").as[String])
				println("✅ Using variables saved in the session Returned: " + session("returnedName").as[String])
				session
			}
		)
	setUp(scn.inject(atOnceUsers(1))).protocols(ConstantsReqRes.HTTP_PROTOCOLS)
}