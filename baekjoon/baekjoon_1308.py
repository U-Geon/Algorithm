from sys import stdin
from datetime import date

y1,m1,d1 = map(int, stdin.readline().split())
y2,m2,d2 = map(int, stdin.readline().split())
day1 = date(y1,m1,d1)
day2 = date(y2,m2,d2)
d_day = (day2-day1).days

if d_day >= 365243: # 1000년 뒤 일수보다 큰 경우 gg
    print("gg")
else:
    print(f'D-{d_day}')