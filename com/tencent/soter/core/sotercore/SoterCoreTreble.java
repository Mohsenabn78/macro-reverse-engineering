package com.tencent.soter.core.sotercore;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.os.RemoteException;
import android.os.SystemClock;
import com.tencent.soter.core.model.ConstantsSoter;
import com.tencent.soter.core.model.ISoterExParameters;
import com.tencent.soter.core.model.SLogger;
import com.tencent.soter.core.model.SoterCoreResult;
import com.tencent.soter.core.model.SoterDelegate;
import com.tencent.soter.core.model.SoterErrCode;
import com.tencent.soter.core.model.SoterExParametersTrebleImpl;
import com.tencent.soter.core.model.SoterPubKeyModel;
import com.tencent.soter.soterserver.ISoterService;
import com.tencent.soter.soterserver.SoterExtraParam;
import com.tencent.soter.soterserver.SoterSessionResult;
import com.tencent.soter.soterserver.SoterSignResult;
import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.Signature;
import java.security.UnrecoverableEntryException;
import java.security.cert.CertificateException;

/* loaded from: classes6.dex */
public class SoterCoreTreble extends SoterCoreBase implements ConstantsSoter, SoterErrCode {
    private static final int CONNECTED = 2;
    private static final int CONNECTING = 1;
    protected static final int DEFAULT_BLOCK_TIME = 3000;
    private static final int DELAY_THRESHOLD = 30;
    private static final int DISCONNECT = 0;
    private static final int INITIAL_FIB_VALUE = 3;
    public static final String TAG = "Soter.SoterCoreTreble";
    private static int connectState = 0;
    private static boolean isInitializeSuccessed = false;
    private static boolean isInitializing = false;
    protected static ISoterService mSoterService;
    private Context mContext;
    private SoterCoreTrebleServiceListener serviceListener;
    private static final Object lock = new Object();
    private static SyncJob syncJob = new SyncJob();
    public static int uid = 0;
    private boolean canRetry = true;
    private int disconnectCount = 0;
    private int noResponseCount = 3;
    private long lastBindTime = 0;
    private boolean hasBind = false;
    private Handler mMainLooperHandler = new Handler(Looper.getMainLooper());
    private IBinder.DeathRecipient mDeathRecipient = new IBinder.DeathRecipient() { // from class: com.tencent.soter.core.sotercore.SoterCoreTreble.1
        @Override // android.os.IBinder.DeathRecipient
        public void binderDied() {
            SLogger.i(SoterCoreTreble.TAG, "soter: binder died", new Object[0]);
            ISoterService iSoterService = SoterCoreTreble.mSoterService;
            if (iSoterService != null && iSoterService.asBinder() != null) {
                SoterCoreTreble.mSoterService.asBinder().unlinkToDeath(SoterCoreTreble.this.mDeathRecipient, 0);
                SoterCoreTreble.mSoterService = null;
                if (SoterCoreTreble.this.serviceListener != null) {
                    SoterCoreTreble.this.serviceListener.onServiceBinderDied();
                }
                synchronized (SoterCoreTreble.lock) {
                    int unused = SoterCoreTreble.connectState = 0;
                    SoterCoreTreble.this.unbindService();
                    SoterCoreTreble.this.rebindService();
                }
            }
        }
    };
    private ServiceConnection mServiceConnection = new ServiceConnection() { // from class: com.tencent.soter.core.sotercore.SoterCoreTreble.2
        @Override // android.content.ServiceConnection
        public void onBindingDied(ComponentName componentName) {
            SLogger.i(SoterCoreTreble.TAG, "soter: binding died", new Object[0]);
            int unused = SoterCoreTreble.connectState = 0;
            SoterCoreTreble.mSoterService = null;
            if (SoterCoreTreble.getFib(SoterCoreTreble.this.noResponseCount) > 30) {
                SLogger.i(SoterCoreTreble.TAG, "soter: rest fib, now is delay %dS", Long.valueOf(SoterCoreTreble.getFib(SoterCoreTreble.this.noResponseCount)));
                SoterCoreTreble.this.noResponseCount = 3;
                SoterCoreTreble.this.mMainLooperHandler.removeCallbacks(SoterCoreTreble.this.retryFunc);
            }
            SoterCoreTreble.this.unbindService();
            SoterCoreTreble.this.rebindService();
        }

        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            SLogger.i(SoterCoreTreble.TAG, "soter: onServiceConnected", new Object[0]);
            synchronized (SoterCoreTreble.lock) {
                int unused = SoterCoreTreble.connectState = 2;
            }
            SoterCoreTreble.this.noResponseCount = 3;
            SoterCoreTreble.this.mMainLooperHandler.removeCallbacks(SoterCoreTreble.this.retryFunc);
            try {
                iBinder.linkToDeath(SoterCoreTreble.this.mDeathRecipient, 0);
                SoterCoreTreble.mSoterService = ISoterService.Stub.asInterface(iBinder);
            } catch (RemoteException e4) {
                SLogger.e(SoterCoreTreble.TAG, "soter: Binding deathRecipient is error - RemoteException" + e4.toString(), new Object[0]);
            }
            if (SoterCoreTreble.this.serviceListener != null) {
                SoterCoreTreble.this.serviceListener.onServiceConnected();
            }
            SLogger.i(SoterCoreTreble.TAG, "soter: Binding is done - Service connected", new Object[0]);
            SoterCoreTreble.syncJob.countDown();
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
            synchronized (SoterCoreTreble.lock) {
                SLogger.i(SoterCoreTreble.TAG, "soter: unBinding is done - Service disconnected", new Object[0]);
                int unused = SoterCoreTreble.connectState = 0;
                SoterCoreTreble.mSoterService = null;
                if (SoterCoreTreble.getFib(SoterCoreTreble.this.noResponseCount) > 30) {
                    SLogger.i(SoterCoreTreble.TAG, "soter: rest fib, now is delay %dS", Long.valueOf(SoterCoreTreble.getFib(SoterCoreTreble.this.noResponseCount)));
                    SoterCoreTreble.this.noResponseCount = 3;
                    SoterCoreTreble.this.mMainLooperHandler.removeCallbacks(SoterCoreTreble.this.retryFunc);
                }
                if (SoterCoreTreble.this.serviceListener != null) {
                    SoterCoreTreble.this.serviceListener.onServiceDisconnected();
                }
                SoterCoreTreble.this.rebindService();
                SoterCoreTreble.syncJob.countDown();
            }
        }
    };
    private Runnable retryFunc = new Runnable() { // from class: com.tencent.soter.core.sotercore.SoterCoreTreble.5
        @Override // java.lang.Runnable
        public void run() {
            if (SoterCoreTreble.this.canRetry && SoterCoreTreble.isInitializeSuccessed) {
                SoterCoreTreble.access$508(SoterCoreTreble.this);
                if (SoterCoreTreble.connectState != 2) {
                    SLogger.i(SoterCoreTreble.TAG, "soter: retryFunc bindservice no response: %d delay: %d", Integer.valueOf(SoterCoreTreble.this.noResponseCount), Long.valueOf(SoterCoreTreble.getFib(SoterCoreTreble.this.noResponseCount)));
                    SoterCoreTreble.this.bindService(true);
                    return;
                }
                SLogger.i(SoterCoreTreble.TAG, "soter: retryFunc stop, CONNECTED", new Object[0]);
                return;
            }
            SLogger.i(SoterCoreTreble.TAG, "soter: retryFunc stop, canRetry:%b isInitializeSuccessed:%b", Boolean.valueOf(SoterCoreTreble.this.canRetry), Boolean.valueOf(SoterCoreTreble.isInitializeSuccessed));
        }
    };

    static /* synthetic */ int access$508(SoterCoreTreble soterCoreTreble) {
        int i4 = soterCoreTreble.noResponseCount;
        soterCoreTreble.noResponseCount = i4 + 1;
        return i4;
    }

    private boolean checkIfServiceNull() {
        if (mSoterService != null) {
            return false;
        }
        SLogger.w(TAG, "soter: soter service not found", new Object[0]);
        SoterCoreTrebleServiceListener soterCoreTrebleServiceListener = this.serviceListener;
        if (soterCoreTrebleServiceListener != null) {
            soterCoreTrebleServiceListener.onNoServiceWhenCalling();
            return true;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static long getFib(long j4) {
        long j5 = 0;
        int i4 = (j4 > 0L ? 1 : (j4 == 0L ? 0 : -1));
        if (i4 < 0) {
            return -1L;
        }
        if (i4 == 0) {
            return 0L;
        }
        long j6 = 1;
        if (j4 == 1 || j4 == 2) {
            return 1L;
        }
        long j7 = 1;
        int i5 = 3;
        while (i5 <= j4) {
            j5 = j6 + j7;
            i5++;
            j6 = j7;
            j7 = j5;
        }
        return j5;
    }

    public static boolean isInitializing() {
        return isInitializing;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void rebindService() {
        if (!this.canRetry) {
            return;
        }
        this.disconnectCount++;
        long fib = getFib(this.disconnectCount);
        long elapsedRealtime = fib - ((SystemClock.elapsedRealtime() - this.lastBindTime) / 1000);
        SLogger.i(TAG, "fib: %s, rebind delay: %sS", Long.valueOf(fib), Long.valueOf(elapsedRealtime));
        if (elapsedRealtime <= 0) {
            bindService();
        } else {
            this.mMainLooperHandler.postDelayed(new Runnable() { // from class: com.tencent.soter.core.sotercore.SoterCoreTreble.3
                @Override // java.lang.Runnable
                public void run() {
                    SoterCoreTreble.this.bindServiceIfNeeded();
                }
            }, elapsedRealtime * 1000);
        }
    }

    private void resetDisconnectCount() {
        this.disconnectCount = 0;
    }

    private void scheduleTimeoutTask(boolean z3) {
        long fib = getFib(this.noResponseCount);
        SLogger.i(TAG, "soter: scheduleTimeoutTask isCycle:%b noResponseCount:%d checkDelay:%d ", Boolean.valueOf(z3), Integer.valueOf(this.noResponseCount), Long.valueOf(fib));
        if (z3 || this.noResponseCount <= 3) {
            this.mMainLooperHandler.postDelayed(this.retryFunc, fib * 1000);
        }
    }

    public void bindService() {
        bindService(false);
    }

    public void bindServiceIfNeeded() {
        ISoterService iSoterService;
        try {
            if (connectState == 2 && (iSoterService = mSoterService) != null && iSoterService.asBinder() != null && mSoterService.asBinder().isBinderAlive() && mSoterService.asBinder().pingBinder()) {
                SLogger.i(TAG, "no need rebind", new Object[0]);
            }
            SLogger.i(TAG, "soter: bindServiceIfNeeded try to bind", new Object[0]);
            bindService();
        } catch (Exception e4) {
            SLogger.printErrStackTrace(TAG, e4, "soter: bindServiceIfNeeded fail: ");
        }
    }

    @Override // com.tencent.soter.core.sotercore.SoterCoreBase
    public byte[] finishSign(long j4) throws Exception {
        SoterSignResult finishSign;
        SLogger.i(TAG, "soter: finishSign in", new Object[0]);
        if (!isNativeSupportSoter()) {
            return null;
        }
        if (this.mContext == null) {
            SLogger.w(TAG, "soter: context is null", new Object[0]);
            return null;
        }
        bindServiceIfNeeded();
        if (checkIfServiceNull()) {
            SLogger.w(TAG, "soter: soter service not found", new Object[0]);
            return null;
        }
        byte[] bArr = new byte[0];
        try {
            finishSign = mSoterService.finishSign(j4);
            bArr = finishSign.exportData;
        } catch (Exception e4) {
            SLogger.printErrStackTrace(TAG, e4, "soter: finishSign fail: ");
        }
        if (finishSign.resultCode != 0) {
            throw new Exception("finishSign error");
        }
        return bArr;
    }

    @Override // com.tencent.soter.core.sotercore.SoterCoreBase
    public SoterCoreResult generateAppGlobalSecureKey() {
        SLogger.i(TAG, "soter: generateAppSecureKey in", new Object[0]);
        if (!isNativeSupportSoter()) {
            return new SoterCoreResult(4);
        }
        if (this.mContext == null) {
            SLogger.w(TAG, "soter: context is null", new Object[0]);
            return new SoterCoreResult(4);
        }
        bindServiceIfNeeded();
        if (checkIfServiceNull()) {
            return new SoterCoreResult(4);
        }
        try {
            if (mSoterService.generateAppSecureKey(uid) == 0) {
                return new SoterCoreResult(0);
            }
        } catch (Exception e4) {
            SLogger.printErrStackTrace(TAG, e4, "soter: generateAppSecureKey fail: ");
        }
        return new SoterCoreResult(4);
    }

    @Override // com.tencent.soter.core.sotercore.SoterCoreBase
    public SoterCoreResult generateAuthKey(String str) {
        SLogger.i(TAG, "soter: generateAuthKey in", new Object[0]);
        if (!isNativeSupportSoter()) {
            return new SoterCoreResult(6);
        }
        if (this.mContext == null) {
            SLogger.w(TAG, "soter: context is null", new Object[0]);
            return new SoterCoreResult(6);
        }
        bindServiceIfNeeded();
        if (checkIfServiceNull()) {
            SLogger.w(TAG, "soter: soter service not found", new Object[0]);
            return new SoterCoreResult(6);
        }
        try {
            if (mSoterService.generateAuthKey(uid, str) == 0) {
                return new SoterCoreResult(0);
            }
        } catch (Exception e4) {
            SLogger.printErrStackTrace(TAG, e4, "soter: generateAuthKey fail: ");
        }
        return new SoterCoreResult(6);
    }

    @Override // com.tencent.soter.core.sotercore.SoterCoreBase
    public SoterPubKeyModel getAppGlobalSecureKeyModel() {
        SLogger.i(TAG, "soter: getAppGlobalSecureKeyModel in", new Object[0]);
        if (!isNativeSupportSoter()) {
            return null;
        }
        if (this.mContext == null) {
            SLogger.w(TAG, "soter: context is null", new Object[0]);
            return null;
        }
        bindServiceIfNeeded();
        if (checkIfServiceNull()) {
            SLogger.w(TAG, "soter: soter service not found", new Object[0]);
            return null;
        }
        try {
            byte[] bArr = mSoterService.getAppSecureKey(uid).exportData;
            if (bArr != null && bArr.length > 0) {
                return SoterCoreBase.retrieveJsonFromExportedData(bArr);
            }
            SLogger.e(TAG, "soter: soter: key can not be retrieved", new Object[0]);
            return null;
        } catch (Exception e4) {
            SLogger.printErrStackTrace(TAG, e4, "soter: getAppGlobalSecureKeyModel fail: ");
            return null;
        }
    }

    @Override // com.tencent.soter.core.sotercore.SoterCoreBase
    public Signature getAuthInitAndSign(String str) {
        return null;
    }

    @Override // com.tencent.soter.core.sotercore.SoterCoreBase
    public SoterPubKeyModel getAuthKeyModel(String str) {
        SLogger.i(TAG, "soter: getAuthKeyModel in", new Object[0]);
        if (!isNativeSupportSoter()) {
            return null;
        }
        if (this.mContext == null) {
            SLogger.w(TAG, "soter: context is null", new Object[0]);
            return null;
        }
        bindServiceIfNeeded();
        if (checkIfServiceNull()) {
            SLogger.w(TAG, "soter: soter service not found", new Object[0]);
            return null;
        }
        try {
            byte[] bArr = mSoterService.getAuthKey(uid, str).exportData;
            if (bArr != null && bArr.length > 0) {
                return SoterCoreBase.retrieveJsonFromExportedData(bArr);
            }
            SLogger.e(TAG, "soter: key can not be retrieved", new Object[0]);
            return null;
        } catch (Exception e4) {
            SLogger.printErrStackTrace(TAG, e4, "soter: getAuthKeyModel fail: ");
            return null;
        }
    }

    public int getVersion() {
        SLogger.i(TAG, "soter: getVersion in", new Object[0]);
        if (!isNativeSupportSoter()) {
            return 0;
        }
        if (this.mContext == null) {
            SLogger.w(TAG, "soter: context is null", new Object[0]);
            return 0;
        }
        bindServiceIfNeeded();
        if (checkIfServiceNull()) {
            SLogger.w(TAG, "soter: soter service not found", new Object[0]);
            return 0;
        }
        try {
            return mSoterService.getVersion();
        } catch (Exception e4) {
            SLogger.printErrStackTrace(TAG, e4, "soter: getVersion fail: ");
            return 0;
        }
    }

    @Override // com.tencent.soter.core.sotercore.SoterCoreBase
    public boolean hasAppGlobalSecureKey() {
        SLogger.i(TAG, "soter: hasAppGlobalSecureKey in", new Object[0]);
        if (!isNativeSupportSoter()) {
            return false;
        }
        if (this.mContext == null) {
            SLogger.w(TAG, "soter: context is null", new Object[0]);
            return false;
        }
        bindServiceIfNeeded();
        if (checkIfServiceNull()) {
            SLogger.w(TAG, "soter: soter service not found", new Object[0]);
            return false;
        }
        try {
            return mSoterService.hasAskAlready(uid);
        } catch (Exception e4) {
            SLogger.printErrStackTrace(TAG, e4, "soter: hasAppGlobalSecureKey fail: ");
            return false;
        }
    }

    @Override // com.tencent.soter.core.sotercore.SoterCoreBase
    public boolean hasAuthKey(String str) {
        SLogger.i(TAG, "soter: hasAuthKey in", new Object[0]);
        if (!isNativeSupportSoter()) {
            return false;
        }
        if (this.mContext == null) {
            SLogger.w(TAG, "soter: context is null", new Object[0]);
            return false;
        }
        bindServiceIfNeeded();
        if (checkIfServiceNull()) {
            SLogger.w(TAG, "soter: soter service not found", new Object[0]);
            return false;
        }
        try {
            return mSoterService.hasAuthKey(uid, str);
        } catch (Exception e4) {
            SLogger.printErrStackTrace(TAG, e4, "soter: hasAuthKey fail: ");
            return false;
        }
    }

    @Override // com.tencent.soter.core.sotercore.SoterCoreBase
    public Signature initAuthKeySignature(String str) throws InvalidKeyException, NoSuchProviderException, NoSuchAlgorithmException, KeyStoreException, IOException, CertificateException, UnrecoverableEntryException {
        return null;
    }

    @Override // com.tencent.soter.core.sotercore.SoterCoreBase
    public SoterSessionResult initSigh(String str, String str2) {
        SLogger.i(TAG, "soter: initSigh in", new Object[0]);
        if (!isNativeSupportSoter()) {
            return null;
        }
        if (this.mContext == null) {
            SLogger.w(TAG, "soter: context is null", new Object[0]);
            return null;
        }
        bindServiceIfNeeded();
        if (checkIfServiceNull()) {
            SLogger.w(TAG, "soter: soter service not found", new Object[0]);
            return null;
        }
        try {
            return mSoterService.initSigh(uid, str, str2);
        } catch (Exception e4) {
            SLogger.printErrStackTrace(TAG, e4, "soter: initSigh fail: ");
            return null;
        }
    }

    @Override // com.tencent.soter.core.sotercore.SoterCoreBase
    public boolean initSoter(Context context) {
        this.mContext = context;
        SLogger.i(TAG, "soter: initSoter in", new Object[0]);
        isInitializing = true;
        syncJob.doAsSyncJob(ConstantsSoter.FACEID_AUTH_CHECK_TIME, new Runnable() { // from class: com.tencent.soter.core.sotercore.SoterCoreTreble.4
            @Override // java.lang.Runnable
            public void run() {
                SoterCoreTreble.this.bindServiceIfNeeded();
                SLogger.i(SoterCoreTreble.TAG, "soter: initSoter binding", new Object[0]);
            }
        });
        isInitializing = false;
        if (connectState == 2) {
            SLogger.i(TAG, "soter: initSoter finish", new Object[0]);
            isInitializeSuccessed = true;
            return true;
        }
        connectState = 0;
        SLogger.e(TAG, "soter: initSoter error", new Object[0]);
        return false;
    }

    @Override // com.tencent.soter.core.sotercore.SoterCoreBase
    public boolean isAppGlobalSecureKeyValid() {
        SLogger.i(TAG, "soter: isAppGlobalSecureKeyValid in", new Object[0]);
        if (!hasAppGlobalSecureKey() || getAppGlobalSecureKeyModel() == null) {
            return false;
        }
        return true;
    }

    @Override // com.tencent.soter.core.sotercore.SoterCoreBase
    public boolean isAuthKeyValid(String str, boolean z3) {
        SLogger.i(TAG, "soter: isAuthKeyValid in", new Object[0]);
        if (!hasAuthKey(str) || getAuthKeyModel(str) == null) {
            return false;
        }
        return true;
    }

    @Override // com.tencent.soter.core.sotercore.SoterCoreBase
    public boolean isNativeSupportSoter() {
        if (SoterDelegate.isTriggeredOOM()) {
            SLogger.w(TAG, "soter: the device has already triggered OOM. mark as not support", new Object[0]);
            return false;
        }
        return true;
    }

    @Override // com.tencent.soter.core.sotercore.SoterCoreBase
    public boolean isTrebleServiceConnected() {
        if (connectState == 2) {
            return true;
        }
        return false;
    }

    @Override // com.tencent.soter.core.sotercore.SoterCoreBase
    public void releaseTrebleServiceConnection() {
        this.canRetry = false;
        unbindService();
    }

    @Override // com.tencent.soter.core.sotercore.SoterCoreBase
    public SoterCoreResult removeAppGlobalSecureKey() {
        SLogger.i(TAG, "soter: removeAppGlobalSecureKey in", new Object[0]);
        if (!isNativeSupportSoter()) {
            return new SoterCoreResult(5);
        }
        if (this.mContext == null) {
            SLogger.w(TAG, "soter: context is null", new Object[0]);
            return new SoterCoreResult(5);
        }
        bindServiceIfNeeded();
        if (checkIfServiceNull()) {
            SLogger.w(TAG, "soter: soter service not found", new Object[0]);
            return new SoterCoreResult(5);
        }
        try {
            if (mSoterService.removeAllAuthKey(uid) == 0) {
                return new SoterCoreResult(0);
            }
        } catch (Exception e4) {
            SLogger.printErrStackTrace(TAG, e4, "soter: removeAppGlobalSecureKey fail: ");
        }
        return new SoterCoreResult(5);
    }

    @Override // com.tencent.soter.core.sotercore.SoterCoreBase
    public SoterCoreResult removeAuthKey(String str, boolean z3) {
        SLogger.i(TAG, "soter: removeAuthKey in", new Object[0]);
        if (!isNativeSupportSoter()) {
            return new SoterCoreResult(7);
        }
        if (this.mContext == null) {
            SLogger.w(TAG, "soter: context is null", new Object[0]);
            return new SoterCoreResult(7);
        }
        bindServiceIfNeeded();
        if (checkIfServiceNull()) {
            SLogger.w(TAG, "soter: soter service not found", new Object[0]);
            return new SoterCoreResult(7);
        }
        try {
            if (mSoterService.removeAuthKey(uid, str) == 0) {
                if (z3) {
                    if (mSoterService.removeAllAuthKey(uid) == 0) {
                        return new SoterCoreResult(0);
                    }
                    return new SoterCoreResult(5);
                }
                return new SoterCoreResult(0);
            }
        } catch (Exception e4) {
            SLogger.printErrStackTrace(TAG, e4, "soter: removeAuthKey fail: ");
        }
        return new SoterCoreResult(7);
    }

    @Override // com.tencent.soter.core.sotercore.SoterCoreBase
    public void setTrebleServiceListener(SoterCoreTrebleServiceListener soterCoreTrebleServiceListener) {
        this.serviceListener = soterCoreTrebleServiceListener;
    }

    @Override // com.tencent.soter.core.sotercore.SoterCoreBase
    public void triggerTrebleServiceConnecting() {
        resetDisconnectCount();
        bindServiceIfNeeded();
    }

    public void unbindService() {
        if (this.hasBind) {
            try {
                try {
                    this.mContext.unbindService(this.mServiceConnection);
                } catch (Exception e4) {
                    SLogger.printErrStackTrace(TAG, e4, "");
                }
            } finally {
                this.hasBind = false;
            }
        }
    }

    @Override // com.tencent.soter.core.sotercore.SoterCoreBase
    public void updateExtraParam() {
        try {
            new Thread(new Runnable() { // from class: com.tencent.soter.core.sotercore.SoterCoreTreble.6
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        ISoterService iSoterService = SoterCoreTreble.mSoterService;
                        if (iSoterService == null) {
                            SLogger.w(SoterCoreTreble.TAG, "soter: mSoterService is null", new Object[0]);
                            return;
                        }
                        SoterExtraParam extraParam = iSoterService.getExtraParam(ISoterExParameters.FINGERPRINT_TYPE);
                        if (extraParam != null) {
                            Object obj = extraParam.result;
                            if (obj instanceof Integer) {
                                SoterExParametersTrebleImpl.setParam(ISoterExParameters.FINGERPRINT_TYPE, obj);
                            }
                        }
                        SoterExtraParam extraParam2 = SoterCoreTreble.mSoterService.getExtraParam(ISoterExParameters.FINGERPRINT_HARDWARE_POSITION);
                        if (extraParam2 != null) {
                            Object obj2 = extraParam2.result;
                            if (obj2 instanceof Integer[]) {
                                SoterExParametersTrebleImpl.setParam(ISoterExParameters.FINGERPRINT_HARDWARE_POSITION, obj2);
                            }
                        }
                    } catch (Exception e4) {
                        SLogger.printErrStackTrace(SoterCoreTreble.TAG, e4, "soter: getExtraParam fail");
                    }
                }
            }).start();
        } catch (Exception e4) {
            SLogger.printErrStackTrace(TAG, e4, "soter: getExtraParam fail");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bindService(boolean z3) {
        Intent intent = new Intent();
        intent.setAction("com.tencent.soter.soterserver.ISoterService");
        intent.setPackage("com.tencent.soter.soterserver");
        if (this.mContext == null) {
            SLogger.e(TAG, "soter: bindService context is null ", new Object[0]);
            return;
        }
        connectState = 1;
        SoterCoreTrebleServiceListener soterCoreTrebleServiceListener = this.serviceListener;
        if (soterCoreTrebleServiceListener != null) {
            soterCoreTrebleServiceListener.onStartServiceConnecting();
        }
        SLogger.i(TAG, "soter: bindService binding is start ", new Object[0]);
        this.lastBindTime = SystemClock.elapsedRealtime();
        this.hasBind = this.mContext.bindService(intent, this.mServiceConnection, 1);
        scheduleTimeoutTask(z3);
    }
}
