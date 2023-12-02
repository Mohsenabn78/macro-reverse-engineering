package com.google.api.client.util.store;

import java.io.IOException;
import net.bytebuddy.jar.asm.signature.SignatureVisitor;

/* loaded from: classes5.dex */
public final class DataStoreUtils {
    private DataStoreUtils() {
    }

    public static String toString(DataStore<?> dataStore) {
        try {
            StringBuilder sb = new StringBuilder();
            sb.append('{');
            boolean z3 = true;
            for (String str : dataStore.keySet()) {
                if (z3) {
                    z3 = false;
                } else {
                    sb.append(", ");
                }
                sb.append(str);
                sb.append(SignatureVisitor.INSTANCEOF);
                sb.append(dataStore.get(str));
            }
            sb.append('}');
            return sb.toString();
        } catch (IOException e4) {
            throw new RuntimeException(e4);
        }
    }
}
