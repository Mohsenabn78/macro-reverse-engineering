package com.pollfish.internal;

import java.util.Iterator;
import java.util.List;
import kotlin.Unit;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import kotlin.ranges.IntRange;
import kotlin.sequences.Sequence;
import kotlin.sequences.SequencesKt___SequencesKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: classes6.dex */
public final class q1 {

    /* loaded from: classes6.dex */
    public static final class a extends Lambda implements Function1<Integer, JSONObject> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ JSONArray f37161a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(JSONArray jSONArray) {
            super(1);
            this.f37161a = jSONArray;
        }

        @Override // kotlin.jvm.functions.Function1
        public final JSONObject invoke(Integer num) {
            return (JSONObject) this.f37161a.get(num.intValue());
        }
    }

    public static final void a(@NotNull JSONObject jSONObject, @Nullable List list) {
        if (list != null) {
            JSONArray jSONArray = new JSONArray();
            Iterator it = list.iterator();
            while (it.hasNext()) {
                jSONArray.put((String) it.next());
            }
            jSONObject.put("spoken_languages", jSONArray);
        }
    }

    @Nullable
    public static final Integer b(@NotNull String str, @NotNull JSONObject jSONObject) {
        if (jSONObject.has(str)) {
            return Integer.valueOf(jSONObject.getInt(str));
        }
        return null;
    }

    @Nullable
    public static final String c(@NotNull String str, @NotNull JSONObject jSONObject) {
        boolean z3;
        if (jSONObject.has(str)) {
            String string = jSONObject.getString(str);
            if (string.length() == 0) {
                z3 = true;
            } else {
                z3 = false;
            }
            if (!z3) {
                return string;
            }
        }
        return null;
    }

    @NotNull
    public static final Iterator<JSONObject> a(@NotNull JSONArray jSONArray) {
        IntRange until;
        Sequence asSequence;
        Sequence map;
        until = kotlin.ranges.h.until(0, jSONArray.length());
        asSequence = CollectionsKt___CollectionsKt.asSequence(until);
        map = SequencesKt___SequencesKt.map(asSequence, new a(jSONArray));
        return map.iterator();
    }

    @Nullable
    public static final Boolean a(@NotNull String str, @NotNull JSONObject jSONObject) {
        if (jSONObject.has(str)) {
            return Boolean.valueOf(jSONObject.getBoolean(str));
        }
        return null;
    }

    public static final <T> void a(@NotNull JSONObject jSONObject, @NotNull String str, @Nullable T t3) {
        if (t3 != null) {
            jSONObject.put(str, t3);
        }
    }

    @Nullable
    public static final void a(@NotNull JSONObject jSONObject, @Nullable JSONObject jSONObject2) {
        if (jSONObject2 != null) {
            Iterator<String> keys = jSONObject2.keys();
            while (keys.hasNext()) {
                String next = keys.next();
                jSONObject.put(next, jSONObject2.get(next));
            }
            Unit unit = Unit.INSTANCE;
        }
    }
}
