package com.arlosoft.macrodroid.emailservice.sendgrid;

import android.content.Context;
import android.net.Uri;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.fasterxml.jackson.core.util.MinimalPrettyPrinter;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* loaded from: classes3.dex */
public class SendGridMail {

    /* renamed from: d  reason: collision with root package name */
    private String f11963d;

    /* renamed from: i  reason: collision with root package name */
    private String f11968i;

    /* renamed from: j  reason: collision with root package name */
    private int f11969j;

    /* renamed from: a  reason: collision with root package name */
    private final Map<String, String> f11960a = new HashMap();

    /* renamed from: b  reason: collision with root package name */
    private final Map<String, String> f11961b = new HashMap();

    /* renamed from: c  reason: collision with root package name */
    private final Map<String, String> f11962c = new HashMap();

    /* renamed from: e  reason: collision with root package name */
    private final Map<String, String> f11964e = new HashMap();

    /* renamed from: f  reason: collision with root package name */
    private final Map<String, String> f11965f = new HashMap();

    /* renamed from: g  reason: collision with root package name */
    private final Map<String, String> f11966g = new HashMap();

    /* renamed from: h  reason: collision with root package name */
    private final Map<String, Map<String, Boolean>> f11967h = new HashMap();

    /* renamed from: k  reason: collision with root package name */
    private List<d> f11970k = new ArrayList();

    /* loaded from: classes3.dex */
    class a extends HashMap<String, Boolean> {
        final /* synthetic */ Boolean val$enabled;

        a(Boolean bool) {
            this.val$enabled = bool;
            put("enable", bool);
        }
    }

    /* loaded from: classes3.dex */
    class b extends HashMap<String, Boolean> {
        final /* synthetic */ Boolean val$enabled;

        b(Boolean bool) {
            this.val$enabled = bool;
            put("enable", bool);
        }
    }

    /* loaded from: classes3.dex */
    class c extends HashMap<String, Boolean> {
        final /* synthetic */ Boolean val$enabled;

        c(Boolean bool) {
            this.val$enabled = bool;
            put("enable", bool);
        }
    }

    /* loaded from: classes3.dex */
    static class d {

        /* renamed from: a  reason: collision with root package name */
        private final String f11971a;

        /* renamed from: b  reason: collision with root package name */
        private final String f11972b;

        d(File file) throws IOException {
            this.f11971a = com.arlosoft.macrodroid.emailservice.sendgrid.b.a(file);
            this.f11972b = file.getName();
        }

        static boolean d(File file) {
            if (file != null && file.canRead() && file.exists() && file.isFile()) {
                return true;
            }
            return false;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public String b() {
            return this.f11971a;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public String c() {
            return this.f11972b;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public List<String> a() {
        ArrayList arrayList = new ArrayList();
        for (d dVar : this.f11970k) {
            arrayList.add(dVar.f11972b);
        }
        return arrayList;
    }

    public void addAttachment(@NonNull File file) throws IOException {
        if (this.f11970k.size() < 10 && d.d(file)) {
            this.f11970k.add(new d(file));
        }
    }

    public void addRecipient(@NonNull String str, @Nullable String str2) {
        if (this.f11960a.size() >= 1000) {
            return;
        }
        if (str2 == null) {
            str2 = "";
        }
        this.f11960a.put(str, str2);
    }

    public void addRecipientBlindCarbonCopy(@NonNull String str, @Nullable String str2) {
        if (this.f11962c.size() >= 1000) {
            return;
        }
        if (str2 == null) {
            str2 = "";
        }
        this.f11962c.put(str, str2);
    }

    public void addRecipientCarbonCopy(@NonNull String str, @Nullable String str2) {
        if (this.f11961b.size() >= 1000) {
            return;
        }
        if (str2 == null) {
            str2 = "";
        }
        this.f11961b.put(str, str2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Map<String, String> b() {
        return this.f11964e;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public List<d> c() {
        return this.f11970k;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Map<String, String> d() {
        return this.f11965f;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Map<String, String> e() {
        return this.f11962c;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Map<String, String> f() {
        return this.f11961b;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Map<String, String> g() {
        return this.f11960a;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Map<String, String> h() {
        return this.f11966g;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int i() {
        return this.f11969j;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String j() {
        return this.f11963d;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String k() {
        return this.f11968i;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Map<String, Map<String, Boolean>> l() {
        return this.f11967h;
    }

    public void setClickTrackingEnabled(@NonNull Boolean bool) {
        this.f11967h.put("click_tracking", new a(bool));
    }

    public void setContent(@NonNull String str) {
        if (str.length() == 0) {
            str = MinimalPrettyPrinter.DEFAULT_ROOT_VALUE_SEPARATOR;
        }
        this.f11964e.put("text/plain", str);
    }

    public void setFrom(@NonNull String str, @Nullable String str2) {
        if (str2 == null) {
            str2 = "";
        }
        this.f11965f.put(str, str2);
    }

    public void setHtmlContent(@NonNull String str) {
        if (str.length() == 0) {
            str = MinimalPrettyPrinter.DEFAULT_ROOT_VALUE_SEPARATOR;
        }
        this.f11964e.put("text/html", str);
    }

    public void setOpenTrackingEnabled(@NonNull Boolean bool) {
        this.f11967h.put("open_tracking", new b(bool));
    }

    public void setReplyTo(@NonNull String str, @Nullable String str2) {
        if (str2 == null) {
            str2 = "";
        }
        this.f11966g.put(str, str2);
    }

    public void setSendAt(@NonNull int i4) {
        if (i4 > System.currentTimeMillis() / 1000) {
            this.f11969j = i4;
        }
    }

    public void setSubject(@NonNull String str) {
        if (str.length() == 0) {
            str = MinimalPrettyPrinter.DEFAULT_ROOT_VALUE_SEPARATOR;
        }
        this.f11963d = str;
    }

    public void setSubscriptionTrackingEnabled(@NonNull Boolean bool) {
        this.f11967h.put("subscription_tracking", new c(bool));
    }

    public void setTemplateId(@NonNull String str) {
        this.f11968i = str;
    }

    public void addAttachment(@NonNull Context context, @NonNull Uri uri) throws IOException {
        if (this.f11970k.size() >= 10) {
            return;
        }
        File b4 = com.arlosoft.macrodroid.emailservice.sendgrid.b.b(context, uri);
        if (d.d(b4)) {
            this.f11970k.add(new d(b4));
        }
    }
}
