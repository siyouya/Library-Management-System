{
    dataSource : {

        type : "com.alibaba.druid.pool.DruidDataSource",

        events : {
            depose : 'close'
        },

        fields : {
            // url : "jdbc:mysql://127.0.0.1/test?serverTimezone=GMT%2B8&useUnicode=true&characterEncoding=utf-8",
            url : "jdbc:mysql://127.0.0.1:3306/test?serverTimezone=GMT%2B8&useUnicode=true&characterEncoding=utf-8",
            username : "root",
            // password : "",
            password : "123456",
            maxWait: 15000,
            defaultAutoCommit : false
        }

    }
}