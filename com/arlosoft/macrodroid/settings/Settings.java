package com.arlosoft.macrodroid.settings;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.hardware.Camera;
import android.net.Uri;
import android.os.Build;
import android.os.Environment;
import android.preference.PreferenceManager;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.exifinterface.media.ExifInterface;
import com.arlosoft.macrodroid.BuildConfig;
import com.arlosoft.macrodroid.R;
import com.arlosoft.macrodroid.analytics.FirebaseAnalyticsEventLogger;
import com.arlosoft.macrodroid.common.CalendarEvent;
import com.arlosoft.macrodroid.common.MagicText;
import com.arlosoft.macrodroid.common.NotificationButton;
import com.arlosoft.macrodroid.common.SimpleEncryption;
import com.arlosoft.macrodroid.confirmation.validation.ExtraSubscriptions;
import com.arlosoft.macrodroid.data.SmtpServerConfig;
import com.arlosoft.macrodroid.drawer.model.DrawerConfiguration;
import com.arlosoft.macrodroid.freeversion.DataSharingService;
import com.arlosoft.macrodroid.gson.GsonUtils;
import com.arlosoft.macrodroid.logging.systemlog.LogFilter;
import com.arlosoft.macrodroid.logging.systemlog.SystemLog;
import com.arlosoft.macrodroid.macro.DamnYouPirates;
import com.arlosoft.macrodroid.templatestore.model.User;
import com.arlosoft.macrodroid.triggers.LocationTrigger;
import com.arlosoft.macrodroid.triggers.services.LocationTriggerAreaChecker;
import com.google.android.gms.maps.model.LatLng;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import com.google.mlkit.nl.translate.TranslateLanguage;
import java.io.File;
import java.math.BigInteger;
import java.nio.charset.Charset;
import java.text.Collator;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Locale;
import java.util.Objects;
import java.util.Random;
import java.util.Set;
import java.util.StringTokenizer;
import java.util.UUID;

/* loaded from: classes3.dex */
public class Settings {
    public static final String BASE_64_PURCHASE_KEY_PART_1 = "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKC";
    public static final String EXTRA_CHUNK = "extra_chunk";
    public static final String EXTRA_IV = "chopup";
    public static final int KEYGUARD_DISABLED = 2;
    public static final int KEYGUARD_ENABLED = 1;
    public static final int KEYGUARD_NOT_SET = 0;
    public static final String LANGUAGE_NONE = "None Available";
    public static final String LEGACY_PRO_UPGRADE_WARNING_COUNT = "legacy_upgrade_warning_count";
    public static final String OBFUSCATED_PURCHASE_DEFAULT = "utc_check_enabled";
    public static final String OBFUSCATED_PURCHASE_KEY_2 = "vcp_count";
    public static final String PACKAGE_NONE = "none";
    public static final String PREFERENCE_ACTIVITY_RECOGNITION_UPDATE_RATE = "preferences:activity_recognition_update_rate";
    public static final String PREFERENCE_CELL_TOWER_UPDATE_RATE = "preferences:cell_tower_update_rate";
    public static final String PREFERENCE_CLOSE_APP = "preferences:close";
    public static final String PREFERENCE_CONFIGURE_NOTIFICATION_BUTTON_BAR = "preferences:configure_notification_button_bar";
    public static final String PREFERENCE_CONFIGURE_SUNRISE_SUNSET_LOCATION = "preferences:sunrise_sunset_location";
    public static final String PREFERENCE_CONFIGURE_WEATHER_LOCATION = "preferences:weather_location";
    public static final String PREFERENCE_DEVICE_FACING_SCREEN_OFF = "device_facing_constraint_screen_off";
    public static final String PREFERENCE_DONATE = "preferences:donate";
    public static final String PREFERENCE_DRAWER_ENABLED = "preferences:draw_enabled";
    public static final String PREFERENCE_DRAWER_SWIPE_DOWN_TO_OPEN = "preferences:swipe_down_to_open";
    public static final String PREFERENCE_DRAWER_SWIPE_HORIZONTALLY_TO_OPEN = "preferences:swipe_horizontally_to_open";
    public static final String PREFERENCE_DRAWER_SWIPE_UP_TO_OPEN = "preferences:swipe_up_to_open";
    public static final String PREFERENCE_EDIT_CATEGORIES = "preferences:edit_categories";
    public static final String PREFERENCE_EDIT_CUSTOM_MODES = "preferences:edit_custom_modes";
    public static final String PREFERENCE_EMAIL_GMAIL_ACCOUNT = "preferences:gmail_account";
    public static final String PREFERENCE_EMAIL_PASSWORD = "preferences:email_password";
    public static final String PREFERENCE_EMAIL_USE_PASSWORD = "preferences:email_use_password";
    public static final String PREFERENCE_EXPORT_OPTION = "preferences:export_preferences";
    public static final String PREFERENCE_EXTRAS_ENABLED = "ee";
    public static final String PREFERENCE_FACEBOOK = "preferences:facebook";
    public static final String PREFERENCE_FLIP_DEVICE_SCREEN_OFF = "preferences:flip_device_screen_off";
    public static final String PREFERENCE_FORCE_API_22_APP_LAUNCHED_TRIGGER = "preferences:api_22_app_launched_trigger";
    public static final String PREFERENCE_FORCE_HIDE_ICON = "preferences:force_hide_icon";
    public static final String PREFERENCE_FORCE_LANGUAGE_CODE = "preferences:force_language_code";
    public static final String PREFERENCE_FORCE_ROOT_HELPER = "preferences:force_root_helper_file";
    public static final String PREFERENCE_FOREGROUND_SERVICE = "preferences:foreground_service_2";
    public static final String PREFERENCE_HIDDEN_MICROPHONE_RECORDING = "preferences:hidden_microphone_recording";
    public static final String PREFERENCE_HOME_SCREEN_TILES_PER_ROW = "preferences:home_screen_tiles_per_row";
    public static final String PREFERENCE_HOME_SCREEN_TILES_PER_ROW_LANDSCAPE = "preferences:home_screen_tiles_per_row_landscape";
    public static final String PREFERENCE_LIGHT_SENSOR_BG_UPDATE_RATE = "preferences:light_sensor_bg_update_rate";
    public static final String PREFERENCE_LOC_UPDATE_RATE = "preferences:location_update_rate";
    public static final String PREFERENCE_LOC_UPDATE_RATE_SECONDS = "preferences:location_update_rate_seconds";
    public static final String PREFERENCE_NOTIFICATION_LIST_MACROS = "preferences:notification_list_macros";
    public static final String PREFERENCE_NOTIFICATION_PRIORITY = "preferences:notification_priority";
    public static final String PREFERENCE_PASSWORD_PROTECT = "preferences:password_protect";
    public static final String PREFERENCE_PEBBLE_INSTALL_WATCH_APP = "preferences:pebble_install_watchapp";
    public static final String PREFERENCE_PHOTO_IN_GALLERY = "preferences:photos_in_gallery";
    public static final String PREFERENCE_POWER_BUTTON_TOGGLE_TIMEOUT = "preferences:power_button_toggle_timeout";
    public static final String PREFERENCE_PROXIMITY_SENSOR_SCREEN_OFF = "preferences:proximity_sensor_screen_off";
    public static final String PREFERENCE_READ_SCREEN_CONTENTS_UPDATE_RATE = "preferences:read_screen_contents_update_rate";
    public static final String PREFERENCE_ROOT_ENABLED = "preferences:show_root";
    public static final String PREFERENCE_SET_LANGUAGE = "preferences:force_language";
    public static final String PREFERENCE_SHAKE_SAMPLE_FREQUENCY = "preferences:shake_detect_frequency";
    public static final String PREFERENCE_SHAKE_SCREEN_OFF = "preferences:shake_screen_off";
    public static final String PREFERENCE_SHAKE_SENSITIVITY = "preferences:shake_sensitivity";
    public static final String PREFERENCE_SHOW_JAVASCRIPT_VARIABLE_WARNING = "preferences:show_javascript_variable_warning";
    public static final String PREFERENCE_SHOW_LOCATION_SERVICES_WARNING = "preferences:show_location_services_warning";
    public static final String PREFERENCE_SHOW_NOTIFICATION_BUTTON_BAR = "preferences:show_notification_button_bar";
    public static final String PREFERENCE_SPOKEN_LANGUAGE = "preferences:spoken_langugage";
    public static final String PREFERENCE_SPOKEN_LOCALE = "preferences:spoken_locale";
    public static final String PREFERENCE_SYSTEM_LOG_LENGTH = "preferences:system_log_length";
    public static final String PREFERENCE_TAKE_PICTURE_ACTION = "preferences:picture_quality_screen";
    public static final String PREFERENCE_TTS_ENGINE = "preferences:texttospeech_engine";
    public static final String PREFERENCE_TWITTER = "preferences:twitter";
    public static final String PREFERENCE_WEATHER_UPDATE_RATE = "preferences:weather_update_rate";
    public static final String PREFERENCE_WIFI_BACKGROUND_SCAN_RATE = "preferences:wifi_background_scan_rate";
    public static final String PRO_UPGRADE_PREFIX = "com.arlosoft.macrodroid.pro";
    public static final int PURCHASE_ACK_COMPLETE = 2;
    public static final int PURCHASE_ACK_NOT_REQUIRED = 0;
    public static final int PURCHASE_ACK_PENDING = 1;
    public static final String TIMESTAMP_FOR_NEXT_PRO_USER_CHECK = "random_generator_seed_part";
    public static final Locale[] PREFERENCE_LANGUAGE_LOCALES = {new Locale(TranslateLanguage.BULGARIAN), new Locale(TranslateLanguage.CATALAN), new Locale(TranslateLanguage.CZECH), Locale.GERMAN, Locale.ENGLISH, new Locale(TranslateLanguage.SPANISH), Locale.FRENCH, new Locale(TranslateLanguage.HUNGARIAN), Locale.ITALIAN, new Locale(TranslateLanguage.DUTCH), new Locale(TranslateLanguage.POLISH), new Locale(TranslateLanguage.PORTUGUESE), new Locale(TranslateLanguage.RUSSIAN), new Locale(TranslateLanguage.ROMANIAN), new Locale(TranslateLanguage.SWEDISH), new Locale(TranslateLanguage.TURKISH), new Locale(TranslateLanguage.UKRAINIAN), new Locale(TranslateLanguage.ARABIC), new Locale(TranslateLanguage.PERSIAN), Locale.JAPANESE, new Locale("zh-rCN"), new Locale(TranslateLanguage.VIETNAMESE), new Locale(TranslateLanguage.KOREAN), new Locale("in")};
    public static final Locale[] SUPPORTED_LOCALES = {new Locale("en", "us"), new Locale("en", "gb"), new Locale("en", "in"), new Locale("en", "au"), Locale.FRENCH, Locale.GERMAN, Locale.ITALIAN, new Locale(TranslateLanguage.SPANISH, TranslateLanguage.SPANISH), new Locale(TranslateLanguage.PORTUGUESE), new Locale(TranslateLanguage.PORTUGUESE, "br"), new Locale(TranslateLanguage.DANISH), new Locale(TranslateLanguage.SWEDISH), new Locale(TranslateLanguage.NORWEGIAN), new Locale(TranslateLanguage.FINNISH), new Locale(TranslateLanguage.DUTCH), new Locale(TranslateLanguage.POLISH), new Locale(TranslateLanguage.JAPANESE), new Locale(TranslateLanguage.KOREAN), new Locale(TranslateLanguage.TURKISH), new Locale(TranslateLanguage.CZECH), new Locale(TranslateLanguage.HUNGARIAN), new Locale(TranslateLanguage.GREEK), new Locale(TranslateLanguage.RUSSIAN), new Locale(TranslateLanguage.SPANISH, "mx"), new Locale("in"), new Locale(TranslateLanguage.HUNGARIAN, "HU"), new Locale(TranslateLanguage.ROMANIAN), new Locale(TranslateLanguage.SLOVAK), new Locale(TranslateLanguage.CHINESE), new Locale(TranslateLanguage.VIETNAMESE), new Locale(TranslateLanguage.ARABIC), new Locale(TranslateLanguage.GREEK), new Locale("iw"), new Locale("sr"), new Locale("nb"), new Locale(TranslateLanguage.SLOVENIAN), new Locale(TranslateLanguage.UKRAINIAN), new Locale(TranslateLanguage.THAI), new Locale(TranslateLanguage.HINDI), new Locale(TranslateLanguage.PERSIAN), new Locale(TranslateLanguage.HEBREW), new Locale(TranslateLanguage.BULGARIAN), new Locale(TranslateLanguage.CATALAN), new Locale(TranslateLanguage.BENGALI), new Locale(TranslateLanguage.HEBREW)};

    /* loaded from: classes3.dex */
    class a extends TypeToken<ArrayList<String>> {
        a() {
        }
    }

    /* loaded from: classes3.dex */
    class b extends TypeToken<HashMap<String, List<CalendarEvent>>> {
        b() {
        }
    }

    public static boolean areExperimentalFeaturesEnabled(Context context) {
        return PreferenceManager.getDefaultSharedPreferences(context).getBoolean("preferences:enable_experimental_features", false);
    }

    private static String b() {
        return new BigInteger(UUID.randomUUID().toString().replaceAll("-", ""), 16).toString(36);
    }

    private static Locale c(Context context) {
        String forcedLanguage = getForcedLanguage(context);
        if (forcedLanguage != null) {
            String[] stringArray = context.getResources().getStringArray(R.array.languages);
            int i4 = 0;
            while (true) {
                if (i4 < stringArray.length) {
                    if (stringArray[i4].equals(forcedLanguage)) {
                        break;
                    }
                    i4++;
                } else {
                    i4 = -1;
                    break;
                }
            }
            if (i4 >= 0) {
                return PREFERENCE_LANGUAGE_LOCALES[i4];
            }
        }
        return null;
    }

    private static List<String> e(Context context, int i4) {
        ArrayList arrayList = new ArrayList();
        try {
            Camera open = Camera.open(i4);
            List<Camera.Size> supportedPictureSizes = open.getParameters().getSupportedPictureSizes();
            for (int i5 = 0; i5 < supportedPictureSizes.size(); i5++) {
                arrayList.add(supportedPictureSizes.get(i5).width + "," + supportedPictureSizes.get(i5).height);
            }
            open.release();
        } catch (Exception e4) {
            SystemLog.logError("Could not look up camera resolutions: " + e4.toString());
        }
        return arrayList;
    }

    public static void enableAllInfoCards(Context context) {
        PreferenceManager.getDefaultSharedPreferences(context).edit().putBoolean("preferences:hide_info_card_trigger", false).apply();
        PreferenceManager.getDefaultSharedPreferences(context).edit().putBoolean("preferences:hide_info_card_notification_bar", false).apply();
        PreferenceManager.getDefaultSharedPreferences(context).edit().putBoolean("preferences:hide_info_card_action", false).apply();
        PreferenceManager.getDefaultSharedPreferences(context).edit().putBoolean("preferences:hide_info_card_constraint", false).apply();
        PreferenceManager.getDefaultSharedPreferences(context).edit().putBoolean("preferences:hide_info_card_variables", false).apply();
        PreferenceManager.getDefaultSharedPreferences(context).edit().putBoolean("preferences:hide_info_card_cell_towers", false).apply();
        PreferenceManager.getDefaultSharedPreferences(context).edit().putBoolean("preferences:hide_info_card_geofences", false).apply();
        PreferenceManager.getDefaultSharedPreferences(context).edit().putBoolean("preferences:hide_info_card_user_log", false).apply();
        PreferenceManager.getDefaultSharedPreferences(context).edit().putBoolean("preferences:hide_info_card_system_log", false).apply();
        PreferenceManager.getDefaultSharedPreferences(context).edit().putBoolean("preference:hide_info_card_action_blocks", false).apply();
        PreferenceManager.getDefaultSharedPreferences(context).edit().putBoolean("preferences:hide_info_card_quick_settings", false).apply();
        PreferenceManager.getDefaultSharedPreferences(context).edit().putBoolean("preferences:hide_info_card_keep_accessibility_running", false).apply();
        PreferenceManager.getDefaultSharedPreferences(context).edit().putBoolean("preferences:hide_info_card_drawer", false).apply();
        PreferenceManager.getDefaultSharedPreferences(context).edit().putBoolean("preferences:hide_info_card_auto_backup", false).apply();
        PreferenceManager.getDefaultSharedPreferences(context).edit().putBoolean("preferences:hide_info_card_categories", false).apply();
        PreferenceManager.getDefaultSharedPreferences(context).edit().putBoolean("preferences:hide_info_card_recent_towers", false).apply();
        PreferenceManager.getDefaultSharedPreferences(context).edit().putBoolean("preferences:hide_info_card_ignored_cell_towers", false).apply();
    }

    public static boolean getAPI22AppLaunchTrigger(Context context) {
        return PreferenceManager.getDefaultSharedPreferences(context).getBoolean(PREFERENCE_FORCE_API_22_APP_LAUNCHED_TRIGGER, false);
    }

    public static List<String> getAccessibilityServicesToKeepRunning(Context context) {
        return new ArrayList(PreferenceManager.getDefaultSharedPreferences(context).getStringSet("accessibility_services_to_keep_running", new HashSet()));
    }

    public static boolean getActionLoggingEnabled(Context context) {
        return PreferenceManager.getDefaultSharedPreferences(context).getBoolean("preferences:action_logging", true);
    }

