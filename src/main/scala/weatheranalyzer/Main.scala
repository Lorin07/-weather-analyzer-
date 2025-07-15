package weatheranalyzer

import weatheranalyzer.model._
import weatheranalyzer.utils.FileLoader
import weatheranalyzer.processing._
import weatheranalyzer.reporting._

object Main {
  def main(args: Array[String]): Unit = {
    println("=== Weather Analyzer ===")

    val stations = FileLoader.loadStations("data/raw/station_data.csv")
    val observations = FileLoader.loadObservations("data/raw/weather_observations.csv")

    val cleanObs = Cleaning.clean(observations)

    println(s"�� Nombre d'observations brutes : ${observations.size}")
    println(s"✅ Nombre d'observations nettoyées : ${cleanObs.size}")

    Visualizer.showTemperatureAlerts(cleanObs)

    val avgPerDay = Aggregation.averageTemperaturePerDay(cleanObs)
    Visualizer.exportAverages("data/generated/average_temperature.csv", avgPerDay)

    println("📄 Fichier CSV exporté : data/generated/average_temperature.csv")
  }
}
