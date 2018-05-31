   #/bin/bash
   #Vision_eye (Siddharth joshi/A687313 Shikha Kumari/A686301)
   # We have assumed that is number of clap and number of clappers are same or if number clapper is divisible by number of claps then experiment is successful
   echo "Please enter number os experiments"
   read E
   tail -$E input.txt > input_1.txt
   val1=` cat input_1.txt | wc -l`
  for (( i=1; i <= $val1;i++))
  {
   while read line
   do 
	echo $line > test1.txt
	IFS=' ' read N C < test1.txt
	result1=` expr $C % $N `
	if [ $N -eq $C ] || [ $result1 -eq 0 ] ;
	then
	echo " Experiment-$i: ON "
	else 
	echo " Experiment-$i: OFF "
	fi
	done < input_1.txt;
	}
	exit 0
