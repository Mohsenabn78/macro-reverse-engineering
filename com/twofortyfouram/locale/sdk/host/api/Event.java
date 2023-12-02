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
import androidx.core.util.Pair;
import com.arlosoft.macrodroid.plugins.comments.PluginCommentsActivity;
import com.twofortyfouram.assertion.Assertions;
import com.twofortyfouram.locale.sdk.host.TaskerPlugin;
import com.twofortyfouram.locale.sdk.host.internal.BundleSerializer;
import com.twofortyfouram.locale.sdk.host.model.Plugin;
import com.twofortyfouram.locale.sdk.host.model.PluginInstanceData;
import com.twofortyfouram.locale.sdk.host.model.PluginType;
import com.twofortyfouram.log.Lumberjack;
import com.twofortyfouram.spackle.ContextUtil;
import com.twofortyfouram.spackle.ThreadUtil;
import com.twofortyfouram.spackle.bundle.BundleScrubber;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import net.jcip.annotations.ThreadSafe;

/* loaded from: classes6.dex */
public final class Event {
    private static final int BROADCAST_TIMEOUT_MILLIS = 11000;
    private Context mContext;
    @NonNull
    private final Handler mHandler;
    @NonNull
    private final HandlerThread mHandlerThread;
    private Plugin mPlugin;

    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes6.dex */
    public @interface ConditionResult {
    }

    /* JADX INFO: Access modifiers changed from: private */
    @ThreadSafe
    /* loaded from: classes6.dex */
    public static final class QueryResultReceiver extends BroadcastReceiver {
        @NonNull
        final CountDownLatch mLatch;
        @NonNull
        final AtomicInteger mQueryResult;
        Bundle variablesBundle;

        private QueryResultReceiver() {
            this.mLatch = new CountDownLatch(1);
            this.mQueryResult = new AtomicInteger(18);
            this.variablesBundle = null;
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            try {
                if (BundleScrubber.scrub(intent)) {
                    this.mQueryResult.set(18);
                    return;
                }
                switch (getResultCode()) {
                    case 16:
                        if (getResultExtras(true) != null) {
                            this.variablesBundle = TaskerPlugin.Host.getVariablesBundle(getResultExtras(true));
                        } else {
                            this.variablesBundle = null;
                        }
                        Lumberjack.always("Got RESULT_CONDITION_SATISFIED", new Object[0]);
                        this.mQueryResult.set(16);
                        break;
                    case 17:
                        Lumberjack.always("Got RESULT_CONDITION_UNSATISFIED", new Object[0]);
                        this.mQueryResult.set(17);
                        break;
                    case 18:
                        Lumberjack.always("Got RESULT_CONDITION_UNKNOWN", new Object[0]);
                        this.mQueryResult.set(18);
                        break;
                    default:
                        getResultCode();
                        this.mQueryResult.set(18);
                        break;
                }
            } finally {
                this.mLatch.countDown();
            }
        }
    }

    public Event(@NonNull Context context, @NonNull Plugin plugin) {
        HandlerThread newHandlerThread = ThreadUtil.newHandlerThread(Event.class.getName(), ThreadUtil.ThreadPriority.BACKGROUND);
        this.mHandlerThread = newHandlerThread;
        this.mHandler = new Handler(newHandlerThread.getLooper());
        Assertions.assertNotNull(context, "context");
        Assertions.assertNotNull(plugin, PluginCommentsActivity.EXTRA_PLUGIN_DETAIL);
        if (PluginType.EVENT == plugin.getType()) {
            this.mContext = ContextUtil.cleanContext(context);
            this.mPlugin = plugin;
            return;
        }
        throw new IllegalArgumentException("plugin.getType() must be EVENT");
    }

    @TargetApi(12)
    private static void addFlagsHoneycombMr1(@NonNull Intent intent) {
        intent.addFlags(32);
    }

    @NonNull
    private static Intent newQueryIntent(@NonNull Plugin plugin, @NonNull Bundle bundle) {
        Assertions.assertNotNull(plugin, PluginCommentsActivity.EXTRA_PLUGIN_DETAIL);
        Assertions.assertNotNull(bundle, "extraBundle");
        Intent intent = new Intent();
        intent.setAction(com.twofortyfouram.locale.api.Intent.ACTION_QUERY_CONDITION);
        intent.setFlags(4);
        TaskerPlugin.Host.addCapabilities(intent, 126);
        addFlagsHoneycombMr1(intent);
        intent.setClassName(plugin.getPackageName(), plugin.getReceiverClassName());
        intent.putExtra(com.twofortyfouram.locale.api.Intent.EXTRA_BUNDLE, bundle);
        intent.putExtras(bundle);
        return intent;
    }

    public void destroy() {
        this.mHandlerThread.getLooper().quit();
        this.mContext = null;
        this.mPlugin = null;
    }

    public Pair<Integer, Bundle> query(@NonNull PluginInstanceData pluginInstanceData, int i4, Bundle bundle) {
        Assertions.assertNotNull(pluginInstanceData, "data");
        Assertions.assertInRangeInclusive(i4, 16, 18, "previousState");
        try {
            return query(BundleSerializer.deserializeFromByteArray(pluginInstanceData.getSerializedBundle()), i4, bundle);
        } catch (Exception e4) {
            Lumberjack.always("Error deserializing bundle", e4);
            return new Pair<>(18, null);
        }
    }

    private Pair<Integer, Bundle> query(@NonNull Bundle bundle, int i4, Bundle bundle2) {
        Assertions.assertNotNull(bundle, "pluginBundle");
        Assertions.assertInRangeInclusive(i4, 16, 18, "previousState");
        Lumberjack.always("Querying plug-in condition %s", this.mPlugin.getRegistryName());
        Intent newQueryIntent = newQueryIntent(this.mPlugin, bundle);
        if (bundle2 != null) {
            TaskerPlugin.Event.addPassThroughData(newQueryIntent, bundle2);
        }
        TaskerPlugin.Host.addCapabilities(newQueryIntent, 126);
        QueryResultReceiver queryResultReceiver = new QueryResultReceiver();
        SystemClock.elapsedRealtime();
        this.mContext.sendOrderedBroadcast(newQueryIntent, null, queryResultReceiver, this.mHandler, i4, null, null);
        try {
            if (queryResultReceiver.mLatch.await(11000L, TimeUnit.MILLISECONDS)) {
                SystemClock.elapsedRealtime();
            }
        } catch (InterruptedException unused) {
        }
        return new Pair<>(Integer.valueOf(queryResultReceiver.mQueryResult.get()), queryResultReceiver.variablesBundle);
    }
}
