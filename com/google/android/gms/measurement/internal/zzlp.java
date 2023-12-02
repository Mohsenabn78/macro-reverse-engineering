package com.google.android.gms.measurement.internal;

import android.content.ComponentName;
import android.content.Context;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.ServiceInfo;
import android.content.pm.Signature;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.RemoteException;
import android.text.TextUtils;
import androidx.annotation.WorkerThread;
import androidx.core.app.NotificationCompat;
import com.google.android.gms.common.GoogleApiAvailabilityLight;
import com.google.android.gms.common.GooglePlayServicesUtilLight;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.CollectionUtils;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.common.wrappers.Wrappers;
import com.google.android.gms.internal.measurement.zzpq;
import com.google.android.gms.measurement.api.AppMeasurementSdk;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.google.firebase.firestore.util.ExponentialBackoff;
import com.tencent.soter.core.keystore.KeyPropertiesCompact;
import dev.skomlach.biometric.compat.engine.internal.face.miui.impl.Miui3DFaceManagerImpl;
import java.io.ByteArrayInputStream;
import java.math.BigInteger;
import java.net.MalformedURLException;
import java.net.URL;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Random;
import java.util.TreeSet;
import java.util.concurrent.atomic.AtomicLong;
import javax.security.auth.x500.X500Principal;
import org.checkerframework.checker.nullness.qual.EnsuresNonNull;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@21.3.0 */
/* loaded from: classes4.dex */
public final class zzlp extends zzgx {

    /* renamed from: g  reason: collision with root package name */
    private static final String[] f22073g = {"firebase_", "google_", "ga_"};

    /* renamed from: h  reason: collision with root package name */
    private static final String[] f22074h = {"_err"};

    /* renamed from: c  reason: collision with root package name */
    private SecureRandom f22075c;

    /* renamed from: d  reason: collision with root package name */
    private final AtomicLong f22076d;

    /* renamed from: e  reason: collision with root package name */
    private int f22077e;

