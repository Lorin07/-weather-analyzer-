package weatheranalyzer.utils

import weatheranalyzer.model._

import kantan.csv._
import kantan.csv.ops._
import kantan.csv.generic._

import java.io.File
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

object FileLoader {
  private val dateFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")

  def loadStations(path: String): List[Station] = {
    new File(path)
      .asCsvReader[Station](rfc.withHeader)
      .collect { case Right(s) => s }
      .toList
  }

  def loadObservations(path: String): List[WeatherObservation] = {
    implicit val decoder: RowDecoder[WeatherObservation] =
      RowDecoder.ordered {
        (stationId: String,
         dateStr: String,
         temperature: Double,
         humidity: Int,
         windSpeed: Double,
         precipitation: Double) =>
          WeatherObservation(
            stationId,
            LocalDateTime.parse(dateStr, dateFormatter),
            temperature,
            humidity,
            windSpeed,
            precipitation
          )
      }

    new File(path)
      .asCsvReader[WeatherObservation](rfc.withHeader)
      .collect { case Right(obs) => obs }
      .toList
  }
}
