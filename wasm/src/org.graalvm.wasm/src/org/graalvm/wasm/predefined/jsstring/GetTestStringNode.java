package org.graalvm.wasm.predefined.jsstring;

import com.oracle.truffle.api.frame.VirtualFrame;
import com.oracle.truffle.api.strings.TruffleString;
import org.graalvm.wasm.WasmArguments;
import org.graalvm.wasm.WasmInstance;
import org.graalvm.wasm.WasmLanguage;
import org.graalvm.wasm.WasmModule;
import org.graalvm.wasm.predefined.WasmBuiltinRootNode;

public class GetTestStringNode extends WasmBuiltinRootNode {
    protected GetTestStringNode(WasmLanguage language, WasmModule module) {
        super(language, module);
    }

    @Override
    public String builtinNodeName() {
        return "getTestString";
    }

    @Override
    public Object executeWithInstance(VirtualFrame frame, WasmInstance instance) {
        return TruffleString.fromJavaStringUncached("This is a test String!", TruffleString.Encoding.UTF_16);
    }
}
