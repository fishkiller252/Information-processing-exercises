# トピック07

##簡易Databaseの作成(その1)

膨大な数のデータを検索したり，登録，削除を行うためには，データベース専用のソフトウエアやサービス（MySQL, PostgresQLなど）を利用することが多い．この演習では，データの管理用のクラスとして学んだArrayListを用いて，これらに類似した，きわめて簡単なデータベースを実現するプログラムを作成する．
作成するプログラムの概要

前回のCardクラスを拡張して，年齢を保存できるMCardというクラスを用意する．このインスタンス（一人分のメンバーカードの情報）を保存し，以下の操作が行えるDBというクラスを作成する．利用法のサンプルとしてDBMainというクラスを用意し，作成したDBクラスを実際に操作する．

    カード（MCardの新たなインスタンス）を追加，
    すべてのデータの取り出し（すべてのデータを返すだけで，元のデータはそのまま）
    男性・女性だけのデータの抽出（抽出後のデータを返すだけで，元のデータはそのまま）
    ある年齢未満のデータの削除（元のデータから対象のものを削除）

### 演習の進め方

    まずCardクラスを継承して，MCardクラスを作成する．
    MCardクラスの動作テストのため，MCardMainクラスを作成し，検証後，パッケージを提出（その１はここまで）
    ArrayListを用いた拡張for文についてのクイズに回答（その２で実施）
    MCardクラスを保存するArrayListを有し，上記の1-3のメソッドを実装したDBクラスを作成する
    DBクラスの動作テストのため，DBMain1クラスを作成し，検証後，パッケージを提出（その３で実施）
    DBクラスに，上記4のメソッドを実装．その後動作テストのためDBMain2クラスを作成して，検証後，パッケージを提出（その４で実施）

### 演習の手順
１．CardクラスのコピーとMCardクラスの作成

まずeasydbパッケージを作成する．

次にEclipse上のパッケージエクスプローラで，easycardパッケージの中のCardクラスをクリックし，メニューのEdit->Copyを選んでコピーする．その後easydbパッケージをクリックし，Edit->Pasteを選ぶ．easydbパッケージの中にCardクラスができていることを確認し，ダブルクリックで開いて，一番上の行がpackage easydbとなっていることを確認する．

