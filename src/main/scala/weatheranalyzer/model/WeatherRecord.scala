package weatheranalyzer.model

import java.time.LocalDateTime

final case class Station(
  stationId: String,
  name: String,
  latitude: Double,
  longitude: Double,
  altitude: Double
)

final case class WeatherObservation(
  stationId: String,
  date: LocalDateTime,
  temperature: Double,
  humidity: Int,
  windSpeed: Double,
  precipitation: Double
)
