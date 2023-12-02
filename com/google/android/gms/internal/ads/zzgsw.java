package com.google.android.gms.internal.ads;

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
/* compiled from: com.google.android.gms:play-services-ads@@22.3.0 */
/* loaded from: classes4.dex */
public final class zzgsw {
    public static final zzgsw zza;
    public static final zzgsw zzb;
    public static final zzgsw zzc;
    public static final zzgsw zzd;
    public static final zzgsw zze;
    public static final zzgsw zzf;
    public static final zzgsw zzg;
    public static final zzgsw zzh;
    public static final zzgsw zzi;
    public static final zzgsw zzj;
    public static final zzgsw zzk;
    public static final zzgsw zzl;
    public static final zzgsw zzm;
    public static final zzgsw zzn;
    public static final zzgsw zzo;
    public static final zzgsw zzp;
    public static final zzgsw zzq;
    public static final zzgsw zzr;
    private static final /* synthetic */ zzgsw[] zzs;
    private final zzgsx zzt;

    static {
        zzgsw zzgswVar = new zzgsw("DOUBLE", 0, zzgsx.DOUBLE, 1);
        zza = zzgswVar;
        zzgsw zzgswVar2 = new zzgsw("FLOAT", 1, zzgsx.FLOAT, 5);
        zzb = zzgswVar2;
        zzgsx zzgsxVar = zzgsx.LONG;
        zzgsw zzgswVar3 = new zzgsw("INT64", 2, zzgsxVar, 0);
        zzc = zzgswVar3;
        zzgsw zzgswVar4 = new zzgsw("UINT64", 3, zzgsxVar, 0);
        zzd = zzgswVar4;
        zzgsx zzgsxVar2 = zzgsx.INT;
        zzgsw zzgswVar5 = new zzgsw("INT32", 4, zzgsxVar2, 0);
        zze = zzgswVar5;
        zzgsw zzgswVar6 = new zzgsw("FIXED64", 5, zzgsxVar, 1);
        zzf = zzgswVar6;
        zzgsw zzgswVar7 = new zzgsw("FIXED32", 6, zzgsxVar2, 5);
        zzg = zzgswVar7;
        zzgsw zzgswVar8 = new zzgsw("BOOL", 7, zzgsx.BOOLEAN, 0);
        zzh = zzgswVar8;
        zzgsw zzgswVar9 = new zzgsw("STRING", 8, zzgsx.STRING, 2);
        zzi = zzgswVar9;
        zzgsx zzgsxVar3 = zzgsx.MESSAGE;
        zzgsw zzgswVar10 = new zzgsw("GROUP", 9, zzgsxVar3, 3);
        zzj = zzgswVar10;
        zzgsw zzgswVar11 = new zzgsw("MESSAGE", 10, zzgsxVar3, 2);
        zzk = zzgswVar11;
        zzgsw zzgswVar12 = new zzgsw("BYTES", 11, zzgsx.BYTE_STRING, 2);
        zzl = zzgswVar12;
        zzgsw zzgswVar13 = new zzgsw("UINT32", 12, zzgsxVar2, 0);
        zzm = zzgswVar13;
        zzgsw zzgswVar14 = new zzgsw("ENUM", 13, zzgsx.ENUM, 0);
        zzn = zzgswVar14;
        zzgsw zzgswVar15 = new zzgsw("SFIXED32", 14, zzgsxVar2, 5);
        zzo = zzgswVar15;
        zzgsw zzgswVar16 = new zzgsw("SFIXED64", 15, zzgsxVar, 1);
        zzp = zzgswVar16;
        zzgsw zzgswVar17 = new zzgsw("SINT32", 16, zzgsxVar2, 0);
        zzq = zzgswVar17;
        zzgsw zzgswVar18 = new zzgsw("SINT64", 17, zzgsxVar, 0);
        zzr = zzgswVar18;
        zzs = new zzgsw[]{zzgswVar, zzgswVar2, zzgswVar3, zzgswVar4, zzgswVar5, zzgswVar6, zzgswVar7, zzgswVar8, zzgswVar9, zzgswVar10, zzgswVar11, zzgswVar12, zzgswVar13, zzgswVar14, zzgswVar15, zzgswVar16, zzgswVar17, zzgswVar18};
    }

    private zzgsw(String str, int i4, zzgsx zzgsxVar, int i5) {
        this.zzt = zzgsxVar;
    }

    public static zzgsw[] values() {
        return (zzgsw[]) zzs.clone();
    }

    public final zzgsx zza() {
        return this.zzt;
    }
}
