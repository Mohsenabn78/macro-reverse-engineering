package com.google.common.hash;

import com.google.common.base.Preconditions;
import com.google.errorprone.annotations.Immutable;
import com.tencent.soter.core.keystore.KeyPropertiesCompact;
import java.security.Key;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.zip.Adler32;
import java.util.zip.CRC32;
import java.util.zip.Checksum;
import javax.annotation.CheckForNull;
import javax.crypto.spec.SecretKeySpec;

@ElementTypesAreNonnullByDefault
/* loaded from: classes5.dex */
public final class Hashing {

    /* renamed from: a  reason: collision with root package name */
    static final int f27845a = (int) System.currentTimeMillis();

    @Immutable
    /* loaded from: classes5.dex */
    enum ChecksumType implements ImmutableSupplier<Checksum> {
        CRC_32("Hashing.crc32()") { // from class: com.google.common.hash.Hashing.ChecksumType.1
            @Override // com.google.common.base.Supplier
            /* renamed from: b */
            public Checksum get() {
                return new CRC32();
            }
        },
        ADLER_32("Hashing.adler32()") { // from class: com.google.common.hash.Hashing.ChecksumType.2
            @Override // com.google.common.base.Supplier
            /* renamed from: b */
            public Checksum get() {
                return new Adler32();
            }
        };
        
        public final HashFunction hashFunction;

        ChecksumType(String str) {
            this.hashFunction = new ChecksumHashFunction(this, 32, str);
        }
    }

    /* loaded from: classes5.dex */
    private static final class ConcatenatedHashFunction extends AbstractCompositeHashFunction {
        @Override // com.google.common.hash.AbstractCompositeHashFunction
        HashCode b(Hasher[] hasherArr) {
            byte[] bArr = new byte[bits() / 8];
            int i4 = 0;
            for (Hasher hasher : hasherArr) {
                HashCode hash = hasher.hash();
                i4 += hash.writeBytesTo(bArr, i4, hash.bits() / 8);
            }
            return HashCode.c(bArr);
        }

        @Override // com.google.common.hash.HashFunction
        public int bits() {
            int i4 = 0;
            for (HashFunction hashFunction : this.f27809a) {
                i4 += hashFunction.bits();
            }
            return i4;
        }

        public boolean equals(@CheckForNull Object obj) {
            if (obj instanceof ConcatenatedHashFunction) {
                return Arrays.equals(this.f27809a, ((ConcatenatedHashFunction) obj).f27809a);
            }
            return false;
        }

        public int hashCode() {
            return Arrays.hashCode(this.f27809a);
        }

