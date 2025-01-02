# 1. 機能要件
## 1.1. 本の登録と管理
- 登録: ユーザーはタイトル、著者、ISBN、出版日を入力して本を登録する。
- 編集: 登録済みの本の情報を編集可能にする。
- 削除: 本をデータベースから削除する。
## 1.2. 読書ステータスの管理
- 読書ステータスを以下の3つから選択:
    - 未読
    - 読書中
    - 読了
- 読書開始日と終了日を追跡。
- ステータスの更新履歴を保持。
## 1.3. 本の検索
- タイトルや著者名で本を検索可能。
- ステータス（未読、読書中、読了）で絞り込み可能。
## 1.4. 統計情報の表示
- 登録された本の総数、未読本数、読了本数を表示。
- 月ごとの読了冊数をグラフ化（CLIの場合、テキストベースの簡易グラフを提供）。
## 1.5. データの永続化
- データはローカルストレージ（例: SQLiteまたはJSONファイル）に保存。
- アプリ終了後もデータを保持。
# 2. 非機能要件
## 2.1. CLIインターフェイス
- シンプルで直感的な操作を提供。
- メニュー形式で操作を選択可能（例: 数字やコマンドによる選択）。
## 2.2. 拡張性
- 将来的にGUIやREST API対応に拡張できるコードベースを目指す。
- データベースや外部API（例: Google Books API）の統合を考慮した設計。
## 2.3. パフォーマンス
- 数百冊程度の本を管理しても動作が遅くならない。
- 検索や統計表示を効率的に実行。
# 3. ユーザーストーリー
## 3.1. 本の登録
- ユーザー: 最近購入した本を管理したい。
- アクション: タイトル、著者、ISBN、出版日を入力して登録。
- 結果: 本がデータベースに追加され、未読リストに表示される。

## 3.2. 読書ステータスの更新
- ユーザー: 読書を開始したのでステータスを「読書中」に更新したい。
- アクション: 読書開始日を入力してステータスを更新。
- 結果: 本の状態が更新され、読書中リストに表示される。

## 3.3. 統計情報の確認
- ユーザー: 今月はどれくらい本を読んだか知りたい。
- アクション: 統計情報を表示するコマンドを入力。
- 結果: 今月読了した本の数やリストが表示される。

# 4. 技術スタック
- プログラミング言語: Java
- データベース: SQLite（シンプルでCLIアプリに適合）
- ライブラリ:
- Gson または Jackson（データのJSON形式保存に使用する場合）
- JUnit（テスト用）
- 構成ツール: Maven または Gradle
# 5. コマンド例
メインメニュー
```bash
1. 本を登録する
2. 本を検索する
3. 読書ステータスを更新する
4. 統計情報を表示する
5. 終了
```
本の登録コマンド例
```bash
> 1
タイトル: Effective Java
著者: Joshua Bloch
ISBN: 9780134685991
出版日 (YYYY-MM-DD): 2018-01-06
本を登録しました。
```
読書ステータス更新コマンド例
```bash
> 3
検索: Effective Java
ステータスを選択してください:
1. 未読
2. 読書中
3. 読了
> 2
読書開始日 (YYYY-MM-DD): 2024-12-29
ステータスを更新しました。
```