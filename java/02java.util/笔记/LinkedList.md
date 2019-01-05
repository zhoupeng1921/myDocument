# LinkedList

## 介绍

  上一篇中ArrayDeque为数组实现的Deque，LinkedList为用链表实现的。

1. 双链表实现了List和Deque接口，允许元素为null
2. 不是线程安全的
3. 如果iterator已经构建，不通过iterator的remove或者add来改变链表，iterator将会跑出一个异常`ConcurrentModificationException`

## 源码分析

- 类中有三个变量

  ```java
      transient int size = 0;
  
      transient Node<E> first;
  
      transient Node<E> last;
  ```

  `first`指向链表的头

  `last`指向链表的尾

  看一下`Node`对象的构造

  ```java
      private static class Node<E> {
          E item;
          Node<E> next;
          Node<E> prev;
  
          Node(Node<E> prev, E element, Node<E> next) {
              this.item = element;
              this.next = next;
              this.prev = prev;
          }
      }
  ```

  `item`用来存储值的，`next`指向链表的下一个节点，`prev`指向链表的上一个节点，如果不是循环链表链表的头prev为null，链表的尾next为null

- `linkFirst`方法，在头部添加元素

  ```java
      private void linkFirst(E e) {
          final Node<E> f = first;
          final Node<E> newNode = new Node<>(null, e, f);
          first = newNode;
          if (f == null)
              last = newNode;
          else
              f.prev = newNode;
          size++;
          modCount++;
      }
  ```



  1. 创建一个newNode，newNode的next指向原来的头部元素，prev为null
  2. 另头部指针first指向newNode，newNode此时为新的头部元素
  3. 如果原来头部first为null，表示链表为null,此元素是链表第一个元素，此时尾部指针也指向这个元素
  4. 如果列表不为null，另原来头部元素的prev指向新添加的元素，构成双向链表
  5. 修改元素大小，修改修改的次数

- `linkLast`方法，在尾部添加元素

  ```
      void linkLast(E e) {
          final Node<E> l = last;
          final Node<E> newNode = new Node<>(l, e, null);
          last = newNode;
          if (l == null)
              first = newNode;
          else
              l.next = newNode;
          size++;
          modCount++;
      }
  ```

  1. 创建一个newNode，newNode的next为null，prev指向原来的尾部元素
  2. 另尾部指针指向新添加的元素
  3. 如果原来链表last为null，表示是空链表，此时头部也指向这个新添加的元素
  4. 如果原来链表不为null，原来链表尾部元素指向新添加的这个元素，构成双向链表
  5. 修改元素大小，修改修改的次数

- linkBefore方法，在某个元素前插入元素

  ```java
   void linkBefore(E e, Node<E> succ) {
          // assert succ != null;
          final Node<E> pred = succ.prev;
          final Node<E> newNode = new Node<>(pred, e, succ);
          succ.prev = newNode;
          if (pred == null)
              first = newNode;
          else
              pred.next = newNode;
          size++;
          modCount++;
      }
  ```

  入参表示，`e`要插入在`succ`节点之前

  1. 首先拿到`succ`节点的前一个节点`pred`
  2. 构造newNode对象，另新元素的next指向`succ`节点，prev指向`pred节点`，succ的prev指向新插入的节点
  3. 如果pred节点为null，表示succ节点为头结点，此时另头指针first指向新的节点
  4. 如果pred不为null，另pred的next指向新节点，通过2,3,4三步，把元素插入进来，构造成了一个双向链表
  5. 修改元素大小，修改修改的次数

- removeFirst方法，弹出头部元素

  ```java
  public E removeFirst() {
          final Node<E> f = first;
          if (f == null)
              throw new NoSuchElementException();
          return unlinkFirst(f);
      }
  private E unlinkFirst(Node<E> f) {
          // assert f == first && f != null;
          final E element = f.item;
          final Node<E> next = f.next;
          f.item = null;
          f.next = null; // help GC
          first = next;
          if (next == null)
              last = null;
          else
              next.prev = null;
          size--;
          modCount++;
          return element;
      }
  ```

  1. 首先拿到头部指针，判空一下，链表是否有元素，调用unlinkFirst方法，入参为头部指针的引用
  2. 获取头部指针的下一个节点，把头部指针的next指向空，item指向null（为了GC）
  3. 然后另头部指针first指向第二个节点，这样第二个节点就变成了头部节点
  4. 如果节点为null，证明原来链表只有一个元素，此时last也赋值null
  5. 如果节点不为null，把头结点的prev赋值null
  6. 修改元素大小，修改修改的次数
  7. 返回弹出的头部元素

- removeLast方法，弹出尾部元素

  ```java
    public E removeLast() {
          final Node<E> l = last;
          if (l == null)
              throw new NoSuchElementException();
          return unlinkLast(l);
      }
    private E unlinkLast(Node<E> l) {
          // assert l == last && l != null;
          final E element = l.item;
          final Node<E> prev = l.prev;
          l.item = null;
          l.prev = null; // help GC
          last = prev;
          if (prev == null)
              first = null;
          else
              prev.next = null;
          size--;
          modCount++;
          return element;
      }
  ```

  removeLast与removeFirst类似，只不过是操作的尾部节点

- `addFirst` 里面调用的linkFirst

  ```java
     public void addFirst(E e) {
          linkFirst(e);
      }
  ```

- `addLast` 里面调用的linkLast

  ```java
  public void addLast(E e) {
          linkLast(e);
      }
  ```


- unlink方法，删除一个节点

  ```java
  E unlink(Node<E> x) {
          // assert x != null;
          final E element = x.item;
          final Node<E> next = x.next;
          final Node<E> prev = x.prev;
  
          if (prev == null) {
              first = next;
          } else {
              prev.next = next;
              x.prev = null;
          }
  
          if (next == null) {
              last = prev;
          } else {
              next.prev = prev;
              x.next = null;
          }
  
          x.item = null;
          size--;
          modCount++;
          return element;
      }
  ```

  1. 获得被删除节点的上一个节点与下一个节点
  2. 如果上一个节点为null，则把头指针指向next节点，否则上一个节点的next指向下一个节点的next，当前节点的prev赋值null
  3. 如果next节点为null，则把尾指针指向prev节点，否则把next节点的prev指向上一个节点，当前节点的next赋值null
  4. 当前节点的item赋值null，修改元素大小，修改修改的次数
  5. 返回删除的节点