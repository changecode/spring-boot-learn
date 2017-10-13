###本例子未测试

操作MongoDB实现类，只需继承MongoRepository<T, ID>接口又继承CrudRepository
    T：操作的实体类
    ID：T的主键类型（@ID修饰的属性），通常就是String

该接口实现了常用的增删改查功能
    findAll findAll(Sort var1) save(S var1) exists T findOne(ID var1) delete(ID var1)等方法
  
复杂查询：使用MongoTemplate以及一些查询条件构建类（BasicDBList、BasicDBObject、Criteria等）
    