



## Python编程学习笔记

> 创建：讯飞人工智能学院
>
> 时间：2020年2月21日

----

### 第一章 相关环境知识

1. Python安装之后，自带功能包：IDLE（Python自带代码编辑工具）、Python.exe（Python代码解释器）、Python Manuals（Python使用手册）、Python Module Docs（Python标准库帮助文档）

2. Python属于典型的带解释器的编程语言，初学编程使用IDLE即可；其他商业级的开发工具：

   1. EclipsePydev，适合熟悉eclipse的程序员使用
   2. PyCharm，免费社区版缺少远程开发数据库支持及Web开发框架支持等功能
   3. VIM神器
   4. Wing，有免费基本版和收费版
   5. Spyder，可免费使用
   6. VSCode，推荐

3. 程序注释

   1. 使用#号注释单行：`# this is our first programe!`
   2. 使用`'''注释多行'''`或者`"""注释多行"""`

4. 设置解释器为utf-8编码。在文件头部添加一行：`# -*-coding:UTF-8 -*-`,Python3之前的版本需要设置，Python3之后默认就是utf-8编码，不会有中文乱码问题，可以不用设置

5. Python标识符命名规则：字母、数字、下划线，且不能数字开头，python语言是大小写敏感的；其中以下划线开头的标识符有特殊含义，以单下划线开头的代表不能直接访问的类属性，需要类提供的接口进行访问；以双下划线开头的代表类的私有成员；以双下划线开头和结尾的代表Python里特殊方法专用的标识，如`__init__()`表示类的构造函数;

   ​	有效的Python标识符是任意长度的非空字符序列，其中包括一个引导字符以及0个或者多个后续字符，其中只要是Unicode编码的字符否可以充当引导符，所以Python中是可以起中文的标识符的；但是不能与关键字同名；

6. Python3 关键字

   ```python
   import keyword
   keyword.kwlist打印如下关键字列表：
   ['False', 'None', 'True', 'and', 'as', 'assert', 'async', 'await', 'break', 'class', 'continue', 'def', 'del', 'elif', 'else', 'except', 'finally', 'for', 'from', 'global', 'if', 'import', 'in', 'is', 'lambda', 'nonlocal', 'not', 'or', 'pass', 'raise', 'return', 'try', 'while', 'with', 'yield']
   ```

7. Python代码规范：《PEP8代码规范》

---

### 第二章 变量和简单数据类型

>学习重点：
>
>1. 变量
>2. 字符串
>3. 数字和运算符
>4. 数据类型转换

1. 变量定义与多个变量赋值，请打开IDLE输入如下语句进行实践

   1. ```python
      >>> a
      Traceback (most recent call last):
        File "<pyshell#3>", line 1, in <module>
          a
      NameError: name 'a' is not defined
      >>> a = 0
      >>> print(a)
      0
      >>> one = two = three = 10
      >>> print(one, two, three)
      10 10 10
      ```

      Python语言变量值的类型在赋值后才被隐性确定；基本变量类型包括：字符串、数字、列表、元祖、字典五大类

2. 字符串

   1. 字符串定义

      ```python
      >>> name = 'TOM'
      >>> name1 = "Jerry"
      >>> name2 = '''Sreck'''
      >>> print(name, name1, name2, '<Tom&Jerry>')
      TOM Jerry Sreck <Tom&Jerry>
      >>> name, name1, name2 = 'Tom', "Jerry", '''Sreck'''
      >>> print(name, name1, name2)
      Tom Jerry Sreck
      >>> text1 = '''这是多行文本
      可以不受行数限制
      主要是由于三单引号的作用'''
      >>> print(text1)
      这是多行文本
      可以不受行数限制
      主要是由于三单引号的作用
      ```

      ---

   2. 字符串基本操作

      1. 字符串读取，字符串每个字符串都有一个下标，下标从0开始

         1. 单下标读取：[下标]

         2. 切片：[左下标:右下标]，如name[4:6]，表示下标的范围为4<=X<6

            1. 其他切片形式：`[:右下标]`、`[左下标:]`、`[:]`

            2. 带步长的切片形式：`[左下标:右下标:步长]`

            3. 负数下标读取：表示从右到左读取第一个字符，如：

               ```python
               >>> name = 'Tom\'s cat!'
               >>> name[-2]
               't'
               ```

               注意：Python在采用下标读取其他对象值时，也统一采用上面的下标使用规则。如后面要介绍的数组、元祖等

         3. 使用下标超出字符串范围时，解释器会报错

      2. 字符串值合并：不同的字符串可以使用`+`加好来进行合并

      3. 字符串值修改：不能直接对字符串进行修改，必须重新进行拼接

         ```python
         >>> name = 'three cool cat'
         >>> new_name = name[:11] + 'dogs'
         >>> print(new_name)
         three cool dogs
         >>> name[3] = 'C'
         Traceback (most recent call last):
           File "<pyshell#46>", line 1, in <module>
             name[3] = 'C'
         TypeError: 'str' object does not support item assignment
         ```

      4. 字符串值删除：将整个字符串值删除，`del(name) #将会清除内存中的值`

      5. 其他常用操作：

         1. 获取字符串长度：`len(name)`,此函数可以用来获取字符串、列表、元组、字典的长度

         2. r/R原始字符串控制符号

            ```python
            >>> print('C:\back\name')
            C:ack
            ame
            >>> print(r'C:\back\name')
            C:\back\name
            ```

         3. 重复输出字符串：`print('Cat'*2)`

         4. 格式化字符串：`print("Tom's age is %d"%(age)) #%d为格式化整数`

      ---

   3. 数字和运算符

      1. 这里把数字分为：整数、浮点数、复数、布尔

      2. 用来进行数运算的算数运算符

         | 运算符 |        功能描述        |
         | :----: | :--------------------: |
         |   +    |           加           |
         |   -    |           减           |
         |   *    |           乘           |
         |   /    |         **除**         |
         |   %    |          取模          |
         |   **   |         幂运算         |
         |   //   | **取整除**(剥离操作符) |

      3. 自行练习相应的整数及浮点数的例子

         1. 对于Python有一点需要注意，赋值操作实际上是先创建一个对象来存储结果，然后再将对象的引用赋值给变量，而不是像其他编程语言一样直接修改变量指向的存储空间中的值：

         <img src="C:\Users\My\AppData\Roaming\Typora\typora-user-images\image-20200424190655555.png" alt="image-20200424190655555" style="zoom:80%;" />
   
         如下表示对象与引用的关系图：
   
      <img src="C:\Users\My\AppData\Roaming\Typora\typora-user-images\image-20200424190910701.png" alt="image-20200424190910701" style="zoom:80%;" />
   
      另外，操作符`+`与`+=`对字符串作用不一样，如下：
   
      <img src="C:\Users\My\AppData\Roaming\Typora\typora-user-images\image-20200424191202301.png" alt="image-20200424191202301" style="zoom:80%;" />
   
         > 也就是说使用+=时会创建一个新字符串，并且变量重新绑定新字符串的引用;
   
      4. 复数：由实部和虚部组成，形式为：a+bj
   
         ```python
         >>> (1-2j)*(2-3j)
         (-4-7j)
         ```
      ```
      
      > Why？我已忘记复数乘法规则，请自行补充
      
      5. 布尔运算：在Python中True和False来表示，注意首字母必须大写，否则报错，一般与and、or、not一起使用
      
         ```python
         >>> True and True
         True
      >>> True or False
         True
      >>> not False
         True
      ```
   
      6. 二进制运算
   
         ```python
         >>> 0b1110
         14
         ```
      >>> bin(14)
         '0b1110'
      ```
      
      二进制位运算符：
      
         | 运算符 | 运算规则 |
         | :----: | :------: |
         |   &    |  与运算  |
         |   \|   |  或运算  |
         |   ^    | 按位异或 |
         |   ~    | 按位反转 |
         |   <<   |  左移动  |
      |   >>   |  右移动  |
      
      > 可以使用前面介绍的二进制运算来练习这些运算符
      ```
   
   7. 赋值运算符：
   
         ```python
         +、+=、-=、*=、/=、%=、**=、//=、<<=、>>=、&=、|=、^=
      ```
   
   8. 逻辑操作符
   
      1. 身份操作符：`is`、`is not`，用于查看两个对象引用是否指向同一个对象；或者用于查看某个对象是否为None
   
         2. 比较运算符
   
            | 比较运算符 |   运算规则   |
            | :--------: | :----------: |
            |     ==     | 比较是否相等 |
            |     !=     | 比较是否不等 |
            |     >      |     大于     |
            |     <      |     小于     |
            |     >=     |   大于等于   |
            |     <=     |   小于等于   |
   
            比较运算符的优先级低于算数运算符、位运算符，但是高于逻辑运算符：`5+1>5 and True  #先计算5+1=6，再计算6>5得True，再计算True and True运算`
   
         3. 成员操作符：`in`、`not in `，用来测试成员关系，测试数据是否属于字符串、列表或元组
   
         4. 逻辑运算符：`and`、`or`、`not`，其中and与or使用short-circuit逻辑，返回值为决定结果的操作数，而不是返回默认的布尔类型，这一点与其他编程语言不同，如：`2 and 5`返回值决定此结果的5，而不是True，not运算符总是返回布尔结果；
   
      ---
   
   4. 数据类型转换
   
      ```python
      >>> int(3.2)
      3
      >>> int('10')
      10
      >>> float(10)
      10.0
      >>> float('10')
      10.0
      >>> complex(2,3)
      (2+3j)
      >>> complex('10')
      (10+0j)
      >>> str(5+2j)
      '(5+2j)'
      >>> bin(22)
      '0b10110'
      >>> oct(22)
      '0o26'
      >>> hex(22)
      '0x16'
      >>> chr(97)
      'a'
      >>> ord('a')
      97
      ```

