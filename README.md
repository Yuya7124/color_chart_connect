## アプリケーション名
Color Chart Connect

### アプリケーション概要
出来上がった模型作品のカラーガイドを共有し合い、参考にしながら完成度の高い作品ができるきっかけができる。

### URL


### 利用方法
#### アプリケーションを作成した背景
展示会などの作品で、どんな塗料を使っているのかが知りたい時、使用している塗料が見つからない時がある。そのことから、カラーガイドを共有することで、塗装するときに役立ててほしいことからこのアプリケーションの開発をしようと考えた。

### 実装した機能についての画像やGIFおよびその説明
#### トップページ
![colorchartconnect_index](https://github.com/Yuya7124/color_chart_connect/assets/86750113/1d712ff3-2837-4447-90c0-c1f16ee3a2dd)
いままで投稿した作品を閲覧でき、作品名をクリックすると詳細画面に遷移する。

#### 新規登録画面
![colorchartconnect_new_1](https://github.com/Yuya7124/color_chart_connect/assets/86750113/bb363821-0935-4625-b64e-21c3b0c43992)
![colorchartconnect_new_2](https://github.com/Yuya7124/color_chart_connect/assets/86750113/eb07befa-8656-46f7-9e62-863654054312)
- 登録機能

作品名、カラーガイド（部位、塗料の色(ブランド名)、比率）、コメントを入力をする。また、写真投稿は1枚だけ選択できる。

#### 詳細画面
![colorchartconnect_detail](https://github.com/Yuya7124/color_chart_connect/assets/86750113/5f6cd02d-ea12-4a86-92de-f8923325ef22)
- 詳細画面

写真、カラーガイド、工夫点が閲覧できる。
- 削除機能

投稿した作品を削除ボタンで削除できる。

#### 編集画面
- 編集画面
  ![colorchartconnect_edit_1](https://github.com/Yuya7124/color_chart_connect/assets/86750113/bfe04ddc-87f5-4a8d-8ce0-8549ac70ac65)
  ![colorchartconnect_edit_2](https://github.com/Yuya7124/color_chart_connect/assets/86750113/7814a5b3-c857-4d5d-b108-73e7b8480435)
- 更新機能
- 

登録した作品名、カラーガイド（部位、塗料の色(ブランド名)、比率）、コメントの編集・修正ができる。しかし、写真投稿は変更できない。

#### 実装予定の機能
ユーザー登録およびログイン機能の実装、詳細画面からコメント機能を追加、カラーガイドの登録をより扱いやすくしたいと考えている。

#### 画面遷移図

### 開発環境
#### 使用した言語
- Java 17
- Spring Boot

### プロジェクトで使用したパッケージ
- Spring Data JPA
- Thymeleaf
- Spring Web
- MySQL
- Javax Persistence API
  
### 工夫したポイント

