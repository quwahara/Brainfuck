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

```bash
$ git clone https://github.com/quwahara/Brainfuck
$ cd Brainfuck
$ gradle shadowJar
$ gradle run
```

## EclipseへのImport

### Eclipseメニューで
File -> Import...

### Select
Git -> Projects from Git

### Select Repository Source
Clone URI

### Source Git Repository
URI: https://github.com/quwahara/Brainfuck.git

### Branch Selection
(default)

### Local Destination
(default)

### Select a wizard to use for importintg projects
Import as general project

### Import Projects
(default)

### Wizardが終了したら
Project Explorerのルートノードで右クリックし、
Configure -> Covert to Gradle Project

## NetBeansへのImport

チーム -> Git -> クローン...

### リモート・リポジトリ
リポジトリURL: https://github.com/quwahara/Brainfuck.git

### リモート分岐
(default)

### 宛先ディレクトリ
(default)

### クローン完了
プロジェクトを開く

## IntelliJ IDEAへのImport

### IntelliJ IDEAメニューで
File -> New -> Projet from Version Control -> GitHub

### または、起動画面のWelcome to IntelliJ IDEAで
Check out from Version Control -> GitHub

### Clone Repository
Git Repository URL: https://github.com/quwahara/Brainfuck.git

### Checkout from Version Control
Yes

### Import Project from Gradle
お使いの環境合わせて指定して下さい


## ライセンス
MIT ライセンスで公開しています。 ライセンスの全文は下で参照できます。
https://raw.github.com/quwahara/Brainfuck/master/LICENSE
