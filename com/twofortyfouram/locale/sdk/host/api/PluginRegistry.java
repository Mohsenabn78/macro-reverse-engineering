package com.twofortyfouram.locale.sdk.host.api;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.HandlerThread;
import android.os.Process;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.twofortyfouram.assertion.Assertions;
import com.twofortyfouram.locale.sdk.host.internal.PluginRegistryHandler;
import com.twofortyfouram.locale.sdk.host.model.Plugin;
import com.twofortyfouram.locale.sdk.host.model.PluginType;
import com.twofortyfouram.spackle.AndroidSdkVersion;
import com.twofortyfouram.spackle.ContextUtil;
import com.twofortyfouram.spackle.StrictModeCompat;
import com.twofortyfouram.spackle.ThreadUtil;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.CountDownLatch;
import net.jcip.annotations.GuardedBy;
import net.jcip.annotations.ThreadSafe;

@ThreadSafe
/* loaded from: classes6.dex */
public final class PluginRegistry {
    @NonNull
    private static final String ACTION_REGISTRY_CHANGED = "com.twofortyfouram.locale.intent.action.PLUGIN_REGISTRY_CHANGED:%d";
    @NonNull
    private static final Object LAZY_INITIALIZATION_INTRINSIC_LOCK = new Object();
    @Nullable
    @GuardedBy("LAZY_INITIALIZATION_INTRINSIC_LOCK")
    private static volatile PluginRegistry sRegistry;
    @NonNull
    private final PluginRegistryHandler mHandler;
    @NonNull
    private final HandlerThread mHandlerThread;
    @NonNull
    private final CountDownLatch mLoadLatch;
    @NonNull
    private final String mRegistryChangeAction;
    @NonNull
    private final String mRegistryChangePermission;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.twofortyfouram.locale.sdk.host.api.PluginRegistry$1  reason: invalid class name */
    /* loaded from: classes6.dex */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$twofortyfouram$locale$sdk$host$model$PluginType;

        static {
            int[] iArr = new int[PluginType.values().length];
            $SwitchMap$com$twofortyfouram$locale$sdk$host$model$PluginType = iArr;
            try {
                iArr[PluginType.CONDITION.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$twofortyfouram$locale$sdk$host$model$PluginType[PluginType.SETTING.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$twofortyfouram$locale$sdk$host$model$PluginType[PluginType.EVENT.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    private PluginRegistry(@NonNull Context context, @NonNull String str) {
        HandlerThread newHandlerThread = ThreadUtil.newHandlerThread(PluginRegistryHandler.class.getName(), ThreadUtil.ThreadPriority.BACKGROUND);
        this.mHandlerThread = newHandlerThread;
        this.mLoadLatch = new CountDownLatch(1);
        Assertions.assertNotNull(context, "context");
        Assertions.assertNotNull(str, "notificationAction");
        Context cleanContext = ContextUtil.cleanContext(context);
        this.mRegistryChangeAction = str;
        String internalPermission = getInternalPermission(cleanContext);
        this.mRegistryChangePermission = internalPermission;
        this.mHandler = new PluginRegistryHandler(newHandlerThread.getLooper(), cleanContext, str, internalPermission);
    }

    private void blockUntilLoaded() {
        try {
            this.mLoadLatch.await();
        } catch (InterruptedException e4) {
            throw new RuntimeException(e4);
        }
    }

    @NonNull
    public static PluginRegistry getInstance(@NonNull Context context) {
        Context cleanContext = ContextUtil.cleanContext(context);
        PluginRegistry pluginRegistry = sRegistry;
        if (pluginRegistry == null) {
            synchronized (LAZY_INITIALIZATION_INTRINSIC_LOCK) {
                pluginRegistry = sRegistry;
                if (pluginRegistry == null) {
                    PluginRegistry pluginRegistry2 = new PluginRegistry(cleanContext, String.format(Locale.US, ACTION_REGISTRY_CHANGED, Integer.valueOf(Process.myPid())));
                    sRegistry = pluginRegistry2;
                    pluginRegistry2.init();
                    pluginRegistry = pluginRegistry2;
                }
            }
        }
        return pluginRegistry;
    }

    @NonNull
    private static String getInternalPermission(@NonNull Context context) {
        Assertions.assertNotNull(context, "context");
        return context.getPackageName() + ".com.twofortyfouram.locale.sdk.host.permission.internal";
    }

    private void init() {
        PluginRegistryHandler pluginRegistryHandler = this.mHandler;
        if (pluginRegistryHandler.sendMessage(pluginRegistryHandler.obtainMessage(0, this.mLoadLatch))) {
            return;
        }
        throw new AssertionError();
    }

    @Nullable
    private Map<String, Plugin> peekPluginMap(@NonNull PluginType pluginType) {
        Assertions.assertNotNull(pluginType, "type");
        int i4 = AnonymousClass1.$SwitchMap$com$twofortyfouram$locale$sdk$host$model$PluginType[pluginType.ordinal()];
        if (i4 != 1) {
            if (i4 != 2) {
                if (i4 == 3) {
                    return this.mHandler.getEvents();
                }
                throw new AssertionError();
            }
            return this.mHandler.getSettings();
        }
        return this.mHandler.getConditions();
    }

    @SuppressLint({"NewApi"})
    public void destroy() {
        synchronized (this) {
            if (this.mHandler.sendEmptyMessage(4)) {
                if (AndroidSdkVersion.isAtLeastSdk(18)) {
                    this.mHandlerThread.quitSafely();
                } else {
                    this.mHandlerThread.quit();
                    this.mLoadLatch.countDown();
                }
            } else {
                throw new AssertionError();
            }
        }
        sRegistry = null;
    }

    @NonNull
    public String getChangeIntentAction() {
        return this.mRegistryChangeAction;
    }

    @NonNull
    public String getChangeIntentPermission() {
        return this.mRegistryChangePermission;
    }

    @NonNull
    public Map<String, Plugin> getPluginMap(@NonNull PluginType pluginType) {
        Assertions.assertNotNull(pluginType, "type");
        StrictModeCompat.noteSlowCall("Call getPluginMap(PluginType).  Use peekPluginMap(PluginType) for performance critical sections of code");
        blockUntilLoaded();
        return peekPluginMap(pluginType);
    }
}
