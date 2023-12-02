package com.google.android.gms.internal.measurement;

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
/* compiled from: com.google.android.gms:play-services-measurement-base@@21.3.0 */
/* loaded from: classes4.dex */
public final class zzkt {
    public static final zzkt zzA;
    public static final zzkt zzB;
    public static final zzkt zzC;
    public static final zzkt zzD;
    public static final zzkt zzE;
    public static final zzkt zzF;
    public static final zzkt zzG;
    public static final zzkt zzH;
    public static final zzkt zzI;
    public static final zzkt zzJ;
    public static final zzkt zzK;
    public static final zzkt zzL;
    public static final zzkt zzM;
    public static final zzkt zzN;
    public static final zzkt zzO;
    public static final zzkt zzP;
    public static final zzkt zzQ;
    public static final zzkt zzR;
    public static final zzkt zzS;
    public static final zzkt zzT;
    public static final zzkt zzU;
    public static final zzkt zzV;
    public static final zzkt zzW;
    public static final zzkt zzX;
    public static final zzkt zzY;
    private static final zzkt[] zzZ;
    public static final zzkt zza;
    private static final /* synthetic */ zzkt[] zzaa;
    public static final zzkt zzb;
    public static final zzkt zzc;
    public static final zzkt zzd;
    public static final zzkt zze;
    public static final zzkt zzf;
    public static final zzkt zzg;
    public static final zzkt zzh;
    public static final zzkt zzi;
    public static final zzkt zzj;
    public static final zzkt zzk;
    public static final zzkt zzl;
    public static final zzkt zzm;
    public static final zzkt zzn;
    public static final zzkt zzo;
    public static final zzkt zzp;
    public static final zzkt zzq;
    public static final zzkt zzr;
    public static final zzkt zzs;
    public static final zzkt zzt;
    public static final zzkt zzu;
    public static final zzkt zzv;
    public static final zzkt zzw;
    public static final zzkt zzx;
    public static final zzkt zzy;
    public static final zzkt zzz;
    private final zzlm zzab;
    private final int zzac;
    private final Class zzad;

