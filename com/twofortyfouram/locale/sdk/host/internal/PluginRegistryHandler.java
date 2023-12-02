package com.twofortyfouram.locale.sdk.host.internal;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.Uri;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.firebase.remoteconfig.RemoteConfigConstants;
import com.twofortyfouram.assertion.Assertions;
import com.twofortyfouram.locale.sdk.host.model.Plugin;
import com.twofortyfouram.locale.sdk.host.model.PluginType;
import com.twofortyfouram.log.Lumberjack;
import com.twofortyfouram.spackle.ContextUtil;
import com.twofortyfouram.spackle.ThreadUtil;
import com.twofortyfouram.spackle.bundle.BundleScrubber;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.CountDownLatch;

/* loaded from: classes6.dex */
public final class PluginRegistryHandler extends Handler {
    public static final int MESSAGE_DESTROY = 4;
    public static final int MESSAGE_INIT = 0;
    private static final int MESSAGE_PACKAGE_ADDED = 1;
    private static final int MESSAGE_PACKAGE_CHANGED = 3;
    private static final int MESSAGE_PACKAGE_REMOVED = 2;
    @NonNull
    private final Context mContext;
    @Nullable
    private volatile Map<String, Plugin> mImmutableConditionMap;
    @Nullable
    private volatile Map<String, Plugin> mImmutableEventMap;
    @Nullable
    private volatile Map<String, Plugin> mImmutableSettingMap;
    @Nullable
    private volatile Map<String, Plugin> mMutableConditionMap;
    @Nullable
    private volatile Map<String, Plugin> mMutableEventMap;
    @Nullable
    private volatile Map<String, Plugin> mMutableSettingMap;
    @NonNull
    private final BroadcastReceiver mReceiver;
    @Nullable
    private volatile HandlerThread mReceiverHandlerThread;
    @Nullable
    private final Intent mRegistryReloadedIntent;
    @Nullable
    private final String mRegistryReloadedPermission;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.twofortyfouram.locale.sdk.host.internal.PluginRegistryHandler$1  reason: invalid class name */
    /* loaded from: classes6.dex */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$twofortyfouram$locale$sdk$host$internal$PackageResult;
        static final /* synthetic */ int[] $SwitchMap$com$twofortyfouram$locale$sdk$host$model$PluginType;

