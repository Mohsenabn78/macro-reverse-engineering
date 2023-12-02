package com.twofortyfouram.locale.sdk.client.receiver;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import androidx.annotation.NonNull;
import com.twofortyfouram.annotation.VisibleForTesting;
import com.twofortyfouram.locale.sdk.client.internal.d;
import com.twofortyfouram.log.Lumberjack;
import com.twofortyfouram.spackle.AndroidSdkVersion;
import com.twofortyfouram.spackle.bundle.BundleScrubber;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* loaded from: classes6.dex */
public abstract class AbstractPluginConditionReceiver extends d {

    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes6.dex */
    public @interface ConditionResult {
    }

    @VisibleForTesting(VisibleForTesting.Visibility.PRIVATE)
    static void a(int i4) {
        if (16 != i4 && 17 != i4 && 18 != i4) {
            throw new AssertionError(Lumberjack.formatMessage("result=%d is not one of [%d, %d, %d]", Integer.valueOf(i4), 16, 17, 18));
        }
    }

    protected abstract int getPluginConditionResult(@NonNull Context context, @NonNull Bundle bundle);

    protected abstract boolean isAsync();

    protected abstract boolean isBundleValid(@NonNull Bundle bundle);

    @Override // android.content.BroadcastReceiver
    public final void onReceive(Context context, Intent intent) {
        if (BundleScrubber.scrub(intent) || !isOrderedBroadcast()) {
            return;
        }
        if (!com.twofortyfouram.locale.api.Intent.ACTION_QUERY_CONDITION.equals(intent.getAction())) {
            setResultCode(18);
        } else if (!new ComponentName(context, getClass().getName()).equals(intent.getComponent())) {
            setResultCode(18);
            abortBroadcast();
        } else {
            Bundle bundleExtra = intent.getBundleExtra(com.twofortyfouram.locale.api.Intent.EXTRA_BUNDLE);
            if (BundleScrubber.scrub(intent)) {
                return;
            }
            if (bundleExtra == null) {
                setResultCode(18);
            } else if (!isBundleValid(bundleExtra)) {
                setResultCode(18);
            } else if (isAsync() && AndroidSdkVersion.isAtLeastSdk(11)) {
                a(new d.a(context, bundleExtra) { // from class: com.twofortyfouram.locale.sdk.client.receiver.AbstractPluginConditionReceiver.1

                    /* renamed from: a  reason: collision with root package name */
                    final /* synthetic */ Context f38094a;

                    /* renamed from: b  reason: collision with root package name */
                    final /* synthetic */ Bundle f38095b;
                    @NonNull

                    /* renamed from: d  reason: collision with root package name */
                    private final Context f38097d;
                    @NonNull

                    /* renamed from: e  reason: collision with root package name */
                    private final Bundle f38098e;

                    {
                        this.f38094a = context;
                        this.f38095b = bundleExtra;
                        this.f38097d = context;
                        this.f38098e = bundleExtra;
                    }

                    @Override // com.twofortyfouram.locale.sdk.client.internal.d.a
                    public final int a() {
                        int pluginConditionResult = AbstractPluginConditionReceiver.this.getPluginConditionResult(this.f38097d, this.f38098e);
                        AbstractPluginConditionReceiver.a(pluginConditionResult);
                        return pluginConditionResult;
                    }
                }, isOrderedBroadcast());
            } else {
                int pluginConditionResult = getPluginConditionResult(context, bundleExtra);
                a(pluginConditionResult);
                setResultCode(pluginConditionResult);
            }
        }
    }
}
