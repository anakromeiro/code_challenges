def is_leap(year):
    leap = False
    
    if ((year/4).is_integer()):
        d100 = (year/100).is_integer()
        d400 = (year/400).is_integer()
        if (d100 == d400):
                leap = True
        
    return leap

year = int(input())
print(is_leap(year))