    public static int getActivityRecognitionUpdateRate(Context context) {
        try {
            return Integer.valueOf(PreferenceManager.getDefaultSharedPreferences(context).getString(PREFERENCE_ACTIVITY_RECOGNITION_UPDATE_RATE, "120")).intValue();
        } catch (Exception e4) {
            FirebaseAnalyticsEventLogger.logHandledException(new RuntimeException("Failed to convert activity recognition rate value into integer: " + e4.getMessage()));
            return 120;
        }
    }

    public static String getAnonymousUserId(Context context) {
        String string = PreferenceManager.getDefaultSharedPreferences(context).getString("user_id", null);
        if (string == null) {
            String b4 = b();
            PreferenceManager.getDefaultSharedPreferences(context).edit().putString("user_id", b4).apply();
            return b4;
        }
        return string;
    }

    public static int getAppLaunchCount(Context context) {
        return PreferenceManager.getDefaultSharedPreferences(context).getInt("app_launch_count", 0);
    }

    public static boolean getAppLaunchPreventNotifications(Context context) {
        return PreferenceManager.getDefaultSharedPreferences(context).getBoolean("preferences:app_launch_prevent_notifications", false);
    }

    public static boolean getAtomicVarFileMigrated(Context context) {
        return PreferenceManager.getDefaultSharedPreferences(context).getBoolean("preferences:atomicFileMigrated", false);
    }

    public static boolean getAutoBackupEncryptionEnabled(Context context) {
        return PreferenceManager.getDefaultSharedPreferences(context).getBoolean("ab_e", false);
    }

    public static String getAutoBackupEncryptionPassword(Context context) {
        return PreferenceManager.getDefaultSharedPreferences(context).getString("ab_p", "");
    }

    public static boolean getAutoBackupsEnabled(Context context) {
        return PreferenceManager.getDefaultSharedPreferences(context).getBoolean("prefrences:auto_backups_enabled", true);
    }

    public static boolean getAutoTranslateTemplates(Context context) {
        return PreferenceManager.getDefaultSharedPreferences(context).getBoolean("preferences:auto_translate_templates", false);
    }

    public static boolean getBiometricsEnabled(Context context) {
        return PreferenceManager.getDefaultSharedPreferences(context).getBoolean("biometrics_enabled", false);
    }

    public static boolean getButtonBarBlackBg(Context context) {
        return PreferenceManager.getDefaultSharedPreferences(context).getBoolean("preferences:notification_button_bar_black_bg", false);
    }

    public static int getButtonBarIconTint(Context context) {
        int i4;
        SharedPreferences defaultSharedPreferences = PreferenceManager.getDefaultSharedPreferences(context);
        if ((context.getResources().getConfiguration().uiMode & 48) != 32 && !getButtonBarBlackBg(context)) {
            i4 = -16777216;
        } else {
            i4 = -1;
        }
        return defaultSharedPreferences.getInt("preferences:notificaiton_button_bar_icon_tint", i4);
    }

    public static List<String> getCameraResolutions(Context context, int i4) {
        ArrayList arrayList = new ArrayList();
        SharedPreferences defaultSharedPreferences = PreferenceManager.getDefaultSharedPreferences(context);
        String string = defaultSharedPreferences.getString("preferences:camera_supported_resolutions" + i4, "");
        if (string.length() == 0) {
            List<String> e4 = e(context, i4);
            StringBuilder sb = new StringBuilder();
            for (String str : e4) {
                sb.append(str);
                sb.append(":");
            }
            SharedPreferences.Editor edit = defaultSharedPreferences.edit();
            edit.putString("preferences:camera_supported_resolutions" + i4, sb.toString());
            edit.apply();
            return e4;
        }
        try {
            StringTokenizer stringTokenizer = new StringTokenizer(string, ":");
            while (stringTokenizer.hasMoreTokens()) {
                String nextToken = stringTokenizer.nextToken();
                if (nextToken.length() > 0) {
                    arrayList.add(nextToken);
                }
            }
            return arrayList;
        } catch (Exception e5) {
            List<String> e6 = e(context, i4);
            FirebaseAnalyticsEventLogger.logHandledException(new RuntimeException("Exception tokenizing: " + e5.getMessage()));
            return e6;
        }
    }

    @Nullable
    public static boolean getCanShowFlashNotification(Context context) {
        return PreferenceManager.getDefaultSharedPreferences(context).getBoolean("can_show_flash", true);
    }

    public static boolean getCanShowUpgradeOnLaunch(Context context) {
        return PreferenceManager.getDefaultSharedPreferences(context).getBoolean("show_upgrade_on_launch", true);
    }

    public static List<String> getCategories(Context context) {
        SharedPreferences defaultSharedPreferences = PreferenceManager.getDefaultSharedPreferences(context);
        if (defaultSharedPreferences.getString("preferences:user_categories", null) == null) {
            List<String> categoriesLegacy = getCategoriesLegacy(context);
            setCategories(context, categoriesLegacy);
            return categoriesLegacy;
        }
        String string = defaultSharedPreferences.getString("preferences:user_categories", null);
        if (string != null) {
            try {
                return (List) new GsonBuilder().create().fromJson(string, new a().getType());
            } catch (Exception e4) {
                SystemLog.logError("Failed to load category list: " + e4.toString());
            }
        }
        List<String> categoriesLegacy2 = getCategoriesLegacy(context);
        setCategories(context, categoriesLegacy2);
        return categoriesLegacy2;
    }

    public static List<String> getCategoriesLegacy(Context context) {
        String string = PreferenceManager.getDefaultSharedPreferences(context).getString("preferences:default_categories", context.getString(R.string.uncategorized) + ":" + context.getString(R.string.categories_auto_and_vehicles) + ":" + context.getString(R.string.categories_battery_saving) + ":" + context.getString(R.string.categories_call_handling) + ":" + context.getString(R.string.categories_communication) + ":" + context.getString(R.string.categories_device_config) + ":" + context.getString(R.string.categories_entertainment) + ":" + context.getString(R.string.categories_games) + ":" + context.getString(R.string.categories_health_and_fitness) + ":" + context.getString(R.string.categories_house_and_home) + ":" + context.getString(R.string.categories_location_based) + ":" + context.getString(R.string.categories_maps_and_navigation) + ":" + context.getString(R.string.categories_miscellaneous) + ":" + context.getString(R.string.categories_music_and_audio) + ":" + context.getString(R.string.categories_news) + ":" + context.getString(R.string.categories_notifications) + ":" + context.getString(R.string.categories_personalisation) + ":" + context.getString(R.string.categories_photography) + ":" + context.getString(R.string.categories_productivity) + ":" + context.getString(R.string.categories_quick_setting_tiles) + ":" + context.getString(R.string.categories_security) + ":" + context.getString(R.string.categories_shopping) + ":" + context.getString(R.string.categories_social) + ":" + context.getString(R.string.categories_sport) + ":" + context.getString(R.string.categories_utilities) + ":" + context.getString(R.string.categories_video) + ":" + context.getString(R.string.categories_weather) + ":");
        ArrayList arrayList = new ArrayList();
        StringTokenizer stringTokenizer = new StringTokenizer(string, ":");
        while (stringTokenizer.hasMoreTokens()) {
            String nextToken = stringTokenizer.nextToken();
            if (nextToken.length() > 0) {
                arrayList.add(nextToken);
            }
        }
        final Collator collator = Collator.getInstance(getLocale(context));
        collator.setStrength(0);
        Collections.sort(arrayList, new Comparator() { // from class: com.arlosoft.macrodroid.settings.e2
            @Override // java.util.Comparator
            public final int compare(Object obj, Object obj2) {
                int compare;
                compare = collator.compare((String) obj, (String) obj2);
                return compare;
            }
        });
        return arrayList;
    }

    public static int getCellTowerUpdateRate(Context context) {
        try {
            return Integer.valueOf(PreferenceManager.getDefaultSharedPreferences(context).getString(PREFERENCE_CELL_TOWER_UPDATE_RATE, ExifInterface.GPS_MEASUREMENT_2D)).intValue();
        } catch (Exception e4) {
            FirebaseAnalyticsEventLogger.logHandledException(new RuntimeException("Failed to convert cell tower update rate value into integer: " + e4.getMessage()));
            return 0;
        }
    }

    public static boolean getCellTowerUseAlarm(Context context) {
        return PreferenceManager.getDefaultSharedPreferences(context).getBoolean("preferences:cell_tower_use_alarm", false);
    }

    public static boolean getClipboardTriggerUseLogcat(Context context) {
        boolean z3;
        SharedPreferences defaultSharedPreferences = PreferenceManager.getDefaultSharedPreferences(context);
        if (Build.VERSION.SDK_INT >= 29) {
            z3 = true;
        } else {
            z3 = false;
        }
        return defaultSharedPreferences.getBoolean("clipboard_use_logcat", z3);
    }

    public static boolean getCloudBackupsEnabled(Context context) {
        return PreferenceManager.getDefaultSharedPreferences(context).getBoolean("prefrences:cloud_backups_enabled", true);
    }

    public static String getCloudBackupsId(Context context) {
        return PreferenceManager.getDefaultSharedPreferences(context).getString("prefernces:cloud_backup_id", null);
    }

    public static boolean getCollapseCategoriesDefault(Context context) {
        return PreferenceManager.getDefaultSharedPreferences(context).getBoolean("preferences:collapseCategoriesDefault", false);
    }

    public static boolean getCommercialPurchasesRequired(Context context) {
        if (PreferenceManager.getDefaultSharedPreferences(context).getString("cps", getUniqueId(context, false).substring(3, 8)).equals(getUniqueId(context, false).substring(3, 8))) {
            return false;
        }
        return true;
    }

    public static boolean getConstraintLoggingEnabled(Context context) {
        return PreferenceManager.getDefaultSharedPreferences(context).getBoolean("preferences:constraint_logging", true);
    }

    public static String getCurrentFgPackage(Context context) {
        return PreferenceManager.getDefaultSharedPreferences(context).getString("current_fg_package", "none");
    }

    public static String getCurrentLanguageTag(Context context) {
        return PreferenceManager.getDefaultSharedPreferences(context).getString("preferences:current_language_tag", null);
    }

    public static int getCurrentLogFile(Context context) {
        return PreferenceManager.getDefaultSharedPreferences(context).getInt("preferences:active_log", 1);
    }

    public static int getCurrentUpgradeBanner(Context context) {
        return PreferenceManager.getDefaultSharedPreferences(context).getInt("current_upgrade_banner", 0);
    }

    public static String getDarkMode(Context context) {
        return PreferenceManager.getDefaultSharedPreferences(context).getString("preferences:dark_mode", String.valueOf(-1));
    }

    public static DataSharingService getDataSharingService(Context context) {
        return DataSharingService.fromServiceName(PreferenceManager.getDefaultSharedPreferences(context).getString("data_sharing_service", ""));
    }

    public static boolean getDeviceFacingWorkWithScreenOff(Context context) {
        return PreferenceManager.getDefaultSharedPreferences(context).getBoolean(PREFERENCE_DEVICE_FACING_SCREEN_OFF, false);
    }

    public static Set<String> getDisabledCategories(Context context) {
        String string = PreferenceManager.getDefaultSharedPreferences(context).getString("preferences:disabled_categories", "");
        HashSet hashSet = new HashSet();
        StringTokenizer stringTokenizer = new StringTokenizer(string, ":");
        while (stringTokenizer.hasMoreTokens()) {
            String nextToken = stringTokenizer.nextToken();
            if (nextToken.length() > 0) {
                hashSet.add(nextToken.replace("<>COLON<>", ":"));
            }
        }
        return hashSet;
    }

    public static boolean getDrawerAutoClose(Context context) {
        return PreferenceManager.getDefaultSharedPreferences(context).getBoolean("preferences:drawer_auto_close", false);
    }

    public static int getDrawerAutoCloseTimeoutSeconds(Context context) {
        try {
            return Integer.valueOf(PreferenceManager.getDefaultSharedPreferences(context).getString("preferences:drawer_auto_close_timeout", "5")).intValue();
        } catch (Exception unused) {
            return Integer.MAX_VALUE;
        }
    }

    public static DrawerConfiguration getDrawerConfiguration(Context context) {
        String string = PreferenceManager.getDefaultSharedPreferences(context).getString("preferences:drawer_configuration", null);
        if (string != null) {
            return (DrawerConfiguration) GsonUtils.getDrawerItemGson().fromJson(string, (Class<Object>) DrawerConfiguration.class);
        }
        return DrawerConfiguration.getDefaultConfiguration(context);
    }

    public static int getDrawerTextSize(Context context) {
        return Integer.parseInt(PreferenceManager.getDefaultSharedPreferences(context).getString("preferences:drawer_text_size", "14"));
    }

    public static boolean getEditMacroSmallMode(Context context) {
        return PreferenceManager.getDefaultSharedPreferences(context).getBoolean("preferences:edit_macro_small_mode", false);
    }

    public static boolean getEditModeInfoCardHide(Context context) {
        return PreferenceManager.getDefaultSharedPreferences(context).getBoolean("preferences:edit_modes_card_hide", false);
    }

    public static String getEmailGmailAddress(Context context) {
        return PreferenceManager.getDefaultSharedPreferences(context).getString(PREFERENCE_EMAIL_GMAIL_ACCOUNT, null);
    }

    public static boolean getEmailNotifyFailure(Context context) {
        return PreferenceManager.getDefaultSharedPreferences(context).getBoolean("preferences:send_email_notify_failure", false);
    }

    public static boolean getEmailNotifySuccess(Context context) {
        return PreferenceManager.getDefaultSharedPreferences(context).getBoolean("preferences:send_email_notify_success", false);
    }

    public static String getEmailPassword(Context context) {
        String string = PreferenceManager.getDefaultSharedPreferences(context).getString(PREFERENCE_EMAIL_PASSWORD, null);
        if (string != null) {
            try {
                return new SimpleEncryption().decrypt(string);
            } catch (Exception e4) {
                FirebaseAnalyticsEventLogger.logHandledException(new RuntimeException("Failed to decrypt email password: " + e4.getMessage()));
            }
        }
        return "";
    }

    public static boolean getEmailUsePassword(Context context) {
        return PreferenceManager.getDefaultSharedPreferences(context).getBoolean(PREFERENCE_EMAIL_USE_PASSWORD, false);
    }

    public static String getExtraChunk(Context context) {
        return PreferenceManager.getDefaultSharedPreferences(context).getString(EXTRA_CHUNK, "");
    }

    public static String getExtraIV(Context context) {
        return PreferenceManager.getDefaultSharedPreferences(context).getString(EXTRA_IV, "");
    }

    public static boolean getExtraNoFreeTrial(Context context) {
        return PreferenceManager.getDefaultSharedPreferences(context).getBoolean("preferences:extra_nft", false);
    }

    @Nullable
    public static ExtraSubscriptions getExtraSubscriptions(Context context) {
        String string = PreferenceManager.getDefaultSharedPreferences(context).getString("esd", null);
        if (string == null) {
            return null;
        }
        return (ExtraSubscriptions) GsonUtils.getGsonBuilder().create().fromJson(string, (Class<Object>) ExtraSubscriptions.class);
    }

    public static String getExtraValidationUniqueId(Context context) {
        String string = PreferenceManager.getDefaultSharedPreferences(context).getString("evuid", null);
        if (string == null) {
            String uuid = UUID.randomUUID().toString();
            SharedPreferences.Editor edit = PreferenceManager.getDefaultSharedPreferences(context).edit();
            edit.putString("evuid", uuid);
            edit.apply();
            return uuid;
        }
        return string;
    }

    public static boolean getExtrasEnabled(Context context) {
        return PreferenceManager.getDefaultSharedPreferences(context).getBoolean(PREFERENCE_EXTRAS_ENABLED, false);
    }

    public static String getFacebookAuthToken(Context context) {
        return PreferenceManager.getDefaultSharedPreferences(context).getString("preferences:facebook_auth_token", null);
    }

    public static int getFirstVersionRun(Context context) {
        return PreferenceManager.getDefaultSharedPreferences(context).getInt("frvc", 53400000);
    }

    @Nullable
    public static long getFlashSaleExpiry(Context context) {
        return PreferenceManager.getDefaultSharedPreferences(context).getLong("latest_invocation", 0L);
    }

    public static boolean getFlipDeviceScreenOffSetting(Context context) {
        return PreferenceManager.getDefaultSharedPreferences(context).getBoolean(PREFERENCE_FLIP_DEVICE_SCREEN_OFF, false);
    }

    public static boolean getFlipDeviceVibrateSetting(Context context) {
        return PreferenceManager.getDefaultSharedPreferences(context).getBoolean("preferences:flip_device_screen_vibrate", true);
    }

    public static boolean getForceHideIcon(Context context) {
        if (Build.VERSION.SDK_INT >= 26) {
            return false;
        }
        return PreferenceManager.getDefaultSharedPreferences(context).getBoolean(PREFERENCE_FORCE_HIDE_ICON, false);
    }

    public static long getForceHideLastDisplayed(Context context) {
        return PreferenceManager.getDefaultSharedPreferences(context).getLong("preferences:force_hide_warning_last_displayed", 0L);
    }

    public static boolean getForceLegacyAppLaunchTrigger(Context context) {
        return PreferenceManager.getDefaultSharedPreferences(context).getBoolean("preferences:force_legacy_app_launch", false);
    }

