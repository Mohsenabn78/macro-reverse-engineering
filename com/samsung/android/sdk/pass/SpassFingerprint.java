package com.samsung.android.sdk.pass;

import android.app.Activity;
import android.app.Dialog;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.RemoteException;
import android.util.Log;
import android.util.SparseArray;
import com.google.firebase.remoteconfig.RemoteConfigConstants;
import com.samsung.android.fingerprint.FingerprintEvent;
import com.samsung.android.fingerprint.FingerprintIdentifyDialog;
import com.samsung.android.fingerprint.FingerprintManager;
import com.samsung.android.fingerprint.IFingerprintClient;
import com.samsung.android.sdk.pass.support.IFingerprintManagerProxy;
import com.samsung.android.sdk.pass.support.SdkSupporter;
import com.samsung.android.sdk.pass.support.v1.FingerprintManagerProxyFactory;
import java.lang.reflect.UndeclaredThrowableException;
import java.util.ArrayList;

/* loaded from: classes6.dex */
public class SpassFingerprint {
    public static final String ACTION_FINGERPRINT_ADDED = "com.samsung.android.intent.action.FINGERPRINT_ADDED";
    public static final String ACTION_FINGERPRINT_REMOVED = "com.samsung.android.intent.action.FINGERPRINT_REMOVED";
    public static final String ACTION_FINGERPRINT_RESET = "com.samsung.android.intent.action.FINGERPRINT_RESET";
    public static final int STATUS_AUTHENTIFICATION_FAILED = 16;
    public static final int STATUS_AUTHENTIFICATION_PASSWORD_SUCCESS = 100;
    public static final int STATUS_AUTHENTIFICATION_SUCCESS = 0;
    public static final int STATUS_BUTTON_PRESSED = 9;
    public static final int STATUS_OPERATION_DENIED = 51;
    public static final int STATUS_QUALITY_FAILED = 12;
    public static final int STATUS_SENSOR_FAILED = 7;
    public static final int STATUS_TIMEOUT_FAILED = 4;
    public static final int STATUS_USER_CANCELLED = 8;
    public static final int STATUS_USER_CANCELLED_BY_TOUCH_OUTSIDE = 13;
    public static final String TAG = "SpassFingerprintSDK";

    /* renamed from: n  reason: collision with root package name */
    private static int f37376n = 0;

    /* renamed from: o  reason: collision with root package name */
    private static boolean f37377o = false;

    /* renamed from: p  reason: collision with root package name */
    private static boolean f37378p = false;

    /* renamed from: q  reason: collision with root package name */
    private static boolean f37379q = false;

    /* renamed from: r  reason: collision with root package name */
    private static boolean f37380r = false;

    /* renamed from: a  reason: collision with root package name */
    private IFingerprintManagerProxy f37381a;

    /* renamed from: b  reason: collision with root package name */
    private Context f37382b;

    /* renamed from: c  reason: collision with root package name */
    private int f37383c = -1;

    /* renamed from: d  reason: collision with root package name */
    private String f37384d = null;

    /* renamed from: e  reason: collision with root package name */
    private ArrayList f37385e = null;

    /* renamed from: f  reason: collision with root package name */
    private String f37386f = null;

    /* renamed from: g  reason: collision with root package name */
    private int f37387g = -1;

    /* renamed from: h  reason: collision with root package name */
    private String f37388h = null;

    /* renamed from: i  reason: collision with root package name */
    private int f37389i = -1;

    /* renamed from: j  reason: collision with root package name */
    private boolean f37390j = false;

    /* renamed from: k  reason: collision with root package name */
    private String f37391k = null;

    /* renamed from: l  reason: collision with root package name */
    private String f37392l = null;

    /* renamed from: m  reason: collision with root package name */
    private boolean f37393m = false;

    /* renamed from: s  reason: collision with root package name */
    private Dialog f37394s = null;

    /* renamed from: t  reason: collision with root package name */
    private b f37395t = null;

