1. 必须是函数式接口，才可以使用lambda表达式
2. lambda表达式三种编写方式：
   1. expression:单条语句表达式 ()->表达式

   2. statement:语句块 ()->{}

   3. reference:方法引用：如果某个方法在结构上与lambda表达式中对应的方法匹配，那么就可以直接引用给lambda表达式。

      | 类型                 | 语法                        |
      | -------------------- | --------------------------- |
      | 基于实例方法引用     | object::methodName          |
      | 构造方法引用         | className::new              |
      | 基于参数实例方法引用 | className::methodName       |
      | 静态方法引用         | className::staticMethodName |

      