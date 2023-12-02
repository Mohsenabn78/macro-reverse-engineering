package com.github.javiersantos.licensing;

import android.annotation.SuppressLint;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.pm.PackageManager;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.IBinder;
import android.os.RemoteException;
import android.util.Log;
import com.android.vending.licensing.ILicenseResultListener;
import com.android.vending.licensing.ILicensingService;
import com.github.javiersantos.licensing.util.Base64;
import com.github.javiersantos.licensing.util.Base64DecoderException;
import com.tencent.soter.core.keystore.KeyPropertiesCompact;
import java.security.KeyFactory;
import java.security.NoSuchAlgorithmException;
import java.security.PublicKey;
import java.security.SecureRandom;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.X509EncodedKeySpec;
import java.util.Calendar;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

@SuppressLint({"SimpleDateFormat", "HardwareIds"})
/* loaded from: classes3.dex */
public class LibraryChecker implements ServiceConnection {

    /* renamed from: j  reason: collision with root package name */
    private static final SecureRandom f18367j = new SecureRandom();

    /* renamed from: a  reason: collision with root package name */
    private final Context f18368a;

    /* renamed from: b  reason: collision with root package name */
    private final Policy f18369b;

    /* renamed from: c  reason: collision with root package name */
    private final String f18370c;

    /* renamed from: d  reason: collision with root package name */
    private final String f18371d;

    /* renamed from: e  reason: collision with root package name */
    private final Set<LibraryValidator> f18372e = new HashSet();

    /* renamed from: f  reason: collision with root package name */
    private final Queue<LibraryValidator> f18373f = new LinkedList();

    /* renamed from: g  reason: collision with root package name */
    private ILicensingService f18374g;

    /* renamed from: h  reason: collision with root package name */
    private PublicKey f18375h;

    /* renamed from: i  reason: collision with root package name */
    private Handler f18376i;

    /* loaded from: classes3.dex */
    public class ResultListener extends ILicenseResultListener.Stub {

        /* renamed from: a  reason: collision with root package name */
        private final LibraryValidator f18377a;

        /* renamed from: b  reason: collision with root package name */
        private Runnable f18378b;

        public ResultListener(LibraryValidator libraryValidator) {
            this.f18377a = libraryValidator;
            this.f18378b = new Runnable() { // from class: com.github.javiersantos.licensing.LibraryChecker.ResultListener.1
                @Override // java.lang.Runnable
                public void run() {
                    Log.i("LibraryChecker", "Check timed out.");
                    ResultListener resultListener = ResultListener.this;
                    LibraryChecker.this.k(resultListener.f18377a);
                    ResultListener resultListener2 = ResultListener.this;
                    LibraryChecker.this.g(resultListener2.f18377a);
                }
            };
            d();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void c() {
            Log.i("LibraryChecker", "Clearing timeout.");
            LibraryChecker.this.f18376i.removeCallbacks(this.f18378b);
        }

        private void d() {
            Log.i("LibraryChecker", "Start monitoring timeout.");
            LibraryChecker.this.f18376i.postDelayed(this.f18378b, 10000L);
        }

        @Override // com.android.vending.licensing.ILicenseResultListener
        public void verifyLicense(final int i4, final String str, final String str2) {
            LibraryChecker.this.f18376i.post(new Runnable() { // from class: com.github.javiersantos.licensing.LibraryChecker.ResultListener.2
                @Override // java.lang.Runnable
                public void run() {
                    Log.i("LibraryChecker", "Received response.");
                    if (LibraryChecker.this.f18372e.contains(ResultListener.this.f18377a)) {
                        ResultListener.this.c();
                        ResultListener.this.f18377a.a(LibraryChecker.this.f18375h, i4, str, Calendar.getInstance(), str2);
                        ResultListener resultListener = ResultListener.this;
                        LibraryChecker.this.g(resultListener.f18377a);
                    }
                }
            });
        }
    }

    public LibraryChecker(Context context, Policy policy, String str) {
        this.f18368a = context;
        this.f18369b = policy;
        this.f18375h = i(str);
        String packageName = context.getPackageName();
        this.f18370c = packageName;
        this.f18371d = j(context, packageName);
        HandlerThread handlerThread = new HandlerThread("background thread");
        handlerThread.start();
        this.f18376i = new Handler(handlerThread.getLooper());
    }

