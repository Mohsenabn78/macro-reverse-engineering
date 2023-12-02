package com.google.mlkit.nl.translate.internal;

import android.content.Context;
import android.content.res.Resources;
import android.net.Uri;
import androidx.annotation.NonNull;
import androidx.annotation.WorkerThread;
import com.google.android.gms.internal.mlkit_translate.zzbo;
import com.google.android.gms.internal.mlkit_translate.zzbr;
import com.google.android.gms.internal.mlkit_translate.zzbt;
import com.google.android.gms.internal.mlkit_translate.zzbv;
import com.google.mlkit.common.MlKitException;
import com.google.mlkit.common.sdkinternal.ModelInfo;
import com.google.mlkit.common.sdkinternal.ModelType;
import com.google.mlkit.nl.translate.R;
import com.google.mlkit.nl.translate.TranslateRemoteModel;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/* compiled from: com.google.mlkit:translate@@17.0.1 */
@WorkerThread
/* loaded from: classes5.dex */
public final class zzu {

    /* renamed from: b  reason: collision with root package name */
    private static final int f33139b = R.raw.translate_models_metadata;

    /* renamed from: a  reason: collision with root package name */
    private final zzt f33140a;

    public zzu(zzt zztVar) {
        this.f33140a = zztVar;
    }

    private static final ModelInfo a(String str, String str2, String str3) {
        return new ModelInfo(TranslateRemoteModel.zza(str), Uri.parse(String.format(str3, "v5", "r29", str)), str2, ModelType.TRANSLATE);
    }

    public final List zza(@NonNull Context context, @NonNull TranslateRemoteModel translateRemoteModel) throws MlKitException {
        zzbo zza;
        String zze = zzad.zze(translateRemoteModel.getLanguage());
        try {
            InputStream openRawResource = context.getResources().openRawResource(f33139b);
            String next = new Scanner(openRawResource).useDelimiter("\\A").next();
            if (openRawResource != null) {
                openRawResource.close();
            }
            try {
                zzbr zzb = zzbt.zzb(next).zzb();
                zzbr zzc = zzb.zzc("PKG_HIGH");
                zzbr zzc2 = zzb.zzc("PKG_LOW");
                if (!zzc.zzg(zze) && !zzc2.zzg(zze)) {
                    this.f33140a.t();
                    throw new MlKitException("Could not locate the model metadata.", 13);
                }
                try {
                    if (zzc.zzg(zze)) {
                        zza = zzc.zza(zze);
                    } else {
                        zza = zzc2.zza(zze);
                    }
                    String zzd = zza.zzb().zzd("HASH").zzd();
                    ArrayList arrayList = new ArrayList(2);
                    arrayList.add(a(zze, zzd, "https://redirector.gvt1.com/edgedl/translate/offline/%s/high/%s/%s.zip"));
                    arrayList.add(a(zze, zzd, "https://dl.google.com/translate/offline/%s/high/%s/%s.zip"));
                    return arrayList;
                } catch (ClassCastException | IllegalStateException | NullPointerException e4) {
                    this.f33140a.r();
                    throw new MlKitException("Could not locate model's hash.", 13, e4);
                }
            } catch (zzbv e5) {
                this.f33140a.s();
                throw new MlKitException("Translate metadata could not be parsed.", 13, e5);
            }
        } catch (Resources.NotFoundException | IOException e6) {
            this.f33140a.q();
            throw new MlKitException("Translate metadata could not be located.", 13, e6);
        }
    }
}
