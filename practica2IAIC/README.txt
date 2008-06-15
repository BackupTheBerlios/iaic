Practica realizada por:
- Paloma de la Fuente Bahon
- Ines Gonzalez de Miguel
- Federico Mon Trotti

Requisitos: Java 5

Los ficheros de entrada han de ser archivos de textos con valores numericos.
En la primera linea, ira el valor umbral necesario para clasificar las 
muestras. El resto del archivo seran los valores de las muestras separados por
comas, donde los decimales han de separarse por un punto. Todas las muestras 
han de tener el mismo numero de argumentos, y este debe ser el mismo tanto en 
el fichero de entrenamiento como en el de aprendizaje. En ambos ficheros se 
considera que el primer dato en cada muestra es del de la clase a la que 
pertenece, luego es ignorado en los algoritmos.

Estan implementados los algoritmos de Cuantizacion Vectorial, SOM, Lloyd y 
K-Medias.

El algoritmo de Cuantizacion Vectorial entrena con un archivo de muestras 
(xxx_training), y luego se ejecutan los algoritmos que se elijan de entre 
los otros tres, que realizan el aprendizaje de las muestras que se encuentran
en el otro archivo (xxx_learning).

Hemos incluido 3 archivos de datos distintos. Dos de ellos nos han ayudado a 
realizar y depurar cada uno de los algoritmos implementados y el tercer archivo
ha sido descargado de www.ics.uci.edu/~mlearn/MLRepository.html y adecuado a
las necesidades de la implementacion.

Un ejemplo de uso del programa:

java -jar iaic2.jar --som --lloyd --kmedias --entrenamiento data.txt 
--entrada data.txt


Para mas informacion, ejecute:

java -jar iaic2.jar -h
