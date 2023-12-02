package com.google.android.gms.internal.play_billing;

/* JADX WARN: Enum visitor error
jadx.core.utils.exceptions.JadxRuntimeException: Init of enum zza uses external variables
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
public final class zzbt {
    public static final zzbt zzA;
    public static final zzbt zzB;
    public static final zzbt zzC;
    public static final zzbt zzD;
    public static final zzbt zzE;
    public static final zzbt zzF;
    public static final zzbt zzG;
    public static final zzbt zzH;
    public static final zzbt zzI;
    public static final zzbt zzJ;
    public static final zzbt zzK;
    public static final zzbt zzL;
    public static final zzbt zzM;
    public static final zzbt zzN;
    public static final zzbt zzO;
    public static final zzbt zzP;
    public static final zzbt zzQ;
    public static final zzbt zzR;
    public static final zzbt zzS;
    public static final zzbt zzT;
    public static final zzbt zzU;
    public static final zzbt zzV;
    public static final zzbt zzW;
    public static final zzbt zzX;
    public static final zzbt zzY;
    private static final zzbt[] zzZ;
    public static final zzbt zza;
    private static final /* synthetic */ zzbt[] zzaa;
    public static final zzbt zzb;
    public static final zzbt zzc;
    public static final zzbt zzd;
    public static final zzbt zze;
    public static final zzbt zzf;
    public static final zzbt zzg;
    public static final zzbt zzh;
    public static final zzbt zzi;
    public static final zzbt zzj;
    public static final zzbt zzk;
    public static final zzbt zzl;
    public static final zzbt zzm;
    public static final zzbt zzn;
    public static final zzbt zzo;
    public static final zzbt zzp;
    public static final zzbt zzq;
    public static final zzbt zzr;
    public static final zzbt zzs;
    public static final zzbt zzt;
    public static final zzbt zzu;
    public static final zzbt zzv;
    public static final zzbt zzw;
    public static final zzbt zzx;
    public static final zzbt zzy;
    public static final zzbt zzz;
    private final zzcj zzab;
    private final int zzac;
    private final Class zzad;

    static {
        zzcj zzcjVar = zzcj.zze;
        zzbt zzbtVar = new zzbt("DOUBLE", 0, 0, 1, zzcjVar);
        zza = zzbtVar;
        zzcj zzcjVar2 = zzcj.zzd;
        zzbt zzbtVar2 = new zzbt("FLOAT", 1, 1, 1, zzcjVar2);
        zzb = zzbtVar2;
        zzcj zzcjVar3 = zzcj.zzc;
        zzbt zzbtVar3 = new zzbt("INT64", 2, 2, 1, zzcjVar3);
        zzc = zzbtVar3;
        zzbt zzbtVar4 = new zzbt("UINT64", 3, 3, 1, zzcjVar3);
        zzd = zzbtVar4;
        zzcj zzcjVar4 = zzcj.zzb;
        zzbt zzbtVar5 = new zzbt("INT32", 4, 4, 1, zzcjVar4);
        zze = zzbtVar5;
        zzbt zzbtVar6 = new zzbt("FIXED64", 5, 5, 1, zzcjVar3);
        zzf = zzbtVar6;
        zzbt zzbtVar7 = new zzbt("FIXED32", 6, 6, 1, zzcjVar4);
        zzg = zzbtVar7;
        zzcj zzcjVar5 = zzcj.zzf;
        zzbt zzbtVar8 = new zzbt("BOOL", 7, 7, 1, zzcjVar5);
        zzh = zzbtVar8;
        zzcj zzcjVar6 = zzcj.zzg;
        zzbt zzbtVar9 = new zzbt("STRING", 8, 8, 1, zzcjVar6);
        zzi = zzbtVar9;
        zzcj zzcjVar7 = zzcj.zzj;
        zzbt zzbtVar10 = new zzbt("MESSAGE", 9, 9, 1, zzcjVar7);
        zzj = zzbtVar10;
        zzcj zzcjVar8 = zzcj.zzh;
        zzbt zzbtVar11 = new zzbt("BYTES", 10, 10, 1, zzcjVar8);
        zzk = zzbtVar11;
        zzbt zzbtVar12 = new zzbt("UINT32", 11, 11, 1, zzcjVar4);
        zzl = zzbtVar12;
        zzcj zzcjVar9 = zzcj.zzi;
        zzbt zzbtVar13 = new zzbt("ENUM", 12, 12, 1, zzcjVar9);
        zzm = zzbtVar13;
        zzbt zzbtVar14 = new zzbt("SFIXED32", 13, 13, 1, zzcjVar4);
        zzn = zzbtVar14;
        zzbt zzbtVar15 = new zzbt("SFIXED64", 14, 14, 1, zzcjVar3);
        zzo = zzbtVar15;
        zzbt zzbtVar16 = new zzbt("SINT32", 15, 15, 1, zzcjVar4);
        zzp = zzbtVar16;
        zzbt zzbtVar17 = new zzbt("SINT64", 16, 16, 1, zzcjVar3);
        zzq = zzbtVar17;
        zzbt zzbtVar18 = new zzbt("GROUP", 17, 17, 1, zzcjVar7);
        zzr = zzbtVar18;
        zzbt zzbtVar19 = new zzbt("DOUBLE_LIST", 18, 18, 2, zzcjVar);
        zzs = zzbtVar19;
        zzbt zzbtVar20 = new zzbt("FLOAT_LIST", 19, 19, 2, zzcjVar2);
        zzt = zzbtVar20;
        zzbt zzbtVar21 = new zzbt("INT64_LIST", 20, 20, 2, zzcjVar3);
        zzu = zzbtVar21;
        zzbt zzbtVar22 = new zzbt("UINT64_LIST", 21, 21, 2, zzcjVar3);
        zzv = zzbtVar22;
        zzbt zzbtVar23 = new zzbt("INT32_LIST", 22, 22, 2, zzcjVar4);
        zzw = zzbtVar23;
        zzbt zzbtVar24 = new zzbt("FIXED64_LIST", 23, 23, 2, zzcjVar3);
        zzx = zzbtVar24;
        zzbt zzbtVar25 = new zzbt("FIXED32_LIST", 24, 24, 2, zzcjVar4);
        zzy = zzbtVar25;
        zzbt zzbtVar26 = new zzbt("BOOL_LIST", 25, 25, 2, zzcjVar5);
        zzz = zzbtVar26;
        zzbt zzbtVar27 = new zzbt("STRING_LIST", 26, 26, 2, zzcjVar6);
        zzA = zzbtVar27;
        zzbt zzbtVar28 = new zzbt("MESSAGE_LIST", 27, 27, 2, zzcjVar7);
        zzB = zzbtVar28;
        zzbt zzbtVar29 = new zzbt("BYTES_LIST", 28, 28, 2, zzcjVar8);
        zzC = zzbtVar29;
        zzbt zzbtVar30 = new zzbt("UINT32_LIST", 29, 29, 2, zzcjVar4);
        zzD = zzbtVar30;
        zzbt zzbtVar31 = new zzbt("ENUM_LIST", 30, 30, 2, zzcjVar9);
        zzE = zzbtVar31;
        zzbt zzbtVar32 = new zzbt("SFIXED32_LIST", 31, 31, 2, zzcjVar4);
        zzF = zzbtVar32;
        zzbt zzbtVar33 = new zzbt("SFIXED64_LIST", 32, 32, 2, zzcjVar3);
        zzG = zzbtVar33;
        zzbt zzbtVar34 = new zzbt("SINT32_LIST", 33, 33, 2, zzcjVar4);
        zzH = zzbtVar34;
        zzbt zzbtVar35 = new zzbt("SINT64_LIST", 34, 34, 2, zzcjVar3);
        zzI = zzbtVar35;
        zzbt zzbtVar36 = new zzbt("DOUBLE_LIST_PACKED", 35, 35, 3, zzcjVar);
        zzJ = zzbtVar36;
        zzbt zzbtVar37 = new zzbt("FLOAT_LIST_PACKED", 36, 36, 3, zzcjVar2);
        zzK = zzbtVar37;
        zzbt zzbtVar38 = new zzbt("INT64_LIST_PACKED", 37, 37, 3, zzcjVar3);
        zzL = zzbtVar38;
        zzbt zzbtVar39 = new zzbt("UINT64_LIST_PACKED", 38, 38, 3, zzcjVar3);
        zzM = zzbtVar39;
        zzbt zzbtVar40 = new zzbt("INT32_LIST_PACKED", 39, 39, 3, zzcjVar4);
        zzN = zzbtVar40;
        zzbt zzbtVar41 = new zzbt("FIXED64_LIST_PACKED", 40, 40, 3, zzcjVar3);
        zzO = zzbtVar41;
        zzbt zzbtVar42 = new zzbt("FIXED32_LIST_PACKED", 41, 41, 3, zzcjVar4);
        zzP = zzbtVar42;
        zzbt zzbtVar43 = new zzbt("BOOL_LIST_PACKED", 42, 42, 3, zzcjVar5);
        zzQ = zzbtVar43;
        zzbt zzbtVar44 = new zzbt("UINT32_LIST_PACKED", 43, 43, 3, zzcjVar4);
        zzR = zzbtVar44;
        zzbt zzbtVar45 = new zzbt("ENUM_LIST_PACKED", 44, 44, 3, zzcjVar9);
        zzS = zzbtVar45;
        zzbt zzbtVar46 = new zzbt("SFIXED32_LIST_PACKED", 45, 45, 3, zzcjVar4);
        zzT = zzbtVar46;
        zzbt zzbtVar47 = new zzbt("SFIXED64_LIST_PACKED", 46, 46, 3, zzcjVar3);
        zzU = zzbtVar47;
        zzbt zzbtVar48 = new zzbt("SINT32_LIST_PACKED", 47, 47, 3, zzcjVar4);
        zzV = zzbtVar48;
        zzbt zzbtVar49 = new zzbt("SINT64_LIST_PACKED", 48, 48, 3, zzcjVar3);
        zzW = zzbtVar49;
        zzbt zzbtVar50 = new zzbt("GROUP_LIST", 49, 49, 2, zzcjVar7);
        zzX = zzbtVar50;
        zzbt zzbtVar51 = new zzbt("MAP", 50, 50, 4, zzcj.zza);
        zzY = zzbtVar51;
        zzaa = new zzbt[]{zzbtVar, zzbtVar2, zzbtVar3, zzbtVar4, zzbtVar5, zzbtVar6, zzbtVar7, zzbtVar8, zzbtVar9, zzbtVar10, zzbtVar11, zzbtVar12, zzbtVar13, zzbtVar14, zzbtVar15, zzbtVar16, zzbtVar17, zzbtVar18, zzbtVar19, zzbtVar20, zzbtVar21, zzbtVar22, zzbtVar23, zzbtVar24, zzbtVar25, zzbtVar26, zzbtVar27, zzbtVar28, zzbtVar29, zzbtVar30, zzbtVar31, zzbtVar32, zzbtVar33, zzbtVar34, zzbtVar35, zzbtVar36, zzbtVar37, zzbtVar38, zzbtVar39, zzbtVar40, zzbtVar41, zzbtVar42, zzbtVar43, zzbtVar44, zzbtVar45, zzbtVar46, zzbtVar47, zzbtVar48, zzbtVar49, zzbtVar50, zzbtVar51};
        zzbt[] values = values();
        zzZ = new zzbt[values.length];
        for (zzbt zzbtVar52 : values) {
            zzZ[zzbtVar52.zzac] = zzbtVar52;
        }
    }

    private zzbt(String str, int i4, int i5, int i6, zzcj zzcjVar) {
        this.zzac = i5;
        this.zzab = zzcjVar;
        zzcj zzcjVar2 = zzcj.zza;
        int i7 = i6 - 1;
        if (i7 != 1) {
            if (i7 != 3) {
                this.zzad = null;
            } else {
                this.zzad = zzcjVar.zza();
            }
        } else {
            this.zzad = zzcjVar.zza();
        }
        if (i6 == 1) {
            zzcjVar.ordinal();
        }
    }

    public static zzbt[] values() {
        return (zzbt[]) zzaa.clone();
    }

    public final int zza() {
        return this.zzac;
    }
}
