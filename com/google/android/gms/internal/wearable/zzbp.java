package com.google.android.gms.internal.wearable;

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
/* compiled from: com.google.android.gms:play-services-wearable@@18.0.0 */
/* loaded from: classes4.dex */
public final class zzbp {
    public static final zzbp zzA;
    public static final zzbp zzB;
    public static final zzbp zzC;
    public static final zzbp zzD;
    public static final zzbp zzE;
    public static final zzbp zzF;
    public static final zzbp zzG;
    public static final zzbp zzH;
    public static final zzbp zzI;
    public static final zzbp zzJ;
    public static final zzbp zzK;
    public static final zzbp zzL;
    public static final zzbp zzM;
    public static final zzbp zzN;
    public static final zzbp zzO;
    public static final zzbp zzP;
    public static final zzbp zzQ;
    public static final zzbp zzR;
    public static final zzbp zzS;
    public static final zzbp zzT;
    public static final zzbp zzU;
    public static final zzbp zzV;
    public static final zzbp zzW;
    public static final zzbp zzX;
    public static final zzbp zzY;
    private static final zzbp[] zzZ;
    public static final zzbp zza;
    private static final /* synthetic */ zzbp[] zzaa;
    public static final zzbp zzb;
    public static final zzbp zzc;
    public static final zzbp zzd;
    public static final zzbp zze;
    public static final zzbp zzf;
    public static final zzbp zzg;
    public static final zzbp zzh;
    public static final zzbp zzi;
    public static final zzbp zzj;
    public static final zzbp zzk;
    public static final zzbp zzl;
    public static final zzbp zzm;
    public static final zzbp zzn;
    public static final zzbp zzo;
    public static final zzbp zzp;
    public static final zzbp zzq;
    public static final zzbp zzr;
    public static final zzbp zzs;
    public static final zzbp zzt;
    public static final zzbp zzu;
    public static final zzbp zzv;
    public static final zzbp zzw;
    public static final zzbp zzx;
    public static final zzbp zzy;
    public static final zzbp zzz;
    private final zzcg zzab;
    private final int zzac;
    private final Class zzad;