---

### 第三章 条件分支与循环

1. if条件分支

   1. 格式一：单分支判断

      ```python
      if boolean_value1:
      	子代码模块1
      ```

   2. 格式二：双分支语句

      ```python
      if boolean_vlaue1:
      	子代码模块1
      else:
      	子代码模块2
      ```

   3. 格式三：多条件多分支判断

      ```python
      if boolean_value1:
      	子代码模块
      elif boolean_value2:
      	子代码模块2
      .......
      else:
      	子代码模块3
      ```
      
   4. 格式四：将一条if-else缩减为单一的条件表达式：

      ```python
      expression if boolean_expresseion else expression2
      例如：
      offset = 20
      if not sys.platform.startwith("win")
      	offset = 10
      简化之后是：
      offset = 20 if sys.platform.startwith("win") else 10
      ```

      

2. while循环

   1. while基本语法

      ```python
      while boolean_value1:
      	子代码模块1
      ```
      
   2. while-else结构

      ```python
      while boolean_value2:
      	子代码模块1
      else:
      	子代码模块2
      ```

      >  注：else分支用法很容易被迷惑，只要循环是正常终止的，else分支代码就会被执行；如果是由于break语句、或者其他返回语句、或者发生异常而跳出循环，else分支的代码则不会执行；
      >
      >  else的这个分支特点对while循环、for-in循环以及try-except都适用；

3. for语句基本语法

   1. 基本语法

      ```python
      for <variable> in <sequence>:
      	子代码模块1
      else:
      	子代码模块2 #为for循环语句正常结束时，再执行此对应的代码模块2
      ```

      sequence可以为数字序列，字符串，列表，元组，字典等

   2. 示例一：利用自定义集合对象实现for循环

      ```python
      >>> fish_record = '鲫鱼5条、鲤鱼8条、草鱼7条、黑鱼5条、乌龟1只'
      >>> i = 0
      
      >>> for var in fish_record:
              if var == '条':
                  i += 1
                  print(i)
      		
      1
      2
      3
      4
      ```

   3. 示例二：利用内建范围函数range()实现for循环

      ```python
      >>> for i in range(9): # range(9)是0-8的有序集合
              if i != 0:         # 0既不是奇数，也不是偶数
                  if i%2 == 0:
                      print('%d 是偶数'%(i))
      			
      2 是偶数
      4 是偶数
      6 是偶数
      8 是偶数
      ```

   4. range函数的另一种用法：

      ```python
      >>> for i in range(1, 5, 2):   # range(start, stop [,step])
      		print(i)
      	
      1
      3
      ```

4. 循环控制语句

   1. break

      ```python
      >>> cm = 'Tom, Jerry, Sreck!'
      >>> for i in range(len(cm)):
              if cm[i:i+3] == 'Tom':
                  print('Tom is %d'%(i))
                  break
              print('for 继续循环吗？%d次'%(i+1))
      	
      Tom is 0
      ```

   2. continue

      ```python
      >>> for i in range(9):
              if i%2 != 0:
                  continue
              print('%d 是偶数'%(i))
      	
      0 是偶数
      2 是偶数
      4 是偶数
      6 是偶数
      8 是偶数
      ```

5. 负责条件处理方法

   1. 成员运算符（in、not in）
   2. 身份运算符（is、is not）

---

### 第四章 列表与元组

1. 列表（List）是Python语言显著区别于其他语言的一种数据结构，是可变的序列，也是一种可以存储各种数据类型的集合，用中括号[]表示列表的开始和结束，元素之间用逗号进行分隔；列表中的每个元素提供一个对应的下标

2. 列表基本格式表示

   ```python
   >>> []
   []
   >>> test1 = []
   >>> len(test1)
   0
   >>> test2 = [2]
   >>> len(test2)
   1
   >>> test3 = [1, 2]
   >>> print(test3)
   [1, 2]
   ```

3. 列表不同数据类型元素成员

   ```python
   >>> testn = [1, 2, 3, 4]
   >>> len(testn)
   4
   >>> tests = ['Tom', 'John', 'Jim']
   >>> len(tests)
   3
   >>> testx = ['鲫鱼', 5, 8.5, '鲢鱼']
   >>> len(testx)
   4
   >>> testx1 = [1, 2, 3, tests]
   >>> len(testx1)
   4
   >>> print(testx1)
   [1, 2, 3, ['Tom', 'John', 'Jim']]
   ```

4. 列表的下标：也是从0开始

5. 列表的基本操作，只需要记住是使用`列表对象.方法名()`方式进行调用即可，编辑器会自动提示

   | 方法名称 |        方法功能描述        |
   | :------: | :------------------------: |
   |  append  |     在列表尾部增加元素     |
   |  clear   |          列表清空          |
   |   copy   |    复制生成另外一个列表    |
   |  count   |      统计指定元素个数      |
   |  extend  |      两个列表元素合并      |
   |  index   |     返回指定元素的下标     |
   |  insert  |    在指定位置插入新元素    |
   |   pop    | 删除并返回指定下标对应元素 |
   |  remove  |  删除最左边一个指定的元素  |
   | reverse  |      反转列表元素顺序      |
   |   sort   |     对列表元素进行排序     |

   > 1.del()方法可以删除列表某个下标的值，甚至整个列表对象
   >
   > 2.排序sort()方法
   >
   > ​	L.sort(key=None, reverse=False)，key为可选参数，表示预处理函数，默认排序是增序

6. 列表解析，Python语言为列表提供了基于列表本身的元素操作语句解析功能

   1. 语法如下：

      ```python
      [expression for inter_val in iterable]
      [expression for inter_val in iterable if cond_expr]
      ```

      ```python
      >>> Nums = [i**2 for i in range(11) if i>0] # 对集合除0的数做平方运算
      >>> print(Nums)
      [1, 4, 9, 16, 25, 36, 49, 64, 81, 100]
      ```

7. 使用列表实现冒泡排序及二分查找

---

1. 元组：元组与列表比较类似，但是还是有如下两点不同：

   1. 元组不能对元素进行变动，而列表可以

   2. 元组用小括号表示，列表用中括号表示

      ```python
      >>> ()
      ()
      >>> test1 = ()
      >>> len(test1)
      0
      >>> test2 = (1, 2, '1', 'a')
      >>> len(test2)
      4
      >>> test3 = (1,) # 元组中只有一个元素的时候最后要添加一个逗号避免歧义
      >>> type(test3)
      <class 'tuple'>
      ```

   3. 省略小括号的元组定义及使用

      ```python
      >>> name, age = 'Tom', 19
      >>> (name, age) # 执行带小括号的元组
      ('Tom', 19)
      >>> name, age  # 执行不带小括号的元组
      ('Tom', 19)
      >>> test4 = ('Jack', 4)
      >>> name1, age1 = test4
      >>> name1
      'Jack'
      >>> age1
      4
      ```

   4. 元祖的基本操作

      1. tuple()将列表转换为元组
      2. list()将元组转换为列表
      3. 其他相关方法可以编程时自行查看

---

### 第五章 字典数据类型

1. 字典的基本知识：字典是可变的无序集合，同时是一种以键值对基本元素的可以存储各种数据类型的集合，用大括号表示字典的开始和结束，元素之间用逗号分隔；键值对有键key和值value组成，中间用冒号分隔，如"Tom:29"

2. 基本格式

   ```python
   >>> {}
   {}
   >>> d1 = {'Tom':29}
   >>> len(d1)
   1
   >>> d2 = {1:'cat', 2:'car'}
   >>> len(d2)
   2
   ```

