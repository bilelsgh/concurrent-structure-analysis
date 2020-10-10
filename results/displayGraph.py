import matplotlib.pyplot as plt
import random


##CURVES##
#Read values
myFile = open("values.txt", "r")
x_values = ( myFile.read() ).split('\n')
x_values = x_values[:len(x_values)-1]
x_values = [float(i) for i in x_values]

plt.grid(True)

"""
#Titles
plt.title("Time to do x computations according a gaussian distribution of the indexes")
plt.xlabel("Number of threads")
plt.ylabel("Time (second)")

#Plots ([xi]; [yi])
plt.plot(x_values, label="First attempt")
plt.plot(x_values, [1,-6,10,-9,11,0,15], label="Second attempt")

#bounds of the axis: [xmin, xmax, ymin, ymax]
plt.axis([min(x_values)-1, max(x_values)+1, -10, 25])

plt.legend()
plt.show()

"""

##HISTOGRAM##

# 1000 tirages entre 0 et 150
x = [random.randint(0,150) for i in range(1000)]
n, bins, patches = plt.hist(x_values, 50, normed=1, facecolor='b', alpha=0.5)

plt.xlabel('Mise')
plt.ylabel('Probabilite')
plt.axis([0, 21, 0, 1])
plt.show()



myFile.close()
