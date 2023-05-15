## 특정 string 포함 여부 확인 
 - **locate** : 특정 문자열이 등장하는 위치 반환, 특정 문자열이 없는 경우 0 반환
     ``` MySQL
      locate("특정 문자열", STRING);   # return : 값 없는 경우 0, 특정 문자열 위치
      select * from TEST where locate("네비게이션", STRING) > 0;   # like를 사용할 수 없는 경우 유용
      select * from TEST where locate("네비게이션", STRING);       # 위의 > 0 줄과 같은 결과 출력함
      ``` 
 - **like**
     ``` MySQL
     # 주의점 : like 연산자 사용, 문자열 이어붙이는 concat 함수 사용
     select * from TEST where STRING like concat("%", "네비게이션", "%");
     ```
     
## string 합치기
 - **concat**
    ``` MySQL
       concat(STRING1, STRING2, " ", "-", STRING3, ...);
    ```

## string 자르기
 - **substr**
   ``` MySQL
      substr(STRING, 시작 위치값);  # 시작 위치값부터 읽음
      substr(STRING from 시작 위치값);  # 위와 동일
      substr(STRING, 시작 위치값, 가져올 길이값);  # 시작 위치값부터 가져올 길이값 만큼만 읽음
      substr(STRING from 시작 위치값 for 가져올 길이값);  # 위와 동일
      
      # 가져올 길이값 (-)
      select substr('동해물과백두산이', -4);  # 뒤에서 4번째 문자열부터 읽음, '백두산이'
      select substr('동해물과백두산이' from -4);  # 백두산이
      select substr('동해물과백두산이', -6, 4);  # 뒤에서 6번째 문자열부터 4글자만 읽음, '물과백두'
      select substr('동해물과백두산이' from -6 for 4);  # 물과백두
   ```
