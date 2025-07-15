import pandas as pd
import seaborn as sns
import matplotlib.pyplot as plt
df = pd.read_csv("data/raw/weather_observations.csv")
sns.histplot(df['humidity'], kde=True, color="skyblue")
plt.title("Distribution de l'humidité")
plt.xlabel("Humidité (%)")
plt.tight_layout()
plt.show()