    static {
        zzlm zzlmVar = zzlm.zze;
        zzkt zzktVar = new zzkt("DOUBLE", 0, 0, 1, zzlmVar);
        zza = zzktVar;
        zzlm zzlmVar2 = zzlm.zzd;
        zzkt zzktVar2 = new zzkt("FLOAT", 1, 1, 1, zzlmVar2);
        zzb = zzktVar2;
        zzlm zzlmVar3 = zzlm.zzc;
        zzkt zzktVar3 = new zzkt("INT64", 2, 2, 1, zzlmVar3);
        zzc = zzktVar3;
        zzkt zzktVar4 = new zzkt("UINT64", 3, 3, 1, zzlmVar3);
        zzd = zzktVar4;
        zzlm zzlmVar4 = zzlm.zzb;
        zzkt zzktVar5 = new zzkt("INT32", 4, 4, 1, zzlmVar4);
        zze = zzktVar5;
        zzkt zzktVar6 = new zzkt("FIXED64", 5, 5, 1, zzlmVar3);
        zzf = zzktVar6;
        zzkt zzktVar7 = new zzkt("FIXED32", 6, 6, 1, zzlmVar4);
        zzg = zzktVar7;
        zzlm zzlmVar5 = zzlm.zzf;
        zzkt zzktVar8 = new zzkt("BOOL", 7, 7, 1, zzlmVar5);
        zzh = zzktVar8;
        zzlm zzlmVar6 = zzlm.zzg;
        zzkt zzktVar9 = new zzkt("STRING", 8, 8, 1, zzlmVar6);
        zzi = zzktVar9;
        zzlm zzlmVar7 = zzlm.zzj;
        zzkt zzktVar10 = new zzkt("MESSAGE", 9, 9, 1, zzlmVar7);
        zzj = zzktVar10;
        zzlm zzlmVar8 = zzlm.zzh;
        zzkt zzktVar11 = new zzkt("BYTES", 10, 10, 1, zzlmVar8);
        zzk = zzktVar11;
        zzkt zzktVar12 = new zzkt("UINT32", 11, 11, 1, zzlmVar4);
        zzl = zzktVar12;
        zzlm zzlmVar9 = zzlm.zzi;
        zzkt zzktVar13 = new zzkt("ENUM", 12, 12, 1, zzlmVar9);
        zzm = zzktVar13;
        zzkt zzktVar14 = new zzkt("SFIXED32", 13, 13, 1, zzlmVar4);
        zzn = zzktVar14;
        zzkt zzktVar15 = new zzkt("SFIXED64", 14, 14, 1, zzlmVar3);
        zzo = zzktVar15;
        zzkt zzktVar16 = new zzkt("SINT32", 15, 15, 1, zzlmVar4);
        zzp = zzktVar16;
        zzkt zzktVar17 = new zzkt("SINT64", 16, 16, 1, zzlmVar3);
        zzq = zzktVar17;
        zzkt zzktVar18 = new zzkt("GROUP", 17, 17, 1, zzlmVar7);
        zzr = zzktVar18;
        zzkt zzktVar19 = new zzkt("DOUBLE_LIST", 18, 18, 2, zzlmVar);
        zzs = zzktVar19;
        zzkt zzktVar20 = new zzkt("FLOAT_LIST", 19, 19, 2, zzlmVar2);
        zzt = zzktVar20;
        zzkt zzktVar21 = new zzkt("INT64_LIST", 20, 20, 2, zzlmVar3);
        zzu = zzktVar21;
        zzkt zzktVar22 = new zzkt("UINT64_LIST", 21, 21, 2, zzlmVar3);
        zzv = zzktVar22;
        zzkt zzktVar23 = new zzkt("INT32_LIST", 22, 22, 2, zzlmVar4);
        zzw = zzktVar23;
        zzkt zzktVar24 = new zzkt("FIXED64_LIST", 23, 23, 2, zzlmVar3);
        zzx = zzktVar24;
        zzkt zzktVar25 = new zzkt("FIXED32_LIST", 24, 24, 2, zzlmVar4);
        zzy = zzktVar25;
        zzkt zzktVar26 = new zzkt("BOOL_LIST", 25, 25, 2, zzlmVar5);
        zzz = zzktVar26;
        zzkt zzktVar27 = new zzkt("STRING_LIST", 26, 26, 2, zzlmVar6);
        zzA = zzktVar27;
        zzkt zzktVar28 = new zzkt("MESSAGE_LIST", 27, 27, 2, zzlmVar7);
        zzB = zzktVar28;
        zzkt zzktVar29 = new zzkt("BYTES_LIST", 28, 28, 2, zzlmVar8);
        zzC = zzktVar29;
        zzkt zzktVar30 = new zzkt("UINT32_LIST", 29, 29, 2, zzlmVar4);
        zzD = zzktVar30;
        zzkt zzktVar31 = new zzkt("ENUM_LIST", 30, 30, 2, zzlmVar9);
        zzE = zzktVar31;
        zzkt zzktVar32 = new zzkt("SFIXED32_LIST", 31, 31, 2, zzlmVar4);
        zzF = zzktVar32;
        zzkt zzktVar33 = new zzkt("SFIXED64_LIST", 32, 32, 2, zzlmVar3);
        zzG = zzktVar33;
        zzkt zzktVar34 = new zzkt("SINT32_LIST", 33, 33, 2, zzlmVar4);
        zzH = zzktVar34;
        zzkt zzktVar35 = new zzkt("SINT64_LIST", 34, 34, 2, zzlmVar3);
        zzI = zzktVar35;
        zzkt zzktVar36 = new zzkt("DOUBLE_LIST_PACKED", 35, 35, 3, zzlmVar);
        zzJ = zzktVar36;
        zzkt zzktVar37 = new zzkt("FLOAT_LIST_PACKED", 36, 36, 3, zzlmVar2);
        zzK = zzktVar37;
        zzkt zzktVar38 = new zzkt("INT64_LIST_PACKED", 37, 37, 3, zzlmVar3);
        zzL = zzktVar38;
        zzkt zzktVar39 = new zzkt("UINT64_LIST_PACKED", 38, 38, 3, zzlmVar3);
        zzM = zzktVar39;
        zzkt zzktVar40 = new zzkt("INT32_LIST_PACKED", 39, 39, 3, zzlmVar4);
        zzN = zzktVar40;
        zzkt zzktVar41 = new zzkt("FIXED64_LIST_PACKED", 40, 40, 3, zzlmVar3);
        zzO = zzktVar41;
        zzkt zzktVar42 = new zzkt("FIXED32_LIST_PACKED", 41, 41, 3, zzlmVar4);
        zzP = zzktVar42;
        zzkt zzktVar43 = new zzkt("BOOL_LIST_PACKED", 42, 42, 3, zzlmVar5);
        zzQ = zzktVar43;
        zzkt zzktVar44 = new zzkt("UINT32_LIST_PACKED", 43, 43, 3, zzlmVar4);
        zzR = zzktVar44;
        zzkt zzktVar45 = new zzkt("ENUM_LIST_PACKED", 44, 44, 3, zzlmVar9);
        zzS = zzktVar45;
        zzkt zzktVar46 = new zzkt("SFIXED32_LIST_PACKED", 45, 45, 3, zzlmVar4);
        zzT = zzktVar46;
        zzkt zzktVar47 = new zzkt("SFIXED64_LIST_PACKED", 46, 46, 3, zzlmVar3);
        zzU = zzktVar47;
        zzkt zzktVar48 = new zzkt("SINT32_LIST_PACKED", 47, 47, 3, zzlmVar4);
        zzV = zzktVar48;
        zzkt zzktVar49 = new zzkt("SINT64_LIST_PACKED", 48, 48, 3, zzlmVar3);
        zzW = zzktVar49;
        zzkt zzktVar50 = new zzkt("GROUP_LIST", 49, 49, 2, zzlmVar7);
        zzX = zzktVar50;
        zzkt zzktVar51 = new zzkt("MAP", 50, 50, 4, zzlm.zza);
        zzY = zzktVar51;
        zzaa = new zzkt[]{zzktVar, zzktVar2, zzktVar3, zzktVar4, zzktVar5, zzktVar6, zzktVar7, zzktVar8, zzktVar9, zzktVar10, zzktVar11, zzktVar12, zzktVar13, zzktVar14, zzktVar15, zzktVar16, zzktVar17, zzktVar18, zzktVar19, zzktVar20, zzktVar21, zzktVar22, zzktVar23, zzktVar24, zzktVar25, zzktVar26, zzktVar27, zzktVar28, zzktVar29, zzktVar30, zzktVar31, zzktVar32, zzktVar33, zzktVar34, zzktVar35, zzktVar36, zzktVar37, zzktVar38, zzktVar39, zzktVar40, zzktVar41, zzktVar42, zzktVar43, zzktVar44, zzktVar45, zzktVar46, zzktVar47, zzktVar48, zzktVar49, zzktVar50, zzktVar51};
        zzkt[] values = values();
        zzZ = new zzkt[values.length];
        for (zzkt zzktVar52 : values) {
            zzZ[zzktVar52.zzac] = zzktVar52;
        }
    }

    private zzkt(String str, int i4, int i5, int i6, zzlm zzlmVar) {
        this.zzac = i5;
        this.zzab = zzlmVar;
        zzlm zzlmVar2 = zzlm.zza;
        int i7 = i6 - 1;
        if (i7 != 1) {
            if (i7 != 3) {
                this.zzad = null;
            } else {
                this.zzad = zzlmVar.zza();
            }
        } else {
            this.zzad = zzlmVar.zza();
        }
        if (i6 == 1) {
            zzlmVar.ordinal();
        }
    }

    public static zzkt[] values() {
        return (zzkt[]) zzaa.clone();
    }

    public final int zza() {
        return this.zzac;
    }
}
