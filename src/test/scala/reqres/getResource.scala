package reqres

import utils.ConstantsReqRes
import io.gatling.core.Predef._
import io.gatling.http.Predef._

class getResource extends Simulation {

  val resourceEndPoint: String = ConstantsReqRes.REQRES_ENDPOINTS("unknown");
  val headers = ConstantsReqRes.REQRES_HEADERS;

  val scn = scenario("USERS_VALIDATION")
    .exec(http("Request Resource List")
      .get(resourceEndPoint)
      .headers(headers)
      .check(status.is(200)))
    .pause(1)
    .exec(http("Request Resource Single")
      .get(resourceEndPoint + "/2")
      .headers(headers)
      .check(status.is(200)))
    .pause(1)
    .exec(http("Get Resource 23 - Not Found")
      .get(resourceEndPoint + "/23")
      .headers(headers)
      .check(status.is(404)))
    .pause(1)
  setUp(scn.inject(atOnceUsers(1))).protocols(ConstantsReqRes.HTTP_PROTOCOLS)
}