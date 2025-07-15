package weatheranalyzer.ml

import weatheranalyzer.model.WeatherObservation

object LinearRegressor {

  case class Coefficients(a: Double, b: Double, c: Double, d: Double)
  val defaultCoefficients = Coefficients(-0.1, 0.2, -0.3, 30)

  def predict(obs: WeatherObservation, coeffs: Coefficients = defaultCoefficients): Double = {
    coeffs.a * obs.humidity + coeffs.b * obs.windSpeed + coeffs.c * obs.precipitation + coeffs.d
  }

  def predictAll(data: List[WeatherObservation], coeffs: Coefficients = defaultCoefficients): List[Double] = {
    data.map(obs => predict(obs, coeffs))
  }
}
