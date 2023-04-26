### 입출금내역 분석

**Keep it short and simple**

가장 간단한 문제(요구사항)부터 코드를 한 개의 클래스로 구현한다.  
구현중 발생할 수 있는 예외 상황은 신경쓰지말고 일단 간단히 구현한다.

**요구 사항**

수상한 정팔이의 돈관리가 의심된다.
확인하고자 입출금 내역이 담긴 CSV 파일을 분석하려고한다.

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

        System.out.println("정팔이의 총 지출은 " + total + "원 입니다.");
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


**접근**
One에서는 KISS, DRY, SRP가 녹아있다.

<details>
<summary>final에 대한 생각</summary>

</details>

코드 유지보수성을 결정하는데 중요한 개념, 보통 클래스에 적용하지만 메서드 수준에서도 적용이 가능하다.

Entry Point인 BankAnalyzer 클래스에서는

- 정팔이의 거래 내역을 읽고,
- 계산하고,
- 화면으로 결과 전송

SRP와도 거리가 멀고 응집도(클래스와 케서드의 책임도 강하게 연결)가 높게 보인다.

BankAnalyzer에서 계산 관련 작업은 BankProcessor라는 클래스로 따로 빼버린다.

이러면 계산을 위해 BankAnalyzer를 귀찮게하지 않아도 된다.

즉, 전체 클래스인 BankAnalyzer에 의존하지 않고 BankProcessor가 제공하는 메소드를 다른곳에서도 재사용할 수 있게된다.

연산 클래스인 BankProcessor

```sql
public class BankStatementProcessor {

    private final List<BankTransaction> bankTransactions;

    public BankStatementProcessor(List<BankTransaction> bankTransactions) {
        this.bankTransactions = bankTransactions;
    }

    public double calculateTotalAmount() {
        double total = 0;
        for(final BankTransaction bankTransaction : bankTransactions){
            total+= bankTransaction.getAmount();
        }
        return total;
    }

    public double calculateTotalInMonth(final Month month) {
        double total = 0;
        for(final BankTransaction bankTransaction : bankTransactions){
            if(bankTransaction.getDate().getMonth() == month) {
                total += bankTransaction.getAmount();
            }
        }
        return total;
    }

    public double calculateTotalForCategory(final String category) {
        double total = 0;
        for(final BankTransaction bankTransaction : bankTransactions){
            if(bankTransaction.getDescription().equals(category)) {
                total += bankTransaction.getAmount();
            }
        }
        return total;
    }
}
```

연산을 분리후

```sql
public class BankAnalyzer {
    private static final String RESOURCES = "src/main/resources/";

    public void analyze(final String fileName, final BankStatementParser bankStatementParser) throws IOException {
        final Path path = Paths.get(RESOURCES + fileName);
        final List<String> lines = Files.readAllLines(path);

        final List<BankTransaction> bankTransactions = bankStatementParser.parseLinesFrom(lines);
        final BankStatementProcessor bankStatementProcessor = new BankStatementProcessor(bankTransactions);
        collectSummary(bankStatementProcessor);
    }

    private static void collectSummary(BankStatementProcessor bankStatementProcessor) {
        System.out.println("정팔이의 총 지출은  " + bankStatementProcessor.calculateTotalAmount());
        System.out.println("정팔이의 1월 지출은 " + bankStatementProcessor.calculateTotalInMonth(JANUARY));
        System.out.println("정팔이의 2월 지출은 " + bankStatementProcessor.calculateTotalInMonth(FEBRUARY));
        System.out.println("정팔이의 총 급여는 " + bankStatementProcessor.calculateTotalForCategory("Salary"));
    }
}
```

---

**유틸리티**

만능 국밥식 유틸 클래스를 어떻게 바라봐야할까? 객체지향으로 이름을 날린 사람들이 혀를 내두르고 반대하는데 그럼 이런 상황에서 업무에서나 사이드에서나 어디에 그럼 위치해야하는지도 의문이다.

OOP에서 유틸 클래스를 죄악으로 생각하는 이유는 기능 응집도 중심인 절차적 언어에서 넘어왔기때문이다. 클래스 단위에서 생각해봐야할 응집도 그룹화가 6가지 정도 있는데

DRY 원칙으로 생각하면 된다. 중복 피해라 단점으로는 하나의 기능을 가진 메소드들이 정말 많이 생겨날 수 있다.

**A. 절차적 메소드 호출**

```sql
int max = NumberUtils.max(10, 5);
```

**B. 객체지향적 방법**

```sql
int max = new Max(10, 5).intValue();
```

같은가? 다른가?

1. 객체지향 원칙 위반
   유틸리티 클래스는 객체지향 프로그래밍에서 추구하는 원칙 중 하나인 "객체 지향적 설계"와 상반. 객체 지향적 설계는 코드를 구성하는 모든 요소를 객체로 추상화하고, 이러한 객체 간의 상호작용을 통해 시스템을 구성하려는 것.

유틸리티 클래스는 이러한 객체 지향적 설계를 무시하고, 단순히 메서드들을 모아 놓은 "함수 라이브러리"에 가깝다.
2. 의존성 문제
   유틸리티 클래스에 구현된 메서드는 일반적으로 다른 클래스에서 사용된다, 이 경우, 다른 클래스가 유틸리티 클래스에 의존하게 되는데, 이는 의존성 문제를 야기하고 . 의존성 문제는 시스템의 복잡성을 증가시키고, 유지보수를 어렵게 만든다.
3. 단위 테스트 어려움
   static method)로 이루어져 있기 때문에 단위 테스트하기가 어렵다. 정적 메서드는 다른 코드와 결합되어 있기 때문에 테스트 할려면 모든 종속성(dependency)을 명시적으로 정의해야 하기 때문

싸움터

[https://www.yegor256.com/2014/05/05/oop-alternative-to-utility-classes.html](https://www.yegor256.com/2014/05/05/oop-alternative-to-utility-classes.html)