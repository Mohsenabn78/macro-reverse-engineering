package com.pollfish.internal;

import android.util.Log;
import com.pollfish.internal.f4;
import com.pollfish.internal.l4;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* loaded from: classes6.dex */
public final class b0 implements i4 {
    @Override // com.pollfish.internal.i4
    public final void a(@NotNull f4.a aVar, @NotNull String str, @Nullable l4.a aVar2) {
        int ordinal = aVar.ordinal();
        if (ordinal != 0) {
            if (ordinal != 2) {
                if (ordinal != 3) {
                    if (ordinal == 4) {
                        Log.w("Pollfish", str);
                        return;
                    }
                    return;
                }
                Log.wtf("Pollfish", str);
                return;
            }
            Log.e("Pollfish", str);
            return;
        }
        Log.i("Pollfish", str);
    }
}
