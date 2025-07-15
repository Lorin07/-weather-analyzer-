package weatheranalyzer.reporting

import java.io.PrintWriter
import java.time.LocalDate
import weatheranalyzer.model._

object Visualizer {
  def exportAverages(path: String, data: Map[(String, LocalDate), Double]): Unit = {
    val writer = new PrintWriter(path)
    writer.println("station_id,date,avg_temp")
    data.foreach { case ((station, date), avg) =>
      writer.println(s"$station,$date,$avg")
    }
    writer.close()
  }

  def showTemperatureAlerts(observations: List[WeatherObservation]): Unit = {
    val alerts = observations.filter(o => o.temperature > 40 || o.humidity > 90)
    println("🚨 ALERTES METEO :")
    alerts.take(10).foreach(println)
  }
}
