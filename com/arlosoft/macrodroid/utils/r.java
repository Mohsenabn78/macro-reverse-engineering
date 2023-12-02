package com.arlosoft.macrodroid.utils;

import android.content.res.XmlResourceParser;
import java.io.IOException;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: MimeTypeParser.java */
/* loaded from: classes3.dex */
public class r {

    /* renamed from: a  reason: collision with root package name */
    private XmlPullParser f16136a;

    /* renamed from: b  reason: collision with root package name */
    private MimeTypes f16137b;

    private void a() {
        this.f16137b.put(this.f16136a.getAttributeValue(null, "extension"), this.f16136a.getAttributeValue(null, "mimetype"));
    }

    private MimeTypes c() throws XmlPullParserException, IOException {
        this.f16137b = new MimeTypes();
        int eventType = this.f16136a.getEventType();
        while (eventType != 1) {
            String name = this.f16136a.getName();
            if (eventType == 2) {
                if (!name.equals("MimeTypes") && name.equals("type")) {
                    a();
                }
            } else if (eventType == 3) {
                name.equals("MimeTypes");
            }
            eventType = this.f16136a.next();
        }
        return this.f16137b;
    }

    public MimeTypes b(XmlResourceParser xmlResourceParser) throws XmlPullParserException, IOException {
        this.f16136a = xmlResourceParser;
        return c();
    }
}
