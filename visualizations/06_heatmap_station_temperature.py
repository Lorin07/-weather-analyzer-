import pandas as pd
import seaborn as sns
import matplotlib.pyplot as plt
df = pd.read_csv("data/generated/average_temperature.csv")
pivot = df.pivot_table(index="station_id", columns="date", values="avg_temp")
plt.figure(figsize=(14,10))
sns.heatmap(pivot, cmap="coolwarm", cbar_kws={"label": "Température (°C)"})
plt.title("Carte thermique des températures moyennes par station")
plt.tight_layout()
plt.show()
