# Java | Binary Search Tree JUnit单元测试
> 单元测试是什么，单元测试是谁？单元测试是什么意思出自哪里？ 今天小编就来帮助大家了解一下单元测试到底是什么。  

单元测试在[这里](https://github.com/Elnifio/COMP401Notes/blob/master/Notes/Java%20%7C%20Binary%20Search%20Tree%20JUnit%E5%8D%95%E5%85%83%E6%B5%8B%E8%AF%95/JUnitMain.java)。

- - - -

- 使用方法

	- 将其下载到对应的文件夹中就能用了
	
- 使用的OO Signature

```Java
insert(String s) -> boolean;
remove(String s) -> boolean;
findMin() -> String;
findMax() -> String;
empty() -> boolean;
contains(String s) -> boolean;
size() -> int;
height() -> int;
```

- Axioms

```Java
insert: (insert success)?(True):(False)
remove: (remove success)?(True):(False)
findMin: (empty)?(null):(BST(min))
findMax: (empty)?(null):(BST(max))
empty: (size == 0)
contains: (contain s)?(True):(False)
size: BST(size)
height: BST(height)
```

- 注意事项

	- **单元测试全部通过并不代表程序完全成功运行，请务必自己排除其他疏漏内容**
	
	- **请根据实现要求自行更改单元测试内的对应测试内容**
	
	- **请根据OO Signature自行更改JUnit中的Method名**

- - - -

没有了。

> 好了，以上就是单元测试的含义和出处。希望小编精心整理的这篇内容能够解决你的困惑。  
