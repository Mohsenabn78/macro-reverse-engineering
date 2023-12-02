package com.twofortyfouram.spackle;

import android.app.Activity;
import android.app.Service;
import android.app.backup.BackupAgent;
import android.content.Context;
import androidx.annotation.NonNull;
import com.twofortyfouram.assertion.Assertions;
import net.jcip.annotations.ThreadSafe;

@ThreadSafe
/* loaded from: classes6.dex */
public final class ContextUtil {
    private ContextUtil() {
        throw new UnsupportedOperationException("This class is non-instantiable");
    }

    public static Context cleanContext(@NonNull Context context) {
        Assertions.assertNotNull(context, "context");
        if (context instanceof Activity) {
            new Exception();
        } else if (context instanceof Service) {
            new Exception();
        } else if (context instanceof BackupAgent) {
            new Exception();
        }
        String name = context.getClass().getName();
        if (!name.equals("android.test.IsolatedContext") && !name.equals("android.test.RenamingDelegatingContext")) {
            try {
                Context applicationContext = context.getApplicationContext();
                if (applicationContext == null) {
                    return context;
                }
                return applicationContext;
            } catch (UnsupportedOperationException unused) {
            }
        }
        return context;
    }
}
