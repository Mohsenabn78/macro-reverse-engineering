package com.tencent.soter.core.biometric;

import android.content.Context;
import android.os.Bundle;
import android.os.CancellationSignal;
import android.os.Handler;
import com.tencent.soter.core.SoterCore;
import com.tencent.soter.core.biometric.FaceidManagerProxy;
import com.tencent.soter.core.biometric.FingerprintManagerProxy;
import com.tencent.soter.core.model.SLogger;
import java.security.Signature;
import java.util.HashMap;
import java.util.Map;
import javax.crypto.Cipher;
import javax.crypto.Mac;

/* loaded from: classes6.dex */
public class BiometricManagerCompat {
    static final Map<Integer, IBiometricManager> IMPL_PROVIDER;
    private static final String TAG = "Soter.BiometricManagerCompat";
    private Integer mBiometricType;
    private Context mContext;

    /* loaded from: classes6.dex */
    public static final class AuthenticationResult {
        private CryptoObject mCryptoObject;

        public AuthenticationResult(CryptoObject cryptoObject) {
            this.mCryptoObject = cryptoObject;
        }

        public CryptoObject getCryptoObject() {
            return this.mCryptoObject;
        }
    }

    /* loaded from: classes6.dex */
    private static class FaceidManagerImpl implements IBiometricManager {
        private static final String TAG = "Soter.BiometricManagerCompat.Faceid";

