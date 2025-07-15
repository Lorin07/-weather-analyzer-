import pandas as pd
import matplotlib.pyplot as plt
df = pd.read_csv("data/generated/average_temperature.csv")
df = df[df['station_id'] == 'ST001']
df['date'] = pd.to_datetime(df['date'])
plt.plot(df['date'], df['avg_temp'])
plt.title("Évolution de la température moyenne - ST001")
plt.xlabel("Date")
plt.ylabel("Température (°C)")
plt.grid(True)
plt.tight_layout()
plt.show()