続いて，MCardクラスを作成する．作成後，extendsを付けてCardクラスを継承することを忘れないように．(@authorも忘れずに）

MCardクラスには，以下のインスタンス変数，インスタンスメソッドを作成する．（前回の演習に近い）

    インスタンス変数として，int型のageを用意
    String型のname, String型のgender, int型のageを引数とするコンストラクタを用意して，それぞれをインスタンス変数に代入する初期化を行わせる．（継承元のコンストラクタを利用することを忘れずに）
    ageのゲッターとセッターを用意する
    String型を返すpublicなdispメソッドを用意し，name, gender, ageを１つの文字列にして返すようにする．例えば，name="Taro", gender="M"，age=20の場合には，以下の文字列を返すようにする．（コロンの後に半角空白があること，およびコンマを忘れないように注意）

Name: Taro, Gender: M, Age: 20

## ２．ＭＣａｒdクラスのテスト用クラスを作成

続いて，MCardクラスの動作テストのために，MCardMainというクラスを作成する．作成する際に，public static void main(String[] args)を付けるオプションを忘れないように．(@authorも忘れずに）

  MCardMainのmainメソッド内に，以下の処理を書く．

1.  名前(name)を"Taro", 性別(gender)を"M", 年齢(age)を20とした，MCardのインスタンスを一つ生成し，aという変数に代入する．
1.  aのdispメソッドで返される文字列をSystem.out.printlnで出力する．
1.  aのgetAgeメソッドで返される数字をSystem.out.printlnで出力する．
1.  aのgetGenderメソッドで返される文字列をSystem.out.printlnで出力する．
## 簡易データベース（その２）

次に進む前に，ArrayListと拡張for文について，次のクイズに回答してください（このクイズの内容は次の演習３に関係したものです）

### クイズ１．

あるプログラム（クラス）で，
```
ArrayList<String> a = new ArrayList<>();
```
と，Stringオブジェクトを保存するArrayListのインスタンスをaという名前で生成したとします．その後aを操作した結果，いくつかの要素（文字列（String型のオブジェクト））が追加されたものとします．

このとき，aの中の，すべての要素（文字列）をプリントする処理を，拡張for文で作成する場合，次のプログラム行の空白に当てはまる文字を入力してください（半角英数字で入力し，余計な空白は一切入れないように注意してください）．

```
for (String s:a ) {
    System.out.println (s);
}
```

### クイズ２．

あるプログラム（クラス）で，
```
Dclass d = new Dclass ();
```
と，Dclassと名付けたクラスのインスタンスをdという名前で生成したとします．その後dを操作した結果，dの内部には様々な情報が保存されたものとします．

Dclassには，内部の情報をString型のArrayListとして返す all() というメソッドが用意されているものとします．

そこで，dのall()メソッドを呼んだ結果のArrayListの中の，すべての要素（文字列）をプリントする処理を，拡張for文で作成する場合，次のプログラム行の空白に当てはまる文字を入力してください（半角英数字で入力し，余計な空白は一切入れないように注意してください）．

```
for (String i :d.all()){
  System.out.println(i);
}
```
## 簡易データベース（その３）

１．DBクラスの作成

easydbパッケージにDBという名前のクラスを作成する．このクラスでは継承は使っていないので注意．(@authorも忘れずに）

（重要）DBクラスの先頭（packageの後，public class DBの前）に

import java.util.ArrayList;

と，ArrayListが使えるようにimport文を追加．

DBクラスには，以下のインスタンス変数，インスタンスメソッドを作成する．

※重要※　for文には必ず拡張for文を使用すること．

1.  データを保存する格納場所として，MCardクラスのインスタンスを格納するArrayListを型とするdataというインスタンス変数を用意する．(具体的には，ArrayList<MCard> data;)
1.  初期化のため，引数のないコンストラクタ(具体的には，public DB() { ... }）で，dataを初期化する（具体的には，MCardクラスのインスタンス（中身はまだ入っていない）を生成し代入）．(具体的には，コンストラクタ中でdata=new ArrayList<>();)
1.  データの追加のため，void型の insert というインスタンスメソッドを用意し，MCardのオブジェクト（=インスタンス）を引数とし，dataにそれを追加する処理を記述する．
1.  保存されているデータをMCardを保存するArrayListのオブジェクト（インスタンス）を返す getAll というインスタンスメソッドを用意し，保存されているデータを返す．
（※注釈※　dataをそのまま返すと外部で変更されてしまう可能性があるので，実は危険だが，この演習では簡易的に通常通りdataをそのままreturnで返してもよいこととする．安全のためには，新しくArrayListのインスタンスを作成して，dataのすべての要素をここに追加して，新しいインスタンスを返すことが望ましいが，この演習ではそこまでしなくてもよい）．
1.  該当する性別のデータだけを返すために，selectGenderというインスタンスメソッドを用意する．
引数はString型のgenderとし，選択する性別を与える．結果は，その性別のMCardだけが入った新しいArrayListで返す．
作り方として，まず結果を入れる空のArrayListを用意し（newで空のを作っておく），その後dataの要素を見ながら(for文），条件（genderがdataのgenderに等しいかどうか．文字列の比較なので注意．文字列Aと文字列Bが一致しているかを比較するには，A.equals(B)であることを忘れなく）に合致（if文）した要素を，結果を入れるArrayListに追加（add）すればよい．作業用の変数の名前は任意のものでかまわない．（考え方）dataの要素を見るfor文は，たとえばfor(MCard i: data) { }のようになる．これによってiにMCardの一枚一枚が取得されるので，たとえばそのカードの性別を判断するif文は，if (i.getGender().equals(gender))という判断になる．i.getGender()がString型になるので，その比較のためにequalsメソッドを呼んでいる．

とりあえずここまで完成させたのち，DBMain1というクラスを作成し，下記のソースリストを転記（コピーペースト）し，@authorを書き換え，「※ここに...拡張for文」という部分を適切に書き直して実行し，以下のような結果が得られることを確認し，easydb3.jarとして提出すること．※jarファイルにエクスポートする際，メインクラスをDBMain1とすることに注意．

```java
package easydb;

/**
 *
 * @author b学生番号 氏名
 *
 */
public class DBMain1 {

    public static void main(String[] args) {
        // create new database
        DB db = new DB();

        // add some data
        db.insert(new MCard("Ms Atom", "F", 18));
        db.insert(new MCard("Mr Bean", "M", 61));
        db.insert(new MCard("Ms Cake", "F", 40));
        db.insert(new MCard("Mr Dean", "M", 19));
        db.insert(new MCard("Ms Even", "F", 19));
        db.insert(new MCard("Mr Feel", "M", 18));

        // current data entries
        System.out.println("Show all");

        for (※ここにdb.getAll()を使った拡張for文) {
            System.out.println (i.disp());
        }

        // choose male cards and show
        System.out.println("Show male:");

        for (※ここにdb.selectGender("M")を使った拡張for文) {
            System.out.println (i.disp());
        }
    }
}
```

## 簡易データベース（その４）

その４では，DBクラスに，条件に合致するデータを削除する機能を追加し完成させる．
### その４の演習の手順

作成したDBクラスに，以下のインスタンスメソッドを作成する．（for文には拡張for文を使用すること）

-  deleteAgeLessThan メソッド，返し値はMCardを格納するArrayList．引数はint型のageで，格納されているMCardの中で，ageが与えられた値より小さいものを削除する．たとえば，20歳未満のメンバーを削除する場合などに利用する．

作り方（selectGenderに近いが，違いも多いので注意）：

まず，削除されるべき要素を一時的に入れる空のArrayListを用意する（newで空のリストを作っておく），

その後dataの要素を見ながら(for文），条件（ageがdataのageより大きいかどうか）に合致（if文）した要素を，削除されるべき要素を入れるArrayListに追加（add）すればよい．

削除すべき情報がすべて集まったら，これをdataから一挙に削除させる．このためのArrayListのメソッドは，removeAllが適している．

ここまで完成させたのち，DBMain2というクラスを作成し，下記のソースリストを転記（コピーペースト）し，@authorを書き換え実行し，以下のような結果が得られることを確認し，easydb4.jarとして提出すること．exportする際，mainクラスをDBMain2とすることに注意．

```java
package easydb;

/**
 *
 * @author b学生番号 氏名
 *
 */
public class DBMain2 {

    public static void main(String[] args) {
        // create new database
        DB db = new DB();

        // add some data
        db.insert(new MCard("Ms Atom", "F", 18));
        db.insert(new MCard("Mr Bean", "M", 61));
        db.insert(new MCard("Ms Cake", "F", 40));
        db.insert(new MCard("Mr Dean", "M", 19));
        db.insert(new MCard("Ms Even", "F", 19));
        db.insert(new MCard("Mr Feel", "M", 18));

        // choose male cards and show
        System.out.println("Show male:");

        for (MCard i: db.selectGender("M")) {
            System.out.println (i.disp());
        }

        // delete under 20 and show
        System.out.println("Delete under 20:");

        for (MCard i: db.deleteAgeLessThan (20)) {
            System.out.println (i.disp());
        }

        // choose female cards and show
        System.out.println("Show female:");

        for (MCard i: db.selectGender("F")) {
            System.out.println (i.disp());
        }

        // current data entries
        System.out.println("Show all");

        for (MCard i: db.getAll ()) {
            System.out.println (i.disp());
        }
    }
}
```
