package com.training.javaEight.stream;

import lombok.AllArgsConstructor;
import lombok.Data;
import sun.management.GcInfoBuilder;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class StreamExample3 {

    private final static BigDecimal thirty = new BigDecimal(30); //BigDecimal은 불변객체이기 때문에 안전하게 재사용 할수 있다.

    public static void main(String[] args){
        final List<Product> products = Arrays.asList(
                new Product(1L, "A", new BigDecimal("100.50")),
                new Product(2L, "B", new BigDecimal("23.00")),
                new Product(3L, "C", new BigDecimal("31.45")),
                new Product(4L, "D", new BigDecimal("80.20")),
                new Product(5L, "E", new BigDecimal("7.50"))
        );

        System.out.println("Products.price >= 30 \n" +
            products.stream()
                    .filter(product -> product.getPrice().compareTo(thirty) >= 0)
                    .collect(Collectors.toList())
        );

        System.out.println("\n====================================================");
        System.out.println("Products.price > 30 (with joining(\"\\n\")) \n"+
            products.stream()
                    .filter(product -> product.getPrice().compareTo(thirty) >= 0)
                    .map(product -> product.toString())
                    .collect(Collectors.joining("\n"))
        );

        System.out.println("\n====================================================");
        System.out.println("Products price total sum \n"+
            products.stream()
                    .map(product -> product.getPrice()) // price1 / price2의 값을 정의
                    .reduce(BigDecimal.ZERO, (price1, price2) -> price1.add(price2)) //resuce(초기값, 계산식) price1은 누적값(이전값)
        );

        System.out.println("\n====================================================");
        System.out.println("Products price 30 over sum \n"+
            products.stream()
                    .filter(product -> product.getPrice().compareTo(thirty) >= 0)
                    .map(product -> product.getPrice())
                    .reduce(BigDecimal.ZERO, (price1, price2) -> price1.add(price2))
        );

        System.out.println("\n====================================================");
        System.out.println("Products price 30 over count \n"+
            products.stream()
                    .filter(product -> product.getPrice().compareTo(thirty) >= 0)
                    .count()
        );

        final OrderedItem item1 = new OrderedItem(1L, products.get(0), 1);
        final OrderedItem item2 = new OrderedItem(2L, products.get(2), 3);
        final OrderedItem item3 = new OrderedItem(3L, products.get(4), 10);

        final Order order = new Order(1L, Arrays.asList(item1, item2, item3));

        System.out.println("\n====================================================");
        System.out.println("order.totalPrice : "+order.totalPrice());
    }
}

@AllArgsConstructor
@Data
class Product {
    private Long id;
    private String name;
    private BigDecimal price;
}

@AllArgsConstructor
@Data
class OrderedItem {
    private Long id;
    private Product product;
    private int quantity;

    public BigDecimal getTotalPrice(){
        return product.getPrice().multiply(new BigDecimal(quantity));
    }
}

@AllArgsConstructor
@Data
class Order {
    private Long id;
    private List<OrderedItem> items;

    public BigDecimal totalPrice(){
        return items.stream()
                .map(item -> item.getTotalPrice())
                .reduce(BigDecimal.ZERO, (price1, price2)-> price1.add(price2));
    }
}

