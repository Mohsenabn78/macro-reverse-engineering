package com.google.android.gms.internal.play_billing;

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
/* compiled from: com.android.billingclient:billing@@5.2.0 */
/* loaded from: classes4.dex */
public final class zzew {
    public static final zzew zza;
    public static final zzew zzb;
    public static final zzew zzc;
    public static final zzew zzd;
    public static final zzew zze;
    public static final zzew zzf;
    public static final zzew zzg;
    public static final zzew zzh;
    public static final zzew zzi;
    public static final zzew zzj;
    public static final zzew zzk;
    public static final zzew zzl;
    public static final zzew zzm;
    public static final zzew zzn;
    public static final zzew zzo;
    public static final zzew zzp;
    public static final zzew zzq;
    public static final zzew zzr;
    private static final /* synthetic */ zzew[] zzs;
    private final zzex zzt;

    static {
        zzew zzewVar = new zzew("DOUBLE", 0, zzex.DOUBLE, 1);
        zza = zzewVar;
        zzew zzewVar2 = new zzew("FLOAT", 1, zzex.FLOAT, 5);
        zzb = zzewVar2;
        zzex zzexVar = zzex.LONG;
        zzew zzewVar3 = new zzew("INT64", 2, zzexVar, 0);
        zzc = zzewVar3;
        zzew zzewVar4 = new zzew("UINT64", 3, zzexVar, 0);
        zzd = zzewVar4;
        zzex zzexVar2 = zzex.INT;
        zzew zzewVar5 = new zzew("INT32", 4, zzexVar2, 0);
        zze = zzewVar5;
        zzew zzewVar6 = new zzew("FIXED64", 5, zzexVar, 1);
        zzf = zzewVar6;
        zzew zzewVar7 = new zzew("FIXED32", 6, zzexVar2, 5);
        zzg = zzewVar7;
        zzew zzewVar8 = new zzew("BOOL", 7, zzex.BOOLEAN, 0);
        zzh = zzewVar8;
        zzew zzewVar9 = new zzew("STRING", 8, zzex.STRING, 2);
        zzi = zzewVar9;
        zzex zzexVar3 = zzex.MESSAGE;
        zzew zzewVar10 = new zzew("GROUP", 9, zzexVar3, 3);
        zzj = zzewVar10;
        zzew zzewVar11 = new zzew("MESSAGE", 10, zzexVar3, 2);
        zzk = zzewVar11;
        zzew zzewVar12 = new zzew("BYTES", 11, zzex.BYTE_STRING, 2);
        zzl = zzewVar12;
        zzew zzewVar13 = new zzew("UINT32", 12, zzexVar2, 0);
        zzm = zzewVar13;
        zzew zzewVar14 = new zzew("ENUM", 13, zzex.ENUM, 0);
        zzn = zzewVar14;
        zzew zzewVar15 = new zzew("SFIXED32", 14, zzexVar2, 5);
        zzo = zzewVar15;
        zzew zzewVar16 = new zzew("SFIXED64", 15, zzexVar, 1);
        zzp = zzewVar16;
        zzew zzewVar17 = new zzew("SINT32", 16, zzexVar2, 0);
        zzq = zzewVar17;
        zzew zzewVar18 = new zzew("SINT64", 17, zzexVar, 0);
        zzr = zzewVar18;
        zzs = new zzew[]{zzewVar, zzewVar2, zzewVar3, zzewVar4, zzewVar5, zzewVar6, zzewVar7, zzewVar8, zzewVar9, zzewVar10, zzewVar11, zzewVar12, zzewVar13, zzewVar14, zzewVar15, zzewVar16, zzewVar17, zzewVar18};
    }

    private zzew(String str, int i4, zzex zzexVar, int i5) {
        this.zzt = zzexVar;
    }

    public static zzew[] values() {
        return (zzew[]) zzs.clone();
    }

    public final zzex zza() {
        return this.zzt;
    }
}
