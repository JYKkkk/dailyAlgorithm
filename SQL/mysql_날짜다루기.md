## 날짜 차이 가져오기
 - **datediff** : 단순히 일 차이를 가져옴 
     ``` MySQL
      # +1 해줘야 시작일(날짜1) 포함한 일 수 반환 e.g. 10/03 ~ 10/04 -> 1인데, +1해줘야 2
      datediff(날짜1, 날짜2) + 1;   #날짜1 - 날짜2
      ``` 
 - **timestampdiff** : 차이를 연, 분기, 월, 주, 일, 시, 분, 초로 지정하여 가져올 때 사용하는 함수
     ``` MySQL
     timestampdiff(단위, 날짜1, 날짜2); 
     ```
    - 단위 : second, minute, hour, day, week, month, quarter, year
