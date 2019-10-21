# Java | 浅谈 Java 中的 String Pool 机制
> String Pool是什么，String Pool是谁？String Pool是什么意思出自哪里？ 今天小编就来帮助大家了解一下String Pool到底是什么。  

通过上一篇文章我们可以知道，`==` 比较的是两个对象的**内存地址**，而`.equals()`方法则根据该类是否有提供合适的`.equals()`方法来决定比较内容。
与此同时，我们又知道，Java中的String实际上并不是真正意义上的String（比如Python自带的str类型），而是一个特殊的`char[]`。因此，实际上String在Java中是一个Reference Data Type -> 也就是说，如果我们直接比较两个不同的String的**内存地址**，返回的值应该是`false`。
我们在程序里面试试看：
![](Java%20%7C%20%E6%B5%85%E8%B0%88%20Java%20%E4%B8%AD%E7%9A%84%20String%20Pool%20%E6%9C%BA%E5%88%B6/A07B6A36-91EA-4035-A5BF-D06B2F243211.png)
在这一个例子中，我们让字符串变量 s1 s2 分别赋值 “abc” （第十三 & 十四行），然后使用 `==` 进行判断。既然 String 是 Reference Type，每一次初始化一个新的 String 的时候，理论上就是创建了一个新的 String 对象。因此，我们会期望这两个变量不指向同一个对象，也就是说**这两个对象的内存地址不相等**。所以，这里的 `a == b` 返回值应该是`false`。
我们来看一看程序运行的结果：
![](Java%20%7C%20%E6%B5%85%E8%B0%88%20Java%20%E4%B8%AD%E7%9A%84%20String%20Pool%20%E6%9C%BA%E5%88%B6/BB64C72B-C125-4AAD-B3E8-446C38C81C39.png)
我们可以看到，在这里s1是等于s2的。但是这是为什么呢？
实际上，Java 对于 String 的处理，并不是每次新建一个 String 就傻傻的创建一个新的字符串对象。而相反，Java 运行的时候，会创建一个 String Pool - 一个字符串的“池子”，保存了前面所有用过的字符串。在后续运行中，如果要新建一个新的字符串，则 Java 会在这个 Pool 里面进行寻找，看之前有没有这个字符串。如果有这串字符，则 Java 会将这个变量~直接指向这个字符串对象~。反之，则新建一个新的字符串对象。
上面例子画出 Environment Diagram 大概如下图：
![](Java%20%7C%20%E6%B5%85%E8%B0%88%20Java%20%E4%B8%AD%E7%9A%84%20String%20Pool%20%E6%9C%BA%E5%88%B6/bear_sketch@2x.png)
如上图所示，两个变量实际上**指向同一个对象**。
当然，对于两个不同的String，我们也可以对其画出 Environment Diagram：
![](Java%20%7C%20%E6%B5%85%E8%B0%88%20Java%20%E4%B8%AD%E7%9A%84%20String%20Pool%20%E6%9C%BA%E5%88%B6/bear_sketch@2x%202.png)
在上面的这个例子中，因为在 initialize b 变量的时候，Java 在整个 String Pool 中没有找到值为 `def` 的字符串，所以就新建了一个 String，值为 `def`，并且将b指向这个对象。
我们不难得出，`(b == a) == false`。
因此，我们也就能理解，为什么 String 在 Java 中必须是**不可变对象**的原因了。
- - - -
那么，这和`.equals()`有什么关系呢？
在讨论`.equals()`之前，我们先来看一下下面这个例子：
![](Java%20%7C%20%E6%B5%85%E8%B0%88%20Java%20%E4%B8%AD%E7%9A%84%20String%20Pool%20%E6%9C%BA%E5%88%B6/8504F7F3-2F33-4062-B6CE-37AB76412FE7.png)
运行结果如下：
![](Java%20%7C%20%E6%B5%85%E8%B0%88%20Java%20%E4%B8%AD%E7%9A%84%20String%20Pool%20%E6%9C%BA%E5%88%B6/5090D11A-28EB-4A64-B9DD-61C0C95D9A54.png)
字符串内容同样是`”abc”`，为什么这两个现在就不相等了呢？
这是因为，我们在使用`new String()`的时候，实际上是**强制创建了新的字符串对象**，因此，画出 Environment Diagram 如下所示：
![](Java%20%7C%20%E6%B5%85%E8%B0%88%20Java%20%E4%B8%AD%E7%9A%84%20String%20Pool%20%E6%9C%BA%E5%88%B6/bear_sketch@2x%203.png)
观察上面的图我们可以看出，不像上一个例子一样，a 和 b 此时并不指向同一个 String 对象。这时候我们如果用 `==` 来比较两个变量的内存地址，那么结果就是 false。
并且，这种 initialize 方式和顺序无关：
![](Java%20%7C%20%E6%B5%85%E8%B0%88%20Java%20%E4%B8%AD%E7%9A%84%20String%20Pool%20%E6%9C%BA%E5%88%B6/1E7E22A2-76E3-4963-A787-AAA47709CE85.png)
上面的代码运行后结果依然是 false。此时 a 的这个字符串被默认在整个 String Pool 中“没办法被搜索到”了，于是 b 在创建的时候，搜索了整个 Pool 都没有找到 ”abc”，就只能新建了。
那么，对于这种情况，我们应该如何比较这两个字符串的内容呢？此时就要用到`.equals()`方法了。
上一篇文章中我们讲到，对于`.equals()`方法，每个类都可以对其进行重写，使其并不是简单的`return (this == obj)`。在 Java 的 String 类中，也对这个方法进行了优化，使其并不比较内存地址，而是比较这两个字符串的内容，如下图所示：
![](Java%20%7C%20%E6%B5%85%E8%B0%88%20Java%20%E4%B8%AD%E7%9A%84%20String%20Pool%20%E6%9C%BA%E5%88%B6/BCAA25E5-FB9C-40F4-A57E-197EBFA85318.png)
运行结果如下：
![](Java%20%7C%20%E6%B5%85%E8%B0%88%20Java%20%E4%B8%AD%E7%9A%84%20String%20Pool%20%E6%9C%BA%E5%88%B6/81A759E7-825A-4E9C-847D-85E7B16DBB57.png)
因此我们可以看到，用`.equals()`方法进行比较的时候，并不是简单的比较两个字符串的内存地址，也因此不会被`new String()`影响。
- - - -
关于 String Pool 的内容（大概）就这么多？嗯……
如果本文章有问题请务必在公众号后台留言指出。

> 好了，以上就是String Pool的含义和出处。希望小编精心整理的这篇内容能够解决你的困惑。  


#微信公众号