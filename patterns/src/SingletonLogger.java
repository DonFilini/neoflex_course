public class SingletonLogger {
    private static SingletonLogger instance;

    private SingletonLogger() {}

    public static SingletonLogger getInstance() {
        if (instance == null) {
            instance = new SingletonLogger();
        }
        return instance;
    }

    public void classLogg(Object obj, String info) {
        String className = obj.getClass().getSimpleName();
        String logMessage = String.format("Log info: %s - %s - %s", java.time.LocalDate.now(), className, info);
        System.out.println(logMessage);
    }

    public static void main(String[] args) {
        SingletonLogger logger = SingletonLogger.getInstance();
        logger.classLogg(new SingletonLogger(), "Some info");
    }
}