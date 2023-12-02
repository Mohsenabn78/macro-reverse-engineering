package com.google.android.gms.internal.ads;

import android.os.Build;
import androidx.annotation.VisibleForTesting;
import com.facebook.stetho.dumpapp.Framer;
import com.google.common.base.Ascii;
import com.tencent.soter.core.keystore.KeyPropertiesCompact;
import java.io.File;
import java.io.IOException;
import java.security.GeneralSecurityException;
import java.security.MessageDigest;
import java.security.cert.X509Certificate;
import java.util.Arrays;
import kotlin.io.encoding.Base64;
import okio.Utf8;
import org.objenesis.instantiator.util.ClassDefinitionUtils;

/* compiled from: com.google.android.gms:play-services-ads@@22.3.0 */
/* loaded from: classes4.dex */
public final class zzfiw {
    @VisibleForTesting
    protected static final byte[] zza = {Base64.padSymbol, 122, Ascii.DC2, 35, 1, -102, -93, -99, -98, -96, -29, 67, 106, ClassDefinitionUtils.OPS_invokespecial, -64, -119, 107, -5, 79, -74, 121, -12, -34, Framer.STDIN_REQUEST_FRAME_PREFIX, -25, -62, Utf8.REPLACEMENT_BYTE, Framer.STDERR_FRAME_PREFIX, 108, -113, -103, 74};
    @VisibleForTesting
    protected static final byte[] zzb = {-110, -13, -34, 70, -83, 43, 97, Ascii.NAK, -44, Ascii.DLE, -54, -125, -28, -57, -125, -127, -7, 17, 102, ClassDefinitionUtils.OPS_new, 116, -121, ClassDefinitionUtils.OPS_return, 43, -13, Framer.EXIT_FRAME_PREFIX, 58, 55, -29, -108, Framer.STDIN_REQUEST_FRAME_PREFIX, 83};
    private final byte[] zzc = zzb;
    private final byte[] zzd = zza;

    public final boolean zza(File file) throws GeneralSecurityException {
        try {
            X509Certificate[][] zza2 = zzakq.zza(file.getAbsolutePath());
            if (zza2.length == 1) {
                byte[] digest = MessageDigest.getInstance(KeyPropertiesCompact.DIGEST_SHA256).digest(zza2[0][0].getEncoded());
                if (Arrays.equals(this.zzd, digest)) {
                    return true;
                }
                if (!"user".equals(Build.TYPE) && Arrays.equals(this.zzc, digest)) {
                    return true;
                }
                return false;
            }
            throw new GeneralSecurityException("APK has more than one signature.");
        } catch (zzakn e4) {
            throw new GeneralSecurityException("Package is not signed", e4);
        } catch (IOException e5) {
            e = e5;
            throw new GeneralSecurityException("Failed to verify signatures", e);
        } catch (RuntimeException e6) {
            e = e6;
            throw new GeneralSecurityException("Failed to verify signatures", e);
        }
    }
}
