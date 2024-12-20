# TomTrek

## 概要

読書管理アプリ

## 目的

読書内容を記録する

## きっかけ

Java とデザインパターン、Spring フレームワークを用いた開発の練習

# TomTrek CLI 版 要件定義

## 概要

TomTrek は、個人の読書体験を記録し、管理するための CLI（コマンドラインインターフェース）アプリケーションです。この初期バージョンでは、シンプルな読書記録の機能を提供し、将来的に Web アプリケーションとして拡張する基盤を構築します。

---

## 基本機能

### 1. 本の登録

- ユーザーが読書記録を登録できるようにする。
- 必須項目：
  - 書籍名
  - 著者名
  - 読書開始日
  - 読書終了日
- 任意項目：
  - ジャンル
  - 簡単な感想
  - 評価（1–5 の数値）

### 2. 読書記録の閲覧

- 登録された読書記録を一覧表示する。
- フィルタリングやソート機能を提供：
  - フィルタリング：ジャンル、評価、期間
  - ソート：読書開始日、読書終了日、評価

### 3. 記録の編集

- 既存の読書記録を更新できるようにする。
  - 書籍名や感想、評価などを変更可能。

### 4. 記録の削除

- 読書記録を削除できるようにする。
  - 削除確認を求める。

### 5. データの保存

- データをローカルストレージに保存。
  - ファイル形式：JSON（後の拡張性を考慮）

---

## ユーザーインターフェース

CLI ベースの簡易な操作を提供。

### 1. コマンド構造

- メインメニュー
  - 1: 本を登録
  - 2: 読書記録を閲覧
  - 3: 記録を編集
  - 4: 記録を削除
  - 5: アプリを終了

### 2. 入力と出力例

#### 本の登録

```
1: 本を登録
書籍名を入力してください: コンビニ人間
著者名を入力してください: 村田沙耶香
読書開始日 (YYYY-MM-DD): 2024-01-01
読書終了日 (YYYY-MM-DD): 2024-01-05
ジャンル (任意): 小説
感想 (任意): 興味深い作品でした。
評価 (1-5): 4
本が登録されました！
```

#### 読書記録の閲覧

```
2: 読書記録を閲覧
-- あなたの読書記録 --
1. コンビニ人間 | 村田沙耶香 | 開始: 2024-01-01 | 終了: 2024-01-05 | 評価: 4
2. 図書館戦争 | 有川浩 | 開始: 2023-12-15 | 終了: 2023-12-20 | 評価: 5
```

#### 記録の編集

```
3: 記録を編集
編集したい記録の番号を選択してください: 1
1. コンビニ人間 | 村田沙耶香 | 開始: 2024-01-01 | 終了: 2024-01-05 | 評価: 4
新しい感想を入力してください (変更しない場合はEnter): 新しい気づきが多かった。
新しい評価を入力してください (変更しない場合はEnter): 5
記録が更新されました！
```

#### 記録の削除

```
4: 記録を削除
削除したい記録の番号を選択してください: 2
2. 図書館戦争 | 有川浩 | 開始: 2023-12-15 | 終了: 2023-12-20 | 評価: 5
本当に削除しますか？ (y/n): y
記録が削除されました。
```

---

## 技術要件

- プログラミング言語: Java
- 保存方法: MySQL に保存
- 実行環境: JDK 17 以上。

---

## 今後の拡張

- Web アプリケーション化 (Spring Framework を利用)
- 他ユーザーとの記録共有機能
- 推薦アルゴリズムの実装

---

以上の要件をもとに、最初のプロトタイプの設計と実装を進めます。