    static {
        zzcg zzcgVar = zzcg.zze;
        zzbp zzbpVar = new zzbp("DOUBLE", 0, 0, 1, zzcgVar);
        zza = zzbpVar;
        zzcg zzcgVar2 = zzcg.zzd;
        zzbp zzbpVar2 = new zzbp("FLOAT", 1, 1, 1, zzcgVar2);
        zzb = zzbpVar2;
        zzcg zzcgVar3 = zzcg.zzc;
        zzbp zzbpVar3 = new zzbp("INT64", 2, 2, 1, zzcgVar3);
        zzc = zzbpVar3;
        zzbp zzbpVar4 = new zzbp("UINT64", 3, 3, 1, zzcgVar3);
        zzd = zzbpVar4;
        zzcg zzcgVar4 = zzcg.zzb;
        zzbp zzbpVar5 = new zzbp("INT32", 4, 4, 1, zzcgVar4);
        zze = zzbpVar5;
        zzbp zzbpVar6 = new zzbp("FIXED64", 5, 5, 1, zzcgVar3);
        zzf = zzbpVar6;
        zzbp zzbpVar7 = new zzbp("FIXED32", 6, 6, 1, zzcgVar4);
        zzg = zzbpVar7;
        zzcg zzcgVar5 = zzcg.zzf;
        zzbp zzbpVar8 = new zzbp("BOOL", 7, 7, 1, zzcgVar5);
        zzh = zzbpVar8;
        zzcg zzcgVar6 = zzcg.zzg;
        zzbp zzbpVar9 = new zzbp("STRING", 8, 8, 1, zzcgVar6);
        zzi = zzbpVar9;
        zzcg zzcgVar7 = zzcg.zzj;
        zzbp zzbpVar10 = new zzbp("MESSAGE", 9, 9, 1, zzcgVar7);
        zzj = zzbpVar10;
        zzcg zzcgVar8 = zzcg.zzh;
        zzbp zzbpVar11 = new zzbp("BYTES", 10, 10, 1, zzcgVar8);
        zzk = zzbpVar11;
        zzbp zzbpVar12 = new zzbp("UINT32", 11, 11, 1, zzcgVar4);
        zzl = zzbpVar12;
        zzcg zzcgVar9 = zzcg.zzi;
        zzbp zzbpVar13 = new zzbp("ENUM", 12, 12, 1, zzcgVar9);
        zzm = zzbpVar13;
        zzbp zzbpVar14 = new zzbp("SFIXED32", 13, 13, 1, zzcgVar4);
        zzn = zzbpVar14;
        zzbp zzbpVar15 = new zzbp("SFIXED64", 14, 14, 1, zzcgVar3);
        zzo = zzbpVar15;
        zzbp zzbpVar16 = new zzbp("SINT32", 15, 15, 1, zzcgVar4);
        zzp = zzbpVar16;
        zzbp zzbpVar17 = new zzbp("SINT64", 16, 16, 1, zzcgVar3);
        zzq = zzbpVar17;
        zzbp zzbpVar18 = new zzbp("GROUP", 17, 17, 1, zzcgVar7);
        zzr = zzbpVar18;
        zzbp zzbpVar19 = new zzbp("DOUBLE_LIST", 18, 18, 2, zzcgVar);
        zzs = zzbpVar19;
        zzbp zzbpVar20 = new zzbp("FLOAT_LIST", 19, 19, 2, zzcgVar2);
        zzt = zzbpVar20;
        zzbp zzbpVar21 = new zzbp("INT64_LIST", 20, 20, 2, zzcgVar3);
        zzu = zzbpVar21;
        zzbp zzbpVar22 = new zzbp("UINT64_LIST", 21, 21, 2, zzcgVar3);
        zzv = zzbpVar22;
        zzbp zzbpVar23 = new zzbp("INT32_LIST", 22, 22, 2, zzcgVar4);
        zzw = zzbpVar23;
        zzbp zzbpVar24 = new zzbp("FIXED64_LIST", 23, 23, 2, zzcgVar3);
        zzx = zzbpVar24;
        zzbp zzbpVar25 = new zzbp("FIXED32_LIST", 24, 24, 2, zzcgVar4);
        zzy = zzbpVar25;
        zzbp zzbpVar26 = new zzbp("BOOL_LIST", 25, 25, 2, zzcgVar5);
        zzz = zzbpVar26;
        zzbp zzbpVar27 = new zzbp("STRING_LIST", 26, 26, 2, zzcgVar6);
        zzA = zzbpVar27;
        zzbp zzbpVar28 = new zzbp("MESSAGE_LIST", 27, 27, 2, zzcgVar7);
        zzB = zzbpVar28;
        zzbp zzbpVar29 = new zzbp("BYTES_LIST", 28, 28, 2, zzcgVar8);
        zzC = zzbpVar29;
        zzbp zzbpVar30 = new zzbp("UINT32_LIST", 29, 29, 2, zzcgVar4);
        zzD = zzbpVar30;
        zzbp zzbpVar31 = new zzbp("ENUM_LIST", 30, 30, 2, zzcgVar9);
        zzE = zzbpVar31;
        zzbp zzbpVar32 = new zzbp("SFIXED32_LIST", 31, 31, 2, zzcgVar4);
        zzF = zzbpVar32;
        zzbp zzbpVar33 = new zzbp("SFIXED64_LIST", 32, 32, 2, zzcgVar3);
        zzG = zzbpVar33;
        zzbp zzbpVar34 = new zzbp("SINT32_LIST", 33, 33, 2, zzcgVar4);
        zzH = zzbpVar34;
        zzbp zzbpVar35 = new zzbp("SINT64_LIST", 34, 34, 2, zzcgVar3);
        zzI = zzbpVar35;
        zzbp zzbpVar36 = new zzbp("DOUBLE_LIST_PACKED", 35, 35, 3, zzcgVar);
        zzJ = zzbpVar36;
        zzbp zzbpVar37 = new zzbp("FLOAT_LIST_PACKED", 36, 36, 3, zzcgVar2);
        zzK = zzbpVar37;
        zzbp zzbpVar38 = new zzbp("INT64_LIST_PACKED", 37, 37, 3, zzcgVar3);
        zzL = zzbpVar38;
        zzbp zzbpVar39 = new zzbp("UINT64_LIST_PACKED", 38, 38, 3, zzcgVar3);
        zzM = zzbpVar39;
        zzbp zzbpVar40 = new zzbp("INT32_LIST_PACKED", 39, 39, 3, zzcgVar4);
        zzN = zzbpVar40;
        zzbp zzbpVar41 = new zzbp("FIXED64_LIST_PACKED", 40, 40, 3, zzcgVar3);
        zzO = zzbpVar41;
        zzbp zzbpVar42 = new zzbp("FIXED32_LIST_PACKED", 41, 41, 3, zzcgVar4);
        zzP = zzbpVar42;
        zzbp zzbpVar43 = new zzbp("BOOL_LIST_PACKED", 42, 42, 3, zzcgVar5);
        zzQ = zzbpVar43;
        zzbp zzbpVar44 = new zzbp("UINT32_LIST_PACKED", 43, 43, 3, zzcgVar4);
        zzR = zzbpVar44;
        zzbp zzbpVar45 = new zzbp("ENUM_LIST_PACKED", 44, 44, 3, zzcgVar9);
        zzS = zzbpVar45;
        zzbp zzbpVar46 = new zzbp("SFIXED32_LIST_PACKED", 45, 45, 3, zzcgVar4);
        zzT = zzbpVar46;
        zzbp zzbpVar47 = new zzbp("SFIXED64_LIST_PACKED", 46, 46, 3, zzcgVar3);
        zzU = zzbpVar47;
        zzbp zzbpVar48 = new zzbp("SINT32_LIST_PACKED", 47, 47, 3, zzcgVar4);
        zzV = zzbpVar48;
        zzbp zzbpVar49 = new zzbp("SINT64_LIST_PACKED", 48, 48, 3, zzcgVar3);
        zzW = zzbpVar49;
        zzbp zzbpVar50 = new zzbp("GROUP_LIST", 49, 49, 2, zzcgVar7);
        zzX = zzbpVar50;
        zzbp zzbpVar51 = new zzbp("MAP", 50, 50, 4, zzcg.zza);
        zzY = zzbpVar51;
        zzaa = new zzbp[]{zzbpVar, zzbpVar2, zzbpVar3, zzbpVar4, zzbpVar5, zzbpVar6, zzbpVar7, zzbpVar8, zzbpVar9, zzbpVar10, zzbpVar11, zzbpVar12, zzbpVar13, zzbpVar14, zzbpVar15, zzbpVar16, zzbpVar17, zzbpVar18, zzbpVar19, zzbpVar20, zzbpVar21, zzbpVar22, zzbpVar23, zzbpVar24, zzbpVar25, zzbpVar26, zzbpVar27, zzbpVar28, zzbpVar29, zzbpVar30, zzbpVar31, zzbpVar32, zzbpVar33, zzbpVar34, zzbpVar35, zzbpVar36, zzbpVar37, zzbpVar38, zzbpVar39, zzbpVar40, zzbpVar41, zzbpVar42, zzbpVar43, zzbpVar44, zzbpVar45, zzbpVar46, zzbpVar47, zzbpVar48, zzbpVar49, zzbpVar50, zzbpVar51};
        zzbp[] values = values();
        zzZ = new zzbp[values.length];
        for (zzbp zzbpVar52 : values) {
            zzZ[zzbpVar52.zzac] = zzbpVar52;
        }
    }

    private zzbp(String str, int i4, int i5, int i6, zzcg zzcgVar) {
        this.zzac = i5;
        this.zzab = zzcgVar;
        zzcg zzcgVar2 = zzcg.zza;
        int i7 = i6 - 1;
        if (i7 != 1) {
            if (i7 != 3) {
                this.zzad = null;
            } else {
                this.zzad = zzcgVar.zza();
            }
        } else {
            this.zzad = zzcgVar.zza();
        }
        if (i6 == 1) {
            zzcgVar.ordinal();
        }
    }

    public static zzbp[] values() {
        return (zzbp[]) zzaa.clone();
    }

    public final int zza() {
        return this.zzac;
    }
}
