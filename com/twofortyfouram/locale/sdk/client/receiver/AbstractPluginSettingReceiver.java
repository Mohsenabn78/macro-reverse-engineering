package com.twofortyfouram.locale.sdk.client.receiver;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import androidx.annotation.NonNull;
import com.twofortyfouram.locale.sdk.client.internal.d;
import com.twofortyfouram.spackle.AndroidSdkVersion;
import com.twofortyfouram.spackle.bundle.BundleScrubber;

/* loaded from: classes6.dex */
public abstract class AbstractPluginSettingReceiver extends d {
    protected abstract void firePluginSetting(@NonNull Context context, @NonNull Bundle bundle);

    protected abstract boolean isAsync();

    protected abstract boolean isBundleValid(@NonNull Bundle bundle);

    @Override // android.content.BroadcastReceiver
    public final void onReceive(Context context, Intent intent) {
        if (BundleScrubber.scrub(intent) || !com.twofortyfouram.locale.api.Intent.ACTION_FIRE_SETTING.equals(intent.getAction())) {
            return;
        }
        if (!context.getPackageName().equals(intent.getPackage()) && !new ComponentName(context, getClass().getName()).equals(intent.getComponent())) {
            return;
        }
        Bundle bundleExtra = intent.getBundleExtra(com.twofortyfouram.locale.api.Intent.EXTRA_BUNDLE);
        if (BundleScrubber.scrub(intent) || bundleExtra == null || !isBundleValid(bundleExtra)) {
            return;
        }
        if (isAsync() && AndroidSdkVersion.isAtLeastSdk(11)) {
            a(new d.a(context, bundleExtra) { // from class: com.twofortyfouram.locale.sdk.client.receiver.AbstractPluginSettingReceiver.1

                /* renamed from: a  reason: collision with root package name */
                final /* synthetic */ Context f38099a;

                /* renamed from: b  reason: collision with root package name */
                final /* synthetic */ Bundle f38100b;
                @NonNull

                /* renamed from: d  reason: collision with root package name */
                private final Context f38102d;
                @NonNull

                /* renamed from: e  reason: collision with root package name */
                private final Bundle f38103e;

                {
                    this.f38099a = context;
                    this.f38100b = bundleExtra;
                    this.f38102d = context;
                    this.f38103e = bundleExtra;
                }

                @Override // com.twofortyfouram.locale.sdk.client.internal.d.a
                public final int a() {
                    AbstractPluginSettingReceiver.this.firePluginSetting(this.f38102d, this.f38103e);
                    return -1;
                }
            }, isOrderedBroadcast());
        } else {
            firePluginSetting(context, bundleExtra);
        }
    }
}
