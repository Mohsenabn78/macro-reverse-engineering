package com.google.android.gms.internal.p002firebaseauthapi;

/* JADX WARN: Enum visitor error
jadx.core.utils.exceptions.JadxRuntimeException: Init of enum zzc uses external variables
	at jadx.core.dex.visitors.EnumVisitor.createEnumFieldByConstructor(EnumVisitor.java:444)
	at jadx.core.dex.visitors.EnumVisitor.processEnumFieldByRegister(EnumVisitor.java:391)
	at jadx.core.dex.visitors.EnumVisitor.extractEnumFieldsFromFilledArray(EnumVisitor.java:320)
	at jadx.core.dex.visitors.EnumVisitor.extractEnumFieldsFromInsn(EnumVisitor.java:258)
	at jadx.core.dex.visitors.EnumVisitor.convertToEnum(EnumVisitor.java:151)
	at jadx.core.dex.visitors.EnumVisitor.visit(EnumVisitor.java:100)
 */
/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* compiled from: com.google.firebase:firebase-auth@@22.1.1 */
/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzake  reason: invalid package */
/* loaded from: classes4.dex */
public final class zzake {
    public static final zzake zza;
    public static final zzake zzb;
    public static final zzake zzc;
    public static final zzake zzd;
    public static final zzake zze;
    public static final zzake zzf;
    public static final zzake zzg;
    public static final zzake zzh;
    public static final zzake zzi;
    public static final zzake zzj;
    public static final zzake zzk;
    public static final zzake zzl;
    public static final zzake zzm;
    public static final zzake zzn;
    public static final zzake zzo;
    public static final zzake zzp;
    public static final zzake zzq;
    public static final zzake zzr;
    private static final /* synthetic */ zzake[] zzs;
    private final zzakf zzt;

    static {
        zzake zzakeVar = new zzake("DOUBLE", 0, zzakf.DOUBLE, 1);
        zza = zzakeVar;
        zzake zzakeVar2 = new zzake("FLOAT", 1, zzakf.FLOAT, 5);
        zzb = zzakeVar2;
        zzakf zzakfVar = zzakf.LONG;
        zzake zzakeVar3 = new zzake("INT64", 2, zzakfVar, 0);
        zzc = zzakeVar3;
        zzake zzakeVar4 = new zzake("UINT64", 3, zzakfVar, 0);
        zzd = zzakeVar4;
        zzakf zzakfVar2 = zzakf.INT;
        zzake zzakeVar5 = new zzake("INT32", 4, zzakfVar2, 0);
        zze = zzakeVar5;
        zzake zzakeVar6 = new zzake("FIXED64", 5, zzakfVar, 1);
        zzf = zzakeVar6;
        zzake zzakeVar7 = new zzake("FIXED32", 6, zzakfVar2, 5);
        zzg = zzakeVar7;
        zzake zzakeVar8 = new zzake("BOOL", 7, zzakf.BOOLEAN, 0);
        zzh = zzakeVar8;
        zzake zzakeVar9 = new zzake("STRING", 8, zzakf.STRING, 2);
        zzi = zzakeVar9;
        zzakf zzakfVar3 = zzakf.MESSAGE;
        zzake zzakeVar10 = new zzake("GROUP", 9, zzakfVar3, 3);
        zzj = zzakeVar10;
        zzake zzakeVar11 = new zzake("MESSAGE", 10, zzakfVar3, 2);
        zzk = zzakeVar11;
        zzake zzakeVar12 = new zzake("BYTES", 11, zzakf.BYTE_STRING, 2);
        zzl = zzakeVar12;
        zzake zzakeVar13 = new zzake("UINT32", 12, zzakfVar2, 0);
        zzm = zzakeVar13;
        zzake zzakeVar14 = new zzake("ENUM", 13, zzakf.ENUM, 0);
        zzn = zzakeVar14;
        zzake zzakeVar15 = new zzake("SFIXED32", 14, zzakfVar2, 5);
        zzo = zzakeVar15;
        zzake zzakeVar16 = new zzake("SFIXED64", 15, zzakfVar, 1);
        zzp = zzakeVar16;
        zzake zzakeVar17 = new zzake("SINT32", 16, zzakfVar2, 0);
        zzq = zzakeVar17;
        zzake zzakeVar18 = new zzake("SINT64", 17, zzakfVar, 0);
        zzr = zzakeVar18;
        zzs = new zzake[]{zzakeVar, zzakeVar2, zzakeVar3, zzakeVar4, zzakeVar5, zzakeVar6, zzakeVar7, zzakeVar8, zzakeVar9, zzakeVar10, zzakeVar11, zzakeVar12, zzakeVar13, zzakeVar14, zzakeVar15, zzakeVar16, zzakeVar17, zzakeVar18};
    }

    private zzake(String str, int i4, zzakf zzakfVar, int i5) {
        this.zzt = zzakfVar;
    }

    public static zzake[] values() {
        return (zzake[]) zzs.clone();
    }

    public final zzakf zza() {
        return this.zzt;
    }
}
