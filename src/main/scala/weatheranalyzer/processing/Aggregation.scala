package weatheranalyzer.processing

import weatheranalyzer.model._
import java.time.LocalDate

object Aggregation {
  def averageTemperaturePerDay(observations: List[WeatherObservation]): Map[(String, LocalDate), Double] = {
    observations
      .groupBy(obs => (obs.stationId, obs.date.toLocalDate))
      .mapValues(list => list.map(_.temperature).sum / list.size)
      .toMap
  }

  def minMaxTemperaturePerDay(observations: List[WeatherObservation]): Map[(String, LocalDate), (Double, Double)] = {
    observations
      .groupBy(obs => (obs.stationId, obs.date.toLocalDate))
      .mapValues(list => (list.map(_.temperature).min, list.map(_.temperature).max))
      .toMap
  }
}
