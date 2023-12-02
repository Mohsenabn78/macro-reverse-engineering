package com.jakewharton.threetenabp;

import android.content.Context;
import java.io.IOException;
import java.io.InputStream;
import org.threeten.bp.zone.TzdbZoneRulesProvider;
import org.threeten.bp.zone.ZoneRulesInitializer;
import org.threeten.bp.zone.ZoneRulesProvider;

/* compiled from: AssetsZoneRulesInitializer.java */
/* loaded from: classes6.dex */
final class a extends ZoneRulesInitializer {

    /* renamed from: c  reason: collision with root package name */
    private final Context f34449c;

    /* renamed from: d  reason: collision with root package name */
    private final String f34450d;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(Context context, String str) {
        this.f34449c = context;
        this.f34450d = str;
    }

    @Override // org.threeten.bp.zone.ZoneRulesInitializer
    protected void b() {
        InputStream inputStream = null;
        try {
            try {
                inputStream = this.f34449c.getAssets().open(this.f34450d);
                TzdbZoneRulesProvider tzdbZoneRulesProvider = new TzdbZoneRulesProvider(inputStream);
                if (inputStream != null) {
                    try {
                        inputStream.close();
                    } catch (IOException unused) {
                    }
                }
                ZoneRulesProvider.registerProvider(tzdbZoneRulesProvider);
            } catch (IOException e4) {
                throw new IllegalStateException(this.f34450d + " missing from assets", e4);
            }
        } catch (Throwable th) {
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException unused2) {
                }
            }
            throw th;
        }
    }
}
