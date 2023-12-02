package com.google.android.gms.internal.p002firebaseauthapi;

import android.net.Uri;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.gms.common.internal.Preconditions;
import com.google.firebase.auth.zze;
import java.util.List;

/* compiled from: com.google.firebase:firebase-auth@@22.1.1 */
/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzadl  reason: invalid package */
/* loaded from: classes4.dex */
public final class zzadl {
    private String zza;
    private String zzb;
    private boolean zzc;
    private String zzd;
    private String zze;
    private zzaea zzf;
    private String zzg;
    private String zzh;
    private long zzi;
    private long zzj;
    private boolean zzk;
    private zze zzl;
    private List zzm;

    public zzadl() {
        this.zzf = new zzaea();
    }

    public final long zza() {
        return this.zzi;
    }

    public final long zzb() {
        return this.zzj;
    }

    @Nullable
    public final Uri zzc() {
        if (!TextUtils.isEmpty(this.zze)) {
            return Uri.parse(this.zze);
        }
        return null;
    }

    @Nullable
    public final zze zzd() {
        return this.zzl;
    }

    @NonNull
    public final zzadl zze(zze zzeVar) {
        this.zzl = zzeVar;
        return this;
    }

    @NonNull
    public final zzadl zzf(@Nullable String str) {
        this.zzd = str;
        return this;
    }

    @NonNull
    public final zzadl zzg(@Nullable String str) {
        this.zzb = str;
        return this;
    }

    public final zzadl zzh(boolean z3) {
        this.zzk = z3;
        return this;
    }

    @NonNull
    public final zzadl zzi(String str) {
        Preconditions.checkNotEmpty(str);
        this.zzg = str;
        return this;
    }

    @NonNull
    public final zzadl zzj(@Nullable String str) {
        this.zze = str;
        return this;
    }

    @NonNull
    public final zzadl zzk(List list) {
        Preconditions.checkNotNull(list);
        zzaea zzaeaVar = new zzaea();
        this.zzf = zzaeaVar;
        zzaeaVar.zzc().addAll(list);
        return this;
    }

    public final zzaea zzl() {
        return this.zzf;
    }

    @Nullable
    public final String zzm() {
        return this.zzd;
    }

    @Nullable
    public final String zzn() {
        return this.zzb;
    }

    @NonNull
    public final String zzo() {
        return this.zza;
    }

    @Nullable
    public final String zzp() {
        return this.zzh;
    }

    @NonNull
    public final List zzq() {
        return this.zzm;
    }

    @NonNull
    public final List zzr() {
        return this.zzf.zzc();
    }

    public final boolean zzs() {
        return this.zzc;
    }

    public final boolean zzt() {
        return this.zzk;
    }

    public zzadl(String str, String str2, boolean z3, String str3, String str4, zzaea zzaeaVar, String str5, String str6, long j4, long j5, boolean z4, zze zzeVar, List list) {
        this.zza = str;
        this.zzb = str2;
        this.zzc = z3;
        this.zzd = str3;
        this.zze = str4;
        this.zzf = zzaea.zzb(zzaeaVar);
        this.zzg = str5;
        this.zzh = str6;
        this.zzi = j4;
        this.zzj = j5;
        this.zzk = false;
        this.zzl = null;
        this.zzm = list;
    }
}
