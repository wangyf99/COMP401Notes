# Java | 使用Scanner类
> Scanner是什么，Scanner是谁？Scanner是什么意思出自哪里？ 今天小编就来帮助大家了解一下Scanner到底是什么。  

java.util.Scanner 是Java 5的新特征，我们可以通过Scanner类获取用户输入并且对字符串进行各种操作。

需要使用Scanner的时候需要先import scanner：

`import java.util.Scanner;`

Import成功后便可以在 main 里面创建新的Scanner:

`Scanner scan = new Scanner(System.in);`

注：暂时不会讨论Scanner的parameter中输入其他内容的情况。
- - - -
对于上面定义的Scanner对象，它能够实时接收用户在Terminal中的输入，并且经过处理后直接输出到Terminal，演示如下：
<a href='Scanner_demo.mov'>Scanner_demo.mov</a> 
*如果这里失灵了的话直接看下面的文章也无所谓*
- - - -
上面演示的全部代码截图如下：

![](Java%20%7C%20%E4%BD%BF%E7%94%A8Scanner%E7%B1%BB/6F531EA9-591F-4A10-8166-33D1C0A830ED.png)

程序主体内容从第八行开始。但是第八行我们在文章开头介绍过，所以这里不再重述。

我们看到第十行: Declare & Initiate一个叫做next的变量，赋值内容为scan.next()
- - - -
### Scanner.next()方法

![](Java%20%7C%20%E4%BD%BF%E7%94%A8Scanner%E7%B1%BB/7B39E8F1-846B-4A72-BB62-2F158D286BD7.png)

我们首先看一下Oracle的官方文档。

简单来说，Scanner.next() 方法可以取得用户输入值，并且以*设定的delimiter*分隔 - 这里的delimiter我们目前可以不用考虑，默认的delimiter是空格。

下面我们先看几个简单的例子。

![](Java%20%7C%20%E4%BD%BF%E7%94%A8Scanner%E7%B1%BB/5E460E2F-4C4A-477D-9AAA-EC2F091F232B.png)

这一部分代码中，我们先调用next()方法获取输入值，然后直接打印出来：

![](Java%20%7C%20%E4%BD%BF%E7%94%A8Scanner%E7%B1%BB/EF3E4576-DA2B-4F3F-9BA4-C744D44CB0D1.png)

首先我们保存上述代码。
点击运行后，在Eclipse的Console中，我们可以看到光标在闪烁，代表我们需要在这里进行输入值。
在我们输入test之后，按下**回车**，就能看到test在console中print出来了。
在同样的代码中，我们可以再测试另外几个输入的例子。

![](Java%20%7C%20%E4%BD%BF%E7%94%A8Scanner%E7%B1%BB/73710AA6-5AD9-4D1D-995A-609D6E266A29.png)

在这一个例子中，我们对不同的输入之间添加了**空格**。输出的时候我们会发现，只有test1被print出来了。

这就涉及到我们刚才提到的delimiter了。
在前面的文章中，我们提到默认的delimiter是**空格** - 也就是说，对于输入的字符串，我们在其中寻找空格，然后用空格分开。
对于上面的例子而言，我们输入的字符串就会被Scanner自动分割为 “test1”, “test2”, “test3”, “test4”, “test5”。
而对于这些字符串，每次调用next()方法的时候，就会访问到下一个。
而我们前面的代码中，因为只调用了一次next()，所以只能拿到test1，也只会print test1。

如果我们将代码修改为如下这样：

![](Java%20%7C%20%E4%BD%BF%E7%94%A8Scanner%E7%B1%BB/CA1DA9AB-41F8-4AE2-9DAE-69F28CEC5C1A.png)

然后输入同样的内容：

![](Java%20%7C%20%E4%BD%BF%E7%94%A8Scanner%E7%B1%BB/73E2D4A1-DC4C-4D90-A657-11637885D7A6.png)

我们就能看到，输出了test1，test2和test3 - 因为前面调用了三次next()。

因此类推，我们在调用一次next() 的时候，就会print test4.

- - - -
### 小结

Scanner.next()方法可以得到下一个输入值

