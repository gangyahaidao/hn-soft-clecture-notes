### Python网络爬虫

> 创建：讯飞人工智能学院
>
> 时间：2020-07-27

##### 一、开发环境配置

##### 二、爬虫基础概念

##### 三、基本库的使用

Python提供了功能齐全的类库来帮助完成HTTP请求，最基础的HTTP库有urllib、httplib2、requests、treq等。

###### 1.urllib库

urllib库是Python内置的HTTP请求库，包含如下4个模块：

- request：最基本的HTTP请求模块，用来模拟发送请求；

- error：异常处理模块

- parse：工具模块，提供URL处理方法，如拆分、解析、合并等；

- robotparser：用来识别网站的robots.txt文件

  ###### 1.发送请求

  ​	1.urlopen()基本用法

  ```python
  import urllib.request
  
  response = urllib.request.urlopen('https://www.python.org')
  print(type(response)) # type()方法查看对象的类型
  print(response.read().decode('utf-8')) # 调用read()可以获取返回的网页内容，status属性可以得到返回结果的状态码
  ```

   2. data参数：用来以POST方式提交请求参数，需要转换成字节流

      ```python
      import urllib.parse
      import urllib.request
      
      data = bytes(urllib.parse.urlencode({'world': 'hello'}), encoding='utf8')
      response = urllib.request.urlopen('http://httpbin.org/post', data=data)
      print(response.read())
      ```

   3. timeout参数：设置超时时间，超过则抛出异常，不指定则使用全局默认时间

   4. 其他参数

      - context参数：用来指定SSL设置
      - cafile和capath参数：用来指定CA证书和它的路径，请求HTTPS链接时有用

  ###### 2.Request类

  ​	利用urlopen()方法可以完成简单的请求和网页抓取，但是参数太简单不足以构建一个更复杂的请求，如果需要在请求中添加Headers参数，可以利用更强大的Request类来实现。

  - 基本用法

    ```python
    import urllib.request
    
    request = urllib.request.Request('http://python.org')
    response = urllib.request.urlopen(request)
    print(response.read().encode('utf-8'))
    ```

  - 多参数用法

    ```python
    from urllib import request, parse
    
    url = 'http://httpbin.org/post'
    headers = {
    	'User-Agent': 'Mozilla/4.0 (compatible; MSIE 5.5; Windows NT)',
    	'Host': 'httpbin.org'
    }
    dict = {
    	'name': 'Germey'
    }
    data = bytes(parse.urlencode(dict), encoding='utf-8')
    req = request.Request(url=url, data=data, headers=headers, method='POST') # headers也可以使用add_header()添加
    response = request.urlopen(req)
    print(response.read().decode('utf-8'))
    ```

  - 进阶用法

    1. Cookies处理

       - handler构建：urllib.request模块中的BaseHandler类是所有其他Handler的父类，如处理Cookies的`HTTPCookieProcessor`

       - Opener类：是在urlopen()和Request基础上又进行了封装，可以完成更复杂的功能

       - 利用Handler来构建Opener：完成网站表单验证功能：

         ```python
         from urllib.request import HTTPPasswordMgrWithDefaultRealm, HTTPBaseAuthHandler, build_opener
         from urllib.error import URLError
         
         usename = 'username'
         password = 'password'
         
         p = HTTPPasswordMgrWithDefaultRealm()
         p.add_password(None, url, username, password)
         auth_handler = HTTPBaseAuthHandler(p)
         opener = build_opener(auth_handler)
         
         try:
         	result = opener.open(url)
         	html = result.read().decode('utf-8')
         	print(html)
         except URLError as e:
         	print(e.reason)
         ```

    2. 代理设置

       ```python
       from urllib.error import URLError
       from urllib.request import ProxyHandler, build_opener
       
       proxy_handler = ProxyHandler({
           'http': 'http://127.0.0.1:9743',
           'https': 'https://127.0.0.1:9743'
       })
       opener = build_opener(proxy_handler)
       try:
       	response = opener.open('https://www.baidu.com')
           print(response.read().decode('utf-8'))
       except URLError as e:
           print(e.reason)
       ```

    3. Cookies操作

       ```python
       import http.cookiejar, urllib.request
       
       cookie = http.cookiejar.CookieJar() # 声明一个Cookie对象
       handler = urllib.request.HTTPCookieProcess(cookie) # 构建Handler
       opener = urllib.request.build_opener(handler)
       response = opener.open('http://www.baidu.com') 
       for item in cookie: # 还支持以文件的方式保存Cookie
           print(item.name + '=' + item.value)
       ```

    4. 解析链接 - parse模块

       ```python
       # 1.urlparse()实现URL的识别和分段
       from urllib.parse import urlparse
       
       result = urlparse('http://www.baidu.com/index.html;user?id=5#comment')
       print(type()result, result) # 会将链接拆分成6个部分
       
       # 2.urlunparser()接收一个可迭代对象参数，长度必须是6
       
       # 3. 还有urlsplit()、urlunsplit()、urljoin()、urlencode()将字典参数转化为GET参数、quote()将中文转化成URL编码、unquote()
       ```

       

###### 2.requests库

