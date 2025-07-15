import pandas as pd
import matplotlib.pyplot as plt
from scipy.stats import zscore
df = pd.read_csv("data/generated/average_temperature.csv")
df['z'] = zscore(df['avg_temp'])
anomalies = df[df['z'].abs() > 3]
plt.scatter(df['date'], df['avg_temp'], s=10, label='Normal')
plt.scatter(anomalies['date'], anomalies['avg_temp'], color='red', label='Anomalies')
plt.legend()
plt.title("Détection de températures anormales (z-score)")
plt.xticks(rotation=45)
plt.tight_layout()
plt.show()
