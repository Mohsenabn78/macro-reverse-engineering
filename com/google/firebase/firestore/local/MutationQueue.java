package com.google.firebase.firestore.local;

import androidx.annotation.Nullable;
import com.google.firebase.Timestamp;
import com.google.firebase.firestore.model.DocumentKey;
import com.google.firebase.firestore.model.mutation.Mutation;
import com.google.firebase.firestore.model.mutation.MutationBatch;
import com.google.protobuf.ByteString;
import java.util.List;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes5.dex */
public interface MutationQueue {
    void a();

    List<MutationBatch> b(Iterable<DocumentKey> iterable);

    @Nullable
    MutationBatch c(int i4);

    @Nullable
    MutationBatch d(int i4);

    void e(MutationBatch mutationBatch, ByteString byteString);

    MutationBatch f(Timestamp timestamp, List<Mutation> list, List<Mutation> list2);

    int g();

    ByteString getLastStreamToken();

    void h(MutationBatch mutationBatch);

    void i(ByteString byteString);

    List<MutationBatch> j();

    void start();
}