        /* JADX INFO: Access modifiers changed from: private */
        public static void informTooManyTrial(FaceidManagerProxy.AuthenticationCallback authenticationCallback) {
            SLogger.w(TAG, "soter: too many fail callback. inform it.", new Object[0]);
            authenticationCallback.onAuthenticationError(10308, "Too many failed times");
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static boolean shouldInformTooManyTrial(FaceidManagerProxy.AuthenticationCallback authenticationCallback, Context context) {
            if (SoterBiometricAntiBruteForceStrategy.isSystemHasAntiBruteForce()) {
                SLogger.v(TAG, "soter: using system anti brute force strategy", new Object[0]);
                return false;
            } else if (SoterBiometricAntiBruteForceStrategy.isCurrentTweenTimeAvailable(context)) {
                if (!SoterBiometricAntiBruteForceStrategy.isCurrentFailTimeAvailable(context)) {
                    SLogger.v(TAG, "soter: unfreeze former frozen status", new Object[0]);
                    SoterBiometricAntiBruteForceStrategy.unFreeze(context);
                }
                return false;
            } else if (SoterBiometricAntiBruteForceStrategy.isCurrentFailTimeAvailable(context)) {
                SLogger.v(TAG, "soter: failure time available", new Object[0]);
                return false;
            } else {
                informTooManyTrial(authenticationCallback);
                return true;
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static CryptoObject unwrapCryptoObject(FaceidManagerProxy.CryptoObject cryptoObject) {
            if (cryptoObject == null) {
                return null;
            }
            if (cryptoObject.getCipher() != null) {
                return new CryptoObject(cryptoObject.getCipher());
            }
            if (cryptoObject.getSignature() != null) {
                return new CryptoObject(cryptoObject.getSignature());
            }
            if (cryptoObject.getMac() == null) {
                return null;
            }
            return new CryptoObject(cryptoObject.getMac());
        }

        private static FaceidManagerProxy.AuthenticationCallback wrapCallback(final Context context, final AuthenticationCallback authenticationCallback) {
            return new FaceidManagerProxy.AuthenticationCallback() { // from class: com.tencent.soter.core.biometric.BiometricManagerCompat.FaceidManagerImpl.1
                private boolean mMarkPermanentlyCallbacked = false;

                @Override // com.tencent.soter.core.biometric.FaceidManagerProxy.AuthenticationCallback
                public void onAuthenticationError(int i4, CharSequence charSequence) {
                    SLogger.d(FaceidManagerImpl.TAG, "soter: basic onAuthenticationError code[%d], msg[%s] entered.", Integer.valueOf(i4), charSequence);
                    if (this.mMarkPermanentlyCallbacked) {
                        SLogger.d(FaceidManagerImpl.TAG, "soter: basic onAuthenticationError code[%d], msg[%s] returned cause permanently callback.", Integer.valueOf(i4), charSequence);
                        return;
                    }
                    this.mMarkPermanentlyCallbacked = true;
                    if (i4 == 5) {
                        SLogger.i(FaceidManagerImpl.TAG, "soter: basic onAuthenticationError code[%d], msg[%s] callbacked and returned cause FACE_ERROR_CANCELED got.", Integer.valueOf(i4), charSequence);
                        AuthenticationCallback.this.onAuthenticationCancelled();
                    } else if (i4 == 7) {
                        SLogger.i(FaceidManagerImpl.TAG, "soter: basic onAuthenticationError code[%d], msg[%s] callbacked and returned cause FACE_ERROR_LOCKOUT got.", Integer.valueOf(i4), charSequence);
                        if (!SoterBiometricAntiBruteForceStrategy.isCurrentFailTimeAvailable(context) && !SoterBiometricAntiBruteForceStrategy.isCurrentTweenTimeAvailable(context) && !SoterBiometricAntiBruteForceStrategy.isSystemHasAntiBruteForce()) {
                            SoterBiometricAntiBruteForceStrategy.freeze(context);
                        }
                        AuthenticationCallback.this.onAuthenticationError(10308, "Too many failed times");
                    } else {
                        SLogger.d(FaceidManagerImpl.TAG, "soter: basic onAuthenticationError code[%d], msg[%s] callbacked and returned.", Integer.valueOf(i4), charSequence);
                        AuthenticationCallback.this.onAuthenticationError(i4, charSequence);
                    }
                }

                @Override // com.tencent.soter.core.biometric.FaceidManagerProxy.AuthenticationCallback
                public void onAuthenticationFailed() {
                    SLogger.d(FaceidManagerImpl.TAG, "soter: basic onAuthenticationFailed", new Object[0]);
                    if (this.mMarkPermanentlyCallbacked) {
                        return;
                    }
                    this.mMarkPermanentlyCallbacked = true;
                    if (!FaceidManagerImpl.shouldInformTooManyTrial(this, context) && !SoterBiometricAntiBruteForceStrategy.isSystemHasAntiBruteForce()) {
                        SoterBiometricAntiBruteForceStrategy.addFailTime(context);
                        if (!SoterBiometricAntiBruteForceStrategy.isCurrentFailTimeAvailable(context)) {
                            SLogger.w(FaceidManagerImpl.TAG, "soter: too many fail trials", new Object[0]);
                            SoterBiometricAntiBruteForceStrategy.freeze(context);
                            FaceidManagerImpl.informTooManyTrial(this);
                            return;
                        }
                    }
                    AuthenticationCallback.this.onAuthenticationFailed();
                }

                @Override // com.tencent.soter.core.biometric.FaceidManagerProxy.AuthenticationCallback
                public void onAuthenticationHelp(int i4, CharSequence charSequence) {
                    SLogger.d(FaceidManagerImpl.TAG, "soter: basic onAuthenticationHelp helpMsgId[%d], helpString[%s]", Integer.valueOf(i4), charSequence);
                    System.currentTimeMillis();
                    if (!this.mMarkPermanentlyCallbacked && !FaceidManagerImpl.shouldInformTooManyTrial(this, context)) {
                        AuthenticationCallback.this.onAuthenticationHelp(i4, charSequence);
                    }
                }

                @Override // com.tencent.soter.core.biometric.FaceidManagerProxy.AuthenticationCallback
                public void onAuthenticationSucceeded(FaceidManagerProxy.AuthenticationResult authenticationResult) {
                    SLogger.d(FaceidManagerImpl.TAG, "soter: basic onAuthenticationSucceeded", new Object[0]);
                    if (this.mMarkPermanentlyCallbacked) {
                        return;
                    }
                    this.mMarkPermanentlyCallbacked = true;
                    if (!FaceidManagerImpl.shouldInformTooManyTrial(this, context)) {
                        if (!SoterBiometricAntiBruteForceStrategy.isSystemHasAntiBruteForce()) {
                            SoterBiometricAntiBruteForceStrategy.unFreeze(context);
                        }
                        AuthenticationCallback.this.onAuthenticationSucceeded(new AuthenticationResult(FaceidManagerImpl.unwrapCryptoObject(authenticationResult.getCryptoObject())));
                    }
                }
            };
        }

        private static FaceidManagerProxy.CryptoObject wrapCryptoObject(CryptoObject cryptoObject) {
            if (cryptoObject == null) {
                return null;
            }
            if (cryptoObject.getCipher() != null) {
                return new FaceidManagerProxy.CryptoObject(cryptoObject.getCipher());
            }
            if (cryptoObject.getSignature() != null) {
                return new FaceidManagerProxy.CryptoObject(cryptoObject.getSignature());
            }
            if (cryptoObject.getMac() == null) {
                return null;
            }
            return new FaceidManagerProxy.CryptoObject(cryptoObject.getMac());
        }

        @Override // com.tencent.soter.core.biometric.BiometricManagerCompat.IBiometricManager
        public void authenticate(Context context, CryptoObject cryptoObject, int i4, CancellationSignal cancellationSignal, AuthenticationCallback authenticationCallback, Handler handler, Bundle bundle) {
            FaceidManagerProxy.authenticate(context, wrapCryptoObject(cryptoObject), i4, cancellationSignal, wrapCallback(context, authenticationCallback), handler);
        }

        @Override // com.tencent.soter.core.biometric.BiometricManagerCompat.IBiometricManager
        public String getBiometricName(Context context) {
            return FaceidManagerProxy.getBiometricName(context);
        }

        @Override // com.tencent.soter.core.biometric.BiometricManagerCompat.IBiometricManager
        public boolean hasEnrolledBiometric(Context context) {
            return FaceidManagerProxy.hasEnrolledFaceids(context);
        }

        @Override // com.tencent.soter.core.biometric.BiometricManagerCompat.IBiometricManager
        public boolean isHardwareDetected(Context context) {
            return FaceidManagerProxy.isHardwareDetected(context);
        }
    }

    /* loaded from: classes6.dex */
    private static class FingerprintManagerImpl implements IBiometricManager {
        private static final String TAG = "Soter.BiometricManagerCompat.Fingerprint";

        /* JADX INFO: Access modifiers changed from: private */
        public static void informTooManyTrial(FingerprintManagerProxy.AuthenticationCallback authenticationCallback) {
            SLogger.w(TAG, "soter: too many fail fingerprint callback. inform it.", new Object[0]);
            authenticationCallback.onAuthenticationError(10308, "Too many failed times");
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static boolean shouldInformTooManyTrial(FingerprintManagerProxy.AuthenticationCallback authenticationCallback, Context context) {
            if (SoterBiometricAntiBruteForceStrategy.isSystemHasAntiBruteForce()) {
                SLogger.v(TAG, "soter: using system anti brute force strategy", new Object[0]);
                return false;
            } else if (SoterBiometricAntiBruteForceStrategy.isCurrentTweenTimeAvailable(context)) {
                if (!SoterBiometricAntiBruteForceStrategy.isCurrentFailTimeAvailable(context)) {
                    SLogger.v(TAG, "soter: unfreeze former frozen status", new Object[0]);
                    SoterBiometricAntiBruteForceStrategy.unFreeze(context);
                }
                return false;
            } else if (SoterBiometricAntiBruteForceStrategy.isCurrentFailTimeAvailable(context)) {
                SLogger.v(TAG, "soter: failure time available", new Object[0]);
                return false;
            } else {
                informTooManyTrial(authenticationCallback);
                return true;
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static CryptoObject unwrapCryptoObject(FingerprintManagerProxy.CryptoObject cryptoObject) {
            if (cryptoObject == null) {
                return null;
            }
            if (cryptoObject.getCipher() != null) {
                return new CryptoObject(cryptoObject.getCipher());
            }
            if (cryptoObject.getSignature() != null) {
                return new CryptoObject(cryptoObject.getSignature());
            }
            if (cryptoObject.getMac() == null) {
                return null;
            }
            return new CryptoObject(cryptoObject.getMac());
        }

        private static FingerprintManagerProxy.AuthenticationCallback wrapCallback(final Context context, final AuthenticationCallback authenticationCallback) {
            return new FingerprintManagerProxy.AuthenticationCallback() { // from class: com.tencent.soter.core.biometric.BiometricManagerCompat.FingerprintManagerImpl.1
                private boolean mMarkPermanentlyCallbacked = false;

                @Override // com.tencent.soter.core.biometric.FingerprintManagerProxy.AuthenticationCallback
                public void onAuthenticationError(int i4, CharSequence charSequence) {
                    SLogger.d(FingerprintManagerImpl.TAG, "soter: basic onAuthenticationError", new Object[0]);
                    if (this.mMarkPermanentlyCallbacked) {
                        return;
                    }
                    this.mMarkPermanentlyCallbacked = true;
                    if (i4 != 5 && i4 != 10) {
                        if (i4 != 7 && i4 != 9) {
                            AuthenticationCallback.this.onAuthenticationError(i4, charSequence);
                            return;
                        }
                        SLogger.i(FingerprintManagerImpl.TAG, "soter: system call too many trial.", new Object[0]);
                        if (!SoterBiometricAntiBruteForceStrategy.isCurrentFailTimeAvailable(context) && !SoterBiometricAntiBruteForceStrategy.isCurrentTweenTimeAvailable(context) && !SoterBiometricAntiBruteForceStrategy.isSystemHasAntiBruteForce()) {
                            SoterBiometricAntiBruteForceStrategy.freeze(context);
                        }
                        this.mMarkPermanentlyCallbacked = false;
                        if (i4 == 7) {
                            onAuthenticationError(10308, "Too many failed times");
                            return;
                        } else {
                            onAuthenticationError(10309, "Too many failed times");
                            return;
                        }
                    }
                    SLogger.i(FingerprintManagerImpl.TAG, "soter: user cancelled fingerprint authen", new Object[0]);
                    AuthenticationCallback.this.onAuthenticationCancelled();
                }

                @Override // com.tencent.soter.core.biometric.FingerprintManagerProxy.AuthenticationCallback
                public void onAuthenticationFailed() {
                    SLogger.d(FingerprintManagerImpl.TAG, "soter: basic onAuthenticationFailed", new Object[0]);
                    if (!this.mMarkPermanentlyCallbacked && !FingerprintManagerImpl.shouldInformTooManyTrial(this, context)) {
                        if (!SoterBiometricAntiBruteForceStrategy.isSystemHasAntiBruteForce()) {
                            SoterBiometricAntiBruteForceStrategy.addFailTime(context);
                            if (!SoterBiometricAntiBruteForceStrategy.isCurrentFailTimeAvailable(context)) {
                                SLogger.w(FingerprintManagerImpl.TAG, "soter: too many fail trials", new Object[0]);
                                SoterBiometricAntiBruteForceStrategy.freeze(context);
                                FingerprintManagerImpl.informTooManyTrial(this);
                                return;
                            }
                        }
                        AuthenticationCallback.this.onAuthenticationFailed();
                    }
                }

                @Override // com.tencent.soter.core.biometric.FingerprintManagerProxy.AuthenticationCallback
                public void onAuthenticationHelp(int i4, CharSequence charSequence) {
                    SLogger.d(FingerprintManagerImpl.TAG, "soter: basic onAuthenticationHelp", new Object[0]);
                    if (!this.mMarkPermanentlyCallbacked && !FingerprintManagerImpl.shouldInformTooManyTrial(this, context)) {
                        AuthenticationCallback.this.onAuthenticationHelp(i4, charSequence);
                    }
                }

                @Override // com.tencent.soter.core.biometric.FingerprintManagerProxy.AuthenticationCallback
                public void onAuthenticationSucceeded(FingerprintManagerProxy.AuthenticationResultInternal authenticationResultInternal) {
                    SLogger.d(FingerprintManagerImpl.TAG, "soter: basic onAuthenticationSucceeded", new Object[0]);
                    if (!this.mMarkPermanentlyCallbacked && !FingerprintManagerImpl.shouldInformTooManyTrial(this, context)) {
                        if (!SoterBiometricAntiBruteForceStrategy.isSystemHasAntiBruteForce()) {
                            SoterBiometricAntiBruteForceStrategy.unFreeze(context);
                        }
                        this.mMarkPermanentlyCallbacked = true;
                        AuthenticationCallback.this.onAuthenticationSucceeded(new AuthenticationResult(FingerprintManagerImpl.unwrapCryptoObject(authenticationResultInternal.getCryptoObject())));
                    }
                }
            };
        }

        private static FingerprintManagerProxy.CryptoObject wrapCryptoObject(CryptoObject cryptoObject) {
            if (cryptoObject == null) {
                return null;
            }
            if (cryptoObject.getCipher() != null) {
                return new FingerprintManagerProxy.CryptoObject(cryptoObject.getCipher());
            }
            if (cryptoObject.getSignature() != null) {
                return new FingerprintManagerProxy.CryptoObject(cryptoObject.getSignature());
            }
            if (cryptoObject.getMac() == null) {
                return null;
            }
            return new FingerprintManagerProxy.CryptoObject(cryptoObject.getMac());
        }

        @Override // com.tencent.soter.core.biometric.BiometricManagerCompat.IBiometricManager
        public void authenticate(Context context, CryptoObject cryptoObject, int i4, CancellationSignal cancellationSignal, AuthenticationCallback authenticationCallback, Handler handler, Bundle bundle) {
            FingerprintManagerProxy.authenticate(context, wrapCryptoObject(cryptoObject), i4, cancellationSignal, wrapCallback(context, authenticationCallback), handler, bundle);
        }

        @Override // com.tencent.soter.core.biometric.BiometricManagerCompat.IBiometricManager
        public String getBiometricName(Context context) {
            return "fingerprint";
        }

        @Override // com.tencent.soter.core.biometric.BiometricManagerCompat.IBiometricManager
        public boolean hasEnrolledBiometric(Context context) {
            return FingerprintManagerProxy.hasEnrolledFingerprints(context);
        }

        @Override // com.tencent.soter.core.biometric.BiometricManagerCompat.IBiometricManager
        public boolean isHardwareDetected(Context context) {
            return FingerprintManagerProxy.isHardwareDetected(context);
        }
    }

    /* loaded from: classes6.dex */
    private interface IBiometricManager {
        void authenticate(Context context, CryptoObject cryptoObject, int i4, CancellationSignal cancellationSignal, AuthenticationCallback authenticationCallback, Handler handler, Bundle bundle);

        String getBiometricName(Context context);

        boolean hasEnrolledBiometric(Context context);

        boolean isHardwareDetected(Context context);
    }

    static {
        IBiometricManager legacyFingerprintManagerImpl;
        HashMap hashMap = new HashMap();
        IMPL_PROVIDER = hashMap;
        if (SoterCore.isNativeSupportSoter()) {
            legacyFingerprintManagerImpl = new FingerprintManagerImpl();
        } else {
            legacyFingerprintManagerImpl = new LegacyFingerprintManagerImpl();
        }
        hashMap.put(1, legacyFingerprintManagerImpl);
        if (SoterCore.isNativeSupportSoter() && isNativeSupportFaceid()) {
            hashMap.put(2, new FaceidManagerImpl());
        }
    }

    private BiometricManagerCompat(Context context, Integer num) {
        this.mContext = context;
        this.mBiometricType = num;
    }

    public static BiometricManagerCompat from(Context context, Integer num) {
        return new BiometricManagerCompat(context, num);
    }

    public static boolean isNativeSupportFaceid() {
        try {
            Class.forName(FaceidManagerProxy.FACEMANAGER_FACTORY_CLASS_NAME);
            return true;
        } catch (Exception unused) {
            return false;
        }
    }

    public void authenticate(CryptoObject cryptoObject, int i4, CancellationSignal cancellationSignal, AuthenticationCallback authenticationCallback, Handler handler, Bundle bundle) {
        IBiometricManager iBiometricManager = IMPL_PROVIDER.get(this.mBiometricType);
        if (iBiometricManager == null) {
            SLogger.i(TAG, "soter: Biometric provider not initialized type[" + this.mBiometricType + "]", new Object[0]);
            authenticationCallback.onAuthenticationCancelled();
        }
        iBiometricManager.authenticate(this.mContext, cryptoObject, i4, cancellationSignal, authenticationCallback, handler, bundle);
    }

    public String getBiometricName() {
        IBiometricManager iBiometricManager = IMPL_PROVIDER.get(this.mBiometricType);
        if (iBiometricManager == null) {
            SLogger.i(TAG, "soter: Biometric provider not initialized type[" + this.mBiometricType + "]", new Object[0]);
            return null;
        }
        return iBiometricManager.getBiometricName(this.mContext);
    }

    public boolean hasEnrolledBiometric() {
        IBiometricManager iBiometricManager = IMPL_PROVIDER.get(this.mBiometricType);
        if (iBiometricManager == null) {
            SLogger.i(TAG, "soter: Biometric provider not initialized type[" + this.mBiometricType + "]", new Object[0]);
            return false;
        }
        return iBiometricManager.hasEnrolledBiometric(this.mContext);
    }

    public boolean isCurrentFailTimeAvailable() {
        return SoterBiometricAntiBruteForceStrategy.isCurrentFailTimeAvailable(this.mContext);
    }

    public boolean isCurrentTweenTimeAvailable(Context context) {
        return SoterBiometricAntiBruteForceStrategy.isCurrentTweenTimeAvailable(this.mContext);
    }

    public boolean isHardwareDetected() {
        IBiometricManager iBiometricManager = IMPL_PROVIDER.get(this.mBiometricType);
        if (iBiometricManager == null) {
            SLogger.i(TAG, "soter: Biometric provider not initialized type[" + this.mBiometricType + "]", new Object[0]);
            return false;
        }
        return iBiometricManager.isHardwareDetected(this.mContext);
    }

    /* loaded from: classes6.dex */
    public static class CryptoObject {
        private final Cipher mCipher;
        private final Mac mMac;
        private final Signature mSignature;

        public CryptoObject(Signature signature) {
            this.mSignature = signature;
            this.mCipher = null;
            this.mMac = null;
        }

        public Cipher getCipher() {
            return this.mCipher;
        }

        public Mac getMac() {
            return this.mMac;
        }

        public Signature getSignature() {
            return this.mSignature;
        }

        public CryptoObject(Cipher cipher) {
            this.mCipher = cipher;
            this.mSignature = null;
            this.mMac = null;
        }

        public CryptoObject(Mac mac) {
            this.mMac = mac;
            this.mCipher = null;
            this.mSignature = null;
        }
    }

    /* loaded from: classes6.dex */
    public static abstract class AuthenticationCallback {
        public void onAuthenticationCancelled() {
        }

        public void onAuthenticationFailed() {
        }

        public void onAuthenticationSucceeded(AuthenticationResult authenticationResult) {
        }

        public void onAuthenticationError(int i4, CharSequence charSequence) {
        }

        public void onAuthenticationHelp(int i4, CharSequence charSequence) {
        }
    }

    /* loaded from: classes6.dex */
    private static class LegacyFingerprintManagerImpl implements IBiometricManager {
        @Override // com.tencent.soter.core.biometric.BiometricManagerCompat.IBiometricManager
        public String getBiometricName(Context context) {
            return null;
        }

        @Override // com.tencent.soter.core.biometric.BiometricManagerCompat.IBiometricManager
        public boolean hasEnrolledBiometric(Context context) {
            return false;
        }

        @Override // com.tencent.soter.core.biometric.BiometricManagerCompat.IBiometricManager
        public boolean isHardwareDetected(Context context) {
            return false;
        }

        @Override // com.tencent.soter.core.biometric.BiometricManagerCompat.IBiometricManager
        public void authenticate(Context context, CryptoObject cryptoObject, int i4, CancellationSignal cancellationSignal, AuthenticationCallback authenticationCallback, Handler handler, Bundle bundle) {
        }
    }
}
