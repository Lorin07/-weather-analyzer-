import pandas as pd
import matplotlib.pyplot as plt
from matplotlib.animation import FuncAnimation

df = pd.read_csv("data/generated/average_temperature.csv")
df['date'] = pd.to_datetime(df['date'])
stations = df['station_id'].unique()
dates = sorted(df['date'].unique())

fig, ax = plt.subplots(figsize=(10, 6))
bars = ax.bar(stations, [0]*len(stations))

def update(frame):
    current_date = dates[frame]
    daily_data = df[df['date'] == current_date]
    avg_temps = [daily_data[daily_data['station_id'] == s]['avg_temp'].mean() for s in stations]
    for bar, height in zip(bars, avg_temps):
        bar.set_height(height)
    ax.set_title(f"Température moyenne par station - {current_date.date()}")

ani = FuncAnimation(fig, update, frames=len(dates), interval=300, repeat=False)
plt.xlabel("Station ID")
plt.ylabel("Température (°C)")
plt.tight_layout()
plt.show()
