package com.hihonor.android.facerecognition;

import android.os.CancellationSignal;
import android.os.Handler;
import java.security.Signature;
import javax.crypto.Cipher;
import javax.crypto.Mac;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import net.bytebuddy.description.method.MethodDescription;
import net.bytebuddy.implementation.auxiliary.TypeProxy;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: FaceManager.kt */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b&\u0018\u0000 \u00152\u00020\u0001:\u0004\u0013\u0014\u0015\u0016B\u0005¢\u0006\u0002\u0010\u0002J8\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011H&J\b\u0010\u0012\u001a\u00020\u0004H&R\u0012\u0010\u0003\u001a\u00020\u0004X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0003\u0010\u0005¨\u0006\u0017"}, d2 = {"Lcom/hihonor/android/facerecognition/FaceManager;", "", "()V", "isHardwareDetected", "", "()Z", "authenticate", "", "var1", "Lcom/hihonor/android/facerecognition/FaceManager$CryptoObject;", "var2", "Landroid/os/CancellationSignal;", "var3", "", "var4", "Lcom/hihonor/android/facerecognition/FaceManager$AuthenticationCallback;", "var5", "Landroid/os/Handler;", "hasEnrolledTemplates", "AuthenticationCallback", "AuthenticationResult", "Companion", "CryptoObject", "biometric_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes6.dex */
public abstract class FaceManager {
    @NotNull
    public static final Companion Companion = new Companion(null);
    public static final int FACE_ACQUIRED_GOOD = 0;
    public static final int FACE_ACQUIRED_INSUFFICIENT = 1;
    public static final int FACE_ACQUIRED_NOT_DETECTED = 12;
    public static final int FACE_ACQUIRED_POOR_GAZE = 11;
    public static final int FACE_ACQUIRED_TOO_BRIGHT = 2;
    public static final int FACE_ACQUIRED_TOO_CLOSE = 4;
    public static final int FACE_ACQUIRED_TOO_DARK = 3;
    public static final int FACE_ACQUIRED_TOO_FAR = 5;
    public static final int FACE_ACQUIRED_TOO_HIGH = 6;
    public static final int FACE_ACQUIRED_TOO_LEFT = 9;
    public static final int FACE_ACQUIRED_TOO_LOW = 7;
    public static final int FACE_ACQUIRED_TOO_MUCH_MOTION = 10;
    public static final int FACE_ACQUIRED_TOO_RIGHT = 8;
    public static final int FACE_ACQUIRED_VENDOR = 13;
    public static final int FACE_ERROR_CANCELED = 5;
    public static final int FACE_ERROR_HW_NOT_PRESENT = 12;
    public static final int FACE_ERROR_HW_UNAVAILABLE = 1;
    public static final int FACE_ERROR_LOCKOUT = 7;
    public static final int FACE_ERROR_LOCKOUT_PERMANENT = 9;
    public static final int FACE_ERROR_NOT_ENROLLED = 11;
    public static final int FACE_ERROR_NO_SPACE = 4;
    public static final int FACE_ERROR_TIMEOUT = 3;
    public static final int FACE_ERROR_UNABLE_TO_PROCESS = 2;
    public static final int FACE_ERROR_UNABLE_TO_REMOVE = 6;
    public static final int FACE_ERROR_USER_CANCELED = 10;
    public static final int FACE_ERROR_VENDOR = 8;
    public static final int FACE_ERROR_VENDOR_BASE = 1000;

    /* compiled from: FaceManager.kt */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0007\u001a\u00020\u0002¢\u0006\u0004\b\b\u0010\tR\u0017\u0010\u0007\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006¨\u0006\n"}, d2 = {"Lcom/hihonor/android/facerecognition/FaceManager$AuthenticationResult;", "", "Lcom/hihonor/android/facerecognition/FaceManager$CryptoObject;", "a", "Lcom/hihonor/android/facerecognition/FaceManager$CryptoObject;", "getCryptoObject", "()Lcom/hihonor/android/facerecognition/FaceManager$CryptoObject;", "cryptoObject", MethodDescription.CONSTRUCTOR_INTERNAL_NAME, "(Lcom/hihonor/android/facerecognition/FaceManager$CryptoObject;)V", "biometric_release"}, k = 1, mv = {1, 8, 0})
    /* loaded from: classes6.dex */
    public static final class AuthenticationResult {
        @NotNull

        /* renamed from: a  reason: collision with root package name */
        private final CryptoObject f34049a;

        public AuthenticationResult(@NotNull CryptoObject cryptoObject) {
            Intrinsics.checkNotNullParameter(cryptoObject, "cryptoObject");
            this.f34049a = cryptoObject;
        }

        @NotNull
        public final CryptoObject getCryptoObject() {
            return this.f34049a;
        }
    }

