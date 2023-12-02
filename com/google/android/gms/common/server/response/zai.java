package com.google.android.gms.common.server.response;

import androidx.annotation.Nullable;
import com.google.android.gms.common.server.response.FastParser;
import java.io.BufferedReader;
import java.io.IOException;

/* compiled from: com.google.android.gms:play-services-base@@18.2.0 */
/* loaded from: classes4.dex */
interface zai {
    @Nullable
    Object a(FastParser fastParser, BufferedReader bufferedReader) throws FastParser.ParseException, IOException;
}
