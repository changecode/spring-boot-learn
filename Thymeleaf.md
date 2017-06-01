特点：
	1、Thymeleaf在有无网络都可运行。支持HTML原型，然后在HTML标签里增加额外的属性来达到模板+数据的展现方式。浏览器解释HTML时会忽略未定义的标签属性，所以Thymeleaf的模板可以静态地运行，当有数据返回到页面时，Thymeleaf标签会动态地替换静态内容，是页面动态显示
	2、Thymeleaf提供了spring标准二种方言，可以直接套用模板实现jstl、ognl表达式效果
	3、Thymeleaf和spring mvc可选模块，可以快速的实现表单绑定、属性编辑器、国际化等功能

标准表达式语法：
	1、变量表达式
		${session.user.name},将于HTML标签的一个属性来表示：
		<span th:text="${book.author.name}">
		<li th:each="book:${books}">
	2、选择（星号）表达式
		*{customer.name},被指定的object由th:object属性定义
		<div th:object="${book}">
			<span th:text="*{title}">...</span>
		</div>
	3、文字国际化表达式
		允许我们从一个外部文件获取区域文字信息（.properties) 用key索引value
		#{main.title}
		#{message.entrycreated(${entryId})}
		模板文件：
		<table>
			<th th:text="#{header.address.city}">...</th>
			<th th:text="#{header.address.country}">...</th>
		</table>
	3、URL表达式
		@{/order/list}  @{/order/detauls(id=${orderId})}  @{../documents/report}
		<form th:action="@{/createOrder}">
		<a href="main.html" th:href="@{/main}">

常用th标签：
	th:id  替换id <input th:id="'xxx' + ${collect.id}"/>
	th:text 文本替换 <p th:text="${collect.description}">description</p>
	th:utext 支持HTML的文本替换 <p th:utext="${htmlcontent}">content</p>
	th:object 替换对象 <div th:object="${session.user}">
	th:value 属性赋值 <input th:value="${user.name}">
	th:with 变量赋值运算 <div th:with="isEven=${prodStat.count}%2==0"></div>
	th:style 设置样式 th:style="'display:' + @{(${sitrue} ? 'none' :'inline-block')} + ''" 	
	th:onclick 点击事件  th:onclick="'getCollect()'"
	th:each 属性赋值 tr th:each="user,userStat:${users}"
	th:if 判断条件  <a th:if="${userId == collect.userId}">
	th:unless 和th:if判断相反 <a th:href="@{/login}" th:unless=${session.user != null}>login</a>
	th:href   <a th:href="@{/login}" th:unless=${session.user != null}>login</a>
	th:swith 多路选择 配合th:case  <div th:swith="${user.role}">
	th:case th:switch一个分支  <p th:case="'admin'">user is a adminer</p>
	th:fragment 布局标签 定义个代码片段 方便其他地方引用 <div th:fragment="alert">
	th:include 布局标签 替换内容到引入的文件  <head th:include="layout :: htmlhead" th:with="title='xxx'"></head>
	th:replace 布局标签 替换整个标签到引入的文件 <div th:replace="fragments/header  :: title"></div>
	th:selected  th:selected="(${xxx.id}) == ${configobj.dd})"
	th:src 图片类引入  <img class="img-responsive" alt="app logo" th:src="@{/img/logon.png}" />
	th:inline 定义js脚本可以使用变量  <script type="text/javascript" th:inline="javascript">
	th:action 表单提交的地址 <form action="subscribe.html" th:action="@{/subscribe}">
	th:remove 删除某个属性  <tr th:remove="all" 1.all:删除包含标签和所有的孩子。
						2.body:不包含标记删除,但删除其所有的孩子。
						3.tag:包含标记的删除,但不删除它的孩子。
						4.all-but-first:删除所有包含标签的孩子,除了第一个。
						5.none:什么也不做
	th:attr 设置标签属性，多个属性用逗号分开 th:attr="src=@{/image/aa.jpg},title=#{logon}"
	一个标签内可以包含多个th:x属性，其生效的优先级顺序为: include,each,if/unless/switch/case,with,attr/attrprepend/attrappend,value/href,src ,etc,text/utext,fragment,remove









