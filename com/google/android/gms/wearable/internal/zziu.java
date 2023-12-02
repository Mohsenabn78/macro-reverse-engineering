package com.google.android.gms.wearable.internal;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.util.Log;
import com.google.android.gms.common.GooglePlayServicesUtilLight;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.ShowFirstParty;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.common.wrappers.Wrappers;
import java.io.UnsupportedEncodingException;
import java.util.Arrays;

/* compiled from: com.google.android.gms:play-services-wearable@@18.0.0 */
/* loaded from: classes4.dex */
public final class zziu {

    /* renamed from: b  reason: collision with root package name */
    private static zziu f22843b;
    @VisibleForTesting

    /* renamed from: c  reason: collision with root package name */
    static final byte[] f22844c = b("0\u0082\u0005a0\u0082\u0003K\u0002\u0006\u0001D\u009e\u0091\u0096Ó0\u000b\u0006\t*\u0086H\u0086÷\r\u0001\u0001\u00050v1\u000b0\t\u0006\u0003U\u0004\u0006\u0013\u0002US1\u00130\u0011\u0006\u0003U\u0004\b\u0013\nCalifornia1\u00160\u0014\u0006\u0003U\u0004\u0007\u0013\rMountain View1\u00140\u0012\u0006\u0003U\u0004\n\u0013\u000bGoogle Inc.1\u00100\u000e\u0006\u0003U\u0004\u000b\u0013\u0007Android1\u00120\u0010\u0006\u0003U\u0004\u0003\u0013\tClockWork0\u001e\u0017\r140307220225Z\u0017\r380119031407Z0v1\u000b0\t\u0006\u0003U\u0004\u0006\u0013\u0002US1\u00130\u0011\u0006\u0003U\u0004\b\u0013\nCalifornia1\u00160\u0014\u0006\u0003U\u0004\u0007\u0013\rMountain View1\u00140\u0012\u0006\u0003U\u0004\n\u0013\u000bGoogle Inc.1\u00100\u000e\u0006\u0003U\u0004\u000b\u0013\u0007Android1\u00120\u0010\u0006\u0003U\u0004\u0003\u0013\tClockWork0\u0082\u0002\"0\r\u0006\t*\u0086H\u0086÷\r\u0001\u0001\u0001\u0005\u0000\u0003\u0082\u0002\u000f\u00000\u0082\u0002\n\u0002\u0082\u0002\u0001\u0000º<\u007f9\u000bþY\u008ab¼ü\u008b<\u0094Æ'Z\u0099\u0015íÜÝ7:Uj\u0099\u000bâýC÷\u009f\u0018³\u0001Ò@'ãr\u007f\tÎýâ\u009c|&°\u008a Þ6}\u001aßãN§\u008f®7ó\u0090õà&rzN\b(;ïvøöC¼\u0015'6 H?É·\u0091«R<ó½\u0086{f-*'L\u0000Ø\u0090ç\u009d\u0011è°&_í©uÜÈåB\u0099\u0089\u008e\u0090\u0013jbq\u008c.\u000b/9yQÛ$±W¡¿çÅkÎJ8\u000b%ú¹&c>¨\u0094\u00048à¶\u0094\u000b¹\u009e\u0089~.ú\u0005<2)\u009bÙao¤½\u0096\u0082!{7C\u001fÍØ\u0082í!§òðF\u007fà\u0095\u001c¼Z\u0098bãJ\u0015káZ\u0017ÿ\u0002\u0017\u0098dDÖ\u0013±\u001e×_\u0083\u0080\u0018î´ý\u0094ä\u008fZã\u001cä¯¤68¶\u0097,\u0085\\ÒÛ\n\u0001Ä2a(äÅ\u0019z¾¬ÌmÂè\u00ad¤B_\u000f\u0090Õ¥¥X$a¿x\u0011á.Î\u000eê\u0006\u0003?\u0096T9íàqÿÄl òß¾##:\u007fdÁÎ\t\u00ad¡ËÎkö¼¢.\u009b\u0098\u009cJÀÉj\u009dluOì\u0018qØ{\u0010\u0098Á Þ`¼}wÞ0ÕN¸GÎk\u0012|\u0019\u001e§\u0093o\nFÁFó6¹4êºZ_\u001c\u0003d·R\u0096UD2Pýcªå{ë«à&?\t\bM\u0019D\u0006\f:Ù»º\u007fyôÞ<+-7º³\rK¹\u0011ÜQià¯\u0095RôÓ\u008e=³òË\u0080\u001cR\u0002Rpa¿\u0001°BÐ~\u0089ä\u008f\u0011©ª 'ðD\u0095\u009eÚ(ÅÝØSW§\u001e9»\u0082Q³Wëor\u0018üÌ\u0017\u0018\u0081¦0gF1àU\u00949\u001azg\u009aòZ b\u0001Ö\"¸Ð\tÝ\u0011Õ\u0006¢\u0003\u000f$'®gØ\u001b47yy\u0002\u0003\u0001\u0000\u00010\u000b\u0006\t*\u0086H\u0086÷\r\u0001\u0001\u0005\u0003\u0082\u0002\u0001\u0000¤Ä\u0096\u00964aÈ\u00955¥±\nÍ\u0001$7j\u0089Ú'C\u009d¬0\u0003Hg\u000b +\u00adã?/º*\u0007d\u0003µ\u000bèqÊ*²\u009b¾½»Ä\u0006Û\t9AÉ\u008c\u0017j\u000eFÿ\u0090ÿ\u0000\u0016\u0016\u0004D\u0080nÜ\u0082á0þ\u0010\u0086\u001eã\u0005\u009d·~=\u009d©¢\u00ad4©Ò´Ú\u001b&ýZ[p\u001cÕlþédzä\u0014;\u0097¦|\u0002\u0080e±\u007f\u009e\u0014ò2¥ï\u0017ád¡I\u0017\u0092\u0096\u0094\u001c0½Z6«øóBÈã¯¼oICs\u0007}j\u009c\u0011×9\"\rZ×µ\u0019/\u009b\u001cþ\u0096\u008fJr±¸Tuàé\u0088¾hr\u0088fe±+ôîÃ\"VTõáò+\u008bëU\u008e¾fw\u008bÖ_\t\u0091-ù^\u0080\u009dþï\u000fÇêÊ]\u000e¾\u001dA\u0004\u001fç Ë2\u009b0~9.\u0013\u0097ñ 9Ti0\u0084\u008b\u007f\u0002\u0017@\u0089-öÇ rçß8ºÃ×\"5oæT\u007fj|W\u008aßgÉ=+5\u0088\u0093T5ðù¡\u0013Î-ìÍm¡\u009dÃKA\u0082ì®Ö ëR\u00850%Åà\u0004ì´Q¼EáHZÌ6\u007f¶I\u0092¯YLU\u001b\u000bÉ8ËÖ\u001aÕgY\u0090 ÷:eá©È¤\u0088Û¬\u0083\u001eë\u0091\u008f\f\u0092)\t^ÞA\u0005{<®êN\u0016Å¹EK\u0092âY\u008a\u0011´\u0094¢\u001f?z¿\u0083Àgô\u0018.\u0098A\u009b¤ä\u0093\u008a4\u0080ð\u0086/í¯WrJU3W\u008fÚ_³ÍüùT\u0080\u007fÿØÉQwçu\u0004¦B¾\\Û á\u0000eü|h\u0012\u009cí'³¨\u0004×¤ÍÙ\fÓìË\u0005¨È\u008a`\u009aÐV N´\u008a\u001e\u0005\u0095ý9\\\u001f§{³\u001d¥$4^\n½N\u0001µ\u0006\u0082OêºBÓ-Ô\u0092g>ÏÀ\u0017\u009d\u0086\u001d&éÍ\\FïÐ");
    @VisibleForTesting

