첫번째 접근방법은 SRP 원칙을 적용해 파싱 로직을 분리하는것이다.  
CSV가 아니라 JSON이나 다른 확장자를 사용할 수 있지않은가?

```java
public interface BankStatementParser {
    BankTransaction parseFrom(String line);
    List<BankTransaction> parseLinesFrom(List<String> lines);
}
```

인터페이스로 만들어서 앞으로 새로운 확장자에대한 파싱에서 유연하게  대처할 수 있게했다.

**BankTransaction**(입출금내역)이라는 도메인 객체를 만들어서 반환시킨다.

```java
public class BankTransaction {
    private final LocalDate date;
    private final double amount;
    private final String description;

    public BankTransaction(final LocalDate date, final double amount, final String description) {
        this.date = date;
        this.amount = amount;
        this.description = description;
    }

    public LocalDate getDate() {
        return date;
    }

    public double getAmount() {
        return amount;
    }

    public String getDescription() {
        return description;
    }

    @Override
    public String toString() {
        return "입출금 내역{" +
                "날짜=" + date +
                ", 금액=" + amount +
                ", 설명='" + description + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BankTransaction that = (BankTransaction) o;
        return Double.compare(that.amount, amount) == 0 &&
                date.equals(that.date) &&
                description.equals(that.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(date, amount, description);
    }
}
```

**생각해볼점**  
여기서 equals()와 hashCode() 구현을 왜 제공하는지 충분히 고민해볼만하다.  

### **Main 클래스의 변화**
**Before**

```java
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
```

**After**

```java
private static final String RESOURCES = "src/main/resources/";

public static void main(final String[] args) throws Exception {

    final BankStatementCSVParser bankStatementParser = new BankStatementCSVParser();
    final Path path = Paths.get(RESOURCES + args[0]);
    final List<String> lines = Files.readAllLines(path);
    final List<BankTransaction> bankTransactions = bankStatementParser.parseLinesFrom(lines);

    System.out.println("총지출 " + calculateTotalAmount(bankTransactions));
    System.out.println("1월의 지출 " + selectInMonth(bankTransactions, Month.JANUARY));
}

private static double calculateTotalAmount(final List<BankTransaction> bankTransactions) {
        double total = 0d;
        for(final BankTransaction bankTransaction: bankTransactions){
            total+=bankTransaction.getAmount();
        }
        return total;
    }

    private static List<BankTransaction> selectInMonth(final List<BankTransaction> bankTransactions, final Month month) {
        final List<BankTransaction> bankTransactionsThisMonth = new ArrayList<>();
        for (final BankTransaction bankTransaction : bankTransactions) {
            if (bankTransaction.getDate().getMonth() == month) {
                bankTransactionsThisMonth.add(bankTransaction);
            }
        }
        return bankTransactions;
    }
```

후의 코드량이 더 증가했지만 bankTransactions 객체에서 정보를 추출하기 때문에 메인에서 굳이 내부에서 파싱이 어떻게 이루어지는지 알아야 할 필요가 사라졌다.  
time.Month는 처음 사용해보는데 따로 상수화 할 필요 없이 자바에서 제공한다.  
파싱 기능을 다른 클래스로 위임했다. final for문 경우는 신선한 방식이라서 생각해볼 필요가있다.
