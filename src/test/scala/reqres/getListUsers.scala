package reqres

import utils.ConstantsReqRes
import io.gatling.core.Predef._
import io.gatling.core.structure.ScenarioBuilder
import io.gatling.http.Predef._

class getListUsers extends Simulation {

	val userName: String = ConstantsReqRes.USERS_VALIDATION("userName");
	val userEndPoint: String = ConstantsReqRes.REQRES_ENDPOINTS("users");
	val headers: Map[String, String] = ConstantsReqRes.REQRES_HEADERS;
	val userListResponse: String = ConstantsReqRes.USERS_VALIDATION("userListResponse");

	val scn: ScenarioBuilder = scenario("USERS_VALIDATION")
		.exec(http("Get List Users for page 2")
			.get(userEndPoint + "?page=2")
			.headers(headers)
			.check(status.is(200),
				bodyString.saveAs("userListResponse"),
			))
		.exec { session =>
			println("Response Body: " + session("userListResponse").as[String])
			session
		}
		.pause(1)
		.exec(http("Get User Single")
			.get(userEndPoint+ "/2")
			.headers(headers)
			.check(status.is(200),
				bodyString.saveAs("userListResponse"),
//				substring(userName).exists),
			))
		.exec { session =>
			val parsed = parse(rawJson) match {
				case Right(json) =>
					// Aqui o JSON já está como estrutura manipulável
					val cursor = json.hcursor
					val firstUserId = cursor.downField("data").downArray.downField("id").as[Int].getOrElse(-1)
					println(s"ID do primeiro usuário: $firstUserId")

				case Left(error) =>
					println(s"Erro ao parsear JSON: $error")
			}
			println("Response Body: " + session("userListResponse").as[String])
			session
		}
		.pause(1)
		.exec(http("Get User 23 - Not Found")
			.get(userEndPoint + "/23")
			.headers(headers)
			.check(status.is(404)))
	setUp(scn.inject(atOnceUsers(1))).protocols(ConstantsReqRes.HTTP_PROTOCOLS)
}