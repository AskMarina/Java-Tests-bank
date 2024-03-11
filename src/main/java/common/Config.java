package common;

public class Config {
    /**
     * Specify platform and config
     * CHROME_WINDOWS
     * MOZILLA_WINDOWS
     */
    public static final String BROWSER_AND_PLATFORM = "CHROME_WINDOWS";
    /**
     *Clear browser cookies after each iteration
     */
    public static final Boolean IS_CLEAR_COOKIES = false;
    /**
     *To keep browser open after all scenarios/ tests
     */
    public static final Boolean IS_BROWSER_OPEN = false;
    /**
     *Clear the directory with the screen before starting the build
     */
    public static final Boolean IS_CLEAR_REPORT_DIR = true;

}
