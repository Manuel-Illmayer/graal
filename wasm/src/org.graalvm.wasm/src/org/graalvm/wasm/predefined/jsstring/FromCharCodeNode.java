package org.graalvm.wasm.predefined.jsstring;

import com.oracle.truffle.api.frame.VirtualFrame;
import com.oracle.truffle.api.strings.TruffleString;
import org.graalvm.wasm.WasmArguments;
import org.graalvm.wasm.WasmInstance;
import org.graalvm.wasm.WasmLanguage;
import org.graalvm.wasm.WasmModule;
import org.graalvm.wasm.predefined.WasmBuiltinRootNode;

public class FromCharCodeNode extends WasmBuiltinRootNode {
    protected FromCharCodeNode(WasmLanguage language, WasmModule module) {
        super(language, module);
    }

    @Override
    public String builtinNodeName() {
        return "fromCharCode";
    }

    @Override
    public Object executeWithInstance(VirtualFrame frame, WasmInstance instance) {
        // TODO: test edge cases, maybe use trufflestring also?
        var args = WasmArguments.getArguments(frame.getArguments());
        int code = ((Number)args[1]).intValue();
        return String.valueOf((char)code);
    }
}