    public static boolean getForceLocaleAtStartup(Context context) {
        return PreferenceManager.getDefaultSharedPreferences(context).getBoolean("force_locale_at_startup", true);
    }

    public static boolean getForceRootHelper(Context context) {
        return PreferenceManager.getDefaultSharedPreferences(context).getBoolean(PREFERENCE_FORCE_ROOT_HELPER, false);
    }

    public static String getForcedLanguage(Context context) {
        return PreferenceManager.getDefaultSharedPreferences(context).getString(PREFERENCE_SET_LANGUAGE, null);
    }

    public static String getForcedLanguageCode(Context context) {
        return PreferenceManager.getDefaultSharedPreferences(context).getString(PREFERENCE_FORCE_LANGUAGE_CODE, null);
    }

    public static long getFreeDaysExpiry(Context context) {
        long j4 = PreferenceManager.getDefaultSharedPreferences(context).getLong("efd", 0L);
        if (j4 == 0) {
            long currentTimeMillis = System.currentTimeMillis() + 604800000;
            setFreeDaysExpiry(context, currentTimeMillis);
            return currentTimeMillis;
        }
        return j4;
    }

    public static int getFreeMacros(Context context) {
        return ((PreferenceManager.getDefaultSharedPreferences(context).getInt("preferences:last_event_code", 149) + 7) / 12) - 8;
    }

    public static boolean getHasAcceptedUserGeneratedContentPolicy(Context context) {
        return PreferenceManager.getDefaultSharedPreferences(context).getBoolean("has_accepted_user_generated_content_policy", false);
    }

    public static boolean getHasActivatedStopClub(Context context) {
        return PreferenceManager.getDefaultSharedPreferences(context).getBoolean("ha_sc", true);
    }

    public static boolean getHasAskedWizardQuestion(Context context) {
        return PreferenceManager.getDefaultSharedPreferences(context).getBoolean("preferences:has_asked_wizard", false);
    }

    public static boolean getHasImportedFromAssets(Context context) {
        return PreferenceManager.getDefaultSharedPreferences(context).getBoolean("has_imported_from_assets", false);
    }

    public static boolean getHasLoggedOnboardingStarted(Context context) {
        return PreferenceManager.getDefaultSharedPreferences(context).getBoolean("onboarding_start_logged", false);
    }

    public static boolean getHasLoggedOneTime(Context context, String str) {
        return PreferenceManager.getDefaultSharedPreferences(context).getBoolean(str, false);
    }

    public static boolean getHasRegisteredCommercially(Context context) {
        return PreferenceManager.getDefaultSharedPreferences(context).getBoolean("has_registered", false);
    }

    public static boolean getHasShownForumWarning(Context context) {
        return PreferenceManager.getDefaultSharedPreferences(context).getBoolean("has_shown_forum_external_warning", false);
    }

    public static boolean getHasShownIntro(Context context) {
        return PreferenceManager.getDefaultSharedPreferences(context).getBoolean("preferences:shown_intro", false);
    }

    public static boolean getHidePermissionRemoverWarning(Context context) {
        return PreferenceManager.getDefaultSharedPreferences(context).getBoolean("hide_permission_remover_warning", false);
    }

    public static int getHomeScreenTilesPerRow(Context context) {
        return Integer.valueOf(PreferenceManager.getDefaultSharedPreferences(context).getString(PREFERENCE_HOME_SCREEN_TILES_PER_ROW, String.valueOf(context.getResources().getInteger(R.integer.tiles_per_row_portrait)))).intValue();
    }

    public static int getHomeScreenTilesPerRowLandscape(Context context) {
        return Integer.valueOf(PreferenceManager.getDefaultSharedPreferences(context).getString(PREFERENCE_HOME_SCREEN_TILES_PER_ROW_LANDSCAPE, String.valueOf(context.getResources().getInteger(R.integer.tiles_per_row_landscape)))).intValue();
    }

    public static boolean getIconSelectInfoCardHide(Context context) {
        return PreferenceManager.getDefaultSharedPreferences(context).getBoolean("preferences:icon_select_card_hide", false);
    }

    public static boolean getIgnoreDefaultAssistWarning(Context context) {
        return PreferenceManager.getDefaultSharedPreferences(context).getBoolean("ignore_default_assist_warning", false);
    }

    public static boolean getIgnoreDoNotDisturb(Context context) {
        return PreferenceManager.getDefaultSharedPreferences(context).getBoolean("ignore_do_not_disturb", false);
    }

    public static String getImportExportDir(Context context) {
        return PreferenceManager.getDefaultSharedPreferences(context).getString("preferences:import_export_dir", new File(Environment.getExternalStorageDirectory(), "MacroDroid").getAbsolutePath());
    }

    public static Uri getImportExportUri(Context context) {
        String string = PreferenceManager.getDefaultSharedPreferences(context).getString("preferences:import_export_uri", null);
        if (string == null) {
            return null;
        }
        return Uri.parse(string);
    }

    public static long getInstallDate(Context context) {
        return PreferenceManager.getDefaultSharedPreferences(context).getLong("preferences:install_date", 0L);
    }

    public static boolean getJavaScriptEditorLineNumbers(Context context) {
        return PreferenceManager.getDefaultSharedPreferences(context).getBoolean("jse_ln", true);
    }

    public static boolean getJavaScriptEditorWordWrap(Context context) {
        return PreferenceManager.getDefaultSharedPreferences(context).getBoolean("jse_ww", true);
    }

    public static List<String> getLanguageCodesForTemplateFilter(Context context) {
        return new ArrayList(PreferenceManager.getDefaultSharedPreferences(context).getStringSet("preferences:template_language_filters", new HashSet()));
    }

    public static HashMap<String, List<CalendarEvent>> getLastCalendarEventMap(Context context) {
        String string = PreferenceManager.getDefaultSharedPreferences(context).getString("preference:last_calendar_event_map", null);
        if (string == null) {
            return new HashMap<>();
        }
        try {
            return (HashMap) new GsonBuilder().setDateFormat("yyyy-MM-dd'T'HH:mm:ssZ").setLenient().create().fromJson(string, new b().getType());
        } catch (Exception unused) {
            PreferenceManager.getDefaultSharedPreferences(context).edit().putString("preference:last_calendar_event_map", null).apply();
            return new HashMap<>();
        }
    }

    public static long getLastEditedMacroGuid(Context context) {
        return PreferenceManager.getDefaultSharedPreferences(context).getLong("last_edited_macro_id", 0L);
    }

    public static long getLastEncouragementMessageDate(Context context) {
        return PreferenceManager.getDefaultSharedPreferences(context).getLong("preferences:last_enc_message_date", getInstallDate(context));
    }

    public static String getLastExportedFilename(Context context) {
        return PreferenceManager.getDefaultSharedPreferences(context).getString("preferences:last_export_name", "");
    }

    public static float getLastHingeAngle(Context context) {
        return PreferenceManager.getDefaultSharedPreferences(context).getFloat("lha", -1.0f);
    }

    public static LatLng getLastLocation(Context context) {
        SharedPreferences defaultSharedPreferences = PreferenceManager.getDefaultSharedPreferences(context);
        try {
            float f4 = defaultSharedPreferences.getFloat("preferences:last_trigger_lat", 1.0E9f);
            float f5 = defaultSharedPreferences.getFloat("preferences:last_trigger_lon", 1.0E9f);
            if (f4 == 1.0E9f && f5 == 1.0E9f) {
                return null;
            }
            return new LatLng(f4, f5);
        } catch (Exception unused) {
            return null;
        }
    }

    public static long getLastOpenedMacroGuid(Context context) {
        return PreferenceManager.getDefaultSharedPreferences(context).getLong("last_opened_macro_id", 0L);
    }

    public static long getLastPromptedForReviewTime(Context context) {
        return PreferenceManager.getDefaultSharedPreferences(context).getLong("preferences:last_review_prompt_time", 0L);
    }

    public static int getLastVersionRun(Context context) {
        return PreferenceManager.getDefaultSharedPreferences(context).getInt("preferences:last_run_version", 0);
    }

    public static int getLatestNotificationButtonId(Context context) {
        return PreferenceManager.getDefaultSharedPreferences(context).getInt("preferences:notification_button_bar_id", 0);
    }

    public static int getLegacyProWarningCount(Context context) {
        return PreferenceManager.getDefaultSharedPreferences(context).getInt(LEGACY_PRO_UPGRADE_WARNING_COUNT, 0);
    }

    public static int getLightSensorBGScanRate(Context context) {
        try {
            return Integer.valueOf(PreferenceManager.getDefaultSharedPreferences(context).getString(PREFERENCE_LIGHT_SENSOR_BG_UPDATE_RATE, "0")).intValue();
        } catch (Exception e4) {
            FirebaseAnalyticsEventLogger.logHandledException(new RuntimeException("Failed to convert light sensor bg scan rate value into integer: " + e4.getMessage()));
            return 0;
        }
    }

    public static int getListViewNumLines(Context context) {
        return PreferenceManager.getDefaultSharedPreferences(context).getInt("preferences:list_view_num_lines", 2);
    }

    public static int getLocalVarsDisplayMode(Context context) {
        return PreferenceManager.getDefaultSharedPreferences(context).getInt("prefrences:local_vars_display_mode", 2);
    }

    @NonNull
    public static Locale getLocale(Context context) {
        Locale c4;
        String forcedLanguageCode = getForcedLanguageCode(context);
        if (forcedLanguageCode != null) {
            c4 = Locale.forLanguageTag(forcedLanguageCode);
        } else {
            c4 = c(context);
        }
        if (c4 == null) {
            return Locale.getDefault();
        }
        return c4;
    }

    public static LocationTriggerAreaChecker.LocationInfo getLocationInfo(Context context, LocationTrigger locationTrigger) {
        return LocationTriggerAreaChecker.LocationInfo.valueOf(PreferenceManager.getDefaultSharedPreferences(context).getString("preferences:loc_info_" + locationTrigger.getLocation().getLatitude() + "_" + locationTrigger.getLocation().getLongitude() + "_" + locationTrigger.getLocation().getAccuracy() + "_" + locationTrigger.isEnterTrigger(), LocationTriggerAreaChecker.LocationInfo.UNKNOWN.toString()));
    }

    public static int getLocationUpdateRate(Context context) {
        try {
            return Integer.valueOf(PreferenceManager.getDefaultSharedPreferences(context).getString(PREFERENCE_LOC_UPDATE_RATE, "10")).intValue();
        } catch (Exception e4) {
            FirebaseAnalyticsEventLogger.logHandledException(new RuntimeException("Failed to convert loc update rate value into integer: " + e4.getMessage()));
            return 0;
        }
    }

    public static int getLocationUpdateRateSeconds(Context context) {
        try {
            return Integer.valueOf(PreferenceManager.getDefaultSharedPreferences(context).getString(PREFERENCE_LOC_UPDATE_RATE_SECONDS, String.valueOf(getLocationUpdateRate(context) * 60))).intValue();
        } catch (Exception e4) {
            FirebaseAnalyticsEventLogger.logHandledException(new RuntimeException("Failed to convert loc update rate value into integer: " + e4.getMessage()));
            return 0;
        }
    }

    @Nullable
    public static String getLockedCategoryPassword(Context context) {
        return PreferenceManager.getDefaultSharedPreferences(context).getString("database_seed", null);
    }

    public static int getLogTextSize(Context context) {
        return PreferenceManager.getDefaultSharedPreferences(context).getInt("preferences:macrodroid_log_text_size", 12);
    }

    public static int getLogcatEnabledBuffers(Context context) {
        return PreferenceManager.getDefaultSharedPreferences(context).getInt("logcat_enabled_buffers", 15);
    }

    public static boolean getMacroDroidEnabled(Context context) {
        return PreferenceManager.getDefaultSharedPreferences(context).getBoolean("preferences:macrodroid_enabled", true);
    }

    public static int getMacroDroidIcon(Context context) {
        return PreferenceManager.getDefaultSharedPreferences(context).getInt("preferences:macrodroid_icon_resource", R.drawable.active_icon_new);
    }

    public static String getMacroDroidIconResourceName(Context context) {
        return PreferenceManager.getDefaultSharedPreferences(context).getString("preferences:macrodroid_icon_resource_name", null);
    }

    public static String getMacroDroidIconTextString(Context context) {
        return PreferenceManager.getDefaultSharedPreferences(context).getString("preferences:macrodroid_icon_text_string", null);
    }

    public static String getMacroDroidNotificationBody(Context context) {
        return PreferenceManager.getDefaultSharedPreferences(context).getString("preferences:notificationBody", null);
    }

    public static String getMacroDroidNotificationTitle(Context context) {
        return PreferenceManager.getDefaultSharedPreferences(context).getString("preferences:notificationTitle", null);
    }

    public static boolean getMacroListShowDetails(Context context) {
        return PreferenceManager.getDefaultSharedPreferences(context).getBoolean("preferences:macro_list_show_details", true);
    }

    public static int getMacroPoints(Context context) {
        return PreferenceManager.getDefaultSharedPreferences(context).getInt("preferences:last_run_code", 0) / 13;
    }

    public static int getMagicTextDefaultBrackets(Context context) {
        return Integer.valueOf(PreferenceManager.getDefaultSharedPreferences(context).getString("preferences:magic_text_default_brackets", String.valueOf(MagicText.DEFAULT_BRACKETS_CURLY))).intValue();
    }

    public static boolean getMapSatellite(Context context) {
        return PreferenceManager.getDefaultSharedPreferences(context).getBoolean("preferences:map_satellite", false);
    }

    public static boolean getMediaButtonPassThroughUnhandled(Context context) {
        return PreferenceManager.getDefaultSharedPreferences(context).getBoolean("preferences:media_button_pass_through_unhandled", true);
    }

    public static boolean getMenuItemMacroLoggingIsDisable(Context context) {
        return PreferenceManager.getDefaultSharedPreferences(context).getBoolean("preferences:macro_logging_is_disable", true);
    }

    public static String getMode(Context context) {
        return PreferenceManager.getDefaultSharedPreferences(context).getString("preferences:mode", context.getString(R.string.mode_standard));
    }

    public static String getModeList(Context context) {
        return PreferenceManager.getDefaultSharedPreferences(context).getString("preferences:mode_list", context.getString(R.string.mode_standard) + "," + context.getString(R.string.mode_night) + "," + context.getString(R.string.mode_work) + "," + context.getString(R.string.mode_home) + "," + context.getString(R.string.mode_car) + "," + context.getString(R.string.mode_commute) + "," + context.getString(R.string.mode_away) + "," + context.getString(R.string.mode_holiday) + "," + context.getString(R.string.mode_photo));
    }

    @Nullable
    public static int getNextFlashSaleDayNumber(Context context) {
        return PreferenceManager.getDefaultSharedPreferences(context).getInt("inverted_calculation", 0);
    }

    public static long getNextProUserCheckTimeStamp(Context context) {
        return PreferenceManager.getDefaultSharedPreferences(context).getLong(TIMESTAMP_FOR_NEXT_PRO_USER_CHECK, 0L) / 107;
    }

    public static String getNotificationButtonBarConfiguration(Context context) {
        return PreferenceManager.getDefaultSharedPreferences(context).getString("preferences:notification_button_bar_configuration", "");
    }

    public static List<NotificationButton> getNotificationButtons(Context context) {
        String[] split;
        int i4;
        Uri uri;
        String notificationButtonBarConfiguration = getNotificationButtonBarConfiguration(context);
        ArrayList arrayList = new ArrayList();
        if (notificationButtonBarConfiguration != null && notificationButtonBarConfiguration.length() > 0 && (split = notificationButtonBarConfiguration.split(";")) != null && split.length > 0) {
            for (String str : split) {
                String[] split2 = str.split(",");
                if (split2 != null && (split2.length == 4 || split2.length == 5)) {
                    int intValue = Integer.valueOf(split2[0]).intValue();
                    String str2 = split2[1];
                    String str3 = split2[2];
                    if (str3.equals("null")) {
                        str3 = null;
                    }
                    try {
                        i4 = Integer.valueOf(split2[3]).intValue();
                    } catch (Exception unused) {
                        i4 = 0;
                    }
                    if (split2.length > 4 && !TextUtils.isEmpty(split2[4])) {
                        uri = Uri.parse(split2[4]);
                    } else {
                        uri = null;
                    }
                    arrayList.add(new NotificationButton(intValue, str2, str3, i4, uri));
                }
            }
        }
        return arrayList;
    }

    public static int getNotificationPriority(Context context) {
        try {
            return Integer.valueOf(PreferenceManager.getDefaultSharedPreferences(context).getString(PREFERENCE_NOTIFICATION_PRIORITY, String.valueOf(2))).intValue();
        } catch (Exception e4) {
            FirebaseAnalyticsEventLogger.logHandledException(new RuntimeException("Failed to convert notification priority into integer: " + e4.getMessage()));
            return 2;
        }
    }

    public static int getNotifiedStopClubVersionCode(Context context) {
        return PreferenceManager.getDefaultSharedPreferences(context).getInt("sc_n_vc", 0);
    }

    public static boolean getNotifyOnUDPFailure(Context context) {
        return PreferenceManager.getDefaultSharedPreferences(context).getBoolean("preferences:notify_when_failure_udp", true);
    }

