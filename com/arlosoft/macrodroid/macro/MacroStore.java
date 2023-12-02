package com.arlosoft.macrodroid.macro;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Looper;
import android.text.TextUtils;
import android.util.Base64;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.util.AtomicFile;
import androidx.documentfile.provider.DocumentFile;
import com.arlosoft.macrodroid.MacroDroidService;
import com.arlosoft.macrodroid.R;
import com.arlosoft.macrodroid.action.Action;
import com.arlosoft.macrodroid.action.SetWallpaperAction;
import com.arlosoft.macrodroid.actionblock.data.ActionBlock;
import com.arlosoft.macrodroid.analytics.FirebaseAnalyticsEventLogger;
import com.arlosoft.macrodroid.app.MacroDroidApplication;
import com.arlosoft.macrodroid.app.di.annotations.ApplicationContext;
import com.arlosoft.macrodroid.autobackup.worker.AutoBackupCloudWorker;
import com.arlosoft.macrodroid.categories.Category;
import com.arlosoft.macrodroid.categories.CategoryList;
import com.arlosoft.macrodroid.celltowers.CellTowerGroupStore;
import com.arlosoft.macrodroid.common.MacroDroidVariableStore;
import com.arlosoft.macrodroid.common.NotificationButton;
import com.arlosoft.macrodroid.common.Util;
import com.arlosoft.macrodroid.confirmation.PremiumStatusHandler;
import com.arlosoft.macrodroid.constraint.Constraint;
import com.arlosoft.macrodroid.data.CategoryExportData;
import com.arlosoft.macrodroid.data.ExportData;
import com.arlosoft.macrodroid.data.HomeScreenTileConfig;
import com.arlosoft.macrodroid.data.MacroExportData;
import com.arlosoft.macrodroid.data.UserIconData;
import com.arlosoft.macrodroid.database.Database;
import com.arlosoft.macrodroid.drawer.model.DrawerConfiguration;
import com.arlosoft.macrodroid.geofences.GeofenceStore;
import com.arlosoft.macrodroid.gson.GsonUtils;
import com.arlosoft.macrodroid.logging.systemlog.SystemLog;
import com.arlosoft.macrodroid.notification.NotificationChannelList;
import com.arlosoft.macrodroid.quicksettings.QuickSettingsData;
import com.arlosoft.macrodroid.settings.Settings;
import com.arlosoft.macrodroid.stopwatch.StopWatch;
import com.arlosoft.macrodroid.triggers.AndroidWearTrigger;
import com.arlosoft.macrodroid.triggers.ScreenContentTrigger;
import com.arlosoft.macrodroid.triggers.Trigger;
import com.arlosoft.macrodroid.utils.AndroidWearHelper;
import com.arlosoft.macrodroid.utils.Debouncer;
import com.arlosoft.macrodroid.utils.FileUtils;
import com.arlosoft.macrodroid.utils.NotificationChannelUtil;
import com.arlosoft.macrodroid.utils.encryption.Encryptor;
import com.arlosoft.macrodroid.utils.encryption.ExtrasEncryption;
import com.google.firebase.sessions.settings.RemoteSettings;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.text.Collator;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.ConcurrentModificationException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import me.drakeet.support.toast.ToastCompat;

/* loaded from: classes3.dex */
public class MacroStore implements ActionBlockStore {
    public static final String JSON_FILE_EXTRA_MACROS = "extramacros.bin";

    /* renamed from: k  reason: collision with root package name */
    private static List<Macro> f12828k;

    /* renamed from: l  reason: collision with root package name */
    private static MacroStore f12829l;

    /* renamed from: m  reason: collision with root package name */
    private static HashSet<String> f12830m;

    /* renamed from: n  reason: collision with root package name */
    private static final Object f12831n = new Object();

    /* renamed from: f  reason: collision with root package name */
    private boolean f12837f;
    @ApplicationContext

    /* renamed from: h  reason: collision with root package name */
    private final Context f12839h;

    /* renamed from: g  reason: collision with root package name */
    private final Object f12838g = new Object();

    /* renamed from: j  reason: collision with root package name */
    private final Debouncer f12841j = new Debouncer();

    /* renamed from: a  reason: collision with root package name */
    private HashMap<Long, Macro> f12832a = new HashMap<>();

    /* renamed from: b  reason: collision with root package name */
    private HashMap<Long, Macro> f12833b = new HashMap<>();

    /* renamed from: c  reason: collision with root package name */
    private HashMap<Long, Macro> f12834c = new HashMap<>();

    /* renamed from: d  reason: collision with root package name */
    private HashMap<Long, Macro> f12835d = new HashMap<>();

    /* renamed from: e  reason: collision with root package name */
    private HashMap<Long, Macro> f12836e = new HashMap<>();