​	替换urllib的更方便操作的HTTP库。

 1. 简单示例

    ```python
    import requests
    
    r = requests.get('https://www.baidu.com')
    print(type(r))
    print(r.status_code)
    print(type(r.text), r.text)
    print(r.cookies)
    ```

	2. GET请求构造参数

    ```python
    import requests
    
    data = {
    	'name': 'germey',
        'age': 22
    }
    r = requests.get('http://httpbin.org/get', params=data)
    print(r.text) # 也可以调用r.json()可以将返回结果是JSON格式的字符串转换成字典
    ```

	3. 增加请求headers信息

    ```python
    import requests
    import re
    
    headers = {
    	'User-Agent': 'Mozilla.......'   
    }
    r = requests.get('https://www.zhihu.com/example', headers=headers)
    pattern = re.compile('explore-feed.*?question_link.*?>(.*?)</a>', re.S) # 使用正则表达式匹配
    titles = re.findall(pattern, r.text)
    print(titles)
    ```

	4. 抓取保存二进制数据

    ```python
    import requests
    
    r = requests.get('https://github.com/favicon.ico')
    with open('favicon.ico', 'wb') as f:
        f.write(r.content) # 使用content()方法获取二进制数据
    ```

	5. POST请求

    ```python
    import requests
    
    data = {
        'name': 'germey',
        'age': 22
    }
    r = requests.post('http://www.baidu.com', data=data)
    print(r.text)
    ```

	6. 获取相应信息

    - r.text() 获取相应文本
    - r.content() 获取相应二进制数据
    - r.status_code
    - r.headers
    - r.cookies 获取Cookies一步到位

	7. 高级用法

    	1. 文件上传

        ```python
        import requests
        
        files = {'file': open('favicon.ico', 'rb')}
        r = requests.post('http://httpbin.org/post', files=files)
        print(r.text)
        ```

    	2. 填充Cookies登录：首先登录知乎，获取Cookie，然后将其设置到headers中的Cookie字段，然后发送请求，结果中包含登录之后的内容；

    	3. 会话维持

        默认不同的请求对应不同的会话，维持同一个会话有两种方式：

        - 每次请求都设置同样的Cookie
        - 使用Session对象

        ```python
        import requests
        
        s = requests.session()
        s.get('http://httpbin.org/cookies/set/number/12345678')
        r = s.get('http://httpbin.org/cookies')
        print(r.text)
        ```

    	4. SSL证书验证

        	1. 可以使用verify字段来控制是否提供证书验证，默认为true，会自动验证

        	2. 不使用证书验证：

            ```python
            import requests
            from requests.packages import urllib3
            
            urllib3.disable_warnings() # 消除警告信息
            response = requests.get('https://www.12306.cn', verify=False)
            print(response.status_code)
            
            ```

    	5. Prepared Request对象将请求作为独立的对象，方便调度

        ```python
        from requests import Request, Session
        
        url = 'http://httpbin.org/post'
        data = {
            'name': 'germey'
        }
        headers = {
            'User-Agent': '...........'
        }
        s = Session()
        req = Request('POST', url, data=data, headers=headers)
        prepare = s.prepare_request(req)
        r = s.send(prepare)
        print(r.text)
        ```

        

###### 3.正则表达式

​	正则表达式是处理字符串的强大工具，可以用来实现字符串的检索、替换、匹配验证等，即：使用一定的规则将特定的文本提取出来。

 1. 正则表达式匹配规则

    <img src="C:\Users\My\AppData\Roaming\Typora\typora-user-images\image-20200727175020669.png" alt="image-20200727175020669" style="zoom:90%;" />

    <img src="C:\Users\My\AppData\Roaming\Typora\typora-user-images\image-20200727175042134.png" alt="image-20200727175042134" style="zoom:90%;" />

    

 2. re库中常用的方法

     1. ###### match()

        传入要匹配的字符串和正则表达式，可以检测这个正则表达式是否匹配字符串，如果匹配，返回匹配成功的结果，如果不匹配，则返回None。

        ```python
        import re
        
        content = 'Hello 123 4567 World_This is a Regex Demo'
        result = re.match('^Hello\s\d\d\d\s\d{4}\s\w{10}', content)
        print(result)
        print(result.group()) # 输出匹配到的内容
        print(result.span()) # 输出匹配的下标范围
        
        result2 = re.match('^Hello\s(\d+)\s', content) #()实际上标记了一个子表达式，对应一个分组，通过索引获取结果
        print(result.group())
        print(result.group(1))
        ```

    2. 通用匹配：`.*`点星组合可以用来匹配任意字符，其中点`.`可以匹配除换行符外的任意字符，星*表示匹配前面的字符无限次；上面的正则表达式可以改写成re.match('^Hello.\*Demo$', content)

    3. 贪婪与非贪婪匹配

       ```python
       import re
       
       content = 'Hello 1234567 World_This is a Regex Demo'
       result = re.match('^He.*(\d+).*Demo&', content)
       print(result.group(1)) # 结果是数字7，而不是希望的1234567
       ```

       ​	（1）以上结果的原因是点星.*是贪婪匹配，会尽可能多的匹配字符，所以只给\d+留下一个可满足条件的数字7；

       ​	（2）非贪婪匹配的写法是.*?会尽可能少的匹配字符，\d+可以匹配数字1234567，所以后面就交给\d+匹配了；

       > 所以，在做匹配的时候，字符串中间尽量使用非贪婪匹配，也就是用.*?，避免出现匹配结果确实的情况；

       ​	（3）如果匹配的结果在字符串末尾的话，.*?可能匹配不到任何内容了，因为会尽可能少的匹配字符

       ​	

       ```python
       import re
       
       content = 'http://weibo.com/comment/kEraCN'
       result1 = re.match('http.*?comment/(.*?)', content) # 不能匹配到后面的字符串
       result2 = re.match('http.*?comment/(.*)', content) # 可以匹配
       ```

    4. 修饰符总结

       正则表达式可以包含一些修饰符来控制匹配的模式，修饰符是一个可选的标志。

       ![image-20200727183251800](C:\Users\My\AppData\Roaming\Typora\typora-user-images\image-20200727183251800.png)

    5. 转义匹配：使用反斜杠\

    6. 

 3. 修饰符总结

###### 4.实例：抓取猫眼电影排行