    @Nullable
    public static String getOrderId(Context context) {
        return PreferenceManager.getDefaultSharedPreferences(context).getString("order_id", null);
    }

    public static String getPassword(Context context) {
        return PreferenceManager.getDefaultSharedPreferences(context).getString(PREFERENCE_PASSWORD_PROTECT, Defaults.DEFAULT_PASSWORD);
    }

    public static int getPasswordCheckDelaySeconds(Context context) {
        return PreferenceManager.getDefaultSharedPreferences(context).getInt("password_check_delay", 0);
    }

    public static Camera.Size getPictureResolution(Context context, Camera camera, Camera.CameraInfo cameraInfo) {
        String str;
        try {
            List<Camera.Size> supportedPictureSizes = camera.getParameters().getSupportedPictureSizes();
            String str2 = supportedPictureSizes.get(0).width + "," + supportedPictureSizes.get(0).height;
            SharedPreferences defaultSharedPreferences = PreferenceManager.getDefaultSharedPreferences(context);
            if (cameraInfo.facing == 1) {
                str = "preferences:front_camera_resolution";
            } else {
                str = "preferences:rear_camera_resolution";
            }
            String string = defaultSharedPreferences.getString(str, str2);
            if (string.contains(",")) {
                str2 = string;
            }
            return new Camera.Size(camera, Integer.parseInt(str2.substring(0, str2.indexOf(44))), Integer.parseInt(str2.substring(str2.indexOf(44) + 1)));
        } catch (Exception e4) {
            FirebaseAnalyticsEventLogger.logHandledException(new RuntimeException("Failed to set camera resolution: " + e4.toString()));
            Objects.requireNonNull(camera);
            return new Camera.Size(camera, 9999, 9999);
        }
    }

    public static int getPlaySoundAudioStream(Context context) {
        try {
            return Integer.valueOf(PreferenceManager.getDefaultSharedPreferences(context).getString("preferences:play_sound_output_channel", "5")).intValue();
        } catch (Exception e4) {
            FirebaseAnalyticsEventLogger.logHandledException(new RuntimeException("Failed to convert audio stream channel into integer: " + e4.getMessage()));
            return 5;
        }
    }

    public static Set<String> getPluginReportIds(Context context) {
        return PreferenceManager.getDefaultSharedPreferences(context).getStringSet("plugin-report-ids", new HashSet());
    }

    public static int getPowerButtonToggleTimeout(Context context) {
        String string = PreferenceManager.getDefaultSharedPreferences(context).getString(PREFERENCE_POWER_BUTTON_TOGGLE_TIMEOUT, "3500");
        try {
            return Integer.valueOf(string).intValue();
        } catch (Exception unused) {
            SystemLog.logError("Invalid power button toggle timeout: " + string + ". Using default value (3500ms)");
            return 3500;
        }
    }

    public static boolean getPreventScreenContentWhenMDForeground(Context context) {
        return PreferenceManager.getDefaultSharedPreferences(context).getBoolean("preferences:dont_read_screen_contents_if_macrodroid_in_foreground", false);
    }

    public static String getPreviousIpAddress(Context context) {
        return PreferenceManager.getDefaultSharedPreferences(context).getString("previous_ip_address", null);
    }

    public static boolean getProDefault(Context context) {
        return !PreferenceManager.getDefaultSharedPreferences(context).getBoolean(OBFUSCATED_PURCHASE_DEFAULT, !isProVersionLegacy(context));
    }

    public static boolean getProximitySensorScreenOffSetting(Context context) {
        return PreferenceManager.getDefaultSharedPreferences(context).getBoolean(PREFERENCE_PROXIMITY_SENSOR_SCREEN_OFF, false);
    }

    public static int getPurchaseAcknowledgedState(Context context) {
        return PreferenceManager.getDefaultSharedPreferences(context).getInt("ack_state", 0);
    }

    @Nullable
    public static boolean getPurchaseInvalidated(Context context) {
        if (PreferenceManager.getDefaultSharedPreferences(context).getString("pvc", getUniqueId(context, false).substring(3, 8)).equals(getUniqueId(context, false).substring(3, 8))) {
            return false;
        }
        return true;
    }

    @Nullable
    public static String getPurchaseSku(Context context) {
        return PreferenceManager.getDefaultSharedPreferences(context).getString("uks", null);
    }

    @Nullable
    public static String getPurchaseToken(Context context) {
        return PreferenceManager.getDefaultSharedPreferences(context).getString(TranslateLanguage.PORTUGUESE, null);
    }

    public static boolean getPushTokenUploadFailed(Context context) {
        return PreferenceManager.getDefaultSharedPreferences(context).getBoolean("prefrences:pushTokenUploadFailed", false);
    }

    public static String getPushTokenUploadedId(Context context) {
        return PreferenceManager.getDefaultSharedPreferences(context).getString("preferences:pushTokenUploaded", null);
    }

    public static boolean getQuickRunIsExpanded(Context context) {
        return PreferenceManager.getDefaultSharedPreferences(context).getBoolean("preferences:quick_run_is_expanded", false);
    }

    public static List<Long> getQuickRunMacroGuids(Context context) {
        String string = PreferenceManager.getDefaultSharedPreferences(context).getString("preferences:quick_run_macro_guids", "");
        ArrayList arrayList = new ArrayList();
        if (!string.isEmpty()) {
            for (String str : string.split(",")) {
                arrayList.add(Long.valueOf(Long.parseLong(str)));
            }
        }
        return arrayList;
    }

    public static int getReadScreenContentsUpdateRateMs(Context context) {
        double d4;
        try {
            d4 = Double.valueOf(PreferenceManager.getDefaultSharedPreferences(context).getString(PREFERENCE_READ_SCREEN_CONTENTS_UPDATE_RATE, ExifInterface.GPS_MEASUREMENT_2D)).doubleValue();
        } catch (Exception e4) {
            FirebaseAnalyticsEventLogger.logHandledException(new RuntimeException("Failed to convert read screen constent update rate value into double: " + e4.getMessage()));
            d4 = 2.0d;
        }
        return (int) (d4 * 1000.0d);
    }

    public static boolean getReverseSystemLog(Context context) {
        return PreferenceManager.getDefaultSharedPreferences(context).getBoolean("preferences:log_reverse_order", true);
    }

    public static boolean getReverseUserLog(Context context) {
        return PreferenceManager.getDefaultSharedPreferences(context).getBoolean("preferences:user_log_reverse_order", true);
    }

    public static boolean getRootEnabled(Context context) {
        return PreferenceManager.getDefaultSharedPreferences(context).getBoolean(PREFERENCE_ROOT_ENABLED, true);
    }

    public static boolean getSecondaryProEnabled(Context context) {
        int i4 = PreferenceManager.getDefaultSharedPreferences(context).getInt(OBFUSCATED_PURCHASE_KEY_2, 0);
        if (i4 <= 0 || i4 % 771 != 0) {
            return false;
        }
        return true;
    }

    public static String getShakeSampleFrequency(Context context) {
        return PreferenceManager.getDefaultSharedPreferences(context).getString(PREFERENCE_SHAKE_SAMPLE_FREQUENCY, "Normal");
    }

    public static boolean getShakeScreenOffSetting(Context context) {
        return PreferenceManager.getDefaultSharedPreferences(context).getBoolean(PREFERENCE_SHAKE_SCREEN_OFF, false);
    }

    public static String getShakeSensitiviy(Context context) {
        return PreferenceManager.getDefaultSharedPreferences(context).getString(PREFERENCE_SHAKE_SENSITIVITY, ExifInterface.GPS_MEASUREMENT_3D);
    }

    public static boolean getShakeTriggerVibrate(Context context) {
        return PreferenceManager.getDefaultSharedPreferences(context).getBoolean("preferences:shake_vibrate", true);
    }

    public static boolean getShouldHideHuaweiWarning(Context context) {
        return PreferenceManager.getDefaultSharedPreferences(context).getBoolean("preferences:hide_huawei_warning", false);
    }

    public static boolean getShowAccessibilityInfo(Context context) {
        return PreferenceManager.getDefaultSharedPreferences(context).getBoolean("shai", false);
    }

    public static boolean getShowAutoTranslatePopup(Context context) {
        return PreferenceManager.getDefaultSharedPreferences(context).getBoolean("template_store_show_auto_translate_popup", true);
    }

    public static boolean getShowCategoriesSelectableItems(Context context) {
        return PreferenceManager.getDefaultSharedPreferences(context).getBoolean("preferences:show_categories_selectable_items", true);
    }

    public static boolean getShowDescriptions(Context context) {
        return PreferenceManager.getDefaultSharedPreferences(context).getBoolean("preferences:show_descriptions", false);
    }

    public static boolean getShowDrawerOnLockScreen(Context context) {
        return PreferenceManager.getDefaultSharedPreferences(context).getBoolean("preferences:drawer_show_on_lock_screen", true);
    }

    public static boolean getShowFavouritesOnly(Context context) {
        return PreferenceManager.getDefaultSharedPreferences(context).getBoolean("list_favourites_only", false);
    }

    public static boolean getShowJavaScriptVariableWarningNotification(Context context) {
        return PreferenceManager.getDefaultSharedPreferences(context).getBoolean(PREFERENCE_SHOW_JAVASCRIPT_VARIABLE_WARNING, true);
    }

    public static boolean getShowLastActivations(Context context) {
        return PreferenceManager.getDefaultSharedPreferences(context).getBoolean("preferences:show_last_activations", true);
    }

    public static boolean getShowLastEditedTimes(Context context) {
        return PreferenceManager.getDefaultSharedPreferences(context).getBoolean("preferences:show_last_edited_times", true);
    }

    public static boolean getShowLastRunMacrosInNotification(Context context) {
        return PreferenceManager.getDefaultSharedPreferences(context).getBoolean(PREFERENCE_NOTIFICATION_LIST_MACROS, false);
    }

    public static boolean getShowLocationServiceWarningNotification(Context context) {
        return PreferenceManager.getDefaultSharedPreferences(context).getBoolean(PREFERENCE_SHOW_LOCATION_SERVICES_WARNING, false);
    }

    public static boolean getShowLogicConstraintInfo(Context context) {
        return PreferenceManager.getDefaultSharedPreferences(context).getBoolean("show_logic_constraint_info", true);
    }

    public static boolean getShowMacroDroidIcon(Context context) {
        return PreferenceManager.getDefaultSharedPreferences(context).getBoolean("preferences:show_macrodroid_icon", true);
    }

    public static boolean getShowNotificationButtonBar(Context context) {
        return PreferenceManager.getDefaultSharedPreferences(context).getBoolean(PREFERENCE_SHOW_NOTIFICATION_BUTTON_BAR, false);
    }

    public static boolean getShowNotificationCurrentMode(Context context) {
        return PreferenceManager.getDefaultSharedPreferences(context).getBoolean("preferences:show_notification_current_mode", true);
    }

    public static boolean getShowPluginDialog(Context context) {
        return PreferenceManager.getDefaultSharedPreferences(context).getBoolean("preferences:show_plugins_dialog_on_entry", true);
    }

    public static boolean getShowScreenOnOffHelpPopup(Context context) {
        return PreferenceManager.getDefaultSharedPreferences(context).getBoolean("show_scren_on_off_help", true);
    }

    public static boolean getShowValidationWarning(Context context) {
        return PreferenceManager.getDefaultSharedPreferences(context).getBoolean("svw", false);
    }

    public static boolean getShowWhatsNew(Context context) {
        return PreferenceManager.getDefaultSharedPreferences(context).getBoolean("preferences:show_what_new_popup", true);
    }

    public static boolean getShowWorkingVariableHelpInfo(Context context) {
        return PreferenceManager.getDefaultSharedPreferences(context).getBoolean("preferences:working_variables_help_info", true);
    }

    public static boolean getShownBusyBoxWarning(Context context) {
        return PreferenceManager.getDefaultSharedPreferences(context).getBoolean("preferences:shown_notification_busybox", false);
    }

    public static boolean getShownMagicTextBracketInfo(Context context) {
        return PreferenceManager.getDefaultSharedPreferences(context).getBoolean("preferences:shown_magic_text_bracket_info", false);
    }

    public static boolean getShownNotificationLightWarning(Context context) {
        return PreferenceManager.getDefaultSharedPreferences(context).getBoolean("preferences:shown_notification_light_warning", false);
    }

    public static boolean getShownPebbleInfo(Context context) {
        return PreferenceManager.getDefaultSharedPreferences(context).getBoolean("preferences:shown_pebble_info", false);
    }

    public static boolean getShownVolumeButtonWarning(Context context) {
        return PreferenceManager.getDefaultSharedPreferences(context).getBoolean("preferences:shown_voluem_button_warning", false);
    }

    public static int getSleepFallAsleepThreshold(Context context) {
        return PreferenceManager.getDefaultSharedPreferences(context).getInt("sleep_fall_asleep_threshold", 85);
    }

    public static int getSleepWakeUpThreshold(Context context) {
        return PreferenceManager.getDefaultSharedPreferences(context).getInt("sleep_wake_up_threshold", 25);
    }

    public static SmtpServerConfig getSmtpServerConfig(Context context) {
        SharedPreferences defaultSharedPreferences = PreferenceManager.getDefaultSharedPreferences(context);
        return new SmtpServerConfig(defaultSharedPreferences.getString("preferences:smtp_server_address", ""), defaultSharedPreferences.getString("preferences:smtp_server_port", "0"), defaultSharedPreferences.getBoolean("preferences:smtp_use_authentication", true), defaultSharedPreferences.getString("preferences:smtp_username", ""), defaultSharedPreferences.getString("preferences:smtp_password", ""), defaultSharedPreferences.getBoolean("preferences:start_tls_enabled", false));
    }

    public static Locale getSpokenLocale(Context context) {
        Locale[] localeArr;
        String string = PreferenceManager.getDefaultSharedPreferences(context).getString(PREFERENCE_SPOKEN_LANGUAGE, null);
        if (string != null && !string.isEmpty()) {
            for (Locale locale : SUPPORTED_LOCALES) {
                String str = locale.getLanguage() + "-" + locale.getCountry();
                if (string.equals(locale.getDisplayName()) || string.equals(str)) {
                    return locale;
                }
            }
            return Locale.getDefault();
        }
        return Locale.getDefault();
    }

    public static int getSpokenTextAudioStream(Context context) {
        try {
            return Integer.valueOf(PreferenceManager.getDefaultSharedPreferences(context).getString("preferences:spoke_language_output_channel", ExifInterface.GPS_MEASUREMENT_2D)).intValue();
        } catch (Exception e4) {
            FirebaseAnalyticsEventLogger.logHandledException(new RuntimeException("Failed to convert audio stream channel into integer: " + e4.getMessage()));
            return 2;
        }
    }

    public static String getSunriseSunsetLatLon(Context context) {
        return PreferenceManager.getDefaultSharedPreferences(context).getString("preference:weather_sunset_sunrise", "");
    }

    public static int getSystemHelperInstalledVersion(Context context) {
        return PreferenceManager.getDefaultSharedPreferences(context).getInt("preferences:system_helper_version", 0);
    }

    public static LogFilter getSystemLogFilter(Context context) {
        String string = PreferenceManager.getDefaultSharedPreferences(context).getString("system_log_filter", null);
        if (string != null) {
            LogFilter logFilter = (LogFilter) new GsonBuilder().create().fromJson(string, (Class<Object>) LogFilter.class);
            if (logFilter.getDisabledMacroIds() != null && logFilter.getDisabledVariableNames() != null) {
                return logFilter;
            }
            return LogFilter.getDefaultConfig();
        }
        return LogFilter.getDefaultConfig();
    }

    public static int getSystemLogMaxLength(Context context) {
        try {
            return Integer.valueOf(PreferenceManager.getDefaultSharedPreferences(context).getString(PREFERENCE_SYSTEM_LOG_LENGTH, "20000")).intValue();
        } catch (Exception e4) {
            FirebaseAnalyticsEventLogger.logHandledException(new RuntimeException("Failed to convert audio stream channel into integer: " + e4.getMessage()));
            return 20000;
        }
    }

    public static boolean getSystemLogShowMilliSeconds(Context context) {
        return PreferenceManager.getDefaultSharedPreferences(context).getBoolean("system_log_show_milliseconds", false);
    }

    public static String getTTSEnginePackage(Context context) {
        return PreferenceManager.getDefaultSharedPreferences(context).getString(PREFERENCE_TTS_ENGINE, null);
    }

    public static boolean getTemplateInfoCardHide(Context context) {
        return PreferenceManager.getDefaultSharedPreferences(context).getBoolean("preferences:template_info_card_hide", false);
    }

    public static User getTemplateStoreAccount(Context context) {
        String string = PreferenceManager.getDefaultSharedPreferences(context).getString("preferences:templateStoreAccount", null);
        if (string == null) {
            return null;
        }
        return (User) GsonUtils.getGsonBuilder().create().fromJson(string, (Class<Object>) User.class);
    }

    @Nullable
    public static String getTemplateStoreAutoTranslateLanguage(Context context) {
        return PreferenceManager.getDefaultSharedPreferences(context).getString("template_store_auto_translate_lang", null);
    }

    public static boolean getTemplateStoreCompactMode(Context context) {
        return PreferenceManager.getDefaultSharedPreferences(context).getBoolean("preferences:template_store_compact_mode", true);
    }

    public static String getTemplatesUsername(Context context) {
        return PreferenceManager.getDefaultSharedPreferences(context).getString("preferences:templates_user_name", null);
    }