3. 字典的基本方法

   |  方法名称  | 功能描述                                 |
   | :--------: | :--------------------------------------- |
   |   clear    | 字典清空                                 |
   |    copy    | 复制生成另外一个字典                     |
   |  fromkeys  | 使用给定的键建立新的字典，默认值None     |
   |    get     | 根据键返回值，不存在返回None             |
   |   items    | 以元组中包含数组的方式返回键值元素       |
   |    keys    | 类似列表形式返回字典中的键               |
   |    pop     | 删除指定元素并返回指定键对应的值         |
   |  popitem   | 随机返回元素并删除元素                   |
   | setdefault | 当键不存在设置键值对，存在则获取对应的值 |
   |   update   | 利用一个字典更新另一个字典               |
   |   values   | 类似列表的形式返回字典中的值             |

   > 字典对象没有提供排序功能，是无序的，主要是因为字典内部结构由哈希表构成的，这是区别于列表、元组的明显地方；
   >
   > 列表、元组元素允许重复,字典不允许重复;

   1. 字典元素增加

      1. 利用赋值给字典增加元素

      ```python
      >>> d1 = {'Tom':2, 'Jim':5}
      >>> d1['Mike'] = 8
      >>> d1
      {'Tom': 2, 'Jim': 5, 'Mike': 8}
      ```

      2. 利用setdefault()给字典增加元素

      ```python
      >>> d1 = {'Tom':2, 'Jim':5, 'Mike':9}
      >>> d1.setdefault('Alice'， 10)
      10
      >>> d1
      {'Tom': 2, 'Jim': 5, 'Mike': 9, 'Alice': 10}
      ```

      > 若新增的键值已经存在则显示已经存在的键值

   2. 字典值查找

      1. 字典名字+[key]查找

      ```python
      >>> d1 = {'Tom':2, 'Mike':5}
      >>> d1['Mike']
      5
      ```

      > 如果key不存在，则执行结果会报错

      2. 利用get(key)查找指定的键名，如果不存在返回空值，比较符合实际需求

   3. 字典值修改

      1. 利用赋值修改键值：`d1['Mike'] = 10`，需要确保字典中存在此键值对，否则就变成了新增
      2. 利用update()更新键值

      ```python
      >>> d1 = {'Tom':2, 'Jim':5, 'Mike':8}
      >>> d2 = {'Tom':10, 'Jack':9}
      >>> d1.update(d2)
      >>> d1
      {'Tom': 10, 'Jim': 5, 'Mike': 8, 'Jack': 9}
      ```

   4. 字典元素的删除

      1. 利用del()删除：`del(d1['Tom'])`

      2. 利用pop()删除：`d1.pop('Mike')`  # 返回值为键对应的值

      3. popitem()方法：随机返回键值对元组，并在字典中删除对应的元素

         > 上述几个删除方法若元素不存在则会报错

   5. 字典遍历操作

      1. 遍历所有的键值对

      ```python
      >>> d1 = {'Tom':10, 'Jim':5, 'Mike':11, 'Jack': 12}
      >>> for get_L in d1.items():
      	print(get_L)
      	
      ('Tom', 10)
      ('Jim', 5)
      ('Mike', 11)
      ('Jack', 12)
      ```

      2. 遍历所有的键

         1. 利用字典变量循环遍历

         ```python
         >>> d1 = {'Tom':1, 'Mike':2, 'Jack':3}
         >>> for key in d1:
         	print(key)
         
         Tom
         Mike
         Jack
         ```

         2. 利用keys()方法获取字典键

         ```python
         >>> d1 = {'Tom':1, 'Mike':2, 'Jack':3}
         >>> for key in d1.keys():
         	print(key)
         	
         Tom
         Mike
         Jack
         ```

      3. 遍历所有的值

         1. 通过键遍历值

         ```python
         >>> d1 = {'Tom':1, 'Mike':2, 'Jack':3}
         >>> for key in d1:
         	print(d1[key])
         
         1
         2
         3
         ```

         2. 通过values()获取值

         ```python
         >>> d1 = {'Tom':1, 'Mike':2, 'Jack':3}
         >>> for value in d1.values():
         	print(value)
         
         1
         2
         3
         ```

      4. python3中复制copy()是深度复制，会产生两个完全不一样的变量

      5. fromkeys(列表对象)方法：将列表值作为字典的键值，键值对的值为None

      ```python
      >>> d8 = {}.fromkeys(['pen', 'rule', 'paper'])
      >>> d8
      {'pen': None, 'rule': None, 'paper': None}
      ```

      > 这个功能可以用于获取商品列表，但是价格还没有确定的情况

   6. 字典嵌套

      1. 字典的键可以是简单的数字、字符串，也可以是元组；其对应的值可以是Python语言支持的任何类型，一般主要有字典嵌入字典、列表嵌入字典、字典嵌入列表三种情况

---

### 第六章 函数

1. 函数基本定义

   ```python
   def 函数名([参数]):
   	函数体
   	[return 返回值]
   ```

   Python中函数不能先调用再定义，否则会提示找不到函数定义错误；

2. 不带参数函数

3. 带简单参数函数

4. 带返回值函数

   1. 如果函数中没有明显的return返回值，则默认返回None
   2. 带返回参数的例子

   ```python
   #!/usr/bin/env python3    #告诉Linux/OS X系统，这是一个Python可执行程序，Windows系统会忽略这个注释
   # -*- coding: utf-8 -*-   #告诉Python解释器，按照UTF-8编码读取源代码，否则，你在源代码中写的中文输出可能会有乱码
   
   # 带返回值的求因数函数案例
   def find_factor(nums):
       i = 1
       str1 = ''
       while i <= nums:
           if nums%i == 0:
               str1 = str1 + ' ' + str(i)
           i+=1
       return str1
   
   num2_L = [10, 15, 18, 25]
   i = 0
   num_len = len(num2_L)
   return_str = ''
   
   while i < num_len:
       return_str = find_factor(num2_L[i])
       print('%d 的因数是：%s' % (num2_L[i], return_str))
       i+=1
   # 结果
   10 的因数是： 1 2 5 10
   15 的因数是： 1 3 5 15
   18 的因数是： 1 2 3 6 9 18
   25 的因数是： 1 5 25
   ```

5. 自定义函数的完善（为函数增加说明文档）,新建一个文件用于函数的定义，如下：

   ```python
   def find_factor(nums):
       '''
       find_factor是自定义函数
       :param nums: 一个正整数参数
       :return: 以字符串形式返回一个正整数的所有因数
       '''
       i = 1
       str1 = ''
       while i <= nums:
           if nums % i == 0:
               str1 = str1 + ' ' + str(i)
           i += 1
       return str1
   
   help(find_factor) # 调用help可以查看函数的帮助信息
   
   结果：
   Help on function find_factor in module __main__:
   
   find_factor(nums)
       find_factor是自定义函数
       :param nums: 一个正整数参数
       :return: 以字符串形式返回一个正整数的所有因数
   ```

6. 给方法参数的处理增加健壮性，进行参数合理性的校验

   ```python
   # 在上面的find_factor函数中添加如下：
   if type(nums) != int:
   	print('输入值类型错误，必须是整数')
   	return
   if nums <= 0:
   	print('输入值范围出错，必须是正整数')
   	return
   ```

7. 把方法放入到模块中，这样在任何地方都可以复用此方法

   1. 建立一个空白文件test_function.py，存放自定义函数代码；若有多个自定义函数，按照顺序复制保存即可

   2. 调用函数模块

      1. 用import导入整个函数模块

      ```python
      import test_function  # 导入模块
      print(test_function.find_factor(8)) # 调用：模块名.函数名
      ```

      2. 用import导入指定函数

      ```python
      from test_function import find_factor
      print(find_factor(8))
      ```

      3. 用import语句导入所有函数：`from test_function import *`
      4. 模块名、函数名别名方式

      ```python
      import test_function as t1
      print(t1.find_factor(8))
      ```

   3. 模块搜索路径

      ```python
      import sys
      sys.path[0] = 'D:\Python\第六章\\function' #临时增加
      from test_function import *
      
      print(find_factor(8))
      ```

---

#### 自定义函数进阶

