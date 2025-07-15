import pandas as pd
import matplotlib.pyplot as plt
df = pd.read_csv("data/generated/average_temperature.csv")
avg = df.groupby("station_id")["avg_temp"].mean().sort_values()
plt.figure(figsize=(10,6))
avg.plot(kind='barh')
plt.title("Température moyenne par station")
plt.xlabel("Température (°C)")
plt.tight_layout()
plt.show()
