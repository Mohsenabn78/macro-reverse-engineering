package com.google.mlkit.nl.translate.internal;

import android.app.DownloadManager;
import android.content.Context;
import com.google.android.gms.internal.mlkit_translate.zznv;
import com.google.mlkit.common.sdkinternal.MlKitContext;
import com.google.mlkit.common.sdkinternal.SharedPrefManager;
import com.google.mlkit.common.sdkinternal.model.ModelFileHelper;
import com.google.mlkit.common.sdkinternal.model.RemoteModelFileManager;
import com.google.mlkit.nl.translate.TranslateRemoteModel;

/* compiled from: com.google.mlkit:translate@@17.0.1 */
/* loaded from: classes5.dex */
public final class zzh {

    /* renamed from: a  reason: collision with root package name */
    private final MlKitContext f33105a;

    /* renamed from: b  reason: collision with root package name */
    private final Context f33106b;

    /* renamed from: c  reason: collision with root package name */
    private final zzr f33107c;

    /* renamed from: d  reason: collision with root package name */
    private final zzaf f33108d;

    /* renamed from: e  reason: collision with root package name */
    private final ModelFileHelper f33109e;

    /* renamed from: f  reason: collision with root package name */
    private final SharedPrefManager f33110f;

    public zzh(MlKitContext mlKitContext, Context context, zzr zzrVar, zzaf zzafVar, ModelFileHelper modelFileHelper, SharedPrefManager sharedPrefManager) {
        this.f33105a = mlKitContext;
        this.f33106b = context;
        this.f33107c = zzrVar;
        this.f33108d = zzafVar;
        this.f33109e = modelFileHelper;
        this.f33110f = sharedPrefManager;
    }

    public final zzi zza(TranslateRemoteModel translateRemoteModel) {
        zzr zzrVar = this.f33107c;
        String[] split = translateRemoteModel.getUniqueModelNameForPersist().split("_");
        zznv zznvVar = new zznv();
        zznvVar.zza(split[0]);
        zznvVar.zzb(split[1]);
        zzt zza = zzrVar.zza(zznvVar.zzc());
        return new zzi(this.f33106b, new RemoteModelFileManager(this.f33105a, translateRemoteModel, null, this.f33109e, new zzag(this.f33105a, zzad.zze(translateRemoteModel.getLanguage()))), translateRemoteModel, this.f33108d, zza, new zzu(zza), (DownloadManager) this.f33106b.getSystemService("download"), this.f33109e, this.f33110f, new zzc());
    }
}
