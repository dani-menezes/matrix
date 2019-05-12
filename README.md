# MELI - MATRIX

### ALGORITMO

![alt Sonar](images/Algorithm.png)

Para a solução do problema, foi desenvolvimento um método que analisa todos os elementos da Matriz, checando se seu visinhos são o mesma letra do DNA.
As possibilidades são: 

- itens de uma mesma linha
- itens de uma mesma coluna
- itens na diagonal

Dessa maneira a matriz é percorrida somente uma vez, já eliminando os elementos que não possuem um número de 4 vizinhos.

### HOW TO (API)

#### SIMIAN

##### ENDPOINT

```
https://cloudapp.leapmind.com.br/simian
```

##### BODY

```
{"dna": ["AATAA", "CCTCC", "TTATT", "GGAGG", "GGAGG"]}
```

##### EXEMPLO
![alt Simian endpoint](images/postman_simian.png)

#### STATS

##### ENDPOINT

```
https://cloudapp.leapmind.com.br/stats
```

##### EXEMPLO
![alt Simian endpoint](images/postman_stats.png)

### HOW TO (RUN)

##### DOCKER BUILD

```
./build.sh
```

##### DOCKER RUN

```
./run.sh
```
obs: run usado na porta 11080

##### DOCKER STOP

```
./stop.sh
```

### SONAR

![alt Sonar](images/sonar.png)
