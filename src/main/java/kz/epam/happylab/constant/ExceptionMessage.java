package kz.epam.happylab.constant;

public final class ExceptionMessage {
    public static final String EXCEPTION_FIND_RECORDS = "Failed selecting records from db";
    public static final String EXCEPTION_FIND_RECORD = "Failed selecting record from db by its id";
    public static final String EXCEPTION_DELETE_RECORD = "Failed deleting record from db by its id";
    public static final String EXCEPTION_INSERT_RECORD = "Failed inserting or updating record in db by its id";
    public static final String EXCEPTION_UPDATE_RECORD = "Failed updating record in db by its id";
    public static final String EXCEPTION_PARSE_DATE = "Failed parsing date with pattern";
    public static final String EXCEPTION_DB_CONNECTION = "Failed connecting db";
    public static final String EXCEPTION_CLASS_NOT_FOUND = "Failed loading class by its name";
    public static final String EXCEPTION_CLEAR_QUEUE = "Failed clearing connection queue";
    public static final String EXCEPTION_TAKE_CONNECTION = "Failed taking connection from pool";
    public static final String EXCEPTION_RELEASE_CONNECTION = "Failed releasing connection";
    public static final String EXCEPTION_WRONG_ACTION = "Failed wrong action";
    public static final String EXCEPTION_WRONG_OPTION = "Failed wrong option";

    private ExceptionMessage() {
    }
}
