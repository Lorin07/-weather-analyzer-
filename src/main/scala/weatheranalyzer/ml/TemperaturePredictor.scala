package weatheranalyzer.ml

import weatheranalyzer.model.WeatherObservation

object TemperaturePredictor {

  def classify(obs: WeatherObservation, threshold: Double = 25.0): Boolean = {
    val score = estimateTemperature(obs)
    score >= threshold
  }

  def estimateTemperature(obs: WeatherObservation): Double = {
    30 - 0.1 * obs.humidity + 0.2 * obs.windSpeed - 0.3 * obs.precipitation
  }

  def classifyAll(data: List[WeatherObservation], threshold: Double = 25.0): List[(WeatherObservation, Boolean)] = {
    data.map(obs => (obs, classify(obs, threshold)))
  }
}
