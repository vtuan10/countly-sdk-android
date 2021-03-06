package ly.count.android.sdk;

import android.app.Application;
import android.content.Context;
import java.util.Map;

public class CountlyConfig {

    /**
     * Internal fields and fields for testing
     */

    protected CountlyStore countlyStore = null;

    protected boolean checkForNativeCrashDumps = true;

    //used to deliver this object to connection queue
    protected DeviceId deviceIdInstance = null;

    /**
     * Android context.
     * Mandatory field.
     */
    protected Context context = null;

    /**
     * URL of the Countly server to submit data to.
     * Mandatory field.
     */
    protected String serverURL = null;

    /**
     * app key for the application being tracked; find in the Countly Dashboard under Management &gt; Applications.
     * Mandatory field.
     */
    protected String appKey = null;

    /**
     * unique ID for the device the app is running on; note that null in deviceID means that Countly will fall back to OpenUDID, then, if it's not available, to Google Advertising ID.
     */
    protected String deviceID = null;

    /**
     * enum value specifying which device ID generation strategy Countly should use: OpenUDID or Google Advertising ID.
     */
    protected DeviceId.Type idMode = null;

    /**
     * sets the limit after how many sessions, for each apps version, the automatic star rating dialog is shown.
     */
    protected int starRatingSessionLimit = 5;

    /**
     * the callback function that will be called from the automatic star rating dialog.
     */
    protected StarRatingCallback starRatingCallback = null;

    /**
     * the shown title text for the star rating dialogs.
     */
    protected String starRatingTextTitle = null;

    /**
     * the shown message text for the star rating dialogs.
     */
    protected String starRatingTextMessage = null;

    /**
     * the shown dismiss button text for the shown star rating dialogs.
     */
    protected String starRatingTextDismiss = null;

    protected boolean loggingEnabled = false;

    protected boolean enableUnhandledCrashReporting = false;

    protected boolean enableViewTracking = false;

    protected boolean autoTrackingUseShortName = false;

    protected Class[] autoTrackingExceptions = null;

    protected Map<String, Object> automaticViewSegmentation = null;

    protected Map<String, String> customNetworkRequestHeaders = null;

    protected boolean pushIntentAddMetadata = false;

    protected boolean enableRemoteConfigAutomaticDownload = false;
    protected RemoteConfig.RemoteConfigCallback remoteConfigCallback = null;

    protected boolean shouldRequireConsent = false;
    protected String[] enabledFeatureNames = null;

    protected boolean httpPostForced = false;

    protected boolean temporaryDeviceIdEnabled = false;

    protected String tamperingProtectionSalt = null;

    protected Integer eventQueueSizeThreshold = null;

    protected boolean trackOrientationChange = false;

    protected boolean manualSessionControlEnabled = false;

    protected boolean recordAllThreadsWithCrash = false;

    protected boolean disableUpdateSessionRequests = false;

    protected boolean shouldIgnoreAppCrawlers = false;

    protected String[] appCrawlerNames = null;

    protected String[] publicKeyPinningCertificates = null;

    protected String[] certificatePinningCertificates = null;

    protected Boolean enableAttribution = null;

    protected Map<String, Object> customCrashSegment = null;

    protected Integer sessionUpdateTimerDelay = null;

    protected CrashFilterCallback crashFilterCallback;

    protected boolean starRatingDialogIsCancellable = false;

    protected boolean starRatingShownAutomatically = false;

    protected boolean starRatingDisableAskingForEachAppVersion = false;

    protected Application application = null;

    protected boolean recordAppStartTime = false;

    boolean disableLocation = false;

    String locationCountyCode = null;

    String locationCity = null;

    String locationLocation = null;

    String locationIpAddress = null;

    Map<String, String> metricOverride = null;

    Long appStartTimestampOverride = null;

    boolean appLoadedManualTrigger = false;

    boolean manualForegroundBackgroundTrigger = false;

    ModuleLog.LogCallback providedLogCallback;

    public CountlyConfig() {
    }

