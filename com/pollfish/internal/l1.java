package com.pollfish.internal;

import android.content.Context;
import android.util.Log;
import com.google.android.gms.ads.identifier.AdvertisingIdClient;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GoogleApiAvailabilityLight;
import com.pollfish.internal.l4;
import java.io.IOException;
import java.lang.ref.WeakReference;
import java.util.UUID;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Regex;
import org.jetbrains.annotations.NotNull;

/* loaded from: classes6.dex */
public final class l1 implements a {
    @NotNull

    /* renamed from: a  reason: collision with root package name */
    public WeakReference<Context> f36995a;
    @NotNull

    /* renamed from: b  reason: collision with root package name */
    public String f36996b = UUID.randomUUID().toString();

    public l1(@NotNull Context context) {
        this.f36995a = new WeakReference<>(context);
    }

    public final void a(@NotNull Context context) {
        this.f36995a = new WeakReference<>(context);
        this.f36996b = UUID.randomUUID().toString();
    }

    @Override // com.pollfish.internal.a
    @NotNull
    public final l4<Pair<String, h0>> b() {
        l4<AdvertisingIdClient.Info> c4 = c();
        if (c4 instanceof l4.b) {
            l4.b bVar = (l4.b) c4;
            if (((AdvertisingIdClient.Info) bVar.a()).isLimitAdTrackingEnabled()) {
                return new l4.b(new Pair(this.f36996b, h0.SESSION));
            }
            String id = ((AdvertisingIdClient.Info) bVar.a()).getId();
            if (id != null) {
                if (!Intrinsics.areEqual(id, "00000000-0000-0000-0000-000000000000") && !new Regex("[0-]+").matches(id)) {
                    return new l4.b(new Pair(id, h0.ADVERTISING));
                }
                Log.w("Pollfish", "It seems that you have removed com.google.android.gms.permission.AD_ID permission from your AndroidManifest.xml file.\n                    <uses-permission android:name=\"com.google.android.gms.permission.AD_ID\"/>\n                    For more information, see Google's AdvertisingIdClient.Info documentation.\n                    https://developers.google.com/android/reference/com/google/android/gms/ads/identifier/AdvertisingIdClient.Info#public-string-getid");
                return new l4.b(new Pair(this.f36996b, h0.SESSION));
            }
            return l4.a.s.f37059c;
        }
        return (l4.a) c4;
    }

    public final l4<AdvertisingIdClient.Info> c() {
        l4<AdvertisingIdClient.Info> l4Var;
        l4<AdvertisingIdClient.Info> bVar;
        Context context = this.f36995a.get();
        if (context != null) {
            try {
                int isGooglePlayServicesAvailable = GoogleApiAvailabilityLight.getInstance().isGooglePlayServicesAvailable(context);
                if (isGooglePlayServicesAvailable == 0) {
                    l4Var = new l4.b<>(Unit.INSTANCE);
                } else {
                    ConnectionResult connectionResult = new ConnectionResult(isGooglePlayServicesAvailable);
                    l4Var = new l4.a.n(connectionResult.getErrorCode(), connectionResult.getErrorMessage());
                }
            } catch (Throwable unused) {
                l4Var = l4.a.m.f37044c;
            }
            if (!n4.b(l4Var)) {
                bVar = (l4.a) l4Var;
            } else {
                try {
                    bVar = new l4.b<>(AdvertisingIdClient.getAdvertisingIdInfo(context));
                } catch (IOException unused2) {
                    bVar = l4.a.p.f37055c;
                } catch (InterruptedException unused3) {
                    bVar = l4.a.p.f37055c;
                } catch (Exception e4) {
                    bVar = new l4.a.b(e4);
                }
            }
            if (bVar != null) {
                return bVar;
            }
        }
        return l4.a.t.f37060c;
    }

    @Override // com.pollfish.internal.a
    @NotNull
    public final l4<Boolean> a() {
        l4<AdvertisingIdClient.Info> c4 = c();
        if (c4 instanceof l4.b) {
            return new l4.b(Boolean.valueOf(((AdvertisingIdClient.Info) ((l4.b) c4).a()).isLimitAdTrackingEnabled()));
        }
        return (l4.a) c4;
    }
}
