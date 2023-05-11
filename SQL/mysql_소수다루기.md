## 반올림
 - **round** : (숫자를 반올림할 자릿수+1)자릿수에서 반올림
     ``` MySQL
      select round(3456.1234567) from TEST;   #3456
      select round(3456.1234567, 1) from TEST;  #3456.1
      select round(3456.1234567, 4) from TEST;  #3456.1235
      select round(3456.1234567, -1) from TEST;   #3460
      select round(3456.1234567, -2) from TEST;   #3500
      ``` 
## 버림
 - **truncate** : 버릴 자릿수를 명시해 줘야 함
     ``` MySQL
     select truncate(3456.1234567, 1) from TEST;  #3456.1
     select truncate(3456.1234567, 4) from TEST;  #3456.1234
     select truncate(3456.1234567, -1) from TEST;   #3450
     select truncate(3456.1234567, -2) from TEST;   #3400
     ```