1. 多种形式的参数

   1. 位置参数：就是在传递参数时，必须和函数定义的参数一一对应，是最常用的一种方式

   2. 关键字参数

      1. 为了避免传递值出错，可以使用"参数名=值"的形式来传参，无需考虑参数的位置顺序

      2. 部分参数指定则优先指定右边的参数

         ```python
         test1(name = 'John', age = 20)
         test1('John', age = 20)
         ```

   3. 默认值参数：为参数预先指定默认值

      ```python
      def test1(name='', age = 20):  # 设置默认参数是从右边开始
      	print('姓名%s, 年龄%s'%(name, str(age)))
      test1(18) # 默认是给第一个默认的参数赋值
      test1()
      ```

   4. 变长参数*、**

      1. 传递任意数量的参数值：函数名([param1, param2, ...]*paramX)，变长参数只能放在最右边

         ```python
         def watermelon(name, *attribute):
             description = ''
             for get_i in attribute:
                 description = description + ' ' + get_i
             print(description)
         
         watermelon('西瓜', '甜瓜', '圆形', '甜')
         结果：
         甜瓜 圆形 甜
         ```

      2. 传递任意数量的键值对：函数名([param1, param2, ...]**paramX)

         ```python
         def watermelon(name, **attribute):
             print(name)
             print(attribute)
             return attribute
         
         watermelon('西瓜', taste='甜', shape='圆形', color='绿色')
         结果：
         西瓜
         {'taste': '甜', 'shape': '圆形', 'color': '绿色'}
         ```

2. 传递元组、列表和字典：由于Python函数参数没有类型，所有同一个函数可能既可以接收元组类型参数，也可以接收列表和字典参数

   1. 自定义函数获取到传递过来的参数之后，在函数内部对他们的元素进行改变，则会同步影响函数外部传递的原始对象

      ```python
      def editFruit(name, attribute):
          attribute[0] = attribute[0]*0.9
          return attribute
      
      attri_L = [21, '甜', '圆形', '绿色']
      get_L = editFruit('西瓜', attri_L)
      print(get_L)
      print(attri_L)
      结果：
      [18.900000000000002, '甜', '圆形', '绿色']
      [18.900000000000002, '甜', '圆形', '绿色']
      ```

      > 对于列表、字典类型，函数内外是同一个对象，修改值会同步变化；元组、字符串属于不可变对象，在函数中进行修改之后会变成新的对象

   2. 如何让函数内外的列表和字典对象不是同一个？

      1. 可以使用copy()函数：`get_L = editFruit('西瓜', attri_L.copy())`
      2. 也可以通过设置下标的方式获取**列表对象**的副本

3. 函数与变量作用域

   1. 只有清楚了变量的作用范围，编写的程序才不会逻辑混乱

   2. 全局变量与局部变量

      ```python
      j = 5
      def sum1(i):
      	i = i+j # 不建议直接使用全局变量，建议通过参数进行传递
      	return i
      i = 8
      ```

   3. global关键字：函数内部默认只能读取全局变量的值，若需要修改全局变量，则需要使用global关键字进行事先声明，否则在函数内修改全局变量会报错

      ```python
      j = 5
      k = 2
      def sum1():
      	global j
      	j = j + 5
      	k = 4
      	return k
      print('全局变量k的值为%d，函数返回局部变量k的值为%d' % (k, sum1()))
      print('全局变量j修改后的值为%d' % (j))
      结果：
      全局变量k的值为2，函数返回局部变量k的值为4
      全局变量j修改后的值为10
      ```

      > 此处只是一个演示，平时不鼓励采用该方法传递值及修改值

   4. 闭包（Closure）的概念

      1. 闭包是介于全局变量和局部变量之间的一种特殊变量

      ```python
      j = 5
      def sum0():
      	k = 2			# 闭包变量k
      	def sum1():		# 嵌套的内部函数sum1
      		i = k + j	# 局部变量i
      		return i
      	return sum1()
      print('调用sum0()结果 = %d' % sum0())
      结果：
      调用sum0()结果 = 7
      ```

      > 三种变量范围：全局变量 > 闭包变量 > 局部变量，闭包变量定义位置在外部函数与内部嵌套函数之间

   5. nonlocal关键字

      1. 要在sum1函数中修改上述代码闭包变量k，则需要事先用nonlocal关键字声明k，才能对他进行修改操作；修改的结果k也变成函数sum1的局部变量，一般不鼓励使用此方法传递和修改值

   6. 匿名函数：Python使用lambda来创建匿名函数，即定义的函数没有名称

      1. 匿名函数语法：`lambda [para1, para2, ...]:expression`

         > 1. lambda后面没有跟函数名，这就是匿名函数名称的由来
         > 2. 参数是可选的
         > 3. expression实现匿名函数的功能，并返回操作结果
         > 4. 整个匿名函数在一行内实现所有定义

         ```python
         a = lambda x, y:x*y		# 定义匿名函数并赋值给a
         print(a(2, 3))			# a具有匿名函数的功能，通过参数传值
         结果：
         6
         ```

   7. 递归函数

---

### 第七章 类

1. 为什么要引入类

2. 类的定义格式示例：`BoxClass.py`

   ```python
   class Box1():
       '''求立方体的类'''
       # self用于传输实例对象地址
       def __init__(self, length1, width1, height1):	# 构造方法，self参数隐性传递
           self.length = length1		# 属性定义
           self.width = width1
           self.height = height1
   
       def volume(self):			# 方法定义，必须提供self参数，佛足额不能被类实例调用
           return self.length * self.width * self.height
   
   my_box1 = Box1(10, 10, 10)
   print('立方体的体积是 = %d' % my_box1.volume())
   结果：
   立方体的体积是 = 1000
   ```

3. 实例定义与属性、方法的调用

4. 属性

   1. 属性值的初始化
   2. 属性值修改：直接使用实例进行属性修改、通过方法进行修改

5. 把类赋值给属性

   ```python
   class Color1():
       def __init__(self, index = 0):
           self.set_color = ['white', 'red', 'black', 'green']
           self.index = index
       def getColor(self):
           return self.set_color[self.index]
   
   class Box1():
       def __init__(self, length1, width1, height1, c1 = 0):
           self.length = length1
           self.width = width1
           self.height = height1
           self.color = Color1(c1).getColor()      # 创建Color1类实例
   
       def volume(self):
           return self.legnth * self.width * self.height
   
   my_box1 = Box1(10, 10, 10, 1)
   print(my_box1.color)
   结果：
   red
   ```

6. 类改造的问题：此时需要考虑类的继承和方法的重写问题

   1. 继承语法：

      `class 子类名(父类名1, 父类名2, ....)`

      ```python
      class Box1():
          def __init__(self, length1, width1, height1):
              self.length = length1
              self.width = width1
              self.height = height1
          def volume(self):
              return self.length * self.width * self.height
      #===========================================================
      class Box2(Box1):                                 # 继承
          def __init__(self, length1, width1, height1): # 子类重新定义__init__
              super().__init__(length1, width1, height1)# super实现父类与子类的关联
              self.color = 'white'        # 增加颜色属性
              self.material = 'paper'     # 增加材质属性
              self.type = 'fish'          # 增加类型属性
          def area(self):
              re = self.length*self.width + self.height*self.length + self.width*self.height       
              return re*2
         	def volume(self, num=1):	# 子类重写父类的方法，只要求函数名称与父类相同即可
              return self.length*self.height*num
      my_box2 = Box2(10, 10, 10)
      print('立方体的体积是 = %d' % my_box2.volume(5))
      print('立方体表面积是 = %d' % my_box2.area())
      结果：
      立方体的体积是 = 1000
      立方体表面积是 = 600
      ```

      > Python2.7中类的继承语法不一样

   2. 重写方法:当程序员发现父类的方法不能满足需求时，就需要子类重写方法，具体见上述例子

7. 私有

   1. 有些程序员想自己设计的类内变量或者方法只允许这个类访问，可以让类内变量或者函数变成私有的即可
   2. 在方法的名称或者属性名字前面增加两个下划线即可 ：`__`

8. 把类放入到模块中

   1. 封装成模块可以实现世界所有人共同使用
   2. 与建立类模块的过程一模一样，
      1. 新建模块文件如：`Class_module.py`
      2. 把调试好的自定义类放入文件中
      3. 调用方式为：`fromClass_module import *`

9. 静态类

   1. 静态类与动态类的区别为：

      1. 静态类内没有self关键字，即不能被实例化
      2. 静态类不能通过类名传递参数
      3. 静态类不支持`__init()__`初始化函数
      4. 静态类不能真正的被实例化，但它可以集成变量或函数，是一个带结构的数据类型

      ```python
      class OneStaticClass():
      	name = 'Tom'
      	age = 20
      	
      	def aa():
      		print('aa()')
      ```

      > 使用方式：
      >
      > 1. 调用属性和方法：OneStaticClass.aa()
      > 2. 修改属性：OneStaticClass.name = 'Jack'

10. 可以在类内引用外面已经定义的函数，可以供类直接使用

---

### 第八章 标准库

1. Python在安装时自带标准库，标准库为程序员提供了大量的函数和类功能，掌握标准库是程序员必须认真对待的一项内容；掌握了标准库会让编程更加容易，更重要的是可以节省时间并提高编程质量，是一件非常有意义的事情

