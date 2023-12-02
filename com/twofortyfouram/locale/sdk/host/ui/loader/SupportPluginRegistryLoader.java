package com.twofortyfouram.locale.sdk.host.ui.loader;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.WorkerThread;
import androidx.loader.content.AsyncTaskLoader;
import com.twofortyfouram.assertion.Assertions;
import com.twofortyfouram.locale.sdk.host.api.PluginRegistry;
import com.twofortyfouram.locale.sdk.host.internal.UiConfigChangeChecker;
import com.twofortyfouram.locale.sdk.host.model.Plugin;
import com.twofortyfouram.locale.sdk.host.model.PluginType;
import com.twofortyfouram.spackle.ContextUtil;
import com.twofortyfouram.spackle.bundle.BundleScrubber;
import java.util.Map;

/* loaded from: classes6.dex */
public final class SupportPluginRegistryLoader extends AsyncTaskLoader<Map<String, Plugin>> {
    @NonNull
    private final UiConfigChangeChecker mLastConfig;
    @NonNull
    private final PluginRegistry mPluginRegistry;
    @Nullable
    private RegistryReloadReceiver mReceiver;
    @Nullable
    private Map<String, Plugin> mResult;
    @NonNull
    private final PluginType mType;

    /* loaded from: classes6.dex */
    private final class RegistryReloadReceiver extends BroadcastReceiver {
        private RegistryReloadReceiver() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            Assertions.assertIsMainThread();
            if (BundleScrubber.scrub(intent) || this != SupportPluginRegistryLoader.this.mReceiver) {
                return;
            }
            SupportPluginRegistryLoader.this.onContentChanged();
        }
    }

    public SupportPluginRegistryLoader(@NonNull Context context, @NonNull PluginType pluginType) {
        super(ContextUtil.cleanContext(context));
        this.mReceiver = null;
        this.mLastConfig = new UiConfigChangeChecker();
        this.mResult = null;
        Assertions.assertNotNull(pluginType, "type");
        this.mType = pluginType;
        this.mPluginRegistry = PluginRegistry.getInstance(getContext());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.loader.content.Loader
    public void onReset() {
        Assertions.assertIsMainThread();
        onStopLoading();
        if (this.mReceiver != null) {
            getContext().unregisterReceiver(this.mReceiver);
            this.mReceiver = null;
        }
        this.mResult = null;
        super.onReset();
    }

    @Override // androidx.loader.content.Loader
    protected void onStartLoading() {
        Assertions.assertIsMainThread();
        if (this.mReceiver == null) {
            IntentFilter intentFilter = new IntentFilter(this.mPluginRegistry.getChangeIntentAction());
            this.mReceiver = new RegistryReloadReceiver();
            getContext().registerReceiver(this.mReceiver, intentFilter, this.mPluginRegistry.getChangeIntentPermission(), null);
        }
        Map<String, Plugin> map = this.mResult;
        if (map != null) {
            deliverResult(map);
        }
        boolean checkNewConfig = this.mLastConfig.checkNewConfig(getContext().getResources());
        if (takeContentChanged() || this.mResult == null || checkNewConfig) {
            forceLoad();
        }
    }

    @Override // androidx.loader.content.Loader
    protected void onStopLoading() {
        Assertions.assertIsMainThread();
        cancelLoad();
    }

    @Override // androidx.loader.content.Loader
    public void deliverResult(Map<String, Plugin> map) {
        Assertions.assertIsMainThread();
        if (map != this.mResult) {
            this.mResult = map;
            if (isStarted()) {
                super.deliverResult((SupportPluginRegistryLoader) this.mResult);
            }
        }
    }

    @Override // androidx.loader.content.AsyncTaskLoader
    @WorkerThread
    public Map<String, Plugin> loadInBackground() {
        return this.mPluginRegistry.getPluginMap(this.mType);
    }
}
