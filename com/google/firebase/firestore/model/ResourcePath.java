package com.google.firebase.firestore.model;

import com.google.firebase.sessions.settings.RemoteSettings;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* loaded from: classes5.dex */
public final class ResourcePath extends BasePath<ResourcePath> {
    public static final ResourcePath EMPTY = new ResourcePath(Collections.emptyList());

    private ResourcePath(List<String> list) {
        super(list);
    }

    public static ResourcePath fromSegments(List<String> list) {
        if (list.isEmpty()) {
            return EMPTY;
        }
        return new ResourcePath(list);
    }

    public static ResourcePath fromString(String str) {
        if (!str.contains("//")) {
            String[] split = str.split(RemoteSettings.FORWARD_SLASH_STRING);
            ArrayList arrayList = new ArrayList(split.length);
            for (String str2 : split) {
                if (!str2.isEmpty()) {
                    arrayList.add(str2);
                }
            }
            return new ResourcePath(arrayList);
        }
        throw new IllegalArgumentException("Invalid path (" + str + "). Paths must not contain // in them.");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.firebase.firestore.model.BasePath
    /* renamed from: b */
    public ResourcePath a(List<String> list) {
        return new ResourcePath(list);
    }

    @Override // com.google.firebase.firestore.model.BasePath
    public String canonicalString() {
        StringBuilder sb = new StringBuilder();
        for (int i4 = 0; i4 < this.f30943a.size(); i4++) {
            if (i4 > 0) {
                sb.append(RemoteSettings.FORWARD_SLASH_STRING);
            }
            sb.append(this.f30943a.get(i4));
        }
        return sb.toString();
    }
}