2. 内置对象及部分常见模块

   | 内置对象名称 | 说明               |
   | ------------ | ------------------ |
   | 内置函数     | print()等函数      |
   | 内置常量     | True、False等      |
   | 内置类型     | 各种数据类型及操作 |
   | 内置异常     | 后面介绍           |

   | 模块分类     | 模块名称 | 说明                 |
   | ------------ | -------- | -------------------- |
   | 数据类型     | datetime | 日期时间模块         |
   | 数字和数学   | math     | 数学函数模块         |
   | 数字和数学   | random   | 伪随机数模块         |
   | 通用系统服务 | os       | 系统相关接口模块     |
   | 通用系统服务 | sys      | 系统特定的参数和功能 |
   | 通用系统服务 | time     | 时间访问和转换模块   |

   > 详细用法参考官网：https://docs.python.org/3.6/library/index.html

3. datetime模块：用于表示日期时间、日期和时间等相关功能的操作

   ```python
   from datetime import datetime, date, time
   
   print(datatime.now())
   today = datetime.now()
   print(datetime.date(today))
   
   date1 = date(2020, 2, 23)
   time1 = time(20, 53, 48)
   ....
   ```

   > strftime()方法和strptime()方法的时间日期格式化符号功能非常强大

4. math模块

   ```python
   import math
   math.trunc(x)
   ...
   ```

5. random模块

   1. random()：生成一个基于[0.0, 1.0)之间的浮点数
   2. uniform(a, b)：指定范围内的随机数[a, b]
   3. triangular(low, high, mode)：返回三角形的随机分布
   4. betavariate()：求Beta分布的随机数
   5. 其他方法参照官方文档

6. os模块

7. sys模块

8. time模块：除了提供时间相关的函数之外，还有一些系统延迟相关的函数，如：sleep(s)等

9. 当模块文件多了之后，如何创建包来进行管理？

   1. 建立顶级目录，如package1，然后在此目录放置一个`__init__.py`的空文件，主要是说明该文件的目录是一个包目录；该顶级包目录的名称就是包的名称

   2. 把模块文件放到包中，也可以在包中建立子文件夹如Cat，存放对应的模块文件Cat_Main.py模块文件，则导入包模块方式为：`import package1.Cat.Cat_Main as CatMain`；

   3. 上面的方法一次只能导入一个模块，如果想同时导入包中所有的模块，则需要编辑`__init__.py`文件，在其中加入如下一句：

      ```python
      __all__ = ["Bmp", "Jpeg", "Png", "Tiff"]
      ```

      然后在使用导入语句是：`from package1 import *`即可将包中的模块全部导入；

   4. 如果包中存在子包，则结构一样，导入时使用点号`.`号进行连接，如：`import Graphics.Vector.SVG as SVG`;

   5. 写完一个模块之后，如果想测试一下代码功能，则可以在模块底部编写如下代码进行简单的使用方法演示及测试：

      ```python
      if __name__ == "__main__":
      	import doctest
      	doctest.test_method()
      ```

      > 注：上面代码不影响模块被加载的原因是，模块被其他模块导入的时候Python将为此模块创建一个名为`__name__`的变量，并将其值设置为模块的名字，所以被导入的时候上面代码的if条件并不满足，不会影响模块的导入；但是在单独执行此模块.py文件时，Python会将`__name__`的值设置成`__main__`，此时if条件满足，可以单独执行测试；

   6. 可以通过设置sys.path临时增加搜索路径，或存放于Python默认搜索路径下；

   7. 第三方开发者提供的软件包多是以包的形式提供的，如：https://pypi.python.org/pypi

   8. 安装Python目录下的lib文件夹中包含相关标准库的源码， 可以参考世界级的高手都是怎么写程序的

---

### 第九章 异常

1. 程序中常见的错误：

   1. 低级错误：代码语法出错
   2. 中级错误：代码存在隐性错误，如错误传参导致程序错误
   3. 高级错误：软件面对不确定性的异常错误，如突然断网、数据库宕机等等

2. 异常捕捉基本语法：

   ```python
   try:
   	代码模块1
   except:
   	代码模块2
   ```

   > 执行流程如下：
   >
   > 1. 先执行try语句，代表捕捉异常机制开启
   > 2. 执行代码模块1，若没有异常，忽略后续except及代码模块2，代码正常执行完毕
   > 3. 若在执行代码模块1中发生异常现象，则终止代码模块1剩余代码的执行，转到except处
   > 4. except关键字捕捉到异常信息，并执行代码模块2

3. 带finally子句的异常处理：finally关键字后面的代码模块，不论代码1是否有异常都会执行

   ```python
   try:
   	代码模块1
   except expression_type as err:
   	代码模块2
   else:
       代码块3   #如果try块代码正常执行完毕，则会执行else代码块
   finally:
   	代码模块4  # finally代码块最后总是会被执行，不管是否有异常发生
   如：
   import sys
   try:
       1/0
   except (IOError, OSError) as err:
       print(err) # err变量包含详细的错误信息
       print('除数不能为0')
       sys.exit()   # 此处虽然强制退出，但是finally子句还是会执行
   finally:
       print('程序执行结束')
   ```

4. 捕捉特定的异常信息：`except(Excep1, [Excep2, Excep3, ...])`

   ```python
   try:
   	i += 1
   except NameError as err:
       print(err)
   	print('NameError')
   #=========================================
   try:
   	i += 1
   except(NameError, TypeError):
   	print('some error')
   ```

   > 使用特定异常来判断程序代码出错问题，在实际项目中很少使用，都知道要出什么错误了，为什么不修改代码呢？
   >
   > 所以这里只是熟悉出错类的使用功能；

5. 抛出异常：使用raise关键字，不带参数的触发`raise`或者 `raise TypeError('i类型错误')`

6. 自定义简单的异常

   1. 格式：`class ExceptionnName(baseException): pass`
   2. 例如：

   ```python
   class FoundException(Exception): pass
   
   try:
   	for row, record in enumerate(table):
   		for column, field in enumerate(record):
   			for index, item in enumetate(field):
   				if item == target:
   					raise FoundException()
   except FoundException:
   	print("found in ({1}, {1}, {2})".format(row, column, index))
   else:
   	print("not found")
   ```

   

---

### 第十章 文件处理

#### 1. 文件读写

1. ###### 文件操作基本规则

   1. 文件名称一般以英文、数字、汉字开头易于阅读

   2. 转移字符可以使用反斜杠，或者r或R添加原始符号限制

   3. 指定的文件路径必须存在，否则报错

      ```python
      newfile = './t1.txt'
      
      b_new_file = open(newfile, 'w')
      b_new_file.close();
      print('创建文件成功%s' % newfile)
      ```

      打开模式：

      | mode参数值 | 功能描述                                       |
      | ---------- | ---------------------------------------------- |
      | r          | 以只读方式打开已经存在的文件                   |
      | w          | 以可写方式打开，若不存在则建立新文件           |
      | x          | 以可写方式建立一个新文件                       |
      | a          | 追加方式打开一个文件，若文件不存在则建立新文件 |
      | b          | 二进制模式                                     |
      | t          | 文本模式                                       |
      | +          | 以读写方式打开一个文件                         |
      | U          | 通用换行符模式（不建议使用）                   |

      *模式可以进行组合*

   4. 写入方法：f.write(str)

   5. 读取方法：f.read([size])，size是可选的，用于指定读取的字节数，如果省略则尽可能读取多的内容，可以连续调用read方法来读取

   6. 行读取：f.readline([size])，s表示可选参数读取字节大小

      1. f.readlines()可以列表结果形式一次读取多行

   7. 在指定位置读取

      1. f.tell()方法返回当前文件操作指示器所在的字节偏移位置；
      2. f.seek(offset [, whence])，offset参数设置位置的偏移量，whence确定文件起始位置：SEEK_SET代表从文件开头读取；SEEK_CUR表示当前位置；SEEK_END表示文件尾；

2. ###### 文件操作异常处理

```python
f_n = r'd:\t3.txt'

try:
    f = open(f_n, 'r')
    print(f.read())
except:
    print('打开文件%s出错，请检查' % f_n)
finally:
    if f:
        f.close()
        print('文件做关闭处理')
    else:
        print('程序关闭')
```

​	每次都写文件关闭太麻烦了，Python中引入了`with`语句来自动调用`close()`方法

```python
whith open(r'd:\t3.txt') as f:
	print(f.read())
```

> 调用read()会一次性读取文件所有内容，如果文件有20G，内存就爆了，所以一般保险操作是反复调用read(size)函数，分多次每次只读取size个字节；另外，调用readline()可以每次读取一行内容；调用readlines()可以一次读取所有内容并按行返回list结构，具体根据情况进行选择。

```python
for line in f.readlines():
	print(line.strip()) # 删除末尾的\n
```

