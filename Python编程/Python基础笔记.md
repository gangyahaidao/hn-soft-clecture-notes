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
   2. 使用`'''注释多行'''`或者`“”“注释多行”“”`

4. 设置解释器为utf-8编码。在文件头部添加一行：`# -*-coding:UTF-8 -*-`,Python3之前的版本需要设置，Python3之后默认就是utf-8编码，不会有中文乱码问题，可以不用设置

5. Python标识符命名规则：字母、数字、下划线，且不能数字开头，python语言是大小写敏感的；其中以下划线开头的标识符有特殊含义，以单下划线开头的代表不能直接访问的类属性，需要类提供的接口进行访问；以双下划线开头的代表类的私有成员；以双下划线开头和结尾的代表Python里特殊方法专用的标识，如`__init__()`表示类的构造函数

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

         | 运算符 |  功能描述  |
         | :----: | :--------: |
         |   +    |     加     |
         |   -    |     减     |
         |   *    |     乘     |
         |   /    |   **除**   |
         |   %    |    取模    |
         |   **   |   幂运算   |
         |   //   | **取整除** |

      3. 自行练习相应的整数及浮点数的例子

      4. 复数：由实部和虚部组成，形式为：a+bj

         ```python
         >>> (1-2j)*(2-3j)
         (-4-7j)
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

      7. 比较运算符

         | 比较运算符 |   运算规则   |
         | :--------: | :----------: |
         |     ==     | 比较是否相等 |
         |     !=     | 比较是否不等 |
         |     >      |     大于     |
         |     <      |     小于     |
         |     >=     |   大于等于   |
         |     <=     |   小于等于   |

         比较运算符的优先级低于算数运算符、位运算符，但是高于逻辑运算符：`5+1>5 and True  #先计算5+1=6，再计算6>5得True，再计算True and True运算`

      8. 赋值运算符：

         ```python
         +、+=、-=、*=、/=、%=、**=、//=、<<=、>>=、&=、|=、^=
         ```

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
      else:
      	子代码模块3
      ```

2. while循环

   1. while基本语法

      ```python
      while boolean_value1:
      	子代码模块1
      ```

3. for语句基本语法

   1. 基本语法

      ```python
      for <variable> in <sequence>:
      	子代码模块1
      else:
      	子代码模块2 #为for循环语句结束时，再执行此对应的代码模块2
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
   2. 把模块文件放到包中，也可以在包中建立子文件夹如Cat，存放对应的模块文件Cat_Main.py模块文件，则导入包模块方式为：`import package1.Cat.Cat_Main`
   3. 可以通过设置sys.path临时增加搜索路径，或存放于Python默认搜索路径下
   4. 第三方开发者提供的软件包多是以包的形式提供的，如：https://pypi.python.org/pypi
   5. 安装Python目录下的lib文件夹中包含相关标准库的源码， 可以参考世界级的高手都是怎么写程序的

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
   except:
   	代码模块2
   finally:
   	代码模块3
   如：
   import sys
   try:
       1/0
   except:
       print('除数不能为0')
       sys.exit()   # 此处虽然强制退出，但是finally子句还是会执行
   finally:
       print('程序执行结束')
   ```

4. 捕捉特定的异常信息：`except(Excep1, [Excep2, Excep3, ...])`

   ```python
   try:
   	i += 1
   except NameError:
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

---



