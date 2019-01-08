# Deque

## 介绍

java.util.Deque是一种双向线性集合（The name <i>deque</i> is short for "double ended queue"），可以在两端对集合进行插入或者删除操作，所以既可以当队列(FIFO)，也可以当栈(LIFO)，Deque继承java.util.Queue。

java.util.Stack继承自Vector，已经过时了，不推荐使用

## 方法介绍

1. `void addFirst(E e);`

   头部添加一个元素，没有容量会抛出`IllegalStateException`异常

2. `void addLast(E e);`

   尾部添加一个元素，没有容量会抛出`IllegalStateException`异常

3. `boolean offerFirst(E e);`

   头部添加一个元素，没有容量时会返回false

4. `boolean offerLast(E e);`

   尾部添加一个元素，没有容量时会返回false

5. `E removeFirst();`

   头部移除一个元素，deque为空时会抛出异常`NoSuchElementException`

6. `E removeLast();`

   尾部移除一个元素，deque为空时会抛出异常`NoSuchElementException`

7. `E pollFirst();`

   头部移除一个元素，deque为空时返回`null`

8. `E pollLast();`

   尾部移除一个元素，deque为空时返回`null`

9. `E getFirst();`

   获取一个头部元素，不移除，deque为空时抛出异常`NoSuchElementException`

10. `E getLast();`

    获取一个尾部元素，不移除，deque为空时抛出异常`NoSuchElementException`

11. `E peekFirst();`

    获取一个头部元素，不移除，deque为空时返回`null`

12. `E peekLast();`

    获取一个尾部元素，不移除，deque为空时返回`null`

13. `boolean removeFirstOccurrence(Object o);`

    删除第一个与`o`相等的元素，删除成功返回true

14. `boolean removeLastOccurrence(Object o);`

    删除最后一个与`o`相等的元素，删除成功返回true
    


** Queue methods **


15. `boolean add(E e);`

    等价于 `addLast`

16. `boolean offer(E e);`

    等价于 `offerLast`

17. `E remove();`

    等价于 `removeFirst`

18. `E poll();`

    等价于`pollFirst` 

19. `E element();`

    等价于`getFirst`

20. `E peek();`

    等价于`peekFirst`

21. `boolean addAll(Collection<? extends E> c);`

    相当于每个元素分分别调用offer(E e)

** Stack methods **

22. `void push(E e);`

    相当于`addFirst`

23. `E pop();`

    相当于`removeFirst`

** Collection methods **

24. `boolean remove(Object o);`

    相当于 `removeFirstOccurrence`

25. `boolean contains(Object o);`

    是否包含某个元素

26. `int size();`

    deque的大小

27. `Iterator<E> iterator();`

    The elements will be returned in order from first (head) to last (tail)

28. `Iterator<E> descendingIterator();`

    The elements will be returned in order from last (tail) to first (head).