    /**
     * @param context
     * @param appKey
     * @param serverURL
     * @deprecated Please use the constructor that takes the application class
     */
    public CountlyConfig(Context context, String appKey, String serverURL) {
        setContext(context);
        setAppKey(appKey);
        setServerURL(serverURL);
    }

    public CountlyConfig(Application application, String appKey, String serverURL) {
        setContext(application.getApplicationContext());
        setAppKey(appKey);
        setServerURL(serverURL);
        setApplication(application);
    }

    /**
     * Android context.
     * Mandatory field.
     */
    public CountlyConfig setContext(Context context) {
        this.context = context;
        return this;
    }

    /**
     * URL of the Countly server to submit data to.
     * Mandatory field.
     */
    public CountlyConfig setServerURL(String serverURL) {
        this.serverURL = serverURL;
        return this;
    }

    /**
     * app key for the application being tracked; find in the Countly Dashboard under Management &gt; Applications.
     * Mandatory field.
     */
    public CountlyConfig setAppKey(String appKey) {
        this.appKey = appKey;
        return this;
    }

    /**
     * unique ID for the device the app is running on; note that null in deviceID means that Countly will fall back to OpenUDID, then, if it's not available, to Google Advertising ID.
     */
    public CountlyConfig setDeviceId(String deviceID) {
        this.deviceID = deviceID;
        return this;
    }

    /**
     * enum value specifying which device ID generation strategy Countly should use: OpenUDID or Google Advertising ID.
     */
    public CountlyConfig setIdMode(DeviceId.Type idMode) {
        this.idMode = idMode;
        return this;
    }

    /**
     * sets the limit after how many sessions, for each apps version, the automatic star rating dialog is shown.
     */
    public CountlyConfig setStarRatingSessionLimit(int starRatingLimit) {
        this.starRatingSessionLimit = starRatingLimit;
        return this;
    }

    /**
     * the callback function that will be called from the automatic star rating dialog.
     */
    public CountlyConfig setStarRatingCallback(StarRatingCallback starRatingCallback) {
        this.starRatingCallback = starRatingCallback;
        return this;
    }

    /**
     * the shown title text for the star rating dialogs.
     */
    public CountlyConfig setStarRatingTextTitle(String starRatingTextTitle) {
        this.starRatingTextTitle = starRatingTextTitle;
        return this;
    }

    /**
     * the shown message text for the star rating dialogs.
     */
    public CountlyConfig setStarRatingTextMessage(String starRatingTextMessage) {
        this.starRatingTextMessage = starRatingTextMessage;
        return this;
    }

    /**
     * the shown dismiss button text for the shown star rating dialogs.
     */
    public CountlyConfig setStarRatingTextDismiss(String starRatingTextDismiss) {
        this.starRatingTextDismiss = starRatingTextDismiss;
        return this;
    }

    /**
     * Set to true of you want to enable countly internal debugging logs
     * Those logs will be printed to the console
     *
     * @param enabled
     */
    public CountlyConfig setLoggingEnabled(boolean enabled) {
        this.loggingEnabled = enabled;
        return this;
    }

    /**
     * Call to enable uncaught crash reporting
     * @return
     */
    public CountlyConfig enableCrashReporting() {
        this.enableUnhandledCrashReporting = true;
        return this;
    }

    /**
     * Set if automatic view tracking should be enabled
     * @param enable
     * @return
     */
    public CountlyConfig setViewTracking(boolean enable) {
        this.enableViewTracking = enable;
        return this;
    }

    public CountlyConfig setAutoTrackingUseShortName(boolean enable) {
        this.autoTrackingUseShortName = enable;
        return this;
    }

    public CountlyConfig setAutomaticViewSegmentation(Map<String, Object> segmentation) {
        automaticViewSegmentation = segmentation;
        return this;
    }

