package com.google.firebase.storage;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.google.firebase.sessions.settings.RemoteSettings;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes5.dex */
public final class ListResult {

    /* renamed from: a  reason: collision with root package name */
    private final List<StorageReference> f32217a;

    /* renamed from: b  reason: collision with root package name */
    private final List<StorageReference> f32218b;
    @Nullable

    /* renamed from: c  reason: collision with root package name */
    private final String f32219c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ListResult(List<StorageReference> list, List<StorageReference> list2, @Nullable String str) {
        this.f32217a = list;
        this.f32218b = list2;
        this.f32219c = str;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static ListResult a(FirebaseStorage firebaseStorage, JSONObject jSONObject) throws JSONException {
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        if (jSONObject.has("prefixes")) {
            JSONArray jSONArray = jSONObject.getJSONArray("prefixes");
            for (int i4 = 0; i4 < jSONArray.length(); i4++) {
                String string = jSONArray.getString(i4);
                if (string.endsWith(RemoteSettings.FORWARD_SLASH_STRING)) {
                    string = string.substring(0, string.length() - 1);
                }
                arrayList.add(firebaseStorage.getReference(string));
            }
        }
        if (jSONObject.has(FirebaseAnalytics.Param.ITEMS)) {
            JSONArray jSONArray2 = jSONObject.getJSONArray(FirebaseAnalytics.Param.ITEMS);
            for (int i5 = 0; i5 < jSONArray2.length(); i5++) {
                arrayList2.add(firebaseStorage.getReference(jSONArray2.getJSONObject(i5).getString("name")));
            }
        }
        return new ListResult(arrayList, arrayList2, jSONObject.optString("nextPageToken", null));
    }

    @NonNull
    public List<StorageReference> getItems() {
        return this.f32218b;
    }

    @Nullable
    public String getPageToken() {
        return this.f32219c;
    }

    @NonNull
    public List<StorageReference> getPrefixes() {
        return this.f32217a;
    }
}
