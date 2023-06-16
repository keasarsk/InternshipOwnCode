# 介绍
这是kaesar记录在团子实习期间自己的一些代码的项目

下面是各个小工具代码的介绍:

- com.sk.Csv 处理 csv 文件

  - 背景: 压测csv 文件中每个单元格都是String json 数据
  - MergeCsv —— 合并两个 csv 文件
    - 两个文件内容行交替放入新文件
  - ProcessCsvByString —— 处理csv 文件中每个单元格内容
    - 处理方式: 将每个单元格内容视为 String，进行字符串编辑替换等