理解了Scanner.next()方法后，大家就可以尝试着理解一下前面演示的代码了。

### 注意事项

完成输入后记得按下回车，否则就算输入空格也是不会自动输入到Scanner中的。

这大概是因为Java中的`System.in`是以回车分隔的 - 也就是，按下回车后，就会创建一个新的输入，前一个输入的字符串就交给Scanner进行处理。

- - - -
## Scanner.nextInt() & Scanner.nextDouble()

讲解了Scanner.next() 方法后，我们就可以讲一讲Scanner.nextInt()和Scanner.nextDouble()了。

### Scanner.nextInt()

照例首先放Oracle官方文档：

![](Java%20%7C%20%E4%BD%BF%E7%94%A8Scanner%E7%B1%BB/FDEF95B5-6E02-495E-B737-378B72214508.png)

本方法返回值是一个int，针对输入值是 “单纯数字的组合” 且 “不超过int最大范围”的输入内容，并将其转换为int类型数据输出。我们可以测试一下：

![](Java%20%7C%20%E4%BD%BF%E7%94%A8Scanner%E7%B1%BB/925DDD43-FE68-4B08-BDAE-2F0C26E4FBDC.png)

同样，保存后运行：

![](Java%20%7C%20%E4%BD%BF%E7%94%A8Scanner%E7%B1%BB/B0CADA33-9E75-4687-874D-3F9A140946AB.png)

在上面的例子中，Scanner会将我们输入的内容加上2后输出整个等式到Terminal。
因此我们可以看到，如果我们输入1，加上2后输出为3。

那么，如果我们输入一个不是整数的内容会怎样呢？

![](Java%20%7C%20%E4%BD%BF%E7%94%A8Scanner%E7%B1%BB/09AC6D09-E1A3-4104-9B51-99294EB10EAA.png)

这时候就会报错InputMismatchException，可以通过报错信息定位到源代码中错误行数位置
（报错信息最后一行，at main(Main.java: 10) -> 错误发生在主程序第十行）

### Scanner.nextDouble()

Oracle官方文档：

![](Java%20%7C%20%E4%BD%BF%E7%94%A8Scanner%E7%B1%BB/82E3E8F1-727E-4E3C-814A-2963D57A03F4.png)

本方法返回值是一个double，针对 “输入值是多个数字与一个小数点” 且 “符合double类型要求”的输入，
并将其转换为double数据输出。同样写代码进行测试：

![](Java%20%7C%20%E4%BD%BF%E7%94%A8Scanner%E7%B1%BB/06BA2F41-0D59-45E7-8BF5-D0D1CAFE2AC5.png)

同样，保存后运行：

![](Java%20%7C%20%E4%BD%BF%E7%94%A8Scanner%E7%B1%BB/6D27B94C-6EC0-44BF-956A-92A2102627B8.png)

可以看到程序将输入值乘上了十倍，并且将整个等式进行输出。

*至于这里为什么是31.45000…003，是因为Java中的数据并不是**完全精准**的。
显示上我们的输入值是3.1415，但是实际Java在操作数据的时候，可能会出现小小的误差，导致最终打印出来的内容后面多了一点003。
这个问题可以通过String.format()方法对输出值进行格式化来解决。*

同样，如果输入一个其它内容，则会报错：

![](Java%20%7C%20%E4%BD%BF%E7%94%A8Scanner%E7%B1%BB/D3B83644-0B7B-422B-B116-8C2B94AEC65F.png)

但是，如果这里我们输入一个整数会怎么样呢？

![](Java%20%7C%20%E4%BD%BF%E7%94%A8Scanner%E7%B1%BB/08AF5212-AFD7-46DA-AD9B-5A7FA19D1F0C.png)

可以看到，这里**自动将整数转换为了一个double**。

- - - -
### 小结

nextInt()可以将输入值直接转化为整数数据类型，nextDouble()可以将输入值直接转化为double类型。

**代码请自己动手敲，本文不提供可用于复制粘贴的源代码**

> 好了，以上就是Scanner的含义和出处。希望小编精心整理的这篇内容能够解决你的困惑。  

#微信公众号
