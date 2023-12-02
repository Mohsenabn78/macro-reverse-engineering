package com.google.android.gms.internal.icing;

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
/* compiled from: com.google.firebase:firebase-appindexing@@20.0.0 */
/* loaded from: classes4.dex */
public final class zzdk {
    public static final zzdk zza;
    public static final zzdk zzb;
    public static final zzdk zzc;
    public static final zzdk zzd;
    public static final zzdk zze;
    public static final zzdk zzf;
    public static final zzdk zzg;
    public static final zzdk zzh;
    public static final zzdk zzi;
    public static final zzdk zzj;
    private static final /* synthetic */ zzdk[] zzn;
    private final Class<?> zzk;
    private final Class<?> zzl;
    private final Object zzm;

    static {
        zzdk zzdkVar = new zzdk("VOID", 0, Void.class, Void.class, null);
        zza = zzdkVar;
        Class cls = Integer.TYPE;
        zzdk zzdkVar2 = new zzdk("INT", 1, cls, Integer.class, 0);
        zzb = zzdkVar2;
        zzdk zzdkVar3 = new zzdk("LONG", 2, Long.TYPE, Long.class, 0L);
        zzc = zzdkVar3;
        zzdk zzdkVar4 = new zzdk("FLOAT", 3, Float.TYPE, Float.class, Float.valueOf(0.0f));
        zzd = zzdkVar4;
        zzdk zzdkVar5 = new zzdk("DOUBLE", 4, Double.TYPE, Double.class, Double.valueOf((double) FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE));
        zze = zzdkVar5;
        zzdk zzdkVar6 = new zzdk("BOOLEAN", 5, Boolean.TYPE, Boolean.class, Boolean.FALSE);
        zzf = zzdkVar6;
        zzdk zzdkVar7 = new zzdk("STRING", 6, String.class, String.class, "");
        zzg = zzdkVar7;
        zzdk zzdkVar8 = new zzdk("BYTE_STRING", 7, zzcf.class, zzcf.class, zzcf.zzb);
        zzh = zzdkVar8;
        zzdk zzdkVar9 = new zzdk("ENUM", 8, cls, Integer.class, null);
        zzi = zzdkVar9;
        zzdk zzdkVar10 = new zzdk("MESSAGE", 9, Object.class, Object.class, null);
        zzj = zzdkVar10;
        zzn = new zzdk[]{zzdkVar, zzdkVar2, zzdkVar3, zzdkVar4, zzdkVar5, zzdkVar6, zzdkVar7, zzdkVar8, zzdkVar9, zzdkVar10};
    }

    private zzdk(String str, int i4, Class cls, Class cls2, Object obj) {
        this.zzk = cls;
        this.zzl = cls2;
        this.zzm = obj;
    }

    public static zzdk[] values() {
        return (zzdk[]) zzn.clone();
    }

    public final Class<?> zza() {
        return this.zzl;
    }
}