    /* renamed from: d  reason: collision with root package name */
    static final byte[] f22845d = b("0\u0082\u0003¿0\u0082\u0002§ \u0003\u0002\u0001\u0002\u0002\t\u0000Ú\u0098ÃÙ\u0015sÓï0\r\u0006\t*\u0086H\u0086÷\r\u0001\u0001\u0005\u0005\u00000v1\u000b0\t\u0006\u0003U\u0004\u0006\u0013\u0002US1\u00130\u0011\u0006\u0003U\u0004\b\f\nCalifornia1\u00160\u0014\u0006\u0003U\u0004\u0007\f\rMountain View1\u00140\u0012\u0006\u0003U\u0004\n\f\u000bGoogle Inc.1\u00100\u000e\u0006\u0003U\u0004\u000b\f\u0007Android1\u00120\u0010\u0006\u0003U\u0004\u0003\f\tClockWork0\u001e\u0017\r140307220118Z\u0017\r410723220118Z0v1\u000b0\t\u0006\u0003U\u0004\u0006\u0013\u0002US1\u00130\u0011\u0006\u0003U\u0004\b\f\nCalifornia1\u00160\u0014\u0006\u0003U\u0004\u0007\f\rMountain View1\u00140\u0012\u0006\u0003U\u0004\n\f\u000bGoogle Inc.1\u00100\u000e\u0006\u0003U\u0004\u000b\f\u0007Android1\u00120\u0010\u0006\u0003U\u0004\u0003\f\tClockWork0\u0082\u0001\"0\r\u0006\t*\u0086H\u0086÷\r\u0001\u0001\u0001\u0005\u0000\u0003\u0082\u0001\u000f\u00000\u0082\u0001\n\u0002\u0082\u0001\u0001\u0000Ü\u001doK(í80\u0014²\u009c\u0082öÚÿÓ\u001dÞ{\u008c\u001ec\b@e\u000bX±e£j®¶,qS\u0095.\u0004E\t¯\u0082\u001f\u0094º\u009fO\u0018dÃ§µÖSÌ\u0000\u0015\u009d\u0000\u0010áåfú7ªÿ\u00186]®{J\u0085Ý±ó\u0083ÌGp¢>\u0095b\u0091þµrÁi1Z¯Nôê¥®\u0086\u001fÍÖçåêÔ1\u0013tFF\f|(û2,\u0092\u0095\\\\z¨\u0095wÃp?\u0097à\u0098·~¶ n¬krê \u00ad!\n°*\u001fÜüvbttA©?<ê\u008a\u0016ô\u008c\u0097\"Áã2A2~ÂÉ÷01.\u008d\u001bïî)\u000bE\u001a4\u0089,¬ï[\u0014rÖÙ~ùT(Ì\u008aÕï\u0004¸Äñõ\rÒBÕ]rXf\u0085P[^K\u001b\u001eY\u00ad\u008c\u001d\u0085/ \u0082H\u0015g;ÆæC)ìÄêÔÛ\u0084d©k1\u0083\u009f\u009fÛÉ\u0007\u0002\u0003\u0001\u0000\u0001£P0N0\u001d\u0006\u0003U\u001d\u000e\u0004\u0016\u0004\u0014\u0084\u0085G\u0010\u0084¤<³êø?«!b \u0095\u0000Î,z0\u001f\u0006\u0003U\u001d#\u0004\u00180\u0016\u0080\u0014\u0084\u0085G\u0010\u0084¤<³êø?«!b \u0095\u0000Î,z0\f\u0006\u0003U\u001d\u0013\u0004\u00050\u0003\u0001\u0001ÿ0\r\u0006\t*\u0086H\u0086÷\r\u0001\u0001\u0005\u0005\u0000\u0003\u0082\u0001\u0001\u0000\u00079b\u000b¢}*\u000fT\u0088C\u00ad\u001b`\u008e\u001c)Ù\u0001(\u0081êü?Ö(__bj\u0097>ðWæ\u0097î²¬\\¢æ\u0005Ê=3õ\u0090\u0099k\u008b\u00002ÄGæP\u000f%½\u0017Êù\u0095\u00039\u0083@ÈîlÜµ;íä±òHçÐ \u0099\u009e\u0081çÊê¥2ÏÚ\u0099þJ¥í@@ND÷[ïÒ\u007fÊÛ5¸²\u001b\u0094xF^\u0017\"òzû+\u000bn\u0015\u008eDÄ«\fOe{\u0019×}\u008fSÉÏ¹î-OE¶Tà\u0012¼\u008dé\u0081äÂâÃÓ\u009eQ\u0093\u0003Ø®M,ÁÈb\u008dxW®u?\u001d{\u0002£§\u0005xÆ\u0005ã\u0005\u001cl\u001d©I\u001aÎ\u0013»\u0088Ð}\u0081}Ô\u0094&Q\u0097\u0084®\u0096\u0095¤G5\r\u0089ë@^\u0090ò«óf®/ÊXÒö¿\u001d¿K\u001cH\u009eà \u0001TßÏ\u0002%\u0012õ¡Ç\"\u009es\u001dãðGÖø");

