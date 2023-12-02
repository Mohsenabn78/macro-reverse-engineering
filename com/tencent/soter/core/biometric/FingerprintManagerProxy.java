package com.tencent.soter.core.biometric;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.DialogInterface;
import android.hardware.biometrics.BiometricPrompt;
import android.hardware.fingerprint.FingerprintManager;
import android.os.Build;
import android.os.Bundle;
import android.os.CancellationSignal;
import android.os.Handler;
import android.text.TextUtils;
import com.tencent.soter.core.model.ConstantsSoter;
import com.tencent.soter.core.model.SLogger;
import com.tencent.soter.core.model.SoterCoreUtil;
import java.security.Signature;
import java.util.concurrent.Executor;
import javax.crypto.Cipher;
import javax.crypto.Mac;

@SuppressLint({"NewApi"})
/* loaded from: classes6.dex */
final class FingerprintManagerProxy {
    public static final String FINGERPRINT_SERVICE = "fingerprint";
    private static final String TAG = "Soter.FingerprintManagerProxy";
    public static boolean sCLOSE_API31 = false;

    /* loaded from: classes6.dex */
    public static final class AuthenticationResultInternal {
        private CryptoObject mCryptoObject;

        public AuthenticationResultInternal(CryptoObject cryptoObject) {
            this.mCryptoObject = cryptoObject;
        }

        public CryptoObject getCryptoObject() {
            return this.mCryptoObject;
        }
    }

    FingerprintManagerProxy() {
    }

    public static void authenticate(Context context, CryptoObject cryptoObject, int i4, Object obj, AuthenticationCallback authenticationCallback, Handler handler, Bundle bundle) {
        boolean z3 = bundle.getBoolean("use_biometric_prompt");
        int i5 = Build.VERSION.SDK_INT;
        SLogger.i(TAG, "use_biometric_prompt: %s, sdk_version: %s", Boolean.valueOf(z3), Integer.valueOf(i5));
        if (z3 && i5 >= 28) {
            authenticateApi28(context, cryptoObject, i4, obj, authenticationCallback, handler, bundle);
        } else {
            authenticateLegacy(context, cryptoObject, i4, obj, authenticationCallback, handler);
        }
    }

