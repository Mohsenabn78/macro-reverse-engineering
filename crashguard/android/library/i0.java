package crashguard.android.library;

import android.content.Context;
import com.google.android.gms.ads.identifier.AdvertisingIdClient;
import java.lang.ref.WeakReference;
import java.util.LinkedList;
import javax.crypto.spec.SecretKeySpec;

/* loaded from: classes6.dex */
final class i0 {

    /* renamed from: a  reason: collision with root package name */
    private final WeakReference<Context> f38822a;

    /* renamed from: b  reason: collision with root package name */
    private final y0 f38823b;

    /* renamed from: c  reason: collision with root package name */
    private final m f38824c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i0(Context context) {
        this.f38822a = new WeakReference<>(context);
        this.f38823b = new y0(context);
        this.f38824c = t4.f(context).e();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final LinkedList a() {
        LinkedList linkedList = new LinkedList();
        try {
            SecretKeySpec e4 = new e1(this.f38822a.get()).e();
            if (e4 != null) {
                for (d0 d0Var : this.f38824c.a()) {
                    linkedList.add(new w(Long.parseLong(new String(k2.f(d0Var.b(), e4))), new String(k2.f(d0Var.a(), e4))));
                }
            }
        } catch (Throwable unused) {
        }
        return linkedList;
    }

    final void b(w wVar) {
        try {
            SecretKeySpec e4 = new e1(this.f38822a.get()).e();
            if (e4 != null) {
                this.f38824c.c(new d0(k2.h(wVar.a(), e4), k2.h(String.valueOf(wVar.c()), e4)));
            }
        } catch (Throwable unused) {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final String c() {
        Context context = this.f38822a.get();
        if (context == null) {
            return null;
        }
        long currentTimeMillis = System.currentTimeMillis();
        long Y = this.f38823b.Y();
        String D = this.f38823b.D();
        if (Y == 0 || Y <= currentTimeMillis) {
            try {
                String id = AdvertisingIdClient.getAdvertisingIdInfo(context).getId();
                if (id != null && !id.equals(D)) {
                    b(new w(currentTimeMillis, id));
                    this.f38823b.w(id);
                    D = id;
                }
            } catch (Throwable unused) {
            }
            this.f38823b.E(currentTimeMillis + 86400000);
        }
        return D;
    }
}
