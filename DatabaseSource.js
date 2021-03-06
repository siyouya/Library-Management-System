var ioc = {
    dataSource : {
        type : "com.alibaba.druid.pool.DruidDataSource",
        events : {
            depose : 'close'
        },
        fields : {
            url : "jdbc:mysql://127.0.0.1:3306/test?serverTimezone=GMT%2B8&useUnicode=true&characterEncoding=utf-8",
            username : "root",
            password : "123456",
            maxWait: 15000, // 若不配置此项,如果数据库未启动,druid会一直等可用连接,卡住启动过程
            defaultAutoCommit : false // 提高fastInsert的性能
        }
    }
};