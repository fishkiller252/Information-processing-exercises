文字列sを，以下の記号のいずれかが1個以上続くものを区切り記号として分解するようなsplitメソッドの引数を答えてください．ただし，チェックの関係上，文字は下記の順番に並ぶようにしてください．（注意：説明の都合上，記号をわかりやすくするために""で囲ってあります．）

（復習）ブックで説明した通り，Javaの文字列に"\."などという表現を記入する場合には，"\"を正しく"\"文字と認識してもらうために"\\."とする必要があります．

（重要）ブックでは説明していませんでしたが，Javaの文字列の中に"（ダブルクオート）記号を含める場合には，
```
\"
```
のように先頭に\を付ける必要があります（この場合は\"だけです）．

### 区切りとして使う文字

```
"<"
">"
" " (半角スペース）
","
"/"
"?"
"["
"]"
"."
"""（ダブルクオート）
```
### splitメソッドの引数

```
s.split("[<> ,/\\?\\[\\]\\.\"]+");
```
（ヒント）

1.  いくつかの文字のいずれかにマッチさせる場合には，[ ] でそれらの文字全体を囲うパターンを作ります．
1.  ある文字（パターン）が1個以上連続することを示すには，その文字(またはパターン）の後ろに+を付けます
1.  コンマや?, [など正規表現で特別な意味を持つ文字を，マッチ対象の文字として表すには，その文字の先頭に\を付けます．
1.  特別な意味を持つ文字一覧は，ブックに記載されています．
1.  Javaの文字列に\のついた文字を含めるには，\\と指定します．たとえば"a."という正規表現をsplitの引数にしたい場合は，"a\\."となります．
1.  "などのようなJavaの文字列で特殊な意味を持つ文字を含める場合にも，先頭に\を付けます．
（ヒントその２）

正解の一部（先頭から"["に相当する部分まで）を示します．
```
[<> ,/\\?\\[
```
