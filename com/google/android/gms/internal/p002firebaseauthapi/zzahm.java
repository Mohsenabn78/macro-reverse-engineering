package com.google.android.gms.internal.p002firebaseauthapi;

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
/* compiled from: com.google.firebase:firebase-auth@@22.1.1 */
/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzahm  reason: invalid package */
/* loaded from: classes4.dex */
public final class zzahm {
    public static final zzahm zza;
    public static final zzahm zzb;
    public static final zzahm zzc;
    public static final zzahm zzd;
    public static final zzahm zze;
    public static final zzahm zzf;
    public static final zzahm zzg;
    public static final zzahm zzh;
    public static final zzahm zzi;
    public static final zzahm zzj;
    private static final /* synthetic */ zzahm[] zzk;
    private final Class zzl;
    private final Class zzm;
    private final Object zzn;

    static {
        zzahm zzahmVar = new zzahm("VOID", 0, Void.class, Void.class, null);
        zza = zzahmVar;
        Class cls = Integer.TYPE;
        zzahm zzahmVar2 = new zzahm("INT", 1, cls, Integer.class, 0);
        zzb = zzahmVar2;
        zzahm zzahmVar3 = new zzahm("LONG", 2, Long.TYPE, Long.class, 0L);
        zzc = zzahmVar3;
        zzahm zzahmVar4 = new zzahm("FLOAT", 3, Float.TYPE, Float.class, Float.valueOf(0.0f));
        zzd = zzahmVar4;
        zzahm zzahmVar5 = new zzahm("DOUBLE", 4, Double.TYPE, Double.class, Double.valueOf((double) FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE));
        zze = zzahmVar5;
        zzahm zzahmVar6 = new zzahm("BOOLEAN", 5, Boolean.TYPE, Boolean.class, Boolean.FALSE);
        zzf = zzahmVar6;
        zzahm zzahmVar7 = new zzahm("STRING", 6, String.class, String.class, "");
        zzg = zzahmVar7;
        zzahm zzahmVar8 = new zzahm("BYTE_STRING", 7, zzafy.class, zzafy.class, zzafy.zzb);
        zzh = zzahmVar8;
        zzahm zzahmVar9 = new zzahm("ENUM", 8, cls, Integer.class, null);
        zzi = zzahmVar9;
        zzahm zzahmVar10 = new zzahm("MESSAGE", 9, Object.class, Object.class, null);
        zzj = zzahmVar10;
        zzk = new zzahm[]{zzahmVar, zzahmVar2, zzahmVar3, zzahmVar4, zzahmVar5, zzahmVar6, zzahmVar7, zzahmVar8, zzahmVar9, zzahmVar10};
    }

    private zzahm(String str, int i4, Class cls, Class cls2, Object obj) {
        this.zzl = cls;
        this.zzm = cls2;
        this.zzn = obj;
    }

    public static zzahm[] values() {
        return (zzahm[]) zzk.clone();
    }

    public final Class zza() {
        return this.zzm;
    }
}
