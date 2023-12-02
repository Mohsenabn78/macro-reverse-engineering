package com.google.android.recaptcha.internal;

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
/* compiled from: com.google.android.recaptcha:recaptcha@@18.1.2 */
/* loaded from: classes5.dex */
public final class zzgf {
    public static final zzgf zzA;
    public static final zzgf zzB;
    public static final zzgf zzC;
    public static final zzgf zzD;
    public static final zzgf zzE;
    public static final zzgf zzF;
    public static final zzgf zzG;
    public static final zzgf zzH;
    public static final zzgf zzI;
    public static final zzgf zzJ;
    public static final zzgf zzK;
    public static final zzgf zzL;
    public static final zzgf zzM;
    public static final zzgf zzN;
    public static final zzgf zzO;
    public static final zzgf zzP;
    public static final zzgf zzQ;
    public static final zzgf zzR;
    public static final zzgf zzS;
    public static final zzgf zzT;
    public static final zzgf zzU;
    public static final zzgf zzV;
    public static final zzgf zzW;
    public static final zzgf zzX;
    public static final zzgf zzY;
    private static final zzgf[] zzZ;
    public static final zzgf zza;
    private static final /* synthetic */ zzgf[] zzaa;
    public static final zzgf zzb;
    public static final zzgf zzc;
    public static final zzgf zzd;
    public static final zzgf zze;
    public static final zzgf zzf;
    public static final zzgf zzg;
    public static final zzgf zzh;
    public static final zzgf zzi;
    public static final zzgf zzj;
    public static final zzgf zzk;
    public static final zzgf zzl;
    public static final zzgf zzm;
    public static final zzgf zzn;
    public static final zzgf zzo;
    public static final zzgf zzp;
    public static final zzgf zzq;
    public static final zzgf zzr;
    public static final zzgf zzs;
    public static final zzgf zzt;
    public static final zzgf zzu;
    public static final zzgf zzv;
    public static final zzgf zzw;
    public static final zzgf zzx;
    public static final zzgf zzy;
    public static final zzgf zzz;
    private final zzgz zzab;
    private final int zzac;
    private final Class zzad;