    /**
     * Set which activities should be excluded from automatic view tracking
     *
     * @param exceptions activities which should be ignored
     * @return
     */
    public CountlyConfig setAutoTrackingExceptions(Class[] exceptions) {
        if (exceptions != null) {
            for (int a = 0; a < exceptions.length; a++) {
                if (exceptions[a] == null) {
                    throw new IllegalArgumentException("setAutoTrackingExceptions() does not accept 'null' activities");
                }
            }
        }

        autoTrackingExceptions = exceptions;
        return this;
    }

    public CountlyConfig addCustomNetworkRequestHeaders(Map<String, String> customHeaderValues) {
        this.customNetworkRequestHeaders = customHeaderValues;
        return this;
    }

    public CountlyConfig setPushIntentAddMetadata(boolean enable) {
        pushIntentAddMetadata = enable;
        return this;
    }

    public CountlyConfig setRemoteConfigAutomaticDownload(boolean enabled, RemoteConfig.RemoteConfigCallback callback) {
        enableRemoteConfigAutomaticDownload = enabled;
        remoteConfigCallback = callback;
        return this;
    }

    /**
     * Set if consent should be required
     *
     * @param shouldRequireConsent
     * @return
     */
    public CountlyConfig setRequiresConsent(boolean shouldRequireConsent) {
        this.shouldRequireConsent = shouldRequireConsent;
        return this;
    }

    /**
     * Sets which features are enabled in case consent is required
     *
     * @param featureNames
     * @return
     */
    public CountlyConfig setConsentEnabled(String[] featureNames) {
        enabledFeatureNames = featureNames;
        return this;
    }

    public CountlyConfig setHttpPostForced(boolean isForced) {
        httpPostForced = isForced;
        return this;
    }

    public CountlyConfig enableTemporaryDeviceIdMode() {
        temporaryDeviceIdEnabled = true;
        return this;
    }

    public CountlyConfig setCrashFilterCallback(CrashFilterCallback callback) {
        crashFilterCallback = callback;
        return this;
    }

    public CountlyConfig setParameterTamperingProtectionSalt(String salt) {
        tamperingProtectionSalt = salt;
        return this;
    }

    public CountlyConfig setTrackOrientationChanges(boolean shouldTrackOrientation) {
        trackOrientationChange = shouldTrackOrientation;
        return this;
    }

    public CountlyConfig setRecordAllThreadsWithCrash() {
        recordAllThreadsWithCrash = true;
        return this;
    }

    public CountlyConfig setEnableAttribution(boolean enableAttribution) {
        this.enableAttribution = enableAttribution;
        return this;
    }

    public CountlyConfig enablePublicKeyPinning(String[] certificates) {
        publicKeyPinningCertificates = certificates;
        return this;
    }

    public CountlyConfig enableCertificatePinning(String[] certificates) {
        certificatePinningCertificates = certificates;
        return this;
    }

    public CountlyConfig setShouldIgnoreAppCrawlers(boolean shouldIgnore) {
        shouldIgnoreAppCrawlers = shouldIgnore;
        return this;
    }

    public CountlyConfig setAppCrawlerNames(String[] appCrawlerNames) {
        this.appCrawlerNames = appCrawlerNames;
        return this;
    }

    /**
     * Set the threshold for event grouping. Event count that is bellow the
     * threshold will be send on update ticks.
     * @param threshold
     * @return
     */
    public CountlyConfig setEventQueueSizeToSend(int threshold) {
        eventQueueSizeThreshold = threshold;
        return this;
    }

    public CountlyConfig enableManualSessionControl() {
        manualSessionControlEnabled = true;
        return this;
    }

    public CountlyConfig setCustomCrashSegment(Map<String, Object> crashSegment) {
        customCrashSegment = crashSegment;
        return this;
    }

    protected CountlyConfig checkForNativeCrashDumps(boolean checkForDumps) {
        checkForNativeCrashDumps = checkForDumps;
        return this;
    }

    /**
     * Sets the interval for the automatic session update calls
     * min value 1 (1 second),
     * max value 600 (10 minutes)
     *
     * @param delay in seconds
     * @return
     */
    public CountlyConfig setUpdateSessionTimerDelay(int delay) {
        sessionUpdateTimerDelay = delay;
        return this;
    }

