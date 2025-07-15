import pandas as pd
from sklearn.cluster import KMeans
import matplotlib.pyplot as plt
df = pd.read_csv("data/generated/average_temperature.csv")
grouped = df.groupby("station_id")["avg_temp"].mean().reset_index()
X = grouped["avg_temp"].values.reshape(-1,1)
kmeans = KMeans(n_clusters=3, random_state=42).fit(X)
grouped["cluster"] = kmeans.labels_
plt.scatter(grouped.index, grouped["avg_temp"], c=grouped["cluster"], cmap="Accent")
plt.title("Clustering des stations météo selon température moyenne")
plt.xlabel("Station")
plt.ylabel("Température")
plt.tight_layout()
plt.show()
