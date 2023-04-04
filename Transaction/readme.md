### 입출금내역 분석

**Keep it short and simple**

가장 간단한 문제(요구사항)부터 코드를 한 개의 클래스로 구현한다.  
구현중 발생할 수 있는 예외 상황은 신경쓰지말고 일단 간단히 구현한다.

**요구 사항**

막내아들 철수는 용돈 대신 아버지 카드를 사용한다.  
철수의 씀씀이를 확인하고자 입출금 내역이 담긴 CSV 파일을 계좌에서 다운받아 분석하려고한다.

**코드**

```jsx
public class BankTransactionHistorySimple {
    private static final String RESOURCES = "src/main/resources/";

    public static void main(final String[] args) throws Exception {
        final Path path = Paths.get(RESOURCES + "bank-data.csv");
        final List<String> lines = Files.readAllLines(path);
        double total = 0;
        for(final String line: lines) {
            String[] columns = line.split(",");
            double amount = Double.parseDouble(columns[1]);
            total += amount;
        }

        System.out.println("철수의 총 지출은 " + total + "원 입니다.");
    }
}
```

**생각해볼점** 
1. final  
여기서 지역 변수나 필드를 final로 선언했는데 변수에 값을 재할당할 수 없다.  
사용시 장단점에 대해 생각해볼 수 있고 final 키워드가 추상메소드 환경에서는 의미있을지?  

2. DRY 위반  
코드를 간결히 유지하는것도 중요하지만 위와 같이 변화에 유연하지못하고  
경우의 수마다 반복될 상황이 생긴다면 DRY를 위반한것이고 KISS를 남용한것이다.
