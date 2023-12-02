package com.google.firebase.messaging;

import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.exifinterface.media.ExifInterface;
import com.google.android.gms.common.internal.Objects;
import java.util.regex.Pattern;

/* loaded from: classes5.dex */
final class TopicOperation {

    /* renamed from: d  reason: collision with root package name */
    private static final Pattern f31735d = Pattern.compile("[a-zA-Z0-9-_.~%]{1,900}");

    /* renamed from: a  reason: collision with root package name */
    private final String f31736a;

    /* renamed from: b  reason: collision with root package name */
    private final String f31737b;

    /* renamed from: c  reason: collision with root package name */
    private final String f31738c;

    private TopicOperation(String str, String str2) {
        this.f31736a = d(str2, str);
        this.f31737b = str;
        this.f31738c = str + "!" + str2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Nullable
    public static TopicOperation a(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        String[] split = str.split("!", -1);
        if (split.length != 2) {
            return null;
        }
        return new TopicOperation(split[0], split[1]);
    }

    @NonNull
    private static String d(String str, String str2) {
        if (str != null && str.startsWith("/topics/")) {
            Log.w(Constants.TAG, String.format("Format /topics/topic-name is deprecated. Only 'topic-name' should be used in %s.", str2));
            str = str.substring(8);
        }
        if (str != null && f31735d.matcher(str).matches()) {
            return str;
        }
        throw new IllegalArgumentException(String.format("Invalid topic name: %s does not match the allowed format %s.", str, "[a-zA-Z0-9-_.~%]{1,900}"));
    }

    public static TopicOperation f(@NonNull String str) {
        return new TopicOperation(ExifInterface.LATITUDE_SOUTH, str);
    }

    public static TopicOperation g(@NonNull String str) {
        return new TopicOperation("U", str);
    }

    public String b() {
        return this.f31737b;
    }

    public String c() {
        return this.f31736a;
    }

    public String e() {
        return this.f31738c;
    }

    public boolean equals(@Nullable Object obj) {
        if (!(obj instanceof TopicOperation)) {
            return false;
        }
        TopicOperation topicOperation = (TopicOperation) obj;
        if (!this.f31736a.equals(topicOperation.f31736a) || !this.f31737b.equals(topicOperation.f31737b)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        return Objects.hashCode(this.f31737b, this.f31736a);
    }
}