    /* compiled from: FaceManager.kt */
    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u001b\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020 X\u0082T¢\u0006\u0002\n\u0000¨\u0006!"}, d2 = {"Lcom/hihonor/android/facerecognition/FaceManager$Companion;", "", "()V", "FACE_ACQUIRED_GOOD", "", "FACE_ACQUIRED_INSUFFICIENT", "FACE_ACQUIRED_NOT_DETECTED", "FACE_ACQUIRED_POOR_GAZE", "FACE_ACQUIRED_TOO_BRIGHT", "FACE_ACQUIRED_TOO_CLOSE", "FACE_ACQUIRED_TOO_DARK", "FACE_ACQUIRED_TOO_FAR", "FACE_ACQUIRED_TOO_HIGH", "FACE_ACQUIRED_TOO_LEFT", "FACE_ACQUIRED_TOO_LOW", "FACE_ACQUIRED_TOO_MUCH_MOTION", "FACE_ACQUIRED_TOO_RIGHT", "FACE_ACQUIRED_VENDOR", "FACE_ERROR_CANCELED", "FACE_ERROR_HW_NOT_PRESENT", "FACE_ERROR_HW_UNAVAILABLE", "FACE_ERROR_LOCKOUT", "FACE_ERROR_LOCKOUT_PERMANENT", "FACE_ERROR_NOT_ENROLLED", "FACE_ERROR_NO_SPACE", "FACE_ERROR_TIMEOUT", "FACE_ERROR_UNABLE_TO_PROCESS", "FACE_ERROR_UNABLE_TO_REMOVE", "FACE_ERROR_USER_CANCELED", "FACE_ERROR_VENDOR", "FACE_ERROR_VENDOR_BASE", "TAG", "", "biometric_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* loaded from: classes6.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public abstract void authenticate(@Nullable CryptoObject cryptoObject, @Nullable CancellationSignal cancellationSignal, int i4, @Nullable AuthenticationCallback authenticationCallback, @Nullable Handler handler);

    public abstract boolean hasEnrolledTemplates();

    public abstract boolean isHardwareDetected();

    /* compiled from: FaceManager.kt */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B\u0011\b\u0016\u0012\u0006\u0010\b\u001a\u00020\u0005¢\u0006\u0004\b\u0011\u0010\u0012B\u0011\b\u0016\u0012\u0006\u0010\f\u001a\u00020\t¢\u0006\u0004\b\u0011\u0010\u0013B\u0011\b\u0016\u0012\u0006\u0010\u0010\u001a\u00020\r¢\u0006\u0004\b\u0011\u0010\u0014R\u0014\u0010\u0004\u001a\u00020\u00018\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0002\u0010\u0003R\u0013\u0010\b\u001a\u0004\u0018\u00010\u00058F¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007R\u0013\u0010\f\u001a\u0004\u0018\u00010\t8F¢\u0006\u0006\u001a\u0004\b\n\u0010\u000bR\u0013\u0010\u0010\u001a\u0004\u0018\u00010\r8F¢\u0006\u0006\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u0015"}, d2 = {"Lcom/hihonor/android/facerecognition/FaceManager$CryptoObject;", "", "a", TypeProxy.SilentConstruction.Appender.JAVA_LANG_OBJECT_DESCRIPTOR, "mCrypto", "Ljava/security/Signature;", "getSignature", "()Ljava/security/Signature;", "signature", "Ljavax/crypto/Cipher;", "getCipher", "()Ljavax/crypto/Cipher;", "cipher", "Ljavax/crypto/Mac;", "getMac", "()Ljavax/crypto/Mac;", "mac", MethodDescription.CONSTRUCTOR_INTERNAL_NAME, "(Ljava/security/Signature;)V", "(Ljavax/crypto/Cipher;)V", "(Ljavax/crypto/Mac;)V", "biometric_release"}, k = 1, mv = {1, 8, 0})
    /* loaded from: classes6.dex */
    public static final class CryptoObject {
        @NotNull

        /* renamed from: a  reason: collision with root package name */
        private final Object f34050a;

        public CryptoObject(@NotNull Signature signature) {
            Intrinsics.checkNotNullParameter(signature, "signature");
            this.f34050a = signature;
        }

        @Nullable
        public final Cipher getCipher() {
            Object obj = this.f34050a;
            if (obj instanceof Cipher) {
                return (Cipher) obj;
            }
            return null;
        }

        @Nullable
        public final Mac getMac() {
            Object obj = this.f34050a;
            if (obj instanceof Mac) {
                return (Mac) obj;
            }
            return null;
        }

        @Nullable
        public final Signature getSignature() {
            Object obj = this.f34050a;
            if (obj instanceof Signature) {
                return (Signature) obj;
            }
            return null;
        }

        public CryptoObject(@NotNull Cipher cipher) {
            Intrinsics.checkNotNullParameter(cipher, "cipher");
            this.f34050a = cipher;
        }

        public CryptoObject(@NotNull Mac mac) {
            Intrinsics.checkNotNullParameter(mac, "mac");
            this.f34050a = mac;
        }
    }

    /* compiled from: FaceManager.kt */
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\r\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\b&\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u001a\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\bH\u0016J\b\u0010\t\u001a\u00020\u0004H\u0016J\u001a\u0010\n\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\u00062\b\u0010\f\u001a\u0004\u0018\u00010\bH\u0016J\u0012\u0010\r\u001a\u00020\u00042\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0016¨\u0006\u0010"}, d2 = {"Lcom/hihonor/android/facerecognition/FaceManager$AuthenticationCallback;", "", "()V", "onAuthenticationError", "", "errorCode", "", "errString", "", "onAuthenticationFailed", "onAuthenticationHelp", "helpCode", "helpString", "onAuthenticationSucceeded", "result", "Lcom/hihonor/android/facerecognition/FaceManager$AuthenticationResult;", "biometric_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* loaded from: classes6.dex */
    public static abstract class AuthenticationCallback {
        public void onAuthenticationFailed() {
        }

        public void onAuthenticationSucceeded(@Nullable AuthenticationResult authenticationResult) {
        }

        public void onAuthenticationError(int i4, @Nullable CharSequence charSequence) {
        }

        public void onAuthenticationHelp(int i4, @Nullable CharSequence charSequence) {
        }
    }
}
