package weatheranalyzer.ml

import org.scalatest.funsuite.AnyFunSuite
import weatheranalyzer.model.WeatherObservation
import java.time.LocalDateTime

class TemperaturePredictorTest extends AnyFunSuite {

  val sample = WeatherObservation("001", LocalDateTime.now(), 20.0, 50, 5, 0.0)

  test("estimateTemperature returns correct value") {
    val estimated = TemperaturePredictor.estimateTemperature(sample)
    assert(Math.abs(estimated - 26.0) < 0.01)
  }

  test("classify returns true if above threshold") {
    assert(TemperaturePredictor.classify(sample, 24.0) === true)
  }

  test("classifyAll returns list of same length") {
    val list = List.fill(10)(sample)
    assert(TemperaturePredictor.classifyAll(list).length == 10)
  }
}
