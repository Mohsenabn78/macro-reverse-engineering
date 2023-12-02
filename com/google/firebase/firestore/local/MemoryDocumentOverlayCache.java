package com.google.firebase.firestore.local;

import androidx.annotation.Nullable;
import com.google.firebase.firestore.model.DocumentKey;
import com.google.firebase.firestore.model.ResourcePath;
import com.google.firebase.firestore.model.mutation.Mutation;
import com.google.firebase.firestore.model.mutation.Overlay;
import com.google.firebase.firestore.util.Preconditions;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeMap;

/* loaded from: classes5.dex */
public class MemoryDocumentOverlayCache implements DocumentOverlayCache {

    /* renamed from: a  reason: collision with root package name */
    private final TreeMap<DocumentKey, Overlay> f30649a = new TreeMap<>();

    /* renamed from: b  reason: collision with root package name */
    private final Map<Integer, Set<DocumentKey>> f30650b = new HashMap();

    private void a(int i4, Mutation mutation) {
        Overlay overlay = this.f30649a.get(mutation.getKey());
        if (overlay != null) {
            this.f30650b.get(Integer.valueOf(overlay.getLargestBatchId())).remove(mutation.getKey());
        }
        this.f30649a.put(mutation.getKey(), Overlay.create(i4, mutation));
        if (this.f30650b.get(Integer.valueOf(i4)) == null) {
            this.f30650b.put(Integer.valueOf(i4), new HashSet());
        }
        this.f30650b.get(Integer.valueOf(i4)).add(mutation.getKey());
    }

    @Override // com.google.firebase.firestore.local.DocumentOverlayCache
    @Nullable
    public Overlay getOverlay(DocumentKey documentKey) {
        return this.f30649a.get(documentKey);
    }

    @Override // com.google.firebase.firestore.local.DocumentOverlayCache
    public Map<DocumentKey, Overlay> getOverlays(SortedSet<DocumentKey> sortedSet) {
        HashMap hashMap = new HashMap();
        for (DocumentKey documentKey : sortedSet) {
            Overlay overlay = this.f30649a.get(documentKey);
            if (overlay != null) {
                hashMap.put(documentKey, overlay);
            }
        }
        return hashMap;
    }

    @Override // com.google.firebase.firestore.local.DocumentOverlayCache
    public void removeOverlaysForBatchId(int i4) {
        if (this.f30650b.containsKey(Integer.valueOf(i4))) {
            this.f30650b.remove(Integer.valueOf(i4));
            for (DocumentKey documentKey : this.f30650b.get(Integer.valueOf(i4))) {
                this.f30649a.remove(documentKey);
            }
        }
    }

    @Override // com.google.firebase.firestore.local.DocumentOverlayCache
    public void saveOverlays(int i4, Map<DocumentKey, Mutation> map) {
        for (Map.Entry<DocumentKey, Mutation> entry : map.entrySet()) {
            a(i4, (Mutation) Preconditions.checkNotNull(entry.getValue(), "null value for key: %s", entry.getKey()));
        }
    }

    @Override // com.google.firebase.firestore.local.DocumentOverlayCache
    public Map<DocumentKey, Overlay> getOverlays(ResourcePath resourcePath, int i4) {
        HashMap hashMap = new HashMap();
        int length = resourcePath.length() + 1;
        for (Overlay overlay : this.f30649a.tailMap(DocumentKey.fromPath(resourcePath.append(""))).values()) {
            DocumentKey key = overlay.getKey();
            if (!resourcePath.isPrefixOf(key.getPath())) {
                break;
            } else if (key.getPath().length() == length && overlay.getLargestBatchId() > i4) {
                hashMap.put(overlay.getKey(), overlay);
            }
        }
        return hashMap;
    }

    @Override // com.google.firebase.firestore.local.DocumentOverlayCache
    public Map<DocumentKey, Overlay> getOverlays(String str, int i4, int i5) {
        TreeMap treeMap = new TreeMap();
        for (Overlay overlay : this.f30649a.values()) {
            if (overlay.getKey().getCollectionGroup().equals(str) && overlay.getLargestBatchId() > i4) {
                Map map = (Map) treeMap.get(Integer.valueOf(overlay.getLargestBatchId()));
                if (map == null) {
                    map = new HashMap();
                    treeMap.put(Integer.valueOf(overlay.getLargestBatchId()), map);
                }
                map.put(overlay.getKey(), overlay);
            }
        }
        HashMap hashMap = new HashMap();
        for (Map map2 : treeMap.values()) {
            hashMap.putAll(map2);
            if (hashMap.size() >= i5) {
                break;
            }
        }
        return hashMap;
    }
}
