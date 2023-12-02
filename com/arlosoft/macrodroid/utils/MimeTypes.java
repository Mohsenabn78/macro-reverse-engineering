package com.arlosoft.macrodroid.utils;

import android.net.Uri;
import android.webkit.MimeTypeMap;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes3.dex */
public class MimeTypes {

    /* renamed from: a  reason: collision with root package name */
    private final Map<String, String> f16061a = new HashMap();

    public String getMimeType(String str) {
        String mimeTypeFromExtension;
        String extension = FileUtils.getExtension(str);
        if (extension.length() <= 0 || (mimeTypeFromExtension = MimeTypeMap.getSingleton().getMimeTypeFromExtension(extension.substring(1))) == null) {
            String str2 = this.f16061a.get(extension.toLowerCase());
            return str2 == null ? "*/*" : str2;
        }
        return mimeTypeFromExtension;
    }

    public void put(String str, String str2) {
        this.f16061a.put(str, str2.toLowerCase());
    }

    public String getMimeType(Uri uri) {
        return getMimeType(FileUtils.getFile(uri).getName());
    }
}
