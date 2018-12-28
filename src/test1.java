import model.User;
import org.nutz.dao.Dao;
import org.nutz.dao.impl.NutDao;
import org.nutz.ioc.Ioc;
import org.nutz.ioc.impl.NutIoc;
import org.nutz.ioc.loader.json.JsonLoader;

import javax.sql.DataSource;

public class test1 {

    public static void main(String args[]) throws ClassNotFoundException {
        //将配置信息保存到dao.xml,并存放于src文件夹下. 代码仅供演示,实际使用的话必须单例

        Ioc ioc = new NutIoc(new JsonLoader("db_server.js"));
        DataSource ds = ioc.get(DataSource.class);
        Dao dao = new NutDao(ds); //如果已经定义了dao,那么改成dao = ioc.get(Dao.class);

        dao.create(User.class, false);
        User user = new User();
        user.setName("1234");
        user.setPassword("1233123214");
        user.setPermission(1);
        dao.insert(user);

        User user1 = dao.fetch(User.class,1);
        System.out.println(user1.getName());


        ioc.depose(); //关闭Ioc容器
    }

}