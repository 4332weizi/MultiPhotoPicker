package net.funol.utils;

/**
 * 在应用开发期打印日志信息，应用发布时将display改为false可避免在发布的应用中打印log。
 * <p>
 * 内部调用{@link android.util.Log}中的方法，使用方法与{@link android.util.Log}基本相同。
 * <p>
 * <b>使用方法:</b>
 * <p>
 * 1.<b>display</b>为<b>true</b>时打印日志信息，发布应用时应将<b>display</b>设置为<b>false</b >
 * <p>
 * 2. 分别使用L.v() L.d() L.i() L.w() L.e()打印不同级别的错误
 * <p>
 *
 * @see android.util.Log
 * @author 赵尉尉
 */
public class L {
    /**
     * 是否输出日志信息，true时打印日志信息
     */
    public static final boolean display = true;

    public static final int VERBOSE = android.util.Log.VERBOSE;
    /**
     * debug级别的Log打印优先级，对应L.d
     */
    public static final int DEBUG = android.util.Log.DEBUG;
    /**
     * info级别的Log打印优先级，对应L.i
     */
    public static final int INFO = android.util.Log.INFO;
    /**
     * warn级别的Log打印优先级，对应L.w
     */
    public static final int WARN = android.util.Log.WARN;
    /**
     * error级别的Log打印优先级，对应L.e
     */
    public static final int ERROR = android.util.Log.ERROR;
    /**
     * assert级别的Log打印优先级，对应L.a
     */
    public static final int ASSERT = android.util.Log.ASSERT;

    private L() {

    }

    /**
     * 打印 {@link #VERBOSE} 级别的日志信息
     *
     * @param tag
     *            标识日志信息的来源，一般为打印日志的Class或者Activity名。
     * @param msg
     *            要输出的日志信息
     */
    public static int v(String tag, String msg) {
        if (display)
            return android.util.Log.v(tag, msg);
        return 0;
    }

    /**
     * 打印 {@link #VERBOSE} 级别的日志信息
     *
     * @param obj
     *            标识日志信息的来源，自动获得obj的Class名作为日志来源的标识。一般传人<b>this</b>即可。
     * @param msg
     *            要输出的日志信息
     */
    public static int v(Object obj, String msg) {
        return v(getClassName(obj), msg);
    }

    /**
     * 打印 {@link #VERBOSE} 级别的日志信息
     * <p>
     * 输出Tag为调用该方法的类的类名
     *
     * @param msg
     *            要输出的日志信息
     */
    public static int v(String msg) {
        return v(getClassName(), msg);
    }

    /**
     * 打印 {@link #VERBOSE} 级别的日志及异常信息
     *
     * @param tag
     *            标识日志信息的来源，一般为打印日志的Class或者Activity名。
     * @param msg
     *            要输出的日志信息
     * @param tr
     *            要输出的日志信息
     */
    public static int v(String tag, String msg, Throwable tr) {
        if (display)
            return android.util.Log.v(tag, msg, tr);
        return 0;
    }

    /**
     * 打印 {@link #VERBOSE} 级别的日志及异常信息
     *
     * @param obj
     *            标识日志信息的来源，自动获得obj的Class名作为日志来源的标识。一般传人<b>this</b>即可。
     * @param msg
     *            要输出的日志信息
     * @param tr
     *            要输出的日志信息
     */
    public static int v(Object obj, String msg, Throwable tr) {
        return v(getClassName(obj), msg, tr);
    }

    /**
     * 打印 {@link #VERBOSE} 级别的日志及异常信息
     * <p>
     * 输出Tag为调用该方法的类的类名
     *
     * @param msg
     *            要输出的日志信息
     * @param tr
     *            要输出的日志信息
     */
    public static int v(String msg, Throwable tr) {
        return v(getClassName(), msg, tr);
    }

    /**
     * 打印 {@link #DEBUG} 级别的日志信息
     *
     * @param tag
     *            标识日志信息的来源，一般为打印日志的Class或者Activity名。
     * @param msg
     *            要输出的日志信息
     */
    public static int d(String tag, String msg) {
        if (display)
            return android.util.Log.d(tag, msg);
        return 0;
    }

    /**
     * 打印 {@link #DEBUG} 级别的日志信息
     *
     * @param obj
     *            标识日志信息的来源，自动获得obj的Class名作为日志来源的标识。一般传人<b>this</b>即可。
     * @param msg
     *            要输出的日志信息
     */
    public static int d(Object obj, String msg) {
        return d(getClassName(obj), msg);
    }

    /**
     * 打印 {@link #DEBUG} 级别的日志信息
     * <p>
     * 输出Tag为调用该方法的类的类名
     *
     * @param msg
     *            要输出的日志信息
     */
    public static int d(String msg) {
        return d(getClassName(), msg);
    }

