package weatheranalyzer

import weatheranalyzer.model._
import weatheranalyzer.utils.FileLoader
import weatheranalyzer.processing._
import weatheranalyzer.reporting._
import weatheranalyzer.ml.{TemperaturePredictor, PredictionExporter, LinearRegressor}

object Main {
  def main(args: Array[String]): Unit = {
    println("=== Weather Analyzer ===")

    // Chargement des données
    val stations = FileLoader.loadStations("data/raw/station_data.csv")
    val observations = FileLoader.loadObservations("data/raw/weather_observations.csv")

    // Nettoyage
    val cleanedData = Cleaning.clean(observations)
    println(s"🔢 Nombre d'observations brutes : ${observations.size}")
    println(s"✅ Nombre d'observations nettoyées : ${cleanedData.size}")

    // Alertes visuelles (console)
    Visualizer.showTemperatureAlerts(cleanedData)

    // Agrégation
    val avgPerDay = Aggregation.averageTemperaturePerDay(cleanedData)
    Visualizer.exportAverages("data/generated/average_temperature.csv", avgPerDay)
    println("📄 Fichier CSV exporté : data/generated/average_temperature.csv")

    // Prédictions chaud/froid
    val classified = TemperaturePredictor.classifyAll(cleanedData)
    PredictionExporter.exportToCSV(classified, "data/generated/predictions.csv")
    println("📄 Prédictions exportées : data/generated/predictions.csv")

    // Régression linéaire simple
    val preds = LinearRegressor.predictAll(cleanedData)
    println("Exemples de prédictions linéaires :")
    preds.take(5).foreach(println)
  }
}
