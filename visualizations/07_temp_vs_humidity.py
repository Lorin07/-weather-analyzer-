import pandas as pd
import seaborn as sns
df = pd.read_csv("data/raw/weather_observations.csv")
sns.jointplot(x="temperature", y="humidity", data=df, kind="hex", cmap="viridis")
plt.suptitle("Corrélation température / humidité", y=1.02)
plt.show()
