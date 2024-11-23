interface Database {
    void connect();
}

class RealDatabase implements Database {
    private String dbName;

    public RealDatabase(String dbName) {
        this.dbName = dbName;
    }

    @Override
    public void connect() {
        System.out.println("Успешное подключение к базе: " + dbName);
    }
}

class DatabaseProxy implements Database {
    private RealDatabase realDatabase;
    private String dbName;

    public DatabaseProxy(String dbName) {
        this.dbName = dbName;
    }

    @Override
    public void connect() {
        if (realDatabase == null) {
            realDatabase = new RealDatabase("localhost:port/" + dbName);
        }
        realDatabase.connect();
    }

    public static void main(String[] args) {
        Database dbProxy = new DatabaseProxy("myDatabase");
        dbProxy.connect();
    }
}