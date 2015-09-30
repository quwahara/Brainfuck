# Brainfuck

## 概要

Brainfuckという言語のJavaによる実装です。
https://ja.wikipedia.org/wiki/Brainfuck

池袋バイナリ勉強会の活動で作成したものを、低レイヤ教育研究会へ向けて、公開しました。

池袋バイナリ勉強会
http://connpass.com/series/182/

低レイヤ教育研究会
http://lowedu.connpass.com/

## 使い方

Gradleが使えることを前提にしています。
実行するにはコマンドライン引数に、Brainfuckのソースファイル名と、処理1回ごとの停止時間をミリ秒で指定します。

```bash
$ git clone https://github.com/quwahara/Brainfuck
$ cd Brainfuck/Brainfuck/
$ gradle shadowJar
$ java -jar build/libs/Brainfuck-1.0-all.jar helloworld.bf 500
```

## ライセンス

MIT ライセンスで公開しています。 ライセンスの全文は下で参照できます。

https://raw.github.com/quwahara/Brainfuck/master/LICENSE