    /* renamed from: u  reason: collision with root package name */
    private b f37396u = null;

    /* renamed from: v  reason: collision with root package name */
    private IBinder f37397v = null;

    /* renamed from: w  reason: collision with root package name */
    private Handler f37398w;

    /* loaded from: classes6.dex */
    public interface IdentifyListener {
        void onCompleted();

        void onFinished(int i4);

        void onReady();

        void onStarted();
    }

    /* loaded from: classes6.dex */
    public interface RegisterListener {
        void onFinished();
    }

    /* loaded from: classes6.dex */
    private static class a {

        /* renamed from: a  reason: collision with root package name */
        private Bundle f37399a;

        public a() {
            Bundle bundle = new Bundle();
            this.f37399a = bundle;
            bundle.putString("sdk_version", "Pass-v1.2.6");
        }

        public final Bundle a() {
            return this.f37399a;
        }

        public final a a(int[] iArr) {
            if (iArr.length > 0) {
                this.f37399a.putIntArray("request_template_index_list", iArr);
            }
            return this;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes6.dex */
    public class b extends IFingerprintClient.Stub {

        /* renamed from: a  reason: collision with root package name */
        private IdentifyListener f37400a;

        /* renamed from: b  reason: collision with root package name */
        private final int f37401b;

        private b(IdentifyListener identifyListener) {
            this.f37401b = SpassFingerprint.f37377o ? 16 : 13;
            this.f37400a = identifyListener;
        }

        public final IdentifyListener a() {
            return this.f37400a;
        }

        public final void onFingerprintEvent(FingerprintEvent fingerprintEvent) throws RemoteException {
            String str;
            if (fingerprintEvent == null) {
                str = "onFingerprintEvent: null event will be ignored!";
            } else {
                try {
                    StringBuilder sb = new StringBuilder("evt : ");
                    sb.append(fingerprintEvent.eventId);
                    sb.append(", ");
                    sb.append(fingerprintEvent.eventResult);
                    sb.append(", ");
                    sb.append(fingerprintEvent.eventStatus);
                    IdentifyListener identifyListener = this.f37400a;
                    if (fingerprintEvent.eventId == this.f37401b) {
                        new StringBuilder("onFingerprintEvent : completed = ").append(this.f37401b);
                        SpassFingerprint.this.f37395t = null;
                        SpassFingerprint.this.f();
                    }
                    if (identifyListener != null && SpassFingerprint.this.f37398w != null) {
                        SpassFingerprint.this.f37398w.post(new e(this, fingerprintEvent, identifyListener));
                        return;
                    }
                    return;
                } catch (Exception e4) {
                    str = "onFingerprintEvent: Error : " + e4;
                }
            }
            Log.w(SpassFingerprint.TAG, str);
        }

        /* synthetic */ b(SpassFingerprint spassFingerprint, IdentifyListener identifyListener, byte b4) {
            this(identifyListener);
        }

        public final void a(IdentifyListener identifyListener) {
            this.f37400a = identifyListener;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes6.dex */
    public class c implements FingerprintIdentifyDialog.FingerprintListener {

        /* renamed from: a  reason: collision with root package name */
        private IdentifyListener f37403a;

        /* renamed from: b  reason: collision with root package name */
        private FingerprintEvent f37404b;

        private c(IdentifyListener identifyListener) {
            this.f37403a = identifyListener;
        }

        public final void onEvent(FingerprintEvent fingerprintEvent) {
            try {
                if (fingerprintEvent.eventId != 13 && SpassFingerprint.this.f37398w != null) {
                    SpassFingerprint.this.f37398w.post(new f(this, fingerprintEvent));
                } else {
                    this.f37404b = fingerprintEvent;
                }
            } catch (Exception e4) {
                Log.w(SpassFingerprint.TAG, "onFingerprintEvent: Error : " + e4);
            }
        }

        /* synthetic */ c(SpassFingerprint spassFingerprint, IdentifyListener identifyListener, byte b4) {
            this(identifyListener);
        }

        public final void a() {
            FingerprintEvent fingerprintEvent = this.f37404b;
            IdentifyListener identifyListener = this.f37403a;
            if (fingerprintEvent == null || identifyListener == null || SpassFingerprint.this.f37398w == null) {
                return;
            }
            SpassFingerprint.this.f37398w.post(new g(this, fingerprintEvent, identifyListener));
            this.f37403a = null;
            this.f37404b = null;
        }
    }

    public SpassFingerprint(Context context) {
        if (context != null) {
            this.f37382b = context;
            if (!f37378p) {
                f37379q = context.getPackageManager().hasSystemFeature("com.sec.feature.fingerprint_manager_service");
                f37380r = g();
                f37378p = true;
            }
            if (f37379q) {
                this.f37381a = FingerprintManagerProxyFactory.create(this.f37382b);
                this.f37398w = new Handler(context.getMainLooper());
                if (this.f37381a != null) {
                    try {
                        if (this.f37381a.getSensorType() == FingerprintManager.class.getField("SENSOR_TYPE_TOUCH").getInt(null)) {
                            f37377o = true;
                        }
                    } catch (Exception e4) {
                        Log.i(TAG, "SpassFingerprint : " + e4.toString());
                    }
                    f37376n = this.f37381a.getVersion();
                }
            }
            Log.i(TAG, "SpassFingerprint : 1.2.6, " + f37376n + ", " + f37377o);
            return;
        }
        throw new IllegalArgumentException("context is null.");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(Context context, String str) {
        if (g() && context.checkCallingOrSelfPermission("com.samsung.android.providers.context.permission.WRITE_USE_APP_FEATURE_SURVEY") == 0) {
            ContentValues contentValues = new ContentValues();
            contentValues.put("app_id", SpassFingerprint.class.getPackage().getName());
            contentValues.put("feature", String.valueOf(context.getPackageName()) + "#12");
            if (str != null) {
                contentValues.put("extra", str);
            }
            Intent intent = new Intent();
            intent.setAction("com.samsung.android.providers.context.log.action.USE_APP_FEATURE_SURVEY");
            intent.putExtra("data", contentValues);
            intent.setPackage("com.samsung.android.providers.context");
            context.sendBroadcast(intent);
            Log.i(TAG, "insertLog : " + contentValues.toString());
        }
    }

    private synchronized void e() throws UnsupportedOperationException {
        if (f37379q) {
            if (this.f37381a == null) {
                Log.i(TAG, "ensureServiceSupported : proxy is null, retry to create proxy");
                IFingerprintManagerProxy create = FingerprintManagerProxyFactory.create(this.f37382b);
                this.f37381a = create;
                if (create == null) {
                    throw new UnsupportedOperationException("Fingerprint Service is not running on the device.");
                }
            }
        } else {
            throw new UnsupportedOperationException("Fingerprint Service is not supported in the platform.");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f() {
        this.f37381a.unregisterClient(this.f37397v);
        this.f37397v = null;
        b bVar = this.f37396u;
        if (bVar != null) {
            bVar.a((IdentifyListener) null);
        }
    }

    private static boolean g() {
        if (f37378p) {
            return f37380r;
        }
        boolean z3 = false;
        try {
            Class<?> cls = Class.forName("com.samsung.android.feature.FloatingFeature");
            z3 = ((Boolean) cls.getMethod("getEnableStatus", String.class).invoke(cls.getMethod("getInstance", new Class[0]).invoke(null, new Object[0]), "SEC_FLOATING_FEATURE_CONTEXTSERVICE_ENABLE_SURVEY_MODE")).booleanValue();
        } catch (Exception e4) {
            new StringBuilder("Survey Mode : ").append(e4.toString());
            try {
                Class<?> cls2 = Class.forName("com.samsung.android.feature.SemFloatingFeature");
                z3 = ((Boolean) cls2.getMethod("getBoolean", String.class).invoke(cls2.getMethod("getInstance", new Class[0]).invoke(null, new Object[0]), "SEC_FLOATING_FEATURE_CONTEXTSERVICE_ENABLE_SURVEY_MODE")).booleanValue();
            } catch (Exception e5) {
                new StringBuilder("Survey Mode : ").append(e5.toString());
            }
        }
        Log.i(TAG, "Survey Mode : " + z3);
        return z3;
    }

    public void cancelIdentify() {
        Handler handler;
        e();
        IBinder iBinder = this.f37397v;
        if (iBinder == null && this.f37395t == null && this.f37394s == null) {
            throw new IllegalStateException("No Identify request.");
        }
        IdentifyListener identifyListener = null;
        if (iBinder != null) {
            b bVar = this.f37396u;
            if (bVar != null) {
                identifyListener = bVar.a();
            }
            f();
            if (identifyListener != null && (handler = this.f37398w) != null) {
                handler.postDelayed(new com.samsung.android.sdk.pass.a(this, identifyListener), 100L);
            }
        } else if (this.f37395t != null || this.f37394s != null) {
            this.f37381a.notifyAppActivityState(4, null);
            this.f37395t = null;
            this.f37394s = null;
        }
    }

    public void changeStandbyString(String str) {
        e();
        if (!c()) {
            if (str != null) {
                if (str.length() <= 100) {
                    this.f37392l = str;
                    return;
                }
                throw new IllegalArgumentException("the standby text passed is longer than 100 characters.");
            }
            throw new IllegalArgumentException("the standby text passed is null.");
        }
        throw new IllegalStateException("setStandbyString is not supported.");
    }

    public String getGuideForPoorQuality() {
        e();
        String str = this.f37384d;
        if (str != null) {
            return str;
        }
        throw new IllegalStateException("FingerprintGuide is Invalid. This API must be called inside IdentifyListener.onFinished() with STATUS_QUALITY_FAILED only.");
    }

    public int getIdentifiedFingerprintIndex() {
        e();
        int i4 = this.f37383c;
        if (i4 != -1) {
            return i4;
        }
        throw new IllegalStateException("FingerprintIndex is Invalid. This API must be called inside IdentifyListener.onFinished() only.");
    }

    public SparseArray getRegisteredFingerprintName() {
        e();
        SparseArray sparseArray = new SparseArray();
        int enrolledFingers = this.f37381a.getEnrolledFingers();
        if (enrolledFingers <= 0) {
            return null;
        }
        for (int i4 = 1; i4 <= 10; i4++) {
            if (((1 << i4) & enrolledFingers) != 0) {
                sparseArray.put(i4, this.f37381a.getIndexName(i4));
            }
        }
        return sparseArray;
    }

    public SparseArray getRegisteredFingerprintUniqueID() {
        e();
        if (b()) {
            SparseArray sparseArray = new SparseArray();
            int enrolledFingers = this.f37381a.getEnrolledFingers();
            if (enrolledFingers <= 0) {
                return null;
            }
            for (int i4 = 1; i4 <= 10; i4++) {
                if (((1 << i4) & enrolledFingers) != 0) {
                    sparseArray.put(i4, this.f37381a.getFingerprintId(i4));
                }
            }
            return sparseArray;
        }
        throw new IllegalStateException("getRegisteredFingerprintUniqueID is not supported.");
    }

    public boolean hasRegisteredFinger() {
        e();
        if (this.f37381a.getEnrolledFingers() != 0) {
            return true;
        }
        return false;
    }

    public void registerFinger(Context context, RegisterListener registerListener) {
        e();
        if (context != null) {
            if (registerListener != null) {
                if (this.f37381a.isEnrolling()) {
                    this.f37381a.notifyEnrollEnd();
                }
                try {
                    context.getPackageManager();
                    try {
                        this.f37381a.startEnrollActivity(context, new d(registerListener), toString());
                        return;
                    } catch (UndeclaredThrowableException unused) {
                        throw new IllegalArgumentException("activityContext is invalid");
                    }
                } catch (NullPointerException unused2) {
                    throw new IllegalArgumentException("activityContext is invalid");
                }
            }
            throw new IllegalArgumentException("listener passed is null.");
        }
        throw new IllegalArgumentException("activityContext passed is null.");
    }

    public void setCanceledOnTouchOutside(boolean z3) {
        e();
        if (a()) {
            this.f37390j = z3;
            return;
        }
        throw new IllegalStateException("setCanceledOnTouchOutside is not supported.");
    }

    public void setDialogBgTransparency(int i4) {
        e();
        if (a()) {
            if (i4 >= 0 && i4 <= 255) {
                this.f37389i = i4;
                return;
            }
            throw new IllegalArgumentException("the transparency passed is not valid.");
        }
        throw new IllegalStateException("setDialogBGTransparency is not supported.");
    }

    public void setDialogButton(String str) {
        e();
        if (!c()) {
            if (str != null) {
                if (str.length() <= 32) {
                    this.f37391k = str;
                    return;
                }
                throw new IllegalArgumentException("the title text passed is longer than 32 characters.");
            }
            throw new IllegalArgumentException("the buttonText passed is null.");
        }
        throw new IllegalStateException("setDialogButton is not supported.");
    }

    public void setDialogIcon(String str) {
        e();
        if (a()) {
            if (str != null) {
                if (a(str)) {
                    this.f37388h = str;
                    return;
                }
                throw new IllegalArgumentException("the iconName passed is not valid.");
            }
            throw new IllegalArgumentException("the iconName passed is null.");
        }
        throw new IllegalStateException("setDialogIcon is not supported.");
    }

    public void setDialogTitle(String str, int i4) {
        e();
        if (a()) {
            if (str != null) {
                if (str.length() <= 256) {
                    if ((i4 >>> 24) == 0) {
                        this.f37386f = str;
                        this.f37387g = i4 - 16777216;
                        return;
                    }
                    throw new IllegalArgumentException("alpha value is not supported in the titleColor.");
                }
                throw new IllegalArgumentException("the title text passed is longer than 256 characters.");
            }
            throw new IllegalArgumentException("the titletext passed is null.");
        }
        throw new IllegalStateException("setDialogTitle is not supported.");
    }

    public void setIntendedFingerprintIndex(ArrayList arrayList) {
        e();
        if (arrayList == null) {
            Log.w(TAG, "requestedIndex is null. Identify is carried out for all indexes.");
        } else if (a()) {
            this.f37385e = new ArrayList();
            for (int i4 = 0; i4 < arrayList.size(); i4++) {
                this.f37385e.add((Integer) arrayList.get(i4));
            }
        } else {
            throw new IllegalStateException("setIntendedFingerprintIndex is not supported.");
        }
    }

    public void startIdentify(IdentifyListener identifyListener) {
        a aVar = new a();
        ArrayList arrayList = this.f37385e;
        if (arrayList != null && arrayList.size() > 0) {
            int[] iArr = new int[this.f37385e.size()];
            for (int i4 = 0; i4 < this.f37385e.size(); i4++) {
                iArr[i4] = ((Integer) this.f37385e.get(i4)).intValue();
            }
            this.f37385e = null;
            aVar.a(iArr);
        }
        e();
        if (this.f37381a.getEnrolledFingers() != 0) {
            if (this.f37397v == null) {
                if (identifyListener != null) {
                    if (this.f37396u == null) {
                        this.f37396u = new b(this, identifyListener, (byte) 0);
                    }
                    Bundle a4 = aVar.a();
                    a4.putString("appName", this.f37382b.getPackageName());
                    IBinder registerClient = this.f37381a.registerClient(this.f37396u, a4);
                    this.f37397v = registerClient;
                    if (registerClient == null) {
                        IBinder registerClient2 = this.f37381a.registerClient(this.f37396u, a4);
                        this.f37397v = registerClient2;
                        if (registerClient2 == null) {
                            Handler handler = this.f37398w;
                            if (handler != null) {
                                handler.post(new com.samsung.android.sdk.pass.b(this, identifyListener));
                                return;
                            }
                            throw new IllegalStateException("failed because registerClient returned null.");
                        }
                    }
                    int identify = this.f37381a.identify(this.f37397v, null);
                    if (identify != 0) {
                        f();
                        Log.i(TAG, "startIdentify : failed, " + identify);
                        if (identify != -2) {
                            if (identify == 51) {
                                throw new SpassInvalidStateException("Identify request is denied because 5 identify attempts are failed.", 1);
                            }
                            throw new IllegalStateException("Identify operation is failed.");
                        }
                        throw new IllegalStateException("Identify request is denied because a previous request is still in progress.");
                    }
                    this.f37396u.a(identifyListener);
                    return;
                }
                throw new IllegalArgumentException("listener passed is null.");
            }
            throw new IllegalStateException("Identify request is denied because a previous request is still in progress.");
        }
        throw new IllegalStateException("Identify operation is failed.");
    }

    /* JADX WARN: Type inference failed for: r3v0, types: [java.lang.String, java.util.ArrayList] */
    public void startIdentifyWithDialog(Context context, IdentifyListener identifyListener, boolean z3) {
        int[] iArr;
        e();
        if (context != null) {
            if (identifyListener != null) {
                try {
                    context.getPackageManager();
                    if (!(context instanceof Activity)) {
                        Log.w(TAG, "startIdentifyWithDialog : No Actvity Context");
                    }
                    if (a()) {
                        ArrayList arrayList = this.f37385e;
                        if (arrayList != null && arrayList.size() > 0) {
                            iArr = new int[this.f37385e.size()];
                            for (int i4 = 0; i4 < this.f37385e.size(); i4++) {
                                iArr[i4] = ((Integer) this.f37385e.get(i4)).intValue();
                            }
                        } else {
                            iArr = null;
                        }
                        this.f37395t = new b(this, identifyListener, (byte) 0);
                        try {
                            Bundle bundle = new Bundle();
                            bundle.putBoolean("password", z3);
                            bundle.putString(RemoteConfigConstants.RequestFieldKey.PACKAGE_NAME, context.getPackageName());
                            bundle.putString("sdk_version", "Pass-v1.2.6");
                            bundle.putBoolean("demandExtraEvent", true);
                            if (iArr != null) {
                                bundle.putIntArray("request_template_index_list", iArr);
                            }
                            String str = this.f37386f;
                            if (str != null) {
                                bundle.putString("titletext", str);
                            }
                            int i5 = this.f37387g;
                            if (i5 != -1) {
                                bundle.putInt("titlecolor", i5);
                            }
                            String str2 = this.f37388h;
                            if (str2 != null) {
                                bundle.putString("iconname", str2);
                            }
                            int i6 = this.f37389i;
                            if (i6 != -1) {
                                bundle.putInt("transparency", i6);
                            }
                            boolean z4 = this.f37390j;
                            if (z4) {
                                bundle.putBoolean("touchoutside", z4);
                            }
                            String str3 = this.f37391k;
                            if (str3 != null) {
                                bundle.putString("button_name", str3);
                            }
                            String str4 = this.f37392l;
                            if (str4 != null) {
                                bundle.putString("standby_string", str4);
                            }
                            if (this.f37381a.identifyWithDialog(context, this.f37395t, bundle) == 0) {
                                return;
                            }
                            throw new IllegalStateException("Identify operation is failed.");
                        } finally {
                            this.f37385e = null;
                            this.f37386f = null;
                            this.f37387g = -1;
                            this.f37389i = -1;
                            this.f37388h = null;
                            this.f37390j = false;
                            this.f37392l = null;
                            this.f37391k = null;
                        }
                    }
                    c cVar = new c(this, identifyListener, (byte) 0);
                    Dialog showIdentifyDialog = this.f37381a.showIdentifyDialog(context, cVar, null, z3);
                    this.f37394s = showIdentifyDialog;
                    if (showIdentifyDialog != null) {
                        showIdentifyDialog.setOnDismissListener(new com.samsung.android.sdk.pass.c(cVar));
                        this.f37394s.show();
                        return;
                    }
                    throw new IllegalStateException("Identify operation is failed.");
                } catch (NullPointerException unused) {
                    throw new IllegalArgumentException("activityContext is invalid");
                }
            }
            throw new IllegalArgumentException("listener passed is null.");
        }
        throw new IllegalArgumentException("activityContext passed is null.");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final boolean b() {
        e();
        try {
            Class.forName(SdkSupporter.CLASSNAME_FINGERPRINT_MANAGER).getMethod("isSupportFingerprintIds", new Class[0]);
            return this.f37381a.isSupportFingerprintIds();
        } catch (Exception e4) {
            Log.w(TAG, e4);
            return a();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final boolean c() {
        e();
        try {
            Class.forName(SdkSupporter.CLASSNAME_FINGERPRINT_MANAGER).getMethod("isSupportBackupPassword", new Class[0]);
            return this.f37381a.isSupportBackupPassword();
        } catch (Exception e4) {
            Log.w(TAG, e4);
            return true;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void a(SpassFingerprint spassFingerprint, IdentifyListener identifyListener, FingerprintEvent fingerprintEvent, int i4) {
        spassFingerprint.f37384d = "";
        if (fingerprintEvent == null) {
            spassFingerprint.f37383c = 0;
        } else {
            spassFingerprint.f37383c = fingerprintEvent.getFingerIndex();
            if (fingerprintEvent.eventStatus == 12 || fingerprintEvent.eventStatus == 11) {
                spassFingerprint.f37384d = fingerprintEvent.getImageQualityFeedback();
            }
            int i5 = fingerprintEvent.eventStatus;
            if (i5 != 0) {
                i4 = 4;
                if (i5 != 4) {
                    i4 = 51;
                    if (i5 != 51) {
                        i4 = 100;
                        if (i5 != 100) {
                            i4 = 7;
                            if (i5 != 7) {
                                if (i5 == 8) {
                                    i4 = 8;
                                } else if (i5 != 9) {
                                    switch (i5) {
                                        case 11:
                                            i4 = 16;
                                            break;
                                        case 12:
                                            i4 = 12;
                                            break;
                                        case 13:
                                            i4 = 13;
                                            break;
                                    }
                                } else {
                                    i4 = 9;
                                }
                            }
                        }
                    }
                }
            } else {
                i4 = 0;
            }
        }
        identifyListener.onFinished(i4);
        spassFingerprint.f37383c = -1;
        spassFingerprint.f37384d = null;
        if (spassFingerprint.f37393m) {
            return;
        }
        spassFingerprint.f37393m = true;
        a(spassFingerprint.f37382b, "IdentifyListener.onFinished");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean a() {
        return f37376n >= 16843008;
    }

    private boolean a(String str) {
        String packageName = this.f37382b.getPackageName();
        try {
            Resources resourcesForApplication = this.f37382b.getPackageManager().getResourcesForApplication(packageName);
            if (resourcesForApplication == null) {
                return false;
            }
            try {
                int identifier = resourcesForApplication.getIdentifier(str, "drawable", packageName);
                if (identifier != 0 && identifier != -1) {
                    return BitmapFactory.decodeResource(resourcesForApplication, identifier) != null;
                }
            } catch (Resources.NotFoundException unused) {
            }
            return false;
        } catch (PackageManager.NameNotFoundException e4) {
            e4.printStackTrace();
            return false;
        }
    }
}
