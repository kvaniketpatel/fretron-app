import matplotlib.pyplot as plt


flight_paths = {
    'Flight 1': [(1,1), (2,2), (3,3)],
    'Flight 2': [(1,1), (2,4), (3,2)],
    'Flight 3': [(1,1), (4,2), (3,4)]
}


for flight, path in flight_paths.items():
x, y = zip(*path)
plt.plot(x, y, marker='o', label=flight)
plt.xlabel('X Coordinate')
plt.ylabel('Y Coordinate')
plt.title('Flight Paths')
plt.legend()
plt.grid(True)
plt.show()