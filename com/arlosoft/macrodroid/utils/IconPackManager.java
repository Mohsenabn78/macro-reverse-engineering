package com.arlosoft.macrodroid.utils;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.content.res.Resources;
import android.content.res.XmlResourceParser;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlPullParserFactory;

/* loaded from: classes3.dex */
public class IconPackManager {

    /* renamed from: a  reason: collision with root package name */
    private Context f16044a;

    /* renamed from: b  reason: collision with root package name */
    private HashMap<String, IconPack> f16045b = null;

    /* loaded from: classes3.dex */
    public class IconPack {

        /* renamed from: g  reason: collision with root package name */
        private int f16052g;
        public String name;
        public String packageName;

        /* renamed from: a  reason: collision with root package name */
        private boolean f16046a = false;

        /* renamed from: b  reason: collision with root package name */
        private HashMap<String, String> f16047b = new HashMap<>();

        /* renamed from: c  reason: collision with root package name */
        private List<Bitmap> f16048c = new ArrayList();

        /* renamed from: d  reason: collision with root package name */
        private Bitmap f16049d = null;

        /* renamed from: e  reason: collision with root package name */
        private Bitmap f16050e = null;

        /* renamed from: f  reason: collision with root package name */
        private float f16051f = 1.0f;

        /* renamed from: h  reason: collision with root package name */
        Resources f16053h = null;

        public IconPack() {
        }

        private Bitmap a(String str) {
            int identifier = this.f16053h.getIdentifier(str, "drawable", this.packageName);
            if (identifier > 0) {
                Drawable drawable = this.f16053h.getDrawable(identifier);
                if (drawable instanceof BitmapDrawable) {
                    return ((BitmapDrawable) drawable).getBitmap();
                }
                return null;
            }
            return null;
        }

        public void load() {
            XmlResourceParser xmlResourceParser;
            Bitmap a4;
            try {
                try {
                    Resources resourcesForApplication = IconPackManager.this.f16044a.getPackageManager().getResourcesForApplication(this.packageName);
                    this.f16053h = resourcesForApplication;
                    int identifier = resourcesForApplication.getIdentifier("appfilter", "xml", this.packageName);
                    if (identifier > 0) {
                        xmlResourceParser = this.f16053h.getXml(identifier);
                    } else {
                        try {
                            InputStream open = this.f16053h.getAssets().open("appfilter.xml");
                            XmlPullParserFactory newInstance = XmlPullParserFactory.newInstance();
                            newInstance.setNamespaceAware(true);
                            XmlPullParser newPullParser = newInstance.newPullParser();
                            try {
                                newPullParser.setInput(open, "utf-8");
                            } catch (IOException unused) {
                            }
                            xmlResourceParser = newPullParser;
                        } catch (IOException unused2) {
                            xmlResourceParser = null;
                        }
                    }
                    if (xmlResourceParser != null) {
                        for (int eventType = xmlResourceParser.getEventType(); eventType != 1; eventType = xmlResourceParser.next()) {
                            if (eventType == 2) {
                                int i4 = 0;
                                if (xmlResourceParser.getName().equals("iconback")) {
                                    while (i4 < xmlResourceParser.getAttributeCount()) {
                                        if (xmlResourceParser.getAttributeName(i4).startsWith("img") && (a4 = a(xmlResourceParser.getAttributeValue(i4))) != null) {
                                            this.f16048c.add(a4);
                                        }
                                        i4++;
                                    }
                                } else if (xmlResourceParser.getName().equals("iconmask")) {
                                    if (xmlResourceParser.getAttributeCount() > 0 && xmlResourceParser.getAttributeName(0).equals("img1")) {
                                        this.f16049d = a(xmlResourceParser.getAttributeValue(0));
                                    }
                                } else if (xmlResourceParser.getName().equals("iconupon")) {
                                    if (xmlResourceParser.getAttributeCount() > 0 && xmlResourceParser.getAttributeName(0).equals("img1")) {
                                        this.f16050e = a(xmlResourceParser.getAttributeValue(0));
                                    }
                                } else if (xmlResourceParser.getName().equals("scale")) {
                                    if (xmlResourceParser.getAttributeCount() > 0 && xmlResourceParser.getAttributeName(0).equals("factor")) {
                                        try {
                                            this.f16051f = Float.valueOf(xmlResourceParser.getAttributeValue(0)).floatValue();
                                        } catch (Exception unused3) {
                                            this.f16051f = 1.0f;
                                        }
                                    }
                                } else if (xmlResourceParser.getName().equals("item")) {
                                    String str = null;
                                    String str2 = null;
                                    while (i4 < xmlResourceParser.getAttributeCount()) {
                                        if (xmlResourceParser.getAttributeName(i4).equals("component")) {
                                            str = xmlResourceParser.getAttributeValue(i4);
                                        } else if (xmlResourceParser.getAttributeName(i4).equals("drawable")) {
                                            str2 = xmlResourceParser.getAttributeValue(i4);
                                        }
                                        i4++;
                                    }
                                    if (!this.f16047b.containsKey(str)) {
                                        this.f16047b.put(str, str2);
                                        this.f16052g++;
                                    }
                                }
                            }
                        }
                    }
                    this.f16046a = true;
                } catch (IOException e4) {
                    e4.printStackTrace();
                }
            } catch (PackageManager.NameNotFoundException | XmlPullParserException unused4) {
            }
        }
    }

    public HashMap<String, IconPack> getAvailableIconPacks(boolean z3) {
        if (this.f16045b == null || z3) {
            this.f16045b = new HashMap<>();
            PackageManager packageManager = this.f16044a.getPackageManager();
            List<ResolveInfo> queryIntentActivities = packageManager.queryIntentActivities(new Intent("org.adw.launcher.THEMES"), 128);
            List<ResolveInfo> queryIntentActivities2 = packageManager.queryIntentActivities(new Intent("com.gau.go.launcherex.theme"), 128);
            ArrayList<ResolveInfo> arrayList = new ArrayList(queryIntentActivities);
            arrayList.addAll(queryIntentActivities2);
            for (ResolveInfo resolveInfo : arrayList) {
                IconPack iconPack = new IconPack();
                String str = resolveInfo.activityInfo.packageName;
                iconPack.packageName = str;
                try {
                    iconPack.name = this.f16044a.getPackageManager().getApplicationLabel(packageManager.getApplicationInfo(str, 128)).toString();
                    this.f16045b.put(iconPack.packageName, iconPack);
                } catch (PackageManager.NameNotFoundException e4) {
                    e4.printStackTrace();
                }
            }
        }
        return this.f16045b;
    }

    public void setContext(Context context) {
        this.f16044a = context;
    }
}
