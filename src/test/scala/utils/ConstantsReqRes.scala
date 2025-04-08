package utils

import io.gatling.core.Predef._
import io.gatling.http.Predef._

object ConstantsReqRes {
  val TIMEOUT: Int = 5000
  val REQRES_BASE_URL: String = "https://reqres.in/"
  val HEADER_AGENT: String = "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome"
  val REQRES_HEADERS: Map[String, String] = Map(
    "sec-ch-ua" -> """Google Chrome";v="135", "Not-A.Brand";v="8", "Chromium";v="135"""",
    "sec-ch-ua-mobile" -> "?0",
    "sec-ch-ua-platform" -> "Windows"
  )
  val HTTP_PROTOCOLS = http
    .baseUrl(REQRES_BASE_URL)
    .inferHtmlResources()
    .contentTypeHeader("application/json")
    .userAgentHeader(HEADER_AGENT)
  val REQRES_ENDPOINTS: Map[String, String] = Map(
    "users" -> "api/users",
    "unknown" -> "api/unknown"
  )
  val USERS_VALIDATION: Map[String, String] = Map(
    "userName" -> "Janet",
  )
}

