package com.google.firebase.firestore.core;

import com.google.firebase.firestore.core.DocumentViewChange;
import com.google.firebase.firestore.model.DocumentKey;
import com.google.firebase.firestore.util.Assert;
import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;

/* loaded from: classes5.dex */
public class DocumentViewChangeSet {

    /* renamed from: a  reason: collision with root package name */
    private final TreeMap<DocumentKey, DocumentViewChange> f30335a = new TreeMap<>();

    /* JADX INFO: Access modifiers changed from: package-private */
    public List<DocumentViewChange> a() {
        return new ArrayList(this.f30335a.values());
    }

    public void addChange(DocumentViewChange documentViewChange) {
        DocumentKey key = documentViewChange.getDocument().getKey();
        DocumentViewChange documentViewChange2 = this.f30335a.get(key);
        if (documentViewChange2 == null) {
            this.f30335a.put(key, documentViewChange);
            return;
        }
        DocumentViewChange.Type type = documentViewChange2.getType();
        DocumentViewChange.Type type2 = documentViewChange.getType();
        DocumentViewChange.Type type3 = DocumentViewChange.Type.ADDED;
        if (type2 != type3 && type == DocumentViewChange.Type.METADATA) {
            this.f30335a.put(key, documentViewChange);
        } else if (type2 == DocumentViewChange.Type.METADATA && type != DocumentViewChange.Type.REMOVED) {
            this.f30335a.put(key, DocumentViewChange.create(type, documentViewChange.getDocument()));
        } else {
            DocumentViewChange.Type type4 = DocumentViewChange.Type.MODIFIED;
            if (type2 == type4 && type == type4) {
                this.f30335a.put(key, DocumentViewChange.create(type4, documentViewChange.getDocument()));
            } else if (type2 == type4 && type == type3) {
                this.f30335a.put(key, DocumentViewChange.create(type3, documentViewChange.getDocument()));
            } else {
                DocumentViewChange.Type type5 = DocumentViewChange.Type.REMOVED;
                if (type2 == type5 && type == type3) {
                    this.f30335a.remove(key);
                } else if (type2 == type5 && type == type4) {
                    this.f30335a.put(key, DocumentViewChange.create(type5, documentViewChange2.getDocument()));
                } else if (type2 == type3 && type == type5) {
                    this.f30335a.put(key, DocumentViewChange.create(type4, documentViewChange.getDocument()));
                } else {
                    throw Assert.fail("Unsupported combination of changes %s after %s", type2, type);
                }
            }
        }
    }
}
