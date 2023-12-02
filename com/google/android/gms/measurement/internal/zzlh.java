package com.google.android.gms.measurement.internal;

import android.content.ContentValues;
import android.content.Context;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.VisibleForTesting;
import androidx.annotation.WorkerThread;
import androidx.collection.ArrayMap;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.Clock;
import com.google.android.gms.common.wrappers.Wrappers;
import com.google.android.gms.internal.measurement.zzop;
import com.google.android.gms.internal.measurement.zzpz;
import com.google.android.gms.internal.measurement.zzqu;
import com.google.android.gms.internal.measurement.zzrd;
import com.google.common.net.HttpHeaders;
import com.google.firebase.messaging.Constants;
import dev.skomlach.biometric.compat.engine.internal.face.miui.impl.Miui3DFaceManagerImpl;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.math.BigInteger;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.FileLock;
import java.nio.channels.OverlappingFileLockException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import kotlinx.coroutines.DebugKt;

/* compiled from: com.google.android.gms:play-services-measurement@@21.3.0 */
/* loaded from: classes4.dex */
public final class zzlh implements zzgy {
    private static volatile zzlh F;
    private final Map A;
    private final Map B;
    private zzir C;
    private String D;

    /* renamed from: a  reason: collision with root package name */
    private final zzfu f22041a;

    /* renamed from: b  reason: collision with root package name */
    private final zzez f22042b;

    /* renamed from: c  reason: collision with root package name */
    private zzak f22043c;

    /* renamed from: d  reason: collision with root package name */
    private zzfb f22044d;

    /* renamed from: e  reason: collision with root package name */
    private zzks f22045e;

    /* renamed from: f  reason: collision with root package name */
    private zzaa f22046f;

    /* renamed from: g  reason: collision with root package name */
    private final zzlj f22047g;

    /* renamed from: h  reason: collision with root package name */
    private zzip f22048h;

    /* renamed from: i  reason: collision with root package name */
    private zzkb f22049i;

    /* renamed from: j  reason: collision with root package name */
    private final zzkw f22050j;

    /* renamed from: k  reason: collision with root package name */
    private zzfl f22051k;

    /* renamed from: l  reason: collision with root package name */
    private final zzgd f22052l;

    /* renamed from: n  reason: collision with root package name */
    private boolean f22054n;
    @VisibleForTesting

    /* renamed from: o  reason: collision with root package name */
    long f22055o;

    /* renamed from: p  reason: collision with root package name */
    private List f22056p;

    /* renamed from: q  reason: collision with root package name */
    private int f22057q;

    /* renamed from: r  reason: collision with root package name */
    private int f22058r;

    /* renamed from: s  reason: collision with root package name */
    private boolean f22059s;

    /* renamed from: t  reason: collision with root package name */
    private boolean f22060t;

    /* renamed from: u  reason: collision with root package name */
    private boolean f22061u;

    /* renamed from: v  reason: collision with root package name */
    private FileLock f22062v;

    /* renamed from: w  reason: collision with root package name */
    private FileChannel f22063w;

    /* renamed from: x  reason: collision with root package name */
    private List f22064x;

    /* renamed from: y  reason: collision with root package name */
    private List f22065y;

    /* renamed from: z  reason: collision with root package name */
    private long f22066z;

    /* renamed from: m  reason: collision with root package name */
    private boolean f22053m = false;
    private final zzlo E = new zzlc(this);

    zzlh(zzli zzliVar, zzgd zzgdVar) {
        Preconditions.checkNotNull(zzliVar);
        this.f22052l = zzgd.zzp(zzliVar.f22067a, null, null);
        this.f22066z = -1L;
        this.f22050j = new zzkw(this);
        zzlj zzljVar = new zzlj(this);
        zzljVar.zzX();
        this.f22047g = zzljVar;
        zzez zzezVar = new zzez(this);
        zzezVar.zzX();
        this.f22042b = zzezVar;
        zzfu zzfuVar = new zzfu(this);
        zzfuVar.zzX();
        this.f22041a = zzfuVar;
        this.A = new HashMap();
        this.B = new HashMap();
        zzaB().zzp(new zzkx(this, zzliVar));
    }

    @VisibleForTesting
    static final void A(com.google.android.gms.internal.measurement.zzfs zzfsVar, int i4, String str) {
        List zzp = zzfsVar.zzp();
        for (int i5 = 0; i5 < zzp.size(); i5++) {
            if ("_err".equals(((com.google.android.gms.internal.measurement.zzfx) zzp.get(i5)).zzg())) {
                return;
            }
        }
        com.google.android.gms.internal.measurement.zzfw zze = com.google.android.gms.internal.measurement.zzfx.zze();
        zze.zzj("_err");
        zze.zzi(Long.valueOf(i4).longValue());
        com.google.android.gms.internal.measurement.zzfw zze2 = com.google.android.gms.internal.measurement.zzfx.zze();
        zze2.zzj("_ev");
        zze2.zzk(str);
        zzfsVar.zzf((com.google.android.gms.internal.measurement.zzfx) zze.zzaD());
        zzfsVar.zzf((com.google.android.gms.internal.measurement.zzfx) zze2.zzaD());
    }

    @VisibleForTesting
    static final void B(com.google.android.gms.internal.measurement.zzfs zzfsVar, @NonNull String str) {
        List zzp = zzfsVar.zzp();
        for (int i4 = 0; i4 < zzp.size(); i4++) {
            if (str.equals(((com.google.android.gms.internal.measurement.zzfx) zzp.get(i4)).zzg())) {
                zzfsVar.zzh(i4);
                return;
            }
        }
    }

    @WorkerThread
    private final zzq C(String str) {
        zzak zzakVar = this.f22043c;
        L(zzakVar);
        zzh I = zzakVar.I(str);
        if (I != null && !TextUtils.isEmpty(I.o0())) {
            Boolean D = D(I);
            if (D != null && !D.booleanValue()) {
                zzaA().zzd().zzb("App version does not match; dropping. appId", zzet.f(str));
                return null;
            }
            String a4 = I.a();
            String o02 = I.o0();
            long R = I.R();
            String n02 = I.n0();
            long c02 = I.c0();
            long Z = I.Z();
            boolean O = I.O();
            String p02 = I.p0();
            I.A();
            return new zzq(str, a4, o02, R, n02, c02, Z, (String) null, O, false, p02, 0L, 0L, 0, I.N(), false, I.j0(), I.i0(), I.a0(), I.e(), (String) null, P(str).zzi(), "", (String) null, I.Q(), I.h0());
        }
        zzaA().zzc().zzb("No app data available; dropping", str);
        return null;
    }

    @WorkerThread
    private final Boolean D(zzh zzhVar) {
        try {
            if (zzhVar.R() != -2147483648L) {
                if (zzhVar.R() == Wrappers.packageManager(this.f22052l.zzaw()).getPackageInfo(zzhVar.l0(), 0).versionCode) {
                    return Boolean.TRUE;
                }
            } else {
                String str = Wrappers.packageManager(this.f22052l.zzaw()).getPackageInfo(zzhVar.l0(), 0).versionName;
                String o02 = zzhVar.o0();
                if (o02 != null && o02.equals(str)) {
                    return Boolean.TRUE;
                }
            }
            return Boolean.FALSE;
        } catch (PackageManager.NameNotFoundException unused) {
            return null;
        }
    }

    @WorkerThread
    private final void E() {
        zzaB().zzg();
        if (!this.f22059s && !this.f22060t && !this.f22061u) {
            zzaA().zzj().zza("Stopping uploading service(s)");
            List<Runnable> list = this.f22056p;
            if (list == null) {
                return;
            }
            for (Runnable runnable : list) {
                runnable.run();
            }
            ((List) Preconditions.checkNotNull(this.f22056p)).clear();
            return;
        }
        zzaA().zzj().zzd("Not stopping services. fetch, network, upload", Boolean.valueOf(this.f22059s), Boolean.valueOf(this.f22060t), Boolean.valueOf(this.f22061u));
    }

