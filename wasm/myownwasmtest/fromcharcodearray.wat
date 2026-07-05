(module
  (type $u16_array (array (mut i16)))

  (import "js-string" "fromCharCodeArray"
    (func $fromCharCodeArray
      (param (ref null array) i32 i32)
      (result externref)))

;;   (func (export "array_to_string")
;;     (param $arr (ref null $u16_array))
;;     (param $start i32)
;;     (param $end i32)
;;     (result externref)
;;     local.get $arr
;;     local.get $start
;;     local.get $end
;;     call $fromCharCodeArray)

  (func $_start

    i32.const 72
    i32.const 101
    i32.const 108
    i32.const 108
    i32.const 111
    array.new_fixed $u16_array 5
    i32.const 0
    i32.const 5
    call $fromCharCodeArray
    drop
  )

  (export "_start" (func $_start))
)