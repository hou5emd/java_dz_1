# Домашнее задание 10

## Вывод в консоли
```
cd /home/andrey/git/java_first/dz_1/dz-on
e ; /usr/bin/env /usr/lib/jvm/java-21-openjdk-amd64/bin/java -XX:+ShowCodeDetailsInExceptionMessages -c
p /home/andrey/git/java_first/dz_1/dz-one/bin homeworks.homework010.App 
Четные числа: [12, 22, 34, 48, 56, 78]
Числа, сумма цифр которых четна: [22, 48, 91]
Доп задание
1
hello
true
true
```

## App.java
```java
package homeworks.homework010;

import java.util.Arrays;

public class App {
   public static void main(String[] args) {
      int[] array = {12, 22, 34, 48, 56, 67, 78, 89, 91};

      int[] evenNumbers = Sequence.filter(array, n -> n % 2 == 0);
      System.out.println("Четные числа: " + Arrays.toString(evenNumbers));

      int[] sumEvenNumbers = Sequence.filter(array, n -> {
         int sum = 0;
         int temp = n;
         while (temp > 0) {
            sum += temp % 10;
            temp /= 10;
         }
         return sum % 2 == 0;
      });
      System.out.println("Числа, сумма цифр которых четна: " + Arrays.toString(sumEvenNumbers));
      System.out.println("Доп задание");
      Pair<Integer, String> pair = Pair.of(1, "hello");
      Integer i = pair.getFirst(); // 1
      String s = pair.getSecond(); // "hello"
      Pair<Integer, String> pair2 = Pair.of(1, "hello");
      boolean mustBeTrue = pair.equals(pair2); // true!
      boolean mustAlsoBeTrue = pair.hashCode() == pair2.hashCode(); // true!
      System.out.println(i);
      System.out.println(s);
      System.out.println(mustBeTrue);
      System.out.println(mustAlsoBeTrue);
   }
}
```

## Sequence.java
```java
package homeworks.homework010;

import java.util.ArrayList;
import java.util.List;

public class Sequence {
   public static int[] filter(int[] array, ByCondition condition) {
      List<Integer> result = new ArrayList<>();
      for (int num : array) {
         if (condition.isOk(num)) {
            result.add(num);
         }
      }
      int[] filtered = new int[result.size()];
      for (int i = 0; i < result.size(); i++) {
         filtered[i] = result.get(i);
      }
      return filtered;
   }
}
```

## ByCondition.java
```java
package homeworks.homework010;

@FunctionalInterface
public interface ByCondition {
   boolean isOk(int number);
}
```

## Pair.java
```java
package homeworks.homework010;

import java.util.Objects;

public final class Pair<F, S> {
   private final F first;
   private final S second;

   private Pair(F first, S second) {
      this.first = first;
      this.second = second;
   }

   public static <F, S> Pair<F, S> of(F first, S second) {
      return new Pair<F, S>(first, second);
   }

   public F getFirst() {
      return first;
   }

   public S getSecond() {
      return second;
   }

   @Override
   public boolean equals(Object o) {
      if (this == o)
         return true;
      if (o != null || o instanceof Pair) {
         Pair<?, ?> pair = (Pair<?, ?>) o;
         return Objects.equals(first, pair.first) && Objects.equals(second, pair.second);
      }
      return false;
   }

   @Override
   public int hashCode() {
      return Objects.hash(first, second);
   }
}
```
