# RareItemCollections
ショップ系プラグインと併用したり、単純にコレクション目的で追加するのがおすすめです。

# インストール
下のリンクから最新のリリースをダウンロードしてください。  
[Latest Release](https://github.com/iO2v74XnUfZvhDE/RareItemCollections/releases/latest "Latest release link")

# ビルド
1. このプロジェクトをクローンする  
2. gradle clean build  

# アイテムを追加する方法
下のテンプレートの通りに、config.ymlに追記してください。
```yaml
Name: # 名前。スペースの代わりにアンダーバーを使用してください。
  rate: 10000000 # 確率の値。10000を入れた場合は、1/10000の確率という意味になります。
  block: ['diamond_ore', 'deepslate_diamond_ore'] # Target blocks
```