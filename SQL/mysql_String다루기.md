## 특정 string 포함 여부 확인 
 - **locate** : 특정 문자열이 등장하는 위치 반환, 특정 문자열이 없는 경우 0 반환
     ``` MySQL
      locate("특정 문자열", STRING);   # return : 값 없는 경우 0, 특정 문자열 위치
      select * from TEST where locate("네비게이션", STRING) > 0;   # like를 사용할 수 없는 경우 유용
      ``` 
 - **like**
     ``` MySQL
     # 주의점 : like 연산자 사용, 문자열 이어붙이는 concat 함수 사용
     select * from TEST where STRING like concat("%", "네비게이션", "%");
     ```
