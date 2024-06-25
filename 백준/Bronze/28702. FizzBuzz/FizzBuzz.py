from sys import stdin as s


def solution(num):
    if num % 3 == 0 and num % 5 == 0:
        print('FizzBuzz')
    elif num % 3 == 0:
        print('Fizz')
    elif num % 5 == 0:
        print('Buzz')
    else:
        print(num)


s1 = s.readline().strip()
s2 = s.readline().strip()
s3 = s.readline().strip()


if s3 == 'FizzBuzz':
    print(int(s2) + 2)
elif s3 == 'Fizz':
    if s1 != 'Buzz':
        num = int(s1) + 3
    else:
        num = int(s2) + 2
    solution(num)

elif s3 == 'Buzz':
    if s1 != 'Fizz':
        num = int(s1) + 3
    else:
        num = int(s2) + 2
    solution(num)

else:
    solution(int(s3) + 1)