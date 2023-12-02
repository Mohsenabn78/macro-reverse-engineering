package com.tencent.soter.core.model;

import android.util.Base64;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.StringWriter;
import java.security.cert.Certificate;
import java.security.cert.X509Certificate;
import org.json.JSONObject;

/* loaded from: classes6.dex */
public class CertUtil {
    public static final String JSON_KEY_COUNTER = "counter";
    public static final String JSON_KEY_CPU_ID = "cpu_id";
    public static final String JSON_KEY_UID = "uid";
    private static final String KEY_DESCRIPTION_OID = "1.3.6.1.4.1.11129.2.1.17";
    private static final int LINE_LENGTH = 64;
    private static final String LINE_SEPARATOR = "\n";
    protected static final String TAG = "Soter.CertUtil";

    public static void extractAttestationSequence(X509Certificate x509Certificate, SoterPubKeyModel soterPubKeyModel) throws Exception, IOException {
        byte[] extensionValue = x509Certificate.getExtensionValue(KEY_DESCRIPTION_OID);
        if (extensionValue != null && extensionValue.length != 0) {
            byte b4 = "{".getBytes()[0];
            byte b5 = "}".getBytes()[0];
            int i4 = 0;
            int i5 = 0;
            for (int i6 = 0; i6 < extensionValue.length; i6++) {
                byte b6 = extensionValue[i6];
                if (b6 == b4) {
                    i4 = i6;
                } else if (b6 == b5) {
                    i5 = i6;
                }
            }
            if (i4 > 0 && i4 < i5) {
                int i7 = (i5 - i4) + 1;
                if (extensionValue[i4 - 1] != i7) {
                    SLogger.w(TAG, "read extension lenght error", new Object[0]);
                }
                byte[] bArr = new byte[i7];
                System.arraycopy(extensionValue, i4, bArr, 0, i7);
                String str = new String(bArr);
                SLogger.i(TAG, "soter: challenge json in attestation certificate " + str, new Object[0]);
                JSONObject jSONObject = new JSONObject(str);
                soterPubKeyModel.setCpu_id(jSONObject.getString("cpu_id"));
                soterPubKeyModel.setUid(jSONObject.getInt("uid"));
                soterPubKeyModel.setCounter(jSONObject.getLong("counter"));
                return;
            }
            return;
        }
        throw new Exception("Couldn't find the keystore attestation extension data.");
    }

    public static String format(Certificate certificate) throws Exception {
        StringWriter stringWriter = new StringWriter();
        BufferedWriter bufferedWriter = new BufferedWriter(stringWriter);
        writePreEncapsulationBoundary(bufferedWriter, "CERTIFICATE");
        writeEncoded(bufferedWriter, Base64.encode(certificate.getEncoded(), 2));
        writePostEncapsulationBoundary(bufferedWriter, "CERTIFICATE");
        bufferedWriter.close();
        return stringWriter.toString();
    }

    private static void writeEncoded(BufferedWriter bufferedWriter, byte[] bArr) throws IOException {
        char[] cArr = new char[64];
        for (int i4 = 0; i4 < bArr.length; i4 += 64) {
            int i5 = 0;
            while (i5 != 64) {
                int i6 = i4 + i5;
                if (i6 >= bArr.length) {
                    break;
                }
                cArr[i5] = (char) bArr[i6];
                i5++;
            }
            bufferedWriter.write(cArr, 0, i5);
            bufferedWriter.write("\n");
        }
    }

    private static void writePostEncapsulationBoundary(BufferedWriter bufferedWriter, String str) throws IOException {
        bufferedWriter.write("-----END " + str + "-----");
        bufferedWriter.write("\n");
    }

    private static void writePreEncapsulationBoundary(BufferedWriter bufferedWriter, String str) throws IOException {
        bufferedWriter.write("-----BEGIN " + str + "-----");
        bufferedWriter.write("\n");
    }
}