3. ###### file-like Object

   1. 像`open()`函数返回的这种有个`read()`方法的对象，在Python中统称为file-like Object。除了file外，还可以是内存的字节流，网络流，自定义流等等。file-like Object不要求从特定类继承，只要写个`read()`方法就行。
   2. `StringIO`就是在内存中创建的file-like Object，常用作临时缓冲，稍后介绍。

4. ###### 字符编码

   1. 要读取非UTF-8编码的文本文件，需要给`open()`函数传入`encoding`参数，例如，读取utf-8编码的文件：

   ```python
   f = open(r'd:\a.txt', 'r', encoding = 'utf-8')
   f.read()
   ```

   > 遇到有些编码不规范的文件，你可能会遇到`UnicodeDecodeError`，因为在文本文件中可能夹杂了一些非法编码的字符。遇到这种情况，`open()`函数还接收一个`errors`参数，表示如果遇到编码错误后如何处理。最简单的方式是直接忽略，追加参数：errors='ignore'

5. ###### 写文件
   1. 写文件和读文件是一样的，唯一区别是调用`open()`函数时，传入标识符`'w'`或者`'wb'`表示写文本文件或写二进制文件
   2. 你可以反复调用`write()`来写入文件，但是务必要调用`f.close()`来关闭文件。当我们写文件时，操作系统往往不会立刻把数据写入磁盘，而是放到内存缓存起来，空闲的时候再慢慢写入。只有调用`close()`方法时，操作系统才保证把没有写入的数据全部写入磁盘。忘记调用`close()`的后果是数据可能只写了一部分到磁盘，剩下的丢失了。所以，还是用`with`语句来得保险：

   ```python
   with open('/Users/michael/test.txt', 'w') as f:
       f.write('Hello, world!')
   ```

   > 要写入特定编码的文本文件，请给`open()`函数传入`encoding`参数，将字符串自动转换成指定编码；
   >
   > 另外，以`'w'`模式写入文件时，如果文件已存在，会直接覆盖（相当于删掉后新写入一个文件）

---

#### 2. StringIO

1. StringIO顾名思义就是在内存中读写字符串数据

2. 写入StringIO

   要把str写入StringIO，我们需要先创建一个StringIO，然后，像文件一样写入即可：

   ```python
   >>> from io import StringIO
   >>> f = StringIO()
   >>> f.write('hello')
   5
   >>> f.write(' ')
   1
   >>> f.write('world!')
   6
   >>> print(f.getvalue()) # 获取写入后的str
   hello world!
   ```

3. 读取StringIO

   ```python
   >>> from io import StringIO
   >>> f = StringIO('Hello!\nHi!\nGoodbye!')
   >>> while True:
   ...     s = f.readline()
   ...     if s == '':
   ...         break
   ...     print(s.strip())
   ...
   Hello!
   Hi!
   Goodbye!
   ```

1. BytesIO读写

   1. StringIO操作的只能是str，如果要操作二进制数据，就需要使用BytesIO。

   2. BytesIO实现了在内存中读写bytes，我们创建一个BytesIO，然后写入一些bytes：

      ```python
      >>> from io import BytesIO
      >>> f = BytesIO()
      >>> f.write('中文'.encode('utf-8'))
      6
      >>> print(f.getvalue())
      b'\xe4\xb8\xad\xe6\x96\x87'
      ```

   3. 与StringIO类似，可以用一个bytes初始化BytesIO，然后，与读取文件具有一致的接口；

---

#### 3. 操作文件和目录

​	1. 文件与路径相关：在os模块中通过path对象来实现对路径的各种操作

​		1. 获取程序运行的当前路：`cur_path =os.path.abspath(os.path.curdir)`

​		2. 判断指定路径下是否存在文件：`os.path.exists(r'd:\t1.txt')`或者 `os.path.isfile(r'd:\t1.txt')`

​		3. 判断指定的路径是否存在：`os.path.isdir(path)`或者 `os.path.exists(path)`

​		4. 建立文件夹（子路径）: `os.makedirs(path)`，建立失败则抛出OSError错误信息

```python
# 查看当前目录的绝对路径:
>>> os.path.abspath('.')
'/Users/michael'
# 在某个目录下创建一个新目录，首先把新目录的完整路径表示出来:
>>> os.path.join('/Users/michael', 'testdir')
'/Users/michael/testdir'
# 拆分路径，把一个路径拆分为两部分，后一部分总是最后级别的目录或文件名
>>> os.path.split('/Users/michael/testdir/file.txt')
('/Users/michael/testdir', 'file.txt')
# 得到文件扩展名
>>> os.path.splitext('/path/to/file.txt')
('/path/to/file', '.txt')
# 然后创建一个目录:
>>> os.mkdir('/Users/michael/testdir')
# 删掉一个目录:
>>> os.rmdir('/Users/michael/testdir')
# 对文件重命名:
>>> os.rename('test.txt', 'test.py')
# 删掉文件:
>>> os.remove('test.py')
```

> 把两个路径合成一个时，不要直接拼字符串，而要通过`os.path.join()`函数，这样可以正确处理不同操作系统的路径分隔符。
>
> `另外，shutil`模块提供了`copyfile()`的函数，你还可以在`shutil`模块中找到很多实用函数，它们可以看做是`os`模块的补充。

 2. 列出当前目录下的所有目录

    ```python
    >>> [x for x in os.listdir('.') if os.path.isdir(x)]
    ['.lein', '.local', '.m2', '.npm', '.ssh', '.Trash', '.vim', 'Applications', 'Desktop', ...]
    ```

	3. 列出所有的`.py`文件

    ```python
    >>> [x for x in os.listdir('.') if os.path.isfile(x) and os.path.splitext(x)[1]=='.py']
    ['apis.py', 'config.py', 'models.py', 'pymonitor.py', 'test_db.py', 'urls.py', 'wsgiapp.py']
    ```

---

#### 4. 序列化与JSON格式

1. 序列化定义：

   我们把变量从内存中变成可存储或传输的过程称之为序列化；反过来，把变量内容从序列化的对象重新读到内存里称之为反序列化，Python提供了pickle模块来实现序列化；

2. 把一个对象序列化并返回bytes类型数据：

   ```python
   >>> import pickle
   >>> d = dict(name='Bob', age=20, score=88)
   >>> pickle.dumps(d)
   b'\x80\x03}q\x00(X\x03\x00\x00\x00ageq\x01K\x14X\x05\x00\x00\x00scoreq\x02KXX\x04\x00\x00\x00nameq\x03X\x03\x00\x00\x00Bobq\x04u.'
   ```

   ```python
   # 另一个方法pickle.dump()直接把对象序列化后写入一个file-like Object
   >>> f = open('dump.txt', 'wb')
   >>> pickle.dump(d, f)
   >>> f.close()
   ```

3. 读取序列化对象到内存

   1. 用`pickle.loads()`方法反序列化出对象，也可以直接用`pickle.load()`方法从一个`file-like Object`中直接反序列化出对象

      ```Python
      >>> f = open('dump.txt', 'rb')
      >>> d = pickle.load(f)
      >>> f.close()
      >>> d
      {'age': 20, 'score': 88, 'name': 'Bob'}
      ```

      > Pickle的问题和所有其他编程语言特有的序列化问题一样，就是它只能用于Python，并且可能不同版本的Python彼此都不兼容，因此，只能用Pickle保存那些不重要的数据，不能成功地反序列化也没关系。

4. JSON对象与Python对象之间相互转化规则：

   | 从Python开始序列化         | 从JSON反序列化 |            |
   | -------------------------- | -------------- | ---------- |
   | Python类型                 | JSON类型       | Python类型 |
   | dict                       | object         | dict       |
   | list、tuple                | array          | list       |
   | str                        | string         | str        |
   | int、float及派生的枚举类型 | number(int)    | int        |
   | true                       | true           | true       |
   | false                      | false          | false      |
   | none                       | null           | none       |

   示例：使用Python自带的json模块

   ```python
   import json
   p_d = {'Tom':29, 'Jack':20, 'Jim':12}
   p_to_j = json.dumps(p_d) # 转换成JSON类型
   j_to_p = json.loads(p_to_j)  # 把JSON反序列化
   ```

5. 读写JSON

   1. `dumps()`方法返回一个`str`，内容就是标准的JSON；类似的，`dump()`方法可以直接把JSON写入一个`file-like Object`
   2. 要把JSON反序列化为Python对象，用`loads()`或者对应的`load()`方法，前者把JSON的字符串反序列化，后者从`file-like Object`中读取字符串并反序列化

   > 由于JSON标准规定JSON编码是UTF-8，所以我们总是能正确地在Python的`str`与JSON的字符串之间转换。

