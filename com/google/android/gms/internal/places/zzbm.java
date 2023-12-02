package com.google.android.gms.internal.places;

import com.google.firebase.remoteconfig.FirebaseRemoteConfig;

/* JADX WARN: Enum visitor error
jadx.core.utils.exceptions.JadxRuntimeException: Init of enum zzjg uses external variables
	at jadx.core.dex.visitors.EnumVisitor.createEnumFieldByConstructor(EnumVisitor.java:444)
	at jadx.core.dex.visitors.EnumVisitor.processEnumFieldByRegister(EnumVisitor.java:391)
	at jadx.core.dex.visitors.EnumVisitor.extractEnumFieldsFromFilledArray(EnumVisitor.java:320)
	at jadx.core.dex.visitors.EnumVisitor.extractEnumFieldsFromInsn(EnumVisitor.java:258)
	at jadx.core.dex.visitors.EnumVisitor.convertToEnum(EnumVisitor.java:151)
	at jadx.core.dex.visitors.EnumVisitor.visit(EnumVisitor.java:100)
 */
/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* loaded from: classes4.dex */
public final class zzbm {
    public static final zzbm zzjf;
    public static final zzbm zzjg;
    public static final zzbm zzjh;
    public static final zzbm zzji;
    public static final zzbm zzjj;
    public static final zzbm zzjk;
    public static final zzbm zzjl;
    public static final zzbm zzjm;
    public static final zzbm zzjn;
    public static final zzbm zzjo;
    private static final /* synthetic */ zzbm[] zzjs;
    private final Class<?> zzjp;
    private final Class<?> zzjq;
    private final Object zzjr;

    static {
        zzbm zzbmVar = new zzbm("VOID", 0, Void.class, Void.class, null);
        zzjf = zzbmVar;
        Class cls = Integer.TYPE;
        zzbm zzbmVar2 = new zzbm("INT", 1, cls, Integer.class, 0);
        zzjg = zzbmVar2;
        zzbm zzbmVar3 = new zzbm("LONG", 2, Long.TYPE, Long.class, 0L);
        zzjh = zzbmVar3;
        zzbm zzbmVar4 = new zzbm("FLOAT", 3, Float.TYPE, Float.class, Float.valueOf(0.0f));
        zzji = zzbmVar4;
        zzbm zzbmVar5 = new zzbm("DOUBLE", 4, Double.TYPE, Double.class, Double.valueOf((double) FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE));
        zzjj = zzbmVar5;
        zzbm zzbmVar6 = new zzbm("BOOLEAN", 5, Boolean.TYPE, Boolean.class, Boolean.FALSE);
        zzjk = zzbmVar6;
        zzbm zzbmVar7 = new zzbm("STRING", 6, String.class, String.class, "");
        zzjl = zzbmVar7;
        zzbm zzbmVar8 = new zzbm("BYTE_STRING", 7, zzw.class, zzw.class, zzw.zzeg);
        zzjm = zzbmVar8;
        zzbm zzbmVar9 = new zzbm("ENUM", 8, cls, Integer.class, null);
        zzjn = zzbmVar9;
        zzbm zzbmVar10 = new zzbm("MESSAGE", 9, Object.class, Object.class, null);
        zzjo = zzbmVar10;
        zzjs = new zzbm[]{zzbmVar, zzbmVar2, zzbmVar3, zzbmVar4, zzbmVar5, zzbmVar6, zzbmVar7, zzbmVar8, zzbmVar9, zzbmVar10};
    }

    private zzbm(String str, int i4, Class cls, Class cls2, Object obj) {
        this.zzjp = cls;
        this.zzjq = cls2;
        this.zzjr = obj;
    }

    public static zzbm[] values() {
        return (zzbm[]) zzjs.clone();
    }

    public final Class<?> zzbw() {
        return this.zzjq;
    }
}