    /* renamed from: a  reason: collision with root package name */
    private final Context f22846a;

    @VisibleForTesting
    zziu(Context context) {
        this.f22846a = context.getApplicationContext();
    }

    @VisibleForTesting
    static final boolean a(PackageInfo packageInfo, boolean z3) {
        Signature[] signatureArr = packageInfo.signatures;
        if (signatureArr.length != 1) {
            Log.w("WearSignatureVerifier", "Package has more than one signature.");
            return false;
        }
        signatureArr[0].toByteArray();
        if (z3) {
            return c(packageInfo, f22844c, f22845d);
        }
        return c(packageInfo, f22844c);
    }

    private static byte[] b(String str) {
        try {
            return str.getBytes("ISO-8859-1");
        } catch (UnsupportedEncodingException e4) {
            throw new AssertionError(e4);
        }
    }

    private static final boolean c(PackageInfo packageInfo, byte[]... bArr) {
        Signature[] signatureArr = packageInfo.signatures;
        if (signatureArr == null) {
            return false;
        }
        if (signatureArr.length != 1) {
            Log.w("WearSignatureVerifier", "Package has more than one signature.");
            return false;
        }
        byte[] byteArray = signatureArr[0].toByteArray();
        for (byte[] bArr2 : bArr) {
            if (Arrays.equals(bArr2, byteArray)) {
                return true;
            }
        }
        return false;
    }

    public static zziu zza(Context context) {
        Preconditions.checkNotNull(context);
        synchronized (zziu.class) {
            if (f22843b == null) {
                f22843b = new zziu(context);
            }
        }
        return f22843b;
    }

    @ShowFirstParty
    public final boolean zzb(String str) {
        PackageInfo packageInfo;
        try {
            packageInfo = Wrappers.packageManager(this.f22846a).getPackageInfo("com.google.android.wearable.app.cn", 64);
        } catch (PackageManager.NameNotFoundException unused) {
            packageInfo = null;
        }
        if (packageInfo == null) {
            return false;
        }
        if (GooglePlayServicesUtilLight.honorsDebugCertificates(this.f22846a)) {
            return a(packageInfo, true);
        }
        boolean a4 = a(packageInfo, false);
        if (!a4 && a(packageInfo, true)) {
            Log.w("WearSignatureVerifier", "Test-keys aren't accepted on this build.");
            return false;
        }
        return a4;
    }
}
