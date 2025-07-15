package weatheranalyzer.ml

import weatheranalyzer.model.WeatherObservation
import java.io.{File, PrintWriter}
import java.time.format.DateTimeFormatter

object PredictionExporter {

  val dateFormatter: DateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm")

  def exportToCSV(data: List[(WeatherObservation, Boolean)], outputPath: String): Unit = {
    val file = new PrintWriter(new File(outputPath))
    file.println("station_id,date,temp,humidity,wind_speed,precipitation,is_hot")
    data.foreach { case (obs, isHot) =>
      file.println(
        s"${obs.stationId},${obs.date.format(dateFormatter)},${obs.temperature}," +
        s"${obs.humidity},${obs.windSpeed},${obs.precipitation},${if (isHot) 1 else 0}"
      )
    }
    file.close()
  }
}
