package org.graalvm.wasm.predefined.jsstring;

import com.oracle.truffle.api.frame.VirtualFrame;
import com.oracle.truffle.api.strings.TruffleString;
import org.graalvm.wasm.WasmArguments;
import org.graalvm.wasm.WasmInstance;
import org.graalvm.wasm.WasmLanguage;
import org.graalvm.wasm.WasmModule;
import org.graalvm.wasm.predefined.WasmBuiltinRootNode;

public class CharCodeAtNode extends WasmBuiltinRootNode {
    protected CharCodeAtNode(WasmLanguage language, WasmModule module) {
        super(language, module);
    }

    @Override
    public String builtinNodeName() {
        return "charCodeAt";
    }

    @Override
    public Object executeWithInstance(VirtualFrame frame, WasmInstance instance) {
        var args = WasmArguments.getArguments(frame.getArguments());
        TruffleString s = TruffleString.fromJavaStringUncached((String) args[0], TruffleString.Encoding.UTF_16);
        int i = (int) args[1];
        if (i < 0 || i >= s.byteLength(TruffleString.Encoding.UTF_16)) {
            return null;
        }
        return s.readCharUTF16Uncached(i);
    }
}