    private void f() {
        if (this.f18374g != null) {
            try {
                this.f18368a.unbindService(this);
            } catch (IllegalArgumentException unused) {
                Log.e("LibraryChecker", "Unable to unbind from licensing service (already unbound)");
            }
            this.f18374g = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void g(LibraryValidator libraryValidator) {
        this.f18372e.remove(libraryValidator);
        if (this.f18372e.isEmpty()) {
            f();
        }
    }

    private int h() {
        return f18367j.nextInt();
    }

    private static PublicKey i(String str) {
        try {
            return KeyFactory.getInstance(KeyPropertiesCompact.KEY_ALGORITHM_RSA).generatePublic(new X509EncodedKeySpec(Base64.decode(str)));
        } catch (Base64DecoderException e4) {
            Log.e("LibraryChecker", "Could not decode from Base64.");
            throw new IllegalArgumentException(e4);
        } catch (NoSuchAlgorithmException e5) {
            throw new RuntimeException(e5);
        } catch (InvalidKeySpecException e6) {
            Log.e("LibraryChecker", "Invalid key specification.");
            throw new IllegalArgumentException(e6);
        }
    }

    private static String j(Context context, String str) {
        try {
            return String.valueOf(context.getPackageManager().getPackageInfo(str, 0).versionCode);
        } catch (PackageManager.NameNotFoundException unused) {
            Log.e("LibraryChecker", "Package not found. could not get version code.");
            return "";
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void k(LibraryValidator libraryValidator) {
        this.f18369b.processServerResponse(Policy.RETRY, null);
        if (this.f18369b.allowAccess()) {
            libraryValidator.b().allow(Policy.RETRY);
        } else {
            libraryValidator.b().dontAllow(Policy.RETRY);
        }
    }

    private void l() {
        while (true) {
            LibraryValidator poll = this.f18373f.poll();
            if (poll != null) {
                try {
                    Log.i("LibraryChecker", "Calling checkLicense on service for " + poll.d());
                    this.f18374g.checkLicense((long) poll.c(), poll.d(), new ResultListener(poll));
                    this.f18372e.add(poll);
                } catch (RemoteException e4) {
                    Log.w("LibraryChecker", "RemoteException in checkLicense call.", e4);
                    k(poll);
                }
            } else {
                return;
            }
        }
    }

    public synchronized void checkAccess(LibraryCheckerCallback libraryCheckerCallback) {
        if (this.f18369b.allowAccess()) {
            Log.i("LibraryChecker", "Using cached license response");
            libraryCheckerCallback.allow(Policy.LICENSED);
        } else {
            LibraryValidator libraryValidator = new LibraryValidator(this.f18369b, new NullDeviceLimiter(), libraryCheckerCallback, h(), this.f18370c, this.f18371d);
            if (this.f18374g == null) {
                Log.i("LibraryChecker", "Binding to licensing service.");
                try {
                    if (this.f18368a.bindService(new Intent(new String(Base64.decode("Y29tLmFuZHJvaWQudmVuZGluZy5saWNlbnNpbmcuSUxpY2Vuc2luZ1NlcnZpY2U="))).setPackage(new String(Base64.decode("Y29tLmFuZHJvaWQudmVuZGluZw=="))), this, 1)) {
                        this.f18373f.offer(libraryValidator);
                    } else {
                        Log.e("LibraryChecker", "Could not bind to service.");
                        k(libraryValidator);
                    }
                } catch (Base64DecoderException e4) {
                    e4.printStackTrace();
                } catch (SecurityException unused) {
                    libraryCheckerCallback.applicationError(6);
                }
            } else {
                this.f18373f.offer(libraryValidator);
                l();
            }
        }
    }

    public synchronized void finishAllChecks() {
        for (LibraryValidator libraryValidator : this.f18372e) {
            try {
                g(libraryValidator);
            } catch (Exception unused) {
            }
        }
        for (LibraryValidator libraryValidator2 : this.f18373f) {
            try {
                this.f18373f.remove(libraryValidator2);
            } catch (Exception unused2) {
            }
        }
    }

    public synchronized void onDestroy() {
        f();
        this.f18376i.getLooper().quit();
    }

    @Override // android.content.ServiceConnection
    public synchronized void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        this.f18374g = ILicensingService.Stub.asInterface(iBinder);
        l();
    }

    @Override // android.content.ServiceConnection
    public synchronized void onServiceDisconnected(ComponentName componentName) {
        Log.w("LibraryChecker", "Service unexpectedly disconnected.");
        this.f18374g = null;
    }
}
