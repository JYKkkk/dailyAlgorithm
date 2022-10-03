<img src="https://j7b205.p.ssafy.io/assets/header/github_header.png" />

# <img src="https://static.solved.ac/tier_small/14.svg" alt="tier" height="32px" /> 크리스마스 트리 - 1234 

## 문제

> https://www.acmicpc.net/problem/1234

### 분류

combinatorics, ,dp, ,math, 

### 문제 설명

오민식은 오늘이 크리스마스라고 생각해서, 크리스마스 트리를 만들려고 한다. 트리는 N개의 레벨로 이루어져 있다. 위에서부터 레벨1, ... 레벨 N이다. 또, 민식이는 빨강, 파랑, 초록색의 장난감을 가지고 있다. 그리고 민식이는 이 장난감을 일정한 규칙에 의해서 장식하려고 한다.
레벨 K에는 딱 K개의 장난감이 있어야 한다. 또, 각 레벨에 놓으려고 선택한 색이 있으면, 그 색의 장난감의 수는 서로 같아야 한다. 예를 들어, 레벨 3에 장난감을 놓으려고 할 때, 빨강 2, 파랑 1과 같이 놓으면, 빨강과 파랑의 수가 다르기 때문에 안 된다. 하지만, 레벨 4에 빨강 2, 파랑 2와 같이 놓으면, 가능하다.
N과, 장난감의 수가 주어질 때, 트리를 장식하는 경우의 수를 출력하는 프로그램을 작성하시오.



#### 입력

첫째 줄에 트리의 크기 N, 빨강의 개수, 초록의 개수, 파랑의 개수가 주어진다. N은 10보다 작거나 같다. 빨강, 초록, 파랑의 개수는 0보다 크거나 같고, 100보다 작거나 같다.



#### 출력

첫째 줄에 경우의 수를 출력한다. 만약 주어진 장난감으로 트리를 장식할 수 없으면 0을 출력한다. 문제의 정답은 263-1보다 작거나 같다.



#### 예제

<table><tr><th><img width=120/>입력 1<img width=120/></th><th><img width=120/>출력 1<img width=120/></th></tr><tr><td>

```
2 1 1 1```
</td><td>

```
6```
</td></tr></table>
,<table><tr><th><img width=120/>입력 2<img width=120/></th><th><img width=120/>출력 2<img width=120/></th></tr><tr><td>

```
2 2 1 0```
</td><td>

```
3```
</td></tr></table>
,<table><tr><th><img width=120/>입력 3<img width=120/></th><th><img width=120/>출력 3<img width=120/></th></tr><tr><td>

```
3 2 2 1```
</td><td>

```
0```
</td></tr></table>
,<table><tr><th><img width=120/>입력 4<img width=120/></th><th><img width=120/>출력 4<img width=120/></th></tr><tr><td>

```
3 2 2 2```
</td><td>

```
36```
</td></tr></table>
,<table><tr><th><img width=120/>입력 5<img width=120/></th><th><img width=120/>출력 5<img width=120/></th></tr><tr><td>

```
8 1 15 20```
</td><td>

```
197121```
</td></tr></table>


####

## 풀이 코드

```c


```
