import pandas as pd
import matplotlib.pyplot as plt

df = pd.read_csv("data/generated/average_temperature.csv")
df['date'] = pd.to_datetime(df['date'])

# Exemple : station ST001
subset = df[df['station_id'] == 'ST001']

plt.figure(figsize=(10,5))
plt.plot(subset['date'], subset['avg_temp'], label='Température Moyenne')
plt.title("Température moyenne quotidienne - ST001")
plt.xlabel("Date")
plt.ylabel("Température (°C)")
plt.legend()
plt.grid(True)
plt.tight_layout()
plt.show()
