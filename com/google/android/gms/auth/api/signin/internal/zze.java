package com.google.android.gms.auth.api.signin.internal;

import androidx.annotation.Nullable;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.PendingResults;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.StatusPendingResult;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.logging.Logger;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

/* compiled from: com.google.android.gms:play-services-auth@@19.0.0 */
/* loaded from: classes4.dex */
public final class zze implements Runnable {

    /* renamed from: c  reason: collision with root package name */
    private static final Logger f19864c = new Logger("RevokeAccessOperation", new String[0]);

    /* renamed from: a  reason: collision with root package name */
    private final String f19865a;

    /* renamed from: b  reason: collision with root package name */
    private final StatusPendingResult f19866b = new StatusPendingResult((GoogleApiClient) null);

    private zze(String str) {
        this.f19865a = Preconditions.checkNotEmpty(str);
    }

    public static PendingResult<Status> zzi(@Nullable String str) {
        if (str == null) {
            return PendingResults.immediateFailedResult(new Status(4), null);
        }
        zze zzeVar = new zze(str);
        new Thread(zzeVar).start();
        return zzeVar.f19866b;
    }

    @Override // java.lang.Runnable
    public final void run() {
        String str;
        String str2;
        String str3;
        Status status = Status.RESULT_INTERNAL_ERROR;
        try {
            String valueOf = String.valueOf(this.f19865a);
            if (valueOf.length() != 0) {
                str3 = "https://accounts.google.com/o/oauth2/revoke?token=".concat(valueOf);
            } else {
                str3 = new String("https://accounts.google.com/o/oauth2/revoke?token=");
            }
            HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(str3).openConnection();
            httpURLConnection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
            int responseCode = httpURLConnection.getResponseCode();
            if (responseCode == 200) {
                status = Status.RESULT_SUCCESS;
            } else {
                f19864c.e("Unable to revoke access!", new Object[0]);
            }
            Logger logger = f19864c;
            StringBuilder sb = new StringBuilder(26);
            sb.append("Response Code: ");
            sb.append(responseCode);
            logger.d(sb.toString(), new Object[0]);
        } catch (IOException e4) {
            Logger logger2 = f19864c;
            String valueOf2 = String.valueOf(e4.toString());
            if (valueOf2.length() != 0) {
                str2 = "IOException when revoking access: ".concat(valueOf2);
            } else {
                str2 = new String("IOException when revoking access: ");
            }
            logger2.e(str2, new Object[0]);
        } catch (Exception e5) {
            Logger logger3 = f19864c;
            String valueOf3 = String.valueOf(e5.toString());
            if (valueOf3.length() != 0) {
                str = "Exception when revoking access: ".concat(valueOf3);
            } else {
                str = new String("Exception when revoking access: ");
            }
            logger3.e(str, new Object[0]);
        }
        this.f19866b.setResult(status);
    }
}
