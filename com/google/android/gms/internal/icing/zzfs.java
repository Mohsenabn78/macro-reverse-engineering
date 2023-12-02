package com.google.android.gms.internal.icing;

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
/* compiled from: com.google.firebase:firebase-appindexing@@20.0.0 */
/* loaded from: classes4.dex */
public final class zzfs {
    public static final zzfs zza;
    public static final zzfs zzb;
    public static final zzfs zzc;
    public static final zzfs zzd;
    public static final zzfs zze;
    public static final zzfs zzf;
    public static final zzfs zzg;
    public static final zzfs zzh;
    public static final zzfs zzi;
    public static final zzfs zzj;
    public static final zzfs zzk;
    public static final zzfs zzl;
    public static final zzfs zzm;
    public static final zzfs zzn;
    public static final zzfs zzo;
    public static final zzfs zzp;
    public static final zzfs zzq;
    public static final zzfs zzr;
    private static final /* synthetic */ zzfs[] zzt;
    private final zzft zzs;

    static {
        zzfs zzfsVar = new zzfs("DOUBLE", 0, zzft.DOUBLE, 1);
        zza = zzfsVar;
        zzfs zzfsVar2 = new zzfs("FLOAT", 1, zzft.FLOAT, 5);
        zzb = zzfsVar2;
        zzft zzftVar = zzft.LONG;
        zzfs zzfsVar3 = new zzfs("INT64", 2, zzftVar, 0);
        zzc = zzfsVar3;
        zzfs zzfsVar4 = new zzfs("UINT64", 3, zzftVar, 0);
        zzd = zzfsVar4;
        zzft zzftVar2 = zzft.INT;
        zzfs zzfsVar5 = new zzfs("INT32", 4, zzftVar2, 0);
        zze = zzfsVar5;
        zzfs zzfsVar6 = new zzfs("FIXED64", 5, zzftVar, 1);
        zzf = zzfsVar6;
        zzfs zzfsVar7 = new zzfs("FIXED32", 6, zzftVar2, 5);
        zzg = zzfsVar7;
        zzfs zzfsVar8 = new zzfs("BOOL", 7, zzft.BOOLEAN, 0);
        zzh = zzfsVar8;
        zzfs zzfsVar9 = new zzfs("STRING", 8, zzft.STRING, 2);
        zzi = zzfsVar9;
        zzft zzftVar3 = zzft.MESSAGE;
        zzfs zzfsVar10 = new zzfs("GROUP", 9, zzftVar3, 3);
        zzj = zzfsVar10;
        zzfs zzfsVar11 = new zzfs("MESSAGE", 10, zzftVar3, 2);
        zzk = zzfsVar11;
        zzfs zzfsVar12 = new zzfs("BYTES", 11, zzft.BYTE_STRING, 2);
        zzl = zzfsVar12;
        zzfs zzfsVar13 = new zzfs("UINT32", 12, zzftVar2, 0);
        zzm = zzfsVar13;
        zzfs zzfsVar14 = new zzfs("ENUM", 13, zzft.ENUM, 0);
        zzn = zzfsVar14;
        zzfs zzfsVar15 = new zzfs("SFIXED32", 14, zzftVar2, 5);
        zzo = zzfsVar15;
        zzfs zzfsVar16 = new zzfs("SFIXED64", 15, zzftVar, 1);
        zzp = zzfsVar16;
        zzfs zzfsVar17 = new zzfs("SINT32", 16, zzftVar2, 0);
        zzq = zzfsVar17;
        zzfs zzfsVar18 = new zzfs("SINT64", 17, zzftVar, 0);
        zzr = zzfsVar18;
        zzt = new zzfs[]{zzfsVar, zzfsVar2, zzfsVar3, zzfsVar4, zzfsVar5, zzfsVar6, zzfsVar7, zzfsVar8, zzfsVar9, zzfsVar10, zzfsVar11, zzfsVar12, zzfsVar13, zzfsVar14, zzfsVar15, zzfsVar16, zzfsVar17, zzfsVar18};
    }

    private zzfs(String str, int i4, zzft zzftVar, int i5) {
        this.zzs = zzftVar;
    }

    public static zzfs[] values() {
        return (zzfs[]) zzt.clone();
    }

    public final zzft zza() {
        return this.zzs;
    }
}
