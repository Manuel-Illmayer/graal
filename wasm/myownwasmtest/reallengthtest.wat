(module
  (import "spectest" "print_i32" (func $print (param i32)))

  (import "js-string" "length" (func $length (param externref) (result i32)))

  (import "js-string" "getTestString" (func $getTestString (result externref)))

  (memory 1)
  ;; (memory (export "memory") 1)

;;   (data (i32.const 0) "Hello World!")
;;   (data (i32.const 32) "Second String")

  (func $_start

    ;; test length
    call $getTestString
    call $length
    call $print

  )

  (export "_start" (func $_start))
)