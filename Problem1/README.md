# Bus Service

After shifting to a new location for Mumbai, Atos wanted to start bus service for an employee coming from the Western side.
So buses will run on the route Airoli to Borivali to-and-fro multiple times a day.

When bus reach Borivali from Airoli (or at Airoli from Borivali), a driver needs some tea break before he starts to take the return journey. But it depends on driver how much minutes he will take.
If one driver doesn't need any tea break, he will immediately start for a return journey. So if the bus arrives at 08:00 and driver doesn't need any tea break then break time is 0 minutes, and it can leave immediately, i.e at 08:00.

Atos already have bus schedule consist of all trips with departure and arrival time between Airoli and Borivali. Atos needs the count of buses, they have to start the day at Airoli and Borivali in order to make the schedule work. It means that whenever a bus is supposed to leave Airoli or Borivali, there must actually be one there ready to go. There are various pickups and drops in the route, so buses don't necessarily arrive in the same order that they leave. and Buses will always stick to the schedule.

## Input

The first line gives the number of days in that schedule, **D**. **D** days follow.

Each day contains a number of lines. The first line is the tea break time, **T**, in minutes.
The next line has two numbers in it, 1st number is the number of trips from Airoli to Borivali (say AB), and the 2nd one is the number of trips from Borivali to Airoli (say BA). Then there are AB lines giving the details of the trips from Airoli to Borivali.

Each line contains two inputs, giving the **hr:min** departure and arrival time for that trip. All trips will occur on the same day. The trips are not sorted by time. Trips timings are given in a 24-hour clock (00:00 through 23:59).
After these AB lines, there are BA lines giving the departure and arrival times for the trips from Borivali to Airoli.

## Output

For each day, output one line containing "**Day-DN: A B**",

Where **DN** is Day number, and **A** is the number of buses that must start at Airoli and **B** is the number of buses that must start at Borivali on that day.


### Sample Input
```
3
0
1 2
02:40 04:00
01:00 02:40
02:40 03:55
10
3 2
02:40 03:41
02:40 03:42
02:40 03:43
02:49 03:50
02:50 03:51
2
2 0
09:00 10:30
12:00 01:45
```

### Sample Output

```
Day-1: 0 2
Day-2: 3 2
Day-3: 2 0
```