    static {
        zzgz zzgzVar = zzgz.zze;
        zzgf zzgfVar = new zzgf("DOUBLE", 0, 0, 1, zzgzVar);
        zza = zzgfVar;
        zzgz zzgzVar2 = zzgz.zzd;
        zzgf zzgfVar2 = new zzgf("FLOAT", 1, 1, 1, zzgzVar2);
        zzb = zzgfVar2;
        zzgz zzgzVar3 = zzgz.zzc;
        zzgf zzgfVar3 = new zzgf("INT64", 2, 2, 1, zzgzVar3);
        zzc = zzgfVar3;
        zzgf zzgfVar4 = new zzgf("UINT64", 3, 3, 1, zzgzVar3);
        zzd = zzgfVar4;
        zzgz zzgzVar4 = zzgz.zzb;
        zzgf zzgfVar5 = new zzgf("INT32", 4, 4, 1, zzgzVar4);
        zze = zzgfVar5;
        zzgf zzgfVar6 = new zzgf("FIXED64", 5, 5, 1, zzgzVar3);
        zzf = zzgfVar6;
        zzgf zzgfVar7 = new zzgf("FIXED32", 6, 6, 1, zzgzVar4);
        zzg = zzgfVar7;
        zzgz zzgzVar5 = zzgz.zzf;
        zzgf zzgfVar8 = new zzgf("BOOL", 7, 7, 1, zzgzVar5);
        zzh = zzgfVar8;
        zzgz zzgzVar6 = zzgz.zzg;
        zzgf zzgfVar9 = new zzgf("STRING", 8, 8, 1, zzgzVar6);
        zzi = zzgfVar9;
        zzgz zzgzVar7 = zzgz.zzj;
        zzgf zzgfVar10 = new zzgf("MESSAGE", 9, 9, 1, zzgzVar7);
        zzj = zzgfVar10;
        zzgz zzgzVar8 = zzgz.zzh;
        zzgf zzgfVar11 = new zzgf("BYTES", 10, 10, 1, zzgzVar8);
        zzk = zzgfVar11;
        zzgf zzgfVar12 = new zzgf("UINT32", 11, 11, 1, zzgzVar4);
        zzl = zzgfVar12;
        zzgz zzgzVar9 = zzgz.zzi;
        zzgf zzgfVar13 = new zzgf("ENUM", 12, 12, 1, zzgzVar9);
        zzm = zzgfVar13;
        zzgf zzgfVar14 = new zzgf("SFIXED32", 13, 13, 1, zzgzVar4);
        zzn = zzgfVar14;
        zzgf zzgfVar15 = new zzgf("SFIXED64", 14, 14, 1, zzgzVar3);
        zzo = zzgfVar15;
        zzgf zzgfVar16 = new zzgf("SINT32", 15, 15, 1, zzgzVar4);
        zzp = zzgfVar16;
        zzgf zzgfVar17 = new zzgf("SINT64", 16, 16, 1, zzgzVar3);
        zzq = zzgfVar17;
        zzgf zzgfVar18 = new zzgf("GROUP", 17, 17, 1, zzgzVar7);
        zzr = zzgfVar18;
        zzgf zzgfVar19 = new zzgf("DOUBLE_LIST", 18, 18, 2, zzgzVar);
        zzs = zzgfVar19;
        zzgf zzgfVar20 = new zzgf("FLOAT_LIST", 19, 19, 2, zzgzVar2);
        zzt = zzgfVar20;
        zzgf zzgfVar21 = new zzgf("INT64_LIST", 20, 20, 2, zzgzVar3);
        zzu = zzgfVar21;
        zzgf zzgfVar22 = new zzgf("UINT64_LIST", 21, 21, 2, zzgzVar3);
        zzv = zzgfVar22;
        zzgf zzgfVar23 = new zzgf("INT32_LIST", 22, 22, 2, zzgzVar4);
        zzw = zzgfVar23;
        zzgf zzgfVar24 = new zzgf("FIXED64_LIST", 23, 23, 2, zzgzVar3);
        zzx = zzgfVar24;
        zzgf zzgfVar25 = new zzgf("FIXED32_LIST", 24, 24, 2, zzgzVar4);
        zzy = zzgfVar25;
        zzgf zzgfVar26 = new zzgf("BOOL_LIST", 25, 25, 2, zzgzVar5);
        zzz = zzgfVar26;
        zzgf zzgfVar27 = new zzgf("STRING_LIST", 26, 26, 2, zzgzVar6);
        zzA = zzgfVar27;
        zzgf zzgfVar28 = new zzgf("MESSAGE_LIST", 27, 27, 2, zzgzVar7);
        zzB = zzgfVar28;
        zzgf zzgfVar29 = new zzgf("BYTES_LIST", 28, 28, 2, zzgzVar8);
        zzC = zzgfVar29;
        zzgf zzgfVar30 = new zzgf("UINT32_LIST", 29, 29, 2, zzgzVar4);
        zzD = zzgfVar30;
        zzgf zzgfVar31 = new zzgf("ENUM_LIST", 30, 30, 2, zzgzVar9);
        zzE = zzgfVar31;
        zzgf zzgfVar32 = new zzgf("SFIXED32_LIST", 31, 31, 2, zzgzVar4);
        zzF = zzgfVar32;
        zzgf zzgfVar33 = new zzgf("SFIXED64_LIST", 32, 32, 2, zzgzVar3);
        zzG = zzgfVar33;
        zzgf zzgfVar34 = new zzgf("SINT32_LIST", 33, 33, 2, zzgzVar4);
        zzH = zzgfVar34;
        zzgf zzgfVar35 = new zzgf("SINT64_LIST", 34, 34, 2, zzgzVar3);
        zzI = zzgfVar35;
        zzgf zzgfVar36 = new zzgf("DOUBLE_LIST_PACKED", 35, 35, 3, zzgzVar);
        zzJ = zzgfVar36;
        zzgf zzgfVar37 = new zzgf("FLOAT_LIST_PACKED", 36, 36, 3, zzgzVar2);
        zzK = zzgfVar37;
        zzgf zzgfVar38 = new zzgf("INT64_LIST_PACKED", 37, 37, 3, zzgzVar3);
        zzL = zzgfVar38;
        zzgf zzgfVar39 = new zzgf("UINT64_LIST_PACKED", 38, 38, 3, zzgzVar3);
        zzM = zzgfVar39;
        zzgf zzgfVar40 = new zzgf("INT32_LIST_PACKED", 39, 39, 3, zzgzVar4);
        zzN = zzgfVar40;
        zzgf zzgfVar41 = new zzgf("FIXED64_LIST_PACKED", 40, 40, 3, zzgzVar3);
        zzO = zzgfVar41;
        zzgf zzgfVar42 = new zzgf("FIXED32_LIST_PACKED", 41, 41, 3, zzgzVar4);
        zzP = zzgfVar42;
        zzgf zzgfVar43 = new zzgf("BOOL_LIST_PACKED", 42, 42, 3, zzgzVar5);
        zzQ = zzgfVar43;
        zzgf zzgfVar44 = new zzgf("UINT32_LIST_PACKED", 43, 43, 3, zzgzVar4);
        zzR = zzgfVar44;
        zzgf zzgfVar45 = new zzgf("ENUM_LIST_PACKED", 44, 44, 3, zzgzVar9);
        zzS = zzgfVar45;
        zzgf zzgfVar46 = new zzgf("SFIXED32_LIST_PACKED", 45, 45, 3, zzgzVar4);
        zzT = zzgfVar46;
        zzgf zzgfVar47 = new zzgf("SFIXED64_LIST_PACKED", 46, 46, 3, zzgzVar3);
        zzU = zzgfVar47;
        zzgf zzgfVar48 = new zzgf("SINT32_LIST_PACKED", 47, 47, 3, zzgzVar4);
        zzV = zzgfVar48;
        zzgf zzgfVar49 = new zzgf("SINT64_LIST_PACKED", 48, 48, 3, zzgzVar3);
        zzW = zzgfVar49;
        zzgf zzgfVar50 = new zzgf("GROUP_LIST", 49, 49, 2, zzgzVar7);
        zzX = zzgfVar50;
        zzgf zzgfVar51 = new zzgf("MAP", 50, 50, 4, zzgz.zza);
        zzY = zzgfVar51;
        zzaa = new zzgf[]{zzgfVar, zzgfVar2, zzgfVar3, zzgfVar4, zzgfVar5, zzgfVar6, zzgfVar7, zzgfVar8, zzgfVar9, zzgfVar10, zzgfVar11, zzgfVar12, zzgfVar13, zzgfVar14, zzgfVar15, zzgfVar16, zzgfVar17, zzgfVar18, zzgfVar19, zzgfVar20, zzgfVar21, zzgfVar22, zzgfVar23, zzgfVar24, zzgfVar25, zzgfVar26, zzgfVar27, zzgfVar28, zzgfVar29, zzgfVar30, zzgfVar31, zzgfVar32, zzgfVar33, zzgfVar34, zzgfVar35, zzgfVar36, zzgfVar37, zzgfVar38, zzgfVar39, zzgfVar40, zzgfVar41, zzgfVar42, zzgfVar43, zzgfVar44, zzgfVar45, zzgfVar46, zzgfVar47, zzgfVar48, zzgfVar49, zzgfVar50, zzgfVar51};
        zzgf[] values = values();
        zzZ = new zzgf[values.length];
        for (zzgf zzgfVar52 : values) {
            zzZ[zzgfVar52.zzac] = zzgfVar52;
        }
    }

    private zzgf(String str, int i4, int i5, int i6, zzgz zzgzVar) {
        this.zzac = i5;
        this.zzab = zzgzVar;
        zzgz zzgzVar2 = zzgz.zza;
        int i7 = i6 - 1;
        if (i7 != 1) {
            if (i7 != 3) {
                this.zzad = null;
            } else {
                this.zzad = zzgzVar.zza();
            }
        } else {
            this.zzad = zzgzVar.zza();
        }
        if (i6 == 1) {
            zzgzVar.ordinal();
        }
    }

    public static zzgf[] values() {
        return (zzgf[]) zzaa.clone();
    }

    public final int zza() {
        return this.zzac;
    }
}