        static {
            int[] iArr = new int[PackageResult.values().length];
            $SwitchMap$com$twofortyfouram$locale$sdk$host$internal$PackageResult = iArr;
            try {
                iArr[PackageResult.NOTHING_CHANGED.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$twofortyfouram$locale$sdk$host$internal$PackageResult[PackageResult.EVENT_AND_SETTINGS_AND_CONDITIONS_CHANGED.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$twofortyfouram$locale$sdk$host$internal$PackageResult[PackageResult.CONDITIONS_AND_SETTINGS_CHANGED.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$com$twofortyfouram$locale$sdk$host$internal$PackageResult[PackageResult.EVENT_AND_SETTINGS_CHANGED.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$com$twofortyfouram$locale$sdk$host$internal$PackageResult[PackageResult.EVENTS_AND_CONDITIONS_CHANGED.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                $SwitchMap$com$twofortyfouram$locale$sdk$host$internal$PackageResult[PackageResult.EVENTS_CHANGED.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                $SwitchMap$com$twofortyfouram$locale$sdk$host$internal$PackageResult[PackageResult.CONDITIONS_CHANGED.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                $SwitchMap$com$twofortyfouram$locale$sdk$host$internal$PackageResult[PackageResult.SETTINGS_CHANGED.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            int[] iArr2 = new int[PluginType.values().length];
            $SwitchMap$com$twofortyfouram$locale$sdk$host$model$PluginType = iArr2;
            try {
                iArr2[PluginType.CONDITION.ordinal()] = 1;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                $SwitchMap$com$twofortyfouram$locale$sdk$host$model$PluginType[PluginType.SETTING.ordinal()] = 2;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                $SwitchMap$com$twofortyfouram$locale$sdk$host$model$PluginType[PluginType.EVENT.ordinal()] = 3;
            } catch (NoSuchFieldError unused11) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes6.dex */
    public final class RegistryReceiver extends BroadcastReceiver {
        private RegistryReceiver() {
        }

        @Nullable
        private String getChangedPackage(@NonNull Intent intent) {
            Uri data = intent.getData();
            if (data != null) {
                return data.getSchemeSpecificPart();
            }
            return null;
        }

        private boolean isReplacing(@NonNull Intent intent) {
            return !intent.getBooleanExtra("android.intent.extra.REPLACING", false);
        }

        private void sendChangedPackageMessage(@Nullable String str) {
            if (str != null) {
                PluginRegistryHandler pluginRegistryHandler = PluginRegistryHandler.this;
                pluginRegistryHandler.sendMessage(pluginRegistryHandler.obtainMessage(1, str));
            }
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            String[] stringArrayExtra;
            if (BundleScrubber.scrub(intent)) {
                return;
            }
            String action = intent.getAction();
            if (!"android.intent.action.PACKAGE_ADDED".equals(action) && !"android.intent.action.PACKAGE_REMOVED".equals(action)) {
                if (!"android.intent.action.PACKAGE_REPLACED".equals(action) && !"android.intent.action.PACKAGE_CHANGED".equals(action)) {
                    if (("android.intent.action.EXTERNAL_APPLICATIONS_AVAILABLE".equals(action) || "android.intent.action.EXTERNAL_APPLICATIONS_UNAVAILABLE".equals(action)) && (stringArrayExtra = intent.getStringArrayExtra("android.intent.extra.changed_package_list")) != null) {
                        for (String str : stringArrayExtra) {
                            sendChangedPackageMessage(str);
                        }
                        return;
                    }
                    return;
                }
                sendChangedPackageMessage(getChangedPackage(intent));
                return;
            }
            String changedPackage = getChangedPackage(intent);
            if (!isReplacing(intent)) {
                sendChangedPackageMessage(changedPackage);
            }
        }

        /* synthetic */ RegistryReceiver(PluginRegistryHandler pluginRegistryHandler, AnonymousClass1 anonymousClass1) {
            this();
        }
    }

    public PluginRegistryHandler(@NonNull Looper looper, @NonNull Context context, @NonNull String str, @NonNull String str2) {
        super(looper);
        this.mMutableConditionMap = null;
        this.mMutableEventMap = null;
        this.mMutableSettingMap = null;
        this.mImmutableConditionMap = null;
        this.mImmutableEventMap = null;
        this.mImmutableSettingMap = null;
        this.mReceiverHandlerThread = null;
        this.mReceiver = new RegistryReceiver(this, null);
        Assertions.assertNotNull(context, "context");
        Assertions.assertNotNull(str, "notificationAction");
        Assertions.assertNotNull(str2, "notificationPermission");
        this.mContext = ContextUtil.cleanContext(context);
        Intent intent = new Intent(str);
        this.mRegistryReloadedIntent = intent;
        intent.setPackage(context.getPackageName());
        this.mRegistryReloadedPermission = str2;
    }

    @NonNull
    private Map<String, Plugin> getMutablePluginMap(@NonNull PluginType pluginType) {
        Assertions.assertNotNull(pluginType, "type");
        int i4 = AnonymousClass1.$SwitchMap$com$twofortyfouram$locale$sdk$host$model$PluginType[pluginType.ordinal()];
        if (i4 != 1) {
            if (i4 != 2) {
                if (i4 == 3) {
                    return this.mMutableEventMap;
                }
                throw new AssertionError();
            }
            return this.mMutableSettingMap;
        }
        return this.mMutableConditionMap;
    }

    private void handleDestroy() {
        this.mContext.unregisterReceiver(this.mReceiver);
        this.mReceiverHandlerThread.quit();
    }

    private void handleInit() {
        this.mReceiverHandlerThread = ThreadUtil.newHandlerThread(RegistryReceiver.class.getName(), ThreadUtil.ThreadPriority.BACKGROUND);
        Handler handler = new Handler(this.mReceiverHandlerThread.getLooper());
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.intent.action.PACKAGE_ADDED");
        intentFilter.addAction("android.intent.action.PACKAGE_CHANGED");
        intentFilter.addAction("android.intent.action.PACKAGE_REMOVED");
        intentFilter.addAction("android.intent.action.PACKAGE_REPLACED");
        intentFilter.addDataScheme("package");
        this.mContext.registerReceiver(this.mReceiver, intentFilter, null, handler);
        IntentFilter intentFilter2 = new IntentFilter();
        intentFilter2.addAction("android.intent.action.EXTERNAL_APPLICATIONS_AVAILABLE");
        intentFilter2.addAction("android.intent.action.EXTERNAL_APPLICATIONS_UNAVAILABLE");
        this.mContext.registerReceiver(this.mReceiver, intentFilter2, null, handler);
        this.mMutableConditionMap = PluginPackageScanner.loadPluginMap(this.mContext, PluginType.CONDITION, null);
        this.mMutableSettingMap = PluginPackageScanner.loadPluginMap(this.mContext, PluginType.SETTING, null);
        this.mMutableEventMap = PluginPackageScanner.loadPluginMap(this.mContext, PluginType.EVENT, null);
        setEvents();
        setConditions();
        setSettings();
        sendBroadcast();
    }

    @NonNull
    private PackageResult handlePackageAdded(@NonNull String str) {
        Assertions.assertNotNull(str, RemoteConfigConstants.RequestFieldKey.PACKAGE_NAME);
        PluginType pluginType = PluginType.CONDITION;
        boolean isPluginAdded = isPluginAdded(pluginType, PluginPackageScanner.loadPluginMap(this.mContext, pluginType, str));
        PluginType pluginType2 = PluginType.SETTING;
        boolean isPluginAdded2 = isPluginAdded(pluginType2, PluginPackageScanner.loadPluginMap(this.mContext, pluginType2, str));
        PluginType pluginType3 = PluginType.EVENT;
        return PackageResult.get(isPluginAdded, isPluginAdded2, isPluginAdded(pluginType3, PluginPackageScanner.loadPluginMap(this.mContext, pluginType3, str)));
    }

    @NonNull
    private PackageResult handlePackageChanged(@NonNull String str) {
        boolean z3;
        boolean z4;
        Assertions.assertNotNull(str, RemoteConfigConstants.RequestFieldKey.PACKAGE_NAME);
        Context context = this.mContext;
        PluginType pluginType = PluginType.CONDITION;
        Map<String, Plugin> loadPluginMap = PluginPackageScanner.loadPluginMap(context, pluginType, str);
        Context context2 = this.mContext;
        PluginType pluginType2 = PluginType.SETTING;
        Map<String, Plugin> loadPluginMap2 = PluginPackageScanner.loadPluginMap(context2, pluginType2, str);
        Context context3 = this.mContext;
        PluginType pluginType3 = PluginType.EVENT;
        Map<String, Plugin> loadPluginMap3 = PluginPackageScanner.loadPluginMap(context3, pluginType3, str);
        boolean z5 = false;
        if (!isPluginRemoved(pluginType, str, loadPluginMap) && !isPluginAdded(pluginType, loadPluginMap)) {
            z3 = false;
        } else {
            z3 = true;
        }
        if (!isPluginRemoved(pluginType2, str, loadPluginMap2) && !isPluginAdded(pluginType2, loadPluginMap2)) {
            z4 = false;
        } else {
            z4 = true;
        }
        z5 = (isPluginRemoved(pluginType3, str, loadPluginMap3) || isPluginAdded(pluginType3, loadPluginMap2)) ? true : true;
        for (Plugin plugin : loadPluginMap.values()) {
            if (this.mImmutableConditionMap.containsKey(plugin.getRegistryName()) && this.mImmutableConditionMap.get(plugin.getRegistryName()).getVersionCode() != plugin.getVersionCode()) {
                z3 = true;
            }
            if (this.mImmutableEventMap.containsKey(plugin.getRegistryName()) && this.mImmutableEventMap.get(plugin.getRegistryName()).getVersionCode() != plugin.getVersionCode()) {
                z3 = true;
            }
        }
        return PackageResult.get(z3, z4, z5);
    }

    @NonNull
    private PackageResult handlePackageRemoved(@NonNull String str) {
        Assertions.assertNotNull(str, RemoteConfigConstants.RequestFieldKey.PACKAGE_NAME);
        PluginType pluginType = PluginType.CONDITION;
        boolean isPluginRemoved = isPluginRemoved(pluginType, str, PluginPackageScanner.loadPluginMap(this.mContext, pluginType, str));
        PluginType pluginType2 = PluginType.SETTING;
        boolean isPluginRemoved2 = isPluginRemoved(pluginType2, str, PluginPackageScanner.loadPluginMap(this.mContext, pluginType2, str));
        PluginType pluginType3 = PluginType.EVENT;
        return PackageResult.get(isPluginRemoved, isPluginRemoved2, isPluginRemoved(pluginType3, str, PluginPackageScanner.loadPluginMap(this.mContext, pluginType3, str)));
    }

    private boolean isPluginAdded(@NonNull PluginType pluginType, @NonNull Map<String, Plugin> map) {
        Assertions.assertNotNull(pluginType, "type");
        Assertions.assertNotNull(map, "scannedPlugins");
        Map<String, Plugin> mutablePluginMap = getMutablePluginMap(pluginType);
        if (!mutablePluginMap.keySet().containsAll(map.keySet())) {
            mutablePluginMap.putAll(map);
            return true;
        }
        return false;
    }

    private boolean isPluginRemoved(@NonNull PluginType pluginType, @NonNull String str, @NonNull Map<String, Plugin> map) {
        Assertions.assertNotNull(pluginType, "type");
        Assertions.assertNotNull(map, "scannedPlugins");
        Iterator<Plugin> it = getMutablePluginMap(pluginType).values().iterator();
        boolean z3 = false;
        while (it.hasNext()) {
            Plugin next = it.next();
            if (str.equals(next.getPackageName()) && !map.containsKey(next.getRegistryName())) {
                next.getRegistryName();
                it.remove();
                z3 = true;
            }
        }
        return z3;
    }

    private void processPackageResult(@NonNull PackageResult packageResult) {
        Assertions.assertNotNull(packageResult, "result");
        switch (AnonymousClass1.$SwitchMap$com$twofortyfouram$locale$sdk$host$internal$PackageResult[packageResult.ordinal()]) {
            case 2:
                setEvents();
                setConditions();
                setSettings();
                sendBroadcast();
                return;
            case 3:
                setConditions();
                setSettings();
                sendBroadcast();
                return;
            case 4:
                setEvents();
                setSettings();
                sendBroadcast();
                return;
            case 5:
                setEvents();
                setConditions();
                sendBroadcast();
                return;
            case 6:
                setEvents();
                sendBroadcast();
                return;
            case 7:
                setConditions();
                sendBroadcast();
                return;
            case 8:
                setSettings();
                sendBroadcast();
                return;
            default:
                return;
        }
    }

    private void sendBroadcast() {
        Intent intent = this.mRegistryReloadedIntent;
        if (intent != null) {
            this.mContext.sendBroadcast(intent, this.mRegistryReloadedPermission);
        }
    }

    private void setConditions() {
        this.mImmutableConditionMap = Collections.unmodifiableMap(new HashMap(this.mMutableConditionMap));
    }

    private void setEvents() {
        this.mImmutableEventMap = Collections.unmodifiableMap(new HashMap(this.mMutableEventMap));
    }

    private void setSettings() {
        this.mImmutableSettingMap = Collections.unmodifiableMap(new HashMap(this.mMutableSettingMap));
    }

    @Nullable
    public Map<String, Plugin> getConditions() {
        return this.mImmutableConditionMap;
    }

    @Nullable
    public Map<String, Plugin> getEvents() {
        return this.mImmutableEventMap;
    }

    @Nullable
    public Map<String, Plugin> getSettings() {
        return this.mImmutableSettingMap;
    }

    @Override // android.os.Handler
    public void handleMessage(@NonNull Message message) {
        int i4 = message.what;
        if (i4 != 0) {
            if (i4 != 1) {
                if (i4 != 2) {
                    if (i4 != 3) {
                        if (i4 == 4) {
                            handleDestroy();
                            return;
                        }
                        throw new AssertionError(Lumberjack.formatMessage("Unrecognized what=%d", Integer.valueOf(message.what)));
                    }
                    processPackageResult(handlePackageChanged((String) message.obj));
                    return;
                }
                processPackageResult(handlePackageRemoved((String) message.obj));
                return;
            }
            processPackageResult(handlePackageAdded((String) message.obj));
            return;
        }
        CountDownLatch countDownLatch = (CountDownLatch) message.obj;
        try {
            handleInit();
        } finally {
            countDownLatch.countDown();
        }
    }

    PluginRegistryHandler(@NonNull Looper looper, @NonNull Context context, @NonNull String str) {
        super(looper);
        this.mMutableConditionMap = null;
        this.mMutableEventMap = null;
        this.mMutableSettingMap = null;
        this.mImmutableConditionMap = null;
        this.mImmutableEventMap = null;
        this.mImmutableSettingMap = null;
        this.mReceiverHandlerThread = null;
        this.mReceiver = new RegistryReceiver(this, null);
        Assertions.assertNotNull(context, "context");
        Assertions.assertNotNull(str, "notificationAction");
        this.mContext = ContextUtil.cleanContext(context);
        Intent intent = new Intent(str);
        this.mRegistryReloadedIntent = intent;
        intent.setPackage(context.getPackageName());
        this.mRegistryReloadedPermission = null;
    }
}
