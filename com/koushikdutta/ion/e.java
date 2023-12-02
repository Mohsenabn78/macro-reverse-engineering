package com.koushikdutta.ion;

import com.koushikdutta.async.DataEmitter;
import com.koushikdutta.async.DataSink;
import com.koushikdutta.async.Util;
import com.koushikdutta.async.callback.CompletedCallback;
import com.koushikdutta.async.future.Future;
import com.koushikdutta.async.future.SimpleFuture;
import com.koushikdutta.async.parser.AsyncParser;
import java.lang.reflect.Type;

/* compiled from: DataEmitterParser.java */
/* loaded from: classes6.dex */
class e implements AsyncParser<DataEmitter> {
    @Override // com.koushikdutta.async.parser.AsyncParser
    /* renamed from: a */
    public void write(DataSink dataSink, DataEmitter dataEmitter, CompletedCallback completedCallback) {
        Util.pump(dataEmitter, dataSink, completedCallback);
    }

    @Override // com.koushikdutta.async.parser.AsyncParser
    public Type getType() {
        return DataEmitter.class;
    }

    @Override // com.koushikdutta.async.parser.AsyncParser
    public Future<DataEmitter> parse(DataEmitter dataEmitter) {
        SimpleFuture simpleFuture = new SimpleFuture();
        simpleFuture.setComplete((SimpleFuture) dataEmitter);
        return simpleFuture;
    }
}
