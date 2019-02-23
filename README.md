# uva-11462-age-sort
Age sort impl
https://uva.onlinejudge.org/index.php?option=onlinejudge&page=show_problem&problem=2457

You are given the ages (in years) of all people of a country with at least 1 year of age. You know that
no individual in that country lives for 100 or more years. Now, you are given a very simple task of
sorting all the ages in ascending order.
Input
There are multiple test cases in the input file. Each case starts with an integer n (0 < n ≤ 2000000), the
total number of people. In the next line, there are n integers indicating the ages. Input is terminated
with a case where n = 0. This case should not be processed.
Output
For each case, print a line with n space separated integers. These integers are the ages of that country
sorted in ascending order.
Warning: Input Data is pretty big (∼ 25 MB) so use faster IO.
Sample Input
5
3 4 2 1 5
5
2 3 2 3 1
0
Sample Output
1 2 3 4 5
1 2 2 3 3
