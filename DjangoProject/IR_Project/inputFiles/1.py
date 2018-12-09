if __name__ == '__main__':
    students = []
    for _ in range(int(input())):
        name = input()
        score = float(input())
        students.append([name, score])
    first_min = 0
    # print(first_min, second_min)
    for i in students:
        if i[1] < first_min:
            second_min = first_min
            first_min = i[1]
    students.sort(key=lambda x: x[0])
    students.sort(key=lambda x: x[1])
    # print(students)
    flag = 0
    first_min = students[0][1]
    second_min = 0 
    for i in students:
        if first_min != i[1] and flag == 0:
            second_min = i[1]
            flag = 1
        if flag == 1 and i[1] == second_min:
            print(i[0])



