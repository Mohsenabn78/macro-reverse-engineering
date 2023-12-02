package com.google.android.recaptcha.internal;

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
/* compiled from: com.google.android.recaptcha:recaptcha@@18.1.2 */
/* loaded from: classes5.dex */
public final class zzgz {
    public static final zzgz zza;
    public static final zzgz zzb;
    public static final zzgz zzc;
    public static final zzgz zzd;
    public static final zzgz zze;
    public static final zzgz zzf;
    public static final zzgz zzg;
    public static final zzgz zzh;
    public static final zzgz zzi;
    public static final zzgz zzj;
    private static final /* synthetic */ zzgz[] zzk;
    private final Class zzl;
    private final Class zzm;
    private final Object zzn;

    static {
        zzgz zzgzVar = new zzgz("VOID", 0, Void.class, Void.class, null);
        zza = zzgzVar;
        Class cls = Integer.TYPE;
        zzgz zzgzVar2 = new zzgz("INT", 1, cls, Integer.class, 0);
        zzb = zzgzVar2;
        zzgz zzgzVar3 = new zzgz("LONG", 2, Long.TYPE, Long.class, 0L);
        zzc = zzgzVar3;
        zzgz zzgzVar4 = new zzgz("FLOAT", 3, Float.TYPE, Float.class, Float.valueOf(0.0f));
        zzd = zzgzVar4;
        zzgz zzgzVar5 = new zzgz("DOUBLE", 4, Double.TYPE, Double.class, Double.valueOf((double) FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE));
        zze = zzgzVar5;
        zzgz zzgzVar6 = new zzgz("BOOLEAN", 5, Boolean.TYPE, Boolean.class, Boolean.FALSE);
        zzf = zzgzVar6;
        zzgz zzgzVar7 = new zzgz("STRING", 6, String.class, String.class, "");
        zzg = zzgzVar7;
        zzgz zzgzVar8 = new zzgz("BYTE_STRING", 7, zzez.class, zzez.class, zzez.zzb);
        zzh = zzgzVar8;
        zzgz zzgzVar9 = new zzgz("ENUM", 8, cls, Integer.class, null);
        zzi = zzgzVar9;
        zzgz zzgzVar10 = new zzgz("MESSAGE", 9, Object.class, Object.class, null);
        zzj = zzgzVar10;
        zzk = new zzgz[]{zzgzVar, zzgzVar2, zzgzVar3, zzgzVar4, zzgzVar5, zzgzVar6, zzgzVar7, zzgzVar8, zzgzVar9, zzgzVar10};
    }

    private zzgz(String str, int i4, Class cls, Class cls2, Object obj) {
        this.zzl = cls;
        this.zzm = cls2;
        this.zzn = obj;
    }

    public static zzgz[] values() {
        return (zzgz[]) zzk.clone();
    }

    public final Class zza() {
        return this.zzm;
    }
}
