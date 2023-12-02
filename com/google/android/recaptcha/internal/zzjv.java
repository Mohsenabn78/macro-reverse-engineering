package com.google.android.recaptcha.internal;

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
/* compiled from: com.google.android.recaptcha:recaptcha@@18.1.2 */
/* loaded from: classes5.dex */
public final class zzjv {
    public static final zzjv zza;
    public static final zzjv zzb;
    public static final zzjv zzc;
    public static final zzjv zzd;
    public static final zzjv zze;
    public static final zzjv zzf;
    public static final zzjv zzg;
    public static final zzjv zzh;
    public static final zzjv zzi;
    public static final zzjv zzj;
    public static final zzjv zzk;
    public static final zzjv zzl;
    public static final zzjv zzm;
    public static final zzjv zzn;
    public static final zzjv zzo;
    public static final zzjv zzp;
    public static final zzjv zzq;
    public static final zzjv zzr;
    private static final /* synthetic */ zzjv[] zzs;
    private final zzjw zzt;

    static {
        zzjv zzjvVar = new zzjv("DOUBLE", 0, zzjw.DOUBLE, 1);
        zza = zzjvVar;
        zzjv zzjvVar2 = new zzjv("FLOAT", 1, zzjw.FLOAT, 5);
        zzb = zzjvVar2;
        zzjw zzjwVar = zzjw.LONG;
        zzjv zzjvVar3 = new zzjv("INT64", 2, zzjwVar, 0);
        zzc = zzjvVar3;
        zzjv zzjvVar4 = new zzjv("UINT64", 3, zzjwVar, 0);
        zzd = zzjvVar4;
        zzjw zzjwVar2 = zzjw.INT;
        zzjv zzjvVar5 = new zzjv("INT32", 4, zzjwVar2, 0);
        zze = zzjvVar5;
        zzjv zzjvVar6 = new zzjv("FIXED64", 5, zzjwVar, 1);
        zzf = zzjvVar6;
        zzjv zzjvVar7 = new zzjv("FIXED32", 6, zzjwVar2, 5);
        zzg = zzjvVar7;
        zzjv zzjvVar8 = new zzjv("BOOL", 7, zzjw.BOOLEAN, 0);
        zzh = zzjvVar8;
        zzjv zzjvVar9 = new zzjv("STRING", 8, zzjw.STRING, 2);
        zzi = zzjvVar9;
        zzjw zzjwVar3 = zzjw.MESSAGE;
        zzjv zzjvVar10 = new zzjv("GROUP", 9, zzjwVar3, 3);
        zzj = zzjvVar10;
        zzjv zzjvVar11 = new zzjv("MESSAGE", 10, zzjwVar3, 2);
        zzk = zzjvVar11;
        zzjv zzjvVar12 = new zzjv("BYTES", 11, zzjw.BYTE_STRING, 2);
        zzl = zzjvVar12;
        zzjv zzjvVar13 = new zzjv("UINT32", 12, zzjwVar2, 0);
        zzm = zzjvVar13;
        zzjv zzjvVar14 = new zzjv("ENUM", 13, zzjw.ENUM, 0);
        zzn = zzjvVar14;
        zzjv zzjvVar15 = new zzjv("SFIXED32", 14, zzjwVar2, 5);
        zzo = zzjvVar15;
        zzjv zzjvVar16 = new zzjv("SFIXED64", 15, zzjwVar, 1);
        zzp = zzjvVar16;
        zzjv zzjvVar17 = new zzjv("SINT32", 16, zzjwVar2, 0);
        zzq = zzjvVar17;
        zzjv zzjvVar18 = new zzjv("SINT64", 17, zzjwVar, 0);
        zzr = zzjvVar18;
        zzs = new zzjv[]{zzjvVar, zzjvVar2, zzjvVar3, zzjvVar4, zzjvVar5, zzjvVar6, zzjvVar7, zzjvVar8, zzjvVar9, zzjvVar10, zzjvVar11, zzjvVar12, zzjvVar13, zzjvVar14, zzjvVar15, zzjvVar16, zzjvVar17, zzjvVar18};
    }

    private zzjv(String str, int i4, zzjw zzjwVar, int i5) {
        this.zzt = zzjwVar;
    }

    public static zzjv[] values() {
        return (zzjv[]) zzs.clone();
    }

    public final zzjw zza() {
        return this.zzt;
    }
}
