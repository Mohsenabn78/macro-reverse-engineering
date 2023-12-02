package com.tencent.soter.core.keystore;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.os.Build;
import android.security.keystore.KeyGenParameterSpec;
import com.tencent.soter.core.SoterCore;
import com.tencent.soter.core.model.SLogger;
import java.lang.reflect.InvocationTargetException;
import java.math.BigInteger;
import java.security.spec.AlgorithmParameterSpec;
import java.util.Date;
import javax.security.auth.x500.X500Principal;

/* loaded from: classes6.dex */
public abstract class KeyGenParameterSpecCompatBuilder {
    private static final String TAG = "Soter.KeyGenParameterSpecCompatBuilder";

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes6.dex */
    public static class DummyKeyGenParameterSpecCompatBuilder extends KeyGenParameterSpecCompatBuilder {
        public DummyKeyGenParameterSpecCompatBuilder(String str, int i4) {
            super(str, i4);
        }

        @Override // com.tencent.soter.core.keystore.KeyGenParameterSpecCompatBuilder
        public AlgorithmParameterSpec build() {
            return null;
        }

        @Override // com.tencent.soter.core.keystore.KeyGenParameterSpecCompatBuilder
        public KeyGenParameterSpecCompatBuilder setAlgorithmParameterSpec(AlgorithmParameterSpec algorithmParameterSpec) {
            return null;
        }

        @Override // com.tencent.soter.core.keystore.KeyGenParameterSpecCompatBuilder
        public KeyGenParameterSpecCompatBuilder setBlockModes(String... strArr) {
            return null;
        }

        @Override // com.tencent.soter.core.keystore.KeyGenParameterSpecCompatBuilder
        public KeyGenParameterSpecCompatBuilder setCertificateNotAfter(Date date) {
            return null;
        }

        @Override // com.tencent.soter.core.keystore.KeyGenParameterSpecCompatBuilder
        public KeyGenParameterSpecCompatBuilder setCertificateNotBefore(Date date) {
            return null;
        }

        @Override // com.tencent.soter.core.keystore.KeyGenParameterSpecCompatBuilder
        public KeyGenParameterSpecCompatBuilder setCertificateSerialNumber(BigInteger bigInteger) {
            return null;
        }

        @Override // com.tencent.soter.core.keystore.KeyGenParameterSpecCompatBuilder
        public KeyGenParameterSpecCompatBuilder setCertificateSubject(X500Principal x500Principal) {
            return null;
        }

        @Override // com.tencent.soter.core.keystore.KeyGenParameterSpecCompatBuilder
        public KeyGenParameterSpecCompatBuilder setDigests(String... strArr) {
            return null;
        }

        @Override // com.tencent.soter.core.keystore.KeyGenParameterSpecCompatBuilder
        public KeyGenParameterSpecCompatBuilder setEncryptionPaddings(String... strArr) {
            return null;
        }

        @Override // com.tencent.soter.core.keystore.KeyGenParameterSpecCompatBuilder
        public KeyGenParameterSpecCompatBuilder setKeySize(int i4) {
            return null;
        }

        @Override // com.tencent.soter.core.keystore.KeyGenParameterSpecCompatBuilder
        public KeyGenParameterSpecCompatBuilder setKeyValidityEnd(Date date) {
            return null;
        }

        @Override // com.tencent.soter.core.keystore.KeyGenParameterSpecCompatBuilder
        public KeyGenParameterSpecCompatBuilder setKeyValidityStart(Date date) {
            return null;
        }

        @Override // com.tencent.soter.core.keystore.KeyGenParameterSpecCompatBuilder
        public KeyGenParameterSpecCompatBuilder setRandomizedEncryptionRequired(boolean z3) {
            return null;
        }

        @Override // com.tencent.soter.core.keystore.KeyGenParameterSpecCompatBuilder
        public KeyGenParameterSpecCompatBuilder setSignaturePaddings(String... strArr) {
            return null;
        }

        @Override // com.tencent.soter.core.keystore.KeyGenParameterSpecCompatBuilder
        public KeyGenParameterSpecCompatBuilder setUserAuthenticationRequired(boolean z3) {
            return null;
        }

