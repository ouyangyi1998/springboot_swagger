# springboot联动swagger，实现生成api
- 代码来自github
- swagger通过注解就可以实现ui界面的api，非常方便
- 通过@Configuration注解，表明它是一个配置类
- @EnableSwagger2开启swagger2，apiINfo()配置一些基本的信息，apis()指定扫描的包会生成文档。
- 代码采用Map来模拟数据库，Collections.synchronized()返回线程安全的Map()
***
### swagger注解开发
- @ApiOperation：描述一个类的一个方法，或者说一个接口
- @ApiParam：单个参数描述
- @ApiIgnore：使用该注解忽略这个API
- 如果请求参数在url上，@ApiImplicitParam 上加paramType = “path” 
- required=true 说明必须要有这个请求参数 
***
### 容器使用方法
- map.values() 获得map容器中所有values 返回为list集合
- map.remove() 通过key移除map中的key-value
