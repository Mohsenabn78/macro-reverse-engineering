package com.google.android.gms.internal.play_billing;

import com.google.firebase.remoteconfig.FirebaseRemoteConfig;

/* JADX WARN: Enum visitor error
jadx.core.utils.exceptions.JadxRuntimeException: Init of enum zzb uses external variables
	at jadx.core.dex.visitors.EnumVisitor.createEnumFieldByConstructor(EnumVisitor.java:444)
	at jadx.core.dex.visitors.EnumVisitor.processEnumFieldByRegister(EnumVisitor.java:391)
	at jadx.core.dex.visitors.EnumVisitor.extractEnumFieldsFromFilledArray(EnumVisitor.java:320)
	at jadx.core.dex.visitors.EnumVisitor.extractEnumFieldsFromInsn(EnumVisitor.java:258)
	at jadx.core.dex.visitors.EnumVisitor.convertToEnum(EnumVisitor.java:151)
	at jadx.core.dex.visitors.EnumVisitor.visit(EnumVisitor.java:100)
 */
/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* compiled from: com.android.billingclient:billing@@5.2.0 */
/* loaded from: classes4.dex */
public final class zzcj {
    public static final zzcj zza;
    public static final zzcj zzb;
    public static final zzcj zzc;
    public static final zzcj zzd;
    public static final zzcj zze;
    public static final zzcj zzf;
    public static final zzcj zzg;
    public static final zzcj zzh;
    public static final zzcj zzi;
    public static final zzcj zzj;
    private static final /* synthetic */ zzcj[] zzk;
    private final Class zzl;
    private final Class zzm;
    private final Object zzn;

    static {
        zzcj zzcjVar = new zzcj("VOID", 0, Void.class, Void.class, null);
        zza = zzcjVar;
        Class cls = Integer.TYPE;
        zzcj zzcjVar2 = new zzcj("INT", 1, cls, Integer.class, 0);
        zzb = zzcjVar2;
        zzcj zzcjVar3 = new zzcj("LONG", 2, Long.TYPE, Long.class, 0L);
        zzc = zzcjVar3;
        zzcj zzcjVar4 = new zzcj("FLOAT", 3, Float.TYPE, Float.class, Float.valueOf(0.0f));
        zzd = zzcjVar4;
        zzcj zzcjVar5 = new zzcj("DOUBLE", 4, Double.TYPE, Double.class, Double.valueOf((double) FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE));
        zze = zzcjVar5;
        zzcj zzcjVar6 = new zzcj("BOOLEAN", 5, Boolean.TYPE, Boolean.class, Boolean.FALSE);
        zzf = zzcjVar6;
        zzcj zzcjVar7 = new zzcj("STRING", 6, String.class, String.class, "");
        zzg = zzcjVar7;
        zzcj zzcjVar8 = new zzcj("BYTE_STRING", 7, zzba.class, zzba.class, zzba.zzb);
        zzh = zzcjVar8;
        zzcj zzcjVar9 = new zzcj("ENUM", 8, cls, Integer.class, null);
        zzi = zzcjVar9;
        zzcj zzcjVar10 = new zzcj("MESSAGE", 9, Object.class, Object.class, null);
        zzj = zzcjVar10;
        zzk = new zzcj[]{zzcjVar, zzcjVar2, zzcjVar3, zzcjVar4, zzcjVar5, zzcjVar6, zzcjVar7, zzcjVar8, zzcjVar9, zzcjVar10};
    }

    private zzcj(String str, int i4, Class cls, Class cls2, Object obj) {
        this.zzl = cls;
        this.zzm = cls2;
        this.zzn = obj;
    }

    public static zzcj[] values() {
        return (zzcj[]) zzk.clone();
    }

    public final Class zza() {
        return this.zzm;
    }
}
