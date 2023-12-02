package com.tencent.soter.core.biometric;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.CancellationSignal;
import android.os.Handler;
import com.tencent.soter.core.biometric.FaceManager;
import com.tencent.soter.core.model.SLogger;
import java.security.Signature;
import javax.crypto.Cipher;
import javax.crypto.Mac;

@SuppressLint({"NewApi"})
/* loaded from: classes6.dex */
final class FaceidManagerProxy {
    public static final String FACEMANAGER_FACTORY_CLASS_NAME = "com.tencent.soter.core.biometric.SoterFaceManagerFactory";
    private static final String TAG = "Soter.FaceidManagerProxy";

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

    FaceidManagerProxy() {
    }

    public static void authenticate(Context context, CryptoObject cryptoObject, int i4, Object obj, AuthenticationCallback authenticationCallback, Handler handler) {
        try {
            FaceManager faceManager = getFaceManager(context);
            if (faceManager != null) {
                faceManager.authenticate(wrapCryptoObject(cryptoObject), (CancellationSignal) obj, i4, wrapCallback(authenticationCallback), handler);
            } else {
                SLogger.e(TAG, "soter: facemanager is null in authenticate! Should never happen", new Object[0]);
            }
        } catch (Exception unused) {
            SLogger.e(TAG, "soter: triggered SecurityException in authenticate! Make sure you declared USE_FACEID in AndroidManifest.xml", new Object[0]);
        }
    }

    public static String getBiometricName(Context context) {
        try {
            FaceManager faceManager = getFaceManager(context);
            if (faceManager != null) {
                return faceManager.getBiometricName(context);
            }
            SLogger.e(TAG, "soter: faceid manager is null! no biometric name returned.", new Object[0]);
            return null;
        } catch (Exception unused) {
            SLogger.e(TAG, "soter: triggered SecurityException in getBiometricName! Make sure you declared USE_FACEID in AndroidManifest.xml", new Object[0]);
            return null;
        }
    }

    private static FaceManager getFaceManager(Context context) {
        try {
            return (FaceManager) Class.forName(FACEMANAGER_FACTORY_CLASS_NAME).getDeclaredMethod("getFaceManager", Context.class).invoke(null, context);
        } catch (Exception e4) {
            SLogger.e(TAG, "soter: FaceManager init failed, maybe not support." + e4.toString(), new Object[0]);
            e4.printStackTrace();
            return null;
        }
    }

    public static boolean hasEnrolledFaceids(Context context) {
        try {
            FaceManager faceManager = getFaceManager(context);
            if (faceManager != null) {
                return faceManager.hasEnrolledFaces();
            }
            SLogger.e(TAG, "soter: facemanager is null in hasEnrolledBiometric! Should never happen", new Object[0]);
            return false;
        } catch (Exception unused) {
            SLogger.e(TAG, "soter: triggered SecurityException in hasEnrolledBiometric! Make sure you declared USE_FACEID in AndroidManifest.xml", new Object[0]);
            return false;
        }
    }

    public static boolean isHardwareDetected(Context context) {
        try {
            FaceManager faceManager = getFaceManager(context);
            if (faceManager != null) {
                return faceManager.isHardwareDetected();
            }
            SLogger.e(TAG, "soter: facemanager is null in isHardwareDetected! Should never happen", new Object[0]);
            return false;
        } catch (Exception unused) {
            SLogger.e(TAG, "soter: triggered SecurityException in isHardwareDetected! Make sure you declared USE_FACEID in AndroidManifest.xml", new Object[0]);
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static CryptoObject unwrapCryptoObject(FaceManager.CryptoObject cryptoObject) {
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

    private static FaceManager.AuthenticationCallback wrapCallback(final AuthenticationCallback authenticationCallback) {
        return new FaceManager.AuthenticationCallback() { // from class: com.tencent.soter.core.biometric.FaceidManagerProxy.1
            @Override // com.tencent.soter.core.biometric.FaceManager.AuthenticationCallback
            public void onAuthenticationError(int i4, CharSequence charSequence) {
                SLogger.d(FaceidManagerProxy.TAG, "hy: lowest level return onAuthenticationError", new Object[0]);
                AuthenticationCallback.this.onAuthenticationError(i4, charSequence);
            }

            @Override // com.tencent.soter.core.biometric.FaceManager.AuthenticationCallback
            public void onAuthenticationFailed() {
                SLogger.d(FaceidManagerProxy.TAG, "hy: lowest level return onAuthenticationFailed", new Object[0]);
                AuthenticationCallback.this.onAuthenticationFailed();
            }

            @Override // com.tencent.soter.core.biometric.FaceManager.AuthenticationCallback
            public void onAuthenticationHelp(int i4, CharSequence charSequence) {
                SLogger.d(FaceidManagerProxy.TAG, "hy: lowest level return onAuthenticationHelp", new Object[0]);
                AuthenticationCallback.this.onAuthenticationHelp(i4, charSequence);
            }

            @Override // com.tencent.soter.core.biometric.FaceManager.AuthenticationCallback
            public void onAuthenticationSucceeded(FaceManager.AuthenticationResult authenticationResult) {
                SLogger.d(FaceidManagerProxy.TAG, "hy: lowest level return onAuthenticationSucceeded", new Object[0]);
                AuthenticationCallback.this.onAuthenticationSucceeded(new AuthenticationResult(FaceidManagerProxy.unwrapCryptoObject(authenticationResult.getCryptoObject())));
            }
        };
    }

    private static FaceManager.CryptoObject wrapCryptoObject(CryptoObject cryptoObject) {
        if (cryptoObject == null) {
            return null;
        }
        if (cryptoObject.getCipher() != null) {
            return new FaceManager.CryptoObject(cryptoObject.getCipher());
        }
        if (cryptoObject.getSignature() != null) {
            return new FaceManager.CryptoObject(cryptoObject.getSignature());
        }
        if (cryptoObject.getMac() == null) {
            return null;
        }
        return new FaceManager.CryptoObject(cryptoObject.getMac());
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
        public void onAuthenticationFailed() {
        }

        public void onAuthenticationSucceeded(AuthenticationResult authenticationResult) {
        }

        public void onAuthenticationError(int i4, CharSequence charSequence) {
        }

        public void onAuthenticationHelp(int i4, CharSequence charSequence) {
        }
    }
}
