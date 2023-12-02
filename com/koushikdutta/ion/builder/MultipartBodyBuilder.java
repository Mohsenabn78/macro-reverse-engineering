package com.koushikdutta.ion.builder;

import com.koushikdutta.async.http.body.Part;
import com.koushikdutta.ion.builder.MultipartBodyBuilder;
import java.io.File;
import java.util.List;
import java.util.Map;

/* loaded from: classes6.dex */
public interface MultipartBodyBuilder<M extends MultipartBodyBuilder> {
    M addMultipartParts(Iterable<Part> iterable);

    M addMultipartParts(Part... partArr);

    M setMultipartContentType(String str);

    M setMultipartFile(String str, File file);

    M setMultipartFile(String str, String str2, File file);

    M setMultipartParameter(String str, String str2);

    M setMultipartParameters(Map<String, List<String>> map);
}
