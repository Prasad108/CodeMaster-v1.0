# Clapper

My friend developed a clapping circuit, Clapper. Which turn ON and OFF on clap if receiving power. 
Not only that, but he also manages to make this circuit to work as an adapter (like our three pin adapter, but with On and OFF facility), where it's one side plug into the power supply and another side can work as a socket to plug a bulb or other Clapper circuit in it.

So say, I have one Clapper and bulb, I attached Clapper to a power supply ( which is Always ON ) and bulb to Clapper.

Something like below, for below case I assume Clapper is in ON state ( by default, it's always OFF)

Power(Always ON) -> Clapper 1(ON) -> bulb(ON)

Power is ON, and my Clapper is in ON state, then the bulb is also ON, as it is receiving power through Clapper. Pretty simple right!!
 


Now let's do this experiment with two Clapper. Initially, all the Clappers are in the OFF state, as by default.

Power is ON, but both Clapper is in OFF State, hence bulb is OFF

Which will look like below,

Power(Always ON) -> Clapper 1(OFF) -> Clapper 2(OFF) -> bulb(OFF)


I clapped, and now

As while clap, 1st Clapper receiving power hence went in ON state, but during clap, 2nd was not receiving power. Hence remains in OFF state, and so the bulb will remain OFF.

Power(Always ON) -> Clapper 1(ON) -> Clapper 2(OFF) -> bulb(OFF)  


I clapped again, and now

Again 1st Clapper was receiving power hence, toggle to OFF state. Making 2nd Clapper to ON state but now without power, hence bulb still remains OFF.

Power(Always ON) -> Clapper 1(OFF) -> Clapper 2(ON) -> bulb(OFF)


and now if I clapped one more time,

Again 1st Clapper was receiving power hence toggle to ON state, 2nd Clapper remains in ON state, as during clap it was not receiving power. So both clappers are in ON state, which makes bulb ON. wohoooo :)

Power(Always ON) -> Clapper 1(ON) -> Clapper 2(ON) -> bulb(ON)


So my outcome is, the bulb is ON in only one condition, that if the bulb is receiving power from the Clapper, to which it is plugged in.

Somehow, now I have N Clapper and I connected them in the chain back to back (like 3 pin adapter attached to other 3 pin adapter) and on last i.e Nth Clapper, I attached bulb. Now say if I clapped for C times. Is my bulb ON / OFF?


## Input
The first line of the input gives the number of experiments, **E**. **E** lines follow. Each one contains two integers, **N** and **C**.
**N** is a number of Clappers connected to each other back to back and **C** is number clapped I did for that experiment.


## Output
For each experiment, output one line containing "**Experiment-EN: BS**", where **EN** is the experiment number (starting from 1) and **BS** is bulb state which is ON/OFF.


### Sample Input

```
4
4 0
1 1
3 350
1 85
```

### Sample Output

```
Experiment-1: OFF
Experiment-2: ON
Experiment-3: OFF
Experiment-4: ON
```