    @SuppressLint({"MissingPermission"})
    private static void authenticateApi28(Context context, CryptoObject cryptoObject, int i4, Object obj, final AuthenticationCallback authenticationCallback, Handler handler, Bundle bundle) {
        Executor mainExecutor;
        BiometricPrompt build;
        Executor mainExecutor2;
        if (checkSelfPermission(context, "android.permission.USE_BIOMETRIC") != 0) {
            SLogger.e(TAG, "soter: permission check failed: authenticate", new Object[0]);
            return;
        }
        BiometricPrompt.Builder builder = new BiometricPrompt.Builder(context);
        builder.setDeviceCredentialAllowed(false);
        if (Build.VERSION.SDK_INT >= 30) {
            builder.setAllowedAuthenticators(15);
        }
        builder.setTitle(bundle.getString("prompt_title"));
        builder.setSubtitle(bundle.getString("prompt_subtitle"));
        builder.setDescription(bundle.getString("prompt_description"));
        String string = bundle.getString("prompt_button");
        if (TextUtils.isEmpty(string)) {
            string = context.getString(17039360);
        }
        mainExecutor = context.getMainExecutor();
        builder.setNegativeButton(string, mainExecutor, new DialogInterface.OnClickListener() { // from class: com.tencent.soter.core.biometric.FingerprintManagerProxy.1
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i5) {
                AuthenticationCallback.this.onAuthenticationError(ConstantsSoter.ERR_NEGATIVE_BUTTON, "click negative button");
            }
        });
        build = builder.build();
        mainExecutor2 = context.getMainExecutor();
        build.authenticate((CancellationSignal) obj, mainExecutor2, wrapCallback2(authenticationCallback));
    }

    @SuppressLint({"MissingPermission"})
    private static void authenticateLegacy(Context context, CryptoObject cryptoObject, int i4, Object obj, AuthenticationCallback authenticationCallback, Handler handler) {
        if (checkSelfPermission(context, "android.permission.USE_FINGERPRINT") != 0) {
            SLogger.e(TAG, "soter: permission check failed: authenticate", new Object[0]);
            return;
        }
        try {
            FingerprintManager fingerprintManager = getFingerprintManager(context);
            if (fingerprintManager != null) {
                fingerprintManager.authenticate(wrapCryptoObject(cryptoObject), (CancellationSignal) obj, i4, wrapCallback(authenticationCallback), handler);
            } else {
                SLogger.e(TAG, "soter: fingerprint manager is null in authenticate! Should never happen", new Object[0]);
            }
        } catch (SecurityException unused) {
            SLogger.e(TAG, "soter: triggered SecurityException in authenticate! Make sure you declared USE_FINGERPRINT in AndroidManifest.xml", new Object[0]);
        }
    }

    private static int checkSelfPermission(Context context, String str) {
        int checkSelfPermission;
        if (context == null) {
            SLogger.e(TAG, "soter: check self permission: context is null", new Object[0]);
            return -1;
        } else if (SoterCoreUtil.isNullOrNil(str)) {
            SLogger.e(TAG, "soter: requested permission is null or nil", new Object[0]);
            return -1;
        } else if (Build.VERSION.SDK_INT >= 23) {
            checkSelfPermission = context.checkSelfPermission(str);
            return checkSelfPermission;
        } else {
            SLogger.d(TAG, "soter: below 23. directly return.", new Object[0]);
            return 0;
        }
    }

    private static FingerprintManager getFingerprintManager(Context context) {
        return (FingerprintManager) context.getSystemService("fingerprint");
    }

    public static boolean hasEnrolledFingerprints(Context context) {
        boolean hasEnrolledFingerprints;
        if (checkSelfPermission(context, "android.permission.USE_FINGERPRINT") != 0) {
            SLogger.e(TAG, "soter: permission check failed: hasEnrolledBiometric", new Object[0]);
            return false;
        }
        try {
            FingerprintManager fingerprintManager = getFingerprintManager(context);
            if (fingerprintManager != null) {
                hasEnrolledFingerprints = fingerprintManager.hasEnrolledFingerprints();
                return hasEnrolledFingerprints;
            }
            SLogger.e(TAG, "soter: fingerprint manager is null in hasEnrolledBiometric! Should never happen", new Object[0]);
            return false;
        } catch (SecurityException unused) {
            SLogger.e(TAG, "soter: triggered SecurityException in hasEnrolledBiometric! Make sure you declared USE_FINGERPRINT in AndroidManifest.xml", new Object[0]);
            return false;
        }
    }

    public static boolean isHardwareDetected(Context context) {
        boolean isHardwareDetected;
        if (checkSelfPermission(context, "android.permission.USE_FINGERPRINT") != 0) {
            SLogger.e(TAG, "soter: permission check failed: isHardwareDetected", new Object[0]);
            return false;
        }
        try {
            FingerprintManager fingerprintManager = getFingerprintManager(context);
            if (fingerprintManager != null) {
                isHardwareDetected = fingerprintManager.isHardwareDetected();
                return isHardwareDetected;
            }
            SLogger.e(TAG, "soter: fingerprint manager is null in isHardwareDetected! Should never happen", new Object[0]);
            return false;
        } catch (SecurityException unused) {
            SLogger.e(TAG, "soter: triggered SecurityException in isHardwareDetected! Make sure you declared USE_FINGERPRINT in AndroidManifest.xml", new Object[0]);
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static CryptoObject unwrapCryptoObject(FingerprintManager.CryptoObject cryptoObject) {
        Cipher cipher;
        Signature signature;
        Mac mac;
        Mac mac2;
        Signature signature2;
        Cipher cipher2;
        if (cryptoObject == null) {
            return null;
        }
        cipher = cryptoObject.getCipher();
        if (cipher != null) {
            cipher2 = cryptoObject.getCipher();
            return new CryptoObject(cipher2);
        }
        signature = cryptoObject.getSignature();
        if (signature != null) {
            signature2 = cryptoObject.getSignature();
            return new CryptoObject(signature2);
        }
        mac = cryptoObject.getMac();
        if (mac != null) {
            mac2 = cryptoObject.getMac();
            return new CryptoObject(mac2);
        }
        return null;
    }

    private static FingerprintManager.AuthenticationCallback wrapCallback(final AuthenticationCallback authenticationCallback) {
        return new FingerprintManager.AuthenticationCallback() { // from class: com.tencent.soter.core.biometric.FingerprintManagerProxy.2
            @Override // android.hardware.fingerprint.FingerprintManager.AuthenticationCallback
            public void onAuthenticationError(int i4, CharSequence charSequence) {
                SLogger.d(FingerprintManagerProxy.TAG, "hy: lowest level return onAuthenticationError", new Object[0]);
                AuthenticationCallback.this.onAuthenticationError(i4, charSequence);
            }

            @Override // android.hardware.fingerprint.FingerprintManager.AuthenticationCallback
            public void onAuthenticationFailed() {
                SLogger.d(FingerprintManagerProxy.TAG, "hy: lowest level return onAuthenticationFailed", new Object[0]);
                AuthenticationCallback.this.onAuthenticationFailed();
            }

            @Override // android.hardware.fingerprint.FingerprintManager.AuthenticationCallback
            public void onAuthenticationHelp(int i4, CharSequence charSequence) {
                SLogger.d(FingerprintManagerProxy.TAG, "hy: lowest level return onAuthenticationHelp", new Object[0]);
                AuthenticationCallback.this.onAuthenticationHelp(i4, charSequence);
            }

            @Override // android.hardware.fingerprint.FingerprintManager.AuthenticationCallback
            public void onAuthenticationSucceeded(FingerprintManager.AuthenticationResult authenticationResult) {
                FingerprintManager.CryptoObject cryptoObject;
                SLogger.d(FingerprintManagerProxy.TAG, "hy: lowest level return onAuthenticationSucceeded", new Object[0]);
                AuthenticationCallback authenticationCallback2 = AuthenticationCallback.this;
                cryptoObject = authenticationResult.getCryptoObject();
                authenticationCallback2.onAuthenticationSucceeded(new AuthenticationResultInternal(FingerprintManagerProxy.unwrapCryptoObject(cryptoObject)));
            }
        };
    }

    private static BiometricPrompt.AuthenticationCallback wrapCallback2(final AuthenticationCallback authenticationCallback) {
        return new BiometricPrompt.AuthenticationCallback() { // from class: com.tencent.soter.core.biometric.FingerprintManagerProxy.3
            @Override // android.hardware.biometrics.BiometricPrompt.AuthenticationCallback
            public void onAuthenticationError(int i4, CharSequence charSequence) {
                AuthenticationCallback.this.onAuthenticationError(i4, charSequence);
            }

            @Override // android.hardware.biometrics.BiometricPrompt.AuthenticationCallback
            public void onAuthenticationFailed() {
                AuthenticationCallback.this.onAuthenticationFailed();
            }

            @Override // android.hardware.biometrics.BiometricPrompt.AuthenticationCallback
            public void onAuthenticationHelp(int i4, CharSequence charSequence) {
                AuthenticationCallback.this.onAuthenticationHelp(i4, charSequence);
            }

            @Override // android.hardware.biometrics.BiometricPrompt.AuthenticationCallback
            public void onAuthenticationSucceeded(BiometricPrompt.AuthenticationResult authenticationResult) {
                BiometricPrompt.CryptoObject cryptoObject;
                AuthenticationCallback authenticationCallback2 = AuthenticationCallback.this;
                cryptoObject = authenticationResult.getCryptoObject();
                authenticationCallback2.onAuthenticationSucceeded(new AuthenticationResultInternal(FingerprintManagerProxy.unwrapCryptoObject(cryptoObject)));
            }
        };
    }

    private static FingerprintManager.CryptoObject wrapCryptoObject(CryptoObject cryptoObject) {
        if (cryptoObject == null) {
            return null;
        }
        if (cryptoObject.getCipher() != null) {
            return new FingerprintManager.CryptoObject(cryptoObject.getCipher());
        }
        if (cryptoObject.getSignature() != null) {
            return new FingerprintManager.CryptoObject(cryptoObject.getSignature());
        }
        if (cryptoObject.getMac() == null) {
            return null;
        }
        return new FingerprintManager.CryptoObject(cryptoObject.getMac());
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

    /* JADX INFO: Access modifiers changed from: private */
    public static CryptoObject unwrapCryptoObject(BiometricPrompt.CryptoObject cryptoObject) {
        Cipher cipher;
        Signature signature;
        Mac mac;
        Mac mac2;
        Signature signature2;
        Cipher cipher2;
        if (cryptoObject == null) {
            return null;
        }
        cipher = cryptoObject.getCipher();
        if (cipher != null) {
            cipher2 = cryptoObject.getCipher();
            return new CryptoObject(cipher2);
        }
        signature = cryptoObject.getSignature();
        if (signature != null) {
            signature2 = cryptoObject.getSignature();
            return new CryptoObject(signature2);
        }
        mac = cryptoObject.getMac();
        if (mac != null) {
            mac2 = cryptoObject.getMac();
            return new CryptoObject(mac2);
        }
        return null;
    }

    /* loaded from: classes6.dex */
    public static abstract class AuthenticationCallback {
        public void onAuthenticationFailed() {
        }

        public void onAuthenticationSucceeded(AuthenticationResultInternal authenticationResultInternal) {
        }

        public void onAuthenticationError(int i4, CharSequence charSequence) {
        }

        public void onAuthenticationHelp(int i4, CharSequence charSequence) {
        }
    }
}
