package com.koushikdutta.async.parser;

import com.koushikdutta.async.DataEmitter;
import com.koushikdutta.async.DataSink;
import com.koushikdutta.async.callback.CompletedCallback;
import com.koushikdutta.async.future.Future;
import com.koushikdutta.async.future.TransformFuture;
import java.lang.reflect.Type;
import org.json.JSONArray;

/* loaded from: classes6.dex */
public class JSONArrayParser implements AsyncParser<JSONArray> {

    /* loaded from: classes6.dex */
    class a extends TransformFuture<JSONArray, String> {
        a() {
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.koushikdutta.async.future.TransformFuture
        /* renamed from: l */
        public void k(String str) throws Exception {
            setComplete((a) new JSONArray(str));
        }
    }

    @Override // com.koushikdutta.async.parser.AsyncParser
    public Type getType() {
        return JSONArray.class;
    }

    @Override // com.koushikdutta.async.parser.AsyncParser
    public Future<JSONArray> parse(DataEmitter dataEmitter) {
        return (Future) new StringParser().parse(dataEmitter).then(new a());
    }

    @Override // com.koushikdutta.async.parser.AsyncParser
    public void write(DataSink dataSink, JSONArray jSONArray, CompletedCallback completedCallback) {
        new StringParser().write(dataSink, jSONArray.toString(), completedCallback);
    }
}
