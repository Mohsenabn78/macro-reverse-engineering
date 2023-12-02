package com.google.android.gms.internal.wearable;

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
/* compiled from: com.google.android.gms:play-services-wearable@@18.0.0 */
/* loaded from: classes4.dex */
public final class zzcg {
    public static final zzcg zza;
    public static final zzcg zzb;
    public static final zzcg zzc;
    public static final zzcg zzd;
    public static final zzcg zze;
    public static final zzcg zzf;
    public static final zzcg zzg;
    public static final zzcg zzh;
    public static final zzcg zzi;
    public static final zzcg zzj;
    private static final /* synthetic */ zzcg[] zzk;
    private final Class zzl;
    private final Class zzm;
    private final Object zzn;

    static {
        zzcg zzcgVar = new zzcg("VOID", 0, Void.class, Void.class, null);
        zza = zzcgVar;
        Class cls = Integer.TYPE;
        zzcg zzcgVar2 = new zzcg("INT", 1, cls, Integer.class, 0);
        zzb = zzcgVar2;
        zzcg zzcgVar3 = new zzcg("LONG", 2, Long.TYPE, Long.class, 0L);
        zzc = zzcgVar3;
        zzcg zzcgVar4 = new zzcg("FLOAT", 3, Float.TYPE, Float.class, Float.valueOf(0.0f));
        zzd = zzcgVar4;
        zzcg zzcgVar5 = new zzcg("DOUBLE", 4, Double.TYPE, Double.class, Double.valueOf((double) FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE));
        zze = zzcgVar5;
        zzcg zzcgVar6 = new zzcg("BOOLEAN", 5, Boolean.TYPE, Boolean.class, Boolean.FALSE);
        zzf = zzcgVar6;
        zzcg zzcgVar7 = new zzcg("STRING", 6, String.class, String.class, "");
        zzg = zzcgVar7;
        zzcg zzcgVar8 = new zzcg("BYTE_STRING", 7, zzaw.class, zzaw.class, zzaw.zzb);
        zzh = zzcgVar8;
        zzcg zzcgVar9 = new zzcg("ENUM", 8, cls, Integer.class, null);
        zzi = zzcgVar9;
        zzcg zzcgVar10 = new zzcg("MESSAGE", 9, Object.class, Object.class, null);
        zzj = zzcgVar10;
        zzk = new zzcg[]{zzcgVar, zzcgVar2, zzcgVar3, zzcgVar4, zzcgVar5, zzcgVar6, zzcgVar7, zzcgVar8, zzcgVar9, zzcgVar10};
    }

    private zzcg(String str, int i4, Class cls, Class cls2, Object obj) {
        this.zzl = cls;
        this.zzm = cls2;
        this.zzn = obj;
    }

    public static zzcg[] values() {
        return (zzcg[]) zzk.clone();
    }

    public final Class zza() {
        return this.zzm;
    }
}
