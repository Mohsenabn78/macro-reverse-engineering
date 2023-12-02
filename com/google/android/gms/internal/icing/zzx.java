package com.google.android.gms.internal.icing;

import android.content.ComponentName;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.Nullable;
import com.arlosoft.macrodroid.common.Util;
import com.google.android.gms.appindexing.AppIndexApi;
import com.google.android.gms.common.internal.ImagesContract;
import com.google.android.gms.common.internal.ShowFirstParty;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.util.VisibleForTesting;
import java.io.UnsupportedEncodingException;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import java.util.zip.CRC32;

/* compiled from: com.google.firebase:firebase-appindexing@@20.0.0 */
@ShowFirstParty
@SafeParcelable.Class(creator = "UsageInfoCreator")
@SafeParcelable.Reserved({1000})
/* loaded from: classes4.dex */
public final class zzx extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzx> CREATOR = new zzy();
    @SafeParcelable.Field(id = 1)
    final zzi zza;
    @SafeParcelable.Field(id = 2)
    final long zzb;
    @SafeParcelable.Field(id = 3)
    int zzc;
    @Nullable
    @SafeParcelable.Field(id = 4)
    public final String zzd;
    @Nullable
    @SafeParcelable.Field(id = 5)
    final zzg zze;
    @SafeParcelable.Field(defaultValue = "false", id = 6)
    final boolean zzf;
    @SafeParcelable.Field(defaultValue = Util.ANY_CONTACT_ID, id = 7)
    int zzg;
    @SafeParcelable.Field(id = 8)
    int zzh;
    @Nullable
    @SafeParcelable.Field(id = 9)
    public final String zzi;

    /* JADX INFO: Access modifiers changed from: package-private */
    @SafeParcelable.Constructor
    public zzx(@SafeParcelable.Param(id = 1) zzi zziVar, @SafeParcelable.Param(id = 2) long j4, @SafeParcelable.Param(id = 3) int i4, @Nullable @SafeParcelable.Param(id = 4) String str, @Nullable @SafeParcelable.Param(id = 5) zzg zzgVar, @SafeParcelable.Param(id = 6) boolean z3, @SafeParcelable.Param(id = 7) int i5, @SafeParcelable.Param(id = 8) int i6, @Nullable @SafeParcelable.Param(id = 9) String str2) {
        this.zza = zziVar;
        this.zzb = j4;
        this.zzc = i4;
        this.zzd = str;
        this.zze = zzgVar;
        this.zzf = z3;
        this.zzg = i5;
        this.zzh = i6;
        this.zzi = str2;
    }

    public static zzi zza(String str, Intent intent) {
        return zzc(str, zze(intent));
    }

    @VisibleForTesting
    public static zzf zzb(Intent intent, @Nullable String str, @Nullable Uri uri, @Nullable String str2, @Nullable List<AppIndexApi.AppIndexingLink> list) {
        String string;
        zzf zzfVar = new zzf();
        if (str != null) {
            zzr zzrVar = new zzr("title");
            zzrVar.zzc(true);
            zzrVar.zzd("name");
            zzfVar.zza(new zzk(str, zzrVar.zze(), zzq.zzb("text1"), null));
        }
        if (uri != null) {
            String uri2 = uri.toString();
            zzr zzrVar2 = new zzr("web_url");
            zzrVar2.zzb(true);
            zzrVar2.zzd(ImagesContract.URL);
            zzfVar.zza(new zzk(uri2, zzrVar2.zze(), zzk.zza, null));
        }
        if (list != null) {
            zzan zza = zzaq.zza();
            int size = list.size();
            zzap[] zzapVarArr = new zzap[size];
            for (int i4 = 0; i4 < size; i4++) {
                zzao zza2 = zzap.zza();
                AppIndexApi.AppIndexingLink appIndexingLink = list.get(i4);
                zza2.zza(appIndexingLink.appIndexingUrl.toString());
                zza2.zzc(appIndexingLink.viewId);
                Uri uri3 = appIndexingLink.webUrl;
                if (uri3 != null) {
                    zza2.zzb(uri3.toString());
                }
                zzapVarArr[i4] = zza2.zzj();
            }
            zza.zza(Arrays.asList(zzapVarArr));
            byte[] zzh = zza.zzj().zzh();
            zzr zzrVar3 = new zzr("outlinks");
            zzrVar3.zzb(true);
            zzrVar3.zzd(".private:outLinks");
            zzrVar3.zza("blob");
            zzfVar.zza(new zzk(null, zzrVar3.zze(), zzk.zza, zzh));
        }
        String action = intent.getAction();
        if (action != null) {
            zzfVar.zza(zzd("intent_action", action));
        }
        String dataString = intent.getDataString();
        if (dataString != null) {
            zzfVar.zza(zzd("intent_data", dataString));
        }
        ComponentName component = intent.getComponent();
        if (component != null) {
            zzfVar.zza(zzd("intent_activity", component.getClassName()));
        }
        Bundle extras = intent.getExtras();
        if (extras != null && (string = extras.getString("intent_extra_data_key")) != null) {
            zzfVar.zza(zzd("intent_extra_data", string));
        }
        if (str2 != null) {
            zzfVar.zzb(str2);
        }
        zzfVar.zzc(true);
        return zzfVar;
    }

    private static zzi zzc(String str, String str2) {
        return new zzi(str, "", str2);
    }

    private static zzk zzd(String str, String str2) {
        zzr zzrVar = new zzr(str);
        zzrVar.zzb(true);
        return new zzk(str2, zzrVar.zze(), zzq.zzb(str), null);
    }

    private static String zze(Intent intent) {
        String uri = intent.toUri(1);
        CRC32 crc32 = new CRC32();
        try {
            crc32.update(uri.getBytes("UTF-8"));
            return Long.toHexString(crc32.getValue());
        } catch (UnsupportedEncodingException e4) {
            throw new IllegalStateException(e4);
        }
    }

    public final String toString() {
        return String.format(Locale.US, "UsageInfo[documentId=%s, timestamp=%d, usageType=%d, status=%d]", this.zza, Long.valueOf(this.zzb), Integer.valueOf(this.zzc), Integer.valueOf(this.zzh));
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i4) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeParcelable(parcel, 1, this.zza, i4, false);
        SafeParcelWriter.writeLong(parcel, 2, this.zzb);
        SafeParcelWriter.writeInt(parcel, 3, this.zzc);
        SafeParcelWriter.writeString(parcel, 4, this.zzd, false);
        SafeParcelWriter.writeParcelable(parcel, 5, this.zze, i4, false);
        SafeParcelWriter.writeBoolean(parcel, 6, this.zzf);
        SafeParcelWriter.writeInt(parcel, 7, this.zzg);
        SafeParcelWriter.writeInt(parcel, 8, this.zzh);
        SafeParcelWriter.writeString(parcel, 9, this.zzi, false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }

    @VisibleForTesting
    public zzx(String str, Intent intent, String str2, Uri uri, @Nullable String str3, List<AppIndexApi.AppIndexingLink> list, int i4) {
        this(zzc(str, zze(intent)), System.currentTimeMillis(), 0, null, zzb(intent, str2, uri, null, list).zze(), false, -1, 1, null);
    }
}
