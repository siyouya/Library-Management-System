import cc.southseast.model.Book;
import cc.southseast.model.Borrow;
import cc.southseast.model.Publish;

import static cc.southseast.controller.function.ToConnect.dao;

/**
 * @Author: Southseast
 * @Date: 2019/1/4 1:02 AM
 * @Version 1.0
 */
public class testCreate {

    public static void main(String[] args) {


        dao.create(Publish.class, false);
        dao.create(Book.class, false);
        dao.create(Borrow.class, false);
    }
}
