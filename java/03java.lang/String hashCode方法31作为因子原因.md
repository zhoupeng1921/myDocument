#  String hashCode方法31作为因子原因

先看代码：

```java
public int hashCode() {
    int h = hash;
    if (h == 0 && value.length > 0) {
        char val[] = value;

        for (int i = 0; i < value.length; i++) {
            h = 31 * h + val[i];
        }
        hash = h;
    }
    return h;
}
```

上面的公式相当于：`val[0]*31^(n-1)+val[1]*31^(n-2)...val[n-1]`

1. 31可以被jvm优化：`31*i = (i<<5)-i`
2. 31是一个不大不小的质数，如果太小，会导致hash值散落在一个较小的区间，如果太大，它的幂可能会很大