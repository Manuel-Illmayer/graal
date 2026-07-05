package org.graalvm.wasm.predefined.jsstring;

import com.oracle.truffle.api.frame.VirtualFrame;
import org.graalvm.wasm.WasmArguments;
import org.graalvm.wasm.WasmInstance;
import org.graalvm.wasm.WasmLanguage;
import org.graalvm.wasm.WasmModule;
import org.graalvm.wasm.array.WasmInt16Array;
import org.graalvm.wasm.predefined.WasmBuiltinRootNode;

public class FromCharCodeArrayNode extends WasmBuiltinRootNode {
    protected FromCharCodeArrayNode(WasmLanguage language, WasmModule module) {
        super(language, module);
    }

    @Override
    public String builtinNodeName() {
        return "fromCharCodeArray";
    }

    @Override
    public Object executeWithInstance(VirtualFrame frame, WasmInstance instance) {
        var args = WasmArguments.getArguments(frame.getArguments());
        var wasmarray = (WasmInt16Array) args[0];
        int start = ((Number)args[1]).intValue();
        int end = ((Number)args[2]).intValue();
        StringBuilder result = new StringBuilder();
        for(int i = start; i < end; i++) {
            result.append((char) wasmarray.get(i));
        }
        return result.toString();
    }
}
