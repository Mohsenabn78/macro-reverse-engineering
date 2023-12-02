package crashguard.android.library;

import android.os.Build;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

/* loaded from: classes6.dex */
final class r0 {

    /* renamed from: a  reason: collision with root package name */
    private final byte[] f39026a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public r0(byte[] bArr) {
        this.f39026a = bArr;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final byte[] a(String str) throws IOException {
        byte[] bArr;
        byte[] bArr2;
        ZipEntry nextEntry;
        if (Build.VERSION.SDK_INT > 23) {
            ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(this.f39026a);
            try {
                ZipInputStream zipInputStream = new ZipInputStream(byteArrayInputStream);
                do {
                    nextEntry = zipInputStream.getNextEntry();
                    if (nextEntry == null) {
                        zipInputStream.close();
                        byteArrayInputStream.close();
                        return null;
                    }
                } while (!nextEntry.getName().equals(str));
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                try {
                    byte[] bArr3 = new byte[8192];
                    while (true) {
                        int read = zipInputStream.read(bArr3);
                        if (read > 0) {
                            byteArrayOutputStream.write(bArr3, 0, read);
                        } else {
                            byte[] byteArray = byteArrayOutputStream.toByteArray();
                            byteArrayOutputStream.close();
                            zipInputStream.close();
                            byteArrayInputStream.close();
                            return byteArray;
                        }
                    }
                } catch (Throwable th) {
                    try {
                        byteArrayOutputStream.close();
                    } catch (Throwable th2) {
                        th.addSuppressed(th2);
                    }
                    throw th;
                }
            } catch (Throwable th3) {
                try {
                    byteArrayInputStream.close();
                } catch (Throwable th4) {
                    th3.addSuppressed(th4);
                }
                throw th3;
            }
        } else {
            byte[] bArr4 = this.f39026a;
            int length = bArr4.length;
            int length2 = bArr4.length - 1;
            while (true) {
                if (length2 > -1) {
                    byte[] bArr5 = this.f39026a;
                    if (bArr5[length2] == 80 && bArr5[length2 + 1] == 75 && bArr5[length2 + 2] == 1 && bArr5[length2 + 3] == 2) {
                        byte b4 = bArr5[length2 + 28];
                        StringBuilder sb = new StringBuilder();
                        for (int i4 = 0; i4 < b4; i4++) {
                            sb.append((char) this.f39026a[length2 + 46 + i4]);
                        }
                        if (sb.toString().equals(str)) {
                            int abs = Math.abs(length - length2);
                            bArr = new byte[abs];
                            for (int i5 = 0; i5 < abs; i5++) {
                                bArr[i5] = this.f39026a[length2];
                                length2++;
                            }
                        } else {
                            length = length2;
                        }
                    }
                    length2--;
                } else {
                    bArr = null;
                    break;
                }
            }
            if (bArr != null) {
                int i6 = 0;
                for (int i7 = 0; i7 < 4; i7++) {
                    i6 |= (bArr[i7 + 42] & 255) << (i7 * 8);
                }
                int i8 = 0;
                for (int i9 = 0; i9 < 4; i9++) {
                    i8 |= (bArr[i9 + 20] & 255) << (i9 * 8);
                }
                byte[] bArr6 = this.f39026a;
                int i10 = i6 + 26;
                int i11 = 0;
                short s3 = 0;
                while (i11 < 2) {
                    i11++;
                    s3 = (short) (s3 | ((bArr6[i11 + i10] & 255) << (i11 * 8)));
                }
                byte[] bArr7 = this.f39026a;
                int i12 = i6 + 28;
                short s4 = 0;
                for (int i13 = 0; i13 < 2; i13++) {
                    s4 = (short) (((bArr7[i13 + i12] & 255) << (i13 * 8)) | s4);
                }
                int i14 = i6 + 30 + s3 + s4 + i8;
                ByteArrayOutputStream byteArrayOutputStream2 = new ByteArrayOutputStream();
                while (i6 < i14) {
                    try {
                        byteArrayOutputStream2.write(this.f39026a[i6]);
                        i6++;
                    } finally {
                    }
                }
                byte[] byteArray2 = byteArrayOutputStream2.toByteArray();
                byteArrayOutputStream2.close();
                int length3 = this.f39026a.length - 1;
                while (true) {
                    if (length3 > -1) {
                        byte[] bArr8 = this.f39026a;
                        if (bArr8[length3] == 80 && bArr8[length3 + 1] == 75 && bArr8[length3 + 2] == 5 && bArr8[length3 + 3] == 6) {
                            int length4 = bArr8.length - length3;
                            bArr2 = new byte[length4];
                            int i15 = 0;
                            while (i15 < length4) {
                                bArr2[i15] = this.f39026a[length3];
                                i15++;
                                length3++;
                            }
                        } else {
                            length3--;
                        }
                    } else {
                        bArr2 = null;
                        break;
                    }
                }
                if (bArr2 != null) {
                    byte[] bArr9 = new byte[4];
                    for (int i16 = 0; i16 < 4; i16++) {
                        bArr9[i16] = (byte) (bArr9[i16] | ((0 >> (i16 * 8)) & 255));
                    }
                    bArr[42] = bArr9[0];
                    bArr[43] = bArr9[1];
                    bArr[44] = bArr9[2];
                    bArr[45] = bArr9[3];
                    int length5 = byteArray2.length;
                    int length6 = bArr.length;
                    byte[] bArr10 = new byte[2];
                    for (int i17 = 0; i17 < 2; i17++) {
                        bArr10[i17] = (byte) (((0 >> (i17 * 8)) & 255) | bArr10[i17]);
                    }
                    byte b5 = bArr10[0];
                    bArr2[4] = b5;
                    byte b6 = bArr10[1];
                    bArr2[5] = b6;
                    bArr2[6] = b5;
                    bArr2[7] = b6;
                    byte[] bArr11 = new byte[2];
                    for (int i18 = 0; i18 < 2; i18++) {
                        bArr11[i18] = (byte) (bArr11[i18] | ((1 >> (i18 * 8)) & 255));
                    }
                    byte b7 = bArr11[0];
                    bArr2[8] = b7;
                    byte b8 = bArr11[1];
                    bArr2[9] = b8;
                    bArr2[10] = b7;
                    bArr2[11] = b8;
                    byte[] bArr12 = new byte[4];
                    for (int i19 = 0; i19 < 4; i19++) {
                        bArr12[i19] = (byte) (bArr12[i19] | ((length6 >> (i19 * 8)) & 255));
                    }
                    bArr2[12] = bArr12[0];
                    bArr2[13] = bArr12[1];
                    bArr2[14] = bArr12[2];
                    bArr2[15] = bArr12[3];
                    byte[] bArr13 = new byte[4];
                    for (int i20 = 0; i20 < 4; i20++) {
                        bArr13[i20] = (byte) (bArr13[i20] | ((length5 >> (i20 * 8)) & 255));
                    }
                    bArr2[16] = bArr13[0];
                    bArr2[17] = bArr13[1];
                    bArr2[18] = bArr13[2];
                    bArr2[19] = bArr13[3];
                    byteArrayOutputStream2 = new ByteArrayOutputStream();
                    try {
                        byteArrayOutputStream2.write(byteArray2);
                        byteArrayOutputStream2.write(bArr);
                        byteArrayOutputStream2.write(bArr2);
                        ByteArrayInputStream byteArrayInputStream2 = new ByteArrayInputStream(byteArrayOutputStream2.toByteArray());
                        ZipInputStream zipInputStream2 = new ZipInputStream(byteArrayInputStream2);
                        try {
                            ByteArrayOutputStream byteArrayOutputStream3 = new ByteArrayOutputStream();
                            zipInputStream2.getNextEntry();
                            byte[] bArr14 = new byte[8192];
                            while (true) {
                                int read2 = zipInputStream2.read(bArr14);
                                if (read2 > 0) {
                                    byteArrayOutputStream3.write(bArr14, 0, read2);
                                } else {
                                    byte[] byteArray3 = byteArrayOutputStream3.toByteArray();
                                    byteArrayOutputStream3.close();
                                    zipInputStream2.close();
                                    byteArrayInputStream2.close();
                                    byteArrayOutputStream2.close();
                                    return byteArray3;
                                }
                            }
                        } catch (Throwable th5) {
                            try {
                                zipInputStream2.close();
                            } catch (Throwable th6) {
                                th5.addSuppressed(th6);
                            }
                            throw th5;
                        }
                    } finally {
                    }
                }
            }
            return null;
        }
    }
}
