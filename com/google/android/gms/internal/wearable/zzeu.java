package com.google.android.gms.internal.wearable;

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
/* compiled from: com.google.android.gms:play-services-wearable@@18.0.0 */
/* loaded from: classes4.dex */
public final class zzeu {
    public static final zzeu zza;
    public static final zzeu zzb;
    public static final zzeu zzc;
    public static final zzeu zzd;
    public static final zzeu zze;
    public static final zzeu zzf;
    public static final zzeu zzg;
    public static final zzeu zzh;
    public static final zzeu zzi;
    public static final zzeu zzj;
    public static final zzeu zzk;
    public static final zzeu zzl;
    public static final zzeu zzm;
    public static final zzeu zzn;
    public static final zzeu zzo;
    public static final zzeu zzp;
    public static final zzeu zzq;
    public static final zzeu zzr;
    private static final /* synthetic */ zzeu[] zzs;
    private final zzev zzt;

    static {
        zzeu zzeuVar = new zzeu("DOUBLE", 0, zzev.DOUBLE, 1);
        zza = zzeuVar;
        zzeu zzeuVar2 = new zzeu("FLOAT", 1, zzev.FLOAT, 5);
        zzb = zzeuVar2;
        zzev zzevVar = zzev.LONG;
        zzeu zzeuVar3 = new zzeu("INT64", 2, zzevVar, 0);
        zzc = zzeuVar3;
        zzeu zzeuVar4 = new zzeu("UINT64", 3, zzevVar, 0);
        zzd = zzeuVar4;
        zzev zzevVar2 = zzev.INT;
        zzeu zzeuVar5 = new zzeu("INT32", 4, zzevVar2, 0);
        zze = zzeuVar5;
        zzeu zzeuVar6 = new zzeu("FIXED64", 5, zzevVar, 1);
        zzf = zzeuVar6;
        zzeu zzeuVar7 = new zzeu("FIXED32", 6, zzevVar2, 5);
        zzg = zzeuVar7;
        zzeu zzeuVar8 = new zzeu("BOOL", 7, zzev.BOOLEAN, 0);
        zzh = zzeuVar8;
        zzeu zzeuVar9 = new zzeu("STRING", 8, zzev.STRING, 2);
        zzi = zzeuVar9;
        zzev zzevVar3 = zzev.MESSAGE;
        zzeu zzeuVar10 = new zzeu("GROUP", 9, zzevVar3, 3);
        zzj = zzeuVar10;
        zzeu zzeuVar11 = new zzeu("MESSAGE", 10, zzevVar3, 2);
        zzk = zzeuVar11;
        zzeu zzeuVar12 = new zzeu("BYTES", 11, zzev.BYTE_STRING, 2);
        zzl = zzeuVar12;
        zzeu zzeuVar13 = new zzeu("UINT32", 12, zzevVar2, 0);
        zzm = zzeuVar13;
        zzeu zzeuVar14 = new zzeu("ENUM", 13, zzev.ENUM, 0);
        zzn = zzeuVar14;
        zzeu zzeuVar15 = new zzeu("SFIXED32", 14, zzevVar2, 5);
        zzo = zzeuVar15;
        zzeu zzeuVar16 = new zzeu("SFIXED64", 15, zzevVar, 1);
        zzp = zzeuVar16;
        zzeu zzeuVar17 = new zzeu("SINT32", 16, zzevVar2, 0);
        zzq = zzeuVar17;
        zzeu zzeuVar18 = new zzeu("SINT64", 17, zzevVar, 0);
        zzr = zzeuVar18;
        zzs = new zzeu[]{zzeuVar, zzeuVar2, zzeuVar3, zzeuVar4, zzeuVar5, zzeuVar6, zzeuVar7, zzeuVar8, zzeuVar9, zzeuVar10, zzeuVar11, zzeuVar12, zzeuVar13, zzeuVar14, zzeuVar15, zzeuVar16, zzeuVar17, zzeuVar18};
    }

    private zzeu(String str, int i4, zzev zzevVar, int i5) {
        this.zzt = zzevVar;
    }

    public static zzeu[] values() {
        return (zzeu[]) zzs.clone();
    }

    public final zzev zza() {
        return this.zzt;
    }
}