6. JSON进阶：序列化class类

   1. Python的`dict`对象可以直接序列化为JSON的`{}`，不过，很多时候，我们更喜欢用`class`表示对象，比如定义`Student`类，然后序列化：

      ```python
      import json
      
      class Student(object):
          def __init__(self, name, age, score):
              self.name = name
              self.age = age
              self.score = score
      
          # 可选参数default就是把任意一个对象变成一个可序列为JSON的对象，我们只需要为Student专门写一个转换函数，再把对象传进去即可
          def student2dict(self, std):
              return {
                  'name': std.name,
                  'age': std.age,
                  'score': std.score
              }
      
      s = Student('Bob', 20, 88)
      # Student实例首先被student2dict()函数转换成dict，然后再被顺利序列化为JSON
      print(json.dumps(s, default=s.student2dict))
      # 结果：{"age": 20, "name": "Bob", "score": 88}
      ```

      有一种偷懒的简化写法：

      ```python
      。。。。
      print(json.dumps(s, default=lambda s: s.__dict__))
      。。。
      ```

   2. 把JSON反序列化为Student对象

      1. `loads()`方法首先转换出一个`dict`对象，然后，我们传入的`object_hook`函数负责把`dict`转换为`Student`实例

         ```python
         def dict2student(d):
             return Student(d['name'], d['age'], d['score'])
            
         >>> json_str = '{"age": 20, "score": 88, "name": "Bob"}'
         >>> print(json.loads(json_str, object_hook=dict2student))
         <__main__.Student object at 0x10cd3c190>  
         ```

         > 打印出的是反序列化的`Student`实例对象

---

### 第十一章 进程和线程

---

### 第十二章 正则表达式

---

### 第十三章 常用内建模块

#### 1. datetime

 1. datetime是Python处理日期和时间的标准库；

 2. 获取当前日期和时间

    ```python
    >>> from datetime import datetime
    >>> now = datetime.now() # 获取当前datetime
    >>> print(now)
    2015-05-18 16:28:07.198690
    >>> print(type(now))
    <class 'datetime.datetime'>
    ```

    > 注意到`datetime`是模块，`datetime`模块还包含一个`datetime`类，通过`from datetime import datetime`导入的才是`datetime`这个类。
    >
    > 如果仅导入`import datetime`，则必须引用全名`datetime.datetime`。
    >
    > `datetime.now()`返回当前日期和时间，其类型是`datetime`。

    3. 获取指定日期和时间

    	1. 要指定某个日期和时间，我们直接用参数构造一个`datetime`

        ```python
        >>> from datetime import datetime
        >>> dt = datetime(2015, 4, 19, 12, 20) # 用指定日期时间创建datetime
        >>> print(dt)
        2015-04-19 12:20:00
        ```

    4. datetime转换为timestamp

       1. 在计算机中，时间实际上是用数字表示的。我们把1970年1月1日 00:00:00 UTC+00:00时区的时刻称为epoch time，记为`0`（1970年以前的时间timestamp为负数），当前时间就是相对于epoch time的秒数，称为timestamp。

       2. timestamp的值与时区没有关系，因为timestamp一旦确定，其UTC时间也就确定了，转换到任意时区的时间也是完全确定的。

          1. 把一个`datetime`类型转换为timestamp只需要简单调用`timestamp()`方法：

          ```python
          >>> from datetime import datetime
          >>> dt = datetime(2015, 4, 19, 12, 20) # 用指定日期时间创建datetime
          >>> dt.timestamp() # 把datetime转换为timestamp
          1429417200.0
          ```

          > 注意Python的timestamp是一个浮点数。如果有小数位，小数位表示毫秒数

    5. timestamp转换成datetime

       1. 要把timestamp转换为`datetime`，使用`datetime`提供的`fromtimestamp()`方法：

          ```python
          >>> from datetime import datetime
          >>> t = 1429417200.0
          >>> print(datetime.fromtimestamp(t))
          2015-04-19 12:20:00
          ```

          > 注意到timestamp是一个浮点数，它没有时区的概念，而datetime是有时区的。上述转换是在timestamp和本地时间做转换。

       2. timestamp也可以直接被转换到UTC标准时区的时间：

          ```python
          >>> from datetime import datetime
          >>> t = 1429417200.0
          >>> print(datetime.fromtimestamp(t)) # 本地时间
          2015-04-19 12:20:00
          >>> print(datetime.utcfromtimestamp(t)) # UTC时间
          2015-04-19 04:20:00
          ```

    6. str转换为datetime

       ```python
       >>> from datetime import datetime
       >>> cday = datetime.strptime('2015-6-1 18:19:59', '%Y-%m-%d %H:%M:%S')
       >>> print(cday)
       2015-06-01 18:19:59
       ```

    7. datetime转换为str

       ```python
       >>> from datetime import datetime
       >>> now = datetime.now()
       >>> print(now.strftime('%a, %b %d %H:%M'))
       Mon, May 05 16:28
       ```

    8. datetime加减

       1. 加减可以直接用`+`和`-`运算符，不过需要导入`timedelta`这个类：

          ```python
          >>> from datetime import datetime, timedelta
          >>> now = datetime.now()
          >>> now
          datetime.datetime(2015, 5, 18, 16, 57, 3, 540997)
          >>> now + timedelta(hours=10)
          datetime.datetime(2015, 5, 19, 2, 57, 3, 540997)
          >>> now - timedelta(days=1)
          datetime.datetime(2015, 5, 17, 16, 57, 3, 540997)
          >>> now + timedelta(days=2, hours=12)
          datetime.datetime(2015, 5, 21, 4, 57, 3, 540997)
          ```

    9. 本地时间转换为UTC时间

       1. 本地时间是指系统设定时区的时间，例如北京时间是UTC+8:00时区的时间，而UTC时间指UTC+0:00时区的时间。一个`datetime`类型有一个时区属性`tzinfo`，但是默认为`None`，所以无法区分这个`datetime`到底是哪个时区，除非强行给`datetime`设置一个时区：

          ```python
          >>> from datetime import datetime, timedelta, timezone
          >>> tz_utc_8 = timezone(timedelta(hours=8)) # 创建时区UTC+8:00
          >>> now = datetime.now()
          >>> now
          datetime.datetime(2015, 5, 18, 17, 2, 10, 871012)
          >>> dt = now.replace(tzinfo=tz_utc_8) # 强制设置为UTC+8:00
          >>> dt
          datetime.datetime(2015, 5, 18, 17, 2, 10, 871012, tzinfo=datetime.timezone(datetime.timedelta(0, 28800)))
          ```

          > 如果系统时区恰好是UTC+8:00，那么上述代码就是正确的，否则，不能强制设置为UTC+8:00时区。

       2. 时区转换

          1. 我们可以先通过`utcnow()`拿到当前的UTC时间，再转换为任意时区的时间：

             ```python
             # 拿到UTC时间，并强制设置时区为UTC+0:00:
             >>> utc_dt = datetime.utcnow().replace(tzinfo=timezone.utc)
             >>> print(utc_dt)
             2015-05-18 09:05:12.377316+00:00
             # astimezone()将转换时区为北京时间:
             >>> bj_dt = utc_dt.astimezone(timezone(timedelta(hours=8)))
             >>> print(bj_dt)
             2015-05-18 17:05:12.377316+08:00
             # astimezone()将转换时区为东京时间:
             >>> tokyo_dt = utc_dt.astimezone(timezone(timedelta(hours=9)))
             >>> print(tokyo_dt)
             2015-05-18 18:05:12.377316+09:00
             # astimezone()将bj_dt转换时区为东京时间:
             >>> tokyo_dt2 = bj_dt.astimezone(timezone(timedelta(hours=9)))
             >>> print(tokyo_dt2)
             2015-05-18 18:05:12.377316+09:00
             ```

---

2. #### collections集合

collections是Python内建的一个集合模块，提供了许多有用的集合类。

1. namedtuple

   1. 我们知道`tuple`可以表示不变集合，例如，一个点的二维坐标就可以表示成：`p = (1, 2)`,但是，看到`(1, 2)`，很难看出这个`tuple`是用来表示一个坐标的,定义一个class又小题大做了，这时，`namedtuple`就派上了用场:

      ```python
      >>> from collections import namedtuple
      >>> Point = namedtuple('Point', ['x', 'y'])
      >>> p = Point(1, 2)
      >>> p.x
      1
      >>> p.y
      2
      ```

      `namedtuple`是一个函数，它用来创建一个自定义的`tuple`对象，并且规定了`tuple`元素的个数，并可以用属性而不是索引来引用`tuple`的某个元素。

      这样一来，我们用`namedtuple`可以很方便地定义一种数据类型，它具备tuple的不变性，又可以根据属性来引用，使用十分方便，类似的，如果要用坐标和半径表示一个圆，也可以用`namedtuple`定义：

      ```python
      # namedtuple('名称', [属性list]):
      Circle = namedtuple('Circle', ['x', 'y', 'r'])
      ```