    @VisibleForTesting
    private final void F(com.google.android.gms.internal.measurement.zzgc zzgcVar, long j4, boolean z3) {
        String str;
        zzlm zzlmVar;
        String str2;
        zzak zzakVar = this.f22043c;
        L(zzakVar);
        if (true != z3) {
            str = "_lte";
        } else {
            str = "_se";
        }
        zzlm O = zzakVar.O(zzgcVar.zzaq(), str);
        if (O != null && O.f22072e != null) {
            zzlmVar = new zzlm(zzgcVar.zzaq(), DebugKt.DEBUG_PROPERTY_VALUE_AUTO, str, zzax().currentTimeMillis(), Long.valueOf(((Long) O.f22072e).longValue() + j4));
        } else {
            zzlmVar = new zzlm(zzgcVar.zzaq(), DebugKt.DEBUG_PROPERTY_VALUE_AUTO, str, zzax().currentTimeMillis(), Long.valueOf(j4));
        }
        com.google.android.gms.internal.measurement.zzgl zzd = com.google.android.gms.internal.measurement.zzgm.zzd();
        zzd.zzf(str);
        zzd.zzg(zzax().currentTimeMillis());
        zzd.zze(((Long) zzlmVar.f22072e).longValue());
        com.google.android.gms.internal.measurement.zzgm zzgmVar = (com.google.android.gms.internal.measurement.zzgm) zzd.zzaD();
        int o4 = zzlj.o(zzgcVar, str);
        if (o4 >= 0) {
            zzgcVar.zzan(o4, zzgmVar);
        } else {
            zzgcVar.zzm(zzgmVar);
        }
        if (j4 > 0) {
            zzak zzakVar2 = this.f22043c;
            L(zzakVar2);
            zzakVar2.o(zzlmVar);
            if (true != z3) {
                str2 = "lifetime";
            } else {
                str2 = "session-scoped";
            }
            zzaA().zzj().zzc("Updated engagement user property. scope, value", str2, zzlmVar.f22072e);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:52:0x0194  */
    /* JADX WARN: Removed duplicated region for block: B:64:0x0239  */
    @androidx.annotation.WorkerThread
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private final void G() {
        /*
            Method dump skipped, instructions count: 627
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzlh.G():void");
    }

    /* JADX WARN: Code restructure failed: missing block: B:353:0x0b33, code lost:
        if (r10 > (com.google.android.gms.measurement.internal.zzag.zzA() + r8)) goto L384;
     */
    /* JADX WARN: Removed duplicated region for block: B:131:0x0447 A[Catch: all -> 0x0ccc, TryCatch #2 {all -> 0x0ccc, blocks: (B:3:0x000e, B:5:0x0026, B:8:0x002e, B:9:0x0040, B:12:0x0054, B:15:0x007b, B:17:0x00b1, B:20:0x00c3, B:22:0x00cd, B:154:0x04ee, B:24:0x00f7, B:26:0x0105, B:29:0x0125, B:31:0x012b, B:33:0x013d, B:35:0x014b, B:37:0x015b, B:38:0x0168, B:39:0x016d, B:42:0x0186, B:97:0x0383, B:98:0x038f, B:101:0x0399, B:107:0x03bc, B:104:0x03ab, B:129:0x043b, B:131:0x0447, B:134:0x045c, B:136:0x046d, B:138:0x0479, B:153:0x04da, B:141:0x0489, B:143:0x0495, B:146:0x04aa, B:148:0x04bb, B:150:0x04c7, B:111:0x03c4, B:113:0x03d0, B:115:0x03dc, B:127:0x0421, B:119:0x03f9, B:122:0x040b, B:124:0x0411, B:126:0x041b, B:54:0x01c0, B:57:0x01ca, B:59:0x01d8, B:63:0x021f, B:60:0x01f5, B:62:0x0206, B:67:0x022e, B:69:0x025a, B:70:0x0284, B:72:0x02ba, B:74:0x02c0, B:77:0x02cc, B:79:0x0302, B:80:0x031d, B:82:0x0323, B:84:0x0331, B:88:0x0344, B:85:0x0339, B:91:0x034b, B:94:0x0352, B:95:0x036a, B:157:0x0506, B:159:0x0514, B:161:0x051f, B:172:0x0551, B:162:0x0527, B:164:0x0532, B:166:0x0538, B:169:0x0544, B:171:0x054c, B:173:0x0554, B:174:0x0560, B:177:0x0568, B:179:0x057a, B:180:0x0586, B:182:0x058e, B:186:0x05b3, B:188:0x05d8, B:190:0x05e9, B:192:0x05ef, B:194:0x05fb, B:195:0x062c, B:197:0x0632, B:199:0x0640, B:200:0x0644, B:201:0x0647, B:202:0x064a, B:203:0x0658, B:205:0x065e, B:207:0x066e, B:208:0x0675, B:210:0x0681, B:211:0x0688, B:212:0x068b, B:214:0x06cb, B:215:0x06de, B:217:0x06e4, B:220:0x06fe, B:222:0x0719, B:224:0x0732, B:226:0x0737, B:228:0x073b, B:230:0x073f, B:232:0x0749, B:233:0x0753, B:235:0x0757, B:237:0x075d, B:238:0x076b, B:239:0x0774, B:307:0x09c6, B:241:0x0780, B:243:0x0797, B:249:0x07b3, B:251:0x07d7, B:252:0x07df, B:254:0x07e5, B:256:0x07f7, B:263:0x0820, B:264:0x0843, B:266:0x084f, B:268:0x0864, B:270:0x08a5, B:274:0x08bd, B:276:0x08c4, B:278:0x08d3, B:280:0x08d7, B:282:0x08db, B:284:0x08df, B:285:0x08eb, B:286:0x08f0, B:288:0x08f6, B:290:0x0912, B:291:0x0917, B:306:0x09c3, B:292:0x0931, B:294:0x0939, B:298:0x0960, B:300:0x098e, B:301:0x0995, B:302:0x09a7, B:304:0x09b3, B:295:0x0946, B:261:0x080b, B:247:0x079e, B:308:0x09d1, B:310:0x09de, B:311:0x09e4, B:312:0x09ec, B:314:0x09f2, B:316:0x0a08, B:318:0x0a19, B:338:0x0a8d, B:340:0x0a93, B:342:0x0aab, B:345:0x0ab2, B:350:0x0ae1, B:352:0x0b23, B:355:0x0b58, B:356:0x0b5c, B:357:0x0b67, B:359:0x0baa, B:360:0x0bb7, B:362:0x0bc6, B:366:0x0be0, B:368:0x0bf9, B:354:0x0b35, B:346:0x0aba, B:348:0x0ac6, B:349:0x0aca, B:369:0x0c11, B:370:0x0c29, B:373:0x0c31, B:374:0x0c36, B:375:0x0c46, B:377:0x0c60, B:378:0x0c7b, B:379:0x0c84, B:384:0x0ca8, B:383:0x0c95, B:319:0x0a31, B:321:0x0a37, B:323:0x0a41, B:325:0x0a48, B:331:0x0a58, B:333:0x0a5f, B:335:0x0a7e, B:337:0x0a85, B:336:0x0a82, B:332:0x0a5c, B:324:0x0a45, B:183:0x0593, B:185:0x0599, B:387:0x0cba), top: B:397:0x000e, inners: #0, #1, #3, #4 }] */
    /* JADX WARN: Removed duplicated region for block: B:141:0x0489 A[Catch: all -> 0x0ccc, TryCatch #2 {all -> 0x0ccc, blocks: (B:3:0x000e, B:5:0x0026, B:8:0x002e, B:9:0x0040, B:12:0x0054, B:15:0x007b, B:17:0x00b1, B:20:0x00c3, B:22:0x00cd, B:154:0x04ee, B:24:0x00f7, B:26:0x0105, B:29:0x0125, B:31:0x012b, B:33:0x013d, B:35:0x014b, B:37:0x015b, B:38:0x0168, B:39:0x016d, B:42:0x0186, B:97:0x0383, B:98:0x038f, B:101:0x0399, B:107:0x03bc, B:104:0x03ab, B:129:0x043b, B:131:0x0447, B:134:0x045c, B:136:0x046d, B:138:0x0479, B:153:0x04da, B:141:0x0489, B:143:0x0495, B:146:0x04aa, B:148:0x04bb, B:150:0x04c7, B:111:0x03c4, B:113:0x03d0, B:115:0x03dc, B:127:0x0421, B:119:0x03f9, B:122:0x040b, B:124:0x0411, B:126:0x041b, B:54:0x01c0, B:57:0x01ca, B:59:0x01d8, B:63:0x021f, B:60:0x01f5, B:62:0x0206, B:67:0x022e, B:69:0x025a, B:70:0x0284, B:72:0x02ba, B:74:0x02c0, B:77:0x02cc, B:79:0x0302, B:80:0x031d, B:82:0x0323, B:84:0x0331, B:88:0x0344, B:85:0x0339, B:91:0x034b, B:94:0x0352, B:95:0x036a, B:157:0x0506, B:159:0x0514, B:161:0x051f, B:172:0x0551, B:162:0x0527, B:164:0x0532, B:166:0x0538, B:169:0x0544, B:171:0x054c, B:173:0x0554, B:174:0x0560, B:177:0x0568, B:179:0x057a, B:180:0x0586, B:182:0x058e, B:186:0x05b3, B:188:0x05d8, B:190:0x05e9, B:192:0x05ef, B:194:0x05fb, B:195:0x062c, B:197:0x0632, B:199:0x0640, B:200:0x0644, B:201:0x0647, B:202:0x064a, B:203:0x0658, B:205:0x065e, B:207:0x066e, B:208:0x0675, B:210:0x0681, B:211:0x0688, B:212:0x068b, B:214:0x06cb, B:215:0x06de, B:217:0x06e4, B:220:0x06fe, B:222:0x0719, B:224:0x0732, B:226:0x0737, B:228:0x073b, B:230:0x073f, B:232:0x0749, B:233:0x0753, B:235:0x0757, B:237:0x075d, B:238:0x076b, B:239:0x0774, B:307:0x09c6, B:241:0x0780, B:243:0x0797, B:249:0x07b3, B:251:0x07d7, B:252:0x07df, B:254:0x07e5, B:256:0x07f7, B:263:0x0820, B:264:0x0843, B:266:0x084f, B:268:0x0864, B:270:0x08a5, B:274:0x08bd, B:276:0x08c4, B:278:0x08d3, B:280:0x08d7, B:282:0x08db, B:284:0x08df, B:285:0x08eb, B:286:0x08f0, B:288:0x08f6, B:290:0x0912, B:291:0x0917, B:306:0x09c3, B:292:0x0931, B:294:0x0939, B:298:0x0960, B:300:0x098e, B:301:0x0995, B:302:0x09a7, B:304:0x09b3, B:295:0x0946, B:261:0x080b, B:247:0x079e, B:308:0x09d1, B:310:0x09de, B:311:0x09e4, B:312:0x09ec, B:314:0x09f2, B:316:0x0a08, B:318:0x0a19, B:338:0x0a8d, B:340:0x0a93, B:342:0x0aab, B:345:0x0ab2, B:350:0x0ae1, B:352:0x0b23, B:355:0x0b58, B:356:0x0b5c, B:357:0x0b67, B:359:0x0baa, B:360:0x0bb7, B:362:0x0bc6, B:366:0x0be0, B:368:0x0bf9, B:354:0x0b35, B:346:0x0aba, B:348:0x0ac6, B:349:0x0aca, B:369:0x0c11, B:370:0x0c29, B:373:0x0c31, B:374:0x0c36, B:375:0x0c46, B:377:0x0c60, B:378:0x0c7b, B:379:0x0c84, B:384:0x0ca8, B:383:0x0c95, B:319:0x0a31, B:321:0x0a37, B:323:0x0a41, B:325:0x0a48, B:331:0x0a58, B:333:0x0a5f, B:335:0x0a7e, B:337:0x0a85, B:336:0x0a82, B:332:0x0a5c, B:324:0x0a45, B:183:0x0593, B:185:0x0599, B:387:0x0cba), top: B:397:0x000e, inners: #0, #1, #3, #4 }] */
    /* JADX WARN: Removed duplicated region for block: B:251:0x07d7 A[Catch: all -> 0x0ccc, TryCatch #2 {all -> 0x0ccc, blocks: (B:3:0x000e, B:5:0x0026, B:8:0x002e, B:9:0x0040, B:12:0x0054, B:15:0x007b, B:17:0x00b1, B:20:0x00c3, B:22:0x00cd, B:154:0x04ee, B:24:0x00f7, B:26:0x0105, B:29:0x0125, B:31:0x012b, B:33:0x013d, B:35:0x014b, B:37:0x015b, B:38:0x0168, B:39:0x016d, B:42:0x0186, B:97:0x0383, B:98:0x038f, B:101:0x0399, B:107:0x03bc, B:104:0x03ab, B:129:0x043b, B:131:0x0447, B:134:0x045c, B:136:0x046d, B:138:0x0479, B:153:0x04da, B:141:0x0489, B:143:0x0495, B:146:0x04aa, B:148:0x04bb, B:150:0x04c7, B:111:0x03c4, B:113:0x03d0, B:115:0x03dc, B:127:0x0421, B:119:0x03f9, B:122:0x040b, B:124:0x0411, B:126:0x041b, B:54:0x01c0, B:57:0x01ca, B:59:0x01d8, B:63:0x021f, B:60:0x01f5, B:62:0x0206, B:67:0x022e, B:69:0x025a, B:70:0x0284, B:72:0x02ba, B:74:0x02c0, B:77:0x02cc, B:79:0x0302, B:80:0x031d, B:82:0x0323, B:84:0x0331, B:88:0x0344, B:85:0x0339, B:91:0x034b, B:94:0x0352, B:95:0x036a, B:157:0x0506, B:159:0x0514, B:161:0x051f, B:172:0x0551, B:162:0x0527, B:164:0x0532, B:166:0x0538, B:169:0x0544, B:171:0x054c, B:173:0x0554, B:174:0x0560, B:177:0x0568, B:179:0x057a, B:180:0x0586, B:182:0x058e, B:186:0x05b3, B:188:0x05d8, B:190:0x05e9, B:192:0x05ef, B:194:0x05fb, B:195:0x062c, B:197:0x0632, B:199:0x0640, B:200:0x0644, B:201:0x0647, B:202:0x064a, B:203:0x0658, B:205:0x065e, B:207:0x066e, B:208:0x0675, B:210:0x0681, B:211:0x0688, B:212:0x068b, B:214:0x06cb, B:215:0x06de, B:217:0x06e4, B:220:0x06fe, B:222:0x0719, B:224:0x0732, B:226:0x0737, B:228:0x073b, B:230:0x073f, B:232:0x0749, B:233:0x0753, B:235:0x0757, B:237:0x075d, B:238:0x076b, B:239:0x0774, B:307:0x09c6, B:241:0x0780, B:243:0x0797, B:249:0x07b3, B:251:0x07d7, B:252:0x07df, B:254:0x07e5, B:256:0x07f7, B:263:0x0820, B:264:0x0843, B:266:0x084f, B:268:0x0864, B:270:0x08a5, B:274:0x08bd, B:276:0x08c4, B:278:0x08d3, B:280:0x08d7, B:282:0x08db, B:284:0x08df, B:285:0x08eb, B:286:0x08f0, B:288:0x08f6, B:290:0x0912, B:291:0x0917, B:306:0x09c3, B:292:0x0931, B:294:0x0939, B:298:0x0960, B:300:0x098e, B:301:0x0995, B:302:0x09a7, B:304:0x09b3, B:295:0x0946, B:261:0x080b, B:247:0x079e, B:308:0x09d1, B:310:0x09de, B:311:0x09e4, B:312:0x09ec, B:314:0x09f2, B:316:0x0a08, B:318:0x0a19, B:338:0x0a8d, B:340:0x0a93, B:342:0x0aab, B:345:0x0ab2, B:350:0x0ae1, B:352:0x0b23, B:355:0x0b58, B:356:0x0b5c, B:357:0x0b67, B:359:0x0baa, B:360:0x0bb7, B:362:0x0bc6, B:366:0x0be0, B:368:0x0bf9, B:354:0x0b35, B:346:0x0aba, B:348:0x0ac6, B:349:0x0aca, B:369:0x0c11, B:370:0x0c29, B:373:0x0c31, B:374:0x0c36, B:375:0x0c46, B:377:0x0c60, B:378:0x0c7b, B:379:0x0c84, B:384:0x0ca8, B:383:0x0c95, B:319:0x0a31, B:321:0x0a37, B:323:0x0a41, B:325:0x0a48, B:331:0x0a58, B:333:0x0a5f, B:335:0x0a7e, B:337:0x0a85, B:336:0x0a82, B:332:0x0a5c, B:324:0x0a45, B:183:0x0593, B:185:0x0599, B:387:0x0cba), top: B:397:0x000e, inners: #0, #1, #3, #4 }] */
    /* JADX WARN: Removed duplicated region for block: B:263:0x0820 A[Catch: all -> 0x0ccc, TryCatch #2 {all -> 0x0ccc, blocks: (B:3:0x000e, B:5:0x0026, B:8:0x002e, B:9:0x0040, B:12:0x0054, B:15:0x007b, B:17:0x00b1, B:20:0x00c3, B:22:0x00cd, B:154:0x04ee, B:24:0x00f7, B:26:0x0105, B:29:0x0125, B:31:0x012b, B:33:0x013d, B:35:0x014b, B:37:0x015b, B:38:0x0168, B:39:0x016d, B:42:0x0186, B:97:0x0383, B:98:0x038f, B:101:0x0399, B:107:0x03bc, B:104:0x03ab, B:129:0x043b, B:131:0x0447, B:134:0x045c, B:136:0x046d, B:138:0x0479, B:153:0x04da, B:141:0x0489, B:143:0x0495, B:146:0x04aa, B:148:0x04bb, B:150:0x04c7, B:111:0x03c4, B:113:0x03d0, B:115:0x03dc, B:127:0x0421, B:119:0x03f9, B:122:0x040b, B:124:0x0411, B:126:0x041b, B:54:0x01c0, B:57:0x01ca, B:59:0x01d8, B:63:0x021f, B:60:0x01f5, B:62:0x0206, B:67:0x022e, B:69:0x025a, B:70:0x0284, B:72:0x02ba, B:74:0x02c0, B:77:0x02cc, B:79:0x0302, B:80:0x031d, B:82:0x0323, B:84:0x0331, B:88:0x0344, B:85:0x0339, B:91:0x034b, B:94:0x0352, B:95:0x036a, B:157:0x0506, B:159:0x0514, B:161:0x051f, B:172:0x0551, B:162:0x0527, B:164:0x0532, B:166:0x0538, B:169:0x0544, B:171:0x054c, B:173:0x0554, B:174:0x0560, B:177:0x0568, B:179:0x057a, B:180:0x0586, B:182:0x058e, B:186:0x05b3, B:188:0x05d8, B:190:0x05e9, B:192:0x05ef, B:194:0x05fb, B:195:0x062c, B:197:0x0632, B:199:0x0640, B:200:0x0644, B:201:0x0647, B:202:0x064a, B:203:0x0658, B:205:0x065e, B:207:0x066e, B:208:0x0675, B:210:0x0681, B:211:0x0688, B:212:0x068b, B:214:0x06cb, B:215:0x06de, B:217:0x06e4, B:220:0x06fe, B:222:0x0719, B:224:0x0732, B:226:0x0737, B:228:0x073b, B:230:0x073f, B:232:0x0749, B:233:0x0753, B:235:0x0757, B:237:0x075d, B:238:0x076b, B:239:0x0774, B:307:0x09c6, B:241:0x0780, B:243:0x0797, B:249:0x07b3, B:251:0x07d7, B:252:0x07df, B:254:0x07e5, B:256:0x07f7, B:263:0x0820, B:264:0x0843, B:266:0x084f, B:268:0x0864, B:270:0x08a5, B:274:0x08bd, B:276:0x08c4, B:278:0x08d3, B:280:0x08d7, B:282:0x08db, B:284:0x08df, B:285:0x08eb, B:286:0x08f0, B:288:0x08f6, B:290:0x0912, B:291:0x0917, B:306:0x09c3, B:292:0x0931, B:294:0x0939, B:298:0x0960, B:300:0x098e, B:301:0x0995, B:302:0x09a7, B:304:0x09b3, B:295:0x0946, B:261:0x080b, B:247:0x079e, B:308:0x09d1, B:310:0x09de, B:311:0x09e4, B:312:0x09ec, B:314:0x09f2, B:316:0x0a08, B:318:0x0a19, B:338:0x0a8d, B:340:0x0a93, B:342:0x0aab, B:345:0x0ab2, B:350:0x0ae1, B:352:0x0b23, B:355:0x0b58, B:356:0x0b5c, B:357:0x0b67, B:359:0x0baa, B:360:0x0bb7, B:362:0x0bc6, B:366:0x0be0, B:368:0x0bf9, B:354:0x0b35, B:346:0x0aba, B:348:0x0ac6, B:349:0x0aca, B:369:0x0c11, B:370:0x0c29, B:373:0x0c31, B:374:0x0c36, B:375:0x0c46, B:377:0x0c60, B:378:0x0c7b, B:379:0x0c84, B:384:0x0ca8, B:383:0x0c95, B:319:0x0a31, B:321:0x0a37, B:323:0x0a41, B:325:0x0a48, B:331:0x0a58, B:333:0x0a5f, B:335:0x0a7e, B:337:0x0a85, B:336:0x0a82, B:332:0x0a5c, B:324:0x0a45, B:183:0x0593, B:185:0x0599, B:387:0x0cba), top: B:397:0x000e, inners: #0, #1, #3, #4 }] */
    /* JADX WARN: Removed duplicated region for block: B:264:0x0843 A[Catch: all -> 0x0ccc, TryCatch #2 {all -> 0x0ccc, blocks: (B:3:0x000e, B:5:0x0026, B:8:0x002e, B:9:0x0040, B:12:0x0054, B:15:0x007b, B:17:0x00b1, B:20:0x00c3, B:22:0x00cd, B:154:0x04ee, B:24:0x00f7, B:26:0x0105, B:29:0x0125, B:31:0x012b, B:33:0x013d, B:35:0x014b, B:37:0x015b, B:38:0x0168, B:39:0x016d, B:42:0x0186, B:97:0x0383, B:98:0x038f, B:101:0x0399, B:107:0x03bc, B:104:0x03ab, B:129:0x043b, B:131:0x0447, B:134:0x045c, B:136:0x046d, B:138:0x0479, B:153:0x04da, B:141:0x0489, B:143:0x0495, B:146:0x04aa, B:148:0x04bb, B:150:0x04c7, B:111:0x03c4, B:113:0x03d0, B:115:0x03dc, B:127:0x0421, B:119:0x03f9, B:122:0x040b, B:124:0x0411, B:126:0x041b, B:54:0x01c0, B:57:0x01ca, B:59:0x01d8, B:63:0x021f, B:60:0x01f5, B:62:0x0206, B:67:0x022e, B:69:0x025a, B:70:0x0284, B:72:0x02ba, B:74:0x02c0, B:77:0x02cc, B:79:0x0302, B:80:0x031d, B:82:0x0323, B:84:0x0331, B:88:0x0344, B:85:0x0339, B:91:0x034b, B:94:0x0352, B:95:0x036a, B:157:0x0506, B:159:0x0514, B:161:0x051f, B:172:0x0551, B:162:0x0527, B:164:0x0532, B:166:0x0538, B:169:0x0544, B:171:0x054c, B:173:0x0554, B:174:0x0560, B:177:0x0568, B:179:0x057a, B:180:0x0586, B:182:0x058e, B:186:0x05b3, B:188:0x05d8, B:190:0x05e9, B:192:0x05ef, B:194:0x05fb, B:195:0x062c, B:197:0x0632, B:199:0x0640, B:200:0x0644, B:201:0x0647, B:202:0x064a, B:203:0x0658, B:205:0x065e, B:207:0x066e, B:208:0x0675, B:210:0x0681, B:211:0x0688, B:212:0x068b, B:214:0x06cb, B:215:0x06de, B:217:0x06e4, B:220:0x06fe, B:222:0x0719, B:224:0x0732, B:226:0x0737, B:228:0x073b, B:230:0x073f, B:232:0x0749, B:233:0x0753, B:235:0x0757, B:237:0x075d, B:238:0x076b, B:239:0x0774, B:307:0x09c6, B:241:0x0780, B:243:0x0797, B:249:0x07b3, B:251:0x07d7, B:252:0x07df, B:254:0x07e5, B:256:0x07f7, B:263:0x0820, B:264:0x0843, B:266:0x084f, B:268:0x0864, B:270:0x08a5, B:274:0x08bd, B:276:0x08c4, B:278:0x08d3, B:280:0x08d7, B:282:0x08db, B:284:0x08df, B:285:0x08eb, B:286:0x08f0, B:288:0x08f6, B:290:0x0912, B:291:0x0917, B:306:0x09c3, B:292:0x0931, B:294:0x0939, B:298:0x0960, B:300:0x098e, B:301:0x0995, B:302:0x09a7, B:304:0x09b3, B:295:0x0946, B:261:0x080b, B:247:0x079e, B:308:0x09d1, B:310:0x09de, B:311:0x09e4, B:312:0x09ec, B:314:0x09f2, B:316:0x0a08, B:318:0x0a19, B:338:0x0a8d, B:340:0x0a93, B:342:0x0aab, B:345:0x0ab2, B:350:0x0ae1, B:352:0x0b23, B:355:0x0b58, B:356:0x0b5c, B:357:0x0b67, B:359:0x0baa, B:360:0x0bb7, B:362:0x0bc6, B:366:0x0be0, B:368:0x0bf9, B:354:0x0b35, B:346:0x0aba, B:348:0x0ac6, B:349:0x0aca, B:369:0x0c11, B:370:0x0c29, B:373:0x0c31, B:374:0x0c36, B:375:0x0c46, B:377:0x0c60, B:378:0x0c7b, B:379:0x0c84, B:384:0x0ca8, B:383:0x0c95, B:319:0x0a31, B:321:0x0a37, B:323:0x0a41, B:325:0x0a48, B:331:0x0a58, B:333:0x0a5f, B:335:0x0a7e, B:337:0x0a85, B:336:0x0a82, B:332:0x0a5c, B:324:0x0a45, B:183:0x0593, B:185:0x0599, B:387:0x0cba), top: B:397:0x000e, inners: #0, #1, #3, #4 }] */
    /* JADX WARN: Removed duplicated region for block: B:272:0x08ba  */
    /* JADX WARN: Removed duplicated region for block: B:273:0x08bc  */
    /* JADX WARN: Removed duplicated region for block: B:276:0x08c4 A[Catch: all -> 0x0ccc, TryCatch #2 {all -> 0x0ccc, blocks: (B:3:0x000e, B:5:0x0026, B:8:0x002e, B:9:0x0040, B:12:0x0054, B:15:0x007b, B:17:0x00b1, B:20:0x00c3, B:22:0x00cd, B:154:0x04ee, B:24:0x00f7, B:26:0x0105, B:29:0x0125, B:31:0x012b, B:33:0x013d, B:35:0x014b, B:37:0x015b, B:38:0x0168, B:39:0x016d, B:42:0x0186, B:97:0x0383, B:98:0x038f, B:101:0x0399, B:107:0x03bc, B:104:0x03ab, B:129:0x043b, B:131:0x0447, B:134:0x045c, B:136:0x046d, B:138:0x0479, B:153:0x04da, B:141:0x0489, B:143:0x0495, B:146:0x04aa, B:148:0x04bb, B:150:0x04c7, B:111:0x03c4, B:113:0x03d0, B:115:0x03dc, B:127:0x0421, B:119:0x03f9, B:122:0x040b, B:124:0x0411, B:126:0x041b, B:54:0x01c0, B:57:0x01ca, B:59:0x01d8, B:63:0x021f, B:60:0x01f5, B:62:0x0206, B:67:0x022e, B:69:0x025a, B:70:0x0284, B:72:0x02ba, B:74:0x02c0, B:77:0x02cc, B:79:0x0302, B:80:0x031d, B:82:0x0323, B:84:0x0331, B:88:0x0344, B:85:0x0339, B:91:0x034b, B:94:0x0352, B:95:0x036a, B:157:0x0506, B:159:0x0514, B:161:0x051f, B:172:0x0551, B:162:0x0527, B:164:0x0532, B:166:0x0538, B:169:0x0544, B:171:0x054c, B:173:0x0554, B:174:0x0560, B:177:0x0568, B:179:0x057a, B:180:0x0586, B:182:0x058e, B:186:0x05b3, B:188:0x05d8, B:190:0x05e9, B:192:0x05ef, B:194:0x05fb, B:195:0x062c, B:197:0x0632, B:199:0x0640, B:200:0x0644, B:201:0x0647, B:202:0x064a, B:203:0x0658, B:205:0x065e, B:207:0x066e, B:208:0x0675, B:210:0x0681, B:211:0x0688, B:212:0x068b, B:214:0x06cb, B:215:0x06de, B:217:0x06e4, B:220:0x06fe, B:222:0x0719, B:224:0x0732, B:226:0x0737, B:228:0x073b, B:230:0x073f, B:232:0x0749, B:233:0x0753, B:235:0x0757, B:237:0x075d, B:238:0x076b, B:239:0x0774, B:307:0x09c6, B:241:0x0780, B:243:0x0797, B:249:0x07b3, B:251:0x07d7, B:252:0x07df, B:254:0x07e5, B:256:0x07f7, B:263:0x0820, B:264:0x0843, B:266:0x084f, B:268:0x0864, B:270:0x08a5, B:274:0x08bd, B:276:0x08c4, B:278:0x08d3, B:280:0x08d7, B:282:0x08db, B:284:0x08df, B:285:0x08eb, B:286:0x08f0, B:288:0x08f6, B:290:0x0912, B:291:0x0917, B:306:0x09c3, B:292:0x0931, B:294:0x0939, B:298:0x0960, B:300:0x098e, B:301:0x0995, B:302:0x09a7, B:304:0x09b3, B:295:0x0946, B:261:0x080b, B:247:0x079e, B:308:0x09d1, B:310:0x09de, B:311:0x09e4, B:312:0x09ec, B:314:0x09f2, B:316:0x0a08, B:318:0x0a19, B:338:0x0a8d, B:340:0x0a93, B:342:0x0aab, B:345:0x0ab2, B:350:0x0ae1, B:352:0x0b23, B:355:0x0b58, B:356:0x0b5c, B:357:0x0b67, B:359:0x0baa, B:360:0x0bb7, B:362:0x0bc6, B:366:0x0be0, B:368:0x0bf9, B:354:0x0b35, B:346:0x0aba, B:348:0x0ac6, B:349:0x0aca, B:369:0x0c11, B:370:0x0c29, B:373:0x0c31, B:374:0x0c36, B:375:0x0c46, B:377:0x0c60, B:378:0x0c7b, B:379:0x0c84, B:384:0x0ca8, B:383:0x0c95, B:319:0x0a31, B:321:0x0a37, B:323:0x0a41, B:325:0x0a48, B:331:0x0a58, B:333:0x0a5f, B:335:0x0a7e, B:337:0x0a85, B:336:0x0a82, B:332:0x0a5c, B:324:0x0a45, B:183:0x0593, B:185:0x0599, B:387:0x0cba), top: B:397:0x000e, inners: #0, #1, #3, #4 }] */
    /* JADX WARN: Removed duplicated region for block: B:286:0x08f0 A[Catch: all -> 0x0ccc, TryCatch #2 {all -> 0x0ccc, blocks: (B:3:0x000e, B:5:0x0026, B:8:0x002e, B:9:0x0040, B:12:0x0054, B:15:0x007b, B:17:0x00b1, B:20:0x00c3, B:22:0x00cd, B:154:0x04ee, B:24:0x00f7, B:26:0x0105, B:29:0x0125, B:31:0x012b, B:33:0x013d, B:35:0x014b, B:37:0x015b, B:38:0x0168, B:39:0x016d, B:42:0x0186, B:97:0x0383, B:98:0x038f, B:101:0x0399, B:107:0x03bc, B:104:0x03ab, B:129:0x043b, B:131:0x0447, B:134:0x045c, B:136:0x046d, B:138:0x0479, B:153:0x04da, B:141:0x0489, B:143:0x0495, B:146:0x04aa, B:148:0x04bb, B:150:0x04c7, B:111:0x03c4, B:113:0x03d0, B:115:0x03dc, B:127:0x0421, B:119:0x03f9, B:122:0x040b, B:124:0x0411, B:126:0x041b, B:54:0x01c0, B:57:0x01ca, B:59:0x01d8, B:63:0x021f, B:60:0x01f5, B:62:0x0206, B:67:0x022e, B:69:0x025a, B:70:0x0284, B:72:0x02ba, B:74:0x02c0, B:77:0x02cc, B:79:0x0302, B:80:0x031d, B:82:0x0323, B:84:0x0331, B:88:0x0344, B:85:0x0339, B:91:0x034b, B:94:0x0352, B:95:0x036a, B:157:0x0506, B:159:0x0514, B:161:0x051f, B:172:0x0551, B:162:0x0527, B:164:0x0532, B:166:0x0538, B:169:0x0544, B:171:0x054c, B:173:0x0554, B:174:0x0560, B:177:0x0568, B:179:0x057a, B:180:0x0586, B:182:0x058e, B:186:0x05b3, B:188:0x05d8, B:190:0x05e9, B:192:0x05ef, B:194:0x05fb, B:195:0x062c, B:197:0x0632, B:199:0x0640, B:200:0x0644, B:201:0x0647, B:202:0x064a, B:203:0x0658, B:205:0x065e, B:207:0x066e, B:208:0x0675, B:210:0x0681, B:211:0x0688, B:212:0x068b, B:214:0x06cb, B:215:0x06de, B:217:0x06e4, B:220:0x06fe, B:222:0x0719, B:224:0x0732, B:226:0x0737, B:228:0x073b, B:230:0x073f, B:232:0x0749, B:233:0x0753, B:235:0x0757, B:237:0x075d, B:238:0x076b, B:239:0x0774, B:307:0x09c6, B:241:0x0780, B:243:0x0797, B:249:0x07b3, B:251:0x07d7, B:252:0x07df, B:254:0x07e5, B:256:0x07f7, B:263:0x0820, B:264:0x0843, B:266:0x084f, B:268:0x0864, B:270:0x08a5, B:274:0x08bd, B:276:0x08c4, B:278:0x08d3, B:280:0x08d7, B:282:0x08db, B:284:0x08df, B:285:0x08eb, B:286:0x08f0, B:288:0x08f6, B:290:0x0912, B:291:0x0917, B:306:0x09c3, B:292:0x0931, B:294:0x0939, B:298:0x0960, B:300:0x098e, B:301:0x0995, B:302:0x09a7, B:304:0x09b3, B:295:0x0946, B:261:0x080b, B:247:0x079e, B:308:0x09d1, B:310:0x09de, B:311:0x09e4, B:312:0x09ec, B:314:0x09f2, B:316:0x0a08, B:318:0x0a19, B:338:0x0a8d, B:340:0x0a93, B:342:0x0aab, B:345:0x0ab2, B:350:0x0ae1, B:352:0x0b23, B:355:0x0b58, B:356:0x0b5c, B:357:0x0b67, B:359:0x0baa, B:360:0x0bb7, B:362:0x0bc6, B:366:0x0be0, B:368:0x0bf9, B:354:0x0b35, B:346:0x0aba, B:348:0x0ac6, B:349:0x0aca, B:369:0x0c11, B:370:0x0c29, B:373:0x0c31, B:374:0x0c36, B:375:0x0c46, B:377:0x0c60, B:378:0x0c7b, B:379:0x0c84, B:384:0x0ca8, B:383:0x0c95, B:319:0x0a31, B:321:0x0a37, B:323:0x0a41, B:325:0x0a48, B:331:0x0a58, B:333:0x0a5f, B:335:0x0a7e, B:337:0x0a85, B:336:0x0a82, B:332:0x0a5c, B:324:0x0a45, B:183:0x0593, B:185:0x0599, B:387:0x0cba), top: B:397:0x000e, inners: #0, #1, #3, #4 }] */
    /* JADX WARN: Removed duplicated region for block: B:352:0x0b23 A[Catch: all -> 0x0ccc, TryCatch #2 {all -> 0x0ccc, blocks: (B:3:0x000e, B:5:0x0026, B:8:0x002e, B:9:0x0040, B:12:0x0054, B:15:0x007b, B:17:0x00b1, B:20:0x00c3, B:22:0x00cd, B:154:0x04ee, B:24:0x00f7, B:26:0x0105, B:29:0x0125, B:31:0x012b, B:33:0x013d, B:35:0x014b, B:37:0x015b, B:38:0x0168, B:39:0x016d, B:42:0x0186, B:97:0x0383, B:98:0x038f, B:101:0x0399, B:107:0x03bc, B:104:0x03ab, B:129:0x043b, B:131:0x0447, B:134:0x045c, B:136:0x046d, B:138:0x0479, B:153:0x04da, B:141:0x0489, B:143:0x0495, B:146:0x04aa, B:148:0x04bb, B:150:0x04c7, B:111:0x03c4, B:113:0x03d0, B:115:0x03dc, B:127:0x0421, B:119:0x03f9, B:122:0x040b, B:124:0x0411, B:126:0x041b, B:54:0x01c0, B:57:0x01ca, B:59:0x01d8, B:63:0x021f, B:60:0x01f5, B:62:0x0206, B:67:0x022e, B:69:0x025a, B:70:0x0284, B:72:0x02ba, B:74:0x02c0, B:77:0x02cc, B:79:0x0302, B:80:0x031d, B:82:0x0323, B:84:0x0331, B:88:0x0344, B:85:0x0339, B:91:0x034b, B:94:0x0352, B:95:0x036a, B:157:0x0506, B:159:0x0514, B:161:0x051f, B:172:0x0551, B:162:0x0527, B:164:0x0532, B:166:0x0538, B:169:0x0544, B:171:0x054c, B:173:0x0554, B:174:0x0560, B:177:0x0568, B:179:0x057a, B:180:0x0586, B:182:0x058e, B:186:0x05b3, B:188:0x05d8, B:190:0x05e9, B:192:0x05ef, B:194:0x05fb, B:195:0x062c, B:197:0x0632, B:199:0x0640, B:200:0x0644, B:201:0x0647, B:202:0x064a, B:203:0x0658, B:205:0x065e, B:207:0x066e, B:208:0x0675, B:210:0x0681, B:211:0x0688, B:212:0x068b, B:214:0x06cb, B:215:0x06de, B:217:0x06e4, B:220:0x06fe, B:222:0x0719, B:224:0x0732, B:226:0x0737, B:228:0x073b, B:230:0x073f, B:232:0x0749, B:233:0x0753, B:235:0x0757, B:237:0x075d, B:238:0x076b, B:239:0x0774, B:307:0x09c6, B:241:0x0780, B:243:0x0797, B:249:0x07b3, B:251:0x07d7, B:252:0x07df, B:254:0x07e5, B:256:0x07f7, B:263:0x0820, B:264:0x0843, B:266:0x084f, B:268:0x0864, B:270:0x08a5, B:274:0x08bd, B:276:0x08c4, B:278:0x08d3, B:280:0x08d7, B:282:0x08db, B:284:0x08df, B:285:0x08eb, B:286:0x08f0, B:288:0x08f6, B:290:0x0912, B:291:0x0917, B:306:0x09c3, B:292:0x0931, B:294:0x0939, B:298:0x0960, B:300:0x098e, B:301:0x0995, B:302:0x09a7, B:304:0x09b3, B:295:0x0946, B:261:0x080b, B:247:0x079e, B:308:0x09d1, B:310:0x09de, B:311:0x09e4, B:312:0x09ec, B:314:0x09f2, B:316:0x0a08, B:318:0x0a19, B:338:0x0a8d, B:340:0x0a93, B:342:0x0aab, B:345:0x0ab2, B:350:0x0ae1, B:352:0x0b23, B:355:0x0b58, B:356:0x0b5c, B:357:0x0b67, B:359:0x0baa, B:360:0x0bb7, B:362:0x0bc6, B:366:0x0be0, B:368:0x0bf9, B:354:0x0b35, B:346:0x0aba, B:348:0x0ac6, B:349:0x0aca, B:369:0x0c11, B:370:0x0c29, B:373:0x0c31, B:374:0x0c36, B:375:0x0c46, B:377:0x0c60, B:378:0x0c7b, B:379:0x0c84, B:384:0x0ca8, B:383:0x0c95, B:319:0x0a31, B:321:0x0a37, B:323:0x0a41, B:325:0x0a48, B:331:0x0a58, B:333:0x0a5f, B:335:0x0a7e, B:337:0x0a85, B:336:0x0a82, B:332:0x0a5c, B:324:0x0a45, B:183:0x0593, B:185:0x0599, B:387:0x0cba), top: B:397:0x000e, inners: #0, #1, #3, #4 }] */
    /* JADX WARN: Removed duplicated region for block: B:359:0x0baa A[Catch: all -> 0x0ccc, TRY_LEAVE, TryCatch #2 {all -> 0x0ccc, blocks: (B:3:0x000e, B:5:0x0026, B:8:0x002e, B:9:0x0040, B:12:0x0054, B:15:0x007b, B:17:0x00b1, B:20:0x00c3, B:22:0x00cd, B:154:0x04ee, B:24:0x00f7, B:26:0x0105, B:29:0x0125, B:31:0x012b, B:33:0x013d, B:35:0x014b, B:37:0x015b, B:38:0x0168, B:39:0x016d, B:42:0x0186, B:97:0x0383, B:98:0x038f, B:101:0x0399, B:107:0x03bc, B:104:0x03ab, B:129:0x043b, B:131:0x0447, B:134:0x045c, B:136:0x046d, B:138:0x0479, B:153:0x04da, B:141:0x0489, B:143:0x0495, B:146:0x04aa, B:148:0x04bb, B:150:0x04c7, B:111:0x03c4, B:113:0x03d0, B:115:0x03dc, B:127:0x0421, B:119:0x03f9, B:122:0x040b, B:124:0x0411, B:126:0x041b, B:54:0x01c0, B:57:0x01ca, B:59:0x01d8, B:63:0x021f, B:60:0x01f5, B:62:0x0206, B:67:0x022e, B:69:0x025a, B:70:0x0284, B:72:0x02ba, B:74:0x02c0, B:77:0x02cc, B:79:0x0302, B:80:0x031d, B:82:0x0323, B:84:0x0331, B:88:0x0344, B:85:0x0339, B:91:0x034b, B:94:0x0352, B:95:0x036a, B:157:0x0506, B:159:0x0514, B:161:0x051f, B:172:0x0551, B:162:0x0527, B:164:0x0532, B:166:0x0538, B:169:0x0544, B:171:0x054c, B:173:0x0554, B:174:0x0560, B:177:0x0568, B:179:0x057a, B:180:0x0586, B:182:0x058e, B:186:0x05b3, B:188:0x05d8, B:190:0x05e9, B:192:0x05ef, B:194:0x05fb, B:195:0x062c, B:197:0x0632, B:199:0x0640, B:200:0x0644, B:201:0x0647, B:202:0x064a, B:203:0x0658, B:205:0x065e, B:207:0x066e, B:208:0x0675, B:210:0x0681, B:211:0x0688, B:212:0x068b, B:214:0x06cb, B:215:0x06de, B:217:0x06e4, B:220:0x06fe, B:222:0x0719, B:224:0x0732, B:226:0x0737, B:228:0x073b, B:230:0x073f, B:232:0x0749, B:233:0x0753, B:235:0x0757, B:237:0x075d, B:238:0x076b, B:239:0x0774, B:307:0x09c6, B:241:0x0780, B:243:0x0797, B:249:0x07b3, B:251:0x07d7, B:252:0x07df, B:254:0x07e5, B:256:0x07f7, B:263:0x0820, B:264:0x0843, B:266:0x084f, B:268:0x0864, B:270:0x08a5, B:274:0x08bd, B:276:0x08c4, B:278:0x08d3, B:280:0x08d7, B:282:0x08db, B:284:0x08df, B:285:0x08eb, B:286:0x08f0, B:288:0x08f6, B:290:0x0912, B:291:0x0917, B:306:0x09c3, B:292:0x0931, B:294:0x0939, B:298:0x0960, B:300:0x098e, B:301:0x0995, B:302:0x09a7, B:304:0x09b3, B:295:0x0946, B:261:0x080b, B:247:0x079e, B:308:0x09d1, B:310:0x09de, B:311:0x09e4, B:312:0x09ec, B:314:0x09f2, B:316:0x0a08, B:318:0x0a19, B:338:0x0a8d, B:340:0x0a93, B:342:0x0aab, B:345:0x0ab2, B:350:0x0ae1, B:352:0x0b23, B:355:0x0b58, B:356:0x0b5c, B:357:0x0b67, B:359:0x0baa, B:360:0x0bb7, B:362:0x0bc6, B:366:0x0be0, B:368:0x0bf9, B:354:0x0b35, B:346:0x0aba, B:348:0x0ac6, B:349:0x0aca, B:369:0x0c11, B:370:0x0c29, B:373:0x0c31, B:374:0x0c36, B:375:0x0c46, B:377:0x0c60, B:378:0x0c7b, B:379:0x0c84, B:384:0x0ca8, B:383:0x0c95, B:319:0x0a31, B:321:0x0a37, B:323:0x0a41, B:325:0x0a48, B:331:0x0a58, B:333:0x0a5f, B:335:0x0a7e, B:337:0x0a85, B:336:0x0a82, B:332:0x0a5c, B:324:0x0a45, B:183:0x0593, B:185:0x0599, B:387:0x0cba), top: B:397:0x000e, inners: #0, #1, #3, #4 }] */
    /* JADX WARN: Removed duplicated region for block: B:362:0x0bc6 A[Catch: SQLiteException -> 0x0bde, all -> 0x0ccc, TRY_LEAVE, TryCatch #3 {SQLiteException -> 0x0bde, blocks: (B:360:0x0bb7, B:362:0x0bc6), top: B:398:0x0bb7, outer: #2 }] */
    /* JADX WARN: Removed duplicated region for block: B:97:0x0383 A[Catch: all -> 0x0ccc, TryCatch #2 {all -> 0x0ccc, blocks: (B:3:0x000e, B:5:0x0026, B:8:0x002e, B:9:0x0040, B:12:0x0054, B:15:0x007b, B:17:0x00b1, B:20:0x00c3, B:22:0x00cd, B:154:0x04ee, B:24:0x00f7, B:26:0x0105, B:29:0x0125, B:31:0x012b, B:33:0x013d, B:35:0x014b, B:37:0x015b, B:38:0x0168, B:39:0x016d, B:42:0x0186, B:97:0x0383, B:98:0x038f, B:101:0x0399, B:107:0x03bc, B:104:0x03ab, B:129:0x043b, B:131:0x0447, B:134:0x045c, B:136:0x046d, B:138:0x0479, B:153:0x04da, B:141:0x0489, B:143:0x0495, B:146:0x04aa, B:148:0x04bb, B:150:0x04c7, B:111:0x03c4, B:113:0x03d0, B:115:0x03dc, B:127:0x0421, B:119:0x03f9, B:122:0x040b, B:124:0x0411, B:126:0x041b, B:54:0x01c0, B:57:0x01ca, B:59:0x01d8, B:63:0x021f, B:60:0x01f5, B:62:0x0206, B:67:0x022e, B:69:0x025a, B:70:0x0284, B:72:0x02ba, B:74:0x02c0, B:77:0x02cc, B:79:0x0302, B:80:0x031d, B:82:0x0323, B:84:0x0331, B:88:0x0344, B:85:0x0339, B:91:0x034b, B:94:0x0352, B:95:0x036a, B:157:0x0506, B:159:0x0514, B:161:0x051f, B:172:0x0551, B:162:0x0527, B:164:0x0532, B:166:0x0538, B:169:0x0544, B:171:0x054c, B:173:0x0554, B:174:0x0560, B:177:0x0568, B:179:0x057a, B:180:0x0586, B:182:0x058e, B:186:0x05b3, B:188:0x05d8, B:190:0x05e9, B:192:0x05ef, B:194:0x05fb, B:195:0x062c, B:197:0x0632, B:199:0x0640, B:200:0x0644, B:201:0x0647, B:202:0x064a, B:203:0x0658, B:205:0x065e, B:207:0x066e, B:208:0x0675, B:210:0x0681, B:211:0x0688, B:212:0x068b, B:214:0x06cb, B:215:0x06de, B:217:0x06e4, B:220:0x06fe, B:222:0x0719, B:224:0x0732, B:226:0x0737, B:228:0x073b, B:230:0x073f, B:232:0x0749, B:233:0x0753, B:235:0x0757, B:237:0x075d, B:238:0x076b, B:239:0x0774, B:307:0x09c6, B:241:0x0780, B:243:0x0797, B:249:0x07b3, B:251:0x07d7, B:252:0x07df, B:254:0x07e5, B:256:0x07f7, B:263:0x0820, B:264:0x0843, B:266:0x084f, B:268:0x0864, B:270:0x08a5, B:274:0x08bd, B:276:0x08c4, B:278:0x08d3, B:280:0x08d7, B:282:0x08db, B:284:0x08df, B:285:0x08eb, B:286:0x08f0, B:288:0x08f6, B:290:0x0912, B:291:0x0917, B:306:0x09c3, B:292:0x0931, B:294:0x0939, B:298:0x0960, B:300:0x098e, B:301:0x0995, B:302:0x09a7, B:304:0x09b3, B:295:0x0946, B:261:0x080b, B:247:0x079e, B:308:0x09d1, B:310:0x09de, B:311:0x09e4, B:312:0x09ec, B:314:0x09f2, B:316:0x0a08, B:318:0x0a19, B:338:0x0a8d, B:340:0x0a93, B:342:0x0aab, B:345:0x0ab2, B:350:0x0ae1, B:352:0x0b23, B:355:0x0b58, B:356:0x0b5c, B:357:0x0b67, B:359:0x0baa, B:360:0x0bb7, B:362:0x0bc6, B:366:0x0be0, B:368:0x0bf9, B:354:0x0b35, B:346:0x0aba, B:348:0x0ac6, B:349:0x0aca, B:369:0x0c11, B:370:0x0c29, B:373:0x0c31, B:374:0x0c36, B:375:0x0c46, B:377:0x0c60, B:378:0x0c7b, B:379:0x0c84, B:384:0x0ca8, B:383:0x0c95, B:319:0x0a31, B:321:0x0a37, B:323:0x0a41, B:325:0x0a48, B:331:0x0a58, B:333:0x0a5f, B:335:0x0a7e, B:337:0x0a85, B:336:0x0a82, B:332:0x0a5c, B:324:0x0a45, B:183:0x0593, B:185:0x0599, B:387:0x0cba), top: B:397:0x000e, inners: #0, #1, #3, #4 }] */
    @androidx.annotation.WorkerThread
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private final boolean H(java.lang.String r41, long r42) {
        /*
            Method dump skipped, instructions count: 3287
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzlh.H(java.lang.String, long):boolean");
    }

    private final boolean I() {
        zzaB().zzg();
        b();
        zzak zzakVar = this.f22043c;
        L(zzakVar);
        if (!zzakVar.i()) {
            zzak zzakVar2 = this.f22043c;
            L(zzakVar2);
            if (TextUtils.isEmpty(zzakVar2.zzr())) {
                return false;
            }
            return true;
        }
        return true;
    }

    private final boolean J(com.google.android.gms.internal.measurement.zzfs zzfsVar, com.google.android.gms.internal.measurement.zzfs zzfsVar2) {
        String zzh;
        Preconditions.checkArgument("_e".equals(zzfsVar.zzo()));
        L(this.f22047g);
        com.google.android.gms.internal.measurement.zzfx f4 = zzlj.f((com.google.android.gms.internal.measurement.zzft) zzfsVar.zzaD(), "_sc");
        String str = null;
        if (f4 == null) {
            zzh = null;
        } else {
            zzh = f4.zzh();
        }
        L(this.f22047g);
        com.google.android.gms.internal.measurement.zzfx f5 = zzlj.f((com.google.android.gms.internal.measurement.zzft) zzfsVar2.zzaD(), "_pc");
        if (f5 != null) {
            str = f5.zzh();
        }
        if (str != null && str.equals(zzh)) {
            Preconditions.checkArgument("_e".equals(zzfsVar.zzo()));
            L(this.f22047g);
            com.google.android.gms.internal.measurement.zzfx f6 = zzlj.f((com.google.android.gms.internal.measurement.zzft) zzfsVar.zzaD(), "_et");
            if (f6 != null && f6.zzw() && f6.zzd() > 0) {
                long zzd = f6.zzd();
                L(this.f22047g);
                com.google.android.gms.internal.measurement.zzfx f7 = zzlj.f((com.google.android.gms.internal.measurement.zzft) zzfsVar2.zzaD(), "_et");
                if (f7 != null && f7.zzd() > 0) {
                    zzd += f7.zzd();
                }
                L(this.f22047g);
                zzlj.d(zzfsVar2, "_et", Long.valueOf(zzd));
                L(this.f22047g);
                zzlj.d(zzfsVar, "_fr", 1L);
                return true;
            }
            return true;
        }
        return false;
    }

    private static final boolean K(zzq zzqVar) {
        if (TextUtils.isEmpty(zzqVar.zzb) && TextUtils.isEmpty(zzqVar.zzq)) {
            return false;
        }
        return true;
    }

    private static final zzku L(zzku zzkuVar) {
        if (zzkuVar != null) {
            if (zzkuVar.b()) {
                return zzkuVar;
            }
            throw new IllegalStateException("Component not initialized: ".concat(String.valueOf(zzkuVar.getClass())));
        }
        throw new IllegalStateException("Upload Component not created");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* bridge */ /* synthetic */ void S(zzlh zzlhVar, zzli zzliVar) {
        zzlhVar.zzaB().zzg();
        zzlhVar.f22051k = new zzfl(zzlhVar);
        zzak zzakVar = new zzak(zzlhVar);
        zzakVar.zzX();
        zzlhVar.f22043c = zzakVar;
        zzlhVar.zzg().g((zzaf) Preconditions.checkNotNull(zzlhVar.f22041a));
        zzkb zzkbVar = new zzkb(zzlhVar);
        zzkbVar.zzX();
        zzlhVar.f22049i = zzkbVar;
        zzaa zzaaVar = new zzaa(zzlhVar);
        zzaaVar.zzX();
        zzlhVar.f22046f = zzaaVar;
        zzip zzipVar = new zzip(zzlhVar);
        zzipVar.zzX();
        zzlhVar.f22048h = zzipVar;
        zzks zzksVar = new zzks(zzlhVar);
        zzksVar.zzX();
        zzlhVar.f22045e = zzksVar;
        zzlhVar.f22044d = new zzfb(zzlhVar);
        if (zzlhVar.f22057q != zzlhVar.f22058r) {
            zzlhVar.zzaA().zzd().zzc("Not all upload components initialized", Integer.valueOf(zzlhVar.f22057q), Integer.valueOf(zzlhVar.f22058r));
        }
        zzlhVar.f22053m = true;
    }

    public static zzlh zzt(Context context) {
        Preconditions.checkNotNull(context);
        Preconditions.checkNotNull(context.getApplicationContext());
        if (F == null) {
            synchronized (zzlh.class) {
                if (F == null) {
                    F = new zzlh((zzli) Preconditions.checkNotNull(new zzli(context)), null);
                }
            }
        }
        return F;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @WorkerThread
    public final zzh M(zzq zzqVar) {
        String str;
        zzaB().zzg();
        b();
        Preconditions.checkNotNull(zzqVar);
        Preconditions.checkNotEmpty(zzqVar.zza);
        if (!zzqVar.zzw.isEmpty()) {
            this.B.put(zzqVar.zza, new zzlg(this, zzqVar.zzw));
        }
        zzak zzakVar = this.f22043c;
        L(zzakVar);
        zzh I = zzakVar.I(zzqVar.zza);
        zzhb zzd = P(zzqVar.zza).zzd(zzhb.zzc(zzqVar.zzv, 100));
        zzha zzhaVar = zzha.AD_STORAGE;
        if (zzd.zzj(zzhaVar)) {
            str = this.f22049i.f(zzqVar.zza, zzqVar.zzo);
        } else {
            str = "";
        }
        if (I == null) {
            I = new zzh(this.f22052l, zzqVar.zza);
            if (zzd.zzj(zzha.ANALYTICS_STORAGE)) {
                I.j(Q(zzd));
            }
            if (zzd.zzj(zzhaVar)) {
                I.H(str);
            }
        } else if (zzd.zzj(zzhaVar) && str != null && !str.equals(I.c())) {
            I.H(str);
            if (zzqVar.zzo && !"00000000-0000-0000-0000-000000000000".equals(this.f22049i.e(zzqVar.zza, zzd).first)) {
                I.j(Q(zzd));
                zzak zzakVar2 = this.f22043c;
                L(zzakVar2);
                if (zzakVar2.O(zzqVar.zza, Miui3DFaceManagerImpl.TABLE_TEMPLATE_COLUMN_ID) != null) {
                    zzak zzakVar3 = this.f22043c;
                    L(zzakVar3);
                    if (zzakVar3.O(zzqVar.zza, "_lair") == null) {
                        zzlm zzlmVar = new zzlm(zzqVar.zza, DebugKt.DEBUG_PROPERTY_VALUE_AUTO, "_lair", zzax().currentTimeMillis(), 1L);
                        zzak zzakVar4 = this.f22043c;
                        L(zzakVar4);
                        zzakVar4.o(zzlmVar);
                    }
                }
            }
        } else if (TextUtils.isEmpty(I.m0()) && zzd.zzj(zzha.ANALYTICS_STORAGE)) {
            I.j(Q(zzd));
        }
        I.y(zzqVar.zzb);
        I.h(zzqVar.zzq);
        if (!TextUtils.isEmpty(zzqVar.zzk)) {
            I.x(zzqVar.zzk);
        }
        long j4 = zzqVar.zze;
        if (j4 != 0) {
            I.z(j4);
        }
        if (!TextUtils.isEmpty(zzqVar.zzc)) {
            I.l(zzqVar.zzc);
        }
        I.m(zzqVar.zzj);
        String str2 = zzqVar.zzd;
        if (str2 != null) {
            I.k(str2);
        }
        I.u(zzqVar.zzf);
        I.F(zzqVar.zzh);
        if (!TextUtils.isEmpty(zzqVar.zzg)) {
            I.B(zzqVar.zzg);
        }
        I.i(zzqVar.zzo);
        I.G(zzqVar.zzr);
        I.v(zzqVar.zzs);
        zzqu.zzc();
        if (zzg().zzs(null, zzeg.zzam) || zzg().zzs(zzqVar.zza, zzeg.zzao)) {
            I.J(zzqVar.zzx);
        }
        zzop.zzc();
        if (zzg().zzs(null, zzeg.zzal)) {
            I.I(zzqVar.zzt);
        } else {
            zzop.zzc();
            if (zzg().zzs(null, zzeg.zzak)) {
                I.I(null);
            }
        }
        zzrd.zzc();
        if (zzg().zzs(null, zzeg.zzaq)) {
            I.L(zzqVar.zzy);
        }
        zzpz.zzc();
        if (zzg().zzs(null, zzeg.zzaE)) {
            I.M(zzqVar.zzz);
        }
        if (I.P()) {
            zzak zzakVar5 = this.f22043c;
            L(zzakVar5);
            zzakVar5.g(I);
        }
        return I;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final zzgd O() {
        return this.f22052l;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @WorkerThread
    public final zzhb P(String str) {
        String str2;
        zzhb zzhbVar = zzhb.zza;
        zzaB().zzg();
        b();
        zzhb zzhbVar2 = (zzhb) this.A.get(str);
        if (zzhbVar2 == null) {
            zzak zzakVar = this.f22043c;
            L(zzakVar);
            Preconditions.checkNotNull(str);
            zzakVar.zzg();
            zzakVar.a();
            Cursor cursor = null;
            try {
                try {
                    cursor = zzakVar.G().rawQuery("select consent_state from consent_settings where app_id=? limit 1;", new String[]{str});
                    if (cursor.moveToFirst()) {
                        str2 = cursor.getString(0);
                        cursor.close();
                    } else {
                        cursor.close();
                        str2 = "G1";
                    }
                    zzhb zzc = zzhb.zzc(str2, 100);
                    u(str, zzc);
                    return zzc;
                } catch (SQLiteException e4) {
                    zzakVar.f21734a.zzaA().zzd().zzc("Database error", "select consent_state from consent_settings where app_id=? limit 1;", e4);
                    throw e4;
                }
            } catch (Throwable th) {
                if (cursor != null) {
                    cursor.close();
                }
                throw th;
            }
        }
        return zzhbVar2;
    }

    @WorkerThread
    final String Q(zzhb zzhbVar) {
        if (zzhbVar.zzj(zzha.ANALYTICS_STORAGE)) {
            byte[] bArr = new byte[16];
            zzv().h().nextBytes(bArr);
            return String.format(Locale.US, "%032x", new BigInteger(1, bArr));
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final String R(zzq zzqVar) {
        try {
            return (String) zzaB().zzh(new zzla(this, zzqVar)).get(30000L, TimeUnit.MILLISECONDS);
        } catch (InterruptedException | ExecutionException | TimeoutException e4) {
            zzaA().zzd().zzc("Failed to get app instance id. appId", zzet.f(zzqVar.zza), e4);
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @WorkerThread
    public final void T(Runnable runnable) {
        zzaB().zzg();
        if (this.f22056p == null) {
            this.f22056p = new ArrayList();
        }
        this.f22056p.add(runnable);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @VisibleForTesting
    @WorkerThread
    public final void a() {
        zzaB().zzg();
        b();
        if (!this.f22054n) {
            this.f22054n = true;
            if (y()) {
                FileChannel fileChannel = this.f22063w;
                zzaB().zzg();
                int i4 = 0;
                if (fileChannel != null && fileChannel.isOpen()) {
                    ByteBuffer allocate = ByteBuffer.allocate(4);
                    try {
                        fileChannel.position(0L);
                        int read = fileChannel.read(allocate);
                        if (read != 4) {
                            if (read != -1) {
                                zzaA().zzk().zzb("Unexpected data length. Bytes read", Integer.valueOf(read));
                            }
                        } else {
                            allocate.flip();
                            i4 = allocate.getInt();
                        }
                    } catch (IOException e4) {
                        zzaA().zzd().zzb("Failed to read from channel", e4);
                    }
                } else {
                    zzaA().zzd().zza("Bad channel to read from");
                }
                int e5 = this.f22052l.zzh().e();
                zzaB().zzg();
                if (i4 > e5) {
                    zzaA().zzd().zzc("Panic: can't downgrade version. Previous, current version", Integer.valueOf(i4), Integer.valueOf(e5));
                } else if (i4 < e5) {
                    FileChannel fileChannel2 = this.f22063w;
                    zzaB().zzg();
                    if (fileChannel2 != null && fileChannel2.isOpen()) {
                        ByteBuffer allocate2 = ByteBuffer.allocate(4);
                        allocate2.putInt(e5);
                        allocate2.flip();
                        try {
                            fileChannel2.truncate(0L);
                            fileChannel2.write(allocate2);
                            fileChannel2.force(true);
                            if (fileChannel2.size() != 4) {
                                zzaA().zzd().zzb("Error writing to channel. Bytes written", Long.valueOf(fileChannel2.size()));
                            }
                            zzaA().zzj().zzc("Storage version upgraded. Previous, current version", Integer.valueOf(i4), Integer.valueOf(e5));
                            return;
                        } catch (IOException e6) {
                            zzaA().zzd().zzb("Failed to write to channel", e6);
                        }
                    } else {
                        zzaA().zzd().zza("Bad channel to read from");
                    }
                    zzaA().zzd().zzc("Storage version upgrade failed. Previous, current version", Integer.valueOf(i4), Integer.valueOf(e5));
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void b() {
        if (this.f22053m) {
            return;
        }
        throw new IllegalStateException("UploadController is not initialized");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void c(String str, com.google.android.gms.internal.measurement.zzgc zzgcVar) {
        int o4;
        int indexOf;
        zzfu zzfuVar = this.f22041a;
        L(zzfuVar);
        Set p4 = zzfuVar.p(str);
        if (p4 != null) {
            zzgcVar.zzi(p4);
        }
        zzfu zzfuVar2 = this.f22041a;
        L(zzfuVar2);
        if (zzfuVar2.z(str)) {
            zzgcVar.zzp();
        }
        zzfu zzfuVar3 = this.f22041a;
        L(zzfuVar3);
        if (zzfuVar3.B(str)) {
            if (zzg().zzs(str, zzeg.zzar)) {
                String zzas = zzgcVar.zzas();
                if (!TextUtils.isEmpty(zzas) && (indexOf = zzas.indexOf(".")) != -1) {
                    zzgcVar.zzY(zzas.substring(0, indexOf));
                }
            } else {
                zzgcVar.zzu();
            }
        }
        zzfu zzfuVar4 = this.f22041a;
        L(zzfuVar4);
        if (zzfuVar4.C(str) && (o4 = zzlj.o(zzgcVar, Miui3DFaceManagerImpl.TABLE_TEMPLATE_COLUMN_ID)) != -1) {
            zzgcVar.zzB(o4);
        }
        zzfu zzfuVar5 = this.f22041a;
        L(zzfuVar5);
        if (zzfuVar5.A(str)) {
            zzgcVar.zzq();
        }
        zzfu zzfuVar6 = this.f22041a;
        L(zzfuVar6);
        if (zzfuVar6.y(str)) {
            zzgcVar.zzn();
            zzlg zzlgVar = (zzlg) this.B.get(str);
            if (zzlgVar == null || zzlgVar.f22040b + zzg().zzi(str, zzeg.zzT) < zzax().elapsedRealtime()) {
                zzlgVar = new zzlg(this);
                this.B.put(str, zzlgVar);
            }
            zzgcVar.zzR(zzlgVar.f22039a);
        }
        zzfu zzfuVar7 = this.f22041a;
        L(zzfuVar7);
        if (zzfuVar7.zzw(str)) {
            zzgcVar.zzy();
        }
    }

    @WorkerThread
    final void d(zzh zzhVar) {
        zzaB().zzg();
        if (TextUtils.isEmpty(zzhVar.a()) && TextUtils.isEmpty(zzhVar.j0())) {
            i((String) Preconditions.checkNotNull(zzhVar.l0()), 204, null, null, null);
            return;
        }
        zzkw zzkwVar = this.f22050j;
        Uri.Builder builder = new Uri.Builder();
        String a4 = zzhVar.a();
        if (TextUtils.isEmpty(a4)) {
            a4 = zzhVar.j0();
        }
        ArrayMap arrayMap = null;
        Uri.Builder appendQueryParameter = builder.scheme((String) zzeg.zze.zza(null)).encodedAuthority((String) zzeg.zzf.zza(null)).path("config/app/".concat(String.valueOf(a4))).appendQueryParameter("platform", "android");
        zzkwVar.f21734a.zzf().zzh();
        appendQueryParameter.appendQueryParameter("gmp_version", String.valueOf(79000L)).appendQueryParameter("runtime_version", "0");
        String uri = builder.build().toString();
        try {
            String str = (String) Preconditions.checkNotNull(zzhVar.l0());
            URL url = new URL(uri);
            zzaA().zzj().zzb("Fetching remote configuration", str);
            zzfu zzfuVar = this.f22041a;
            L(zzfuVar);
            com.google.android.gms.internal.measurement.zzff k4 = zzfuVar.k(str);
            zzfu zzfuVar2 = this.f22041a;
            L(zzfuVar2);
            String m4 = zzfuVar2.m(str);
            if (k4 != null) {
                if (!TextUtils.isEmpty(m4)) {
                    ArrayMap arrayMap2 = new ArrayMap();
                    arrayMap2.put(HttpHeaders.IF_MODIFIED_SINCE, m4);
                    arrayMap = arrayMap2;
                }
                zzfu zzfuVar3 = this.f22041a;
                L(zzfuVar3);
                String l4 = zzfuVar3.l(str);
                if (!TextUtils.isEmpty(l4)) {
                    if (arrayMap == null) {
                        arrayMap = new ArrayMap();
                    }
                    arrayMap.put(HttpHeaders.IF_NONE_MATCH, l4);
                }
            }
            this.f22059s = true;
            zzez zzezVar = this.f22042b;
            L(zzezVar);
            zzkz zzkzVar = new zzkz(this);
            zzezVar.zzg();
            zzezVar.a();
            Preconditions.checkNotNull(url);
            Preconditions.checkNotNull(zzkzVar);
            zzezVar.f21734a.zzaB().zzo(new zzey(zzezVar, str, url, null, arrayMap, zzkzVar));
        } catch (MalformedURLException unused) {
            zzaA().zzd().zzc("Failed to parse config URL. Not fetching. appId", zzet.f(zzhVar.l0()), uri);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @WorkerThread
    public final void e(zzau zzauVar, zzq zzqVar) {
        zzau zzauVar2;
        List<zzac> R;
        List<zzac> R2;
        List<zzac> R3;
        String str;
        Preconditions.checkNotNull(zzqVar);
        Preconditions.checkNotEmpty(zzqVar.zza);
        zzaB().zzg();
        b();
        String str2 = zzqVar.zza;
        long j4 = zzauVar.zzd;
        zzeu zzb = zzeu.zzb(zzauVar);
        zzaB().zzg();
        zzir zzirVar = null;
        if (this.C != null && (str = this.D) != null && str.equals(str2)) {
            zzirVar = this.C;
        }
        zzlp.zzK(zzirVar, zzb.zzd, false);
        zzau zza = zzb.zza();
        L(this.f22047g);
        if (!zzlj.e(zza, zzqVar)) {
            return;
        }
        if (!zzqVar.zzh) {
            M(zzqVar);
            return;
        }
        List list = zzqVar.zzt;
        if (list != null) {
            if (list.contains(zza.zza)) {
                Bundle zzc = zza.zzb.zzc();
                zzc.putLong("ga_safelisted", 1L);
                zzauVar2 = new zzau(zza.zza, new zzas(zzc), zza.zzc, zza.zzd);
            } else {
                zzaA().zzc().zzd("Dropping non-safelisted event. appId, event name, origin", str2, zza.zza, zza.zzc);
                return;
            }
        } else {
            zzauVar2 = zza;
        }
        zzak zzakVar = this.f22043c;
        L(zzakVar);
        zzakVar.zzw();
        try {
            zzak zzakVar2 = this.f22043c;
            L(zzakVar2);
            Preconditions.checkNotEmpty(str2);
            zzakVar2.zzg();
            zzakVar2.a();
            int i4 = (j4 > 0L ? 1 : (j4 == 0L ? 0 : -1));
            if (i4 < 0) {
                zzakVar2.f21734a.zzaA().zzk().zzc("Invalid time querying timed out conditional properties", zzet.f(str2), Long.valueOf(j4));
                R = Collections.emptyList();
            } else {
                R = zzakVar2.R("active=0 and app_id=? and abs(? - creation_timestamp) > trigger_timeout", new String[]{str2, String.valueOf(j4)});
            }
            for (zzac zzacVar : R) {
                if (zzacVar != null) {
                    zzaA().zzj().zzd("User property timed out", zzacVar.zza, this.f22052l.zzj().f(zzacVar.zzc.zzb), zzacVar.zzc.zza());
                    zzau zzauVar3 = zzacVar.zzg;
                    if (zzauVar3 != null) {
                        x(new zzau(zzauVar3, j4), zzqVar);
                    }
                    zzak zzakVar3 = this.f22043c;
                    L(zzakVar3);
                    zzakVar3.A(str2, zzacVar.zzc.zzb);
                }
            }
            zzak zzakVar4 = this.f22043c;
            L(zzakVar4);
            Preconditions.checkNotEmpty(str2);
            zzakVar4.zzg();
            zzakVar4.a();
            if (i4 < 0) {
                zzakVar4.f21734a.zzaA().zzk().zzc("Invalid time querying expired conditional properties", zzet.f(str2), Long.valueOf(j4));
                R2 = Collections.emptyList();
            } else {
                R2 = zzakVar4.R("active<>0 and app_id=? and abs(? - triggered_timestamp) > time_to_live", new String[]{str2, String.valueOf(j4)});
            }
            ArrayList<zzau> arrayList = new ArrayList(R2.size());
            for (zzac zzacVar2 : R2) {
                if (zzacVar2 != null) {
                    zzaA().zzj().zzd("User property expired", zzacVar2.zza, this.f22052l.zzj().f(zzacVar2.zzc.zzb), zzacVar2.zzc.zza());
                    zzak zzakVar5 = this.f22043c;
                    L(zzakVar5);
                    zzakVar5.d(str2, zzacVar2.zzc.zzb);
                    zzau zzauVar4 = zzacVar2.zzk;
                    if (zzauVar4 != null) {
                        arrayList.add(zzauVar4);
                    }
                    zzak zzakVar6 = this.f22043c;
                    L(zzakVar6);
                    zzakVar6.A(str2, zzacVar2.zzc.zzb);
                }
            }
            for (zzau zzauVar5 : arrayList) {
                x(new zzau(zzauVar5, j4), zzqVar);
            }
            zzak zzakVar7 = this.f22043c;
            L(zzakVar7);
            String str3 = zzauVar2.zza;
            Preconditions.checkNotEmpty(str2);
            Preconditions.checkNotEmpty(str3);
            zzakVar7.zzg();
            zzakVar7.a();
            if (i4 < 0) {
                zzakVar7.f21734a.zzaA().zzk().zzd("Invalid time querying triggered conditional properties", zzet.f(str2), zzakVar7.f21734a.zzj().d(str3), Long.valueOf(j4));
                R3 = Collections.emptyList();
            } else {
                R3 = zzakVar7.R("active=0 and app_id=? and trigger_event_name=? and abs(? - creation_timestamp) <= trigger_timeout", new String[]{str2, str3, String.valueOf(j4)});
            }
            ArrayList<zzau> arrayList2 = new ArrayList(R3.size());
            for (zzac zzacVar3 : R3) {
                if (zzacVar3 != null) {
                    zzlk zzlkVar = zzacVar3.zzc;
                    zzlm zzlmVar = new zzlm((String) Preconditions.checkNotNull(zzacVar3.zza), zzacVar3.zzb, zzlkVar.zzb, j4, Preconditions.checkNotNull(zzlkVar.zza()));
                    zzak zzakVar8 = this.f22043c;
                    L(zzakVar8);
                    if (zzakVar8.o(zzlmVar)) {
                        zzaA().zzj().zzd("User property triggered", zzacVar3.zza, this.f22052l.zzj().f(zzlmVar.f22070c), zzlmVar.f22072e);
                    } else {
                        zzaA().zzd().zzd("Too many active user properties, ignoring", zzet.f(zzacVar3.zza), this.f22052l.zzj().f(zzlmVar.f22070c), zzlmVar.f22072e);
                    }
                    zzau zzauVar6 = zzacVar3.zzi;
                    if (zzauVar6 != null) {
                        arrayList2.add(zzauVar6);
                    }
                    zzacVar3.zzc = new zzlk(zzlmVar);
                    zzacVar3.zze = true;
                    zzak zzakVar9 = this.f22043c;
                    L(zzakVar9);
                    zzakVar9.n(zzacVar3);
                }
            }
            x(zzauVar2, zzqVar);
            for (zzau zzauVar7 : arrayList2) {
                x(new zzau(zzauVar7, j4), zzqVar);
            }
            zzak zzakVar10 = this.f22043c;
            L(zzakVar10);
            zzakVar10.f();
        } finally {
            zzak zzakVar11 = this.f22043c;
            L(zzakVar11);
            zzakVar11.zzx();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @WorkerThread
    public final void f(zzau zzauVar, String str) {
        zzak zzakVar = this.f22043c;
        L(zzakVar);
        zzh I = zzakVar.I(str);
        if (I != null && !TextUtils.isEmpty(I.o0())) {
            Boolean D = D(I);
            if (D == null) {
                if (!"_ui".equals(zzauVar.zza)) {
                    zzaA().zzk().zzb("Could not find package. appId", zzet.f(str));
                }
            } else if (!D.booleanValue()) {
                zzaA().zzd().zzb("App version does not match; dropping event. appId", zzet.f(str));
                return;
            }
            String a4 = I.a();
            String o02 = I.o0();
            long R = I.R();
            String n02 = I.n0();
            long c02 = I.c0();
            long Z = I.Z();
            boolean O = I.O();
            String p02 = I.p0();
            I.A();
            g(zzauVar, new zzq(str, a4, o02, R, n02, c02, Z, (String) null, O, false, p02, 0L, 0L, 0, I.N(), false, I.j0(), I.i0(), I.a0(), I.e(), (String) null, P(str).zzi(), "", (String) null, I.Q(), I.h0()));
            return;
        }
        zzaA().zzc().zzb("No app data available; dropping event", str);
    }

    @WorkerThread
    final void g(zzau zzauVar, zzq zzqVar) {
        Preconditions.checkNotEmpty(zzqVar.zza);
        zzeu zzb = zzeu.zzb(zzauVar);
        zzlp zzv = zzv();
        Bundle bundle = zzb.zzd;
        zzak zzakVar = this.f22043c;
        L(zzakVar);
        zzv.k(bundle, zzakVar.H(zzqVar.zza));
        zzv().m(zzb, zzg().zzd(zzqVar.zza));
        zzau zza = zzb.zza();
        if (Constants.ScionAnalytics.EVENT_FIREBASE_CAMPAIGN.equals(zza.zza) && "referrer API v2".equals(zza.zzb.f("_cis"))) {
            String f4 = zza.zzb.f("gclid");
            if (!TextUtils.isEmpty(f4)) {
                v(new zzlk("_lgclid", zza.zzd, f4, DebugKt.DEBUG_PROPERTY_VALUE_AUTO), zzqVar);
            }
        }
        e(zza, zzqVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void h() {
        this.f22058r++;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Removed duplicated region for block: B:16:0x004a A[Catch: all -> 0x0177, TryCatch #2 {all -> 0x0181, blocks: (B:4:0x0010, B:5:0x0012, B:62:0x0169, B:6:0x002c, B:16:0x004a, B:61:0x0161, B:21:0x0064, B:26:0x00b6, B:25:0x00a7, B:29:0x00be, B:32:0x00ca, B:34:0x00d0, B:37:0x00da, B:40:0x00e6, B:42:0x00ec, B:47:0x00f9, B:51:0x0115, B:53:0x012a, B:55:0x0149, B:57:0x0154, B:59:0x015a, B:60:0x015e, B:54:0x0138, B:48:0x0102, B:50:0x010d), top: B:71:0x0010 }] */
    /* JADX WARN: Removed duplicated region for block: B:17:0x005d  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x012a A[Catch: all -> 0x0177, TryCatch #2 {all -> 0x0181, blocks: (B:4:0x0010, B:5:0x0012, B:62:0x0169, B:6:0x002c, B:16:0x004a, B:61:0x0161, B:21:0x0064, B:26:0x00b6, B:25:0x00a7, B:29:0x00be, B:32:0x00ca, B:34:0x00d0, B:37:0x00da, B:40:0x00e6, B:42:0x00ec, B:47:0x00f9, B:51:0x0115, B:53:0x012a, B:55:0x0149, B:57:0x0154, B:59:0x015a, B:60:0x015e, B:54:0x0138, B:48:0x0102, B:50:0x010d), top: B:71:0x0010 }] */
    /* JADX WARN: Removed duplicated region for block: B:54:0x0138 A[Catch: all -> 0x0177, TryCatch #2 {all -> 0x0181, blocks: (B:4:0x0010, B:5:0x0012, B:62:0x0169, B:6:0x002c, B:16:0x004a, B:61:0x0161, B:21:0x0064, B:26:0x00b6, B:25:0x00a7, B:29:0x00be, B:32:0x00ca, B:34:0x00d0, B:37:0x00da, B:40:0x00e6, B:42:0x00ec, B:47:0x00f9, B:51:0x0115, B:53:0x012a, B:55:0x0149, B:57:0x0154, B:59:0x015a, B:60:0x015e, B:54:0x0138, B:48:0x0102, B:50:0x010d), top: B:71:0x0010 }] */
    @androidx.annotation.VisibleForTesting
    @androidx.annotation.WorkerThread
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void i(java.lang.String r8, int r9, java.lang.Throwable r10, byte[] r11, java.util.Map r12) {
        /*
            Method dump skipped, instructions count: 392
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzlh.i(java.lang.String, int, java.lang.Throwable, byte[], java.util.Map):void");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void j(boolean z3) {
        G();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @VisibleForTesting
    @WorkerThread
    public final void k(int i4, Throwable th, byte[] bArr, String str) {
        zzak zzakVar;
        long longValue;
        zzaB().zzg();
        b();
        if (bArr == null) {
            try {
                bArr = new byte[0];
            } finally {
                this.f22060t = false;
                E();
            }
        }
        List<Long> list = (List) Preconditions.checkNotNull(this.f22064x);
        this.f22064x = null;
        if (i4 != 200) {
            if (i4 == 204) {
                i4 = 204;
            }
            zzaA().zzj().zzc("Network upload failed. Will retry later. code, error", Integer.valueOf(i4), th);
            this.f22049i.zzd.zzb(zzax().currentTimeMillis());
            if (i4 != 503 || i4 == 429) {
                this.f22049i.zzb.zzb(zzax().currentTimeMillis());
            }
            zzak zzakVar2 = this.f22043c;
            L(zzakVar2);
            zzakVar2.U(list);
            G();
        }
        if (th == null) {
            try {
                this.f22049i.zzc.zzb(zzax().currentTimeMillis());
                this.f22049i.zzd.zzb(0L);
                G();
                zzaA().zzj().zzc("Successful upload. Got network response. code, size", Integer.valueOf(i4), Integer.valueOf(bArr.length));
                zzak zzakVar3 = this.f22043c;
                L(zzakVar3);
                zzakVar3.zzw();
                try {
                    for (Long l4 : list) {
                        try {
                            zzakVar = this.f22043c;
                            L(zzakVar);
                            longValue = l4.longValue();
                            zzakVar.zzg();
                            zzakVar.a();
                            try {
                            } catch (SQLiteException e4) {
                                zzakVar.f21734a.zzaA().zzd().zzb("Failed to delete a bundle in a queue table", e4);
                                throw e4;
                                break;
                            }
                        } catch (SQLiteException e5) {
                            List list2 = this.f22065y;
                            if (list2 == null || !list2.contains(l4)) {
                                throw e5;
                            }
                        }
                        if (zzakVar.G().delete("queue", "rowid=?", new String[]{String.valueOf(longValue)}) != 1) {
                            throw new SQLiteException("Deleted fewer rows from queue than expected");
                            break;
                        }
                    }
                    zzak zzakVar4 = this.f22043c;
                    L(zzakVar4);
                    zzakVar4.f();
                    zzak zzakVar5 = this.f22043c;
                    L(zzakVar5);
                    zzakVar5.zzx();
                    this.f22065y = null;
                    zzez zzezVar = this.f22042b;
                    L(zzezVar);
                    if (zzezVar.zza() && I()) {
                        w();
                    } else {
                        this.f22066z = -1L;
                        G();
                    }
                    this.f22055o = 0L;
                } catch (Throwable th2) {
                    zzak zzakVar6 = this.f22043c;
                    L(zzakVar6);
                    zzakVar6.zzx();
                    throw th2;
                }
            } catch (SQLiteException e6) {
                zzaA().zzd().zzb("Database error while trying to delete uploaded bundles", e6);
                this.f22055o = zzax().elapsedRealtime();
                zzaA().zzj().zzb("Disable upload, time", Long.valueOf(this.f22055o));
            }
        }
        zzaA().zzj().zzc("Network upload failed. Will retry later. code, error", Integer.valueOf(i4), th);
        this.f22049i.zzd.zzb(zzax().currentTimeMillis());
        if (i4 != 503) {
        }
        this.f22049i.zzb.zzb(zzax().currentTimeMillis());
        zzak zzakVar22 = this.f22043c;
        L(zzakVar22);
        zzakVar22.U(list);
        G();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Can't wrap try/catch for region: R(6:(2:96|97)|(2:99|(8:101|(3:103|(2:105|(1:107))(1:126)|108)(1:127)|109|(1:111)(1:125)|112|113|114|(4:116|(1:118)|119|(1:121))))|128|113|114|(0)) */
    /* JADX WARN: Code restructure failed: missing block: B:160:0x04a6, code lost:
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:161:0x04a7, code lost:
        zzaA().zzd().zzc("Application info is null, first open report might be inaccurate. appId", com.google.android.gms.measurement.internal.zzet.f(r3), r0);
        r3 = r10;
     */
    /* JADX WARN: Removed duplicated region for block: B:129:0x03d8 A[Catch: all -> 0x0570, TryCatch #0 {all -> 0x0570, blocks: (B:23:0x00a6, B:25:0x00b6, B:43:0x00fd, B:45:0x0110, B:47:0x0126, B:48:0x014d, B:50:0x01a7, B:52:0x01ac, B:54:0x01b2, B:56:0x01bb, B:68:0x01f5, B:70:0x0200, B:74:0x020d, B:77:0x021b, B:81:0x0226, B:83:0x0229, B:84:0x0249, B:86:0x024e, B:89:0x026d, B:92:0x0281, B:94:0x02a8, B:97:0x02b0, B:99:0x02bf, B:127:0x03a4, B:129:0x03d8, B:130:0x03db, B:132:0x0404, B:171:0x04db, B:172:0x04de, B:180:0x055f, B:134:0x0419, B:139:0x043e, B:141:0x0446, B:143:0x0450, B:147:0x0463, B:151:0x0474, B:155:0x0480, B:158:0x0496, B:161:0x04a7, B:163:0x04bb, B:165:0x04c1, B:166:0x04c8, B:168:0x04ce, B:149:0x046c, B:137:0x042a, B:100:0x02d0, B:102:0x02fb, B:103:0x030c, B:105:0x0313, B:107:0x0319, B:109:0x0323, B:111:0x0329, B:113:0x032f, B:115:0x0335, B:116:0x033a, B:120:0x035c, B:123:0x0361, B:124:0x0375, B:125:0x0385, B:126:0x0395, B:173:0x04f5, B:175:0x0526, B:176:0x0529, B:177:0x0540, B:179:0x0544, B:87:0x025d, B:64:0x01da, B:29:0x00c3, B:31:0x00c7, B:35:0x00d8, B:37:0x00e9, B:39:0x00f3, B:42:0x00fa), top: B:187:0x00a6, inners: #1, #2, #5 }] */
    /* JADX WARN: Removed duplicated region for block: B:132:0x0404 A[Catch: all -> 0x0570, TRY_LEAVE, TryCatch #0 {all -> 0x0570, blocks: (B:23:0x00a6, B:25:0x00b6, B:43:0x00fd, B:45:0x0110, B:47:0x0126, B:48:0x014d, B:50:0x01a7, B:52:0x01ac, B:54:0x01b2, B:56:0x01bb, B:68:0x01f5, B:70:0x0200, B:74:0x020d, B:77:0x021b, B:81:0x0226, B:83:0x0229, B:84:0x0249, B:86:0x024e, B:89:0x026d, B:92:0x0281, B:94:0x02a8, B:97:0x02b0, B:99:0x02bf, B:127:0x03a4, B:129:0x03d8, B:130:0x03db, B:132:0x0404, B:171:0x04db, B:172:0x04de, B:180:0x055f, B:134:0x0419, B:139:0x043e, B:141:0x0446, B:143:0x0450, B:147:0x0463, B:151:0x0474, B:155:0x0480, B:158:0x0496, B:161:0x04a7, B:163:0x04bb, B:165:0x04c1, B:166:0x04c8, B:168:0x04ce, B:149:0x046c, B:137:0x042a, B:100:0x02d0, B:102:0x02fb, B:103:0x030c, B:105:0x0313, B:107:0x0319, B:109:0x0323, B:111:0x0329, B:113:0x032f, B:115:0x0335, B:116:0x033a, B:120:0x035c, B:123:0x0361, B:124:0x0375, B:125:0x0385, B:126:0x0395, B:173:0x04f5, B:175:0x0526, B:176:0x0529, B:177:0x0540, B:179:0x0544, B:87:0x025d, B:64:0x01da, B:29:0x00c3, B:31:0x00c7, B:35:0x00d8, B:37:0x00e9, B:39:0x00f3, B:42:0x00fa), top: B:187:0x00a6, inners: #1, #2, #5 }] */
    /* JADX WARN: Removed duplicated region for block: B:163:0x04bb A[Catch: all -> 0x0570, TryCatch #0 {all -> 0x0570, blocks: (B:23:0x00a6, B:25:0x00b6, B:43:0x00fd, B:45:0x0110, B:47:0x0126, B:48:0x014d, B:50:0x01a7, B:52:0x01ac, B:54:0x01b2, B:56:0x01bb, B:68:0x01f5, B:70:0x0200, B:74:0x020d, B:77:0x021b, B:81:0x0226, B:83:0x0229, B:84:0x0249, B:86:0x024e, B:89:0x026d, B:92:0x0281, B:94:0x02a8, B:97:0x02b0, B:99:0x02bf, B:127:0x03a4, B:129:0x03d8, B:130:0x03db, B:132:0x0404, B:171:0x04db, B:172:0x04de, B:180:0x055f, B:134:0x0419, B:139:0x043e, B:141:0x0446, B:143:0x0450, B:147:0x0463, B:151:0x0474, B:155:0x0480, B:158:0x0496, B:161:0x04a7, B:163:0x04bb, B:165:0x04c1, B:166:0x04c8, B:168:0x04ce, B:149:0x046c, B:137:0x042a, B:100:0x02d0, B:102:0x02fb, B:103:0x030c, B:105:0x0313, B:107:0x0319, B:109:0x0323, B:111:0x0329, B:113:0x032f, B:115:0x0335, B:116:0x033a, B:120:0x035c, B:123:0x0361, B:124:0x0375, B:125:0x0385, B:126:0x0395, B:173:0x04f5, B:175:0x0526, B:176:0x0529, B:177:0x0540, B:179:0x0544, B:87:0x025d, B:64:0x01da, B:29:0x00c3, B:31:0x00c7, B:35:0x00d8, B:37:0x00e9, B:39:0x00f3, B:42:0x00fa), top: B:187:0x00a6, inners: #1, #2, #5 }] */
    /* JADX WARN: Removed duplicated region for block: B:171:0x04db A[Catch: all -> 0x0570, TryCatch #0 {all -> 0x0570, blocks: (B:23:0x00a6, B:25:0x00b6, B:43:0x00fd, B:45:0x0110, B:47:0x0126, B:48:0x014d, B:50:0x01a7, B:52:0x01ac, B:54:0x01b2, B:56:0x01bb, B:68:0x01f5, B:70:0x0200, B:74:0x020d, B:77:0x021b, B:81:0x0226, B:83:0x0229, B:84:0x0249, B:86:0x024e, B:89:0x026d, B:92:0x0281, B:94:0x02a8, B:97:0x02b0, B:99:0x02bf, B:127:0x03a4, B:129:0x03d8, B:130:0x03db, B:132:0x0404, B:171:0x04db, B:172:0x04de, B:180:0x055f, B:134:0x0419, B:139:0x043e, B:141:0x0446, B:143:0x0450, B:147:0x0463, B:151:0x0474, B:155:0x0480, B:158:0x0496, B:161:0x04a7, B:163:0x04bb, B:165:0x04c1, B:166:0x04c8, B:168:0x04ce, B:149:0x046c, B:137:0x042a, B:100:0x02d0, B:102:0x02fb, B:103:0x030c, B:105:0x0313, B:107:0x0319, B:109:0x0323, B:111:0x0329, B:113:0x032f, B:115:0x0335, B:116:0x033a, B:120:0x035c, B:123:0x0361, B:124:0x0375, B:125:0x0385, B:126:0x0395, B:173:0x04f5, B:175:0x0526, B:176:0x0529, B:177:0x0540, B:179:0x0544, B:87:0x025d, B:64:0x01da, B:29:0x00c3, B:31:0x00c7, B:35:0x00d8, B:37:0x00e9, B:39:0x00f3, B:42:0x00fa), top: B:187:0x00a6, inners: #1, #2, #5 }] */
    /* JADX WARN: Removed duplicated region for block: B:177:0x0540 A[Catch: all -> 0x0570, TryCatch #0 {all -> 0x0570, blocks: (B:23:0x00a6, B:25:0x00b6, B:43:0x00fd, B:45:0x0110, B:47:0x0126, B:48:0x014d, B:50:0x01a7, B:52:0x01ac, B:54:0x01b2, B:56:0x01bb, B:68:0x01f5, B:70:0x0200, B:74:0x020d, B:77:0x021b, B:81:0x0226, B:83:0x0229, B:84:0x0249, B:86:0x024e, B:89:0x026d, B:92:0x0281, B:94:0x02a8, B:97:0x02b0, B:99:0x02bf, B:127:0x03a4, B:129:0x03d8, B:130:0x03db, B:132:0x0404, B:171:0x04db, B:172:0x04de, B:180:0x055f, B:134:0x0419, B:139:0x043e, B:141:0x0446, B:143:0x0450, B:147:0x0463, B:151:0x0474, B:155:0x0480, B:158:0x0496, B:161:0x04a7, B:163:0x04bb, B:165:0x04c1, B:166:0x04c8, B:168:0x04ce, B:149:0x046c, B:137:0x042a, B:100:0x02d0, B:102:0x02fb, B:103:0x030c, B:105:0x0313, B:107:0x0319, B:109:0x0323, B:111:0x0329, B:113:0x032f, B:115:0x0335, B:116:0x033a, B:120:0x035c, B:123:0x0361, B:124:0x0375, B:125:0x0385, B:126:0x0395, B:173:0x04f5, B:175:0x0526, B:176:0x0529, B:177:0x0540, B:179:0x0544, B:87:0x025d, B:64:0x01da, B:29:0x00c3, B:31:0x00c7, B:35:0x00d8, B:37:0x00e9, B:39:0x00f3, B:42:0x00fa), top: B:187:0x00a6, inners: #1, #2, #5 }] */
    /* JADX WARN: Removed duplicated region for block: B:189:0x0419 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:68:0x01f5 A[Catch: all -> 0x0570, TryCatch #0 {all -> 0x0570, blocks: (B:23:0x00a6, B:25:0x00b6, B:43:0x00fd, B:45:0x0110, B:47:0x0126, B:48:0x014d, B:50:0x01a7, B:52:0x01ac, B:54:0x01b2, B:56:0x01bb, B:68:0x01f5, B:70:0x0200, B:74:0x020d, B:77:0x021b, B:81:0x0226, B:83:0x0229, B:84:0x0249, B:86:0x024e, B:89:0x026d, B:92:0x0281, B:94:0x02a8, B:97:0x02b0, B:99:0x02bf, B:127:0x03a4, B:129:0x03d8, B:130:0x03db, B:132:0x0404, B:171:0x04db, B:172:0x04de, B:180:0x055f, B:134:0x0419, B:139:0x043e, B:141:0x0446, B:143:0x0450, B:147:0x0463, B:151:0x0474, B:155:0x0480, B:158:0x0496, B:161:0x04a7, B:163:0x04bb, B:165:0x04c1, B:166:0x04c8, B:168:0x04ce, B:149:0x046c, B:137:0x042a, B:100:0x02d0, B:102:0x02fb, B:103:0x030c, B:105:0x0313, B:107:0x0319, B:109:0x0323, B:111:0x0329, B:113:0x032f, B:115:0x0335, B:116:0x033a, B:120:0x035c, B:123:0x0361, B:124:0x0375, B:125:0x0385, B:126:0x0395, B:173:0x04f5, B:175:0x0526, B:176:0x0529, B:177:0x0540, B:179:0x0544, B:87:0x025d, B:64:0x01da, B:29:0x00c3, B:31:0x00c7, B:35:0x00d8, B:37:0x00e9, B:39:0x00f3, B:42:0x00fa), top: B:187:0x00a6, inners: #1, #2, #5 }] */
    /* JADX WARN: Removed duplicated region for block: B:86:0x024e A[Catch: all -> 0x0570, TryCatch #0 {all -> 0x0570, blocks: (B:23:0x00a6, B:25:0x00b6, B:43:0x00fd, B:45:0x0110, B:47:0x0126, B:48:0x014d, B:50:0x01a7, B:52:0x01ac, B:54:0x01b2, B:56:0x01bb, B:68:0x01f5, B:70:0x0200, B:74:0x020d, B:77:0x021b, B:81:0x0226, B:83:0x0229, B:84:0x0249, B:86:0x024e, B:89:0x026d, B:92:0x0281, B:94:0x02a8, B:97:0x02b0, B:99:0x02bf, B:127:0x03a4, B:129:0x03d8, B:130:0x03db, B:132:0x0404, B:171:0x04db, B:172:0x04de, B:180:0x055f, B:134:0x0419, B:139:0x043e, B:141:0x0446, B:143:0x0450, B:147:0x0463, B:151:0x0474, B:155:0x0480, B:158:0x0496, B:161:0x04a7, B:163:0x04bb, B:165:0x04c1, B:166:0x04c8, B:168:0x04ce, B:149:0x046c, B:137:0x042a, B:100:0x02d0, B:102:0x02fb, B:103:0x030c, B:105:0x0313, B:107:0x0319, B:109:0x0323, B:111:0x0329, B:113:0x032f, B:115:0x0335, B:116:0x033a, B:120:0x035c, B:123:0x0361, B:124:0x0375, B:125:0x0385, B:126:0x0395, B:173:0x04f5, B:175:0x0526, B:176:0x0529, B:177:0x0540, B:179:0x0544, B:87:0x025d, B:64:0x01da, B:29:0x00c3, B:31:0x00c7, B:35:0x00d8, B:37:0x00e9, B:39:0x00f3, B:42:0x00fa), top: B:187:0x00a6, inners: #1, #2, #5 }] */
    /* JADX WARN: Removed duplicated region for block: B:87:0x025d A[Catch: all -> 0x0570, TryCatch #0 {all -> 0x0570, blocks: (B:23:0x00a6, B:25:0x00b6, B:43:0x00fd, B:45:0x0110, B:47:0x0126, B:48:0x014d, B:50:0x01a7, B:52:0x01ac, B:54:0x01b2, B:56:0x01bb, B:68:0x01f5, B:70:0x0200, B:74:0x020d, B:77:0x021b, B:81:0x0226, B:83:0x0229, B:84:0x0249, B:86:0x024e, B:89:0x026d, B:92:0x0281, B:94:0x02a8, B:97:0x02b0, B:99:0x02bf, B:127:0x03a4, B:129:0x03d8, B:130:0x03db, B:132:0x0404, B:171:0x04db, B:172:0x04de, B:180:0x055f, B:134:0x0419, B:139:0x043e, B:141:0x0446, B:143:0x0450, B:147:0x0463, B:151:0x0474, B:155:0x0480, B:158:0x0496, B:161:0x04a7, B:163:0x04bb, B:165:0x04c1, B:166:0x04c8, B:168:0x04ce, B:149:0x046c, B:137:0x042a, B:100:0x02d0, B:102:0x02fb, B:103:0x030c, B:105:0x0313, B:107:0x0319, B:109:0x0323, B:111:0x0329, B:113:0x032f, B:115:0x0335, B:116:0x033a, B:120:0x035c, B:123:0x0361, B:124:0x0375, B:125:0x0385, B:126:0x0395, B:173:0x04f5, B:175:0x0526, B:176:0x0529, B:177:0x0540, B:179:0x0544, B:87:0x025d, B:64:0x01da, B:29:0x00c3, B:31:0x00c7, B:35:0x00d8, B:37:0x00e9, B:39:0x00f3, B:42:0x00fa), top: B:187:0x00a6, inners: #1, #2, #5 }] */
    /* JADX WARN: Removed duplicated region for block: B:89:0x026d A[Catch: all -> 0x0570, TRY_LEAVE, TryCatch #0 {all -> 0x0570, blocks: (B:23:0x00a6, B:25:0x00b6, B:43:0x00fd, B:45:0x0110, B:47:0x0126, B:48:0x014d, B:50:0x01a7, B:52:0x01ac, B:54:0x01b2, B:56:0x01bb, B:68:0x01f5, B:70:0x0200, B:74:0x020d, B:77:0x021b, B:81:0x0226, B:83:0x0229, B:84:0x0249, B:86:0x024e, B:89:0x026d, B:92:0x0281, B:94:0x02a8, B:97:0x02b0, B:99:0x02bf, B:127:0x03a4, B:129:0x03d8, B:130:0x03db, B:132:0x0404, B:171:0x04db, B:172:0x04de, B:180:0x055f, B:134:0x0419, B:139:0x043e, B:141:0x0446, B:143:0x0450, B:147:0x0463, B:151:0x0474, B:155:0x0480, B:158:0x0496, B:161:0x04a7, B:163:0x04bb, B:165:0x04c1, B:166:0x04c8, B:168:0x04ce, B:149:0x046c, B:137:0x042a, B:100:0x02d0, B:102:0x02fb, B:103:0x030c, B:105:0x0313, B:107:0x0319, B:109:0x0323, B:111:0x0329, B:113:0x032f, B:115:0x0335, B:116:0x033a, B:120:0x035c, B:123:0x0361, B:124:0x0375, B:125:0x0385, B:126:0x0395, B:173:0x04f5, B:175:0x0526, B:176:0x0529, B:177:0x0540, B:179:0x0544, B:87:0x025d, B:64:0x01da, B:29:0x00c3, B:31:0x00c7, B:35:0x00d8, B:37:0x00e9, B:39:0x00f3, B:42:0x00fa), top: B:187:0x00a6, inners: #1, #2, #5 }] */
    @androidx.annotation.WorkerThread
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void l(com.google.android.gms.measurement.internal.zzq r24) {
        /*
            Method dump skipped, instructions count: 1403
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzlh.l(com.google.android.gms.measurement.internal.zzq):void");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void m() {
        this.f22057q++;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @WorkerThread
    public final void n(zzac zzacVar) {
        zzq C = C((String) Preconditions.checkNotNull(zzacVar.zza));
        if (C != null) {
            o(zzacVar, C);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @WorkerThread
    public final void o(zzac zzacVar, zzq zzqVar) {
        Bundle bundle;
        Preconditions.checkNotNull(zzacVar);
        Preconditions.checkNotEmpty(zzacVar.zza);
        Preconditions.checkNotNull(zzacVar.zzc);
        Preconditions.checkNotEmpty(zzacVar.zzc.zzb);
        zzaB().zzg();
        b();
        if (!K(zzqVar)) {
            return;
        }
        if (zzqVar.zzh) {
            zzak zzakVar = this.f22043c;
            L(zzakVar);
            zzakVar.zzw();
            try {
                M(zzqVar);
                String str = (String) Preconditions.checkNotNull(zzacVar.zza);
                zzak zzakVar2 = this.f22043c;
                L(zzakVar2);
                zzac J = zzakVar2.J(str, zzacVar.zzc.zzb);
                if (J != null) {
                    zzaA().zzc().zzc("Removing conditional user property", zzacVar.zza, this.f22052l.zzj().f(zzacVar.zzc.zzb));
                    zzak zzakVar3 = this.f22043c;
                    L(zzakVar3);
                    zzakVar3.A(str, zzacVar.zzc.zzb);
                    if (J.zze) {
                        zzak zzakVar4 = this.f22043c;
                        L(zzakVar4);
                        zzakVar4.d(str, zzacVar.zzc.zzb);
                    }
                    zzau zzauVar = zzacVar.zzk;
                    if (zzauVar != null) {
                        zzas zzasVar = zzauVar.zzb;
                        if (zzasVar != null) {
                            bundle = zzasVar.zzc();
                        } else {
                            bundle = null;
                        }
                        x((zzau) Preconditions.checkNotNull(zzv().V(str, ((zzau) Preconditions.checkNotNull(zzacVar.zzk)).zza, bundle, J.zzb, zzacVar.zzk.zzd, true, true)), zzqVar);
                    }
                } else {
                    zzaA().zzk().zzc("Conditional user property doesn't exist", zzet.f(zzacVar.zza), this.f22052l.zzj().f(zzacVar.zzc.zzb));
                }
                zzak zzakVar5 = this.f22043c;
                L(zzakVar5);
                zzakVar5.f();
                return;
            } finally {
                zzak zzakVar6 = this.f22043c;
                L(zzakVar6);
                zzakVar6.zzx();
            }
        }
        M(zzqVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @WorkerThread
    public final void p(String str, zzq zzqVar) {
        long j4;
        zzaB().zzg();
        b();
        if (!K(zzqVar)) {
            return;
        }
        if (!zzqVar.zzh) {
            M(zzqVar);
        } else if ("_npa".equals(str) && zzqVar.zzr != null) {
            zzaA().zzc().zza("Falling back to manifest metadata value for ad personalization");
            long currentTimeMillis = zzax().currentTimeMillis();
            if (true != zzqVar.zzr.booleanValue()) {
                j4 = 0;
            } else {
                j4 = 1;
            }
            v(new zzlk("_npa", currentTimeMillis, Long.valueOf(j4), DebugKt.DEBUG_PROPERTY_VALUE_AUTO), zzqVar);
        } else {
            zzaA().zzc().zzb("Removing user property", this.f22052l.zzj().f(str));
            zzak zzakVar = this.f22043c;
            L(zzakVar);
            zzakVar.zzw();
            try {
                M(zzqVar);
                if (Miui3DFaceManagerImpl.TABLE_TEMPLATE_COLUMN_ID.equals(str)) {
                    zzak zzakVar2 = this.f22043c;
                    L(zzakVar2);
                    zzakVar2.d((String) Preconditions.checkNotNull(zzqVar.zza), "_lair");
                }
                zzak zzakVar3 = this.f22043c;
                L(zzakVar3);
                zzakVar3.d((String) Preconditions.checkNotNull(zzqVar.zza), str);
                zzak zzakVar4 = this.f22043c;
                L(zzakVar4);
                zzakVar4.f();
                zzaA().zzc().zzb("User property removed", this.f22052l.zzj().f(str));
            } finally {
                zzak zzakVar5 = this.f22043c;
                L(zzakVar5);
                zzakVar5.zzx();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @VisibleForTesting
    @WorkerThread
    public final void q(zzq zzqVar) {
        if (this.f22064x != null) {
            ArrayList arrayList = new ArrayList();
            this.f22065y = arrayList;
            arrayList.addAll(this.f22064x);
        }
        zzak zzakVar = this.f22043c;
        L(zzakVar);
        String str = (String) Preconditions.checkNotNull(zzqVar.zza);
        Preconditions.checkNotEmpty(str);
        zzakVar.zzg();
        zzakVar.a();
        try {
            SQLiteDatabase G = zzakVar.G();
            String[] strArr = {str};
            int delete = G.delete("apps", "app_id=?", strArr) + G.delete("events", "app_id=?", strArr) + G.delete("user_attributes", "app_id=?", strArr) + G.delete("conditional_properties", "app_id=?", strArr) + G.delete("raw_events", "app_id=?", strArr) + G.delete("raw_events_metadata", "app_id=?", strArr) + G.delete("queue", "app_id=?", strArr) + G.delete("audience_filter_values", "app_id=?", strArr) + G.delete("main_event_params", "app_id=?", strArr) + G.delete("default_event_params", "app_id=?", strArr);
            if (delete > 0) {
                zzakVar.f21734a.zzaA().zzj().zzc("Reset analytics data. app, records", str, Integer.valueOf(delete));
            }
        } catch (SQLiteException e4) {
            zzakVar.f21734a.zzaA().zzd().zzc("Error resetting analytics data. appId, error", zzet.f(str), e4);
        }
        if (zzqVar.zzh) {
            l(zzqVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @WorkerThread
    public final void r() {
        zzaB().zzg();
        zzak zzakVar = this.f22043c;
        L(zzakVar);
        zzakVar.zzz();
        if (this.f22049i.zzc.zza() == 0) {
            this.f22049i.zzc.zzb(zzax().currentTimeMillis());
        }
        G();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @WorkerThread
    public final void s(zzac zzacVar) {
        zzq C = C((String) Preconditions.checkNotNull(zzacVar.zza));
        if (C != null) {
            t(zzacVar, C);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @WorkerThread
    public final void t(zzac zzacVar, zzq zzqVar) {
        Preconditions.checkNotNull(zzacVar);
        Preconditions.checkNotEmpty(zzacVar.zza);
        Preconditions.checkNotNull(zzacVar.zzb);
        Preconditions.checkNotNull(zzacVar.zzc);
        Preconditions.checkNotEmpty(zzacVar.zzc.zzb);
        zzaB().zzg();
        b();
        if (!K(zzqVar)) {
            return;
        }
        if (!zzqVar.zzh) {
            M(zzqVar);
            return;
        }
        zzac zzacVar2 = new zzac(zzacVar);
        boolean z3 = false;
        zzacVar2.zze = false;
        zzak zzakVar = this.f22043c;
        L(zzakVar);
        zzakVar.zzw();
        try {
            zzak zzakVar2 = this.f22043c;
            L(zzakVar2);
            zzac J = zzakVar2.J((String) Preconditions.checkNotNull(zzacVar2.zza), zzacVar2.zzc.zzb);
            if (J != null && !J.zzb.equals(zzacVar2.zzb)) {
                zzaA().zzk().zzd("Updating a conditional user property with different origin. name, origin, origin (from DB)", this.f22052l.zzj().f(zzacVar2.zzc.zzb), zzacVar2.zzb, J.zzb);
            }
            if (J != null && J.zze) {
                zzacVar2.zzb = J.zzb;
                zzacVar2.zzd = J.zzd;
                zzacVar2.zzh = J.zzh;
                zzacVar2.zzf = J.zzf;
                zzacVar2.zzi = J.zzi;
                zzacVar2.zze = true;
                zzlk zzlkVar = zzacVar2.zzc;
                zzacVar2.zzc = new zzlk(zzlkVar.zzb, J.zzc.zzc, zzlkVar.zza(), J.zzc.zzf);
            } else if (TextUtils.isEmpty(zzacVar2.zzf)) {
                zzlk zzlkVar2 = zzacVar2.zzc;
                zzacVar2.zzc = new zzlk(zzlkVar2.zzb, zzacVar2.zzd, zzlkVar2.zza(), zzacVar2.zzc.zzf);
                zzacVar2.zze = true;
                z3 = true;
            }
            if (zzacVar2.zze) {
                zzlk zzlkVar3 = zzacVar2.zzc;
                zzlm zzlmVar = new zzlm((String) Preconditions.checkNotNull(zzacVar2.zza), zzacVar2.zzb, zzlkVar3.zzb, zzlkVar3.zzc, Preconditions.checkNotNull(zzlkVar3.zza()));
                zzak zzakVar3 = this.f22043c;
                L(zzakVar3);
                if (zzakVar3.o(zzlmVar)) {
                    zzaA().zzc().zzd("User property updated immediately", zzacVar2.zza, this.f22052l.zzj().f(zzlmVar.f22070c), zzlmVar.f22072e);
                } else {
                    zzaA().zzd().zzd("(2)Too many active user properties, ignoring", zzet.f(zzacVar2.zza), this.f22052l.zzj().f(zzlmVar.f22070c), zzlmVar.f22072e);
                }
                if (z3 && zzacVar2.zzi != null) {
                    x(new zzau(zzacVar2.zzi, zzacVar2.zzd), zzqVar);
                }
            }
            zzak zzakVar4 = this.f22043c;
            L(zzakVar4);
            if (zzakVar4.n(zzacVar2)) {
                zzaA().zzc().zzd("Conditional property added", zzacVar2.zza, this.f22052l.zzj().f(zzacVar2.zzc.zzb), zzacVar2.zzc.zza());
            } else {
                zzaA().zzd().zzd("Too many conditional properties, ignoring", zzet.f(zzacVar2.zza), this.f22052l.zzj().f(zzacVar2.zzc.zzb), zzacVar2.zzc.zza());
            }
            zzak zzakVar5 = this.f22043c;
            L(zzakVar5);
            zzakVar5.f();
        } finally {
            zzak zzakVar6 = this.f22043c;
            L(zzakVar6);
            zzakVar6.zzx();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @WorkerThread
    public final void u(String str, zzhb zzhbVar) {
        zzaB().zzg();
        b();
        this.A.put(str, zzhbVar);
        zzak zzakVar = this.f22043c;
        L(zzakVar);
        Preconditions.checkNotNull(str);
        Preconditions.checkNotNull(zzhbVar);
        zzakVar.zzg();
        zzakVar.a();
        ContentValues contentValues = new ContentValues();
        contentValues.put("app_id", str);
        contentValues.put("consent_state", zzhbVar.zzi());
        try {
            if (zzakVar.G().insertWithOnConflict("consent_settings", null, contentValues, 5) == -1) {
                zzakVar.f21734a.zzaA().zzd().zzb("Failed to insert/update consent setting (got -1). appId", zzet.f(str));
            }
        } catch (SQLiteException e4) {
            zzakVar.f21734a.zzaA().zzd().zzc("Error storing consent setting. appId, error", zzet.f(str), e4);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @WorkerThread
    public final void v(zzlk zzlkVar, zzq zzqVar) {
        long j4;
        int i4;
        int i5;
        zzaB().zzg();
        b();
        if (!K(zzqVar)) {
            return;
        }
        if (!zzqVar.zzh) {
            M(zzqVar);
            return;
        }
        int Q = zzv().Q(zzlkVar.zzb);
        if (Q != 0) {
            zzlp zzv = zzv();
            String str = zzlkVar.zzb;
            zzg();
            String zzD = zzv.zzD(str, 24, true);
            String str2 = zzlkVar.zzb;
            if (str2 != null) {
                i5 = str2.length();
            } else {
                i5 = 0;
            }
            zzv().n(this.E, zzqVar.zza, Q, "_ev", zzD, i5);
            return;
        }
        int N = zzv().N(zzlkVar.zzb, zzlkVar.zza());
        if (N != 0) {
            zzlp zzv2 = zzv();
            String str3 = zzlkVar.zzb;
            zzg();
            String zzD2 = zzv2.zzD(str3, 24, true);
            Object zza = zzlkVar.zza();
            if (zza != null && ((zza instanceof String) || (zza instanceof CharSequence))) {
                i4 = zza.toString().length();
            } else {
                i4 = 0;
            }
            zzv().n(this.E, zzqVar.zza, N, "_ev", zzD2, i4);
            return;
        }
        Object e4 = zzv().e(zzlkVar.zzb, zzlkVar.zza());
        if (e4 == null) {
            return;
        }
        if ("_sid".equals(zzlkVar.zzb)) {
            long j5 = zzlkVar.zzc;
            String str4 = zzlkVar.zzf;
            String str5 = (String) Preconditions.checkNotNull(zzqVar.zza);
            zzak zzakVar = this.f22043c;
            L(zzakVar);
            zzlm O = zzakVar.O(str5, "_sno");
            if (O != null) {
                Object obj = O.f22072e;
                if (obj instanceof Long) {
                    j4 = ((Long) obj).longValue();
                    v(new zzlk("_sno", j5, Long.valueOf(j4 + 1), str4), zzqVar);
                }
            }
            if (O != null) {
                zzaA().zzk().zzb("Retrieved last session number from database does not contain a valid (long) value", O.f22072e);
            }
            zzak zzakVar2 = this.f22043c;
            L(zzakVar2);
            zzaq M = zzakVar2.M(str5, "_s");
            if (M != null) {
                j4 = M.f21473c;
                zzaA().zzj().zzb("Backfill the session number. Last used session number", Long.valueOf(j4));
            } else {
                j4 = 0;
            }
            v(new zzlk("_sno", j5, Long.valueOf(j4 + 1), str4), zzqVar);
        }
        zzlm zzlmVar = new zzlm((String) Preconditions.checkNotNull(zzqVar.zza), (String) Preconditions.checkNotNull(zzlkVar.zzf), zzlkVar.zzb, zzlkVar.zzc, e4);
        zzaA().zzj().zzc("Setting user property", this.f22052l.zzj().f(zzlmVar.f22070c), e4);
        zzak zzakVar3 = this.f22043c;
        L(zzakVar3);
        zzakVar3.zzw();
        try {
            if (Miui3DFaceManagerImpl.TABLE_TEMPLATE_COLUMN_ID.equals(zzlmVar.f22070c)) {
                zzak zzakVar4 = this.f22043c;
                L(zzakVar4);
                zzlm O2 = zzakVar4.O(zzqVar.zza, Miui3DFaceManagerImpl.TABLE_TEMPLATE_COLUMN_ID);
                if (O2 != null && !zzlmVar.f22072e.equals(O2.f22072e)) {
                    zzak zzakVar5 = this.f22043c;
                    L(zzakVar5);
                    zzakVar5.d(zzqVar.zza, "_lair");
                }
            }
            M(zzqVar);
            zzak zzakVar6 = this.f22043c;
            L(zzakVar6);
            boolean o4 = zzakVar6.o(zzlmVar);
            if (zzg().zzs(null, zzeg.zzaH) && "_sid".equals(zzlkVar.zzb)) {
                zzlj zzljVar = this.f22047g;
                L(zzljVar);
                long p4 = zzljVar.p(zzqVar.zzx);
                zzak zzakVar7 = this.f22043c;
                L(zzakVar7);
                zzh I = zzakVar7.I(zzqVar.zza);
                if (I != null) {
                    I.K(p4);
                    if (I.P()) {
                        zzak zzakVar8 = this.f22043c;
                        L(zzakVar8);
                        zzakVar8.g(I);
                    }
                }
            }
            zzak zzakVar9 = this.f22043c;
            L(zzakVar9);
            zzakVar9.f();
            if (!o4) {
                zzaA().zzd().zzc("Too many unique user properties are set. Ignoring user property", this.f22052l.zzj().f(zzlmVar.f22070c), zzlmVar.f22072e);
                zzv().n(this.E, zzqVar.zza, 9, null, null, 0);
            }
        } finally {
            zzak zzakVar10 = this.f22043c;
            L(zzakVar10);
            zzakVar10.zzx();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Code restructure failed: missing block: B:212:0x0506, code lost:
        if (r3 == null) goto L229;
     */
    /* JADX WARN: Code restructure failed: missing block: B:52:0x0126, code lost:
        if (r11 == null) goto L204;
     */
    /* JADX WARN: Removed duplicated region for block: B:132:0x029d A[Catch: all -> 0x052b, TryCatch #6 {all -> 0x052b, blocks: (B:3:0x0010, B:5:0x0021, B:9:0x0034, B:11:0x003a, B:13:0x004a, B:15:0x0052, B:17:0x0058, B:19:0x0063, B:21:0x0073, B:23:0x007e, B:25:0x0091, B:27:0x00b0, B:29:0x00b6, B:30:0x00b9, B:32:0x00c5, B:33:0x00dc, B:35:0x00ed, B:37:0x00f3, B:41:0x0108, B:54:0x0129, B:58:0x0130, B:59:0x0133, B:60:0x0134, B:64:0x015c, B:68:0x0164, B:73:0x0198, B:130:0x0297, B:132:0x029d, B:134:0x02a9, B:135:0x02ad, B:137:0x02b3, B:139:0x02c7, B:143:0x02d0, B:145:0x02d6, B:151:0x02fb, B:148:0x02eb, B:150:0x02f5, B:152:0x02fe, B:154:0x0319, B:158:0x0328, B:160:0x034c, B:162:0x0386, B:164:0x038b, B:166:0x0393, B:167:0x0396, B:169:0x039b, B:170:0x039e, B:172:0x03aa, B:173:0x03c0, B:174:0x03c8, B:176:0x03d9, B:178:0x03ea, B:179:0x03ff, B:181:0x040c, B:183:0x0421, B:185:0x042c, B:186:0x0435, B:182:0x041a, B:188:0x0484, B:117:0x0268, B:129:0x0294, B:192:0x049f, B:193:0x04a2, B:194:0x04a3, B:199:0x04e3, B:215:0x050a, B:217:0x0510, B:219:0x051b, B:203:0x04ec, B:224:0x0527, B:225:0x052a), top: B:234:0x0010, inners: #2 }] */
    /* JADX WARN: Removed duplicated region for block: B:217:0x0510 A[Catch: all -> 0x052b, TryCatch #6 {all -> 0x052b, blocks: (B:3:0x0010, B:5:0x0021, B:9:0x0034, B:11:0x003a, B:13:0x004a, B:15:0x0052, B:17:0x0058, B:19:0x0063, B:21:0x0073, B:23:0x007e, B:25:0x0091, B:27:0x00b0, B:29:0x00b6, B:30:0x00b9, B:32:0x00c5, B:33:0x00dc, B:35:0x00ed, B:37:0x00f3, B:41:0x0108, B:54:0x0129, B:58:0x0130, B:59:0x0133, B:60:0x0134, B:64:0x015c, B:68:0x0164, B:73:0x0198, B:130:0x0297, B:132:0x029d, B:134:0x02a9, B:135:0x02ad, B:137:0x02b3, B:139:0x02c7, B:143:0x02d0, B:145:0x02d6, B:151:0x02fb, B:148:0x02eb, B:150:0x02f5, B:152:0x02fe, B:154:0x0319, B:158:0x0328, B:160:0x034c, B:162:0x0386, B:164:0x038b, B:166:0x0393, B:167:0x0396, B:169:0x039b, B:170:0x039e, B:172:0x03aa, B:173:0x03c0, B:174:0x03c8, B:176:0x03d9, B:178:0x03ea, B:179:0x03ff, B:181:0x040c, B:183:0x0421, B:185:0x042c, B:186:0x0435, B:182:0x041a, B:188:0x0484, B:117:0x0268, B:129:0x0294, B:192:0x049f, B:193:0x04a2, B:194:0x04a3, B:199:0x04e3, B:215:0x050a, B:217:0x0510, B:219:0x051b, B:203:0x04ec, B:224:0x0527, B:225:0x052a), top: B:234:0x0010, inners: #2 }] */
    @androidx.annotation.WorkerThread
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void w() {
        /*
            Method dump skipped, instructions count: 1331
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzlh.w():void");
    }

    /*  JADX ERROR: JadxRuntimeException in pass: BlockProcessor
        jadx.core.utils.exceptions.JadxRuntimeException: Unreachable block: B:93:0x02f6
        	at jadx.core.dex.visitors.blocks.BlockProcessor.checkForUnreachableBlocks(BlockProcessor.java:81)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.processBlocksTree(BlockProcessor.java:47)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.visit(BlockProcessor.java:39)
        */
    @androidx.annotation.WorkerThread
    final void x(com.google.android.gms.measurement.internal.zzau r36, com.google.android.gms.measurement.internal.zzq r37) {
        /*
            Method dump skipped, instructions count: 2910
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzlh.x(com.google.android.gms.measurement.internal.zzau, com.google.android.gms.measurement.internal.zzq):void");
    }

    @VisibleForTesting
    @WorkerThread
    final boolean y() {
        zzaB().zzg();
        FileLock fileLock = this.f22062v;
        if (fileLock != null && fileLock.isValid()) {
            zzaA().zzj().zza("Storage concurrent access okay");
            return true;
        }
        this.f22043c.f21734a.zzf();
        try {
            FileChannel channel = new RandomAccessFile(new File(this.f22052l.zzaw().getFilesDir(), "google_app_measurement.db"), "rw").getChannel();
            this.f22063w = channel;
            FileLock tryLock = channel.tryLock();
            this.f22062v = tryLock;
            if (tryLock != null) {
                zzaA().zzj().zza("Storage concurrent access okay");
                return true;
            }
            zzaA().zzd().zza("Storage concurrent data access panic");
            return false;
        } catch (FileNotFoundException e4) {
            zzaA().zzd().zzb("Failed to acquire storage lock", e4);
            return false;
        } catch (IOException e5) {
            zzaA().zzd().zzb("Failed to access storage lock file", e5);
            return false;
        } catch (OverlappingFileLockException e6) {
            zzaA().zzk().zzb("Storage lock already acquired", e6);
            return false;
        }
    }

    final long z() {
        long currentTimeMillis = zzax().currentTimeMillis();
        zzkb zzkbVar = this.f22049i;
        zzkbVar.a();
        zzkbVar.zzg();
        long zza = zzkbVar.zze.zza();
        if (zza == 0) {
            zza = zzkbVar.f21734a.zzv().h().nextInt(86400000) + 1;
            zzkbVar.zze.zzb(zza);
        }
        return ((((currentTimeMillis + zza) / 1000) / 60) / 60) / 24;
    }

    @WorkerThread
    public final void zzR(String str, zzir zzirVar) {
        zzaB().zzg();
        String str2 = this.D;
        if (str2 != null && !str2.equals(str) && zzirVar == null) {
            return;
        }
        this.D = str;
        this.C = zzirVar;
    }

    @Override // com.google.android.gms.measurement.internal.zzgy
    public final zzet zzaA() {
        return ((zzgd) Preconditions.checkNotNull(this.f22052l)).zzaA();
    }

    @Override // com.google.android.gms.measurement.internal.zzgy
    public final zzga zzaB() {
        return ((zzgd) Preconditions.checkNotNull(this.f22052l)).zzaB();
    }

    @Override // com.google.android.gms.measurement.internal.zzgy
    public final Context zzaw() {
        return this.f22052l.zzaw();
    }

    @Override // com.google.android.gms.measurement.internal.zzgy
    public final Clock zzax() {
        return ((zzgd) Preconditions.checkNotNull(this.f22052l)).zzax();
    }

    @Override // com.google.android.gms.measurement.internal.zzgy
    public final zzab zzay() {
        throw null;
    }

    public final zzaa zzf() {
        zzaa zzaaVar = this.f22046f;
        L(zzaaVar);
        return zzaaVar;
    }

    public final zzag zzg() {
        return ((zzgd) Preconditions.checkNotNull(this.f22052l)).zzf();
    }

    public final zzak zzh() {
        zzak zzakVar = this.f22043c;
        L(zzakVar);
        return zzakVar;
    }

    public final zzeo zzi() {
        return this.f22052l.zzj();
    }

    public final zzez zzj() {
        zzez zzezVar = this.f22042b;
        L(zzezVar);
        return zzezVar;
    }

    public final zzfb zzl() {
        zzfb zzfbVar = this.f22044d;
        if (zzfbVar != null) {
            return zzfbVar;
        }
        throw new IllegalStateException("Network broadcast receiver not created");
    }

    public final zzfu zzm() {
        zzfu zzfuVar = this.f22041a;
        L(zzfuVar);
        return zzfuVar;
    }

    public final zzip zzr() {
        zzip zzipVar = this.f22048h;
        L(zzipVar);
        return zzipVar;
    }

    public final zzkb zzs() {
        return this.f22049i;
    }

    public final zzlj zzu() {
        zzlj zzljVar = this.f22047g;
        L(zzljVar);
        return zzljVar;
    }

    public final zzlp zzv() {
        return ((zzgd) Preconditions.checkNotNull(this.f22052l)).zzv();
    }
}
