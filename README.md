# voicezen
HighScoreSubSequence

Initial Analysis:

Found the problem too tough and not sure what to do. so thought I did not think about it again
But later the HR called and said if I give upto what I have solved. So I started writing the things and 
little ideas came in and below is the flow of that.

Later took up the challenge and tried to divide the problem to smaller version, like how would i solve the problem if given string 
was small.

Approach:

But later the formula seemed very wierd, But after observing the graphs of x^2 (x - length) and cubic root of y(frequency)
Assumed below points and approached to this solution:
Math.pow(x, 2) * Math.pow((y - 1), 0.33)
    x -> subsequence length
    y -> number of times the subsequence is repeated in the full file
->for larger values of x we can ignore cubic root of y since it is growing very slow.
->file will always contain repeated strings
->but the minimum value for y(i.e frequency) should be > 1 

So we can find the longest subsequence among the given string and that should be the answer for larger values of x.
so applied the same to the given file.

  

