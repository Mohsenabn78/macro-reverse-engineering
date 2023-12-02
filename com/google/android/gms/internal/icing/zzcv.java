package com.google.android.gms.internal.icing;

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
/* compiled from: com.google.firebase:firebase-appindexing@@20.0.0 */
/* loaded from: classes4.dex */
public final class zzcv {
    public static final zzcv zzA;
    public static final zzcv zzB;
    public static final zzcv zzC;
    public static final zzcv zzD;
    public static final zzcv zzE;
    public static final zzcv zzF;
    public static final zzcv zzG;
    public static final zzcv zzH;
    public static final zzcv zzI;
    public static final zzcv zzJ;
    public static final zzcv zzK;
    public static final zzcv zzL;
    public static final zzcv zzM;
    public static final zzcv zzN;
    public static final zzcv zzO;
    public static final zzcv zzP;
    public static final zzcv zzQ;
    public static final zzcv zzR;
    public static final zzcv zzS;
    public static final zzcv zzT;
    public static final zzcv zzU;
    public static final zzcv zzV;
    public static final zzcv zzW;
    public static final zzcv zzX;
    public static final zzcv zzY;
    public static final zzcv zza;
    private static final zzcv[] zzac;
    private static final /* synthetic */ zzcv[] zzad;
    public static final zzcv zzb;
    public static final zzcv zzc;
    public static final zzcv zzd;
    public static final zzcv zze;
    public static final zzcv zzf;
    public static final zzcv zzg;
    public static final zzcv zzh;
    public static final zzcv zzi;
    public static final zzcv zzj;
    public static final zzcv zzk;
    public static final zzcv zzl;
    public static final zzcv zzm;
    public static final zzcv zzn;
    public static final zzcv zzo;
    public static final zzcv zzp;
    public static final zzcv zzq;
    public static final zzcv zzr;
    public static final zzcv zzs;
    public static final zzcv zzt;
    public static final zzcv zzu;
    public static final zzcv zzv;
    public static final zzcv zzw;
    public static final zzcv zzx;
    public static final zzcv zzy;
    public static final zzcv zzz;
    private final zzdk zzZ;
    private final int zzaa;
    private final Class<?> zzab;

