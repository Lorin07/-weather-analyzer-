import pandas as pd
import matplotlib.pyplot as plt

df = pd.read_csv("../data/generated/predictions.csv")

plt.figure(figsize=(10,6))
colors = df['is_hot'].map({0: "blue", 1: "red"})
plt.scatter(df['temp'], df['humidity'], c=colors, alpha=0.6)
plt.xlabel("Température réelle (°C)")
plt.ylabel("Humidité (%)")
plt.title("Classification des températures chaudes (rouge) / froides (bleu)")
plt.grid(True)
plt.tight_layout()
plt.show()