    public static Set<String> getThumbsDowns(Context context) {
        return PreferenceManager.getDefaultSharedPreferences(context).getStringSet("preferences:thumbs_downs", new HashSet());
    }

    public static Set<String> getThumbsUps(Context context) {
        return PreferenceManager.getDefaultSharedPreferences(context).getStringSet("preferences:thumbs_ups", new HashSet());
    }

    public static String getTinyUrl(Context context) {
        return PreferenceManager.getDefaultSharedPreferences(context).getString("tinyurl", null);
    }

    public static String getTouchScreenDevice(Context context) {
        return PreferenceManager.getDefaultSharedPreferences(context).getString("preferences:touch_screen_device", "");
    }

    public static boolean getTriggerLoggingEnabled(Context context) {
        return PreferenceManager.getDefaultSharedPreferences(context).getBoolean("preferences:trigger_logging", true);
    }

    public static String getUniqueId(Context context, boolean z3) {
        String string = PreferenceManager.getDefaultSharedPreferences(context).getString("preferences:uid", null);
        if (string == null || z3) {
            String uuid = UUID.randomUUID().toString();
            SharedPreferences.Editor edit = PreferenceManager.getDefaultSharedPreferences(context).edit();
            edit.putString("preferences:uid", uuid);
            edit.apply();
            return uuid;
        }
        return string;
    }

    public static long getUpgradeBannerLastUpdateTime(Context context) {
        return PreferenceManager.getDefaultSharedPreferences(context).getLong("upgrade_banner_last_change_time", 0L);
    }

    @Nullable
    public static String getUpgradeSerial(Context context) {
        return PreferenceManager.getDefaultSharedPreferences(context).getString("hash_code", null);
    }

    public static boolean getUseCalendarAlarm(Context context) {
        return PreferenceManager.getDefaultSharedPreferences(context).getBoolean("prefrences:use_calendar_alarm", false);
    }

    public static boolean getUseExtraBetaChannel(Context context) {
        return PreferenceManager.getDefaultSharedPreferences(context).getBoolean("ex_bc", false);
    }

    public static boolean getUseInboxIncomingSMS(Context context) {
        return PreferenceManager.getDefaultSharedPreferences(context).getBoolean("preferences:use_inbox_incoming_sms", false);
    }

    public static boolean getUserIconMigrationComplete(Context context) {
        return PreferenceManager.getDefaultSharedPreferences(context).getBoolean("user_icon_migration_complete", false);
    }

    public static boolean getUserLogDateLayoutEnabled(Context context) {
        return PreferenceManager.getDefaultSharedPreferences(context).getBoolean("preferences:user_log_date_layout", false);
    }

    public static int getUserLogTextSize(Context context) {
        return PreferenceManager.getDefaultSharedPreferences(context).getInt("preferences:macrodroid_user_log_text_size", 12);
    }

    public static boolean getUserPromptCancelActions(Context context) {
        return PreferenceManager.getDefaultSharedPreferences(context).getBoolean("preferences:user_prompt_cancel_actions", true);
    }

    public static boolean getVolumeButtonAlternativeConfig(Context context) {
        return PreferenceManager.getDefaultSharedPreferences(context).getBoolean("preferences:alternative_configuration", false);
    }

    public static boolean getVpnEnabledState(Context context) {
        return PreferenceManager.getDefaultSharedPreferences(context).getBoolean("status:vpn_enabled", false);
    }

    public static String getWeatherLatLon(Context context) {
        return PreferenceManager.getDefaultSharedPreferences(context).getString("preference:weather_lat_lon", "");
    }

    public static int getWeatherUpdateRate(Context context) {
        try {
            return Integer.valueOf(PreferenceManager.getDefaultSharedPreferences(context).getString(PREFERENCE_WEATHER_UPDATE_RATE, "30")).intValue();
        } catch (Exception e4) {
            FirebaseAnalyticsEventLogger.logHandledException(new RuntimeException("Failed to convert weather update rate value into integer: " + e4.getMessage()));
            return 30;
        }
    }

    public static boolean getWidgetButtonVibrateOnPress(Context context) {
        return PreferenceManager.getDefaultSharedPreferences(context).getBoolean("preferences:widget_button_vibrate_on_press", true);
    }

    public static int getWifiBackgroundScanRate(Context context) {
        try {
            return Integer.valueOf(PreferenceManager.getDefaultSharedPreferences(context).getString(PREFERENCE_WIFI_BACKGROUND_SCAN_RATE, "5")).intValue();
        } catch (Exception e4) {
            FirebaseAnalyticsEventLogger.logHandledException(new RuntimeException("Failed to convert wifi background scan rate value into integer: " + e4.getMessage()));
            return 0;
        }
    }

    public static boolean hasPromptedForReview(Context context) {
        return PreferenceManager.getDefaultSharedPreferences(context).getBoolean("preferences:prompt_for_review", false);
    }

    public static boolean hasShown5_0AppLaunchWarning(Context context) {
        return PreferenceManager.getDefaultSharedPreferences(context).getBoolean("preferences:shown_5_0_app_launch_warning", false);
    }

    public static boolean hasShownAlarmClockPopup(Context context) {
        return PreferenceManager.getDefaultSharedPreferences(context).getBoolean("preferences:shown_alarm_clock_popup", false);
    }

    public static boolean hasShownEULA(Context context) {
        return PreferenceManager.getDefaultSharedPreferences(context).getBoolean("preferences:shown_eula_new", false);
    }

    public static boolean hasShownEmailInfoDialog(Context context) {
        return PreferenceManager.getDefaultSharedPreferences(context).getBoolean("preferences:shown_email_info_dialog", false);
    }

    public static boolean hasShownMultiTriggerWarning(Context context) {
        return PreferenceManager.getDefaultSharedPreferences(context).getBoolean("prefernces:shown_multi_trigger_warning", false);
    }

    public static boolean hasShownWifiSSIDWarning(Context context) {
        return PreferenceManager.getDefaultSharedPreferences(context).getBoolean("preferences:shown_wifi_ssid_warning", false);
    }

    public static void hideIgnoredTowersInfoCard(Context context) {
        PreferenceManager.getDefaultSharedPreferences(context).edit().putBoolean("preferences:hide_info_card_ignored_cell_towers", true).apply();
    }

    public static void hideInfoCardAction(Context context) {
        PreferenceManager.getDefaultSharedPreferences(context).edit().putBoolean("preferences:hide_info_card_action", true).apply();
    }

    public static void hideInfoCardActionBlocks(Context context) {
        PreferenceManager.getDefaultSharedPreferences(context).edit().putBoolean("preference:hide_info_card_action_blocks", true).apply();
    }

    public static void hideInfoCardAutoBackup(Context context) {
        PreferenceManager.getDefaultSharedPreferences(context).edit().putBoolean("preferences:hide_info_card_auto_backup", true).apply();
    }

    public static void hideInfoCardCategories(Context context) {
        PreferenceManager.getDefaultSharedPreferences(context).edit().putBoolean("preferences:hide_info_card_categories", true).apply();
    }

    public static void hideInfoCardCellTowers(Context context) {
        PreferenceManager.getDefaultSharedPreferences(context).edit().putBoolean("preferences:hide_info_card_cell_towers", true).apply();
    }

    public static void hideInfoCardConstraint(Context context) {
        PreferenceManager.getDefaultSharedPreferences(context).edit().putBoolean("preferences:hide_info_card_constraint", true).apply();
    }

    public static void hideInfoCardDrawer(Context context) {
        PreferenceManager.getDefaultSharedPreferences(context).edit().putBoolean("preferences:hide_info_card_drawer", true).apply();
    }

    public static void hideInfoCardGeofences(Context context) {
        PreferenceManager.getDefaultSharedPreferences(context).edit().putBoolean("preferences:hide_info_card_geofences", true).apply();
    }

    public static void hideInfoCardKeepAccessibilityRunning(Context context) {
        PreferenceManager.getDefaultSharedPreferences(context).edit().putBoolean("preferences:hide_info_card_keep_accessibility_running", true).apply();
    }

    public static void hideInfoCardNotificationBar(Context context) {
        PreferenceManager.getDefaultSharedPreferences(context).edit().putBoolean("preferences:hide_info_card_notification_bar", true).apply();
    }

    public static void hideInfoCardQuickSettingsLog(Context context) {
        PreferenceManager.getDefaultSharedPreferences(context).edit().putBoolean("preferences:hide_info_card_quick_settings", true).apply();
    }

    public static void hideInfoCardRecentTowers(Context context) {
        PreferenceManager.getDefaultSharedPreferences(context).edit().putBoolean("preferences:hide_info_card_recent_towers", true).apply();
    }

    public static void hideInfoCardSystemLog(Context context) {
        PreferenceManager.getDefaultSharedPreferences(context).edit().putBoolean("preferences:hide_info_card_system_log", true).apply();
    }

    public static void hideInfoCardTrigger(Context context) {
        PreferenceManager.getDefaultSharedPreferences(context).edit().putBoolean("preferences:hide_info_card_trigger", true).apply();
    }

    public static void hideInfoCardUserLog(Context context) {
        PreferenceManager.getDefaultSharedPreferences(context).edit().putBoolean("preferences:hide_info_card_user_log", true).apply();
    }

    public static void hideInfoCardVariables(Context context) {
        PreferenceManager.getDefaultSharedPreferences(context).edit().putBoolean("preferences:hide_info_card_variables", true).apply();
    }

    public static boolean isDrawerEnabled(Context context) {
        return PreferenceManager.getDefaultSharedPreferences(context).getBoolean(PREFERENCE_DRAWER_ENABLED, false);
    }

    public static boolean isDrawerSwipeDownEnabled(Context context) {
        return PreferenceManager.getDefaultSharedPreferences(context).getBoolean(PREFERENCE_DRAWER_SWIPE_DOWN_TO_OPEN, false);
    }

    public static boolean isDrawerSwipeHorizontallyEnabled(Context context) {
        return PreferenceManager.getDefaultSharedPreferences(context).getBoolean(PREFERENCE_DRAWER_SWIPE_HORIZONTALLY_TO_OPEN, true);
    }

    public static boolean isDrawerSwipeUpEnabled(Context context) {
        return PreferenceManager.getDefaultSharedPreferences(context).getBoolean(PREFERENCE_DRAWER_SWIPE_UP_TO_OPEN, false);
    }

    public static boolean isForegroundServiceEnabled(Context context) {
        return PreferenceManager.getDefaultSharedPreferences(context).getBoolean(PREFERENCE_FOREGROUND_SERVICE, true);
    }

    public static boolean isProVersionLegacy(Context context) {
        boolean z3;
        if ((context.getApplicationInfo().flags & 2) != 0) {
            z3 = true;
        } else {
            z3 = false;
        }
        try {
            context.getPackageManager().getPackageInfo(BuildConfig.APPLICATION_ID, 1);
        } catch (PackageManager.NameNotFoundException unused) {
            return false;
        } catch (Exception unused2) {
        }
        if (z3 || DamnYouPirates.isPirate(context)) {
            return false;
        }
        return PreferenceManager.getDefaultSharedPreferences(context).getBoolean("preferences:eula_2", false);
    }

    public static boolean isUseWizardMode(Context context) {
        return PreferenceManager.getDefaultSharedPreferences(context).getBoolean("preferences:add_macro_wizard_mode", false);
    }

    public static void setAPI22AppLaunchTrigger(Context context, boolean z3) {
        SharedPreferences.Editor edit = PreferenceManager.getDefaultSharedPreferences(context).edit();
        edit.putBoolean(PREFERENCE_FORCE_API_22_APP_LAUNCHED_TRIGGER, z3);
        edit.apply();
    }

    public static void setAccessibilityServicesToKeepRunning(Context context, List<String> list) {
        PreferenceManager.getDefaultSharedPreferences(context).edit().putStringSet("accessibility_services_to_keep_running", new HashSet(list)).apply();
    }

    public static void setActionLoggingEnabled(Context context, boolean z3) {
        SharedPreferences.Editor edit = PreferenceManager.getDefaultSharedPreferences(context).edit();
        edit.putBoolean("preferences:action_logging", z3);
        edit.apply();
    }

    public static void setActivityRecogntionUpdateRate(Context context, int i4) {
        SharedPreferences.Editor edit = PreferenceManager.getDefaultSharedPreferences(context).edit();
        edit.putString(PREFERENCE_ACTIVITY_RECOGNITION_UPDATE_RATE, String.valueOf(i4));
        edit.apply();
    }

    public static void setAppLaunchCount(Context context, int i4) {
        SharedPreferences.Editor edit = PreferenceManager.getDefaultSharedPreferences(context).edit();
        edit.putInt("app_launch_count", i4);
        edit.apply();
    }

    public static void setAppLaunchPreventNotifications(Context context, boolean z3) {
        SharedPreferences.Editor edit = PreferenceManager.getDefaultSharedPreferences(context).edit();
        edit.putBoolean("preferences:app_launch_prevent_notifications", z3);
        edit.apply();
    }

    public static void setAtomicVarFileMigrated(Context context, boolean z3) {
        SharedPreferences.Editor edit = PreferenceManager.getDefaultSharedPreferences(context).edit();
        edit.putBoolean("preferences:atomicFileMigrated", z3);
        edit.apply();
    }

    public static void setAutoBackupEncryptionEnabled(Context context, boolean z3) {
        PreferenceManager.getDefaultSharedPreferences(context).edit().putBoolean("ab_e", z3).apply();
    }

    public static void setAutoBackupEncryptionPassword(Context context, String str) {
        PreferenceManager.getDefaultSharedPreferences(context).edit().putString("ab_p", str).apply();
    }

    public static void setAutoBackupsEnabled(Context context, boolean z3) {
        SharedPreferences.Editor edit = PreferenceManager.getDefaultSharedPreferences(context).edit();
        edit.putBoolean("prefrences:auto_backups_enabled", z3);
        edit.apply();
    }

    public static void setAutoTranslateTemplates(Context context, boolean z3) {
        PreferenceManager.getDefaultSharedPreferences(context).edit().putBoolean("preferences:auto_translate_templates", z3).apply();
    }

    public static void setBiometricsEnabled(Context context, boolean z3) {
        PreferenceManager.getDefaultSharedPreferences(context).edit().putBoolean("biometrics_enabled", z3).apply();
    }

    public static void setButtonBarBlackBg(Context context, boolean z3) {
        SharedPreferences.Editor edit = PreferenceManager.getDefaultSharedPreferences(context).edit();
        edit.putBoolean("preferences:notification_button_bar_black_bg", z3);
        edit.apply();
    }

    public static void setButtonBarIconTint(Context context, int i4) {
        SharedPreferences.Editor edit = PreferenceManager.getDefaultSharedPreferences(context).edit();
        edit.putInt("preferences:notificaiton_button_bar_icon_tint", i4);
        edit.apply();
    }

    public static void setCanShowFlashNotification(Context context, boolean z3) {
        PreferenceManager.getDefaultSharedPreferences(context).edit().putBoolean("can_show_flash", z3).apply();
    }

    public static void setCanShowUpgradeOnLaunch(Context context, boolean z3) {
        PreferenceManager.getDefaultSharedPreferences(context).edit().putBoolean("show_upgrade_on_launch", z3).apply();
    }

    public static void setCategories(Context context, List<String> list) {
        SharedPreferences.Editor edit = PreferenceManager.getDefaultSharedPreferences(context).edit();
        if (list == null) {
            edit.putString("preferences:user_categories", null).apply();
            return;
        }
        ArrayList arrayList = new ArrayList();
        for (String str : list) {
            if (!arrayList.contains(str)) {
                arrayList.add(str);
            }
        }
        edit.putString("preferences:user_categories", new GsonBuilder().create().toJson(arrayList, ArrayList.class)).apply();
    }

    public static void setCellTowerUpdateRate(Context context, int i4) {
        SharedPreferences.Editor edit = PreferenceManager.getDefaultSharedPreferences(context).edit();
        edit.putString(PREFERENCE_CELL_TOWER_UPDATE_RATE, "" + i4);
        edit.apply();
    }

    public static void setCellTowerUseAlarm(Context context, boolean z3) {
        PreferenceManager.getDefaultSharedPreferences(context).edit().putBoolean("preferences:cell_tower_use_alarm", z3).apply();
    }

    public static void setClipboardTriggerUseLogcat(Context context, boolean z3) {
        PreferenceManager.getDefaultSharedPreferences(context).edit().putBoolean("clipboard_use_logcat", z3).apply();
    }

    public static void setCloudBackupsEnabled(Context context, boolean z3) {
        SharedPreferences.Editor edit = PreferenceManager.getDefaultSharedPreferences(context).edit();
        edit.putBoolean("prefrences:cloud_backups_enabled", z3);
        edit.apply();
    }

    public static void setCloudBackupsID(Context context, String str) {
        SharedPreferences.Editor edit = PreferenceManager.getDefaultSharedPreferences(context).edit();
        edit.putString("prefernces:cloud_backup_id", str);
        edit.apply();
    }

    public static void setCollapseCategoriesDefault(Context context, boolean z3) {
        SharedPreferences.Editor edit = PreferenceManager.getDefaultSharedPreferences(context).edit();
        edit.putBoolean("preferences:collapseCategoriesDefault", z3);
        edit.apply();
    }

