package com.tencent.soter.core.biometric;

import android.content.Context;
import android.os.CancellationSignal;
import android.os.Handler;
import java.security.Signature;
import javax.crypto.Cipher;
import javax.crypto.Mac;

/* loaded from: classes6.dex */
public abstract class FaceManager {
    public static final int FACE_ACQUIRED_BRIGHT = 1112;
    public static final int FACE_ACQUIRED_DARK = 1110;
    public static final int FACE_ACQUIRED_DOWN = 1116;
    public static final int FACE_ACQUIRED_FAR_FACE = 1106;
    public static final int FACE_ACQUIRED_GOOD = 1101;
    public static final int FACE_ACQUIRED_HACKER = 1111;
    public static final int FACE_ACQUIRED_IMAGER_DIRTY = 1103;
    public static final int FACE_ACQUIRED_INSUFFICIENT = 1102;
    public static final int FACE_ACQUIRED_LEFT = 1113;
    public static final int FACE_ACQUIRED_MOUTH_OCCLUSION = 1119;
    public static final int FACE_ACQUIRED_MULTI_FACE = 1121;
    public static final int FACE_ACQUIRED_NEAR_FACE = 1107;
    public static final int FACE_ACQUIRED_NOSE_OCCLUSION = 1120;
    public static final int FACE_ACQUIRED_NO_FACE = 1108;
    public static final int FACE_ACQUIRED_NO_FOCUS = 1118;
    public static final int FACE_ACQUIRED_RIGHT = 1114;
    public static final int FACE_ACQUIRED_SHIFTING = 1109;
    public static final int FACE_ACQUIRED_TOO_FAST = 1105;
    public static final int FACE_ACQUIRED_TOO_SLOW = 1104;
    public static final int FACE_ACQUIRED_UP = 1115;
    public static final int FACE_ERROR_CAMERA_UNAVAILABLE = 8;
    public static final int FACE_ERROR_CANCELED = 5;
    public static final int FACE_ERROR_HW_UNAVAILABLE = 1;
    public static final int FACE_ERROR_LOCKOUT = 7;
    public static final int FACE_ERROR_TIMEOUT = 3;
    public static final int FACE_ERROR_UNABLE_TO_PROCESS = 2;
    public static final int FACE_ERROR_VENDOR_BASE = 1000;
    public static final int FACE_WITH_EYES_CLOSED = 1117;
    private static final String TAG = "Soter.FaceManager";

    /* loaded from: classes6.dex */
    public static class AuthenticationResult {
        private CryptoObject mCryptoObject;

        public AuthenticationResult(CryptoObject cryptoObject) {
            this.mCryptoObject = cryptoObject;
        }

        public CryptoObject getCryptoObject() {
            return this.mCryptoObject;
        }
    }

    public abstract void authenticate(CryptoObject cryptoObject, CancellationSignal cancellationSignal, int i4, AuthenticationCallback authenticationCallback, Handler handler);

    public abstract String getBiometricName(Context context);

    public abstract boolean hasEnrolledFaces();

    public abstract boolean isHardwareDetected();

    /* loaded from: classes6.dex */
    public static final class CryptoObject {
        private final Object mCrypto;

        public CryptoObject(Signature signature) {
            this.mCrypto = signature;
        }

        public Cipher getCipher() {
            Object obj = this.mCrypto;
            if (obj instanceof Cipher) {
                return (Cipher) obj;
            }
            return null;
        }

        public Mac getMac() {
            Object obj = this.mCrypto;
            if (obj instanceof Mac) {
                return (Mac) obj;
            }
            return null;
        }

        public Signature getSignature() {
            Object obj = this.mCrypto;
            if (obj instanceof Signature) {
                return (Signature) obj;
            }
            return null;
        }

        public CryptoObject(Cipher cipher) {
            this.mCrypto = cipher;
        }

        public CryptoObject(Mac mac) {
            this.mCrypto = mac;
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
