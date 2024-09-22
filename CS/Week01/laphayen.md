# 자료구조 - 1

## 1. Array & List

**질문:**
두 개의 정렬된 배열이 주어졌을 때, 이 두 배열을 합쳐서 하나의 정렬된 배열로 만드는 효율적인 방법은 무엇인가요? 시간 복잡도는 어떻게 되나요?

**예상 답변:**
- 방법: 병합 정렬(Merge Sort)에서 사용하는 병합(Merge) 기법을 활용할 수 있습니다. 두 배열의 첫 번째 원소부터 비교하여, 더 작은 값을 새로운 배열에 추가하고, 그 배열의 인덱스를 증가시킵니다. 두 배열 중 하나가 끝날 때까지 이를 반복합니다.

- 시간 복잡도: 두 배열의 크기를 각각 m, n이라고 하면, 전체 시간 복잡도는 O(m + n) 입니다. 각 배열의 모든 원소를 한 번씩 비교하여 새로운 배열에 추가하기 때문입니다.

## 2. Stack & Queue

**질문:**
애플리케이션 프로그램에서 스택과 큐가 쓰이는 예시를 들어주세요.

**예상 답변:**
- 웹 브라우저의 뒤로 가기 기능 (브라우저의 내비게이션 히스토리 관리)

- 웹 브라우저에서 사용자가 페이지를 탐색할 때, 이전에 방문한 페이지의 URL이 스택에 저장됩니다. 사용자가 "뒤로 가기" 버튼을 클릭하면 스택의 가장 상단에 있는 페이지가 제거되면서 해당 페이지로 이동합니다.

- 프린터 작업 대기열

- 여러 사용자가 프린터에 작업을 보내면, 프린터는 큐를 사용하여 작업을 순서대로 처리합니다. 가장 먼저 요청된 인쇄 작업이 먼저 처리되고, 나중에 요청된 작업은 뒤에서 기다립니다.

## 3. Hash

**질문:**
Hash Map과 Hash Table의 차이점에 대해 설명해주세요.

**예상 답변:**
- 동기화 지원 여부와 null 값 허용 여부의 차이가 있습니다.

- 해시 테이블(Hash Table): 병렬 처리를 할 때 (동기화를 고려해야 하는 상황) Thread-safe 하다.Null 값을 허용하지 않는다.

- 해시 맵(Hash Map): 병렬 처리를 하지 않을 때 (동기화를 고려하지 않는 상황) Thread-safe하지 않는다.Null 값을 허용한다