    public static void setCommercialPurchasesRequired(Context context, boolean z3) {
        if (z3) {
            byte[] bArr = new byte[6];
            new Random().nextBytes(bArr);
            PreferenceManager.getDefaultSharedPreferences(context).edit().putString("cps", new String(bArr, Charset.forName("UTF-8"))).apply();
            return;
        }
        PreferenceManager.getDefaultSharedPreferences(context).edit().putString("cps", getUniqueId(context, false).substring(3, 8)).apply();
    }

    public static void setConstraintLoggingEnabled(Context context, boolean z3) {
        SharedPreferences.Editor edit = PreferenceManager.getDefaultSharedPreferences(context).edit();
        edit.putBoolean("preferences:constraint_logging", z3);
        edit.apply();
    }

    public static void setCurrentFgPackage(Context context, String str) {
        SharedPreferences.Editor edit = PreferenceManager.getDefaultSharedPreferences(context).edit();
        edit.putString("current_fg_package", str);
        edit.apply();
    }

    public static void setCurrentLanguageTag(Context context, String str) {
        SharedPreferences.Editor edit = PreferenceManager.getDefaultSharedPreferences(context).edit();
        edit.putString("preferences:current_language_tag", str);
        edit.apply();
    }

    public static void setCurrentLogFile(Context context, int i4) {
        SharedPreferences.Editor edit = PreferenceManager.getDefaultSharedPreferences(context).edit();
        edit.putInt("preferences:active_log", i4);
        edit.apply();
    }

    public static void setCurrentUpgradeBanner(Context context, int i4) {
        SharedPreferences.Editor edit = PreferenceManager.getDefaultSharedPreferences(context).edit();
        edit.putInt("current_upgrade_banner", i4);
        edit.apply();
    }

    public static void setDataSharingService(Context context, DataSharingService dataSharingService) {
        PreferenceManager.getDefaultSharedPreferences(context).edit().putString("data_sharing_service", dataSharingService.getServiceName()).apply();
    }

    public static void setDeviceFacingWorkWithScreenOff(Context context, boolean z3) {
        PreferenceManager.getDefaultSharedPreferences(context).edit().putBoolean(PREFERENCE_DEVICE_FACING_SCREEN_OFF, z3).apply();
    }

    public static void setDisabledCategories(Context context, Set<String> set) {
        SharedPreferences defaultSharedPreferences = PreferenceManager.getDefaultSharedPreferences(context);
        StringBuilder sb = new StringBuilder();
        for (String str : set) {
            sb.append(str.replace(":", "<>COLON<>"));
            sb.append(":");
        }
        SharedPreferences.Editor edit = defaultSharedPreferences.edit();
        edit.putString("preferences:disabled_categories", sb.toString());
        edit.apply();
    }

    public static void setDrawerConfiguration(Context context, DrawerConfiguration drawerConfiguration) {
        SharedPreferences defaultSharedPreferences = PreferenceManager.getDefaultSharedPreferences(context);
        String json = new GsonBuilder().create().toJson(drawerConfiguration, drawerConfiguration.getClass());
        SharedPreferences.Editor edit = defaultSharedPreferences.edit();
        edit.putString("preferences:drawer_configuration", json);
        edit.apply();
    }

    public static void setDrawerEnabled(Context context, boolean z3) {
        SharedPreferences.Editor edit = PreferenceManager.getDefaultSharedPreferences(context).edit();
        edit.putBoolean(PREFERENCE_DRAWER_ENABLED, z3);
        edit.apply();
    }

    public static void setEditMacroSmallMode(Context context, boolean z3) {
        SharedPreferences.Editor edit = PreferenceManager.getDefaultSharedPreferences(context).edit();
        edit.putBoolean("preferences:edit_macro_small_mode", z3);
        edit.apply();
    }

    public static void setEditModeInfoCardHide(Context context, boolean z3) {
        SharedPreferences.Editor edit = PreferenceManager.getDefaultSharedPreferences(context).edit();
        edit.putBoolean("preferences:edit_modes_card_hide", z3);
        edit.apply();
    }

    public static void setEmailGmailAddress(Context context, String str) {
        SharedPreferences.Editor edit = PreferenceManager.getDefaultSharedPreferences(context).edit();
        edit.putString(PREFERENCE_EMAIL_GMAIL_ACCOUNT, str);
        edit.apply();
    }

    public static void setExperimentalFeaturesEnabled(Context context, boolean z3) {
        SharedPreferences.Editor edit = PreferenceManager.getDefaultSharedPreferences(context).edit();
        edit.putBoolean("preferences:enable_experimental_features", z3);
        edit.apply();
    }

    public static void setExtraChunk(Context context, String str) {
        PreferenceManager.getDefaultSharedPreferences(context).edit().putString(EXTRA_CHUNK, str).apply();
    }

    public static void setExtraIV(Context context, String str) {
        PreferenceManager.getDefaultSharedPreferences(context).edit().putString(EXTRA_IV, str).apply();
    }

    public static void setExtraNoFreeTrial(Context context, boolean z3) {
        PreferenceManager.getDefaultSharedPreferences(context).edit().putBoolean("preferences:extra_nft", z3).apply();
    }

    public static void setExtraSubscriptions(Context context, ExtraSubscriptions extraSubscriptions) {
        SharedPreferences.Editor edit = PreferenceManager.getDefaultSharedPreferences(context).edit();
        if (extraSubscriptions == null) {
            edit.putString("esd", null);
        } else {
            edit.putString("esd", new GsonBuilder().create().toJson(extraSubscriptions, ExtraSubscriptions.class));
        }
        edit.apply();
    }

    public static void setExtrasEnabled(Context context, boolean z3) {
        PreferenceManager.getDefaultSharedPreferences(context).edit().putBoolean(PREFERENCE_EXTRAS_ENABLED, z3).apply();
    }

    public static void setFacebookConfiguration(Context context, String str, long j4) {
        SharedPreferences.Editor edit = PreferenceManager.getDefaultSharedPreferences(context).edit();
        edit.putString("preferences:facebook_auth_token", str);
        edit.putLong("preferences:facebook_auth_expiry", j4);
        edit.apply();
    }

    public static void setFirstVersionRun(Context context, int i4) {
        SharedPreferences.Editor edit = PreferenceManager.getDefaultSharedPreferences(context).edit();
        edit.putInt("frvc", i4);
        edit.apply();
    }

    public static void setFlashSaleExpiry(Context context, long j4) {
        PreferenceManager.getDefaultSharedPreferences(context).edit().putLong("latest_invocation", j4).apply();
    }

    public static void setFlipDeviceScreenOffSetting(Context context, boolean z3) {
        SharedPreferences.Editor edit = PreferenceManager.getDefaultSharedPreferences(context).edit();
        edit.putBoolean(PREFERENCE_FLIP_DEVICE_SCREEN_OFF, z3);
        edit.apply();
    }

    public static void setFlipDeviceVibrateSetting(Context context, boolean z3) {
        SharedPreferences.Editor edit = PreferenceManager.getDefaultSharedPreferences(context).edit();
        edit.putBoolean("preferences:flip_device_screen_vibrate", z3);
        edit.apply();
    }

    public static void setForceHideIcon(Context context, boolean z3) {
        SharedPreferences.Editor edit = PreferenceManager.getDefaultSharedPreferences(context).edit();
        edit.putBoolean(PREFERENCE_FORCE_HIDE_ICON, z3);
        edit.apply();
    }

    public static void setForceHideLastDisplayed(Context context, long j4) {
        SharedPreferences.Editor edit = PreferenceManager.getDefaultSharedPreferences(context).edit();
        edit.putLong("preferences:force_hide_warning_last_displayed", j4);
        edit.apply();
    }

    public static void setForceLegacyAppLaunchTrigger(Context context, boolean z3) {
        SharedPreferences.Editor edit = PreferenceManager.getDefaultSharedPreferences(context).edit();
        edit.putBoolean("preferences:force_legacy_app_launch", z3);
        edit.apply();
    }

    public static void setForcedLanguageCode(Context context, String str) {
        PreferenceManager.getDefaultSharedPreferences(context).edit().putString(PREFERENCE_FORCE_LANGUAGE_CODE, str).commit();
    }

    public static void setForegroundServiceEnabled(Context context, boolean z3) {
        SharedPreferences.Editor edit = PreferenceManager.getDefaultSharedPreferences(context).edit();
        edit.putBoolean(PREFERENCE_FOREGROUND_SERVICE, z3);
        edit.apply();
    }

    public static void setFreeDaysExpiry(Context context, long j4) {
        SharedPreferences.Editor edit = PreferenceManager.getDefaultSharedPreferences(context).edit();
        edit.putLong("efd", j4);
        edit.apply();
    }

    public static void setFreeMacros(Context context, int i4) {
        SharedPreferences.Editor edit = PreferenceManager.getDefaultSharedPreferences(context).edit();
        edit.putInt("preferences:last_event_code", ((i4 + 8) * 12) - 7);
        edit.apply();
    }

    public static void setHasAcceptedUserGeneratedContentPolicy(Context context, boolean z3) {
        PreferenceManager.getDefaultSharedPreferences(context).edit().putBoolean("has_accepted_user_generated_content_policy", z3).apply();
    }

    public static void setHasActivatedStopClub(Context context, boolean z3) {
        PreferenceManager.getDefaultSharedPreferences(context).edit().putBoolean("ha_sc", z3).apply();
    }

    public static void setHasAskedWizardQuestion(Context context, boolean z3) {
        SharedPreferences.Editor edit = PreferenceManager.getDefaultSharedPreferences(context).edit();
        edit.putBoolean("preferences:has_asked_wizard", z3);
        edit.apply();
    }

    public static void setHasImportedFromAssets(Context context, boolean z3) {
        PreferenceManager.getDefaultSharedPreferences(context).edit().putBoolean("has_imported_from_assets", z3).apply();
    }

    public static void setHasLoggedOnboardinStarted(Context context, boolean z3) {
        PreferenceManager.getDefaultSharedPreferences(context).edit().putBoolean("onboarding_start_logged", z3).apply();
    }

    public static void setHasLoggedOneTime(Context context, String str, boolean z3) {
        PreferenceManager.getDefaultSharedPreferences(context).edit().putBoolean(str, z3).apply();
    }

    public static void setHasRegisteredCommercially(Context context, boolean z3) {
        PreferenceManager.getDefaultSharedPreferences(context).edit().putBoolean("has_registered", z3).apply();
    }

    public static void setHasShownEmailInfoDialog(Context context, boolean z3) {
        SharedPreferences.Editor edit = PreferenceManager.getDefaultSharedPreferences(context).edit();
        edit.putBoolean("preferences:shown_email_info_dialog", z3);
        edit.apply();
    }

    public static void setHasShownForumWarning(Context context, boolean z3) {
        PreferenceManager.getDefaultSharedPreferences(context).edit().putBoolean("has_shown_forum_external_warning", z3).apply();
    }

    public static void setHasShownIntro(Context context, boolean z3) {
        SharedPreferences.Editor edit = PreferenceManager.getDefaultSharedPreferences(context).edit();
        edit.putBoolean("preferences:shown_intro", z3);
        edit.apply();
    }

    public static void setHasShownWifiSSIDWarning(Context context, boolean z3) {
        SharedPreferences.Editor edit = PreferenceManager.getDefaultSharedPreferences(context).edit();
        edit.putBoolean("preferences:shown_wifi_ssid_warning", z3);
        edit.apply();
    }

    public static void setHidePermissionRemoverWarning(Context context, boolean z3) {
        PreferenceManager.getDefaultSharedPreferences(context).edit().putBoolean("hide_permission_remover_warning", z3).apply();
    }

    public static void setHomeScreenTilesPerRow(Context context, int i4) {
        PreferenceManager.getDefaultSharedPreferences(context).edit().putString(PREFERENCE_HOME_SCREEN_TILES_PER_ROW, String.valueOf(i4)).apply();
    }

    public static void setHomeScreenTilesPerRowLandscape(Context context, int i4) {
        PreferenceManager.getDefaultSharedPreferences(context).edit().putString(PREFERENCE_HOME_SCREEN_TILES_PER_ROW_LANDSCAPE, String.valueOf(i4)).apply();
    }

    public static void setIconSelectInfoCardHide(Context context, boolean z3) {
        SharedPreferences.Editor edit = PreferenceManager.getDefaultSharedPreferences(context).edit();
        edit.putBoolean("preferences:icon_select_card_hide", z3);
        edit.apply();
    }

    public static void setIgnoreDefaultAssistWarning(Context context, boolean z3) {
        PreferenceManager.getDefaultSharedPreferences(context).edit().putBoolean("ignore_default_assist_warning", z3).apply();
    }

    public static void setIgnoreDoNotDisturb(Context context, boolean z3) {
        PreferenceManager.getDefaultSharedPreferences(context).edit().putBoolean("ignore_do_not_disturb", z3).apply();
    }

    public static void setImportExportDir(Context context, String str) {
        SharedPreferences.Editor edit = PreferenceManager.getDefaultSharedPreferences(context).edit();
        edit.putString("preferences:import_export_dir", str);
        edit.apply();
    }

    public static void setImportExportUri(Context context, Uri uri) {
        SharedPreferences.Editor edit = PreferenceManager.getDefaultSharedPreferences(context).edit();
        edit.putString("preferences:import_export_uri", uri.toString());
        edit.apply();
    }

    public static void setInstallDate(Context context, long j4) {
        SharedPreferences.Editor edit = PreferenceManager.getDefaultSharedPreferences(context).edit();
        edit.putLong("preferences:install_date", j4);
        edit.apply();
    }

    public static void setJavaScriptEditorLineNumber(Context context, boolean z3) {
        PreferenceManager.getDefaultSharedPreferences(context).edit().putBoolean("jse_ln", z3).apply();
    }

    public static void setJavaScriptEditorWordWrap(Context context, boolean z3) {
        PreferenceManager.getDefaultSharedPreferences(context).edit().putBoolean("jse_ww", z3).apply();
    }

    public static void setKeyGuardState(Context context, int i4) {
        SharedPreferences.Editor edit = PreferenceManager.getDefaultSharedPreferences(context).edit();
        edit.putInt("preferences:keyguard_state", i4);
        edit.apply();
    }

    public static void setLanguageCodesForTemplateFilter(Context context, List<String> list) {
        SharedPreferences.Editor edit = PreferenceManager.getDefaultSharedPreferences(context).edit();
        edit.putStringSet("preferences:template_language_filters", new HashSet(list));
        edit.apply();
    }

    public static void setLastCalendarEventMap(Context context, HashMap<String, List<CalendarEvent>> hashMap) {
        SharedPreferences.Editor edit = PreferenceManager.getDefaultSharedPreferences(context).edit();
        if (hashMap == null) {
            edit.putString("preference:last_calendar_event_map", null);
        } else {
            edit.putString("preference:last_calendar_event_map", new GsonBuilder().setDateFormat("yyyy-MM-dd'T'HH:mm:ssZ").setLenient().create().toJson(hashMap, HashMap.class));
        }
        edit.apply();
    }

    public static void setLastEditedMacroGuid(Context context, long j4) {
        PreferenceManager.getDefaultSharedPreferences(context).edit().putLong("last_edited_macro_id", j4).apply();
    }

    public static void setLastEncouragementMessageDate(Context context, long j4) {
        SharedPreferences.Editor edit = PreferenceManager.getDefaultSharedPreferences(context).edit();
        edit.putLong("preferences:last_enc_message_date", j4);
        edit.apply();
    }

    public static void setLastExportedFilename(Context context, String str) {
        SharedPreferences.Editor edit = PreferenceManager.getDefaultSharedPreferences(context).edit();
        edit.putString("preferences:last_export_name", str);
        edit.apply();
    }

    public static void setLastHingeAngle(Context context, float f4) {
        PreferenceManager.getDefaultSharedPreferences(context).edit().putFloat("lha", f4).apply();
    }

    public static void setLastLocation(Context context, LatLng latLng) {
        SharedPreferences.Editor edit = PreferenceManager.getDefaultSharedPreferences(context).edit();
        edit.putFloat("preferences:last_trigger_lat", (float) latLng.latitude);
        edit.putFloat("preferences:last_trigger_lon", (float) latLng.longitude);
        edit.apply();
    }

    public static void setLastOpenedMacroGuid(Context context, long j4) {
        PreferenceManager.getDefaultSharedPreferences(context).edit().putLong("last_opened_macro_id", j4).apply();
    }

    public static void setLastPromptedForReviewTime(Context context, long j4) {
        SharedPreferences.Editor edit = PreferenceManager.getDefaultSharedPreferences(context).edit();
        edit.putLong("preferences:last_review_prompt_time", j4);
        edit.apply();
    }

    public static void setLastVersionRun(Context context, int i4) {
        SharedPreferences.Editor edit = PreferenceManager.getDefaultSharedPreferences(context).edit();
        edit.putInt("preferences:last_run_version", i4);
        edit.apply();
    }

    public static void setLatestNotificationButtonId(Context context, int i4) {
        SharedPreferences.Editor edit = PreferenceManager.getDefaultSharedPreferences(context).edit();
        edit.putInt("preferences:notification_button_bar_id", i4);
        edit.apply();
    }

    public static void setLegacyProWarningCount(Context context, int i4) {
        PreferenceManager.getDefaultSharedPreferences(context).edit().putInt(LEGACY_PRO_UPGRADE_WARNING_COUNT, i4).apply();
    }

