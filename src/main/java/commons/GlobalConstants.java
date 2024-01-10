package commons;

import java.io.File;

public class GlobalConstants {

	public static final String PORTAL_PAGE_URL = "https://demo.nopcommerce.com/";
	public static final String ADMIN_PAGE_URL = "https://admin-demo.nopcommerce.com/" + "";
	public static final String PROJECT_PATH = System.getProperty("user.dir");
	public static final String OS_NAME = System.getProperty("os.name");
	public static final String JAVA_VERSION = System.getProperty("java.version");
	public static final String UPLOAD_FILE = PROJECT_PATH + File.separator + "uploadFiles" + File.separator;
	public static final String DOWNLOAD_FILE = PROJECT_PATH + File.separator + "downloadFiles";
	public static final String BROWSERLOG = PROJECT_PATH + File.separator + "browserLogs";
	public static final String DRAG_DROP_HTML5 = PROJECT_PATH + File.separator + "dragDropHTML5";

	public static final String DB_DEV_URL = "192.186.1.15:9870";

	public static final long SHORT_TIMEOUT = 5;

	// 30s la time vua du de wait element = STANDARD
	public static final long LONG_TIMEOUT = 5;
	public static final long RETRY_TEST_FAIL = 3;

	public static final String UPLOAD_FILE_JQUERY = "xpath=//input[@type='file']";

	// wordpress
	public static final String WORDPRESS__ADMIN_PAGE_URL = "https://localhost/wp-admin/";
	public static final String WORDPRESS__User_PAGE_URL = "127.0.0.1";

}
