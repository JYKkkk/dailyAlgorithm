## group by 활용
 - ex1)
     ``` MySQL
      select FOOD_TYPE, REST_ID, REST_NAME, FAVORITES 
      from REST_INFO 
      where (FOOD_TYPE, FAVORITES) in 
        (select FOOD_TYPE, max(FAVORITES) from REST_INFO group by FOOD_TYPE) 
      order by FOOD_TYPE desc; 
      
      ``` 
      
      ``` MySQL
      
      # 쿼리를 실행하면 각 FOOD_TYPE별 첫번째 식당 정보가 나옴 (having max 부분을 지워도 결과값 동일) 
      select FOOD_TYPE, REST_ID, REST_NAME, FAVORITES
      from REST_INFO
      group by FOOD_TYPE
      having max(FAVORITES)
      order by FOOD_TYPE desc;
      
      ```