        @Override // com.tencent.soter.core.keystore.KeyGenParameterSpecCompatBuilder
        public KeyGenParameterSpecCompatBuilder setUserAuthenticationValidityDurationSeconds(int i4) {
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    @TargetApi(23)
    /* loaded from: classes6.dex */
    public static class NormalKeyGenParameterSpecCompatBuilder extends KeyGenParameterSpecCompatBuilder {
        private KeyGenParameterSpec.Builder builder;

        public NormalKeyGenParameterSpecCompatBuilder(String str, int i4) {
            super(str, i4);
            this.builder = null;
            this.builder = new KeyGenParameterSpec.Builder(str, i4);
        }

        @Override // com.tencent.soter.core.keystore.KeyGenParameterSpecCompatBuilder
        public AlgorithmParameterSpec build() throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
            KeyGenParameterSpec build;
            build = this.builder.build();
            return build;
        }

        @Override // com.tencent.soter.core.keystore.KeyGenParameterSpecCompatBuilder
        public KeyGenParameterSpecCompatBuilder setAlgorithmParameterSpec(AlgorithmParameterSpec algorithmParameterSpec) {
            this.builder.setAlgorithmParameterSpec(algorithmParameterSpec);
            return this;
        }

        @Override // com.tencent.soter.core.keystore.KeyGenParameterSpecCompatBuilder
        @SuppressLint({"WrongConstant"})
        public KeyGenParameterSpecCompatBuilder setBlockModes(String... strArr) {
            this.builder.setBlockModes(strArr);
            return this;
        }

        @Override // com.tencent.soter.core.keystore.KeyGenParameterSpecCompatBuilder
        public KeyGenParameterSpecCompatBuilder setCertificateNotAfter(Date date) {
            this.builder.setCertificateNotAfter(date);
            return this;
        }

        @Override // com.tencent.soter.core.keystore.KeyGenParameterSpecCompatBuilder
        public KeyGenParameterSpecCompatBuilder setCertificateNotBefore(Date date) {
            this.builder.setCertificateNotBefore(date);
            return this;
        }

        @Override // com.tencent.soter.core.keystore.KeyGenParameterSpecCompatBuilder
        public KeyGenParameterSpecCompatBuilder setCertificateSerialNumber(BigInteger bigInteger) {
            this.builder.setCertificateSerialNumber(bigInteger);
            return this;
        }

        @Override // com.tencent.soter.core.keystore.KeyGenParameterSpecCompatBuilder
        public KeyGenParameterSpecCompatBuilder setCertificateSubject(X500Principal x500Principal) {
            this.builder.setCertificateSubject(x500Principal);
            return this;
        }

        @Override // com.tencent.soter.core.keystore.KeyGenParameterSpecCompatBuilder
        @SuppressLint({"WrongConstant"})
        public KeyGenParameterSpecCompatBuilder setDigests(String... strArr) {
            this.builder.setDigests(strArr);
            return this;
        }

        @Override // com.tencent.soter.core.keystore.KeyGenParameterSpecCompatBuilder
        @SuppressLint({"WrongConstant"})
        public KeyGenParameterSpecCompatBuilder setEncryptionPaddings(String... strArr) {
            this.builder.setEncryptionPaddings(strArr);
            return this;
        }

        @Override // com.tencent.soter.core.keystore.KeyGenParameterSpecCompatBuilder
        public KeyGenParameterSpecCompatBuilder setKeySize(int i4) {
            this.builder.setKeySize(i4);
            return this;
        }

        @Override // com.tencent.soter.core.keystore.KeyGenParameterSpecCompatBuilder
        public KeyGenParameterSpecCompatBuilder setKeyValidityEnd(Date date) {
            this.builder.setKeyValidityEnd(date);
            return this;
        }

        @Override // com.tencent.soter.core.keystore.KeyGenParameterSpecCompatBuilder
        public KeyGenParameterSpecCompatBuilder setKeyValidityStart(Date date) {
            this.builder.setKeyValidityStart(date);
            return this;
        }

        @Override // com.tencent.soter.core.keystore.KeyGenParameterSpecCompatBuilder
        public KeyGenParameterSpecCompatBuilder setRandomizedEncryptionRequired(boolean z3) {
            this.builder.setRandomizedEncryptionRequired(z3);
            return this;
        }

        @Override // com.tencent.soter.core.keystore.KeyGenParameterSpecCompatBuilder
        @SuppressLint({"WrongConstant"})
        public KeyGenParameterSpecCompatBuilder setSignaturePaddings(String... strArr) {
            this.builder.setSignaturePaddings(strArr);
            return this;
        }

        @Override // com.tencent.soter.core.keystore.KeyGenParameterSpecCompatBuilder
        public KeyGenParameterSpecCompatBuilder setUserAuthenticationRequired(boolean z3) {
            this.builder.setUserAuthenticationRequired(z3);
            return this;
        }

        @Override // com.tencent.soter.core.keystore.KeyGenParameterSpecCompatBuilder
        public KeyGenParameterSpecCompatBuilder setUserAuthenticationValidityDurationSeconds(int i4) {
            this.builder.setUserAuthenticationValidityDurationSeconds(i4);
            return this;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes6.dex */
    public static class ReflectKeyGenParameterSpecCompatBuilder extends KeyGenParameterSpecCompatBuilder {
        private static final String CLASSNAME = "android.security.keystore.KeyGenParameterSpec";
        private String[] mBlockModes;
        private Date mCertificateNotAfter;
        private Date mCertificateNotBefore;
        private BigInteger mCertificateSerialNumber;
        private X500Principal mCertificateSubject;
        private String[] mDigests;
        private String[] mEncryptionPaddings;
        private int mKeySize;
        private Date mKeyValidityForConsumptionEnd;
        private Date mKeyValidityForOriginationEnd;
        private Date mKeyValidityStart;
        private final String mKeystoreAlias;
        private int mPurposes;
        private boolean mRandomizedEncryptionRequired;
        private String[] mSignaturePaddings;
        private AlgorithmParameterSpec mSpec;
        private boolean mUserAuthenticationRequired;
        private int mUserAuthenticationValidityDurationSeconds;

        public ReflectKeyGenParameterSpecCompatBuilder(String str, int i4) {
            super(str, i4);
            this.mKeySize = -1;
            this.mRandomizedEncryptionRequired = true;
            this.mUserAuthenticationValidityDurationSeconds = -1;
            if (str != null) {
                if (!str.isEmpty()) {
                    this.mKeystoreAlias = str;
                    this.mPurposes = i4;
                    return;
                }
                throw new IllegalArgumentException("keystoreAlias must not be empty");
            }
            throw new NullPointerException("keystoreAlias == null");
        }

        @Override // com.tencent.soter.core.keystore.KeyGenParameterSpecCompatBuilder
        public AlgorithmParameterSpec build() throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
            Class<?> cls = Class.forName(CLASSNAME);
            Class<?> cls2 = Integer.TYPE;
            Class<?> cls3 = Boolean.TYPE;
            return (AlgorithmParameterSpec) cls.getConstructor(String.class, cls2, AlgorithmParameterSpec.class, X500Principal.class, BigInteger.class, Date.class, Date.class, Date.class, Date.class, Date.class, cls2, String[].class, String[].class, String[].class, String[].class, cls3, cls3, cls2).newInstance(this.mKeystoreAlias, Integer.valueOf(this.mKeySize), this.mSpec, this.mCertificateSubject, this.mCertificateSerialNumber, this.mCertificateNotBefore, this.mCertificateNotAfter, this.mKeyValidityStart, this.mKeyValidityForOriginationEnd, this.mKeyValidityForConsumptionEnd, Integer.valueOf(this.mPurposes), this.mDigests, this.mEncryptionPaddings, this.mSignaturePaddings, this.mBlockModes, Boolean.valueOf(this.mRandomizedEncryptionRequired), Boolean.valueOf(this.mUserAuthenticationRequired), Integer.valueOf(this.mUserAuthenticationValidityDurationSeconds));
        }

        @Override // com.tencent.soter.core.keystore.KeyGenParameterSpecCompatBuilder
        public KeyGenParameterSpecCompatBuilder setAlgorithmParameterSpec(AlgorithmParameterSpec algorithmParameterSpec) {
            if (algorithmParameterSpec != null) {
                this.mSpec = algorithmParameterSpec;
                return this;
            }
            throw new NullPointerException("spec == null");
        }

        @Override // com.tencent.soter.core.keystore.KeyGenParameterSpecCompatBuilder
        public KeyGenParameterSpecCompatBuilder setBlockModes(String... strArr) {
            this.mBlockModes = KeyGenParameterSpecCompatBuilder.cloneIfNotEmpty(strArr);
            return this;
        }

        @Override // com.tencent.soter.core.keystore.KeyGenParameterSpecCompatBuilder
        public KeyGenParameterSpecCompatBuilder setCertificateNotAfter(Date date) {
            if (date != null) {
                this.mCertificateNotAfter = KeyGenParameterSpecCompatBuilder.cloneIfNotNull(date);
                return this;
            }
            throw new NullPointerException("date == null");
        }

        @Override // com.tencent.soter.core.keystore.KeyGenParameterSpecCompatBuilder
        public KeyGenParameterSpecCompatBuilder setCertificateNotBefore(Date date) {
            if (date != null) {
                this.mCertificateNotBefore = KeyGenParameterSpecCompatBuilder.cloneIfNotNull(date);
                return this;
            }
            throw new NullPointerException("date == null");
        }

        @Override // com.tencent.soter.core.keystore.KeyGenParameterSpecCompatBuilder
        public KeyGenParameterSpecCompatBuilder setCertificateSerialNumber(BigInteger bigInteger) {
            if (bigInteger != null) {
                this.mCertificateSerialNumber = bigInteger;
                return this;
            }
            throw new NullPointerException("serialNumber == null");
        }

        @Override // com.tencent.soter.core.keystore.KeyGenParameterSpecCompatBuilder
        public KeyGenParameterSpecCompatBuilder setCertificateSubject(X500Principal x500Principal) {
            if (x500Principal != null) {
                this.mCertificateSubject = x500Principal;
                return this;
            }
            throw new NullPointerException("subject == null");
        }

        @Override // com.tencent.soter.core.keystore.KeyGenParameterSpecCompatBuilder
        public KeyGenParameterSpecCompatBuilder setDigests(String... strArr) {
            this.mDigests = KeyGenParameterSpecCompatBuilder.cloneIfNotEmpty(strArr);
            return this;
        }

        @Override // com.tencent.soter.core.keystore.KeyGenParameterSpecCompatBuilder
        public KeyGenParameterSpecCompatBuilder setEncryptionPaddings(String... strArr) {
            this.mEncryptionPaddings = KeyGenParameterSpecCompatBuilder.cloneIfNotEmpty(strArr);
            return this;
        }

        @Override // com.tencent.soter.core.keystore.KeyGenParameterSpecCompatBuilder
        public KeyGenParameterSpecCompatBuilder setKeySize(int i4) {
            if (i4 >= 0) {
                this.mKeySize = i4;
                return this;
            }
            throw new IllegalArgumentException("keySize < 0");
        }

        @Override // com.tencent.soter.core.keystore.KeyGenParameterSpecCompatBuilder
        public KeyGenParameterSpecCompatBuilder setKeyValidityEnd(Date date) {
            setKeyValidityForOriginationEnd(date);
            setKeyValidityForConsumptionEnd(date);
            return this;
        }

        public KeyGenParameterSpecCompatBuilder setKeyValidityForConsumptionEnd(Date date) {
            this.mKeyValidityForConsumptionEnd = KeyGenParameterSpecCompatBuilder.cloneIfNotNull(date);
            return this;
        }

        public KeyGenParameterSpecCompatBuilder setKeyValidityForOriginationEnd(Date date) {
            this.mKeyValidityForOriginationEnd = KeyGenParameterSpecCompatBuilder.cloneIfNotNull(date);
            return this;
        }

        @Override // com.tencent.soter.core.keystore.KeyGenParameterSpecCompatBuilder
        public KeyGenParameterSpecCompatBuilder setKeyValidityStart(Date date) {
            this.mKeyValidityStart = KeyGenParameterSpecCompatBuilder.cloneIfNotNull(date);
            return this;
        }

        @Override // com.tencent.soter.core.keystore.KeyGenParameterSpecCompatBuilder
        public KeyGenParameterSpecCompatBuilder setRandomizedEncryptionRequired(boolean z3) {
            this.mRandomizedEncryptionRequired = z3;
            return this;
        }

        @Override // com.tencent.soter.core.keystore.KeyGenParameterSpecCompatBuilder
        public KeyGenParameterSpecCompatBuilder setSignaturePaddings(String... strArr) {
            this.mSignaturePaddings = KeyGenParameterSpecCompatBuilder.cloneIfNotEmpty(strArr);
            return this;
        }

        @Override // com.tencent.soter.core.keystore.KeyGenParameterSpecCompatBuilder
        public KeyGenParameterSpecCompatBuilder setUserAuthenticationRequired(boolean z3) {
            this.mUserAuthenticationRequired = z3;
            return this;
        }

        @Override // com.tencent.soter.core.keystore.KeyGenParameterSpecCompatBuilder
        public KeyGenParameterSpecCompatBuilder setUserAuthenticationValidityDurationSeconds(int i4) {
            if (i4 >= -1) {
                this.mUserAuthenticationValidityDurationSeconds = i4;
                return this;
            }
            throw new IllegalArgumentException("seconds must be -1 or larger");
        }
    }

    public KeyGenParameterSpecCompatBuilder(String str, int i4) {
    }

    public static String[] cloneIfNotEmpty(String[] strArr) {
        return (strArr == null || strArr.length <= 0) ? strArr : (String[]) strArr.clone();
    }

    static Date cloneIfNotNull(Date date) {
        if (date != null) {
            return (Date) date.clone();
        }
        return null;
    }

    public static KeyGenParameterSpecCompatBuilder newInstance(String str, int i4) {
        if (SoterCore.isNativeSupportSoter()) {
            if (Build.VERSION.SDK_INT >= 23) {
                return new NormalKeyGenParameterSpecCompatBuilder(str, i4);
            }
            return new ReflectKeyGenParameterSpecCompatBuilder(str, i4);
        }
        SLogger.e(TAG, "soter: not support soter. return dummy", new Object[0]);
        return new DummyKeyGenParameterSpecCompatBuilder(str, i4);
    }

    public abstract AlgorithmParameterSpec build() throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException;

    public abstract KeyGenParameterSpecCompatBuilder setAlgorithmParameterSpec(AlgorithmParameterSpec algorithmParameterSpec);

    public abstract KeyGenParameterSpecCompatBuilder setBlockModes(String... strArr);

    public abstract KeyGenParameterSpecCompatBuilder setCertificateNotAfter(Date date);

    public abstract KeyGenParameterSpecCompatBuilder setCertificateNotBefore(Date date);

    public abstract KeyGenParameterSpecCompatBuilder setCertificateSerialNumber(BigInteger bigInteger);

    public abstract KeyGenParameterSpecCompatBuilder setCertificateSubject(X500Principal x500Principal);

    public abstract KeyGenParameterSpecCompatBuilder setDigests(String... strArr);

    public abstract KeyGenParameterSpecCompatBuilder setEncryptionPaddings(String... strArr);

    public abstract KeyGenParameterSpecCompatBuilder setKeySize(int i4);

    public abstract KeyGenParameterSpecCompatBuilder setKeyValidityEnd(Date date);

    public abstract KeyGenParameterSpecCompatBuilder setKeyValidityStart(Date date);

    public abstract KeyGenParameterSpecCompatBuilder setRandomizedEncryptionRequired(boolean z3);

    public abstract KeyGenParameterSpecCompatBuilder setSignaturePaddings(String... strArr);

    public abstract KeyGenParameterSpecCompatBuilder setUserAuthenticationRequired(boolean z3);

    public abstract KeyGenParameterSpecCompatBuilder setUserAuthenticationValidityDurationSeconds(int i4);

    public static byte[] cloneIfNotEmpty(byte[] bArr) {
        return (bArr == null || bArr.length <= 0) ? bArr : (byte[]) bArr.clone();
    }
}
