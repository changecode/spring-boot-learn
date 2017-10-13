### swagger常用注解

#### @Api ：用于类上，描述类的作用
#### @ApiOperation : 用于方法上，描述方法的作用
#### @ApiImplicitParams : 用于方法上包含一组参数描述
#### @ApiImplicitParam ：用于@ApiImplicitParams注解中，指定一个请求参数的各个方面

##### ParamType : 参数放在哪个地方
###### header ： 请求参数 @RequestHeader
###### query ： 请求参数 @RequestParam
###### path：用于restful接口，请求参数@PathVariable
###### body 不常用
###### form 不常用

##### name:参数名
##### dataType:参数类型
##### required:参数是否必须
##### value 
##### defaultValue 参数默认值

####@APIResponses 用于表示一组响应
####@APIResponse 用于@APIResponses中，表示错误信息
##### code :数字 400等
##### message 信息 提示信息
##### response  抛出异常类

####@APIModel 描述一个model的信息，一般用在post创建时候使用@ResponseBody场景，请求参数无法使用@ApiImplicitParam注解进行描述的时候
#####@APIModelProperty 描述model的属性

    