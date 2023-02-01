def solution(babbling):
    answer = 0
    canbabbleList = ["aya","ye","woo","ma"]
    for i in babbling:
        for j in canbabbleList:
            if j in i:
                i = i.replace(j,'@')
        else:
            rtn = set(i)
            if len(rtn) == 1 and '@' in rtn:
                answer += 1

    return answer

print(solution(["ayaye", "uuuma", "ye", "yemawoo", "ayaa"]))
