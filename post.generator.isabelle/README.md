PoST to Isabelle/HOL translator.

To launch translator use: ``java --add-opens java.base/java.lang=ALL-UNNAMED -jar post2isabelle.jar [key/value]``

| key    | value | meaning                   |
|--------|-------|---------------------------|
| -s 	 | path  | path to source .post file |
| -o 	 | path  | output destination        |
| -model | -     | extraction f post model   |