2. deque双向列表

   1. deque是为了高效实现插入和删除操作的双向列表，适合用于队列和栈：

      ```python
      >>> from collections import deque
      >>> q = deque(['a', 'b', 'c'])
      >>> q.append('x')
      >>> q.appendleft('y')
      >>> q
      deque(['y', 'a', 'b', 'c', 'x'])
      ```

      > `deque`除了实现list的`append()`和`pop()`外，还支持`appendleft()`和`popleft()`，这样就可以非常高效地往头部添加或删除元素。

3. 带默认值字典defaultdict

   1. 使用`dict`时，如果引用的Key不存在，就会抛出`KeyError`。如果希望key不存在时，返回一个默认值，就可以用`defaultdict`：

      ```python
      >>> from collections import defaultdict
      >>> dd = defaultdict(lambda: 'N/A')
      >>> dd['key1'] = 'abc'
      >>> dd['key1'] # key1存在
      'abc'
      >>> dd['key2'] # key2不存在，返回默认值
      'N/A'
      ```

4. 有序key的字典OrderedDict

   1. 使用`dict`时，Key是无序的。在对`dict`做迭代时，我们无法确定Key的顺序，如果要保持Key的顺序，可以用`OrderedDict`：

      ```python
      >>> from collections import OrderedDict
      >>> d = dict([('a', 1), ('b', 2), ('c', 3)])
      >>> d # dict的Key是无序的
      {'a': 1, 'c': 3, 'b': 2}
      >>> od = OrderedDict([('a', 1), ('b', 2), ('c', 3)])
      >>> od # OrderedDict的Key是有序的
      OrderedDict([('a', 1), ('b', 2), ('c', 3)])
      ```

      > 注意，`OrderedDict`的Key会按照插入的顺序排列，不是Key本身排序;

   2. `OrderedDict`可以实现一个FIFO（先进先出）的dict，当容量超出限制时，先删除最早添加的Key:

      ```python
      from collections import OrderedDict
      
      class LastUpdatedOrderedDict(OrderedDict):
      
          def __init__(self, capacity):
              super(LastUpdatedOrderedDict, self).__init__()
              self._capacity = capacity
      
          def __setitem__(self, key, value):
              containsKey = 1 if key in self else 0
              if len(self) - containsKey >= self._capacity:
                  last = self.popitem(last=False)
                  print('remove:', last)
              if containsKey:
                  del self[key]
                  print('set:', (key, value))
              else:
                  print('add:', (key, value))
              OrderedDict.__setitem__(self, key, value)
      ```

5. 组合dict的ChainMap

   1. `ChainMap`可以把一组`dict`串起来并组成一个逻辑上的`dict`。`ChainMap`本身也是一个dict，但是查找的时候，会按照顺序在内部的dict依次查找。

   什么时候使用`ChainMap`最合适？举个例子：应用程序往往都需要传入参数，参数可以通过命令行传入，可以通过环境变量传入，还可以有默认参数。我们可以用`ChainMap`实现参数的优先级查找，即先查命令行参数，如果没有传入，再查环境变量，如果没有，就使用默认参数。

   下面的代码演示了如何查找`user`和`color`这两个参数：

   ```python
   from collections import ChainMap
   import os, argparse
   
   # 构造缺省参数:
   defaults = {
       'color': 'red',
       'user': 'guest'
   }
   
   # 构造命令行参数:
   parser = argparse.ArgumentParser()
   parser.add_argument('-u', '--user')
   parser.add_argument('-c', '--color')
   namespace = parser.parse_args()
   command_line_args = { k: v for k, v in vars(namespace).items() if v }
   
   # 组合成ChainMap:
   combined = ChainMap(command_line_args, os.environ, defaults)
   
   # 打印参数:
   print('color=%s' % combined['color'])
   print('user=%s' % combined['user'])
   ```

   没有任何参数时，打印出默认参数：

   ```python
   $ python3 use_chainmap.py 
   color=red
   user=guest
   ```

   当传入命令行参数时，优先使用命令行参数：

   ```python
   $ python3 use_chainmap.py -u bob
   color=red
   user=bob
   ```

   同时传入命令行参数和环境变量，命令行参数的优先级较高：

   ```python
   $ user=admin color=green python3 use_chainmap.py -u bob
   color=green
   user=bob
   ```

6. 计数器Counter

   1. `Counter`是一个简单的计数器，例如，统计字符出现的个数：

      ```python
      >>> from collections import Counter
      >>> c = Counter()
      >>> for ch in 'programming':
      ...     c[ch] = c[ch] + 1
      ...
      >>> c
      Counter({'g': 2, 'm': 2, 'r': 2, 'a': 1, 'i': 1, 'o': 1, 'n': 1, 'p': 1})
      >>> c.update('hello') # 也可以一次性update
      >>> c
      Counter({'r': 2, 'o': 2, 'g': 2, 'm': 2, 'l': 2, 'p': 1, 'a': 1, 'i': 1, 'n': 1, 'h': 1, 'e': 1})
      ```

      > 可以获取每个字符出现的次数

---

#### 3. base64

Base64是一种用64个字符来表示任意二进制数据的方法。

用记事本打开`exe`、`jpg`、`pdf`这些文件时，我们都会看到一大堆乱码，因为二进制文件包含很多无法显示和打印的字符，所以，如果要让记事本这样的文本处理软件能处理二进制数据，就需要一个二进制到字符串的转换方法。Base64是一种最常见的二进制编码方法。

Base64的原理很简单，首先，准备一个包含64个字符的数组：

```pyhton
['A', 'B', 'C', ... 'a', 'b', 'c', ... '0', '1', ... '+', '/']
```

然后，对二进制数据进行处理，每3个字节一组，一共是`3x8=24`bit，划为4组，每组正好6个bit：

![base64-encode](https://www.liaoxuefeng.com/files/attachments/949444125467040)

这样我们得到4个数字作为索引，然后查表，获得相应的4个字符，就是编码后的字符串。

所以，Base64编码会把3字节的二进制数据编码为4字节的文本数据，长度增加33%，好处是编码后的文本数据可以在邮件正文、网页等直接显示。

如果要编码的二进制数据不是3的倍数，最后会剩下1个或2个字节怎么办？Base64用`\x00`字节在末尾补足后，再在编码的末尾加上1个或2个`=`号，表示补了多少字节，解码的时候，会自动去掉。

Python内置的`base64`可以直接进行base64的编解码：

```python
>>> import base64
>>> base64.b64encode(b'binary\x00string')
b'YmluYXJ5AHN0cmluZw=='
>>> base64.b64decode(b'YmluYXJ5AHN0cmluZw==')
b'binary\x00string'
```

由于标准的Base64编码后可能出现字符`+`和`/`，在URL中就不能直接作为参数，所以又有一种"url safe"的base64编码，其实就是把字符`+`和`/`分别变成`-`和`_`：

```python
>>> base64.b64encode(b'i\xb7\x1d\xfb\xef\xff')
b'abcd++//'
>>> base64.urlsafe_b64encode(b'i\xb7\x1d\xfb\xef\xff')
b'abcd--__'
>>> base64.urlsafe_b64decode('abcd--__')
b'i\xb7\x1d\xfb\xef\xff'
```

还可以自己定义64个字符的排列顺序，这样就可以自定义Base64编码，不过，通常情况下完全没有必要。

Base64是一种通过查表的编码方法，不能用于加密，即使使用自定义的编码表也不行。

Base64适用于小段内容的编码，比如数字证书签名、Cookie的内容等。

由于`=`字符也可能出现在Base64编码中，但`=`用在URL、Cookie里面会造成歧义，所以，很多Base64编码后会把`=`去掉：

```python
# 标准Base64:
'abcd' -> 'YWJjZA=='
# 自动去掉=:
'abcd' -> 'YWJjZA'
```

去掉`=`后怎么解码呢？因为Base64是把3个字节变为4个字节，所以，Base64编码的长度永远是4的倍数，因此，需要加上`=`把Base64字符串的长度变为4的倍数，就可以正常解码了。

---

#### 4.hashlib

#### 5.hmac

#### 6.itertools

#### 7.urllib

urllib提供的功能就是利用程序去执行各种HTTP请求。如果要模拟浏览器完成特定功能，需要把请求伪装成浏览器。伪装的方法是先监控浏览器发出的请求，再根据浏览器的请求头来伪装，`User-Agent`头就是用来标识浏览器的，更好的方案是使用requests。它是一个Python第三方库，处理URL资源特别方便。