    /* renamed from: i  reason: collision with root package name */
    private PremiumStatusHandler f12840i = MacroDroidApplication.getInstance().premiumStatusHandler;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public class a extends Thread {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ Macro f12842a;

        a(Macro macro) {
            this.f12842a = macro;
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            Iterator<Trigger> it = this.f12842a.getTriggerList().iterator();
            while (it.hasNext()) {
                for (Constraint constraint : it.next().getConstraints()) {
                    constraint.disableConstraintCheckingThreadSafe();
                }
            }
            Iterator<Action> it2 = this.f12842a.getActions().iterator();
            while (it2.hasNext()) {
                Action next = it2.next();
                next.kill();
                next.disableActionThreadSafe();
                for (Constraint constraint2 : next.getConstraints()) {
                    constraint2.disableConstraintCheckingThreadSafe();
                }
            }
            for (Constraint constraint3 : this.f12842a.getConstraints()) {
                constraint3.disableConstraintCheckingThreadSafe();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public class b extends TypeToken<Collection<Macro>> {
        b() {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public class c extends TypeToken<List<String>> {
        c() {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public class d extends TypeToken<Collection<Macro>> {
        d() {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public class e implements Runnable {
        e() {
        }

        @Override // java.lang.Runnable
        public void run() {
            MacroStore.this.writeToJSON("macros.json", false, false, true, (String) null);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public class f implements Runnable {
        f() {
        }

        @Override // java.lang.Runnable
        public void run() {
            MacroStore.this.writeExtras(MacroStore.JSON_FILE_EXTRA_MACROS, SetWallpaperAction.EXTRA_ENCRYPTION_PASSWORD);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public class g extends Thread {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ Macro f12849a;

        g(Macro macro) {
            this.f12849a = macro;
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            Iterator<Action> it = this.f12849a.getActions().iterator();
            while (it.hasNext()) {
                Action next = it.next();
                next.kill();
                next.disableActionThreadSafe();
                for (Constraint constraint : next.getConstraints()) {
                    constraint.disableConstraintCheckingThreadSafe();
                }
            }
        }
    }

    private MacroStore(@ApplicationContext Context context) {
        this.f12837f = false;
        this.f12839h = context;
        if (!this.f12837f) {
            this.f12837f = true;
        }
    }

    private String g(String str) {
        return ("((" + MacroDroidVariableStore.getInstance().getJson() + "))") + str;
    }

    public static synchronized MacroStore getInstance(@ApplicationContext Context context) {
        MacroStore macroStore;
        synchronized (MacroStore.class) {
            if (f12829l == null) {
                f12829l = new MacroStore(context);
                SystemLog.logVerbose("Reading JSON file on startup");
                f12829l.readFromJSON(false);
                f12829l.readExtras(false);
            }
            macroStore = f12829l;
        }
        return macroStore;
    }

    @Nullable
    public static synchronized MacroStore getInstanceIfAvailable() {
        MacroStore macroStore;
        synchronized (MacroStore.class) {
            macroStore = f12829l;
        }
        return macroStore;
    }

    private void h(Macro macro) {
        Iterator<Trigger> it = macro.getTriggerList().iterator();
        while (it.hasNext()) {
            Trigger next = it.next();
            next.applyImport();
            for (Constraint constraint : next.getConstraints()) {
                constraint.setMacro(macro);
                constraint.applyImport();
            }
        }
        Iterator<Action> it2 = macro.getActions().iterator();
        while (it2.hasNext()) {
            Action next2 = it2.next();
            next2.applyImport();
            for (Constraint constraint2 : next2.getConstraints()) {
                constraint2.setMacro(macro);
                constraint2.applyImport();
            }
        }
        for (Constraint constraint3 : macro.getConstraints()) {
            constraint3.setMacro(macro);
            constraint3.applyImport();
        }
    }

    private void i(Iterator<Macro> it) {
        while (it.hasNext()) {
            Macro next = it.next();
            if (next.isActionBlock) {
                new g(next).start();
                it.remove();
            }
        }
    }

    public static boolean isInstanceAvailable() {
        if (f12829l != null) {
            return true;
        }
        return false;
    }

    private void j(Collection<Macro> collection) {
        synchronized (f12831n) {
            Iterator<Macro> it = collection.iterator();
            while (it.hasNext()) {
                Macro next = it.next();
                if (!(next instanceof ActionBlock)) {
                    if (next.isEnabled()) {
                        Iterator<Trigger> it2 = next.getTriggerList().iterator();
                        while (it2.hasNext()) {
                            it2.next().disableTriggerThreadSafe();
                        }
                    }
                    new a(next).start();
                    it.remove();
                }
            }
        }
    }

    private ExportData k(boolean z3) {
        File[] listFiles;
        ExportData exportData = new ExportData();
        exportData.macroList = getAllCompletedMacrosWithActionBlocks(true);
        exportData.notificationButtonBarConfig = Settings.getNotificationButtonBarConfiguration(this.f12839h);
        exportData.notificationButtonBarIconTint = Settings.getButtonBarIconTint(this.f12839h);
        exportData.notificationButtonBarIsEnabled = Settings.getShowNotificationButtonBar(this.f12839h);
        exportData.forceBlackBackground = Settings.getButtonBarBlackBg(this.f12839h);
        exportData.drawerConfiguration = Settings.getDrawerConfiguration(this.f12839h);
        exportData.cellTowerGroups = CellTowerGroupStore.getInstance().getCellTowerGroups();
        exportData.cellTowersIgnore = Database.getInstance(this.f12839h).getIgnoreCellTowers();
        exportData.categoryList = (CategoryList) MacroDroidApplication.getInstance().getCache(Category.CATEGORY_CACHE).get(Category.CATEGORIES_KEY, CategoryList.class);
        exportData.geofenceData = (GeofenceStore) MacroDroidApplication.getInstance().getCache("GeofenceInfo").get("GeofenceInfo", GeofenceStore.class);
        exportData.quickSettingsData = (QuickSettingsData) MacroDroidApplication.getInstance().getCache(QuickSettingsData.QUICK_SETTINGS_CACHE).get(QuickSettingsData.QUICK_SETTINGS_DATA_KEY, QuickSettingsData.class);
        exportData.stopWatches = StopWatch.getStopWatches(this.f12839h);
        exportData.notificationChannelList = (NotificationChannelList) MacroDroidApplication.getInstance().getCache(NotificationChannelUtil.NOTIFICATION_CHANNELS).get(NotificationChannelUtil.NOTIFICATION_CHANNELS, NotificationChannelList.class);
        exportData.variables = MacroDroidVariableStore.getInstance().getAllVariables(true);
        exportData.homeScreenTileConfig = (HomeScreenTileConfig) MacroDroidApplication.getInstance().getCache("HomeScreenTiles").get("HomeScreenTiles", HomeScreenTileConfig.class);
        exportData.smtpServerConfig = Settings.getSmtpServerConfig(this.f12839h);
        exportData.databaseHash = Settings.getLockedCategoryPassword(this.f12839h);
        exportData.quickRunMacroIds = Settings.getQuickRunMacroGuids(this.f12839h);
        exportData.readScreenUpdateRate = Integer.valueOf(Settings.getReadScreenContentsUpdateRateMs(MacroDroidApplication.getInstance()));
        exportData.notificationPriority = Integer.valueOf(Settings.getNotificationPriority(MacroDroidApplication.getInstance()));
        exportData.enableRootFeatures = Settings.getRootEnabled(this.f12839h);
        exportData.enableExperimentalFeatures = Settings.areExperimentalFeaturesEnabled(this.f12839h);
        exportData.spokenTextAudioStream = Settings.getSpokenTextAudioStream(this.f12839h);
        exportData.activityRecognitionUpdateRate = Settings.getActivityRecognitionUpdateRate(this.f12839h);
        exportData.smsMonitorInbox = Settings.getUseInboxIncomingSMS(this.f12839h);
        exportData.widgetButtonVibrateOnPress = Settings.getWidgetButtonVibrateOnPress(this.f12839h);
        exportData.wifiSSIDBackgroundScanRate = Settings.getWifiBackgroundScanRate(this.f12839h);
        exportData.cellTowerUpdateRate = Settings.getCellTowerUpdateRate(this.f12839h);
        exportData.cellTowerUseAlarm = Settings.getCellTowerUseAlarm(this.f12839h);
        exportData.locationUpdateRate = Settings.getLocationUpdateRate(this.f12839h);
        exportData.shakeWorkWithScreenOff = Settings.getShakeScreenOffSetting(this.f12839h);
        exportData.vibrateOnShake = Settings.getShakeTriggerVibrate(this.f12839h);
        exportData.shakeSensitivity = Settings.getShakeSensitiviy(this.f12839h);
        exportData.shakeDetectionRate = Settings.getShakeSampleFrequency(this.f12839h);
        exportData.flipWithScreenOff = Settings.getFlipDeviceScreenOffSetting(this.f12839h);
        exportData.vibrateOnFlip = Settings.getFlipDeviceVibrateSetting(this.f12839h);
        exportData.proximityWorkWithScreenOff = Settings.getProximitySensorScreenOffSetting(this.f12839h);
        exportData.weatherTriggerLocation = Settings.getWeatherLatLon(this.f12839h);
        exportData.weatherUpdateRate = Settings.getWeatherUpdateRate(this.f12839h);
        exportData.sunsetSunriseLocation = Settings.getSunriseSunsetLatLon(this.f12839h);
        exportData.lightSensorUpdateRate = Settings.getLightSensorBGScanRate(this.f12839h);
        exportData.mediaButtonPassThroughUnhandled = Settings.getMediaButtonPassThroughUnhandled(this.f12839h);
        exportData.udpNotifyFailure = Settings.getNotifyOnUDPFailure(this.f12839h);
        exportData.deviceFacingConstraintWorkWithScreenOff = Settings.getDeviceFacingWorkWithScreenOff(this.f12839h);
        exportData.templateMacrosAutoTranslate = Settings.getAutoTranslateTemplates(this.f12839h);
        exportData.macroDroidIconResourceId = Integer.valueOf(Settings.getMacroDroidIcon(this.f12839h));
        exportData.macroDroidIconResourceName = Settings.getMacroDroidIconResourceName(this.f12839h);
        exportData.getMacroDroidIconTextString = Settings.getMacroDroidIconTextString(this.f12839h);
        exportData.homeScreenTilesNumRows = Integer.valueOf(Settings.getHomeScreenTilesPerRow(this.f12839h));
        exportData.homeScreenTilesNumRowsLandscape = Integer.valueOf(Settings.getHomeScreenTilesPerRowLandscape(this.f12839h));
        if (z3) {
            File userIconDir = FileUtils.getUserIconDir(this.f12839h);
            ArrayList arrayList = new ArrayList();
            if (userIconDir.exists() && (listFiles = userIconDir.listFiles()) != null) {
                for (File file : listFiles) {
                    UserIconData userIconData = new UserIconData();
                    Bitmap decodeFile = BitmapFactory.decodeFile(file.getAbsolutePath());
                    if (decodeFile != null) {
                        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                        decodeFile.compress(Bitmap.CompressFormat.PNG, 100, byteArrayOutputStream);
                        byte[] byteArray = byteArrayOutputStream.toByteArray();
                        userIconData.fileName = file.getName();
                        userIconData.data = Base64.encodeToString(byteArray, 0);
                        arrayList.add(userIconData);
                    }
                }
            }
            exportData.userIcons = arrayList;
        }
        return exportData;
    }

    private List<Macro> l(String str, boolean z3, boolean z4) {
        if (str.startsWith("{{")) {
            String substring = str.substring(2, str.indexOf("}}"));
            try {
                if (Integer.valueOf(substring).intValue() > this.f12839h.getPackageManager().getPackageInfo(this.f12839h.getPackageName(), 0).versionCode) {
                    ToastCompat.makeText(this.f12839h.getApplicationContext(), (CharSequence) "Cannot import file - it was exported from a later version of MacroDroid.\n\nPlease update this version of MacroDroid to the latest version.", 1).show();
                    return null;
                }
            } catch (PackageManager.NameNotFoundException e4) {
                FirebaseAnalyticsEventLogger.logHandledException(new RuntimeException("Failed to get version code when exporting: " + e4.getMessage()));
            }
            str = str.substring(str.indexOf("}}") + 2);
        }
        Gson create = GsonUtils.getGsonBuilder().registerTypeAdapter(Macro.class, new MacroDeserializer(this.f12839h, z3, true, z4)).create();
        if (str.startsWith("StopWatchesStart")) {
            try {
                StopWatch.setStopWatches(this.f12839h, (List) create.fromJson(str.substring(16, str.indexOf("StopWatchesEnd")), (Class<Object>) List.class));
            } catch (Exception e5) {
                FirebaseAnalyticsEventLogger.logHandledException(new RuntimeException("Failed to import stop watches data: " + e5.toString()));
            }
            str = str.substring(str.indexOf("StopWatchesEnd") + 14);
        }
        if (str.startsWith("QuickSettingsStart")) {
            try {
                MacroDroidApplication.getInstance().getCache(QuickSettingsData.QUICK_SETTINGS_CACHE).put(QuickSettingsData.QUICK_SETTINGS_DATA_KEY, (QuickSettingsData) create.fromJson(str.substring(18, str.indexOf("QuickSettingsEnd")), (Class<Object>) QuickSettingsData.class));
            } catch (Exception e6) {
                FirebaseAnalyticsEventLogger.logHandledException(new RuntimeException("Failed to import quick settings data: " + e6.toString()));
            }
            str = str.substring(str.indexOf("QuickSettingsEnd") + 16);
        }
        if (str.startsWith("GeofencesStart")) {
            try {
                MacroDroidApplication.getInstance().getCache("GeofenceInfo").put("GeofenceInfo", (GeofenceStore) create.fromJson(str.substring(14, str.indexOf("GeofencesEnd")), (Class<Object>) GeofenceStore.class));
            } catch (Exception e7) {
                FirebaseAnalyticsEventLogger.logHandledException(new RuntimeException("Failed to import geofence info: " + e7.toString()));
            }
            str = str.substring(str.indexOf("GeofencesEnd") + 12);
        }
        if (str.startsWith("CategoryInfoStart")) {
            try {
                CategoryList categoryList = (CategoryList) create.fromJson(str.substring(17, str.indexOf("CategoryInfoEnd")), (Class<Object>) CategoryList.class);
                if (categoryList.getCategories() == null) {
                    categoryList = new CategoryList(new ArrayList());
                }
                MacroDroidApplication.getInstance().getCache(Category.CATEGORY_CACHE).put(Category.CATEGORIES_KEY, categoryList);
            } catch (Exception e8) {
                FirebaseAnalyticsEventLogger.logHandledException(new RuntimeException("Failed to import categories info: " + e8.toString()));
            }
            str = str.substring(str.indexOf("CategoryInfoEnd") + 15);
        }
        if (str.startsWith("CellTowersIgnoreStart")) {
            String substring2 = str.substring(21, str.indexOf("CellTowersIgnoreEnd"));
            try {
                Database database = Database.getInstance();
                database.clearAllIgnoreTowers();
                for (String str2 : (List) GsonUtils.getGsonBuilder().create().fromJson(substring2, new c().getType())) {
                    database.setIgnoreCellTowerState(str2, true);
                }
            } catch (Exception e9) {
                FirebaseAnalyticsEventLogger.logHandledException(new RuntimeException("Failed to import cell tower ignore groups: " + e9.toString()));
            }
            str = str.substring(str.indexOf("CellTowersIgnoreEnd") + 19);
        }
        if (str.startsWith("CellTowersStart")) {
            try {
                CellTowerGroupStore.getInstance().importJSONFromString(str.substring(15, str.indexOf("CellTowersEnd")));
                CellTowerGroupStore.getInstance().persistData();
            } catch (Exception e10) {
                FirebaseAnalyticsEventLogger.logHandledException(new RuntimeException("Failed to import cell tower groups: " + e10.toString()));
            }
            str = str.substring(str.indexOf("CellTowersEnd") + 13);
        }
        if (str.startsWith("DrawerConfigStart")) {
            String substring3 = str.substring(17, str.indexOf("DrawerConfigEnd"));
            try {
                Settings.setDrawerConfiguration(this.f12839h, (DrawerConfiguration) GsonUtils.getDrawerItemGson().fromJson(substring3, (Class<Object>) DrawerConfiguration.class));
            } catch (Exception e11) {
                FirebaseAnalyticsEventLogger.logHandledException(new RuntimeException("Failed to import drawer configuration: " + e11.toString()));
            }
            str = str.substring(str.indexOf("DrawerConfigEnd") + 15);
        }
        if (str.startsWith("<<")) {
            try {
                Settings.setLatestNotificationButtonId(this.f12839h, Integer.valueOf(str.substring(2, str.indexOf(">>"))).intValue());
            } catch (Exception e12) {
                FirebaseAnalyticsEventLogger.logHandledException(new RuntimeException("Failed to get version code when exporting: " + e12.getMessage()));
            }
            str = str.substring(str.indexOf(">>") + 2);
        }
        if (str.startsWith("[[")) {
            try {
                Settings.setNotificationButtonBarConfiguration(MacroDroidApplication.getInstance(), str.substring(2, str.indexOf("]]")));
            } catch (Exception e13) {
                FirebaseAnalyticsEventLogger.logHandledException(new RuntimeException("Failed to get version code when exporting: " + e13.toString()));
            }
            str = str.substring(str.indexOf("]]") + 2);
        }
        if (str.startsWith("((")) {
            try {
                String substring4 = str.substring(2, str.lastIndexOf("))["));
                if (substring4.length() > 0) {
                    MacroDroidVariableStore.getInstance().importJsonFromString(substring4);
                    MacroDroidVariableStore.getInstance().persistData();
                }
            } catch (Exception e14) {
                FirebaseAnalyticsEventLogger.logHandledException(new RuntimeException("Failed to import variables from macro export: " + e14.toString()));
            }
            str = str.substring(str.lastIndexOf("))[") + 2);
        }
        List<Macro> list = (List) create.fromJson(str, new d().getType());
        if (list == null) {
            list = new ArrayList<>();
        }
        int freeMacros = Settings.getFreeMacros(this.f12839h);
        if (!this.f12840i.getPremiumStatus().isPro() && list.size() > freeMacros) {
            list.subList(freeMacros, list.size()).clear();
        }
        return list;
    }

    @Nullable
    private List<Macro> m(String str, boolean z3, boolean z4, boolean z5) {
        List<Macro> list = (List) GsonUtils.getGsonBuilder().registerTypeAdapter(Macro.class, new MacroDeserializer(this.f12839h, z3, z4, z5)).create().fromJson(str, new b().getType());
        if (list == null) {
            return null;
        }
        return u(list);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ int n(Locale locale, Macro macro, Macro macro2) {
        Collator collator = Collator.getInstance(locale);
        collator.setStrength(0);
        return collator.compare(macro.getName(), macro2.getName());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ int o(boolean z3, Locale locale, Macro macro, Macro macro2) {
        if (z3 && macro.getIsFavourite() != macro2.getIsFavourite()) {
            if (macro.getIsFavourite()) {
                return -1;
            }
            return 1;
        }
        Collator collator = Collator.getInstance(locale);
        collator.setStrength(0);
        return collator.compare(macro.getName(), macro2.getName());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ int p(Macro macro, Macro macro2) {
        boolean z3 = macro.isActionBlock;
        if (z3 != macro2.isActionBlock) {
            if (z3) {
                return 1;
            }
            return -1;
        }
        Collator collator = Collator.getInstance(Settings.getLocale(this.f12839h));
        collator.setStrength(0);
        return collator.compare(macro.getName(), macro2.getName());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ int q(Macro macro, Macro macro2) {
        boolean z3 = macro.isActionBlock;
        if (z3 != macro2.isActionBlock) {
            if (z3) {
                return 1;
            }
            return -1;
        }
        Collator collator = Collator.getInstance(Settings.getLocale(this.f12839h));
        collator.setStrength(0);
        return collator.compare(macro.getName(), macro2.getName());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ int r(Macro macro, Macro macro2) {
        boolean z3 = macro.isActionBlock;
        if (z3 != macro2.isActionBlock) {
            if (z3) {
                return 1;
            }
            return -1;
        }
        Collator collator = Collator.getInstance(Settings.getLocale(this.f12839h));
        collator.setStrength(0);
        return collator.compare(macro.getName(), macro2.getName());
    }

    public static void resetEnabledMacroList() {
        synchronized (f12831n) {
            f12828k = null;
            f12830m = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ int s(Locale locale, Macro macro, Macro macro2) {
        Collator collator = Collator.getInstance(locale);
        collator.setStrength(0);
        return collator.compare(macro.getName(), macro2.getName());
    }

    /* JADX WARN: Not initialized variable reg: 8, insn: 0x00c9: MOVE  (r6 I:??[OBJECT, ARRAY]) = (r8 I:??[OBJECT, ARRAY]), block:B:31:0x00c9 */
    /* JADX WARN: Not initialized variable reg: 8, insn: 0x014c: MOVE  (r6 I:??[OBJECT, ARRAY]) = (r8 I:??[OBJECT, ARRAY]), block:B:47:0x014c */
    /* JADX WARN: Removed duplicated region for block: B:51:0x0153 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:52:0x0154  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private boolean t(java.lang.String r16, boolean r17, boolean r18) {
        /*
            Method dump skipped, instructions count: 444
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.arlosoft.macrodroid.macro.MacroStore.t(java.lang.String, boolean, boolean):boolean");
    }

    private List<Macro> u(List<Macro> list) {
        int freeMacros = Settings.getFreeMacros(this.f12839h);
        if (!this.f12840i.getPremiumStatus().isPro()) {
            int i4 = 0;
            int i5 = 0;
            for (Macro macro : list) {
                if (!macro.isActionBlock) {
                    i5++;
                }
            }
            if (i5 > 5) {
                ArrayList arrayList = new ArrayList();
                for (Macro macro2 : list) {
                    if (macro2 instanceof ActionBlock) {
                        arrayList.add(macro2);
                    } else if (i4 < freeMacros) {
                        arrayList.add(macro2);
                        i4++;
                    }
                }
                return arrayList;
            }
        }
        return list;
    }

    @Override // com.arlosoft.macrodroid.macro.ActionBlockStore
    public void addActionBlock(@NonNull ActionBlock actionBlock) {
        if (!actionBlock.isClonedInstance()) {
            if (actionBlock.getIsBeingImported()) {
                this.f12835d.put(Long.valueOf(actionBlock.getGUID()), actionBlock);
                return;
            } else if (getActionBlockByGuid(actionBlock.getGUID()) == null) {
                addMacro(actionBlock, true);
                return;
            } else {
                return;
            }
        }
        this.f12833b.put(Long.valueOf(actionBlock.getGUID()), actionBlock);
    }

    public void addClonedMacroToJSON(Macro macro) {
        synchronized (f12831n) {
            this.f12832a.put(Long.valueOf(macro.getGUID()), macro);
            f12828k = null;
            f12830m = null;
        }
        writeToJSON();
    }

    public void addMacro(Macro macro) {
        addMacro(macro, true);
    }

    @Override // com.arlosoft.macrodroid.macro.ActionBlockStore
    public void clearActionBlocksBeingImported() {
        this.f12835d.clear();
    }

    @Override // com.arlosoft.macrodroid.macro.ActionBlockStore
    public void deleteActionBlock(@NonNull ActionBlock actionBlock) {
        if (!actionBlock.isClonedInstance()) {
            removeMacro(actionBlock, true);
        } else {
            this.f12833b.remove(Long.valueOf(actionBlock.getGUID()));
        }
    }

    @Override // com.arlosoft.macrodroid.macro.ActionBlockStore
    public void deleteAllActionBlocks() {
        i(this.f12832a.values().iterator());
        i(this.f12833b.values().iterator());
        this.f12834c.clear();
        writeToJSON();
    }

    @SuppressLint({"UseValueOf", "UseValueOf", "UseValueOf", "UseValueOf"})
    public void disableMacroAndUpdate(Macro macro, boolean z3) {
        synchronized (f12831n) {
            if (macro.isEnabled()) {
                macro.setEnabled(false);
                if (macro.isExtra()) {
                    this.f12836e.put(Long.valueOf(macro.getGUID()), macro);
                } else {
                    this.f12832a.put(Long.valueOf(macro.getGUID()), macro);
                }
                f12828k = null;
                f12830m = null;
            }
        }
        if (z3) {
            if (macro.isExtra()) {
                writeExtras();
            } else {
                writeToJSON(false);
            }
        }
    }

    @SuppressLint({"UseValueOf", "UseValueOf", "UseValueOf", "UseValueOf"})
    public void enableMacroAndUpdate(Macro macro, boolean z3) {
        synchronized (f12831n) {
            macro.setEnabled(true);
            if (macro.isExtra()) {
                this.f12836e.put(Long.valueOf(macro.getGUID()), macro);
            } else {
                this.f12832a.put(Long.valueOf(macro.getGUID()), macro);
            }
            f12828k = null;
            f12830m = null;
        }
        if (z3) {
            if (macro.isExtra()) {
                writeExtras();
            } else {
                writeToJSON(false);
            }
        }
    }

    @Override // com.arlosoft.macrodroid.macro.ActionBlockStore
    @Nullable
    public ActionBlock getActionBlockByGuid(long j4) {
        Macro macroByGUID = getMacroByGUID(j4);
        if (macroByGUID != null && macroByGUID.isActionBlock) {
            return (ActionBlock) macroByGUID;
        }
        return null;
    }

    @Override // com.arlosoft.macrodroid.macro.ActionBlockStore
    @Nullable
    public ActionBlock getActionBlockByName(String str) {
        Macro macroByName = getMacroByName(str);
        if (macroByName != null && macroByName.isActionBlock) {
            return (ActionBlock) macroByName;
        }
        return null;
    }

    @Override // com.arlosoft.macrodroid.macro.ActionBlockStore
    public List<ActionBlock> getActionBlocksBeingImported() {
        ArrayList arrayList = new ArrayList();
        for (Macro macro : this.f12835d.values()) {
            if (macro.isActionBlock) {
                arrayList.add((ActionBlock) macro);
            }
        }
        return arrayList;
    }

    public List<Macro> getActiveActionBlockInstances() {
        ArrayList arrayList;
        synchronized (f12831n) {
            arrayList = new ArrayList(this.f12833b.values());
        }
        return arrayList;
    }

    @Override // com.arlosoft.macrodroid.macro.ActionBlockStore
    @NonNull
    public List<ActionBlock> getAllActionBlocks() {
        ArrayList arrayList = new ArrayList();
        for (Macro macro : this.f12832a.values()) {
            if (macro.isActionBlock) {
                arrayList.add((ActionBlock) macro);
            }
        }
        return arrayList;
    }

    @Override // com.arlosoft.macrodroid.macro.ActionBlockStore
    @NonNull
    public List<ActionBlock> getAllActionBlocksSorted() {
        ArrayList arrayList = new ArrayList();
        List<Macro> allCompletedMacrosWithActionBlocks = getAllCompletedMacrosWithActionBlocks(false);
        final Locale locale = Settings.getLocale(this.f12839h);
        Collections.sort(allCompletedMacrosWithActionBlocks, new Comparator() { // from class: com.arlosoft.macrodroid.macro.j
            @Override // java.util.Comparator
            public final int compare(Object obj, Object obj2) {
                int n4;
                n4 = MacroStore.n(locale, (Macro) obj, (Macro) obj2);
                return n4;
            }
        });
        for (Macro macro : allCompletedMacrosWithActionBlocks) {
            if (macro.isActionBlock) {
                arrayList.add((ActionBlock) macro);
            }
        }
        return arrayList;
    }

    public List<Macro> getAllCompletedMacros() {
        ArrayList arrayList = new ArrayList();
        synchronized (f12831n) {
            for (Macro macro : this.f12832a.values()) {
                if (!macro.isActionBlock && macro.isCompleted()) {
                    arrayList.add(macro);
                }
            }
        }
        return arrayList;
    }

    public List<Macro> getAllCompletedMacrosExcludingOne(Macro macro, boolean z3) {
        List<Macro> allCompletedMacrosSorted = getAllCompletedMacrosSorted(z3);
        Iterator<Macro> it = allCompletedMacrosSorted.iterator();
        while (it.hasNext()) {
            if (it.next().getGUID() == macro.getGUID()) {
                it.remove();
            }
        }
        return allCompletedMacrosSorted;
    }

    public List<Macro> getAllCompletedMacrosIncludingExtras() {
        ArrayList arrayList = new ArrayList();
        synchronized (f12831n) {
            for (Macro macro : this.f12832a.values()) {
                if (!macro.isActionBlock && macro.isCompleted()) {
                    arrayList.add(macro);
                }
            }
            for (Macro macro2 : this.f12836e.values()) {
                arrayList.add(macro2);
            }
        }
        return arrayList;
    }

    public List<Macro> getAllCompletedMacrosSorted(final boolean z3) {
        List<Macro> allCompletedMacros;
        synchronized (f12831n) {
            allCompletedMacros = getAllCompletedMacros();
            if (allCompletedMacros.size() > 0) {
                final Locale locale = Settings.getLocale(this.f12839h);
                Collections.sort(allCompletedMacros, new Comparator() { // from class: com.arlosoft.macrodroid.macro.l
                    @Override // java.util.Comparator
                    public final int compare(Object obj, Object obj2) {
                        int o4;
                        o4 = MacroStore.o(z3, locale, (Macro) obj, (Macro) obj2);
                        return o4;
                    }
                });
            }
        }
        return allCompletedMacros;
    }

    public List<Macro> getAllCompletedMacrosSortedExcludingOne(Macro macro, boolean z3) {
        List<Macro> allCompletedMacrosSorted = getAllCompletedMacrosSorted(z3);
        Iterator<Macro> it = allCompletedMacrosSorted.iterator();
        while (it.hasNext()) {
            Macro next = it.next();
            if (macro != null && next.getGUID() == macro.getGUID()) {
                it.remove();
            }
        }
        return allCompletedMacrosSorted;
    }

    public List<Macro> getAllCompletedMacrosWithActionBlocks(boolean z3) {
        ArrayList arrayList = new ArrayList();
        synchronized (f12831n) {
            for (Macro macro : this.f12832a.values()) {
                if (macro.isCompleted()) {
                    if (z3) {
                        macro.configureForExport();
                    }
                    arrayList.add(macro);
                }
            }
        }
        return arrayList;
    }

    public List<Macro> getAllCompletedMacrosWithActionBlocksSortedMacrosFirst(boolean z3) {
        ArrayList arrayList = new ArrayList();
        synchronized (f12831n) {
            for (Macro macro : this.f12832a.values()) {
                if (macro.isCompleted()) {
                    if (z3) {
                        macro.configureForExport();
                    }
                    arrayList.add(macro);
                }
            }
            Collections.sort(arrayList, new Comparator() { // from class: com.arlosoft.macrodroid.macro.k
                @Override // java.util.Comparator
                public final int compare(Object obj, Object obj2) {
                    int p4;
                    p4 = MacroStore.this.p((Macro) obj, (Macro) obj2);
                    return p4;
                }
            });
        }
        return arrayList;
    }

    public List<Macro> getAllMacros() {
        ArrayList arrayList = new ArrayList();
        synchronized (f12831n) {
            for (Macro macro : this.f12832a.values()) {
                if (!macro.isActionBlock) {
                    arrayList.add(macro);
                }
            }
        }
        return arrayList;
    }

    public List<Macro> getAllMacrosWithActionBlocksSortedMacrosFirst() {
        ArrayList arrayList = new ArrayList();
        synchronized (f12831n) {
            for (Macro macro : this.f12832a.values()) {
                arrayList.add(macro);
            }
            Collections.sort(arrayList, new Comparator() { // from class: com.arlosoft.macrodroid.macro.i
                @Override // java.util.Comparator
                public final int compare(Object obj, Object obj2) {
                    int r4;
                    r4 = MacroStore.this.r((Macro) obj, (Macro) obj2);
                    return r4;
                }
            });
        }
        return arrayList;
    }

    public Set<String> getAllScreenContentPackages() {
        HashSet<String> hashSet = f12830m;
        if (hashSet != null) {
            return hashSet;
        }
        HashSet<String> hashSet2 = new HashSet<>();
        for (Macro macro : getInstance().getAllCompletedMacros()) {
            Iterator<Trigger> it = macro.getTriggerList().iterator();
            while (it.hasNext()) {
                Trigger next = it.next();
                if (next instanceof ScreenContentTrigger) {
                    ArrayList<String> packageList = ((ScreenContentTrigger) next).getPackageList();
                    if (packageList.isEmpty()) {
                        HashSet<String> hashSet3 = new HashSet<>();
                        f12830m = hashSet3;
                        return hashSet3;
                    }
                    hashSet2.addAll(packageList);
                }
            }
        }
        f12830m = hashSet2;
        return hashSet2;
    }

    public HashMap<String, List<Macro>> getCategoryMap() {
        HashMap<String, List<Macro>> hashMap = new HashMap<>();
        for (Macro macro : getInstance().getAllCompletedMacrosSorted(false)) {
            String category = macro.getCategory();
            if (category == null) {
                category = this.f12839h.getString(R.string.uncategorized);
            }
            List<Macro> list = hashMap.get(category);
            if (list == null) {
                list = new ArrayList<>();
                hashMap.put(category, list);
            }
            list.add(macro);
        }
        return hashMap;
    }

    public HashMap<String, List<Macro>> getCategoryMapFavourites() {
        HashMap<String, List<Macro>> hashMap = new HashMap<>();
        for (Macro macro : getInstance().getFavouriteMacros()) {
            String category = macro.getCategory();
            if (category == null) {
                category = this.f12839h.getString(R.string.uncategorized);
            }
            List<Macro> list = hashMap.get(category);
            if (list == null) {
                list = new ArrayList<>();
                hashMap.put(category, list);
            }
            list.add(macro);
        }
        return hashMap;
    }

    @Nullable
    public String getCloudBackupJson() {
        try {
            return GsonUtils.getGsonBuilder(false, false).create().toJson(k(false));
        } catch (OutOfMemoryError e4) {
            SystemLog.logError("Out of memory while trying to save macros - Check local variables/macros for enormous content: " + e4.toString());
            return null;
        }
    }

    public List<Macro> getEnabledMacros() {
        List<Macro> list;
        synchronized (f12831n) {
            if (f12828k == null) {
                f12828k = new ArrayList();
                Set<String> disabledCategories = Settings.getDisabledCategories(this.f12839h);
                for (Macro macro : this.f12832a.values()) {
                    if (macro.isCompleted() && macro.isEnabled() && !macro.isActionBlock && !disabledCategories.contains(macro.getCategory())) {
                        f12828k.add(macro);
                    }
                }
                f12828k.addAll(this.f12836e.values());
            }
            list = f12828k;
        }
        return list;
    }

    public List<Macro> getEnabledMacrosAndActionBlocks() {
        ArrayList arrayList;
        synchronized (f12831n) {
            arrayList = new ArrayList();
            Set<String> disabledCategories = Settings.getDisabledCategories(this.f12839h);
            for (Macro macro : this.f12832a.values()) {
                if (macro.isCompleted() && macro.isEnabled() && !disabledCategories.contains(macro.getCategory())) {
                    arrayList.add(macro);
                }
            }
            for (Macro macro2 : this.f12836e.values()) {
                if (macro2.isCompleted() && macro2.isEnabled() && !disabledCategories.contains(macro2.getCategory())) {
                    arrayList.add(macro2);
                }
            }
        }
        return arrayList;
    }

    public List<Macro> getExtraMacrosList() {
        ArrayList arrayList;
        synchronized (f12831n) {
            arrayList = new ArrayList(this.f12836e.values());
        }
        return arrayList;
    }

    public List<Macro> getFavouriteMacros() {
        ArrayList arrayList = new ArrayList();
        synchronized (f12831n) {
            for (Macro macro : this.f12832a.values()) {
                if (!macro.isActionBlock && macro.isCompleted() && macro.getIsFavourite()) {
                    arrayList.add(macro);
                }
            }
            if (arrayList.size() > 0) {
                final Locale locale = Settings.getLocale(this.f12839h);
                Collections.sort(arrayList, new Comparator() { // from class: com.arlosoft.macrodroid.macro.g
                    @Override // java.util.Comparator
                    public final int compare(Object obj, Object obj2) {
                        int s3;
                        s3 = MacroStore.s(locale, (Macro) obj, (Macro) obj2);
                        return s3;
                    }
                });
            }
        }
        return arrayList;
    }

    public Macro getMacroByGUID(long j4) {
        Macro macro;
        synchronized (f12831n) {
            macro = this.f12836e.get(Long.valueOf(j4));
            if (macro == null) {
                macro = this.f12832a.get(Long.valueOf(j4));
            }
            if (macro == null) {
                macro = this.f12833b.get(Long.valueOf(j4));
            }
            if (macro == null) {
                macro = this.f12835d.get(Long.valueOf(j4));
            }
        }
        return macro;
    }

    @Nullable
    @SuppressLint({"UseValueOf", "UseValueOf"})
    public Macro getMacroById(int i4) {
        Macro macro;
        synchronized (f12831n) {
            Iterator<Macro> it = this.f12832a.values().iterator();
            while (true) {
                if (it.hasNext()) {
                    macro = it.next();
                    if (macro.getId() == i4) {
                        break;
                    }
                } else {
                    macro = null;
                    break;
                }
            }
            if (macro == null) {
                Iterator<Macro> it2 = this.f12836e.values().iterator();
                while (true) {
                    if (!it2.hasNext()) {
                        break;
                    }
                    Macro next = it2.next();
                    if (next.getId() == i4) {
                        macro = next;
                        break;
                    }
                }
            }
            if (macro == null) {
                Iterator<Macro> it3 = this.f12833b.values().iterator();
                while (true) {
                    if (!it3.hasNext()) {
                        break;
                    }
                    Macro next2 = it3.next();
                    if (next2.getId() == i4) {
                        macro = next2;
                        break;
                    }
                }
            }
            if (macro == null) {
                Iterator<Macro> it4 = this.f12835d.values().iterator();
                while (true) {
                    if (!it4.hasNext()) {
                        break;
                    }
                    Macro next3 = it4.next();
                    if (next3.getId() == i4) {
                        macro = next3;
                        break;
                    }
                }
            }
        }
        return macro;
    }

    public Macro getMacroByName(String str) {
        for (Macro macro : this.f12836e.values()) {
            if (macro.getName().trim().equals(str.trim())) {
                return macro;
            }
        }
        for (Macro macro2 : this.f12832a.values()) {
            if (macro2.getName().trim().equals(str.trim())) {
                return macro2;
            }
        }
        for (Macro macro3 : this.f12833b.values()) {
            if (macro3.getName().trim().equals(str.trim())) {
                return macro3;
            }
        }
        for (Macro macro4 : this.f12835d.values()) {
            if (macro4.getName().trim().equals(str.trim())) {
                return macro4;
            }
        }
        return null;
    }

    public Macro getMacroFloatingTextInstanceByGUID(long j4) {
        Macro macro;
        synchronized (f12831n) {
            macro = this.f12834c.get(Long.valueOf(j4));
        }
        return macro;
    }

    public int getVersion() {
        try {
            return this.f12839h.getPackageManager().getPackageInfo(this.f12839h.getPackageName(), 0).versionCode;
        } catch (PackageManager.NameNotFoundException unused) {
            return 0;
        }
    }

    public List<Macro> importCategory(String str, boolean z3, boolean z4) {
        MacroDroidApplication macroDroidApplication = MacroDroidApplication.getInstance();
        CategoryExportData categoryExportData = (CategoryExportData) GsonUtils.getGsonBuilder().registerTypeAdapter(Macro.class, new MacroDeserializer(this.f12839h, z3, false, z4)).create().fromJson(str, (Class<Object>) CategoryExportData.class);
        if (categoryExportData.getUserIcons() != null) {
            UserIconHelper.importUserIcons(macroDroidApplication, categoryExportData.getUserIcons());
        }
        return u(categoryExportData.getMacros());
    }

    /* JADX WARN: Not initialized variable reg: 5, insn: 0x0139: MOVE  (r3 I:??[OBJECT, ARRAY]) = (r5 I:??[OBJECT, ARRAY]), block:B:35:0x0139 */
    public List<Macro> importJson(String str, boolean z3) {
        FileInputStream fileInputStream;
        FileInputStream fileInputStream2;
        File file;
        StringBuilder sb = new StringBuilder();
        SystemLog.logDebug("Import Macro List");
        FileInputStream fileInputStream3 = null;
        r3 = null;
        List<Macro> list = null;
        try {
            try {
            } catch (FileNotFoundException unused) {
                fileInputStream = null;
            } catch (Exception e4) {
                e = e4;
                fileInputStream = null;
            } catch (Throwable th) {
                th = th;
                try {
                    fileInputStream3.close();
                } catch (Exception unused2) {
                }
                throw th;
            }
            try {
                try {
                    synchronized (this.f12838g) {
                        try {
                            fileInputStream = new FileInputStream(str);
                            if (new File(MacroDroidApplication.getInstance().getFilesDir().getAbsolutePath() + RemoteSettings.FORWARD_SLASH_STRING + str).exists()) {
                                SystemLog.logDebug("File Length is: " + file.length());
                            }
                            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(fileInputStream, "UTF-8"));
                            char[] cArr = new char[1024];
                            int read = bufferedReader.read(cArr, 0, 1024);
                            SystemLog.logDebug("First Read Returned: " + read);
                            while (read > 0) {
                                sb.append(cArr, 0, read);
                                read = bufferedReader.read(cArr, 0, 1024);
                            }
                            bufferedReader.close();
                            SystemLog.logDebug("READ FILE - LENGTH = " + sb.length());
                        } catch (Throwable th2) {
                            th = th2;
                            throw th;
                        }
                    }
                    list = importJsonString(sb.toString(), z3);
                } catch (FileNotFoundException unused3) {
                    SystemLog.logDebug("No MacroDroid data file found");
                    Log.w("MacroStore", "No MacroDroid data file found");
                    fileInputStream.close();
                } catch (Exception e5) {
                    e = e5;
                    String stackTraceToString = Util.stackTraceToString(e);
                    FirebaseAnalyticsEventLogger.logHandledException(new RuntimeException("Failed to import " + str + " : " + e.getMessage() + stackTraceToString.substring(0, Math.max(200, stackTraceToString.length()))));
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append("Failed to import macro file: ");
                    sb2.append(e.getMessage());
                    SystemLog.logError(sb2.toString());
                    SystemLog.logError("File contents: ");
                    fileInputStream.close();
                }
                try {
                    fileInputStream.close();
                } catch (Exception unused4) {
                    return list;
                }
            } catch (Throwable th3) {
                th = th3;
            }
        } catch (Throwable th4) {
            th = th4;
            fileInputStream3 = fileInputStream2;
            fileInputStream3.close();
            throw th;
        }
    }

    public List<Macro> importJsonString(String str, boolean z3) {
        if (str.contains("\"macroExportVersion\":")) {
            return importMacro(str, true, z3);
        }
        if (str.startsWith("[")) {
            return m(str, true, true, false);
        }
        if (str.startsWith("{{")) {
            return l(str, true, z3);
        }
        if (str.contains("\"categoryExportVersion\":")) {
            return importCategory(str, true, z3);
        }
        return importJsonStringV2(str, true, z3);
    }

    public List<Macro> importJsonStringV2(String str, boolean z3, boolean z4) {
        int i4;
        MacroDroidApplication macroDroidApplication = MacroDroidApplication.getInstance();
        ExportData exportData = (ExportData) GsonUtils.getGsonBuilder().registerTypeAdapter(Macro.class, new MacroDeserializer(this.f12839h, z3, false, z4)).create().fromJson(str, (Class<Object>) ExportData.class);
        int i5 = exportData.notificationButtonBarIconTint;
        int i6 = -1;
        if (i5 != 0) {
            Settings.setButtonBarIconTint(macroDroidApplication, i5);
        } else {
            if ((macroDroidApplication.getResources().getConfiguration().uiMode & 48) != 32 && !Settings.getButtonBarBlackBg(macroDroidApplication)) {
                i4 = -16777216;
            } else {
                i4 = -1;
            }
            Settings.setButtonBarIconTint(macroDroidApplication, i4);
        }
        Settings.setButtonBarBlackBg(macroDroidApplication, exportData.forceBlackBackground);
        String str2 = exportData.notificationButtonBarConfig;
        if (str2 != null) {
            Settings.setNotificationButtonBarConfiguration(macroDroidApplication, str2);
            List<NotificationButton> notificationButtons = Settings.getNotificationButtons(macroDroidApplication);
            if (notificationButtons.size() > 0) {
                for (NotificationButton notificationButton : notificationButtons) {
                    i6 = Math.max(notificationButton.getId(), i6);
                }
                Settings.setLatestNotificationButtonId(macroDroidApplication, i6 + 1);
                MacroDroidService.updateNotification(macroDroidApplication, true, false);
            }
        }
        Settings.setShowNotificationButtonBar(macroDroidApplication, exportData.notificationButtonBarIsEnabled);
        if (exportData.geofenceData != null) {
            Settings.setDrawerConfiguration(this.f12839h, exportData.drawerConfiguration);
        }
        if (exportData.cellTowerGroups != null) {
            CellTowerGroupStore.getInstance().setCellTowerGroups(exportData.cellTowerGroups);
            CellTowerGroupStore.getInstance().persistData();
        }
        if (exportData.cellTowersIgnore != null) {
            Database database = Database.getInstance();
            database.clearAllIgnoreTowers();
            for (String str3 : exportData.cellTowersIgnore) {
                database.setIgnoreCellTowerState(str3, true);
            }
        }
        if (exportData.categoryList != null) {
            MacroDroidApplication.getInstance().getCache(Category.CATEGORY_CACHE).put(Category.CATEGORIES_KEY, exportData.categoryList);
        }
        if (exportData.geofenceData != null) {
            MacroDroidApplication.getInstance().getCache("GeofenceInfo").put("GeofenceInfo", exportData.geofenceData);
        }
        if (exportData.quickSettingsData != null) {
            MacroDroidApplication.getInstance().getCache(QuickSettingsData.QUICK_SETTINGS_CACHE).put(QuickSettingsData.QUICK_SETTINGS_DATA_KEY, exportData.quickSettingsData);
        }
        List<String> list = exportData.stopWatches;
        if (list != null) {
            StopWatch.setStopWatches(this.f12839h, list);
        }
        if (exportData.notificationChannelList != null) {
            MacroDroidApplication.getInstance().getCache(NotificationChannelUtil.NOTIFICATION_CHANNELS).put(NotificationChannelUtil.NOTIFICATION_CHANNELS, exportData.notificationChannelList);
        }
        if (exportData.variables != null) {
            MacroDroidVariableStore.getInstance().setVariables(exportData.variables);
            MacroDroidVariableStore.getInstance().persistData();
        }
        if (exportData.drawerConfiguration != null) {
            Settings.setDrawerConfiguration(MacroDroidApplication.getInstance(), exportData.drawerConfiguration);
        }
        if (exportData.homeScreenTileConfig != null) {
            MacroDroidApplication.getInstance().getCache("HomeScreenTiles").put(new Gson(), "HomeScreenTiles", exportData.homeScreenTileConfig);
        }
        if (exportData.smtpServerConfig != null) {
            Settings.setSmtpServerConfig(MacroDroidApplication.getInstance(), exportData.smtpServerConfig);
        }
        if (exportData.quickRunMacroIds != null) {
            Settings.setQuickRunMacroGuids(MacroDroidApplication.getInstance(), exportData.quickRunMacroIds);
        }
        Integer num = exportData.readScreenUpdateRate;
        if (num != null) {
            if (num.intValue() < 1000) {
                Settings.setReadScreenContentsUpdateRateMs(MacroDroidApplication.getInstance(), String.valueOf(exportData.readScreenUpdateRate.intValue() / 1000.0d));
            } else {
                Settings.setReadScreenContentsUpdateRateMs(MacroDroidApplication.getInstance(), String.valueOf(exportData.readScreenUpdateRate.intValue() / 1000));
            }
        }
        if (exportData.notificationPriority != null) {
            Settings.setNotificationPriority(MacroDroidApplication.getInstance(), exportData.notificationPriority.intValue());
        }
        if (exportData.homeScreenTilesNumRows != null) {
            Settings.setHomeScreenTilesPerRow(MacroDroidApplication.getInstance(), exportData.homeScreenTilesNumRows.intValue());
        }
        if (exportData.homeScreenTilesNumRowsLandscape != null) {
            Settings.setHomeScreenTilesPerRowLandscape(MacroDroidApplication.getInstance(), exportData.homeScreenTilesNumRowsLandscape.intValue());
        }
        Settings.setRootEnabled(macroDroidApplication, exportData.enableRootFeatures);
        Settings.setExperimentalFeaturesEnabled(macroDroidApplication, exportData.enableExperimentalFeatures);
        Settings.setSpokenTextAudioStream(macroDroidApplication, exportData.spokenTextAudioStream);
        Settings.setActivityRecogntionUpdateRate(macroDroidApplication, exportData.activityRecognitionUpdateRate);
        Settings.setUseInboxIncomingSMS(macroDroidApplication, exportData.smsMonitorInbox);
        Settings.setWidgetButtonVibrateOnPress(macroDroidApplication, exportData.widgetButtonVibrateOnPress);
        Settings.setWifiBackgroundScanRate(macroDroidApplication, exportData.wifiSSIDBackgroundScanRate);
        Settings.setCellTowerUpdateRate(macroDroidApplication, exportData.cellTowerUpdateRate);
        Settings.setCellTowerUseAlarm(macroDroidApplication, exportData.cellTowerUseAlarm);
        Settings.setLocationUpdateRate(macroDroidApplication, exportData.locationUpdateRate);
        Settings.setShakeScreenOffSetting(macroDroidApplication, exportData.shakeWorkWithScreenOff);
        Settings.setShakeTriggerVibrate(macroDroidApplication, exportData.vibrateOnShake);
        String str4 = exportData.shakeSensitivity;
        if (str4 != null) {
            Settings.setShakeSensitiviy(macroDroidApplication, str4);
        }
        String str5 = exportData.shakeDetectionRate;
        if (str5 != null) {
            Settings.setShakeSampleFrequency(macroDroidApplication, str5);
        }
        Settings.setFlipDeviceScreenOffSetting(macroDroidApplication, exportData.flipWithScreenOff);
        Settings.setFlipDeviceVibrateSetting(macroDroidApplication, exportData.vibrateOnFlip);
        Settings.setProximitySensorScreenOffSetting(macroDroidApplication, exportData.proximityWorkWithScreenOff);
        String str6 = exportData.weatherTriggerLocation;
        if (str6 != null) {
            Settings.setWeatherLatLon(macroDroidApplication, str6);
        }
        Settings.setWeatherUpdateRate(macroDroidApplication, exportData.weatherUpdateRate);
        String str7 = exportData.sunsetSunriseLocation;
        if (str7 != null) {
            Settings.setSunriseSunsetLatLon(macroDroidApplication, str7);
        }
        Settings.setLightSensorBGScanRate(macroDroidApplication, exportData.lightSensorUpdateRate);
        Settings.setMediaButtonPassThroughUnhandled(macroDroidApplication, exportData.mediaButtonPassThroughUnhandled);
        Settings.setNotifyOnUDPFailure(macroDroidApplication, exportData.udpNotifyFailure);
        Settings.setDeviceFacingWorkWithScreenOff(macroDroidApplication, exportData.deviceFacingConstraintWorkWithScreenOff);
        Settings.setAutoTranslateTemplates(macroDroidApplication, exportData.templateMacrosAutoTranslate);
        Integer num2 = exportData.macroDroidIconResourceId;
        if (num2 != null) {
            Settings.setMacroDroidIcon(macroDroidApplication, num2.intValue());
        }
        String str8 = exportData.macroDroidIconResourceName;
        if (str8 != null) {
            Settings.setMacroDroidIconResourceName(macroDroidApplication, str8);
        }
        String str9 = exportData.getMacroDroidIconTextString;
        if (str9 != null) {
            Settings.setMacroDroidIconTextString(macroDroidApplication, str9);
        }
        List<UserIconData> list2 = exportData.userIcons;
        if (list2 != null) {
            UserIconHelper.importUserIcons(macroDroidApplication, list2);
        }
        String str10 = exportData.databaseHash;
        if (str10 != null) {
            Settings.setLockedCategoryPassword(macroDroidApplication, str10);
        }
        Set<String> disabledCategories = Settings.getDisabledCategories(macroDroidApplication);
        for (Macro macro : exportData.macroList) {
            if (!disabledCategories.contains(macro.getCategory())) {
                if (z4) {
                    macro.setEnabledFlag(macro.getEnabledStateDuringLoad());
                } else {
                    try {
                        macro.setEnabled(macro.getEnabledStateDuringLoad());
                    } catch (Exception e4) {
                        SystemLog.logError("Could not enable macro: " + macro.getName() + " (" + e4.toString() + ")");
                        FirebaseAnalyticsEventLogger.logHandledException(e4);
                        try {
                            macro.setEnabled(false);
                        } catch (Exception unused) {
                        }
                    }
                }
            } else {
                macro.setEnabledFlag(macro.getEnabledStateDuringLoad());
            }
        }
        return exportData.macroList;
    }

    public List<Macro> importMacro(String str, boolean z3, boolean z4) {
        MacroDroidApplication macroDroidApplication = MacroDroidApplication.getInstance();
        MacroExportData macroExportData = (MacroExportData) GsonUtils.getGsonBuilder().registerTypeAdapter(Macro.class, new MacroDeserializer(this.f12839h, z3, false, z4)).create().fromJson(str, (Class<Object>) MacroExportData.class);
        if (macroExportData.getUserIcons() != null) {
            UserIconHelper.importUserIcons(macroDroidApplication, macroExportData.getUserIcons());
        }
        ArrayList arrayList = new ArrayList();
        arrayList.add(macroExportData.getMacro());
        return arrayList;
    }

    public boolean isExtra(long j4) {
        return this.f12836e.containsKey(Long.valueOf(j4));
    }

    public void persistMacro(Macro macro) {
        if (macro.isExtra()) {
            this.f12836e.put(Long.valueOf(macro.getGUID()), macro);
            writeExtras();
        } else if (!macro.isClonedInstance()) {
            this.f12832a.put(Long.valueOf(macro.getGUID()), macro);
            writeToJSON(false);
        } else {
            this.f12833b.put(Long.valueOf(macro.getGUID()), macro);
        }
    }

    public void readExtras(boolean z3) {
        long j4;
        File file;
        File file2 = null;
        try {
            file = new File(MacroDroidApplication.getInstance().getFilesDir().getAbsolutePath() + RemoteSettings.FORWARD_SLASH_STRING + JSON_FILE_EXTRA_MACROS);
        } catch (Exception e4) {
            e = e4;
        }
        try {
            SystemLog.logDebug("Reading extras - file exists: " + file.exists());
            if (file.exists()) {
                StringBuilder sb = new StringBuilder();
                SystemLog.logDebug("Extras file found");
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(MacroDroidApplication.getInstance().openFileInput(JSON_FILE_EXTRA_MACROS), "UTF-8"));
                char[] cArr = new char[1024];
                for (int read = bufferedReader.read(cArr, 0, 1024); read > 0; read = bufferedReader.read(cArr, 0, 1024)) {
                    sb.append(cArr, 0, read);
                }
                bufferedReader.close();
                List<Macro> importCategory = importCategory(ExtrasEncryption.decrypt(this.f12839h, sb.toString()), false, true);
                for (Macro macro : importCategory) {
                    macro.setIsExtra(true);
                }
                if (z3) {
                    for (Macro macro2 : importCategory) {
                        h(macro2);
                    }
                }
                storeExtrasList(importCategory);
                for (Macro macro3 : importCategory) {
                    if (Settings.getExtrasEnabled(this.f12839h)) {
                        try {
                            macro3.setEnabled(macro3.getEnabledStateDuringLoad());
                        } catch (Exception e5) {
                            SystemLog.logError("Could not enable macro: " + macro3.getName() + " (" + e5.toString() + ")");
                            FirebaseAnalyticsEventLogger.logHandledException(e5);
                            try {
                                macro3.setEnabled(false);
                            } catch (Exception unused) {
                            }
                        }
                    } else {
                        macro3.setEnabledFlag(macro3.getEnabledStateDuringLoad());
                    }
                }
            }
        } catch (Exception e6) {
            e = e6;
            file2 = file;
            StringBuilder sb2 = new StringBuilder();
            sb2.append("Error when loading extras file: ");
            sb2.append(e.getMessage());
            sb2.append(" File length: ");
            if (file2 != null) {
                j4 = file2.length();
            } else {
                j4 = 0;
            }
            sb2.append(j4);
            SystemLog.logDebug(sb2.toString());
        }
    }

    public void readFromJSON(boolean z3) {
        readFromJSON(z3, true);
    }

    public void removeAllExtraMacros() {
        synchronized (f12831n) {
            j(this.f12836e.values());
            this.f12836e.clear();
            f12828k = null;
            f12830m = null;
        }
        writeExtras();
    }

    public void removeAllFloatingTextInstances() {
        synchronized (f12831n) {
            this.f12834c.clear();
        }
    }

    public void removeAllMacros() {
        SystemLog.logInfo("Removing all macros");
        synchronized (f12831n) {
            j(this.f12832a.values());
            this.f12832a.clear();
        }
        writeToJSON();
    }

    public void removeFloatingTextInstance(long j4) {
        synchronized (f12831n) {
            this.f12834c.remove(Long.valueOf(j4));
        }
    }

    @SuppressLint({"UseValueOf"})
    public void removeMacro(Macro macro, boolean z3) {
        Iterator<Trigger> it = macro.getTriggerList().iterator();
        while (it.hasNext()) {
            it.next().disableTriggerThreadSafe();
        }
        Iterator<Action> it2 = macro.getActions().iterator();
        while (it2.hasNext()) {
            Action next = it2.next();
            next.kill();
            next.disableActionThreadSafe();
            for (Constraint constraint : next.getConstraints()) {
                constraint.disableConstraintCheckingThreadSafe();
            }
        }
        for (Constraint constraint2 : macro.getConstraints()) {
            constraint2.disableConstraintCheckingThreadSafe();
        }
        synchronized (f12831n) {
            macro.cancelActiveMacro(this.f12839h);
            this.f12832a.remove(Long.valueOf(macro.getGUID()));
            f12828k = null;
            f12830m = null;
        }
        if (z3) {
            writeToJSON();
        }
    }

    public boolean removeStandardMacroWithGuid(long j4) {
        boolean z3;
        if (this.f12832a.remove(Long.valueOf(j4)) != null) {
            z3 = true;
        } else {
            z3 = false;
        }
        if (z3) {
            f12828k = null;
        }
        return z3;
    }

    public void saveFloatingTextInstance(Macro macro) {
        synchronized (f12831n) {
            this.f12834c.put(Long.valueOf(macro.getGUID()), macro);
        }
    }

    public void setExtraEnabledState(boolean z3) {
        synchronized (f12831n) {
            for (Macro macro : this.f12836e.values()) {
                macro.setEnabled(z3);
            }
            f12828k = null;
        }
    }

    @SuppressLint({"UseValueOf"})
    public void storeExtrasList(List<Macro> list) {
        synchronized (f12831n) {
            this.f12836e = new HashMap<>();
            if (list != null) {
                for (Macro macro : list) {
                    this.f12836e.put(Long.valueOf(macro.getGUID()), macro);
                }
            }
            f12828k = null;
            f12830m = null;
        }
    }

    @SuppressLint({"UseValueOf"})
    public void storeMacroList(List<Macro> list) {
        synchronized (f12831n) {
            this.f12832a = new HashMap<>();
            if (list != null) {
                for (Macro macro : list) {
                    this.f12832a.put(Long.valueOf(macro.getGUID()), macro);
                }
            }
            f12828k = null;
            f12830m = null;
        }
    }

    @Override // com.arlosoft.macrodroid.macro.ActionBlockStore
    public void updateActionBlock(@NonNull ActionBlock actionBlock) {
        updateMacro(actionBlock, true);
    }

    public void updateEnabledStateOfAllCompletedMacros() {
        List<Macro> allCompletedMacrosIncludingExtras = getAllCompletedMacrosIncludingExtras();
        Set<String> disabledCategories = Settings.getDisabledCategories(this.f12839h);
        for (Macro macro : allCompletedMacrosIncludingExtras) {
            macro.updateEnabledStateBasedOnGlobalState(disabledCategories);
        }
        for (Macro macro2 : getExtraMacrosList()) {
            macro2.updateEnabledStateBasedOnGlobalState(new HashSet());
        }
    }

    public void updateMacro(Macro macro) {
        updateMacro(macro, true, true);
    }

    @SuppressLint({"UseValueOf"})
    public void updateMacroState(Macro macro) {
        if (macro != null) {
            synchronized (f12831n) {
                if (macro.isExtra()) {
                    this.f12836e.put(Long.valueOf(macro.getGUID()), macro);
                } else {
                    this.f12832a.put(Long.valueOf(macro.getGUID()), macro);
                }
                f12828k = null;
                f12830m = null;
            }
            if (macro.isExtra()) {
                writeExtras();
            } else {
                writeToJSON();
            }
        }
    }

    public void writeExtras() {
        this.f12841j.debounce(Void.class, new f(), 500L, TimeUnit.MILLISECONDS);
    }

    public void writeToJSON() {
        writeToJSON(true);
    }

    public void addMacro(Macro macro, boolean z3) {
        addMacro(macro, z3, true);
    }

    public void readFromJSON(boolean z3, boolean z4) {
        if (t("macros.json", z3, z4)) {
            return;
        }
        SystemLog.logVerbose("Failed to read macro file");
    }

    public void updateMacro(Macro macro, boolean z3) {
        updateMacro(macro, z3, true);
    }

    public boolean writeExtras(String str, @Nullable String str2) {
        FileOutputStream startWrite;
        List<Macro> extraMacrosList = getExtraMacrosList();
        boolean z3 = true;
        if (extraMacrosList.isEmpty()) {
            return true;
        }
        long currentTimeMillis = System.currentTimeMillis();
        Gson create = GsonUtils.getGsonBuilder(false, false).create();
        SystemLog.logDebug("Saving Extra Macro List (" + extraMacrosList.size() + " macros)");
        try {
            ArrayList arrayList = new ArrayList();
            for (Macro macro : extraMacrosList) {
                arrayList.addAll(macro.getUserIconData());
            }
            String encryptToBase64 = ExtrasEncryption.encryptToBase64(this.f12839h, create.toJson(new CategoryExportData(1, extraMacrosList, arrayList)));
            long currentTimeMillis2 = System.currentTimeMillis();
            System.currentTimeMillis();
            synchronized (this.f12838g) {
                try {
                    AtomicFile atomicFile = new AtomicFile(new File(MacroDroidApplication.getInstance().getFilesDir().getAbsolutePath() + RemoteSettings.FORWARD_SLASH_STRING + str));
                    try {
                        startWrite = atomicFile.startWrite();
                    } catch (Exception e4) {
                        SystemLog.logErrorDontTrigger("Failed to persist extra data: " + e4.toString());
                        FirebaseAnalyticsEventLogger.logHandledException(new RuntimeException("Failed to persist extra data: " + e4.toString()));
                    }
                    try {
                        OutputStreamWriter outputStreamWriter = new OutputStreamWriter(startWrite, "UTF-8");
                        outputStreamWriter.write(encryptToBase64);
                        outputStreamWriter.flush();
                        atomicFile.finishWrite(startWrite);
                        outputStreamWriter.close();
                        outputStreamWriter.close();
                        if (startWrite != null) {
                            startWrite.close();
                        }
                        try {
                            throw null;
                        } catch (Exception unused) {
                            SystemLog.logDebug("Extra Persist took: " + (currentTimeMillis2 - currentTimeMillis) + RemoteSettings.FORWARD_SLASH_STRING + (System.currentTimeMillis() - currentTimeMillis) + "ms. Main thread = " + Thread.currentThread().equals(Looper.getMainLooper().getThread()));
                            return z3;
                        }
                    } catch (Throwable th) {
                        if (startWrite != null) {
                            try {
                                startWrite.close();
                            } catch (Throwable th2) {
                                th.addSuppressed(th2);
                            }
                        }
                        throw th;
                    }
                } catch (Exception e5) {
                    SystemLog.logError("Failed to store extra macro list: " + e5.getMessage());
                    try {
                        throw null;
                    } catch (Exception unused2) {
                        z3 = false;
                        SystemLog.logDebug("Extra Persist took: " + (currentTimeMillis2 - currentTimeMillis) + RemoteSettings.FORWARD_SLASH_STRING + (System.currentTimeMillis() - currentTimeMillis) + "ms. Main thread = " + Thread.currentThread().equals(Looper.getMainLooper().getThread()));
                        return z3;
                    }
                }
            }
            SystemLog.logDebug("Extra Persist took: " + (currentTimeMillis2 - currentTimeMillis) + RemoteSettings.FORWARD_SLASH_STRING + (System.currentTimeMillis() - currentTimeMillis) + "ms. Main thread = " + Thread.currentThread().equals(Looper.getMainLooper().getThread()));
            return z3;
        } catch (Exception e6) {
            SystemLog.logError("Failed to save extras macro: " + e6.toString());
            return false;
        } catch (OutOfMemoryError e7) {
            SystemLog.logError("Out of memory while trying to save macros - Check local variables/macros for enormous content: " + e7.toString());
            return false;
        }
    }

    public void writeToJSON(boolean z3) {
        if (z3) {
            AutoBackupCloudWorker.scheduleNewBackup(this.f12839h, 6L);
        }
        if (AndroidWearTrigger.usingAndroidWear) {
            try {
                AndroidWearHelper.updateMacroList(this.f12839h, false);
            } catch (Exception unused) {
            }
        }
        this.f12841j.debounce(Void.class, new e(), 500L, TimeUnit.MILLISECONDS);
    }

    @SuppressLint({"UseValueOf"})
    public void addMacro(Macro macro, boolean z3, boolean z4) {
        Iterator<Trigger> it = macro.getTriggerList().iterator();
        while (it.hasNext()) {
            it.next().setMacro(macro);
        }
        Iterator<Action> it2 = macro.getActions().iterator();
        while (it2.hasNext()) {
            it2.next().setMacro(macro);
        }
        if (macro.getConstraints().size() > 0) {
            for (Constraint constraint : macro.getConstraints()) {
                constraint.setMacro(macro);
            }
        }
        synchronized (f12831n) {
            this.f12832a.put(Long.valueOf(macro.getGUID()), macro);
            f12828k = null;
            f12830m = null;
        }
        if (z3) {
            writeToJSON();
            if (z4) {
                macro.setEnabled(true);
            }
        }
    }

    @SuppressLint({"UseValueOf", "UseValueOf", "UseValueOf", "UseValueOf"})
    public void updateMacro(Macro macro, boolean z3, boolean z4) {
        synchronized (f12831n) {
            boolean isEnabled = macro.isEnabled();
            if (isEnabled) {
                macro.setEnabled(false, z4);
            }
            if (!macro.isClonedInstance()) {
                if (!macro.getIsBeingImported()) {
                    if (macro.isExtra()) {
                        this.f12836e.put(Long.valueOf(macro.getGUID()), macro);
                    } else {
                        this.f12832a.put(Long.valueOf(macro.getGUID()), macro);
                    }
                    f12828k = null;
                    f12830m = null;
                    this.f12835d.remove(Long.valueOf(macro.getGUID()));
                } else {
                    this.f12835d.put(Long.valueOf(macro.getGUID()), macro);
                }
            } else {
                this.f12833b.put(Long.valueOf(macro.getGUID()), macro);
            }
            if (isEnabled) {
                macro.setEnabled(true);
            }
        }
        if (z3) {
            if (macro.isExtra()) {
                writeExtras();
            } else {
                writeToJSON();
            }
        }
    }

    public synchronized boolean writeToJSON(DocumentFile documentFile, String str, boolean z3, boolean z4, @Nullable String str2) {
        String json;
        DocumentFile findFile = documentFile.findFile(str);
        if (findFile != null && findFile.exists()) {
            findFile.delete();
        }
        Gson create = GsonUtils.getGsonBuilder(false, false).create();
        if (z3) {
            json = create.toJson(k(true));
        } else {
            json = create.toJson(getAllCompletedMacros());
            if (z4) {
                json = g(json);
            }
        }
        OutputStreamWriter outputStreamWriter = null;
        try {
            try {
                if (TextUtils.isEmpty(str2)) {
                    OutputStreamWriter outputStreamWriter2 = new OutputStreamWriter(this.f12839h.getContentResolver().openOutputStream(documentFile.createFile("*/*", str).getUri()), "UTF-8");
                    try {
                        outputStreamWriter2.write(json);
                        outputStreamWriter2.close();
                        outputStreamWriter = outputStreamWriter2;
                    } catch (Exception e4) {
                        e = e4;
                        outputStreamWriter = outputStreamWriter2;
                        SystemLog.logError("Failed to store macro list: " + e.getMessage());
                        try {
                            outputStreamWriter.close();
                        } catch (Exception unused) {
                        }
                        return false;
                    } catch (Throwable th) {
                        th = th;
                        outputStreamWriter = outputStreamWriter2;
                        try {
                            outputStreamWriter.close();
                        } catch (Exception unused2) {
                        }
                        throw th;
                    }
                } else {
                    byte[] encrypt = Encryptor.encrypt(json.getBytes(), str2);
                    OutputStream openOutputStream = this.f12839h.getContentResolver().openOutputStream(documentFile.createFile("*/*", str).getUri());
                    ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                    byteArrayOutputStream.write(encrypt);
                    byteArrayOutputStream.writeTo(openOutputStream);
                    byteArrayOutputStream.close();
                }
                try {
                    outputStreamWriter.close();
                } catch (Exception unused3) {
                }
                return true;
            } catch (Exception e5) {
                e = e5;
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }

    public static MacroStore getInstance() {
        return getInstance(true);
    }

    public static synchronized MacroStore getInstance(boolean z3) {
        MacroStore macroStore;
        synchronized (MacroStore.class) {
            if (f12829l == null) {
                f12829l = new MacroStore(MacroDroidApplication.getInstance());
                if (z3) {
                    SystemLog.logVerbose("Reading JSON file on startup");
                    f12829l.readFromJSON(false);
                    f12829l.readExtras(false);
                }
            }
            macroStore = f12829l;
        }
        return macroStore;
    }

    public List<Macro> getAllCompletedMacrosWithActionBlocksSortedMacrosFirst() {
        ArrayList arrayList = new ArrayList();
        synchronized (f12831n) {
            for (Macro macro : this.f12832a.values()) {
                if (macro.isCompleted()) {
                    arrayList.add(macro);
                }
            }
            Collections.sort(arrayList, new Comparator() { // from class: com.arlosoft.macrodroid.macro.h
                @Override // java.util.Comparator
                public final int compare(Object obj, Object obj2) {
                    int q4;
                    q4 = MacroStore.this.q((Macro) obj, (Macro) obj2);
                    return q4;
                }
            });
        }
        return arrayList;
    }

    public boolean writeToJSON(String str, boolean z3, boolean z4, boolean z5, @Nullable String str2) {
        String json;
        FileOutputStream fileOutputStream;
        FileOutputStream startWrite;
        String json2;
        long currentTimeMillis = System.currentTimeMillis();
        boolean z6 = false;
        Gson create = GsonUtils.getGsonBuilder(false, false).create();
        if (z3) {
            try {
                json = create.toJson(k(z5));
            } catch (OutOfMemoryError e4) {
                SystemLog.logError("Out of memory while trying to save macros - Check local variables/macros for enormous content: " + e4.toString());
                return false;
            }
        } else {
            List<Macro> allCompletedMacrosWithActionBlocks = getAllCompletedMacrosWithActionBlocks(false);
            SystemLog.logDebug("Saving Macro List (" + allCompletedMacrosWithActionBlocks.size() + " macros)");
            try {
                json2 = create.toJson(allCompletedMacrosWithActionBlocks);
            } catch (OutOfMemoryError e5) {
                SystemLog.logError("Out of memory while trying to save macros - Check local variables/macros for enormous content: " + e5.toString());
                return false;
            } catch (ConcurrentModificationException e6) {
                try {
                    json2 = create.toJson(allCompletedMacrosWithActionBlocks);
                } catch (ConcurrentModificationException e7) {
                    SystemLog.logError("Failed to persist macro file: " + e6.toString());
                    FirebaseAnalyticsEventLogger.logHandledException(e7);
                    return false;
                }
            }
            json = z4 ? g(json2) : json2;
        }
        long currentTimeMillis2 = System.currentTimeMillis();
        System.currentTimeMillis();
        synchronized (this.f12838g) {
            OutputStreamWriter outputStreamWriter = null;
            try {
                try {
                    if (z3) {
                        if (TextUtils.isEmpty(str2)) {
                            fileOutputStream = new FileOutputStream(str);
                            try {
                                try {
                                    OutputStreamWriter outputStreamWriter2 = new OutputStreamWriter(fileOutputStream, "UTF-8");
                                    try {
                                        outputStreamWriter2.write(json);
                                        outputStreamWriter2.close();
                                        outputStreamWriter = outputStreamWriter2;
                                    } catch (Exception e8) {
                                        e = e8;
                                        outputStreamWriter = outputStreamWriter2;
                                        SystemLog.logError("Failed to store macro list: " + e.getMessage());
                                        try {
                                            outputStreamWriter.close();
                                            fileOutputStream.close();
                                        } catch (Exception unused) {
                                        }
                                        SystemLog.logDebug("Persist took: " + (currentTimeMillis2 - currentTimeMillis) + RemoteSettings.FORWARD_SLASH_STRING + (System.currentTimeMillis() - currentTimeMillis) + "ms. Main thread = " + Thread.currentThread().equals(Looper.getMainLooper().getThread()));
                                        return z6;
                                    } catch (Throwable th) {
                                        th = th;
                                        outputStreamWriter = outputStreamWriter2;
                                        try {
                                            outputStreamWriter.close();
                                            fileOutputStream.close();
                                        } catch (Exception unused2) {
                                            throw th;
                                        }
                                    }
                                } catch (Throwable th2) {
                                    th = th2;
                                }
                            } catch (Exception e9) {
                                e = e9;
                            }
                        } else {
                            byte[] encrypt = Encryptor.encrypt(json.getBytes(), str2);
                            FileOutputStream fileOutputStream2 = new FileOutputStream(str);
                            try {
                                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                                byteArrayOutputStream.write(encrypt);
                                byteArrayOutputStream.writeTo(fileOutputStream2);
                                byteArrayOutputStream.close();
                                fileOutputStream = fileOutputStream2;
                            } catch (Exception e10) {
                                fileOutputStream = fileOutputStream2;
                                e = e10;
                                SystemLog.logError("Failed to store macro list: " + e.getMessage());
                                outputStreamWriter.close();
                                fileOutputStream.close();
                                SystemLog.logDebug("Persist took: " + (currentTimeMillis2 - currentTimeMillis) + RemoteSettings.FORWARD_SLASH_STRING + (System.currentTimeMillis() - currentTimeMillis) + "ms. Main thread = " + Thread.currentThread().equals(Looper.getMainLooper().getThread()));
                                return z6;
                            } catch (Throwable th3) {
                                fileOutputStream = fileOutputStream2;
                                th = th3;
                                outputStreamWriter.close();
                                fileOutputStream.close();
                            }
                        }
                    } else {
                        AtomicFile atomicFile = new AtomicFile(new File(MacroDroidApplication.getInstance().getFilesDir().getAbsolutePath() + RemoteSettings.FORWARD_SLASH_STRING + str));
                        try {
                            startWrite = atomicFile.startWrite();
                        } catch (Exception e11) {
                            SystemLog.logErrorDontTrigger("Failed to persist macro data: " + e11.toString());
                            FirebaseAnalyticsEventLogger.logHandledException(new RuntimeException("Failed to persist macro data: " + e11.toString()));
                        }
                        try {
                            OutputStreamWriter outputStreamWriter3 = new OutputStreamWriter(startWrite, "UTF-8");
                            outputStreamWriter3.write(json);
                            outputStreamWriter3.flush();
                            atomicFile.finishWrite(startWrite);
                            outputStreamWriter3.close();
                            outputStreamWriter3.close();
                            if (startWrite != null) {
                                startWrite.close();
                            }
                            fileOutputStream = null;
                        } catch (Throwable th4) {
                            if (startWrite != null) {
                                try {
                                    startWrite.close();
                                } catch (Throwable th5) {
                                    th4.addSuppressed(th5);
                                }
                            }
                            throw th4;
                        }
                    }
                    try {
                        outputStreamWriter.close();
                        fileOutputStream.close();
                    } catch (Exception unused3) {
                    }
                    z6 = true;
                } catch (Throwable th6) {
                    th = th6;
                    fileOutputStream = null;
                }
            } catch (Exception e12) {
                e = e12;
                fileOutputStream = null;
            }
        }
        SystemLog.logDebug("Persist took: " + (currentTimeMillis2 - currentTimeMillis) + RemoteSettings.FORWARD_SLASH_STRING + (System.currentTimeMillis() - currentTimeMillis) + "ms. Main thread = " + Thread.currentThread().equals(Looper.getMainLooper().getThread()));
        return z6;
    }
}
