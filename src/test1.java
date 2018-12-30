import controller.ToConnect;
import model.User;
import org.nutz.dao.Dao;
import org.nutz.dao.impl.NutDao;
import org.nutz.ioc.Ioc;
import org.nutz.ioc.impl.NutIoc;
import org.nutz.ioc.loader.json.JsonLoader;

import javax.sql.DataSource;

import java.util.Date;
import java.util.Random;

import static controller.ToConnect.*;


public class test1 {

    public static void main(String args[]) throws ClassNotFoundException {
//        //将配置信息保存到dao.xml,并存放于src文件夹下. 代码仅供演示,实际使用的话必须单例
//
//        Ioc ioc = new NutIoc(new JsonLoader("DatabaseSource.js"));
//        DataSource ds = ioc.get(DataSource.class);
//        Dao dao = new NutDao(ds);
//
//
//        //如果已经定义了dao,那么改成dao = ioc.get(Dao.class);

//

        Random rand = new Random();

        for (int i = 1; i <= 10; i++) {

            dao.create(User.class, false);
            User user = new User();

            String studentId = "2017";
            for (int j = 0; j < 6; j++) {
                studentId += rand.nextInt(10);
            }

            user.setStudentId(studentId);

            String name = "";
            for (int j = 0; j < 3; j++) {
                name += (char) (rand.nextInt(0x9fa5 - 0x4e00 + 1) + 0x4e00);
            }

            user.setName(name);

            String password = "";
            for (int j = 0; j < 8; j++) {
                password += (char)(rand.nextInt(48) + 65);
            }

            user.setPassword(password);

            user.setBirthday(new Date());

            String email = "";

            for (int j = 0; j < 8; j++) {
                email += rand.nextInt(10);
            }

            email += "@qq.com";

            user.setEmail(email);

            if (rand.nextInt(2) == 0)
                user.setSex("女");
            else
                user.setSex("男");

            String telphone = "1";

            for (int j = 0; j < 10; j++) {
                telphone += rand.nextInt(10);
            }

            user.setTelphone(telphone);

            dao.insert(user);

        }


    }

}