package com.google.api.client.googleapis.testing;

import com.google.common.base.Splitter;
import com.google.common.collect.Lists;
import java.io.IOException;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import kotlin.text.Typography;
import net.bytebuddy.jar.asm.signature.SignatureVisitor;

/* loaded from: classes5.dex */
public final class TestUtils {
    private TestUtils() {
    }

    public static Map<String, String> parseQuery(String str) throws IOException {
        HashMap hashMap = new HashMap();
        for (String str2 : Splitter.on((char) Typography.amp).split(str)) {
            ArrayList newArrayList = Lists.newArrayList(Splitter.on((char) SignatureVisitor.INSTANCEOF).split(str2));
            if (newArrayList.size() == 2) {
                hashMap.put(URLDecoder.decode((String) newArrayList.get(0), "UTF-8"), URLDecoder.decode((String) newArrayList.get(1), "UTF-8"));
            } else {
                throw new IOException("Invalid Query String");
            }
        }
        return hashMap;
    }
}
