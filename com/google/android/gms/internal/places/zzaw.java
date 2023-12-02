package com.google.android.gms.internal.places;

import java.lang.reflect.Type;

/* JADX WARN: Enum visitor error
jadx.core.utils.exceptions.JadxRuntimeException: Init of enum zzfn uses external variables
	at jadx.core.dex.visitors.EnumVisitor.createEnumFieldByConstructor(EnumVisitor.java:444)
	at jadx.core.dex.visitors.EnumVisitor.processEnumFieldByRegister(EnumVisitor.java:391)
	at jadx.core.dex.visitors.EnumVisitor.extractEnumFieldsFromFilledArray(EnumVisitor.java:320)
	at jadx.core.dex.visitors.EnumVisitor.extractEnumFieldsFromInsn(EnumVisitor.java:258)
	at jadx.core.dex.visitors.EnumVisitor.convertToEnum(EnumVisitor.java:151)
	at jadx.core.dex.visitors.EnumVisitor.visit(EnumVisitor.java:100)
 */
/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* loaded from: classes4.dex */
public final class zzaw {
    private static final zzaw zzfn;
    private static final zzaw zzfo;
    private static final zzaw zzfp;
    private static final zzaw zzfq;
    private static final zzaw zzfr;
    private static final zzaw zzfs;
    private static final zzaw zzft;
    private static final zzaw zzfu;
    private static final zzaw zzfv;
    private static final zzaw zzfw;
    private static final zzaw zzfx;
    private static final zzaw zzfy;
    private static final zzaw zzfz;
    private static final zzaw zzga;
    private static final zzaw zzgb;
    private static final zzaw zzgc;
    private static final zzaw zzgd;
    private static final zzaw zzge;
    private static final zzaw zzgf;
    private static final zzaw zzgg;
    private static final zzaw zzgh;
    private static final zzaw zzgi;
    private static final zzaw zzgj;
    private static final zzaw zzgk;
    private static final zzaw zzgl;
    private static final zzaw zzgm;
    private static final zzaw zzgn;
    private static final zzaw zzgo;
    private static final zzaw zzgp;
    private static final zzaw zzgq;
    private static final zzaw zzgr;
    private static final zzaw zzgs;
    private static final zzaw zzgt;
    private static final zzaw zzgu;
    private static final zzaw zzgv;
    public static final zzaw zzgw;
    private static final zzaw zzgx;
    private static final zzaw zzgy;
    private static final zzaw zzgz;
    private static final zzaw zzha;
    private static final zzaw zzhb;
    private static final zzaw zzhc;
    private static final zzaw zzhd;
    private static final zzaw zzhe;
    private static final zzaw zzhf;
    private static final zzaw zzhg;
    private static final zzaw zzhh;
    private static final zzaw zzhi;
    public static final zzaw zzhj;
    private static final zzaw zzhk;
    private static final zzaw zzhl;
    private static final zzaw[] zzhq;
    private static final Type[] zzhr;
    private static final /* synthetic */ zzaw[] zzhs;
    private final int id;
    private final zzbm zzhm;
    private final zzay zzhn;
    private final Class<?> zzho;
    private final boolean zzhp;

