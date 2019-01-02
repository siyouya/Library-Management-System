package cc.southseast.controller.function;

import org.nutz.dao.Dao;
import org.nutz.dao.impl.NutDao;
import org.nutz.ioc.Ioc;
import org.nutz.ioc.impl.NutIoc;
import org.nutz.ioc.loader.json.JsonLoader;
import javax.sql.DataSource;


public class ToConnect {

    public static Ioc ioc;

    public static DataSource ds;

    public static Dao dao;

    static {
        ioc = new NutIoc(new JsonLoader("DatabaseSource.js"));
    }

    static {
        ds = ioc.get(DataSource.class);
    }

    static {
        // 如果已经定义了dao,那么改成dao = ioc.get(Dao.class);
        dao = new NutDao(ds);
    }
}