    static {
        zzdk zzdkVar = zzdk.zze;
        zzcv zzcvVar = new zzcv("DOUBLE", 0, 0, 1, zzdkVar);
        zza = zzcvVar;
        zzdk zzdkVar2 = zzdk.zzd;
        zzcv zzcvVar2 = new zzcv("FLOAT", 1, 1, 1, zzdkVar2);
        zzb = zzcvVar2;
        zzdk zzdkVar3 = zzdk.zzc;
        zzcv zzcvVar3 = new zzcv("INT64", 2, 2, 1, zzdkVar3);
        zzc = zzcvVar3;
        zzcv zzcvVar4 = new zzcv("UINT64", 3, 3, 1, zzdkVar3);
        zzd = zzcvVar4;
        zzdk zzdkVar4 = zzdk.zzb;
        zzcv zzcvVar5 = new zzcv("INT32", 4, 4, 1, zzdkVar4);
        zze = zzcvVar5;
        zzcv zzcvVar6 = new zzcv("FIXED64", 5, 5, 1, zzdkVar3);
        zzf = zzcvVar6;
        zzcv zzcvVar7 = new zzcv("FIXED32", 6, 6, 1, zzdkVar4);
        zzg = zzcvVar7;
        zzdk zzdkVar5 = zzdk.zzf;
        zzcv zzcvVar8 = new zzcv("BOOL", 7, 7, 1, zzdkVar5);
        zzh = zzcvVar8;
        zzdk zzdkVar6 = zzdk.zzg;
        zzcv zzcvVar9 = new zzcv("STRING", 8, 8, 1, zzdkVar6);
        zzi = zzcvVar9;
        zzdk zzdkVar7 = zzdk.zzj;
        zzcv zzcvVar10 = new zzcv("MESSAGE", 9, 9, 1, zzdkVar7);
        zzj = zzcvVar10;
        zzdk zzdkVar8 = zzdk.zzh;
        zzcv zzcvVar11 = new zzcv("BYTES", 10, 10, 1, zzdkVar8);
        zzk = zzcvVar11;
        zzcv zzcvVar12 = new zzcv("UINT32", 11, 11, 1, zzdkVar4);
        zzl = zzcvVar12;
        zzdk zzdkVar9 = zzdk.zzi;
        zzcv zzcvVar13 = new zzcv("ENUM", 12, 12, 1, zzdkVar9);
        zzm = zzcvVar13;
        zzcv zzcvVar14 = new zzcv("SFIXED32", 13, 13, 1, zzdkVar4);
        zzn = zzcvVar14;
        zzcv zzcvVar15 = new zzcv("SFIXED64", 14, 14, 1, zzdkVar3);
        zzo = zzcvVar15;
        zzcv zzcvVar16 = new zzcv("SINT32", 15, 15, 1, zzdkVar4);
        zzp = zzcvVar16;
        zzcv zzcvVar17 = new zzcv("SINT64", 16, 16, 1, zzdkVar3);
        zzq = zzcvVar17;
        zzcv zzcvVar18 = new zzcv("GROUP", 17, 17, 1, zzdkVar7);
        zzr = zzcvVar18;
        zzcv zzcvVar19 = new zzcv("DOUBLE_LIST", 18, 18, 2, zzdkVar);
        zzs = zzcvVar19;
        zzcv zzcvVar20 = new zzcv("FLOAT_LIST", 19, 19, 2, zzdkVar2);
        zzt = zzcvVar20;
        zzcv zzcvVar21 = new zzcv("INT64_LIST", 20, 20, 2, zzdkVar3);
        zzu = zzcvVar21;
        zzcv zzcvVar22 = new zzcv("UINT64_LIST", 21, 21, 2, zzdkVar3);
        zzv = zzcvVar22;
        zzcv zzcvVar23 = new zzcv("INT32_LIST", 22, 22, 2, zzdkVar4);
        zzw = zzcvVar23;
        zzcv zzcvVar24 = new zzcv("FIXED64_LIST", 23, 23, 2, zzdkVar3);
        zzx = zzcvVar24;
        zzcv zzcvVar25 = new zzcv("FIXED32_LIST", 24, 24, 2, zzdkVar4);
        zzy = zzcvVar25;
        zzcv zzcvVar26 = new zzcv("BOOL_LIST", 25, 25, 2, zzdkVar5);
        zzz = zzcvVar26;
        zzcv zzcvVar27 = new zzcv("STRING_LIST", 26, 26, 2, zzdkVar6);
        zzA = zzcvVar27;
        zzcv zzcvVar28 = new zzcv("MESSAGE_LIST", 27, 27, 2, zzdkVar7);
        zzB = zzcvVar28;
        zzcv zzcvVar29 = new zzcv("BYTES_LIST", 28, 28, 2, zzdkVar8);
        zzC = zzcvVar29;
        zzcv zzcvVar30 = new zzcv("UINT32_LIST", 29, 29, 2, zzdkVar4);
        zzD = zzcvVar30;
        zzcv zzcvVar31 = new zzcv("ENUM_LIST", 30, 30, 2, zzdkVar9);
        zzE = zzcvVar31;
        zzcv zzcvVar32 = new zzcv("SFIXED32_LIST", 31, 31, 2, zzdkVar4);
        zzF = zzcvVar32;
        zzcv zzcvVar33 = new zzcv("SFIXED64_LIST", 32, 32, 2, zzdkVar3);
        zzG = zzcvVar33;
        zzcv zzcvVar34 = new zzcv("SINT32_LIST", 33, 33, 2, zzdkVar4);
        zzH = zzcvVar34;
        zzcv zzcvVar35 = new zzcv("SINT64_LIST", 34, 34, 2, zzdkVar3);
        zzI = zzcvVar35;
        zzcv zzcvVar36 = new zzcv("DOUBLE_LIST_PACKED", 35, 35, 3, zzdkVar);
        zzJ = zzcvVar36;
        zzcv zzcvVar37 = new zzcv("FLOAT_LIST_PACKED", 36, 36, 3, zzdkVar2);
        zzK = zzcvVar37;
        zzcv zzcvVar38 = new zzcv("INT64_LIST_PACKED", 37, 37, 3, zzdkVar3);
        zzL = zzcvVar38;
        zzcv zzcvVar39 = new zzcv("UINT64_LIST_PACKED", 38, 38, 3, zzdkVar3);
        zzM = zzcvVar39;
        zzcv zzcvVar40 = new zzcv("INT32_LIST_PACKED", 39, 39, 3, zzdkVar4);
        zzN = zzcvVar40;
        zzcv zzcvVar41 = new zzcv("FIXED64_LIST_PACKED", 40, 40, 3, zzdkVar3);
        zzO = zzcvVar41;
        zzcv zzcvVar42 = new zzcv("FIXED32_LIST_PACKED", 41, 41, 3, zzdkVar4);
        zzP = zzcvVar42;
        zzcv zzcvVar43 = new zzcv("BOOL_LIST_PACKED", 42, 42, 3, zzdkVar5);
        zzQ = zzcvVar43;
        zzcv zzcvVar44 = new zzcv("UINT32_LIST_PACKED", 43, 43, 3, zzdkVar4);
        zzR = zzcvVar44;
        zzcv zzcvVar45 = new zzcv("ENUM_LIST_PACKED", 44, 44, 3, zzdkVar9);
        zzS = zzcvVar45;
        zzcv zzcvVar46 = new zzcv("SFIXED32_LIST_PACKED", 45, 45, 3, zzdkVar4);
        zzT = zzcvVar46;
        zzcv zzcvVar47 = new zzcv("SFIXED64_LIST_PACKED", 46, 46, 3, zzdkVar3);
        zzU = zzcvVar47;
        zzcv zzcvVar48 = new zzcv("SINT32_LIST_PACKED", 47, 47, 3, zzdkVar4);
        zzV = zzcvVar48;
        zzcv zzcvVar49 = new zzcv("SINT64_LIST_PACKED", 48, 48, 3, zzdkVar3);
        zzW = zzcvVar49;
        zzcv zzcvVar50 = new zzcv("GROUP_LIST", 49, 49, 2, zzdkVar7);
        zzX = zzcvVar50;
        zzcv zzcvVar51 = new zzcv("MAP", 50, 50, 4, zzdk.zza);
        zzY = zzcvVar51;
        zzad = new zzcv[]{zzcvVar, zzcvVar2, zzcvVar3, zzcvVar4, zzcvVar5, zzcvVar6, zzcvVar7, zzcvVar8, zzcvVar9, zzcvVar10, zzcvVar11, zzcvVar12, zzcvVar13, zzcvVar14, zzcvVar15, zzcvVar16, zzcvVar17, zzcvVar18, zzcvVar19, zzcvVar20, zzcvVar21, zzcvVar22, zzcvVar23, zzcvVar24, zzcvVar25, zzcvVar26, zzcvVar27, zzcvVar28, zzcvVar29, zzcvVar30, zzcvVar31, zzcvVar32, zzcvVar33, zzcvVar34, zzcvVar35, zzcvVar36, zzcvVar37, zzcvVar38, zzcvVar39, zzcvVar40, zzcvVar41, zzcvVar42, zzcvVar43, zzcvVar44, zzcvVar45, zzcvVar46, zzcvVar47, zzcvVar48, zzcvVar49, zzcvVar50, zzcvVar51};
        zzcv[] values = values();
        zzac = new zzcv[values.length];
        for (zzcv zzcvVar52 : values) {
            zzac[zzcvVar52.zzaa] = zzcvVar52;
        }
    }

    private zzcv(String str, int i4, int i5, int i6, zzdk zzdkVar) {
        this.zzaa = i5;
        this.zzZ = zzdkVar;
        zzdk zzdkVar2 = zzdk.zza;
        int i7 = i6 - 1;
        if (i7 != 1) {
            if (i7 != 3) {
                this.zzab = null;
            } else {
                this.zzab = zzdkVar.zza();
            }
        } else {
            this.zzab = zzdkVar.zza();
        }
        if (i6 == 1) {
            zzdkVar.ordinal();
        }
    }

    public static zzcv[] values() {
        return (zzcv[]) zzad.clone();
    }

    public final int zza() {
        return this.zzaa;
    }
}
