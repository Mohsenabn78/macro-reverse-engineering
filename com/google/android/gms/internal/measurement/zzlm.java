package com.google.android.gms.internal.measurement;

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
/* compiled from: com.google.android.gms:play-services-measurement-base@@21.3.0 */
/* loaded from: classes4.dex */
public final class zzlm {
    public static final zzlm zza;
    public static final zzlm zzb;
    public static final zzlm zzc;
    public static final zzlm zzd;
    public static final zzlm zze;
    public static final zzlm zzf;
    public static final zzlm zzg;
    public static final zzlm zzh;
    public static final zzlm zzi;
    public static final zzlm zzj;
    private static final /* synthetic */ zzlm[] zzk;
    private final Class zzl;
    private final Class zzm;
    private final Object zzn;

    static {
        zzlm zzlmVar = new zzlm("VOID", 0, Void.class, Void.class, null);
        zza = zzlmVar;
        Class cls = Integer.TYPE;
        zzlm zzlmVar2 = new zzlm("INT", 1, cls, Integer.class, 0);
        zzb = zzlmVar2;
        zzlm zzlmVar3 = new zzlm("LONG", 2, Long.TYPE, Long.class, 0L);
        zzc = zzlmVar3;
        zzlm zzlmVar4 = new zzlm("FLOAT", 3, Float.TYPE, Float.class, Float.valueOf(0.0f));
        zzd = zzlmVar4;
        zzlm zzlmVar5 = new zzlm("DOUBLE", 4, Double.TYPE, Double.class, Double.valueOf((double) FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE));
        zze = zzlmVar5;
        zzlm zzlmVar6 = new zzlm("BOOLEAN", 5, Boolean.TYPE, Boolean.class, Boolean.FALSE);
        zzf = zzlmVar6;
        zzlm zzlmVar7 = new zzlm("STRING", 6, String.class, String.class, "");
        zzg = zzlmVar7;
        zzlm zzlmVar8 = new zzlm("BYTE_STRING", 7, zzka.class, zzka.class, zzka.zzb);
        zzh = zzlmVar8;
        zzlm zzlmVar9 = new zzlm("ENUM", 8, cls, Integer.class, null);
        zzi = zzlmVar9;
        zzlm zzlmVar10 = new zzlm("MESSAGE", 9, Object.class, Object.class, null);
        zzj = zzlmVar10;
        zzk = new zzlm[]{zzlmVar, zzlmVar2, zzlmVar3, zzlmVar4, zzlmVar5, zzlmVar6, zzlmVar7, zzlmVar8, zzlmVar9, zzlmVar10};
    }

    private zzlm(String str, int i4, Class cls, Class cls2, Object obj) {
        this.zzl = cls;
        this.zzm = cls2;
        this.zzn = obj;
    }

    public static zzlm[] values() {
        return (zzlm[]) zzk.clone();
    }

    public final Class zza() {
        return this.zzm;
    }
}