    public static void setLightSensorBGScanRate(Context context, int i4) {
        SharedPreferences.Editor edit = PreferenceManager.getDefaultSharedPreferences(context).edit();
        edit.putString(PREFERENCE_LIGHT_SENSOR_BG_UPDATE_RATE, String.valueOf(i4));
        edit.apply();
    }

    public static void setListViewNumLines(Context context, int i4) {
        SharedPreferences.Editor edit = PreferenceManager.getDefaultSharedPreferences(context).edit();
        edit.putInt("preferences:list_view_num_lines", i4);
        edit.apply();
    }

    public static void setLocalVarsDisplayMode(Context context, int i4) {
        SharedPreferences.Editor edit = PreferenceManager.getDefaultSharedPreferences(context).edit();
        edit.putInt("prefrences:local_vars_display_mode", i4);
        edit.apply();
    }

    public static void setLocationInfo(Context context, LocationTrigger locationTrigger, LocationTriggerAreaChecker.LocationInfo locationInfo) {
        SharedPreferences.Editor edit = PreferenceManager.getDefaultSharedPreferences(context).edit();
        edit.putString("preferences:loc_info_" + locationTrigger.getLocation().getLatitude() + "_" + locationTrigger.getLocation().getLongitude() + "_" + locationTrigger.getLocation().getAccuracy() + "_" + locationTrigger.isEnterTrigger(), locationInfo.toString());
        edit.apply();
    }

    public static void setLocationUpdateRate(Context context, int i4) {
        SharedPreferences.Editor edit = PreferenceManager.getDefaultSharedPreferences(context).edit();
        edit.putString(PREFERENCE_LOC_UPDATE_RATE, "" + i4).apply();
    }

    public static void setLocationUpdateRateSeconds(Context context, int i4) {
        PreferenceManager.getDefaultSharedPreferences(context).edit().putString(PREFERENCE_LOC_UPDATE_RATE_SECONDS, String.valueOf(i4)).apply();
    }

    public static void setLockedCategoryPassword(Context context, String str) {
        PreferenceManager.getDefaultSharedPreferences(context).edit().putString("database_seed", str).apply();
    }

    public static void setLogTextSize(Context context, int i4) {
        SharedPreferences.Editor edit = PreferenceManager.getDefaultSharedPreferences(context).edit();
        edit.putInt("preferences:macrodroid_log_text_size", i4);
        edit.apply();
    }

    public static void setLogcatEnabledBuffers(Context context, int i4) {
        PreferenceManager.getDefaultSharedPreferences(context).edit().putInt("logcat_enabled_buffers", i4).apply();
    }

    public static void setMacroDroidEnabled(Context context, boolean z3) {
        SharedPreferences.Editor edit = PreferenceManager.getDefaultSharedPreferences(context).edit();
        edit.putBoolean("preferences:macrodroid_enabled", z3);
        edit.apply();
    }

    public static void setMacroDroidIcon(Context context, int i4) {
        SharedPreferences.Editor edit = PreferenceManager.getDefaultSharedPreferences(context).edit();
        edit.putInt("preferences:macrodroid_icon_resource", i4);
        edit.apply();
    }

    public static void setMacroDroidIconResourceName(Context context, String str) {
        SharedPreferences.Editor edit = PreferenceManager.getDefaultSharedPreferences(context).edit();
        edit.putString("preferences:macrodroid_icon_resource_name", str);
        edit.apply();
    }

    public static void setMacroDroidIconTextString(Context context, String str) {
        SharedPreferences.Editor edit = PreferenceManager.getDefaultSharedPreferences(context).edit();
        edit.putString("preferences:macrodroid_icon_text_string", str);
        edit.apply();
    }

    public static void setMacroDroidNotificationBody(Context context, String str) {
        PreferenceManager.getDefaultSharedPreferences(context).edit().putString("preferences:notificationBody", str).apply();
    }

    public static void setMacroDroidNotificationTitle(Context context, String str) {
        PreferenceManager.getDefaultSharedPreferences(context).edit().putString("preferences:notificationTitle", str).apply();
    }

    public static void setMacroListShowDetails(Context context, boolean z3) {
        PreferenceManager.getDefaultSharedPreferences(context).edit().putBoolean("preferences:macro_list_show_details", z3).apply();
    }

    public static void setMacroPoints(Context context, int i4) {
        SharedPreferences.Editor edit = PreferenceManager.getDefaultSharedPreferences(context).edit();
        edit.putInt("preferences:last_run_code", i4 * 13);
        edit.apply();
    }

    public static void setMagicTextDefaultBrackets(Context context, int i4) {
        PreferenceManager.getDefaultSharedPreferences(context).edit().putString("preferences:magic_text_default_brackets", String.valueOf(i4)).apply();
    }

    public static void setMapSatellite(Context context, boolean z3) {
        SharedPreferences.Editor edit = PreferenceManager.getDefaultSharedPreferences(context).edit();
        edit.putBoolean("preferences:map_satellite", z3);
        edit.apply();
    }

    public static void setMediaButtonPassThroughUnhandled(Context context, boolean z3) {
        PreferenceManager.getDefaultSharedPreferences(context).edit().putBoolean("preferences:media_button_pass_through_unhandled", z3).apply();
    }

    public static void setMenuItemMacroLoggingIsDisable(Context context, boolean z3) {
        SharedPreferences.Editor edit = PreferenceManager.getDefaultSharedPreferences(context).edit();
        edit.putBoolean("preferences:macro_logging_is_disable", z3);
        edit.apply();
    }

    public static void setMode(Context context, String str) {
        SharedPreferences.Editor edit = PreferenceManager.getDefaultSharedPreferences(context).edit();
        edit.putString("preferences:mode", str);
        edit.apply();
    }

    public static void setModeList(Context context, String str) {
        SharedPreferences.Editor edit = PreferenceManager.getDefaultSharedPreferences(context).edit();
        edit.putString("preferences:mode_list", str);
        edit.apply();
    }

    public static void setNextFlashSaleDayNumber(Context context, int i4) {
        PreferenceManager.getDefaultSharedPreferences(context).edit().putInt("inverted_calculation", i4).apply();
    }

    public static void setNextProUserCheckTimeStamp(Context context, long j4) {
        PreferenceManager.getDefaultSharedPreferences(context).edit().putLong(TIMESTAMP_FOR_NEXT_PRO_USER_CHECK, j4 * 107).apply();
    }

    public static void setNotificationButtonBarConfiguration(Context context, String str) {
        SharedPreferences.Editor edit = PreferenceManager.getDefaultSharedPreferences(context).edit();
        edit.putString("preferences:notification_button_bar_configuration", str);
        edit.apply();
    }

    public static void setNotificationButtons(Context context, List<NotificationButton> list) {
        String str;
        StringBuilder sb = new StringBuilder();
        for (int i4 = 0; i4 < list.size(); i4++) {
            NotificationButton notificationButton = list.get(i4);
            sb.append(notificationButton.getId());
            sb.append(",");
            sb.append(notificationButton.getImageResourceName());
            sb.append(",");
            sb.append(notificationButton.getImageResourcePackage());
            sb.append(",");
            sb.append(notificationButton.getImageResourceId());
            sb.append(",");
            if (notificationButton.getImageUri() != null) {
                str = notificationButton.getImageUri().toString();
            } else {
                str = "";
            }
            sb.append(str);
            if (i4 < list.size() - 1) {
                sb.append(";");
            }
        }
        setNotificationButtonBarConfiguration(context, sb.toString());
    }

    public static void setNotificationPriority(Context context, int i4) {
        SharedPreferences.Editor edit = PreferenceManager.getDefaultSharedPreferences(context).edit();
        edit.putString(PREFERENCE_NOTIFICATION_PRIORITY, String.valueOf(i4));
        edit.apply();
    }

    public static void setNotifiedStopClubVersionCode(Context context, int i4) {
        PreferenceManager.getDefaultSharedPreferences(context).edit().putInt("sc_n_vc", i4).apply();
    }

    public static void setNotifyOnUDPFailure(Context context, boolean z3) {
        PreferenceManager.getDefaultSharedPreferences(context).edit().putBoolean("preferences:notify_when_failure_udp", z3).apply();
    }

    public static void setOrderId(Context context, String str) {
        PreferenceManager.getDefaultSharedPreferences(context).edit().putString("order_id", str).apply();
    }

    public static void setPassword(Context context, String str) {
        SharedPreferences.Editor edit = PreferenceManager.getDefaultSharedPreferences(context).edit();
        edit.putString(PREFERENCE_PASSWORD_PROTECT, str);
        edit.apply();
    }

    public static void setPasswordCheckDelaySeconds(Context context, int i4) {
        PreferenceManager.getDefaultSharedPreferences(context).edit().putInt("password_check_delay", i4).apply();
    }

    public static void setPlaySoundAudioStream(Context context, int i4) {
        SharedPreferences.Editor edit = PreferenceManager.getDefaultSharedPreferences(context).edit();
        edit.putString("preferences:play_sound_output_channel", "" + i4);
        edit.apply();
    }

    public static void setPluginReportIds(Context context, Set<String> set) {
        PreferenceManager.getDefaultSharedPreferences(context).edit().putStringSet("plugin-report-ids", set).apply();
    }

    public static void setPreviousIpAddress(Context context, String str) {
        PreferenceManager.getDefaultSharedPreferences(context).edit().putString("previous_ip_address", str).apply();
    }

    public static void setProDefault(Context context, boolean z3) {
        SharedPreferences.Editor edit = PreferenceManager.getDefaultSharedPreferences(context).edit();
        edit.putBoolean(OBFUSCATED_PURCHASE_DEFAULT, !z3);
        edit.apply();
    }

    public static void setPromptedForReview(Context context) {
        SharedPreferences.Editor edit = PreferenceManager.getDefaultSharedPreferences(context).edit();
        edit.putBoolean("preferences:prompt_for_review", true);
        edit.apply();
    }

    public static void setProximitySensorScreenOffSetting(Context context, boolean z3) {
        SharedPreferences.Editor edit = PreferenceManager.getDefaultSharedPreferences(context).edit();
        edit.putBoolean(PREFERENCE_PROXIMITY_SENSOR_SCREEN_OFF, z3);
        edit.apply();
    }

    public static void setPurchaseAcknowledgedState(Context context, int i4) {
        PreferenceManager.getDefaultSharedPreferences(context).edit().putInt("ack_state", i4).apply();
    }

    public static void setPurchaseInvalidated(Context context, boolean z3) {
        if (z3) {
            byte[] bArr = new byte[6];
            new Random().nextBytes(bArr);
            PreferenceManager.getDefaultSharedPreferences(context).edit().putString("pvc", new String(bArr, Charset.forName("UTF-8"))).apply();
            return;
        }
        PreferenceManager.getDefaultSharedPreferences(context).edit().putString("pvc", getUniqueId(context, false).substring(3, 8)).apply();
    }

    public static void setPurchaseSku(Context context, String str) {
        PreferenceManager.getDefaultSharedPreferences(context).edit().putString("uks", str).apply();
    }

    public static void setPurchaseToken(Context context, String str) {
        PreferenceManager.getDefaultSharedPreferences(context).edit().putString(TranslateLanguage.PORTUGUESE, str).apply();
    }

    public static void setPushTokenUploadFailed(Context context, boolean z3) {
        SharedPreferences.Editor edit = PreferenceManager.getDefaultSharedPreferences(context).edit();
        edit.putBoolean("prefrences:pushTokenUploadFailed", z3);
        edit.apply();
    }

    public static void setPushTokenUploadedId(Context context, String str) {
        SharedPreferences.Editor edit = PreferenceManager.getDefaultSharedPreferences(context).edit();
        edit.putString("preferences:pushTokenUploaded", str);
        edit.apply();
    }

    public static void setQuickRunIsExpanded(Context context, boolean z3) {
        PreferenceManager.getDefaultSharedPreferences(context).edit().putBoolean("preferences:quick_run_is_expanded", z3).apply();
    }

    public static void setQuickRunMacroGuids(Context context, List<Long> list) {
        PreferenceManager.getDefaultSharedPreferences(context).edit().putString("preferences:quick_run_macro_guids", TextUtils.join(",", list)).apply();
    }

    public static void setReadScreenContentsUpdateRateMs(Context context, String str) {
        SharedPreferences.Editor edit = PreferenceManager.getDefaultSharedPreferences(context).edit();
        edit.putString(PREFERENCE_READ_SCREEN_CONTENTS_UPDATE_RATE, str);
        edit.apply();
    }

    public static void setReverseSystemLog(Context context, boolean z3) {
        SharedPreferences.Editor edit = PreferenceManager.getDefaultSharedPreferences(context).edit();
        edit.putBoolean("preferences:log_reverse_order", z3);
        edit.apply();
    }

    public static void setReverseUserLog(Context context, boolean z3) {
        SharedPreferences.Editor edit = PreferenceManager.getDefaultSharedPreferences(context).edit();
        edit.putBoolean("preferences:user_log_reverse_order", z3);
        edit.apply();
    }

    public static void setRootEnabled(Context context, boolean z3) {
        SharedPreferences.Editor edit = PreferenceManager.getDefaultSharedPreferences(context).edit();
        edit.putBoolean(PREFERENCE_ROOT_ENABLED, z3);
        edit.apply();
    }

    public static void setSecondaryProEnabled(Context context, boolean z3) {
        int i4;
        if (z3) {
            i4 = ((new Random().nextInt(771000) + 771) / 771) * 771;
        } else {
            i4 = 0;
        }
        SharedPreferences.Editor edit = PreferenceManager.getDefaultSharedPreferences(context).edit();
        edit.putInt(OBFUSCATED_PURCHASE_KEY_2, i4);
        edit.apply();
    }

    public static void setSettingsForceLocaleAtStartup(Context context, boolean z3) {
        PreferenceManager.getDefaultSharedPreferences(context).edit().putBoolean("force_locale_at_startup", z3).apply();
    }

    public static void setShakeSampleFrequency(Context context, String str) {
        PreferenceManager.getDefaultSharedPreferences(context).edit().putString(PREFERENCE_SHAKE_SAMPLE_FREQUENCY, str).apply();
    }

    public static void setShakeScreenOffSetting(Context context, boolean z3) {
        PreferenceManager.getDefaultSharedPreferences(context).edit().putBoolean(PREFERENCE_SHAKE_SCREEN_OFF, z3).apply();
    }

    public static void setShakeSensitiviy(Context context, String str) {
        PreferenceManager.getDefaultSharedPreferences(context).edit().putString(PREFERENCE_SHAKE_SENSITIVITY, str).apply();
    }

    public static void setShakeTriggerVibrate(Context context, boolean z3) {
        PreferenceManager.getDefaultSharedPreferences(context).edit().putBoolean("preferences:shake_vibrate", z3).apply();
    }

    public static void setShouldHideHuaweiWarning(Context context, boolean z3) {
        SharedPreferences.Editor edit = PreferenceManager.getDefaultSharedPreferences(context).edit();
        edit.putBoolean("preferences:hide_huawei_warning", z3);
        edit.apply();
    }

    public static void setShowAccessibilityInfo(Context context, boolean z3) {
        PreferenceManager.getDefaultSharedPreferences(context).edit().putBoolean("shai", z3).apply();
    }

    public static void setShowAutoTranslatePopup(Context context, boolean z3) {
        PreferenceManager.getDefaultSharedPreferences(context).edit().putBoolean("template_store_show_auto_translate_popup", z3).apply();
    }

    public static void setShowCategoriesSelectableItems(Context context, boolean z3) {
        SharedPreferences.Editor edit = PreferenceManager.getDefaultSharedPreferences(context).edit();
        edit.putBoolean("preferences:show_categories_selectable_items", z3);
        edit.apply();
    }

    public static void setShowDescriptions(Context context, boolean z3) {
        SharedPreferences.Editor edit = PreferenceManager.getDefaultSharedPreferences(context).edit();
        edit.putBoolean("preferences:show_descriptions", z3);
        edit.apply();
    }

    public static void setShowFavouritesOnly(Context context, boolean z3) {
        PreferenceManager.getDefaultSharedPreferences(context).edit().putBoolean("list_favourites_only", z3).apply();
    }

    public static void setShowJavaScriptVariableWarningNotification(Context context, boolean z3) {
        SharedPreferences.Editor edit = PreferenceManager.getDefaultSharedPreferences(context).edit();
        edit.putBoolean(PREFERENCE_SHOW_JAVASCRIPT_VARIABLE_WARNING, z3);
        edit.apply();
    }

    public static void setShowLastActivations(Context context, boolean z3) {
        SharedPreferences.Editor edit = PreferenceManager.getDefaultSharedPreferences(context).edit();
        edit.putBoolean("preferences:show_last_activations", z3);
        edit.apply();
    }

    public static void setShowLastEditedTimes(Context context, boolean z3) {
        SharedPreferences.Editor edit = PreferenceManager.getDefaultSharedPreferences(context).edit();
        edit.putBoolean("preferences:show_last_edited_times", z3);
        edit.apply();
    }

    public static void setShowLastRunMacrosInNotification(Context context, boolean z3) {
        SharedPreferences.Editor edit = PreferenceManager.getDefaultSharedPreferences(context).edit();
        edit.putBoolean(PREFERENCE_NOTIFICATION_LIST_MACROS, z3);
        edit.apply();
    }

