package com.google.android.gms.internal.measurement;

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
/* compiled from: com.google.android.gms:play-services-measurement-base@@21.3.0 */
/* loaded from: classes4.dex */
public final class zzoa {
    public static final zzoa zza;
    public static final zzoa zzb;
    public static final zzoa zzc;
    public static final zzoa zzd;
    public static final zzoa zze;
    public static final zzoa zzf;
    public static final zzoa zzg;
    public static final zzoa zzh;
    public static final zzoa zzi;
    public static final zzoa zzj;
    public static final zzoa zzk;
    public static final zzoa zzl;
    public static final zzoa zzm;
    public static final zzoa zzn;
    public static final zzoa zzo;
    public static final zzoa zzp;
    public static final zzoa zzq;
    public static final zzoa zzr;
    private static final /* synthetic */ zzoa[] zzs;
    private final zzob zzt;

    static {
        zzoa zzoaVar = new zzoa("DOUBLE", 0, zzob.DOUBLE, 1);
        zza = zzoaVar;
        zzoa zzoaVar2 = new zzoa("FLOAT", 1, zzob.FLOAT, 5);
        zzb = zzoaVar2;
        zzob zzobVar = zzob.LONG;
        zzoa zzoaVar3 = new zzoa("INT64", 2, zzobVar, 0);
        zzc = zzoaVar3;
        zzoa zzoaVar4 = new zzoa("UINT64", 3, zzobVar, 0);
        zzd = zzoaVar4;
        zzob zzobVar2 = zzob.INT;
        zzoa zzoaVar5 = new zzoa("INT32", 4, zzobVar2, 0);
        zze = zzoaVar5;
        zzoa zzoaVar6 = new zzoa("FIXED64", 5, zzobVar, 1);
        zzf = zzoaVar6;
        zzoa zzoaVar7 = new zzoa("FIXED32", 6, zzobVar2, 5);
        zzg = zzoaVar7;
        zzoa zzoaVar8 = new zzoa("BOOL", 7, zzob.BOOLEAN, 0);
        zzh = zzoaVar8;
        zzoa zzoaVar9 = new zzoa("STRING", 8, zzob.STRING, 2);
        zzi = zzoaVar9;
        zzob zzobVar3 = zzob.MESSAGE;
        zzoa zzoaVar10 = new zzoa("GROUP", 9, zzobVar3, 3);
        zzj = zzoaVar10;
        zzoa zzoaVar11 = new zzoa("MESSAGE", 10, zzobVar3, 2);
        zzk = zzoaVar11;
        zzoa zzoaVar12 = new zzoa("BYTES", 11, zzob.BYTE_STRING, 2);
        zzl = zzoaVar12;
        zzoa zzoaVar13 = new zzoa("UINT32", 12, zzobVar2, 0);
        zzm = zzoaVar13;
        zzoa zzoaVar14 = new zzoa("ENUM", 13, zzob.ENUM, 0);
        zzn = zzoaVar14;
        zzoa zzoaVar15 = new zzoa("SFIXED32", 14, zzobVar2, 5);
        zzo = zzoaVar15;
        zzoa zzoaVar16 = new zzoa("SFIXED64", 15, zzobVar, 1);
        zzp = zzoaVar16;
        zzoa zzoaVar17 = new zzoa("SINT32", 16, zzobVar2, 0);
        zzq = zzoaVar17;
        zzoa zzoaVar18 = new zzoa("SINT64", 17, zzobVar, 0);
        zzr = zzoaVar18;
        zzs = new zzoa[]{zzoaVar, zzoaVar2, zzoaVar3, zzoaVar4, zzoaVar5, zzoaVar6, zzoaVar7, zzoaVar8, zzoaVar9, zzoaVar10, zzoaVar11, zzoaVar12, zzoaVar13, zzoaVar14, zzoaVar15, zzoaVar16, zzoaVar17, zzoaVar18};
    }

    private zzoa(String str, int i4, zzob zzobVar, int i5) {
        this.zzt = zzobVar;
    }

    public static zzoa[] values() {
        return (zzoa[]) zzs.clone();
    }

    public final zzob zza() {
        return this.zzt;
    }
}
