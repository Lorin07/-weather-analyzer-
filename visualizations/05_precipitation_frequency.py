import pandas as pd
import matplotlib.pyplot as plt
df = pd.read_csv("data/raw/weather_observations.csv")
df['precipitation_binary'] = df['precipitation'].apply(lambda x: 1 if x > 0 else 0)
plt.figure(figsize=(6,6))
df['precipitation_binary'].value_counts().plot(kind='bar')
plt.xticks([0,1], ['Sans pluie', 'Avec pluie'], rotation=0)
plt.title("Nombre d'observations avec/sans pluie")
plt.tight_layout()
plt.show()
