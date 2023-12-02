package com.google.android.gms.internal.ads;

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
/* compiled from: com.google.android.gms:play-services-ads@@22.3.0 */
/* loaded from: classes4.dex */
public final class zzgqa {
    public static final zzgqa zza;
    public static final zzgqa zzb;
    public static final zzgqa zzc;
    public static final zzgqa zzd;
    public static final zzgqa zze;
    public static final zzgqa zzf;
    public static final zzgqa zzg;
    public static final zzgqa zzh;
    public static final zzgqa zzi;
    public static final zzgqa zzj;
    private static final /* synthetic */ zzgqa[] zzk;
    private final Class zzl;
    private final Class zzm;
    private final Object zzn;

    static {
        zzgqa zzgqaVar = new zzgqa("VOID", 0, Void.class, Void.class, null);
        zza = zzgqaVar;
        Class cls = Integer.TYPE;
        zzgqa zzgqaVar2 = new zzgqa("INT", 1, cls, Integer.class, 0);
        zzb = zzgqaVar2;
        zzgqa zzgqaVar3 = new zzgqa("LONG", 2, Long.TYPE, Long.class, 0L);
        zzc = zzgqaVar3;
        zzgqa zzgqaVar4 = new zzgqa("FLOAT", 3, Float.TYPE, Float.class, Float.valueOf(0.0f));
        zzd = zzgqaVar4;
        zzgqa zzgqaVar5 = new zzgqa("DOUBLE", 4, Double.TYPE, Double.class, Double.valueOf((double) FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE));
        zze = zzgqaVar5;
        zzgqa zzgqaVar6 = new zzgqa("BOOLEAN", 5, Boolean.TYPE, Boolean.class, Boolean.FALSE);
        zzf = zzgqaVar6;
        zzgqa zzgqaVar7 = new zzgqa("STRING", 6, String.class, String.class, "");
        zzg = zzgqaVar7;
        zzgqa zzgqaVar8 = new zzgqa("BYTE_STRING", 7, zzgoe.class, zzgoe.class, zzgoe.zzb);
        zzh = zzgqaVar8;
        zzgqa zzgqaVar9 = new zzgqa("ENUM", 8, cls, Integer.class, null);
        zzi = zzgqaVar9;
        zzgqa zzgqaVar10 = new zzgqa("MESSAGE", 9, Object.class, Object.class, null);
        zzj = zzgqaVar10;
        zzk = new zzgqa[]{zzgqaVar, zzgqaVar2, zzgqaVar3, zzgqaVar4, zzgqaVar5, zzgqaVar6, zzgqaVar7, zzgqaVar8, zzgqaVar9, zzgqaVar10};
    }

    private zzgqa(String str, int i4, Class cls, Class cls2, Object obj) {
        this.zzl = cls;
        this.zzm = cls2;
        this.zzn = obj;
    }

    public static zzgqa[] values() {
        return (zzgqa[]) zzk.clone();
    }

    public final Class zza() {
        return this.zzm;
    }
}
