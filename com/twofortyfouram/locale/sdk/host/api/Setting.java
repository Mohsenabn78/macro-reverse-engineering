package com.twofortyfouram.locale.sdk.host.api;

import android.annotation.TargetApi;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.SystemClock;
import androidx.annotation.NonNull;
import com.arlosoft.macrodroid.plugins.comments.PluginCommentsActivity;
import com.twofortyfouram.assertion.Assertions;
import com.twofortyfouram.locale.sdk.host.TaskerPlugin;
import com.twofortyfouram.locale.sdk.host.internal.BundleSerializer;
import com.twofortyfouram.locale.sdk.host.model.Plugin;
import com.twofortyfouram.locale.sdk.host.model.PluginInstanceData;
import com.twofortyfouram.locale.sdk.host.model.PluginType;
import com.twofortyfouram.log.Lumberjack;
import com.twofortyfouram.spackle.AndroidSdkVersion;
import com.twofortyfouram.spackle.ContextUtil;
import com.twofortyfouram.spackle.ThreadUtil;
import com.twofortyfouram.spackle.bundle.BundleScrubber;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import net.jcip.annotations.ThreadSafe;

/* loaded from: classes6.dex */
public final class Setting {
    private static final int BROADCAST_TIMEOUT_MILLIS = 11000;
    @NonNull
    private final Context mContext;
    @NonNull
    private final Handler mHandler;
    @NonNull
    private final HandlerThread mHandlerThread;
    @NonNull
    private final Plugin mPlugin;

    /* JADX INFO: Access modifiers changed from: private */
    @ThreadSafe
    /* loaded from: classes6.dex */
    public static final class FireResultReceiver extends BroadcastReceiver {
        @NonNull
        final CountDownLatch mLatch;

        private FireResultReceiver() {
            this.mLatch = new CountDownLatch(1);
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            try {
                if (BundleScrubber.scrub(intent)) {
                }
            } finally {
                this.mLatch.countDown();
            }
        }
    }

    public Setting(@NonNull Context context, @NonNull Plugin plugin) {
        HandlerThread newHandlerThread = ThreadUtil.newHandlerThread(Setting.class.getName(), ThreadUtil.ThreadPriority.BACKGROUND);
        this.mHandlerThread = newHandlerThread;
        this.mHandler = new Handler(newHandlerThread.getLooper());
        Assertions.assertNotNull(context, "context");
        Assertions.assertNotNull(plugin, PluginCommentsActivity.EXTRA_PLUGIN_DETAIL);
        if (PluginType.SETTING == plugin.getType()) {
            this.mContext = ContextUtil.cleanContext(context);
            this.mPlugin = plugin;
            return;
        }
        throw new IllegalArgumentException("plugin.getType() must be SETTING");
    }

    @TargetApi(12)
    private static void addFlagsHoneycombMr1(@NonNull Intent intent) {
        intent.addFlags(32);
    }

    public void destroy() {
        this.mHandlerThread.getLooper().quit();
    }

    public void fire(@NonNull PluginInstanceData pluginInstanceData, Intent intent) {
        Assertions.assertNotNull(pluginInstanceData, "data");
        try {
            fire(BundleSerializer.deserializeFromByteArray(pluginInstanceData.getSerializedBundle()), intent);
        } catch (Exception e4) {
            Lumberjack.always("Error deserializing bundle", e4);
        }
    }

    private void fire(@NonNull Bundle bundle, Intent intent) {
        Assertions.assertNotNull(bundle, "pluginBundle");
        Lumberjack.always("Firing plug-in setting %s", this.mPlugin.getRegistryName());
        Intent intent2 = new Intent();
        intent2.setAction(com.twofortyfouram.locale.api.Intent.ACTION_FIRE_SETTING);
        intent2.setFlags(4);
        if (AndroidSdkVersion.isAtLeastSdk(12)) {
            addFlagsHoneycombMr1(intent2);
        }
        TaskerPlugin.Host.addCapabilities(intent2, 126);
        TaskerPlugin.Host.addCompletionIntent(intent2, intent);
        intent2.setClassName(this.mPlugin.getPackageName(), this.mPlugin.getReceiverClassName());
        intent2.putExtra(com.twofortyfouram.locale.api.Intent.EXTRA_BUNDLE, bundle);
        if (this.mPlugin.getConfiguration().isBackwardsCompatibilityEnabled()) {
            intent2.putExtras(bundle);
        }
        try {
            FireResultReceiver fireResultReceiver = new FireResultReceiver();
            SystemClock.elapsedRealtime();
            this.mContext.sendOrderedBroadcast(intent2, null, fireResultReceiver, this.mHandler, 18, null, null);
            try {
                if (!fireResultReceiver.mLatch.await(11000L, TimeUnit.MILLISECONDS)) {
                    this.mContext.sendBroadcast(intent2);
                } else {
                    SystemClock.elapsedRealtime();
                }
            } catch (InterruptedException unused) {
                this.mContext.sendBroadcast(intent2);
            }
        } catch (Exception e4) {
            Lumberjack.always("Could not fire plug-in setting%s", e4);
        }
    }
}
