package com.google.firebase.heartbeatinfo;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.OffsetDateTime;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes5.dex */
public class HeartBeatInfoStorage {

    /* renamed from: a  reason: collision with root package name */
    private final SharedPreferences f31432a;

    public HeartBeatInfoStorage(Context context, String str) {
        this.f31432a = context.getSharedPreferences("FirebaseHeartBeat" + str, 0);
    }

    private synchronized void a() {
        long j4 = this.f31432a.getLong("fire-count", 0L);
        String str = "";
        String str2 = null;
        for (Map.Entry<String, ?> entry : this.f31432a.getAll().entrySet()) {
            if (entry.getValue() instanceof Set) {
                for (String str3 : (Set) entry.getValue()) {
                    if (str2 == null || str2.compareTo(str3) > 0) {
                        str = entry.getKey();
                        str2 = str3;
                    }
                }
            }
        }
        HashSet hashSet = new HashSet(this.f31432a.getStringSet(str, new HashSet()));
        hashSet.remove(str2);
        this.f31432a.edit().putStringSet(str, hashSet).putLong("fire-count", j4 - 1).commit();
    }

    private synchronized String d(long j4) {
        Instant instant;
        ZoneOffset zoneOffset;
        OffsetDateTime atOffset;
        LocalDateTime localDateTime;
        DateTimeFormatter dateTimeFormatter;
        String format;
        if (Build.VERSION.SDK_INT >= 26) {
            instant = new Date(j4).toInstant();
            zoneOffset = ZoneOffset.UTC;
            atOffset = instant.atOffset(zoneOffset);
            localDateTime = atOffset.toLocalDateTime();
            dateTimeFormatter = DateTimeFormatter.ISO_LOCAL_DATE;
            format = localDateTime.format(dateTimeFormatter);
            return format;
        }
        return new SimpleDateFormat("yyyy-MM-dd", Locale.UK).format(new Date(j4));
    }

    private synchronized String e(String str) {
        for (Map.Entry<String, ?> entry : this.f31432a.getAll().entrySet()) {
            if (entry.getValue() instanceof Set) {
                for (String str2 : (Set) entry.getValue()) {
                    if (str.equals(str2)) {
                        return entry.getKey();
                    }
                }
                continue;
            }
        }
        return null;
    }

    private synchronized void h(String str) {
        String e4 = e(str);
        if (e4 == null) {
            return;
        }
        HashSet hashSet = new HashSet(this.f31432a.getStringSet(e4, new HashSet()));
        hashSet.remove(str);
        if (hashSet.isEmpty()) {
            this.f31432a.edit().remove(e4).commit();
        } else {
            this.f31432a.edit().putStringSet(e4, hashSet).commit();
        }
    }

    private synchronized void m(String str, String str2) {
        h(str2);
        HashSet hashSet = new HashSet(this.f31432a.getStringSet(str, new HashSet()));
        hashSet.add(str2);
        this.f31432a.edit().putStringSet(str, hashSet).commit();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public synchronized void b() {
        SharedPreferences.Editor edit = this.f31432a.edit();
        int i4 = 0;
        for (Map.Entry<String, ?> entry : this.f31432a.getAll().entrySet()) {
            if (entry.getValue() instanceof Set) {
                String d4 = d(System.currentTimeMillis());
                String key = entry.getKey();
                if (((Set) entry.getValue()).contains(d4)) {
                    HashSet hashSet = new HashSet();
                    hashSet.add(d4);
                    i4++;
                    edit.putStringSet(key, hashSet);
                } else {
                    edit.remove(key);
                }
            }
        }
        if (i4 == 0) {
            edit.remove("fire-count");
        } else {
            edit.putLong("fire-count", i4);
        }
        edit.commit();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public synchronized List<HeartBeatResult> c() {
        ArrayList arrayList;
        arrayList = new ArrayList();
        for (Map.Entry<String, ?> entry : this.f31432a.getAll().entrySet()) {
            if (entry.getValue() instanceof Set) {
                HashSet hashSet = new HashSet((Set) entry.getValue());
                hashSet.remove(d(System.currentTimeMillis()));
                if (!hashSet.isEmpty()) {
                    arrayList.add(HeartBeatResult.create(entry.getKey(), new ArrayList(hashSet)));
                }
            }
        }
        l(System.currentTimeMillis());
        return arrayList;
    }

    synchronized boolean f(long j4, long j5) {
        return d(j4).equals(d(j5));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public synchronized void g() {
        String d4 = d(System.currentTimeMillis());
        this.f31432a.edit().putString("last-used-date", d4).commit();
        h(d4);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public synchronized boolean i(long j4) {
        return j("fire-global", j4);
    }

    synchronized boolean j(String str, long j4) {
        if (this.f31432a.contains(str)) {
            if (!f(this.f31432a.getLong(str, -1L), j4)) {
                this.f31432a.edit().putLong(str, j4).commit();
                return true;
            }
            return false;
        }
        this.f31432a.edit().putLong(str, j4).commit();
        return true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public synchronized void k(long j4, String str) {
        String d4 = d(j4);
        if (this.f31432a.getString("last-used-date", "").equals(d4)) {
            String e4 = e(d4);
            if (e4 == null) {
                return;
            }
            if (e4.equals(str)) {
                return;
            }
            m(str, d4);
            return;
        }
        long j5 = this.f31432a.getLong("fire-count", 0L);
        if (j5 + 1 == 30) {
            a();
            j5 = this.f31432a.getLong("fire-count", 0L);
        }
        HashSet hashSet = new HashSet(this.f31432a.getStringSet(str, new HashSet()));
        hashSet.add(d4);
        this.f31432a.edit().putStringSet(str, hashSet).putLong("fire-count", j5 + 1).putString("last-used-date", d4).commit();
    }

    synchronized void l(long j4) {
        this.f31432a.edit().putLong("fire-global", j4).commit();
    }
}
