package desginpattern.singleton;

import java.sql.Connection;

public class Application {

    public static void main(String[] args){

        long start;
        long end;

        Database database = Database.getDatabase();
        System.out.println(database);

        start = System.currentTimeMillis();
        Connection connection =database.getConnection();
        end =System.currentTimeMillis();

        System.out.println(end-start);

        Database database1 = Database.getDatabase();
        System.out.println(database1);
        start = System.currentTimeMillis();
        Connection connection1 =database1.getConnection();
        end =System.currentTimeMillis();

        System.out.println(end-start);



    }

}
