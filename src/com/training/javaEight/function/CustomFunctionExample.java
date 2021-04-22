package com.training.javaEight.function;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class CustomFunctionExample {
    public static void main(String[] args){
        List<Product> productList = Arrays.asList(
                new Product(1L, "A", new BigDecimal("10.00")),
                new Product(2L, "B", new BigDecimal("55.50")),
                new Product(3L, "C", new BigDecimal("17.45")),
                new Product(4L, "D", new BigDecimal("23.00")),
                new Product(5L, "E", new BigDecimal("110.99"))
        );

        System.out.println("productList all ::> "+productList);
        System.out.println("productList price 20 upper ::> "+productList.stream().filter(product -> product.getPrice().compareTo(new BigDecimal("20.00")) > 0).collect(Collectors.toList()));

        List<DiscountedProduct> discountedProducts = productList.stream().filter(product -> product.getPrice().compareTo(new BigDecimal("50.00")) > 0).map(product -> {
             return new DiscountedProduct(product.getId(), product.getName(), product.getPrice().multiply(new BigDecimal("0.5")));
        }).collect(Collectors.toList());

        discountedProducts.forEach(System.out::println);

        Predicate<Product> lessThanOrEqualTo30Product = product -> product.getPrice().compareTo(new BigDecimal("30")) <= 0;
        System.out.println("discount product (<= $30) "+filter(discountedProducts, lessThanOrEqualTo30Product));

        //Product total
        System.out.println("Product list total :: "+total(productList, product -> product.getPrice()));

        //discount total
        System.out.println("discount list total :: "+total(discountedProducts, product -> product.getPrice()));
    }

    private static <T> List<T> filter(List<T> list, Predicate<? super T> predicate) { //discountProduct는 Product의 하위 클래스이다. discountProduct가 Product에 있는 값을 사용하기 위해서는 <? super T>로 super class의 값을 사용하겠다고 정의 한다.
        List<T> result = new ArrayList<>();

        for(T t :  list){
            if(predicate.test(t)){
                result.add(t);
            }
        }
        return result;
    }

    private static <T> BigDecimal total(List<T> list, Function<T, BigDecimal> mapper){
        BigDecimal total = BigDecimal.ZERO;
        for(T t : list){
            total = total.add(mapper.apply(t));
        }
        return total;
    }
}

class Product{
    private Long id;
    private String name;
    private BigDecimal price;

    public Product(){
    }

    public Product(Long id, String name, BigDecimal price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return new StringBuilder("Product{")
               .append("id=").append(id)
               .append(", name='").append(name).append('\'' )
               .append(", price=").append(price)
               .append('}').toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return Objects.equals(id, product.id) && Objects.equals(name, product.name) && Objects.equals(price, product.price);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, price);
    }
}

class DiscountedProduct extends Product{
    public DiscountedProduct(Long id, String name, BigDecimal price) {
        super(id, name, price);
    }
}
