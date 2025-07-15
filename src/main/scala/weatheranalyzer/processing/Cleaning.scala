package weatheranalyzer.processing

import weatheranalyzer.model.WeatherObservation

object Cleaning {
  def clean(observations: List[WeatherObservation]): List[WeatherObservation] = {
    observations.filter(obs =>
      obs.temperature >= -50 && obs.temperature <= 60 &&
      obs.humidity >= 0 && obs.humidity <= 100 &&
      obs.windSpeed >= 0 &&
      obs.precipitation >= 0
    )
  }
}
