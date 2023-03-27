# RareItemCollections
ショップ系プラグインと併用したり、単純にコレクション目的で追加するのがおすすめです。

# How to install
[Latest Release](https://github.com/iO2v74XnUfZvhDE/RareItemCollections/releases/latest "Latest release link")

# How to build
1. Clone this project  
2. gradle clean build  

# How to add items
If you would like to add your own items, follow these steps  
Step 1. open config.yml  
Step 2. add your items according to the following template  
Step 3. save the file.  

Use /reload if you have already started the server, it is resistant to reloads.  
There is no ceiling or other functionality. Simple probability.  

```yaml
# Name here do not use space, use underbar
Name:
  rate: 10000000 # The number represents the probability; if 10000 is specified, it means 1/10000.0
  block: ['diamond_ore', 'deepslate_diamond_ore'] # Target blocks
```

# Q&A
Q. SDK version?  
A. 17  
Q. What version?  
A. Native version is 1.19  