    /* renamed from: f  reason: collision with root package name */
    private Integer f22078f;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzlp(zzgd zzgdVar) {
        super(zzgdVar);
        this.f22078f = null;
        this.f22076d = new AtomicLong(0L);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean B(String str) {
        if (!TextUtils.isEmpty(str) && str.startsWith("_")) {
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean C(String str) {
        Preconditions.checkNotEmpty(str);
        if (str.charAt(0) == '_' && !str.equals("_ep")) {
            return false;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean D(Context context) {
        ActivityInfo receiverInfo;
        Preconditions.checkNotNull(context);
        try {
            PackageManager packageManager = context.getPackageManager();
            if (packageManager != null && (receiverInfo = packageManager.getReceiverInfo(new ComponentName(context, "com.google.android.gms.measurement.AppMeasurementReceiver"), 0)) != null) {
                if (receiverInfo.enabled) {
                    return true;
                }
            }
        } catch (PackageManager.NameNotFoundException unused) {
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean E(Context context, boolean z3) {
        Preconditions.checkNotNull(context);
        if (Build.VERSION.SDK_INT >= 24) {
            return M(context, "com.google.android.gms.measurement.AppMeasurementJobService");
        }
        return M(context, "com.google.android.gms.measurement.AppMeasurementService");
    }

    static final boolean H(Bundle bundle, int i4) {
        if (bundle == null || bundle.getLong("_err") != 0) {
            return false;
        }
        bundle.putLong("_err", i4);
        return true;
    }

    @VisibleForTesting
    static final boolean I(String str) {
        Preconditions.checkNotNull(str);
        return str.matches("^(1:\\d+:android:[a-f0-9]+|ca-app-pub-.*)$");
    }

    private final int J(String str) {
        if ("_ldl".equals(str)) {
            this.f21734a.zzf();
            return 2048;
        } else if (Miui3DFaceManagerImpl.TABLE_TEMPLATE_COLUMN_ID.equals(str)) {
            this.f21734a.zzf();
            return 256;
        } else if ("_lgclid".equals(str)) {
            this.f21734a.zzf();
            return 100;
        } else {
            this.f21734a.zzf();
            return 36;
        }
    }

    private final Object K(int i4, Object obj, boolean z3, boolean z4) {
        Parcelable[] parcelableArr;
        long j4;
        if (obj == null) {
            return null;
        }
        if (!(obj instanceof Long) && !(obj instanceof Double)) {
            if (obj instanceof Integer) {
                return Long.valueOf(((Integer) obj).intValue());
            }
            if (obj instanceof Byte) {
                return Long.valueOf(((Byte) obj).byteValue());
            }
            if (obj instanceof Short) {
                return Long.valueOf(((Short) obj).shortValue());
            }
            if (obj instanceof Boolean) {
                if (true != ((Boolean) obj).booleanValue()) {
                    j4 = 0;
                } else {
                    j4 = 1;
                }
                return Long.valueOf(j4);
            } else if (obj instanceof Float) {
                return Double.valueOf(((Float) obj).doubleValue());
            } else {
                if (!(obj instanceof String) && !(obj instanceof Character) && !(obj instanceof CharSequence)) {
                    if (!z4 || (!(obj instanceof Bundle[]) && !(obj instanceof Parcelable[]))) {
                        return null;
                    }
                    ArrayList arrayList = new ArrayList();
                    for (Parcelable parcelable : (Parcelable[]) obj) {
                        if (parcelable instanceof Bundle) {
                            Bundle T = T((Bundle) parcelable);
                            if (!T.isEmpty()) {
                                arrayList.add(T);
                            }
                        }
                    }
                    return arrayList.toArray(new Bundle[arrayList.size()]);
                }
                return zzD(obj.toString(), i4, z3);
            }
        }
        return obj;
    }

    private static boolean L(String str, String[] strArr) {
        Preconditions.checkNotNull(strArr);
        for (String str2 : strArr) {
            if (zzln.zza(str, str2)) {
                return true;
            }
        }
        return false;
    }

    private static boolean M(Context context, String str) {
        ServiceInfo serviceInfo;
        try {
            PackageManager packageManager = context.getPackageManager();
            if (packageManager != null && (serviceInfo = packageManager.getServiceInfo(new ComponentName(context, str), 0)) != null) {
                if (serviceInfo.enabled) {
                    return true;
                }
            }
        } catch (PackageManager.NameNotFoundException unused) {
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @VisibleForTesting
    public static long R(byte[] bArr) {
        boolean z3;
        Preconditions.checkNotNull(bArr);
        int length = bArr.length;
        int i4 = 0;
        if (length > 0) {
            z3 = true;
        } else {
            z3 = false;
        }
        Preconditions.checkState(z3);
        long j4 = 0;
        for (int i5 = length - 1; i5 >= 0 && i5 >= bArr.length - 8; i5--) {
            j4 += (bArr[i5] & 255) << i4;
            i4 += 8;
        }
        return j4;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static MessageDigest g() {
        MessageDigest messageDigest;
        for (int i4 = 0; i4 < 2; i4++) {
            try {
                messageDigest = MessageDigest.getInstance(KeyPropertiesCompact.DIGEST_MD5);
            } catch (NoSuchAlgorithmException unused) {
            }
            if (messageDigest != null) {
                return messageDigest;
            }
        }
        return null;
    }

    public static ArrayList zzH(List list) {
        if (list == null) {
            return new ArrayList(0);
        }
        ArrayList arrayList = new ArrayList(list.size());
        Iterator it = list.iterator();
        while (it.hasNext()) {
            zzac zzacVar = (zzac) it.next();
            Bundle bundle = new Bundle();
            bundle.putString("app_id", zzacVar.zza);
            bundle.putString("origin", zzacVar.zzb);
            bundle.putLong(AppMeasurementSdk.ConditionalUserProperty.CREATION_TIMESTAMP, zzacVar.zzd);
            bundle.putString("name", zzacVar.zzc.zzb);
            zzgz.zzb(bundle, Preconditions.checkNotNull(zzacVar.zzc.zza()));
            bundle.putBoolean(AppMeasurementSdk.ConditionalUserProperty.ACTIVE, zzacVar.zze);
            String str = zzacVar.zzf;
            if (str != null) {
                bundle.putString(AppMeasurementSdk.ConditionalUserProperty.TRIGGER_EVENT_NAME, str);
            }
            zzau zzauVar = zzacVar.zzg;
            if (zzauVar != null) {
                bundle.putString(AppMeasurementSdk.ConditionalUserProperty.TIMED_OUT_EVENT_NAME, zzauVar.zza);
                zzas zzasVar = zzauVar.zzb;
                if (zzasVar != null) {
                    bundle.putBundle(AppMeasurementSdk.ConditionalUserProperty.TIMED_OUT_EVENT_PARAMS, zzasVar.zzc());
                }
            }
            bundle.putLong(AppMeasurementSdk.ConditionalUserProperty.TRIGGER_TIMEOUT, zzacVar.zzh);
            zzau zzauVar2 = zzacVar.zzi;
            if (zzauVar2 != null) {
                bundle.putString(AppMeasurementSdk.ConditionalUserProperty.TRIGGERED_EVENT_NAME, zzauVar2.zza);
                zzas zzasVar2 = zzauVar2.zzb;
                if (zzasVar2 != null) {
                    bundle.putBundle(AppMeasurementSdk.ConditionalUserProperty.TRIGGERED_EVENT_PARAMS, zzasVar2.zzc());
                }
            }
            bundle.putLong(AppMeasurementSdk.ConditionalUserProperty.TRIGGERED_TIMESTAMP, zzacVar.zzc.zzc);
            bundle.putLong(AppMeasurementSdk.ConditionalUserProperty.TIME_TO_LIVE, zzacVar.zzj);
            zzau zzauVar3 = zzacVar.zzk;
            if (zzauVar3 != null) {
                bundle.putString(AppMeasurementSdk.ConditionalUserProperty.EXPIRED_EVENT_NAME, zzauVar3.zza);
                zzas zzasVar3 = zzauVar3.zzb;
                if (zzasVar3 != null) {
                    bundle.putBundle(AppMeasurementSdk.ConditionalUserProperty.EXPIRED_EVENT_PARAMS, zzasVar3.zzc());
                }
            }
            arrayList.add(bundle);
        }
        return arrayList;
    }

    @WorkerThread
    public static void zzK(zzir zzirVar, Bundle bundle, boolean z3) {
        if (bundle != null && zzirVar != null) {
            if (bundle.containsKey("_sc") && !z3) {
                z3 = false;
            } else {
                String str = zzirVar.zza;
                if (str != null) {
                    bundle.putString("_sn", str);
                } else {
                    bundle.remove("_sn");
                }
                String str2 = zzirVar.zzb;
                if (str2 != null) {
                    bundle.putString("_sc", str2);
                } else {
                    bundle.remove("_sc");
                }
                bundle.putLong("_si", zzirVar.zzc);
                return;
            }
        }
        if (bundle != null && zzirVar == null && z3) {
            bundle.remove("_sn");
            bundle.remove("_sc");
            bundle.remove("_si");
        }
    }

    public static boolean zzan(String str) {
        if (f22074h[0].equals(str)) {
            return false;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @VisibleForTesting
    public final boolean A(Context context, String str) {
        Signature[] signatureArr;
        X500Principal x500Principal = new X500Principal("CN=Android Debug,O=Android,C=US");
        try {
            PackageInfo packageInfo = Wrappers.packageManager(context).getPackageInfo(str, 64);
            if (packageInfo != null && (signatureArr = packageInfo.signatures) != null && signatureArr.length > 0) {
                return ((X509Certificate) CertificateFactory.getInstance("X.509").generateCertificate(new ByteArrayInputStream(signatureArr[0].toByteArray()))).getSubjectX500Principal().equals(x500Principal);
            }
            return true;
        } catch (PackageManager.NameNotFoundException e4) {
            this.f21734a.zzaA().zzd().zzb("Package name not found", e4);
            return true;
        } catch (CertificateException e5) {
            this.f21734a.zzaA().zzd().zzb("Error obtaining certificate", e5);
            return true;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final boolean F(String str, String str2, String str3, String str4) {
        boolean isEmpty = TextUtils.isEmpty(str);
        boolean isEmpty2 = TextUtils.isEmpty(str2);
        if (!isEmpty && !isEmpty2) {
            Preconditions.checkNotNull(str);
            if (!str.equals(str2)) {
                return true;
            }
            return false;
        } else if (isEmpty && isEmpty2) {
            if (!TextUtils.isEmpty(str3) && !TextUtils.isEmpty(str4)) {
                if (!str3.equals(str4)) {
                    return true;
                }
                return false;
            } else if (!TextUtils.isEmpty(str4)) {
                return true;
            } else {
                return false;
            }
        } else if (!isEmpty) {
            if (TextUtils.isEmpty(str4)) {
                return false;
            }
            if (TextUtils.isEmpty(str3) || !str3.equals(str4)) {
                return true;
            }
            return false;
        } else if (TextUtils.isEmpty(str3) || !str3.equals(str4)) {
            return true;
        } else {
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final byte[] G(Parcelable parcelable) {
        if (parcelable == null) {
            return null;
        }
        Parcel obtain = Parcel.obtain();
        try {
            parcelable.writeToParcel(obtain, 0);
            return obtain.marshall();
        } finally {
            obtain.recycle();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final int N(String str, Object obj) {
        boolean u3;
        if ("_ldl".equals(str)) {
            u3 = u("user property referrer", str, J(str), obj);
        } else {
            u3 = u("user property", str, J(str), obj);
        }
        if (u3) {
            return 0;
        }
        return 7;
    }

    final int O(String str) {
        if (!v("event param", str)) {
            return 3;
        }
        if (!t("event param", null, null, str)) {
            return 14;
        }
        this.f21734a.zzf();
        if (!r("event param", 40, str)) {
            return 3;
        }
        return 0;
    }

    final int P(String str) {
        if (!w("event param", str)) {
            return 3;
        }
        if (!t("event param", null, null, str)) {
            return 14;
        }
        this.f21734a.zzf();
        if (!r("event param", 40, str)) {
            return 3;
        }
        return 0;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final int Q(String str) {
        if (!v("user property", str)) {
            return 6;
        }
        if (!t("user property", zzhe.zza, null, str)) {
            return 15;
        }
        this.f21734a.zzf();
        if (!r("user property", 24, str)) {
            return 6;
        }
        return 0;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final Bundle S(Uri uri, boolean z3) {
        String str;
        String str2;
        String str3;
        String str4;
        String str5;
        String str6;
        String str7;
        String str8;
        if (uri == null) {
            return null;
        }
        try {
            if (uri.isHierarchical()) {
                str = uri.getQueryParameter("utm_campaign");
                str2 = uri.getQueryParameter("utm_source");
                str3 = uri.getQueryParameter("utm_medium");
                str4 = uri.getQueryParameter("gclid");
                str5 = uri.getQueryParameter("utm_id");
                str6 = uri.getQueryParameter("dclid");
                str7 = uri.getQueryParameter("srsltid");
                if (z3) {
                    str8 = uri.getQueryParameter("sfmc_id");
                } else {
                    str8 = null;
                }
            } else {
                str = null;
                str2 = null;
                str3 = null;
                str4 = null;
                str5 = null;
                str6 = null;
                str7 = null;
                str8 = null;
            }
            if (TextUtils.isEmpty(str) && TextUtils.isEmpty(str2) && TextUtils.isEmpty(str3) && TextUtils.isEmpty(str4) && TextUtils.isEmpty(str5) && TextUtils.isEmpty(str6) && TextUtils.isEmpty(str7) && (!z3 || TextUtils.isEmpty(str8))) {
                return null;
            }
            Bundle bundle = new Bundle();
            if (!TextUtils.isEmpty(str)) {
                bundle.putString("campaign", str);
            }
            if (!TextUtils.isEmpty(str2)) {
                bundle.putString("source", str2);
            }
            if (!TextUtils.isEmpty(str3)) {
                bundle.putString("medium", str3);
            }
            if (!TextUtils.isEmpty(str4)) {
                bundle.putString("gclid", str4);
            }
            String queryParameter = uri.getQueryParameter("utm_term");
            if (!TextUtils.isEmpty(queryParameter)) {
                bundle.putString(FirebaseAnalytics.Param.TERM, queryParameter);
            }
            String queryParameter2 = uri.getQueryParameter("utm_content");
            if (!TextUtils.isEmpty(queryParameter2)) {
                bundle.putString(FirebaseAnalytics.Param.CONTENT, queryParameter2);
            }
            String queryParameter3 = uri.getQueryParameter(FirebaseAnalytics.Param.ACLID);
            if (!TextUtils.isEmpty(queryParameter3)) {
                bundle.putString(FirebaseAnalytics.Param.ACLID, queryParameter3);
            }
            String queryParameter4 = uri.getQueryParameter(FirebaseAnalytics.Param.CP1);
            if (!TextUtils.isEmpty(queryParameter4)) {
                bundle.putString(FirebaseAnalytics.Param.CP1, queryParameter4);
            }
            String queryParameter5 = uri.getQueryParameter("anid");
            if (!TextUtils.isEmpty(queryParameter5)) {
                bundle.putString("anid", queryParameter5);
            }
            if (!TextUtils.isEmpty(str5)) {
                bundle.putString(FirebaseAnalytics.Param.CAMPAIGN_ID, str5);
            }
            if (!TextUtils.isEmpty(str6)) {
                bundle.putString("dclid", str6);
            }
            String queryParameter6 = uri.getQueryParameter("utm_source_platform");
            if (!TextUtils.isEmpty(queryParameter6)) {
                bundle.putString(FirebaseAnalytics.Param.SOURCE_PLATFORM, queryParameter6);
            }
            String queryParameter7 = uri.getQueryParameter("utm_creative_format");
            if (!TextUtils.isEmpty(queryParameter7)) {
                bundle.putString(FirebaseAnalytics.Param.CREATIVE_FORMAT, queryParameter7);
            }
            String queryParameter8 = uri.getQueryParameter("utm_marketing_tactic");
            if (!TextUtils.isEmpty(queryParameter8)) {
                bundle.putString(FirebaseAnalytics.Param.MARKETING_TACTIC, queryParameter8);
            }
            if (!TextUtils.isEmpty(str7)) {
                bundle.putString("srsltid", str7);
            }
            if (z3 && !TextUtils.isEmpty(str8)) {
                bundle.putString("sfmc_id", str8);
            }
            return bundle;
        } catch (UnsupportedOperationException e4) {
            this.f21734a.zzaA().zzk().zzb("Install referrer url isn't a hierarchical URI", e4);
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final Bundle T(Bundle bundle) {
        Bundle bundle2 = new Bundle();
        if (bundle != null) {
            for (String str : bundle.keySet()) {
                Object d4 = d(str, bundle.get(str));
                if (d4 == null) {
                    this.f21734a.zzaA().zzl().zzb("Param value can't be null", this.f21734a.zzj().e(str));
                } else {
                    o(bundle2, str, d4);
                }
            }
        }
        return bundle2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Removed duplicated region for block: B:39:0x00c2  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x0106 A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final android.os.Bundle U(java.lang.String r21, java.lang.String r22, android.os.Bundle r23, java.util.List r24, boolean r25) {
        /*
            Method dump skipped, instructions count: 269
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzlp.U(java.lang.String, java.lang.String, android.os.Bundle, java.util.List, boolean):android.os.Bundle");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final zzau V(String str, String str2, Bundle bundle, String str3, long j4, boolean z3, boolean z4) {
        Bundle bundle2;
        if (TextUtils.isEmpty(str2)) {
            return null;
        }
        if (zzh(str2) == 0) {
            if (bundle != null) {
                bundle2 = new Bundle(bundle);
            } else {
                bundle2 = new Bundle();
            }
            Bundle bundle3 = bundle2;
            bundle3.putString("_o", str3);
            Bundle U = U(str, str2, bundle3, CollectionUtils.listOf("_o"), true);
            if (z3) {
                U = T(U);
            }
            Preconditions.checkNotNull(U);
            return new zzau(str2, new zzas(U), str3, j4);
        }
        this.f21734a.zzaA().zzd().zzb("Invalid conditional property event name", this.f21734a.zzj().f(str2));
        throw new IllegalArgumentException();
    }

    @Override // com.google.android.gms.measurement.internal.zzgx
    @WorkerThread
    protected final void a() {
        zzg();
        SecureRandom secureRandom = new SecureRandom();
        long nextLong = secureRandom.nextLong();
        if (nextLong == 0) {
            nextLong = secureRandom.nextLong();
            if (nextLong == 0) {
                this.f21734a.zzaA().zzk().zza("Utils falling back to Random for random id");
            }
        }
        this.f22076d.set(nextLong);
    }

    @Override // com.google.android.gms.measurement.internal.zzgx
    protected final boolean b() {
        return true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final Object d(String str, Object obj) {
        int i4 = 256;
        if ("_ev".equals(str)) {
            this.f21734a.zzf();
            return K(256, obj, true, true);
        }
        if (B(str)) {
            this.f21734a.zzf();
        } else {
            this.f21734a.zzf();
            i4 = 100;
        }
        return K(i4, obj, false, true);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final Object e(String str, Object obj) {
        if ("_ldl".equals(str)) {
            return K(J(str), obj, true, false);
        }
        return K(J(str), obj, false, false);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final String f() {
        byte[] bArr = new byte[16];
        h().nextBytes(bArr);
        return String.format(Locale.US, "%032x", new BigInteger(1, bArr));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @EnsuresNonNull({"this.secureRandom"})
    @WorkerThread
    public final SecureRandom h() {
        zzg();
        if (this.f22075c == null) {
            this.f22075c = new SecureRandom();
        }
        return this.f22075c;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @WorkerThread
    public final void i(Bundle bundle, long j4) {
        long j5 = bundle.getLong("_et");
        if (j5 != 0) {
            this.f21734a.zzaA().zzk().zzb("Params already contained engagement", Long.valueOf(j5));
        } else {
            j5 = 0;
        }
        bundle.putLong("_et", j4 + j5);
    }

    final void j(Bundle bundle, int i4, String str, String str2, Object obj) {
        if (H(bundle, i4)) {
            this.f21734a.zzf();
            bundle.putString("_ev", zzD(str, 40, true));
            if (obj != null) {
                Preconditions.checkNotNull(bundle);
                if ((obj instanceof String) || (obj instanceof CharSequence)) {
                    bundle.putLong("_el", obj.toString().length());
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void k(Bundle bundle, Bundle bundle2) {
        if (bundle2 == null) {
            return;
        }
        for (String str : bundle2.keySet()) {
            if (!bundle.containsKey(str)) {
                this.f21734a.zzv().o(bundle, str, bundle2.get(str));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void l(Parcelable[] parcelableArr, int i4, boolean z3) {
        Preconditions.checkNotNull(parcelableArr);
        for (Parcelable parcelable : parcelableArr) {
            Bundle bundle = (Bundle) parcelable;
            int i5 = 0;
            for (String str : new TreeSet(bundle.keySet())) {
                if (C(str) && !L(str, zzhd.zzd) && (i5 = i5 + 1) > i4) {
                    if (z3) {
                        this.f21734a.zzaA().zze().zzc("Param can't contain more than " + i4 + " item-scoped custom parameters", this.f21734a.zzj().e(str), this.f21734a.zzj().b(bundle));
                        H(bundle, 28);
                    } else {
                        this.f21734a.zzaA().zze().zzc("Param cannot contain item-scoped custom parameters", this.f21734a.zzj().e(str), this.f21734a.zzj().b(bundle));
                        H(bundle, 23);
                    }
                    bundle.remove(str);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void m(zzeu zzeuVar, int i4) {
        int i5 = 0;
        for (String str : new TreeSet(zzeuVar.zzd.keySet())) {
            if (C(str) && (i5 = i5 + 1) > i4) {
                this.f21734a.zzaA().zze().zzc("Event can't contain more than " + i4 + " params", this.f21734a.zzj().d(zzeuVar.zza), this.f21734a.zzj().b(zzeuVar.zzd));
                H(zzeuVar.zzd, 5);
                zzeuVar.zzd.remove(str);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void n(zzlo zzloVar, String str, int i4, String str2, String str3, int i5) {
        Bundle bundle = new Bundle();
        H(bundle, i4);
        if (!TextUtils.isEmpty(str2) && !TextUtils.isEmpty(str3)) {
            bundle.putString(str2, str3);
        }
        if (i4 == 6 || i4 == 7 || i4 == 2) {
            bundle.putLong("_el", i5);
        }
        zzloVar.a(str, "_err", bundle);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void o(Bundle bundle, String str, Object obj) {
        String str2;
        if (bundle == null) {
            return;
        }
        if (obj instanceof Long) {
            bundle.putLong(str, ((Long) obj).longValue());
        } else if (obj instanceof String) {
            bundle.putString(str, String.valueOf(obj));
        } else if (obj instanceof Double) {
            bundle.putDouble(str, ((Double) obj).doubleValue());
        } else if (obj instanceof Bundle[]) {
            bundle.putParcelableArray(str, (Bundle[]) obj);
        } else if (str != null) {
            if (obj != null) {
                str2 = obj.getClass().getSimpleName();
            } else {
                str2 = null;
            }
            this.f21734a.zzaA().zzl().zzc("Not putting event parameter. Invalid value type. name, type", this.f21734a.zzj().e(str), str2);
        }
    }

    final void p(String str, String str2, String str3, Bundle bundle, List list, boolean z3) {
        int i4;
        int i5;
        int i6;
        String str4;
        int i7;
        int s3;
        int i8;
        String str5;
        String str6;
        if (bundle == null) {
            return;
        }
        zzag zzf = this.f21734a.zzf();
        zzpq.zzc();
        String str7 = null;
        if (zzf.f21734a.zzf().zzs(null, zzeg.zzaz) && zzf.f21734a.zzv().zzai(231100000, true)) {
            i4 = 35;
        } else {
            i4 = 0;
        }
        int i9 = 0;
        for (String str8 : new TreeSet(bundle.keySet())) {
            if (list != null && list.contains(str8)) {
                i6 = 0;
            } else {
                if (!z3) {
                    i5 = P(str8);
                } else {
                    i5 = 0;
                }
                if (i5 == 0) {
                    i5 = O(str8);
                }
                i6 = i5;
            }
            if (i6 != 0) {
                if (i6 == 3) {
                    str6 = str8;
                } else {
                    str6 = str7;
                }
                j(bundle, i6, str8, str8, str6);
                bundle.remove(str8);
                i8 = i4;
                str5 = str7;
            } else {
                if (z(bundle.get(str8))) {
                    this.f21734a.zzaA().zzl().zzd("Nested Bundle parameters are not allowed; discarded. event name, param name, child param name", str2, str3, str8);
                    str4 = str8;
                    i7 = i4;
                    s3 = 22;
                } else {
                    str4 = str8;
                    i7 = i4;
                    s3 = s(str, str2, str8, bundle.get(str8), bundle, list, z3, false);
                }
                if (s3 != 0 && !"_ev".equals(str4)) {
                    j(bundle, s3, str4, str4, bundle.get(str4));
                    bundle.remove(str4);
                } else if (C(str4) && !L(str4, zzhd.zzd)) {
                    int i10 = i9 + 1;
                    if (!zzai(231100000, true)) {
                        this.f21734a.zzaA().zze().zzc("Item array not supported on client's version of Google Play Services (Android Only)", this.f21734a.zzj().d(str2), this.f21734a.zzj().b(bundle));
                        H(bundle, 23);
                        bundle.remove(str4);
                        i8 = i7;
                    } else {
                        i8 = i7;
                        if (i10 > i8) {
                            zzpq.zzc();
                            str5 = null;
                            if (this.f21734a.zzf().zzs(null, zzeg.zzaz)) {
                                zzer zze = this.f21734a.zzaA().zze();
                                zze.zzc("Item can't contain more than " + i8 + " item-scoped custom params", this.f21734a.zzj().d(str2), this.f21734a.zzj().b(bundle));
                                H(bundle, 28);
                                bundle.remove(str4);
                            } else {
                                this.f21734a.zzaA().zze().zzc("Item cannot contain custom parameters", this.f21734a.zzj().d(str2), this.f21734a.zzj().b(bundle));
                                H(bundle, 23);
                                bundle.remove(str4);
                            }
                            i9 = i10;
                        }
                    }
                    str5 = null;
                    i9 = i10;
                }
                i8 = i7;
                str5 = null;
            }
            i4 = i8;
            str7 = str5;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final boolean q(String str, String str2) {
        if (!TextUtils.isEmpty(str)) {
            if (!I(str)) {
                if (this.f21734a.zzL()) {
                    this.f21734a.zzaA().zze().zzb("Invalid google_app_id. Firebase Analytics disabled. See https://goo.gl/NAOOOI. provided id", zzet.f(str));
                }
                return false;
            }
            return true;
        } else if (!TextUtils.isEmpty(str2)) {
            if (!I(str2)) {
                this.f21734a.zzaA().zze().zzb("Invalid admob_app_id. Analytics disabled.", zzet.f(str2));
                return false;
            }
            return true;
        } else {
            if (this.f21734a.zzL()) {
                this.f21734a.zzaA().zze().zza("Missing google_app_id. Firebase Analytics disabled. See https://goo.gl/NAOOOI");
            }
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final boolean r(String str, int i4, String str2) {
        if (str2 == null) {
            this.f21734a.zzaA().zze().zzb("Name is required and can't be null. Type", str);
            return false;
        } else if (str2.codePointCount(0, str2.length()) > i4) {
            this.f21734a.zzaA().zze().zzd("Name is too long. Type, maximum supported length, name", str, Integer.valueOf(i4), str2);
            return false;
        } else {
            return true;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:47:0x00d0 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:48:0x00d1  */
    @androidx.annotation.WorkerThread
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    final int s(java.lang.String r14, java.lang.String r15, java.lang.String r16, java.lang.Object r17, android.os.Bundle r18, java.util.List r19, boolean r20, boolean r21) {
        /*
            Method dump skipped, instructions count: 355
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzlp.s(java.lang.String, java.lang.String, java.lang.String, java.lang.Object, android.os.Bundle, java.util.List, boolean, boolean):int");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final boolean t(String str, String[] strArr, String[] strArr2, String str2) {
        if (str2 == null) {
            this.f21734a.zzaA().zze().zzb("Name is required and can't be null. Type", str);
            return false;
        }
        Preconditions.checkNotNull(str2);
        String[] strArr3 = f22073g;
        for (int i4 = 0; i4 < 3; i4++) {
            if (str2.startsWith(strArr3[i4])) {
                this.f21734a.zzaA().zze().zzc("Name starts with reserved prefix. Type, name", str, str2);
                return false;
            }
        }
        if (strArr != null && L(str2, strArr)) {
            if (strArr2 == null || !L(str2, strArr2)) {
                this.f21734a.zzaA().zze().zzc("Name is reserved. Type, name", str, str2);
                return false;
            }
            return true;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final boolean u(String str, String str2, int i4, Object obj) {
        if (obj != null && !(obj instanceof Long) && !(obj instanceof Float) && !(obj instanceof Integer) && !(obj instanceof Byte) && !(obj instanceof Short) && !(obj instanceof Boolean) && !(obj instanceof Double)) {
            if (!(obj instanceof String) && !(obj instanceof Character) && !(obj instanceof CharSequence)) {
                return false;
            }
            String obj2 = obj.toString();
            if (obj2.codePointCount(0, obj2.length()) > i4) {
                this.f21734a.zzaA().zzl().zzd("Value is too long; discarded. Value kind, name, value length", str, str2, Integer.valueOf(obj2.length()));
                return false;
            }
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final boolean v(String str, String str2) {
        if (str2 == null) {
            this.f21734a.zzaA().zze().zzb("Name is required and can't be null. Type", str);
            return false;
        } else if (str2.length() == 0) {
            this.f21734a.zzaA().zze().zzb("Name is required and can't be empty. Type", str);
            return false;
        } else {
            int codePointAt = str2.codePointAt(0);
            if (!Character.isLetter(codePointAt)) {
                if (codePointAt == 95) {
                    codePointAt = 95;
                } else {
                    this.f21734a.zzaA().zze().zzc("Name must start with a letter or _ (underscore). Type, name", str, str2);
                    return false;
                }
            }
            int length = str2.length();
            int charCount = Character.charCount(codePointAt);
            while (charCount < length) {
                int codePointAt2 = str2.codePointAt(charCount);
                if (codePointAt2 != 95 && !Character.isLetterOrDigit(codePointAt2)) {
                    this.f21734a.zzaA().zze().zzc("Name must consist of letters, digits or _ (underscores). Type, name", str, str2);
                    return false;
                }
                charCount += Character.charCount(codePointAt2);
            }
            return true;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final boolean w(String str, String str2) {
        if (str2 == null) {
            this.f21734a.zzaA().zze().zzb("Name is required and can't be null. Type", str);
            return false;
        } else if (str2.length() == 0) {
            this.f21734a.zzaA().zze().zzb("Name is required and can't be empty. Type", str);
            return false;
        } else {
            int codePointAt = str2.codePointAt(0);
            if (!Character.isLetter(codePointAt)) {
                this.f21734a.zzaA().zze().zzc("Name must start with a letter. Type, name", str, str2);
                return false;
            }
            int length = str2.length();
            int charCount = Character.charCount(codePointAt);
            while (charCount < length) {
                int codePointAt2 = str2.codePointAt(charCount);
                if (codePointAt2 != 95 && !Character.isLetterOrDigit(codePointAt2)) {
                    this.f21734a.zzaA().zze().zzc("Name must consist of letters, digits or _ (underscores). Type, name", str, str2);
                    return false;
                }
                charCount += Character.charCount(codePointAt2);
            }
            return true;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @WorkerThread
    public final boolean x(String str) {
        zzg();
        if (Wrappers.packageManager(this.f21734a.zzaw()).checkCallingOrSelfPermission(str) == 0) {
            return true;
        }
        this.f21734a.zzaA().zzc().zzb("Permission not granted", str);
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final boolean y(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        String zzl = this.f21734a.zzf().zzl();
        this.f21734a.zzay();
        return zzl.equals(str);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final boolean z(Object obj) {
        if (!(obj instanceof Parcelable[]) && !(obj instanceof ArrayList) && !(obj instanceof Bundle)) {
            return false;
        }
        return true;
    }

    public final String zzD(String str, int i4, boolean z3) {
        if (str == null) {
            return null;
        }
        if (str.codePointCount(0, str.length()) > i4) {
            if (!z3) {
                return null;
            }
            return String.valueOf(str.substring(0, str.offsetByCodePoints(0, i4))).concat("...");
        }
        return str;
    }

    public final URL zzE(long j4, String str, String str2, long j5) {
        try {
            Preconditions.checkNotEmpty(str2);
            Preconditions.checkNotEmpty(str);
            String format = String.format("https://www.googleadservices.com/pagead/conversion/app/deeplink?id_type=adid&sdk_version=%s&rdid=%s&bundleid=%s&retry=%s", String.format("v%s.%s", 79000L, Integer.valueOf(zzm())), str2, str, Long.valueOf(j5));
            if (str.equals(this.f21734a.zzf().zzm())) {
                format = format.concat("&ddl_test=1");
            }
            return new URL(format);
        } catch (IllegalArgumentException | MalformedURLException e4) {
            this.f21734a.zzaA().zzd().zzb("Failed to create BOW URL for Deferred Deep Link. exception", e4.getMessage());
            return null;
        }
    }

    public final void zzQ(com.google.android.gms.internal.measurement.zzcf zzcfVar, boolean z3) {
        Bundle bundle = new Bundle();
        bundle.putBoolean("r", z3);
        try {
            zzcfVar.zze(bundle);
        } catch (RemoteException e4) {
            this.f21734a.zzaA().zzk().zzb("Error returning boolean value to wrapper", e4);
        }
    }

    public final void zzR(com.google.android.gms.internal.measurement.zzcf zzcfVar, ArrayList arrayList) {
        Bundle bundle = new Bundle();
        bundle.putParcelableArrayList("r", arrayList);
        try {
            zzcfVar.zze(bundle);
        } catch (RemoteException e4) {
            this.f21734a.zzaA().zzk().zzb("Error returning bundle list to wrapper", e4);
        }
    }

    public final void zzS(com.google.android.gms.internal.measurement.zzcf zzcfVar, Bundle bundle) {
        try {
            zzcfVar.zze(bundle);
        } catch (RemoteException e4) {
            this.f21734a.zzaA().zzk().zzb("Error returning bundle value to wrapper", e4);
        }
    }

    public final void zzT(com.google.android.gms.internal.measurement.zzcf zzcfVar, byte[] bArr) {
        Bundle bundle = new Bundle();
        bundle.putByteArray("r", bArr);
        try {
            zzcfVar.zze(bundle);
        } catch (RemoteException e4) {
            this.f21734a.zzaA().zzk().zzb("Error returning byte array to wrapper", e4);
        }
    }

    public final void zzU(com.google.android.gms.internal.measurement.zzcf zzcfVar, int i4) {
        Bundle bundle = new Bundle();
        bundle.putInt("r", i4);
        try {
            zzcfVar.zze(bundle);
        } catch (RemoteException e4) {
            this.f21734a.zzaA().zzk().zzb("Error returning int value to wrapper", e4);
        }
    }

    public final void zzV(com.google.android.gms.internal.measurement.zzcf zzcfVar, long j4) {
        Bundle bundle = new Bundle();
        bundle.putLong("r", j4);
        try {
            zzcfVar.zze(bundle);
        } catch (RemoteException e4) {
            this.f21734a.zzaA().zzk().zzb("Error returning long value to wrapper", e4);
        }
    }

    public final void zzW(com.google.android.gms.internal.measurement.zzcf zzcfVar, String str) {
        Bundle bundle = new Bundle();
        bundle.putString("r", str);
        try {
            zzcfVar.zze(bundle);
        } catch (RemoteException e4) {
            this.f21734a.zzaA().zzk().zzb("Error returning string value to wrapper", e4);
        }
    }

    public final boolean zzai(int i4, boolean z3) {
        Boolean v3 = this.f21734a.zzt().v();
        if (zzm() >= i4 / 1000) {
            return true;
        }
        if (v3 != null && !v3.booleanValue()) {
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final int zzh(String str) {
        if (!v(NotificationCompat.CATEGORY_EVENT, str)) {
            return 2;
        }
        if (!t(NotificationCompat.CATEGORY_EVENT, zzhc.zza, zzhc.zzb, str)) {
            return 13;
        }
        this.f21734a.zzf();
        if (!r(NotificationCompat.CATEGORY_EVENT, 40, str)) {
            return 2;
        }
        return 0;
    }

    @EnsuresNonNull({"this.apkVersion"})
    public final int zzm() {
        if (this.f22078f == null) {
            this.f22078f = Integer.valueOf(GoogleApiAvailabilityLight.getInstance().getApkVersion(this.f21734a.zzaw()) / 1000);
        }
        return this.f22078f.intValue();
    }

    public final int zzo(int i4) {
        return GoogleApiAvailabilityLight.getInstance().isGooglePlayServicesAvailable(this.f21734a.zzaw(), GooglePlayServicesUtilLight.GOOGLE_PLAY_SERVICES_VERSION_CODE);
    }

    public final long zzq() {
        long andIncrement;
        long j4;
        if (this.f22076d.get() == 0) {
            synchronized (this.f22076d) {
                long nextLong = new Random(System.nanoTime() ^ this.f21734a.zzax().currentTimeMillis()).nextLong();
                int i4 = this.f22077e + 1;
                this.f22077e = i4;
                j4 = nextLong + i4;
            }
            return j4;
        }
        synchronized (this.f22076d) {
            this.f22076d.compareAndSet(-1L, 1L);
            andIncrement = this.f22076d.getAndIncrement();
        }
        return andIncrement;
    }

    public final long zzr(long j4, long j5) {
        return (j4 + (j5 * ExponentialBackoff.DEFAULT_BACKOFF_MAX_DELAY_MS)) / 86400000;
    }
}