        private ConcatenatedHashFunction(HashFunction... hashFunctionArr) {
            super(hashFunctionArr);
            for (HashFunction hashFunction : hashFunctionArr) {
                Preconditions.checkArgument(hashFunction.bits() % 8 == 0, "the number of bits (%s) in hashFunction (%s) must be divisible by 8", hashFunction.bits(), (Object) hashFunction);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes5.dex */
    public static final class LinearCongruentialGenerator {

        /* renamed from: a  reason: collision with root package name */
        private long f27849a;

        public LinearCongruentialGenerator(long j4) {
            this.f27849a = j4;
        }

        public double a() {
            long j4 = (this.f27849a * 2862933555777941757L) + 1;
            this.f27849a = j4;
            return (((int) (j4 >>> 33)) + 1) / 2.147483648E9d;
        }
    }

    /* loaded from: classes5.dex */
    private static class Md5Holder {

        /* renamed from: a  reason: collision with root package name */
        static final HashFunction f27850a = new MessageDigestHashFunction(KeyPropertiesCompact.DIGEST_MD5, "Hashing.md5()");

        private Md5Holder() {
        }
    }

    /* loaded from: classes5.dex */
    private static class Sha1Holder {

        /* renamed from: a  reason: collision with root package name */
        static final HashFunction f27851a = new MessageDigestHashFunction(KeyPropertiesCompact.DIGEST_SHA1, "Hashing.sha1()");

        private Sha1Holder() {
        }
    }

    /* loaded from: classes5.dex */
    private static class Sha256Holder {

        /* renamed from: a  reason: collision with root package name */
        static final HashFunction f27852a = new MessageDigestHashFunction(KeyPropertiesCompact.DIGEST_SHA256, "Hashing.sha256()");

        private Sha256Holder() {
        }
    }

    /* loaded from: classes5.dex */
    private static class Sha384Holder {

        /* renamed from: a  reason: collision with root package name */
        static final HashFunction f27853a = new MessageDigestHashFunction(KeyPropertiesCompact.DIGEST_SHA384, "Hashing.sha384()");

        private Sha384Holder() {
        }
    }

    /* loaded from: classes5.dex */
    private static class Sha512Holder {

        /* renamed from: a  reason: collision with root package name */
        static final HashFunction f27854a = new MessageDigestHashFunction(KeyPropertiesCompact.DIGEST_SHA512, "Hashing.sha512()");

        private Sha512Holder() {
        }
    }

    private Hashing() {
    }

    static int a(int i4) {
        boolean z3;
        if (i4 > 0) {
            z3 = true;
        } else {
            z3 = false;
        }
        Preconditions.checkArgument(z3, "Number of bits must be positive");
        return (i4 + 31) & (-32);
    }

    public static HashFunction adler32() {
        return ChecksumType.ADLER_32.hashFunction;
    }

    private static String b(String str, Key key) {
        return "Hashing." + str + "(Key[algorithm=" + key.getAlgorithm() + ", format=" + key.getFormat() + "])";
    }

    public static HashCode combineOrdered(Iterable<HashCode> iterable) {
        boolean z3;
        Iterator<HashCode> it = iterable.iterator();
        Preconditions.checkArgument(it.hasNext(), "Must be at least 1 hash code to combine.");
        int bits = it.next().bits() / 8;
        byte[] bArr = new byte[bits];
        for (HashCode hashCode : iterable) {
            byte[] asBytes = hashCode.asBytes();
            if (asBytes.length == bits) {
                z3 = true;
            } else {
                z3 = false;
            }
            Preconditions.checkArgument(z3, "All hashcodes must have the same bit length.");
            for (int i4 = 0; i4 < asBytes.length; i4++) {
                bArr[i4] = (byte) ((bArr[i4] * 37) ^ asBytes[i4]);
            }
        }
        return HashCode.c(bArr);
    }

    public static HashCode combineUnordered(Iterable<HashCode> iterable) {
        boolean z3;
        Iterator<HashCode> it = iterable.iterator();
        Preconditions.checkArgument(it.hasNext(), "Must be at least 1 hash code to combine.");
        int bits = it.next().bits() / 8;
        byte[] bArr = new byte[bits];
        for (HashCode hashCode : iterable) {
            byte[] asBytes = hashCode.asBytes();
            if (asBytes.length == bits) {
                z3 = true;
            } else {
                z3 = false;
            }
            Preconditions.checkArgument(z3, "All hashcodes must have the same bit length.");
            for (int i4 = 0; i4 < asBytes.length; i4++) {
                bArr[i4] = (byte) (bArr[i4] + asBytes[i4]);
            }
        }
        return HashCode.c(bArr);
    }

    public static HashFunction concatenating(HashFunction hashFunction, HashFunction hashFunction2, HashFunction... hashFunctionArr) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(hashFunction);
        arrayList.add(hashFunction2);
        Collections.addAll(arrayList, hashFunctionArr);
        return new ConcatenatedHashFunction((HashFunction[]) arrayList.toArray(new HashFunction[0]));
    }

    public static int consistentHash(HashCode hashCode, int i4) {
        return consistentHash(hashCode.padToLong(), i4);
    }

    public static HashFunction crc32() {
        return ChecksumType.CRC_32.hashFunction;
    }

    public static HashFunction crc32c() {
        return Crc32cHashFunction.f27824a;
    }

    public static HashFunction farmHashFingerprint64() {
        return FarmHashFingerprint64.f27833a;
    }

    public static HashFunction fingerprint2011() {
        return Fingerprint2011.f27834a;
    }

    public static HashFunction goodFastHash(int i4) {
        int a4 = a(i4);
        if (a4 == 32) {
            return Murmur3_32HashFunction.f27883e;
        }
        if (a4 <= 128) {
            return Murmur3_128HashFunction.f27877b;
        }
        int i5 = (a4 + 127) / 128;
        HashFunction[] hashFunctionArr = new HashFunction[i5];
        hashFunctionArr[0] = Murmur3_128HashFunction.f27877b;
        int i6 = f27845a;
        for (int i7 = 1; i7 < i5; i7++) {
            i6 += 1500450271;
            hashFunctionArr[i7] = murmur3_128(i6);
        }
        return new ConcatenatedHashFunction(hashFunctionArr);
    }

    public static HashFunction hmacMd5(Key key) {
        return new MacHashFunction("HmacMD5", key, b("hmacMd5", key));
    }

    public static HashFunction hmacSha1(Key key) {
        return new MacHashFunction(KeyPropertiesCompact.KEY_ALGORITHM_HMAC_SHA1, key, b("hmacSha1", key));
    }

    public static HashFunction hmacSha256(Key key) {
        return new MacHashFunction(KeyPropertiesCompact.KEY_ALGORITHM_HMAC_SHA256, key, b("hmacSha256", key));
    }

    public static HashFunction hmacSha512(Key key) {
        return new MacHashFunction(KeyPropertiesCompact.KEY_ALGORITHM_HMAC_SHA512, key, b("hmacSha512", key));
    }

    @Deprecated
    public static HashFunction md5() {
        return Md5Holder.f27850a;
    }

    public static HashFunction murmur3_128(int i4) {
        return new Murmur3_128HashFunction(i4);
    }

    @Deprecated
    public static HashFunction murmur3_32(int i4) {
        return new Murmur3_32HashFunction(i4, false);
    }

    public static HashFunction murmur3_32_fixed(int i4) {
        return new Murmur3_32HashFunction(i4, true);
    }

    @Deprecated
    public static HashFunction sha1() {
        return Sha1Holder.f27851a;
    }

    public static HashFunction sha256() {
        return Sha256Holder.f27852a;
    }

    public static HashFunction sha384() {
        return Sha384Holder.f27853a;
    }

    public static HashFunction sha512() {
        return Sha512Holder.f27854a;
    }

    public static HashFunction sipHash24() {
        return SipHashFunction.f27889a;
    }

    public static int consistentHash(long j4, int i4) {
        int i5 = 0;
        Preconditions.checkArgument(i4 > 0, "buckets must be positive: %s", i4);
        LinearCongruentialGenerator linearCongruentialGenerator = new LinearCongruentialGenerator(j4);
        while (true) {
            int a4 = (int) ((i5 + 1) / linearCongruentialGenerator.a());
            if (a4 < 0 || a4 >= i4) {
                break;
            }
            i5 = a4;
        }
        return i5;
    }

    public static HashFunction hmacMd5(byte[] bArr) {
        return hmacMd5(new SecretKeySpec((byte[]) Preconditions.checkNotNull(bArr), "HmacMD5"));
    }

    public static HashFunction hmacSha1(byte[] bArr) {
        return hmacSha1(new SecretKeySpec((byte[]) Preconditions.checkNotNull(bArr), KeyPropertiesCompact.KEY_ALGORITHM_HMAC_SHA1));
    }

    public static HashFunction hmacSha256(byte[] bArr) {
        return hmacSha256(new SecretKeySpec((byte[]) Preconditions.checkNotNull(bArr), KeyPropertiesCompact.KEY_ALGORITHM_HMAC_SHA256));
    }

    public static HashFunction hmacSha512(byte[] bArr) {
        return hmacSha512(new SecretKeySpec((byte[]) Preconditions.checkNotNull(bArr), KeyPropertiesCompact.KEY_ALGORITHM_HMAC_SHA512));
    }

    public static HashFunction murmur3_128() {
        return Murmur3_128HashFunction.f27876a;
    }

    @Deprecated
    public static HashFunction murmur3_32() {
        return Murmur3_32HashFunction.f27881a;
    }

    public static HashFunction murmur3_32_fixed() {
        return Murmur3_32HashFunction.f27882b;
    }

    public static HashFunction sipHash24(long j4, long j5) {
        return new SipHashFunction(2, 4, j4, j5);
    }

    public static HashFunction concatenating(Iterable<HashFunction> iterable) {
        Preconditions.checkNotNull(iterable);
        ArrayList arrayList = new ArrayList();
        for (HashFunction hashFunction : iterable) {
            arrayList.add(hashFunction);
        }
        Preconditions.checkArgument(!arrayList.isEmpty(), "number of hash functions (%s) must be > 0", arrayList.size());
        return new ConcatenatedHashFunction((HashFunction[]) arrayList.toArray(new HashFunction[0]));
    }
}
