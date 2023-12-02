package com.google.android.gms.ads.internal.client;

import android.content.Context;
import androidx.annotation.NonNull;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.dynamite.descriptors.com.google.android.gms.ads.dynamite.ModuleDescriptor;
import com.google.android.gms.internal.ads.zzbnt;
import com.google.android.gms.internal.ads.zzbnw;

/* compiled from: com.google.android.gms:play-services-ads-lite@@22.3.0 */
@KeepForSdk
/* loaded from: classes4.dex */
public class LiteSdkInfo extends zzck {
    public LiteSdkInfo(@NonNull Context context) {
    }

    @Override // com.google.android.gms.ads.internal.client.zzcl
    public zzbnw getAdapterCreator() {
        return new zzbnt();
    }

    @Override // com.google.android.gms.ads.internal.client.zzcl
    public zzen getLiteSdkVersion() {
        return new zzen(ModuleDescriptor.MODULE_VERSION, ModuleDescriptor.MODULE_VERSION, "22.3.0");
    }
}
