import csv
import random
from datetime import datetime, timedelta
import os

# Création du dossier si nécessaire
os.makedirs("data/raw", exist_ok=True)

# Génération station_data.csv
station_file = "data/raw/station_data.csv"
stations = []

with open(station_file, "w", newline="") as f:
    writer = csv.writer(f)
    writer.writerow(["station_id", "station_name", "latitude", "longitude", "altitude"])
    for i in range(1, 101):
        station_id = f"ST{i:03}"
        name = f"Station_{i}"
        lat = round(random.uniform(-60, 60), 5)
        lon = round(random.uniform(-180, 180), 5)
        alt = round(random.uniform(0, 4000), 1)
        stations.append((station_id, name, lat, lon, alt))
        writer.writerow([station_id, name, lat, lon, alt])

# Génération weather_observations.csv
obs_file = "data/raw/weather_observations.csv"
start_date = datetime(2024, 1, 1, 0, 0, 0)

with open(obs_file, "w", newline="") as f:
    writer = csv.writer(f)
    writer.writerow(["station_id", "date", "temperature", "humidity", "wind_speed", "precipitation"])
    
    for i in range(0, 100000):  # 100k lignes aléatoires
        date = start_date + timedelta(minutes=30 * i)
        station = random.choice(stations)
        temperature = round(random.gauss(15, 10), 2)  # temp réaliste
        humidity = random.randint(20, 100)
        wind = round(random.uniform(0, 30), 2)
        precip = round(random.expovariate(0.4), 2) if random.random() < 0.3 else 0.0
        writer.writerow([
            station[0],
            date.strftime("%Y-%m-%d %H:%M:%S"),
            temperature,
            humidity,
            wind,
            precip
        ])