    protected CountlyConfig setCountlyStore(CountlyStore store) {
        countlyStore = store;
        return this;
    }

    protected CountlyConfig setDisableUpdateSessionRequests(boolean disable) {
        disableUpdateSessionRequests = disable;
        return this;
    }

    /**
     * Set if the star rating dialog is cancellable
     *
     * @param isCancellable set this true if it should be cancellable
     */
    public synchronized CountlyConfig setIfStarRatingDialogIsCancellable(boolean isCancellable) {
        starRatingDialogIsCancellable = isCancellable;
        return this;
    }

    /**
     * Set if the star rating should be shown automatically
     *
     * @param isShownAutomatically set it true if you want to show the app star rating dialog automatically for each new version after the specified session amount
     */
    public synchronized CountlyConfig setIfStarRatingShownAutomatically(boolean isShownAutomatically) {
        starRatingShownAutomatically = isShownAutomatically;
        return this;
    }

    /**
     * Set if the star rating is shown only once per app lifetime
     *
     * @param disableAsking set true if you want to disable asking the app rating for each new app version (show it only once per apps lifetime)
     */
    public synchronized CountlyConfig setStarRatingDisableAskingForEachAppVersion(boolean disableAsking) {
        starRatingDisableAskingForEachAppVersion = disableAsking;
        return this;
    }

    /**
     * Set the link to the application class
     * @param application
     * @return
     */
    public synchronized CountlyConfig setApplication(Application application) {
        this.application = application;
        return this;
    }

    /**
     * Enable the recording of the app start time
     * @param recordAppStartTime
     * @return
     */
    public synchronized CountlyConfig setRecordAppStartTime(boolean recordAppStartTime) {
        this.recordAppStartTime = recordAppStartTime;
        return this;
    }

    /**
     * Disable location tracking
     * @return
     */
    public synchronized CountlyConfig setDisableLocation() {
        disableLocation = true;
        return this;
    }

    /**
     * Set location parameters.
     * This will be ignored if set together with `setDisableLocation`
     *
     * @param country_code ISO Country code for the user's country
     * @param city Name of the user's city
     * @param gpsCoordinates comma separate lat and lng values. For example, "56.42345,123.45325"
     */
    public synchronized CountlyConfig setLocation(String country_code, String city, String gpsCoordinates, String ipAddress) {
        locationCountyCode = country_code;
        locationCity = city;
        locationLocation = gpsCoordinates;
        locationIpAddress = ipAddress;
        return this;
    }

    /**
     * Set the metrics you want to override or additional custom metrics you want to provide
     * @param providedMetricOverride
     * @return
     */
    public synchronized CountlyConfig setMetricOverride(Map<String, String> providedMetricOverride) {
        metricOverride = providedMetricOverride;
        return this;
    }

    /**
     * Override the app start timestamp in case you have a more precise way to measure it
     * @param appStartTimestampOverride
     * @return
     */
    public synchronized CountlyConfig setAppStartTimestampOverride(long appStartTimestampOverride) {
        this.appStartTimestampOverride = appStartTimestampOverride;
        return this;
    }

    /**
     * Set to manually trigger the moment when the app has finished loading
     * @return
     */
    public synchronized CountlyConfig enableManualAppLoadedTrigger() {
        appLoadedManualTrigger = true;
        return this;
    }

    /**
     * Set this in case you want to control these triggers manually
     * @return
     */
    public synchronized CountlyConfig enableManualForegroundBackgroundTriggerAPM() {
        manualForegroundBackgroundTrigger = true;
        return this;
    }

    /**
     * Add a log callback that will duplicate all logs done by the SDK.
     * For each message you will receive the message string and it's targeted log level.
     * @param logCallback
     * @return
     */
    public synchronized CountlyConfig setLogListener(ModuleLog.LogCallback logCallback) {
        providedLogCallback = logCallback;
        return this;
    }
}
