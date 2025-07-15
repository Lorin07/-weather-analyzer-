import pandas as pd
import seaborn as sns
import matplotlib.pyplot as plt
df = pd.read_csv("data/generated/average_temperature.csv")
sns.histplot(df['avg_temp'], kde=True, bins=30)
plt.title("Distribution des températures moyennes")
plt.xlabel("Température (°C)")
plt.tight_layout()
plt.show()
