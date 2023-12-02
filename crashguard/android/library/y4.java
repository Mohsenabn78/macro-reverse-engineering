package crashguard.android.library;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;

/* loaded from: classes6.dex */
final class y4 {
    /* JADX INFO: Access modifiers changed from: package-private */
    public static String a(long j4) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'", Locale.ENGLISH);
        TimeZone timeZone = TimeZone.getTimeZone("UTC");
        Date date = new Date(j4);
        simpleDateFormat.setTimeZone(timeZone);
        return simpleDateFormat.format(date);
    }
}