    static {
        zzay zzayVar = zzay.SCALAR;
        zzbm zzbmVar = zzbm.zzjj;
        zzaw zzawVar = new zzaw("DOUBLE", 0, 0, zzayVar, zzbmVar);
        zzfn = zzawVar;
        zzbm zzbmVar2 = zzbm.zzji;
        zzaw zzawVar2 = new zzaw("FLOAT", 1, 1, zzayVar, zzbmVar2);
        zzfo = zzawVar2;
        zzbm zzbmVar3 = zzbm.zzjh;
        zzaw zzawVar3 = new zzaw("INT64", 2, 2, zzayVar, zzbmVar3);
        zzfp = zzawVar3;
        zzaw zzawVar4 = new zzaw("UINT64", 3, 3, zzayVar, zzbmVar3);
        zzfq = zzawVar4;
        zzbm zzbmVar4 = zzbm.zzjg;
        zzaw zzawVar5 = new zzaw("INT32", 4, 4, zzayVar, zzbmVar4);
        zzfr = zzawVar5;
        zzaw zzawVar6 = new zzaw("FIXED64", 5, 5, zzayVar, zzbmVar3);
        zzfs = zzawVar6;
        zzaw zzawVar7 = new zzaw("FIXED32", 6, 6, zzayVar, zzbmVar4);
        zzft = zzawVar7;
        zzbm zzbmVar5 = zzbm.zzjk;
        zzaw zzawVar8 = new zzaw("BOOL", 7, 7, zzayVar, zzbmVar5);
        zzfu = zzawVar8;
        zzbm zzbmVar6 = zzbm.zzjl;
        zzaw zzawVar9 = new zzaw("STRING", 8, 8, zzayVar, zzbmVar6);
        zzfv = zzawVar9;
        zzbm zzbmVar7 = zzbm.zzjo;
        zzaw zzawVar10 = new zzaw("MESSAGE", 9, 9, zzayVar, zzbmVar7);
        zzfw = zzawVar10;
        zzbm zzbmVar8 = zzbm.zzjm;
        zzaw zzawVar11 = new zzaw("BYTES", 10, 10, zzayVar, zzbmVar8);
        zzfx = zzawVar11;
        zzaw zzawVar12 = new zzaw("UINT32", 11, 11, zzayVar, zzbmVar4);
        zzfy = zzawVar12;
        zzbm zzbmVar9 = zzbm.zzjn;
        zzaw zzawVar13 = new zzaw("ENUM", 12, 12, zzayVar, zzbmVar9);
        zzfz = zzawVar13;
        zzaw zzawVar14 = new zzaw("SFIXED32", 13, 13, zzayVar, zzbmVar4);
        zzga = zzawVar14;
        zzaw zzawVar15 = new zzaw("SFIXED64", 14, 14, zzayVar, zzbmVar3);
        zzgb = zzawVar15;
        zzaw zzawVar16 = new zzaw("SINT32", 15, 15, zzayVar, zzbmVar4);
        zzgc = zzawVar16;
        zzaw zzawVar17 = new zzaw("SINT64", 16, 16, zzayVar, zzbmVar3);
        zzgd = zzawVar17;
        zzaw zzawVar18 = new zzaw("GROUP", 17, 17, zzayVar, zzbmVar7);
        zzge = zzawVar18;
        zzay zzayVar2 = zzay.VECTOR;
        zzaw zzawVar19 = new zzaw("DOUBLE_LIST", 18, 18, zzayVar2, zzbmVar);
        zzgf = zzawVar19;
        zzaw zzawVar20 = new zzaw("FLOAT_LIST", 19, 19, zzayVar2, zzbmVar2);
        zzgg = zzawVar20;
        zzaw zzawVar21 = new zzaw("INT64_LIST", 20, 20, zzayVar2, zzbmVar3);
        zzgh = zzawVar21;
        zzaw zzawVar22 = new zzaw("UINT64_LIST", 21, 21, zzayVar2, zzbmVar3);
        zzgi = zzawVar22;
        zzaw zzawVar23 = new zzaw("INT32_LIST", 22, 22, zzayVar2, zzbmVar4);
        zzgj = zzawVar23;
        zzaw zzawVar24 = new zzaw("FIXED64_LIST", 23, 23, zzayVar2, zzbmVar3);
        zzgk = zzawVar24;
        zzaw zzawVar25 = new zzaw("FIXED32_LIST", 24, 24, zzayVar2, zzbmVar4);
        zzgl = zzawVar25;
        zzaw zzawVar26 = new zzaw("BOOL_LIST", 25, 25, zzayVar2, zzbmVar5);
        zzgm = zzawVar26;
        zzaw zzawVar27 = new zzaw("STRING_LIST", 26, 26, zzayVar2, zzbmVar6);
        zzgn = zzawVar27;
        zzaw zzawVar28 = new zzaw("MESSAGE_LIST", 27, 27, zzayVar2, zzbmVar7);
        zzgo = zzawVar28;
        zzaw zzawVar29 = new zzaw("BYTES_LIST", 28, 28, zzayVar2, zzbmVar8);
        zzgp = zzawVar29;
        zzaw zzawVar30 = new zzaw("UINT32_LIST", 29, 29, zzayVar2, zzbmVar4);
        zzgq = zzawVar30;
        zzaw zzawVar31 = new zzaw("ENUM_LIST", 30, 30, zzayVar2, zzbmVar9);
        zzgr = zzawVar31;
        zzaw zzawVar32 = new zzaw("SFIXED32_LIST", 31, 31, zzayVar2, zzbmVar4);
        zzgs = zzawVar32;
        zzaw zzawVar33 = new zzaw("SFIXED64_LIST", 32, 32, zzayVar2, zzbmVar3);
        zzgt = zzawVar33;
        zzaw zzawVar34 = new zzaw("SINT32_LIST", 33, 33, zzayVar2, zzbmVar4);
        zzgu = zzawVar34;
        zzaw zzawVar35 = new zzaw("SINT64_LIST", 34, 34, zzayVar2, zzbmVar3);
        zzgv = zzawVar35;
        zzay zzayVar3 = zzay.PACKED_VECTOR;
        zzaw zzawVar36 = new zzaw("DOUBLE_LIST_PACKED", 35, 35, zzayVar3, zzbmVar);
        zzgw = zzawVar36;
        zzaw zzawVar37 = new zzaw("FLOAT_LIST_PACKED", 36, 36, zzayVar3, zzbmVar2);
        zzgx = zzawVar37;
        zzaw zzawVar38 = new zzaw("INT64_LIST_PACKED", 37, 37, zzayVar3, zzbmVar3);
        zzgy = zzawVar38;
        zzaw zzawVar39 = new zzaw("UINT64_LIST_PACKED", 38, 38, zzayVar3, zzbmVar3);
        zzgz = zzawVar39;
        zzaw zzawVar40 = new zzaw("INT32_LIST_PACKED", 39, 39, zzayVar3, zzbmVar4);
        zzha = zzawVar40;
        zzaw zzawVar41 = new zzaw("FIXED64_LIST_PACKED", 40, 40, zzayVar3, zzbmVar3);
        zzhb = zzawVar41;
        zzaw zzawVar42 = new zzaw("FIXED32_LIST_PACKED", 41, 41, zzayVar3, zzbmVar4);
        zzhc = zzawVar42;
        zzaw zzawVar43 = new zzaw("BOOL_LIST_PACKED", 42, 42, zzayVar3, zzbmVar5);
        zzhd = zzawVar43;
        zzaw zzawVar44 = new zzaw("UINT32_LIST_PACKED", 43, 43, zzayVar3, zzbmVar4);
        zzhe = zzawVar44;
        zzaw zzawVar45 = new zzaw("ENUM_LIST_PACKED", 44, 44, zzayVar3, zzbmVar9);
        zzhf = zzawVar45;
        zzaw zzawVar46 = new zzaw("SFIXED32_LIST_PACKED", 45, 45, zzayVar3, zzbmVar4);
        zzhg = zzawVar46;
        zzaw zzawVar47 = new zzaw("SFIXED64_LIST_PACKED", 46, 46, zzayVar3, zzbmVar3);
        zzhh = zzawVar47;
        zzaw zzawVar48 = new zzaw("SINT32_LIST_PACKED", 47, 47, zzayVar3, zzbmVar4);
        zzhi = zzawVar48;
        zzaw zzawVar49 = new zzaw("SINT64_LIST_PACKED", 48, 48, zzayVar3, zzbmVar3);
        zzhj = zzawVar49;
        zzaw zzawVar50 = new zzaw("GROUP_LIST", 49, 49, zzayVar2, zzbmVar7);
        zzhk = zzawVar50;
        zzaw zzawVar51 = new zzaw("MAP", 50, 50, zzay.MAP, zzbm.zzjf);
        zzhl = zzawVar51;
        zzhs = new zzaw[]{zzawVar, zzawVar2, zzawVar3, zzawVar4, zzawVar5, zzawVar6, zzawVar7, zzawVar8, zzawVar9, zzawVar10, zzawVar11, zzawVar12, zzawVar13, zzawVar14, zzawVar15, zzawVar16, zzawVar17, zzawVar18, zzawVar19, zzawVar20, zzawVar21, zzawVar22, zzawVar23, zzawVar24, zzawVar25, zzawVar26, zzawVar27, zzawVar28, zzawVar29, zzawVar30, zzawVar31, zzawVar32, zzawVar33, zzawVar34, zzawVar35, zzawVar36, zzawVar37, zzawVar38, zzawVar39, zzawVar40, zzawVar41, zzawVar42, zzawVar43, zzawVar44, zzawVar45, zzawVar46, zzawVar47, zzawVar48, zzawVar49, zzawVar50, zzawVar51};
        zzhr = new Type[0];
        zzaw[] values = values();
        zzhq = new zzaw[values.length];
        for (zzaw zzawVar52 : values) {
            zzhq[zzawVar52.id] = zzawVar52;
        }
    }

    private zzaw(String str, int i4, int i5, zzay zzayVar, zzbm zzbmVar) {
        int i6;
        this.id = i5;
        this.zzhn = zzayVar;
        this.zzhm = zzbmVar;
        int i7 = zzaz.zzhz[zzayVar.ordinal()];
        boolean z3 = true;
        if (i7 != 1) {
            if (i7 != 2) {
                this.zzho = null;
            } else {
                this.zzho = zzbmVar.zzbw();
            }
        } else {
            this.zzho = zzbmVar.zzbw();
        }
        this.zzhp = (zzayVar != zzay.SCALAR || (i6 = zzaz.zzia[zzbmVar.ordinal()]) == 1 || i6 == 2 || i6 == 3) ? false : false;
    }

    public static zzaw[] values() {
        return (zzaw[]) zzhs.clone();
    }

    public final int id() {
        return this.id;
    }
}
