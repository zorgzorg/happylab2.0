package kz.epam.happylab.constant;

public final class Common {
    //Request
    public static final String OPTION = "option";
    public static final String ACTION = "action";
    public static final String DATA = "data";

    //Options
    public static final String CUSTOMER="customer";
    public static final String ORDER="order";
    public static final String PROBE="probe";
    public static final String AES="aes";
    public static final String SSA="ssa";
    public static final String SANPIN="sanpin";
    public static final String REPORT="report";
    public static final String EMPLOYEE="employee";
    public static final String POSITION = "position";
    public static final String USER = "user";
    public static final String PROFILE = "profile";

    //Paths Layouts
    public static final String BASE_PATH = "/WEB-INF/view/";
    public static final String EDIT_LAYOUT = "/edit.jsp";
    public static final String FORM_LAYOUT = "/form.jsp";
    public static final String LOGIN_PATH = "/index.jsp";

    //Connection Pool
    public static final String DB_PARAMS = "config";
    public static final String DRIVER = "driver";
    public static final String URL = "url";
    public static final String POOLSIZE = "poolsize";
    public static final int DEFAULT_POOL_SIZE = 10;

    //Filters
    public static final String HEAD = "head";
    public static final String DELIMITER = ",";
    public static final String UTF8 = "UTF-8";
    public static final String ENCODING = "encoding";
    public static final String LANGUAGE = "language";
    public static final String JSTL_LOCALE = "javax.servlet.jsp.jstl.fmt.locale.session";
    public static final String RU = "ru_RU";

    //Customer
    public static final String NAME = "name";
    public static final String CITY = "city";
    public static final String FILTER = "filter";

    //Order
    public static final String ID = "id";
    public static final String ORDER_ID = "orderId";
    public static final int ZERO = 0;
    public static final String NUMBER = "number";
    public static final String CUSTOMER_ID = "customerId";
    public static final String DATE = "date";
    public static final String REMARK = "remark";

    //Probe
    public static final String PROBE_ID = "probeId";
    public static final String NUMBER_LAB = "numberLab";
    public static final String NUMBER_CUSTOMER = "numberCustomer";
    public static final String DATE_RECEIVING = "dateReceiving";
    public static final String POINT_SAMPLING = "pointSampling";
    public static final String DATE_SAMPLING = "dateSampling";
    public static final String PROBES_QUANTITY = "probesQuantity";

    //Analyses
    public static final String RECORD_ID = "recordId";
    public static final String EMPLOYEE_ID = "employeeId";
    public static final String ELEMENT = "element";
    public static final String LIMIT = "limit";

    //User
    public static final String PASSWORD = "password";
    public static final String USERNAME = "username";
    public static final String EMAIL = "email";
    public static final String USERTYPE = "usertype";
    public static final String BLOCK = "block";
    public static final String DATE_REGISTRATION = "dateRegistration";

    //Employees
    public static final String LASTNAME = "lastname";
    public static final String SURNAME = "surname";
    public static final String POSITION_ID = "positionId";
    public static final String ASSISTANT = "assistant";
    public static final String SIGNATURE = "signature";

    //Report
    public static final String CONTENT = "content";
    public static final String ANALYSIS = "analysis";

    //Date formatter
    public static final String RU_FORMAT_DATE="dd.MM.yy";
    public static final String EN_FORMAT_DATE="MM/dd/yy";
    public static final String DB_FORMAT_DATE="yyyy-MM-dd";

    //SQL
    public static final String SQL_DIR="sql/";
    public static final String INSERT="insert";
    public static final String UPDATE="update";
    public static final String DELETE="delete";
    public static final String UPDATE_ASSISTANT="update_assistant";
    public static final String UPDATE_SIGNATURE="update_signature";
    public static final String DELETE_SIGNATURE="delete_signature";
    public static final String FINDALL="findall";
    public static final String FINDALL_FILTER="findall_filter";
    public static final String FINDBYID="findbyid";
    public static final String FIND_ANALYSIS="find_analysis";
    public static final String FINDBYID_AES="findbyid_aes";
    public static final String FINDBYID_SSA="findbyid_ssa";
    public static final String FINDBYID_SANPIN="findbyid_sanpin";
    public static final String FIND_LIMITS="find_limits";
    public static final String FIND_HEAD_LABORATORY="find_head_laboratory";
    public static final String UPDATE_PROFILE="update_profile";
    public static final String FINDBYLOGIN="findbylogin";

    //Misc
    public static final String EMPTY_PARAMETER = "";

    //Messages
    public static final String MESSAGE="message";
    public static final String MESSAGE_DANGER="message_danger";
    public static final String DELETE_SUCCESFUL="delete_success";
    public static final String DELETE_UNSUCCESFUL="delete_unsuccess";
    public static final String UNKNOWN_USER="unknown_user";
    public static final String BLOCKED_USER="blocked_user";

    private Common() {
    }
}