    /**
     * 打印 {@link #DEBUG} 级别的日志及异常信息
     *
     * @param tag
     *            标识日志信息的来源，一般为打印日志的Class或者Activity名。
     * @param msg
     *            要输出的日志信息
     * @param tr
     *            要输出的日志信息
     */
    public static int d(String tag, String msg, Throwable tr) {
        if (display)
            return android.util.Log.d(tag, msg, tr);
        return 0;
    }

    /**
     * 打印 {@link #DEBUG} 级别的日志及异常信息
     *
     * @param obj
     *            标识日志信息的来源，自动获得obj的Class名作为日志来源的标识。一般传人<b>this</b>即可。
     * @param msg
     *            要输出的日志信息
     * @param tr
     *            要输出的日志信息
     */
    public static int d(Object obj, String msg, Throwable tr) {
        return d(getClassName(obj), msg, tr);
    }

    /**
     * 打印 {@link #DEBUG} 级别的日志及异常信息
     * <p>
     * 输出Tag为调用该方法的类的类名
     *
     * @param msg
     *            要输出的日志信息
     * @param tr
     *            要输出的日志信息
     */
    public static int d(String msg, Throwable tr) {
        return d(getClassName(), msg, tr);
    }

    /**
     * 打印 {@link #INFO} 级别的日志信息
     *
     * @param tag
     *            标识日志信息的来源，一般为打印日志的Class或者Activity名。
     * @param msg
     *            要输出的日志信息
     */
    public static int i(String tag, String msg) {
        if (display)
            return android.util.Log.i(tag, msg);
        return 0;
    }

    /**
     * 打印 {@link #INFO} 级别的日志信息
     *
     * @param obj
     *            标识日志信息的来源，自动获得obj的Class名作为日志来源的标识。一般传人<b>this</b>即可。
     * @param msg
     *            要输出的日志信息
     */
    public static int i(Object obj, String msg) {
        return i(getClassName(obj), msg);
    }

    /**
     * 打印 {@link #INFO} 级别的日志信息
     * <p>
     * 输出Tag为调用该方法的类的类名
     *
     * @param msg
     *            要输出的日志信息
     */
    public static int i(String msg) {
        return i(getClassName(), msg);
    }

    /**
     * 打印 {@link #INFO} 级别的日志及异常信息
     *
     * @param tag
     *            标识日志信息的来源，一般为打印日志的Class或者Activity名。
     * @param msg
     *            要输出的日志信息
     * @param tr
     *            要输出的日志信息
     */
    public static int i(String tag, String msg, Throwable tr) {
        if (display)
            return android.util.Log.i(tag, msg, tr);
        return 0;
    }

    /**
     * 打印 {@link #INFO} 级别的日志及异常信息
     *
     * @param obj
     *            标识日志信息的来源，自动获得obj的Class名作为日志来源的标识。一般传人<b>this</b>即可。
     * @param msg
     *            要输出的日志信息
     * @param tr
     *            要输出的日志信息
     */
    public static int i(Object obj, String msg, Throwable tr) {
        return i(getClassName(obj), msg, tr);
    }

    /**
     * 打印 {@link #INFO} 级别的日志及异常信息
     * <p>
     * 输出Tag为调用该方法的类的类名
     *
     * @param msg
     *            要输出的日志信息
     * @param tr
     *            要输出的日志信息
     */
    public static int i(String msg, Throwable tr) {
        return i(getClassName(), msg, tr);
    }

    /**
     * 打印 {@link #WARN} 级别的日志信息
     *
     * @param tag
     *            标识日志信息的来源，一般为打印日志的Class或者Activity名。
     * @param msg
     *            要输出的日志信息
     */
    public static int w(String tag, String msg) {
        if (display)
            return 0;
        return android.util.Log.w(tag, msg);
    }

    /**
     * 打印 {@link #WARN} 级别的日志信息
     *
     * @param obj
     *            标识日志信息的来源，自动获得obj的Class名作为日志来源的标识。一般传人<b>this</b>即可。
     * @param msg
     *            要输出的日志信息
     */
    public static int w(Object obj, String msg) {
        return w(getClassName(obj), msg);
    }

    /**
     * 打印 {@link #WARN} 级别的日志信息
     * <p>
     * 输出Tag为调用该方法的类的类名
     *
     * @param msg
     *            要输出的日志信息
     */
    public static int w(String msg) {
        return w(getClassName(), msg);
    }

    /**
     * 打印 {@link #WARN} 级别的日志及异常信息
     *
     * @param tag
     *            标识日志信息的来源，一般为打印日志的Class或者Activity名。
     * @param msg
     *            要输出的日志信息
     * @param tr
     *            要输出的日志信息
     */
    public static int w(String tag, String msg, Throwable tr) {
        if (display)
            return android.util.Log.w(tag, msg, tr);
        return 0;
    }