    public static void setShowLogicConstraintInfo(Context context, boolean z3) {
        PreferenceManager.getDefaultSharedPreferences(context).edit().putBoolean("show_logic_constraint_info", z3).apply();
    }

    public static void setShowMacroDroidIcon(Context context, boolean z3) {
        SharedPreferences.Editor edit = PreferenceManager.getDefaultSharedPreferences(context).edit();
        edit.putBoolean("preferences:show_macrodroid_icon", z3);
        edit.apply();
    }

    public static void setShowNotificationButtonBar(Context context, boolean z3) {
        SharedPreferences.Editor edit = PreferenceManager.getDefaultSharedPreferences(context).edit();
        edit.putBoolean(PREFERENCE_SHOW_NOTIFICATION_BUTTON_BAR, z3);
        edit.apply();
    }

    public static void setShowNotificationCurrentMode(Context context, boolean z3) {
        SharedPreferences.Editor edit = PreferenceManager.getDefaultSharedPreferences(context).edit();
        edit.putBoolean("preferences:show_notification_current_mode", z3);
        edit.apply();
    }

    public static void setShowPluginDialog(Context context, boolean z3) {
        PreferenceManager.getDefaultSharedPreferences(context).edit().putBoolean("preferences:show_plugins_dialog_on_entry", z3).apply();
    }

    public static void setShowScreenOnOffHelpPopup(Context context, boolean z3) {
        PreferenceManager.getDefaultSharedPreferences(context).edit().putBoolean("show_scren_on_off_help", z3).apply();
    }

    public static void setShowValidationWarning(Context context, boolean z3) {
        PreferenceManager.getDefaultSharedPreferences(context).edit().putBoolean("svw", z3).apply();
    }

    public static void setShowWorkingVariableHelpInfo(Context context, boolean z3) {
        PreferenceManager.getDefaultSharedPreferences(context).edit().putBoolean("preferences:working_variables_help_info", z3).apply();
    }

    public static void setShown5_0AppLaunchWarning(Context context, boolean z3) {
        SharedPreferences.Editor edit = PreferenceManager.getDefaultSharedPreferences(context).edit();
        edit.putBoolean("preferences:shown_5_0_app_launch_warning", z3);
        edit.apply();
    }

    public static void setShownAlarmClockPopup(Context context, boolean z3) {
        SharedPreferences.Editor edit = PreferenceManager.getDefaultSharedPreferences(context).edit();
        edit.putBoolean("preferences:shown_alarm_clock_popup", z3);
        edit.apply();
    }

    public static void setShownBusyBoxWarning(Context context, boolean z3) {
        SharedPreferences.Editor edit = PreferenceManager.getDefaultSharedPreferences(context).edit();
        edit.putBoolean("preferences:shown_notification_busybox", z3);
        edit.apply();
    }

    public static void setShownEULA(Context context, boolean z3) {
        SharedPreferences.Editor edit = PreferenceManager.getDefaultSharedPreferences(context).edit();
        edit.putBoolean("preferences:shown_eula_new", z3);
        edit.apply();
    }

    public static void setShownMagicTextBracketInfo(Context context, boolean z3) {
        SharedPreferences.Editor edit = PreferenceManager.getDefaultSharedPreferences(context).edit();
        edit.putBoolean("preferences:shown_magic_text_bracket_info", z3);
        edit.apply();
    }

    public static void setShownMultiTriggerWarning(Context context, boolean z3) {
        SharedPreferences.Editor edit = PreferenceManager.getDefaultSharedPreferences(context).edit();
        edit.putBoolean("prefernces:shown_multi_trigger_warning", z3);
        edit.apply();
    }

    public static void setShownNotificationLightWarning(Context context, boolean z3) {
        SharedPreferences.Editor edit = PreferenceManager.getDefaultSharedPreferences(context).edit();
        edit.putBoolean("preferences:shown_notification_light_warning", z3);
        edit.apply();
    }

    public static void setShownPebbelInfo(Context context, boolean z3) {
        SharedPreferences.Editor edit = PreferenceManager.getDefaultSharedPreferences(context).edit();
        edit.putBoolean("preferences:shown_pebble_info", z3);
        edit.apply();
    }

    public static void setShownVolumeButtonWarning(Context context, boolean z3) {
        SharedPreferences.Editor edit = PreferenceManager.getDefaultSharedPreferences(context).edit();
        edit.putBoolean("preferences:shown_voluem_button_warning", z3);
        edit.apply();
    }

    public static void setSleepFallAsleepThreshold(Context context, int i4) {
        PreferenceManager.getDefaultSharedPreferences(context).edit().putInt("sleep_fall_asleep_threshold", i4).apply();
    }

    public static void setSleepWakeUpThreshold(Context context, int i4) {
        PreferenceManager.getDefaultSharedPreferences(context).edit().putInt("sleep_wake_up_threshold", i4).apply();
    }

    public static void setSmtpServerConfig(Context context, SmtpServerConfig smtpServerConfig) {
        SharedPreferences.Editor edit = PreferenceManager.getDefaultSharedPreferences(context).edit();
        edit.putString("preferences:smtp_server_address", smtpServerConfig.getServerAddress()).apply();
        edit.putString("preferences:smtp_server_port", smtpServerConfig.getServerPort()).apply();
        edit.putBoolean("preferences:smtp_use_authentication", smtpServerConfig.getUseAuthentication()).apply();
        edit.putString("preferences:smtp_username", smtpServerConfig.getUsername()).apply();
        edit.putString("preferences:smtp_password", smtpServerConfig.getPassword()).apply();
        edit.putBoolean("preferences:start_tls_enabled", smtpServerConfig.getStartTlsEnabled());
    }

    public static void setSpokenLocale(Context context, String str) {
        SharedPreferences.Editor edit = PreferenceManager.getDefaultSharedPreferences(context).edit();
        edit.putString(PREFERENCE_SPOKEN_LANGUAGE, str);
        edit.apply();
    }

    public static void setSpokenTextAudioStream(Context context, int i4) {
        SharedPreferences.Editor edit = PreferenceManager.getDefaultSharedPreferences(context).edit();
        edit.putString("preferences:spoke_language_output_channel", "" + i4);
        edit.apply();
    }

    public static void setSunriseSunsetLatLon(Context context, String str) {
        SharedPreferences.Editor edit = PreferenceManager.getDefaultSharedPreferences(context).edit();
        edit.putString("preference:weather_sunset_sunrise", str);
        edit.apply();
    }

    public static void setSystemHelperInstalledVersion(Context context, int i4) {
        SharedPreferences.Editor edit = PreferenceManager.getDefaultSharedPreferences(context).edit();
        edit.putInt("preferences:system_helper_version", i4);
        edit.apply();
    }

    public static void setSystemLogFilter(Context context, LogFilter logFilter) {
        SharedPreferences defaultSharedPreferences = PreferenceManager.getDefaultSharedPreferences(context);
        String json = new GsonBuilder().create().toJson(logFilter, logFilter.getClass());
        SharedPreferences.Editor edit = defaultSharedPreferences.edit();
        edit.putString("system_log_filter", json);
        edit.apply();
    }

    public static void setSystemLogMaxLength(Context context, int i4) {
        SharedPreferences.Editor edit = PreferenceManager.getDefaultSharedPreferences(context).edit();
        edit.putString(PREFERENCE_SYSTEM_LOG_LENGTH, "" + i4);
        edit.apply();
    }

    public static void setSystemLogShowMilliSeconds(Context context, boolean z3) {
        PreferenceManager.getDefaultSharedPreferences(context).edit().putBoolean("system_log_show_milliseconds", z3).apply();
    }

    public static void setTTSEnginePackage(Context context, String str) {
        SharedPreferences.Editor edit = PreferenceManager.getDefaultSharedPreferences(context).edit();
        edit.putString(PREFERENCE_TTS_ENGINE, str);
        edit.apply();
    }

    public static void setTemplateInfoCardHide(Context context, boolean z3) {
        SharedPreferences.Editor edit = PreferenceManager.getDefaultSharedPreferences(context).edit();
        edit.putBoolean("preferences:template_info_card_hide", z3);
        edit.apply();
    }

    public static void setTemplateStoreAccount(Context context, User user) {
        SharedPreferences.Editor edit = PreferenceManager.getDefaultSharedPreferences(context).edit();
        if (user == null) {
            edit.putString("preferences:templateStoreAccount", null);
        } else {
            edit.putString("preferences:templateStoreAccount", new GsonBuilder().create().toJson(user, User.class));
        }
        edit.apply();
    }

    public static void setTemplateStoreAutoTranslateLanguage(Context context, @Nullable String str) {
        PreferenceManager.getDefaultSharedPreferences(context).edit().putString("template_store_auto_translate_lang", str).apply();
    }

    public static void setTemplateStoreCompactMode(Context context, boolean z3) {
        PreferenceManager.getDefaultSharedPreferences(context).edit().putBoolean("preferences:template_store_compact_mode", z3).apply();
    }

    public static void setTemplatesUsername(Context context, String str) {
        SharedPreferences.Editor edit = PreferenceManager.getDefaultSharedPreferences(context).edit();
        edit.putString("preferences:templates_user_name", str);
        edit.apply();
    }

    public static void setThumbsDowns(Context context, Set<String> set) {
        SharedPreferences.Editor edit = PreferenceManager.getDefaultSharedPreferences(context).edit();
        edit.putStringSet("preferences:thumbs_downs", set);
        edit.apply();
    }

    public static void setThumbsUps(Context context, Set<String> set) {
        SharedPreferences.Editor edit = PreferenceManager.getDefaultSharedPreferences(context).edit();
        edit.putStringSet("preferences:thumbs_ups", set);
        edit.apply();
    }

    public static void setTinyUrl(Context context, String str) {
        SharedPreferences.Editor edit = PreferenceManager.getDefaultSharedPreferences(context).edit();
        edit.putString("tinyurl", str);
        edit.apply();
    }

    public static void setTouchScreenDevice(Context context, String str) {
        SharedPreferences.Editor edit = PreferenceManager.getDefaultSharedPreferences(context).edit();
        edit.putString("preferences:touch_screen_device", str);
        edit.apply();
    }

    public static void setTriggerLoggingEnabled(Context context, boolean z3) {
        SharedPreferences.Editor edit = PreferenceManager.getDefaultSharedPreferences(context).edit();
        edit.putBoolean("preferences:trigger_logging", z3);
        edit.apply();
    }

    public static void setUniqueId(Context context, String str) {
        SharedPreferences.Editor edit = PreferenceManager.getDefaultSharedPreferences(context).edit();
        edit.putString("preferences:uid", str);
        edit.apply();
    }

    public static void setUpgradeBannerLastUpdateTime(Context context, long j4) {
        SharedPreferences.Editor edit = PreferenceManager.getDefaultSharedPreferences(context).edit();
        edit.putLong("upgrade_banner_last_change_time", j4);
        edit.apply();
    }

    public static void setUpgradeSerial(Context context, String str) {
        PreferenceManager.getDefaultSharedPreferences(context).edit().putString("hash_code", str).apply();
    }

    public static void setUseCalendarAlarm(Context context, boolean z3) {
        SharedPreferences.Editor edit = PreferenceManager.getDefaultSharedPreferences(context).edit();
        edit.putBoolean("prefrences:use_calendar_alarm", z3);
        edit.apply();
    }

    public static void setUseExtraBetaChannel(Context context, boolean z3) {
        PreferenceManager.getDefaultSharedPreferences(context).edit().putBoolean("ex_bc", z3).apply();
    }

    public static void setUseInboxIncomingSMS(Context context, boolean z3) {
        SharedPreferences.Editor edit = PreferenceManager.getDefaultSharedPreferences(context).edit();
        edit.putBoolean("preferences:use_inbox_incoming_sms", z3);
        edit.apply();
    }

    public static void setUseWizardMode(Context context, boolean z3) {
        SharedPreferences.Editor edit = PreferenceManager.getDefaultSharedPreferences(context).edit();
        edit.putBoolean("preferences:add_macro_wizard_mode", z3);
        edit.apply();
    }

    public static void setUserIconMigrationComplete(Context context, boolean z3) {
        PreferenceManager.getDefaultSharedPreferences(context).edit().putBoolean("user_icon_migration_complete", z3).apply();
    }

    public static void setUserLogDateLayoutEnabled(Context context, boolean z3) {
        SharedPreferences.Editor edit = PreferenceManager.getDefaultSharedPreferences(context).edit();
        edit.putBoolean("preferences:user_log_date_layout", z3);
        edit.apply();
    }

    public static void setUserLogTextSize(Context context, int i4) {
        SharedPreferences.Editor edit = PreferenceManager.getDefaultSharedPreferences(context).edit();
        edit.putInt("preferences:macrodroid_user_log_text_size", i4);
        edit.apply();
    }

    public static void setVpnEnabledState(Context context, boolean z3) {
        SharedPreferences.Editor edit = PreferenceManager.getDefaultSharedPreferences(context).edit();
        edit.putBoolean("status:vpn_enabled", z3);
        edit.apply();
    }

    public static void setWeatherLatLon(Context context, String str) {
        SharedPreferences.Editor edit = PreferenceManager.getDefaultSharedPreferences(context).edit();
        edit.putString("preference:weather_lat_lon", str);
        edit.apply();
    }

    public static void setWeatherUpdateRate(Context context, int i4) {
        PreferenceManager.getDefaultSharedPreferences(context).edit().putString(PREFERENCE_WEATHER_UPDATE_RATE, String.valueOf(i4)).apply();
    }

    public static void setWidgetButtonVibrateOnPress(Context context, boolean z3) {
        SharedPreferences.Editor edit = PreferenceManager.getDefaultSharedPreferences(context).edit();
        edit.putBoolean("preferences:widget_button_vibrate_on_press", z3);
        edit.apply();
    }

    public static void setWifiBackgroundScanRate(Context context, int i4) {
        SharedPreferences.Editor edit = PreferenceManager.getDefaultSharedPreferences(context).edit();
        edit.putString(PREFERENCE_WIFI_BACKGROUND_SCAN_RATE, "" + i4);
        edit.apply();
    }

    public static boolean shouldHideIgnoredTowersInfoCard(Context context) {
        return PreferenceManager.getDefaultSharedPreferences(context).getBoolean("preferences:hide_info_card_ignored_cell_towers", false);
    }

    public static boolean shouldHideInfoAutoBackup(Context context) {
        return PreferenceManager.getDefaultSharedPreferences(context).getBoolean("preferences:hide_info_card_auto_backup", false);
    }

    public static boolean shouldHideInfoCardAction(Context context) {
        return PreferenceManager.getDefaultSharedPreferences(context).getBoolean("preferences:hide_info_card_action", false);
    }

    public static boolean shouldHideInfoCardActionBlocks(Context context) {
        return PreferenceManager.getDefaultSharedPreferences(context).getBoolean("preference:hide_info_card_action_blocks", false);
    }

    public static boolean shouldHideInfoCardCategories(Context context) {
        return PreferenceManager.getDefaultSharedPreferences(context).getBoolean("preferences:hide_info_card_categories", false);
    }

    public static boolean shouldHideInfoCardCellTowers(Context context) {
        return PreferenceManager.getDefaultSharedPreferences(context).getBoolean("preferences:hide_info_card_cell_towers", false);
    }

    public static boolean shouldHideInfoCardConstraint(Context context) {
        return PreferenceManager.getDefaultSharedPreferences(context).getBoolean("preferences:hide_info_card_constraint", false);
    }

    public static boolean shouldHideInfoCardDrawer(Context context) {
        return PreferenceManager.getDefaultSharedPreferences(context).getBoolean("preferences:hide_info_card_drawer", false);
    }

    public static boolean shouldHideInfoCardGeofences(Context context) {
        return PreferenceManager.getDefaultSharedPreferences(context).getBoolean("preferences:hide_info_card_geofences", false);
    }

    public static boolean shouldHideInfoCardNotificationBar(Context context) {
        return PreferenceManager.getDefaultSharedPreferences(context).getBoolean("preferences:hide_info_card_notification_bar", false);
    }

    public static boolean shouldHideInfoCardQuickSettings(Context context) {
        return PreferenceManager.getDefaultSharedPreferences(context).getBoolean("preferences:hide_info_card_quick_settings", false);
    }

    public static boolean shouldHideInfoCardRecentTowers(Context context) {
        return PreferenceManager.getDefaultSharedPreferences(context).getBoolean("preferences:hide_info_card_recent_towers", false);
    }

    public static boolean shouldHideInfoCardSystemLog(Context context) {
        return PreferenceManager.getDefaultSharedPreferences(context).getBoolean("preferences:hide_info_card_system_log", false);
    }

    public static boolean shouldHideInfoCardTrigger(Context context) {
        return PreferenceManager.getDefaultSharedPreferences(context).getBoolean("preferences:hide_info_card_trigger", false);
    }

    public static boolean shouldHideInfoCardUserLog(Context context) {
        return PreferenceManager.getDefaultSharedPreferences(context).getBoolean("preferences:hide_info_card_user_log", false);
    }

    public static boolean shouldHideInfoCardVariables(Context context) {
        return PreferenceManager.getDefaultSharedPreferences(context).getBoolean("preferences:hide_info_card_variables", false);
    }

    public static boolean shouldHideKeepAccessibilityRunning(Context context) {
        return PreferenceManager.getDefaultSharedPreferences(context).getBoolean("preferences:hide_info_card_keep_accessibility_running", false);
    }
}