    /**
     * 打印 {@link #WARN} 级别的日志及异常信息
     *
     * @param obj
     *            标识日志信息的来源，自动获得obj的Class名作为日志来源的标识。一般传人<b>this</b>即可。
     * @param msg
     *            要输出的日志信息
     * @param tr
     *            要输出的日志信息
     */
    public static int w(Object obj, String msg, Throwable tr) {
        return w(getClassName(obj), msg, tr);
    }

    // /**
    // * 打印 {@link #WARN} 级别的日志及异常信息
    // *
    // * @param msg
    // * 要输出的日志信息
    // * @param tr
    // * 要输出的日志信息
    // */
    // public static int w(String msg, Throwable tr) {
    // return w(getClassName(), msg, tr);
    // }

    /**
     * 打印 {@link #WARN} 级别的日志及异常信息
     *
     * @param tag
     *            标识日志信息的来源，一般为打印日志的Class或者Activity名。
     * @param tr
     *            要输出的日志信息
     */
    public static int w(String tag, Throwable tr) {
        if (display)
            return android.util.Log.w(tag, tr);
        return 0;
    }

    /**
     * 打印 {@link #WARN} 级别的日志及异常信息
     *
     * @param obj
     *            标识日志信息的来源，自动获得obj的Class名作为日志来源的标识。一般传人<b>this</b>即可。
     * @param tr
     *            要输出的日志信息
     */
    public static int w(Object obj, Throwable tr) {
        return w(getClassName(obj), tr);
    }

    /**
     * 打印 {@link #WARN} 级别的日志及异常信息
     * <p>
     * 输出Tag为调用该方法的类的类名
     *
     * @param tr
     *            要输出的日志信息
     */
    public static int w(Throwable tr) {
        return w(getClassName(), tr);
    }

    /**
     * 打印 {@link #ERROR} 级别的日志信息
     *
     * @param tag
     *            标识日志信息的来源，一般为打印日志的Class或者Activity名。
     * @param msg
     *            要输出的日志信息
     */
    public static int e(String tag, String msg) {
        if (display)
            return android.util.Log.e(tag, msg);
        return 0;
    }

    /**
     * 打印 {@link #ERROR} 级别的日志信息
     *
     * @param obj
     *            标识日志信息的来源，自动获得obj的Class名作为日志来源的标识。一般传人<b>this</b>即可。
     * @param msg
     *            要输出的日志信息
     */
    public static int e(Object obj, String msg) {
        return e(getClassName(obj), msg);
    }

    /**
     * 打印 {@link #ERROR} 级别的日志信息
     * <p>
     * 输出Tag为调用该方法的类的类名
     *
     * @param msg
     *            要输出的日志信息
     */
    public static int e(String msg) {
        return e(getClassName(), msg);
    }

    /**
     * 打印 {@link #ERROR} 级别的日志及异常信息
     *
     * @param tag
     *            标识日志信息的来源，一般为打印日志的Class或者Activity名。
     * @param msg
     *            要输出的日志信息
     * @param tr
     *            要输出的日志信息
     */
    public static int e(String tag, String msg, Throwable tr) {
        if (display)
            return android.util.Log.e(tag, msg, tr);
        return 0;
    }

    /**
     * 打印 {@link #ERROR} 级别的日志及异常信息
     *
     * @param obj
     *            标识日志信息的来源，自动获得obj的Class名作为日志来源的标识。一般传人<b>this</b>即可。
     * @param msg
     *            要输出的日志信息
     * @param tr
     *            要输出的日志信息
     */
    public static int e(Object obj, String msg, Throwable tr) {
        return e(getClassName(obj), msg, tr);
    }

    /**
     * 打印 {@link #ERROR} 级别的日志及异常信息
     * <p>
     * 输出Tag为调用该方法的类的类名
     *
     * @param msg
     *            要输出的日志信息
     * @param tr
     *            要输出的日志信息
     */
    public static int e(String msg, Throwable tr) {
        return e(getClassName(), msg, tr);
    }

    /**
     * 获取第二层调用该方法的类的类名
     *
     * @return
     */
    private static String getClassName() {
        try {
            String name = new Exception().getStackTrace()[2].getClassName();
            return name.substring(name.lastIndexOf(".") + 1);
        } catch (Exception e) {
            e("L", "类名获取失败！", e);
        }
        return "Unkonw Class";
    }

    /**
     * 获取传入的obj实例的类的类名
     *
     * @param obj
     * @return
     */
    private static String getClassName(Object obj) {
        return obj.getClass().getSimpleName();
    }

}